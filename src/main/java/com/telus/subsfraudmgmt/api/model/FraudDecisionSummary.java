package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FraudDecisionSummary
 */
@Validated

public class FraudDecisionSummary   {
  @JsonProperty("caseRulesDecision")
  private String caseRulesDecision = null;

  @JsonProperty("matchingRulesCount")
  private BigDecimal matchingRulesCount = null;

  @JsonProperty("blacklistmatchingRulesCount")
  private BigDecimal blacklistmatchingRulesCount = null;

  @JsonProperty("bureauReportMatchingRulesCount")
  private BigDecimal bureauReportMatchingRulesCount = null;

  @JsonProperty("finalFraudDecision")
  private String finalFraudDecision = null;

  public FraudDecisionSummary caseRulesDecision(String caseRulesDecision) {
    this.caseRulesDecision = caseRulesDecision;
    return this;
  }

  /**
   * Get caseRulesDecision
   * @return caseRulesDecision
  **/
  @ApiModelProperty(value = "")


  public String getCaseRulesDecision() {
    return caseRulesDecision;
  }

  public void setCaseRulesDecision(String caseRulesDecision) {
    this.caseRulesDecision = caseRulesDecision;
  }

  public FraudDecisionSummary matchingRulesCount(BigDecimal matchingRulesCount) {
    this.matchingRulesCount = matchingRulesCount;
    return this;
  }

  /**
   * Get matchingRulesCount
   * @return matchingRulesCount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getMatchingRulesCount() {
    return matchingRulesCount;
  }

  public void setMatchingRulesCount(BigDecimal matchingRulesCount) {
    this.matchingRulesCount = matchingRulesCount;
  }

  public FraudDecisionSummary blacklistmatchingRulesCount(BigDecimal blacklistmatchingRulesCount) {
    this.blacklistmatchingRulesCount = blacklistmatchingRulesCount;
    return this;
  }

  /**
   * Get blacklistmatchingRulesCount
   * @return blacklistmatchingRulesCount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getBlacklistmatchingRulesCount() {
    return blacklistmatchingRulesCount;
  }

  public void setBlacklistmatchingRulesCount(BigDecimal blacklistmatchingRulesCount) {
    this.blacklistmatchingRulesCount = blacklistmatchingRulesCount;
  }

  public FraudDecisionSummary bureauReportMatchingRulesCount(BigDecimal bureauReportMatchingRulesCount) {
    this.bureauReportMatchingRulesCount = bureauReportMatchingRulesCount;
    return this;
  }

  /**
   * Get bureauReportMatchingRulesCount
   * @return bureauReportMatchingRulesCount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getBureauReportMatchingRulesCount() {
    return bureauReportMatchingRulesCount;
  }

  public void setBureauReportMatchingRulesCount(BigDecimal bureauReportMatchingRulesCount) {
    this.bureauReportMatchingRulesCount = bureauReportMatchingRulesCount;
  }

  public FraudDecisionSummary finalFraudDecision(String finalFraudDecision) {
    this.finalFraudDecision = finalFraudDecision;
    return this;
  }

  /**
   * Get finalFraudDecision
   * @return finalFraudDecision
  **/
  @ApiModelProperty(value = "")


  public String getFinalFraudDecision() {
    return finalFraudDecision;
  }

  public void setFinalFraudDecision(String finalFraudDecision) {
    this.finalFraudDecision = finalFraudDecision;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudDecisionSummary fraudDecisionSummary = (FraudDecisionSummary) o;
    return Objects.equals(this.caseRulesDecision, fraudDecisionSummary.caseRulesDecision) &&
        Objects.equals(this.matchingRulesCount, fraudDecisionSummary.matchingRulesCount) &&
        Objects.equals(this.blacklistmatchingRulesCount, fraudDecisionSummary.blacklistmatchingRulesCount) &&
        Objects.equals(this.bureauReportMatchingRulesCount, fraudDecisionSummary.bureauReportMatchingRulesCount) &&
        Objects.equals(this.finalFraudDecision, fraudDecisionSummary.finalFraudDecision);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caseRulesDecision, matchingRulesCount, blacklistmatchingRulesCount, bureauReportMatchingRulesCount, finalFraudDecision);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudDecisionSummary {\n");
    
    sb.append("    caseRulesDecision: ").append(toIndentedString(caseRulesDecision)).append("\n");
    sb.append("    matchingRulesCount: ").append(toIndentedString(matchingRulesCount)).append("\n");
    sb.append("    blacklistmatchingRulesCount: ").append(toIndentedString(blacklistmatchingRulesCount)).append("\n");
    sb.append("    bureauReportMatchingRulesCount: ").append(toIndentedString(bureauReportMatchingRulesCount)).append("\n");
    sb.append("    finalFraudDecision: ").append(toIndentedString(finalFraudDecision)).append("\n");
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

