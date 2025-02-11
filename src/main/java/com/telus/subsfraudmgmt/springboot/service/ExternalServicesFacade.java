package com.telus.subsfraudmgmt.springboot.service;


import com.telus.subsfraudmgmt.api.model.watson.PredictionPerform;
import com.telus.subsfraudmgmt.springboot.model.request.TApplicationRequest;
import com.telus.subsfraudmgmt.springboot.model.request.TCreateFraudFileRequest;
import com.telus.subsfraudmgmt.springboot.model.request.TDeleteFraudFileRequest;
import com.telus.subsfraudmgmt.springboot.model.request.TUpdateAppDispositionRequest;
import com.telus.subsfraudmgmt.springboot.model.request.TUpdateCaseDispositionRequest;
import com.telus.subsfraudmgmt.springboot.model.request.TUpdateFraudFileRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TApplicationResponse;
import com.telus.subsfraudmgmt.springboot.model.response.TFraudFileResponse;
import com.telus.subsfraudmgmt.springboot.model.response.TPredictionResponse;
import com.telus.subsfraudmgmt.springboot.model.response.TUpdateAppDispositionResponse;
import com.telus.subsfraudmgmt.springboot.model.response.TUpdateCaseDispositionResponse;
import com.telus.subsfraudmgmt.springboot.model.transaction.BaseTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.FraudCheckTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.UpdateAppDispositionTransaction;
/**
 * Facade to external services for easy consumption by controllers.
 * 
 * @author Harry Xu
 *
 */
public interface ExternalServicesFacade {
	/**
	 * perform Fraud Prediction by calling AI Fraud
	 * 
	 * @param predictionPerform {@code PredictionPerform} instance
	 * 
	 * @return {@code com.telus.subsfraudmgmt.api.model.watson.Prediction} instance
	 */
	public TPredictionResponse performFraudPrediction(PredictionPerform predictionPerform) throws Exception;
	/**
	 * Update application disposition
	 * 
	 * @param tUpdateAppDispositionRequest {@code TUpdateAppDispositionRequest}
	 *                                     instance
	 * @return {@code TUpdateAppDispositionResponse} instance
	 */
	TUpdateAppDispositionResponse updateAppDisposition(TUpdateAppDispositionRequest tUpdateAppDispositionRequest) throws Exception;
	
	/**
	 * Update application disposition
	 * 
	 * @param tApplicationRequest {@code TApplicationRequest}
	 *                                     instance
	 * @return {@code TApplicationResponse} instance
	 */
	TApplicationResponse performFraudCheck(TApplicationRequest tApplicationRequest) throws Exception;
	
	/**
	 * create fraufile to an individual
	 * 
	 * @param tCreateFraudFileRequest {@code TCreateFraudFileRequest}
	 *                                     instance
	 * @return {@code TFraudFileResponse} instance
	 */
	TFraudFileResponse createFraudFile(TCreateFraudFileRequest tCreateFraudFileRequest) throws Exception;

	/**
	 * update fraufile to an individual
	 * 
	 * @param tUpdateFraudFileRequest {@code TUpdateFraudFileRequest}
	 *                                     instance
	 * @return {@code TFraudFileResponse} instance
	 */
	TFraudFileResponse updateFraudFile(TUpdateFraudFileRequest tUpdateFraudFileRequest) throws Exception;

	/**
	 * delete fraufile to an individual
	 * 
	 * @param tDeleteFraudFileRequest {@code TDeleteFraudFileRequest}
	 *                                     instance
	 * @return {@code TFraudFileResponse} instance
	 */
	TFraudFileResponse deleteFraudFile(TDeleteFraudFileRequest tDeleteFraudFileRequest) throws Exception;
	
	/**
	 * Update case disposition
	 * 
	 * @param tUpdateCaseDispositionRequest {@code TUpdateCaseDispositionRequest}
	 *                                     instance
	 * @return {@code TUpdateCaseDispositionResponse} instance
	 */
	TUpdateCaseDispositionResponse updateCaseDisposition(TUpdateCaseDispositionRequest tUpdateCaseDispositionRequest) throws Exception;
	
	/**
	 * publish transaction
	 * 
	 * @param aTransaction {@code BaseTransaction} sub class instance
	 * @return {@code Status} instance
	 * @throws Exception if applicable
	 */
	void publishTransaction(BaseTransaction aTransaction) throws Exception;
	
	/**
	 * insert fraud check transaction to persistence store after getting back in TFMTopic listerner.
	 * 
	 * @param fraudCheckTransaction FraudCheckTransaction
	 *
	 */
	//void insertFraudCheckTransaction(FraudCheckTransaction fraudCheckTransaction);
	
	/**
	 * insert Update application transaction to persistence store 
	 * 
	 * @param updateAppDispositionTransaction update Application Disposition Transaction
	 *
	 */
	//void insertUpdateAppDispositionTransaction(UpdateAppDispositionTransaction updateAppDispositionTransaction);

}
