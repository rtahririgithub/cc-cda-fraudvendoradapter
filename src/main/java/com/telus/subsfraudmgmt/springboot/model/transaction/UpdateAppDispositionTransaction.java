package com.telus.subsfraudmgmt.springboot.model.transaction;

/**
 * In here, we do not mark tresponse as jsonIgnore, since we want to persist to database when there is an error
 * <p>This is different from FraudMgmtSvc.
 */
import com.telus.subsfraudmgmt.springboot.model.request.TUpdateAppDispositionRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TUpdateAppDispositionResponse;

public class UpdateAppDispositionTransaction extends BaseTransaction{
	private long accountId;
	private TUpdateAppDispositionRequest trequest;
	private TUpdateAppDispositionResponse tresponse;
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public TUpdateAppDispositionRequest getTrequest() {
		return trequest;
	}
	public void setTrequest(TUpdateAppDispositionRequest trequest) {
		this.trequest = trequest;
	}
	public TUpdateAppDispositionResponse getTresponse() {
		return tresponse;
	}
	public void setTresponse(TUpdateAppDispositionResponse tresponse) {
		this.tresponse = tresponse;
	}
	
}
