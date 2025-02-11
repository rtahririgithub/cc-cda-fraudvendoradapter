package com.telus.subsfraudmgmt.springboot.model;
/**
 * RuntimeException wrapper to make it compliant with api definition, but then allow
 * centralized exception handling via CustomizedControllerAdvice
 * @author Harry Xu
 *
 */
public class TfmControllerWrapperRuntimeException extends RuntimeException{

	public TfmControllerWrapperRuntimeException() {
		super();
	}
	
	public TfmControllerWrapperRuntimeException(String message) {
        super(message);
    }
	public TfmControllerWrapperRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public TfmControllerWrapperRuntimeException(Throwable cause) {
        super(cause);
    }
}
