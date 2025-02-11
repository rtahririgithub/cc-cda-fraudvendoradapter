package com.telus.subsfraudmgmt.springboot.service.command;

import java.util.Arrays;
import java.util.List;

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
import com.fico.afm.model.application.CaseType;
import com.fico.afm.model.application.Disposition;
import com.telus.subsfraudmgmt.springboot.config.Config.WebService;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.model.NoCaseExistException;
import com.telus.subsfraudmgmt.springboot.model.request.TUpdateCaseDispositionRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TUpdateCaseDispositionResponse;
import com.telus.subsfraudmgmt.springboot.service.RestServiceClientBase;
import com.telus.subsfraudmgmt.springboot.util.GeneralUtil;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer.ObjectMapperType;

@Component
public class UpdateCaseDispositionCommand extends RestServiceClientBase implements Command {

	private static final Log LOG = CustomizedLogFactory.getLog(UpdateCaseDispositionCommand.class);
	
	@Autowired
	private GetApplicationByIDCommand applicationByIDCommand;
	
	@Autowired
	private GetCaseByIDCommand caseByIdCommand;
	
	@Override
	protected ObjectMapper resolvebjectMapper() {
		//serialize date as -08:00 - XXX means 3 chunks with ':' counted with one chunk
		return ObjectMapperConfigurer.getConfiguredObjectMapper(ObjectMapperType.HONOR_XXX_DATE_TIME);
	}
	/**
	 * Execute {@code TUpdateCaseDispositionRequest} request.
	 * 
	 * <pre>
	 * AFM Return Status Codes include:  
	 *   200 OK
	 *   400 Bad Request
	 *   403 Forbidden
	 * </pre>
	 */
	@Override
	public TUpdateCaseDispositionResponse execute(Object tUpdateCaseDispositionRequest) throws Exception{
		
		LOG.info("It first get application by id,  then find case by caseId in application, finally update case dispostion...");
		
		TUpdateCaseDispositionRequest oRequest = (TUpdateCaseDispositionRequest) tUpdateCaseDispositionRequest;

		Application application = applicationByIDCommand.execute(oRequest.getApplicationId());
		if (application.getCaseDetails()==null || application.getCaseDetails().getCaseId()==0) {
			LOG.info("application found but either no case details or caseId is 0 - meaning no case Id!" );
			throw new NoCaseExistException("No case existed for applicationId: '" + oRequest.getApplicationId() + "'" );
		}

		long caseId = application.getCaseDetails().getCaseId();
		String oCaseId = Long.toString(caseId);

		LOG.info("find caseId: '" + oCaseId+"' for appId: '" + oRequest.getApplicationId());

		CaseType caseType  = this.caseByIdCommand.execute(oCaseId);
		
		try {
			Disposition disposition = caseType.getDisposition();
			if (disposition == null) {
				LOG.info("no case disposition yet for caseId: '" + caseId +"', just create new disposition");
				disposition = oRequest.getDisposition(); 
			}
			else {
				//copy non-null properties from request to existing, which returns property list that is null in request just for logging
				List<String> nullPropertiesInOrequest = GeneralUtil.copyNonNullProperties(oRequest.getDisposition(), disposition);
				LOG.info("Note: Following properties from request disposition has null value and not used to update case disposition: '" + nullPropertiesInOrequest +"'");	
			}
			caseType.setDisposition(disposition);
		    
			WebService afmCaseManagementRestSvcConfig = this.getAfmCaseManagementRestSvcConfig();
			HttpHeaders headers = this.getHttpHeaderWithBasicAuthorization(afmCaseManagementRestSvcConfig);
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);

			String uri = afmCaseManagementRestSvcConfig.getEndpointAddress() + "/afm-casemanagement-server/api/case/" + oCaseId;

			LOG.info("update case uri = '" + uri + "'");

			String jsonPayLoad = this.generateJson(caseType);

			LOG.info("update case jsonPayload: '" + jsonPayLoad + "'");

			HttpEntity<String> requestEntity = new HttpEntity<>(jsonPayLoad, headers);
			ResponseEntity<String> out = this.getRestTemplateDisablesCertificateVerification().exchange(uri, HttpMethod.PUT, requestEntity,String.class);
			//ResponseEntity<String> out = this.getRestTemplate().exchange(uri, HttpMethod.PUT, requestEntity,String.class);

			LOG.info("update case out.getStatusCode() = " + out.getStatusCode());

			return this.deriveResponse(out.getStatusCode());

		} catch (HttpStatusCodeException e) {
			LOG.warn("update case HttpStatusCodeExceptions: " + e.getStatusCode() + " " + e.getStatusText()
			+": " + e.getResponseBodyAsString());
			LOG.warn("UpdateCaseDispositionCommand HttpStatusCodeExceptions wrapped header:" + e.getResponseHeaders());
			throw e;
		} catch (Exception e) {
			LOG.warn("UpdateCaseDispositionCommand REST exception", e);
			throw e;
		}

	}

	private TUpdateCaseDispositionResponse deriveResponse(HttpStatus httpStatus) {
		TUpdateCaseDispositionResponse response = new TUpdateCaseDispositionResponse();
		response.setBackendHttpStatus(httpStatus);
		return response;
	}
	

}