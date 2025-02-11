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
 * CreditProfile reference..
 */
@ApiModel(description = "CreditProfile reference..")
@Validated

public class CreditProfileRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public CreditProfileRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the CreditProfile
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the CreditProfile")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CreditProfileRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the CreditProfile
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the CreditProfile")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public CreditProfileRef description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Detailed description of the CreditProfile
   * @return description
  **/
  @ApiModelProperty(value = "Detailed description of the CreditProfile")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CreditProfileRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the CreditProfile
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the CreditProfile")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreditProfileRef baseType(String baseType) {
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

  public CreditProfileRef schemaLocation(String schemaLocation) {
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

  public CreditProfileRef type(String type) {
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

  public CreditProfileRef referredType(String referredType) {
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
    CreditProfileRef creditProfileRef = (CreditProfileRef) o;
    return Objects.equals(this.id, creditProfileRef.id) &&
        Objects.equals(this.href, creditProfileRef.href) &&
        Objects.equals(this.description, creditProfileRef.description) &&
        Objects.equals(this.name, creditProfileRef.name) &&
        Objects.equals(this.baseType, creditProfileRef.baseType) &&
        Objects.equals(this.schemaLocation, creditProfileRef.schemaLocation) &&
        Objects.equals(this.type, creditProfileRef.type) &&
        Objects.equals(this.referredType, creditProfileRef.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, description, name, baseType, schemaLocation, type, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditProfileRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

