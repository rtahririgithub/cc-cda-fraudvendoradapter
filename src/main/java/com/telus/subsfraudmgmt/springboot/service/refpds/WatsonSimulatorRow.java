package com.telus.subsfraudmgmt.springboot.service.refpds;

public class WatsonSimulatorRow {
    //inputs
	private String simulatorKey;
	private String simulatorKeyDesc;
	//outputs from below
	private String errorCd;
	private String predictionTxt;
	private String probFraudValue;
	private String probNonFraudValue;
	
	private long priority;
	
	public String getSimulatorKey() {
		return simulatorKey;
	}
	public void setSimulatorKey(String simulatorKey) {
		this.simulatorKey = simulatorKey;
	}
	public String getSimulatorKeyDesc() {
		return simulatorKeyDesc;
	}
	public void setSimulatorKeyDesc(String simulatorKeyDesc) {
		this.simulatorKeyDesc = simulatorKeyDesc;
	}
	public String getErrorCd() {
		return errorCd;
	}
	public void setErrorCd(String errorCd) {
		this.errorCd = errorCd;
	}
	public String getPredictionTxt() {
		return predictionTxt;
	}
	public void setPredictionTxt(String predictionTxt) {
		this.predictionTxt = predictionTxt;
	}
	public String getProbFraudValue() {
		return probFraudValue;
	}
	public void setProbFraudValue(String probFraudValue) {
		this.probFraudValue = probFraudValue;
	}
	public String getProbNonFraudValue() {
		return probNonFraudValue;
	}
	public void setProbNonFraudValue(String probNonFraudValue) {
		this.probNonFraudValue = probNonFraudValue;
	}
	public long getPriority() {
		return priority;
	}
	
	public void setPriority(long priority) {
		this.priority = priority;
	}
	
	
}
