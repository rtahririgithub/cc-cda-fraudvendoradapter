package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.AccountRefOrValue;
import com.telus.subsfraudmgmt.api.model.AgreementRefOrValue;
import com.telus.subsfraudmgmt.api.model.Characteristic;
import com.telus.subsfraudmgmt.api.model.ContactMediumRefOrValue;
import com.telus.subsfraudmgmt.api.model.CreditProfileRefOrValue;
import com.telus.subsfraudmgmt.api.model.Entity;
import com.telus.subsfraudmgmt.api.model.PaymentMethodRef;
import com.telus.subsfraudmgmt.api.model.RelatedParty;
import com.telus.subsfraudmgmt.api.model.RelatedPartyRefOrValue;
import com.telus.subsfraudmgmt.api.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Customer
 */
@Validated

public class Customer extends Entity  {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("statusReason")
  private String statusReason = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("engagedParty")
  private RelatedPartyRefOrValue engagedParty = null;

  @JsonProperty("account")
  @Valid
  private List<AccountRefOrValue> account = null;

  @JsonProperty("paymentMethod")
  @Valid
  private List<PaymentMethodRef> paymentMethod = null;

  @JsonProperty("contactMedium")
  @Valid
  private List<ContactMediumRefOrValue> contactMedium = null;

  @JsonProperty("characteristic")
  @Valid
  private List<Characteristic> characteristic = null;

  @JsonProperty("creditProfile")
  @Valid
  private List<CreditProfileRefOrValue> creditProfile = null;

  @JsonProperty("agreement")
  @Valid
  private List<AgreementRefOrValue> agreement = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedParty> relatedParty = null;

  public Customer href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Url used to reference the customer.
   * @return href
  **/
  @ApiModelProperty(value = "Url used to reference the customer.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Customer id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for Customers
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier for Customers")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Customer name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A word, term, or phrase by which the Customer is known and distinguished from other Customers.
   * @return name
  **/
  @ApiModelProperty(value = "A word, term, or phrase by which the Customer is known and distinguished from other Customers.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Customer status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Used to track the lifecycle status of the customer.
   * @return status
  **/
  @ApiModelProperty(value = "Used to track the lifecycle status of the customer.")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Customer statusReason(String statusReason) {
    this.statusReason = statusReason;
    return this;
  }

  /**
   * A string providing an explanation on the value of the status lifecycle. For instance if the status is Rejected, statusReason will provide the reason for rejection.
   * @return statusReason
  **/
  @ApiModelProperty(value = "A string providing an explanation on the value of the status lifecycle. For instance if the status is Rejected, statusReason will provide the reason for rejection.")


  public String getStatusReason() {
    return statusReason;
  }

  public void setStatusReason(String statusReason) {
    this.statusReason = statusReason;
  }

  public Customer validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The time period that the Customer is valid for.
   * @return validFor
  **/
  @ApiModelProperty(value = "The time period that the Customer is valid for.")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public Customer engagedParty(RelatedPartyRefOrValue engagedParty) {
    this.engagedParty = engagedParty;
    return this;
  }

  /**
   * The party - an organization or an individual - that is engaged as a customer.
   * @return engagedParty
  **/
  @ApiModelProperty(value = "The party - an organization or an individual - that is engaged as a customer.")

  @Valid

  public RelatedPartyRefOrValue getEngagedParty() {
    return engagedParty;
  }

  public void setEngagedParty(RelatedPartyRefOrValue engagedParty) {
    this.engagedParty = engagedParty;
  }

  public Customer account(List<AccountRefOrValue> account) {
    this.account = account;
    return this;
  }

  public Customer addAccountItem(AccountRefOrValue accountItem) {
    if (this.account == null) {
      this.account = new ArrayList<>();
    }
    this.account.add(accountItem);
    return this;
  }

  /**
   * Get account
   * @return account
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AccountRefOrValue> getAccount() {
    return account;
  }

  public void setAccount(List<AccountRefOrValue> account) {
    this.account = account;
  }

  public Customer paymentMethod(List<PaymentMethodRef> paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

  public Customer addPaymentMethodItem(PaymentMethodRef paymentMethodItem) {
    if (this.paymentMethod == null) {
      this.paymentMethod = new ArrayList<>();
    }
    this.paymentMethod.add(paymentMethodItem);
    return this;
  }

  /**
   * Get paymentMethod
   * @return paymentMethod
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PaymentMethodRef> getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(List<PaymentMethodRef> paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public Customer contactMedium(List<ContactMediumRefOrValue> contactMedium) {
    this.contactMedium = contactMedium;
    return this;
  }

  public Customer addContactMediumItem(ContactMediumRefOrValue contactMediumItem) {
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

  public Customer characteristic(List<Characteristic> characteristic) {
    this.characteristic = characteristic;
    return this;
  }

  public Customer addCharacteristicItem(Characteristic characteristicItem) {
    if (this.characteristic == null) {
      this.characteristic = new ArrayList<>();
    }
    this.characteristic.add(characteristicItem);
    return this;
  }

  /**
   * Describes the characteristic of a customer.
   * @return characteristic
  **/
  @ApiModelProperty(value = "Describes the characteristic of a customer.")

  @Valid

  public List<Characteristic> getCharacteristic() {
    return characteristic;
  }

  public void setCharacteristic(List<Characteristic> characteristic) {
    this.characteristic = characteristic;
  }

  public Customer creditProfile(List<CreditProfileRefOrValue> creditProfile) {
    this.creditProfile = creditProfile;
    return this;
  }

  public Customer addCreditProfileItem(CreditProfileRefOrValue creditProfileItem) {
    if (this.creditProfile == null) {
      this.creditProfile = new ArrayList<>();
    }
    this.creditProfile.add(creditProfileItem);
    return this;
  }

  /**
   * A list of credit profiles (CreditProfile [*]). Credit profile for the party (containing credit scoring, ...). By default only the current credit profile is retrieved. It can be used as a list to give the party credit profiles history, the first one in the list will be the current one.
   * @return creditProfile
  **/
  @ApiModelProperty(value = "A list of credit profiles (CreditProfile [*]). Credit profile for the party (containing credit scoring, ...). By default only the current credit profile is retrieved. It can be used as a list to give the party credit profiles history, the first one in the list will be the current one.")

  @Valid

  public List<CreditProfileRefOrValue> getCreditProfile() {
    return creditProfile;
  }

  public void setCreditProfile(List<CreditProfileRefOrValue> creditProfile) {
    this.creditProfile = creditProfile;
  }

  public Customer agreement(List<AgreementRefOrValue> agreement) {
    this.agreement = agreement;
    return this;
  }

  public Customer addAgreementItem(AgreementRefOrValue agreementItem) {
    if (this.agreement == null) {
      this.agreement = new ArrayList<>();
    }
    this.agreement.add(agreementItem);
    return this;
  }

  /**
   * Get agreement
   * @return agreement
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AgreementRefOrValue> getAgreement() {
    return agreement;
  }

  public void setAgreement(List<AgreementRefOrValue> agreement) {
    this.agreement = agreement;
  }

  public Customer relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public Customer addRelatedPartyItem(RelatedParty relatedPartyItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.href, customer.href) &&
        Objects.equals(this.id, customer.id) &&
        Objects.equals(this.name, customer.name) &&
        Objects.equals(this.status, customer.status) &&
        Objects.equals(this.statusReason, customer.statusReason) &&
        Objects.equals(this.validFor, customer.validFor) &&
        Objects.equals(this.engagedParty, customer.engagedParty) &&
        Objects.equals(this.account, customer.account) &&
        Objects.equals(this.paymentMethod, customer.paymentMethod) &&
        Objects.equals(this.contactMedium, customer.contactMedium) &&
        Objects.equals(this.characteristic, customer.characteristic) &&
        Objects.equals(this.creditProfile, customer.creditProfile) &&
        Objects.equals(this.agreement, customer.agreement) &&
        Objects.equals(this.relatedParty, customer.relatedParty) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, name, status, statusReason, validFor, engagedParty, account, paymentMethod, contactMedium, characteristic, creditProfile, agreement, relatedParty, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    statusReason: ").append(toIndentedString(statusReason)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    engagedParty: ").append(toIndentedString(engagedParty)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    contactMedium: ").append(toIndentedString(contactMedium)).append("\n");
    sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
    sb.append("    creditProfile: ").append(toIndentedString(creditProfile)).append("\n");
    sb.append("    agreement: ").append(toIndentedString(agreement)).append("\n");
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

