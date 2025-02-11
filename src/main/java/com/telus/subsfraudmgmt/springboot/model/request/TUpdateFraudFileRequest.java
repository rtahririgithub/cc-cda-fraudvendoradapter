package com.telus.subsfraudmgmt.springboot.model.request;

import com.fico.afm.model.application.Individual;

/**
 * Wrapper of the {@code updateFraudFile} parameters and request body.
 * 
 * @author Harry Xu
 *
 */
public class TUpdateFraudFileRequest extends AbstractTfmBaseRequest{
	/**
	 * parameter
	 */
	private String fraudFileId;
	private Individual individual;

	public String getFraudFileId() {
		return fraudFileId;
	}

	public void setFraudFileId(String fraudFileId) {
		this.fraudFileId = fraudFileId;
	}
	
	public Individual getIndividual() {
		return individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}


}
