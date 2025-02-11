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
 * The channel to which the resource reference to. 
 */
@ApiModel(description = "The channel to which the resource reference to. ")
@Validated

public class Channel extends Entity  {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  public Channel href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the channel
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the channel")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Channel id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the channel
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the channel")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Channel name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the channel
   * @return name
  **/
  @ApiModelProperty(value = "Name of the channel")


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
    Channel channel = (Channel) o;
    return Objects.equals(this.href, channel.href) &&
        Objects.equals(this.id, channel.id) &&
        Objects.equals(this.name, channel.name) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, name, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Channel {\n");
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

