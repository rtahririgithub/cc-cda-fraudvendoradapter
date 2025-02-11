package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TelusCreditDecisioningWarning
 */
@Validated

public class TelusCreditDecisioningWarning   {
  @JsonProperty("warningCategoryCd")
  private String warningCategoryCd = null;

  @JsonProperty("warningCd")
  private String warningCd = null;

  @JsonProperty("warningTypeCd")
  private String warningTypeCd = null;

  @JsonProperty("warningDetectionDate")
  private OffsetDateTime warningDetectionDate = null;

  @JsonProperty("warningItemTypeCd")
  private String warningItemTypeCd = null;

  @JsonProperty("warningStatusCd")
  private String warningStatusCd = null;

  public TelusCreditDecisioningWarning warningCategoryCd(String warningCategoryCd) {
    this.warningCategoryCd = warningCategoryCd;
    return this;
  }

  /**
   * 
   * @return warningCategoryCd
  **/
  @ApiModelProperty(value = "")


  public String getWarningCategoryCd() {
    return warningCategoryCd;
  }

  public void setWarningCategoryCd(String warningCategoryCd) {
    this.warningCategoryCd = warningCategoryCd;
  }

  public TelusCreditDecisioningWarning warningCd(String warningCd) {
    this.warningCd = warningCd;
    return this;
  }

  /**
   * 
   * @return warningCd
  **/
  @ApiModelProperty(value = "")


  public String getWarningCd() {
    return warningCd;
  }

  public void setWarningCd(String warningCd) {
    this.warningCd = warningCd;
  }

  public TelusCreditDecisioningWarning warningTypeCd(String warningTypeCd) {
    this.warningTypeCd = warningTypeCd;
    return this;
  }

  /**
   * 
   * @return warningTypeCd
  **/
  @ApiModelProperty(value = "")


  public String getWarningTypeCd() {
    return warningTypeCd;
  }

  public void setWarningTypeCd(String warningTypeCd) {
    this.warningTypeCd = warningTypeCd;
  }

  public TelusCreditDecisioningWarning warningDetectionDate(OffsetDateTime warningDetectionDate) {
    this.warningDetectionDate = warningDetectionDate;
    return this;
  }

  /**
   * 
   * @return warningDetectionDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getWarningDetectionDate() {
    return warningDetectionDate;
  }

  public void setWarningDetectionDate(OffsetDateTime warningDetectionDate) {
    this.warningDetectionDate = warningDetectionDate;
  }

  public TelusCreditDecisioningWarning warningItemTypeCd(String warningItemTypeCd) {
    this.warningItemTypeCd = warningItemTypeCd;
    return this;
  }

  /**
   * 
   * @return warningItemTypeCd
  **/
  @ApiModelProperty(value = "")


  public String getWarningItemTypeCd() {
    return warningItemTypeCd;
  }

  public void setWarningItemTypeCd(String warningItemTypeCd) {
    this.warningItemTypeCd = warningItemTypeCd;
  }

  public TelusCreditDecisioningWarning warningStatusCd(String warningStatusCd) {
    this.warningStatusCd = warningStatusCd;
    return this;
  }

  /**
   * 
   * @return warningStatusCd
  **/
  @ApiModelProperty(value = "")


  public String getWarningStatusCd() {
    return warningStatusCd;
  }

  public void setWarningStatusCd(String warningStatusCd) {
    this.warningStatusCd = warningStatusCd;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelusCreditDecisioningWarning telusCreditDecisioningWarning = (TelusCreditDecisioningWarning) o;
    return Objects.equals(this.warningCategoryCd, telusCreditDecisioningWarning.warningCategoryCd) &&
        Objects.equals(this.warningCd, telusCreditDecisioningWarning.warningCd) &&
        Objects.equals(this.warningTypeCd, telusCreditDecisioningWarning.warningTypeCd) &&
        Objects.equals(this.warningDetectionDate, telusCreditDecisioningWarning.warningDetectionDate) &&
        Objects.equals(this.warningItemTypeCd, telusCreditDecisioningWarning.warningItemTypeCd) &&
        Objects.equals(this.warningStatusCd, telusCreditDecisioningWarning.warningStatusCd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(warningCategoryCd, warningCd, warningTypeCd, warningDetectionDate, warningItemTypeCd, warningStatusCd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelusCreditDecisioningWarning {\n");
    
    sb.append("    warningCategoryCd: ").append(toIndentedString(warningCategoryCd)).append("\n");
    sb.append("    warningCd: ").append(toIndentedString(warningCd)).append("\n");
    sb.append("    warningTypeCd: ").append(toIndentedString(warningTypeCd)).append("\n");
    sb.append("    warningDetectionDate: ").append(toIndentedString(warningDetectionDate)).append("\n");
    sb.append("    warningItemTypeCd: ").append(toIndentedString(warningItemTypeCd)).append("\n");
    sb.append("    warningStatusCd: ").append(toIndentedString(warningStatusCd)).append("\n");
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

