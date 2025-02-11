package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Channel;
import com.telus.subsfraudmgmt.api.model.ChannelRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Related Entity reference.  A related entity defines a entity described by reference or by value linked to a specific entity. The polymorphic attributes @type, @schemaLocation &amp; @referredType are related to the entity entity and not the xxxRefOrValue class itself
 */
@ApiModel(description = "Related Entity reference.  A related entity defines a entity described by reference or by value linked to a specific entity. The polymorphic attributes @type, @schemaLocation & @referredType are related to the entity entity and not the xxxRefOrValue class itself")
@Validated

public class ChannelRefOrValue extends Channel  {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@type")
  private String type = null;

  public ChannelRefOrValue name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the related entity.
   * @return name
  **/
  @ApiModelProperty(value = "Name of the related entity.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ChannelRefOrValue id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of a related entity.
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of a related entity.")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ChannelRefOrValue href(String href) {
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

  public ChannelRefOrValue referredType(String referredType) {
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

  public ChannelRefOrValue schemaLocation(String schemaLocation) {
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

  public ChannelRefOrValue baseType(String baseType) {
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

  public ChannelRefOrValue type(String type) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelRefOrValue channelRefOrValue = (ChannelRefOrValue) o;
    return Objects.equals(this.name, channelRefOrValue.name) &&
        Objects.equals(this.id, channelRefOrValue.id) &&
        Objects.equals(this.href, channelRefOrValue.href) &&
        Objects.equals(this.referredType, channelRefOrValue.referredType) &&
        Objects.equals(this.schemaLocation, channelRefOrValue.schemaLocation) &&
        Objects.equals(this.baseType, channelRefOrValue.baseType) &&
        Objects.equals(this.type, channelRefOrValue.type) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id, href, referredType, schemaLocation, baseType, type, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelRefOrValue {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

