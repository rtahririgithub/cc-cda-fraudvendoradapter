package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Attachment;
import com.telus.subsfraudmgmt.api.model.Quantity;
import com.telus.subsfraudmgmt.api.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TELUS Extension to include additional properties
 */
@ApiModel(description = "TELUS Extension to include additional properties")
@Validated

public class TelusCreditBureuaAttachment extends Attachment  {
  @JsonProperty("attachmentSource")
  private String attachmentSource = null;

  public TelusCreditBureuaAttachment attachmentSource(String attachmentSource) {
    this.attachmentSource = attachmentSource;
    return this;
  }

  /**
   * describes the origin of the attachmetn. for instance a bureau report attachment source could be TU or Equifax or Telus Simulator.
   * @return attachmentSource
  **/
  @ApiModelProperty(value = "describes the origin of the attachmetn. for instance a bureau report attachment source could be TU or Equifax or Telus Simulator.")


  public String getAttachmentSource() {
    return attachmentSource;
  }

  public void setAttachmentSource(String attachmentSource) {
    this.attachmentSource = attachmentSource;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelusCreditBureuaAttachment telusCreditBureuaAttachment = (TelusCreditBureuaAttachment) o;
    return Objects.equals(this.attachmentSource, telusCreditBureuaAttachment.attachmentSource) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attachmentSource, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelusCreditBureuaAttachment {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    attachmentSource: ").append(toIndentedString(attachmentSource)).append("\n");
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

