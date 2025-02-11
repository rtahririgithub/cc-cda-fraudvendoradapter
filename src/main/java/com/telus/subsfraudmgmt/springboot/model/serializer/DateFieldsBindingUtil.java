package com.telus.subsfraudmgmt.springboot.model.serializer;
/**
 * Common functionality for serialization and deserialization.
 * @author Harry Xu
 *
 */
public class DateFieldsBindingUtil {

	// just yyyy-MM-dd or plus offset
	private static String[] DATE_ONLY_FIELDS = new String[] { "birthDate", "fromDate", "toDate", 
			"employerStartDate", "employerEndDate" }; 

	/**
	 * CHeck if a fieldName is in one the date fields by application.xsd, case.xsd
	 * 
	 * @param fieldName the field name to check 
	 * @return true if fieldName is a date only field in the sense that it is
	 *         xsd:date, not xsd:dateTime in xsd.
	 */
	public static boolean isDateOnlyField(String fieldName) {
		if (fieldName == null) {
			return false;
		}
		for (String listItem : DATE_ONLY_FIELDS) {
			if (fieldName.equalsIgnoreCase(listItem)) {
				return true;
			}
		}
		return false;
	}

}
