package com.telus.subsfraudmgmt.api.modelmapper.tfm;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.fico.afm.model.application.Applicant;
import com.fico.afm.model.application.ApplicationDetails;
import com.fico.afm.model.application.ApplicationRequest;
import com.fico.afm.model.application.ApplicationSectionTelco;
import com.fico.afm.model.application.types.PackageType;
import com.telus.subsfraudmgmt.api.model.Customer;
import com.telus.subsfraudmgmt.api.model.FraudCheckPerform;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccount;
import com.telus.subsfraudmgmt.api.model.TelusChannel;
import com.telus.subsfraudmgmt.api.model.TelusCreditDecisioningWarning;
import com.telus.subsfraudmgmt.api.model.TelusCreditProfile;
import com.telus.subsfraudmgmt.api.model.watsonsimulator.WatsonResponseModel;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.ApplicationSectionTelcoUserData.Warning;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.bureau.TfmBureauReports;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.util.PackageTypeUtil;

/**
 * THis is the mapper that handles mapping that does not include bureau report mapping
 * @author Harry Xu
 *
 */
@Mapper(componentModel="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@MapperConfig(unmappedTargetPolicy=ReportingPolicy.WARN)

public interface FraudCheckPerformWorkerMapper extends CustomerToApplicantsMapper {
	 
	FraudCheckPerformWorkerMapper INSTANCE = Mappers.getMapper( FraudCheckPerformWorkerMapper.class );
	
	public static final String DEFAULT_MONTHLY_FEE = " 99.99f";
	public static final String DEFAULT_HANDSET_VALUE = " 999.99f";  
	

	default ApplicationRequest jointMapToApplicationRequest(FraudCheckPerform fraudCheckPerform, TfmBureauReports tfmBureauReports) {
	 
		if (fraudCheckPerform == null || fraudCheckPerform.getCustomer() ==null || fraudCheckPerform.getCustomer().getValue()==null) {
			return null;
		}
		Customer customer = fraudCheckPerform.getCustomer().getValue();
		
		ApplicationRequest applicationRequest = basicMapping(fraudCheckPerform);
		if (applicationRequest==null) {
			return null;
		}
		List<Applicant> applicants= customerAndTfmBureauReportsToApplicants (customer, tfmBureauReports); 
		if (applicants !=null) {
			if (applicationRequest.getApplication()==null) {
				applicationRequest.setApplication(new ApplicationDetails());
			}
			applicationRequest.getApplication().getApplicant().addAll(applicants);
		}
		return applicationRequest;
	}
	
	default ApplicationRequest jointMapToApplicationRequest(FraudCheckPerform fraudCheckPerform, TfmBureauReports tfmBureauReports, com.telus.subsfraudmgmt.api.model.watson.Prediction watsonSimulatorResponse, com.telus.subsfraudmgmt.api.model.watson.Error watsonErrorResponse) {
		 
		if (fraudCheckPerform == null || fraudCheckPerform.getCustomer() ==null || fraudCheckPerform.getCustomer().getValue()==null) {
			return null;
		}
		Customer customer = fraudCheckPerform.getCustomer().getValue();
		
		ApplicationRequest applicationRequest = basicMapping(fraudCheckPerform);
		if (applicationRequest==null) {
			return null;
		}
		List<Applicant> applicants= customerAndTfmBureauReportsToApplicants (customer, tfmBureauReports, watsonSimulatorResponse, watsonErrorResponse); 
		if (applicants !=null) {
			if (applicationRequest.getApplication()==null) {
				applicationRequest.setApplication(new ApplicationDetails());
			}
			applicationRequest.getApplication().getApplicant().addAll(applicants);
		}
		return applicationRequest;
	}

	//map to header 
	@Mapping(target = "header.clientId", constant="RTFDCREDIT")
	@Mapping(source = "applicationDateTime", target = "header.createDateTime", qualifiedByName = "offsetDateTimeToCalendar")
	@Mapping(target = "header.gmtOffset", constant= "0.0f")
	@Mapping(target = "header.applicationSector", constant= "TELECOMMUNICATIONS")
	
	//map to details
	@Mapping(source = "externalApplicationId", target = "application.applicationId")
	@Mapping(source = "applicationDateTime", target = "application.applicationDateTime", qualifiedByName = "offsetDateTimeToCalendar")
	@Mapping(source = "customer.value.account", target = "application.portfolio", qualifiedByName = "getFirstAccountBrandCd")
	@Mapping(source = "channel.value.channelTypeCd", target = "application.applicationMethod", qualifiedByName="toApplicationMethod")
	@Mapping(source = "channel.value.salesRepCd", target = "application.serviceRepresentativeId")
	
	@Mapping(target = "application.sourceCurrencyCode", constant="CAD")
	@Mapping(target = "application.targetCurrencyCode", constant="124")
	@Mapping(target = "application.currencyConversionRate", constant="1.0f")
	
	@Mapping(source="fraudCheckPerform", target = "application.applicationSectionTelco", qualifiedByName="mapApplicationSectionTelco" )
    
	ApplicationRequest basicMapping(FraudCheckPerform fraudCheckPerform); 
	
	
	
	/**
	 * based on excel sheet tab ApplicationSectionTelco and in that order
	 */
	default ApplicationSectionTelco applicationSectionTelcoMapping(FraudCheckPerform fraudCheckPerform) {
		 
		ApplicationSectionTelco applicationSectionTelco = new ApplicationSectionTelco(); 
		if (fraudCheckPerform ==null) {
			return applicationSectionTelco;
		}
		
		//typed data make mapping easy
		
		TelusBillingAccount account = null;
		TelusCreditProfile creditProfile = null;
		TelusChannel channel = null;
		
		if (fraudCheckPerform.getCustomer()!=null && fraudCheckPerform.getCustomer().getValue()!=null) {
			Customer customer = fraudCheckPerform.getCustomer().getValue();
			
			if (customer.getAccount()!=null && !customer.getAccount().isEmpty() && customer.getAccount().get(0).getValue()!=null) {
				account = (TelusBillingAccount)customer.getAccount().get(0).getValue();
			}
			if (customer.getCreditProfile()!=null && !customer.getCreditProfile().isEmpty() && 
					customer.getCreditProfile().get(0)!=null && customer.getCreditProfile().get(0).getValue()!=null) {
				
				creditProfile = (TelusCreditProfile)customer.getCreditProfile().get(0).getValue();
			}
		}
		
		if (fraudCheckPerform.getChannel()!=null && fraudCheckPerform.getChannel().getValue()!=null) {
			channel = fraudCheckPerform.getChannel().getValue();
		}
		//in non user-data section
		presetNonUserData (channel, account, applicationSectionTelco);
		
		//set user-data section
		ApplicationSectionTelcoUserData applicationSectionTelcoUserData = new ApplicationSectionTelcoUserData();
		updateApplicationSectionTelcoUserData (account,  creditProfile, channel, applicationSectionTelcoUserData);
		applicationSectionTelco.getUserData().addAll(this.toAFMUserDataList(applicationSectionTelcoUserData));
		
		return applicationSectionTelco;
		
	}
	
	//
	//
	//From ApplicationSectionTelco tab in mapping excel doc expression="java(Helper.asString(s.isNew())
	@Mapping(target = "id", ignore = true)
	//@Mapping(target="id",  expression="java(null)") to fix Several possible source properties for target property "id"
	@Mapping(target="packageType", source="account", qualifiedByName="derivePackageType")
	@Mapping(target="dealerCode", source="channel.dealerCode")
	@Mapping(target = "monthlyFee", expression="java(new java.math.BigDecimal(\"99.99\"))")
	@Mapping(target = "handsetValue", expression="java(new java.math.BigDecimal(\"999.99\"))")
	void presetNonUserData(TelusChannel channel, TelusBillingAccount account, @MappingTarget ApplicationSectionTelco applicationSectionTelco);
	 
	//
	//Update with user data kvs as utility bean  ApplicationSectionTelcoUserData properties
	//
	
	@Mapping(source="account.accountTypeCd", target="acctTypCd")
	@Mapping(source="account.accountSubTypeCd", target="acctSubTyp")
	//applicationMethod stops invalid ApplicationMethod already, no need to validate here again; changed to use raw value
	@Mapping(source="channel.channelTypeCd", target="channel")
	@Mapping(source="account.pin", target="accPassword")
	@Mapping(source="account.accountStatusCd", target="acctStatCd")
	@Mapping(source="account.accountStatusDate", target="acctStatDt", qualifiedByName="offsetDateTimeToString")
	@Mapping(source="account.creditDecisioningResult.value.decisionKeys.accountTenureCd", target="acctTenureCd")
	@Mapping(source="account.warningApproval.approvalDate", target="apprvlDt", qualifiedByName="offsetDateTimeToString")
	
	@Mapping(source="account.creditDecisioningResult.value.creditAssessmentSubType", target="carSubtypCd")
	@Mapping(source="account.creditDecisioningResult.value.creditAssessmentType", target="carTypCd")
	@Mapping(source="channel.channelOrganizationId", target="chnlOrgCd")
	@Mapping(source="account.creditDecisioningResult.value.clpExistingMatchingAccountInd", target="clpMatchingAcctInd")
	@Mapping(source="account.creditDecisioningResult.value.decisionKeys.collectionHistoryValueCd", target="collHistValCd")
	@Mapping(source="creditProfile.creditClassCd", target="creditClassCd")
	@Mapping(source="creditProfile.creditDecisionCd", target="creditDecsnCd")
	@Mapping(source="creditProfile.creditProgramName", target="crdPrgmNmCd")
	@Mapping(source="account.creditBureauResult.adjudicationResult.creditClassCd", target="cbCreditClass")
	@Mapping(source="account.dealerRepCode", target="dealerRepCode")
	@Mapping(source="account.creditDecisioningResult.value.decisionKeys.wlsDelinquentInd", target="delinqInd")
	@Mapping(source="account.creditDecisioningResult.value.decisionKeys.ficoAccountStatusCd", target="ficoAcctStatCd")
	@Mapping(source="account.creditDecisioningResult.value.decisionKeys.refcApprovalGrantedInd", target="refcApprvlGrantedInd")
	@Mapping(source="account.creditDecisioningResult.value.decisionKeys.refcFlagInd", target="refcFlgInd")
	@Mapping(source="account.revenueBandCd", target="revBandCd")
	@Mapping(source="creditProfile.riskLevelDecisionCd", target="riskLvlDecsnCd")
	@Mapping(source="creditProfile.riskLevelNumber", target="riskLvlNum")
	@Mapping(source="creditProfile.averageSecurityDepositList", target="securDepAmt")
	@Mapping(source="account.totalRequestedProductCount", target="totalReqSubNum")
	@Mapping(source="account.totalExistingProductCount", target="totalExistSubNum")
	@Mapping(source="account.totalProductCount", target="totalSubNum")
	@Mapping(source="account.creditDecisioningResult.value.decisionKeys.validDepositOverrideInd", target="validDepOvrdInd")
	@Mapping(source="account.warningApproval.approvalDate", target="warnApprovDt", qualifiedByName="offsetDateTimeToString")
	@Mapping(source="account.warningApproval.approvalExistInd", target="warnApprovInd")

	@Mapping(source="account.creditDecisioningResult.value.warnings", target="warningList", qualifiedByName="populateWarnings")
	
	@Mapping(source="account.creditBureauResult.riskIndicator.writeOffCd", target="wrtOffCd")
	

	void updateApplicationSectionTelcoUserData(TelusBillingAccount account, 
			TelusCreditProfile creditProfile, 
			TelusChannel channel, 
			@MappingTarget  ApplicationSectionTelcoUserData applicationSectionTelcoUserData);
	
	default List<Warning>populateWarnings(List<TelusCreditDecisioningWarning> tfmWarnings) {
		
		List<Warning> resultList = new ArrayList<>();
		if (tfmWarnings == null || tfmWarnings.isEmpty()) {
			return resultList;
		}
		for (TelusCreditDecisioningWarning tfmWarning: tfmWarnings) {
			Warning afmWarning = new Warning();
			afmWarning.setWarnCatgyCd(tfmWarning.getWarningCategoryCd());
			afmWarning.setWarnCd(tfmWarning.getWarningCd());
			afmWarning.setWarnTypeCd(tfmWarning.getWarningTypeCd());
			afmWarning.setWarnDetectionDt(offsetDateTimeToString(tfmWarning.getWarningDetectionDate()));
			afmWarning.setWarnItemTypeCd(tfmWarning.getWarningItemTypeCd());
			afmWarning.setWarnStatCd(tfmWarning.getWarningStatusCd());
			resultList.add(afmWarning);
		}
		
		return resultList;
		
	}
	
	@Named("derivePackageType")
	default PackageType derivePackageType(TelusBillingAccount account) {
		String typeSubTypeCd = safe(account.getAccountTypeCd()) + safe(account.getAccountSubTypeCd());
		return  PackageTypeUtil.derivePackageType(typeSubTypeCd.toUpperCase());
	}
	
	default String safe(String value) {
		return (value==null) ? "" : value.trim().toString();
	}


}