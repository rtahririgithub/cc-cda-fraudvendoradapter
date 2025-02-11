//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.04 at 12:07:05 PM PST 
//


package com.fico.afm.model.application.cdac.xpn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * XPN 336 segment.
 * 
 * <p>Java class for AddressXpn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressXpn"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://fico.com/dms/fidms/cc/cdac/xpn}AddressType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://fico.com/dms/fidms/cc/cdac/xpn}GeoCountyCodeList" minOccurs="0"/&gt;
 *         &lt;element ref="{http://fico.com/dms/fidms/cc/cdac/xpn}GeoStateAndMetropolitanStatisticalAreaCodeList" minOccurs="0"/&gt;
 *         &lt;element ref="{http://fico.com/dms/fidms/cc/cdac/xpn}SubscriberNameAndPhoneList" minOccurs="0"/&gt;
 *         &lt;element ref="{http://fico.com/dms/fidms/cc/cdac/xpn}SubscriberAddressList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="LastUpdatedDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="OriginationCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NumberTimesReported" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="LastSubscriberCodeReporting" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="DwellingType" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="HomeOwnership" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="AddressText" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Y2kDateFirstReported" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Y2kLastUpdatedDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressXpn", propOrder = {
    "geoCountyCodeList",
    "geoStateAndMetropolitanStatisticalAreaCodeList",
    "subscriberNameAndPhoneList",
    "subscriberAddressList"
})
public class AddressXpn
    extends AddressType
{

    @XmlElement(name = "GeoCountyCodeList")
    protected GeoCountyCodeList geoCountyCodeList;
    @XmlElement(name = "GeoStateAndMetropolitanStatisticalAreaCodeList")
    protected GeoStateAndMetropolitanStatisticalAreaCodeList geoStateAndMetropolitanStatisticalAreaCodeList;
    @XmlElement(name = "SubscriberNameAndPhoneList")
    protected SubscriberNameAndPhoneList subscriberNameAndPhoneList;
    @XmlElement(name = "SubscriberAddressList")
    protected SubscriberAddressList subscriberAddressList;
    @XmlAttribute(name = "LastUpdatedDate")
    protected String lastUpdatedDate;
    @XmlAttribute(name = "OriginationCode")
    protected String originationCode;
    @XmlAttribute(name = "NumberTimesReported")
    protected String numberTimesReported;
    @XmlAttribute(name = "LastSubscriberCodeReporting")
    protected String lastSubscriberCodeReporting;
    @XmlAttribute(name = "DwellingType")
    @XmlSchemaType(name = "anySimpleType")
    protected String dwellingType;
    @XmlAttribute(name = "HomeOwnership")
    @XmlSchemaType(name = "anySimpleType")
    protected String homeOwnership;
    @XmlAttribute(name = "AddressText")
    protected String addressText;
    @XmlAttribute(name = "Y2kDateFirstReported")
    protected String y2KDateFirstReported;
    @XmlAttribute(name = "Y2kLastUpdatedDate")
    protected String y2KLastUpdatedDate;

    /**
     * Gets the value of the geoCountyCodeList property.
     * 
     * @return
     *     possible object is
     *     {@link GeoCountyCodeList }
     *     
     */
    public GeoCountyCodeList getGeoCountyCodeList() {
        return geoCountyCodeList;
    }

    /**
     * Sets the value of the geoCountyCodeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeoCountyCodeList }
     *     
     */
    public void setGeoCountyCodeList(GeoCountyCodeList value) {
        this.geoCountyCodeList = value;
    }

    /**
     * Gets the value of the geoStateAndMetropolitanStatisticalAreaCodeList property.
     * 
     * @return
     *     possible object is
     *     {@link GeoStateAndMetropolitanStatisticalAreaCodeList }
     *     
     */
    public GeoStateAndMetropolitanStatisticalAreaCodeList getGeoStateAndMetropolitanStatisticalAreaCodeList() {
        return geoStateAndMetropolitanStatisticalAreaCodeList;
    }

    /**
     * Sets the value of the geoStateAndMetropolitanStatisticalAreaCodeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeoStateAndMetropolitanStatisticalAreaCodeList }
     *     
     */
    public void setGeoStateAndMetropolitanStatisticalAreaCodeList(GeoStateAndMetropolitanStatisticalAreaCodeList value) {
        this.geoStateAndMetropolitanStatisticalAreaCodeList = value;
    }

    /**
     * Gets the value of the subscriberNameAndPhoneList property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberNameAndPhoneList }
     *     
     */
    public SubscriberNameAndPhoneList getSubscriberNameAndPhoneList() {
        return subscriberNameAndPhoneList;
    }

    /**
     * Sets the value of the subscriberNameAndPhoneList property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberNameAndPhoneList }
     *     
     */
    public void setSubscriberNameAndPhoneList(SubscriberNameAndPhoneList value) {
        this.subscriberNameAndPhoneList = value;
    }

    /**
     * Gets the value of the subscriberAddressList property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberAddressList }
     *     
     */
    public SubscriberAddressList getSubscriberAddressList() {
        return subscriberAddressList;
    }

    /**
     * Sets the value of the subscriberAddressList property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberAddressList }
     *     
     */
    public void setSubscriberAddressList(SubscriberAddressList value) {
        this.subscriberAddressList = value;
    }

    /**
     * Gets the value of the lastUpdatedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    /**
     * Sets the value of the lastUpdatedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUpdatedDate(String value) {
        this.lastUpdatedDate = value;
    }

    /**
     * Gets the value of the originationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginationCode() {
        return originationCode;
    }

    /**
     * Sets the value of the originationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginationCode(String value) {
        this.originationCode = value;
    }

    /**
     * Gets the value of the numberTimesReported property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberTimesReported() {
        return numberTimesReported;
    }

    /**
     * Sets the value of the numberTimesReported property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberTimesReported(String value) {
        this.numberTimesReported = value;
    }

    /**
     * Gets the value of the lastSubscriberCodeReporting property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastSubscriberCodeReporting() {
        return lastSubscriberCodeReporting;
    }

    /**
     * Sets the value of the lastSubscriberCodeReporting property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastSubscriberCodeReporting(String value) {
        this.lastSubscriberCodeReporting = value;
    }

    /**
     * Gets the value of the dwellingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDwellingType() {
        return dwellingType;
    }

    /**
     * Sets the value of the dwellingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDwellingType(String value) {
        this.dwellingType = value;
    }

    /**
     * Gets the value of the homeOwnership property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeOwnership() {
        return homeOwnership;
    }

    /**
     * Sets the value of the homeOwnership property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeOwnership(String value) {
        this.homeOwnership = value;
    }

    /**
     * Gets the value of the addressText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressText() {
        return addressText;
    }

    /**
     * Sets the value of the addressText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressText(String value) {
        this.addressText = value;
    }

    /**
     * Gets the value of the y2KDateFirstReported property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getY2KDateFirstReported() {
        return y2KDateFirstReported;
    }

    /**
     * Sets the value of the y2KDateFirstReported property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setY2KDateFirstReported(String value) {
        this.y2KDateFirstReported = value;
    }

    /**
     * Gets the value of the y2KLastUpdatedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getY2KLastUpdatedDate() {
        return y2KLastUpdatedDate;
    }

    /**
     * Sets the value of the y2KLastUpdatedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setY2KLastUpdatedDate(String value) {
        this.y2KLastUpdatedDate = value;
    }

}
