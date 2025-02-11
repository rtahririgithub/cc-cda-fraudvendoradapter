package com.telus.subsfraudmgmt.springboot.service.refpds;

import com.fico.afm.model.application.ApplicationResponse;
import com.telus.subsfraudmgmt.api.model.watsonsimulator.WatsonResponseModel;
import com.telus.subsfraudmgmt.springboot.model.response.TPredictionResponse;

public interface TFMRefPDSFacade {
	boolean isRTFDSimulatorIndicatorOn(String env); 
	boolean isWatsonSimulatorIndicatorOn(String env);
	boolean isFraudAIDormantOn(String env);
	ApplicationResponse getApplicationResponse(String simulateKey);
	//WatsonResponseModel getWatsonResponse(String watsonSimulateKey);
	TPredictionResponse getWatsonResponse(String watsonSimulateKey);
}
