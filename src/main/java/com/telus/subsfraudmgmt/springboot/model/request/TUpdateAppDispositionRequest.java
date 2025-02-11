package com.telus.subsfraudmgmt.springboot.model.request;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fico.afm.model.application.Disposition;
import com.telus.subsfraudmgmt.api.model.FraudActivityUpdate;

/**
 * Wrapper of the {@code updateAppDisposition} parameters and request body.
 * <p>we mark fraudAcitivityUpdate as jsonInclude.NON_NULL since we do not to persist in db and we can set it to null right before persist
 * <p>This is different from FraudMgmtSvc.
 * 
 * @author Harry Xu
 *
 */
public class TUpdateAppDispositionRequest extends AbstractTfmBaseRequest{
	/**
	 * parameter
	 */
	private String applicationId;
	/**
	 * TFM service client request which shall be set to null before insert into db
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private FraudActivityUpdate fraudActivityUpdate;
	
	public TUpdateAppDispositionRequest fraudActivityUpdate(FraudActivityUpdate fraudActivityUpdate) {
		this.setFraudActivityUpdate(fraudActivityUpdate);
		return this;
	}
	
	public FraudActivityUpdate getFraudActivityUpdate() {
		return fraudActivityUpdate;
	}

	public void setFraudActivityUpdate(FraudActivityUpdate fraudActivityUpdate) {
		this.fraudActivityUpdate = fraudActivityUpdate;
	}

	/**
	 * the AFM body
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private Disposition disposition;

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public Disposition getDisposition() throws Exception{
		return disposition;
	}

	public void setDisposition(Disposition disposition) {
		this.disposition = disposition;
	}

}
