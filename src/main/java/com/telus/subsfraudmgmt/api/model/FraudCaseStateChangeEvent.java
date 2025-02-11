package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.FraudCase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The event data structure
 */
@ApiModel(description = "The event data structure")
@Validated

public class FraudCaseStateChangeEvent   {
  @JsonProperty("service")
  private FraudCase service = null;

  public FraudCaseStateChangeEvent service(FraudCase service) {
    this.service = service;
    return this;
  }

  /**
   * The involved resource data for the event
   * @return service
  **/
  @ApiModelProperty(value = "The involved resource data for the event")

  @Valid

  public FraudCase getService() {
    return service;
  }

  public void setService(FraudCase service) {
    this.service = service;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudCaseStateChangeEvent fraudCaseStateChangeEvent = (FraudCaseStateChangeEvent) o;
    return Objects.equals(this.service, fraudCaseStateChangeEvent.service);
  }

  @Override
  public int hashCode() {
    return Objects.hash(service);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudCaseStateChangeEvent {\n");
    
    sb.append("    service: ").append(toIndentedString(service)).append("\n");
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

