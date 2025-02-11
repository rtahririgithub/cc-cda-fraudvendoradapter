package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.BillFormatRef;
import com.telus.subsfraudmgmt.api.model.BillPresentationMediaRef;
import com.telus.subsfraudmgmt.api.model.BillingCycleSpecificationRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The structure of the bill for party accounts (billling or settlement).
 */
@ApiModel(description = "The structure of the bill for party accounts (billling or settlement).")
@Validated

public class BillStructure   {
  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("presentationMedia")
  @Valid
  private List<BillPresentationMediaRef> presentationMedia = null;

  @JsonProperty("format")
  private BillFormatRef format = null;

  @JsonProperty("cycleSpecification")
  private BillingCycleSpecificationRef cycleSpecification = null;

  public BillStructure baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * Generic attribute indicating the base class type of the extension class of the current object. Useful only when the class type of the current  object is unknown to the implementation.
   * @return baseType
  **/
  @ApiModelProperty(value = "Generic attribute indicating the base class type of the extension class of the current object. Useful only when the class type of the current  object is unknown to the implementation.")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public BillStructure schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * Generic attribute containing the link to the schema that defines the structure of the class type of the current object.
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "Generic attribute containing the link to the schema that defines the structure of the class type of the current object.")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public BillStructure type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Generic attribute containing the name of the resource class type
   * @return type
  **/
  @ApiModelProperty(value = "Generic attribute containing the name of the resource class type")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public BillStructure presentationMedia(List<BillPresentationMediaRef> presentationMedia) {
    this.presentationMedia = presentationMedia;
    return this;
  }

  public BillStructure addPresentationMediaItem(BillPresentationMediaRef presentationMediaItem) {
    if (this.presentationMedia == null) {
      this.presentationMedia = new ArrayList<>();
    }
    this.presentationMedia.add(presentationMediaItem);
    return this;
  }

  /**
   * Get presentationMedia
   * @return presentationMedia
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<BillPresentationMediaRef> getPresentationMedia() {
    return presentationMedia;
  }

  public void setPresentationMedia(List<BillPresentationMediaRef> presentationMedia) {
    this.presentationMedia = presentationMedia;
  }

  public BillStructure format(BillFormatRef format) {
    this.format = format;
    return this;
  }

  /**
   * Get format
   * @return format
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BillFormatRef getFormat() {
    return format;
  }

  public void setFormat(BillFormatRef format) {
    this.format = format;
  }

  public BillStructure cycleSpecification(BillingCycleSpecificationRef cycleSpecification) {
    this.cycleSpecification = cycleSpecification;
    return this;
  }

  /**
   * Get cycleSpecification
   * @return cycleSpecification
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BillingCycleSpecificationRef getCycleSpecification() {
    return cycleSpecification;
  }

  public void setCycleSpecification(BillingCycleSpecificationRef cycleSpecification) {
    this.cycleSpecification = cycleSpecification;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillStructure billStructure = (BillStructure) o;
    return Objects.equals(this.baseType, billStructure.baseType) &&
        Objects.equals(this.schemaLocation, billStructure.schemaLocation) &&
        Objects.equals(this.type, billStructure.type) &&
        Objects.equals(this.presentationMedia, billStructure.presentationMedia) &&
        Objects.equals(this.format, billStructure.format) &&
        Objects.equals(this.cycleSpecification, billStructure.cycleSpecification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, presentationMedia, format, cycleSpecification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillStructure {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    presentationMedia: ").append(toIndentedString(presentationMedia)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    cycleSpecification: ").append(toIndentedString(cycleSpecification)).append("\n");
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

