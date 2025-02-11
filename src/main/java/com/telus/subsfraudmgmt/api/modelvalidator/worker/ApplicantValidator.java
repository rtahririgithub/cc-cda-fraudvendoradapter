package com.telus.subsfraudmgmt.api.modelvalidator.worker;

import java.util.ArrayList;
import java.util.List;

import com.telus.subsfraudmgmt.api.model.Customer;
import com.telus.subsfraudmgmt.api.model.Individual;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccount;
import com.telus.subsfraudmgmt.api.modelvalidator.TfmValidator;

/**
 * Validate the Applicant portion of a <code>Customer</code>
 * <p>
 * Based on Applicant tab in mapping document
 * <p>
 * Warning: this has to be run under FraudCheckPerformValidator to have
 * <code>Individual</code>, <code>TelusBillingAccount</code> verified not null.
 * 
 * @author Harry Xu
 *
 */
public class ApplicantValidator implements TfmValidator<Customer> {

	public static final ApplicantValidator INSTANCE = new ApplicantValidator();

	private ApplicantValidator() {

	}

	@Override
	public List<String> validate(Customer customer) {
		List<String> list = new ArrayList<>();
        
		Individual individual =(Individual)customer.getEngagedParty().getValue();
		//birthDate are optional for new account
		//if (individual.getBirthDate()==null) {
		//	list.add("customer.individual.birthDate is null!");
		//}
		if (this.isNullOrEmpty(individual.getFullName())) {
			list.add("customer.individual.fullName is null or empty!");
		}
		
		TelusBillingAccount account = (TelusBillingAccount) customer.getAccount().get(0).getValue();
		
		if (account.getBillingAccountNumber()==null) {
			list.add("customer.account.billingAccountNumber is null!");
		}
		if (account.getAccountCreationDate()==null) {
			list.add("customer.account.accountCreationDate is null!");
		}
		if (account.getTotalMatchingAccountCount()==null) {
			list.add("customer.account.totalMatchingAccountCount is null!");
		}
		if (account.getTotalProductCountForAllMatchingAccounts()==null) {
			list.add("customer.account.totalProductCountForAllMatchingAccounts is null!");
		}
		
		//SIN, CC, DL, PASSPORT validation is not needed
		
		return list;
	}
}
