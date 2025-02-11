package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.IndividualRefOrValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * fraudster( individual identified as a fraudster)
 */
@ApiModel(description = "fraudster( individual identified as a fraudster)")
@Validated

public class Fraudster   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("externalApplicationId")
  private String externalApplicationId = null;

  @JsonProperty("individual")
  private IndividualRefOrValue individual = null;

  public Fraudster id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier 
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier ")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Fraudster href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Unique reference 
   * @return href
  **/
  @ApiModelProperty(value = "Unique reference ")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Fraudster externalApplicationId(String externalApplicationId) {
    this.externalApplicationId = externalApplicationId;
    return this;
  }

  /**
   * Get externalApplicationId
   * @return externalApplicationId
  **/
  @ApiModelProperty(value = "")


  public String getExternalApplicationId() {
    return externalApplicationId;
  }

  public void setExternalApplicationId(String externalApplicationId) {
    this.externalApplicationId = externalApplicationId;
  }

  public Fraudster individual(IndividualRefOrValue individual) {
    this.individual = individual;
    return this;
  }

  /**
   * The party - an organization or an individual - that is engaged as a customer.
   * @return individual
  **/
  @ApiModelProperty(value = "The party - an organization or an individual - that is engaged as a customer.")

  @Valid

  public IndividualRefOrValue getIndividual() {
    return individual;
  }

  public void setIndividual(IndividualRefOrValue individual) {
    this.individual = individual;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fraudster fraudster = (Fraudster) o;
    return Objects.equals(this.id, fraudster.id) &&
        Objects.equals(this.href, fraudster.href) &&
        Objects.equals(this.externalApplicationId, fraudster.externalApplicationId) &&
        Objects.equals(this.individual, fraudster.individual);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, externalApplicationId, individual);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fraudster {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    externalApplicationId: ").append(toIndentedString(externalApplicationId)).append("\n");
    sb.append("    individual: ").append(toIndentedString(individual)).append("\n");
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

