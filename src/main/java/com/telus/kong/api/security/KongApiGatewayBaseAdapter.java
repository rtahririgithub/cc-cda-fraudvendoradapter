package com.telus.kong.api.security;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * The API access token retriever for a scope id.
 * <p>it may need to use proxy server.
 *  @author Reza, Harry
 */
@Service
public abstract class KongApiGatewayBaseAdapter {

	private static Logger log = LoggerFactory.getLogger(KongApiGatewayBaseAdapter.class);


	//@Value("${kong.accesstoken.username}")
	private String userName;
	
	//@Value("${kong.accesstoken.password}")
	private String password;
	
	//@Value("${kong.accesstoken.url}")
	private String apigwTokenUrl;

	//RestTemplate restTemplate;
	 @Autowired
	  private RestTemplate myRestTemplate;
	 
	@Value("${isProxyEnabled:false}")
	private boolean isProxyEnabled;
	
	@Value("${proxyHost:#{null}}")
	private String proxyHost;

	@Value("${proxyPort:#{null}}")
	private int proxyPort;
		
	protected AccessToken retrieveApiGWAccessToken(String scopeId) {
		//headers
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Content-Type", "application/x-www-form-urlencoded");
		
		String credentials = userName + ":" + password;
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
		headers.add("Authorization", "Basic " + encodedCredentials);
		
		//set parameters
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			map.add("grant_type", "client_credentials");
			map.add("scope", scopeId);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		myRestTemplate = buildRestTemplate();
		ResponseEntity<String> response = null;
		if (isProxyEnabled) {
			System.setProperty("https.proxyHost", "");
			System.setProperty("https.proxyPort", "");
		}
		try {
		    //invoke api gw token svc
			response = myRestTemplate.exchange(apigwTokenUrl, HttpMethod.POST, request, String.class);
		} catch (org.springframework.web.client.ResourceAccessException e1) {
			throw new SecurityException("getting AccessToken from ApiGW <" + apigwTokenUrl + "> failed. " + e1.getMessage() , e1);			
		} catch (RestClientException e1) {
			throw new SecurityException("getting AccessToken from ApiGW <" + apigwTokenUrl + "> failed. " + e1.getMessage() , e1);			
		}catch (java.lang.SecurityException e1) {
			throw new SecurityException("getting AccessToken from ApiGW <" + apigwTokenUrl + "> failed. " + e1.getMessage() , e1);			
		}catch (RuntimeException t) {
			throw new SecurityException("getting AccessToken from ApiGW <" + apigwTokenUrl + "> failed. " + t.getMessage() , t);		
		}
		catch (Throwable t) {
			throw new SecurityException("getting AccessToken from ApiGW <" + apigwTokenUrl + "> failed. " + t.getMessage() , t);		
		}
		
		java.time.LocalDateTime inst = java.time.LocalDateTime.now();
		HttpStatus status = response.getStatusCode();
		if (!HttpStatus.OK.equals(status)) {
			throw new SecurityException(response.toString() + ":"  + response.getStatusCodeValue() +  "," + response.toString() + ":" + response.getBody());
		}
		
		//parse as AccessToken and refresh_token
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(response.getBody());
			AccessToken oauth2AccessToken = new AccessToken();
			oauth2AccessToken.setAccessToken(node.path("access_token").asText());
			oauth2AccessToken.setTokenType(node.path("token_type").asText());
			oauth2AccessToken.setExpiresIn(node.path("expires_in").asLong());
			oauth2AccessToken.setFetchedLocalDateTime(inst);
		 
			return oauth2AccessToken;
		} catch (Exception e) {
			throw new SecurityException("Failed to parse access token: " + response.toString() + ":" + response.getBody(), e);
		}		

	}


	private RestTemplate buildRestTemplate() {
		//proxy added for timeout error during local testing, but have to be for this restTemplate only otherwise main url will not work
	    //System.setProperty("https.proxyHost", "pac.tsl.telus.com");
	   // System.setProperty("https.proxyPort", "8080");		
		if(myRestTemplate==null) {
			SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();        
			if (this.proxyHost!=null && !this.proxyHost.trim().isEmpty()) {
				Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(this.proxyHost, this.proxyPort));
				requestFactory.setProxy(proxy);
			}
			myRestTemplate=new RestTemplate(requestFactory);
		}
	    return myRestTemplate;
		 
	}

	
	protected Boolean isAccessTokenExpired(AccessToken latestAccessToken) {
		if (latestAccessToken != null) {
			Long expiresIn = latestAccessToken.getExpiresIn();
			java.time.LocalDateTime fetchedLocalTime = latestAccessToken.getFetchedLocalDateTime();
			java.time.LocalDateTime tokenExpireTime = fetchedLocalTime.plusSeconds(expiresIn);
			return java.time.LocalDateTime.now().isAfter(tokenExpireTime);			 
		} else {
			return true;
		}
		 
	}	
 



	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setApigwTokenUrl(String apigwTokenUrl) {
		this.apigwTokenUrl = apigwTokenUrl;
	}
	
}
