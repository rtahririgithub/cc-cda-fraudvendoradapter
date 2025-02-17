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
 * TU Sampling Format ZZ segment.
 * 
 * <p>Java class for SummaryInformationTu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SummaryInformationTu"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://fico.com/dms/fidms/cc/cdac/tu}SummaryInformationType"&gt;
 *       &lt;attribute name="MannerOfPaymentUcCounter" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MannerOfPaymentUrCounter" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MannerOfPayment099B9PCounter" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MannerOfPayment088A8D8R8PCounter" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MannerOfPayment07Counter" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MannerOfPayment05Counter" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MannerOfPayment04Counter" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MannerOfPayment03Counter" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MannerOfPayment02Counter" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MannerOfPayment01Counter" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MannerOfPayment00Counter" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="AllOtherMannerOfPaymentCounter" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NumberOfAccountsInDispute" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="CreditSummaryReportingPeriod" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NumberOfPublicRecords" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NumberOfCollections" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NumberOfNegativeTrades" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="TradesWithAnyHistoricalNegative" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="OccurrenceOfHistoricalNegatives" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NumberOfTrades" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NumberOfRevolvingAndCheckCreditTrades" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NumberOfInstallmentTrades" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NumberOfMortgageTrades" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NumberOfOpenTradeAccounts" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="NumberOfInquiries" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="CreditSummaryDescriptionType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="HighCredit" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="CreditLimit" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Balance" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="AmountPastDue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MonthlyPayment" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="PercentOfCreditAvailable" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MatchType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="EditSequenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SummaryInformationTu")
public class SummaryInformationTu
    extends SummaryInformationType
{

    @XmlAttribute(name = "MannerOfPaymentUcCounter")
    protected String mannerOfPaymentUcCounter;
    @XmlAttribute(name = "MannerOfPaymentUrCounter")
    protected String mannerOfPaymentUrCounter;
    @XmlAttribute(name = "MannerOfPayment099B9PCounter")
    protected String mannerOfPayment099B9PCounter;
    @XmlAttribute(name = "MannerOfPayment088A8D8R8PCounter")
    protected String mannerOfPayment088A8D8R8PCounter;
    @XmlAttribute(name = "MannerOfPayment07Counter")
    protected String mannerOfPayment07Counter;
    @XmlAttribute(name = "MannerOfPayment05Counter")
    protected String mannerOfPayment05Counter;
    @XmlAttribute(name = "MannerOfPayment04Counter")
    protected String mannerOfPayment04Counter;
    @XmlAttribute(name = "MannerOfPayment03Counter")
    protected String mannerOfPayment03Counter;
    @XmlAttribute(name = "MannerOfPayment02Counter")
    protected String mannerOfPayment02Counter;
    @XmlAttribute(name = "MannerOfPayment01Counter")
    protected String mannerOfPayment01Counter;
    @XmlAttribute(name = "MannerOfPayment00Counter")
    protected String mannerOfPayment00Counter;
    @XmlAttribute(name = "AllOtherMannerOfPaymentCounter")
    protected String allOtherMannerOfPaymentCounter;
    @XmlAttribute(name = "NumberOfAccountsInDispute")
    protected String numberOfAccountsInDispute;
    @XmlAttribute(name = "CreditSummaryReportingPeriod")
    protected String creditSummaryReportingPeriod;
    @XmlAttribute(name = "NumberOfPublicRecords")
    protected String numberOfPublicRecords;
    @XmlAttribute(name = "NumberOfCollections")
    protected String numberOfCollections;
    @XmlAttribute(name = "NumberOfNegativeTrades")
    protected String numberOfNegativeTrades;
    @XmlAttribute(name = "TradesWithAnyHistoricalNegative")
    protected String tradesWithAnyHistoricalNegative;
    @XmlAttribute(name = "OccurrenceOfHistoricalNegatives")
    protected String occurrenceOfHistoricalNegatives;
    @XmlAttribute(name = "NumberOfTrades")
    protected String numberOfTrades;
    @XmlAttribute(name = "NumberOfRevolvingAndCheckCreditTrades")
    protected String numberOfRevolvingAndCheckCreditTrades;
    @XmlAttribute(name = "NumberOfInstallmentTrades")
    protected String numberOfInstallmentTrades;
    @XmlAttribute(name = "NumberOfMortgageTrades")
    protected String numberOfMortgageTrades;
    @XmlAttribute(name = "NumberOfOpenTradeAccounts")
    protected String numberOfOpenTradeAccounts;
    @XmlAttribute(name = "NumberOfInquiries")
    protected String numberOfInquiries;
    @XmlAttribute(name = "CreditSummaryDescriptionType")
    protected String creditSummaryDescriptionType;
    @XmlAttribute(name = "HighCredit")
    protected String highCredit;
    @XmlAttribute(name = "CreditLimit")
    protected String creditLimit;
    @XmlAttribute(name = "Balance")
    protected String balance;
    @XmlAttribute(name = "AmountPastDue")
    protected String amountPastDue;
    @XmlAttribute(name = "MonthlyPayment")
    protected String monthlyPayment;
    @XmlAttribute(name = "PercentOfCreditAvailable")
    protected String percentOfCreditAvailable;
    @XmlAttribute(name = "MatchType")
    protected String matchType;
    @XmlAttribute(name = "EditSequenceNumber")
    protected String editSequenceNumber;

    /**
     * Gets the value of the mannerOfPaymentUcCounter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMannerOfPaymentUcCounter() {
        return mannerOfPaymentUcCounter;
    }

    /**
     * Sets the value of the mannerOfPaymentUcCounter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMannerOfPaymentUcCounter(String value) {
        this.mannerOfPaymentUcCounter = value;
    }

    /**
     * Gets the value of the mannerOfPaymentUrCounter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMannerOfPaymentUrCounter() {
        return mannerOfPaymentUrCounter;
    }

    /**
     * Sets the value of the mannerOfPaymentUrCounter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMannerOfPaymentUrCounter(String value) {
        this.mannerOfPaymentUrCounter = value;
    }

    /**
     * Gets the value of the mannerOfPayment099B9PCounter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMannerOfPayment099B9PCounter() {
        return mannerOfPayment099B9PCounter;
    }

    /**
     * Sets the value of the mannerOfPayment099B9PCounter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMannerOfPayment099B9PCounter(String value) {
        this.mannerOfPayment099B9PCounter = value;
    }

    /**
     * Gets the value of the mannerOfPayment088A8D8R8PCounter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMannerOfPayment088A8D8R8PCounter() {
        return mannerOfPayment088A8D8R8PCounter;
    }

    /**
     * Sets the value of the mannerOfPayment088A8D8R8PCounter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMannerOfPayment088A8D8R8PCounter(String value) {
        this.mannerOfPayment088A8D8R8PCounter = value;
    }

    /**
     * Gets the value of the mannerOfPayment07Counter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMannerOfPayment07Counter() {
        return mannerOfPayment07Counter;
    }

    /**
     * Sets the value of the mannerOfPayment07Counter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMannerOfPayment07Counter(String value) {
        this.mannerOfPayment07Counter = value;
    }

    /**
     * Gets the value of the mannerOfPayment05Counter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMannerOfPayment05Counter() {
        return mannerOfPayment05Counter;
    }

    /**
     * Sets the value of the mannerOfPayment05Counter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMannerOfPayment05Counter(String value) {
        this.mannerOfPayment05Counter = value;
    }

    /**
     * Gets the value of the mannerOfPayment04Counter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMannerOfPayment04Counter() {
        return mannerOfPayment04Counter;
    }

    /**
     * Sets the value of the mannerOfPayment04Counter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMannerOfPayment04Counter(String value) {
        this.mannerOfPayment04Counter = value;
    }

    /**
     * Gets the value of the mannerOfPayment03Counter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMannerOfPayment03Counter() {
        return mannerOfPayment03Counter;
    }

    /**
     * Sets the value of the mannerOfPayment03Counter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMannerOfPayment03Counter(String value) {
        this.mannerOfPayment03Counter = value;
    }

    /**
     * Gets the value of the mannerOfPayment02Counter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMannerOfPayment02Counter() {
        return mannerOfPayment02Counter;
    }

    /**
     * Sets the value of the mannerOfPayment02Counter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMannerOfPayment02Counter(String value) {
        this.mannerOfPayment02Counter = value;
    }

    /**
     * Gets the value of the mannerOfPayment01Counter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMannerOfPayment01Counter() {
        return mannerOfPayment01Counter;
    }

    /**
     * Sets the value of the mannerOfPayment01Counter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMannerOfPayment01Counter(String value) {
        this.mannerOfPayment01Counter = value;
    }

    /**
     * Gets the value of the mannerOfPayment00Counter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMannerOfPayment00Counter() {
        return mannerOfPayment00Counter;
    }

    /**
     * Sets the value of the mannerOfPayment00Counter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMannerOfPayment00Counter(String value) {
        this.mannerOfPayment00Counter = value;
    }

    /**
     * Gets the value of the allOtherMannerOfPaymentCounter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllOtherMannerOfPaymentCounter() {
        return allOtherMannerOfPaymentCounter;
    }

    /**
     * Sets the value of the allOtherMannerOfPaymentCounter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllOtherMannerOfPaymentCounter(String value) {
        this.allOtherMannerOfPaymentCounter = value;
    }

    /**
     * Gets the value of the numberOfAccountsInDispute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfAccountsInDispute() {
        return numberOfAccountsInDispute;
    }

    /**
     * Sets the value of the numberOfAccountsInDispute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfAccountsInDispute(String value) {
        this.numberOfAccountsInDispute = value;
    }

    /**
     * Gets the value of the creditSummaryReportingPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditSummaryReportingPeriod() {
        return creditSummaryReportingPeriod;
    }

    /**
     * Sets the value of the creditSummaryReportingPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditSummaryReportingPeriod(String value) {
        this.creditSummaryReportingPeriod = value;
    }

    /**
     * Gets the value of the numberOfPublicRecords property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfPublicRecords() {
        return numberOfPublicRecords;
    }

    /**
     * Sets the value of the numberOfPublicRecords property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfPublicRecords(String value) {
        this.numberOfPublicRecords = value;
    }

    /**
     * Gets the value of the numberOfCollections property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfCollections() {
        return numberOfCollections;
    }

    /**
     * Sets the value of the numberOfCollections property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfCollections(String value) {
        this.numberOfCollections = value;
    }

    /**
     * Gets the value of the numberOfNegativeTrades property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfNegativeTrades() {
        return numberOfNegativeTrades;
    }

    /**
     * Sets the value of the numberOfNegativeTrades property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfNegativeTrades(String value) {
        this.numberOfNegativeTrades = value;
    }

    /**
     * Gets the value of the tradesWithAnyHistoricalNegative property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradesWithAnyHistoricalNegative() {
        return tradesWithAnyHistoricalNegative;
    }

    /**
     * Sets the value of the tradesWithAnyHistoricalNegative property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradesWithAnyHistoricalNegative(String value) {
        this.tradesWithAnyHistoricalNegative = value;
    }

    /**
     * Gets the value of the occurrenceOfHistoricalNegatives property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccurrenceOfHistoricalNegatives() {
        return occurrenceOfHistoricalNegatives;
    }

    /**
     * Sets the value of the occurrenceOfHistoricalNegatives property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccurrenceOfHistoricalNegatives(String value) {
        this.occurrenceOfHistoricalNegatives = value;
    }

    /**
     * Gets the value of the numberOfTrades property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfTrades() {
        return numberOfTrades;
    }

    /**
     * Sets the value of the numberOfTrades property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfTrades(String value) {
        this.numberOfTrades = value;
    }

    /**
     * Gets the value of the numberOfRevolvingAndCheckCreditTrades property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfRevolvingAndCheckCreditTrades() {
        return numberOfRevolvingAndCheckCreditTrades;
    }

    /**
     * Sets the value of the numberOfRevolvingAndCheckCreditTrades property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfRevolvingAndCheckCreditTrades(String value) {
        this.numberOfRevolvingAndCheckCreditTrades = value;
    }

    /**
     * Gets the value of the numberOfInstallmentTrades property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfInstallmentTrades() {
        return numberOfInstallmentTrades;
    }

    /**
     * Sets the value of the numberOfInstallmentTrades property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfInstallmentTrades(String value) {
        this.numberOfInstallmentTrades = value;
    }

    /**
     * Gets the value of the numberOfMortgageTrades property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfMortgageTrades() {
        return numberOfMortgageTrades;
    }

    /**
     * Sets the value of the numberOfMortgageTrades property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfMortgageTrades(String value) {
        this.numberOfMortgageTrades = value;
    }

    /**
     * Gets the value of the numberOfOpenTradeAccounts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfOpenTradeAccounts() {
        return numberOfOpenTradeAccounts;
    }

    /**
     * Sets the value of the numberOfOpenTradeAccounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfOpenTradeAccounts(String value) {
        this.numberOfOpenTradeAccounts = value;
    }

    /**
     * Gets the value of the numberOfInquiries property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfInquiries() {
        return numberOfInquiries;
    }

    /**
     * Sets the value of the numberOfInquiries property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfInquiries(String value) {
        this.numberOfInquiries = value;
    }

    /**
     * Gets the value of the creditSummaryDescriptionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditSummaryDescriptionType() {
        return creditSummaryDescriptionType;
    }

    /**
     * Sets the value of the creditSummaryDescriptionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditSummaryDescriptionType(String value) {
        this.creditSummaryDescriptionType = value;
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
     * Gets the value of the balance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalance() {
        return balance;
    }

    /**
     * Sets the value of the balance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalance(String value) {
        this.balance = value;
    }

    /**
     * Gets the value of the amountPastDue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountPastDue() {
        return amountPastDue;
    }

    /**
     * Sets the value of the amountPastDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountPastDue(String value) {
        this.amountPastDue = value;
    }

    /**
     * Gets the value of the monthlyPayment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonthlyPayment() {
        return monthlyPayment;
    }

    /**
     * Sets the value of the monthlyPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonthlyPayment(String value) {
        this.monthlyPayment = value;
    }

    /**
     * Gets the value of the percentOfCreditAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPercentOfCreditAvailable() {
        return percentOfCreditAvailable;
    }

    /**
     * Sets the value of the percentOfCreditAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPercentOfCreditAvailable(String value) {
        this.percentOfCreditAvailable = value;
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

}
