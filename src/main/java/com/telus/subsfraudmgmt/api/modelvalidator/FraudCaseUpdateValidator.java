package com.telus.subsfraudmgmt.api.modelvalidator;

import java.util.ArrayList;
import java.util.List;
import com.telus.subsfraudmgmt.api.model.FraudCaseUpdate;
import com.telus.subsfraudmgmt.api.modelvalidator.worker.FraudDispositionValidator;
/**
 * Fraudcase update validation
 * @author Harry Xu
 *
 */
public class FraudCaseUpdateValidator implements TfmValidator<FraudCaseUpdate> {
	
	public static final FraudCaseUpdateValidator INSTANCE = new FraudCaseUpdateValidator();

	private FraudCaseUpdateValidator() {

	}
	@Override
	public List<String> validate(FraudCaseUpdate fraudCaseUpdate) {
		
		List<String> errorMessages = new ArrayList<>();
		if (fraudCaseUpdate ==null) {
			errorMessages.add("fraudCaseUpdate is null!");
			return errorMessages;
		}
		
		if (this.isNullOrEmpty(fraudCaseUpdate.getExternalApplicationId())) {
			errorMessages.add("fraudCaseUpdate.externalApplicationId is null or empty!");
		}
		if (this.isNullOrEmpty(fraudCaseUpdate.getExternalCreditAssessmentId())) {
			errorMessages.add("fraudCaseUpdate.externalCreditAssessmentId is null or empty!");
		}
		if (fraudCaseUpdate.getFraudCase() == null) {
			errorMessages.add("fraudCaseUpdate.fraudCase is null!");
			return errorMessages;
		}else {
			if (fraudCaseUpdate.getFraudCase().getFraudDisposition() ==null) {
				errorMessages.add("fraudCaseUpdate.fraudCase.fraudDisposition is null!");
				return errorMessages;
			}else {
				errorMessages.addAll(FraudDispositionValidator.INSTANCE.validate(
						fraudCaseUpdate.getFraudCase().getFraudDisposition()));  
			}
		}
		
		return errorMessages;
	}
}
