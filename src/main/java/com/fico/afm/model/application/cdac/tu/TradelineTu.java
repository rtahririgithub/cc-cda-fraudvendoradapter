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
import javax.xml.bind.annotation.XmlType;


/**
 * TU Sampling Format TR segment.
 * 
 * <p>Java class for TradelineTu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TradelineTu"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://fico.com/dms/fidms/cc/cdac/tu}TradelineType"&gt;
 *       &lt;attribute name="SubscriberName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="IndustryCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SubscriberNumber" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="DateVerified" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="DateClosed" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="DateClosedIndicator" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="HighCredit" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="CreditLimit" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="TermsDuration" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="TermsFrequencyOfPayment" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="TermsAmountOfPayment" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NumberOfPaymentsPastDue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MaximumDelinquencyAmount" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MaximumDelinquencyDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MaximumDelinquencyMannerOfPayment" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="LoanType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="DateOfLastActivity" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="RemarksCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="TradeVerificationIndicator" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="DatePaidOut" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Collateral" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="PaymentPatternStartDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="HistoricalCountersVerificationIndicator" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MatchType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="EditSequenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="OpenClosedIndicator" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MaximumDelinquencyValue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="DisputeCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="DuplicateIndicator" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradelineTu")
public class TradelineTu
    extends TradelineType
{

    @XmlAttribute(name = "SubscriberName")
    protected String subscriberName;
    @XmlAttribute(name = "IndustryCode")
    protected String industryCode;
    @XmlAttribute(name = "SubscriberNumber")
    protected String subscriberNumber;
    @XmlAttribute(name = "DateVerified")
    protected String dateVerified;
    @XmlAttribute(name = "DateClosed")
    protected String dateClosed;
    @XmlAttribute(name = "DateClosedIndicator")
    protected String dateClosedIndicator;
    @XmlAttribute(name = "HighCredit")
    protected String highCredit;
    @XmlAttribute(name = "CreditLimit")
    protected String creditLimit;
    @XmlAttribute(name = "TermsDuration")
    protected String termsDuration;
    @XmlAttribute(name = "TermsFrequencyOfPayment")
    protected String termsFrequencyOfPayment;
    @XmlAttribute(name = "TermsAmountOfPayment")
    protected String termsAmountOfPayment;
    @XmlAttribute(name = "NumberOfPaymentsPastDue")
    protected String numberOfPaymentsPastDue;
    @XmlAttribute(name = "MaximumDelinquencyAmount")
    protected String maximumDelinquencyAmount;
    @XmlAttribute(name = "MaximumDelinquencyDate")
    protected String maximumDelinquencyDate;
    @XmlAttribute(name = "MaximumDelinquencyMannerOfPayment")
    protected String maximumDelinquencyMannerOfPayment;
    @XmlAttribute(name = "LoanType")
    protected String loanType;
    @XmlAttribute(name = "DateOfLastActivity")
    protected String dateOfLastActivity;
    @XmlAttribute(name = "RemarksCode")
    protected String remarksCode;
    @XmlAttribute(name = "TradeVerificationIndicator")
    protected String tradeVerificationIndicator;
    @XmlAttribute(name = "DatePaidOut")
    protected String datePaidOut;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "Collateral")
    protected String collateral;
    @XmlAttribute(name = "PaymentPatternStartDate")
    protected String paymentPatternStartDate;
    @XmlAttribute(name = "HistoricalCountersVerificationIndicator")
    protected String historicalCountersVerificationIndicator;
    @XmlAttribute(name = "MatchType")
    protected String matchType;
    @XmlAttribute(name = "EditSequenceNumber")
    protected String editSequenceNumber;
    @XmlAttribute(name = "OpenClosedIndicator")
    protected String openClosedIndicator;
    @XmlAttribute(name = "MaximumDelinquencyValue")
    protected String maximumDelinquencyValue;
    @XmlAttribute(name = "DisputeCode")
    protected String disputeCode;
    @XmlAttribute(name = "DuplicateIndicator")
    protected String duplicateIndicator;

    /**
     * Gets the value of the subscriberName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberName() {
        return subscriberName;
    }

    /**
     * Sets the value of the subscriberName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberName(String value) {
        this.subscriberName = value;
    }

    /**
     * Gets the value of the industryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndustryCode() {
        return industryCode;
    }

    /**
     * Sets the value of the industryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndustryCode(String value) {
        this.industryCode = value;
    }

    /**
     * Gets the value of the subscriberNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberNumber() {
        return subscriberNumber;
    }

    /**
     * Sets the value of the subscriberNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberNumber(String value) {
        this.subscriberNumber = value;
    }

    /**
     * Gets the value of the dateVerified property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateVerified() {
        return dateVerified;
    }

    /**
     * Sets the value of the dateVerified property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateVerified(String value) {
        this.dateVerified = value;
    }

    /**
     * Gets the value of the dateClosed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateClosed() {
        return dateClosed;
    }

    /**
     * Sets the value of the dateClosed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateClosed(String value) {
        this.dateClosed = value;
    }

    /**
     * Gets the value of the dateClosedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateClosedIndicator() {
        return dateClosedIndicator;
    }

    /**
     * Sets the value of the dateClosedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateClosedIndicator(String value) {
        this.dateClosedIndicator = value;
    }

    /**
     * Gets the value of the highCredit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHighCredit() {
        return highCredit;
    }

    /**
     * Sets the value of the highCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHighCredit(String value) {
        this.highCredit = value;
    }

    /**
     * Gets the value of the creditLimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditLimit() {
        return creditLimit;
    }

    /**
     * Sets the value of the creditLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditLimit(String value) {
        this.creditLimit = value;
    }

    /**
     * Gets the value of the termsDuration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermsDuration() {
        return termsDuration;
    }

    /**
     * Sets the value of the termsDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermsDuration(String value) {
        this.termsDuration = value;
    }

    /**
     * Gets the value of the termsFrequencyOfPayment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermsFrequencyOfPayment() {
        return termsFrequencyOfPayment;
    }

    /**
     * Sets the value of the termsFrequencyOfPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermsFrequencyOfPayment(String value) {
        this.termsFrequencyOfPayment = value;
    }

    /**
     * Gets the value of the termsAmountOfPayment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermsAmountOfPayment() {
        return termsAmountOfPayment;
    }

    /**
     * Sets the value of the termsAmountOfPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermsAmountOfPayment(String value) {
        this.termsAmountOfPayment = value;
    }

    /**
     * Gets the value of the numberOfPaymentsPastDue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfPaymentsPastDue() {
        return numberOfPaymentsPastDue;
    }

    /**
     * Sets the value of the numberOfPaymentsPastDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfPaymentsPastDue(String value) {
        this.numberOfPaymentsPastDue = value;
    }

    /**
     * Gets the value of the maximumDelinquencyAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaximumDelinquencyAmount() {
        return maximumDelinquencyAmount;
    }

    /**
     * Sets the value of the maximumDelinquencyAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaximumDelinquencyAmount(String value) {
        this.maximumDelinquencyAmount = value;
    }

    /**
     * Gets the value of the maximumDelinquencyDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaximumDelinquencyDate() {
        return maximumDelinquencyDate;
    }

    /**
     * Sets the value of the maximumDelinquencyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaximumDelinquencyDate(String value) {
        this.maximumDelinquencyDate = value;
    }

    /**
     * Gets the value of the maximumDelinquencyMannerOfPayment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaximumDelinquencyMannerOfPayment() {
        return maximumDelinquencyMannerOfPayment;
    }

    /**
     * Sets the value of the maximumDelinquencyMannerOfPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaximumDelinquencyMannerOfPayment(String value) {
        this.maximumDelinquencyMannerOfPayment = value;
    }

    /**
     * Gets the value of the loanType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * Sets the value of the loanType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanType(String value) {
        this.loanType = value;
    }

    /**
     * Gets the value of the dateOfLastActivity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfLastActivity() {
        return dateOfLastActivity;
    }

    /**
     * Sets the value of the dateOfLastActivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfLastActivity(String value) {
        this.dateOfLastActivity = value;
    }

    /**
     * Gets the value of the remarksCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarksCode() {
        return remarksCode;
    }

    /**
     * Sets the value of the remarksCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarksCode(String value) {
        this.remarksCode = value;
    }

    /**
     * Gets the value of the tradeVerificationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeVerificationIndicator() {
        return tradeVerificationIndicator;
    }

    /**
     * Sets the value of the tradeVerificationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeVerificationIndicator(String value) {
        this.tradeVerificationIndicator = value;
    }

    /**
     * Gets the value of the datePaidOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatePaidOut() {
        return datePaidOut;
    }

    /**
     * Sets the value of the datePaidOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatePaidOut(String value) {
        this.datePaidOut = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the collateral property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollateral() {
        return collateral;
    }

    /**
     * Sets the value of the collateral property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollateral(String value) {
        this.collateral = value;
    }

    /**
     * Gets the value of the paymentPatternStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentPatternStartDate() {
        return paymentPatternStartDate;
    }

    /**
     * Sets the value of the paymentPatternStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentPatternStartDate(String value) {
        this.paymentPatternStartDate = value;
    }

    /**
     * Gets the value of the historicalCountersVerificationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHistoricalCountersVerificationIndicator() {
        return historicalCountersVerificationIndicator;
    }

    /**
     * Sets the value of the historicalCountersVerificationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHistoricalCountersVerificationIndicator(String value) {
        this.historicalCountersVerificationIndicator = value;
    }

    /**
     * Gets the value of the matchType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatchType() {
        return matchType;
    }

    /**
     * Sets the value of the matchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatchType(String value) {
        this.matchType = value;
    }

    /**
     * Gets the value of the editSequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditSequenceNumber() {
        return editSequenceNumber;
    }

    /**
     * Sets the value of the editSequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditSequenceNumber(String value) {
        this.editSequenceNumber = value;
    }

    /**
     * Gets the value of the openClosedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpenClosedIndicator() {
        return openClosedIndicator;
    }

    /**
     * Sets the value of the openClosedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpenClosedIndicator(String value) {
        this.openClosedIndicator = value;
    }

    /**
     * Gets the value of the maximumDelinquencyValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaximumDelinquencyValue() {
        return maximumDelinquencyValue;
    }

    /**
     * Sets the value of the maximumDelinquencyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaximumDelinquencyValue(String value) {
        this.maximumDelinquencyValue = value;
    }

    /**
     * Gets the value of the disputeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisputeCode() {
        return disputeCode;
    }

    /**
     * Sets the value of the disputeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisputeCode(String value) {
        this.disputeCode = value;
    }

    /**
     * Gets the value of the duplicateIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuplicateIndicator() {
        return duplicateIndicator;
    }

    /**
     * Sets the value of the duplicateIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuplicateIndicator(String value) {
        this.duplicateIndicator = value;
    }

}
