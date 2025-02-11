package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Account;
import com.telus.subsfraudmgmt.api.model.AccountBalance;
import com.telus.subsfraudmgmt.api.model.AccountRelationship;
import com.telus.subsfraudmgmt.api.model.AccountTaxExemption;
import com.telus.subsfraudmgmt.api.model.BillStructure;
import com.telus.subsfraudmgmt.api.model.Contact;
import com.telus.subsfraudmgmt.api.model.FinancialAccountRef;
import com.telus.subsfraudmgmt.api.model.Money;
import com.telus.subsfraudmgmt.api.model.PaymentMethodRef;
import com.telus.subsfraudmgmt.api.model.PaymentPlan;
import com.telus.subsfraudmgmt.api.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Account used for billing or for settlement purposes concerning a given party (an organization or an individual). It is a specialization of entity Account.
 */
@ApiModel(description = "Account used for billing or for settlement purposes concerning a given party (an organization or an individual). It is a specialization of entity Account.")
@Validated

public class PartyAccount extends Account  {
  @JsonProperty("paymentStatus")
  private String paymentStatus = null;

  @JsonProperty("billStructure")
  private BillStructure billStructure = null;

  @JsonProperty("paymentPlan")
  @Valid
  private List<PaymentPlan> paymentPlan = null;

  @JsonProperty("financialAccount")
  private FinancialAccountRef financialAccount = null;

  @JsonProperty("defaultPaymentMethod")
  private PaymentMethodRef defaultPaymentMethod = null;

  public PartyAccount paymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
    return this;
  }

  /**
   * The condition of the account, such as due, paid, in arrears.
   * @return paymentStatus
  **/
  @ApiModelProperty(value = "The condition of the account, such as due, paid, in arrears.")


  public String getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public PartyAccount billStructure(BillStructure billStructure) {
    this.billStructure = billStructure;
    return this;
  }

  /**
   * Get billStructure
   * @return billStructure
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BillStructure getBillStructure() {
    return billStructure;
  }

  public void setBillStructure(BillStructure billStructure) {
    this.billStructure = billStructure;
  }

  public PartyAccount paymentPlan(List<PaymentPlan> paymentPlan) {
    this.paymentPlan = paymentPlan;
    return this;
  }

  public PartyAccount addPaymentPlanItem(PaymentPlan paymentPlanItem) {
    if (this.paymentPlan == null) {
      this.paymentPlan = new ArrayList<>();
    }
    this.paymentPlan.add(paymentPlanItem);
    return this;
  }

  /**
   * Get paymentPlan
   * @return paymentPlan
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PaymentPlan> getPaymentPlan() {
    return paymentPlan;
  }

  public void setPaymentPlan(List<PaymentPlan> paymentPlan) {
    this.paymentPlan = paymentPlan;
  }

  public PartyAccount financialAccount(FinancialAccountRef financialAccount) {
    this.financialAccount = financialAccount;
    return this;
  }

  /**
   * Get financialAccount
   * @return financialAccount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public FinancialAccountRef getFinancialAccount() {
    return financialAccount;
  }

  public void setFinancialAccount(FinancialAccountRef financialAccount) {
    this.financialAccount = financialAccount;
  }

  public PartyAccount defaultPaymentMethod(PaymentMethodRef defaultPaymentMethod) {
    this.defaultPaymentMethod = defaultPaymentMethod;
    return this;
  }

  /**
   * Get defaultPaymentMethod
   * @return defaultPaymentMethod
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PaymentMethodRef getDefaultPaymentMethod() {
    return defaultPaymentMethod;
  }

  public void setDefaultPaymentMethod(PaymentMethodRef defaultPaymentMethod) {
    this.defaultPaymentMethod = defaultPaymentMethod;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PartyAccount partyAccount = (PartyAccount) o;
    return Objects.equals(this.paymentStatus, partyAccount.paymentStatus) &&
        Objects.equals(this.billStructure, partyAccount.billStructure) &&
        Objects.equals(this.paymentPlan, partyAccount.paymentPlan) &&
        Objects.equals(this.financialAccount, partyAccount.financialAccount) &&
        Objects.equals(this.defaultPaymentMethod, partyAccount.defaultPaymentMethod) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentStatus, billStructure, paymentPlan, financialAccount, defaultPaymentMethod, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PartyAccount {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    paymentStatus: ").append(toIndentedString(paymentStatus)).append("\n");
    sb.append("    billStructure: ").append(toIndentedString(billStructure)).append("\n");
    sb.append("    paymentPlan: ").append(toIndentedString(paymentPlan)).append("\n");
    sb.append("    financialAccount: ").append(toIndentedString(financialAccount)).append("\n");
    sb.append("    defaultPaymentMethod: ").append(toIndentedString(defaultPaymentMethod)).append("\n");
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

