package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PartyAccount reference. A party account is an arrangement that a party has with an enterprise that provides products to the party.
 */
@ApiModel(description = "PartyAccount reference. A party account is an arrangement that a party has with an enterprise that provides products to the party.")
@Validated

public class PartyAccountRef extends Entity  {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public PartyAccountRef description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Detailed description of the party account
   * @return description
  **/
  @ApiModelProperty(value = "Detailed description of the party account")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PartyAccountRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the party account
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the party account")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public PartyAccountRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the party account
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the party account")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PartyAccountRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the party account
   * @return name
  **/
  @ApiModelProperty(value = "Name of the party account")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PartyAccountRef status(String status) {
    this.status = status;
    return this;
  }

  /**
   * The condition of the account, such as due, paid, in arrears.
   * @return status
  **/
  @ApiModelProperty(value = "The condition of the account, such as due, paid, in arrears.")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public PartyAccountRef referredType(String referredType) {
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
    PartyAccountRef partyAccountRef = (PartyAccountRef) o;
    return Objects.equals(this.description, partyAccountRef.description) &&
        Objects.equals(this.href, partyAccountRef.href) &&
        Objects.equals(this.id, partyAccountRef.id) &&
        Objects.equals(this.name, partyAccountRef.name) &&
        Objects.equals(this.status, partyAccountRef.status) &&
        Objects.equals(this.referredType, partyAccountRef.referredType) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, href, id, name, status, referredType, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PartyAccountRef {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

