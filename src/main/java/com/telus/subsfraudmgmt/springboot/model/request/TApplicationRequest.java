package com.telus.subsfraudmgmt.springboot.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fico.afm.model.application.ApplicationRequest;
import com.telus.subsfraudmgmt.api.model.FraudCheckPerform;

/**
 * Wrapper of the {@code ApplicationRequest} parameters and request body.
 * 
 * @author Harry Xu
 *
 */
public class TApplicationRequest extends AbstractTfmBaseRequest{
	
	/**
	 * should treat backend as xml, only set when we want to invoke backend with xml payload
	 */
	@JsonIgnore
	private boolean postXml;
	
	/**
	 * open api input, which will not be used to publish to telus pub sub thus marked as json ignore
	 */
	@JsonIgnore
	private FraudCheckPerform fraudCheckPerform;

	/**
	 * the body 
	 */
	private ApplicationRequest applicationRequest;

	public boolean isPostXml() {
		return postXml;
	}

	public void setPostXml(boolean postXml) {
		this.postXml = postXml;
	}

	public FraudCheckPerform getFraudCheckPerform() {
		return fraudCheckPerform;
	}
	
	//chain
	public TApplicationRequest fraudCheckPerform(FraudCheckPerform fraudCheckPerform) {
		this.setFraudCheckPerform(fraudCheckPerform);
		return this;
	}

	public void setFraudCheckPerform(FraudCheckPerform fraudCheckPerform) {
		this.fraudCheckPerform = fraudCheckPerform;
	}

	public ApplicationRequest getApplicationRequest() {
		return applicationRequest;
	}

	public void setApplicationRequest(ApplicationRequest applicationRequest) {
		this.applicationRequest = applicationRequest;
	}

 
}
