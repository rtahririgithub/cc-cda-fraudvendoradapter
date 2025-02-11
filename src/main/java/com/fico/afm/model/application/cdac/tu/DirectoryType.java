//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.04 at 12:07:05 PM PST 
//


package com.fico.afm.model.application.cdac.tu;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * TU LK01, SA01, PN01 segments. SA01 is the subscriber address and PN01 is the subscriber
 *                 phone (returned after LK01)
 *             
 * 
 * <p>Java class for DirectoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DirectoryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute ref="{http://fico.com/dms/fidms/cc/cdac/tu}Deduplicate"/&gt;
 *       &lt;attribute ref="{http://fico.com/dms/fidms/cc/cdac/tu}SourceSegment"/&gt;
 *       &lt;attribute name="SubscriberNumber" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SubscriberName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SubscriberAddress1" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SubscriberAddressCity" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SubscriberAddressState" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SubscriberAddressZipCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Number" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirectoryType")
@XmlSeeAlso({
    DirectoryTu.class
})
public class DirectoryType {

    @XmlAttribute(name = "Deduplicate", namespace = "http://fico.com/dms/fidms/cc/cdac/tu")
    protected String deduplicate;
    @XmlAttribute(name = "SourceSegment", namespace = "http://fico.com/dms/fidms/cc/cdac/tu")
    protected String sourceSegment;
    @XmlAttribute(name = "SubscriberNumber")
    protected String subscriberNumber;
    @XmlAttribute(name = "SubscriberName")
    protected String subscriberName;
    @XmlAttribute(name = "SubscriberAddress1")
    protected String subscriberAddress1;
    @XmlAttribute(name = "SubscriberAddressCity")
    protected String subscriberAddressCity;
    @XmlAttribute(name = "SubscriberAddressState")
    protected String subscriberAddressState;
    @XmlAttribute(name = "SubscriberAddressZipCode")
    protected String subscriberAddressZipCode;
    @XmlAttribute(name = "Number")
    protected String number;

    /**
     * TU De-duplicate flag
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeduplicate() {
        return deduplicate;
    }

    /**
     * Sets the value of the deduplicate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeduplicate(String value) {
        this.deduplicate = value;
    }

    /**
     * TU Source Segment
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceSegment() {
        return sourceSegment;
    }

    /**
     * Sets the value of the sourceSegment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceSegment(String value) {
        this.sourceSegment = value;
    }

    /**
     * Gets the value of the subscriberNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberNumber() {
        return subscriberNumber;
    }

    /**
     * Sets the value of the subscriberNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberNumber(String value) {
        this.subscriberNumber = value;
    }

    /**
     * Gets the value of the subscriberName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberName() {
        return subscriberName;
    }

    /**
     * Sets the value of the subscriberName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberName(String value) {
        this.subscriberName = value;
    }

    /**
     * Gets the value of the subscriberAddress1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberAddress1() {
        return subscriberAddress1;
    }

    /**
     * Sets the value of the subscriberAddress1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberAddress1(String value) {
        this.subscriberAddress1 = value;
    }

    /**
     * Gets the value of the subscriberAddressCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberAddressCity() {
        return subscriberAddressCity;
    }

    /**
     * Sets the value of the subscriberAddressCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberAddressCity(String value) {
        this.subscriberAddressCity = value;
    }

    /**
     * Gets the value of the subscriberAddressState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberAddressState() {
        return subscriberAddressState;
    }

    /**
     * Sets the value of the subscriberAddressState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberAddressState(String value) {
        this.subscriberAddressState = value;
    }

    /**
     * Gets the value of the subscriberAddressZipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberAddressZipCode() {
        return subscriberAddressZipCode;
    }

    /**
     * Sets the value of the subscriberAddressZipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberAddressZipCode(String value) {
        this.subscriberAddressZipCode = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

}
