package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Entity;
import com.telus.subsfraudmgmt.api.model.Money;
import com.telus.subsfraudmgmt.api.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Balances linked to the account
 */
@ApiModel(description = "Balances linked to the account")
@Validated

public class AccountBalance extends Entity  {
  @JsonProperty("amount")
  private Money amount = null;

  @JsonProperty("balanceType")
  private String balanceType = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  public AccountBalance amount(Money amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Balance amount
   * @return amount
  **/
  @ApiModelProperty(value = "Balance amount")

  @Valid

  public Money getAmount() {
    return amount;
  }

  public void setAmount(Money amount) {
    this.amount = amount;
  }

  public AccountBalance balanceType(String balanceType) {
    this.balanceType = balanceType;
    return this;
  }

  /**
   * Type of the balance : deposit balance, disputed balance, loyalty balance, receivable balance...
   * @return balanceType
  **/
  @ApiModelProperty(value = "Type of the balance : deposit balance, disputed balance, loyalty balance, receivable balance...")


  public String getBalanceType() {
    return balanceType;
  }

  public void setBalanceType(String balanceType) {
    this.balanceType = balanceType;
  }

  public AccountBalance validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Balance validity period
   * @return validFor
  **/
  @ApiModelProperty(value = "Balance validity period")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountBalance accountBalance = (AccountBalance) o;
    return Objects.equals(this.amount, accountBalance.amount) &&
        Objects.equals(this.balanceType, accountBalance.balanceType) &&
        Objects.equals(this.validFor, accountBalance.validFor) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, balanceType, validFor, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountBalance {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    balanceType: ").append(toIndentedString(balanceType)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

