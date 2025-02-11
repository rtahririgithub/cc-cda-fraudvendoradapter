package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.CustomerRefOrValue;
import com.telus.subsfraudmgmt.api.model.FraudAnalyticModelScore;
import com.telus.subsfraudmgmt.api.model.FraudCheckDecisioningError;
import com.telus.subsfraudmgmt.api.model.FraudDecisioningRuleResult;
import com.telus.subsfraudmgmt.api.model.RelatedParty;
import com.telus.subsfraudmgmt.api.model.TelusChannelRefOfValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Fraud Check Result.
 */
@ApiModel(description = "Fraud Check Result.")
@Validated

public class FraudCheck   {
  @JsonProperty("fraudCheckTransactionId")
  private String fraudCheckTransactionId = null;

  @JsonProperty("fraudAnalyticModelScore")
  @Valid
  private List<FraudAnalyticModelScore> fraudAnalyticModelScore = null;

  @JsonProperty("fraudDecisioningRuleResult")
  private FraudDecisioningRuleResult fraudDecisioningRuleResult = null;

  @JsonProperty("externalApplicationId")
  private String externalApplicationId = null;

  @JsonProperty("applicationDateTime")
  private String  applicationDateTime = null;

  @JsonProperty("customer")
  private CustomerRefOrValue customer = null;

  @JsonProperty("channel")
  private TelusChannelRefOfValue channel = null;

  @JsonProperty("relatedParty")
  private RelatedParty relatedParty = null;

  @JsonProperty("decisioningError")
  private FraudCheckDecisioningError decisioningError = null;

  public FraudCheck fraudCheckTransactionId(String fraudCheckTransactionId) {
    this.fraudCheckTransactionId = fraudCheckTransactionId;
    return this;
  }

  /**
   * Get fraudCheckTransactionId
   * @return fraudCheckTransactionId
  **/
  @ApiModelProperty(value = "")


  public String getFraudCheckTransactionId() {
    return fraudCheckTransactionId;
  }

  public void setFraudCheckTransactionId(String fraudCheckTransactionId) {
    this.fraudCheckTransactionId = fraudCheckTransactionId;
  }

  public FraudCheck fraudAnalyticModelScore(List<FraudAnalyticModelScore> fraudAnalyticModelScore) {
    this.fraudAnalyticModelScore = fraudAnalyticModelScore;
    return this;
  }

  public FraudCheck addFraudAnalyticModelScoreItem(FraudAnalyticModelScore fraudAnalyticModelScoreItem) {
    if (this.fraudAnalyticModelScore == null) {
      this.fraudAnalyticModelScore = new ArrayList<>();
    }
    this.fraudAnalyticModelScore.add(fraudAnalyticModelScoreItem);
    return this;
  }

  /**
   * Get fraudAnalyticModelScore
   * @return fraudAnalyticModelScore
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<FraudAnalyticModelScore> getFraudAnalyticModelScore() {
    return fraudAnalyticModelScore;
  }

  public void setFraudAnalyticModelScore(List<FraudAnalyticModelScore> fraudAnalyticModelScore) {
    this.fraudAnalyticModelScore = fraudAnalyticModelScore;
  }

  public FraudCheck fraudDecisioningRuleResult(FraudDecisioningRuleResult fraudDecisioningRuleResult) {
    this.fraudDecisioningRuleResult = fraudDecisioningRuleResult;
    return this;
  }

  /**
   * Get fraudDecisioningRuleResult
   * @return fraudDecisioningRuleResult
  **/
  @ApiModelProperty(value = "")

  @Valid

  public FraudDecisioningRuleResult getFraudDecisioningRuleResult() {
    return fraudDecisioningRuleResult;
  }

  public void setFraudDecisioningRuleResult(FraudDecisioningRuleResult fraudDecisioningRuleResult) {
    this.fraudDecisioningRuleResult = fraudDecisioningRuleResult;
  }

  public FraudCheck externalApplicationId(String externalApplicationId) {
    this.externalApplicationId = externalApplicationId;
    return this;
  }

  /**
   * Unique identifier for a particular application assigned by the client who is receiving or submitting the fraudCheck application 
   * @return externalApplicationId
  **/
  @ApiModelProperty(value = "Unique identifier for a particular application assigned by the client who is receiving or submitting the fraudCheck application ")


  public String getExternalApplicationId() {
    return externalApplicationId;
  }

  public void setExternalApplicationId(String externalApplicationId) {
    this.externalApplicationId = externalApplicationId;
  }

  public FraudCheck applicationDateTime(String  applicationDateTime) {
    this.applicationDateTime = applicationDateTime;
    return this;
  }

  /**
   * Date and time that the application was received from the applicant
   * @return applicationDateTime
  **/
  @ApiModelProperty(value = "Date and time that the application was received from the applicant")

  @Valid

  public String  getApplicationDateTime() {
    return applicationDateTime;
  }

  public void setApplicationDateTime(String  applicationDateTime) {
    this.applicationDateTime = applicationDateTime;
  }

  public FraudCheck customer(CustomerRefOrValue customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CustomerRefOrValue getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerRefOrValue customer) {
    this.customer = customer;
  }

  public FraudCheck channel(TelusChannelRefOfValue channel) {
    this.channel = channel;
    return this;
  }

  /**
   * Get channel
   * @return channel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TelusChannelRefOfValue getChannel() {
    return channel;
  }

  public void setChannel(TelusChannelRefOfValue channel) {
    this.channel = channel;
  }

  public FraudCheck relatedParty(RelatedParty relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  /**
   * Get relatedParty
   * @return relatedParty
  **/
  @ApiModelProperty(value = "")

  @Valid

  public RelatedParty getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(RelatedParty relatedParty) {
    this.relatedParty = relatedParty;
  }

  public FraudCheck decisioningError(FraudCheckDecisioningError decisioningError) {
    this.decisioningError = decisioningError;
    return this;
  }

  /**
   * Get decisioningError
   * @return decisioningError
  **/
  @ApiModelProperty(value = "")

  @Valid

  public FraudCheckDecisioningError getDecisioningError() {
    return decisioningError;
  }

  public void setDecisioningError(FraudCheckDecisioningError decisioningError) {
    this.decisioningError = decisioningError;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudCheck fraudCheck = (FraudCheck) o;
    return Objects.equals(this.fraudCheckTransactionId, fraudCheck.fraudCheckTransactionId) &&
        Objects.equals(this.fraudAnalyticModelScore, fraudCheck.fraudAnalyticModelScore) &&
        Objects.equals(this.fraudDecisioningRuleResult, fraudCheck.fraudDecisioningRuleResult) &&
        Objects.equals(this.externalApplicationId, fraudCheck.externalApplicationId) &&
        Objects.equals(this.applicationDateTime, fraudCheck.applicationDateTime) &&
        Objects.equals(this.customer, fraudCheck.customer) &&
        Objects.equals(this.channel, fraudCheck.channel) &&
        Objects.equals(this.relatedParty, fraudCheck.relatedParty) &&
        Objects.equals(this.decisioningError, fraudCheck.decisioningError);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fraudCheckTransactionId, fraudAnalyticModelScore, fraudDecisioningRuleResult, externalApplicationId, applicationDateTime, customer, channel, relatedParty, decisioningError);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudCheck {\n");
    
    sb.append("    fraudCheckTransactionId: ").append(toIndentedString(fraudCheckTransactionId)).append("\n");
    sb.append("    fraudAnalyticModelScore: ").append(toIndentedString(fraudAnalyticModelScore)).append("\n");
    sb.append("    fraudDecisioningRuleResult: ").append(toIndentedString(fraudDecisioningRuleResult)).append("\n");
    sb.append("    externalApplicationId: ").append(toIndentedString(externalApplicationId)).append("\n");
    sb.append("    applicationDateTime: ").append(toIndentedString(applicationDateTime)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    decisioningError: ").append(toIndentedString(decisioningError)).append("\n");
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

