package com.telus.subsfraudmgmt.springboot.model.transaction;

import com.telus.subsfraudmgmt.api.model.watson.Error;
import com.telus.subsfraudmgmt.api.model.watson.Prediction;
import com.telus.subsfraudmgmt.api.model.watson.PredictionPerform;
import com.telus.subsfraudmgmt.springboot.model.request.TApplicationRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TApplicationResponse;
import com.telus.subsfraudmgmt.springboot.model.response.TPredictionResponse;

public class FraudCheckTransaction extends BaseTransaction{
	private long accountId;
	private TApplicationRequest trequest;
	private TApplicationResponse tresponse; 
	
	//private PredictionPerform watsonSimulatorRequest;
	//private Object fraudPredictionResponse; 
	//private Prediction watsonSimulatorResponse;
	
	//Fraud AI response
	private Prediction fraudPredictionResponse;
	//Fraud AI request
	private PredictionPerform fraudPredictionRequest;
	
	private TPredictionResponse predictionResponse;

	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public TApplicationRequest getTrequest() {
		return trequest;
	}
	public void setTrequest(TApplicationRequest trequest) {
		this.trequest = trequest;
	}
	public TApplicationResponse getTresponse() {
		return tresponse;
	}
	public void setTresponse(TApplicationResponse tresponse) {
		this.tresponse = tresponse;
	}
	/*
	public PredictionPerform getWatsonSimulatorRequest() {
		return watsonSimulatorRequest;
	}
	public void setWatsonSimulatorRequest(PredictionPerform watsonSimulatorRequest) {
		this.watsonSimulatorRequest = watsonSimulatorRequest;
	}
	public Object getFraudPredictionResponse() {
		return fraudPredictionResponse;
	}
	public void setFraudPredictionResponse(Object fraudPredictionResponse) {
		this.fraudPredictionResponse = fraudPredictionResponse;
	}
	public Prediction getWatsonSimulatorResponse() {
		return watsonSimulatorResponse;
	}
	public void setWatsonSimulatorResponse(Prediction watsonSimulatorResponse) {
		this.watsonSimulatorResponse = watsonSimulatorResponse;
	}
	*/
	/**
	 * @return the predictionResponse
	 */
	public TPredictionResponse getPredictionResponse() {
		return predictionResponse;
	}
	/**
	 * @param predictionResponse the predictionResponse to set
	 */
	public void setPredictionResponse(TPredictionResponse predictionResponse) {
		this.predictionResponse = predictionResponse;
	}
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
	 * @return the fraudPredictionRequest
	 */
	public PredictionPerform getFraudPredictionRequest() {
		return fraudPredictionRequest;
	}
	/**
	 * @param fraudPredictionRequest the fraudPredictionRequest to set
	 */
	public void setFraudPredictionRequest(PredictionPerform fraudPredictionRequest) {
		this.fraudPredictionRequest = fraudPredictionRequest;
	}
	
}
