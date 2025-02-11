package com.telus.subsfraudmgmt.springboot.pubsub.receivers;

import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;
import org.springframework.cloud.gcp.pubsub.support.GcpPubSubHeaders;
import org.springframework.cloud.gcp.pubsub.support.converter.JacksonPubSubMessageConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.pubsub.v1.PubsubMessage;
import com.telus.subsfraudmgmt.springboot.RequestId;
import com.telus.subsfraudmgmt.springboot.controller.ControllerHelper;
import com.telus.subsfraudmgmt.springboot.controller.FraudCUDTransactionsListenerController;
import com.telus.subsfraudmgmt.springboot.model.transaction.BaseTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.CreateFraudFileTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.DeleteFraudFileTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.FraudCheckTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.UpdateAppDispositionTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.UpdateCaseDispositionTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.UpdateFraudFileTransaction;
import com.telus.subsfraudmgmt.springboot.service.ExternalServicesFacade;
import com.telus.subsfraudmgmt.springboot.service.MaskingService;

@Service
public class FraudCheckMessageReceiver {

	private static final Logger LOGGER = LoggerFactory.getLogger(FraudCheckMessageReceiver.class);

	private final JacksonPubSubMessageConverter messageConverter;

	private ControllerHelper controllerHelper;

	private ExternalServicesFacade externalServicesFacade;

	private MaskingService maskingService;

	private ObjectMapper objectMapper;
	
	@Autowired
	FraudCUDTransactionsListenerController aFraudCUDTransactionsListenerController;

	@Autowired
	public FraudCheckMessageReceiver(ObjectMapper objectMapper, ExternalServicesFacade externalServicesFacade,
			MaskingService maskingService, ControllerHelper controllerHelper) {
		messageConverter = new JacksonPubSubMessageConverter(objectMapper);
		this.controllerHelper = controllerHelper;
		this.externalServicesFacade = externalServicesFacade;
		this.maskingService = maskingService;
		this.objectMapper = objectMapper;
	}

	/**
	 * Receives fraucheck transaction message from google pubsub topic
	 * credit-fraud-dv-tp Messages then will be mapped to PATCH DTO and will be
	 * process similarly as requests coming from REST API
	 */
	@ServiceActivator(inputChannel = "fraudCheckPubSubInputChannel")
	public void messageReceiver(@Header(GcpPubSubHeaders.ORIGINAL_MESSAGE) BasicAcknowledgeablePubsubMessage message) {
		try {
			if(message!=null &&  message.getPubsubMessage() !=null) {
				String requestId = message.getPubsubMessage().getMessageId();
				// set threadLocal for logging
				RequestId.set(requestId);				
				LOGGER.info("FraudCheckMessageReceiver.messageReceiver : handle pubsub messages from inputChannel fraudCheckPubSubInputChannel with message.getPubsubMessage() : '" + message.getPubsubMessage() + "'");
	
				 PubsubMessage pubsubMessage = message.getPubsubMessage();
				 byte[] payload = pubsubMessage.getData().toByteArray();
				 String payloadString = new String(payload, StandardCharsets.UTF_8);
					 
				 Map<String, String> msgAttributesMap = message.getPubsubMessage().getAttributesMap();				 
				 String typeAttribute = msgAttributesMap.get("type");
				 LOGGER.info("FraudCheckMessageReceiver.messageReceiver : " + "typeAttribute=" +typeAttribute );
				 
				 if("DeleteFraudFileTransaction".equalsIgnoreCase(typeAttribute)) {
					 aFraudCUDTransactionsListenerController.deleteFraudFileListener(payloadString);
				 }else {
					 if("CreateFraudFileTransaction".equalsIgnoreCase(typeAttribute)) {
						 aFraudCUDTransactionsListenerController.createFraudFileListener(payloadString);
					 }else {
						 if("UpdateAppDispositionTransaction".equalsIgnoreCase(typeAttribute)) {
							 aFraudCUDTransactionsListenerController.updateApplicationDispositonListener(payloadString);
						 }else {
							 if("UpdateCaseDispositionTransaction".equalsIgnoreCase(typeAttribute)) {
								 aFraudCUDTransactionsListenerController.updateCaseDispositionListener(payloadString);				 
							 }else {
								 if("UpdateFraudFileTransaction".equalsIgnoreCase(typeAttribute)) {
									//ignore 					 
								 }else {
									 if("FraudCheckTransaction".equalsIgnoreCase(typeAttribute)) {
										 //ignore 
									 }					 				 
							 }					 
						 }				 
					 }	 
				 }
			}
			ackMessage(message.ack(), message.getPubsubMessage().getMessageId());
			}
		} catch (Exception e) {
			LOGGER.error("ERROR reading msg from listener", e);
			ackMessage(message.nack(), message.getPubsubMessage().getMessageId());
		} finally {
			MDC.clear();
		}
	}

	private void ackMessage(ListenableFuture<Void> future, String messageId) {
		try {
			future.get();
		} catch (Exception e) {
			LOGGER.error(" Exception acknowledging pubsub message. messageId={} .  StackTrace= {}", messageId, e);
		}
	}

}
