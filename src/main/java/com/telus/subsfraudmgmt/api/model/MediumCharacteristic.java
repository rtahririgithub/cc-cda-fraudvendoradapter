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
 * Describes the contact medium characteristics that could be used to contact a party (an individual or an organization)
 */
@ApiModel(description = "Describes the contact medium characteristics that could be used to contact a party (an individual or an organization)")
@Validated

public class MediumCharacteristic   {
  @JsonProperty("city")
  private String city = null;

  @JsonProperty("contactType")
  private String contactType = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("emailAddress")
  private String emailAddress = null;

  @JsonProperty("faxNumber")
  private String faxNumber = null;

  @JsonProperty("phoneNumber")
  private String phoneNumber = null;

  @JsonProperty("postCode")
  private String postCode = null;

  @JsonProperty("socialNetworkId")
  private String socialNetworkId = null;

  @JsonProperty("stateOrProvince")
  private String stateOrProvince = null;

  @JsonProperty("street1")
  private String street1 = null;

  @JsonProperty("street2")
  private String street2 = null;

  @JsonProperty("street3")
  private String street3 = null;

  @JsonProperty("street4")
  private String street4 = null;

  @JsonProperty("street5")
  private String street5 = null;

  @JsonProperty("streetName")
  private String streetName = null;

  @JsonProperty("civicNumber")
  private String civicNumber = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public MediumCharacteristic city(String city) {
    this.city = city;
    return this;
  }

  /**
   * The city
   * @return city
  **/
  @ApiModelProperty(value = "The city")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public MediumCharacteristic contactType(String contactType) {
    this.contactType = contactType;
    return this;
  }

  /**
   * The type of contact, for example: phone number such as mobile, fixed home, fixed office. postal address such a shipping installation
   * @return contactType
  **/
  @ApiModelProperty(value = "The type of contact, for example: phone number such as mobile, fixed home, fixed office. postal address such a shipping installation")


  public String getContactType() {
    return contactType;
  }

  public void setContactType(String contactType) {
    this.contactType = contactType;
  }

  public MediumCharacteristic country(String country) {
    this.country = country;
    return this;
  }

  /**
   * The country
   * @return country
  **/
  @ApiModelProperty(value = "The country")


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public MediumCharacteristic emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  /**
   * Full email address in standard format
   * @return emailAddress
  **/
  @ApiModelProperty(value = "Full email address in standard format")


  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public MediumCharacteristic faxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
    return this;
  }

  /**
   * The fax number of the contact
   * @return faxNumber
  **/
  @ApiModelProperty(value = "The fax number of the contact")


  public String getFaxNumber() {
    return faxNumber;
  }

  public void setFaxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
  }

  public MediumCharacteristic phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * The primary phone number of the contact
   * @return phoneNumber
  **/
  @ApiModelProperty(value = "The primary phone number of the contact")


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public MediumCharacteristic postCode(String postCode) {
    this.postCode = postCode;
    return this;
  }

  /**
   * Postcode
   * @return postCode
  **/
  @ApiModelProperty(value = "Postcode")


  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public MediumCharacteristic socialNetworkId(String socialNetworkId) {
    this.socialNetworkId = socialNetworkId;
    return this;
  }

  /**
   * Identifier as a member of a social network
   * @return socialNetworkId
  **/
  @ApiModelProperty(value = "Identifier as a member of a social network")


  public String getSocialNetworkId() {
    return socialNetworkId;
  }

  public void setSocialNetworkId(String socialNetworkId) {
    this.socialNetworkId = socialNetworkId;
  }

  public MediumCharacteristic stateOrProvince(String stateOrProvince) {
    this.stateOrProvince = stateOrProvince;
    return this;
  }

  /**
   * State or province
   * @return stateOrProvince
  **/
  @ApiModelProperty(value = "State or province")


  public String getStateOrProvince() {
    return stateOrProvince;
  }

  public void setStateOrProvince(String stateOrProvince) {
    this.stateOrProvince = stateOrProvince;
  }

  public MediumCharacteristic street1(String street1) {
    this.street1 = street1;
    return this;
  }

  /**
   * Describes the street
   * @return street1
  **/
  @ApiModelProperty(value = "Describes the street")


  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public MediumCharacteristic street2(String street2) {
    this.street2 = street2;
    return this;
  }

  /**
   * Complementary street description
   * @return street2
  **/
  @ApiModelProperty(value = "Complementary street description")


  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public MediumCharacteristic street3(String street3) {
    this.street3 = street3;
    return this;
  }

  /**
   * Complementary street description
   * @return street3
  **/
  @ApiModelProperty(value = "Complementary street description")


  public String getStreet3() {
    return street3;
  }

  public void setStreet3(String street3) {
    this.street3 = street3;
  }

  public MediumCharacteristic street4(String street4) {
    this.street4 = street4;
    return this;
  }

  /**
   * Complementary street description
   * @return street4
  **/
  @ApiModelProperty(value = "Complementary street description")


  public String getStreet4() {
    return street4;
  }

  public void setStreet4(String street4) {
    this.street4 = street4;
  }

  public MediumCharacteristic street5(String street5) {
    this.street5 = street5;
    return this;
  }

  /**
   * Complementary street description
   * @return street5
  **/
  @ApiModelProperty(value = "Complementary street description")


  public String getStreet5() {
    return street5;
  }

  public void setStreet5(String street5) {
    this.street5 = street5;
  }

  public MediumCharacteristic streetName(String streetName) {
    this.streetName = streetName;
    return this;
  }

  /**
   * streetName
   * @return streetName
  **/
  @ApiModelProperty(value = "streetName")


  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public MediumCharacteristic civicNumber(String civicNumber) {
    this.civicNumber = civicNumber;
    return this;
  }

  /**
   * civicNumber
   * @return civicNumber
  **/
  @ApiModelProperty(value = "civicNumber")


  public String getCivicNumber() {
    return civicNumber;
  }

  public void setCivicNumber(String civicNumber) {
    this.civicNumber = civicNumber;
  }

  public MediumCharacteristic baseType(String baseType) {
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

  public MediumCharacteristic schemaLocation(String schemaLocation) {
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

  public MediumCharacteristic type(String type) {
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
    MediumCharacteristic mediumCharacteristic = (MediumCharacteristic) o;
    return Objects.equals(this.city, mediumCharacteristic.city) &&
        Objects.equals(this.contactType, mediumCharacteristic.contactType) &&
        Objects.equals(this.country, mediumCharacteristic.country) &&
        Objects.equals(this.emailAddress, mediumCharacteristic.emailAddress) &&
        Objects.equals(this.faxNumber, mediumCharacteristic.faxNumber) &&
        Objects.equals(this.phoneNumber, mediumCharacteristic.phoneNumber) &&
        Objects.equals(this.postCode, mediumCharacteristic.postCode) &&
        Objects.equals(this.socialNetworkId, mediumCharacteristic.socialNetworkId) &&
        Objects.equals(this.stateOrProvince, mediumCharacteristic.stateOrProvince) &&
        Objects.equals(this.street1, mediumCharacteristic.street1) &&
        Objects.equals(this.street2, mediumCharacteristic.street2) &&
        Objects.equals(this.street3, mediumCharacteristic.street3) &&
        Objects.equals(this.street4, mediumCharacteristic.street4) &&
        Objects.equals(this.street5, mediumCharacteristic.street5) &&
        Objects.equals(this.streetName, mediumCharacteristic.streetName) &&
        Objects.equals(this.civicNumber, mediumCharacteristic.civicNumber) &&
        Objects.equals(this.baseType, mediumCharacteristic.baseType) &&
        Objects.equals(this.schemaLocation, mediumCharacteristic.schemaLocation) &&
        Objects.equals(this.type, mediumCharacteristic.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, contactType, country, emailAddress, faxNumber, phoneNumber, postCode, socialNetworkId, stateOrProvince, street1, street2, street3, street4, street5, streetName, civicNumber, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediumCharacteristic {\n");
    
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    contactType: ").append(toIndentedString(contactType)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    faxNumber: ").append(toIndentedString(faxNumber)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    postCode: ").append(toIndentedString(postCode)).append("\n");
    sb.append("    socialNetworkId: ").append(toIndentedString(socialNetworkId)).append("\n");
    sb.append("    stateOrProvince: ").append(toIndentedString(stateOrProvince)).append("\n");
    sb.append("    street1: ").append(toIndentedString(street1)).append("\n");
    sb.append("    street2: ").append(toIndentedString(street2)).append("\n");
    sb.append("    street3: ").append(toIndentedString(street3)).append("\n");
    sb.append("    street4: ").append(toIndentedString(street4)).append("\n");
    sb.append("    street5: ").append(toIndentedString(street5)).append("\n");
    sb.append("    streetName: ").append(toIndentedString(streetName)).append("\n");
    sb.append("    civicNumber: ").append(toIndentedString(civicNumber)).append("\n");
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

