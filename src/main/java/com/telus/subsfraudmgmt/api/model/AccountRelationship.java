package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.AccountRefOrValue;
import com.telus.subsfraudmgmt.api.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Significant connection between accounts. For instance an aggregating account for a list of shop branches each having its own billing account.
 */
@ApiModel(description = "Significant connection between accounts. For instance an aggregating account for a list of shop branches each having its own billing account.")
@Validated

public class AccountRelationship   {
  @JsonProperty("relationshipType")
  private String relationshipType = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("account")
  private AccountRefOrValue account = null;

  public AccountRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * Type of relationship
   * @return relationshipType
  **/
  @ApiModelProperty(required = true, value = "Type of relationship")
  @NotNull


  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public AccountRelationship validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Validity period of that relationship
   * @return validFor
  **/
  @ApiModelProperty(required = true, value = "Validity period of that relationship")
  @NotNull

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public AccountRelationship account(AccountRefOrValue account) {
    this.account = account;
    return this;
  }

  /**
   * Get account
   * @return account
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountRefOrValue getAccount() {
    return account;
  }

  public void setAccount(AccountRefOrValue account) {
    this.account = account;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountRelationship accountRelationship = (AccountRelationship) o;
    return Objects.equals(this.relationshipType, accountRelationship.relationshipType) &&
        Objects.equals(this.validFor, accountRelationship.validFor) &&
        Objects.equals(this.account, accountRelationship.account);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relationshipType, validFor, account);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountRelationship {\n");
    
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
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

