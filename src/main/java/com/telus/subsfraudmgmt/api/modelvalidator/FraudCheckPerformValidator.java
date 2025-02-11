package com.telus.subsfraudmgmt.api.modelvalidator;

import java.util.ArrayList;
import java.util.List;

import com.telus.subsfraudmgmt.api.model.ContactMedium;
import com.telus.subsfraudmgmt.api.model.Customer;
import com.telus.subsfraudmgmt.api.model.FraudCheckPerform;
import com.telus.subsfraudmgmt.api.model.Individual;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.ApplicantValidator;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.ApplicationDetailsValidator;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.ApplicationHeaderValidator;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.ApplicationSectionTelcoValidator;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.EmailValidator;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.NameValidator;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.PhoneValidator;

/**
 * FraudCheckPerform validator
 * @author Harry Xu
 *
 */
public class FraudCheckPerformValidator implements TfmValidator<FraudCheckPerform> {
	
	public static final FraudCheckPerformValidator INSTANCE = new FraudCheckPerformValidator();

	private FraudCheckPerformValidator() {

	}
	@Override
	public List<String> validate(FraudCheckPerform fraudCheckPerform) {
		
		List<String> errorMessages = new ArrayList<>();
		if (fraudCheckPerform ==null) {
			errorMessages.add("fraundcheckPerform is null!");
			return errorMessages;
		}

		if (this.isNullOrEmpty(fraudCheckPerform.getExternalApplicationId())) {
			errorMessages.add("fraudCheckPerform.externalApplicationId is null or empty!");
		}
		if (this.isNullOrEmpty(fraudCheckPerform.getExternalCreditAssessmentId())) {
			errorMessages.add("fraudCheckPerform.externalCreditAssessmentId is null or empty!");
		}
		if (fraudCheckPerform.getApplicationDateTime()==null) {
			errorMessages.add("fraudCheckPerform.applicationDateTime is null!");
		}
		
		
		Customer customer = null;
		try {
			customer = fraudCheckPerform.getCustomer().getValue(); 
			if (customer ==null) {
				errorMessages.add("fraudCheckPerform.getCustomer().getValue() is null!");
				return errorMessages;
			}	
		}catch (RuntimeException e) {
			errorMessages.add("fraudCheckPerform.getCustomer().getValue() is missing!");
			return errorMessages;
		}
		
		Individual individual = null;
		try {
			individual =(Individual)customer.getEngagedParty().getValue();
			if (individual == null) {
				errorMessages.add("fraudCheckPerform.getCustomer().getEngagedParty().getValue() is null!");
				return errorMessages;
			}
			
		}catch (RuntimeException e) {
			errorMessages.add("fraudCheckPerform.getCustomer().getEngagedParty().getValue() is missing or not Individual type!");
			return errorMessages;
		}
			

		ContactMedium contactMedium = null;
		try {
			contactMedium = individual.getContactMedium().get(0).getValue();   
			if (contactMedium == null) {
				errorMessages.add("fraudCheckPerform.getCustomer().getEngagedParty().getValue().getContactMedium().get(0).getValue() is null!");
				return errorMessages;
			}
		} catch (RuntimeException e) {
			errorMessages.add("fraudCheckPerform.getCustomer().getEngagedParty().getValue().getContactMedium().get(0).getValue() is missing!");
			return errorMessages;
		}

		//Name, Phone, Email validation
		errorMessages.addAll(NameValidator.INSTANCE.validate(individual));
		errorMessages.addAll(PhoneValidator.INSTANCE.validate(contactMedium));
		errorMessages.addAll(EmailValidator.INSTANCE.validate(contactMedium));
		
		errorMessages.addAll(ApplicationHeaderValidator.INSTANCE.validate(fraudCheckPerform));
		//applicationDetails tab in mapping doc
		errorMessages.addAll(ApplicationDetailsValidator.INSTANCE.validate(fraudCheckPerform));
	    //Applicant tab
	    errorMessages.addAll(ApplicantValidator.INSTANCE.validate(customer));
	    //ApplicationSectionTelco tab
		errorMessages.addAll(ApplicationSectionTelcoValidator.INSTANCE.validate(fraudCheckPerform));
		
		
		return errorMessages;
	}
}
