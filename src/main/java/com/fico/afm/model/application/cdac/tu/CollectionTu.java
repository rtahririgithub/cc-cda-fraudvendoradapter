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
import javax.xml.bind.annotation.XmlType;


/**
 * TU Sampling Format CO segment.
 * 
 * <p>Java class for CollectionTu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CollectionTu"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://fico.com/dms/fidms/cc/cdac/tu}CollectionType"&gt;
 *       &lt;attribute name="IndustryCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SubscriberNumber" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SubscriberName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="AccountType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="CreditorName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="VerificationIndicator" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="DateClosed" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="DateClosedIndicator" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="DatePaidOut" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="RemarksCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MatchType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="EditSequenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CollectionTu")
public class CollectionTu
    extends CollectionType
{

    @XmlAttribute(name = "IndustryCode")
    protected String industryCode;
    @XmlAttribute(name = "SubscriberNumber")
    protected String subscriberNumber;
    @XmlAttribute(name = "SubscriberName")
    protected String subscriberName;
    @XmlAttribute(name = "AccountType")
    protected String accountType;
    @XmlAttribute(name = "CreditorName")
    protected String creditorName;
    @XmlAttribute(name = "VerificationIndicator")
    protected String verificationIndicator;
    @XmlAttribute(name = "DateClosed")
    protected String dateClosed;
    @XmlAttribute(name = "DateClosedIndicator")
    protected String dateClosedIndicator;
    @XmlAttribute(name = "DatePaidOut")
    protected String datePaidOut;
    @XmlAttribute(name = "RemarksCode")
    protected String remarksCode;
    @XmlAttribute(name = "MatchType")
    protected String matchType;
    @XmlAttribute(name = "EditSequenceNumber")
    protected String editSequenceNumber;

    /**
     * Gets the value of the industryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndustryCode() {
        return industryCode;
    }

    /**
     * Sets the value of the industryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndustryCode(String value) {
        this.industryCode = value;
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
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountType(String value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the creditorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditorName() {
        return creditorName;
    }

    /**
     * Sets the value of the creditorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditorName(String value) {
        this.creditorName = value;
    }

    /**
     * Gets the value of the verificationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerificationIndicator() {
        return verificationIndicator;
    }

    /**
     * Sets the value of the verificationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerificationIndicator(String value) {
        this.verificationIndicator = value;
    }

    /**
     * Gets the value of the dateClosed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateClosed() {
        return dateClosed;
    }

    /**
     * Sets the value of the dateClosed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateClosed(String value) {
        this.dateClosed = value;
    }

    /**
     * Gets the value of the dateClosedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateClosedIndicator() {
        return dateClosedIndicator;
    }

    /**
     * Sets the value of the dateClosedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateClosedIndicator(String value) {
        this.dateClosedIndicator = value;
    }

    /**
     * Gets the value of the datePaidOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatePaidOut() {
        return datePaidOut;
    }

    /**
     * Sets the value of the datePaidOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatePaidOut(String value) {
        this.datePaidOut = value;
    }

    /**
     * Gets the value of the remarksCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarksCode() {
        return remarksCode;
    }

    /**
     * Sets the value of the remarksCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarksCode(String value) {
        this.remarksCode = value;
    }

    /**
     * Gets the value of the matchType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatchType() {
        return matchType;
    }

    /**
     * Sets the value of the matchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatchType(String value) {
        this.matchType = value;
    }

    /**
     * Gets the value of the editSequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditSequenceNumber() {
        return editSequenceNumber;
    }

    /**
     * Sets the value of the editSequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditSequenceNumber(String value) {
        this.editSequenceNumber = value;
    }

}
