package com.telus.subsfraudmgmt.springboot.service;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.telus.subsfraudmgmt.springboot.model.transaction.TransactionType;
import com.telus.subsfraudmgmt.springboot.util.LogUtil;

@Service
public class TelusPubsubService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TelusPubsubService.class);

	@Value("${fraud.pubsub.enabled}")
	private boolean pubsubLogEnabled;


	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private PubSubTemplate pubSubTemplate;

	@Value("${proxyHost:#{null}}")
	private String proxyHost;

	@Value("${proxyPort:#{null}}")
	private String proxyPort;

	@Value("${isProxyEnabled:false}")
	private boolean isProxyEnabled;

	@Value("${fraud.pubsub.topic}")
	private String creditfraudtp;	
	/**
	 * Publish document to PubSub
	 *
	 * @param fraud transaction
	 * @return
	 */
	public String publishDocument(String jsonPayLoad,String transactionTypeName) {
		String result = null;
		
		try {
			if (isProxyEnabled) {
				System.setProperty("https.proxyHost", proxyHost);
				System.setProperty("https.proxyPort", proxyPort);
			}
			ByteString data = ByteString.copyFromUtf8(jsonPayLoad);
			//add pubsub attribute with name=type and value=transactionTypeName . this is used to allow pubsub to perform filtering .( note that GCP pubsub does not allow filtering based on message body. only based on message attributes)
			PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).putAttributes("type", transactionTypeName).build();
			// Once published, returns a server-assigned message id (unique within the topic)
			if(LOGGER.isInfoEnabled()) {
				LOGGER.info("Before publishDocument: creditfraudtp={}, transactionType Attribute={} , pubsubMessage::{}", creditfraudtp, transactionTypeName, jsonPayLoad);
			}
			
			long startTime = System.nanoTime();
			// use RestTemplate with Disabled Certificate Verification
			ListenableFuture<String> messageIdFuture2 = pubSubTemplate.publish(creditfraudtp, pubsubMessage);
		       // ResponseEntity<String> out = this.getRestTemplate().exchange(uri, HttpMethod.POST, requestEntity,String.class);
	        long endTime = System.nanoTime();
	        long elapsedTime = endTime - startTime;	        
	        // Convert elapsed time to milliseconds (1 nanosecond = 1e-6 milliseconds)
	        double elapsedTimeMilliseconds = elapsedTime * 1e-6;
	        //LogUtil.logPerformance("pubSubTemplate.publish Elapsed time: " + elapsedTimeMilliseconds + " milliseconds");
	        
			String msg = messageIdFuture2.get();
			if(LOGGER.isInfoEnabled()) {
				LOGGER.debug("After publishDocument: creditfraudtp={}, transactionType Attribute={} , pubSubTemplate.publish response::{}", creditfraudtp, transactionTypeName, msg);
			}
			result = "Message ID " + msg;
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.error("pubSubTemplate.publish fraud transaction published error ", e);
		}
		return result;
	}
}
