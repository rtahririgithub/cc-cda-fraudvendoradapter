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
 * <p>Java class for MatchingRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MatchingRule"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.fico.com/fraud/schemas}AbstractRule"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="decision" type="{http://www.fico.com/fraud/schemas/types}RuleDecision" minOccurs="0"/&gt;
 *         &lt;element name="query" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="searchConditions" type="{http://www.fico.com/fraud/schemas}SearchCondition" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="matches" type="{http://www.fico.com/fraud/schemas}Match" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatchingRule", propOrder = {
    "decision",
    "query",
    "searchConditions",
    "matches"
})
public class MatchingRule
    extends AbstractRule
{

    @XmlSchemaType(name = "string")
    protected RuleDecision decision;
    protected String query;
    protected List<SearchCondition> searchConditions;
    protected List<Match> matches;

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
     * Gets the value of the query property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuery() {
        return query;
    }

    /**
     * Sets the value of the query property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuery(String value) {
        this.query = value;
    }

    /**
     * Gets the value of the searchConditions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchConditions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchConditions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchCondition }
     * 
     * 
     */
    public List<SearchCondition> getSearchConditions() {
        if (searchConditions == null) {
            searchConditions = new ArrayList<SearchCondition>();
        }
        return this.searchConditions;
    }

    /**
     * Gets the value of the matches property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the matches property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMatches().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Match }
     * 
     * 
     */
    public List<Match> getMatches() {
        if (matches == null) {
            matches = new ArrayList<Match>();
        }
        return this.matches;
    }

}
