package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.AccountBalance;
import com.telus.subsfraudmgmt.api.model.AccountRelationship;
import com.telus.subsfraudmgmt.api.model.AccountTaxExemption;
import com.telus.subsfraudmgmt.api.model.BillStructure;
import com.telus.subsfraudmgmt.api.model.BillingAccount;
import com.telus.subsfraudmgmt.api.model.Contact;
import com.telus.subsfraudmgmt.api.model.FinancialAccountRef;
import com.telus.subsfraudmgmt.api.model.Money;
import com.telus.subsfraudmgmt.api.model.PaymentMethodRef;
import com.telus.subsfraudmgmt.api.model.PaymentPlan;
import com.telus.subsfraudmgmt.api.model.RelatedParty;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccountCreditBureauResult;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccountWarningApproval;
import com.telus.subsfraudmgmt.api.model.TelusCreditDecisioningResultReOrValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TELUS Extension to include additional properties 
 */
@ApiModel(description = "TELUS Extension to include additional properties ")
@Validated

public class TelusBillingAccount extends BillingAccount  {
  @JsonProperty("billingAccountNumber")
  private BigDecimal billingAccountNumber = null;

  @JsonProperty("accountCreationDate")
  private String accountCreationDate = null;

  @JsonProperty("brandCd")
  private String brandCd = null;

  @JsonProperty("accountTypeCd")
  private String accountTypeCd = null;

  @JsonProperty("accountSubTypeCd")
  private String accountSubTypeCd = null;

  @JsonProperty("accountStatusCd")
  private String accountStatusCd = null;

  @JsonProperty("accountStatusDate")
  private OffsetDateTime accountStatusDate = null;

  @JsonProperty("statusActivityCode")
  private String statusActivityCode = null;

  @JsonProperty("statusActivityReasonCode")
  private String statusActivityReasonCode = null;

  @JsonProperty("startServiceDate")
  private OffsetDateTime startServiceDate = null;

  @JsonProperty("accountTenureCd")
  private String accountTenureCd = null;

  @JsonProperty("homeProvince")
  private String homeProvince = null;

  @JsonProperty("dealerRepCode")
  private String dealerRepCode = null;

  @JsonProperty("pin")
  private String pin = null;

  @JsonProperty("revenueBandCd")
  private String revenueBandCd = null;

  @JsonProperty("totalProductCount")
  private BigDecimal totalProductCount = null;

  @JsonProperty("totalExistingProductCount")
  private BigDecimal totalExistingProductCount = null;

  @JsonProperty("totalRequestedProductCount")
  private BigDecimal totalRequestedProductCount = null;

  @JsonProperty("totalMatchingAccountCount")
  private BigDecimal totalMatchingAccountCount = null;

  @JsonProperty("totalProductCountForAllMatchingAccounts")
  private BigDecimal totalProductCountForAllMatchingAccounts = null;

  @JsonProperty("warningApproval")
  private TelusBillingAccountWarningApproval warningApproval = null;

  @JsonProperty("creditBureauResult")
  private TelusBillingAccountCreditBureauResult creditBureauResult = null;

  @JsonProperty("creditDecisioningResult")
  private TelusCreditDecisioningResultReOrValue creditDecisioningResult = null;

  public TelusBillingAccount billingAccountNumber(BigDecimal billingAccountNumber) {
    this.billingAccountNumber = billingAccountNumber;
    return this;
  }

  /**
   * Billing account number in Telus billing system(KB)
   * @return billingAccountNumber
  **/
  @ApiModelProperty(value = "Billing account number in Telus billing system(KB)")

  @Valid

  public BigDecimal getBillingAccountNumber() {
    return billingAccountNumber;
  }

  public void setBillingAccountNumber(BigDecimal billingAccountNumber) {
    this.billingAccountNumber = billingAccountNumber;
  }

  public TelusBillingAccount accountCreationDate(String accountCreationDate) {
    this.accountCreationDate = accountCreationDate;
    return this;
  }

  /**
   * 
   * @return accountCreationDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public String getAccountCreationDate() {
    return accountCreationDate;
  }

  public void setAccountCreationDate(String accountCreationDate) {
    this.accountCreationDate = accountCreationDate;
  }

  public TelusBillingAccount brandCd(String brandCd) {
    this.brandCd = brandCd;
    return this;
  }

  /**
   * account's brand code. TELUS, KOODO
   * @return brandCd
  **/
  @ApiModelProperty(value = "account's brand code. TELUS, KOODO")


  public String getBrandCd() {
    return brandCd;
  }

  public void setBrandCd(String brandCd) {
    this.brandCd = brandCd;
  }

  public TelusBillingAccount accountTypeCd(String accountTypeCd) {
    this.accountTypeCd = accountTypeCd;
    return this;
  }

  /**
   * 
   * @return accountTypeCd
  **/
  @ApiModelProperty(value = "")


  public String getAccountTypeCd() {
    return accountTypeCd;
  }

  public void setAccountTypeCd(String accountTypeCd) {
    this.accountTypeCd = accountTypeCd;
  }

  public TelusBillingAccount accountSubTypeCd(String accountSubTypeCd) {
    this.accountSubTypeCd = accountSubTypeCd;
    return this;
  }

  /**
   * 
   * @return accountSubTypeCd
  **/
  @ApiModelProperty(value = "")


  public String getAccountSubTypeCd() {
    return accountSubTypeCd;
  }

  public void setAccountSubTypeCd(String accountSubTypeCd) {
    this.accountSubTypeCd = accountSubTypeCd;
  }

  public TelusBillingAccount accountStatusCd(String accountStatusCd) {
    this.accountStatusCd = accountStatusCd;
    return this;
  }

  /**
   * 
   * @return accountStatusCd
  **/
  @ApiModelProperty(value = "")


  public String getAccountStatusCd() {
    return accountStatusCd;
  }

  public void setAccountStatusCd(String accountStatusCd) {
    this.accountStatusCd = accountStatusCd;
  }

  public TelusBillingAccount accountStatusDate(OffsetDateTime accountStatusDate) {
    this.accountStatusDate = accountStatusDate;
    return this;
  }

  /**
   * 
   * @return accountStatusDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getAccountStatusDate() {
    return accountStatusDate;
  }

  public void setAccountStatusDate(OffsetDateTime accountStatusDate) {
    this.accountStatusDate = accountStatusDate;
  }

  public TelusBillingAccount statusActivityCode(String statusActivityCode) {
    this.statusActivityCode = statusActivityCode;
    return this;
  }

  /**
   * 
   * @return statusActivityCode
  **/
  @ApiModelProperty(value = "")


  public String getStatusActivityCode() {
    return statusActivityCode;
  }

  public void setStatusActivityCode(String statusActivityCode) {
    this.statusActivityCode = statusActivityCode;
  }

  public TelusBillingAccount statusActivityReasonCode(String statusActivityReasonCode) {
    this.statusActivityReasonCode = statusActivityReasonCode;
    return this;
  }

  /**
   * 
   * @return statusActivityReasonCode
  **/
  @ApiModelProperty(value = "")


  public String getStatusActivityReasonCode() {
    return statusActivityReasonCode;
  }

  public void setStatusActivityReasonCode(String statusActivityReasonCode) {
    this.statusActivityReasonCode = statusActivityReasonCode;
  }

  public TelusBillingAccount startServiceDate(OffsetDateTime startServiceDate) {
    this.startServiceDate = startServiceDate;
    return this;
  }

  /**
   * 
   * @return startServiceDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getStartServiceDate() {
    return startServiceDate;
  }

  public void setStartServiceDate(OffsetDateTime startServiceDate) {
    this.startServiceDate = startServiceDate;
  }

  public TelusBillingAccount accountTenureCd(String accountTenureCd) {
    this.accountTenureCd = accountTenureCd;
    return this;
  }

  /**
   * 
   * @return accountTenureCd
  **/
  @ApiModelProperty(value = "")


  public String getAccountTenureCd() {
    return accountTenureCd;
  }

  public void setAccountTenureCd(String accountTenureCd) {
    this.accountTenureCd = accountTenureCd;
  }

  public TelusBillingAccount homeProvince(String homeProvince) {
    this.homeProvince = homeProvince;
    return this;
  }

  /**
   * 
   * @return homeProvince
  **/
  @ApiModelProperty(value = "")


  public String getHomeProvince() {
    return homeProvince;
  }

  public void setHomeProvince(String homeProvince) {
    this.homeProvince = homeProvince;
  }

  public TelusBillingAccount dealerRepCode(String dealerRepCode) {
    this.dealerRepCode = dealerRepCode;
    return this;
  }

  /**
   * 
   * @return dealerRepCode
  **/
  @ApiModelProperty(value = "")


  public String getDealerRepCode() {
    return dealerRepCode;
  }

  public void setDealerRepCode(String dealerRepCode) {
    this.dealerRepCode = dealerRepCode;
  }

  public TelusBillingAccount pin(String pin) {
    this.pin = pin;
    return this;
  }

  /**
   * account pin or password
   * @return pin
  **/
  @ApiModelProperty(value = "account pin or password")


  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public TelusBillingAccount revenueBandCd(String revenueBandCd) {
    this.revenueBandCd = revenueBandCd;
    return this;
  }

  /**
   * 
   * @return revenueBandCd
  **/
  @ApiModelProperty(value = "")


  public String getRevenueBandCd() {
    return revenueBandCd;
  }

  public void setRevenueBandCd(String revenueBandCd) {
    this.revenueBandCd = revenueBandCd;
  }

  public TelusBillingAccount totalProductCount(BigDecimal totalProductCount) {
    this.totalProductCount = totalProductCount;
    return this;
  }

  /**
   * 
   * @return totalProductCount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getTotalProductCount() {
    return totalProductCount;
  }

  public void setTotalProductCount(BigDecimal totalProductCount) {
    this.totalProductCount = totalProductCount;
  }

  public TelusBillingAccount totalExistingProductCount(BigDecimal totalExistingProductCount) {
    this.totalExistingProductCount = totalExistingProductCount;
    return this;
  }

  /**
   * 
   * @return totalExistingProductCount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getTotalExistingProductCount() {
    return totalExistingProductCount;
  }

  public void setTotalExistingProductCount(BigDecimal totalExistingProductCount) {
    this.totalExistingProductCount = totalExistingProductCount;
  }

  public TelusBillingAccount totalRequestedProductCount(BigDecimal totalRequestedProductCount) {
    this.totalRequestedProductCount = totalRequestedProductCount;
    return this;
  }

  /**
   * 
   * @return totalRequestedProductCount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getTotalRequestedProductCount() {
    return totalRequestedProductCount;
  }

  public void setTotalRequestedProductCount(BigDecimal totalRequestedProductCount) {
    this.totalRequestedProductCount = totalRequestedProductCount;
  }

  public TelusBillingAccount totalMatchingAccountCount(BigDecimal totalMatchingAccountCount) {
    this.totalMatchingAccountCount = totalMatchingAccountCount;
    return this;
  }

  /**
   * 
   * @return totalMatchingAccountCount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getTotalMatchingAccountCount() {
    return totalMatchingAccountCount;
  }

  public void setTotalMatchingAccountCount(BigDecimal totalMatchingAccountCount) {
    this.totalMatchingAccountCount = totalMatchingAccountCount;
  }

  public TelusBillingAccount totalProductCountForAllMatchingAccounts(BigDecimal totalProductCountForAllMatchingAccounts) {
    this.totalProductCountForAllMatchingAccounts = totalProductCountForAllMatchingAccounts;
    return this;
  }

  /**
   * 
   * @return totalProductCountForAllMatchingAccounts
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getTotalProductCountForAllMatchingAccounts() {
    return totalProductCountForAllMatchingAccounts;
  }

  public void setTotalProductCountForAllMatchingAccounts(BigDecimal totalProductCountForAllMatchingAccounts) {
    this.totalProductCountForAllMatchingAccounts = totalProductCountForAllMatchingAccounts;
  }

  public TelusBillingAccount warningApproval(TelusBillingAccountWarningApproval warningApproval) {
    this.warningApproval = warningApproval;
    return this;
  }

  /**
   * Get warningApproval
   * @return warningApproval
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TelusBillingAccountWarningApproval getWarningApproval() {
    return warningApproval;
  }

  public void setWarningApproval(TelusBillingAccountWarningApproval warningApproval) {
    this.warningApproval = warningApproval;
  }

  public TelusBillingAccount creditBureauResult(TelusBillingAccountCreditBureauResult creditBureauResult) {
    this.creditBureauResult = creditBureauResult;
    return this;
  }

  /**
   * Get creditBureauResult
   * @return creditBureauResult
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TelusBillingAccountCreditBureauResult getCreditBureauResult() {
    return creditBureauResult;
  }

  public void setCreditBureauResult(TelusBillingAccountCreditBureauResult creditBureauResult) {
    this.creditBureauResult = creditBureauResult;
  }

  public TelusBillingAccount creditDecisioningResult(TelusCreditDecisioningResultReOrValue creditDecisioningResult) {
    this.creditDecisioningResult = creditDecisioningResult;
    return this;
  }

  /**
   * Get creditDecisioningResult
   * @return creditDecisioningResult
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TelusCreditDecisioningResultReOrValue getCreditDecisioningResult() {
    return creditDecisioningResult;
  }

  public void setCreditDecisioningResult(TelusCreditDecisioningResultReOrValue creditDecisioningResult) {
    this.creditDecisioningResult = creditDecisioningResult;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelusBillingAccount telusBillingAccount = (TelusBillingAccount) o;
    return Objects.equals(this.billingAccountNumber, telusBillingAccount.billingAccountNumber) &&
        Objects.equals(this.accountCreationDate, telusBillingAccount.accountCreationDate) &&
        Objects.equals(this.brandCd, telusBillingAccount.brandCd) &&
        Objects.equals(this.accountTypeCd, telusBillingAccount.accountTypeCd) &&
        Objects.equals(this.accountSubTypeCd, telusBillingAccount.accountSubTypeCd) &&
        Objects.equals(this.accountStatusCd, telusBillingAccount.accountStatusCd) &&
        Objects.equals(this.accountStatusDate, telusBillingAccount.accountStatusDate) &&
        Objects.equals(this.statusActivityCode, telusBillingAccount.statusActivityCode) &&
        Objects.equals(this.statusActivityReasonCode, telusBillingAccount.statusActivityReasonCode) &&
        Objects.equals(this.startServiceDate, telusBillingAccount.startServiceDate) &&
        Objects.equals(this.accountTenureCd, telusBillingAccount.accountTenureCd) &&
        Objects.equals(this.homeProvince, telusBillingAccount.homeProvince) &&
        Objects.equals(this.dealerRepCode, telusBillingAccount.dealerRepCode) &&
        Objects.equals(this.pin, telusBillingAccount.pin) &&
        Objects.equals(this.revenueBandCd, telusBillingAccount.revenueBandCd) &&
        Objects.equals(this.totalProductCount, telusBillingAccount.totalProductCount) &&
        Objects.equals(this.totalExistingProductCount, telusBillingAccount.totalExistingProductCount) &&
        Objects.equals(this.totalRequestedProductCount, telusBillingAccount.totalRequestedProductCount) &&
        Objects.equals(this.totalMatchingAccountCount, telusBillingAccount.totalMatchingAccountCount) &&
        Objects.equals(this.totalProductCountForAllMatchingAccounts, telusBillingAccount.totalProductCountForAllMatchingAccounts) &&
        Objects.equals(this.warningApproval, telusBillingAccount.warningApproval) &&
        Objects.equals(this.creditBureauResult, telusBillingAccount.creditBureauResult) &&
        Objects.equals(this.creditDecisioningResult, telusBillingAccount.creditDecisioningResult) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(billingAccountNumber, accountCreationDate, brandCd, accountTypeCd, accountSubTypeCd, accountStatusCd, accountStatusDate, statusActivityCode, statusActivityReasonCode, startServiceDate, accountTenureCd, homeProvince, dealerRepCode, pin, revenueBandCd, totalProductCount, totalExistingProductCount, totalRequestedProductCount, totalMatchingAccountCount, totalProductCountForAllMatchingAccounts, warningApproval, creditBureauResult, creditDecisioningResult, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelusBillingAccount {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    billingAccountNumber: ").append(toIndentedString(billingAccountNumber)).append("\n");
    sb.append("    accountCreationDate: ").append(toIndentedString(accountCreationDate)).append("\n");
    sb.append("    brandCd: ").append(toIndentedString(brandCd)).append("\n");
    sb.append("    accountTypeCd: ").append(toIndentedString(accountTypeCd)).append("\n");
    sb.append("    accountSubTypeCd: ").append(toIndentedString(accountSubTypeCd)).append("\n");
    sb.append("    accountStatusCd: ").append(toIndentedString(accountStatusCd)).append("\n");
    sb.append("    accountStatusDate: ").append(toIndentedString(accountStatusDate)).append("\n");
    sb.append("    statusActivityCode: ").append(toIndentedString(statusActivityCode)).append("\n");
    sb.append("    statusActivityReasonCode: ").append(toIndentedString(statusActivityReasonCode)).append("\n");
    sb.append("    startServiceDate: ").append(toIndentedString(startServiceDate)).append("\n");
    sb.append("    accountTenureCd: ").append(toIndentedString(accountTenureCd)).append("\n");
    sb.append("    homeProvince: ").append(toIndentedString(homeProvince)).append("\n");
    sb.append("    dealerRepCode: ").append(toIndentedString(dealerRepCode)).append("\n");
    sb.append("    pin: ").append(toIndentedString(pin)).append("\n");
    sb.append("    revenueBandCd: ").append(toIndentedString(revenueBandCd)).append("\n");
    sb.append("    totalProductCount: ").append(toIndentedString(totalProductCount)).append("\n");
    sb.append("    totalExistingProductCount: ").append(toIndentedString(totalExistingProductCount)).append("\n");
    sb.append("    totalRequestedProductCount: ").append(toIndentedString(totalRequestedProductCount)).append("\n");
    sb.append("    totalMatchingAccountCount: ").append(toIndentedString(totalMatchingAccountCount)).append("\n");
    sb.append("    totalProductCountForAllMatchingAccounts: ").append(toIndentedString(totalProductCountForAllMatchingAccounts)).append("\n");
    sb.append("    warningApproval: ").append(toIndentedString(warningApproval)).append("\n");
    sb.append("    creditBureauResult: ").append(toIndentedString(creditBureauResult)).append("\n");
    sb.append("    creditDecisioningResult: ").append(toIndentedString(creditDecisioningResult)).append("\n");
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

