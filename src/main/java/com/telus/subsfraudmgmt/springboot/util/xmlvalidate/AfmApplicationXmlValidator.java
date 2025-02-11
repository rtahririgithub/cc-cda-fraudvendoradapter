package com.telus.subsfraudmgmt.springboot.util.xmlvalidate;

import java.io.StringWriter;
import java.util.List;
import org.w3c.dom.Document;

/**
 * General interface to abstract validation based on classpath based schema
 * application.xsd and its sub schemas.
 * 
 * @author Harry Xu
 * 
 */
public interface AfmApplicationXmlValidator {

	public Document validateAfmApplicationXml(StringWriter stringWriter, XmlParsingErrorHandler errorHandler)
			throws AfmApplicationValidatorException;

	@SuppressWarnings("serial")
	public static class AfmApplicationValidatorException extends Exception {
		private List<String> errors;

		public List<String> getValidationErrors() {
			return errors;
		}

		public AfmApplicationValidatorException(List<String> errors) {
			this.errors = errors;
		}
		@Override
		public String toString() {
			return "AfmApplicationValidatorException[" + errors +"]";
		}
	}

}
