package com.telus.subsfraudmgmt.springboot.model.request;

import com.telus.subsfraudmgmt.api.model.Body;

/**
 * Wrapper of the {@code DeleteFraudFile} parameters and request body which
 * contains the applicationId for which all associated fraud files need to be
 * deleted.
 * 
 * @author Harry Xu
 *
 */
public class TDeleteFraudFileRequest extends AbstractTfmBaseRequest{
	/**
	 * Open api input
	 */
	private Body body;

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}
}
