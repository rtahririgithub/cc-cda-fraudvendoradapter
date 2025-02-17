//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.04 at 12:07:05 PM PST 
//


package com.fico.afm.model.application;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>Java class for DecisionResults complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DecisionResults"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{http://www.fico.com/fraud/schemas/types}AbstractEntity"/&gt;
 *         &lt;element name="summary" type="{http://www.fico.com/fraud/schemas}DecisionSummary"/&gt;
 *         &lt;element name="caseRulesFired" type="{http://www.fico.com/fraud/schemas}CaseRule" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="matchingRulesFired" type="{http://www.fico.com/fraud/schemas}MatchingRule" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="serviceInvocations" type="{http://www.fico.com/fraud/schemas}ServiceInvocation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DecisionResults", propOrder = {
    "entityCreateDate",
    "entityLastUpdateDate",
    "id",
    "version",
    "summary",
    "caseRulesFired",
    "matchingRulesFired",
    "serviceInvocations"
})
public class DecisionResults {

    @XmlElement(namespace = "http://www.fico.com/fraud/schemas/types", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar entityCreateDate;
    @XmlElement(namespace = "http://www.fico.com/fraud/schemas/types", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar entityLastUpdateDate;
    @XmlElement(namespace = "http://www.fico.com/fraud/schemas/types")
    protected BigInteger id;
    @XmlElement(namespace = "http://www.fico.com/fraud/schemas/types")
    protected Integer version;
    @XmlElement(required = true)
    protected DecisionSummary summary;
    protected List<CaseRule> caseRulesFired;
    protected List<MatchingRule> matchingRulesFired;
    protected List<ServiceInvocation> serviceInvocations;

    /**
     * Gets the value of the entityCreateDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getEntityCreateDate() {
        return entityCreateDate;
    }

    /**
     * Sets the value of the entityCreateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityCreateDate(Calendar value) {
        this.entityCreateDate = value;
    }

    /**
     * Gets the value of the entityLastUpdateDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getEntityLastUpdateDate() {
        return entityLastUpdateDate;
    }

    /**
     * Sets the value of the entityLastUpdateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityLastUpdateDate(Calendar value) {
        this.entityLastUpdateDate = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVersion(Integer value) {
        this.version = value;
    }

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link DecisionSummary }
     *     
     */
    public DecisionSummary getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecisionSummary }
     *     
     */
    public void setSummary(DecisionSummary value) {
        this.summary = value;
    }

    /**
     * Gets the value of the caseRulesFired property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the caseRulesFired property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseRulesFired().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseRule }
     * 
     * 
     */
    public List<CaseRule> getCaseRulesFired() {
        if (caseRulesFired == null) {
            caseRulesFired = new ArrayList<CaseRule>();
        }
        return this.caseRulesFired;
    }

    /**
     * Gets the value of the matchingRulesFired property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the matchingRulesFired property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMatchingRulesFired().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MatchingRule }
     * 
     * 
     */
    public List<MatchingRule> getMatchingRulesFired() {
        if (matchingRulesFired == null) {
            matchingRulesFired = new ArrayList<MatchingRule>();
        }
        return this.matchingRulesFired;
    }

    /**
     * Gets the value of the serviceInvocations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceInvocations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceInvocations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceInvocation }
     * 
     * 
     */
    public List<ServiceInvocation> getServiceInvocations() {
        if (serviceInvocations == null) {
            serviceInvocations = new ArrayList<ServiceInvocation>();
        }
        return this.serviceInvocations;
    }

}
