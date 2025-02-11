package com.telus.subsfraudmgmt.springboot.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fico.afm.model.application.Disposition;
import com.fico.afm.model.application.Individual;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.FraudActivityUpdateMapper;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.FraudCaseUpdateMapper;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.FraudsterCreateMapper;
import com.telus.subsfraudmgmt.springboot.config.Config;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLog;
import com.telus.subsfraudmgmt.springboot.model.request.TCreateFraudFileRequest;
import com.telus.subsfraudmgmt.springboot.model.request.TDeleteFraudFileRequest;
import com.telus.subsfraudmgmt.springboot.model.request.TUpdateAppDispositionRequest;
import com.telus.subsfraudmgmt.springboot.model.request.TUpdateCaseDispositionRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TFraudFileResponse;
import com.telus.subsfraudmgmt.springboot.model.response.TUpdateAppDispositionResponse;
import com.telus.subsfraudmgmt.springboot.model.response.TUpdateCaseDispositionResponse;
import com.telus.subsfraudmgmt.springboot.model.transaction.CreateFraudFileTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.DeleteFraudFileTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.FraudCheckTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.TransactionType;
import com.telus.subsfraudmgmt.springboot.model.transaction.UpdateAppDispositionTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.UpdateCaseDispositionTransaction;
import com.telus.subsfraudmgmt.springboot.service.CryptoService;
import com.telus.subsfraudmgmt.springboot.service.ExternalServicesFacade;
import com.telus.subsfraudmgmt.springboot.service.MaskingService;
import com.telus.subsfraudmgmt.springboot.service.refpds.TFMRefPDSFacade;
import com.telus.subsfraudmgmt.springboot.util.JsonUtil;

public abstract class BaseFraudTransactionsListenerController {
	
	protected Log log = new CustomizedLog(this.getClass().getName());
	
	protected final ObjectMapper objectMapper;
	
	protected final HttpServletRequest request;
	
	@Autowired
	private ControllerHelper controllerHelper;	
	
	@Autowired
	private CryptoService cryptoService;
	
	@Autowired
	private MaskingService maskingService;
	
	@Autowired
	private ExternalServicesFacade externalServicesFacade;
	
	@Autowired
    private Config appConfig;
	
	@Autowired
    private TFMRefPDSFacade tfmRefPDS;
	
	protected BaseFraudTransactionsListenerController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		// whether or not to Configure ObjectMapper to exclude null fields when serializing
		this.objectMapper.setSerializationInclusion(Include.NON_EMPTY);

		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.request = request;
	}
	
	protected ResponseEntity<Object> handleTFMFraudCheckTransaction(
			String requestId,
			String payload,
			Principal principal) throws Exception {

		log.info("handle callback request fraudcheck transaction with encypted payload : '" + payload + "'");
		

		FraudCheckTransaction fraudCheckTransaction = null;
	
		try {
			//We write AFM request, response to json string using spring provided ObjectMapper
			// ObjectMapper objectMapperToUse = JsonUtil.getDefaultObjectMapper();
			ObjectMapper objectMapperToUse = this.objectMapper;
			fraudCheckTransaction = JsonUtil.fromJson(payload, FraudCheckTransaction.class, objectMapperToUse);
			fraudCheckTransaction.setObjectMapper(objectMapperToUse);
		}catch (Exception e) {
			log.warn("handleTFMFraudCheckTransaction: ", e);
		}
		/*
		try {
			this.externalServicesFacade.insertFraudCheckTransaction(fraudCheckTransaction);
		}catch(Exception e) {
			log.warn("insertFraudCheckTransaction: ", e);
		}
		*/
		return new ResponseEntity<Object>(HttpStatus.OK);

	}
	
	protected ResponseEntity<Object> createFraudFile(String requestId,
			String payload,
			Principal principal) throws Exception {

		log.info("handle callback request createFraudFile transaction with encryoted payload : '" + payload + "'");
		if (this.isRTFDSimulatorFlagOn()) {
			log.info("RTFDSimulator On, just return HttpStatus.Ok... ");
			return new ResponseEntity<Object>(HttpStatus.OK); 
		}
		payload = cryptoService.decryptJsonSecureValues(payload);
		
		CreateFraudFileTransaction createFraudFileTransaction = null;
		TCreateFraudFileRequest tRequest = null;
		TFraudFileResponse tResponse = null;

		try {
			//We write AFM request, response to json string using spring provided ObjectMapper
			createFraudFileTransaction = objectMapper.readValue(payload, CreateFraudFileTransaction.class);
			tRequest = createFraudFileTransaction.getTrequest();
			Individual afmIndividual = FraudsterCreateMapper.INSTANCE.fromFraudsterCreateToAfmIndividual(tRequest.getFraudsterCreate());
			tRequest.setIndividual(afmIndividual);
			tResponse = this.externalServicesFacade.createFraudFile(tRequest);
			log.info("createFraudFile callback get response: '" + tResponse);
		} catch (Exception e) {
			log.warn("createFraudFile callback encountered exception: ", e);
		}
		return new ResponseEntity<Object>(HttpStatus.OK); 
	}

	public ResponseEntity<Object> createFraudFileListener(String payload) throws Exception {

		log.info("handle callback request createFraudFile transaction with encryoted payload : '" + payload + "'");
		if (this.isRTFDSimulatorFlagOn()) {
			log.info("RTFDSimulator On, just return HttpStatus.Ok... ");
			return new ResponseEntity<Object>(HttpStatus.OK); 
		}
		payload = cryptoService.decryptJsonSecureValues(payload);
		
		CreateFraudFileTransaction createFraudFileTransaction = null;
		TCreateFraudFileRequest tRequest = null;
		TFraudFileResponse tResponse = null;

		try {
			//We write AFM request, response to json string using spring provided ObjectMapper
			createFraudFileTransaction = objectMapper.readValue(payload, CreateFraudFileTransaction.class);
			tRequest = createFraudFileTransaction.getTrequest();
			Individual afmIndividual = FraudsterCreateMapper.INSTANCE.fromFraudsterCreateToAfmIndividual(tRequest.getFraudsterCreate());
			tRequest.setIndividual(afmIndividual);
			tResponse = this.externalServicesFacade.createFraudFile(tRequest);
			log.info("createFraudFile callback get response: '" + tResponse);
		} catch (Exception e) {
			log.warn("createFraudFile callback encountered exception: ", e);
		}
		return new ResponseEntity<Object>(HttpStatus.OK); 
	}
	protected ResponseEntity<Object> deleteFraudFile(String requestId,
			String payload,
			Principal principal) throws Exception {

		log.info("handle callback request deleteFraudFile transaction with payload : '" + payload + "'");

		if (this.isRTFDSimulatorFlagOn()) {
			log.info("RTFDSimulator On, just return HttpStatus.Ok... ");
			return new ResponseEntity<Object>(HttpStatus.OK); 
		}
		DeleteFraudFileTransaction deleteFraudFileTransaction = null;
		TDeleteFraudFileRequest tRequest = null;
		TFraudFileResponse tResponse = null;

		try {
			deleteFraudFileTransaction = objectMapper.readValue(payload, DeleteFraudFileTransaction.class);
			tRequest = deleteFraudFileTransaction.getTrequest();
			tResponse = this.externalServicesFacade.deleteFraudFile(tRequest);
			log.info("deleteFraudFile callback get response: '" + tResponse);

		} catch (Exception e) {
			log.warn("deleteFraudFile callback encountered exception: ", e);
		}
		return new ResponseEntity<Object>(HttpStatus.OK); 

	}
		public ResponseEntity<Object> deleteFraudFileListener(String payload) throws Exception {

			log.info("handle callback request deleteFraudFile transaction with payload : '" + payload + "'");

			if (this.isRTFDSimulatorFlagOn()) {
				log.info("RTFDSimulator On, just return HttpStatus.Ok... ");
				return new ResponseEntity<Object>(HttpStatus.OK); 
			}
			DeleteFraudFileTransaction deleteFraudFileTransaction = null;
			TDeleteFraudFileRequest tRequest = null;
			TFraudFileResponse tResponse = null;

			try {
				deleteFraudFileTransaction = objectMapper.readValue(payload, DeleteFraudFileTransaction.class);
				tRequest = deleteFraudFileTransaction.getTrequest();
				tResponse = this.externalServicesFacade.deleteFraudFile(tRequest);
				log.info("deleteFraudFile callback get response: '" + tResponse);

			} catch (Exception e) {
				log.warn("deleteFraudFile callback encountered exception: ", e);
			}
			return new ResponseEntity<Object>(HttpStatus.OK); 

		}	

	protected ResponseEntity<Object> updateApplicationDispositon( String requestId,
			String payload,
			Principal principal) throws Exception {


		log.info("handle callback request updateApplicationDispositon transaction with payload : '" + payload + "'");
		
		UpdateAppDispositionTransaction updateAppDispositionTransaction = null;
		TUpdateAppDispositionRequest tRequest = null;
		TUpdateAppDispositionResponse tResponse = null;

		try {
			updateAppDispositionTransaction = objectMapper.readValue(payload, UpdateAppDispositionTransaction.class);
			tRequest = updateAppDispositionTransaction.getTrequest();
			Disposition disposition = FraudActivityUpdateMapper.INSTANCE.fromFraudActiveUpdateToDisposition(tRequest.getFraudActivityUpdate());
			tRequest.setDisposition(disposition);
			if (this.isRTFDSimulatorFlagOn()) {
				log.info("RTFDSimulator On, just return HttpStatus.Ok and insert transaction... ");
				tResponse = new TUpdateAppDispositionResponse();
				tResponse.setBackendHttpStatus(HttpStatus.OK);				 
			}
			else {
				tResponse = this.externalServicesFacade.updateAppDisposition(tRequest);
				log.info("updateApplicationDispositon callback get response: '" + tResponse);
			}
			

		} catch (Exception e) {
			//for transaction publishing
			log.warn("updateApplicationDispositon callback encountered exception: " +  e.getMessage());
			tResponse = new TUpdateAppDispositionResponse();
			controllerHelper.populateErrorResponse(tResponse, e);
		}finally {
			log.info("tRequest is null?" + (tRequest==null));
			log.info("tResponse is null?" + (tResponse==null));
			if (tRequest!=null && tResponse!=null) {

				updateAppDispositionTransaction.setObjectMapper(this.getObjectMapper());
				updateAppDispositionTransaction.setRequestId(tRequest.getRequestId());
				try {
					updateAppDispositionTransaction.setAccountId(Long.parseLong(tRequest.getFraudActivityUpdate().getExternalAccountId()));
				}catch (Exception e1) {
					log.warn("accountId parsing error", e1);
					updateAppDispositionTransaction.setAccountId(0);
				}

				updateAppDispositionTransaction.setType(TransactionType.UpdateAppDispositionTransaction);
                tRequest.setFraudActivityUpdate(null); //to disable logging it to db via @JsonIncludeNotNull.
                updateAppDispositionTransaction.setTrequest(tRequest);
				
                updateAppDispositionTransaction.setTresponse(tResponse);
				try {
					updateAppDispositionTransaction.setObjectMapper(this.getObjectMapper());
					updateAppDispositionTransaction.setType(TransactionType.UpdateAppDispositionTransaction);
					this.externalServicesFacade.publishTransaction(updateAppDispositionTransaction);
				} catch (Exception e) {
					log.warn("publish updateAppDispositionTransaction encountered excepion, ignored: ", e);
				}					
				/*
				try {
					this.externalServicesFacade.insertUpdateAppDispositionTransaction(updateAppDispositionTran);
					log.info("insertUpdateAppDispositionTransaction invoked successfully!");
				}catch(Exception e) {
					log.warn("insertUpdateAppDispositionTransaction encountered excepion, ignored: ", e);
				}
				*/

			}

		}
		log.info("returning HttpStatus OK...");
		return new ResponseEntity<Object>(HttpStatus.OK); 

	}
	

	public ResponseEntity<Object> updateApplicationDispositonListener( String payload) throws Exception {


		log.info("handle pubsub message updateApplicationDispositon transaction with payload : '" + payload + "'");
		
		UpdateAppDispositionTransaction updateAppDispositionTransaction = null;
		TUpdateAppDispositionRequest tRequest = null;
		TUpdateAppDispositionResponse tResponse = null;

		try {
			updateAppDispositionTransaction = objectMapper.readValue(payload, UpdateAppDispositionTransaction.class);
			tRequest = updateAppDispositionTransaction.getTrequest();
			Disposition disposition = FraudActivityUpdateMapper.INSTANCE.fromFraudActiveUpdateToDisposition(tRequest.getFraudActivityUpdate());
			tRequest.setDisposition(disposition);
			if (this.isRTFDSimulatorFlagOn()) {
				log.info("RTFDSimulator On, just return HttpStatus.Ok and insert transaction... ");
				tResponse = new TUpdateAppDispositionResponse();
				tResponse.setBackendHttpStatus(HttpStatus.OK);				 
			}
			else {
				log.info("RTFDSimulator OFF ");
				tResponse = this.externalServicesFacade.updateAppDisposition(tRequest);
				log.info("updateApplicationDispositon callback get response: '" + tResponse);
			}
			

		} catch (Exception e) {
			//for transaction publishing
			log.warn("updateApplicationDispositon callback encountered exception: " +  e.getMessage());
			tResponse = new TUpdateAppDispositionResponse();
			controllerHelper.populateErrorResponse(tResponse, e);
		}finally {
			log.info("tRequest is null?" + (tRequest==null));
			log.info("tResponse is null?" + (tResponse==null));
			if (tRequest!=null && tResponse!=null) {
				UpdateAppDispositionTransaction updateAppDispositionTran = new UpdateAppDispositionTransaction();

				updateAppDispositionTran.setObjectMapper(this.getObjectMapper());
				updateAppDispositionTran.setRequestId(tRequest.getRequestId());
				try {
					updateAppDispositionTran.setAccountId(Long.parseLong(tRequest.getFraudActivityUpdate().getExternalAccountId()));
				}catch (Exception e1) {
					log.warn("accountId parsing error", e1);
					updateAppDispositionTran.setAccountId(0);
				}

				updateAppDispositionTran.setType(TransactionType.UpdateAppDispositionTransaction);
                tRequest.setFraudActivityUpdate(null); //to disable logging it to db via @JsonIncludeNotNull.
				updateAppDispositionTran.setTrequest(tRequest);
				
				updateAppDispositionTran.setTresponse(tResponse);

				try {
					//this.externalServicesFacade.insertUpdateAppDispositionTransaction(updateAppDispositionTran);
					log.info("externalServicesFacade.publishTransaction =" + updateAppDispositionTran);
					this.externalServicesFacade.publishTransaction(updateAppDispositionTran);

					log.info("publishTransaction invoked successfully!");
				}catch(Exception e) {
					log.warn("publish updateAppDispositionTran encountered excepion, ignored: ", e);
				}

			}

		}
		log.info("returning HttpStatus OK...");
		return new ResponseEntity<Object>(HttpStatus.OK); 

	}
	
	protected ResponseEntity<Object> updateCaseDisposition(String requestId,
			String payload,
			Principal principal) throws Exception {

		log.info("handle callback request updateCaseDisposition transaction with payload : '" + payload + "'");
		if (this.isRTFDSimulatorFlagOn()) {
			log.info("RTFDSimulator On, just return HttpStatus.Ok... ");
			return new ResponseEntity<Object>(HttpStatus.OK); 
		}
		UpdateCaseDispositionTransaction updateCaseDispositionTransaction = null;
		TUpdateCaseDispositionRequest tRequest = null;
		TUpdateCaseDispositionResponse tResponse = null;

		try {
			updateCaseDispositionTransaction = objectMapper.readValue(payload, UpdateCaseDispositionTransaction.class);
			tRequest = updateCaseDispositionTransaction.getTrequest();
			Disposition disposition = FraudCaseUpdateMapper.INSTANCE.fromFraudCaseUpdateToDisposition(tRequest.getFraudCaseUpdate());
			tRequest.setDisposition(disposition);
			tResponse = this.externalServicesFacade.updateCaseDisposition(tRequest);
			log.info("updateCaseDisposition callback get response: '" + tResponse);
		} catch (Exception e) {
			log.warn("updateCaseDisposition callback encountered exception: ", e);
		}
		
		return new ResponseEntity<Object>(HttpStatus.OK); 

	}

	public ResponseEntity<Object> updateCaseDispositionListener(String payload) throws Exception {

		log.info("handle callback request updateCaseDisposition transaction with payload : '" + payload + "'");
		if (this.isRTFDSimulatorFlagOn()) {
			log.info("RTFDSimulator On, just return HttpStatus.Ok... ");
			return new ResponseEntity<Object>(HttpStatus.OK); 
		}
		UpdateCaseDispositionTransaction updateCaseDispositionTransaction = null;
		TUpdateCaseDispositionRequest tRequest = null;
		TUpdateCaseDispositionResponse tResponse = null;

		try {
			updateCaseDispositionTransaction = objectMapper.readValue(payload, UpdateCaseDispositionTransaction.class);
			tRequest = updateCaseDispositionTransaction.getTrequest();
			Disposition disposition = FraudCaseUpdateMapper.INSTANCE.fromFraudCaseUpdateToDisposition(tRequest.getFraudCaseUpdate());
			tRequest.setDisposition(disposition);
			tResponse = this.externalServicesFacade.updateCaseDisposition(tRequest);
			log.info("updateCaseDisposition callback get response: '" + tResponse);
		} catch (Exception e) {
			log.warn("updateCaseDisposition callback encountered exception: ", e);
		}
		
		return new ResponseEntity<Object>(HttpStatus.OK); 

	}
	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	protected String deriveFinalRequestId(String requestId) {
		return requestId;
	}

	protected void logPrincipal(Principal principal) {
		if (principal != null) {
			log.info("principal: " + principal.getName()); 
		} else {
			log.info("principal: null");
		}
	} 
	
	private boolean isRTFDSimulatorFlagOn() {
		boolean isSimulatorOn = this.tfmRefPDS.isRTFDSimulatorIndicatorOn(appConfig.getActiveProfile());
		
		return isSimulatorOn;
	}

}
