package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.AgreementTermOrCondition;
import com.telus.subsfraudmgmt.api.model.Entity;
import com.telus.subsfraudmgmt.api.model.ProductOfferingRef;
import com.telus.subsfraudmgmt.api.model.ProductRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A part of the agreement expressed in terms of a product offering and possibly including specific terms and conditions.
 */
@ApiModel(description = "A part of the agreement expressed in terms of a product offering and possibly including specific terms and conditions.")
@Validated

public class AgreementItem extends Entity  {
  @JsonProperty("productOffering")
  @Valid
  private List<ProductOfferingRef> productOffering = null;

  @JsonProperty("termOrCondition")
  @Valid
  private List<AgreementTermOrCondition> termOrCondition = null;

  @JsonProperty("product")
  @Valid
  private List<ProductRef> product = null;

  public AgreementItem productOffering(List<ProductOfferingRef> productOffering) {
    this.productOffering = productOffering;
    return this;
  }

  public AgreementItem addProductOfferingItem(ProductOfferingRef productOfferingItem) {
    if (this.productOffering == null) {
      this.productOffering = new ArrayList<>();
    }
    this.productOffering.add(productOfferingItem);
    return this;
  }

  /**
   * The list of product offerings referred by this agreement item
   * @return productOffering
  **/
  @ApiModelProperty(value = "The list of product offerings referred by this agreement item")

  @Valid

  public List<ProductOfferingRef> getProductOffering() {
    return productOffering;
  }

  public void setProductOffering(List<ProductOfferingRef> productOffering) {
    this.productOffering = productOffering;
  }

  public AgreementItem termOrCondition(List<AgreementTermOrCondition> termOrCondition) {
    this.termOrCondition = termOrCondition;
    return this;
  }

  public AgreementItem addTermOrConditionItem(AgreementTermOrCondition termOrConditionItem) {
    if (this.termOrCondition == null) {
      this.termOrCondition = new ArrayList<>();
    }
    this.termOrCondition.add(termOrConditionItem);
    return this;
  }

  /**
   * Get termOrCondition
   * @return termOrCondition
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AgreementTermOrCondition> getTermOrCondition() {
    return termOrCondition;
  }

  public void setTermOrCondition(List<AgreementTermOrCondition> termOrCondition) {
    this.termOrCondition = termOrCondition;
  }

  public AgreementItem product(List<ProductRef> product) {
    this.product = product;
    return this;
  }

  public AgreementItem addProductItem(ProductRef productItem) {
    if (this.product == null) {
      this.product = new ArrayList<>();
    }
    this.product.add(productItem);
    return this;
  }

  /**
   * The list of products indirectly referred by this agreement item (since an agreement item refers primarily to product offerings)
   * @return product
  **/
  @ApiModelProperty(value = "The list of products indirectly referred by this agreement item (since an agreement item refers primarily to product offerings)")

  @Valid

  public List<ProductRef> getProduct() {
    return product;
  }

  public void setProduct(List<ProductRef> product) {
    this.product = product;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgreementItem agreementItem = (AgreementItem) o;
    return Objects.equals(this.productOffering, agreementItem.productOffering) &&
        Objects.equals(this.termOrCondition, agreementItem.termOrCondition) &&
        Objects.equals(this.product, agreementItem.product) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productOffering, termOrCondition, product, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgreementItem {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    productOffering: ").append(toIndentedString(productOffering)).append("\n");
    sb.append("    termOrCondition: ").append(toIndentedString(termOrCondition)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
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

