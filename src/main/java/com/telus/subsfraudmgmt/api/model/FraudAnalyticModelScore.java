package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FraudAnalyticModelScore
 */
@Validated

public class FraudAnalyticModelScore   {
  @JsonProperty("modelName")
  private String modelName = null;

  @JsonProperty("scoreNumber")
  private String scoreNumber = null;

  @JsonProperty("scoreNumberReasonCodes")
  @Valid
  private List<String> scoreNumberReasonCodes = null;

  public FraudAnalyticModelScore modelName(String modelName) {
    this.modelName = modelName;
    return this;
  }

  /**
   * Get modelName
   * @return modelName
  **/
  @ApiModelProperty(value = "")


  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public FraudAnalyticModelScore scoreNumber(String scoreNumber) {
    this.scoreNumber = scoreNumber;
    return this;
  }

  /**
   * Get scoreNumber
   * @return scoreNumber
  **/
  @ApiModelProperty(value = "")


  public String getScoreNumber() {
    return scoreNumber;
  }

  public void setScoreNumber(String scoreNumber) {
    this.scoreNumber = scoreNumber;
  }

  public FraudAnalyticModelScore scoreNumberReasonCodes(List<String> scoreNumberReasonCodes) {
    this.scoreNumberReasonCodes = scoreNumberReasonCodes;
    return this;
  }

  public FraudAnalyticModelScore addScoreNumberReasonCodesItem(String scoreNumberReasonCodesItem) {
    if (this.scoreNumberReasonCodes == null) {
      this.scoreNumberReasonCodes = new ArrayList<>();
    }
    this.scoreNumberReasonCodes.add(scoreNumberReasonCodesItem);
    return this;
  }

  /**
   * Get scoreNumberReasonCodes
   * @return scoreNumberReasonCodes
  **/
  @ApiModelProperty(value = "")


  public List<String> getScoreNumberReasonCodes() {
    return scoreNumberReasonCodes;
  }

  public void setScoreNumberReasonCodes(List<String> scoreNumberReasonCodes) {
    this.scoreNumberReasonCodes = scoreNumberReasonCodes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudAnalyticModelScore fraudAnalyticModelScore = (FraudAnalyticModelScore) o;
    return Objects.equals(this.modelName, fraudAnalyticModelScore.modelName) &&
        Objects.equals(this.scoreNumber, fraudAnalyticModelScore.scoreNumber) &&
        Objects.equals(this.scoreNumberReasonCodes, fraudAnalyticModelScore.scoreNumberReasonCodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(modelName, scoreNumber, scoreNumberReasonCodes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudAnalyticModelScore {\n");
    
    sb.append("    modelName: ").append(toIndentedString(modelName)).append("\n");
    sb.append("    scoreNumber: ").append(toIndentedString(scoreNumber)).append("\n");
    sb.append("    scoreNumberReasonCodes: ").append(toIndentedString(scoreNumberReasonCodes)).append("\n");
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

