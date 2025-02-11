package com.telus.subsfraudmgmt.api.modelvalidator.worker;

import java.util.ArrayList;
import java.util.List;

import com.telus.subsfraudmgmt.api.model.Individual;
import com.telus.subsfraudmgmt.api.modelvalidator.TfmValidator;

/**
 * Validate the Person portion of a <code>Individual</code>
 * <p>Based on Person tab in mapping document
 * @author Harry Xu
 *
 */
public class PersonValidator implements TfmValidator<Individual> {

	public static final PersonValidator INSTANCE = new PersonValidator();

	private PersonValidator() {

	}

	@Override
	public List<String> validate(Individual individual) {	
		List<String> list = new ArrayList<>();
		//Name
		if (isNullOrEmpty(individual.getGivenName())) {
			list.add("Individual.givenName is null or empty!");
		}
		if (isNullOrEmpty(individual.getFamilyName())) {
			list.add("Individual.familyName is null or empty!");
		}
		//birthDate are optional for new account
		//if (individual.getBirthDate()==null) {
		//	list.add("Individual.birthDate is null!");
		//}
		return list;
	}
}
