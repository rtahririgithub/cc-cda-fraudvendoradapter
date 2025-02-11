package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.ContactMedium;
import com.telus.subsfraudmgmt.api.model.RelatedPartyRef;
import com.telus.subsfraudmgmt.api.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * An individual or an organization used as a contact point for a given account and accessed via some contact medium.
 */
@ApiModel(description = "An individual or an organization used as a contact point for a given account and accessed via some contact medium.")
@Validated

public class Contact   {
  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("contactName")
  private String contactName = null;

  @JsonProperty("contactType")
  private String contactType = null;

  @JsonProperty("partyRoleType")
  private String partyRoleType = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("contactMedium")
  @Valid
  private List<ContactMedium> contactMedium = null;

  @JsonProperty("relatedParty")
  private RelatedPartyRef relatedParty = null;

  public Contact baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * Generic attribute indicating the base class type of the extension class of the current object. Useful only when the class type of the current  object is unknown to the implementation.
   * @return baseType
  **/
  @ApiModelProperty(value = "Generic attribute indicating the base class type of the extension class of the current object. Useful only when the class type of the current  object is unknown to the implementation.")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public Contact schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * Generic attribute containing the link to the schema that defines the structure of the class type of the current object.
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "Generic attribute containing the link to the schema that defines the structure of the class type of the current object.")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public Contact type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Generic attribute containing the name of the resource class type
   * @return type
  **/
  @ApiModelProperty(value = "Generic attribute containing the name of the resource class type")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Contact contactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

  /**
   * A displayable name for that contact
   * @return contactName
  **/
  @ApiModelProperty(value = "A displayable name for that contact")


  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public Contact contactType(String contactType) {
    this.contactType = contactType;
    return this;
  }

  /**
   * Type of contact (primary, secondary...)
   * @return contactType
  **/
  @ApiModelProperty(required = true, value = "Type of contact (primary, secondary...)")
  @NotNull


  public String getContactType() {
    return contactType;
  }

  public void setContactType(String contactType) {
    this.contactType = contactType;
  }

  public Contact partyRoleType(String partyRoleType) {
    this.partyRoleType = partyRoleType;
    return this;
  }

  /**
   * Identifies what kind of party role type is linked to the contact (a account manager...)
   * @return partyRoleType
  **/
  @ApiModelProperty(value = "Identifies what kind of party role type is linked to the contact (a account manager...)")


  public String getPartyRoleType() {
    return partyRoleType;
  }

  public void setPartyRoleType(String partyRoleType) {
    this.partyRoleType = partyRoleType;
  }

  public Contact validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Validity period of that contact
   * @return validFor
  **/
  @ApiModelProperty(required = true, value = "Validity period of that contact")
  @NotNull

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public Contact contactMedium(List<ContactMedium> contactMedium) {
    this.contactMedium = contactMedium;
    return this;
  }

  public Contact addContactMediumItem(ContactMedium contactMediumItem) {
    if (this.contactMedium == null) {
      this.contactMedium = new ArrayList<>();
    }
    this.contactMedium.add(contactMediumItem);
    return this;
  }

  /**
   * Get contactMedium
   * @return contactMedium
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ContactMedium> getContactMedium() {
    return contactMedium;
  }

  public void setContactMedium(List<ContactMedium> contactMedium) {
    this.contactMedium = contactMedium;
  }

  public Contact relatedParty(RelatedPartyRef relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  /**
   * Get relatedParty
   * @return relatedParty
  **/
  @ApiModelProperty(value = "")

  @Valid

  public RelatedPartyRef getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(RelatedPartyRef relatedParty) {
    this.relatedParty = relatedParty;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contact contact = (Contact) o;
    return Objects.equals(this.baseType, contact.baseType) &&
        Objects.equals(this.schemaLocation, contact.schemaLocation) &&
        Objects.equals(this.type, contact.type) &&
        Objects.equals(this.contactName, contact.contactName) &&
        Objects.equals(this.contactType, contact.contactType) &&
        Objects.equals(this.partyRoleType, contact.partyRoleType) &&
        Objects.equals(this.validFor, contact.validFor) &&
        Objects.equals(this.contactMedium, contact.contactMedium) &&
        Objects.equals(this.relatedParty, contact.relatedParty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, contactName, contactType, partyRoleType, validFor, contactMedium, relatedParty);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contact {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
    sb.append("    contactType: ").append(toIndentedString(contactType)).append("\n");
    sb.append("    partyRoleType: ").append(toIndentedString(partyRoleType)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    contactMedium: ").append(toIndentedString(contactMedium)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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

