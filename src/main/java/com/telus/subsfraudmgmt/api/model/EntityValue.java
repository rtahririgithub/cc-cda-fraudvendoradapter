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
 * Base entity value  schema for use in TMForum Open-APIs
 */
@ApiModel(description = "Base entity value  schema for use in TMForum Open-APIs")
@Validated

public class EntityValue extends Entity  {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  public EntityValue id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of a related entity.
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of a related entity.")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public EntityValue href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the related entity.
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the related entity.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntityValue entityValue = (EntityValue) o;
    return Objects.equals(this.id, entityValue.id) &&
        Objects.equals(this.href, entityValue.href) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntityValue {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
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

