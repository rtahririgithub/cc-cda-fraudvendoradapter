package com.telus.subsfraudmgmt.springboot.model;

import java.util.List;
/**
 * To hold validation error messages that is going to send to TFM service client.
 * @author Harry Xu
 *
 */
public class TFMInputValidationException extends Exception {

	private List<String> validationErrorMessages;
	
	public TFMInputValidationException() {
		super();
	}
	public TFMInputValidationException(String message) {
		super(message);
	}
	public TFMInputValidationException(String message, List<String> validationErrorMessages) {
		super(message);
		this.validationErrorMessages = validationErrorMessages;
	}
	
	public List<String> getValidationErrorMessages() {
		return validationErrorMessages;
	}
	public void setValidationErrorMessages(List<String> validationErrorMessages) {
		this.validationErrorMessages = validationErrorMessages;
	}
	
	
}
