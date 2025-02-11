package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.RelatedEntity;
import com.telus.subsfraudmgmt.api.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ModelCase
 */
@Validated

public class ModelCase   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("externalId")
  private String externalId = null;

  @JsonProperty("ticketType")
  private String ticketType = null;

  @JsonProperty("creationDate")
  private OffsetDateTime creationDate = null;

  @JsonProperty("lastUpdate")
  private OffsetDateTime lastUpdate = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("reason")
  private String reason = null;

  @JsonProperty("severity")
  private String severity = null;

  @JsonProperty("priority")
  private String priority = null;

  @JsonProperty("requestedResolutionDate")
  private OffsetDateTime requestedResolutionDate = null;

  @JsonProperty("expectedResolutionDate")
  private OffsetDateTime expectedResolutionDate = null;

  @JsonProperty("resolutionDate")
  private OffsetDateTime resolutionDate = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("statusChangeReason")
  private String statusChangeReason = null;

  @JsonProperty("relatedEntity")
  private RelatedEntity relatedEntity = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedParty> relatedParty = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public ModelCase id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for Customers
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier for Customers")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ModelCase href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Url used to reference the customer.
   * @return href
  **/
  @ApiModelProperty(value = "Url used to reference the customer.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ModelCase name(String name) {
    this.name = name;
    return this;
  }

  /**
   * case name
   * @return name
  **/
  @ApiModelProperty(value = "case name")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ModelCase externalId(String externalId) {
    this.externalId = externalId;
    return this;
  }

  /**
   * case external ID
   * @return externalId
  **/
  @ApiModelProperty(value = "case external ID")


  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public ModelCase ticketType(String ticketType) {
    this.ticketType = ticketType;
    return this;
  }

  /**
   * case ticket type
   * @return ticketType
  **/
  @ApiModelProperty(value = "case ticket type")


  public String getTicketType() {
    return ticketType;
  }

  public void setTicketType(String ticketType) {
    this.ticketType = ticketType;
  }

  public ModelCase creationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * case creationDate
   * @return creationDate
  **/
  @ApiModelProperty(value = "case creationDate")

  @Valid

  public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public ModelCase lastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * case lastUpdate
   * @return lastUpdate
  **/
  @ApiModelProperty(value = "case lastUpdate")

  @Valid

  public OffsetDateTime getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public ModelCase description(String description) {
    this.description = description;
    return this;
  }

  /**
   * case description
   * @return description
  **/
  @ApiModelProperty(value = "case description")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ModelCase reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * case reason
   * @return reason
  **/
  @ApiModelProperty(value = "case reason")


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public ModelCase severity(String severity) {
    this.severity = severity;
    return this;
  }

  /**
   * case severity
   * @return severity
  **/
  @ApiModelProperty(value = "case severity")


  public String getSeverity() {
    return severity;
  }

  public void setSeverity(String severity) {
    this.severity = severity;
  }

  public ModelCase priority(String priority) {
    this.priority = priority;
    return this;
  }

  /**
   * case priority
   * @return priority
  **/
  @ApiModelProperty(value = "case priority")


  public String getPriority() {
    return priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public ModelCase requestedResolutionDate(OffsetDateTime requestedResolutionDate) {
    this.requestedResolutionDate = requestedResolutionDate;
    return this;
  }

  /**
   * case requestedResolutionDate
   * @return requestedResolutionDate
  **/
  @ApiModelProperty(value = "case requestedResolutionDate")

  @Valid

  public OffsetDateTime getRequestedResolutionDate() {
    return requestedResolutionDate;
  }

  public void setRequestedResolutionDate(OffsetDateTime requestedResolutionDate) {
    this.requestedResolutionDate = requestedResolutionDate;
  }

  public ModelCase expectedResolutionDate(OffsetDateTime expectedResolutionDate) {
    this.expectedResolutionDate = expectedResolutionDate;
    return this;
  }

  /**
   * case expectedResolutionDate
   * @return expectedResolutionDate
  **/
  @ApiModelProperty(value = "case expectedResolutionDate")

  @Valid

  public OffsetDateTime getExpectedResolutionDate() {
    return expectedResolutionDate;
  }

  public void setExpectedResolutionDate(OffsetDateTime expectedResolutionDate) {
    this.expectedResolutionDate = expectedResolutionDate;
  }

  public ModelCase resolutionDate(OffsetDateTime resolutionDate) {
    this.resolutionDate = resolutionDate;
    return this;
  }

  /**
   * case expectedResolutionDate
   * @return resolutionDate
  **/
  @ApiModelProperty(value = "case expectedResolutionDate")

  @Valid

  public OffsetDateTime getResolutionDate() {
    return resolutionDate;
  }

  public void setResolutionDate(OffsetDateTime resolutionDate) {
    this.resolutionDate = resolutionDate;
  }

  public ModelCase status(String status) {
    this.status = status;
    return this;
  }

  /**
   * case status
   * @return status
  **/
  @ApiModelProperty(value = "case status")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ModelCase statusChangeReason(String statusChangeReason) {
    this.statusChangeReason = statusChangeReason;
    return this;
  }

  /**
   * case statusChangeReason
   * @return statusChangeReason
  **/
  @ApiModelProperty(value = "case statusChangeReason")


  public String getStatusChangeReason() {
    return statusChangeReason;
  }

  public void setStatusChangeReason(String statusChangeReason) {
    this.statusChangeReason = statusChangeReason;
  }

  public ModelCase relatedEntity(RelatedEntity relatedEntity) {
    this.relatedEntity = relatedEntity;
    return this;
  }

  /**
   * Get relatedEntity
   * @return relatedEntity
  **/
  @ApiModelProperty(value = "")

  @Valid

  public RelatedEntity getRelatedEntity() {
    return relatedEntity;
  }

  public void setRelatedEntity(RelatedEntity relatedEntity) {
    this.relatedEntity = relatedEntity;
  }

  public ModelCase relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ModelCase addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Get relatedParty
   * @return relatedParty
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public ModelCase baseType(String baseType) {
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

  public ModelCase schemaLocation(String schemaLocation) {
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

  public ModelCase type(String type) {
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
    ModelCase _case = (ModelCase) o;
    return Objects.equals(this.id, _case.id) &&
        Objects.equals(this.href, _case.href) &&
        Objects.equals(this.name, _case.name) &&
        Objects.equals(this.externalId, _case.externalId) &&
        Objects.equals(this.ticketType, _case.ticketType) &&
        Objects.equals(this.creationDate, _case.creationDate) &&
        Objects.equals(this.lastUpdate, _case.lastUpdate) &&
        Objects.equals(this.description, _case.description) &&
        Objects.equals(this.reason, _case.reason) &&
        Objects.equals(this.severity, _case.severity) &&
        Objects.equals(this.priority, _case.priority) &&
        Objects.equals(this.requestedResolutionDate, _case.requestedResolutionDate) &&
        Objects.equals(this.expectedResolutionDate, _case.expectedResolutionDate) &&
        Objects.equals(this.resolutionDate, _case.resolutionDate) &&
        Objects.equals(this.status, _case.status) &&
        Objects.equals(this.statusChangeReason, _case.statusChangeReason) &&
        Objects.equals(this.relatedEntity, _case.relatedEntity) &&
        Objects.equals(this.relatedParty, _case.relatedParty) &&
        Objects.equals(this.baseType, _case.baseType) &&
        Objects.equals(this.schemaLocation, _case.schemaLocation) &&
        Objects.equals(this.type, _case.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, externalId, ticketType, creationDate, lastUpdate, description, reason, severity, priority, requestedResolutionDate, expectedResolutionDate, resolutionDate, status, statusChangeReason, relatedEntity, relatedParty, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelCase {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    ticketType: ").append(toIndentedString(ticketType)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    requestedResolutionDate: ").append(toIndentedString(requestedResolutionDate)).append("\n");
    sb.append("    expectedResolutionDate: ").append(toIndentedString(expectedResolutionDate)).append("\n");
    sb.append("    resolutionDate: ").append(toIndentedString(resolutionDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    statusChangeReason: ").append(toIndentedString(statusChangeReason)).append("\n");
    sb.append("    relatedEntity: ").append(toIndentedString(relatedEntity)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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

