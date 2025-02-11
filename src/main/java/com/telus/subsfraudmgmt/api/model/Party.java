package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Characteristic;
import com.telus.subsfraudmgmt.api.model.ContactMediumRefOrValue;
import com.telus.subsfraudmgmt.api.model.Entity;
import com.telus.subsfraudmgmt.api.model.ExternalReference;
import com.telus.subsfraudmgmt.api.model.PartyCreditProfile;
import com.telus.subsfraudmgmt.api.model.RelatedParty;
import com.telus.subsfraudmgmt.api.model.TaxExemptionCertificate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Generic Party structure used to define commonalities between sub concepts of Individual and Organization.
 */
@ApiModel(description = "Generic Party structure used to define commonalities between sub concepts of Individual and Organization.")
@Validated

public class Party extends Entity  {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("externalReference")
  @Valid
  private List<ExternalReference> externalReference = null;

  @JsonProperty("partyCharacteristic")
  @Valid
  private List<Characteristic> partyCharacteristic = null;

  @JsonProperty("taxExemptionCertificate")
  @Valid
  private List<TaxExemptionCertificate> taxExemptionCertificate = null;

  @JsonProperty("creditRating")
  @Valid
  private List<PartyCreditProfile> creditRating = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedParty> relatedParty = null;

  @JsonProperty("contactMedium")
  @Valid
  private List<ContactMediumRefOrValue> contactMedium = null;

  public Party id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the organization
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the organization")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Party href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink to access the organization
   * @return href
  **/
  @ApiModelProperty(value = "Hyperlink to access the organization")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Party externalReference(List<ExternalReference> externalReference) {
    this.externalReference = externalReference;
    return this;
  }

  public Party addExternalReferenceItem(ExternalReference externalReferenceItem) {
    if (this.externalReference == null) {
      this.externalReference = new ArrayList<>();
    }
    this.externalReference.add(externalReferenceItem);
    return this;
  }

  /**
   * Get externalReference
   * @return externalReference
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ExternalReference> getExternalReference() {
    return externalReference;
  }

  public void setExternalReference(List<ExternalReference> externalReference) {
    this.externalReference = externalReference;
  }

  public Party partyCharacteristic(List<Characteristic> partyCharacteristic) {
    this.partyCharacteristic = partyCharacteristic;
    return this;
  }

  public Party addPartyCharacteristicItem(Characteristic partyCharacteristicItem) {
    if (this.partyCharacteristic == null) {
      this.partyCharacteristic = new ArrayList<>();
    }
    this.partyCharacteristic.add(partyCharacteristicItem);
    return this;
  }

  /**
   * Get partyCharacteristic
   * @return partyCharacteristic
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Characteristic> getPartyCharacteristic() {
    return partyCharacteristic;
  }

  public void setPartyCharacteristic(List<Characteristic> partyCharacteristic) {
    this.partyCharacteristic = partyCharacteristic;
  }

  public Party taxExemptionCertificate(List<TaxExemptionCertificate> taxExemptionCertificate) {
    this.taxExemptionCertificate = taxExemptionCertificate;
    return this;
  }

  public Party addTaxExemptionCertificateItem(TaxExemptionCertificate taxExemptionCertificateItem) {
    if (this.taxExemptionCertificate == null) {
      this.taxExemptionCertificate = new ArrayList<>();
    }
    this.taxExemptionCertificate.add(taxExemptionCertificateItem);
    return this;
  }

  /**
   * Get taxExemptionCertificate
   * @return taxExemptionCertificate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<TaxExemptionCertificate> getTaxExemptionCertificate() {
    return taxExemptionCertificate;
  }

  public void setTaxExemptionCertificate(List<TaxExemptionCertificate> taxExemptionCertificate) {
    this.taxExemptionCertificate = taxExemptionCertificate;
  }

  public Party creditRating(List<PartyCreditProfile> creditRating) {
    this.creditRating = creditRating;
    return this;
  }

  public Party addCreditRatingItem(PartyCreditProfile creditRatingItem) {
    if (this.creditRating == null) {
      this.creditRating = new ArrayList<>();
    }
    this.creditRating.add(creditRatingItem);
    return this;
  }

  /**
   * Get creditRating
   * @return creditRating
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PartyCreditProfile> getCreditRating() {
    return creditRating;
  }

  public void setCreditRating(List<PartyCreditProfile> creditRating) {
    this.creditRating = creditRating;
  }

  public Party relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public Party addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Get relatedParty
   * @return relatedParty
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public Party contactMedium(List<ContactMediumRefOrValue> contactMedium) {
    this.contactMedium = contactMedium;
    return this;
  }

  public Party addContactMediumItem(ContactMediumRefOrValue contactMediumItem) {
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

  public List<ContactMediumRefOrValue> getContactMedium() {
    return contactMedium;
  }

  public void setContactMedium(List<ContactMediumRefOrValue> contactMedium) {
    this.contactMedium = contactMedium;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Party party = (Party) o;
    return Objects.equals(this.id, party.id) &&
        Objects.equals(this.href, party.href) &&
        Objects.equals(this.externalReference, party.externalReference) &&
        Objects.equals(this.partyCharacteristic, party.partyCharacteristic) &&
        Objects.equals(this.taxExemptionCertificate, party.taxExemptionCertificate) &&
        Objects.equals(this.creditRating, party.creditRating) &&
        Objects.equals(this.relatedParty, party.relatedParty) &&
        Objects.equals(this.contactMedium, party.contactMedium) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, externalReference, partyCharacteristic, taxExemptionCertificate, creditRating, relatedParty, contactMedium, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Party {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    externalReference: ").append(toIndentedString(externalReference)).append("\n");
    sb.append("    partyCharacteristic: ").append(toIndentedString(partyCharacteristic)).append("\n");
    sb.append("    taxExemptionCertificate: ").append(toIndentedString(taxExemptionCertificate)).append("\n");
    sb.append("    creditRating: ").append(toIndentedString(creditRating)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    contactMedium: ").append(toIndentedString(contactMedium)).append("\n");
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

