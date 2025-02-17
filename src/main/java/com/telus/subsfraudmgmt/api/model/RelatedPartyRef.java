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
 * RelatedParty reference. A related party defines party or party role linked to a specific entity.
 */
@ApiModel(description = "RelatedParty reference. A related party defines party or party role linked to a specific entity.")
@Validated

public class RelatedPartyRef   {
  @JsonProperty("@referredType")
  private String referredType = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("role")
  private String role = null;

  public RelatedPartyRef referredType(String referredType) {
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

  public RelatedPartyRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the related party, could be a party reference or a party role reference
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the related party, could be a party reference or a party role reference")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public RelatedPartyRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of a related party
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of a related party")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RelatedPartyRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the related party
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the related party")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RelatedPartyRef role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Role of the related party.
   * @return role
  **/
  @ApiModelProperty(value = "Role of the related party.")


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelatedPartyRef relatedPartyRef = (RelatedPartyRef) o;
    return Objects.equals(this.referredType, relatedPartyRef.referredType) &&
        Objects.equals(this.href, relatedPartyRef.href) &&
        Objects.equals(this.id, relatedPartyRef.id) &&
        Objects.equals(this.name, relatedPartyRef.name) &&
        Objects.equals(this.role, relatedPartyRef.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referredType, href, id, name, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelatedPartyRef {\n");
    
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

