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
 * 
 */
@ApiModel(description = "")
@Validated

public class TelusCreditDecisioningResultRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public TelusCreditDecisioningResultRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of a related entity.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of a related entity.")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TelusCreditDecisioningResultRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the related entity.
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the related entity.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public TelusCreditDecisioningResultRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the related entity. 
   * @return name
  **/
  @ApiModelProperty(value = "Name of the related entity. ")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TelusCreditDecisioningResultRef version(String version) {
    this.version = version;
    return this;
  }

  /**
   * version
   * @return version
  **/
  @ApiModelProperty(value = "version")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public TelusCreditDecisioningResultRef baseType(String baseType) {
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

  public TelusCreditDecisioningResultRef schemaLocation(String schemaLocation) {
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

  public TelusCreditDecisioningResultRef type(String type) {
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

  public TelusCreditDecisioningResultRef referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return referredType
  **/
  @ApiModelProperty(value = "The actual type of the target instance when needed for disambiguation.")


  public String getReferredType() {
    return referredType;
  }

  public void setReferredType(String referredType) {
    this.referredType = referredType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelusCreditDecisioningResultRef telusCreditDecisioningResultRef = (TelusCreditDecisioningResultRef) o;
    return Objects.equals(this.id, telusCreditDecisioningResultRef.id) &&
        Objects.equals(this.href, telusCreditDecisioningResultRef.href) &&
        Objects.equals(this.name, telusCreditDecisioningResultRef.name) &&
        Objects.equals(this.version, telusCreditDecisioningResultRef.version) &&
        Objects.equals(this.baseType, telusCreditDecisioningResultRef.baseType) &&
        Objects.equals(this.schemaLocation, telusCreditDecisioningResultRef.schemaLocation) &&
        Objects.equals(this.type, telusCreditDecisioningResultRef.type) &&
        Objects.equals(this.referredType, telusCreditDecisioningResultRef.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, version, baseType, schemaLocation, type, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelusCreditDecisioningResultRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
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

