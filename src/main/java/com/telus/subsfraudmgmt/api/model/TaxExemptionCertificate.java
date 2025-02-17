package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.AttachmentRefOrValue;
import com.telus.subsfraudmgmt.api.model.TaxDefinition;
import com.telus.subsfraudmgmt.api.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A tax exemption certificate represents a tax exemption granted to a party (individual or organization) by a tax jurisdiction which may be a city, state, country,... An exemption has a certificate identifier (received from the jurisdiction that levied the tax) and a validity period. An exemption is per tax types and determines for each type of tax what portion of the tax is exempted (partial by percentage or complete) via the tax definition.
 */
@ApiModel(description = "A tax exemption certificate represents a tax exemption granted to a party (individual or organization) by a tax jurisdiction which may be a city, state, country,... An exemption has a certificate identifier (received from the jurisdiction that levied the tax) and a validity period. An exemption is per tax types and determines for each type of tax what portion of the tax is exempted (partial by percentage or complete) via the tax definition.")
@Validated

public class TaxExemptionCertificate   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("attachment")
  private AttachmentRefOrValue attachment = null;

  @JsonProperty("taxDefinition")
  @Valid
  private List<TaxDefinition> taxDefinition = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public TaxExemptionCertificate id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the certificate of the tax exemption
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the certificate of the tax exemption")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TaxExemptionCertificate attachment(AttachmentRefOrValue attachment) {
    this.attachment = attachment;
    return this;
  }

  /**
   * Get attachment
   * @return attachment
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AttachmentRefOrValue getAttachment() {
    return attachment;
  }

  public void setAttachment(AttachmentRefOrValue attachment) {
    this.attachment = attachment;
  }

  public TaxExemptionCertificate taxDefinition(List<TaxDefinition> taxDefinition) {
    this.taxDefinition = taxDefinition;
    return this;
  }

  public TaxExemptionCertificate addTaxDefinitionItem(TaxDefinition taxDefinitionItem) {
    if (this.taxDefinition == null) {
      this.taxDefinition = new ArrayList<>();
    }
    this.taxDefinition.add(taxDefinitionItem);
    return this;
  }

  /**
   * Get taxDefinition
   * @return taxDefinition
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<TaxDefinition> getTaxDefinition() {
    return taxDefinition;
  }

  public void setTaxDefinition(List<TaxDefinition> taxDefinition) {
    this.taxDefinition = taxDefinition;
  }

  public TaxExemptionCertificate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Get validFor
   * @return validFor
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public TaxExemptionCertificate baseType(String baseType) {
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

  public TaxExemptionCertificate schemaLocation(String schemaLocation) {
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

  public TaxExemptionCertificate type(String type) {
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
    TaxExemptionCertificate taxExemptionCertificate = (TaxExemptionCertificate) o;
    return Objects.equals(this.id, taxExemptionCertificate.id) &&
        Objects.equals(this.attachment, taxExemptionCertificate.attachment) &&
        Objects.equals(this.taxDefinition, taxExemptionCertificate.taxDefinition) &&
        Objects.equals(this.validFor, taxExemptionCertificate.validFor) &&
        Objects.equals(this.baseType, taxExemptionCertificate.baseType) &&
        Objects.equals(this.schemaLocation, taxExemptionCertificate.schemaLocation) &&
        Objects.equals(this.type, taxExemptionCertificate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, attachment, taxDefinition, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaxExemptionCertificate {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    taxDefinition: ").append(toIndentedString(taxDefinition)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
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

