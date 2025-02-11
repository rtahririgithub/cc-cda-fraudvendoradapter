package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Entity;
import com.telus.subsfraudmgmt.api.model.ProductRefOrValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Linked products to the one instantiate, such as [bundled] if the product is a bundle and you want to describe the bundled products inside this bundle; [reliesOn] if the product needs another already owned product to rely on (e.g. an option on an already owned mobile access product) [targets] or [isTargeted] (depending on the way of expressing the link) for any other kind of links that may be useful
 */
@ApiModel(description = "Linked products to the one instantiate, such as [bundled] if the product is a bundle and you want to describe the bundled products inside this bundle; [reliesOn] if the product needs another already owned product to rely on (e.g. an option on an already owned mobile access product) [targets] or [isTargeted] (depending on the way of expressing the link) for any other kind of links that may be useful")
@Validated

public class ProductRelationship extends Entity  {
  @JsonProperty("relationshipType")
  private String relationshipType = null;

  @JsonProperty("product")
  private ProductRefOrValue product = null;

  public ProductRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * Type of the product relationship, such as [bundled] if the product is a bundle and you want to describe the bundled products inside this bundle; [reliesOn] if the product needs another already owned product to rely on (e.g. an option on an already owned mobile access product) [targets] or [isTargeted] (depending on the way of expressing the link) for any other kind of links that may be useful
   * @return relationshipType
  **/
  @ApiModelProperty(value = "Type of the product relationship, such as [bundled] if the product is a bundle and you want to describe the bundled products inside this bundle; [reliesOn] if the product needs another already owned product to rely on (e.g. an option on an already owned mobile access product) [targets] or [isTargeted] (depending on the way of expressing the link) for any other kind of links that may be useful")


  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public ProductRelationship product(ProductRefOrValue product) {
    this.product = product;
    return this;
  }

  /**
   * Get product
   * @return product
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ProductRefOrValue getProduct() {
    return product;
  }

  public void setProduct(ProductRefOrValue product) {
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
    ProductRelationship productRelationship = (ProductRelationship) o;
    return Objects.equals(this.relationshipType, productRelationship.relationshipType) &&
        Objects.equals(this.product, productRelationship.product) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relationshipType, product, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductRelationship {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
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

