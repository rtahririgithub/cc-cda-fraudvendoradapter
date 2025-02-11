package com.telus.subsfraudmgmt.springboot.model.namingstrategy;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
/**
 * AFM uses Upper case key names for BureauReport classes in com.fico.afm.model.application.cdac package.
 * @author Harry Xu
 *
 */
public class AFMParsedResponseUppercaseAwareNameStrategy extends PropertyNamingStrategy {
	
	private static final String COM_FICO_AFM_MODEL_APPLICATION_CDAC = "com.fico.afm.model.application.cdac";

	public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
		return resolveJsonKeyName(field.getDeclaringClass(), defaultName);

	}

	/**
	 * starts with upper case instead of lower case.
	 */
	private String toUpperCamelCase(String defaultName) {
		return Character.toUpperCase(defaultName.charAt(0)) + defaultName.substring(1);
	}

	@Override
	public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
		return resolveJsonKeyName(method.getDeclaringClass(), defaultName);

	}

	@Override
	public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
		return resolveJsonKeyName(method.getDeclaringClass(), defaultName);

	}

	
	/**
	 * 
	 * Resolve json key name
	 * 
	 * @param clazz the classes that the field or method is declared
	 * @param defaultName - jackson generated name
	 * @return the correct property name
	 * 
	 */
	private String resolveJsonKeyName(Class<?> clazz, String defaultName) {
		if (clazz.getName().startsWith(COM_FICO_AFM_MODEL_APPLICATION_CDAC)) {
			return toUpperCamelCase(defaultName);
		}

		return defaultName;

	}

	/**
	 * get all fields from class
	 * 
	 * @param currentClass - should not be null
	 * @return fields from the currentClass and its superclass
	 * 
	 */
	public List<Field> getAllFields(Class<?> currentClass) {
		List<Field> flds = new ArrayList<>();
		while (currentClass != null) {
			Field[] fields = currentClass.getDeclaredFields();
			Collections.addAll(flds, fields);
			if (currentClass.getSuperclass() == null) {
				break;
			}
			currentClass = currentClass.getSuperclass();
		}
		return flds;
	}

}

