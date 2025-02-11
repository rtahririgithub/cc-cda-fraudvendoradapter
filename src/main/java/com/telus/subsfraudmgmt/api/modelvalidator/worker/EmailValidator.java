package com.telus.subsfraudmgmt.api.modelvalidator.worker;

import java.util.ArrayList;
import java.util.List;

import com.telus.subsfraudmgmt.api.model.ContactMedium;
import com.telus.subsfraudmgmt.api.model.Individual;
import com.telus.subsfraudmgmt.api.modelvalidator.TfmValidator;

/**
 * Validate the Email portion of a <code>ContactMedium</code>
 * <p>Based on Email tab in mapping document
 * @author Harry Xu
 *
 */
public class EmailValidator implements TfmValidator<ContactMedium> {

	public static final EmailValidator INSTANCE = new EmailValidator();

	private EmailValidator() {

	}

	@Override
	public List<String> validate(ContactMedium ContactMedium) {
		List<String> list = new ArrayList<>();
        //no validation needed
		return list;
	}
}
