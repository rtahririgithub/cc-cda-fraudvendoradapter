package com.telus.subsfraudmgmt.api.modelvalidator.worker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fico.afm.model.application.types.ApplicationMethod;
import com.telus.subsfraudmgmt.api.model.FraudCheckPerform;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccount;
import com.telus.subsfraudmgmt.api.model.TelusChannel;
import com.telus.subsfraudmgmt.api.modelvalidator.TfmValidator;

/**
 * Validate the ApplicationDetails portion of a <code>FraudCheckPerform</code>
 * <p>Based on ApplicationDetails tab in mapping document
 * @author Harry Xu
 *
 */
public class ApplicationDetailsValidator implements TfmValidator<FraudCheckPerform> {
	
	public static final ApplicationDetailsValidator INSTANCE = new ApplicationDetailsValidator(); 

	private ApplicationDetailsValidator() {

	}
	
	@Override
	public List<String> validate(FraudCheckPerform fraudCheckPerform) {
		List<String> list = new ArrayList<>();
		
		if (this.isNullOrEmpty(fraudCheckPerform.getExternalApplicationId())) {
			list.add("fraudCheckPerform externalApplicationId is null or empty!");
		}
		if (fraudCheckPerform.getApplicationDateTime() ==null) {
			list.add("fraudCheckPerform applicationDateTime is Null!");
		}
		
		TelusBillingAccount account = null;
		
		try {
			account = (TelusBillingAccount) fraudCheckPerform.getCustomer().getValue().getAccount().get(0).getValue();
			if (account == null) {
				list.add("customer.account is null!");
				return list;
			}
		}catch (RuntimeException e) {
			list.add("customer.account is missing or not TelusBillingAccount type!");
			return list;
		}
		if (account.getBillingAccountNumber()==null) {
			list.add("customer.account.billingAccountNumber is null!");
		}
		if (this.isNullOrEmpty(account.getBrandCd())) {
			list.add("customer.account.brandCd is null or empty!");
		}
		
		
		//optional
		TelusChannel channel =null;
		try {
			channel = fraudCheckPerform.getChannel().getValue();
			if (channel == null) {
				list.add("fraudCheckPerform.channel is null!");
				return list;
			}
		}catch (RuntimeException e) {
			list.add("fraudCheckPerform.channel is missing!");
			return list;
		}

		if (this.isNullOrEmpty(channel.getSalesRepCd())) {
			list.add("fraudCheckPerform.channel.salesRepCd is null or empty!");
			return list;
		}
		return list;
	}
}
