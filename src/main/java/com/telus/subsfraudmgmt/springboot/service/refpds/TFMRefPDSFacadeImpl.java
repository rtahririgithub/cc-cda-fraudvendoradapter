package com.telus.subsfraudmgmt.springboot.service.refpds;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Component;
import com.fico.afm.model.application.ApplicationResponse;
import com.telus.subsfraudmgmt.api.model.watsonsimulator.WatsonResponseModel;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLog;
import com.telus.subsfraudmgmt.springboot.model.response.TPredictionResponse;
import com.telus.subsfraudmgmt.springboot.util.GeneralUtil;

/**
 * see <code>TfmRefPdsFacadeITTest</code> for an IT test
 * @author Harry Xu
 *
 */
@Component
public class TFMRefPDSFacadeImpl extends RefPDSAdapter implements TFMRefPDSFacade {
	private  static final Log LOG = new CustomizedLog(TFMRefPDSFacadeImpl.class.getName());

	// private String endPoint = "http://utilmgtsvcwest.tsl.telus.com/telus-ref-rpds-webservices/ReferencePDSDataService";

	public TFMRefPDSFacadeImpl() throws Exception {
		super();
	}


	public boolean isRTFDSimulatorIndicatorOn(String env){

		
		for (OperationParamRow row: this.safeList(this.getCandidateOperationParamRows())) {
			if (env.equalsIgnoreCase(row.getEnvNum())) {
				return "on".equalsIgnoreCase(row.getValue()) || "true".equalsIgnoreCase(row.getValue());
			}
		}
		LOG.warn("WLS_RTFD_SIMULATOR_IND not configured on for env: '" + env+"'");
		return false;
	}

	public boolean isWatsonSimulatorIndicatorOn(String env){

		
		for (OperationParamRow row: this.safeList(this.getFraudAISimulatorOperationParamRows())) {
			if (env.equalsIgnoreCase(row.getEnvNum())) {
				return "on".equalsIgnoreCase(row.getValue()) || "true".equalsIgnoreCase(row.getValue());
			}
		}
		LOG.warn("WATSON_WLS_DORMANT_FLAG not configured on for env: '" + env+"'");
		return false;
	}
	
	 public boolean isFraudAIDormantOn(String env) {

		for (OperationParamRow row: this.safeList(this.getFraudAIDormantOperationParamRows())) {
			if (env.equalsIgnoreCase(row.getEnvNum())) {
				return "on".equalsIgnoreCase(row.getValue()) || "true".equalsIgnoreCase(row.getValue());
			}
		}
		LOG.warn("WATSON_DORMANT not configured on for env: '" + env+"'");
		return false;
		
	}

	/**
	 * simulateKey should be last 2 characters of the first name, and default key is DFLT 
	 */
	public ApplicationResponse getApplicationResponse(String simulateKey){

	
		ApplicationResponse response= this.getSimulationKeyToAfmApplicationResponseMap().get(simulateKey.toUpperCase());
		if (response==null) {
			//use value from default key
			response = this.getSimulationKeyToAfmApplicationResponseMap().get(defaultKey());
			LOG.info("No simulation entry for '" + simulateKey +"', used default entry by key '" + defaultKey() + "'");
			
		}
		return response;

	}
	
	/**
	 * simulateKey should be last 2 characters of the first name, and default key is DFLT 
	 */
	public TPredictionResponse getWatsonResponse(String watsonSimulateKey){

	
		TPredictionResponse response= this.getWatsonSimulationKeyToWatsonResponseMap().get(watsonSimulateKey.toUpperCase());
		if (response==null) {
			//use value from default key
			response = this.getWatsonSimulationKeyToWatsonResponseMap().get(defaultKey());
			LOG.info("No simulation entry for '" + watsonSimulateKey +"', used default entry by key '" + defaultKey() + "'");
			
		}
		return response;

	}

	private String defaultKey() {
		return "DFLT";
	}


}
