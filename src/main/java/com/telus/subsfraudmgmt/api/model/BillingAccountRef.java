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
 * BillingAccount reference. A BillingAccount is a detailed description of a bill structure.
 */
@ApiModel(description = "BillingAccount reference. A BillingAccount is a detailed description of a bill structure.")
@Validated

public class BillingAccountRef extends EntityRef  {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("ratingType")
  private String ratingType = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public BillingAccountRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the billing account
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the billing account")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public BillingAccountRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the billing account
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the billing account")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BillingAccountRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the billing account
   * @return name
  **/
  @ApiModelProperty(value = "Name of the billing account")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BillingAccountRef ratingType(String ratingType) {
    this.ratingType = ratingType;
    return this;
  }

  /**
   * Indicates whether the account follows a specific payment option such as prepaid or postpaid
   * @return ratingType
  **/
  @ApiModelProperty(value = "Indicates whether the account follows a specific payment option such as prepaid or postpaid")


  public String getRatingType() {
    return ratingType;
  }

  public void setRatingType(String ratingType) {
    this.ratingType = ratingType;
  }

  public BillingAccountRef referredType(String referredType) {
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
    BillingAccountRef billingAccountRef = (BillingAccountRef) o;
    return Objects.equals(this.href, billingAccountRef.href) &&
        Objects.equals(this.id, billingAccountRef.id) &&
        Objects.equals(this.name, billingAccountRef.name) &&
        Objects.equals(this.ratingType, billingAccountRef.ratingType) &&
        Objects.equals(this.referredType, billingAccountRef.referredType) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, name, ratingType, referredType, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillingAccountRef {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ratingType: ").append(toIndentedString(ratingType)).append("\n");
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

