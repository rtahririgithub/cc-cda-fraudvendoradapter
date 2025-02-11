package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Body
 */
@Validated

public class Body   {
  @JsonProperty("externalApplicationId")
  private String externalApplicationId = null;

  @JsonProperty("externalCreditAssessmentId")
  private String externalCreditAssessmentId = null;

  public Body externalApplicationId(String externalApplicationId) {
    this.externalApplicationId = externalApplicationId;
    return this;
  }

  /**
   * Unique identifier for a particular activity(application) assigned by the client who is receiving or submitting the fraudCheck request 
   * @return externalApplicationId
  **/
  @ApiModelProperty(value = "Unique identifier for a particular activity(application) assigned by the client who is receiving or submitting the fraudCheck request ")


  public String getExternalApplicationId() {
    return externalApplicationId;
  }

  public void setExternalApplicationId(String externalApplicationId) {
    this.externalApplicationId = externalApplicationId;
  }

  public Body externalCreditAssessmentId(String externalCreditAssessmentId) {
    this.externalCreditAssessmentId = externalCreditAssessmentId;
    return this;
  }

  /**
   * 
   * @return externalCreditAssessmentId
  **/
  @ApiModelProperty(value = "")


  public String getExternalCreditAssessmentId() {
    return externalCreditAssessmentId;
  }

  public void setExternalCreditAssessmentId(String externalCreditAssessmentId) {
    this.externalCreditAssessmentId = externalCreditAssessmentId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body body = (Body) o;
    return Objects.equals(this.externalApplicationId, body.externalApplicationId) &&
        Objects.equals(this.externalCreditAssessmentId, body.externalCreditAssessmentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalApplicationId, externalCreditAssessmentId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body {\n");
    
    sb.append("    externalApplicationId: ").append(toIndentedString(externalApplicationId)).append("\n");
    sb.append("    externalCreditAssessmentId: ").append(toIndentedString(externalCreditAssessmentId)).append("\n");
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

