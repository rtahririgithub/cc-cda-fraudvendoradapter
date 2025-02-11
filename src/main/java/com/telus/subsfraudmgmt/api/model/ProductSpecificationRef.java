package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.EntityRef;
import com.telus.subsfraudmgmt.api.model.TargetProductSchema;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Product specification reference: A ProductSpecification is a detailed description of a tangible or intangible object made available externally in the form of a ProductOffering to customers or other parties playing a party role.
 */
@ApiModel(description = "Product specification reference: A ProductSpecification is a detailed description of a tangible or intangible object made available externally in the form of a ProductOffering to customers or other parties playing a party role.")
@Validated

public class ProductSpecificationRef extends EntityRef  {
  @JsonProperty("version")
  private String version = null;

  @JsonProperty("targetProductSchema")
  private TargetProductSchema targetProductSchema = null;

  public ProductSpecificationRef version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Version of the product specification
   * @return version
  **/
  @ApiModelProperty(value = "Version of the product specification")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public ProductSpecificationRef targetProductSchema(TargetProductSchema targetProductSchema) {
    this.targetProductSchema = targetProductSchema;
    return this;
  }

  /**
   * A target product schema reference. The reference object to the schema and type of target product which is described by product specification.
   * @return targetProductSchema
  **/
  @ApiModelProperty(value = "A target product schema reference. The reference object to the schema and type of target product which is described by product specification.")

  @Valid

  public TargetProductSchema getTargetProductSchema() {
    return targetProductSchema;
  }

  public void setTargetProductSchema(TargetProductSchema targetProductSchema) {
    this.targetProductSchema = targetProductSchema;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductSpecificationRef productSpecificationRef = (ProductSpecificationRef) o;
    return Objects.equals(this.version, productSpecificationRef.version) &&
        Objects.equals(this.targetProductSchema, productSpecificationRef.targetProductSchema) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, targetProductSchema, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSpecificationRef {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    targetProductSchema: ").append(toIndentedString(targetProductSchema)).append("\n");
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

