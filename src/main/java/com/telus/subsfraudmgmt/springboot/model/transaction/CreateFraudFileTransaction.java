package com.telus.subsfraudmgmt.springboot.model.transaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telus.subsfraudmgmt.springboot.model.request.TCreateFraudFileRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TFraudFileResponse;

public class CreateFraudFileTransaction extends BaseTransaction{
	
	private TCreateFraudFileRequest trequest;
	@JsonIgnore
	private TFraudFileResponse tresponse;
	
	public TCreateFraudFileRequest getTrequest() {
		return trequest;
	}
	public void setTrequest(TCreateFraudFileRequest trequest) {
		this.trequest = trequest;
	}
	public TFraudFileResponse getTresponse() {
		return tresponse;
	}
	public void setTresponse(TFraudFileResponse tresponse) {
		this.tresponse = tresponse;
	}
	
	
	
}
