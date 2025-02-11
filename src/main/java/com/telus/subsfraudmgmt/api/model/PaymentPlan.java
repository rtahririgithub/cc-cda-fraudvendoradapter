package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Entity;
import com.telus.subsfraudmgmt.api.model.Money;
import com.telus.subsfraudmgmt.api.model.PaymentMethodRef;
import com.telus.subsfraudmgmt.api.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Defines a plan for payment (when a party wants to spread his payments)
 */
@ApiModel(description = "Defines a plan for payment (when a party wants to spread his payments)")
@Validated

public class PaymentPlan extends Entity  {
  @JsonProperty("numberOfPayments")
  private Integer numberOfPayments = null;

  @JsonProperty("paymentFrequency")
  private String paymentFrequency = null;

  @JsonProperty("priority")
  private Integer priority = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("totalAmount")
  private Money totalAmount = null;

  @JsonProperty("planType")
  private String planType = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("paymentMethod")
  private PaymentMethodRef paymentMethod = null;

  public PaymentPlan numberOfPayments(Integer numberOfPayments) {
    this.numberOfPayments = numberOfPayments;
    return this;
  }

  /**
   * Number of payments used to spread the global payment
   * @return numberOfPayments
  **/
  @ApiModelProperty(value = "Number of payments used to spread the global payment")


  public Integer getNumberOfPayments() {
    return numberOfPayments;
  }

  public void setNumberOfPayments(Integer numberOfPayments) {
    this.numberOfPayments = numberOfPayments;
  }

  public PaymentPlan paymentFrequency(String paymentFrequency) {
    this.paymentFrequency = paymentFrequency;
    return this;
  }

  /**
   * Frequency of the payments, such as monthly and bimonthly
   * @return paymentFrequency
  **/
  @ApiModelProperty(value = "Frequency of the payments, such as monthly and bimonthly")


  public String getPaymentFrequency() {
    return paymentFrequency;
  }

  public void setPaymentFrequency(String paymentFrequency) {
    this.paymentFrequency = paymentFrequency;
  }

  public PaymentPlan priority(Integer priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Priority of the payment plan
   * @return priority
  **/
  @ApiModelProperty(value = "Priority of the payment plan")


  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public PaymentPlan status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the payment plan (effective, ineffective)
   * @return status
  **/
  @ApiModelProperty(value = "Status of the payment plan (effective, ineffective)")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public PaymentPlan totalAmount(Money totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

  /**
   * Amount paid
   * @return totalAmount
  **/
  @ApiModelProperty(value = "Amount paid")

  @Valid

  public Money getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Money totalAmount) {
    this.totalAmount = totalAmount;
  }

  public PaymentPlan planType(String planType) {
    this.planType = planType;
    return this;
  }

  /**
   * Type of payment plan
   * @return planType
  **/
  @ApiModelProperty(value = "Type of payment plan")


  public String getPlanType() {
    return planType;
  }

  public void setPlanType(String planType) {
    this.planType = planType;
  }

  public PaymentPlan validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Validity period of the payment plan
   * @return validFor
  **/
  @ApiModelProperty(value = "Validity period of the payment plan")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public PaymentPlan paymentMethod(PaymentMethodRef paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

  /**
   * Get paymentMethod
   * @return paymentMethod
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PaymentMethodRef getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethodRef paymentMethod) {
    this.paymentMethod = paymentMethod;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentPlan paymentPlan = (PaymentPlan) o;
    return Objects.equals(this.numberOfPayments, paymentPlan.numberOfPayments) &&
        Objects.equals(this.paymentFrequency, paymentPlan.paymentFrequency) &&
        Objects.equals(this.priority, paymentPlan.priority) &&
        Objects.equals(this.status, paymentPlan.status) &&
        Objects.equals(this.totalAmount, paymentPlan.totalAmount) &&
        Objects.equals(this.planType, paymentPlan.planType) &&
        Objects.equals(this.validFor, paymentPlan.validFor) &&
        Objects.equals(this.paymentMethod, paymentPlan.paymentMethod) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfPayments, paymentFrequency, priority, status, totalAmount, planType, validFor, paymentMethod, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentPlan {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    numberOfPayments: ").append(toIndentedString(numberOfPayments)).append("\n");
    sb.append("    paymentFrequency: ").append(toIndentedString(paymentFrequency)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
    sb.append("    planType: ").append(toIndentedString(planType)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
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

