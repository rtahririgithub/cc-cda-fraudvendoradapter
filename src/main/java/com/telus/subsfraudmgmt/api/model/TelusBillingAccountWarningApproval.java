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
 * TelusBillingAccountWarningApproval
 */
@Validated

public class TelusBillingAccountWarningApproval   {
  @JsonProperty("approvalExistInd")
  private Boolean approvalExistInd = null;

  @JsonProperty("approvalDate")
  private OffsetDateTime approvalDate = null;

  public TelusBillingAccountWarningApproval approvalExistInd(Boolean approvalExistInd) {
    this.approvalExistInd = approvalExistInd;
    return this;
  }

  /**
   * 
   * @return approvalExistInd
  **/
  @ApiModelProperty(value = "")


  public Boolean isApprovalExistInd() {
    return approvalExistInd;
  }

  public void setApprovalExistInd(Boolean approvalExistInd) {
    this.approvalExistInd = approvalExistInd;
  }

  public TelusBillingAccountWarningApproval approvalDate(OffsetDateTime approvalDate) {
    this.approvalDate = approvalDate;
    return this;
  }

  /**
   * Time agent issued the approval to discard any warning.
   * @return approvalDate
  **/
  @ApiModelProperty(value = "Time agent issued the approval to discard any warning.")

  @Valid

  public OffsetDateTime getApprovalDate() {
    return approvalDate;
  }

  public void setApprovalDate(OffsetDateTime approvalDate) {
    this.approvalDate = approvalDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelusBillingAccountWarningApproval telusBillingAccountWarningApproval = (TelusBillingAccountWarningApproval) o;
    return Objects.equals(this.approvalExistInd, telusBillingAccountWarningApproval.approvalExistInd) &&
        Objects.equals(this.approvalDate, telusBillingAccountWarningApproval.approvalDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(approvalExistInd, approvalDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelusBillingAccountWarningApproval {\n");
    
    sb.append("    approvalExistInd: ").append(toIndentedString(approvalExistInd)).append("\n");
    sb.append("    approvalDate: ").append(toIndentedString(approvalDate)).append("\n");
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

