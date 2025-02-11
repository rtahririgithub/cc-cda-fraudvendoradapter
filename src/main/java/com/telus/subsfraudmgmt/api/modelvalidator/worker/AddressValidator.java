package com.telus.subsfraudmgmt.api.modelvalidator.worker;

import java.util.ArrayList;
import java.util.List;

import com.telus.subsfraudmgmt.api.model.ContactMedium;
import com.telus.subsfraudmgmt.api.model.MediumCharacteristic;
import com.telus.subsfraudmgmt.api.modelvalidator.TfmValidator;

/**
 * Validate the Address portion of a <code>Customer</code>
 * <p>Based on Address tab in mapping document
 * @author Harry Xu
 *
 */
public class AddressValidator implements TfmValidator<ContactMedium> {

	public static final AddressValidator INSTANCE = new AddressValidator();

	private AddressValidator() {

	}

	@Override
	public List<String> validate(ContactMedium contactMedium) {
		List<String> list = new ArrayList<>();
		
		MediumCharacteristic mediumCharacteristic = null;
		try {
			mediumCharacteristic = contactMedium.getCharacteristic();
			mediumCharacteristic.getCity();
		}catch (RuntimeException e) {
			list.add("contactMedium.getCharacteristic() is missing!");
			return list;
		}
	 
		if (isNullOrEmpty(mediumCharacteristic.getCity())) {
			list.add("contactMedium.getCharacteristic().getCity() is null or empty!");
		}
		if (isNullOrEmpty(mediumCharacteristic.getPostCode())) {
			list.add("contactMedium.getCharacteristic().getPostCode() is null or empty!");
		}
		if (isNullOrEmpty(mediumCharacteristic.getCountry())) {
			list.add("contactMedium.getCharacteristic().getCountry() is null or empty!");
		}
		return list;
	}
}
