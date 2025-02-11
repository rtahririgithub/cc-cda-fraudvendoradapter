package com.telus.subsfraudmgmt.api.modelvalidator.worker;

import java.util.ArrayList;
import java.util.List;

import com.telus.subsfraudmgmt.api.model.FraudCheckPerform;
import com.telus.subsfraudmgmt.api.modelvalidator.TfmValidator;

/**
 * Validate the ApplicationHeader portion of a <code>FraudCheckPerform</code>
 * <p>Based on ApplicationHeader tab in mapping document
 * @author Harry Xu
 *
 */
public class ApplicationHeaderValidator implements TfmValidator<FraudCheckPerform> {
	
	public static final ApplicationHeaderValidator INSTANCE = new ApplicationHeaderValidator();

	private ApplicationHeaderValidator() {

	}

	@Override
	public List<String> validate(FraudCheckPerform fraudCheckPerform) {
		List<String> list = new ArrayList<>();
	
		if (fraudCheckPerform.getApplicationDateTime() ==null) {
			list.add("fraudCheckPerform.applicationDateTime is Null!");
		}
	 
		return list;
	}
}
