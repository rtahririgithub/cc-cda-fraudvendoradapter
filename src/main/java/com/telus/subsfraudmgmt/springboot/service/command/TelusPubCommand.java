package com.telus.subsfraudmgmt.springboot.service.command;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telus.subsfraudmgmt.springboot.config.AppCtx;
import com.telus.subsfraudmgmt.springboot.config.Config.WebService;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.model.transaction.BaseTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.TransactionType;
import com.telus.subsfraudmgmt.springboot.service.CryptoService;
import com.telus.subsfraudmgmt.springboot.service.RestServiceClientBase;
import com.telus.subsfraudmgmt.springboot.service.TelusPubsubService;
import com.telus.subsfraudmgmt.springboot.util.JsonUtil;
import com.telus.subsfraudmgmt.springboot.util.LogUtil;

/**
 * Interface telus pubsub framework to publish message
 * <pre>
 * The transaction json is created from object. If transaction type is FraudCheck and CreateFraudFile, the json message is
 * encrypted for sensitive fields.  
 * 
 * The fraudCheckCommandSvc/FraudTransactionRecord listener in FraudcheckCommandSvc, the /fraudVendorAdapterSvc/VendorFraudTransaction
 * is responsible to decrypt it for FraudCheck and CreateFraudFile transaction.
 * </pre>
 * @author Harry Xu
 *
 */
@Component
public class TelusPubCommand extends RestServiceClientBase implements Command {

	private static final Log LOG = CustomizedLogFactory.getLog(TelusPubCommand.class);

	@Autowired
	private AppCtx appCtx;
	
	@Autowired
	private CryptoService cryptoService;
	
	@Autowired
	private TelusPubsubService telusPubsubService;	
	/**
	 * Note that for publish, it is the caller that providing ObjectMapper and this is not used.
	 */
	@Override
	protected ObjectMapper resolvebjectMapper() {
		//return ObjectMapperConfigurer.getConfiguredObjectMapper(ObjectMapperType.HONOR_XX_DATE_TIME);
		return JsonUtil.getDefaultObjectMapper();
	}
	/**
	 * Execute {@code TUpdateAppDispositionRequest} request.
	 */
	@Override
	public Object execute(Object oTransaction) throws Exception{

		BaseTransaction oRequest = (BaseTransaction) oTransaction;
		String jsonPayLoad = null;
		 //publish and consumer using spring provided one, only use customized one for interfacing with AFM
		if (oRequest.getObjectMapper()!=null) {			
			jsonPayLoad = JsonUtil.generateJson(oRequest, oRequest.getObjectMapper());			
			if (TransactionType.FraudCheckTransaction.equals(oRequest.getType()) ||
					TransactionType.CreateFraudFileTransaction.equals(oRequest.getType())) {				
				long startTime = System.nanoTime();
				
				//for fraudcheck, createFraudFile contains sensitive info
				jsonPayLoad = cryptoService.encryptJsonSecureValues(jsonPayLoad);
				
		        long endTime = System.nanoTime();
		        long elapsedTime = endTime - startTime;	        
		        // Convert elapsed time to milliseconds (1 nanosecond = 1e-6 milliseconds)
		        double elapsedTimeMilliseconds = elapsedTime * 1e-6;
		        //LogUtil.logPerformance("encryptJsonSecureValues Elapsed time: " + elapsedTimeMilliseconds + " milliseconds");				
				
			}			
		}else {
			throw new RuntimeException("An instance of ObjectMapper has to be specified in the publish request!");
			
		}
		String transactionTypeName = oRequest.getType().name(); 
		if(LOG.isInfoEnabled()) {
			LOG.info("telusPubsubService.publishDocument: transactionTypeName="+transactionTypeName + " jsonPayLoad=" + jsonPayLoad);
		}
		return telusPubsubService.publishDocument(jsonPayLoad,transactionTypeName); 
	}
	/*
	public HttpStatus executeOld(Object oTransaction) throws Exception{

		BaseTransaction oRequest = (BaseTransaction) oTransaction;

		try {
			WebService telusPubRestSvcConfig = this.getTelusPubRestSvcConfig();
			HttpHeaders headers = this.getHttpHeaderWithBasicAuthorization(telusPubRestSvcConfig);
			//headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);

			String queryStr= String.format("?originatingAppId=%s&requestId=%s&transactionType=%s",
					appCtx.getCmdbAppID(), oRequest.getRequestId(), oRequest.getType().toString());
			
			String uri = telusPubRestSvcConfig.getEndpointAddress() +  queryStr;
					
			LOG.info("Pubsub endpoint = '" + uri + "'");
			
			String jsonPayLoad = null;
			 //publish and consumer using spring provided one, only use customized one for interfacing with AFM
			if (oRequest.getObjectMapper()!=null) {
				
				jsonPayLoad = JsonUtil.generateJson(oRequest, oRequest.getObjectMapper());
				LOG.info("jsonPayload unEncrypted to publish: '" + jsonPayLoad + "'");
				
				if (TransactionType.FraudCheckTransaction.equals(oRequest.getType()) ||
						TransactionType.CreateFraudFileTransaction.equals(oRequest.getType())) {
					
					//for fraudcheck, createFraudFile contains sensitive info
					jsonPayLoad = cryptoService.encryptJsonSecureValues(jsonPayLoad);
				}
				
			}else {
				throw new RuntimeException("An instance of ObjectMapper has to be specified in the publish request!");
				
			}
			HttpEntity<String> requestEntity = new HttpEntity<>(jsonPayLoad, headers);
			ResponseEntity<String> out = this.getRestTemplate().exchange(uri, HttpMethod.POST, requestEntity,
					String.class);

			LOG.info("Pubsub Response Code = " + out.getStatusCode());
			LOG.info("Pubsub Message ID = " + out.toString());

			return out.getStatusCode();

		} catch (HttpStatusCodeException e) {
			LOG.warn("HttpStatusCodeExceptions: " + e.getStatusCode() + " " + e.getStatusText()
			+ e.getResponseBodyAsString());

			throw e;
		} catch (Exception e) {
			LOG.warn("TelusPubCommand REST exception", e);
			throw e;
		}

	}	 
	*/

}