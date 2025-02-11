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
 * FraudDecisionMatchingRulesFiredMatches
 */
@Validated

public class FraudDecisionMatchingRulesFiredMatches   {
  @JsonProperty("matchId")
  private String matchId = null;

  @JsonProperty("ruleId")
  private String ruleId = null;

  @JsonProperty("source")
  private String source = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("score")
  private String score = null;

  public FraudDecisionMatchingRulesFiredMatches matchId(String matchId) {
    this.matchId = matchId;
    return this;
  }

  /**
   * 
   * @return matchId
  **/
  @ApiModelProperty(value = "")


  public String getMatchId() {
    return matchId;
  }

  public void setMatchId(String matchId) {
    this.matchId = matchId;
  }

  public FraudDecisionMatchingRulesFiredMatches ruleId(String ruleId) {
    this.ruleId = ruleId;
    return this;
  }

  /**
   * 
   * @return ruleId
  **/
  @ApiModelProperty(value = "")


  public String getRuleId() {
    return ruleId;
  }

  public void setRuleId(String ruleId) {
    this.ruleId = ruleId;
  }

  public FraudDecisionMatchingRulesFiredMatches source(String source) {
    this.source = source;
    return this;
  }

  /**
   * 
   * @return source
  **/
  @ApiModelProperty(value = "")


  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public FraudDecisionMatchingRulesFiredMatches type(String type) {
    this.type = type;
    return this;
  }

  /**
   * 
   * @return type
  **/
  @ApiModelProperty(value = "")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public FraudDecisionMatchingRulesFiredMatches score(String score) {
    this.score = score;
    return this;
  }

  /**
   * 
   * @return score
  **/
  @ApiModelProperty(value = "")


  public String getScore() {
    return score;
  }

  public void setScore(String score) {
    this.score = score;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudDecisionMatchingRulesFiredMatches fraudDecisionMatchingRulesFiredMatches = (FraudDecisionMatchingRulesFiredMatches) o;
    return Objects.equals(this.matchId, fraudDecisionMatchingRulesFiredMatches.matchId) &&
        Objects.equals(this.ruleId, fraudDecisionMatchingRulesFiredMatches.ruleId) &&
        Objects.equals(this.source, fraudDecisionMatchingRulesFiredMatches.source) &&
        Objects.equals(this.type, fraudDecisionMatchingRulesFiredMatches.type) &&
        Objects.equals(this.score, fraudDecisionMatchingRulesFiredMatches.score);
  }

  @Override
  public int hashCode() {
    return Objects.hash(matchId, ruleId, source, type, score);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudDecisionMatchingRulesFiredMatches {\n");
    
    sb.append("    matchId: ").append(toIndentedString(matchId)).append("\n");
    sb.append("    ruleId: ").append(toIndentedString(ruleId)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
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

