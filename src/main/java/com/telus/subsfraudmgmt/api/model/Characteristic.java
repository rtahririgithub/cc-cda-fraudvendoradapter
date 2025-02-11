package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.CharacteristicRelationship;
import com.telus.subsfraudmgmt.api.model.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Describes a given characteristic of an object or entity through a name/value pair.
 */
@ApiModel(description = "Describes a given characteristic of an object or entity through a name/value pair.")
@Validated

public class Characteristic extends Entity  {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("valueType")
  private String valueType = null;

  @JsonProperty("characteristicRelationship")
  @Valid
  private List<CharacteristicRelationship> characteristicRelationship = null;

  public Characteristic id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the characteristic
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the characteristic")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Characteristic name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the characteristic
   * @return name
  **/
  @ApiModelProperty(value = "Name of the characteristic")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Characteristic valueType(String valueType) {
    this.valueType = valueType;
    return this;
  }

  /**
   * Data type of the value of the characteristic
   * @return valueType
  **/
  @ApiModelProperty(value = "Data type of the value of the characteristic")


  public String getValueType() {
    return valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
  }

  public Characteristic characteristicRelationship(List<CharacteristicRelationship> characteristicRelationship) {
    this.characteristicRelationship = characteristicRelationship;
    return this;
  }

  public Characteristic addCharacteristicRelationshipItem(CharacteristicRelationship characteristicRelationshipItem) {
    if (this.characteristicRelationship == null) {
      this.characteristicRelationship = new ArrayList<>();
    }
    this.characteristicRelationship.add(characteristicRelationshipItem);
    return this;
  }

  /**
   * Get characteristicRelationship
   * @return characteristicRelationship
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CharacteristicRelationship> getCharacteristicRelationship() {
    return characteristicRelationship;
  }

  public void setCharacteristicRelationship(List<CharacteristicRelationship> characteristicRelationship) {
    this.characteristicRelationship = characteristicRelationship;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Characteristic characteristic = (Characteristic) o;
    return Objects.equals(this.id, characteristic.id) &&
        Objects.equals(this.name, characteristic.name) &&
        Objects.equals(this.valueType, characteristic.valueType) &&
        Objects.equals(this.characteristicRelationship, characteristic.characteristicRelationship) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, valueType, characteristicRelationship, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Characteristic {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
    sb.append("    characteristicRelationship: ").append(toIndentedString(characteristicRelationship)).append("\n");
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

