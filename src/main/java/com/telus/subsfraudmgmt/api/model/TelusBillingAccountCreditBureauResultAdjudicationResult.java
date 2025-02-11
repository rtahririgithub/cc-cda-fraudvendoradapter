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
 * TelusBillingAccountCreditBureauResultAdjudicationResult
 */
@Validated

public class TelusBillingAccountCreditBureauResultAdjudicationResult   {
  @JsonProperty("creditClassCd")
  private String creditClassCd = null;

  public TelusBillingAccountCreditBureauResultAdjudicationResult creditClassCd(String creditClassCd) {
    this.creditClassCd = creditClassCd;
    return this;
  }

  /**
   * 
   * @return creditClassCd
  **/
  @ApiModelProperty(value = "")


  public String getCreditClassCd() {
    return creditClassCd;
  }

  public void setCreditClassCd(String creditClassCd) {
    this.creditClassCd = creditClassCd;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelusBillingAccountCreditBureauResultAdjudicationResult telusBillingAccountCreditBureauResultAdjudicationResult = (TelusBillingAccountCreditBureauResultAdjudicationResult) o;
    return Objects.equals(this.creditClassCd, telusBillingAccountCreditBureauResultAdjudicationResult.creditClassCd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creditClassCd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelusBillingAccountCreditBureauResultAdjudicationResult {\n");
    
    sb.append("    creditClassCd: ").append(toIndentedString(creditClassCd)).append("\n");
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

