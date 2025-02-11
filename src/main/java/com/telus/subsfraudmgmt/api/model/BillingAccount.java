package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.AccountBalance;
import com.telus.subsfraudmgmt.api.model.AccountRelationship;
import com.telus.subsfraudmgmt.api.model.AccountTaxExemption;
import com.telus.subsfraudmgmt.api.model.BillStructure;
import com.telus.subsfraudmgmt.api.model.Contact;
import com.telus.subsfraudmgmt.api.model.FinancialAccountRef;
import com.telus.subsfraudmgmt.api.model.Money;
import com.telus.subsfraudmgmt.api.model.PartyAccount;
import com.telus.subsfraudmgmt.api.model.PaymentMethodRef;
import com.telus.subsfraudmgmt.api.model.PaymentPlan;
import com.telus.subsfraudmgmt.api.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A party account used for billing purposes. It includes a description of the bill structure (frequency, presentation media, format and so on). It is a specialization of entity PartyAccount.
 */
@ApiModel(description = "A party account used for billing purposes. It includes a description of the bill structure (frequency, presentation media, format and so on). It is a specialization of entity PartyAccount.")
@Validated

public class BillingAccount extends PartyAccount  {
  @JsonProperty("ratingType")
  private String ratingType = null;

  public BillingAccount ratingType(String ratingType) {
    this.ratingType = ratingType;
    return this;
  }

  /**
   * Indicates whether the account follows a specific payment option such as prepaid or postpaid
   * @return ratingType
  **/
  @ApiModelProperty(value = "Indicates whether the account follows a specific payment option such as prepaid or postpaid")


  public String getRatingType() {
    return ratingType;
  }

  public void setRatingType(String ratingType) {
    this.ratingType = ratingType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillingAccount billingAccount = (BillingAccount) o;
    return Objects.equals(this.ratingType, billingAccount.ratingType) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ratingType, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillingAccount {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    ratingType: ").append(toIndentedString(ratingType)).append("\n");
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

