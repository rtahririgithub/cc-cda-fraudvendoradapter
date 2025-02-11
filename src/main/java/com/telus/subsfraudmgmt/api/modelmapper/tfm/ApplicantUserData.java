package com.telus.subsfraudmgmt.api.modelmapper.tfm;

import java.util.ArrayList;
import java.util.List;

/**
 * Introduced to make mapping ApplicationSectionTelco easier.
 * 
 * @author Harry Xu
 *
 */
public class ApplicantUserData {
	
	private String accountId;
	private String accountCreateDate;
	private String totalDuplicateBanCounts;
	private String totalDuplicateBanSubCounts;
	private List<RelationShipTentativeAccount> relationshipTentativeAccountList = new ArrayList<>();
	private List<RelationShipOpenAccount> relationshipOpenAccountList= new ArrayList<>();
	
	private String creditCardToken;
	private String drivrLicnsNo;
	private String sinNo;
	private String passport;
	
	private String assmtRsltCd;
	private String assmtRsltRsnCd;
	private String assmtTrigCd;
	private String assmtTrigValCd;
	private String bankruptcyInd;
	private String banStartServiceDate;
	private String banStatus;
	private String burDecsnCd;
	private String burRptErrInd;
	private String burRptExistInd;
	private String burRptRequiredInd;
	private String burTypeCd;
	private String creditCardFirstSix;
	private String credtCardLastFour;
	private String drivrLicnsExpDt;
	private String drivrLicnsState;
	private String fullNm;
	private String noHitThinFileInd;
	private String nullBurCreateDateInd;
	private String secndyRiskCd;
	private String statusActvCode;
	private String statusActvRsnCode;
	private String tempSinInd;
	private String thinFileInd;
	private String trueThinFileInd; 
	
	private String cbRequestApplicantNationalIDInd;
	private String cbRequestApplicantCardNumberInd;
	private String cbRequestApplicantDLInd;
	private String cbRequestApplicantPassportInd;
	
	private String cbTotal_Number_of_Inquiries;
	private String cbCredit_file_Warning_Message;
	
	private String watson_api_error_code;
	private String watson_prediction_value_1;
	private String watson_prb_value_fraud_1;
	private String watson_prb_value_nonfraud_1;
	
	public String getWatson_prediction_value_1() {
		return watson_prediction_value_1;
	}
	public void setWatson_prediction_value_1(String watson_prediction_value_1) {
		this.watson_prediction_value_1 = watson_prediction_value_1;
	}
	public String getWatson_prb_value_fraud_1() {
		return watson_prb_value_fraud_1;
	}
	public void setWatson_prb_value_fraud_1(String watson_prb_value_fraud_1) {
		this.watson_prb_value_fraud_1 = watson_prb_value_fraud_1;
	}
	public String getWatson_prb_value_nonfraud_1() {
		return watson_prb_value_nonfraud_1;
	}
	public void setWatson_prb_value_nonfraud_1(String watson_prb_value_nonfraud_1) {
		this.watson_prb_value_nonfraud_1 = watson_prb_value_nonfraud_1;
	}
	public String getWatson_api_error_code() {
		return watson_api_error_code;
	}
	public void setWatson_api_error_code(String watson_api_error_code) {
		this.watson_api_error_code = watson_api_error_code;
	}
	
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountCreateDate() {
		return accountCreateDate;
	}
	public void setAccountCreateDate(String accountCreateDate) {
		this.accountCreateDate = accountCreateDate;
	}
	public String getTotalDuplicateBanCounts() {
		return totalDuplicateBanCounts;
	}
	public void setTotalDuplicateBanCounts(String totalDuplicateBanCounts) {
		this.totalDuplicateBanCounts = totalDuplicateBanCounts;
	}
	public String getTotalDuplicateBanSubCounts() {
		return totalDuplicateBanSubCounts;
	}
	public void setTotalDuplicateBanSubCounts(String totalDuplicateBanSubCounts) {
		this.totalDuplicateBanSubCounts = totalDuplicateBanSubCounts;
	} 
	public List<RelationShipTentativeAccount> getRelationshipTentativeAccountList() {
		return relationshipTentativeAccountList;
	}
	public void setRelationshipTentativeAccountList(List<RelationShipTentativeAccount> relationshipTentativeAccountList) {
		this.relationshipTentativeAccountList = relationshipTentativeAccountList;
	}
	public List<RelationShipOpenAccount> getRelationshipOpenAccountList() {
		return relationshipOpenAccountList;
	}
	public void setRelationshipOpenAccountList(List<RelationShipOpenAccount> relationshipOpenAccountList) {
		this.relationshipOpenAccountList = relationshipOpenAccountList;
	}
	public String getCreditCardToken() {
		return creditCardToken;
	}
	public void setCreditCardToken(String creditCardToken) {
		this.creditCardToken = creditCardToken;
	}
	public String getDrivrLicnsNo() {
		return drivrLicnsNo;
	}
	public void setDrivrLicnsNo(String drivrLicnsNo) {
		this.drivrLicnsNo = drivrLicnsNo;
	}
	public String getSinNo() {
		return sinNo;
	}
	public void setSinNo(String sinNo) {
		this.sinNo = sinNo;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getAssmtRsltCd() {
		return assmtRsltCd;
	}
	public void setAssmtRsltCd(String assmtRsltCd) {
		this.assmtRsltCd = assmtRsltCd;
	}
	public String getAssmtRsltRsnCd() {
		return assmtRsltRsnCd;
	}
	public void setAssmtRsltRsnCd(String assmtRsltRsnCd) {
		this.assmtRsltRsnCd = assmtRsltRsnCd;
	}
	public String getAssmtTrigCd() {
		return assmtTrigCd;
	}
	public void setAssmtTrigCd(String assmtTrigCd) {
		this.assmtTrigCd = assmtTrigCd;
	}
	public String getAssmtTrigValCd() {
		return assmtTrigValCd;
	}
	public void setAssmtTrigValCd(String assmtTrigValCd) {
		this.assmtTrigValCd = assmtTrigValCd;
	}
	public String getBankruptcyInd() {
		return bankruptcyInd;
	}
	public void setBankruptcyInd(String bankruptcyInd) {
		this.bankruptcyInd = bankruptcyInd;
	}
	public String getBanStartServiceDate() {
		return banStartServiceDate;
	}
	public void setBanStartServiceDate(String banStartServiceDate) {
		this.banStartServiceDate = banStartServiceDate;
	}
	public String getBanStatus() {
		return banStatus;
	}
	public void setBanStatus(String banStatus) {
		this.banStatus = banStatus;
	}
	public String getBurDecsnCd() {
		return burDecsnCd;
	}
	public void setBurDecsnCd(String burDecsnCd) {
		this.burDecsnCd = burDecsnCd;
	}
	public String getBurRptErrInd() {
		return burRptErrInd;
	}
	public void setBurRptErrInd(String burRptErrInd) {
		this.burRptErrInd = burRptErrInd;
	}
	public String getBurRptExistInd() {
		return burRptExistInd;
	}
	public void setBurRptExistInd(String burRptExistInd) {
		this.burRptExistInd = burRptExistInd;
	}
	public String getBurRptRequiredInd() {
		return burRptRequiredInd;
	}
	public void setBurRptRequiredInd(String burRptRequiredInd) {
		this.burRptRequiredInd = burRptRequiredInd;
	}
	public String getBurTypeCd() {
		return burTypeCd;
	}
	public void setBurTypeCd(String burTypeCd) {
		this.burTypeCd = burTypeCd;
	}
	public String getCreditCardFirstSix() {
		return creditCardFirstSix;
	}
	public void setCreditCardFirstSix(String creditCardFirstSix) {
		this.creditCardFirstSix = creditCardFirstSix;
	}
	public String getCredtCardLastFour() {
		return credtCardLastFour;
	}
	public void setCredtCardLastFour(String credtCardLastFour) {
		this.credtCardLastFour = credtCardLastFour;
	}
	public String getDrivrLicnsExpDt() {
		return drivrLicnsExpDt;
	}
	public void setDrivrLicnsExpDt(String drivrLicnsExpDt) {
		this.drivrLicnsExpDt = drivrLicnsExpDt;
	}
	public String getDrivrLicnsState() {
		return drivrLicnsState;
	}
	public void setDrivrLicnsState(String drivrLicnsState) {
		this.drivrLicnsState = drivrLicnsState;
	}
	public String getFullNm() {
		return fullNm;
	}
	public void setFullNm(String fullNm) {
		this.fullNm = fullNm;
	}
	public String getNoHitThinFileInd() {
		return noHitThinFileInd;
	}
	public void setNoHitThinFileInd(String noHitThinFileInd) {
		this.noHitThinFileInd = noHitThinFileInd;
	}
	public String getNullBurCreateDateInd() {
		return nullBurCreateDateInd;
	}
	public void setNullBurCreateDateInd(String nullBurCreateDateInd) {
		this.nullBurCreateDateInd = nullBurCreateDateInd;
	}
	public String getSecndyRiskCd() {
		return secndyRiskCd;
	}
	public void setSecndyRiskCd(String secndyRiskCd) {
		this.secndyRiskCd = secndyRiskCd;
	}
	public String getStatusActvCode() {
		return statusActvCode;
	}
	public void setStatusActvCode(String statusActvCode) {
		this.statusActvCode = statusActvCode;
	}
	public String getStatusActvRsnCode() {
		return statusActvRsnCode;
	}
	public void setStatusActvRsnCode(String statusActvRsnCode) {
		this.statusActvRsnCode = statusActvRsnCode;
	}
	public String getTempSinInd() {
		return tempSinInd;
	}
	public void setTempSinInd(String tempSinInd) {
		this.tempSinInd = tempSinInd;
	}
	public String getThinFileInd() {
		return thinFileInd;
	}
	public void setThinFileInd(String thinFileInd) {
		this.thinFileInd = thinFileInd;
	}
	public String getTrueThinFileInd() {
		return trueThinFileInd;
	}
	public void setTrueThinFileInd(String trueThinFileInd) {
		this.trueThinFileInd = trueThinFileInd;
	}
	
	
	
	public String getCbRequestApplicantNationalIDInd() {
		return cbRequestApplicantNationalIDInd;
	}
	public void setCbRequestApplicantNationalIDInd(String cbRequestApplicantNationalIDInd) {
		this.cbRequestApplicantNationalIDInd = cbRequestApplicantNationalIDInd;
	}
	public String getCbRequestApplicantCardNumberInd() {
		return cbRequestApplicantCardNumberInd;
	}
	public void setCbRequestApplicantCardNumberInd(String cbRequestApplicantCardNumberInd) {
		this.cbRequestApplicantCardNumberInd = cbRequestApplicantCardNumberInd;
	}
	public String getCbRequestApplicantDLInd() {
		return cbRequestApplicantDLInd;
	}
	public void setCbRequestApplicantDLInd(String cbRequestApplicantDLInd) {
		this.cbRequestApplicantDLInd = cbRequestApplicantDLInd;
	}
	public String getCbRequestApplicantPassportInd() {
		return cbRequestApplicantPassportInd;
	}
	public void setCbRequestApplicantPassportInd(String cbRequestApplicantPassportInd) {
		this.cbRequestApplicantPassportInd = cbRequestApplicantPassportInd;
	}

	public String getCbTotal_Number_of_Inquiries() {
		return cbTotal_Number_of_Inquiries;
	}
	public void setCbTotal_Number_of_Inquiries(String cbTotal_Number_of_Inquiries) {
		this.cbTotal_Number_of_Inquiries = cbTotal_Number_of_Inquiries;
	}
	public String getCbCredit_file_Warning_Message() {
		return cbCredit_file_Warning_Message;
	}
	public void setCbCredit_file_Warning_Message(String cbCredit_file_Warning_Message) {
		this.cbCredit_file_Warning_Message = cbCredit_file_Warning_Message;
	}


	//
	//nested classes
	//

	public static class RelationShipTentativeAccount implements Comparable<RelationShipTentativeAccount> {
		private String banTentative;
		private String banTentativeCreationDate;
		
		public static String toAFMKeyName(String propertyName, int i) {
			if (propertyName.startsWith("banTentative")) {
				//ban->ban+i, banStatus->ban+i+Status
				return "banTentative"+ i + propertyName.substring("banTentative".length());
			}
			return propertyName;
		}
		//descending order
		@Override
		public int compareTo(RelationShipTentativeAccount o) {
			return -1 * getBanTentativeCreationDate().compareTo(o.getBanTentativeCreationDate());
		}
		public String getBanTentative() {
			return banTentative;
		}
		public void setBanTentative(String banTentative) {
			this.banTentative = banTentative;
		}
		public String getBanTentativeCreationDate() {
			return banTentativeCreationDate;
		}
		public void setBanTentativeCreationDate(String banTentativeCreationDate) {
			this.banTentativeCreationDate = banTentativeCreationDate;
		}
		 
         
	}
	
	public static class RelationShipOpenAccount implements Comparable<RelationShipOpenAccount> {
		private String ban;
		private String banStatus;
		private String banCreationDate;
		private String banServiceStartDate;
		private String banSubscriberCount;
		private String banStatusActvCode;
		private String banStatusActvRsnCode;
		
		public static String toAFMKeyName(String propertyName, int i) {
			if (propertyName.startsWith("ban")) {
				//ban->ban+i, banStatus->ban+i+Status
				return "ban"+ i + propertyName.substring("ban".length());
			}
			return propertyName;
		}
		
		//most recent is defined by BAN.BAN_START_SERVICE_DATE
		@Override
		public int compareTo(RelationShipOpenAccount o) {
			//ascending order
			return -1 * this.getBanServiceStartDate().compareTo(o.getBanServiceStartDate());
		}
		
		public String getBan() {
			return ban;
		}
		public void setBan(String ban) {
			this.ban = ban;
		}
		public String getBanStatus() {
			return banStatus;
		}
		public void setBanStatus(String banStatus) {
			this.banStatus = banStatus;
		}
		
		public String getBanCreationDate() {
			return banCreationDate;
		}
		public void setBanCreationDate(String banCreationDate) {
			this.banCreationDate = banCreationDate;
		}
		public String getBanServiceStartDate() {
			return banServiceStartDate;
		}
		public void setBanServiceStartDate(String banServiceStartDate) {
			this.banServiceStartDate = banServiceStartDate;
		}
		public String getBanSubscriberCount() {
			return banSubscriberCount;
		}
		public void setBanSubscriberCount(String banSubscriberCount) {
			this.banSubscriberCount = banSubscriberCount;
		}
		public String getBanStatusActvCode() {
			return banStatusActvCode;
		}
		public void setBanStatusActvCode(String banStatusActvCode) {
			this.banStatusActvCode = banStatusActvCode;
		}
		public String getBanStatusActvRsnCode() {
			return banStatusActvRsnCode;
		}
		public void setBanStatusActvRsnCode(String ban1StatusActvRsnCode) {
			this.banStatusActvRsnCode = ban1StatusActvRsnCode;
		}
		

		 
         
	}
	
}
