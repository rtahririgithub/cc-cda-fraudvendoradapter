package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Characteristics of the product to instantiate or to modify
 */
@ApiModel(description = "Characteristics of the product to instantiate or to modify")
@Validated

public class ProductCharacteristic extends Entity  {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("value")
  private String value = null;

  public ProductCharacteristic name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the characteristic
   * @return name
  **/
  @ApiModelProperty(value = "Name of the characteristic")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductCharacteristic value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Value of the characteristic
   * @return value
  **/
  @ApiModelProperty(value = "Value of the characteristic")


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductCharacteristic productCharacteristic = (ProductCharacteristic) o;
    return Objects.equals(this.name, productCharacteristic.name) &&
        Objects.equals(this.value, productCharacteristic.value) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductCharacteristic {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

