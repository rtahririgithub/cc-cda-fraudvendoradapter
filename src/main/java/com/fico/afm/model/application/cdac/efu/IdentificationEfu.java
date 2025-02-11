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
 * EFU Extended FULL, 6 (DT) segments. Only parts of FULL. Other portions are in Header
 *                 element.
 *             
 * 
 * <p>Java class for IdentificationEfu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdentificationEfu"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://fico.com/dms/fidms/cc/cdac/efu}IdentificationType"&gt;
 *       &lt;attribute name="SpouseSsn" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="DeathDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SubjectDateOfBirth" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SpouseDeathDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="GenderCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MaritalStatus" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Sex" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NumberOfDependents" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentificationEfu")
public class IdentificationEfu
    extends IdentificationType
{

    @XmlAttribute(name = "SpouseSsn")
    protected String spouseSsn;
    @XmlAttribute(name = "DeathDate")
    protected String deathDate;
    @XmlAttribute(name = "SubjectDateOfBirth")
    protected String subjectDateOfBirth;
    @XmlAttribute(name = "SpouseDeathDate")
    protected String spouseDeathDate;
    @XmlAttribute(name = "GenderCode")
    protected String genderCode;
    @XmlAttribute(name = "MaritalStatus")
    protected String maritalStatus;
    @XmlAttribute(name = "Sex")
    protected String sex;
    @XmlAttribute(name = "NumberOfDependents")
    protected String numberOfDependents;

    /**
     * Gets the value of the spouseSsn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpouseSsn() {
        return spouseSsn;
    }

    /**
     * Sets the value of the spouseSsn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpouseSsn(String value) {
        this.spouseSsn = value;
    }

    /**
     * Gets the value of the deathDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeathDate() {
        return deathDate;
    }

    /**
     * Sets the value of the deathDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeathDate(String value) {
        this.deathDate = value;
    }

    /**
     * Gets the value of the subjectDateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubjectDateOfBirth() {
        return subjectDateOfBirth;
    }

    /**
     * Sets the value of the subjectDateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubjectDateOfBirth(String value) {
        this.subjectDateOfBirth = value;
    }

    /**
     * Gets the value of the spouseDeathDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpouseDeathDate() {
        return spouseDeathDate;
    }

    /**
     * Sets the value of the spouseDeathDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpouseDeathDate(String value) {
        this.spouseDeathDate = value;
    }

    /**
     * Gets the value of the genderCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenderCode() {
        return genderCode;
    }

    /**
     * Sets the value of the genderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenderCode(String value) {
        this.genderCode = value;
    }

    /**
     * Gets the value of the maritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets the value of the maritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaritalStatus(String value) {
        this.maritalStatus = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSex(String value) {
        this.sex = value;
    }

    /**
     * Gets the value of the numberOfDependents property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfDependents() {
        return numberOfDependents;
    }

    /**
     * Sets the value of the numberOfDependents property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfDependents(String value) {
        this.numberOfDependents = value;
    }

}
