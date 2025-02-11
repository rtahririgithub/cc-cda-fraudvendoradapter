package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Place reference. Place defines the places where the products are sold or delivered.
 */
@ApiModel(description = "Place reference. Place defines the places where the products are sold or delivered.")
@Validated

public class Place extends Entity  {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  public Place href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Unique reference of the place
   * @return href
  **/
  @ApiModelProperty(value = "Unique reference of the place")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Place id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the place
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the place")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Place name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A user-friendly name for the place, such as [Paris Store], [London Store], [Main Home]
   * @return name
  **/
  @ApiModelProperty(value = "A user-friendly name for the place, such as [Paris Store], [London Store], [Main Home]")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Place place = (Place) o;
    return Objects.equals(this.href, place.href) &&
        Objects.equals(this.id, place.id) &&
        Objects.equals(this.name, place.name) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, name, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Place {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

