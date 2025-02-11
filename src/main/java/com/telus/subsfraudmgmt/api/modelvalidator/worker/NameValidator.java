package com.telus.subsfraudmgmt.api.modelvalidator.worker;

import java.util.ArrayList;
import java.util.List;
import com.telus.subsfraudmgmt.api.model.Individual;
import com.telus.subsfraudmgmt.api.modelvalidator.TfmValidator;

/**
 * Validate the Name portion of a <code>Individual</code>
 * <p>Based on Name tab in mapping document
 * @author Harry Xu
 *
 */
public class NameValidator implements TfmValidator<Individual> {

	public static final NameValidator INSTANCE = new NameValidator();

	private NameValidator() {

	}

	@Override
	public List<String> validate(Individual individual) {
		List<String> list = new ArrayList<>();
		if (individual==null) {
			list.add("Individual is null!");
		}else {
			if (isNullOrEmpty(individual.getGivenName())) {
				list.add("Individual givenName is null or empty!");
			}
			if (isNullOrEmpty(individual.getFamilyName())) {
				list.add("Individual familyName is null or empty!");
			}
		}
		return list;
	}
}
