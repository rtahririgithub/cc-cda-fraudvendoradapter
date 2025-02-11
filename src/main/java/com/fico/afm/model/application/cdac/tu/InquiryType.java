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
 * Base type for an inquiry
 * 
 * <p>Java class for InquiryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InquiryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute ref="{http://fico.com/dms/fidms/cc/cdac/tu}Deduplicate"/&gt;
 *       &lt;attribute ref="{http://fico.com/dms/fidms/cc/cdac/tu}SourceSegment"/&gt;
 *       &lt;attribute name="InquiryDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InquiryType")
@XmlSeeAlso({
    InquiryTu.class
})
public class InquiryType {

    @XmlAttribute(name = "Deduplicate", namespace = "http://fico.com/dms/fidms/cc/cdac/tu")
    protected String deduplicate;
    @XmlAttribute(name = "SourceSegment", namespace = "http://fico.com/dms/fidms/cc/cdac/tu")
    protected String sourceSegment;
    @XmlAttribute(name = "InquiryDate")
    protected String inquiryDate;
    @XmlAttribute(name = "Type")
    protected String type;

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
     * Gets the value of the inquiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInquiryDate() {
        return inquiryDate;
    }

    /**
     * Sets the value of the inquiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInquiryDate(String value) {
        this.inquiryDate = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
