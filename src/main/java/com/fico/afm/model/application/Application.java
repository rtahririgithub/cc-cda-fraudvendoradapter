//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.04 at 12:07:05 PM PST 
//


package com.fico.afm.model.application;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.fico.afm.model.application.types.AbstractExtensibleObject;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.fico.com/fraud/schemas/types}AbstractExtensibleObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="header" type="{http://www.fico.com/fraud/schemas}ApplicationHeader"/&gt;
 *         &lt;element name="applicationDetails" type="{http://www.fico.com/fraud/schemas}ApplicationDetails"/&gt;
 *         &lt;element name="caseDetails" type="{http://www.fico.com/fraud/schemas}CaseDetails" minOccurs="0"/&gt;
 *         &lt;element name="disposition" type="{http://www.fico.com/fraud/schemas}Disposition" minOccurs="0"/&gt;
 *         &lt;element name="score" type="{http://www.fico.com/fraud/schemas}ScoreType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ruleResults" type="{http://www.fico.com/fraud/schemas}DecisionResults" minOccurs="0"/&gt;
 *         &lt;element name="reprocessCount" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "applicationDetails",
    "caseDetails",
    "disposition",
    "score",
    "ruleResults",
    "reprocessCount"
})
@XmlRootElement(name = "Application")
public class Application
    extends AbstractExtensibleObject
{

    @XmlElement(required = true)
    protected ApplicationHeader header;
    @XmlElement(required = true)
    protected ApplicationDetails applicationDetails;
    protected CaseDetails caseDetails;
    protected Disposition disposition;
    protected List<ScoreType> score;
    protected DecisionResults ruleResults;
    protected Short reprocessCount;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationHeader }
     *     
     */
    public ApplicationHeader getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationHeader }
     *     
     */
    public void setHeader(ApplicationHeader value) {
        this.header = value;
    }

    /**
     * Gets the value of the applicationDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationDetails }
     *     
     */
    public ApplicationDetails getApplicationDetails() {
        return applicationDetails;
    }

    /**
     * Sets the value of the applicationDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationDetails }
     *     
     */
    public void setApplicationDetails(ApplicationDetails value) {
        this.applicationDetails = value;
    }

    /**
     * Gets the value of the caseDetails property.
     * 
     * @return
     *     possible object is
     *     {@link CaseDetails }
     *     
     */
    public CaseDetails getCaseDetails() {
        return caseDetails;
    }

    /**
     * Sets the value of the caseDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaseDetails }
     *     
     */
    public void setCaseDetails(CaseDetails value) {
        this.caseDetails = value;
    }

    /**
     * Gets the value of the disposition property.
     * 
     * @return
     *     possible object is
     *     {@link Disposition }
     *     
     */
    public Disposition getDisposition() {
        return disposition;
    }

    /**
     * Sets the value of the disposition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Disposition }
     *     
     */
    public void setDisposition(Disposition value) {
        this.disposition = value;
    }

    /**
     * Gets the value of the score property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the score property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScoreType }
     * 
     * 
     */
    public List<ScoreType> getScore() {
        if (score == null) {
            score = new ArrayList<ScoreType>();
        }
        return this.score;
    }

    /**
     * Gets the value of the ruleResults property.
     * 
     * @return
     *     possible object is
     *     {@link DecisionResults }
     *     
     */
    public DecisionResults getRuleResults() {
        return ruleResults;
    }

    /**
     * Sets the value of the ruleResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecisionResults }
     *     
     */
    public void setRuleResults(DecisionResults value) {
        this.ruleResults = value;
    }

    /**
     * Gets the value of the reprocessCount property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getReprocessCount() {
        return reprocessCount;
    }

    /**
     * Sets the value of the reprocessCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setReprocessCount(Short value) {
        this.reprocessCount = value;
    }

}
