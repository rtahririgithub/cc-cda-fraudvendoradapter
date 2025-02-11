package com.telus.subsfraudmgmt.api.modelvalidator;

import java.util.ArrayList;
import java.util.List;

import com.telus.subsfraudmgmt.api.model.ContactMedium;
import com.telus.subsfraudmgmt.api.model.Customer;
import com.telus.subsfraudmgmt.api.model.FraudCheckPerform;
import com.telus.subsfraudmgmt.api.model.FraudsterCreate;
import com.telus.subsfraudmgmt.api.model.Individual;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.AddressValidator;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.ApplicantValidator;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.ApplicationDetailsValidator;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.ApplicationHeaderValidator;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.ApplicationSectionTelcoValidator;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.EmailValidator;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.NameValidator;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.PersonValidator;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.PhoneValidator;

/**
 * FraudCheckPerform validator
 * @author Harry Xu
 *
 */
public class FraudsterCreateValidator implements TfmValidator<FraudsterCreate> {
	
	public static final FraudsterCreateValidator INSTANCE = new FraudsterCreateValidator();

	private FraudsterCreateValidator() {

	}
	@Override
	public List<String> validate(FraudsterCreate fraudsterCreate) {
		
		List<String> errorMessages = new ArrayList<>();
		if (fraudsterCreate ==null) {
			errorMessages.add("fraudsterCreate is null!");
			return errorMessages;
		}
		if (this.isNullOrEmpty(fraudsterCreate.getExternalApplicationId())) {
			errorMessages.add("fraudsterCreate.externalApplicationId is null or empty!");
		}
		if (this.isNullOrEmpty(fraudsterCreate.getExternalCreditAssessmentId())) {
			errorMessages.add("fraudsterCreate.externalCreditAssessmentId is null or empty!");
		}
		 
	   
		Individual individual = null;
		try {
			individual =(Individual)fraudsterCreate.getIndividual().getValue();
			if (individual == null) {
				errorMessages.add("fraudsterCreate.getIndividual().getValue() is null!");
				return errorMessages;
			}
			
		}catch (RuntimeException e) {
			errorMessages.add("fraudsterCreate.getIndividual().getValue() is missing or not Individual type!");
			return errorMessages;
		}
		//this include name validator
		errorMessages.addAll(PersonValidator.INSTANCE.validate(individual));
    
        
		ContactMedium contactMedium = null;
		try {
			contactMedium = individual.getContactMedium().get(0).getValue();   
			if (contactMedium == null) {
				errorMessages.add("fraudsterCreate.getIndividual().getValue().getContactMedium().get(0).getValue() is null!");
				return errorMessages;
			}
		} catch (RuntimeException e) {
			errorMessages.add("fraudsterCreate.getIndividual().getValue().getContactMedium().get(0).getValue() is missing!");
			return errorMessages;
		}
		
		errorMessages.addAll(AddressValidator.INSTANCE.validate(contactMedium));
		//no validation at this moment
		errorMessages.addAll(PhoneValidator.INSTANCE.validate(contactMedium));
		errorMessages.addAll(EmailValidator.INSTANCE.validate(contactMedium));
		  
		return errorMessages;
	}
}
