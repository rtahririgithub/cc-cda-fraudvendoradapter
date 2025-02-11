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
 * TelusBillingAccountCreditBureauResultRiskIndicator
 */
@Validated

public class TelusBillingAccountCreditBureauResultRiskIndicator   {
  @JsonProperty("writeOffCd")
  private String writeOffCd = null;

  @JsonProperty("bankcrupcyInd")
  private Boolean bankcrupcyInd = null;

  @JsonProperty("secondaryRiskCd")
  private String secondaryRiskCd = null;

  @JsonProperty("temporarySinInd")
  private Boolean temporarySinInd = null;

  @JsonProperty("trueThinFileInd")
  private Boolean trueThinFileInd = null;

  @JsonProperty("noHitThinFileInd")
  private Boolean noHitThinFileInd = null;

  public TelusBillingAccountCreditBureauResultRiskIndicator writeOffCd(String writeOffCd) {
    this.writeOffCd = writeOffCd;
    return this;
  }

  /**
   * 
   * @return writeOffCd
  **/
  @ApiModelProperty(value = "")


  public String getWriteOffCd() {
    return writeOffCd;
  }

  public void setWriteOffCd(String writeOffCd) {
    this.writeOffCd = writeOffCd;
  }

  public TelusBillingAccountCreditBureauResultRiskIndicator bankcrupcyInd(Boolean bankcrupcyInd) {
    this.bankcrupcyInd = bankcrupcyInd;
    return this;
  }

  /**
   * 
   * @return bankcrupcyInd
  **/
  @ApiModelProperty(value = "")


  public Boolean isBankcrupcyInd() {
    return bankcrupcyInd;
  }

  public void setBankcrupcyInd(Boolean bankcrupcyInd) {
    this.bankcrupcyInd = bankcrupcyInd;
  }

  public TelusBillingAccountCreditBureauResultRiskIndicator secondaryRiskCd(String secondaryRiskCd) {
    this.secondaryRiskCd = secondaryRiskCd;
    return this;
  }

  /**
   * 
   * @return secondaryRiskCd
  **/
  @ApiModelProperty(value = "")


  public String getSecondaryRiskCd() {
    return secondaryRiskCd;
  }

  public void setSecondaryRiskCd(String secondaryRiskCd) {
    this.secondaryRiskCd = secondaryRiskCd;
  }

  public TelusBillingAccountCreditBureauResultRiskIndicator temporarySinInd(Boolean temporarySinInd) {
    this.temporarySinInd = temporarySinInd;
    return this;
  }

  /**
   * 
   * @return temporarySinInd
  **/
  @ApiModelProperty(value = "")


  public Boolean isTemporarySinInd() {
    return temporarySinInd;
  }

  public void setTemporarySinInd(Boolean temporarySinInd) {
    this.temporarySinInd = temporarySinInd;
  }

  public TelusBillingAccountCreditBureauResultRiskIndicator trueThinFileInd(Boolean trueThinFileInd) {
    this.trueThinFileInd = trueThinFileInd;
    return this;
  }

  /**
   * 
   * @return trueThinFileInd
  **/
  @ApiModelProperty(value = "")


  public Boolean isTrueThinFileInd() {
    return trueThinFileInd;
  }

  public void setTrueThinFileInd(Boolean trueThinFileInd) {
    this.trueThinFileInd = trueThinFileInd;
  }

  public TelusBillingAccountCreditBureauResultRiskIndicator noHitThinFileInd(Boolean noHitThinFileInd) {
    this.noHitThinFileInd = noHitThinFileInd;
    return this;
  }

  /**
   * 
   * @return noHitThinFileInd
  **/
  @ApiModelProperty(value = "")


  public Boolean isNoHitThinFileInd() {
    return noHitThinFileInd;
  }

  public void setNoHitThinFileInd(Boolean noHitThinFileInd) {
    this.noHitThinFileInd = noHitThinFileInd;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelusBillingAccountCreditBureauResultRiskIndicator telusBillingAccountCreditBureauResultRiskIndicator = (TelusBillingAccountCreditBureauResultRiskIndicator) o;
    return Objects.equals(this.writeOffCd, telusBillingAccountCreditBureauResultRiskIndicator.writeOffCd) &&
        Objects.equals(this.bankcrupcyInd, telusBillingAccountCreditBureauResultRiskIndicator.bankcrupcyInd) &&
        Objects.equals(this.secondaryRiskCd, telusBillingAccountCreditBureauResultRiskIndicator.secondaryRiskCd) &&
        Objects.equals(this.temporarySinInd, telusBillingAccountCreditBureauResultRiskIndicator.temporarySinInd) &&
        Objects.equals(this.trueThinFileInd, telusBillingAccountCreditBureauResultRiskIndicator.trueThinFileInd) &&
        Objects.equals(this.noHitThinFileInd, telusBillingAccountCreditBureauResultRiskIndicator.noHitThinFileInd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(writeOffCd, bankcrupcyInd, secondaryRiskCd, temporarySinInd, trueThinFileInd, noHitThinFileInd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelusBillingAccountCreditBureauResultRiskIndicator {\n");
    
    sb.append("    writeOffCd: ").append(toIndentedString(writeOffCd)).append("\n");
    sb.append("    bankcrupcyInd: ").append(toIndentedString(bankcrupcyInd)).append("\n");
    sb.append("    secondaryRiskCd: ").append(toIndentedString(secondaryRiskCd)).append("\n");
    sb.append("    temporarySinInd: ").append(toIndentedString(temporarySinInd)).append("\n");
    sb.append("    trueThinFileInd: ").append(toIndentedString(trueThinFileInd)).append("\n");
    sb.append("    noHitThinFileInd: ").append(toIndentedString(noHitThinFileInd)).append("\n");
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

