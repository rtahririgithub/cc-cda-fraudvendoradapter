package com.telus.subsfraudmgmt.springboot.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fico.afm.model.application.Individual;
import com.telus.subsfraudmgmt.api.model.FraudsterCreate;
/**
 * Wrapper of the {@code CreateFraudFile} parameters and request body.
 * 
 * @author Harry Xu
 *
 */
public class TCreateFraudFileRequest extends AbstractTfmBaseRequest{
	/**
	 * open api input, which will not be used to publish to telus pub sub thus marked as json ignore
	 */
	@JsonIgnore
	private FraudsterCreate FraudsterCreate;
	
    /**
     * AFM input
     */
	private Individual individual;
	
	public FraudsterCreate getFraudsterCreate() {
		return FraudsterCreate;
	}

	public void setFraudsterCreate(FraudsterCreate fraudsterCreate) {
		FraudsterCreate = fraudsterCreate;
	}

	public Individual getIndividual() {
		return individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}

}
