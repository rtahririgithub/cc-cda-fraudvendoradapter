package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Channel;
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

public class TelusChannel extends Channel  {
  @JsonProperty("originatorApplicationId")
  private String originatorApplicationId = null;

  @JsonProperty("channelOrganizationId")
  private String channelOrganizationId = null;

  @JsonProperty("userid")
  private String userid = null;

  @JsonProperty("channelTypeCd")
  private String channelTypeCd = null;

  @JsonProperty("salesRepCd")
  private String salesRepCd = null;

  @JsonProperty("dealerCode")
  private String dealerCode = null;

  public TelusChannel originatorApplicationId(String originatorApplicationId) {
    this.originatorApplicationId = originatorApplicationId;
    return this;
  }

  /**
   * 
   * @return originatorApplicationId
  **/
  @ApiModelProperty(value = "")


  public String getOriginatorApplicationId() {
    return originatorApplicationId;
  }

  public void setOriginatorApplicationId(String originatorApplicationId) {
    this.originatorApplicationId = originatorApplicationId;
  }

  public TelusChannel channelOrganizationId(String channelOrganizationId) {
    this.channelOrganizationId = channelOrganizationId;
    return this;
  }

  /**
   * 
   * @return channelOrganizationId
  **/
  @ApiModelProperty(value = "")


  public String getChannelOrganizationId() {
    return channelOrganizationId;
  }

  public void setChannelOrganizationId(String channelOrganizationId) {
    this.channelOrganizationId = channelOrganizationId;
  }

  public TelusChannel userid(String userid) {
    this.userid = userid;
    return this;
  }

  /**
   * 
   * @return userid
  **/
  @ApiModelProperty(value = "")


  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public TelusChannel channelTypeCd(String channelTypeCd) {
    this.channelTypeCd = channelTypeCd;
    return this;
  }

  /**
   * channel by which the application was initiated.
   * @return channelTypeCd
  **/
  @ApiModelProperty(value = "channel by which the application was initiated.")


  public String getChannelTypeCd() {
    return channelTypeCd;
  }

  public void setChannelTypeCd(String channelTypeCd) {
    this.channelTypeCd = channelTypeCd;
  }

  public TelusChannel salesRepCd(String salesRepCd) {
    this.salesRepCd = salesRepCd;
    return this;
  }

  /**
   * The customer service representative code of the service representative that submitted the application.
   * @return salesRepCd
  **/
  @ApiModelProperty(value = "The customer service representative code of the service representative that submitted the application.")


  public String getSalesRepCd() {
    return salesRepCd;
  }

  public void setSalesRepCd(String salesRepCd) {
    this.salesRepCd = salesRepCd;
  }

  public TelusChannel dealerCode(String dealerCode) {
    this.dealerCode = dealerCode;
    return this;
  }

  /**
   * The dealer code that the application was submmited from.
   * @return dealerCode
  **/
  @ApiModelProperty(value = "The dealer code that the application was submmited from.")


  public String getDealerCode() {
    return dealerCode;
  }

  public void setDealerCode(String dealerCode) {
    this.dealerCode = dealerCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelusChannel telusChannel = (TelusChannel) o;
    return Objects.equals(this.originatorApplicationId, telusChannel.originatorApplicationId) &&
        Objects.equals(this.channelOrganizationId, telusChannel.channelOrganizationId) &&
        Objects.equals(this.userid, telusChannel.userid) &&
        Objects.equals(this.channelTypeCd, telusChannel.channelTypeCd) &&
        Objects.equals(this.salesRepCd, telusChannel.salesRepCd) &&
        Objects.equals(this.dealerCode, telusChannel.dealerCode) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originatorApplicationId, channelOrganizationId, userid, channelTypeCd, salesRepCd, dealerCode, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelusChannel {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    originatorApplicationId: ").append(toIndentedString(originatorApplicationId)).append("\n");
    sb.append("    channelOrganizationId: ").append(toIndentedString(channelOrganizationId)).append("\n");
    sb.append("    userid: ").append(toIndentedString(userid)).append("\n");
    sb.append("    channelTypeCd: ").append(toIndentedString(channelTypeCd)).append("\n");
    sb.append("    salesRepCd: ").append(toIndentedString(salesRepCd)).append("\n");
    sb.append("    dealerCode: ").append(toIndentedString(dealerCode)).append("\n");
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

