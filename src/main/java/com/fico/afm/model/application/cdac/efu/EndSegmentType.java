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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Base type for end segment
 * 
 * <p>Java class for EndSegmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EndSegmentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute ref="{http://fico.com/dms/fidms/cc/cdac/efu}SourceSegment"/&gt;
 *       &lt;attribute name="TotalReportSegments" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EndSegmentType")
@XmlSeeAlso({
    EndSegmentXpn.class
})
public class EndSegmentType {

    @XmlAttribute(name = "SourceSegment", namespace = "http://fico.com/dms/fidms/cc/cdac/efu")
    protected String sourceSegment;
    @XmlAttribute(name = "TotalReportSegments")
    protected String totalReportSegments;

    /**
     * EFU Source Segment
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
     * Gets the value of the totalReportSegments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalReportSegments() {
        return totalReportSegments;
    }

    /**
     * Sets the value of the totalReportSegments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalReportSegments(String value) {
        this.totalReportSegments = value;
    }

}
