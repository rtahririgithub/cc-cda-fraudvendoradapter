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
import com.telus.subsfraudmgmt.springboot.model.response.TFraudFileResponse;
import com.telus.subsfraudmgmt.springboot.service.RestServiceClientBase;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer.ObjectMapperType;
/**
 * Delete a fraud file by fraud file id.
 * @author Harry Xu
 *
 */
@Component
public class DeleteFraudFileByIdCommand extends RestServiceClientBase implements Command {

	private static final Log LOG = CustomizedLogFactory.getLog(DeleteFraudFileByIdCommand.class);
		
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
	public TFraudFileResponse execute(Object oFraudFileId) throws Exception {
 
		 
		try {
		    String fraudFileId = (String)oFraudFileId;
			WebService afmCaseManagementRestSvcConfig = this.getAfmCaseManagementRestSvcConfig();
			HttpHeaders headers = this.getHttpHeaderWithBasicAuthorization(afmCaseManagementRestSvcConfig);
	   
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			
			String uri = afmCaseManagementRestSvcConfig.getEndpointAddress() + "/afm-casemanagement-server/api/fraudfile/entry/" + fraudFileId;;

			LOG.info("AFM DeleteFraudFile: " + " url=" + uri + " url=" + uri);

			HttpEntity<String> requestEntity = new HttpEntity<>(headers);
			ResponseEntity<String> out = this.getRestTemplateDisablesCertificateVerification().exchange(uri, HttpMethod.DELETE, requestEntity,String.class);
			//ResponseEntity<String> out = this.getRestTemplate().exchange(uri, HttpMethod.DELETE, requestEntity,String.class);

			LOG.info("AFM DeleteFraudFile : out.getStatusCode() = " + out.getStatusCode());
			LOG.info("AFM DeleteFraudFile : out.getBody() = " + out.getBody());

			return this.deriveResponse(out.getStatusCode());

		} catch (HttpStatusCodeException e) {
			LOG.warn("DeleteFraudFileByIdCommand HttpStatusCodeExceptions: " + e.getStatusCode() + " " + e.getStatusText()
			+ e.getResponseBodyAsString());

			throw e;
		} catch (Exception e) {
			LOG.warn("DeleteFraudFileByIdCommand REST exception", e);
			throw e;
		}

	}

	private TFraudFileResponse deriveResponse(HttpStatus httpStatus) {
		TFraudFileResponse response = new TFraudFileResponse();
		response.setBackendHttpStatus(httpStatus);
		return response;
	}
	

}