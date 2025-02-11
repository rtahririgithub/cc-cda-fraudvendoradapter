package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.FraudCaseStateChangeEvent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The notification data structure
 */
@ApiModel(description = "The notification data structure")
@Validated

public class FraudCaseStateChangeNotification   {
  @JsonProperty("eventId")
  private String eventId = null;

  @JsonProperty("eventTime")
  private OffsetDateTime eventTime = null;

  @JsonProperty("eventType")
  private String eventType = null;

  @JsonProperty("fieldPath")
  private String fieldPath = null;

  @JsonProperty("resourcePath")
  private String resourcePath = null;

  @JsonProperty("event")
  private FraudCaseStateChangeEvent event = null;

  public FraudCaseStateChangeNotification eventId(String eventId) {
    this.eventId = eventId;
    return this;
  }

  /**
   * The identifier of the notification
   * @return eventId
  **/
  @ApiModelProperty(value = "The identifier of the notification")


  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public FraudCaseStateChangeNotification eventTime(OffsetDateTime eventTime) {
    this.eventTime = eventTime;
    return this;
  }

  /**
   * Time of the event occurrence
   * @return eventTime
  **/
  @ApiModelProperty(value = "Time of the event occurrence")

  @Valid

  public OffsetDateTime getEventTime() {
    return eventTime;
  }

  public void setEventTime(OffsetDateTime eventTime) {
    this.eventTime = eventTime;
  }

  public FraudCaseStateChangeNotification eventType(String eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * The type of the notification
   * @return eventType
  **/
  @ApiModelProperty(value = "The type of the notification")


  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public FraudCaseStateChangeNotification fieldPath(String fieldPath) {
    this.fieldPath = fieldPath;
    return this;
  }

  /**
   * The path identifying the object field concerned by this notification
   * @return fieldPath
  **/
  @ApiModelProperty(value = "The path identifying the object field concerned by this notification")


  public String getFieldPath() {
    return fieldPath;
  }

  public void setFieldPath(String fieldPath) {
    this.fieldPath = fieldPath;
  }

  public FraudCaseStateChangeNotification resourcePath(String resourcePath) {
    this.resourcePath = resourcePath;
    return this;
  }

  /**
   * The path identifying the resource object concerned by this notification
   * @return resourcePath
  **/
  @ApiModelProperty(value = "The path identifying the resource object concerned by this notification")


  public String getResourcePath() {
    return resourcePath;
  }

  public void setResourcePath(String resourcePath) {
    this.resourcePath = resourcePath;
  }

  public FraudCaseStateChangeNotification event(FraudCaseStateChangeEvent event) {
    this.event = event;
    return this;
  }

  /**
   * The event linked to the involved resource object
   * @return event
  **/
  @ApiModelProperty(value = "The event linked to the involved resource object")

  @Valid

  public FraudCaseStateChangeEvent getEvent() {
    return event;
  }

  public void setEvent(FraudCaseStateChangeEvent event) {
    this.event = event;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudCaseStateChangeNotification fraudCaseStateChangeNotification = (FraudCaseStateChangeNotification) o;
    return Objects.equals(this.eventId, fraudCaseStateChangeNotification.eventId) &&
        Objects.equals(this.eventTime, fraudCaseStateChangeNotification.eventTime) &&
        Objects.equals(this.eventType, fraudCaseStateChangeNotification.eventType) &&
        Objects.equals(this.fieldPath, fraudCaseStateChangeNotification.fieldPath) &&
        Objects.equals(this.resourcePath, fraudCaseStateChangeNotification.resourcePath) &&
        Objects.equals(this.event, fraudCaseStateChangeNotification.event);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventId, eventTime, eventType, fieldPath, resourcePath, event);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudCaseStateChangeNotification {\n");
    
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
    sb.append("    eventTime: ").append(toIndentedString(eventTime)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    fieldPath: ").append(toIndentedString(fieldPath)).append("\n");
    sb.append("    resourcePath: ").append(toIndentedString(resourcePath)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
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

