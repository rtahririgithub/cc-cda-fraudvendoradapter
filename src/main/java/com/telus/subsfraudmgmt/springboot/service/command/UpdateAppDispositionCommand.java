package com.telus.subsfraudmgmt.springboot.service.command;

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
import com.telus.subsfraudmgmt.springboot.model.ApplicationNotExistException;
import com.telus.subsfraudmgmt.springboot.model.request.TUpdateAppDispositionRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TUpdateAppDispositionResponse;
import com.telus.subsfraudmgmt.springboot.service.RestServiceClientBase;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer.ObjectMapperType;

@Component
public class UpdateAppDispositionCommand extends RestServiceClientBase implements Command {

	private static final Log LOG = CustomizedLogFactory.getLog(UpdateAppDispositionCommand.class);
	
	@Override
	protected ObjectMapper resolvebjectMapper() {
		//serialize date as -0800
		return ObjectMapperConfigurer.getConfiguredObjectMapper(ObjectMapperType.HONOR_XX_DATE_TIME);
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
	public TUpdateAppDispositionResponse execute(Object tUpdateAppDispositionRequest) throws Exception {

		TUpdateAppDispositionRequest oRequest = (TUpdateAppDispositionRequest) tUpdateAppDispositionRequest;
int i=0;
		try {
			WebService afmScoreRestSvcConfig = this.getAfmScoreServerRestSvcConfig();
			HttpHeaders headers = this.getHttpHeaderWithBasicAuthorization(afmScoreRestSvcConfig);
			//headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			 
			String uri = afmScoreRestSvcConfig.getEndpointAddress() + "/afm-scoring-server/api/application/" + oRequest.getApplicationId()
					+ "/disposition";


			String jsonPayLoad = this.generateJson(oRequest.getDisposition());
			LOG.info("AFM UpdateAppDispositionRequest jsonPayload: '" + jsonPayLoad + "'");
			LOG.info("AFM UpdateAppDispositionRequest: " + " url=" + uri + " url=" + uri);
			
			HttpEntity<String> requestEntity = new HttpEntity<>(jsonPayLoad, headers);
			ResponseEntity<String> out = this.getRestTemplateDisablesCertificateVerification().exchange(uri, HttpMethod.PUT, requestEntity,String.class);
			//ResponseEntity<String> out = this.getRestTemplate().exchange(uri, HttpMethod.PUT, requestEntity,String.class);

			LOG.info("AFM UpdateAppDispositionRequest out.getStatusCode() = " + out.getStatusCode());

			return this.deriveResponse(out.getStatusCode());

		} catch (HttpStatusCodeException e) {
			
			String responseBodyString = e.getResponseBodyAsString();
			
			LOG.warn("HttpStatusCodeExceptions: " + e.getStatusCode() + " " + e.getStatusText()
			+": " + responseBodyString);
			LOG.warn("HttpStatusCodeExceptions wrapped header:" + e.getResponseHeaders());
		
			if (responseBodyString != null && 
					responseBodyString.contains("com.fico.faf.data.EntityLoadException: application with id")
					&& responseBodyString.contains("not found")){
				throw new ApplicationNotExistException("application does not exist with id: '" + oRequest.getApplicationId()+"'");
			}
			throw e;
		} catch (Exception e) {
			LOG.warn("UpdateAppDispositionCommand REST exception:", e);
			throw e;
		}

	}

	private TUpdateAppDispositionResponse deriveResponse(HttpStatus httpStatus) {
		TUpdateAppDispositionResponse response = new TUpdateAppDispositionResponse();
		response.setBackendHttpStatus(httpStatus);
		return response;
	}
	

}