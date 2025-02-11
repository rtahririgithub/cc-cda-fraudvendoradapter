package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Individual;
import com.telus.subsfraudmgmt.api.model.IndividualRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A reference to an entity, where the type of the entity is not known in advance. A related entity defines a entity described by reference or by value linked to a specific entity. The polymorphic attributes @type, @schemaLocation &amp; @referredType are related to the Entity and not the RelatedEntityRefOrValue class itself
 */
@ApiModel(description = "A reference to an entity, where the type of the entity is not known in advance. A related entity defines a entity described by reference or by value linked to a specific entity. The polymorphic attributes @type, @schemaLocation & @referredType are related to the Entity and not the RelatedEntityRefOrValue class itself")
@Validated

public class IndividualRefOrValue   {
  @JsonProperty("role")
  private String role = null;

  @JsonProperty("value")
  private Individual value = null;

  @JsonProperty("ref")
  private IndividualRef ref = null;

  public IndividualRefOrValue role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public IndividualRefOrValue value(Individual value) {
    this.value = value;
    return this;
  }

  /**
   * 
   * @return value
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Individual getValue() {
    return value;
  }

  public void setValue(Individual value) {
    this.value = value;
  }

  public IndividualRefOrValue ref(IndividualRef ref) {
    this.ref = ref;
    return this;
  }

  /**
   * 
   * @return ref
  **/
  @ApiModelProperty(value = "")

  @Valid

  public IndividualRef getRef() {
    return ref;
  }

  public void setRef(IndividualRef ref) {
    this.ref = ref;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndividualRefOrValue individualRefOrValue = (IndividualRefOrValue) o;
    return Objects.equals(this.role, individualRefOrValue.role) &&
        Objects.equals(this.value, individualRefOrValue.value) &&
        Objects.equals(this.ref, individualRefOrValue.ref);
  }

  @Override
  public int hashCode() {
    return Objects.hash(role, value, ref);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndividualRefOrValue {\n");
    
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    ref: ").append(toIndentedString(ref)).append("\n");
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

