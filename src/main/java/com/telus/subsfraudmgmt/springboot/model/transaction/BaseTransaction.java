package com.telus.subsfraudmgmt.springboot.model.transaction;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Base transaction class.
 * @author Harry Xu
 *
 */
public class BaseTransaction {
	//the original request id from application client.  
	private String requestId;
	private TransactionType type;
	private TransactionSubType subType;
	private OffsetDateTime createTime;
 	
	/**
	 * The object mapper to override  to convert object to json to publish to telus pubsub framework
	 */
	@JsonIgnore
	private ObjectMapper objectMapper;
	
	public BaseTransaction() {
		this.createTime= OffsetDateTime.now();
	}
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public TransactionType getType() {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	public TransactionSubType getSubType() {
		return subType;
	}

	public void setSubType(TransactionSubType subType) {
		this.subType = subType;
	}

	public OffsetDateTime getCreateTime() {
		return createTime;		 
	}
	public void setCreateTime(OffsetDateTime createTime) {
		this.createTime = createTime;
	}
	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}
	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

}
