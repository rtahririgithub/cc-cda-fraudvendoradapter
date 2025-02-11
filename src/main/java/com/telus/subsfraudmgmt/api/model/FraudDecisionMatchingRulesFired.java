package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.FraudDecisionMatchingRulesFiredMatches;
import com.telus.subsfraudmgmt.api.model.FraudDecisionMatchingRulesFiredSearchConditions;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Matching Rules Fired
 */
@ApiModel(description = "Matching Rules Fired")
@Validated

public class FraudDecisionMatchingRulesFired   {
  @JsonProperty("ruleID")
  private String ruleID = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("decision")
  private String decision = null;

  @JsonProperty("query")
  private String query = null;

  @JsonProperty("searchConditions")
  @Valid
  private List<FraudDecisionMatchingRulesFiredSearchConditions> searchConditions = null;

  @JsonProperty("matches")
  @Valid
  private List<FraudDecisionMatchingRulesFiredMatches> matches = null;

  public FraudDecisionMatchingRulesFired ruleID(String ruleID) {
    this.ruleID = ruleID;
    return this;
  }

  /**
   * Get ruleID
   * @return ruleID
  **/
  @ApiModelProperty(value = "")


  public String getRuleID() {
    return ruleID;
  }

  public void setRuleID(String ruleID) {
    this.ruleID = ruleID;
  }

  public FraudDecisionMatchingRulesFired description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public FraudDecisionMatchingRulesFired decision(String decision) {
    this.decision = decision;
    return this;
  }

  /**
   * Get decision
   * @return decision
  **/
  @ApiModelProperty(value = "")


  public String getDecision() {
    return decision;
  }

  public void setDecision(String decision) {
    this.decision = decision;
  }

  public FraudDecisionMatchingRulesFired query(String query) {
    this.query = query;
    return this;
  }

  /**
   * Get query
   * @return query
  **/
  @ApiModelProperty(value = "")


  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public FraudDecisionMatchingRulesFired searchConditions(List<FraudDecisionMatchingRulesFiredSearchConditions> searchConditions) {
    this.searchConditions = searchConditions;
    return this;
  }

  public FraudDecisionMatchingRulesFired addSearchConditionsItem(FraudDecisionMatchingRulesFiredSearchConditions searchConditionsItem) {
    if (this.searchConditions == null) {
      this.searchConditions = new ArrayList<>();
    }
    this.searchConditions.add(searchConditionsItem);
    return this;
  }

  /**
   * Get searchConditions
   * @return searchConditions
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<FraudDecisionMatchingRulesFiredSearchConditions> getSearchConditions() {
    return searchConditions;
  }

  public void setSearchConditions(List<FraudDecisionMatchingRulesFiredSearchConditions> searchConditions) {
    this.searchConditions = searchConditions;
  }

  public FraudDecisionMatchingRulesFired matches(List<FraudDecisionMatchingRulesFiredMatches> matches) {
    this.matches = matches;
    return this;
  }

  public FraudDecisionMatchingRulesFired addMatchesItem(FraudDecisionMatchingRulesFiredMatches matchesItem) {
    if (this.matches == null) {
      this.matches = new ArrayList<>();
    }
    this.matches.add(matchesItem);
    return this;
  }

  /**
   * Get matches
   * @return matches
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<FraudDecisionMatchingRulesFiredMatches> getMatches() {
    return matches;
  }

  public void setMatches(List<FraudDecisionMatchingRulesFiredMatches> matches) {
    this.matches = matches;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudDecisionMatchingRulesFired fraudDecisionMatchingRulesFired = (FraudDecisionMatchingRulesFired) o;
    return Objects.equals(this.ruleID, fraudDecisionMatchingRulesFired.ruleID) &&
        Objects.equals(this.description, fraudDecisionMatchingRulesFired.description) &&
        Objects.equals(this.decision, fraudDecisionMatchingRulesFired.decision) &&
        Objects.equals(this.query, fraudDecisionMatchingRulesFired.query) &&
        Objects.equals(this.searchConditions, fraudDecisionMatchingRulesFired.searchConditions) &&
        Objects.equals(this.matches, fraudDecisionMatchingRulesFired.matches);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ruleID, description, decision, query, searchConditions, matches);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudDecisionMatchingRulesFired {\n");
    
    sb.append("    ruleID: ").append(toIndentedString(ruleID)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    decision: ").append(toIndentedString(decision)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    searchConditions: ").append(toIndentedString(searchConditions)).append("\n");
    sb.append("    matches: ").append(toIndentedString(matches)).append("\n");
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

