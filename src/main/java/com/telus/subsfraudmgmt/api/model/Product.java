package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.AgreementRef;
import com.telus.subsfraudmgmt.api.model.BillingAccountRef;
import com.telus.subsfraudmgmt.api.model.Entity;
import com.telus.subsfraudmgmt.api.model.Place;
import com.telus.subsfraudmgmt.api.model.ProductCharacteristic;
import com.telus.subsfraudmgmt.api.model.ProductOfferingRef;
import com.telus.subsfraudmgmt.api.model.ProductPrice;
import com.telus.subsfraudmgmt.api.model.ProductRelationship;
import com.telus.subsfraudmgmt.api.model.ProductSpecificationRef;
import com.telus.subsfraudmgmt.api.model.RealizingResourceRef;
import com.telus.subsfraudmgmt.api.model.RelatedParty;
import com.telus.subsfraudmgmt.api.model.ServiceRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A product offering procured by a customer or other interested party playing a party role. A product is realized as one or more service(s) and / or resource(s).
 */
@ApiModel(description = "A product offering procured by a customer or other interested party playing a party role. A product is realized as one or more service(s) and / or resource(s).")
@Validated

public class Product extends Entity  {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("isBundle")
  private Boolean isBundle = null;

  @JsonProperty("isCustomerVisible")
  private Boolean isCustomerVisible = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("orderDate")
  private OffsetDateTime orderDate = null;

  @JsonProperty("productSerialNumber")
  private String productSerialNumber = null;

  @JsonProperty("startDate")
  private OffsetDateTime startDate = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("terminationDate")
  private OffsetDateTime terminationDate = null;

  @JsonProperty("realizingService")
  @Valid
  private List<ServiceRef> realizingService = null;

  @JsonProperty("billingAccount")
  @Valid
  private List<BillingAccountRef> billingAccount = null;

  @JsonProperty("productOffering")
  private ProductOfferingRef productOffering = null;

  @JsonProperty("agreement")
  @Valid
  private List<AgreementRef> agreement = null;

  @JsonProperty("characteristic")
  @Valid
  private List<ProductCharacteristic> characteristic = null;

  @JsonProperty("productRelationship")
  @Valid
  private List<ProductRelationship> productRelationship = null;

  @JsonProperty("realizingResource")
  @Valid
  private List<RealizingResourceRef> realizingResource = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedParty> relatedParty = null;

  @JsonProperty("productPrice")
  @Valid
  private List<ProductPrice> productPrice = null;

  @JsonProperty("productSpecification")
  private ProductSpecificationRef productSpecification = null;

  @JsonProperty("place")
  @Valid
  private List<Place> place = null;

  public Product description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Is the description of the product. It could be copied from the description of the Product Offering.
   * @return description
  **/
  @ApiModelProperty(value = "Is the description of the product. It could be copied from the description of the Product Offering.")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Product href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the product
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the product")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Product id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the product
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the product")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Product isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

  /**
   * If true, the product is a ProductBundle which is an instantiation of a BundledProductOffering. If false, the product is a ProductComponent which is an instantiation of a SimpleProductOffering.
   * @return isBundle
  **/
  @ApiModelProperty(value = "If true, the product is a ProductBundle which is an instantiation of a BundledProductOffering. If false, the product is a ProductComponent which is an instantiation of a SimpleProductOffering.")


  public Boolean isIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public Product isCustomerVisible(Boolean isCustomerVisible) {
    this.isCustomerVisible = isCustomerVisible;
    return this;
  }

  /**
   * If true, the product is visible by the customer.
   * @return isCustomerVisible
  **/
  @ApiModelProperty(value = "If true, the product is visible by the customer.")


  public Boolean isIsCustomerVisible() {
    return isCustomerVisible;
  }

  public void setIsCustomerVisible(Boolean isCustomerVisible) {
    this.isCustomerVisible = isCustomerVisible;
  }

  public Product name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the product. It could be the same as the name of the product offering
   * @return name
  **/
  @ApiModelProperty(value = "Name of the product. It could be the same as the name of the product offering")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Product orderDate(OffsetDateTime orderDate) {
    this.orderDate = orderDate;
    return this;
  }

  /**
   * Is the date when the product was ordered
   * @return orderDate
  **/
  @ApiModelProperty(value = "Is the date when the product was ordered")

  @Valid

  public OffsetDateTime getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(OffsetDateTime orderDate) {
    this.orderDate = orderDate;
  }

  public Product productSerialNumber(String productSerialNumber) {
    this.productSerialNumber = productSerialNumber;
    return this;
  }

  /**
   * Is the serial number for the product. This is typically applicable to tangible products e.g. Broadband Router.
   * @return productSerialNumber
  **/
  @ApiModelProperty(value = "Is the serial number for the product. This is typically applicable to tangible products e.g. Broadband Router.")


  public String getProductSerialNumber() {
    return productSerialNumber;
  }

  public void setProductSerialNumber(String productSerialNumber) {
    this.productSerialNumber = productSerialNumber;
  }

  public Product startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Is the date from which the product starts
   * @return startDate
  **/
  @ApiModelProperty(value = "Is the date from which the product starts")

  @Valid

  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public Product status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Is the lifecycle status of the product.
   * @return status
  **/
  @ApiModelProperty(value = "Is the lifecycle status of the product.")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Product terminationDate(OffsetDateTime terminationDate) {
    this.terminationDate = terminationDate;
    return this;
  }

  /**
   * Is the date when the product was terminated
   * @return terminationDate
  **/
  @ApiModelProperty(value = "Is the date when the product was terminated")

  @Valid

  public OffsetDateTime getTerminationDate() {
    return terminationDate;
  }

  public void setTerminationDate(OffsetDateTime terminationDate) {
    this.terminationDate = terminationDate;
  }

  public Product realizingService(List<ServiceRef> realizingService) {
    this.realizingService = realizingService;
    return this;
  }

  public Product addRealizingServiceItem(ServiceRef realizingServiceItem) {
    if (this.realizingService == null) {
      this.realizingService = new ArrayList<>();
    }
    this.realizingService.add(realizingServiceItem);
    return this;
  }

  /**
   * Get realizingService
   * @return realizingService
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ServiceRef> getRealizingService() {
    return realizingService;
  }

  public void setRealizingService(List<ServiceRef> realizingService) {
    this.realizingService = realizingService;
  }

  public Product billingAccount(List<BillingAccountRef> billingAccount) {
    this.billingAccount = billingAccount;
    return this;
  }

  public Product addBillingAccountItem(BillingAccountRef billingAccountItem) {
    if (this.billingAccount == null) {
      this.billingAccount = new ArrayList<>();
    }
    this.billingAccount.add(billingAccountItem);
    return this;
  }

  /**
   * Get billingAccount
   * @return billingAccount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<BillingAccountRef> getBillingAccount() {
    return billingAccount;
  }

  public void setBillingAccount(List<BillingAccountRef> billingAccount) {
    this.billingAccount = billingAccount;
  }

  public Product productOffering(ProductOfferingRef productOffering) {
    this.productOffering = productOffering;
    return this;
  }

  /**
   * Get productOffering
   * @return productOffering
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ProductOfferingRef getProductOffering() {
    return productOffering;
  }

  public void setProductOffering(ProductOfferingRef productOffering) {
    this.productOffering = productOffering;
  }

  public Product agreement(List<AgreementRef> agreement) {
    this.agreement = agreement;
    return this;
  }

  public Product addAgreementItem(AgreementRef agreementItem) {
    if (this.agreement == null) {
      this.agreement = new ArrayList<>();
    }
    this.agreement.add(agreementItem);
    return this;
  }

  /**
   * Get agreement
   * @return agreement
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AgreementRef> getAgreement() {
    return agreement;
  }

  public void setAgreement(List<AgreementRef> agreement) {
    this.agreement = agreement;
  }

  public Product characteristic(List<ProductCharacteristic> characteristic) {
    this.characteristic = characteristic;
    return this;
  }

  public Product addCharacteristicItem(ProductCharacteristic characteristicItem) {
    if (this.characteristic == null) {
      this.characteristic = new ArrayList<>();
    }
    this.characteristic.add(characteristicItem);
    return this;
  }

  /**
   * Get characteristic
   * @return characteristic
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ProductCharacteristic> getCharacteristic() {
    return characteristic;
  }

  public void setCharacteristic(List<ProductCharacteristic> characteristic) {
    this.characteristic = characteristic;
  }

  public Product productRelationship(List<ProductRelationship> productRelationship) {
    this.productRelationship = productRelationship;
    return this;
  }

  public Product addProductRelationshipItem(ProductRelationship productRelationshipItem) {
    if (this.productRelationship == null) {
      this.productRelationship = new ArrayList<>();
    }
    this.productRelationship.add(productRelationshipItem);
    return this;
  }

  /**
   * Get productRelationship
   * @return productRelationship
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ProductRelationship> getProductRelationship() {
    return productRelationship;
  }

  public void setProductRelationship(List<ProductRelationship> productRelationship) {
    this.productRelationship = productRelationship;
  }

  public Product realizingResource(List<RealizingResourceRef> realizingResource) {
    this.realizingResource = realizingResource;
    return this;
  }

  public Product addRealizingResourceItem(RealizingResourceRef realizingResourceItem) {
    if (this.realizingResource == null) {
      this.realizingResource = new ArrayList<>();
    }
    this.realizingResource.add(realizingResourceItem);
    return this;
  }

  /**
   * Get realizingResource
   * @return realizingResource
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<RealizingResourceRef> getRealizingResource() {
    return realizingResource;
  }

  public void setRealizingResource(List<RealizingResourceRef> realizingResource) {
    this.realizingResource = realizingResource;
  }

  public Product relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public Product addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Get relatedParty
   * @return relatedParty
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public Product productPrice(List<ProductPrice> productPrice) {
    this.productPrice = productPrice;
    return this;
  }

  public Product addProductPriceItem(ProductPrice productPriceItem) {
    if (this.productPrice == null) {
      this.productPrice = new ArrayList<>();
    }
    this.productPrice.add(productPriceItem);
    return this;
  }

  /**
   * Get productPrice
   * @return productPrice
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ProductPrice> getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(List<ProductPrice> productPrice) {
    this.productPrice = productPrice;
  }

  public Product productSpecification(ProductSpecificationRef productSpecification) {
    this.productSpecification = productSpecification;
    return this;
  }

  /**
   * Get productSpecification
   * @return productSpecification
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ProductSpecificationRef getProductSpecification() {
    return productSpecification;
  }

  public void setProductSpecification(ProductSpecificationRef productSpecification) {
    this.productSpecification = productSpecification;
  }

  public Product place(List<Place> place) {
    this.place = place;
    return this;
  }

  public Product addPlaceItem(Place placeItem) {
    if (this.place == null) {
      this.place = new ArrayList<>();
    }
    this.place.add(placeItem);
    return this;
  }

  /**
   * Get place
   * @return place
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Place> getPlace() {
    return place;
  }

  public void setPlace(List<Place> place) {
    this.place = place;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.description, product.description) &&
        Objects.equals(this.href, product.href) &&
        Objects.equals(this.id, product.id) &&
        Objects.equals(this.isBundle, product.isBundle) &&
        Objects.equals(this.isCustomerVisible, product.isCustomerVisible) &&
        Objects.equals(this.name, product.name) &&
        Objects.equals(this.orderDate, product.orderDate) &&
        Objects.equals(this.productSerialNumber, product.productSerialNumber) &&
        Objects.equals(this.startDate, product.startDate) &&
        Objects.equals(this.status, product.status) &&
        Objects.equals(this.terminationDate, product.terminationDate) &&
        Objects.equals(this.realizingService, product.realizingService) &&
        Objects.equals(this.billingAccount, product.billingAccount) &&
        Objects.equals(this.productOffering, product.productOffering) &&
        Objects.equals(this.agreement, product.agreement) &&
        Objects.equals(this.characteristic, product.characteristic) &&
        Objects.equals(this.productRelationship, product.productRelationship) &&
        Objects.equals(this.realizingResource, product.realizingResource) &&
        Objects.equals(this.relatedParty, product.relatedParty) &&
        Objects.equals(this.productPrice, product.productPrice) &&
        Objects.equals(this.productSpecification, product.productSpecification) &&
        Objects.equals(this.place, product.place) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, href, id, isBundle, isCustomerVisible, name, orderDate, productSerialNumber, startDate, status, terminationDate, realizingService, billingAccount, productOffering, agreement, characteristic, productRelationship, realizingResource, relatedParty, productPrice, productSpecification, place, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    isCustomerVisible: ").append(toIndentedString(isCustomerVisible)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    orderDate: ").append(toIndentedString(orderDate)).append("\n");
    sb.append("    productSerialNumber: ").append(toIndentedString(productSerialNumber)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    terminationDate: ").append(toIndentedString(terminationDate)).append("\n");
    sb.append("    realizingService: ").append(toIndentedString(realizingService)).append("\n");
    sb.append("    billingAccount: ").append(toIndentedString(billingAccount)).append("\n");
    sb.append("    productOffering: ").append(toIndentedString(productOffering)).append("\n");
    sb.append("    agreement: ").append(toIndentedString(agreement)).append("\n");
    sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
    sb.append("    productRelationship: ").append(toIndentedString(productRelationship)).append("\n");
    sb.append("    realizingResource: ").append(toIndentedString(realizingResource)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    productPrice: ").append(toIndentedString(productPrice)).append("\n");
    sb.append("    productSpecification: ").append(toIndentedString(productSpecification)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
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

