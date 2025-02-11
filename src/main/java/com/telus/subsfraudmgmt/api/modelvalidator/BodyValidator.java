package com.telus.subsfraudmgmt.api.modelvalidator;

import java.util.ArrayList;
import java.util.List;

import com.telus.subsfraudmgmt.api.model.Body;
/**
 * Fraudster delete parameter validator
 * @author Harry Xu
 *
 */
public class BodyValidator implements TfmValidator<Body> {
	
	public static final BodyValidator INSTANCE = new BodyValidator();

	private BodyValidator() {

	}
	@Override
	public List<String> validate(Body body) {
		
		List<String> errorMessages = new ArrayList<>();
		if (body ==null) {
			errorMessages.add("Body is null!");
			return errorMessages;
		}
		
		if (this.isNullOrEmpty(body.getExternalApplicationId())) {
			errorMessages.add("Body.externalApplicationId is null or empty!");
		}
		if (this.isNullOrEmpty(body.getExternalCreditAssessmentId())) {
			errorMessages.add("Body.externalCreditAssessmentId is null or empty!");
		}
		 
		
		return errorMessages;
	}
}
