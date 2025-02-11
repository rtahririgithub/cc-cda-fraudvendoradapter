package com.telus.subsfraudmgmt.api.modelmapper.tfm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import com.fico.afm.model.application.Address;
import com.fico.afm.model.application.Applicant;
import com.fico.afm.model.application.Email;
import com.fico.afm.model.application.Phone;
import com.fico.afm.model.application.types.MaritalStatus;
import com.telus.subsfraudmgmt.api.model.AccountRelationship;
import com.telus.subsfraudmgmt.api.model.ContactMedium;
import com.telus.subsfraudmgmt.api.model.ContactMediumRefOrValue;
import com.telus.subsfraudmgmt.api.model.Customer;
import com.telus.subsfraudmgmt.api.model.Individual;
import com.telus.subsfraudmgmt.api.model.IndividualIdentification;
import com.telus.subsfraudmgmt.api.model.MediumCharacteristic;
import com.telus.subsfraudmgmt.api.model.StringCharacteristic;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccount;
import com.telus.subsfraudmgmt.api.model.TelusCreditProfile;
import com.telus.subsfraudmgmt.api.model.TelusIndividualIdentification;
import com.telus.subsfraudmgmt.api.model.watson.ErrorErrors;
import com.telus.subsfraudmgmt.api.model.watson.PredictionPredictions;
import com.telus.subsfraudmgmt.api.model.watsonsimulator.Prediction;
import com.telus.subsfraudmgmt.api.model.watsonsimulator.PredictionError;
import com.telus.subsfraudmgmt.api.model.watsonsimulator.WatsonResponseModel;
import com.telus.subsfraudmgmt.api.modelmapper.common.MapperCommon;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.ApplicantUserData.RelationShipOpenAccount;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.ApplicantUserData.RelationShipTentativeAccount;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.bureau.TfmBureauReports;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.bureau.TfmBureauReports.TfmBureauReport;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.bureau.TfmBureauReports.TfmParsedResponse;
import com.telus.subsfraudmgmt.springboot.util.GeneralUtil;
/**
 * Map api <code>Customer</code> to AFM <code>ApplicationDetail</code>'s <code>Applicant</code> data
 * @author Harry Xu
 *
 */
@Mapper(componentModel="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@MapperConfig(unmappedTargetPolicy=ReportingPolicy.WARN)

public interface CustomerToApplicantsMapper extends MapperCommon {
	
	public static final String PRIMARY_APPLICANT = "PRIMARY_APPLICANT"; //ApplicantType.Primary
	public static final String SIN = "SIN";
	public static final String CC = "CC";
	public static final String DL = "DL";
	public static final String PASSPORT = "PASSPORT";
	public static final String DRIVERS_LICENSE = "DRIVERS_LICENSE"; 
	public static final String UNKNOWN = "UNKNOWN";
	public static final String NATIONAL_ID = "NATIONAL_ID";

	CustomerToApplicantsMapper INSTANCE = Mappers.getMapper( CustomerToApplicantsMapper.class );
	 
	@Named("customerAndTfmBureauReportsToApplicants")
	default List<Applicant> customerAndTfmBureauReportsToApplicants(Customer customer, TfmBureauReports tfmBureauReports) {
		List<Applicant>  applicants = new ArrayList<>();
		
		TfmParsedResponse tfmParsedResponse = null;
		if (tfmBureauReports !=null && tfmBureauReports.getTfmBureauReportList()!=null && 
				!tfmBureauReports.getTfmBureauReportList().isEmpty()) {
			
			TfmBureauReport tfmBureauReport = tfmBureauReports.getTfmBureauReportList().get(0);
			
			if (tfmBureauReport!=null && tfmBureauReport.getTfmParsedResponseList()!=null 
					&&  !tfmBureauReport.getTfmParsedResponseList().isEmpty() ) {
				
				tfmParsedResponse = tfmBureauReports.getTfmBureauReportList().get(0).getTfmParsedResponseList().get(0);
				 
			}
			
		}
		
		Applicant applicant = customerAndTfmReponseToApplicant (customer, tfmParsedResponse);
		if (applicant!=null) {
			applicants.add(applicant);
		}
		return applicants;
	}
	
	@Named("customerAndTfmBureauReportsToApplicants")
	default List<Applicant> customerAndTfmBureauReportsToApplicants(Customer customer, TfmBureauReports tfmBureauReports, com.telus.subsfraudmgmt.api.model.watson.Prediction watsonSimulatorResponse, com.telus.subsfraudmgmt.api.model.watson.Error watsonErrorResponse) {
		List<Applicant>  applicants = new ArrayList<>();
		
		TfmParsedResponse tfmParsedResponse = null;
		if (tfmBureauReports !=null && tfmBureauReports.getTfmBureauReportList()!=null && 
				!tfmBureauReports.getTfmBureauReportList().isEmpty()) {
			
			TfmBureauReport tfmBureauReport = tfmBureauReports.getTfmBureauReportList().get(0);
			
			if (tfmBureauReport!=null && tfmBureauReport.getTfmParsedResponseList()!=null 
					&&  !tfmBureauReport.getTfmParsedResponseList().isEmpty() ) {
				
				tfmParsedResponse = tfmBureauReports.getTfmBureauReportList().get(0).getTfmParsedResponseList().get(0);
				 
			}
			
		}
		
		Applicant applicant = customerAndTfmReponseToApplicant (customer, tfmParsedResponse, watsonSimulatorResponse, watsonErrorResponse);
		if (applicant!=null) {
			applicants.add(applicant);
		}
		return applicants;
	}

	default Applicant fromCustomerToApplicant(Customer customer) {
		return customerAndTfmReponseToApplicant(customer, null);
	}
	
	default Applicant customerAndTfmReponseToApplicant(Customer customer, TfmParsedResponse tfmParsedResponse, com.telus.subsfraudmgmt.api.model.watson.Prediction watsonSimulatorResponse, com.telus.subsfraudmgmt.api.model.watson.Error watsonErrorResponse) {
		Applicant applicant  = new Applicant();
		
		if (customer ==null) {
			return applicant;
		}
		
		//concrete type data
		Individual individual = null;
		TelusBillingAccount account = null;
		TelusCreditProfile creditProfile = null; 	
		
		
		ApplicantUserData applicantUserData = new ApplicantUserData();
		//
		//update applicant non user data
		//customer.engagedParty.value 
		if (customer.getEngagedParty() !=null && customer.getEngagedParty().getValue() !=null) {
			individual = (Individual)customer.getEngagedParty().getValue();
			updateApplicantNonUserDataFromIndividual(individual, applicant);
		}

		//
		//prepare objects for easier updating of applicant user data
		//
		if (customer.getAccount()!=null && !customer.getAccount().isEmpty() && customer.getAccount().get(0).getValue()!=null) {
			account = (TelusBillingAccount)customer.getAccount().get(0).getValue();		  
		}
		if (customer.getCreditProfile()!=null && !customer.getCreditProfile().isEmpty() && 
				customer.getCreditProfile().get(0)!=null && customer.getCreditProfile().get(0).getValue()!=null) {	
			
			creditProfile = (TelusCreditProfile)customer.getCreditProfile().get(0).getValue(); 		
		}

		if (individual != null && individual.getContactMedium()!=null && !individual.getContactMedium().isEmpty()) {
			for (ContactMediumRefOrValue refOrValue: individual.getContactMedium()) {
				ContactMedium contactMedium = refOrValue.getValue();
				if (contactMedium ==null || contactMedium.getMediumType() ==null) {
					continue;
				}
				if ("ADDRESS".equalsIgnoreCase(contactMedium.getMediumType())) {
					Address address = fromContactMediaToAddressMainContents (contactMedium);
					if (address!=null) {
						//address5, streetName etc has to be in user data
						AddressUserData addressUserData = mapToApplicantAddressUserData(account, contactMedium);
						address.getUserData().addAll(this.toAFMUserDataList(addressUserData));
						applicant.getAddress().add(address);
					}
				}
				if ("EMAIL".equalsIgnoreCase(contactMedium.getMediumType())) {
					Email email = fromContactMediaToEmail(contactMedium);
					if (email !=null) {
						applicant.setEmail(email);
					}
				}
				if (contactMedium.getMediumType().endsWith("PH")) {
				   //HOPH- Home Phone
                   // WKPH - Business Phone
                   //DYPH- Contact Phone
                   //WKPH - Other Phone

					Phone phone = fromContactMediaToPhone(contactMedium);
					if (phone !=null) {
						applicant.getPhone().add(phone);
					}
				}

			}	
			
		}
		
		//let mapstruts handle null check with top level annotation
		updateApplicantUserData (individual, tfmParsedResponse,
				account, creditProfile, watsonSimulatorResponse, watsonErrorResponse, applicantUserData);

		//for all properties in ApplicantUserData, add to applicant's the userData list if not null
		applicant.getUserData().addAll(this.toAFMUserDataList(applicantUserData));

		return applicant;
	}

	default Applicant customerAndTfmReponseToApplicant(Customer customer, TfmParsedResponse tfmParsedResponse) {
		Applicant applicant  = new Applicant();
		
		if (customer ==null) {
			return applicant;
		}
		
		//concrete type data
		Individual individual = null;
		TelusBillingAccount account = null;
		TelusCreditProfile creditProfile = null; 	
		
		
		ApplicantUserData applicantUserData = new ApplicantUserData();
		//
		//update applicant non user data
		//customer.engagedParty.value 
		if (customer.getEngagedParty() !=null && customer.getEngagedParty().getValue() !=null) {
			individual = (Individual)customer.getEngagedParty().getValue();
			updateApplicantNonUserDataFromIndividual(individual, applicant);
		}

		//
		//prepare objects for easier updating of applicant user data
		//
		if (customer.getAccount()!=null && !customer.getAccount().isEmpty() && customer.getAccount().get(0).getValue()!=null) {
			account = (TelusBillingAccount)customer.getAccount().get(0).getValue();		  
		}
		if (customer.getCreditProfile()!=null && !customer.getCreditProfile().isEmpty() && 
				customer.getCreditProfile().get(0)!=null && customer.getCreditProfile().get(0).getValue()!=null) {	
			
			creditProfile = (TelusCreditProfile)customer.getCreditProfile().get(0).getValue(); 		
		}

		if (individual != null && individual.getContactMedium()!=null && !individual.getContactMedium().isEmpty()) {
			for (ContactMediumRefOrValue refOrValue: individual.getContactMedium()) {
				ContactMedium contactMedium = refOrValue.getValue();
				if (contactMedium ==null || contactMedium.getMediumType() ==null) {
					continue;
				}
				if ("ADDRESS".equalsIgnoreCase(contactMedium.getMediumType())) {
					Address address = fromContactMediaToAddressMainContents (contactMedium);
					if (address!=null) {
						//address5, streetName etc has to be in user data
						AddressUserData addressUserData = mapToApplicantAddressUserData(account, contactMedium);
						address.getUserData().addAll(this.toAFMUserDataList(addressUserData));
						applicant.getAddress().add(address);
					}
				}
				if ("EMAIL".equalsIgnoreCase(contactMedium.getMediumType())) {
					Email email = fromContactMediaToEmail(contactMedium);
					if (email !=null) {
						applicant.setEmail(email);
					}
				}
				if (contactMedium.getMediumType().endsWith("PH")) {
				   //HOPH- Home Phone
                   // WKPH - Business Phone
                   //DYPH- Contact Phone
                   //WKPH - Other Phone

					Phone phone = fromContactMediaToPhone(contactMedium);
					if (phone !=null) {
						applicant.getPhone().add(phone);
					}
				}

			}	
			
		}
		
		//let mapstruts handle null check with top level annotation
		updateApplicantUserData (individual, tfmParsedResponse,
				account, creditProfile, null, null, applicantUserData);

		//for all properties in ApplicantUserData, add to applicant's the userData list if not null
		applicant.getUserData().addAll(this.toAFMUserDataList(applicantUserData));

		return applicant;
	}

	//
	//Based on Applicant tab  non "user data" portion
	//
	@Mapping(source="birthDate", target="birthDate", qualifiedByName = "offsetDateTimeToCalendar")
	@Mapping(target="gender", constant = UNKNOWN)
	@Mapping(source="maritalStatus", target="maritalStatus", qualifiedByName="deriveMaritalStatus")
	@Mapping(target="primaryIdentificationType", constant = NATIONAL_ID)
	@Mapping(source="individual", target="primaryIdentificationNumber", qualifiedByName = "derivepPimaryIdentificationNumber")
	@Mapping(source="individual", target="primaryIdentificationSupplemental", qualifiedByName = "derivepPimaryIdentificationSupplementalNumber")
	@Mapping(target="secondaryIdentificationType", constant = DRIVERS_LICENSE)
	@Mapping(source="individual", target="secondaryIdentificationNumber", qualifiedByName = "derivepSecondaryIdentificationNumber")
	@Mapping(source="individual", target="secondaryIdentificationSupplemental", qualifiedByName = "derivepSecondaryIdentificationSupplementalNumber")
	@Mapping(target="type", constant = PRIMARY_APPLICANT)
	//
	//Based on Name tab
	//
	@Mapping(source="givenName", target="name.first")
	@Mapping(source="middleName", target="name.middle")
	@Mapping(source="familyName", target="name.last")
	
	void updateApplicantNonUserDataFromIndividual(Individual individual, @MappingTarget Applicant applicant);
	
	@Named("deriveMaritalStatus")
	default MaritalStatus deriveMaritalStatus (String maritalStatus) {
		for (MaritalStatus status: MaritalStatus.values()) {
			if (status.toString().equalsIgnoreCase(maritalStatus)) {
				return status;
			}
		}
		return MaritalStatus.OTHER;
	}
	//
	//Based on Address tab - non user data
	//
	@Mapping(source="contactMedium.characteristic", target="street1", qualifiedByName= "deriveStreet1")
	@Mapping(source="contactMedium.characteristic.street2", target="street2")
	@Mapping(source="contactMedium.characteristic.street3", target="street3")
	@Mapping(source="contactMedium.characteristic.street4", target="street4")
	@Mapping(source="contactMedium.characteristic.city", target="city")
	@Mapping(source="contactMedium.characteristic.stateOrProvince", target="stateOrProvince")
	@Mapping(source="contactMedium.characteristic.postCode", target="postalCode")
	@Mapping(source="contactMedium.characteristic.country", target="countryCode")
	
	Address fromContactMediaToAddressMainContents(ContactMedium contactMedium);
	
	@Named("deriveStreet1")
	default String deriveStreet1(MediumCharacteristic mediumCharacteristic) {
		if (mediumCharacteristic==null || mediumCharacteristic.getStreet1() == null || mediumCharacteristic.getStreet1().trim().isEmpty()) {
			return "EMPTY_VAL";
		}
		return mediumCharacteristic.getStreet1().trim();
	}
	
	//
	//Based on Phone tab
	//
	
	@Mapping(source="contactMedium.characteristic.contactType", target="phoneType")
	@Mapping(source="contactMedium.characteristic.phoneNumber", target="phoneNumber")
	
	Phone fromContactMediaToPhone(ContactMedium contactMedium);
	
	//
	//Based on Email tab
	//
	
	@Mapping(source="contactMedium.characteristic.emailAddress", target="emailAddress")
	
	Email fromContactMediaToEmail(ContactMedium contactMedium);
    
	//
	//Based on Address tab - user data
	//
	@Mapping(source="contactMedium.characteristic.street5", target="addressLineFiveTxt")
	@Mapping(source="contactMedium.characteristic.streetName", target="adrStreetName")
	@Mapping(source="contactMedium.characteristic.civicNumber", target="civicNo")
	@Mapping(source="account.homeProvince", target="homeProvince")
	
	AddressUserData mapToApplicantAddressUserData(TelusBillingAccount account, ContactMedium contactMedium);
	
	//
	//based on excel sheet tab <code>Applicant</code>
	//
	/** Map to applicant user data
	 * <pre>
	 * TelusIndividualIdentification.characteristic[i].value where
	 * name=creditCardLastFourNum
	 * customer.engagedParty.value(individual).TelusIndividualIdentification where
	 * identificationType=CC
	 * 
	 * "TelusIndividualIdentification.characteristic[i].value where name=driverLicenseProvinceCd
	 * customer.engagedParty.value(individual).TelusIndividualIdentification where identificationType=DL"
     *
	 * </pre>
	 */
	@Mapping(source="account.billingAccountNumber", target="accountId") 
	//@Mapping(source="account.accountCreationDate", target="accountCreateDate", qualifiedByName= "offsetDateTimeToString")
	@Mapping(source="account.accountCreationDate", target="accountCreateDate")
	@Mapping(source="account.totalMatchingAccountCount", target="totalDuplicateBanCounts") 
	@Mapping(source="account.totalProductCountForAllMatchingAccounts", target="totalDuplicateBanSubCounts")
	@Mapping (source="account.accountRelationship", target="applicantUserData.relationshipTentativeAccountList", qualifiedByName="deriveRelationshipTentativeAccountList")
	@Mapping (source="account.accountRelationship", target="applicantUserData.relationshipOpenAccountList", qualifiedByName="deriveRelationshipOpenAccountList")
	@Mapping(source="individual", target="creditCardToken", qualifiedByName="deriveCreditCardToken")
	@Mapping(source="individual", target="drivrLicnsNo", qualifiedByName="deriveDriverLicenseNo")
	@Mapping(source="individual", target="sinNo", qualifiedByName= "deriveSinNo")
	@Mapping(source="individual", target="passport",  qualifiedByName= "derivePassportNumber")
	
	@Mapping(source="account.creditDecisioningResult.value.creditAssessmentResultCd", target="assmtRsltCd")
	@Mapping(source="account.creditDecisioningResult.value.creditAssessmentResultReasonCd", target="assmtRsltRsnCd")
	@Mapping(source="account.creditDecisioningResult.value.decisionKeys.assessmentTriggerCd", target="assmtTrigCd")
	@Mapping(source="account.creditDecisioningResult.value.decisionKeys.assessmentTriggerValueCd", target="assmtTrigValCd")
	@Mapping(source="account.creditBureauResult.riskIndicator.bankcrupcyInd", target="bankruptcyInd")
	@Mapping(source="account.startServiceDate", target="banStartServiceDate", qualifiedByName= "offsetDateTimeToString")
	@Mapping(source="account.accountStatusCd", target="banStatus")
	@Mapping(source="creditProfile.bureauDecisionCode", target="burDecsnCd")
	@Mapping(source="account.creditBureauResult.errorCd", target="burRptErrInd")
	@Mapping(source="account.creditDecisioningResult.value.decisionKeys.bureauReportExistInd", target="burRptExistInd")
	@Mapping(source="account.creditDecisioningResult.value.decisionKeys.bureauReportRequiredInd", target="burRptRequiredInd")
	@Mapping(source="account.creditDecisioningResult.value.decisionKeys.bureauTypeCd", target="burTypeCd")
	
	@Mapping(source="individual", target="creditCardFirstSix", qualifiedByName="deriveCreditCardFirstSix")
	@Mapping(source="individual", target="credtCardLastFour", qualifiedByName="deriveCreditCardLastFour")
	@Mapping(source="individual", target="drivrLicnsExpDt", qualifiedByName= "deriveLicenseExpiryDate")
	@Mapping(source="individual", target="drivrLicnsState",  qualifiedByName= "deriveLicenseIssuingState")
	@Mapping(source="individual.fullName", target="fullNm")
	@Mapping(source="account.creditBureauResult.riskIndicator.noHitThinFileInd", target="noHitThinFileInd")
	@Mapping(source="account.creditDecisioningResult.value.decisionKeys.nullBureauCreateDateInd", target="nullBurCreateDateInd")
	@Mapping(source="account.creditBureauResult.riskIndicator.secondaryRiskCd", target="secndyRiskCd")
	@Mapping(source="account.statusActivityCode", target="statusActvCode")
	@Mapping(source="account.statusActivityReasonCode", target="statusActvRsnCode", qualifiedByName= "deriveStatusAtivityReasonCode")
	@Mapping(source="account.creditBureauResult.riskIndicator.temporarySinInd", target="tempSinInd")
	@Mapping(source="account.creditDecisioningResult.value.decisionKeys.thinFileInd", target="thinFileInd", qualifiedByName= "fromBooleanToYN")
	@Mapping(source="account.creditBureauResult.riskIndicator.trueThinFileInd", target="trueThinFileInd")

	@Mapping(source="individual", target="cbRequestApplicantNationalIDInd", qualifiedByName="deriveSinExistence")
	@Mapping(source="individual", target="cbRequestApplicantCardNumberInd", qualifiedByName="deriveCCExistence")
	@Mapping(source="individual", target="cbRequestApplicantDLInd", qualifiedByName= "deriveDriverLicenseExistence")
	@Mapping(source="individual", target="cbRequestApplicantPassportInd",  qualifiedByName= "derivePassportExistence")
	
	@Mapping(source="watsonErrorResponse", target="watson_api_error_code",  qualifiedByName= "deriveWatsonApiErrorCode")
	@Mapping(source="watsonSimulatorResponse", target="watson_prediction_value_1",  qualifiedByName= "deriveWatsonPredictionValue")
	@Mapping(source="watsonSimulatorResponse", target="watson_prb_value_fraud_1",  qualifiedByName= "deriveWatsonProbFraudValue")
	@Mapping(source="watsonSimulatorResponse", target="watson_prb_value_nonfraud_1",  qualifiedByName= "deriveWatsonProbNonFraudValue")

	@Mapping(source="tfmParsedResponse.totalNumberOfInquiries", target="cbTotal_Number_of_Inquiries")
	@Mapping(source="tfmParsedResponse.creditFileWarningMessage", target="cbCredit_file_Warning_Message")
	void updateApplicantUserData(Individual individual, 
			TfmParsedResponse tfmParsedResponse,
			TelusBillingAccount account, 
			TelusCreditProfile creditProfile,
			com.telus.subsfraudmgmt.api.model.watson.Prediction watsonSimulatorResponse, 
			com.telus.subsfraudmgmt.api.model.watson.Error watsonErrorResponse,
			@MappingTarget  ApplicantUserData applicantUserData);
	 

	@Named("deriveWatsonApiErrorCode")
	default String deriveWatsonApiErrorCode(com.telus.subsfraudmgmt.api.model.watson.Error watsonErrorResponse) {
		List <ErrorErrors> predictionErrors = null;
		String response = null;
		try {
			predictionErrors = watsonErrorResponse.getErrors();
			response = predictionErrors.get(0).getCode().trim();
		} catch (NullPointerException npe) {
			LOG.info(npe.getMessage());
		}
		if (watsonErrorResponse==null || response==null) {
			return null;
		}
		return response;
		
	}
	

	@Named("deriveWatsonPredictionValue")
	default String deriveWatsonPredictionValue(com.telus.subsfraudmgmt.api.model.watson.Prediction watsonSimulatorResponse) {
		String response = null;
		try {
			List<PredictionPredictions> predictionList = watsonSimulatorResponse.getPredictions();
			PredictionPredictions singlePrediction = predictionList.get(0);
			response = (String) singlePrediction.getValues().get(0);
		} catch (NullPointerException npe) {
			LOG.info(npe.getMessage());
		}
		return response;
		
	}
	@Named("deriveWatsonProbFraudValue")
	default String deriveWatsonProbFraudValue(com.telus.subsfraudmgmt.api.model.watson.Prediction watsonSimulatorResponse) {
		String response = null;
		try {
			LOG.info("Mapping Prediction response for Probability Fraud value from ..." + watsonSimulatorResponse.toString());
			List<PredictionPredictions> predictionList = watsonSimulatorResponse.getPredictions();
			PredictionPredictions singlePrediction = predictionList.get(0);
//			String [] values = (String []) singlePrediction.getValues().get(1);
//			response = values[0];
			List<Object> objList = new ArrayList<>(singlePrediction.getValues().size());
			objList=singlePrediction.getValues();
			List<String> strProbFraudValues=new ArrayList<String>(2);
			strProbFraudValues=GeneralUtil.castObjectListToStringList(objList);
			response = strProbFraudValues.get(0);
		} catch (NullPointerException npe) {
			LOG.info(npe.getMessage());
		}
		return response;
	}
	@Named("deriveWatsonProbNonFraudValue")
	default String deriveWatsonProbNonFraudValue(com.telus.subsfraudmgmt.api.model.watson.Prediction watsonSimulatorResponse) {
		String response = null;
		try {
			LOG.info("Mapping Prediction response for Probability Non Fraud value from ..." + watsonSimulatorResponse.toString());
			List<PredictionPredictions> predictionList = watsonSimulatorResponse.getPredictions();
			PredictionPredictions singlePrediction = predictionList.get(0);
//			String [] values = (String []) singlePrediction.getValues().get(1);
//			response = values[1];
			List<Object> objList = new ArrayList<>(singlePrediction.getValues().size());
			objList=singlePrediction.getValues();
			List<String> strProbFraudValues=new ArrayList<String>(2);
			strProbFraudValues=GeneralUtil.castObjectListToStringList(objList);
			response = strProbFraudValues.get(1);	
		} catch (NullPointerException npe) {
			LOG.info(npe.getMessage());
		}
		return response;
	}

	@Named("deriveStatusAtivityReasonCode")
	default String deriveStatusAtivityReasonCode(String statusActivityReasonCode) {
		if (statusActivityReasonCode==null) {
			return null;
		}
		return statusActivityReasonCode.trim();
		
	}
	
	@Named("deriveSinNo")
	default String deriveSinNo(Individual individual) {
		//derive social insurance number
		return this.lookForIdentificationNumberByType(individual, SIN);
		
	}
	
	@Named("deriveCreditCardToken")
	default String deriveCreditCardToken(Individual individual) {
		return this.lookForIdentificationNumberByType(individual, CC);
	}
	
	@Named("derivePassportNumber")
	default String derivePassportNumber(Individual individual) {
		return this.lookForIdentificationNumberByType(individual, PASSPORT);
		
	}
	@Named("deriveDriverLicenseNo")
	default String deriveDriverLicenseNo(Individual individual) {
		return this.lookForIdentificationNumberByType(individual, DL);
		
	}
	
	@Named("deriveSinExistence")
	default String deriveSinExistence(Individual individual) {
		String result = this.deriveSinNo(individual);
		return Boolean.toString(result!=null && !result.trim().isEmpty());
		
	}
	@Named("deriveCCExistence")
	default String deriveCCExistence(Individual individual) {
		String result = this.deriveCreditCardToken(individual);
		return Boolean.toString(result!=null && !result.trim().isEmpty());
		
	}
	@Named("deriveDriverLicenseExistence")
	default String deriveDriverLicenseExistence(Individual individual) {
		String result = this.deriveDriverLicenseNo(individual);
		return Boolean.toString(result!=null && !result.trim().isEmpty());
		
	}
	@Named("derivePassportExistence")
	default String derivePassportExistence(Individual individual) {
		String result = this.derivePassportNumber(individual);
		return Boolean.toString(result!=null && !result.trim().isEmpty());
		
	}
	
	@Named("deriveLicenseIssuingState")
	default String deriveLicenseIssuingState(Individual individual) {
		return lookForIdentificationCharcteristicValue(individual, "DL", "driverLicenseProvinceCd");
		
	}
	
	@Named("deriveLicenseExpiryDate")
	default String deriveLicenseExpiryDate(Individual individual) {
		return lookForIdentificationCharcteristicValue(individual, "DL", "endDateTime");
		
	}
	
	
	@Named("deriveCreditCardFirstSix")
	default String deriveCreditCardFirstSix(Individual individual) {
		return lookForIdentificationCharcteristicValue(individual, "CC", "creditCardFirstSixNum");
	}
	
	
	
	@Named("deriveCreditCardLastFour")
	default String deriveCreditCardLastFour(Individual individual) {
		return lookForIdentificationCharcteristicValue(individual, "CC", "creditCardLastFourNum");
	}
	
	default String lookForIdentificationCharcteristicValue (Individual individual,
			String identificationType,
			String nameToLook) {
		
		if (individual.getIndividualIdentification()==null) {
			return null;
		}
		for (IndividualIdentification temp: individual.getIndividualIdentification()) {
			if (!(temp instanceof TelusIndividualIdentification)) {
				throw new RuntimeException("Expect TelusIndividualIdentification subtype to have characteristic list, but got IndividualIdentification!");
			}
			TelusIndividualIdentification iden = (TelusIndividualIdentification)temp;
			if (identificationType.equalsIgnoreCase(iden.getIdentificationType())) {
				//look for DL expiry name, which is not in characteristics
				if ("DL".equalsIgnoreCase(identificationType) && "endDateTime".equals(nameToLook)
						&& iden.getValidFor()!=null) {
			       return this.offsetDateTimeToString(iden.getValidFor().getEndDateTime());
				} else if (iden.getCharacteristic()==null) {
					continue;
				}else {
					for (StringCharacteristic character: iden.getCharacteristic()) {
					 
						if (nameToLook.equalsIgnoreCase(character.getName())) {
							return character.getValue();
						}
					}
				}
			}
		}
		return null;
	}
	
	
	default String lookForIdentificationNumberByType(Individual individual, String identificationType ) {
		if (individual.getIndividualIdentification() ==null || individual.getIndividualIdentification().isEmpty()) {
			return "";
		}
		for (IndividualIdentification identification: individual.getIndividualIdentification()) {
			if (identificationType.equalsIgnoreCase(identification.getIdentificationType())) {
				return identification.getIdentificationId();
			}
		} 
		return "";
	}
    
	@Named("derivepPimaryIdentificationNumber")
	default String derivepPimaryIdentificationNumber(Individual individual) {       
		return lookForIdentificationNumberByType(individual, SIN);
	}
	@Named("derivepPimaryIdentificationSupplementalNumber")
	default String derivepPimaryIdentificationSupplementalNumber(Individual individual) {
		return lookForIdentificationNumberByType(individual, CC);
	}
	
	@Named("derivepSecondaryIdentificationNumber")
	default String derivepSecondaryIdentificationNumber(Individual individual) {
		return lookForIdentificationNumberByType(individual, DL);
	}
	
	@Named("derivepSecondaryIdentificationSupplementalNumber")
	default String derivepSecondaryIdentificationSupplementalNumber(Individual individual) {
		return lookForIdentificationNumberByType(individual, PASSPORT);
	}

	
	default List<RelationShipTentativeAccount> deriveRelationshipTentativeAccountList(List<AccountRelationship> accountRealtionshipList) {
		List<RelationShipTentativeAccount> resultList = new ArrayList<>();
		if (accountRealtionshipList ==null || accountRealtionshipList.isEmpty()) {
			return resultList;
		}
		for (AccountRelationship acctRelationship: accountRealtionshipList) {
			if (acctRelationship ==null || acctRelationship.getAccount()==null 
					|| acctRelationship.getAccount().getValue()==null) {
				continue;
			}
			TelusBillingAccount typedAccount = (TelusBillingAccount) acctRelationship.getAccount().getValue();
			if (!"T".equalsIgnoreCase(typedAccount.getAccountStatusCd())) {
				//not tentative account, do not add to tentative account list
				continue;
			}
			RelationShipTentativeAccount tentativeAccount = new RelationShipTentativeAccount();
			tentativeAccount.setBanTentative(bigDecimalToString(typedAccount.getBillingAccountNumber()));
			//tentativeAccount.setBanTentativeCreationDate(offsetDateTimeToString(typedAccount.getAccountCreationDate()));
			tentativeAccount.setBanTentativeCreationDate(typedAccount.getAccountCreationDate());
			resultList.add(tentativeAccount);
		}
		Collections.sort(resultList);
		return resultList;
	}
	
	default List<RelationShipOpenAccount> deriveRelationshipOpenAccountList(List<AccountRelationship> accountRealtionshipList) {
		List<RelationShipOpenAccount> resultList = new ArrayList<>();
		if (accountRealtionshipList ==null || accountRealtionshipList.isEmpty()) {
			return resultList;
		}
		for (AccountRelationship acctRelationship: accountRealtionshipList) {
			if (acctRelationship ==null || acctRelationship.getAccount()==null 
					|| acctRelationship.getAccount().getValue()==null) {
				continue;
			}
			TelusBillingAccount typedAccount = (TelusBillingAccount) acctRelationship.getAccount().getValue();
			if (!"O".equalsIgnoreCase(typedAccount.getAccountStatusCd())) {
				//not tentative account
				continue;
			}
			RelationShipOpenAccount openAccount = new RelationShipOpenAccount();
			openAccount.setBan(bigDecimalToString(typedAccount.getBillingAccountNumber()));
			openAccount.setBanStatus(typedAccount.getAccountStatusCd());
			//openAccount.setBanCreationDate(offsetDateTimeToString(typedAccount.getAccountCreationDate()));
			openAccount.setBanCreationDate(typedAccount.getAccountCreationDate());
			openAccount.setBanServiceStartDate(offsetDateTimeToString(typedAccount.getStartServiceDate()));		
			openAccount.setBanSubscriberCount(bigDecimalToString(typedAccount.getTotalProductCount()));
			openAccount.setBanStatusActvCode(typedAccount.getStatusActivityCode());
			openAccount.setBanStatusActvRsnCode(typedAccount.getStatusActivityReasonCode());
			resultList.add(openAccount);
		}
	
		Collections.sort(resultList);
		return resultList;
	}
}
