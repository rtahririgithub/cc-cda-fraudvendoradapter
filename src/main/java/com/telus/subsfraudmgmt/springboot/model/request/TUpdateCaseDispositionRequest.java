package com.telus.subsfraudmgmt.springboot.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fico.afm.model.application.Disposition;
import com.telus.subsfraudmgmt.api.model.FraudCaseUpdate;

/**
 * Wrapper of the {@code updateCaseDisposition} parameters and request body.
 * 
 * @author Harry Xu
 *
 */
public class TUpdateCaseDispositionRequest extends AbstractTfmBaseRequest{
	/**
	 * applicationId to use to retrive case detail including caseId
	 */
	private String applicationId;
	/**
	 * The open api fraud case dispostion update request
	 */
	private FraudCaseUpdate FraudCaseUpdate; 
	/**
	 * the body 
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private Disposition disposition;
	
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String caseId) {
		this.applicationId = caseId;
	}
	public FraudCaseUpdate getFraudCaseUpdate() {
		return FraudCaseUpdate;
	}
	public void setFraudCaseUpdate(FraudCaseUpdate fraudCaseUpdate) {
		FraudCaseUpdate = fraudCaseUpdate;
	}
	public Disposition getDisposition() throws Exception{
		return disposition;
	}
	public void setDisposition(Disposition disposition) {
		this.disposition = disposition;
	}

	
}
