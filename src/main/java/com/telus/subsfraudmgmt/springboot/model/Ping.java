package com.telus.subsfraudmgmt.springboot.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class Ping {

	 public Ping() {
	    	this.pingResult = new PingResult();

	    }
	       
	    public PingResult getPingResult() {
			return pingResult;
		}
		public void setPingResult(
				PingResult pingResult) {
			this.pingResult = pingResult;
		}

		private static final Log log = LogFactory.getLog(Ping.class);
		private PingResult pingResult;

		public PingResult PingResult() {
			return pingResult;
		}
		
		
		public  class PingResult {
			
			public PingResult() {
				this.status = new Status();
			}
			private Status status;
			
			public Status getStatus() {
				return status;
			}
			public void setStatus(Status status) {
				this.status = status;
			}
			private String nameTxt;
			private String descriptionTxt;
			private String timestamp;
			
			public String getNameTxt() {
				return nameTxt;
			}
			public void setNameTxt(String nameTxt) {
				this.nameTxt = nameTxt;
			}
			public String getDescriptionTxt() {
				return descriptionTxt;
			}
			public void setDescriptionTxt(String descriptionTxt) {
				this.descriptionTxt = descriptionTxt;
			}
			public String getTimestamp() {
				return timestamp;
			}
			public void setTimestamp(String timestamp) {
				this.timestamp = timestamp;
			}
		}

	    public  class Status {
	    	
	    	private String statusCd;
			private String statusTxt;
			private String systemErrorTimeStamp;
			
			public String getStatusCd() {
				return statusCd;
			}
			public void setStatusCd(String statusCd) {
				this.statusCd = statusCd;
			}
			public String getStatusTxt() {
				return statusTxt;
			}
			public void setStatusTxt(String statusTxt) {
				this.statusTxt = statusTxt;
			}
			public String getSystemErrorTimeStamp() {
				return systemErrorTimeStamp;
			}
			public void setSystemErrorTimeStamp(String systemErrorTimeStamp) {
				this.systemErrorTimeStamp = systemErrorTimeStamp;
			}
				
			
	    }
}
