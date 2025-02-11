package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.EntityRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Agreement specification reference. An AgreementSpecification represents a template of an agreement that can be used when establishing partnerships.
 */
@ApiModel(description = "Agreement specification reference. An AgreementSpecification represents a template of an agreement that can be used when establishing partnerships.")
@Validated

public class AgreementSpecificationRef extends EntityRef  {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  public AgreementSpecificationRef description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains in detail what the agreement specification is about.
   * @return description
  **/
  @ApiModelProperty(value = "A narrative that explains in detail what the agreement specification is about.")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AgreementSpecificationRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the agreement specification
   * @return name
  **/
  @ApiModelProperty(value = "Name of the agreement specification")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgreementSpecificationRef agreementSpecificationRef = (AgreementSpecificationRef) o;
    return Objects.equals(this.description, agreementSpecificationRef.description) &&
        Objects.equals(this.name, agreementSpecificationRef.name) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, name, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgreementSpecificationRef {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

