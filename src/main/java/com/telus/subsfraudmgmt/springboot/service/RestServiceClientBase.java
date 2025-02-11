package com.telus.subsfraudmgmt.springboot.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;

import org.apache.commons.logging.Log;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.secretmanager.SecretManagerTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telus.subsfraudmgmt.springboot.config.Config;
import com.telus.subsfraudmgmt.springboot.config.Config.WebService;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.util.JsonUtil;



/**
 * The base class for REST web service client
 * 
 */
public abstract class RestServiceClientBase { 
	private static final String TFM_FRAUDVENDORADAPTERSVC = "tfmFraudvendoradaptersvc";
	private static final String AFM_SCORING_REST_SVC_CONFIG_NAME = "afmScoringRestSvc";
	private static final String AFM_CASE_MANAGEMENT_REST_SVC_CONFIG_NAME = "afmCaseManagementRestSvc";
	private static final String TELUS_PUB_REST_SVC_CONFIG_NAME = "telusPubRestSvc";
	protected static final String FRAUD_PREDICTION_REST_SVC_CONFIG_NAME="fraudPredictionRestSvc";
	
	@Autowired 
	SecretManagerTemplate secretManagerTemplate;
	private Log log = CustomizedLogFactory.getLog(this.getClass());
	
	@Autowired
	protected Config config;
    
	public void setConfig(Config config) {
		this.config = config;
	}

	private WebService afmScoreServerRestSvcConfig;
	private WebService afmCaseManagementRestSvcConfig;
	//private WebService telusPubRestSvcConfig;
	private WebService tfmFraudvendoradaptersvcConfig;
	private WebService fraudPredictionRestSvcConfig;

	//private RestTemplate restTemplate; 
	@Autowired
	private RestTemplate myRestTemplate;	
	
	//private RestTemplate restTemplateDisablesCertificateVerification;
	@Autowired
	RestTemplate myRestTemplateDisablesCertificateVerification;
	
	private ObjectMapper objectMapper;

	

	/**
	 * Config will not be set in construct, and we use PostConstruct to initialize.
	 */
	public RestServiceClientBase() {
		
	}
	
	/**
	 * Invoked by spring boot to initialize RestTemplate.
	 * <p>Do not remove
	 */
	@PostConstruct
	public void initialize() throws Exception {
		log.info("initializing by @PostConstruct: " + this.getClass());
		  	
		this.setRestTemplate(buildRestTemplateInternal());
		this.setRestTemplateDisablesCertificateVerification(buildRestTemplateInternalDisablesCertificateVerification());
		
		this.setObjectMapper(resolvebjectMapper());
		//get from application.ymal 
		if (config!=null && config.getConnections()!=null) {
			WebService fraudPredictionRestSvcConfig = config.getConnections().getWebService(FRAUD_PREDICTION_REST_SVC_CONFIG_NAME); 
			if (fraudPredictionRestSvcConfig!=null) {
				this.setFraudPredictionRestSvcConfig(fraudPredictionRestSvcConfig);
			}
			WebService scoreWebServiceConfig = config.getConnections().getWebService(AFM_SCORING_REST_SVC_CONFIG_NAME); 
			if (scoreWebServiceConfig!=null) {
				this.setAfmScoreServerRestSvcConfig(scoreWebServiceConfig);
			}
			WebService caseManagementWebServiceConfig = config.getConnections().getWebService(AFM_CASE_MANAGEMENT_REST_SVC_CONFIG_NAME); 
			if (caseManagementWebServiceConfig!=null) {
				this.setAfmCaseManagementRestSvcConfig(caseManagementWebServiceConfig);
			}
			/*
			WebService telusPubRestSvcConfig = config.getConnections().getWebService(TELUS_PUB_REST_SVC_CONFIG_NAME); 
			if (telusPubRestSvcConfig!=null) {
				this.setTelusPubRestSvcConfig(telusPubRestSvcConfig);
			}
			*/
			WebService tfmFraudvendoradaptersvcConfig = config.getConnections().getWebService(TFM_FRAUDVENDORADAPTERSVC); 
			if (tfmFraudvendoradaptersvcConfig!=null) {
				this.setTfmFraudvendoradaptersvcConfig(tfmFraudvendoradaptersvcConfig);
			}
		}else {
			log.warn("config or config.getConnections() is null!");
		}
	}

	//TO support french characters so that "city":"MONTRÉAL" is good
	
	private RestTemplate buildRestTemplateInternal() {
    	if(myRestTemplate==null) {
    		myRestTemplate = new RestTemplate();    			
			List<HttpMessageConverter<?>> converters = myRestTemplate.getMessageConverters();
			converters.removeIf(httpMessageConverter -> httpMessageConverter instanceof StringHttpMessageConverter);
			converters.add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
    	}
		return myRestTemplate;
	}

	private RestTemplate buildRestTemplateInternalDisablesCertificateVerification() throws Exception  { 
		if(myRestTemplateDisablesCertificateVerification==null) {
		     try {
				// Create a custom SSL context that trusts all certificates
				SSLContext sslContext = SSLContextBuilder.create().loadTrustMaterial(new TrustAllStrategy()).build();
	
				// Configure the HttpClient to use the custom SSL context and disable hostname verification
				HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
				requestFactory.setHttpClient(HttpClients.custom()
				        .setSSLContext(sslContext)
				        .setSSLHostnameVerifier(new NoopHostnameVerifier())
				        .build());
	
				// Create a custom RestTemplate using the custom HttpClient
				myRestTemplateDisablesCertificateVerification = new RestTemplate(requestFactory);
				 
				List<HttpMessageConverter<?>> converters = myRestTemplateDisablesCertificateVerification.getMessageConverters();
				converters.removeIf(httpMessageConverter -> httpMessageConverter instanceof StringHttpMessageConverter);
				converters.add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
		}
		return myRestTemplateDisablesCertificateVerification;
	}
		
	public WebService getFraudPredictionRestSvcConfig() {
		return fraudPredictionRestSvcConfig;
	}

	public void setFraudPredictionRestSvcConfig(WebService fraudPredictionRestSvcConfig) {
		this.fraudPredictionRestSvcConfig = fraudPredictionRestSvcConfig;
	}
	
	public WebService getAfmScoreServerRestSvcConfig() {
		return afmScoreServerRestSvcConfig;
	}

	public void setAfmScoreServerRestSvcConfig(WebService afmScoreServerRestSvcConfig) {
		this.afmScoreServerRestSvcConfig = afmScoreServerRestSvcConfig;
	}

	public WebService getAfmCaseManagementRestSvcConfig() {
		return afmCaseManagementRestSvcConfig;
	}

	public void setAfmCaseManagementRestSvcConfig(WebService afmCaseManagementRestSvcConfig) {
		this.afmCaseManagementRestSvcConfig = afmCaseManagementRestSvcConfig;
	}
	/*
	public WebService getTelusPubRestSvcConfig() {
		return telusPubRestSvcConfig;
	}

	public void setTelusPubRestSvcConfig(WebService telusPubRestSvcConfig) {
		this.telusPubRestSvcConfig = telusPubRestSvcConfig;
	}
	*/
	public WebService getTfmFraudvendoradaptersvcConfig() {
		return tfmFraudvendoradaptersvcConfig;
	}

	public void setTfmFraudvendoradaptersvcConfig(WebService tfmFraudvendoradaptersvc) {
		this.tfmFraudvendoradaptersvcConfig = tfmFraudvendoradaptersvc;
	}

	/**
	 * Retrieves the template to be used for REST service calls.
	 *
	 * @return The template for REST operations.
	 */

	public RestTemplate getRestTemplate() {
		return myRestTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.myRestTemplate = restTemplate;
	}
	public RestTemplate getRestTemplateDisablesCertificateVerification() {
		return myRestTemplateDisablesCertificateVerification;
	}

	public void setRestTemplateDisablesCertificateVerification(RestTemplate val) {
		this.myRestTemplateDisablesCertificateVerification = val;
	}
	
	/**
	 * Basic Authorization for REST API needed for the RestTemplate object.
	 */

	public HttpHeaders getHttpHeaderWithBasicAuthorization(WebService webService) {
		HttpHeaders headers = new HttpHeaders();
		
		String gcp_afm_password_value= secretManagerTemplate.getSecretString(webService.getPassword());	
		gcp_afm_password_value=(gcp_afm_password_value!=null)?gcp_afm_password_value.trim():null;
		String auth = webService.getUsername() + ":" + gcp_afm_password_value;

		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("UTF-8")));

		String authHeader = "Basic " + new String(encodedAuth);
		headers.set("Authorization", authHeader);

		return headers;
	}

	/**
	 * Generates the URL parameter of the given map.
	 *
	 * @param map The map to be processed.
	 * @return The URL parameter string representation.
	 */
	protected String generateParamUrl(Map<String, String> map) {
		StringBuilder builder = null;

		for (Map.Entry<String, String> entry : map.entrySet()) {
			String currentKey = entry.getKey();
			String value = entry.getValue();
			if (!isEmpty(value)) {
				if (builder == null) {
					builder = new StringBuilder("?");
					builder.append(currentKey + "=" + value);
				} else {
					builder.append("&" + currentKey + "=" + value);
				}
			}
		}
		return (builder == null) ? "" : builder.toString();
	}

	private static boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();

	}
	
	/**
	 * Enforce each command to determine appropriate <code>ObjectMapper</code>
	 * <p>THis is necessary since AFM requires different serialization format for xsd:date and xsd:datetime
	 * @return the appropriate <code>ObjectMapper</code>
	 */
	protected abstract ObjectMapper resolvebjectMapper();
	
	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
	
	/**
	 * Generates JSON string of the given object based on annotation and default object mapper
	 *
	 * @param request The object to be processed.
	 * @return The JSON string representation.
	 */
	public String generateJson(Object request) throws JsonProcessingException {
		return JsonUtil.generateJson(request, this.getObjectMapper());

	}
	 
	public <T> T fromJson(String json, Class<T> t) throws JsonMappingException, JsonParseException, IOException  {
		return (T) JsonUtil.fromJson(json, t, this.getObjectMapper());

	}
	
}
