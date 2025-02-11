package com.telus.subsfraudmgmt.springboot.model.deserializer;

import java.io.IOException;

import org.apache.commons.logging.Log;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fico.afm.model.application.BureauReport;
import com.fico.afm.model.application.BureauReportType;
import com.fico.afm.model.application.EfuBureauReport;
import com.fico.afm.model.application.OtherBureauReport;
import com.fico.afm.model.application.TuBureauReport;
import com.fico.afm.model.application.XpnBureauReport;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;

/**
 * Deserialize <code>BreauReport</code> json object to <code>BureauReport</code> concrete subclass's object, it is using existing ObjectMapper used for top object.
 * 
 * <pre>
 * In BureauReport abstract class, it tells all its concrete class which is identified by identificationNumber
 *XmlSeeAlso({
 *   EfuBureauReport.class,
 *   TuBureauReport.class,
 *   XpnBureauReport.class,
 *   OtherBureauReport.class
 * })
 * bureauReportNode={"identificationNumber":"efu208","report":"<?xml version=\"1.0\" encoding=\"UTF-16\"?>\n<report xmlns=\"http://www.fico.com/fraud/schemas\" xmlns:efu=\"http://fico.com/dms/fidms/cc/cdac/efu\" xmlns:p=\"http://www.fico.com/fraud/schemas\" xmlns:tu=\"http://fico.com/dms/fidms/cc/cdac/tu\" xmlns:types=\"http://www.fico.com/fraud/schemas/types\" xmlns:xpn=\"http://fico.com/dms/fidms/cc/cdac/xpn\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">EQUIFAX REPORT</report>","type":"EQUIFAX","bureauReport":{"parsedResponse":[{"identificationList":{"identification":[{"spouseSsn":"5298135022089602","deathDate":"032013","subjectDateOfBirth":"09151987","spouseDeathDate":"102013","genderCode":"F","maritalStatus":"M","sex":"M","numberOfDependents":"5"}]},"nameOrAliasList":{"nameOrAlias":[{"lastName":"Washington","firstName":"Robert","suffix":"III","spouseName":"Robert"},{"lastName":"Washington","firstName":"Robert","suffix":"JR","spouseName":"Robert"},{"lastName":"Washington","firstName":"Robert","suffix":"SR","spouseName":"Robert"}]},"addressList":{"address":[{"streetNumber":"45","streetName":"Lakeview Street","city":"SAINT JAMES","state":"Minnesota","zipCode":"56081","rentOwnBuy":"R","sourceIndicator":"D","residenceSince":"072001","phoneNumber":"+1-507-3715808","phoneSource":"4","phoneDate":"062004","addressVarianceIndicator":"C","poBoxFlag":"Y","apoFpoZipCodeFlag":"N","generalDeliveryFlag":"N","boxInAddressFlag":"Y","ruralRouteInAddressFlag":"Y"},{"streetNumber":"45","streetName":"Lakeview Street","city":"SAINT JAMES","state":"Minnesota","zipCode":"56081","rentOwnBuy":"R","sourceIndicator":"C","residenceSince":"022003","phoneNumber":"+1-507-3715808","phoneSource":"2","phoneDate":"082000","addressVarianceIndicator":"A","poBoxFlag":"Y","apoFpoZipCodeFlag":"Y","generalDeliveryFlag":"N","boxInAddressFlag":"Y","ruralRouteInAddressFlag":"N"}]},"tradelineList":{"tradeline":[{"deduplicate":"0","sourceSegment":"EFU","accountDesignatorCode":"A","accountType":"O","dateOpened":"092462001","currentStatus":"O","balance":"40000","pastDueAmount":"40000","times30DaysLate":"1","times60DaysLate":"1","ninetyOrMoreDayCounter":"1","numberOfMonthsReviewed":"8","paymentPattern":"1","tapeIndicator":"1","subscriberName":"Washington","subscriberNumber":"456","dateReported":"01102003","highCredit":"10000","terms":"TERMS","rateOrStatusCode":"A","rateCodeLessThanZero":"N","dateOfLastActivity":"113322002","previousRate1":"3","previousDate1":"02432000","previousRate2":"4","previousDate2":"071872000","previousRate3":"5","previousDate3":"082342004","narrativeCode1":"DD","narrativeCode2":"DD","narrativeCode3":"AA","narrativeCode4":"AA","customerNarrative":"this is a customer narrative","foreignBureauCode":"A","numericNarrativeCode1":"444","numericNarrativeCode2":"333","recentFlag":"Y","qualifiedFlag":"N","previousRateGreaterThan24Months":"5","dateOfPreviousRateGreaterThan24Months":"051242002","creditLimit":"20000","dateClosed":"102832004","dateOfMajorDelinquencyFirstReported":"071912003","activityDesignator":"A"},{"deduplicate":"1","sourceSegment":"EFU","accountDesignatorCode":"J","accountType":"R","dateOpened":"061542001","currentStatus":"I","balance":"30000","pastDueAmount":"40000","times30DaysLate":"99","times60DaysLate":"75","ninetyOrMoreDayCounter":"75","numberOfMonthsReviewed":"8","paymentPattern":"30","tapeIndicator":"1","subscriberName":"Washington","subscriberNumber":"123","dateReported":"051482003","highCredit":"10000","terms":"TERMS","rateOrStatusCode":"C","rateCodeLessThanZero":"Y","dateOfLastActivity":"102742005","previousRate1":"7","previousDate1":"04942000","previousRate2":"5","previousDate2":"03682004","previousRate3":"6","previousDate3":"082252000","narrativeCode1":"AA","narrativeCode2":"DD","narrativeCode3":"BB","narrativeCode4":"AA","customerNarrative":"this is a customer narrative","foreignBureauCode":"C","numericNarrativeCode1":"222","numericNarrativeCode2":"444","recentFlag":"Y","qualifiedFlag":"Y","previousRateGreaterThan24Months":"7","dateOfPreviousRateGreaterThan24Months":"051322005","creditLimit":"20000","dateClosed":"02372005","dateOfMajorDelinquencyFirstReported":"092602002","activityDesignator":"A"},{"deduplicate":"1","sourceSegment":"EFU","accountDesignatorCode":"J","accountType":"R","dateOpened":"02452004","currentStatus":"I","balance":"20000","pastDueAmount":"20000","times30DaysLate":"99","times60DaysLate":"1","ninetyOrMoreDayCounter":"1","numberOfMonthsReviewed":"6","paymentPattern":"1","tapeIndicator":"1","subscriberName":"Washington","subscriberNumber":"123","dateReported":"113092004","highCredit":"40000","terms":"TERMS","rateOrStatusCode":"C","rateCodeLessThanZero":"Y","dateOfLastActivity":"082162004","previousRate1":"1","previousDate1":"123632002","previousRate2":"2","previousDate2":"01162000","previousRate3":"7","previousDate3":"092482000","narrativeCode1":"BB","narrativeCode2":"CC","narrativeCode3":"BB","narrativeCode4":"BB","customerNarrative":"this is a customer narrative","foreignBureauCode":"A","numericNarrativeCode1":"222","numericNarrativeCode2":"444","recentFlag":"N","qualifiedFlag":"Y","previousRateGreaterThan24Months":"6","dateOfPreviousRateGreaterThan24Months":"041002002","creditLimit":"30000","dateClosed":"123632004","dateOfMajorDelinquencyFirstReported":"04942000","activityDesignator":"A"}]},"inquiryList":{"inquiry":[{"deduplicate":"0","sourceSegment":"ABC","inquiryDate":"2002-02-05T07:05:54","type":"123","abbreviationAndOrCustomerNumber":"IAR","subscriberNumber":"123456789","subscriberName":"Washington","inquiryText":"EFU inquiryText  sample"}]}}],"reportDate":"01/01/2014","arfVersion":"1"}}
 * 
 * </pre>
 * 
 * @author Harry Xu
 *
 */
@SuppressWarnings("serial")
public class JsonBureauReportDeserializer extends StdDeserializer<BureauReport> {

	private static final Log LOG = CustomizedLogFactory.getLog(JsonBureauReportDeserializer.class);

	public JsonBureauReportDeserializer() {
		this(null);
	}

	public JsonBureauReportDeserializer(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public BureauReport deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {

		//using the object mapper that is used for top level object
		ObjectMapper mapper = (ObjectMapper)jsonparser.getCodec();
		
		JsonNode bureauReportNode = mapper.readTree(jsonparser);
		//LOG.debug("bureauReportNode=" + bureauReportNode.toString());
		if (bureauReportNode == null) {
			return null;
		}
	 
		String type = bureauReportNode.findValue("type").asText();
		type= (type==null)? "" : type;
	
		BureauReport resultBureauReport = null;
 	
		if (type.equalsIgnoreCase(BureauReportType.EQUIFAX.toString())) {
			resultBureauReport= mapper.readValue(bureauReportNode.toString(), EfuBureauReport.class);  
		}
		else if (type.equalsIgnoreCase(BureauReportType.TRANS_UNION.toString())){
			resultBureauReport= mapper.readValue(bureauReportNode.toString(), TuBureauReport.class);			  
		}
		else if (type.equalsIgnoreCase(BureauReportType.EXPERIAN.toString())) {
			resultBureauReport= mapper.readValue(bureauReportNode.toString(), XpnBureauReport.class);			 
		}
		else {
			resultBureauReport= mapper.readValue(bureauReportNode.toString(), OtherBureauReport.class);
			 
		}
		return resultBureauReport;

	}

}