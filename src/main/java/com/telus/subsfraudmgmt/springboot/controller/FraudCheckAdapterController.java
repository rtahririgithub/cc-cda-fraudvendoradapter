package com.telus.subsfraudmgmt.springboot.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fico.afm.model.application.ApplicationRequest;
import com.fico.afm.model.application.ApplicationResponse;
import com.fico.afm.model.application.Error;
import com.telus.subsfraudmgmt.api.model.FraudCheck;
import com.telus.subsfraudmgmt.api.model.FraudCheckDecisioningError;
import com.telus.subsfraudmgmt.api.model.FraudCheckPerform;
import com.telus.subsfraudmgmt.api.model.Individual;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccount;
import com.telus.subsfraudmgmt.api.model.watson.PredictionPerform;
import com.telus.subsfraudmgmt.api.model.watson.PredictionPerformInputData;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.FraudCheckPerformAggregateMapper;
import com.telus.subsfraudmgmt.springboot.RequestId;
import com.telus.subsfraudmgmt.springboot.config.Config;
import com.telus.subsfraudmgmt.springboot.controller.ControllerHelper.PreProcessResult;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLog;
import com.telus.subsfraudmgmt.springboot.model.TfmControllerWrapperRuntimeException;
import com.telus.subsfraudmgmt.springboot.model.request.TApplicationRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TApplicationResponse;
import com.telus.subsfraudmgmt.springboot.model.response.TPredictionResponse;
import com.telus.subsfraudmgmt.springboot.model.transaction.FraudCheckTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.TransactionSubType;
import com.telus.subsfraudmgmt.springboot.model.transaction.TransactionType;
import com.telus.subsfraudmgmt.springboot.service.ExternalServicesFacade;
import com.telus.subsfraudmgmt.springboot.service.MaskingService;
import com.telus.subsfraudmgmt.springboot.service.refpds.TFMRefPDSFacade;
import com.telus.subsfraudmgmt.springboot.util.GeneralUtil;
import com.telus.subsfraudmgmt.springboot.util.JsonUtil;
import com.telus.subsfraudmgmt.springboot.util.LogUtil;
/**
 * FraudCheck Adapter to allow FraudManagement application call AFM through the AdapterSvc application.
 * <p>IT expects FraudCheckPerform and return ApplicationResponse content.
 * @author Harry Xu 
 *
 */
@Controller
public class FraudCheckAdapterController   {

	private static final Log LOG = new CustomizedLog(FraudCheckAdapterController.class.getSimpleName());

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	private ControllerHelper controllerHelper;	
	@Autowired
	public ExternalServicesFacade externalServicesFacade;
	@Autowired
	private MaskingService maskingService;
	@Autowired
    private Config appConfig;
	@Autowired
    private TFMRefPDSFacade tfmRefPDS;


	@org.springframework.beans.factory.annotation.Autowired
	public FraudCheckAdapterController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		// whether or not to Configure ObjectMapper to exclude null fields when serializing
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);

		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.request = request;
	}

	@RequestMapping(value= {"/fraudVendorAdapterSvc/fraudCheck"}, 
			method = RequestMethod.POST, 
			produces = {"application/json" }, 
			consumes = { "application/json" }
	)
	public ResponseEntity<?> performFraudCheck(
			@RequestBody FraudCheckPerform body) {
long startTime = System.nanoTime();		
		BigDecimal accountNo=null;
		try {
			  accountNo = ((TelusBillingAccount) body.getCustomer().getValue().getAccount().get(0).getValue()).getBillingAccountNumber();
		}catch (Exception e1) {
			LOG.warn("accountId parsing error", e1);
		} 
		//keep it first line to set RequestId threadLocal
		PreProcessResult preprocessResult = controllerHelper.preProcess(getRequest(), body.getExternalCreditAssessmentId());
		RequestId.set(preprocessResult.getRequestId()+"_"+accountNo);

		TApplicationRequest tRequest = null;
		TApplicationResponse tResponse = null;
		com.telus.subsfraudmgmt.api.model.watson.Error watsonErrorResponse = null;
		com.telus.subsfraudmgmt.api.model.watson.Prediction watsonSimulatorResponse = null;
		try {
			
			
			boolean AIFraudDormant = this.tfmRefPDS.isFraudAIDormantOn(appConfig.getActiveProfile());
			LOG.info("Check if WATSON_WLS_DORMANT_FLAG simulator flag is on for running env '" + appConfig.getActiveProfile() +"': " + "WATSON_WLS_DORMANT_FLAG: " + AIFraudDormant);

			tRequest =  new TApplicationRequest().fraudCheckPerform(body);
			tRequest.setRequestId(RequestId.get());
            
	    	if (AIFraudDormant) {    		
	    		LOG.info("AIFraudDormant flag is ON, calling AFM directly.....  ");
				ApplicationRequest applicationRequest = FraudCheckPerformAggregateMapper.INSTANCE.fromFraudCheckPerformToApplicationRequest(body);
				tRequest.setApplicationRequest(applicationRequest);

				tRequest.setPostXml(controllerHelper.getConfig().isUseXmlToAFMScore());
				tResponse = this.externalServicesFacade.performFraudCheck(tRequest);
				
				return new ResponseEntity<ApplicationResponse> (tResponse.getApplicationResponse(),tResponse.getBackendHttpStatus());
	    		  		
	    	}else {	
	    		LOG.info("AIFraudDormant flag is OFF, calling AI Fraud Prediction svc.... ");
			    boolean isWatsonSimulatorOn = this.tfmRefPDS.isWatsonSimulatorIndicatorOn(appConfig.getActiveProfile());
			    LOG.info("WLS_WATSON_SIMULATOR_IND : " + isWatsonSimulatorOn);
			    if(appConfig.getActiveProfile().equalsIgnoreCase("local")) {
				   isWatsonSimulatorOn = false;
			     }
			   // WatsonResponseModel watsonResponsefromRefpds = null;
			    TPredictionResponse simPredictionResponse = null;
			
			    if(isWatsonSimulatorOn) {
					   LOG.info("WATSON SIMULATOR IS ON...");
	    			//simulateKey should be last 2 characters of the first name 
					Individual ind = (Individual) body.getCustomer().getValue().getEngagedParty().getValue();
	    			String applicantFirstName = ind.getGivenName();
					LOG.info("First Name = " + applicantFirstName);
	    			String simulateKey = this.safeGetLast2Digit(applicantFirstName);
					LOG.info("Simulator Key = " + simulateKey);
	    			
	    		/*Map to model generated by Lei (No need as we are setting trequest as input now)
	    			PredictionPerform watsonSimulatorRequest = new PredictionPerform();
	    			PredictionPerformInputData inputData = new PredictionPerformInputData();
	    			inputData.addFieldsItem("last2CharactersOfFirstName");
	    			inputData.addValuesItem(simulateKey);
	    			watsonSimulatorRequest.addInputDataItem(inputData);
				*/
					simPredictionResponse = this.tfmRefPDS.getWatsonResponse(simulateKey);
					if(simPredictionResponse==null) {
						simPredictionResponse = this.tfmRefPDS.getWatsonResponse("DFLT");
					}else {
		    			FraudCheckTransaction watsonSimulatorTransaction = new FraudCheckTransaction();
		    			watsonSimulatorTransaction.setObjectMapper(this.getObjectMapper());
		    			watsonSimulatorTransaction.setRequestId(tRequest.getRequestId());
		    			try {
		    				 //BigDecimal accountNo = ((TelusBillingAccount) body.getCustomer().getValue().getAccount().get(0).getValue()).getBillingAccountNumber();
		    				 watsonSimulatorTransaction.setAccountId(GeneralUtil.safeBigDecimalToLong(accountNo));
		    			}catch (Exception e1) {
		    				LOG.warn("accountId parsing error", e1);
		    				 watsonSimulatorTransaction.setAccountId(0);
		    			}
		    			watsonSimulatorTransaction.setType(TransactionType.FraudCheckTransaction);
		    			watsonSimulatorTransaction.setSubType(TransactionSubType.AIFraudPredictionTransaction);
		    			watsonSimulatorTransaction.setPredictionResponse(simPredictionResponse);
	
						ApplicationRequest applicationRequest = FraudCheckPerformAggregateMapper.INSTANCE.fromFraudCheckPerformToApplicationRequest(body, simPredictionResponse.getFraudPredictionResponse(), simPredictionResponse.getFraudPredictionResponseError());
						tRequest.setApplicationRequest(applicationRequest);
						tRequest.setPostXml(controllerHelper.getConfig().isUseXmlToAFMScore());
		    			watsonSimulatorTransaction.setTrequest(tRequest);
	
		    			if(LOG.isInfoEnabled()) {
		    				LOG.info("Watson Simulator Request/Response : " + JsonUtil.generateJson(watsonSimulatorTransaction, watsonSimulatorTransaction.getObjectMapper()));
		    			}
		    			try {
		    				LOG.info("publish WatsonSimulatorTransaction");
		    				watsonSimulatorTransaction.setType(TransactionType.FraudCheckTransaction);
		    				watsonSimulatorTransaction.setSubType(TransactionSubType.AIFraudPredictionTransaction);	    				
		    				watsonSimulatorTransaction.setObjectMapper(this.getObjectMapper());
		    				this.externalServicesFacade.publishTransaction(watsonSimulatorTransaction);
		    			}catch(Exception e) {
		    				LOG.warn("publish WatsonSimulatorTransaction encountered excepion, ignored: ", e);
		    			}
	
		    		}
		    		LOG.info("Returning to client without waiting for transaction publishing... !");
			}
			else {
				 LOG.info("WATSON Simulator is OFF.....");
				 TPredictionResponse fraudPredictionResponse = null;
				 //set prediction request
				 FraudCheckPerform  fraudCheckPerform = tRequest.getFraudCheckPerform();
	    		 PredictionPerformInputData inputDataItem = new PredictionPerformInputData().addValuesItem(fraudCheckPerform);
	             PredictionPerform predictionPerform = new PredictionPerform().addInputDataItem(inputDataItem);
	            // LOG.info("prepare calling prediction api, prediction request ..." + objectMapper.writeValueAsString(predictionPerform));
	             //call fraud prediction api to get prediction
				 fraudPredictionResponse=this.externalServicesFacade.performFraudPrediction(predictionPerform);
				 // System.out.println(objectMapper.writeValueAsString(predictionPerform));
				 if(LOG.isInfoEnabled()) {
					 LOG.info(" fraudPredictionResquest , prediction request ..." + objectMapper.writeValueAsString(predictionPerform));
					 LOG.info("fraudPredictionResponse after calling prediction api..." + objectMapper.writeValueAsString(fraudPredictionResponse));
				 }
				 
				 //publishing Prediction Transaction
				 if (tRequest!=null && fraudPredictionResponse!=null) {
		    			FraudCheckTransaction fraudPredictionTrnx = new FraudCheckTransaction();
		    		 
		    			fraudPredictionTrnx.setObjectMapper(this.getObjectMapper());
		    			fraudPredictionTrnx.setRequestId(tRequest.getRequestId());
		    			try {
		    				 //BigDecimal accountNo = ((TelusBillingAccount) body.getCustomer().getValue().getAccount().get(0).getValue()).getBillingAccountNumber();
		    				 fraudPredictionTrnx.setAccountId(GeneralUtil.safeBigDecimalToLong(accountNo));
		    			}catch (Exception e1) {
		    				LOG.warn("accountId parsing error", e1);
		    				fraudPredictionTrnx.setAccountId(0);
		    			}
		    			fraudPredictionTrnx.setType(TransactionType.FraudCheckTransaction);
		    			fraudPredictionTrnx.setSubType(TransactionSubType.AIFraudPredictionTransaction);
		    			fraudPredictionTrnx.setFraudPredictionRequest(predictionPerform);
		    			fraudPredictionTrnx.setPredictionResponse(fraudPredictionResponse);
		    			
				        try {
	    				     LOG.info("publish Prediction(with SIM OFF) Transaction");
	    				     fraudPredictionTrnx.setType(TransactionType.FraudCheckTransaction);
	    				     fraudPredictionTrnx.setSubType(TransactionSubType.AIFraudPredictionTransaction);	
	    				     fraudPredictionTrnx.setObjectMapper(this.getObjectMapper());
	    				     this.externalServicesFacade.publishTransaction(fraudPredictionTrnx);
	    			    }catch(Exception e) {
	    				     LOG.warn("publish fraudPredictionTrnx(with SIM OFF) encountered excepion, ignored: ", e);
	    		        }
				 }
				 
				 //construct afm request
				 ApplicationRequest applicationRequest = FraudCheckPerformAggregateMapper.INSTANCE.fromFraudCheckPerformToApplicationRequest
						 (body, fraudPredictionResponse.getFraudPredictionResponse(),  fraudPredictionResponse.getFraudPredictionResponseError());
				 tRequest.setApplicationRequest(applicationRequest);
				 tRequest.setPostXml(false);		 
			  }			    
			    //System.out.println(objectMapper.writeValueAsString(tRequest));
			  if(LOG.isInfoEnabled()) {
				 LOG.info("AFM tRequest" + objectMapper.writeValueAsString(tRequest));
			  }			    
		      //call AFM scoring service to perform fraud check   
			 
				tResponse = this.externalServicesFacade.performFraudCheck(tRequest);	
				if(LOG.isInfoEnabled()) {
						 LOG.info("AFM tResponse ." + objectMapper.writeValueAsString(tResponse) );
				}					
			
			  
			  return new ResponseEntity<ApplicationResponse> (tResponse.getApplicationResponse(),tResponse.getBackendHttpStatus());			    
	      }	
		} catch (Exception e) {
			tResponse = createTApplicationResponseErrorResponse(e);
			throw new TfmControllerWrapperRuntimeException(e);
		} finally {
    		LOG.info("publishing FraudCheckTransaction in finally block..");
    		if (tRequest!=null && tResponse!=null) {
    			FraudCheckTransaction fraudCheckTransaction = new FraudCheckTransaction();
    			fraudCheckTransaction.setObjectMapper(this.getObjectMapper());
    			fraudCheckTransaction.setRequestId(tRequest.getRequestId());
    			try {
    				 fraudCheckTransaction.setAccountId(GeneralUtil.safeBigDecimalToLong(accountNo));
    			}catch (Exception e1) {
    				LOG.warn("accountId parsing error", e1);
    				 fraudCheckTransaction.setAccountId(0);
    			}
    			fraudCheckTransaction.setType(TransactionType.FraudCheckTransaction);
    			fraudCheckTransaction.setTrequest(tRequest);
    			fraudCheckTransaction.setTresponse(tResponse);
 
    			try {
    				LOG.info("publish fraudCheckTransaction");    	
    				fraudCheckTransaction.setObjectMapper(this.getObjectMapper());
    				this.externalServicesFacade.publishTransaction(fraudCheckTransaction);
    			}catch(Exception e) {
    				LOG.warn("publish FraudCheckTransaction encountered excepion, ignored: ", e);
    			}

    		}
    		LOG.info("Returning to client without waiting for transaction publishing... !");
long endTime = System.nanoTime();
long elapsedTime = endTime - startTime;	        
double elapsedTimeMilliseconds = elapsedTime * 1e-6;
LogUtil.logPerformance("FraudCheckAdapterController.performFraudCheck Elapsed time: " + elapsedTimeMilliseconds + " milliseconds");     		
    	}

	}

	private TApplicationResponse createTApplicationResponseErrorResponse(Throwable e) {
		TApplicationResponse tResponse;
		//handle errors from fraud vendor adapter API
		FraudCheckDecisioningError aDecisioningError = new FraudCheckDecisioningError();
		aDecisioningError.setDescription(e.getMessage());
		aDecisioningError.setName("AFM_SVC_ERROR");				
		FraudCheck aFraudCheck = new FraudCheck();
		aFraudCheck.setDecisioningError(aDecisioningError);
		
		tResponse= new TApplicationResponse();
		tResponse.setFraudCheck(aFraudCheck );
		tResponse.setBackendHttpStatus(HttpStatus.OK);
		
		ApplicationResponse aApplicationResponse = new ApplicationResponse();
			Error aError = new Error();
			aError.setDescription(e.getMessage());
			aError.setName("AFM_SVC_ERROR");					
			aApplicationResponse.setError(aError );
		tResponse.setApplicationResponse(aApplicationResponse);
		
		com.telus.subsfraudmgmt.api.model.Error aError2= new com.telus.subsfraudmgmt.api.model.Error();
		aError2.setMessage(e.getMessage());
		aError2.setReason("AFM_SVC_ERROR");		
		aError2.setExceptionText(e.getMessage());	
		
		tResponse.setError(aError2);
		
		return tResponse;
	}
	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}
	


	public HttpServletRequest getRequest() {
		return request;
	}
    private String safeGetLast2Digit(String src) {
    	if (src==null) {
    		return "";
    	}
    	String trimmed = src.trim();
    	if (trimmed.length() <=2) {
    		return trimmed;
    	}
    	return trimmed.substring(trimmed.length() - 2);
    }


}
