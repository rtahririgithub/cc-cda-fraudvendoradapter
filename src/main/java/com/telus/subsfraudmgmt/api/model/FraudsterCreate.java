package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.IndividualRefOrValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * fraudster( individual identified as a fraudster)
 */
@ApiModel(description = "fraudster( individual identified as a fraudster)")
@Validated

public class FraudsterCreate   {
  @JsonProperty("externalApplicationId")
  private String externalApplicationId = null;

  @JsonProperty("externalCreditAssessmentId")
  private String externalCreditAssessmentId = null;

  @JsonProperty("individual")
  private IndividualRefOrValue individual = null;

  public FraudsterCreate externalApplicationId(String externalApplicationId) {
    this.externalApplicationId = externalApplicationId;
    return this;
  }

  /**
   * Unique identifier for a particular activity(application) assigned by the client who is receiving or submitting the fraudCheck request 
   * @return externalApplicationId
  **/
  @ApiModelProperty(required = true, value = "Unique identifier for a particular activity(application) assigned by the client who is receiving or submitting the fraudCheck request ")
  @NotNull


  public String getExternalApplicationId() {
    return externalApplicationId;
  }

  public void setExternalApplicationId(String externalApplicationId) {
    this.externalApplicationId = externalApplicationId;
  }

  public FraudsterCreate externalCreditAssessmentId(String externalCreditAssessmentId) {
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

  public FraudsterCreate individual(IndividualRefOrValue individual) {
    this.individual = individual;
    return this;
  }

  /**
   * Get individual
   * @return individual
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public IndividualRefOrValue getIndividual() {
    return individual;
  }

  public void setIndividual(IndividualRefOrValue individual) {
    this.individual = individual;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudsterCreate fraudsterCreate = (FraudsterCreate) o;
    return Objects.equals(this.externalApplicationId, fraudsterCreate.externalApplicationId) &&
        Objects.equals(this.externalCreditAssessmentId, fraudsterCreate.externalCreditAssessmentId) &&
        Objects.equals(this.individual, fraudsterCreate.individual);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalApplicationId, externalCreditAssessmentId, individual);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudsterCreate {\n");
    
    sb.append("    externalApplicationId: ").append(toIndentedString(externalApplicationId)).append("\n");
    sb.append("    externalCreditAssessmentId: ").append(toIndentedString(externalCreditAssessmentId)).append("\n");
    sb.append("    individual: ").append(toIndentedString(individual)).append("\n");
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

