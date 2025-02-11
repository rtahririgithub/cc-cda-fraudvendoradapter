package com.telus.subsfraudmgmt.springboot.model.request;

/**
 * Base class of all incoming request.
 * 
 * @author Harry Xu
 *
 */
public abstract class AbstractTfmBaseRequest {
	/**
	 * rest request parameter 
	 */
	private String requestId;
	
	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

}
