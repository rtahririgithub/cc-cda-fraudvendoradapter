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
 * EFU Extended 13, 15, 16, 17, 18, 19, 20, 21, 22 segments. (BP, FM, LI, FO, NR, MI, TL, FC,
 *                 GN)
 *             
 * 
 * <p>Java class for PublicRecordEfu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublicRecordEfu"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://fico.com/dms/fidms/cc/cdac/efu}PublicRecordType"&gt;
 *       &lt;attribute name="BankruptcyType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="FilingType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="DispositionCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="LiabilityAmount" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="AssetAmount" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ExemptAmount" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NarrativeCode1" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NarrativeCode2" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="CaseNumberOrDispositionDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="TypeCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SatisfiedDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="StatusCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="VerifiedDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Defendant" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Plaintiff" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="AssociatedCreditBureauCreditorClass" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ReleasedDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="CheckedDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MaturityDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Garnishee" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NumericNarrativeCode1" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NumericNarrativeCode2" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ForeignBureauCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ActionCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SpouseNameOrNarrative" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="CourtName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="CourtNumber" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublicRecordEfu")
public class PublicRecordEfu
    extends PublicRecordType
{

    @XmlAttribute(name = "BankruptcyType")
    protected String bankruptcyType;
    @XmlAttribute(name = "FilingType")
    protected String filingType;
    @XmlAttribute(name = "DispositionCode")
    protected String dispositionCode;
    @XmlAttribute(name = "LiabilityAmount")
    protected String liabilityAmount;
    @XmlAttribute(name = "AssetAmount")
    protected String assetAmount;
    @XmlAttribute(name = "ExemptAmount")
    protected String exemptAmount;
    @XmlAttribute(name = "NarrativeCode1")
    protected String narrativeCode1;
    @XmlAttribute(name = "NarrativeCode2")
    protected String narrativeCode2;
    @XmlAttribute(name = "CaseNumberOrDispositionDate")
    protected String caseNumberOrDispositionDate;
    @XmlAttribute(name = "TypeCode")
    protected String typeCode;
    @XmlAttribute(name = "SatisfiedDate")
    protected String satisfiedDate;
    @XmlAttribute(name = "StatusCode")
    protected String statusCode;
    @XmlAttribute(name = "VerifiedDate")
    protected String verifiedDate;
    @XmlAttribute(name = "Defendant")
    protected String defendant;
    @XmlAttribute(name = "Plaintiff")
    protected String plaintiff;
    @XmlAttribute(name = "Amount")
    protected String amount;
    @XmlAttribute(name = "AssociatedCreditBureauCreditorClass")
    protected String associatedCreditBureauCreditorClass;
    @XmlAttribute(name = "ReleasedDate")
    protected String releasedDate;
    @XmlAttribute(name = "CheckedDate")
    protected String checkedDate;
    @XmlAttribute(name = "MaturityDate")
    protected String maturityDate;
    @XmlAttribute(name = "Garnishee")
    protected String garnishee;
    @XmlAttribute(name = "NumericNarrativeCode1")
    protected String numericNarrativeCode1;
    @XmlAttribute(name = "NumericNarrativeCode2")
    protected String numericNarrativeCode2;
    @XmlAttribute(name = "ForeignBureauCode")
    protected String foreignBureauCode;
    @XmlAttribute(name = "ActionCode")
    protected String actionCode;
    @XmlAttribute(name = "SpouseNameOrNarrative")
    protected String spouseNameOrNarrative;
    @XmlAttribute(name = "CourtName")
    protected String courtName;
    @XmlAttribute(name = "CourtNumber")
    protected String courtNumber;

    /**
     * Gets the value of the bankruptcyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankruptcyType() {
        return bankruptcyType;
    }

    /**
     * Sets the value of the bankruptcyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankruptcyType(String value) {
        this.bankruptcyType = value;
    }

    /**
     * Gets the value of the filingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilingType() {
        return filingType;
    }

    /**
     * Sets the value of the filingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilingType(String value) {
        this.filingType = value;
    }

    /**
     * Gets the value of the dispositionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispositionCode() {
        return dispositionCode;
    }

    /**
     * Sets the value of the dispositionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispositionCode(String value) {
        this.dispositionCode = value;
    }

    /**
     * Gets the value of the liabilityAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLiabilityAmount() {
        return liabilityAmount;
    }

    /**
     * Sets the value of the liabilityAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLiabilityAmount(String value) {
        this.liabilityAmount = value;
    }

    /**
     * Gets the value of the assetAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssetAmount() {
        return assetAmount;
    }

    /**
     * Sets the value of the assetAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssetAmount(String value) {
        this.assetAmount = value;
    }

    /**
     * Gets the value of the exemptAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExemptAmount() {
        return exemptAmount;
    }

    /**
     * Sets the value of the exemptAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExemptAmount(String value) {
        this.exemptAmount = value;
    }

    /**
     * Gets the value of the narrativeCode1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNarrativeCode1() {
        return narrativeCode1;
    }

    /**
     * Sets the value of the narrativeCode1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNarrativeCode1(String value) {
        this.narrativeCode1 = value;
    }

    /**
     * Gets the value of the narrativeCode2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNarrativeCode2() {
        return narrativeCode2;
    }

    /**
     * Sets the value of the narrativeCode2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNarrativeCode2(String value) {
        this.narrativeCode2 = value;
    }

    /**
     * Gets the value of the caseNumberOrDispositionDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseNumberOrDispositionDate() {
        return caseNumberOrDispositionDate;
    }

    /**
     * Sets the value of the caseNumberOrDispositionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseNumberOrDispositionDate(String value) {
        this.caseNumberOrDispositionDate = value;
    }

    /**
     * Gets the value of the typeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * Sets the value of the typeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeCode(String value) {
        this.typeCode = value;
    }

    /**
     * Gets the value of the satisfiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSatisfiedDate() {
        return satisfiedDate;
    }

    /**
     * Sets the value of the satisfiedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSatisfiedDate(String value) {
        this.satisfiedDate = value;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the verifiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerifiedDate() {
        return verifiedDate;
    }

    /**
     * Sets the value of the verifiedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerifiedDate(String value) {
        this.verifiedDate = value;
    }

    /**
     * Gets the value of the defendant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefendant() {
        return defendant;
    }

    /**
     * Sets the value of the defendant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefendant(String value) {
        this.defendant = value;
    }

    /**
     * Gets the value of the plaintiff property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaintiff() {
        return plaintiff;
    }

    /**
     * Sets the value of the plaintiff property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaintiff(String value) {
        this.plaintiff = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmount(String value) {
        this.amount = value;
    }

    /**
     * Gets the value of the associatedCreditBureauCreditorClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssociatedCreditBureauCreditorClass() {
        return associatedCreditBureauCreditorClass;
    }

    /**
     * Sets the value of the associatedCreditBureauCreditorClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssociatedCreditBureauCreditorClass(String value) {
        this.associatedCreditBureauCreditorClass = value;
    }

    /**
     * Gets the value of the releasedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReleasedDate() {
        return releasedDate;
    }

    /**
     * Sets the value of the releasedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReleasedDate(String value) {
        this.releasedDate = value;
    }

    /**
     * Gets the value of the checkedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckedDate() {
        return checkedDate;
    }

    /**
     * Sets the value of the checkedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckedDate(String value) {
        this.checkedDate = value;
    }

    /**
     * Gets the value of the maturityDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaturityDate() {
        return maturityDate;
    }

    /**
     * Sets the value of the maturityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaturityDate(String value) {
        this.maturityDate = value;
    }

    /**
     * Gets the value of the garnishee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGarnishee() {
        return garnishee;
    }

    /**
     * Sets the value of the garnishee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGarnishee(String value) {
        this.garnishee = value;
    }

    /**
     * Gets the value of the numericNarrativeCode1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumericNarrativeCode1() {
        return numericNarrativeCode1;
    }

    /**
     * Sets the value of the numericNarrativeCode1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumericNarrativeCode1(String value) {
        this.numericNarrativeCode1 = value;
    }

    /**
     * Gets the value of the numericNarrativeCode2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumericNarrativeCode2() {
        return numericNarrativeCode2;
    }

    /**
     * Sets the value of the numericNarrativeCode2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumericNarrativeCode2(String value) {
        this.numericNarrativeCode2 = value;
    }

    /**
     * Gets the value of the foreignBureauCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForeignBureauCode() {
        return foreignBureauCode;
    }

    /**
     * Sets the value of the foreignBureauCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignBureauCode(String value) {
        this.foreignBureauCode = value;
    }

    /**
     * Gets the value of the actionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionCode() {
        return actionCode;
    }

    /**
     * Sets the value of the actionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionCode(String value) {
        this.actionCode = value;
    }

    /**
     * Gets the value of the spouseNameOrNarrative property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpouseNameOrNarrative() {
        return spouseNameOrNarrative;
    }

    /**
     * Sets the value of the spouseNameOrNarrative property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpouseNameOrNarrative(String value) {
        this.spouseNameOrNarrative = value;
    }

    /**
     * Gets the value of the courtName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourtName() {
        return courtName;
    }

    /**
     * Sets the value of the courtName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourtName(String value) {
        this.courtName = value;
    }

    /**
     * Gets the value of the courtNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourtNumber() {
        return courtNumber;
    }

    /**
     * Sets the value of the courtNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourtNumber(String value) {
        this.courtNumber = value;
    }

}
