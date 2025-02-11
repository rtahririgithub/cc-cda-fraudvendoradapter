package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.telus.subsfraudmgmt.api.model.EntityRef;
import io.swagger.annotations.ApiModel;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProductPriceOffering reference. An amount, usually of money, that is asked for or allowed when a ProductOffering is bought, rented, or leased
 */
@ApiModel(description = "ProductPriceOffering reference. An amount, usually of money, that is asked for or allowed when a ProductOffering is bought, rented, or leased")
@Validated

public class ProductOfferingPriceRef extends EntityRef  {

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOfferingPriceRef {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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

