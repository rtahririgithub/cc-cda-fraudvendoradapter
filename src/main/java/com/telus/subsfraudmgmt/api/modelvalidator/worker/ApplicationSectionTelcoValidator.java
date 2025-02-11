package com.telus.subsfraudmgmt.api.modelvalidator.worker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fico.afm.model.application.types.ApplicationMethod;
import com.telus.subsfraudmgmt.api.model.Customer;
import com.telus.subsfraudmgmt.api.model.FraudCheckPerform;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccount;
import com.telus.subsfraudmgmt.api.model.TelusChannel;
import com.telus.subsfraudmgmt.api.model.TelusCreditDecisioningResult;
import com.telus.subsfraudmgmt.api.model.TelusCreditDecisioningResultDecisionKeys;
import com.telus.subsfraudmgmt.api.model.TelusCreditProfile;
import com.telus.subsfraudmgmt.api.modelvalidator.TfmValidator;

/**
 * Validate the ApplicationSectionTelco portion of a <code>FraudCheckPerform</code>
 * <p>
 * Based on ApplicationSectionTelco tab in mapping document
 * <p>
 * Warning: this has to be run under FraudCheckPerformValidator to have
 * <code>Customer</code>, <code>Individual</code>, <code>TelusBillingAccount</code>,  <code>Channel</code>verified not null.
 * 
 * @author Harry Xu
 *
 */
public class ApplicationSectionTelcoValidator implements TfmValidator<FraudCheckPerform> {
	
	public static final ApplicationSectionTelcoValidator INSTANCE = new ApplicationSectionTelcoValidator();

	private ApplicationSectionTelcoValidator() {

	}

	@Override
	public List<String> validate(FraudCheckPerform fraudCheckPerform) {
		List<String> list = new ArrayList<>();
		
		TelusChannel channel = null;
		try {
			channel= fraudCheckPerform.getChannel().getValue();
			if (channel ==null) {
				list.add("fraudCheckPerform.channel.value is null!");
				return list;
			}
		}catch (RuntimeException e) {
			list.add("fraudCheckPerform.channel.value is missing!");
			return list;
		}
		
		if (this.isNullOrEmpty(channel.getDealerCode())) {
			list.add("fraudCheckPerform.channel.dealerCode is null or empty!");
		}
		//remove validation since it could be null
		//if (this.isNullOrEmpty(channel.getChannelOrganizationId())) {
		//	list.add("fraudCheckPerform.channel.channelOrganizationId is null or empty!");
		//}
		
		TelusBillingAccount account = (TelusBillingAccount)fraudCheckPerform.getCustomer().getValue().getAccount().get(0).getValue();
		 
		if (this.isNullOrEmpty(account.getAccountTypeCd())) {
			list.add("fraudCheckPerform.customer.account.accountTypeCd is null or empty!");
		}
		if (this.isNullOrEmpty(account.getAccountSubTypeCd())) {
			list.add("fraudCheckPerform.customer.account.acountSubTypeCd( is null or empty!");
		}
		if (account.getAccountStatusDate()==null) {
			list.add("fraudCheckPerform.customer.account.accountStatusDate is null!");
		}
		if (account.getTotalRequestedProductCount()==null) {
			list.add("fraudCheckPerform.customer.account.totalRequestedProductCount is null!");
		}
		if (account.getTotalExistingProductCount()==null) {
			list.add("fraudCheckPerform.customer.account.totalExistingProductCount is null!");
		}
		//sum of total Active, Reserve,Suspended Subscribers and Requested and Pending Subscribers
		if (account.getTotalProductCount()==null) {
			list.add("fraudCheckPerform.customer.account.totalProductCount is null!");
		}
		
		
		
		TelusCreditDecisioningResultDecisionKeys decisionKeys = null;
		try {
			decisionKeys= account.getCreditDecisioningResult().getValue().getDecisionKeys();
			if (decisionKeys ==null) {
				list.add("fraudCheckPerform.customer.account.creditDecisioningResult.value.decisionKeys is null!");
				return list;
			}
		}catch (RuntimeException e) {
			list.add("fraudCheckPerform.customer.account.creditDecisioningResult.value.decisionKeys is missing!");
			return list;
		}
	 
		TelusCreditDecisioningResult decisionResult = account.getCreditDecisioningResult().getValue();
		
		if (this.isNullOrEmpty(decisionKeys.getAccountTenureCd())) {
			list.add("fraudCheckPerform.customer.account.creditDecisioningResult.value.decisionKeys.accountTenureCd is null or empty!");
		}
		if (decisionKeys.isWlsDelinquentInd()==null) {
			list.add("fraudCheckPerform.customer.account.creditDecisioningResult.value.decisionKeys.wlsDelinquentInd is null!");
		}
		if (this.isNullOrEmpty(decisionKeys.getFicoAccountStatusCd())) {
			list.add("fraudCheckPerform.customer.account.creditDecisioningResult.value.decisionKeys.ficoAccountStatusCd is null or empty!");
		}
		if (this.isNullOrEmpty(decisionKeys.getRefcFlagInd())) {
			list.add("fraudCheckPerform.customer.account.creditDecisioningResult.value.decisionKeys.refcFlagInd is null or empty!");
		}
		if (this.isNullOrEmpty(decisionResult.getCreditAssessmentType())) {
			list.add("fraudCheckPerform.customer.account.creditDecisioningResult.value.creditAssessmentType is null or empty!");
		}
		if (this.isNullOrEmpty(decisionResult.getCreditAssessmentSubType())) {
			list.add("fraudCheckPerform.customer.account.creditDecisioningResult.value.creditAssessmentSubType is null or empty!");
		}
		
		Customer customer = fraudCheckPerform.getCustomer().getValue();
		
		TelusCreditProfile creditProfile  = null;
		try {
			creditProfile= (TelusCreditProfile) customer.getCreditProfile().get(0).getValue();
			if (creditProfile ==null) {
				list.add("fraudCheckPerform.customer.creditprofile.0.value is null!");
				return list;
			}
		}catch (RuntimeException e) {
			list.add("fraudCheckPerform.customer.creditprofile.0.value is missing or not type of TelusCreditProfile!");			
			return list;
		}
		if (this.isNullOrEmpty(creditProfile.getCreditClassCd())) {
			list.add("fraudCheckPerform.customer.creditprofile.0.value.creditClassCd is null or empty!");
		}
		
		if (this.isNullOrEmpty(creditProfile.getCreditProgramName())) {
			list.add("fraudCheckPerform.customer.creditprofile.0.value.creditProgramName is null or empty!");
		}
		
		
		return list;
	}
}
