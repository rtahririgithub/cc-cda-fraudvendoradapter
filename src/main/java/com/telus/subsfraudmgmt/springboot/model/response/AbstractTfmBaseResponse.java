package com.telus.subsfraudmgmt.springboot.model.response;

import org.springframework.http.HttpStatus;

import com.telus.subsfraudmgmt.api.model.Error;
 

/**
 * To be extended to make every rest service response in our service contains a status.
 * 
 * @author Harry Xu
 *
 */
public abstract class AbstractTfmBaseResponse {
    /**
     * HttpStatus code from external rest services
     */
	private HttpStatus backendHttpStatus;

	/**
	 * If there is an error
	 */
	private Error error;

	public HttpStatus getBackendHttpStatus() {
		return backendHttpStatus;
	}

	public void setBackendHttpStatus(HttpStatus httpStatus) {
		this.backendHttpStatus = httpStatus;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
}
