package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Entity;
import com.telus.subsfraudmgmt.api.model.Quantity;
import com.telus.subsfraudmgmt.api.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Complements the description of an element (for instance a product) through video, pictures...
 */
@ApiModel(description = "Complements the description of an element (for instance a product) through video, pictures...")
@Validated

public class Attachment extends Entity  {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("attachmentType")
  private String attachmentType = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("mimeType")
  private String mimeType = null;

  @JsonProperty("contentSourceCode")
  private String contentSourceCode = null;

  @JsonProperty("content")
  private String content = null;

  @JsonProperty("size")
  private Quantity size = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  public Attachment id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for this particular attachment
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier for this particular attachment")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Attachment href(String href) {
    this.href = href;
    return this;
  }

  /**
   * URI for this Attachment
   * @return href
  **/
  @ApiModelProperty(value = "URI for this Attachment")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Attachment name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the attachment
   * @return name
  **/
  @ApiModelProperty(value = "The name of the attachment")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Attachment description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative text describing the content of the attachment
   * @return description
  **/
  @ApiModelProperty(value = "A narrative text describing the content of the attachment")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Attachment attachmentType(String attachmentType) {
    this.attachmentType = attachmentType;
    return this;
  }

  /**
   * Attachment type such as video, picture
   * @return attachmentType
  **/
  @ApiModelProperty(value = "Attachment type such as video, picture")


  public String getAttachmentType() {
    return attachmentType;
  }

  public void setAttachmentType(String attachmentType) {
    this.attachmentType = attachmentType;
  }

  public Attachment url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Uniform Resource Locator, is a web page address (a subset of URI)
   * @return url
  **/
  @ApiModelProperty(value = "Uniform Resource Locator, is a web page address (a subset of URI)")


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Attachment mimeType(String mimeType) {
    this.mimeType = mimeType;
    return this;
  }

  /**
   * Attachment mime type such as extension file for video, picture and document
   * @return mimeType
  **/
  @ApiModelProperty(value = "Attachment mime type such as extension file for video, picture and document")


  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public Attachment contentSourceCode(String contentSourceCode) {
    this.contentSourceCode = contentSourceCode;
    return this;
  }

  /**
   * source of attachment content( for instance credit bureua report source( TRANSUNION or EQUIFAX) )
   * @return contentSourceCode
  **/
  @ApiModelProperty(value = "source of attachment content( for instance credit bureua report source( TRANSUNION or EQUIFAX) )")


  public String getContentSourceCode() {
    return contentSourceCode;
  }

  public void setContentSourceCode(String contentSourceCode) {
    this.contentSourceCode = contentSourceCode;
  }

  public Attachment content(String content) {
    this.content = content;
    return this;
  }

  /**
   * The actual contents of the attachment object, if embedded, encoded as base64
   * @return content
  **/
  @ApiModelProperty(value = "The actual contents of the attachment object, if embedded, encoded as base64")


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Attachment size(Quantity size) {
    this.size = size;
    return this;
  }

  /**
   * The size of the attachment.
   * @return size
  **/
  @ApiModelProperty(value = "The size of the attachment.")

  @Valid

  public Quantity getSize() {
    return size;
  }

  public void setSize(Quantity size) {
    this.size = size;
  }

  public Attachment validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period of time for which the attachment is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period of time for which the attachment is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attachment attachment = (Attachment) o;
    return Objects.equals(this.id, attachment.id) &&
        Objects.equals(this.href, attachment.href) &&
        Objects.equals(this.name, attachment.name) &&
        Objects.equals(this.description, attachment.description) &&
        Objects.equals(this.attachmentType, attachment.attachmentType) &&
        Objects.equals(this.url, attachment.url) &&
        Objects.equals(this.mimeType, attachment.mimeType) &&
        Objects.equals(this.contentSourceCode, attachment.contentSourceCode) &&
        Objects.equals(this.content, attachment.content) &&
        Objects.equals(this.size, attachment.size) &&
        Objects.equals(this.validFor, attachment.validFor) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, description, attachmentType, url, mimeType, contentSourceCode, content, size, validFor, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attachment {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    attachmentType: ").append(toIndentedString(attachmentType)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    contentSourceCode: ").append(toIndentedString(contentSourceCode)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

