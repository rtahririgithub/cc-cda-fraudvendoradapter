package com.telus.subsfraudmgmt.springboot.util.xmlvalidate;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Xml parsing error handler to just log the error into a error message list to
 * be retrieved by parser caller.
 * 
 * @author Harry Xu
 *
 */
public class XmlParsingErrorHandler implements ErrorHandler {

	private List<String> errors = new ArrayList<>();

	private static List<String> IGNORABLE_ERROR_MESSAGE_LIST = new ArrayList<>();
	static {
		// IGNORABLE_ERROR_MESSAGE_LIST.add("Attribute 'expr' is not allowed to appear in element
		// 'audio'");
	}

	public List<String> getErrors() {
		return errors;
	}

	@Override
	public void warning(SAXParseException e) throws SAXException {
		if (ignorable(e)) {
			return;
		}
		addToErrorList("Warning", e);
		throw e;
	}

	/**
	 * Something we do not want to treat as error
	 */
	private boolean ignorable(SAXParseException e) {
		if (e.getMessage() == null) {
			return false;
		}

		for (String errorMsg : IGNORABLE_ERROR_MESSAGE_LIST) {
			if (e.getMessage().contains(errorMsg)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		if (ignorable(e)) {
			return;
		}
		addToErrorList("Error", e);
		throw e;
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		if (ignorable(e)) {
			return;
		}
		addToErrorList("Fatal Error", e);
		throw e;
	}

	private void addToErrorList(String type, SAXParseException e) {

		errors.add("------------------------------");
		errors.add(type + ": " + e.getMessage());
		errors.add("Line " + e.getLineNumber() + " Column " + e.getColumnNumber());
		errors.add("System ID: " + e.getSystemId());
		errors.add("------------------------------");
	}
}
