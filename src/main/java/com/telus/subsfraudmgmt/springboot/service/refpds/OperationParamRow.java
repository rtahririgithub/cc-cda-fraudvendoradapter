package com.telus.subsfraudmgmt.springboot.service.refpds;

public class OperationParamRow {
	private String appId;
	private String paramName;
	private String envNum;
	//output
	private String value;
	
	private long priority;
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getEnvNum() {
		return envNum;
	}
	public void setEnvNum(String envNum) {
		this.envNum = envNum;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public long getPriority() {
		return priority;
	}
	public void setPriority(long priority) {
		this.priority = priority;
	}
	
	public boolean isCandiateRow() { 
		return "WLS_RTFD_SIMULATOR_IND".equalsIgnoreCase(paramName);
	}
    
	public boolean isWatsonCandiateRow() { 
		return "WATSON_WLS_DORMANT_FLAG".equalsIgnoreCase(paramName);
	}
	
	public boolean isFraudAIDormantRow() { 
		return "WATSON_WLS_DORMANT_FLAG".equalsIgnoreCase(paramName);
	}
}
