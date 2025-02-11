package com.telus.subsfraudmgmt.api.modelvalidator.worker;

import java.util.ArrayList;
import java.util.List;

import com.telus.subsfraudmgmt.api.model.ContactMedium;
import com.telus.subsfraudmgmt.api.model.Individual;
import com.telus.subsfraudmgmt.api.modelvalidator.TfmValidator;

/**
 * Validate the Phone portion of a <code>ContactMedium</code>
 * <p>Based on Phone tab in mapping document
 * @author Harry Xu
 *
 */
public class PhoneValidator implements TfmValidator<ContactMedium> {

	public static final PhoneValidator INSTANCE = new PhoneValidator();

	private PhoneValidator() {

	}

	@Override
	public List<String> validate(ContactMedium ContactMedium) {
		List<String> list = new ArrayList<>();
        //no validation needed
		return list;
	}
}
