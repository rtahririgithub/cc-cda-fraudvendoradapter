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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.fico.afm.model.application.types.RuleDecision;


/**
 * <p>Java class for CaseRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseRule"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.fico.com/fraud/schemas}AbstractRule"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="proposedDecision" type="{http://www.fico.com/fraud/schemas/types}String128" minOccurs="0"/&gt;
 *         &lt;element name="decision" type="{http://www.fico.com/fraud/schemas/types}RuleDecision" minOccurs="0"/&gt;
 *         &lt;element name="createCase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="actionCodeList" type="{http://www.fico.com/fraud/schemas}CaseRuleActionCodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="reasonCodeList" type="{http://www.fico.com/fraud/schemas}CaseRuleReasonCodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseRule", propOrder = {
    "proposedDecision",
    "decision",
    "createCase",
    "actionCodeList",
    "reasonCodeList"
})
public class CaseRule
    extends AbstractRule
{

    protected String proposedDecision;
    @XmlSchemaType(name = "string")
    protected RuleDecision decision;
    protected String createCase;
    protected List<CaseRuleActionCodeType> actionCodeList;
    protected List<CaseRuleReasonCodeType> reasonCodeList;

    /**
     * Gets the value of the proposedDecision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProposedDecision() {
        return proposedDecision;
    }

    /**
     * Sets the value of the proposedDecision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProposedDecision(String value) {
        this.proposedDecision = value;
    }

    /**
     * Gets the value of the decision property.
     * 
     * @return
     *     possible object is
     *     {@link RuleDecision }
     *     
     */
    public RuleDecision getDecision() {
        return decision;
    }

    /**
     * Sets the value of the decision property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleDecision }
     *     
     */
    public void setDecision(RuleDecision value) {
        this.decision = value;
    }

    /**
     * Gets the value of the createCase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateCase() {
        return createCase;
    }

    /**
     * Sets the value of the createCase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateCase(String value) {
        this.createCase = value;
    }

    /**
     * Gets the value of the actionCodeList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actionCodeList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActionCodeList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseRuleActionCodeType }
     * 
     * 
     */
    public List<CaseRuleActionCodeType> getActionCodeList() {
        if (actionCodeList == null) {
            actionCodeList = new ArrayList<CaseRuleActionCodeType>();
        }
        return this.actionCodeList;
    }

    /**
     * Gets the value of the reasonCodeList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reasonCodeList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReasonCodeList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseRuleReasonCodeType }
     * 
     * 
     */
    public List<CaseRuleReasonCodeType> getReasonCodeList() {
        if (reasonCodeList == null) {
            reasonCodeList = new ArrayList<CaseRuleReasonCodeType>();
        }
        return this.reasonCodeList;
    }

}
