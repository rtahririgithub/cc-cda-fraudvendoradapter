package com.telus.kong.api.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The API access token retriever for tfm service scope id
 * <p>It only retrieves token for TFM api, and it may need to use proxy server.
 *  @author Reza, Harry
 */

@Component
public class TfmApiGatewayAdapter extends KongApiGatewayBaseAdapter{

	private static Logger log = LoggerFactory.getLogger(TfmApiGatewayAdapter.class);
	
	//@Value("${kong.scopeId.tfmsvc}")
	private String scopeId;	//the spotlight projectId
	
	private AccessToken latestAccessToken;
	
	public TfmApiGatewayAdapter() {
	}
	public AccessToken requestAccessToken() {
		if (isAccessTokenExpired(this.latestAccessToken)) {
			// get a new  access token (jwt)	
			this.latestAccessToken= retrieveApiGWAccessToken(this.scopeId);	
		}							
		return this.latestAccessToken;
	}

	public String getScopeId() {
		return scopeId;
	}

	public void setScopeId(String scopeId) {
		this.scopeId = scopeId;
	}
	
}
