package com.telus.subsfraudmgmt.springboot.model.transaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telus.subsfraudmgmt.springboot.model.request.TUpdateFraudFileRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TFraudFileResponse;

public class UpdateFraudFileTransaction extends BaseTransaction{
	
	private TUpdateFraudFileRequest trequest;
	@JsonIgnore
	private TFraudFileResponse tresponse;
	
	public TUpdateFraudFileRequest getTrequest() {
		return trequest;
	}
	public void setTrequest(TUpdateFraudFileRequest trequest) {
		this.trequest = trequest;
	}
	public TFraudFileResponse getTresponse() {
		return tresponse;
	}
	public void setTresponse(TFraudFileResponse tresponse) {
		this.tresponse = tresponse;
	}
	
	
}
