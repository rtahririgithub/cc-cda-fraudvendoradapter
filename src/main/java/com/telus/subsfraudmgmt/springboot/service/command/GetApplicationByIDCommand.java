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
import com.fico.afm.model.application.Application;
import com.telus.subsfraudmgmt.springboot.config.Config.WebService;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.model.ApplicationNotExistException;
import com.telus.subsfraudmgmt.springboot.service.MaskingService;
import com.telus.subsfraudmgmt.springboot.service.RestServiceClientBase;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer.ObjectMapperType;


/**
 * This was used by <code>UpdateCaseDispositionCommand</code> to get case id from application id.
 * 
 * @author Harry Xu
 *
 */
@Component
public class GetApplicationByIDCommand extends RestServiceClientBase implements Command {

	private static final Log LOG = CustomizedLogFactory.getLog(GetApplicationByIDCommand.class);
	
	@Autowired
	private MaskingService maskingService;
	
	@Override
	protected ObjectMapper resolvebjectMapper() {
		//serialize date as -08:00 - XXX means 3 chunks with ':' counted with one chunk
		return ObjectMapperConfigurer.getConfiguredObjectMapper(ObjectMapperType.HONOR_XXX_DATE_TIME);
	}

	/**
	 * Execute retrieve application by application id request.
	 * 
	 * <pre>
	 * AFM Return Status Codes include: 
	 *   200 OK
	 *   400 Bad Request
	 *   403 Forbidden
	 * </pre>
	 */
	@Override
	public Application execute(Object oApplicationId) throws Exception {

		String applicationId = (String) oApplicationId;

		try {
			WebService afmCaseManagementRestSvcConfig = this.getAfmCaseManagementRestSvcConfig();
			HttpHeaders headers = this.getHttpHeaderWithBasicAuthorization(afmCaseManagementRestSvcConfig);
	        
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			
            String uri = afmCaseManagementRestSvcConfig.getEndpointAddress() + "/afm-casemanagement-server/api/case/application/" + applicationId;
			LOG.info("GetApplicationByIDCommand uri = '" + uri + "'"); 

			HttpEntity<String> requestEntity = new HttpEntity<>(headers);
			ResponseEntity<String> out = this.getRestTemplateDisablesCertificateVerification().exchange(uri, HttpMethod.GET, requestEntity,String.class);
			//ResponseEntity<String> out = this.getRestTemplate().exchange(uri, HttpMethod.GET, requestEntity,String.class);

			LOG.info("GetApplicationByIDCommand out.getStatusCode() = " + out.getStatusCode());
			
			String responseEntityBody = out.getBody();
			 
			//maskingService.maskAndLogJsonString(responseEntityBody);
			LOG.info("GetApplicationByID found application by id, but logging is suppressed due to big data and sensitive info!");

			return this.deriveResultFromJson(responseEntityBody);

		} catch (HttpStatusCodeException e) {
			LOG.warn("GetApplicationByID HttpStatusCodeExceptions: " + e.getStatusCode() + ": " + e.getStatusText()
			+ e.getResponseBodyAsString());

			if (HttpStatus.NOT_FOUND.equals(e.getStatusCode())) {
				throw new ApplicationNotExistException("application does not exist with id: '" + applicationId +"'");
			}
			throw e;
		} catch (Exception e) {
			LOG.warn("GetApplicationByID REST exception", e);
			throw e;
		}
	}

	private Application deriveResultFromJson(String responseEntityBody) throws Exception{	 	 
		return this.fromJson(responseEntityBody, Application.class); 
	}

}