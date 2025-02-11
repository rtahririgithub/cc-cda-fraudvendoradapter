package com.telus.subsfraudmgmt.springboot.model.response;

import com.fico.afm.model.application.CaseType;

/**
 * Wrapper of {@code UpdateCaseAppDisposition} response.
 * @author Harry Xu
 *
 */
public class TUpdateCaseDispositionResponse extends AbstractTfmBaseResponse {
	private CaseType caseType;

	public CaseType getCaseType() {
		return caseType;
	}

	public void setCaseType(CaseType caseType) {
		this.caseType = caseType;
	}
	
}
