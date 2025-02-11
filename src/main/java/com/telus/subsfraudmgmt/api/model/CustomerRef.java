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
 * Customer reference..
 */
@ApiModel(description = "Customer reference..")
@Validated

public class CustomerRef   {
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

  public CustomerRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the Customer
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the Customer")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CustomerRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the Customer
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the Customer")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public CustomerRef description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Detailed description of the Customer
   * @return description
  **/
  @ApiModelProperty(value = "Detailed description of the Customer")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CustomerRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the Customer
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the Customer")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CustomerRef baseType(String baseType) {
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

  public CustomerRef schemaLocation(String schemaLocation) {
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

  public CustomerRef type(String type) {
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

  public CustomerRef referredType(String referredType) {
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
    CustomerRef customerRef = (CustomerRef) o;
    return Objects.equals(this.id, customerRef.id) &&
        Objects.equals(this.href, customerRef.href) &&
        Objects.equals(this.description, customerRef.description) &&
        Objects.equals(this.name, customerRef.name) &&
        Objects.equals(this.baseType, customerRef.baseType) &&
        Objects.equals(this.schemaLocation, customerRef.schemaLocation) &&
        Objects.equals(this.type, customerRef.type) &&
        Objects.equals(this.referredType, customerRef.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, description, name, baseType, schemaLocation, type, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerRef {\n");
    
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

