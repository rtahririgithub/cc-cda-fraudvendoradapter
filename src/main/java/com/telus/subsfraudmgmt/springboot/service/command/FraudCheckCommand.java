package com.telus.subsfraudmgmt.springboot.service.command;

import java.util.Arrays;

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
import com.fico.afm.model.application.ApplicationRequest;
import com.fico.afm.model.application.ApplicationResponse;
import com.telus.subsfraudmgmt.springboot.config.Config.WebService;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.model.request.TApplicationRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TApplicationResponse;
import com.telus.subsfraudmgmt.springboot.service.MaskingService;
import com.telus.subsfraudmgmt.springboot.service.RestServiceClientBase;
import com.telus.subsfraudmgmt.springboot.util.AFMXmlUtil;
import com.telus.subsfraudmgmt.springboot.util.GeneralUtil;
import com.telus.subsfraudmgmt.springboot.util.LogUtil;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer.ObjectMapperType;
@Component
public class FraudCheckCommand extends RestServiceClientBase implements Command {

	private static final Log LOG = CustomizedLogFactory.getLog(FraudCheckCommand.class);
	
	@Autowired
	private MaskingService maskingService;
	
	@Override
	protected ObjectMapper resolvebjectMapper() {
		//serialize date as -08:00 - XXX means 3 chunks with ':' counted with one chunk
		return ObjectMapperConfigurer.getConfiguredObjectMapper(ObjectMapperType.HONOR_XXX_DATE_TIME);
	}

	/**
	 * Execute {@code TApplicationRequest} request.
	 * 
	 * <pre>
	 * AFM Return Status Codes include: 
	 *   200 OK
	 *   400 Bad Request
	 *   403 Forbidden
	 * </pre>
	 */
	@Override
	public TApplicationResponse execute(Object tApplicationRequest) throws Exception{

		TApplicationRequest oRequest = (TApplicationRequest) tApplicationRequest;

		return oRequest.isPostXml()? postXml(oRequest): postJson(oRequest);

	}

	private TApplicationResponse postJson(TApplicationRequest oRequest) throws Exception{
		String uri="";
		String jsonPayLoad = "";
		try {
			WebService afmScoreRestSvcConfig = this.getAfmScoreServerRestSvcConfig();
			HttpHeaders headers = this.getHttpHeaderWithBasicAuthorization(afmScoreRestSvcConfig);
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			 uri = afmScoreRestSvcConfig.getEndpointAddress()+ "/afm-scoring-server/scoring/application/score";
			LOG.info("AFM URL = '" + uri + "'");

			
			if(oRequest.getApplicationRequest()!=null) {
				jsonPayLoad = this.generateJson(oRequest.getApplicationRequest());
			}
			if(LOG.isInfoEnabled()) {
				maskingService.maskAndLogJsonString(jsonPayLoad);
			}
			//GeneralUtil.printProxy(uri);

			HttpEntity<String> requestEntity = new HttpEntity<>(jsonPayLoad, headers);
			long startTime = System.nanoTime();
			// use RestTemplate with Disabled Certificate Verification
	        ResponseEntity<String> out = this.getRestTemplateDisablesCertificateVerification().exchange(uri, HttpMethod.POST, requestEntity,String.class);
	       // ResponseEntity<String> out = this.getRestTemplate().exchange(uri, HttpMethod.POST, requestEntity,String.class);
	        long endTime = System.nanoTime();
	        long elapsedTime = endTime - startTime;	        
	        // Convert elapsed time to milliseconds (1 nanosecond = 1e-6 milliseconds)
	        double elapsedTimeMilliseconds = elapsedTime * 1e-6;
	        LogUtil.logPerformance("AFM call Elapsed time: " + elapsedTimeMilliseconds + " milliseconds");				
				        
			LOG.info("AFM Response Code = " + out.getStatusCode());
			//LOG.info("AFM Response Body  = " + out.getBody());
			return this.deriveResultFromJson(out.getStatusCode(), out);

		} catch (HttpStatusCodeException e) {

			String maskedjsonPayLoad = maskingService.maskJsonSecureValues(jsonPayLoad);
			// Add more information to the exception
		    String additionalInfo = "afmScoreRestSvc API call failed = url " + uri + "afmScoreRestSvc request payload " + maskedjsonPayLoad;
		    String combinedMessage = e.getMessage() + " - " + additionalInfo;
		    Exception newException = new Exception(combinedMessage,e );
		    throw newException;
		} catch (Exception e) {
			String maskedjsonPayLoad = maskingService.maskJsonSecureValues(jsonPayLoad);
			// Add more information to the exception
		    String additionalInfo = "afmScoreRestSvc API call failed = url " + uri + "afmScoreRestSvc request payload " + maskedjsonPayLoad;
		    String combinedMessage = e.getMessage() + " - " + additionalInfo;
		    Exception newException = new Exception(combinedMessage,e );
		    throw newException;
		}
	}

	//Only for testing purpose of xml payload, which is much slowers
	
	private TApplicationResponse postXml(TApplicationRequest oRequest) throws Exception {
	
		try {
			WebService afmScoreRestSvcConfig = this.getAfmScoreServerRestSvcConfig();
			HttpHeaders headers = this.getHttpHeaderWithBasicAuthorization(afmScoreRestSvcConfig);
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
			headers.setContentType(MediaType.APPLICATION_XML);
			 
			String uri = afmScoreRestSvcConfig.getEndpointAddress()+ "/afm-scoring-server/scoring/application/score";
			
		 
			LOG.info("AFM URL = '" + uri + "'");

			String xmlPayload = AFMXmlUtil.javaToXml(oRequest.getApplicationRequest(), ApplicationRequest.class);
			 
			maskingService.maskAndLogXmlString(xmlPayload);
			HttpEntity<String> requestEntity = new HttpEntity<>(xmlPayload, headers);
			
			ResponseEntity<String> out = this.getRestTemplateDisablesCertificateVerification().exchange(uri, HttpMethod.POST, requestEntity,String.class);
			//ResponseEntity<String> out = this.getRestTemplate().exchange(uri, HttpMethod.POST, requestEntity,String.class);

			LOG.info("AFM Response Code = " + out.getStatusCode());
			LOG.info("AFM Response Body  = " + out.getBody());
			return this.deriveResultFromXml(out.getStatusCode(), out);

		} catch (HttpStatusCodeException e) {
			LOG.warn("HttpStatusCodeExceptions: " + e.getStatusCode() + " " + e.getStatusText()
			+": " + e.getResponseBodyAsString());
			LOG.warn("HttpStatusCodeExceptions wrapped header:" + e.getResponseHeaders());
			throw e;
		} catch (Exception e) {
			LOG.warn("FraudCheckCommand REST exception", e);
			throw e;
		}
	}

	private TApplicationResponse deriveResultFromJson(HttpStatus httpStatus, ResponseEntity<String> out) throws Exception{
		TApplicationResponse response = new TApplicationResponse();
		response.setBackendHttpStatus(httpStatus);
		ApplicationResponse applicationResponse= this.fromJson(out.getBody(), ApplicationResponse.class);
		response.setApplicationResponse(applicationResponse);

		return response;
	}

	private TApplicationResponse deriveResultFromXml(HttpStatus httpStatus, ResponseEntity<String> out) throws Exception{
		TApplicationResponse response = new TApplicationResponse();
		response.setBackendHttpStatus(httpStatus);
		ApplicationResponse applicationResponse= AFMXmlUtil.xmlToJava(out.getBody(), ApplicationResponse.class);
		response.setApplicationResponse(applicationResponse);

		return response;
	}

}