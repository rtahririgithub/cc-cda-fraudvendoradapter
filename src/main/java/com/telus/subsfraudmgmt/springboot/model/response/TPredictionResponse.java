package com.telus.subsfraudmgmt.springboot.model.response;

import com.telus.subsfraudmgmt.api.model.watson.Prediction;
import com.telus.subsfraudmgmt.api.model.watson.Error;

public class TPredictionResponse extends AbstractTfmBaseResponse { 
	
	//Fraud AI response
	private Prediction fraudPredictionResponse;
	
	//error
	private Error fraudPredictionResponseError;

	/**
	 * @return the fraudPredictionResponse
	 */
	public Prediction getFraudPredictionResponse() {
		return fraudPredictionResponse;
	}

	/**
	 * @param fraudPredictionResponse the fraudPredictionResponse to set
	 */
	public void setFraudPredictionResponse(Prediction fraudPredictionResponse) {
		this.fraudPredictionResponse = fraudPredictionResponse;
	}

	/**
	 * @return the fraudPredictionResponseError
	 */
	public Error getFraudPredictionResponseError() {
		return fraudPredictionResponseError;
	}

	/**
	 * @param fraudPredictionResponseError the fraudPredictionResponseError to set
	 */
	public void setFraudPredictionResponseError(Error fraudPredictionResponseError) {
		this.fraudPredictionResponseError = fraudPredictionResponseError;
	}


	
	
	

}
