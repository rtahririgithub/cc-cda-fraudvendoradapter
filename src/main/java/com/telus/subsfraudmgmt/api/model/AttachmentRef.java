package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.EntityRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Attachment reference. An attachment complements the description of an element (for instance a product) through video, pictures
 */
@ApiModel(description = "Attachment reference. An attachment complements the description of an element (for instance a product) through video, pictures")
@Validated

public class AttachmentRef extends EntityRef  {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public AttachmentRef description(String description) {
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

  public AttachmentRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * URL serving as reference for the attachment resource
   * @return href
  **/
  @ApiModelProperty(value = "URL serving as reference for the attachment resource")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public AttachmentRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique-Identifier for this attachment
   * @return id
  **/
  @ApiModelProperty(value = "Unique-Identifier for this attachment")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AttachmentRef url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Link to the attachment media/content
   * @return url
  **/
  @ApiModelProperty(value = "Link to the attachment media/content")


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public AttachmentRef referredType(String referredType) {
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
    AttachmentRef attachmentRef = (AttachmentRef) o;
    return Objects.equals(this.description, attachmentRef.description) &&
        Objects.equals(this.href, attachmentRef.href) &&
        Objects.equals(this.id, attachmentRef.id) &&
        Objects.equals(this.url, attachmentRef.url) &&
        Objects.equals(this.referredType, attachmentRef.referredType) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, href, id, url, referredType, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentRef {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

