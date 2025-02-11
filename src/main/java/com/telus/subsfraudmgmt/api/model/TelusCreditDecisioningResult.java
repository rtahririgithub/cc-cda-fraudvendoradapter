package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.TelusCreditDecisioningResultDecisionKeys;
import com.telus.subsfraudmgmt.api.model.TelusCreditDecisioningWarning;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TelusCreditDecisioningResult
 */
@Validated

public class TelusCreditDecisioningResult   {
  @JsonProperty("creditAssessmentId")
  private String creditAssessmentId = null;

  @JsonProperty("creditAssessmentType")
  private String creditAssessmentType = null;

  @JsonProperty("creditAssessmentSubType")
  private String creditAssessmentSubType = null;

  @JsonProperty("clpExistingMatchingAccountInd")
  private Boolean clpExistingMatchingAccountInd = null;

  @JsonProperty("creditAssessmentResultCd")
  private String creditAssessmentResultCd = null;

  @JsonProperty("creditAssessmentResultReasonCd")
  private String creditAssessmentResultReasonCd = null;

  @JsonProperty("decisionKeys")
  private TelusCreditDecisioningResultDecisionKeys decisionKeys = null;

  @JsonProperty("warnings")
  @Valid
  private List<TelusCreditDecisioningWarning> warnings = null;

  public TelusCreditDecisioningResult creditAssessmentId(String creditAssessmentId) {
    this.creditAssessmentId = creditAssessmentId;
    return this;
  }

  /**
   * Get creditAssessmentId
   * @return creditAssessmentId
  **/
  @ApiModelProperty(value = "")


  public String getCreditAssessmentId() {
    return creditAssessmentId;
  }

  public void setCreditAssessmentId(String creditAssessmentId) {
    this.creditAssessmentId = creditAssessmentId;
  }

  public TelusCreditDecisioningResult creditAssessmentType(String creditAssessmentType) {
    this.creditAssessmentType = creditAssessmentType;
    return this;
  }

  /**
   * Get creditAssessmentType
   * @return creditAssessmentType
  **/
  @ApiModelProperty(value = "")


  public String getCreditAssessmentType() {
    return creditAssessmentType;
  }

  public void setCreditAssessmentType(String creditAssessmentType) {
    this.creditAssessmentType = creditAssessmentType;
  }

  public TelusCreditDecisioningResult creditAssessmentSubType(String creditAssessmentSubType) {
    this.creditAssessmentSubType = creditAssessmentSubType;
    return this;
  }

  /**
   * Get creditAssessmentSubType
   * @return creditAssessmentSubType
  **/
  @ApiModelProperty(value = "")


  public String getCreditAssessmentSubType() {
    return creditAssessmentSubType;
  }

  public void setCreditAssessmentSubType(String creditAssessmentSubType) {
    this.creditAssessmentSubType = creditAssessmentSubType;
  }

  public TelusCreditDecisioningResult clpExistingMatchingAccountInd(Boolean clpExistingMatchingAccountInd) {
    this.clpExistingMatchingAccountInd = clpExistingMatchingAccountInd;
    return this;
  }

  /**
   * Indicates whether the account has another matching account on credit limit program.
   * @return clpExistingMatchingAccountInd
  **/
  @ApiModelProperty(value = "Indicates whether the account has another matching account on credit limit program.")


  public Boolean isClpExistingMatchingAccountInd() {
    return clpExistingMatchingAccountInd;
  }

  public void setClpExistingMatchingAccountInd(Boolean clpExistingMatchingAccountInd) {
    this.clpExistingMatchingAccountInd = clpExistingMatchingAccountInd;
  }

  public TelusCreditDecisioningResult creditAssessmentResultCd(String creditAssessmentResultCd) {
    this.creditAssessmentResultCd = creditAssessmentResultCd;
    return this;
  }

  /**
   * Get creditAssessmentResultCd
   * @return creditAssessmentResultCd
  **/
  @ApiModelProperty(value = "")


  public String getCreditAssessmentResultCd() {
    return creditAssessmentResultCd;
  }

  public void setCreditAssessmentResultCd(String creditAssessmentResultCd) {
    this.creditAssessmentResultCd = creditAssessmentResultCd;
  }

  public TelusCreditDecisioningResult creditAssessmentResultReasonCd(String creditAssessmentResultReasonCd) {
    this.creditAssessmentResultReasonCd = creditAssessmentResultReasonCd;
    return this;
  }

  /**
   * Get creditAssessmentResultReasonCd
   * @return creditAssessmentResultReasonCd
  **/
  @ApiModelProperty(value = "")


  public String getCreditAssessmentResultReasonCd() {
    return creditAssessmentResultReasonCd;
  }

  public void setCreditAssessmentResultReasonCd(String creditAssessmentResultReasonCd) {
    this.creditAssessmentResultReasonCd = creditAssessmentResultReasonCd;
  }

  public TelusCreditDecisioningResult decisionKeys(TelusCreditDecisioningResultDecisionKeys decisionKeys) {
    this.decisionKeys = decisionKeys;
    return this;
  }

  /**
   * Get decisionKeys
   * @return decisionKeys
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TelusCreditDecisioningResultDecisionKeys getDecisionKeys() {
    return decisionKeys;
  }

  public void setDecisionKeys(TelusCreditDecisioningResultDecisionKeys decisionKeys) {
    this.decisionKeys = decisionKeys;
  }

  public TelusCreditDecisioningResult warnings(List<TelusCreditDecisioningWarning> warnings) {
    this.warnings = warnings;
    return this;
  }

  public TelusCreditDecisioningResult addWarningsItem(TelusCreditDecisioningWarning warningsItem) {
    if (this.warnings == null) {
      this.warnings = new ArrayList<>();
    }
    this.warnings.add(warningsItem);
    return this;
  }

  /**
   * Get warnings
   * @return warnings
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<TelusCreditDecisioningWarning> getWarnings() {
    return warnings;
  }

  public void setWarnings(List<TelusCreditDecisioningWarning> warnings) {
    this.warnings = warnings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelusCreditDecisioningResult telusCreditDecisioningResult = (TelusCreditDecisioningResult) o;
    return Objects.equals(this.creditAssessmentId, telusCreditDecisioningResult.creditAssessmentId) &&
        Objects.equals(this.creditAssessmentType, telusCreditDecisioningResult.creditAssessmentType) &&
        Objects.equals(this.creditAssessmentSubType, telusCreditDecisioningResult.creditAssessmentSubType) &&
        Objects.equals(this.clpExistingMatchingAccountInd, telusCreditDecisioningResult.clpExistingMatchingAccountInd) &&
        Objects.equals(this.creditAssessmentResultCd, telusCreditDecisioningResult.creditAssessmentResultCd) &&
        Objects.equals(this.creditAssessmentResultReasonCd, telusCreditDecisioningResult.creditAssessmentResultReasonCd) &&
        Objects.equals(this.decisionKeys, telusCreditDecisioningResult.decisionKeys) &&
        Objects.equals(this.warnings, telusCreditDecisioningResult.warnings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creditAssessmentId, creditAssessmentType, creditAssessmentSubType, clpExistingMatchingAccountInd, creditAssessmentResultCd, creditAssessmentResultReasonCd, decisionKeys, warnings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelusCreditDecisioningResult {\n");
    
    sb.append("    creditAssessmentId: ").append(toIndentedString(creditAssessmentId)).append("\n");
    sb.append("    creditAssessmentType: ").append(toIndentedString(creditAssessmentType)).append("\n");
    sb.append("    creditAssessmentSubType: ").append(toIndentedString(creditAssessmentSubType)).append("\n");
    sb.append("    clpExistingMatchingAccountInd: ").append(toIndentedString(clpExistingMatchingAccountInd)).append("\n");
    sb.append("    creditAssessmentResultCd: ").append(toIndentedString(creditAssessmentResultCd)).append("\n");
    sb.append("    creditAssessmentResultReasonCd: ").append(toIndentedString(creditAssessmentResultReasonCd)).append("\n");
    sb.append("    decisionKeys: ").append(toIndentedString(decisionKeys)).append("\n");
    sb.append("    warnings: ").append(toIndentedString(warnings)).append("\n");
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

