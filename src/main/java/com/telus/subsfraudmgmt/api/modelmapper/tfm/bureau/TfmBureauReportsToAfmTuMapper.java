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
import com.fico.afm.model.application.TuBureauReport;
import com.fico.afm.model.application.cdac.tu.ParsedResponseList;
import com.fico.afm.model.application.cdac.tu.SummaryInformationList;
import com.fico.afm.model.application.cdac.tu.SummaryInformationTu;
import com.fico.afm.model.application.cdac.tu.AddressList;
import com.fico.afm.model.application.cdac.tu.AddressTu;
import com.fico.afm.model.application.cdac.tu.EmploymentList;
import com.fico.afm.model.application.cdac.tu.EmploymentTu;
import com.fico.afm.model.application.cdac.tu.EndSegmentList;
import com.fico.afm.model.application.cdac.tu.EndSegmentTu;
import com.fico.afm.model.application.cdac.tu.FraudList;
import com.fico.afm.model.application.cdac.tu.FraudTu;
import com.fico.afm.model.application.cdac.tu.HeaderList;
import com.fico.afm.model.application.cdac.tu.HeaderTu;
import com.fico.afm.model.application.cdac.tu.IdentificationList;
import com.fico.afm.model.application.cdac.tu.IdentificationTu;
import com.fico.afm.model.application.cdac.tu.InquiryList;
import com.fico.afm.model.application.cdac.tu.InquiryTu;
import com.fico.afm.model.application.cdac.tu.MessageText;
import com.fico.afm.model.application.cdac.tu.MessageTextList;
import com.fico.afm.model.application.cdac.tu.NameOrAliasList;
import com.fico.afm.model.application.cdac.tu.NameOrAliasTu;
import com.fico.afm.model.application.cdac.tu.ParsedResponse;
import com.telus.subsfraudmgmt.api.model.FraudCheckPerform;
import com.telus.subsfraudmgmt.api.modelmapper.common.MapperCommon;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.bureau.TfmBureauReports.TfmBureauReport;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.bureau.TfmBureauReports.TfmParsedResponse;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;

/**
 * map TfmBureauReports to AFM Trans Union bureauReport equivalents.
 * @author Harry xu
 *
 */
@Mapper(componentModel="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@MapperConfig(unmappedTargetPolicy=ReportingPolicy.WARN)
public interface TfmBureauReportsToAfmTuMapper extends MapperCommon { 
	public static final Log LOG = CustomizedLogFactory.getLog(TfmBureauReportsToAfmTuMapper.class);
     
	public static final String FFF_PARSE_WARNING = "FFFParseWarning";
	public static final String FFF_PARSE_ERROR = "FFFParseError";
	TfmBureauReportsToAfmTuMapper INSTANCE = Mappers.getMapper( TfmBureauReportsToAfmTuMapper.class );
	
	
	default BureauReports mapReports(TfmBureauReports tfmBureauReports, FraudCheckPerform fraudCheckPerform) {
		if (tfmBureauReports == null) {
			return null;
		}
		BureauReports bureauReports = new BureauReports();
		for (TfmBureauReport tfmBureauReport: tfmBureauReports.getTfmBureauReportList() ) {
			TuBureauReport tuBureauReport=  mapOneReport(tfmBureauReport, extractAccountCreditBureauResultCreationDate(fraudCheckPerform));
			if (tuBureauReport !=null) {
				if (fraudCheckPerform !=null) {
					tuBureauReport.setIdentificationNumber(fraudCheckPerform.getExternalApplicationId());
				}
				tuBureauReport.setReport(""); //as in BureauReport tab instruction
				tuBureauReport.setType(BureauReportType.TRANS_UNION);
				 
				bureauReports.getBureauReport().add(tuBureauReport);
			}
		}
	    return bureauReports; 
	}
	
	default TuBureauReport  mapOneReport(TfmBureauReport tfmBureauReport, OffsetDateTime creditBureauResultCreationDate) {
		if (tfmBureauReport ==null || tfmBureauReport.getTfmParsedResponseList()==null || tfmBureauReport.getTfmParsedResponseList().isEmpty()) {
			return null;
		}
		
		TuBureauReport tuBureauReport = new TuBureauReport();
		
		ParsedResponseList parsedResponseList = tuBureauReport.getBureauReport();
		if (parsedResponseList ==null) {
			parsedResponseList = new ParsedResponseList();
		}
		//parsedResponseList.setReportDate(getTodayAsMMddYYYY()); use account.getCreditBureauResult().getCreationDate() and use yyyy-MM-dd'T'HH:mm:ss.SSSZ
		parsedResponseList.setReportDate(offsetDateTimeToString(creditBureauResultCreationDate));
		parsedResponseList.setVersion("4"); //from TU mapping doc
		tuBureauReport.setBureauReport(parsedResponseList);

		
		TfmParsedResponse tfmParsedResponse = tfmBureauReport.getTfmParsedResponseList().get(0);
		if (tfmParsedResponse.hasTopError()) {
			 
			LOG.info("bureau report top level error message to convert to FFFParseError: '" + tfmParsedResponse.getFirstErrorMsg() +"'"); 		
			//if error.erroCd is not empty , TFM to set ParseError= FFFParseError tfmParsedResponse.getFirstErrorMsg()
			tuBureauReport.getBureauReport().setParseError(FFF_PARSE_ERROR);
			return tuBureauReport;
		}else {	
			updateParsedResponse(tuBureauReport, tfmParsedResponse);		 
		}

		return tuBureauReport;
	}
	
	default void updateParsedResponse(TuBureauReport tuBureauReport, TfmParsedResponse tfmParsedResponse) {
		ParsedResponse parsedResponse = new ParsedResponse();

		//if the property error.errorCode or warning.warningCode in any of the json segment is not empty, set the ParseWarning=FFFParseWarning
		if (tfmParsedResponse.getFirstSegmentParseWarning()!=null) {
			parsedResponse.setParseWarning(FFF_PARSE_WARNING);
		}	

		if (parsedResponse.getAddressList()==null) {
			parsedResponse.setAddressList(new AddressList());
		}

		if (parsedResponse.getEmploymentList()==null) {
			parsedResponse.setEmploymentList(new EmploymentList());
		}
		if (parsedResponse.getEndSegmentList()==null) {
			parsedResponse.setEndSegmentList(new EndSegmentList());
		}
		if (parsedResponse.getFraudList()==null) {
			parsedResponse.setFraudList(new FraudList());
		}
		if (parsedResponse.getInquiryList()==null) {
			parsedResponse.setInquiryList(new InquiryList());
		}
		if (parsedResponse.getNameOrAliasList()==null) {
			parsedResponse.setNameOrAliasList(new NameOrAliasList());
		}

		if (parsedResponse.getSummaryInformationList()==null) {
			parsedResponse.setSummaryInformationList(new SummaryInformationList());
		}

		//Address section
		List<Map<String, String>> addressList = tfmParsedResponse.getSegmentDataList("address");
		if (addressList !=null && !addressList.isEmpty()) {
			for (Map<String, String> addressDataKVs: addressList) {
				updateAfmTuAddress(tfmParsedResponse, addressDataKVs, parsedResponse);
			}
		}

		List<Map<String, String>> employmentList = tfmParsedResponse.getSegmentDataList("employment");
		if (employmentList !=null && !employmentList.isEmpty()) {
			for (Map<String, String> employeeKVs: employmentList) {
				this.updateAfmEmployment(tfmParsedResponse, employeeKVs, parsedResponse);
			}
		}

		List<Map<String, String>> endsSegmentList = tfmParsedResponse.getSegmentDataList("endsSegment");
		if (endsSegmentList !=null && !endsSegmentList.isEmpty()) {
			for (Map<String, String> endSegmenteKVs: endsSegmentList) {
				this.updateAfmEndSegment(tfmParsedResponse, endSegmenteKVs, parsedResponse);
			}
		}

		this.updateAfmFraudMessageTextList(tfmParsedResponse, parsedResponse);


		tuBureauReport.getBureauReport().getParsedResponse().add(parsedResponse);

		this.updateAfmHeader(tfmParsedResponse, parsedResponse);

		this.updateAfmIdentification(tfmParsedResponse, parsedResponse);

		List<Map<String, String>> inquiriesList = tfmParsedResponse.getSegmentDataList("inquiry");
		if (inquiriesList !=null && !inquiriesList.isEmpty()) {
			for (Map<String, String> inquiriesDataKVs: inquiriesList) {
				updateAfmInquery(tfmParsedResponse, inquiriesDataKVs, parsedResponse);
			}
		}

		List<Map<String, String>> nameList = tfmParsedResponse.getSegmentDataList("name");
		if (nameList !=null && !nameList.isEmpty()) {
			for (Map<String, String> nameKVs: nameList) {
				//one by one
				updateAfmName(tfmParsedResponse, nameKVs, parsedResponse);
			}
		}

		List<Map<String, String>> creditSummaryDetailList = tfmParsedResponse.getSegmentDataList("creditSummaryDetail");
		if (creditSummaryDetailList !=null && !creditSummaryDetailList.isEmpty()) {
			for (Map<String, String> creditSummaryDetailKVs: creditSummaryDetailList) {
				this.updateAfmSummaryInformation(tfmParsedResponse, creditSummaryDetailKVs, parsedResponse);
			}
		}
		
		 

	}
	
	default void updateAfmTuAddress(TfmParsedResponse tfmParsedResponse, Map<String, String> segmentDataProperies, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null || segmentDataProperies ==null || segmentDataProperies.isEmpty()) {
			return;
		}
		
		AddressTu address = new AddressTu();
		address.setSourceSegment(segmentDataProperies.get("segmentType"));
		address.setDateReported(segmentDataProperies.get("dateReported"));
		address.setAddressQualifier(segmentDataProperies.get("addressQualifier"));
		address.setCity(segmentDataProperies.get("city"));
		address.setState(segmentDataProperies.get("province"));
		address.setZipCode(segmentDataProperies.get("postalCode")); 
		
		address.setAddressText(segmentDataProperies.get("unparsedStreetAddress"));
		address.setSourceIndicator(segmentDataProperies.get("sourceIndicator"));
		String sourceIndicator = segmentDataProperies.get("sourceIndicator");
		if (sourceIndicator==null || sourceIndicator.isEmpty()) {
			sourceIndicator = this.pullValue(tfmParsedResponse, "phoneNumber", "sourceIndicator");
		}
		address.setSourceIndicator(sourceIndicator); 
		address.setPhoneQualifier(this.pullValue(tfmParsedResponse, "phoneNumber", "phoneQualifier"));
		address.setPhoneType(this.pullValue(tfmParsedResponse, "phoneNumber", "phoneType"));

		address.setAreaCode(this.pullValue(tfmParsedResponse, "phoneNumber", "areaCode"));
		address.setPhoneNumber(this.pullValue(tfmParsedResponse, "phoneNumber", "telephoneNumber"));

		
		if (address !=null) {
			parsedResponse.getAddressList().getAddress().add(address);
		}
	}
	
	default void updateAfmEmployment(TfmParsedResponse tfmParsedResponse, Map<String, String> segmentDataProperies, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null || segmentDataProperies ==null || segmentDataProperies.isEmpty()) {
			return;
		}
		
		EmploymentTu employment = new EmploymentTu();
		employment.setSourceSegment(segmentDataProperies.get("segmentType"));
		employment.setEmployer(segmentDataProperies.get("employerName"));
		employment.setDateVerifiedOrReported(segmentDataProperies.get("dateVerifiedOrReported"));
		employment.setOccupation(segmentDataProperies.get("occupation"));
	 
		employment.setDateHired(segmentDataProperies.get("dateHired"));
		employment.setDateSeparated(segmentDataProperies.get("dateSeparated"));
		employment.setSourceIndicator(segmentDataProperies.get("sourceIndicator"));
		employment.setIncome(segmentDataProperies.get("income"));
		employment.setPayBasis(segmentDataProperies.get("payBasis"));	
		
		employment.setAddressSourceIndicator(this.pullValue(tfmParsedResponse, "address", "sourceIndicator"));
		employment.setAddressQualifier(this.pullValue(tfmParsedResponse, "address", "addressQualifier"));
		employment.setCity(this.pullValue(tfmParsedResponse, "address", "city")); 
		employment.setState(this.pullValue(tfmParsedResponse, "address", "province")); 
		employment.setZipCode(this.pullValue(tfmParsedResponse, "address", "postalCode")); 
		
		employment.setAddressDateReported(this.pullValue(tfmParsedResponse, "address", "dateReported")); 
		
		employment.setPhoneSourceIndicator(this.pullValue(tfmParsedResponse, "phoneNumber", "sourceIndicator")); 
		employment.setPhoneQualifier(this.pullValue(tfmParsedResponse, "phoneNumber", "phoneQualifier")); 
		employment.setPhoneType(this.pullValue(tfmParsedResponse, "phoneNumber", "phoneType"));

		employment.setAreaCode(this.pullValue(tfmParsedResponse, "phoneNumber", "areaCode"));
		employment.setPhoneNumber(this.pullValue(tfmParsedResponse, "phoneNumber", "telephoneNumber"));
		
		 
		if (employment !=null) {
			parsedResponse.getEmploymentList().getEmployment().add(employment);
		}
		
	}
	
	default void updateAfmEndSegment(TfmParsedResponse tfmParsedResponse, Map<String, String> segmentDataProperies, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null || segmentDataProperies ==null || segmentDataProperies.isEmpty()) {
			return;
		}
		
		EndSegmentTu endSegment = new EndSegmentTu();
		endSegment.setSourceSegment(segmentDataProperies.get("segmentType"));
		endSegment.setTotalReportSegments(segmentDataProperies.get("totalNumberOfSegments"));
		
		if (endSegment !=null) {
			parsedResponse.getEndSegmentList().setEndSegment(endSegment);
		}
		
	}
	
	default void updateAfmFraudMessageTextList(TfmParsedResponse tfmParsedResponse, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null) {
			return;
		}
		List<Map<String, String>> iDMismatchAlertList = tfmParsedResponse.getSegmentDataList("iDMismatchAlert");
		if (iDMismatchAlertList !=null && !iDMismatchAlertList.isEmpty()) {
			
			for (Map<String, String> oneSegment: iDMismatchAlertList) {
				//create one for fraud for each segment element
				FraudTu fraud = new FraudTu();
				fraud.setSourceSegment(oneSegment.get("segmentType"));
				parsedResponse.getFraudList().getFraud().add(fraud);
				
				MessageTextList messageTextList = new MessageTextList();
				fraud.setMessageTextList(messageTextList);
				
				MessageText messageText = new MessageText();
				messageText.setMessageCode(this.safePull(oneSegment, "messageCode"));
				messageText.setValue(this.safePull(oneSegment, "messageText"));
				
				fraud.setMessageCode(messageText.getMessageCode());
				
				fraud.getMessageTextList().getMessageText().add(messageText);
			}
			
		}
		
		List<Map<String, String>> messageTextSegmentList = tfmParsedResponse.getSegmentDataList("messageTextSegment");
		if (messageTextSegmentList !=null && !messageTextSegmentList.isEmpty()) {
			
			for (Map<String, String> oneSegment: messageTextSegmentList) {
				//only one item in sample data, but treat it as array
				FraudTu fraud = new FraudTu();
				fraud.setSourceSegment(oneSegment.get("segmentType"));
				parsedResponse.getFraudList().getFraud().add(fraud);
				
				MessageTextList messageTextList = new MessageTextList();
				fraud.setMessageTextList(messageTextList);
				
				MessageText messageText = new MessageText();
				messageText.setMessageCode(this.safePull(oneSegment, "messageCode"));
				messageText.setValue(this.safePull(oneSegment, "messageText"));
				
				fraud.setMessageCode(messageText.getMessageCode());
				
				fraud.getMessageTextList().getMessageText().add(messageText);
			}
			
		}
		
		List<Map<String, String>> consumerStatementList = tfmParsedResponse.getSegmentDataList("consumerStatement");
		if (consumerStatementList !=null && !consumerStatementList.isEmpty()) {
			//have 3 elements, but means 1, just information is too long and breaks up to 3.
			Map<String, String> oneSegment = consumerStatementList.get(0);

			FraudTu fraud = new FraudTu();
			fraud.setSourceSegment(oneSegment.get("segmentType"));
			parsedResponse.getFraudList().getFraud().add(fraud);
			
			MessageTextList messageTextList = new MessageTextList();
			fraud.setMessageTextList(messageTextList);
			
			MessageText messageText = new MessageText();
			messageText.setMessageCode(this.safePull(oneSegment, "contentType"));
			messageText.setValue("");
			
			fraud.setMessageCode(messageText.getMessageCode());
			
			fraud.getMessageTextList().getMessageText().add(messageText);


		}
		 
		
	}
	
	default void updateAfmHeader(TfmParsedResponse tfmParsedResponse, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null) {
			return;
		}
		
		HeaderTu header = new HeaderTu();
		header.setSourceSegment(this.pullValue(tfmParsedResponse, "transactionControl", "segmentType"));
		header.setDateOfThisReport(this.pullValue(tfmParsedResponse, "transactionControl", "transactionDate"));
		header.setBureauArfVersion(this.pullValue(tfmParsedResponse, "transactionControl", "versionSwitch"));
		header.setUserReference(this.pullValue(tfmParsedResponse, "transactionControl", "userReferenceNumber"));
		header.setMemberCode(this.pullValue(tfmParsedResponse, "transactionControl", "subscriberCode"));
		header.setProductCode(this.pullValue(tfmParsedResponse, "productHeader", "productCode"));
		header.setSubjectId(this.pullValue(tfmParsedResponse, "subjectHeader", "subjectIdentifier"));
		header.setHitOrNoHitDesignatorCode(this.pullValue(tfmParsedResponse, "subjectHeader", "fileHit"));
		header.setFileSinceDate(this.pullValue(tfmParsedResponse, "subjectHeader", "onFileSinceDate"));
		header.setTransactionTime(this.pullValue(tfmParsedResponse, "transactionControl", "transactionTime"));
		header.setCountryCode(this.pullValue(tfmParsedResponse, "transactionControl", "countryCode"));
		header.setLanguageIndicator(this.pullValue(tfmParsedResponse, "transactionControl", "languageIndicator"));
		header.setConsumerStatementIndicator(this.pullValue(tfmParsedResponse, "subjectHeader", "consumerStatementIndicator"));
		header.setIndustryCode(this.pullValue(tfmParsedResponse, "transactionControl", "industryCode"));
		if (header !=null && header.getSourceSegment()!=null) {
			if (parsedResponse.getHeaderList()==null) {
				parsedResponse.setHeaderList(new HeaderList());
			}
			parsedResponse.getHeaderList().setHeader(header);
		}
		
	}
	default void updateAfmIdentification(TfmParsedResponse tfmParsedResponse, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null) {
			return;
		}
		
		IdentificationTu identification = new IdentificationTu();
		identification.setSourceSegment(this.pullValue(tfmParsedResponse, "personalInformation", "segmentType"));
		identification.setSubjectSsn(this.pullValue(tfmParsedResponse, "personalInformation", "socialInsuranceNumber"));
		identification.setSourceIndicator(this.pullValue(tfmParsedResponse, "personalInformation", "sourceIndicator"));
		identification.setSubjectDateOfBirth(this.pullValue(tfmParsedResponse, "personalInformation", "dateOfBirth"));
		identification.setSubjectAge(this.pullValue(tfmParsedResponse, "personalInformation", "age"));
		
		
		if (identification !=null && identification.getSourceSegment()!=null) {
			if (parsedResponse.getIdentificationList()==null) {
				parsedResponse.setIdentificationList(new IdentificationList());
			}
			parsedResponse.getIdentificationList().getIdentification().add(identification);
		}
		
	}
	
	default void updateAfmInquery(TfmParsedResponse tfmParsedResponse, Map<String, String> segmentDataProperies, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null || segmentDataProperies ==null || segmentDataProperies.isEmpty()) {
			return;
		}
		
		InquiryTu inquiry = new InquiryTu();
	    inquiry.setSourceSegment(segmentDataProperies.get("segmentType"));
	    inquiry.setInquiryDate(segmentDataProperies.get("dateOfInquiry"));
	    inquiry.setIndustryCode(segmentDataProperies.get("industryCode"));
		inquiry.setSubscriberNumber(segmentDataProperies.get("subscriberCode"));
		inquiry.setSubscriberName(segmentDataProperies.get("subscriberName"));
		inquiry.setLoanAmount(segmentDataProperies.get("loanAmount"));
		if (inquiry.getSourceSegment()!=null) {
			parsedResponse.getInquiryList().getInquiry().add(inquiry);
		}
	}
	
	default void updateAfmName(TfmParsedResponse tfmParsedResponse, Map<String, String> segmentDataProperies, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null || segmentDataProperies ==null || segmentDataProperies.isEmpty()) {
			return;
		}
		
		NameOrAliasTu name = new NameOrAliasTu();
		name.setSourceSegment(segmentDataProperies.get("segmentType"));
		name.setLastName(segmentDataProperies.get("lastName"));
		name.setFirstName(segmentDataProperies.get("firstName"));
		name.setMiddleName(segmentDataProperies.get("middleName"));
		name.setSuffix(segmentDataProperies.get("suffix"));
		name.setSourceIndicator(segmentDataProperies.get("sourceIndicator"));
		name.setNameIndicator(segmentDataProperies.get("nameIndicator"));
		if (name.getSourceSegment() !=null) {
			parsedResponse.getNameOrAliasList().getNameOrAlias().add(name);
		}
		 
	}
	
	//for each summary detail, copy summary info to it
	default void updateAfmSummaryInformation(TfmParsedResponse tfmParsedResponse, Map<String, String> segmentDataProperies, ParsedResponse parsedResponse) {
		if (tfmParsedResponse==null) {
			return;
		}
		
		SummaryInformationTu summaryInfo = new SummaryInformationTu();

		summaryInfo.setCreditSummaryReportingPeriod(this.pullValue(tfmParsedResponse, "creditSummary", "creditSummaryReportingPeriod"));
		summaryInfo.setNumberOfPublicRecords(this.pullValue(tfmParsedResponse, "creditSummary", "numberOfPublicRecords"));
		summaryInfo.setNumberOfCollections(this.pullValue(tfmParsedResponse, "creditSummary", "numberOfCollections"));
		summaryInfo.setNumberOfNegativeTrades(this.pullValue(tfmParsedResponse, "creditSummary", "numberOfNegativeTrades"));
		summaryInfo.setTradesWithAnyHistoricalNegative(this.pullValue(tfmParsedResponse, "creditSummary", "tradesWithAnyHistoricalNegative"));
		summaryInfo.setOccurrenceOfHistoricalNegatives(this.pullValue(tfmParsedResponse, "creditSummary", "occurrenceOfHistoricalNegatives"));
		summaryInfo.setNumberOfTrades(this.pullValue(tfmParsedResponse, "creditSummary", "numberOfTrades"));
		summaryInfo.setNumberOfRevolvingAndCheckCreditTrades(this.pullValue(tfmParsedResponse, "creditSummary", "numberOfRevolvingTrades"));
		summaryInfo.setNumberOfInstallmentTrades(this.pullValue(tfmParsedResponse, "creditSummary", "numberOfInstallmentTrades"));
		summaryInfo.setNumberOfMortgageTrades(this.pullValue(tfmParsedResponse, "creditSummary", "numberOfMortgageTrades"));
		summaryInfo.setNumberOfOpenTradeAccounts(this.pullValue(tfmParsedResponse, "creditSummary", "numberOfOpenTradeAccounts"));
		summaryInfo.setNumberOfInquiries(this.pullValue(tfmParsedResponse, "creditSummary", "numberOfInquiries"));
		
		summaryInfo.setCreditSummaryDescriptionType(segmentDataProperies.get("summaryType"));
		summaryInfo.setHighCredit(segmentDataProperies.get("highCredit"));
		
		summaryInfo.setCreditLimit(segmentDataProperies.get("creditLimit"));
		
		summaryInfo.setBalance(segmentDataProperies.get("balance"));
		
		summaryInfo.setAmountPastDue(segmentDataProperies.get("amountPastDue"));
		summaryInfo.setMonthlyPayment(segmentDataProperies.get("monthlyPayment"));
		summaryInfo.setPercentOfCreditAvailable(segmentDataProperies.get("percentOfCreditAvailable"));
		
		if (summaryInfo !=null && summaryInfo.getCreditSummaryReportingPeriod()!=null) {
			if (parsedResponse.getSummaryInformationList()==null) {
				parsedResponse.setSummaryInformationList(new SummaryInformationList());
			}
			parsedResponse.getSummaryInformationList().getSummaryInformation().add(summaryInfo);
		}
		
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
	
	default String safePull(Map<String, String> attributeMap, String attributeName) {
		if (attributeMap==null || attributeMap.isEmpty()) {
			return null;
		}
		 
		return attributeMap.get(attributeName);
	}
	
}
