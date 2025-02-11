package com.telus.subsfraudmgmt.springboot.model;

public class NoCaseExistException extends Exception {

	public NoCaseExistException() {
		super();
	}
	public NoCaseExistException(String message) {
		super(message);
	}
}
