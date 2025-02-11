package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.FraudDisposition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * update a fraud activity(application) with fraud disposition such as status ,type
 */
@ApiModel(description = "update a fraud activity(application) with fraud disposition such as status ,type")
@Validated

public class FraudActivityUpdate   {
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

  @JsonProperty("externalAccountId")
  private String externalAccountId = null;

  @JsonProperty("fraudDisposition")
  private FraudDisposition fraudDisposition = null;

  public FraudActivityUpdate id(Long id) {
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

  public FraudActivityUpdate baseType(String baseType) {
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

  public FraudActivityUpdate schemaLocation(String schemaLocation) {
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

  public FraudActivityUpdate type(String type) {
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

  public FraudActivityUpdate version(String version) {
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

  public FraudActivityUpdate externalApplicationId(String externalApplicationId) {
    this.externalApplicationId = externalApplicationId;
    return this;
  }

  /**
   * Unique identifier for a particular activity(application) assigned by the client who is receiving or submitting the fraudCheck application 
   * @return externalApplicationId
  **/
  @ApiModelProperty(value = "Unique identifier for a particular activity(application) assigned by the client who is receiving or submitting the fraudCheck application ")


  public String getExternalApplicationId() {
    return externalApplicationId;
  }

  public void setExternalApplicationId(String externalApplicationId) {
    this.externalApplicationId = externalApplicationId;
  }

  public FraudActivityUpdate externalCreditAssessmentId(String externalCreditAssessmentId) {
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

  public FraudActivityUpdate externalAccountId(String externalAccountId) {
    this.externalAccountId = externalAccountId;
    return this;
  }

  /**
   * 
   * @return externalAccountId
  **/
  @ApiModelProperty(value = "")


  public String getExternalAccountId() {
    return externalAccountId;
  }

  public void setExternalAccountId(String externalAccountId) {
    this.externalAccountId = externalAccountId;
  }

  public FraudActivityUpdate fraudDisposition(FraudDisposition fraudDisposition) {
    this.fraudDisposition = fraudDisposition;
    return this;
  }

  /**
   * Get fraudDisposition
   * @return fraudDisposition
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

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
    FraudActivityUpdate fraudActivityUpdate = (FraudActivityUpdate) o;
    return Objects.equals(this.id, fraudActivityUpdate.id) &&
        Objects.equals(this.baseType, fraudActivityUpdate.baseType) &&
        Objects.equals(this.schemaLocation, fraudActivityUpdate.schemaLocation) &&
        Objects.equals(this.type, fraudActivityUpdate.type) &&
        Objects.equals(this.version, fraudActivityUpdate.version) &&
        Objects.equals(this.externalApplicationId, fraudActivityUpdate.externalApplicationId) &&
        Objects.equals(this.externalCreditAssessmentId, fraudActivityUpdate.externalCreditAssessmentId) &&
        Objects.equals(this.externalAccountId, fraudActivityUpdate.externalAccountId) &&
        Objects.equals(this.fraudDisposition, fraudActivityUpdate.fraudDisposition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, baseType, schemaLocation, type, version, externalApplicationId, externalCreditAssessmentId, externalAccountId, fraudDisposition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudActivityUpdate {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    externalApplicationId: ").append(toIndentedString(externalApplicationId)).append("\n");
    sb.append("    externalCreditAssessmentId: ").append(toIndentedString(externalCreditAssessmentId)).append("\n");
    sb.append("    externalAccountId: ").append(toIndentedString(externalAccountId)).append("\n");
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

