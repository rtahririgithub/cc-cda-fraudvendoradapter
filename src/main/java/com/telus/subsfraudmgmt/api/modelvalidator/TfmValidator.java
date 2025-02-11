package com.telus.subsfraudmgmt.api.modelvalidator;

import java.util.List;
/**
 * Abstraction of tfm validation of the input
 * @author Harry Xu
 *
 * @param <T> the type parameter
 */
public interface TfmValidator<T> {
	/**
	 * validate certain properties of an instance of type parameter <code>T</code>
	 * @param t the generic type parameter
	 * @return the error message list if there are validation errors, empty otherwise.
	 */
	List<String> validate(T t);
	
	default boolean isNullOrEmpty(String string) {
		return (string==null) || (string.trim().isEmpty());
	}

}
