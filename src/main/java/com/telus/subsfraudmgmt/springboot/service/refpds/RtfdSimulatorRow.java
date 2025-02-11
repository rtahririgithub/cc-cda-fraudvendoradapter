package com.telus.subsfraudmgmt.springboot.service.refpds;

public class RtfdSimulatorRow {
    //inputs
	private String simulatorKey;
	private String simulatorKeyDesc;
	//outputs from below
	private String errorCd;
	private String scoreDetailsTxt;
	private String caseRulesFiredTxt;
	private String decisionSummaryTxt;
	
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
	public String getScoreDetailsTxt() {
		return scoreDetailsTxt;
	}
	public void setScoreDetailsTxt(String scoreDetailsTxt) {
		this.scoreDetailsTxt = scoreDetailsTxt;
	}
	public String getCaseRulesFiredTxt() {
		return caseRulesFiredTxt;
	}
	public void setCaseRulesFiredTxt(String caseRulesFiredTxt) {
		this.caseRulesFiredTxt = caseRulesFiredTxt;
	}
	public String getDecisionSummaryTxt() {
		return decisionSummaryTxt;
	}
	public void setDecisionSummaryTxt(String decisionSummaryTxt) {
		this.decisionSummaryTxt = decisionSummaryTxt;
	}
	public long getPriority() {
		return priority;
	}
	
	public void setPriority(long priority) {
		this.priority = priority;
	}
	
	
}
