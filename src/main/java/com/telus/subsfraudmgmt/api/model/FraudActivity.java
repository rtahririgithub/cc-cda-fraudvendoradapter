package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.CustomerRefOrValue;
import com.telus.subsfraudmgmt.api.model.FraudAnalyticModelScore;
import com.telus.subsfraudmgmt.api.model.FraudDecisioningRuleResult;
import com.telus.subsfraudmgmt.api.model.FraudDisposition;
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
 * represents a snapshot of fraud activity related data including data used to perform fraud check , the fraud check result, the status of the fraud activity. 
 */
@ApiModel(description = "represents a snapshot of fraud activity related data including data used to perform fraud check , the fraud check result, the status of the fraud activity. ")
@Validated

public class FraudActivity   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("externalApplicationId")
  private String externalApplicationId = null;

  @JsonProperty("applicationDateTime")
  private String  applicationDateTime = null;

  @JsonProperty("customer")
  private CustomerRefOrValue customer = null;

  @JsonProperty("channel")
  private TelusChannelRefOfValue channel = null;

  @JsonProperty("fraudCheckTransactionId")
  private String fraudCheckTransactionId = null;

  @JsonProperty("fraudAnalyticModelScore")
  @Valid
  private List<FraudAnalyticModelScore> fraudAnalyticModelScore = null;

  @JsonProperty("fraudDecisioningRuleResult")
  private FraudDecisioningRuleResult fraudDecisioningRuleResult = null;

  @JsonProperty("fraudDisposition")
  private FraudDisposition fraudDisposition = null;

  public FraudActivity id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier 
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier ")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FraudActivity href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Url used to reference .
   * @return href
  **/
  @ApiModelProperty(value = "Url used to reference .")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public FraudActivity baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public FraudActivity schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public FraudActivity type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public FraudActivity externalApplicationId(String externalApplicationId) {
    this.externalApplicationId = externalApplicationId;
    return this;
  }

  /**
   * Unique identifier for a particular activity(application) assigned by the client who is receiving or submitting the fraudCheck request 
   * @return externalApplicationId
  **/
  @ApiModelProperty(value = "Unique identifier for a particular activity(application) assigned by the client who is receiving or submitting the fraudCheck request ")


  public String getExternalApplicationId() {
    return externalApplicationId;
  }

  public void setExternalApplicationId(String externalApplicationId) {
    this.externalApplicationId = externalApplicationId;
  }

  public FraudActivity applicationDateTime(String  applicationDateTime) {
    this.applicationDateTime = applicationDateTime;
    return this;
  }

  /**
   * Date and time that the activity(application) was received from the applicant
   * @return applicationDateTime
  **/
  @ApiModelProperty(value = "Date and time that the activity(application) was received from the applicant")

  @Valid

  public String  getApplicationDateTime() {
    return applicationDateTime;
  }

  public void setApplicationDateTime(String  applicationDateTime) {
    this.applicationDateTime = applicationDateTime;
  }

  public FraudActivity customer(CustomerRefOrValue customer) {
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

  public FraudActivity channel(TelusChannelRefOfValue channel) {
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

  public FraudActivity fraudCheckTransactionId(String fraudCheckTransactionId) {
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

  public FraudActivity fraudAnalyticModelScore(List<FraudAnalyticModelScore> fraudAnalyticModelScore) {
    this.fraudAnalyticModelScore = fraudAnalyticModelScore;
    return this;
  }

  public FraudActivity addFraudAnalyticModelScoreItem(FraudAnalyticModelScore fraudAnalyticModelScoreItem) {
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

  public FraudActivity fraudDecisioningRuleResult(FraudDecisioningRuleResult fraudDecisioningRuleResult) {
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

  public FraudActivity fraudDisposition(FraudDisposition fraudDisposition) {
    this.fraudDisposition = fraudDisposition;
    return this;
  }

  /**
   * Get fraudDisposition
   * @return fraudDisposition
  **/
  @ApiModelProperty(value = "")

  @Valid

  public FraudDisposition getFraudDisposition() {
    return fraudDisposition;
  }

  public void setFraudDisposition(FraudDisposition fraudDisposition) {
    this.fraudDisposition = fraudDisposition;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudActivity fraudActivity = (FraudActivity) o;
    return Objects.equals(this.id, fraudActivity.id) &&
        Objects.equals(this.href, fraudActivity.href) &&
        Objects.equals(this.baseType, fraudActivity.baseType) &&
        Objects.equals(this.schemaLocation, fraudActivity.schemaLocation) &&
        Objects.equals(this.type, fraudActivity.type) &&
        Objects.equals(this.externalApplicationId, fraudActivity.externalApplicationId) &&
        Objects.equals(this.applicationDateTime, fraudActivity.applicationDateTime) &&
        Objects.equals(this.customer, fraudActivity.customer) &&
        Objects.equals(this.channel, fraudActivity.channel) &&
        Objects.equals(this.fraudCheckTransactionId, fraudActivity.fraudCheckTransactionId) &&
        Objects.equals(this.fraudAnalyticModelScore, fraudActivity.fraudAnalyticModelScore) &&
        Objects.equals(this.fraudDecisioningRuleResult, fraudActivity.fraudDecisioningRuleResult) &&
        Objects.equals(this.fraudDisposition, fraudActivity.fraudDisposition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, baseType, schemaLocation, type, externalApplicationId, applicationDateTime, customer, channel, fraudCheckTransactionId, fraudAnalyticModelScore, fraudDecisioningRuleResult, fraudDisposition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudActivity {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    externalApplicationId: ").append(toIndentedString(externalApplicationId)).append("\n");
    sb.append("    applicationDateTime: ").append(toIndentedString(applicationDateTime)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    fraudCheckTransactionId: ").append(toIndentedString(fraudCheckTransactionId)).append("\n");
    sb.append("    fraudAnalyticModelScore: ").append(toIndentedString(fraudAnalyticModelScore)).append("\n");
    sb.append("    fraudDecisioningRuleResult: ").append(toIndentedString(fraudDecisioningRuleResult)).append("\n");
    sb.append("    fraudDisposition: ").append(toIndentedString(fraudDisposition)).append("\n");
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

