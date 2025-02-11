//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.04 at 12:07:05 PM PST 
//


package com.fico.afm.model.application.cdac.efu;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * EFU Extended 27, 28 (FI, IQ) segments.
 * 
 * <p>Java class for InquiryEfu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InquiryEfu"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://fico.com/dms/fidms/cc/cdac/efu}InquiryType"&gt;
 *       &lt;attribute name="AbbreviationAndOrCustomerNumber" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SubscriberNumber" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SubscriberName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="InquiryText" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InquiryEfu")
public class InquiryEfu
    extends InquiryType
{

    @XmlAttribute(name = "AbbreviationAndOrCustomerNumber")
    protected String abbreviationAndOrCustomerNumber;
    @XmlAttribute(name = "SubscriberNumber")
    protected String subscriberNumber;
    @XmlAttribute(name = "SubscriberName")
    protected String subscriberName;
    @XmlAttribute(name = "InquiryText")
    protected String inquiryText;

    /**
     * Gets the value of the abbreviationAndOrCustomerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbbreviationAndOrCustomerNumber() {
        return abbreviationAndOrCustomerNumber;
    }

    /**
     * Sets the value of the abbreviationAndOrCustomerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbbreviationAndOrCustomerNumber(String value) {
        this.abbreviationAndOrCustomerNumber = value;
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
     * Gets the value of the inquiryText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInquiryText() {
        return inquiryText;
    }

    /**
     * Sets the value of the inquiryText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInquiryText(String value) {
        this.inquiryText = value;
    }

}
