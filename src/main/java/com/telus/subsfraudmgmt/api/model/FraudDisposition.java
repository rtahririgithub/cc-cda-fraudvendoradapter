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
 * fraud disposition represent the changes to be applied to fraud data such as fraud status , fraud type
 */
@ApiModel(description = "fraud disposition represent the changes to be applied to fraud data such as fraud status , fraud type")
@Validated

public class FraudDisposition   {
  @JsonProperty("dispositionDateTime")
  private OffsetDateTime dispositionDateTime = null;

  @JsonProperty("manuallyReviewedInd")
  private Boolean manuallyReviewedInd = null;

  @JsonProperty("productActivatedInd")
  private Boolean productActivatedInd = null;

  @JsonProperty("fraudStatusCode")
  private String fraudStatusCode = null;

  @JsonProperty("fraudTypeCode")
  private String fraudTypeCode = null;

  public FraudDisposition dispositionDateTime(OffsetDateTime dispositionDateTime) {
    this.dispositionDateTime = dispositionDateTime;
    return this;
  }

  /**
   * Date of change
   * @return dispositionDateTime
  **/
  @ApiModelProperty(required = true, value = "Date of change")
  @NotNull

  @Valid

  public OffsetDateTime getDispositionDateTime() {
    return dispositionDateTime;
  }

  public void setDispositionDateTime(OffsetDateTime dispositionDateTime) {
    this.dispositionDateTime = dispositionDateTime;
  }

  public FraudDisposition manuallyReviewedInd(Boolean manuallyReviewedInd) {
    this.manuallyReviewedInd = manuallyReviewedInd;
    return this;
  }

  /**
   * 
   * @return manuallyReviewedInd
  **/
  @ApiModelProperty(value = "")


  public Boolean isManuallyReviewedInd() {
    return manuallyReviewedInd;
  }

  public void setManuallyReviewedInd(Boolean manuallyReviewedInd) {
    this.manuallyReviewedInd = manuallyReviewedInd;
  }

  public FraudDisposition productActivatedInd(Boolean productActivatedInd) {
    this.productActivatedInd = productActivatedInd;
    return this;
  }

  /**
   * 
   * @return productActivatedInd
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean isProductActivatedInd() {
    return productActivatedInd;
  }

  public void setProductActivatedInd(Boolean productActivatedInd) {
    this.productActivatedInd = productActivatedInd;
  }

  public FraudDisposition fraudStatusCode(String fraudStatusCode) {
    this.fraudStatusCode = fraudStatusCode;
    return this;
  }

  /**
   * Fraud status 
   * @return fraudStatusCode
  **/
  @ApiModelProperty(required = true, value = "Fraud status ")
  @NotNull


  public String getFraudStatusCode() {
    return fraudStatusCode;
  }

  public void setFraudStatusCode(String fraudStatusCode) {
    this.fraudStatusCode = fraudStatusCode;
  }

  public FraudDisposition fraudTypeCode(String fraudTypeCode) {
    this.fraudTypeCode = fraudTypeCode;
    return this;
  }

  /**
   * Get fraudTypeCode
   * @return fraudTypeCode
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getFraudTypeCode() {
    return fraudTypeCode;
  }

  public void setFraudTypeCode(String fraudTypeCode) {
    this.fraudTypeCode = fraudTypeCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudDisposition fraudDisposition = (FraudDisposition) o;
    return Objects.equals(this.dispositionDateTime, fraudDisposition.dispositionDateTime) &&
        Objects.equals(this.manuallyReviewedInd, fraudDisposition.manuallyReviewedInd) &&
        Objects.equals(this.productActivatedInd, fraudDisposition.productActivatedInd) &&
        Objects.equals(this.fraudStatusCode, fraudDisposition.fraudStatusCode) &&
        Objects.equals(this.fraudTypeCode, fraudDisposition.fraudTypeCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dispositionDateTime, manuallyReviewedInd, productActivatedInd, fraudStatusCode, fraudTypeCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudDisposition {\n");
    
    sb.append("    dispositionDateTime: ").append(toIndentedString(dispositionDateTime)).append("\n");
    sb.append("    manuallyReviewedInd: ").append(toIndentedString(manuallyReviewedInd)).append("\n");
    sb.append("    productActivatedInd: ").append(toIndentedString(productActivatedInd)).append("\n");
    sb.append("    fraudStatusCode: ").append(toIndentedString(fraudStatusCode)).append("\n");
    sb.append("    fraudTypeCode: ").append(toIndentedString(fraudTypeCode)).append("\n");
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

