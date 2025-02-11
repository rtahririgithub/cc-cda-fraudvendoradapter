package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccountCreditBureauResultAdjudicationResult;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccountCreditBureauResultRiskIndicator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TelusBillingAccountCreditBureauResult
 */
@Validated

public class TelusBillingAccountCreditBureauResult   {
  @JsonProperty("errorCd")
  private String errorCd = null;

  @JsonProperty("creationDate")
  private OffsetDateTime creationDate = null;

  @JsonProperty("reportSourceCd")
  private String reportSourceCd = null;

  @JsonProperty("adjudicationResult")
  private TelusBillingAccountCreditBureauResultAdjudicationResult adjudicationResult = null;

  @JsonProperty("riskIndicator")
  private TelusBillingAccountCreditBureauResultRiskIndicator riskIndicator = null;

  public TelusBillingAccountCreditBureauResult errorCd(String errorCd) {
    this.errorCd = errorCd;
    return this;
  }

  /**
   * 
   * @return errorCd
  **/
  @ApiModelProperty(value = "")


  public String getErrorCd() {
    return errorCd;
  }

  public void setErrorCd(String errorCd) {
    this.errorCd = errorCd;
  }

  public TelusBillingAccountCreditBureauResult creationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * credit check timestamp
   * @return creationDate
  **/
  @ApiModelProperty(value = "credit check timestamp")

  @Valid

  public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public TelusBillingAccountCreditBureauResult reportSourceCd(String reportSourceCd) {
    this.reportSourceCd = reportSourceCd;
    return this;
  }

  /**
   * 
   * @return reportSourceCd
  **/
  @ApiModelProperty(value = "")


  public String getReportSourceCd() {
    return reportSourceCd;
  }

  public void setReportSourceCd(String reportSourceCd) {
    this.reportSourceCd = reportSourceCd;
  }

  public TelusBillingAccountCreditBureauResult adjudicationResult(TelusBillingAccountCreditBureauResultAdjudicationResult adjudicationResult) {
    this.adjudicationResult = adjudicationResult;
    return this;
  }

  /**
   * Get adjudicationResult
   * @return adjudicationResult
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TelusBillingAccountCreditBureauResultAdjudicationResult getAdjudicationResult() {
    return adjudicationResult;
  }

  public void setAdjudicationResult(TelusBillingAccountCreditBureauResultAdjudicationResult adjudicationResult) {
    this.adjudicationResult = adjudicationResult;
  }

  public TelusBillingAccountCreditBureauResult riskIndicator(TelusBillingAccountCreditBureauResultRiskIndicator riskIndicator) {
    this.riskIndicator = riskIndicator;
    return this;
  }

  /**
   * Get riskIndicator
   * @return riskIndicator
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TelusBillingAccountCreditBureauResultRiskIndicator getRiskIndicator() {
    return riskIndicator;
  }

  public void setRiskIndicator(TelusBillingAccountCreditBureauResultRiskIndicator riskIndicator) {
    this.riskIndicator = riskIndicator;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelusBillingAccountCreditBureauResult telusBillingAccountCreditBureauResult = (TelusBillingAccountCreditBureauResult) o;
    return Objects.equals(this.errorCd, telusBillingAccountCreditBureauResult.errorCd) &&
        Objects.equals(this.creationDate, telusBillingAccountCreditBureauResult.creationDate) &&
        Objects.equals(this.reportSourceCd, telusBillingAccountCreditBureauResult.reportSourceCd) &&
        Objects.equals(this.adjudicationResult, telusBillingAccountCreditBureauResult.adjudicationResult) &&
        Objects.equals(this.riskIndicator, telusBillingAccountCreditBureauResult.riskIndicator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorCd, creationDate, reportSourceCd, adjudicationResult, riskIndicator);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelusBillingAccountCreditBureauResult {\n");
    
    sb.append("    errorCd: ").append(toIndentedString(errorCd)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    reportSourceCd: ").append(toIndentedString(reportSourceCd)).append("\n");
    sb.append("    adjudicationResult: ").append(toIndentedString(adjudicationResult)).append("\n");
    sb.append("    riskIndicator: ").append(toIndentedString(riskIndicator)).append("\n");
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

