package com.telus.subsfraudmgmt.api.modelvalidator;

import java.util.ArrayList;
import java.util.List;
import com.telus.subsfraudmgmt.api.model.FraudActivityUpdate;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.FraudDispositionValidator;

public class FraudActivityUpdateValidator implements TfmValidator<FraudActivityUpdate> {
	
	public static final FraudActivityUpdateValidator INSTANCE = new FraudActivityUpdateValidator();

	private FraudActivityUpdateValidator() {

	}
	@Override
	public List<String> validate(FraudActivityUpdate fraudActivityUpdate) {
		
		List<String> errorMessages = new ArrayList<>();
		if (fraudActivityUpdate ==null) {
			errorMessages.add("fraudActivityUpdate is null!");
			return errorMessages;
		}
		
		if (this.isNullOrEmpty(fraudActivityUpdate.getExternalApplicationId())) {
			errorMessages.add("fraudActivityUpdate.externalApplicationId is null or empty!");
		}
		if (this.isNullOrEmpty(fraudActivityUpdate.getExternalCreditAssessmentId())) {
			errorMessages.add("fraudActivityUpdate.externalCreditAssessmentId is null or empty!");
		}
		if (fraudActivityUpdate.getFraudDisposition() ==null) {
			errorMessages.add("fraudActivityUpdate.fraudDisposition() is null!");
		}
		else {
			errorMessages.addAll(FraudDispositionValidator.INSTANCE.validate(fraudActivityUpdate.getFraudDisposition()));  
		}
	
		
		return errorMessages;
	}
}
