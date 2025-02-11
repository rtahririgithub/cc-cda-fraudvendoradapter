package com.telus.subsfraudmgmt.springboot.service.command;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.secretmanager.SecretManagerTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fico.afm.model.application.ApplicationRequest;
import com.fico.afm.model.application.ApplicationResponse;
import com.telus.kong.api.security.AccessToken;
import com.telus.kong.api.security.TfmApiGatewayAdapter;
import com.telus.subsfraudmgmt.api.ApiClient;
import com.telus.subsfraudmgmt.api.PredictionApi;
import com.telus.subsfraudmgmt.api.model.FraudCheckDecisioningError;
import com.telus.subsfraudmgmt.api.model.FraudCheckPerform;
import com.telus.subsfraudmgmt.api.model.Party;
import com.telus.subsfraudmgmt.api.model.watson.Prediction;
import com.telus.subsfraudmgmt.springboot.config.Config.WebService;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.model.request.TApplicationRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TApplicationResponse;
import com.telus.subsfraudmgmt.springboot.model.response.TPredictionResponse;
import com.telus.subsfraudmgmt.springboot.service.MaskingService;
import com.telus.subsfraudmgmt.springboot.service.RestServiceClientBase;
import com.telus.subsfraudmgmt.springboot.util.AFMXmlUtil;
import com.telus.subsfraudmgmt.springboot.util.GeneralUtil;
import com.telus.subsfraudmgmt.springboot.util.JsonUtil;
import com.telus.subsfraudmgmt.springboot.util.LogUtil;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer.ObjectMapperType;
import com.telus.subsfraudmgmt.api.model.watson.Prediction;
import com.telus.subsfraudmgmt.api.model.watson.PredictionPerform;
import com.telus.subsfraudmgmt.api.model.watson.PredictionPerformInputData;
import com.telus.subsfraudmgmt.api.model.watson.Error;
import com.telus.subsfraudmgmt.api.model.watson.ErrorErrors;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
@Component
public class FraudPredictionCommand extends RestServiceClientBase implements Command {
	
	private static final Log LOG = CustomizedLogFactory.getLog(FraudPredictionCommand.class);
	
	@Autowired
	private MaskingService maskingService;
	
	@Autowired
	TfmApiGatewayAdapter adapter;
	
	@Autowired
	PredictionApi predictionApi;
	
	@Autowired
	ApiClient apiClient;
	
	@Autowired 
	SecretManagerTemplate secretManagerTemplate;
	String gcp_fraudPrediction_password_value=null;
	@Override
	protected ObjectMapper resolvebjectMapper() {
		//serialize date as -08:00 - XXX means 3 chunks with ':' counted with one chunk
		return ObjectMapperConfigurer.getConfiguredObjectMapper(ObjectMapperType.HONOR_XXX_DATE_TIME);
	}
	
	@PostConstruct
	public void initialize() throws Exception { 
		WebService fraudPredictionRestSvcConfig = config.getConnections().getWebService(FRAUD_PREDICTION_REST_SVC_CONFIG_NAME); 
		predictionApi.setApiClient(createAndConfigApiClient(fraudPredictionRestSvcConfig));	

	}
	/**
	 * Execute {@code TApplicationRequest} request.
	 * 
	 * <pre>
	 * AI Component Return Status Codes include: 
	 *   200 OK
	 *   400 Bad Request
	 *   403 Forbidden
	 * </pre>
	 */
	@Override
	public TPredictionResponse execute(Object predictionPerform) throws Exception{

		//TApplicationRequest oRequest = (TApplicationRequest) tApplicationRequest;
		PredictionPerform oPredictionPerform= (PredictionPerform) predictionPerform;
		TPredictionResponse response = new TPredictionResponse();
		

		//return oRequest.isPostXml()? postXml(oRequest): postJson(oRequest);
		try {
			//moved creating restapi client to load time
			/*
			WebService fraudPredictionRestSvcConfig = this.getFraudPredictionRestSvcConfig();
			final PredictionApi predictionApi= new PredictionApi();
			predictionApi.setApiClient(createAndConfigApiClient(fraudPredictionRestSvcConfig));					
			 */

			try {
				if(LOG.isInfoEnabled()) {
					String jsonPayLoad =JsonUtil.generateJsonPredict(oPredictionPerform, this.getObjectMapper());
					maskingService.maskAndLogJsonString(jsonPayLoad);
				}
				
			} catch (Exception e) {
			}

			
			
			//get token
			AccessToken tfmApiGwAccessToken = adapter.requestAccessToken();
			predictionApi.getApiClient().setAccessToken(tfmApiGwAccessToken.getAccessToken());


			//invoke api
			Prediction prediction=predictionApi.prediction(oPredictionPerform);			

			response.setFraudPredictionResponse(prediction);
		}catch (HttpStatusCodeException e) {
			
			try {
				String jsonPayLoad =JsonUtil.generateJsonPredict(oPredictionPerform, this.getObjectMapper());
				jsonPayLoad = maskingService.maskJsonSecureValues(jsonPayLoad);
				jsonPayLoad= LogUtil.leadingTrailingEscapeChar(LogUtil.removeBrkLine(jsonPayLoad));	
				LOG.error("predictionApi.prediction HttpStatusCodeException: " + LogUtil.getStackTrace(e) +  " request payload :" + jsonPayLoad);
			}catch(Throwable t) {}
			
			Error predictionError =createError(e.getStatusCode().toString(), e);
			response.setFraudPredictionResponseError(predictionError);
		} catch (RestClientException  clientEx) {
			try {
				String jsonPayLoad =JsonUtil.generateJsonPredict(oPredictionPerform, this.getObjectMapper());
				jsonPayLoad = maskingService.maskJsonSecureValues(jsonPayLoad);
				jsonPayLoad= LogUtil.leadingTrailingEscapeChar(LogUtil.removeBrkLine(jsonPayLoad));	
				LOG.error("predictionApi.prediction RestClientException: " + LogUtil.getStackTrace(clientEx) + " request payload :" +jsonPayLoad);
			}catch(Throwable t) {}
						
			String errorCd="Prediction_Rest_Client_Ex";
			if (clientEx instanceof HttpStatusCodeException )
       	    {
       		  HttpStatus status = ((HttpStatusCodeException) clientEx).getStatusCode();
       		  errorCd = status.toString();
       	     } 
			Error predictionError =createError(errorCd, clientEx);
			response.setFraudPredictionResponseError(predictionError);
		} catch (Throwable e) {
			try {
				String jsonPayLoad =JsonUtil.generateJsonPredict(oPredictionPerform, this.getObjectMapper());
				jsonPayLoad = maskingService.maskJsonSecureValues(jsonPayLoad);
				jsonPayLoad= LogUtil.leadingTrailingEscapeChar(LogUtil.removeBrkLine(jsonPayLoad));	
				LOG.error("predictionApi.prediction Throwable: " + LogUtil.getStackTrace(e) + " request payload :" + jsonPayLoad);
			}catch(Throwable t) {}
			
            Error predictionError =createError("unknown error",e);
            response.setFraudPredictionResponseError(predictionError);
        }finally {
        	
        }
			
		return response;


	}
	
	
	 public ApiClient createAndConfigApiClient(WebService fraudPredictionRestSvcConfig ) 
		{				
				adapter.setUserName(fraudPredictionRestSvcConfig.getUsername()); //from kong api gateway registration
				if(gcp_fraudPrediction_password_value==null || gcp_fraudPrediction_password_value.trim().isEmpty()) {
					gcp_fraudPrediction_password_value= secretManagerTemplate.getSecretString(fraudPredictionRestSvcConfig.getPassword());
				}				
				adapter.setPassword(gcp_fraudPrediction_password_value); //from kong api gateway registration
				adapter.setScopeId(fraudPredictionRestSvcConfig.getScopeId()); //TFM spotlight project id, from kong api gateway registration  
				adapter.setApigwTokenUrl(fraudPredictionRestSvcConfig.getTokenUrl()); //prod: https://apigw-pr.tsl.telus.com/token, non-pr:https://apigw-st.telus.com/st/token
				LOG.info("[Calling Kong API to get Access Token, Token Service Url:  " + fraudPredictionRestSvcConfig.getTokenUrl() +", scopeId: " + fraudPredictionRestSvcConfig.getScopeId() + " ]");
						
				AccessToken tfmApiGwAccessToken = adapter.requestAccessToken();
				if (tfmApiGwAccessToken !=null) {
					LOG.info("[Kong API access token]: " + tfmApiGwAccessToken.getAccessToken());
				}			
				
				
				//final ApiClient apiClient = new ApiClient();
				apiClient.setDebugging(true);
				if (tfmApiGwAccessToken !=null) {
					apiClient.setAccessToken(tfmApiGwAccessToken.getAccessToken());
				}
				apiClient.setBasePath(fraudPredictionRestSvcConfig.getEndpointAddress());
				LOG.info("[Calling Kong API, Fraud Prediction Service URL (base):  " +  fraudPredictionRestSvcConfig.getEndpointAddress() +"]");
				return apiClient;
			
		}
	
	//create prediction Error
	private Error createError(String errorCode, Throwable e) {
		String errorMsg=GeneralUtil.getStackTrace(e);
		Error predictionError =new Error();
		ErrorErrors anError=new ErrorErrors();
		anError.setCode(errorCode);
		anError.setMessage(errorMsg);
		predictionError.addErrorsItem(anError);	
		
		return predictionError;
	}
	
//	private TPredictionResponse deriveResultFromJson(HttpStatus httpStatus, ResponseEntity<String> out) throws Exception{
//		TPredictionResponse response = new TPredictionResponse();
//		response.setBackendHttpStatus(httpStatus);
//		Prediction fraudPredictionResponse= this.fromJson(out.getBody(), Prediction.class);
//		response.setFraudPredictionResponse(fraudPredictionResponse);
//
//		return response;
//	}
	
     
	
}
