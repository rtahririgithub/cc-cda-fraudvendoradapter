package com.telus.subsfraudmgmt.api.modelmapper.tfm.bureau;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.fico.afm.model.application.BureauReportType;
import com.fico.afm.model.application.BureauReports;
import com.fico.afm.model.application.EfuBureauReport;
import com.fico.afm.model.application.cdac.efu.AddressEfu;
import com.fico.afm.model.application.cdac.efu.AddressList;
import com.fico.afm.model.application.cdac.efu.EmploymentEfu;
import com.fico.afm.model.application.cdac.efu.EmploymentList;
import com.fico.afm.model.application.cdac.efu.HeaderEfu;
import com.fico.afm.model.application.cdac.efu.HeaderList;
import com.fico.afm.model.application.cdac.efu.IdentificationEfu;
import com.fico.afm.model.application.cdac.efu.IdentificationList;
import com.fico.afm.model.application.cdac.efu.InquiryEfu;
import com.fico.afm.model.application.cdac.efu.InquiryList;
import com.fico.afm.model.application.cdac.efu.NameOrAliasEfu;
import com.fico.afm.model.application.cdac.efu.NameOrAliasList;
import com.fico.afm.model.application.cdac.efu.ParsedResponse;
import com.fico.afm.model.application.cdac.efu.ParsedResponseList;
import com.fico.afm.model.application.cdac.efu.ScoringEfu;
import com.fico.afm.model.application.cdac.efu.ScoringList;
import com.telus.subsfraudmgmt.api.model.Customer;
import com.telus.subsfraudmgmt.api.model.FraudCheckPerform;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccount;
import com.telus.subsfraudmgmt.api.modelmapper.common.MapperCommon;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.bureau.TfmBureauReports.TfmBureauReport;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.bureau.TfmBureauReports.TfmParsedResponse;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;

/**
 * map TfmBureauReports to AFM Equifax bureauReport equivalents.
 * @author Harry xu
 *
 */
@Mapper(componentModel="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@MapperConfig(unmappedTargetPolicy=ReportingPolicy.WARN)
public interface TfmBureauReportsToAfmEfuMapper extends MapperCommon { 
	public static final Log LOG = CustomizedLogFactory.getLog(TfmBureauReportsToAfmEfuMapper.class);
     
	public static final String FFF_PARSE_WARNING = "FFFParseWarning";
	public static final String FFF_PARSE_ERROR = "FFFParseError";
	TfmBureauReportsToAfmEfuMapper INSTANCE = Mappers.getMapper( TfmBureauReportsToAfmEfuMapper.class );
	
	
	default BureauReports mapReports(TfmBureauReports tfmBureauReports, FraudCheckPerform fraudCheckPerform) {
		if (tfmBureauReports == null) {
			return null;
		}
				
		BureauReports bureauReports = new BureauReports();
		for (TfmBureauReport tfmBureauReport: tfmBureauReports.getTfmBureauReportList() ) {
			EfuBureauReport efuBureauReport=  mapOneReport(tfmBureauReport, extractAccountCreditBureauResultCreationDate(fraudCheckPerform));
			if (efuBureauReport !=null) {
				if (fraudCheckPerform !=null) {
					efuBureauReport.setIdentificationNumber(fraudCheckPerform.getExternalApplicationId());
				}
				efuBureauReport.setReport(""); //as in BureauReport tab instruction
				efuBureauReport.setType(BureauReportType.EQUIFAX);
				 
				bureauReports.getBureauReport().add(efuBureauReport);
			}
		}
	    return bureauReports; 
	}


	
	default EfuBureauReport  mapOneReport(TfmBureauReport tfmEfuBureauReport, OffsetDateTime creditBureauResultCreationDate) {
		if (tfmEfuBureauReport ==null || tfmEfuBureauReport.getTfmParsedResponseList()==null || tfmEfuBureauReport.getTfmParsedResponseList().isEmpty()) {
			return null;
		}
		EfuBureauReport efuBureauReport = new EfuBureauReport();
		ParsedResponseList parsedResponseList = efuBureauReport.getBureauReport();
		if (parsedResponseList ==null) {
			parsedResponseList = new ParsedResponseList();
		}
		//parsedResponseList.setReportDate(getTodayAsMMddYYYY()); use account.getCreditBureauResult().getCreationDate() and use yyyy-MM-dd'T'HH:mm:ss.SSSZ
		parsedResponseList.setReportDate(offsetDateTimeToString(creditBureauResultCreationDate));
		parsedResponseList.setVersion("5"); //from Equifax mapping doc
		efuBureauReport.setBureauReport(parsedResponseList);

		TfmParsedResponse tfmParsedResponse = tfmEfuBureauReport.getTfmParsedResponseList().get(0);
		if (tfmParsedResponse.hasTopError()) {
			 
			LOG.info("bureau report top level error message to convert to FFFParseError: '" + tfmParsedResponse.getFirstErrorMsg() +"'"); 			
			//if error.erroCd is not empty , TFM to set ParseError= FFFParseError tfmParsedResponse.getFirstErrorMsg()
			efuBureauReport.getBureauReport().setParseError(FFF_PARSE_ERROR);
			return efuBureauReport;
		}else {
			 
			updateParsedResponse(efuBureauReport, tfmParsedResponse);		 
		}
	 
		return efuBureauReport;
	}
	
	default void updateParsedResponse(EfuBureauReport efuBureauReport, TfmParsedResponse tfmParsedResponse) {
		ParsedResponse parsedResponse = new ParsedResponse();

		//if the property error.errorCode or warning.warningCode in any of the json segment is not empty, set the ParseWarning=FFFParseWarning
		if (tfmParsedResponse.getFirstSegmentParseWarning()!=null) {
			parsedResponse.setParseWarning(FFF_PARSE_WARNING);
		}

		if (parsedResponse.getIdentificationList()==null) {
			parsedResponse.setIdentificationList(new IdentificationList());
		}
		if (parsedResponse.getAddressList()==null) {
			parsedResponse.setAddressList(new AddressList());
		}		
		if (parsedResponse.getEmploymentList()==null) {
			parsedResponse.setEmploymentList(new EmploymentList());
		}
		if (parsedResponse.getHeaderList()==null) {
			parsedResponse.setHeaderList(new HeaderList());
		}		
		if (parsedResponse.getInquiryList()==null) {
			parsedResponse.setInquiryList(new InquiryList());
		}

		if (parsedResponse.getNameOrAliasList()==null) {
			parsedResponse.setNameOrAliasList(new NameOrAliasList());
		}
		if (parsedResponse.getScoringList()==null) {
			parsedResponse.setScoringList(new ScoringList());
		}
		//Address section

		updateAfmAddress(tfmParsedResponse, tfmParsedResponse.getFirstSegmentDataBySegmentName("currentAddress"), parsedResponse);
		updateAfmAddress(tfmParsedResponse, tfmParsedResponse.getFirstSegmentDataBySegmentName("formerAddress1"), parsedResponse);
		updateAfmAddress(tfmParsedResponse, tfmParsedResponse.getFirstSegmentDataBySegmentName("formerAddress2"), parsedResponse);


		updateAfmEmployment(tfmParsedResponse, tfmParsedResponse.getFirstSegmentDataBySegmentName("currentEmployment"), parsedResponse);
		updateAfmEmployment(tfmParsedResponse, tfmParsedResponse.getFirstSegmentDataBySegmentName("formerEmployment1"), parsedResponse);
		updateAfmEmployment(tfmParsedResponse, tfmParsedResponse.getFirstSegmentDataBySegmentName("formerEmployment2"), parsedResponse);


		updateAfmHeader(tfmParsedResponse, tfmParsedResponse.getFirstSegmentDataBySegmentName("header"), parsedResponse);

		updateAfmInqueryFromLocateOrSepcialServcieSegment(tfmParsedResponse, parsedResponse);
		List<Map<String, String>> inquiriesList = tfmParsedResponse.getSegmentDataList("inquiries");
		if (inquiriesList !=null && !inquiriesList.isEmpty()) {
			for (Map<String, String> inquiriesDataKVs: inquiriesList) {
				updateAfmInquery(tfmParsedResponse, inquiriesDataKVs, parsedResponse);
			}
		}


		List<Map<String, String>> alsoKnownAsList = tfmParsedResponse.getSegmentDataList("alsoKnownAs");
		if (alsoKnownAsList !=null && !alsoKnownAsList.isEmpty()) {
			for (Map<String, String> alsoKnownAsKVs: alsoKnownAsList) {
				//one by one
				updateAfmName(tfmParsedResponse, alsoKnownAsKVs, parsedResponse);
			}
		}
		updateAfmNameFromFomerNameSegment(tfmParsedResponse, tfmParsedResponse.getFirstSegmentDataBySegmentName("formerName"), parsedResponse) ;
		updateAfmNameFromHeaderSegment(tfmParsedResponse, tfmParsedResponse.getFirstSegmentDataBySegmentName("header"), parsedResponse);

		updateAfmScoring(tfmParsedResponse, tfmParsedResponse.getFirstSegmentDataBySegmentName("bureauScore"), parsedResponse);





		efuBureauReport.getBureauReport().getParsedResponse().add(parsedResponse);
	}

	
	
	default void updateAfmAddress(TfmParsedResponse tfmParsedResponse, Map<String, String> segmentDataProperies, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null || segmentDataProperies ==null || segmentDataProperies.isEmpty()) {
			return;
		}
		
		AddressEfu address = new AddressEfu();
		address.setSourceSegment(segmentDataProperies.get("recordCode"));
		address.setStreetNumber(segmentDataProperies.get("streetNumber"));
		address.setStreetName(segmentDataProperies.get("streetName"));
		address.setCity(segmentDataProperies.get("city"));
		address.setState(segmentDataProperies.get("province"));
		address.setZipCode(segmentDataProperies.get("postalCode"));
		address.setResidenceSince(segmentDataProperies.get("residenceSince"));
		address.setSourceIndicator(segmentDataProperies.get("indicatorCode"));
		if (address !=null) {
			parsedResponse.getAddressList().getAddress().add(address);
		}
	}

	
	default void updateAfmEmployment(TfmParsedResponse tfmParsedResponse, Map<String, String> segmentDataProperies, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null || segmentDataProperies ==null || segmentDataProperies.isEmpty()) {
			return;
		}
		
		EmploymentEfu employment = new EmploymentEfu();
		employment.setSourceSegment(segmentDataProperies.get("recordCode"));
		employment.setEmployer(segmentDataProperies.get("employer"));
		employment.setDateVerifiedOrReported(segmentDataProperies.get("dateVerified"));
		employment.setOccupation(segmentDataProperies.get("occupation"));
		employment.setIndirectVerificationCode(segmentDataProperies.get("verificationStatu"));
		employment.setHireDate(segmentDataProperies.get("dateEmployed"));
		employment.setDateLeftEmployment(segmentDataProperies.get("dateLeft"));
		employment.setMonthlySalary(segmentDataProperies.get("monthlySalary"));
		employment.setCity(segmentDataProperies.get("cityOfEmployment"));
		employment.setState(segmentDataProperies.get("provinceOfEmployment"));
		 
		 
		if (employment !=null) {
			parsedResponse.getEmploymentList().getEmployment().add(employment);
		}
		
	}

	default void updateAfmHeader(TfmParsedResponse tfmParsedResponse, Map<String, String> segmentDataProperies, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null || segmentDataProperies ==null || segmentDataProperies.isEmpty()) {
			return;
		}
		
		HeaderEfu header = new HeaderEfu();
		header.setSourceSegment(segmentDataProperies.get("reportType"));
	 
		header.setDateOfThisReport(segmentDataProperies.get("dateOfThisReport"));
		String bureauArfVersion = segmentDataProperies.get("outputFormatCode");
		if (bureauArfVersion == null) {
			bureauArfVersion = this.pullValue(tfmParsedResponse, "codedErrorRecord", "outputFormatCode");
		}
		header.setBureauArfVersion(bureauArfVersion);
		 
		header.setUserReference(segmentDataProperies.get("customerReferenceNumber"));
		header.setUserReference2(this.pullValue(tfmParsedResponse, "codedErrorRecord", "customerReferenceNumber"));
		
		String subscriberNumber = segmentDataProperies.get("equifaxMemberNumber");
		if (subscriberNumber ==null) {
			subscriberNumber = this.pullValue(tfmParsedResponse, "codedErrorRecord", "memberNumber");
		}
		header.setSubscriberNumber(subscriberNumber);
		header.setSecurityCode(segmentDataProperies.get("securityCode"));
	 
		header.setConsumerReferralCode(segmentDataProperies.get("consumerReferralCode"));
		header.setMultipleFileIndicator(segmentDataProperies.get("multipleFileIndicator"));
		
		String ecoaInquiryType = segmentDataProperies.get("ecoaInquiryType");
		if (ecoaInquiryType ==null) {
			ecoaInquiryType = this.pullValue(tfmParsedResponse, "codedErrorRecord", "ecoaInquiryType");
		}
		header.setEcoaInquiryType(ecoaInquiryType);
		header.setHitOrNoHitDesignatorCode(segmentDataProperies.get("hitNoHitDesignatorCode"));
		header.setFileSinceDate(segmentDataProperies.get("fileSinceDate"));
		header.setDateOfLastActivity(segmentDataProperies.get("dateOfLastActivity"));
		header.setSegmentCounters(segmentDataProperies.get("segmentCounters"));
		
		header.setNumberOfFormatErrors(this.pullValue(tfmParsedResponse, "codedErrorRecord", "numberOfFormatErrors"));
		header.setValidityErrorCode1(this.pullValue(tfmParsedResponse, "codedErrorRecord", "formatErrorCode1"));
		header.setValidityErrorCode2(this.pullValue(tfmParsedResponse, "codedErrorRecord", "formatErrorCode2"));
		header.setValidityErrorCode3(this.pullValue(tfmParsedResponse, "codedErrorRecord", "formatErrorCode3"));
		header.setValidityErrorCode4(this.pullValue(tfmParsedResponse, "codedErrorRecord", "formatErrorCode4"));
		header.setValidityErrorCode5(this.pullValue(tfmParsedResponse, "codedErrorRecord", "formatErrorCode5"));
		header.setValidityErrorCode6(this.pullValue(tfmParsedResponse, "codedErrorRecord", "formatErrorCode6"));
		header.setValidityErrorCode7(this.pullValue(tfmParsedResponse, "codedErrorRecord", "formatErrorCode7"));
		header.setValidityErrorCode8(this.pullValue(tfmParsedResponse, "codedErrorRecord", "formatErrorCode8"));
		header.setValidityErrorCode9(this.pullValue(tfmParsedResponse, "codedErrorRecord", "formatErrorCode9"));
		
		header.setNumberOfFormatErrors(this.pullValue(tfmParsedResponse, "codedErrorRecord", "numberOfValidityErrors"));
		header.setValidityErrorCode1(this.pullValue(tfmParsedResponse, "codedErrorRecord", "validityErrorCode1"));
		header.setValidityErrorCode2(this.pullValue(tfmParsedResponse, "codedErrorRecord", "validityErrorCode2"));
		header.setValidityErrorCode3(this.pullValue(tfmParsedResponse, "codedErrorRecord", "validityErrorCode3"));
		header.setValidityErrorCode4(this.pullValue(tfmParsedResponse, "codedErrorRecord", "validityErrorCode4"));
		header.setValidityErrorCode5(this.pullValue(tfmParsedResponse, "codedErrorRecord", "validityErrorCode5"));
		header.setValidityErrorCode6(this.pullValue(tfmParsedResponse, "codedErrorRecord", "validityErrorCode6"));
		header.setValidityErrorCode7(this.pullValue(tfmParsedResponse, "codedErrorRecord", "validityErrorCode7"));
		header.setValidityErrorCode8(this.pullValue(tfmParsedResponse, "codedErrorRecord", "validityErrorCode8"));
		header.setValidityErrorCode9(this.pullValue(tfmParsedResponse, "codedErrorRecord", "validityErrorCode9"));
		
		header.setNumberOfProcessingErrors(this.pullValue(tfmParsedResponse, "codedErrorRecord", "numberOfProcessingErrors"));
		header.setProcessingErrorCode1(this.pullValue(tfmParsedResponse, "codedErrorRecord", "processingErrorCode1"));
		header.setProcessingErrorCode2(this.pullValue(tfmParsedResponse, "codedErrorRecord", "processingErrorCode2"));
		header.setProcessingErrorCode3(this.pullValue(tfmParsedResponse, "codedErrorRecord", "processingErrorCode3"));
		header.setProcessingErrorCode4(this.pullValue(tfmParsedResponse, "codedErrorRecord", "processingErrorCode4"));
		header.setProcessingErrorCode5(this.pullValue(tfmParsedResponse, "codedErrorRecord", "processingErrorCode5"));
		header.setProcessingErrorCode6(this.pullValue(tfmParsedResponse, "codedErrorRecord", "processingErrorCode6"));
		header.setProcessingErrorCode7(this.pullValue(tfmParsedResponse, "codedErrorRecord", "processingErrorCode7"));
		header.setProcessingErrorCode8(this.pullValue(tfmParsedResponse, "codedErrorRecord", "processingErrorCode8"));
		header.setProcessingErrorCode9(this.pullValue(tfmParsedResponse, "codedErrorRecord", "processingErrorCode9"));
		

		header.setSafescanCode(segmentDataProperies.get("safescanByte1"));


		parsedResponse.getHeaderList().setHeader(header);

		
		IdentificationEfu identificationEfu = new IdentificationEfu();
		identificationEfu.setSourceSegment(segmentDataProperies.get("reportType"));
		identificationEfu.setSubjectSsn(segmentDataProperies.get("subjectSin"));
		identificationEfu.setDeathDate(this.pullValue(tfmParsedResponse, "death", "dateOfSubjectDeath"));
		identificationEfu.setSubjectDateOfBirth(segmentDataProperies.get("subjectDateOfBirth"));
		
		parsedResponse.getIdentificationList().getIdentification().add(identificationEfu);
	}
 
	default void updateAfmInqueryFromLocateOrSepcialServcieSegment(TfmParsedResponse tfmParsedResponse,ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null) {
			return;
		}
		
		Map<String, String> locateOrSepcialServiceSegmentProperties = tfmParsedResponse.getFirstSegmentDataBySegmentName("locateOrSpecialService");
		if (locateOrSepcialServiceSegmentProperties!=null && !locateOrSepcialServiceSegmentProperties.isEmpty()) {
			InquiryEfu inquiry = new InquiryEfu();
			inquiry.setSourceSegment(locateOrSepcialServiceSegmentProperties.get("recordCode"));
			inquiry.setSubscriberNumber(locateOrSepcialServiceSegmentProperties.get("memberNumber"));
			inquiry.setSubscriberName(locateOrSepcialServiceSegmentProperties.get("nameOfMember"));
			inquiry.setInquiryDate(locateOrSepcialServiceSegmentProperties.get("dateOfInquiry"));
			inquiry.setType(locateOrSepcialServiceSegmentProperties.get("typeCode"));
			parsedResponse.getInquiryList().getInquiry().add(inquiry);
		}
	 
		 
	}
	default void updateAfmInquery(TfmParsedResponse tfmParsedResponse, Map<String, String> segmentDataProperies, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null || segmentDataProperies ==null || segmentDataProperies.isEmpty()) {
			return;
		}
		
		
		InquiryEfu inquiry = new InquiryEfu();
		inquiry.setSourceSegment(segmentDataProperies.get("recordCode"));
		inquiry.setSubscriberNumber(segmentDataProperies.get("memberNumber"));
		inquiry.setSubscriberName(segmentDataProperies.get("nameOfMember"));
		inquiry.setInquiryDate(segmentDataProperies.get("dateOfInquiry"));
	    //no type, leave it null and let not sending to AFM
		parsedResponse.getInquiryList().getInquiry().add(inquiry);
		 
	}
	
	default void updateAfmName(TfmParsedResponse tfmParsedResponse, Map<String, String> segmentDataProperies, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null || segmentDataProperies ==null || segmentDataProperies.isEmpty()) {
			return;
		}
		
		NameOrAliasEfu name = new NameOrAliasEfu();
		name.setSourceSegment(segmentDataProperies.get("recordCode"));
		name.setLastName(segmentDataProperies.get("lastName"));
		name.setFirstName(segmentDataProperies.get("firstName"));
		name.setMiddleName(segmentDataProperies.get("middleName"));
		name.setSuffix(segmentDataProperies.get("suffix"));
		name.setSpouseName(segmentDataProperies.get("spouseName"));
		
		parsedResponse.getNameOrAliasList().getNameOrAlias().add(name);
		 
	}
	
	default void updateAfmNameFromFomerNameSegment(TfmParsedResponse tfmParsedResponse, Map<String, String> segmentDataProperies, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null || segmentDataProperies ==null || segmentDataProperies.isEmpty()) {
			return;
		}
		
		NameOrAliasEfu name = new NameOrAliasEfu();
		name.setSourceSegment(segmentDataProperies.get("recordCode"));
		name.setLastName(segmentDataProperies.get("lastName"));
		name.setFirstName(segmentDataProperies.get("firstName"));
		name.setMiddleName(segmentDataProperies.get("middleName"));
		name.setSuffix(segmentDataProperies.get("suffix"));
		name.setSpouseName(segmentDataProperies.get("spouseName"));
		
		parsedResponse.getNameOrAliasList().getNameOrAlias().add(name);
		 
	}
	
	default void updateAfmNameFromHeaderSegment(TfmParsedResponse tfmParsedResponse, Map<String, String> segmentDataProperies, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null || segmentDataProperies ==null || segmentDataProperies.isEmpty()) {
			return;
		}
		
		NameOrAliasEfu name = new NameOrAliasEfu();
		name.setSourceSegment(segmentDataProperies.get("reportType"));
		name.setLastName(segmentDataProperies.get("subjectLastName"));
		name.setFirstName(segmentDataProperies.get("subjectFirstName"));
		name.setMiddleName(segmentDataProperies.get("subjectMiddleName"));
		name.setSuffix(segmentDataProperies.get("subjectSuffix"));
		name.setSpouseName(segmentDataProperies.get("spouseFirstName"));
		
		parsedResponse.getNameOrAliasList().getNameOrAlias().add(name);
		 
	}
	
	default void updateAfmScoring(TfmParsedResponse tfmParsedResponse, Map<String, String> segmentDataProperies, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null || segmentDataProperies ==null || segmentDataProperies.isEmpty()) {
			return;
		}
		
		ScoringEfu scoring = new ScoringEfu();
		
		scoring.setSourceSegment(segmentDataProperies.get("recordCode"));
		scoring.setScore(segmentDataProperies.get("productScore"));
		scoring.setFirstReasonCode(segmentDataProperies.get("firstReasonCode"));
		scoring.setSecondReasonCode(segmentDataProperies.get("secondReasonCode"));
		scoring.setThirdReasonCode(segmentDataProperies.get("thirdReasonCode"));
		scoring.setFourthReasonCode(segmentDataProperies.get("fourthReasonCode"));
		scoring.setRejectMessageCode(segmentDataProperies.get("rejectMessageCode"));
		 
		parsedResponse.getScoringList().getScoring().add(scoring);
		 
	}
	
	
	default String pullValue(TfmParsedResponse tfmParsedResponse, String segmentName, String attributeName) {
		if (tfmParsedResponse==null) {
			return null;
		}
		Map<String, String> segmentDataProperies = tfmParsedResponse.getFirstSegmentDataBySegmentName(segmentName);
		if (segmentDataProperies ==null) {
			return null;
		}
		return segmentDataProperies.get(attributeName);
	}
	
	
}
