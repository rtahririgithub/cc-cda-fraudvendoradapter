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
 * Case Rules Fired
 */
@ApiModel(description = "Case Rules Fired")
@Validated

public class FraudDecisionCaseRulesFired   {
  @JsonProperty("ruleID")
  private String ruleID = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("proposedDecision")
  private String proposedDecision = null;

  @JsonProperty("createCase")
  private String createCase = null;

  @JsonProperty("decision")
  private String decision = null;

  public FraudDecisionCaseRulesFired ruleID(String ruleID) {
    this.ruleID = ruleID;
    return this;
  }

  /**
   * Get ruleID
   * @return ruleID
  **/
  @ApiModelProperty(value = "")


  public String getRuleID() {
    return ruleID;
  }

  public void setRuleID(String ruleID) {
    this.ruleID = ruleID;
  }

  public FraudDecisionCaseRulesFired description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public FraudDecisionCaseRulesFired proposedDecision(String proposedDecision) {
    this.proposedDecision = proposedDecision;
    return this;
  }

  /**
   * Get proposedDecision
   * @return proposedDecision
  **/
  @ApiModelProperty(value = "")


  public String getProposedDecision() {
    return proposedDecision;
  }

  public void setProposedDecision(String proposedDecision) {
    this.proposedDecision = proposedDecision;
  }

  public FraudDecisionCaseRulesFired createCase(String createCase) {
    this.createCase = createCase;
    return this;
  }

  /**
   * Get createCase
   * @return createCase
  **/
  @ApiModelProperty(value = "")


  public String getCreateCase() {
    return createCase;
  }

  public void setCreateCase(String createCase) {
    this.createCase = createCase;
  }

  public FraudDecisionCaseRulesFired decision(String decision) {
    this.decision = decision;
    return this;
  }

  /**
   * Get decision
   * @return decision
  **/
  @ApiModelProperty(value = "")


  public String getDecision() {
    return decision;
  }

  public void setDecision(String decision) {
    this.decision = decision;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudDecisionCaseRulesFired fraudDecisionCaseRulesFired = (FraudDecisionCaseRulesFired) o;
    return Objects.equals(this.ruleID, fraudDecisionCaseRulesFired.ruleID) &&
        Objects.equals(this.description, fraudDecisionCaseRulesFired.description) &&
        Objects.equals(this.proposedDecision, fraudDecisionCaseRulesFired.proposedDecision) &&
        Objects.equals(this.createCase, fraudDecisionCaseRulesFired.createCase) &&
        Objects.equals(this.decision, fraudDecisionCaseRulesFired.decision);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ruleID, description, proposedDecision, createCase, decision);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudDecisionCaseRulesFired {\n");
    
    sb.append("    ruleID: ").append(toIndentedString(ruleID)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    proposedDecision: ").append(toIndentedString(proposedDecision)).append("\n");
    sb.append("    createCase: ").append(toIndentedString(createCase)).append("\n");
    sb.append("    decision: ").append(toIndentedString(decision)).append("\n");
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

