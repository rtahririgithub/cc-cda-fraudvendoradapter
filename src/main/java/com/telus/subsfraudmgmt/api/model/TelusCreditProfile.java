package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.AttachmentRefOrValue;
import com.telus.subsfraudmgmt.api.model.CreditProfile;
import com.telus.subsfraudmgmt.api.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TELUS Extension to include additional properties
 */
@ApiModel(description = "TELUS Extension to include additional properties")
@Validated

public class TelusCreditProfile extends CreditProfile  {
  @JsonProperty("riskLevelNumber")
  private BigDecimal riskLevelNumber = null;

  @JsonProperty("riskLevelDecisionCd")
  private String riskLevelDecisionCd = null;

  @JsonProperty("creditClassCd")
  private String creditClassCd = null;

  @JsonProperty("creditDecisionCd")
  private String creditDecisionCd = null;

  @JsonProperty("creditProgramName")
  private String creditProgramName = null;

  @JsonProperty("bureauDecisionCode")
  private String bureauDecisionCode = null;

  @JsonProperty("averageSecurityDepositList")
  private BigDecimal averageSecurityDepositList = null;

  @JsonProperty("bureauReportAttachment")
  private AttachmentRefOrValue bureauReportAttachment = null;

  public TelusCreditProfile riskLevelNumber(BigDecimal riskLevelNumber) {
    this.riskLevelNumber = riskLevelNumber;
    return this;
  }

  /**
   * 
   * @return riskLevelNumber
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getRiskLevelNumber() {
    return riskLevelNumber;
  }

  public void setRiskLevelNumber(BigDecimal riskLevelNumber) {
    this.riskLevelNumber = riskLevelNumber;
  }

  public TelusCreditProfile riskLevelDecisionCd(String riskLevelDecisionCd) {
    this.riskLevelDecisionCd = riskLevelDecisionCd;
    return this;
  }

  /**
   * 
   * @return riskLevelDecisionCd
  **/
  @ApiModelProperty(value = "")


  public String getRiskLevelDecisionCd() {
    return riskLevelDecisionCd;
  }

  public void setRiskLevelDecisionCd(String riskLevelDecisionCd) {
    this.riskLevelDecisionCd = riskLevelDecisionCd;
  }

  public TelusCreditProfile creditClassCd(String creditClassCd) {
    this.creditClassCd = creditClassCd;
    return this;
  }

  /**
   * 
   * @return creditClassCd
  **/
  @ApiModelProperty(value = "")


  public String getCreditClassCd() {
    return creditClassCd;
  }

  public void setCreditClassCd(String creditClassCd) {
    this.creditClassCd = creditClassCd;
  }

  public TelusCreditProfile creditDecisionCd(String creditDecisionCd) {
    this.creditDecisionCd = creditDecisionCd;
    return this;
  }

  /**
   * 
   * @return creditDecisionCd
  **/
  @ApiModelProperty(value = "")


  public String getCreditDecisionCd() {
    return creditDecisionCd;
  }

  public void setCreditDecisionCd(String creditDecisionCd) {
    this.creditDecisionCd = creditDecisionCd;
  }

  public TelusCreditProfile creditProgramName(String creditProgramName) {
    this.creditProgramName = creditProgramName;
    return this;
  }

  /**
   * 
   * @return creditProgramName
  **/
  @ApiModelProperty(value = "")


  public String getCreditProgramName() {
    return creditProgramName;
  }

  public void setCreditProgramName(String creditProgramName) {
    this.creditProgramName = creditProgramName;
  }

  public TelusCreditProfile bureauDecisionCode(String bureauDecisionCode) {
    this.bureauDecisionCode = bureauDecisionCode;
    return this;
  }

  /**
   * 
   * @return bureauDecisionCode
  **/
  @ApiModelProperty(value = "")


  public String getBureauDecisionCode() {
    return bureauDecisionCode;
  }

  public void setBureauDecisionCode(String bureauDecisionCode) {
    this.bureauDecisionCode = bureauDecisionCode;
  }

  public TelusCreditProfile averageSecurityDepositList(BigDecimal averageSecurityDepositList) {
    this.averageSecurityDepositList = averageSecurityDepositList;
    return this;
  }

  /**
   * 
   * @return averageSecurityDepositList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getAverageSecurityDepositList() {
    return averageSecurityDepositList;
  }

  public void setAverageSecurityDepositList(BigDecimal averageSecurityDepositList) {
    this.averageSecurityDepositList = averageSecurityDepositList;
  }

  public TelusCreditProfile bureauReportAttachment(AttachmentRefOrValue bureauReportAttachment) {
    this.bureauReportAttachment = bureauReportAttachment;
    return this;
  }

  /**
   * Get bureauReportAttachment
   * @return bureauReportAttachment
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AttachmentRefOrValue getBureauReportAttachment() {
    return bureauReportAttachment;
  }

  public void setBureauReportAttachment(AttachmentRefOrValue bureauReportAttachment) {
    this.bureauReportAttachment = bureauReportAttachment;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelusCreditProfile telusCreditProfile = (TelusCreditProfile) o;
    return Objects.equals(this.riskLevelNumber, telusCreditProfile.riskLevelNumber) &&
        Objects.equals(this.riskLevelDecisionCd, telusCreditProfile.riskLevelDecisionCd) &&
        Objects.equals(this.creditClassCd, telusCreditProfile.creditClassCd) &&
        Objects.equals(this.creditDecisionCd, telusCreditProfile.creditDecisionCd) &&
        Objects.equals(this.creditProgramName, telusCreditProfile.creditProgramName) &&
        Objects.equals(this.bureauDecisionCode, telusCreditProfile.bureauDecisionCode) &&
        Objects.equals(this.averageSecurityDepositList, telusCreditProfile.averageSecurityDepositList) &&
        Objects.equals(this.bureauReportAttachment, telusCreditProfile.bureauReportAttachment) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(riskLevelNumber, riskLevelDecisionCd, creditClassCd, creditDecisionCd, creditProgramName, bureauDecisionCode, averageSecurityDepositList, bureauReportAttachment, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelusCreditProfile {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    riskLevelNumber: ").append(toIndentedString(riskLevelNumber)).append("\n");
    sb.append("    riskLevelDecisionCd: ").append(toIndentedString(riskLevelDecisionCd)).append("\n");
    sb.append("    creditClassCd: ").append(toIndentedString(creditClassCd)).append("\n");
    sb.append("    creditDecisionCd: ").append(toIndentedString(creditDecisionCd)).append("\n");
    sb.append("    creditProgramName: ").append(toIndentedString(creditProgramName)).append("\n");
    sb.append("    bureauDecisionCode: ").append(toIndentedString(bureauDecisionCode)).append("\n");
    sb.append("    averageSecurityDepositList: ").append(toIndentedString(averageSecurityDepositList)).append("\n");
    sb.append("    bureauReportAttachment: ").append(toIndentedString(bureauReportAttachment)).append("\n");
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

