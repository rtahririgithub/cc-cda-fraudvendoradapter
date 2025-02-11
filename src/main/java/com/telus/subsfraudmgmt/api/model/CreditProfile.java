package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Entity;
import com.telus.subsfraudmgmt.api.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Credit profile for the party (containing credit scoring, ...). By default only the current credit profile  is retrieved. It can be used as a list to give the party credit profiles history, the first one in the list will be the current one.
 */
@ApiModel(description = "Credit profile for the party (containing credit scoring, ...). By default only the current credit profile  is retrieved. It can be used as a list to give the party credit profiles history, the first one in the list will be the current one.")
@Validated

public class CreditProfile extends Entity  {
  @JsonProperty("creditProfileDate")
  private OffsetDateTime creditProfileDate = null;

  @JsonProperty("creditRiskRating")
  private Integer creditRiskRating = null;

  @JsonProperty("creditScore")
  private Integer creditScore = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  public CreditProfile creditProfileDate(OffsetDateTime creditProfileDate) {
    this.creditProfileDate = creditProfileDate;
    return this;
  }

  /**
   * The date the profile was established
   * @return creditProfileDate
  **/
  @ApiModelProperty(value = "The date the profile was established")

  @Valid

  public OffsetDateTime getCreditProfileDate() {
    return creditProfileDate;
  }

  public void setCreditProfileDate(OffsetDateTime creditProfileDate) {
    this.creditProfileDate = creditProfileDate;
  }

  public CreditProfile creditRiskRating(Integer creditRiskRating) {
    this.creditRiskRating = creditRiskRating;
    return this;
  }

  /**
   * This is an integer whose value is used to rate the risk
   * @return creditRiskRating
  **/
  @ApiModelProperty(value = "This is an integer whose value is used to rate the risk")


  public Integer getCreditRiskRating() {
    return creditRiskRating;
  }

  public void setCreditRiskRating(Integer creditRiskRating) {
    this.creditRiskRating = creditRiskRating;
  }

  public CreditProfile creditScore(Integer creditScore) {
    this.creditScore = creditScore;
    return this;
  }

  /**
   * A measure of a person or organizations creditworthiness calculated on the basis of a combination of factors such as their income and credit history
   * @return creditScore
  **/
  @ApiModelProperty(value = "A measure of a person or organizations creditworthiness calculated on the basis of a combination of factors such as their income and credit history")


  public Integer getCreditScore() {
    return creditScore;
  }

  public void setCreditScore(Integer creditScore) {
    this.creditScore = creditScore;
  }

  public CreditProfile validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the profile is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the profile is valid")

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
    CreditProfile creditProfile = (CreditProfile) o;
    return Objects.equals(this.creditProfileDate, creditProfile.creditProfileDate) &&
        Objects.equals(this.creditRiskRating, creditProfile.creditRiskRating) &&
        Objects.equals(this.creditScore, creditProfile.creditScore) &&
        Objects.equals(this.validFor, creditProfile.validFor) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creditProfileDate, creditRiskRating, creditScore, validFor, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditProfile {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    creditProfileDate: ").append(toIndentedString(creditProfileDate)).append("\n");
    sb.append("    creditRiskRating: ").append(toIndentedString(creditRiskRating)).append("\n");
    sb.append("    creditScore: ").append(toIndentedString(creditScore)).append("\n");
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

