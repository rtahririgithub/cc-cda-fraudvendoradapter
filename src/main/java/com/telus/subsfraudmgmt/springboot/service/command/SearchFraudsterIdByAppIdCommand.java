package com.telus.subsfraudmgmt.springboot.service.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fico.afm.model.application.Individual;
import com.telus.subsfraudmgmt.springboot.config.Config.WebService;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.service.RestServiceClientBase;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer.ObjectMapperType;

/**
 * This was used by <code>DelteFraudFileCommand</code> to get fraudFileId list from application id.
 * 
 * @author Harry Xu
 *
 */
@Component
public class SearchFraudsterIdByAppIdCommand extends RestServiceClientBase implements Command {

	private static final Log LOG = CustomizedLogFactory.getLog(SearchFraudsterIdByAppIdCommand.class);
	
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
	public List<String> execute(Object oApplicationId) throws Exception {

		String applicationId = (String) oApplicationId;

		try {
			WebService afmCaseManagementRestSvcConfig = this.getAfmCaseManagementRestSvcConfig();
			HttpHeaders headers = this.getHttpHeaderWithBasicAuthorization(afmCaseManagementRestSvcConfig);
	        
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			
            String uri = afmCaseManagementRestSvcConfig.getEndpointAddress() + "/afm-casemanagement-server/api/fraudfile/search?applicationId=" + applicationId;
			LOG.info("SearchFraudsterIdByAppIdCommand uri = '" + uri + "'"); 

			HttpEntity<String> requestEntity = new HttpEntity<>(headers);
			ResponseEntity<String> out = this.getRestTemplateDisablesCertificateVerification().exchange(uri, HttpMethod.GET, requestEntity,String.class);
			//ResponseEntity<String> out = this.getRestTemplate().exchange(uri, HttpMethod.GET, requestEntity,String.class);

			LOG.info("SearchFraudsterIdByAppIdCommand out.getStatusCode() = " + out.getStatusCode());
			
			String responseEntityBody = out.getBody();
			LOG.info("SearchFraudsterIdByAppIdCommand out.body() is suppressed since it contains sensitive info!");

			return this.deriveResultFromJson(responseEntityBody);

		} catch (HttpStatusCodeException e) {
			LOG.warn("SearchFraudsterIdByAppIdCommand HttpStatusCodeExceptions: " + e.getStatusCode() + " " + e.getStatusText()
			+ e.getResponseBodyAsString());

			throw e;
		} catch (Exception e) {
			LOG.warn("SearchFraudsterIdByAppIdCommand REST exception", e);
			throw e;
		}
	}

	private List<String> deriveResultFromJson(String responseEntityBody) throws Exception{
		List<String> result = new ArrayList<>();
		JsonNode contentNode = this.getObjectMapper().readTree(responseEntityBody).get("content");
	 
		List<Individual> frandsters = this.getObjectMapper().readValue(contentNode.toString(), new TypeReference<List<Individual>>(){});
		for (Individual individual: frandsters) {
			if (individual.getId() !=null) {
				result.add(String.valueOf(individual.getId()));
			}
		}
		LOG.info("searchFraudsterByAppId find fraudsters: '" + result.toString()+"'");
		return result;
	}

}