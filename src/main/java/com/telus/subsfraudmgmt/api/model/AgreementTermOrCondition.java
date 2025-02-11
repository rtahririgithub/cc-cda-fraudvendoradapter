package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Entity;
import com.telus.subsfraudmgmt.api.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Aspects of the agreement not formally specified elsewhere in the agreement and that cannot be captured elsewhere in a formal notation, or automatically monitored and require a more human level of management.
 */
@ApiModel(description = "Aspects of the agreement not formally specified elsewhere in the agreement and that cannot be captured elsewhere in a formal notation, or automatically monitored and require a more human level of management.")
@Validated

public class AgreementTermOrCondition extends Entity  {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  public AgreementTermOrCondition description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Text that explains the term or condition of the agreement.
   * @return description
  **/
  @ApiModelProperty(value = "Text that explains the term or condition of the agreement.")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AgreementTermOrCondition id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique number assigned for reference.
   * @return id
  **/
  @ApiModelProperty(value = "Unique number assigned for reference.")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AgreementTermOrCondition validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period of time during which the term or condition of the agreement applies.
   * @return validFor
  **/
  @ApiModelProperty(value = "The period of time during which the term or condition of the agreement applies.")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgreementTermOrCondition agreementTermOrCondition = (AgreementTermOrCondition) o;
    return Objects.equals(this.description, agreementTermOrCondition.description) &&
        Objects.equals(this.id, agreementTermOrCondition.id) &&
        Objects.equals(this.validFor, agreementTermOrCondition.validFor) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, id, validFor, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgreementTermOrCondition {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

