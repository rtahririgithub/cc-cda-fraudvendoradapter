package com.telus.subsfraudmgmt.springboot.model;

public class NoLinkedFraudFileException extends Exception {

	public NoLinkedFraudFileException() {
		super();
	}
	public NoLinkedFraudFileException(String message) {
		super(message);
	}
}
