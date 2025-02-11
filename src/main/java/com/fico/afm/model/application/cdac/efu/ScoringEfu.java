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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * EFU Extended 29 (SC) segment. Original segment is split into 14 separate scoring
 *                 elements.
 *             
 * 
 * <p>Java class for ScoringEfu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScoringEfu"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://fico.com/dms/fidms/cc/cdac/efu}ScoringType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://fico.com/dms/fidms/cc/cdac/efu}CharacteristicList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="MmFormatType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="RegionalIndicatorCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="RejectMessageCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ScoreNumber" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SingleSubjectDebitReject" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SingleSubjectCreditReject" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SpouseDebitReject" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SpouseCreditReject" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="JointDebitReject" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="JointCreditReject" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ScoreCardIndicator" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Item" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Value" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="InquiryKeyFactor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="RiskBasedPricingPercentage" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="LowRangeOfScore" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="HighRangeOfScore" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScoringEfu", propOrder = {
    "characteristicList"
})
public class ScoringEfu
    extends ScoringType
{

    @XmlElement(name = "CharacteristicList")
    protected CharacteristicList characteristicList;
    @XmlAttribute(name = "MmFormatType")
    protected String mmFormatType;
    @XmlAttribute(name = "RegionalIndicatorCode")
    protected String regionalIndicatorCode;
    @XmlAttribute(name = "RejectMessageCode")
    protected String rejectMessageCode;
    @XmlAttribute(name = "ScoreNumber")
    protected String scoreNumber;
    @XmlAttribute(name = "SingleSubjectDebitReject")
    protected String singleSubjectDebitReject;
    @XmlAttribute(name = "SingleSubjectCreditReject")
    protected String singleSubjectCreditReject;
    @XmlAttribute(name = "SpouseDebitReject")
    protected String spouseDebitReject;
    @XmlAttribute(name = "SpouseCreditReject")
    protected String spouseCreditReject;
    @XmlAttribute(name = "JointDebitReject")
    protected String jointDebitReject;
    @XmlAttribute(name = "JointCreditReject")
    protected String jointCreditReject;
    @XmlAttribute(name = "ScoreCardIndicator")
    protected String scoreCardIndicator;
    @XmlAttribute(name = "Item")
    protected String item;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "Value")
    protected String value;
    @XmlAttribute(name = "InquiryKeyFactor")
    protected String inquiryKeyFactor;
    @XmlAttribute(name = "RiskBasedPricingPercentage")
    protected String riskBasedPricingPercentage;
    @XmlAttribute(name = "LowRangeOfScore")
    protected String lowRangeOfScore;
    @XmlAttribute(name = "HighRangeOfScore")
    protected String highRangeOfScore;

    /**
     * Gets the value of the characteristicList property.
     * 
     * @return
     *     possible object is
     *     {@link CharacteristicList }
     *     
     */
    public CharacteristicList getCharacteristicList() {
        return characteristicList;
    }

    /**
     * Sets the value of the characteristicList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacteristicList }
     *     
     */
    public void setCharacteristicList(CharacteristicList value) {
        this.characteristicList = value;
    }

    /**
     * Gets the value of the mmFormatType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMmFormatType() {
        return mmFormatType;
    }

    /**
     * Sets the value of the mmFormatType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMmFormatType(String value) {
        this.mmFormatType = value;
    }

    /**
     * Gets the value of the regionalIndicatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionalIndicatorCode() {
        return regionalIndicatorCode;
    }

    /**
     * Sets the value of the regionalIndicatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionalIndicatorCode(String value) {
        this.regionalIndicatorCode = value;
    }

    /**
     * Gets the value of the rejectMessageCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRejectMessageCode() {
        return rejectMessageCode;
    }

    /**
     * Sets the value of the rejectMessageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRejectMessageCode(String value) {
        this.rejectMessageCode = value;
    }

    /**
     * Gets the value of the scoreNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScoreNumber() {
        return scoreNumber;
    }

    /**
     * Sets the value of the scoreNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScoreNumber(String value) {
        this.scoreNumber = value;
    }

    /**
     * Gets the value of the singleSubjectDebitReject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSingleSubjectDebitReject() {
        return singleSubjectDebitReject;
    }

    /**
     * Sets the value of the singleSubjectDebitReject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSingleSubjectDebitReject(String value) {
        this.singleSubjectDebitReject = value;
    }

    /**
     * Gets the value of the singleSubjectCreditReject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSingleSubjectCreditReject() {
        return singleSubjectCreditReject;
    }

    /**
     * Sets the value of the singleSubjectCreditReject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSingleSubjectCreditReject(String value) {
        this.singleSubjectCreditReject = value;
    }

    /**
     * Gets the value of the spouseDebitReject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpouseDebitReject() {
        return spouseDebitReject;
    }

    /**
     * Sets the value of the spouseDebitReject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpouseDebitReject(String value) {
        this.spouseDebitReject = value;
    }

    /**
     * Gets the value of the spouseCreditReject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpouseCreditReject() {
        return spouseCreditReject;
    }

    /**
     * Sets the value of the spouseCreditReject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpouseCreditReject(String value) {
        this.spouseCreditReject = value;
    }

    /**
     * Gets the value of the jointDebitReject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJointDebitReject() {
        return jointDebitReject;
    }

    /**
     * Sets the value of the jointDebitReject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJointDebitReject(String value) {
        this.jointDebitReject = value;
    }

    /**
     * Gets the value of the jointCreditReject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJointCreditReject() {
        return jointCreditReject;
    }

    /**
     * Sets the value of the jointCreditReject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJointCreditReject(String value) {
        this.jointCreditReject = value;
    }

    /**
     * Gets the value of the scoreCardIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScoreCardIndicator() {
        return scoreCardIndicator;
    }

    /**
     * Sets the value of the scoreCardIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScoreCardIndicator(String value) {
        this.scoreCardIndicator = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItem(String value) {
        this.item = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the inquiryKeyFactor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInquiryKeyFactor() {
        return inquiryKeyFactor;
    }

    /**
     * Sets the value of the inquiryKeyFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInquiryKeyFactor(String value) {
        this.inquiryKeyFactor = value;
    }

    /**
     * Gets the value of the riskBasedPricingPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRiskBasedPricingPercentage() {
        return riskBasedPricingPercentage;
    }

    /**
     * Sets the value of the riskBasedPricingPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRiskBasedPricingPercentage(String value) {
        this.riskBasedPricingPercentage = value;
    }

    /**
     * Gets the value of the lowRangeOfScore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLowRangeOfScore() {
        return lowRangeOfScore;
    }

    /**
     * Sets the value of the lowRangeOfScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLowRangeOfScore(String value) {
        this.lowRangeOfScore = value;
    }

    /**
     * Gets the value of the highRangeOfScore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHighRangeOfScore() {
        return highRangeOfScore;
    }

    /**
     * Sets the value of the highRangeOfScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHighRangeOfScore(String value) {
        this.highRangeOfScore = value;
    }

}
