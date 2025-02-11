package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.AttachmentRefOrValue;
import com.telus.subsfraudmgmt.api.model.IndividualIdentification;
import com.telus.subsfraudmgmt.api.model.StringCharacteristic;
import com.telus.subsfraudmgmt.api.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TELUS Extension to include additional properties
 */
@ApiModel(description = "TELUS Extension to include additional properties")
@Validated

public class TelusIndividualIdentification extends IndividualIdentification  {
  @JsonProperty("characteristic")
  @Valid
  private List<StringCharacteristic> characteristic = null;

  public TelusIndividualIdentification characteristic(List<StringCharacteristic> characteristic) {
    this.characteristic = characteristic;
    return this;
  }

  public TelusIndividualIdentification addCharacteristicItem(StringCharacteristic characteristicItem) {
    if (this.characteristic == null) {
      this.characteristic = new ArrayList<>();
    }
    this.characteristic.add(characteristicItem);
    return this;
  }

  /**
   * Describes the characteristic of a customer.
   * @return characteristic
  **/
  @ApiModelProperty(value = "Describes the characteristic of a customer.")

  @Valid

  public List<StringCharacteristic> getCharacteristic() {
    return characteristic;
  }

  public void setCharacteristic(List<StringCharacteristic> characteristic) {
    this.characteristic = characteristic;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelusIndividualIdentification telusIndividualIdentification = (TelusIndividualIdentification) o;
    return Objects.equals(this.characteristic, telusIndividualIdentification.characteristic) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(characteristic, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelusIndividualIdentification {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
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

