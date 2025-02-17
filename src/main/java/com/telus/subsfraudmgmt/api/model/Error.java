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
 * Used when an API throws an Error, typically with a HTTP error response-code (3xx, 4xx, 5xx)
 */
@ApiModel(description = "Used when an API throws an Error, typically with a HTTP error response-code (3xx, 4xx, 5xx)")
@Validated

public class Error   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("reason")
  private String reason = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("referenceError")
  private String referenceError = null;

  @JsonProperty("exceptionText")
  private String exceptionText = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public Error code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Application relevant detail, defined in the API or a common list.
   * @return code
  **/
  @ApiModelProperty(required = true, value = "Application relevant detail, defined in the API or a common list.")
  @NotNull


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Error reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * Explanation of the reason for the error which can be shown to a client user.
   * @return reason
  **/
  @ApiModelProperty(required = true, value = "Explanation of the reason for the error which can be shown to a client user.")
  @NotNull


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

  /**
   * More details and corrective actions related to the error which can be shown to a client user.
   * @return message
  **/
  @ApiModelProperty(value = "More details and corrective actions related to the error which can be shown to a client user.")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Error status(String status) {
    this.status = status;
    return this;
  }

  /**
   * HTTP Error code extension. this field can be used to store the actual status code
   * @return status
  **/
  @ApiModelProperty(value = "HTTP Error code extension. this field can be used to store the actual status code")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Error referenceError(String referenceError) {
    this.referenceError = referenceError;
    return this;
  }

  /**
   * URI of documentation describing the error.
   * @return referenceError
  **/
  @ApiModelProperty(value = "URI of documentation describing the error.")


  public String getReferenceError() {
    return referenceError;
  }

  public void setReferenceError(String referenceError) {
    this.referenceError = referenceError;
  }

  public Error exceptionText(String exceptionText) {
    this.exceptionText = exceptionText;
    return this;
  }

  /**
   * Additional technical information for a stack trace, but this must not ever be exposed to the end consumer for security reasons.
   * @return exceptionText
  **/
  @ApiModelProperty(value = "Additional technical information for a stack trace, but this must not ever be exposed to the end consumer for security reasons.")


  public String getExceptionText() {
    return exceptionText;
  }

  public void setExceptionText(String exceptionText) {
    this.exceptionText = exceptionText;
  }

  public Error baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class.
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class.")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public Error schemaLocation(String schemaLocation) {
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

  public Error type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name.
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name.")


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
    Error error = (Error) o;
    return Objects.equals(this.code, error.code) &&
        Objects.equals(this.reason, error.reason) &&
        Objects.equals(this.message, error.message) &&
        Objects.equals(this.status, error.status) &&
        Objects.equals(this.referenceError, error.referenceError) &&
        Objects.equals(this.exceptionText, error.exceptionText) &&
        Objects.equals(this.baseType, error.baseType) &&
        Objects.equals(this.schemaLocation, error.schemaLocation) &&
        Objects.equals(this.type, error.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, reason, message, status, referenceError, exceptionText, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    referenceError: ").append(toIndentedString(referenceError)).append("\n");
    sb.append("    exceptionText: ").append(toIndentedString(exceptionText)).append("\n");
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

