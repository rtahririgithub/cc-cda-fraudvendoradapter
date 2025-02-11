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
 * PresentationMedia reference. A mean of communicating a bill, supported by the associated bill format. For example, post mail, email, web page.
 */
@ApiModel(description = "PresentationMedia reference. A mean of communicating a bill, supported by the associated bill format. For example, post mail, email, web page.")
@Validated

public class BillPresentationMediaRef   {
  @JsonProperty("@referredType")
  private String referredType = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  public BillPresentationMediaRef referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

  /**
   * Generic attribute indicating the name of the class type of the referred resource entity.
   * @return referredType
  **/
  @ApiModelProperty(value = "Generic attribute indicating the name of the class type of the referred resource entity.")


  public String getReferredType() {
    return referredType;
  }

  public void setReferredType(String referredType) {
    this.referredType = referredType;
  }

  public BillPresentationMediaRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the bill presentation media
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the bill presentation media")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public BillPresentationMediaRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the bill presentation media
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the bill presentation media")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BillPresentationMediaRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A short descriptive name
   * @return name
  **/
  @ApiModelProperty(value = "A short descriptive name")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillPresentationMediaRef billPresentationMediaRef = (BillPresentationMediaRef) o;
    return Objects.equals(this.referredType, billPresentationMediaRef.referredType) &&
        Objects.equals(this.href, billPresentationMediaRef.href) &&
        Objects.equals(this.id, billPresentationMediaRef.id) &&
        Objects.equals(this.name, billPresentationMediaRef.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referredType, href, id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillPresentationMediaRef {\n");
    
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

