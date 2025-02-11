package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Entity;
import com.telus.subsfraudmgmt.api.model.Price;
import com.telus.subsfraudmgmt.api.model.ProductOfferingPriceRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Is an amount, usually of money, that modifies the price charged for an order item.
 */
@ApiModel(description = "Is an amount, usually of money, that modifies the price charged for an order item.")
@Validated

public class PriceAlteration extends Entity  {
  @JsonProperty("applicationDuration")
  private Integer applicationDuration = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("productOfferingPrice")
  private ProductOfferingPriceRef productOfferingPrice = null;

  @JsonProperty("priceType")
  private String priceType = null;

  @JsonProperty("priority")
  private Integer priority = null;

  @JsonProperty("recurringChargePeriod")
  private String recurringChargePeriod = null;

  @JsonProperty("unitOfMeasure")
  private String unitOfMeasure = null;

  @JsonProperty("price")
  private Price price = null;

  public PriceAlteration applicationDuration(Integer applicationDuration) {
    this.applicationDuration = applicationDuration;
    return this;
  }

  /**
   * Duration during which the alteration applies on the order item price (for instance 2 months free of charge for the recurring charge)
   * @return applicationDuration
  **/
  @ApiModelProperty(value = "Duration during which the alteration applies on the order item price (for instance 2 months free of charge for the recurring charge)")


  public Integer getApplicationDuration() {
    return applicationDuration;
  }

  public void setApplicationDuration(Integer applicationDuration) {
    this.applicationDuration = applicationDuration;
  }

  public PriceAlteration description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains in detail the semantics of this order item price alteration
   * @return description
  **/
  @ApiModelProperty(value = "A narrative that explains in detail the semantics of this order item price alteration")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PriceAlteration name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the order item price alteration
   * @return name
  **/
  @ApiModelProperty(value = "Name of the order item price alteration")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PriceAlteration productOfferingPrice(ProductOfferingPriceRef productOfferingPrice) {
    this.productOfferingPrice = productOfferingPrice;
    return this;
  }

  /**
   * Get productOfferingPrice
   * @return productOfferingPrice
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ProductOfferingPriceRef getProductOfferingPrice() {
    return productOfferingPrice;
  }

  public void setProductOfferingPrice(ProductOfferingPriceRef productOfferingPrice) {
    this.productOfferingPrice = productOfferingPrice;
  }

  public PriceAlteration priceType(String priceType) {
    this.priceType = priceType;
    return this;
  }

  /**
   * A category that describes the price such as recurring, one time and usage.
   * @return priceType
  **/
  @ApiModelProperty(value = "A category that describes the price such as recurring, one time and usage.")


  public String getPriceType() {
    return priceType;
  }

  public void setPriceType(String priceType) {
    this.priceType = priceType;
  }

  public PriceAlteration priority(Integer priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Priority level for applying this alteration among all the defined alterations on the order item price
   * @return priority
  **/
  @ApiModelProperty(value = "Priority level for applying this alteration among all the defined alterations on the order item price")


  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public PriceAlteration recurringChargePeriod(String recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
    return this;
  }

  /**
   * Could be month, week...
   * @return recurringChargePeriod
  **/
  @ApiModelProperty(value = "Could be month, week...")


  public String getRecurringChargePeriod() {
    return recurringChargePeriod;
  }

  public void setRecurringChargePeriod(String recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
  }

  public PriceAlteration unitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

  /**
   * Could be minutes, GB...
   * @return unitOfMeasure
  **/
  @ApiModelProperty(value = "Could be minutes, GB...")


  public String getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public PriceAlteration price(Price price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceAlteration priceAlteration = (PriceAlteration) o;
    return Objects.equals(this.applicationDuration, priceAlteration.applicationDuration) &&
        Objects.equals(this.description, priceAlteration.description) &&
        Objects.equals(this.name, priceAlteration.name) &&
        Objects.equals(this.productOfferingPrice, priceAlteration.productOfferingPrice) &&
        Objects.equals(this.priceType, priceAlteration.priceType) &&
        Objects.equals(this.priority, priceAlteration.priority) &&
        Objects.equals(this.recurringChargePeriod, priceAlteration.recurringChargePeriod) &&
        Objects.equals(this.unitOfMeasure, priceAlteration.unitOfMeasure) &&
        Objects.equals(this.price, priceAlteration.price) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationDuration, description, name, productOfferingPrice, priceType, priority, recurringChargePeriod, unitOfMeasure, price, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceAlteration {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    applicationDuration: ").append(toIndentedString(applicationDuration)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    productOfferingPrice: ").append(toIndentedString(productOfferingPrice)).append("\n");
    sb.append("    priceType: ").append(toIndentedString(priceType)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    recurringChargePeriod: ").append(toIndentedString(recurringChargePeriod)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

