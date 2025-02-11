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
import com.telus.subsfraudmgmt.springboot.config.Config.WebService;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.model.request.TCreateFraudFileRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TFraudFileResponse;
import com.telus.subsfraudmgmt.springboot.service.MaskingService;
import com.telus.subsfraudmgmt.springboot.service.RestServiceClientBase;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer.ObjectMapperType;

@Component
public class CreateFraudFileCommand extends RestServiceClientBase implements Command {

	private static final Log LOG = CustomizedLogFactory.getLog(CreateFraudFileCommand.class);
	

	@Autowired
	private MaskingService maskingService;
	
	@Override
	protected ObjectMapper resolvebjectMapper() {
		//serialize date as -08:00
		return ObjectMapperConfigurer.getConfiguredObjectMapper(ObjectMapperType.HONOR_XXX_DATE_TIME);
	}
	/**
	 * Execute {@code TUpdateAppDispositionRequest} request.
	 * 
	 * <pre>
	 * AFM Return Status Codes include: 
	 *   200 OK
	 *   400 Bad Request
	 *   403 Forbidden
	 * </pre>
	 */
	@Override
	public TFraudFileResponse execute(Object tCreateFraudFileRequest) throws Exception {
		TCreateFraudFileRequest oRequest = (TCreateFraudFileRequest) tCreateFraudFileRequest;
		
		try {
			WebService afmCaseManagementRestSvcConfig = this.getAfmCaseManagementRestSvcConfig();
			HttpHeaders headers = this.getHttpHeaderWithBasicAuthorization(afmCaseManagementRestSvcConfig);
	   
			//headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			//invalid url = https://afm-cm.tsl.telus.com/afm-casemanagement-server/api/fraudfile/entry
			//valid url  =  https://afm-cm.tsl.telus.com/afm-casemanagement-server/casemanagement/fraudfile/entry

	        String postpart;
	        //invalid postpart ="/afm-casemanagement-server/api/fraudfile/entry;
	        postpart ="/afm-casemanagement-server/casemanagement/fraudfile/entry";
	        
			String uri = afmCaseManagementRestSvcConfig.getEndpointAddress() + postpart;
			

			String jsonPayLoad = this.generateJson(oRequest.getIndividual());
			
			if(LOG.isInfoEnabled()) {
				maskingService.maskAndLogJsonString(jsonPayLoad);
			}
			LOG.info("AFM CreateFraudFile: " + " url=" + uri + " url=" + uri);
			HttpEntity<String> requestEntity = new HttpEntity<>(jsonPayLoad, headers);
			// use RestTemplate with Disabled Certificate Verification			
	        ResponseEntity<String> out = this.getRestTemplateDisablesCertificateVerification().exchange(uri, HttpMethod.POST, requestEntity,String.class);
			//ResponseEntity<String> out = this.getRestTemplate().exchange(uri, HttpMethod.POST, requestEntity,String.class);

			LOG.info("AFM CreateFraudFile : out.getStatusCode() = " + out.getStatusCode());
			if(LOG.isInfoEnabled()) {
				maskingService.maskAndLogJsonString(out.getBody());
			}
			
			return this.deriveResponse(out.getStatusCode());

		} catch (HttpStatusCodeException e) {
			LOG.warn("HttpStatusCodeExceptions: " + e.getStatusCode() + " " + e.getStatusText()
			+ e.getResponseBodyAsString());

			throw e;
		} catch (Exception e) {
			LOG.warn("CreateFraudFileCommand REST exception", e);
			throw e;
		}

	}

	private TFraudFileResponse deriveResponse(HttpStatus httpStatus) {
		TFraudFileResponse response = new TFraudFileResponse();
		response.setBackendHttpStatus(httpStatus);
		return response;
	}
	

}