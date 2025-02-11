package com.telus.subsfraudmgmt.springboot.model.transaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telus.subsfraudmgmt.springboot.model.request.TUpdateCaseDispositionRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TUpdateCaseDispositionResponse;

public class UpdateCaseDispositionTransaction extends BaseTransaction{
	
	private TUpdateCaseDispositionRequest trequest;
	@JsonIgnore
	private TUpdateCaseDispositionResponse tresponse;
	
	public TUpdateCaseDispositionRequest getTrequest() {
		return trequest;
	}
	public void setTrequest(TUpdateCaseDispositionRequest trequest) {
		this.trequest = trequest;
	}
	public TUpdateCaseDispositionResponse getTresponse() {
		return tresponse;
	}
	public void setTresponse(TUpdateCaseDispositionResponse tresponse) {
		this.tresponse = tresponse;
	}
	
	 
	
}
