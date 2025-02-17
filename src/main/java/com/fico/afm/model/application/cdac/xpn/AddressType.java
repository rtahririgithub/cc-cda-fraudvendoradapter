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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * XPN 336 segment.
 * 
 * <p>Java class for AddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute ref="{http://fico.com/dms/fidms/cc/cdac/xpn}SourceSegment"/&gt;
 *       &lt;attribute name="DateReported" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="GeoCensusTract" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="GeoSuffix" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="GeoBlockGroup" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType")
@XmlSeeAlso({
    AddressXpn.class
})
public class AddressType {

    @XmlAttribute(name = "SourceSegment", namespace = "http://fico.com/dms/fidms/cc/cdac/xpn")
    protected String sourceSegment;
    @XmlAttribute(name = "DateReported")
    protected String dateReported;
    @XmlAttribute(name = "GeoCensusTract")
    protected String geoCensusTract;
    @XmlAttribute(name = "GeoSuffix")
    protected String geoSuffix;
    @XmlAttribute(name = "GeoBlockGroup")
    protected String geoBlockGroup;

    /**
     * XPN Source Segment
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
     * Gets the value of the dateReported property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateReported() {
        return dateReported;
    }

    /**
     * Sets the value of the dateReported property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateReported(String value) {
        this.dateReported = value;
    }

    /**
     * Gets the value of the geoCensusTract property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeoCensusTract() {
        return geoCensusTract;
    }

    /**
     * Sets the value of the geoCensusTract property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeoCensusTract(String value) {
        this.geoCensusTract = value;
    }

    /**
     * Gets the value of the geoSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeoSuffix() {
        return geoSuffix;
    }

    /**
     * Sets the value of the geoSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeoSuffix(String value) {
        this.geoSuffix = value;
    }

    /**
     * Gets the value of the geoBlockGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeoBlockGroup() {
        return geoBlockGroup;
    }

    /**
     * Sets the value of the geoBlockGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeoBlockGroup(String value) {
        this.geoBlockGroup = value;
    }

}
