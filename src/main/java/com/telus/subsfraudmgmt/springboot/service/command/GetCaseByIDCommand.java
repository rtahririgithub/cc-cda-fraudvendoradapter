package com.telus.subsfraudmgmt.springboot.service.command;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fico.afm.model.application.CaseType;
import com.telus.subsfraudmgmt.springboot.config.Config.WebService;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.service.MaskingService;
import com.telus.subsfraudmgmt.springboot.service.RestServiceClientBase;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer.ObjectMapperType;

/**
 * This will be used by <code>UpdateCaseDispostion</code> indirectly.
 * @author Harry Xu
 *
 */
@Component
public class GetCaseByIDCommand extends RestServiceClientBase implements Command {

	private static final Log LOG = CustomizedLogFactory.getLog(GetCaseByIDCommand.class);
	
	@Autowired
	private MaskingService maskingService;
	
	@Override
	protected ObjectMapper resolvebjectMapper() {
		//serialize date as -08:00 - XXX means 3 chunks with ':' counted with one chunk
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
	public CaseType execute(Object oCaseId) throws Exception {

		String caseId = (String) oCaseId;

		try {
			WebService afmCaseManagementRestSvcConfig = this.getAfmCaseManagementRestSvcConfig();
			HttpHeaders headers = this.getHttpHeaderWithBasicAuthorization(afmCaseManagementRestSvcConfig);
	        
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			String uri = afmCaseManagementRestSvcConfig.getEndpointAddress() + "/afm-casemanagement-server/api/case/" + caseId;
			LOG.info("GetCaseById uri = '" + uri + "'"); 

			HttpEntity<String> requestEntity = new HttpEntity<>(headers);
			ResponseEntity<String> out = this.getRestTemplateDisablesCertificateVerification().exchange(uri, HttpMethod.GET, requestEntity,String.class);
			//ResponseEntity<String> out = this.getRestTemplate().exchange(uri, HttpMethod.GET, requestEntity,String.class);

			LOG.info("GetCaseById out.getStatusCode() = " + out.getStatusCode());
			
			String responseEntityBody = out.getBody();
			maskingService.maskAndLogJsonString(responseEntityBody);

			return this.deriveResultFromJson(responseEntityBody);

		} catch (HttpStatusCodeException e) {
			LOG.warn("GetCaseById HttpStatusCodeExceptions: " + e.getStatusCode() + " " + e.getStatusText()
			+": " + e.getResponseBodyAsString());
			LOG.warn("GetCaseById HttpStatusCodeExceptions wrapped header:" + e.getResponseHeaders());
			throw e;
		} catch (Exception e) {
			LOG.warn("GetCaseById REST exception", e);
			throw e;
		}

	}

	private CaseType deriveResultFromJson(String responseEntityBody) throws Exception{	 	 
		return this.fromJson(responseEntityBody, CaseType.class); 
	}

}