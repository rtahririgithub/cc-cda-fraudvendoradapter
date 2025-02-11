package com.telus.subsfraudmgmt.springboot.model.transaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telus.subsfraudmgmt.springboot.model.request.TDeleteFraudFileRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TFraudFileResponse;

public class DeleteFraudFileTransaction extends BaseTransaction{
	
	private TDeleteFraudFileRequest trequest;
	@JsonIgnore
	private TFraudFileResponse tresponse;
	
	public TDeleteFraudFileRequest getTrequest() {
		return trequest;
	}
	public void setTrequest(TDeleteFraudFileRequest trequest) {
		this.trequest = trequest;
	}
	public TFraudFileResponse getTresponse() {
		return tresponse;
	}
	public void setTresponse(TFraudFileResponse tresponse) {
		this.tresponse = tresponse;
	}
	
	
	
}
