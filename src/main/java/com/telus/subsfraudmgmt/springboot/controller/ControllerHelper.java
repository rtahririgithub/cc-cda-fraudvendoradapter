package com.telus.subsfraudmgmt.springboot.controller;

import java.security.Principal;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import com.telus.subsfraudmgmt.api.model.Error;
import com.telus.subsfraudmgmt.springboot.config.Config;
import com.telus.subsfraudmgmt.springboot.model.response.AbstractTfmBaseResponse;

/**
 * A helper class to be used by concrete api implementation controllers.
 * @author Harry Xu
 *
 */
@Component
public class ControllerHelper {

	@Autowired
	private Config config;
	
	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public PreProcessResult preProcess(HttpServletRequest request, String... preferredRequestId) {
		
		String requestId = null;
		if (preferredRequestId!=null && preferredRequestId.length >0) {
			requestId = preferredRequestId[0];
		}else {
			requestId = request.getParameter("requestId");
			if (requestId != null) { 
				requestId = "t-" + requestId;
			} else {
				//this app generates one if not passed from other application 
				requestId = "tfm-" + UUID.randomUUID().toString();
			}
		}
		

		Principal principal = request.getUserPrincipal();
		String principalName= ((principal==null)? null: principal.getName());
		return new PreProcessResult().requestId(requestId).principalName(principalName);

	}

	public void populateErrorResponse(AbstractTfmBaseResponse response, Exception e) {
		
		HttpStatus backendHttpStatus = null;	
		if (e instanceof HttpStatusCodeException) {
			HttpStatusCodeException o = (HttpStatusCodeException)e;
			backendHttpStatus= o.getStatusCode();	
		}else {
			backendHttpStatus= HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		Error error = new Error();
		error.code(String.valueOf(backendHttpStatus.value()));
		error.setReason(backendHttpStatus.name());
		error.setExceptionText(e.getMessage());
		
		response.setBackendHttpStatus(backendHttpStatus);
		response.setError(error);
	}

	public static class PreProcessResult {
		private String requestId;
		private String principalName;

		public PreProcessResult(){

		}
		public PreProcessResult requestId(String value) {
			this.requestId = value;
			return this;
		}

		public PreProcessResult principalName(String value) {
			this.principalName = value;
			return this;
		}
		public String getRequestId() {
			return requestId;
		}
		public String getPrincipalName() {
			return principalName;
		}

	}
}
