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
 * FraudDecisionMatchingRulesFiredSearchConditions
 */
@Validated

public class FraudDecisionMatchingRulesFiredSearchConditions   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("attribute")
  private String attribute = null;

  @JsonProperty("searchType")
  private String searchType = null;

  @JsonProperty("comparisonType")
  private String comparisonType = null;

  @JsonProperty("valueType")
  private String valueType = null;

  @JsonProperty("similarityThreshold")
  private String similarityThreshold = null;

  @JsonProperty("applicationScope")
  private String applicationScope = null;

  @JsonProperty("valueCompared")
  private String valueCompared = null;

  @JsonProperty("from")
  private String from = null;

  @JsonProperty("to")
  private String to = null;

  @JsonProperty("searchConditionType")
  private String searchConditionType = null;

  public FraudDecisionMatchingRulesFiredSearchConditions id(String id) {
    this.id = id;
    return this;
  }

  /**
   * 
   * @return id
  **/
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FraudDecisionMatchingRulesFiredSearchConditions attribute(String attribute) {
    this.attribute = attribute;
    return this;
  }

  /**
   * 
   * @return attribute
  **/
  @ApiModelProperty(value = "")


  public String getAttribute() {
    return attribute;
  }

  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }

  public FraudDecisionMatchingRulesFiredSearchConditions searchType(String searchType) {
    this.searchType = searchType;
    return this;
  }

  /**
   * 
   * @return searchType
  **/
  @ApiModelProperty(value = "")


  public String getSearchType() {
    return searchType;
  }

  public void setSearchType(String searchType) {
    this.searchType = searchType;
  }

  public FraudDecisionMatchingRulesFiredSearchConditions comparisonType(String comparisonType) {
    this.comparisonType = comparisonType;
    return this;
  }

  /**
   * 
   * @return comparisonType
  **/
  @ApiModelProperty(value = "")


  public String getComparisonType() {
    return comparisonType;
  }

  public void setComparisonType(String comparisonType) {
    this.comparisonType = comparisonType;
  }

  public FraudDecisionMatchingRulesFiredSearchConditions valueType(String valueType) {
    this.valueType = valueType;
    return this;
  }

  /**
   * 
   * @return valueType
  **/
  @ApiModelProperty(value = "")


  public String getValueType() {
    return valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
  }

  public FraudDecisionMatchingRulesFiredSearchConditions similarityThreshold(String similarityThreshold) {
    this.similarityThreshold = similarityThreshold;
    return this;
  }

  /**
   * 
   * @return similarityThreshold
  **/
  @ApiModelProperty(value = "")


  public String getSimilarityThreshold() {
    return similarityThreshold;
  }

  public void setSimilarityThreshold(String similarityThreshold) {
    this.similarityThreshold = similarityThreshold;
  }

  public FraudDecisionMatchingRulesFiredSearchConditions applicationScope(String applicationScope) {
    this.applicationScope = applicationScope;
    return this;
  }

  /**
   * 
   * @return applicationScope
  **/
  @ApiModelProperty(value = "")


  public String getApplicationScope() {
    return applicationScope;
  }

  public void setApplicationScope(String applicationScope) {
    this.applicationScope = applicationScope;
  }

  public FraudDecisionMatchingRulesFiredSearchConditions valueCompared(String valueCompared) {
    this.valueCompared = valueCompared;
    return this;
  }

  /**
   * 
   * @return valueCompared
  **/
  @ApiModelProperty(value = "")


  public String getValueCompared() {
    return valueCompared;
  }

  public void setValueCompared(String valueCompared) {
    this.valueCompared = valueCompared;
  }

  public FraudDecisionMatchingRulesFiredSearchConditions from(String from) {
    this.from = from;
    return this;
  }

  /**
   * 
   * @return from
  **/
  @ApiModelProperty(value = "")


  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public FraudDecisionMatchingRulesFiredSearchConditions to(String to) {
    this.to = to;
    return this;
  }

  /**
   * 
   * @return to
  **/
  @ApiModelProperty(value = "")


  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public FraudDecisionMatchingRulesFiredSearchConditions searchConditionType(String searchConditionType) {
    this.searchConditionType = searchConditionType;
    return this;
  }

  /**
   * 
   * @return searchConditionType
  **/
  @ApiModelProperty(value = "")


  public String getSearchConditionType() {
    return searchConditionType;
  }

  public void setSearchConditionType(String searchConditionType) {
    this.searchConditionType = searchConditionType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudDecisionMatchingRulesFiredSearchConditions fraudDecisionMatchingRulesFiredSearchConditions = (FraudDecisionMatchingRulesFiredSearchConditions) o;
    return Objects.equals(this.id, fraudDecisionMatchingRulesFiredSearchConditions.id) &&
        Objects.equals(this.attribute, fraudDecisionMatchingRulesFiredSearchConditions.attribute) &&
        Objects.equals(this.searchType, fraudDecisionMatchingRulesFiredSearchConditions.searchType) &&
        Objects.equals(this.comparisonType, fraudDecisionMatchingRulesFiredSearchConditions.comparisonType) &&
        Objects.equals(this.valueType, fraudDecisionMatchingRulesFiredSearchConditions.valueType) &&
        Objects.equals(this.similarityThreshold, fraudDecisionMatchingRulesFiredSearchConditions.similarityThreshold) &&
        Objects.equals(this.applicationScope, fraudDecisionMatchingRulesFiredSearchConditions.applicationScope) &&
        Objects.equals(this.valueCompared, fraudDecisionMatchingRulesFiredSearchConditions.valueCompared) &&
        Objects.equals(this.from, fraudDecisionMatchingRulesFiredSearchConditions.from) &&
        Objects.equals(this.to, fraudDecisionMatchingRulesFiredSearchConditions.to) &&
        Objects.equals(this.searchConditionType, fraudDecisionMatchingRulesFiredSearchConditions.searchConditionType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, attribute, searchType, comparisonType, valueType, similarityThreshold, applicationScope, valueCompared, from, to, searchConditionType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudDecisionMatchingRulesFiredSearchConditions {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    attribute: ").append(toIndentedString(attribute)).append("\n");
    sb.append("    searchType: ").append(toIndentedString(searchType)).append("\n");
    sb.append("    comparisonType: ").append(toIndentedString(comparisonType)).append("\n");
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
    sb.append("    similarityThreshold: ").append(toIndentedString(similarityThreshold)).append("\n");
    sb.append("    applicationScope: ").append(toIndentedString(applicationScope)).append("\n");
    sb.append("    valueCompared: ").append(toIndentedString(valueCompared)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    searchConditionType: ").append(toIndentedString(searchConditionType)).append("\n");
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

