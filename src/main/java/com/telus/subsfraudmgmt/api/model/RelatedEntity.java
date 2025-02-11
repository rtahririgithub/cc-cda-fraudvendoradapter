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
 * A reference to an entity, where the type of the entity is not known in advance.
 */
@ApiModel(description = "A reference to an entity, where the type of the entity is not known in advance.")
@Validated

public class RelatedEntity extends EntityRef  {
  @JsonProperty("role")
  private String role = null;

  public RelatedEntity role(String role) {
    this.role = role;
    return this;
  }

  /**
   * The role of an entity.
   * @return role
  **/
  @ApiModelProperty(value = "The role of an entity.")


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelatedEntity relatedEntity = (RelatedEntity) o;
    return Objects.equals(this.role, relatedEntity.role) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(role, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelatedEntity {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

