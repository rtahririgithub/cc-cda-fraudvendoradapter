package com.telus.subsfraudmgmt.springboot.model;

public class ApplicationNotExistException extends Exception {

	public ApplicationNotExistException() {
		super();
	}
	public ApplicationNotExistException(String message) {
		super(message);
	}
}
