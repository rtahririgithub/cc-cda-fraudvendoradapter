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
 * TU PI01, DC01 segments.
 * 
 * <p>Java class for IdentificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdentificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute ref="{http://fico.com/dms/fidms/cc/cdac/tu}SourceSegment"/&gt;
 *       &lt;attribute name="SubjectSsn" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentificationType")
@XmlSeeAlso({
    IdentificationTu.class
})
public class IdentificationType {

    @XmlAttribute(name = "SourceSegment", namespace = "http://fico.com/dms/fidms/cc/cdac/tu")
    protected String sourceSegment;
    @XmlAttribute(name = "SubjectSsn")
    protected String subjectSsn;

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
     * Gets the value of the subjectSsn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubjectSsn() {
        return subjectSsn;
    }

    /**
     * Sets the value of the subjectSsn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubjectSsn(String value) {
        this.subjectSsn = value;
    }

}
