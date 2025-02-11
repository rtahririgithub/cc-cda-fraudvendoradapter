package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.CustomerRefOrValue;
import com.telus.subsfraudmgmt.api.model.TelusChannelRefOfValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The input/request including customer , requested subscriber  , existing subscriber , credit , credit bureau data , etc. 
 */
@ApiModel(description = "The input/request including customer , requested subscriber  , existing subscriber , credit , credit bureau data , etc. ")
@Validated

public class FraudCheckPerform   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("externalApplicationId")
  private String externalApplicationId = null;

  @JsonProperty("externalCreditAssessmentId")
  private String externalCreditAssessmentId = null;

  @JsonProperty("applicationDateTime")
  private String applicationDateTime = null;

  @JsonProperty("customer")
  private CustomerRefOrValue customer = null;

  @JsonProperty("channel")
  private TelusChannelRefOfValue channel = null;

  public FraudCheckPerform id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * unique id for this entity
   * @return id
  **/
  @ApiModelProperty(value = "unique id for this entity")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public FraudCheckPerform baseType(String baseType) {
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

  public FraudCheckPerform schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   *  URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = " URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public FraudCheckPerform type(String type) {
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

  public FraudCheckPerform version(String version) {
    this.version = version;
    return this;
  }

  /**
   * API version 
   * @return version
  **/
  @ApiModelProperty(value = "API version ")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public FraudCheckPerform externalApplicationId(String externalApplicationId) {
    this.externalApplicationId = externalApplicationId;
    return this;
  }

  /**
   * Unique identifier for a particular activity(application) assigned by the client who is receiving or submitting the fraudCheck application 
   * @return externalApplicationId
  **/
  @ApiModelProperty(required = true, value = "Unique identifier for a particular activity(application) assigned by the client who is receiving or submitting the fraudCheck application ")
  @NotNull


  public String getExternalApplicationId() {
    return externalApplicationId;
  }

  public void setExternalApplicationId(String externalApplicationId) {
    this.externalApplicationId = externalApplicationId;
  }

  public FraudCheckPerform externalCreditAssessmentId(String externalCreditAssessmentId) {
    this.externalCreditAssessmentId = externalCreditAssessmentId;
    return this;
  }

  /**
   * 
   * @return externalCreditAssessmentId
  **/
  @ApiModelProperty(value = "")


  public String getExternalCreditAssessmentId() {
    return externalCreditAssessmentId;
  }

  public void setExternalCreditAssessmentId(String externalCreditAssessmentId) {
    this.externalCreditAssessmentId = externalCreditAssessmentId;
  }

  public FraudCheckPerform applicationDateTime(String applicationDateTime) {
    this.applicationDateTime = applicationDateTime;
    return this;
  }

  /**
   * Date and time that the application was received from the applicant
   * @return applicationDateTime
  **/
  @ApiModelProperty(required = true, value = "Date and time that the application was received from the applicant")
  @NotNull

  @Valid

  public String getApplicationDateTime() {
    return applicationDateTime;
  }

  public void setApplicationDateTime(String applicationDateTime) {
    this.applicationDateTime = applicationDateTime;
  }

  public FraudCheckPerform customer(CustomerRefOrValue customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public CustomerRefOrValue getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerRefOrValue customer) {
    this.customer = customer;
  }

  public FraudCheckPerform channel(TelusChannelRefOfValue channel) {
    this.channel = channel;
    return this;
  }

  /**
   * Get channel
   * @return channel
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public TelusChannelRefOfValue getChannel() {
    return channel;
  }

  public void setChannel(TelusChannelRefOfValue channel) {
    this.channel = channel;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudCheckPerform fraudCheckPerform = (FraudCheckPerform) o;
    return Objects.equals(this.id, fraudCheckPerform.id) &&
        Objects.equals(this.baseType, fraudCheckPerform.baseType) &&
        Objects.equals(this.schemaLocation, fraudCheckPerform.schemaLocation) &&
        Objects.equals(this.type, fraudCheckPerform.type) &&
        Objects.equals(this.version, fraudCheckPerform.version) &&
        Objects.equals(this.externalApplicationId, fraudCheckPerform.externalApplicationId) &&
        Objects.equals(this.externalCreditAssessmentId, fraudCheckPerform.externalCreditAssessmentId) &&
        Objects.equals(this.applicationDateTime, fraudCheckPerform.applicationDateTime) &&
        Objects.equals(this.customer, fraudCheckPerform.customer) &&
        Objects.equals(this.channel, fraudCheckPerform.channel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, baseType, schemaLocation, type, version, externalApplicationId, externalCreditAssessmentId, applicationDateTime, customer, channel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudCheckPerform {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    externalApplicationId: ").append(toIndentedString(externalApplicationId)).append("\n");
    sb.append("    externalCreditAssessmentId: ").append(toIndentedString(externalCreditAssessmentId)).append("\n");
    sb.append("    applicationDateTime: ").append(toIndentedString(applicationDateTime)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
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

