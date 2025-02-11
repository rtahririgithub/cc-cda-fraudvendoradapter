package com.telus.subsfraudmgmt.springboot.service.command;

import java.util.Arrays;

import org.apache.commons.logging.Log;
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
import com.telus.subsfraudmgmt.springboot.model.request.TUpdateFraudFileRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TFraudFileResponse;
import com.telus.subsfraudmgmt.springboot.service.RestServiceClientBase;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer.ObjectMapperType;

@Component
public class UpdateFraudFileCommand extends RestServiceClientBase implements Command {

	private static final Log LOG = CustomizedLogFactory.getLog(UpdateFraudFileCommand.class);
		
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
	public TFraudFileResponse execute(Object tUpdateFraudFileRequest) throws Exception {

		TUpdateFraudFileRequest oRequest = (TUpdateFraudFileRequest) tUpdateFraudFileRequest;

		try {
			WebService afmCaseManagementRestSvcConfig = this.getAfmCaseManagementRestSvcConfig();
			HttpHeaders headers = this.getHttpHeaderWithBasicAuthorization(afmCaseManagementRestSvcConfig);
	   
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			String uri = afmCaseManagementRestSvcConfig.getEndpointAddress() + "/afm-casemanagement-server/api/fraudfile/entry/" + oRequest.getFraudFileId();
			String jsonPayLoad = this.generateJson(oRequest.getIndividual());
			
			LOG.info("AFM UpdateFraudFileRequest jsonPayload: '" + jsonPayLoad + "'");
			LOG.info("AFM UpdateFraudFileRequest: " + " url=" + uri + " url=" + uri);
			
			HttpEntity<String> requestEntity = new HttpEntity<>(jsonPayLoad, headers);
			ResponseEntity<String> out = this.getRestTemplateDisablesCertificateVerification().exchange(uri, HttpMethod.PUT, requestEntity,String.class);
			//ResponseEntity<String> out = this.getRestTemplate().exchange(uri, HttpMethod.PUT, requestEntity,String.class);

			LOG.info("AFM UpdateFraudFile out.getStatusCode() = " + out.getStatusCode());
			LOG.info("AFM UpdateFraudFile  out.body  = '" + out.getBody()+"'");
			
			return this.deriveResponse(out.getStatusCode());

		} catch (HttpStatusCodeException e) {
			LOG.warn("HttpStatusCodeExceptions: " + e.getStatusCode() + " " + e.getStatusText()
			+": " + e.getResponseBodyAsString());
			LOG.warn("HttpStatusCodeExceptions wrapped header:" + e.getResponseHeaders());
			throw e;
		} catch (Exception e) {
			LOG.warn("UpdateFraudFileCommand REST exception", e);
			throw e;
		}

	}

	private TFraudFileResponse deriveResponse(HttpStatus httpStatus) {
		TFraudFileResponse response = new TFraudFileResponse();
		response.setBackendHttpStatus(httpStatus);
		return response;
	}
	

}