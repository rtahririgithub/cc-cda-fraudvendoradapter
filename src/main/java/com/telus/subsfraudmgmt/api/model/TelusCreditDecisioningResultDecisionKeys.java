package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TelusCreditDecisioningResultDecisionKeys
 */
@Validated

public class TelusCreditDecisioningResultDecisionKeys   {
  @JsonProperty("accountTenureCd")
  private String accountTenureCd = null;

  @JsonProperty("collectionHistoryValueCd")
  private String collectionHistoryValueCd = null;

  @JsonProperty("wlsDelinquentInd")
  private Boolean wlsDelinquentInd = null;

  @JsonProperty("ficoAccountStatusCd")
  private String ficoAccountStatusCd = null;

  @JsonProperty("refcApprovalGrantedInd")
  private Boolean refcApprovalGrantedInd = null;

  @JsonProperty("refcFlagInd")
  private String refcFlagInd = null;

  @JsonProperty("ValidDepositOverrideInd")
  private String validDepositOverrideInd = null;

  @JsonProperty("assessmentTriggerCd")
  private String assessmentTriggerCd = null;

  @JsonProperty("assessmentTriggerValueCd")
  private String assessmentTriggerValueCd = null;

  @JsonProperty("bureauReportExistInd")
  private Boolean bureauReportExistInd = null;

  @JsonProperty("bureauReportRequiredInd")
  private Boolean bureauReportRequiredInd = null;

  @JsonProperty("bureauTypeCd")
  private String bureauTypeCd = null;

  @JsonProperty("nullBureauCreateDateInd")
  private String nullBureauCreateDateInd = null;

  @JsonProperty("thinFileInd")
  private Boolean thinFileInd = null;

  public TelusCreditDecisioningResultDecisionKeys accountTenureCd(String accountTenureCd) {
    this.accountTenureCd = accountTenureCd;
    return this;
  }

  /**
   * account Tenure code
   * @return accountTenureCd
  **/
  @ApiModelProperty(value = "account Tenure code")


  public String getAccountTenureCd() {
    return accountTenureCd;
  }

  public void setAccountTenureCd(String accountTenureCd) {
    this.accountTenureCd = accountTenureCd;
  }

  public TelusCreditDecisioningResultDecisionKeys collectionHistoryValueCd(String collectionHistoryValueCd) {
    this.collectionHistoryValueCd = collectionHistoryValueCd;
    return this;
  }

  /**
   * collection History Value code
   * @return collectionHistoryValueCd
  **/
  @ApiModelProperty(value = "collection History Value code")


  public String getCollectionHistoryValueCd() {
    return collectionHistoryValueCd;
  }

  public void setCollectionHistoryValueCd(String collectionHistoryValueCd) {
    this.collectionHistoryValueCd = collectionHistoryValueCd;
  }

  public TelusCreditDecisioningResultDecisionKeys wlsDelinquentInd(Boolean wlsDelinquentInd) {
    this.wlsDelinquentInd = wlsDelinquentInd;
    return this;
  }

  /**
   * 
   * @return wlsDelinquentInd
  **/
  @ApiModelProperty(value = "")


  public Boolean isWlsDelinquentInd() {
    return wlsDelinquentInd;
  }

  public void setWlsDelinquentInd(Boolean wlsDelinquentInd) {
    this.wlsDelinquentInd = wlsDelinquentInd;
  }

  public TelusCreditDecisioningResultDecisionKeys ficoAccountStatusCd(String ficoAccountStatusCd) {
    this.ficoAccountStatusCd = ficoAccountStatusCd;
    return this;
  }

  /**
   * 
   * @return ficoAccountStatusCd
  **/
  @ApiModelProperty(value = "")


  public String getFicoAccountStatusCd() {
    return ficoAccountStatusCd;
  }

  public void setFicoAccountStatusCd(String ficoAccountStatusCd) {
    this.ficoAccountStatusCd = ficoAccountStatusCd;
  }

  public TelusCreditDecisioningResultDecisionKeys refcApprovalGrantedInd(Boolean refcApprovalGrantedInd) {
    this.refcApprovalGrantedInd = refcApprovalGrantedInd;
    return this;
  }

  /**
   * 
   * @return refcApprovalGrantedInd
  **/
  @ApiModelProperty(value = "")


  public Boolean isRefcApprovalGrantedInd() {
    return refcApprovalGrantedInd;
  }

  public void setRefcApprovalGrantedInd(Boolean refcApprovalGrantedInd) {
    this.refcApprovalGrantedInd = refcApprovalGrantedInd;
  }

  public TelusCreditDecisioningResultDecisionKeys refcFlagInd(String refcFlagInd) {
    this.refcFlagInd = refcFlagInd;
    return this;
  }

  /**
   * 
   * @return refcFlagInd
  **/
  @ApiModelProperty(value = "")


  public String getRefcFlagInd() {
    return refcFlagInd;
  }

  public void setRefcFlagInd(String refcFlagInd) {
    this.refcFlagInd = refcFlagInd;
  }

  public TelusCreditDecisioningResultDecisionKeys validDepositOverrideInd(String validDepositOverrideInd) {
    this.validDepositOverrideInd = validDepositOverrideInd;
    return this;
  }

  /**
   * 
   * @return validDepositOverrideInd
  **/
  @ApiModelProperty(value = "")


  public String getValidDepositOverrideInd() {
    return validDepositOverrideInd;
  }

  public void setValidDepositOverrideInd(String validDepositOverrideInd) {
    this.validDepositOverrideInd = validDepositOverrideInd;
  }

  public TelusCreditDecisioningResultDecisionKeys assessmentTriggerCd(String assessmentTriggerCd) {
    this.assessmentTriggerCd = assessmentTriggerCd;
    return this;
  }

  /**
   * 
   * @return assessmentTriggerCd
  **/
  @ApiModelProperty(value = "")


  public String getAssessmentTriggerCd() {
    return assessmentTriggerCd;
  }

  public void setAssessmentTriggerCd(String assessmentTriggerCd) {
    this.assessmentTriggerCd = assessmentTriggerCd;
  }

  public TelusCreditDecisioningResultDecisionKeys assessmentTriggerValueCd(String assessmentTriggerValueCd) {
    this.assessmentTriggerValueCd = assessmentTriggerValueCd;
    return this;
  }

  /**
   * 
   * @return assessmentTriggerValueCd
  **/
  @ApiModelProperty(value = "")


  public String getAssessmentTriggerValueCd() {
    return assessmentTriggerValueCd;
  }

  public void setAssessmentTriggerValueCd(String assessmentTriggerValueCd) {
    this.assessmentTriggerValueCd = assessmentTriggerValueCd;
  }

  public TelusCreditDecisioningResultDecisionKeys bureauReportExistInd(Boolean bureauReportExistInd) {
    this.bureauReportExistInd = bureauReportExistInd;
    return this;
  }

  /**
   * 
   * @return bureauReportExistInd
  **/
  @ApiModelProperty(value = "")


  public Boolean isBureauReportExistInd() {
    return bureauReportExistInd;
  }

  public void setBureauReportExistInd(Boolean bureauReportExistInd) {
    this.bureauReportExistInd = bureauReportExistInd;
  }

  public TelusCreditDecisioningResultDecisionKeys bureauReportRequiredInd(Boolean bureauReportRequiredInd) {
    this.bureauReportRequiredInd = bureauReportRequiredInd;
    return this;
  }

  /**
   * 
   * @return bureauReportRequiredInd
  **/
  @ApiModelProperty(value = "")


  public Boolean isBureauReportRequiredInd() {
    return bureauReportRequiredInd;
  }

  public void setBureauReportRequiredInd(Boolean bureauReportRequiredInd) {
    this.bureauReportRequiredInd = bureauReportRequiredInd;
  }

  public TelusCreditDecisioningResultDecisionKeys bureauTypeCd(String bureauTypeCd) {
    this.bureauTypeCd = bureauTypeCd;
    return this;
  }

  /**
   * 
   * @return bureauTypeCd
  **/
  @ApiModelProperty(value = "")


  public String getBureauTypeCd() {
    return bureauTypeCd;
  }

  public void setBureauTypeCd(String bureauTypeCd) {
    this.bureauTypeCd = bureauTypeCd;
  }

  public TelusCreditDecisioningResultDecisionKeys nullBureauCreateDateInd(String nullBureauCreateDateInd) {
    this.nullBureauCreateDateInd = nullBureauCreateDateInd;
    return this;
  }

  /**
   * 
   * @return nullBureauCreateDateInd
  **/
  @ApiModelProperty(value = "")


  public String getNullBureauCreateDateInd() {
    return nullBureauCreateDateInd;
  }

  public void setNullBureauCreateDateInd(String nullBureauCreateDateInd) {
    this.nullBureauCreateDateInd = nullBureauCreateDateInd;
  }

  public TelusCreditDecisioningResultDecisionKeys thinFileInd(Boolean thinFileInd) {
    this.thinFileInd = thinFileInd;
    return this;
  }

  /**
   * 
   * @return thinFileInd
  **/
  @ApiModelProperty(value = "")


  public Boolean isThinFileInd() {
    return thinFileInd;
  }

  public void setThinFileInd(Boolean thinFileInd) {
    this.thinFileInd = thinFileInd;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelusCreditDecisioningResultDecisionKeys telusCreditDecisioningResultDecisionKeys = (TelusCreditDecisioningResultDecisionKeys) o;
    return Objects.equals(this.accountTenureCd, telusCreditDecisioningResultDecisionKeys.accountTenureCd) &&
        Objects.equals(this.collectionHistoryValueCd, telusCreditDecisioningResultDecisionKeys.collectionHistoryValueCd) &&
        Objects.equals(this.wlsDelinquentInd, telusCreditDecisioningResultDecisionKeys.wlsDelinquentInd) &&
        Objects.equals(this.ficoAccountStatusCd, telusCreditDecisioningResultDecisionKeys.ficoAccountStatusCd) &&
        Objects.equals(this.refcApprovalGrantedInd, telusCreditDecisioningResultDecisionKeys.refcApprovalGrantedInd) &&
        Objects.equals(this.refcFlagInd, telusCreditDecisioningResultDecisionKeys.refcFlagInd) &&
        Objects.equals(this.validDepositOverrideInd, telusCreditDecisioningResultDecisionKeys.validDepositOverrideInd) &&
        Objects.equals(this.assessmentTriggerCd, telusCreditDecisioningResultDecisionKeys.assessmentTriggerCd) &&
        Objects.equals(this.assessmentTriggerValueCd, telusCreditDecisioningResultDecisionKeys.assessmentTriggerValueCd) &&
        Objects.equals(this.bureauReportExistInd, telusCreditDecisioningResultDecisionKeys.bureauReportExistInd) &&
        Objects.equals(this.bureauReportRequiredInd, telusCreditDecisioningResultDecisionKeys.bureauReportRequiredInd) &&
        Objects.equals(this.bureauTypeCd, telusCreditDecisioningResultDecisionKeys.bureauTypeCd) &&
        Objects.equals(this.nullBureauCreateDateInd, telusCreditDecisioningResultDecisionKeys.nullBureauCreateDateInd) &&
        Objects.equals(this.thinFileInd, telusCreditDecisioningResultDecisionKeys.thinFileInd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountTenureCd, collectionHistoryValueCd, wlsDelinquentInd, ficoAccountStatusCd, refcApprovalGrantedInd, refcFlagInd, validDepositOverrideInd, assessmentTriggerCd, assessmentTriggerValueCd, bureauReportExistInd, bureauReportRequiredInd, bureauTypeCd, nullBureauCreateDateInd, thinFileInd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelusCreditDecisioningResultDecisionKeys {\n");
    
    sb.append("    accountTenureCd: ").append(toIndentedString(accountTenureCd)).append("\n");
    sb.append("    collectionHistoryValueCd: ").append(toIndentedString(collectionHistoryValueCd)).append("\n");
    sb.append("    wlsDelinquentInd: ").append(toIndentedString(wlsDelinquentInd)).append("\n");
    sb.append("    ficoAccountStatusCd: ").append(toIndentedString(ficoAccountStatusCd)).append("\n");
    sb.append("    refcApprovalGrantedInd: ").append(toIndentedString(refcApprovalGrantedInd)).append("\n");
    sb.append("    refcFlagInd: ").append(toIndentedString(refcFlagInd)).append("\n");
    sb.append("    validDepositOverrideInd: ").append(toIndentedString(validDepositOverrideInd)).append("\n");
    sb.append("    assessmentTriggerCd: ").append(toIndentedString(assessmentTriggerCd)).append("\n");
    sb.append("    assessmentTriggerValueCd: ").append(toIndentedString(assessmentTriggerValueCd)).append("\n");
    sb.append("    bureauReportExistInd: ").append(toIndentedString(bureauReportExistInd)).append("\n");
    sb.append("    bureauReportRequiredInd: ").append(toIndentedString(bureauReportRequiredInd)).append("\n");
    sb.append("    bureauTypeCd: ").append(toIndentedString(bureauTypeCd)).append("\n");
    sb.append("    nullBureauCreateDateInd: ").append(toIndentedString(nullBureauCreateDateInd)).append("\n");
    sb.append("    thinFileInd: ").append(toIndentedString(thinFileInd)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

