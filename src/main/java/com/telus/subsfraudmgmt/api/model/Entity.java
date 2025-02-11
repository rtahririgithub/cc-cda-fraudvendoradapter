package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Base entity schema for use in TMForum Open-APIs
 */
@ApiModel(description = "Base entity schema for use in TMForum Open-APIs")
@Validated
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type", visible = true )
@JsonSubTypes({
  @JsonSubTypes.Type(value = Account.class, name = "Account"),
  @JsonSubTypes.Type(value = ProductCharacteristic.class, name = "ProductCharacteristic"),
  @JsonSubTypes.Type(value = Customer.class, name = "Customer"),
  @JsonSubTypes.Type(value = Product.class, name = "Product"),
  @JsonSubTypes.Type(value = AgreementTermOrCondition.class, name = "AgreementTermOrCondition"),
  @JsonSubTypes.Type(value = ProductRef.class, name = "ProductRef"),
  @JsonSubTypes.Type(value = ChannelRef.class, name = "ChannelRef"),
  @JsonSubTypes.Type(value = BillingAccountRef.class, name = "BillingAccountRef"),
  @JsonSubTypes.Type(value = TelusIndividualIdentification.class, name = "TelusIndividualIdentification"),
  @JsonSubTypes.Type(value = IndividualRef.class, name = "IndividualRef"),
  @JsonSubTypes.Type(value = StringCharacteristic.class, name = "StringCharacteristic"),
  @JsonSubTypes.Type(value = PartyRef.class, name = "PartyRef"),
  @JsonSubTypes.Type(value = Party.class, name = "Party"),
  @JsonSubTypes.Type(value = AgreementItem.class, name = "AgreementItem"),
  @JsonSubTypes.Type(value = CreditProfile.class, name = "CreditProfile"),
  @JsonSubTypes.Type(value = CharacteristicRelationship.class, name = "CharacteristicRelationship"),
  @JsonSubTypes.Type(value = EntityValue.class, name = "EntityValue"),
  @JsonSubTypes.Type(value = Agreement.class, name = "Agreement"),
  @JsonSubTypes.Type(value = Place.class, name = "Place"),
  @JsonSubTypes.Type(value = ProductSpecificationRef.class, name = "ProductSpecificationRef"),
  @JsonSubTypes.Type(value = Attachment.class, name = "Attachment"),
  @JsonSubTypes.Type(value = TelusBillingAccount.class, name = "TelusBillingAccount"),
  @JsonSubTypes.Type(value = TelusCreditProfile.class, name = "TelusCreditProfile"),
  @JsonSubTypes.Type(value = ProductOfferingPriceRef.class, name = "ProductOfferingPriceRef"),
  @JsonSubTypes.Type(value = AgreementSpecificationRef.class, name = "AgreementSpecificationRef"),
  @JsonSubTypes.Type(value = AttachmentRef.class, name = "AttachmentRef"),
  @JsonSubTypes.Type(value = Channel.class, name = "Channel"),
  @JsonSubTypes.Type(value = Characteristic.class, name = "Characteristic"),
  @JsonSubTypes.Type(value = AgreementAuthorization.class, name = "AgreementAuthorization"),
  @JsonSubTypes.Type(value = ProductRefOrValue.class, name = "ProductRefOrValue"),
  @JsonSubTypes.Type(value = RealizingResourceRef.class, name = "RealizingResourceRef"),
  @JsonSubTypes.Type(value = Price.class, name = "Price"),
  @JsonSubTypes.Type(value = Individual.class, name = "Individual"),
  @JsonSubTypes.Type(value = PaymentPlan.class, name = "PaymentPlan"),
  @JsonSubTypes.Type(value = ServiceRef.class, name = "ServiceRef"),
  @JsonSubTypes.Type(value = ChannelRefOrValue.class, name = "ChannelRefOrValue"),
  @JsonSubTypes.Type(value = ProductOfferingRef.class, name = "ProductOfferingRef"),
  @JsonSubTypes.Type(value = ProductPrice.class, name = "ProductPrice"),
  @JsonSubTypes.Type(value = PriceAlteration.class, name = "PriceAlteration"),
  @JsonSubTypes.Type(value = ProductRelationship.class, name = "ProductRelationship"),
  @JsonSubTypes.Type(value = AccountBalance.class, name = "AccountBalance"),
  @JsonSubTypes.Type(value = BillingAccount.class, name = "BillingAccount"),
  @JsonSubTypes.Type(value = TelusChannel.class, name = "TelusChannel"),
  @JsonSubTypes.Type(value = PartyAccount.class, name = "PartyAccount"),
  @JsonSubTypes.Type(value = EntityRef.class, name = "EntityRef"),
  @JsonSubTypes.Type(value = TelusCreditBureuaAttachment.class, name = "TelusCreditBureuaAttachment"),
  @JsonSubTypes.Type(value = RelatedEntity.class, name = "RelatedEntity"),
  @JsonSubTypes.Type(value = IndividualIdentification.class, name = "IndividualIdentification"),
  @JsonSubTypes.Type(value = PartyAccountRef.class, name = "PartyAccountRef"),
})

public class Entity   {
  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@type")
  private String type = null;

  public Entity schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public Entity baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public Entity type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Entity entity = (Entity) o;
    return Objects.equals(this.schemaLocation, entity.schemaLocation) &&
        Objects.equals(this.baseType, entity.baseType) &&
        Objects.equals(this.type, entity.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(schemaLocation, baseType, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Entity {\n");
    
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

