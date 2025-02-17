//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.04 at 12:07:05 PM PST 
//


package com.fico.afm.model.application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.fico.afm.model.application.types.AbstractExtensibleObject;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Java class for CaseDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.fico.com/fraud/schemas/types}AbstractExtensibleObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="caseId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="createdDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="createdExplanation" type="{http://www.fico.com/fraud/schemas/types}String128" minOccurs="0"/&gt;
 *         &lt;element name="reactivatedDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="reactivatedExplanation" type="{http://www.fico.com/fraud/schemas/types}String128" minOccurs="0"/&gt;
 *         &lt;element name="suppressedDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="suppressedExplanation" type="{http://www.fico.com/fraud/schemas/types}String128" minOccurs="0"/&gt;
 *         &lt;element name="caseHistory" type="{http://www.fico.com/fraud/schemas}CaseHistory" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="created" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="reactivated" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="suppressed" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseDetails", propOrder = {
    "caseId",
    "createdDateTime",
    "createdExplanation",
    "reactivatedDateTime",
    "reactivatedExplanation",
    "suppressedDateTime",
    "suppressedExplanation",
    "caseHistory"
})
public class CaseDetails
    extends AbstractExtensibleObject
{

    protected long caseId;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar createdDateTime;
    protected String createdExplanation;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar reactivatedDateTime;
    protected String reactivatedExplanation;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar suppressedDateTime;
    protected String suppressedExplanation;
    protected List<CaseHistory> caseHistory;
    @XmlAttribute(name = "created")
    protected Boolean created;
    @XmlAttribute(name = "reactivated")
    protected Boolean reactivated;
    @XmlAttribute(name = "suppressed")
    protected Boolean suppressed;

    /**
     * Gets the value of the caseId property.
     * 
     */
    public long getCaseId() {
        return caseId;
    }

    /**
     * Sets the value of the caseId property.
     * 
     */
    public void setCaseId(long value) {
        this.caseId = value;
    }

    /**
     * Gets the value of the createdDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getCreatedDateTime() {
        return createdDateTime;
    }

    /**
     * Sets the value of the createdDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedDateTime(Calendar value) {
        this.createdDateTime = value;
    }

    /**
     * Gets the value of the createdExplanation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedExplanation() {
        return createdExplanation;
    }

    /**
     * Sets the value of the createdExplanation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedExplanation(String value) {
        this.createdExplanation = value;
    }

    /**
     * Gets the value of the reactivatedDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getReactivatedDateTime() {
        return reactivatedDateTime;
    }

    /**
     * Sets the value of the reactivatedDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReactivatedDateTime(Calendar value) {
        this.reactivatedDateTime = value;
    }

    /**
     * Gets the value of the reactivatedExplanation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReactivatedExplanation() {
        return reactivatedExplanation;
    }

    /**
     * Sets the value of the reactivatedExplanation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReactivatedExplanation(String value) {
        this.reactivatedExplanation = value;
    }

    /**
     * Gets the value of the suppressedDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getSuppressedDateTime() {
        return suppressedDateTime;
    }

    /**
     * Sets the value of the suppressedDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuppressedDateTime(Calendar value) {
        this.suppressedDateTime = value;
    }

    /**
     * Gets the value of the suppressedExplanation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuppressedExplanation() {
        return suppressedExplanation;
    }

    /**
     * Sets the value of the suppressedExplanation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuppressedExplanation(String value) {
        this.suppressedExplanation = value;
    }

    /**
     * Gets the value of the caseHistory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the caseHistory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseHistory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseHistory }
     * 
     * 
     */
    public List<CaseHistory> getCaseHistory() {
        if (caseHistory == null) {
            caseHistory = new ArrayList<CaseHistory>();
        }
        return this.caseHistory;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCreated(Boolean value) {
        this.created = value;
    }

    /**
     * Gets the value of the reactivated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getReactivated() {
        return reactivated;
    }

    /**
     * Sets the value of the reactivated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReactivated(Boolean value) {
        this.reactivated = value;
    }

    /**
     * Gets the value of the suppressed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getSuppressed() {
        return suppressed;
    }

    /**
     * Sets the value of the suppressed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSuppressed(Boolean value) {
        this.suppressed = value;
    }

}
