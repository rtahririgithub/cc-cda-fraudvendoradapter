package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.HeaderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A response to a requestA response to a request
 */
@ApiModel(description = "A response to a requestA response to a request")
@Validated

public class Request   {
  @JsonProperty("body")
  private String body = null;

  @JsonProperty("method")
  private String method = null;

  @JsonProperty("to")
  private String to = null;

  @JsonProperty("header")
  @Valid
  private List<HeaderItem> header = new ArrayList<>();

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public Request body(String body) {
    this.body = body;
    return this;
  }

  /**
   * The body of the request. For example for an HTTP request might contain content of a form .
   * @return body
  **/
  @ApiModelProperty(required = true, value = "The body of the request. For example for an HTTP request might contain content of a form .")
  @NotNull


  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Request method(String method) {
    this.method = method;
    return this;
  }

  /**
   * The protocol of the request, e.g. http
   * @return method
  **/
  @ApiModelProperty(value = "The protocol of the request, e.g. http")


  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public Request to(String to) {
    this.to = to;
    return this;
  }

  /**
   * The target of the request, e.g. a URL for an HTTP request
   * @return to
  **/
  @ApiModelProperty(value = "The target of the request, e.g. a URL for an HTTP request")


  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public Request header(List<HeaderItem> header) {
    this.header = header;
    return this;
  }

  public Request addHeaderItem(HeaderItem headerItem) {
    this.header.add(headerItem);
    return this;
  }

  /**
   * Items included in the header of the request. For example for an HTTP request might contain requested locale, basic authentication.
   * @return header
  **/
  @ApiModelProperty(required = true, value = "Items included in the header of the request. For example for an HTTP request might contain requested locale, basic authentication.")
  @NotNull

  @Valid
@Size(min=1) 
  public List<HeaderItem> getHeader() {
    return header;
  }

  public void setHeader(List<HeaderItem> header) {
    this.header = header;
  }

  public Request baseType(String baseType) {
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

  public Request schemaLocation(String schemaLocation) {
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

  public Request type(String type) {
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
    Request request = (Request) o;
    return Objects.equals(this.body, request.body) &&
        Objects.equals(this.method, request.method) &&
        Objects.equals(this.to, request.to) &&
        Objects.equals(this.header, request.header) &&
        Objects.equals(this.baseType, request.baseType) &&
        Objects.equals(this.schemaLocation, request.schemaLocation) &&
        Objects.equals(this.type, request.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(body, method, to, header, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Request {\n");
    
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
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

