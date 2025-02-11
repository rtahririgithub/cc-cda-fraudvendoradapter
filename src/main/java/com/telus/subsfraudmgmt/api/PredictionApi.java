package com.telus.subsfraudmgmt.api;

import com.telus.subsfraudmgmt.api.model.watson.Error;
import com.telus.subsfraudmgmt.api.model.watson.Prediction;
import com.telus.subsfraudmgmt.api.model.watson.PredictionPerform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@Component("com.telus.subsfraudmgmt.api.PredictionApi")
public class PredictionApi {
	@Autowired
    private ApiClient apiClient;

    public PredictionApi() {
        //this(new ApiClient());
    }

    @Autowired
    public PredictionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Clients can submit customer data to t the machine learning model and get a prediction back. ( the  AI is trained to perform fraud prediction)
     * Internal Server Error
     * <p><b>200</b> - request has been processed successfully
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - 
     * <p><b>417</b> - Expectation failed. If your API cannot accommodate asynchronous operations, but the consumer has requested it using the Expect header, reject it with this code.
     * <p><b>500</b> - Internal Server Error
     * @param body The  customer&#39;s activity ( such as subscriber activation activity/application/request) including customer , requested subscriber  , existing subscriber , credit , credit bureau data , etc. (optional)
     * @return Prediction
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Prediction prediction(PredictionPerform body) throws RestClientException {
        return predictionWithHttpInfo(body).getBody();
    }

    /**
     * Clients can submit customer data to t the machine learning model and get a prediction back. ( the  AI is trained to perform fraud prediction)
     * Internal Server Error
     * <p><b>200</b> - request has been processed successfully
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - 
     * <p><b>417</b> - Expectation failed. If your API cannot accommodate asynchronous operations, but the consumer has requested it using the Expect header, reject it with this code.
     * <p><b>500</b> - Internal Server Error
     * @param body The  customer&#39;s activity ( such as subscriber activation activity/application/request) including customer , requested subscriber  , existing subscriber , credit , credit bureau data , etc. (optional)
     * @return ResponseEntity&lt;Prediction&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Prediction> predictionWithHttpInfo(PredictionPerform body) throws RestClientException {
        Object postBody = body;
        
        //String path = UriComponentsBuilder.fromPath("/predictions").build().toUriString();
        //String path = UriComponentsBuilder.fromPath("/predictions?version=2021-08-27").build().toUriString();
        //per new  watsonai endpoint  deployed to GKE
        String path = UriComponentsBuilder.fromPath("").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "OAuth2" };

        ParameterizedTypeReference<Prediction> returnType = new ParameterizedTypeReference<Prediction>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
