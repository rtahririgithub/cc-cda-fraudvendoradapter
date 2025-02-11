package com.telus.subsfraudmgmt.springboot.model.response;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fico.afm.model.application.ApplicationResponse;
import com.telus.subsfraudmgmt.api.model.FraudCheck;

/**
 * Wrapper of {@code ApplicationResponse} response.
 * @author Harry Xu
 *
 */
@XmlRootElement(name = "TApplicationResponse")
public class TApplicationResponse extends AbstractTfmBaseResponse {
	/**
	 * AFM response
	 */
	private ApplicationResponse applicationResponse;
	
	/**
	 * The response return to caller
	 */
	private FraudCheck fraudCheck;

	public ApplicationResponse getApplicationResponse() {
		return applicationResponse;
	}

	public void setApplicationResponse(ApplicationResponse applicationResponse) {
		this.applicationResponse = applicationResponse;
	}

	public FraudCheck getFraudCheck() {
		return fraudCheck;
	}

	public void setFraudCheck(FraudCheck fraudCheck) {
		this.fraudCheck = fraudCheck;
	}
	
    
	
}
