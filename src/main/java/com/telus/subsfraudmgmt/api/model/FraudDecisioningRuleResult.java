package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.FraudDecisionCaseRulesFired;
import com.telus.subsfraudmgmt.api.model.FraudDecisionMatchingRulesFired;
import com.telus.subsfraudmgmt.api.model.FraudDecisionSummary;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Subscription Fraud Inquiry Response 
 */
@ApiModel(description = "Subscription Fraud Inquiry Response ")
@Validated

public class FraudDecisioningRuleResult   {
  @JsonProperty("fraudDecisionSummary")
  private FraudDecisionSummary fraudDecisionSummary = null;

  @JsonProperty("fraudDecisionCaseRulesFired")
  @Valid
  private List<FraudDecisionCaseRulesFired> fraudDecisionCaseRulesFired = null;

  @JsonProperty("fraudDecisionMatchingRulesFired")
  @Valid
  private List<FraudDecisionMatchingRulesFired> fraudDecisionMatchingRulesFired = null;

  public FraudDecisioningRuleResult fraudDecisionSummary(FraudDecisionSummary fraudDecisionSummary) {
    this.fraudDecisionSummary = fraudDecisionSummary;
    return this;
  }

  /**
   * Get fraudDecisionSummary
   * @return fraudDecisionSummary
  **/
  @ApiModelProperty(value = "")

  @Valid

  public FraudDecisionSummary getFraudDecisionSummary() {
    return fraudDecisionSummary;
  }

  public void setFraudDecisionSummary(FraudDecisionSummary fraudDecisionSummary) {
    this.fraudDecisionSummary = fraudDecisionSummary;
  }

  public FraudDecisioningRuleResult fraudDecisionCaseRulesFired(List<FraudDecisionCaseRulesFired> fraudDecisionCaseRulesFired) {
    this.fraudDecisionCaseRulesFired = fraudDecisionCaseRulesFired;
    return this;
  }

  public FraudDecisioningRuleResult addFraudDecisionCaseRulesFiredItem(FraudDecisionCaseRulesFired fraudDecisionCaseRulesFiredItem) {
    if (this.fraudDecisionCaseRulesFired == null) {
      this.fraudDecisionCaseRulesFired = new ArrayList<>();
    }
    this.fraudDecisionCaseRulesFired.add(fraudDecisionCaseRulesFiredItem);
    return this;
  }

  /**
   * Get fraudDecisionCaseRulesFired
   * @return fraudDecisionCaseRulesFired
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<FraudDecisionCaseRulesFired> getFraudDecisionCaseRulesFired() {
    return fraudDecisionCaseRulesFired;
  }

  public void setFraudDecisionCaseRulesFired(List<FraudDecisionCaseRulesFired> fraudDecisionCaseRulesFired) {
    this.fraudDecisionCaseRulesFired = fraudDecisionCaseRulesFired;
  }

  public FraudDecisioningRuleResult fraudDecisionMatchingRulesFired(List<FraudDecisionMatchingRulesFired> fraudDecisionMatchingRulesFired) {
    this.fraudDecisionMatchingRulesFired = fraudDecisionMatchingRulesFired;
    return this;
  }

  public FraudDecisioningRuleResult addFraudDecisionMatchingRulesFiredItem(FraudDecisionMatchingRulesFired fraudDecisionMatchingRulesFiredItem) {
    if (this.fraudDecisionMatchingRulesFired == null) {
      this.fraudDecisionMatchingRulesFired = new ArrayList<>();
    }
    this.fraudDecisionMatchingRulesFired.add(fraudDecisionMatchingRulesFiredItem);
    return this;
  }

  /**
   * Get fraudDecisionMatchingRulesFired
   * @return fraudDecisionMatchingRulesFired
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<FraudDecisionMatchingRulesFired> getFraudDecisionMatchingRulesFired() {
    return fraudDecisionMatchingRulesFired;
  }

  public void setFraudDecisionMatchingRulesFired(List<FraudDecisionMatchingRulesFired> fraudDecisionMatchingRulesFired) {
    this.fraudDecisionMatchingRulesFired = fraudDecisionMatchingRulesFired;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudDecisioningRuleResult fraudDecisioningRuleResult = (FraudDecisioningRuleResult) o;
    return Objects.equals(this.fraudDecisionSummary, fraudDecisioningRuleResult.fraudDecisionSummary) &&
        Objects.equals(this.fraudDecisionCaseRulesFired, fraudDecisioningRuleResult.fraudDecisionCaseRulesFired) &&
        Objects.equals(this.fraudDecisionMatchingRulesFired, fraudDecisioningRuleResult.fraudDecisionMatchingRulesFired);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fraudDecisionSummary, fraudDecisionCaseRulesFired, fraudDecisionMatchingRulesFired);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudDecisioningRuleResult {\n");
    
    sb.append("    fraudDecisionSummary: ").append(toIndentedString(fraudDecisionSummary)).append("\n");
    sb.append("    fraudDecisionCaseRulesFired: ").append(toIndentedString(fraudDecisionCaseRulesFired)).append("\n");
    sb.append("    fraudDecisionMatchingRulesFired: ").append(toIndentedString(fraudDecisionMatchingRulesFired)).append("\n");
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

