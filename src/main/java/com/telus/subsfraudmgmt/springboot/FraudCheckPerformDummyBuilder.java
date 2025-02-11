package com.telus.subsfraudmgmt.springboot;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.telus.subsfraudmgmt.api.model.AccountRefOrValue;
import com.telus.subsfraudmgmt.api.model.AccountRelationship;
import com.telus.subsfraudmgmt.api.model.Attachment;
import com.telus.subsfraudmgmt.api.model.AttachmentRefOrValue;
import com.telus.subsfraudmgmt.api.model.ContactMedium;
import com.telus.subsfraudmgmt.api.model.ContactMediumRefOrValue;
import com.telus.subsfraudmgmt.api.model.CreditProfileRefOrValue;
import com.telus.subsfraudmgmt.api.model.Customer;
import com.telus.subsfraudmgmt.api.model.CustomerRefOrValue;
import com.telus.subsfraudmgmt.api.model.FraudCheckPerform;
import com.telus.subsfraudmgmt.api.model.Individual;
import com.telus.subsfraudmgmt.api.model.MediumCharacteristic;
import com.telus.subsfraudmgmt.api.model.RelatedPartyRefOrValue;
import com.telus.subsfraudmgmt.api.model.StringCharacteristic;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccount;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccountCreditBureauResult;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccountCreditBureauResultAdjudicationResult;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccountCreditBureauResultRiskIndicator;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccountWarningApproval;
import com.telus.subsfraudmgmt.api.model.TelusChannel;
import com.telus.subsfraudmgmt.api.model.TelusChannelRefOfValue;
import com.telus.subsfraudmgmt.api.model.TelusCreditDecisioningResult;
import com.telus.subsfraudmgmt.api.model.TelusCreditDecisioningResultDecisionKeys;
import com.telus.subsfraudmgmt.api.model.TelusCreditDecisioningResultReOrValue;
import com.telus.subsfraudmgmt.api.model.TelusCreditDecisioningWarning;
import com.telus.subsfraudmgmt.api.model.TelusCreditProfile;
import com.telus.subsfraudmgmt.api.model.TelusIndividualIdentification;
import com.telus.subsfraudmgmt.api.model.TimePeriod;
/**
 * Build a dummy FraudCheckPerform object to add warm-up to the application.
 * @author Harry Xu
 *
 */

public class FraudCheckPerformDummyBuilder{

	public static FraudCheckPerform build() {
		FraudCheckPerform fraudCheckPerform = buildWithoutBureauReport();
		addBureauReport(fraudCheckPerform);
		return fraudCheckPerform;
	}



	private static void addBureauReport(FraudCheckPerform fraudCheckPerform) {
		TelusCreditProfile telusCreditProfile = new TelusCreditProfile();
		telusCreditProfile.setCreditClassCd("L");
		telusCreditProfile.bureauDecisionCode("bureauDecisionCode")
		.averageSecurityDepositList(new BigDecimal(50))
		.creditDecisionCd("creditDecisionCd")
		.creditProgramName("creditProgramName")
		.creditScore(new Integer(123));

		Attachment attachment = new Attachment();
		attachment.setAttachmentType("json");

		//source of attachment content( for instance credit bureua report source( TRANSUNION or EQUIFAX) )
		attachment.setContentSourceCode("EQUIFAX");
		String content = "[\r\n" + 
				"  [\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"header\": {\r\n" + 
				"        \"languageIndicator\": \"E\",\r\n" + 
				"        \"alertIndicatorFlag\": \"N\",\r\n" + 
				"        \"reportType\": \"FULL\",\r\n" + 
				"        \"subjectSuffix\": \"\",\r\n" + 
				"        \"customerReferenceNumber\": \"36787923\",\r\n" + 
				"        \"cardAlertFlag\": \"\",\r\n" + 
				"        \"outputFormatCode\": \"E\",\r\n" + 
				"        \"ecoaInquiryType\": \"I\",\r\n" + 
				"        \"safescanIdByte2\": \"\",\r\n" + 
				"        \"equifaxMemberNumber\": \"451UT00411\",\r\n" + 
				"        \"dateOfLastActivity\": \"12172019\",\r\n" + 
				"        \"safescanByte1\": \"0\",\r\n" + 
				"        \"subjectLastName\": \"ROBERTS\",\r\n" + 
				"        \"subjectSin\": \"651950271\",\r\n" + 
				"        \"subjectMiddleName\": \"CLARK\",\r\n" + 
				"        \"subjectDateOfBirth\": \"04061982\",\r\n" + 
				"        \"multipleFileIndicator\": \"0\",\r\n" + 
				"        \"depositAlertFlag\": \"\",\r\n" + 
				"        \"consumerReferralCode\": \"045\",\r\n" + 
				"        \"fileSinceDate\": \"04262002\",\r\n" + 
				"        \"spouseFirstName\": \"\",\r\n" + 
				"        \"hitNoHitDesignatorCode\": \"1\",\r\n" + 
				"        \"subjectFirstName\": \"ZACHARY\",\r\n" + 
				"        \"dateOfThisReport\": \"02132020\",\r\n" + 
				"        \"creditFileWarningMessage\": \"\",\r\n" + 
				"        \"segmentCounters\": \"01010104000001010100000001030000000000000000040000000000210001\",\r\n" + 
				"        \"totalNumberOfInquiries\": \"\"\r\n" + 
				"      },\r\n" + 
				"      \"warning\": {}\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  [\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"currentAddress\": {\r\n" + 
				"        \"postalCode\": \"S4T4B8\",\r\n" + 
				"        \"recordCode\": \"CA\",\r\n" + 
				"        \"province\": \"SK\",\r\n" + 
				"        \"streetNumber\": \"1400\",\r\n" + 
				"        \"streetName\": \"QUEEN ST\",\r\n" + 
				"        \"residenceSince\": \"102019\",\r\n" + 
				"        \"indicatorCode\": \"C\",\r\n" + 
				"        \"city\": \"REGINA\"\r\n" + 
				"      },\r\n" + 
				"      \"warning\": {}\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  [\r\n" + 
				"    {\r\n" + 
				"      \"formerAddress1\": {\r\n" + 
				"        \"postalCode\": \"S4X2Z1\",\r\n" + 
				"        \"recordCode\": \"FA\",\r\n" + 
				"        \"province\": \"SK\",\r\n" + 
				"        \"streetNumber\": \"6585\",\r\n" + 
				"        \"streetName\": \"ROCHDALE BLVD APT 3\",\r\n" + 
				"        \"residenceSince\": \"012019\",\r\n" + 
				"        \"indicatorCode\": \"T\",\r\n" + 
				"        \"city\": \"REGINA\"\r\n" + 
				"      },\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {}\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  [\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"formerAddress2\": {\r\n" + 
				"        \"postalCode\": \"S4P1K7\",\r\n" + 
				"        \"recordCode\": \"F2\",\r\n" + 
				"        \"province\": \"SK\",\r\n" + 
				"        \"streetNumber\": \"1651\",\r\n" + 
				"        \"streetName\": \"MONTREAL ST\",\r\n" + 
				"        \"residenceSince\": \"082014\",\r\n" + 
				"        \"indicatorCode\": \"T\",\r\n" + 
				"        \"city\": \"REGINA\"\r\n" + 
				"      },\r\n" + 
				"      \"warning\": {}\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  [\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"alsoKnownAs\": {\r\n" + 
				"        \"middleName\": \"Jones\",\r\n" + 
				"        \"recordCode\": \"AK\",\r\n" + 
				"        \"lastName\": \"ROBERTS\",\r\n" + 
				"        \"firstName\": \"ZACH\",\r\n" + 
				"        \"suffix\": \"XX\",\r\n" + 
				"        \"legalNameChange\": \"\",\r\n" + 
				"        \"spouseName\": \"\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"alsoKnownAs\": {\r\n" + 
				"        \"middleName\": \"\",\r\n" + 
				"        \"recordCode\": \"AK\",\r\n" + 
				"        \"lastName\": \"ROBERTS\",\r\n" + 
				"        \"firstName\": \"ZACK\",\r\n" + 
				"        \"suffix\": \"XX\",\r\n" + 
				"        \"legalNameChange\": \"\",\r\n" + 
				"        \"spouseName\": \"\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"alsoKnownAs\": {\r\n" + 
				"        \"middleName\": \"CLARK\",\r\n" + 
				"        \"recordCode\": \"AK\",\r\n" + 
				"        \"lastName\": \"ROBERTS\",\r\n" + 
				"        \"firstName\": \"ZACK\",\r\n" + 
				"        \"suffix\": \"XX\",\r\n" + 
				"        \"legalNameChange\": \"\",\r\n" + 
				"        \"spouseName\": \"\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"alsoKnownAs\": {\r\n" + 
				"        \"middleName\": \"\",\r\n" + 
				"        \"recordCode\": \"AK\",\r\n" + 
				"        \"lastName\": \"ROBERTS\",\r\n" + 
				"        \"firstName\": \"ZACHERY\",\r\n" + 
				"        \"suffix\": \"XX\",\r\n" + 
				"        \"legalNameChange\": \"\",\r\n" + 
				"        \"spouseName\": \"\"\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  [\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"currentEmployment\": {\r\n" + 
				"        \"dateLeft\": \"\",\r\n" + 
				"        \"verificationStatu\": \"\",\r\n" + 
				"        \"cityOfEmployment\": \"\",\r\n" + 
				"        \"occupation\": \"\",\r\n" + 
				"        \"monthlySalary\": \"\",\r\n" + 
				"        \"dateVerified\": \"\",\r\n" + 
				"        \"provinceOfEmployment\": \"\",\r\n" + 
				"        \"employer\": \"PEOPLE READY\",\r\n" + 
				"        \"recordCode\": \"ES\",\r\n" + 
				"        \"dateEmployed\": \"\"\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  [\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"formerEmployment1\": {\r\n" + 
				"        \"dateLeft\": \"\",\r\n" + 
				"        \"verificationStatu\": \"\",\r\n" + 
				"        \"cityOfEmployment\": \"\",\r\n" + 
				"        \"occupation\": \"BUSBOY\",\r\n" + 
				"        \"monthlySalary\": \"\",\r\n" + 
				"        \"dateVerified\": \"\",\r\n" + 
				"        \"provinceOfEmployment\": \"\",\r\n" + 
				"        \"employer\": \"PRINCE ALBERT INN\",\r\n" + 
				"        \"recordCode\": \"EF\",\r\n" + 
				"        \"dateEmployed\": \"\"\r\n" + 
				"      },\r\n" + 
				"      \"warning\": {}\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  [\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"formerEmployment2\": {\r\n" + 
				"        \"dateLeft\": \"\",\r\n" + 
				"        \"verificationStatu\": \"\",\r\n" + 
				"        \"cityOfEmployment\": \"\",\r\n" + 
				"        \"occupation\": \"\",\r\n" + 
				"        \"monthlySalary\": \"\",\r\n" + 
				"        \"dateVerified\": \"\",\r\n" + 
				"        \"provinceOfEmployment\": \"\",\r\n" + 
				"        \"employer\": \"SELF\",\r\n" + 
				"        \"recordCode\": \"E2\",\r\n" + 
				"        \"dateEmployed\": \"\"\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  [\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"BELL MOBILITY\",\r\n" + 
				"        \"telephoneAreaCode\": \"800\",\r\n" + 
				"        \"dateOfInquiry\": \"12172019\",\r\n" + 
				"        \"memberNumber\": \"481UT02445\",\r\n" + 
				"        \"telephoneNumber\": \"5099904\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"SASK TEL\",\r\n" + 
				"        \"telephoneAreaCode\": \"877\",\r\n" + 
				"        \"dateOfInquiry\": \"10302019\",\r\n" + 
				"        \"memberNumber\": \"057UT00217\",\r\n" + 
				"        \"telephoneNumber\": \"2802395\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"VIRGIN MOBILE\",\r\n" + 
				"        \"telephoneAreaCode\": \"800\",\r\n" + 
				"        \"dateOfInquiry\": \"10302019\",\r\n" + 
				"        \"memberNumber\": \"481UT02437\",\r\n" + 
				"        \"telephoneNumber\": \"5099904\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"SASK TEL\",\r\n" + 
				"        \"telephoneAreaCode\": \"877\",\r\n" + 
				"        \"dateOfInquiry\": \"09192019\",\r\n" + 
				"        \"memberNumber\": \"057UT00217\",\r\n" + 
				"        \"telephoneNumber\": \"2802395\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"BELL MOBILITY\",\r\n" + 
				"        \"telephoneAreaCode\": \"800\",\r\n" + 
				"        \"dateOfInquiry\": \"09122019\",\r\n" + 
				"        \"memberNumber\": \"481UT02445\",\r\n" + 
				"        \"telephoneNumber\": \"5099904\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"CAP ONE\",\r\n" + 
				"        \"telephoneAreaCode\": \"800\",\r\n" + 
				"        \"dateOfInquiry\": \"07232019\",\r\n" + 
				"        \"memberNumber\": \"481BB36399\",\r\n" + 
				"        \"telephoneNumber\": \"4813239\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"HOME TRUST COMPANY\",\r\n" + 
				"        \"telephoneAreaCode\": \"877\",\r\n" + 
				"        \"dateOfInquiry\": \"07022019\",\r\n" + 
				"        \"memberNumber\": \"481FS00411\",\r\n" + 
				"        \"telephoneNumber\": \"9032133\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"BELL MOBILITY\",\r\n" + 
				"        \"telephoneAreaCode\": \"800\",\r\n" + 
				"        \"dateOfInquiry\": \"10252018\",\r\n" + 
				"        \"memberNumber\": \"481UT02445\",\r\n" + 
				"        \"telephoneNumber\": \"5099904\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"PRESIDENTS CHOICE MC\",\r\n" + 
				"        \"telephoneAreaCode\": \"866\",\r\n" + 
				"        \"dateOfInquiry\": \"07142018\",\r\n" + 
				"        \"memberNumber\": \"481ON03485\",\r\n" + 
				"        \"telephoneNumber\": \"2467262\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"PRESIDENTS CHOICE MC\",\r\n" + 
				"        \"telephoneAreaCode\": \"866\",\r\n" + 
				"        \"dateOfInquiry\": \"04212018\",\r\n" + 
				"        \"memberNumber\": \"481ON02354\",\r\n" + 
				"        \"telephoneNumber\": \"2467262\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"BELL MOBILITY\",\r\n" + 
				"        \"telephoneAreaCode\": \"800\",\r\n" + 
				"        \"dateOfInquiry\": \"12292017\",\r\n" + 
				"        \"memberNumber\": \"481UT02445\",\r\n" + 
				"        \"telephoneNumber\": \"5099904\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"VIRGIN MOBILE\",\r\n" + 
				"        \"telephoneAreaCode\": \"800\",\r\n" + 
				"        \"dateOfInquiry\": \"11212017\",\r\n" + 
				"        \"memberNumber\": \"481UT02437\",\r\n" + 
				"        \"telephoneNumber\": \"5099904\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"BELL MOBILITY\",\r\n" + 
				"        \"telephoneAreaCode\": \"800\",\r\n" + 
				"        \"dateOfInquiry\": \"11212017\",\r\n" + 
				"        \"memberNumber\": \"481UT02445\",\r\n" + 
				"        \"telephoneNumber\": \"5099904\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"BMO 2203\",\r\n" + 
				"        \"telephoneAreaCode\": \"800\",\r\n" + 
				"        \"dateOfInquiry\": \"11072017\",\r\n" + 
				"        \"memberNumber\": \"481BB27274\",\r\n" + 
				"        \"telephoneNumber\": \"2632263\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"TELUS COMMUNICATIONS\",\r\n" + 
				"        \"telephoneAreaCode\": \"416\",\r\n" + 
				"        \"dateOfInquiry\": \"10252017\",\r\n" + 
				"        \"memberNumber\": \"451UT00171\",\r\n" + 
				"        \"telephoneNumber\": \"2797844\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"PRESIDENTS CHOICE MC\",\r\n" + 
				"        \"telephoneAreaCode\": \"866\",\r\n" + 
				"        \"dateOfInquiry\": \"10112017\",\r\n" + 
				"        \"memberNumber\": \"481ON02354\",\r\n" + 
				"        \"telephoneNumber\": \"2467262\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"VIRGIN MOBILE\",\r\n" + 
				"        \"telephoneAreaCode\": \"800\",\r\n" + 
				"        \"dateOfInquiry\": \"10092017\",\r\n" + 
				"        \"memberNumber\": \"481UT02437\",\r\n" + 
				"        \"telephoneNumber\": \"5099904\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"BELL MOBILITY\",\r\n" + 
				"        \"telephoneAreaCode\": \"800\",\r\n" + 
				"        \"dateOfInquiry\": \"10092017\",\r\n" + 
				"        \"memberNumber\": \"481UT02445\",\r\n" + 
				"        \"telephoneNumber\": \"5099904\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"CAPONE BANK\",\r\n" + 
				"        \"telephoneAreaCode\": \"800\",\r\n" + 
				"        \"dateOfInquiry\": \"09232017\",\r\n" + 
				"        \"memberNumber\": \"400BB17960\",\r\n" + 
				"        \"telephoneNumber\": \"4813239\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"SASK TEL MOBILITY\",\r\n" + 
				"        \"telephoneAreaCode\": \"877\",\r\n" + 
				"        \"dateOfInquiry\": \"09132017\",\r\n" + 
				"        \"memberNumber\": \"057UT00050\",\r\n" + 
				"        \"telephoneNumber\": \"2802395\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"warning\": {},\r\n" + 
				"      \"inquiries\": {\r\n" + 
				"        \"extension\": \"\",\r\n" + 
				"        \"recordCode\": \"IQ\",\r\n" + 
				"        \"nameOfMember\": \"TDCT\",\r\n" + 
				"        \"telephoneAreaCode\": \"866\",\r\n" + 
				"        \"dateOfInquiry\": \"07052017\",\r\n" + 
				"        \"memberNumber\": \"481BB16632\",\r\n" + 
				"        \"telephoneNumber\": \"2223456\"\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  [\r\n" + 
				"    {\r\n" + 
				"      \"error\": {},\r\n" + 
				"      \"bureauScore\": {\r\n" + 
				"        \"firstReasonCode\": \"71\",\r\n" + 
				"        \"rejectMessageCode\": \"\",\r\n" + 
				"        \"productScore\": \"00449\",\r\n" + 
				"        \"fourthReasonCode\": \"91\",\r\n" + 
				"        \"productIdentifier\": \"SC\",\r\n" + 
				"        \"thirdReasonCode\": \"83\",\r\n" + 
				"        \"recordCode\": \"BS\",\r\n" + 
				"        \"secondReasonCode\": \"55\",\r\n" + 
				"        \"reserved\": \"\"\r\n" + 
				"      },\r\n" + 
				"      \"warning\": {}\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"]\r\n" + 
				"";
		attachment.setContent(content);
		telusCreditProfile.setBureauReportAttachment(new AttachmentRefOrValue().value(attachment));

		fraudCheckPerform.getCustomer().getValue().addCreditProfileItem(new CreditProfileRefOrValue().value(telusCreditProfile).role("value"));
	}



	protected static FraudCheckPerform buildWithoutBureauReport() {
		FraudCheckPerform fraudCheckPerform = new FraudCheckPerform();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String formattedDateTime = now.format(formatter);
        
		fraudCheckPerform.externalApplicationId("extApp123")
		.externalCreditAssessmentId("12345")
		//.applicationDateTime(OffsetDateTime.now());
		.applicationDateTime(formattedDateTime);

		CustomerRefOrValue custRefOrValue = new CustomerRefOrValue().role("customer");
		fraudCheckPerform.setCustomer(custRefOrValue);

		Customer customer = new Customer();
		custRefOrValue.setValue(customer);

		AccountRefOrValue acctRefOrValue = new AccountRefOrValue();
		customer.addAccountItem(acctRefOrValue);

		TelusBillingAccount account = new TelusBillingAccount();
		acctRefOrValue.value(account);
		account.billingAccountNumber(new BigDecimal(12221));
		//account.accountCreationDate(OffsetDateTime.parse("2016-01-05T01:09:23.056Z"));
		account.accountCreationDate("2016-01-05T01:09:23.056Z");
		account.startServiceDate(OffsetDateTime.parse("2019-08-08T01:02:03.059Z"));
		account.setBrandCd("KO");
		account.setDealerRepCode("12345");
		account.setAccountTypeCd("checking");
		account.setAccountSubTypeCd("unlimited");
		account.setPin("12390");
		account.setAccountStatusCd("active");
		account.setAccountStatusDate(OffsetDateTime.now());
		account.setRevenueBandCd("testrevenueBandCodeval");
		account.setTotalProductCount(new BigDecimal(5));
		account.setTotalExistingProductCount(new BigDecimal(4));
		account.setTotalRequestedProductCount(new BigDecimal(1));

		account.totalMatchingAccountCount(new BigDecimal(21));
		account.totalProductCountForAllMatchingAccounts(new BigDecimal(22))
		.statusActivityCode("statusActivityCode")
		.statusActivityReasonCode("statusActivityReasonCode")
		.homeProvince("AB");

		TimePeriod timePeriod = new TimePeriod();
		timePeriod.startDateTime(OffsetDateTime.parse("2017-01-05T01:02:03.056Z"))
		.endDateTime(OffsetDateTime.now());

		TelusBillingAccount relationshipTentativeAccount = new TelusBillingAccount();
		account.addAccountRelationshipItem(new AccountRelationship().validFor(timePeriod).relationshipType("tentative").account(new AccountRefOrValue().value(relationshipTentativeAccount)));
		relationshipTentativeAccount.setBillingAccountNumber(new BigDecimal(123456789));
		relationshipTentativeAccount.setAccountStatusCd("T");
		//relationshipTentativeAccount.setAccountCreationDate(OffsetDateTime.parse("2017-01-05T01:02:03.056Z"));
		relationshipTentativeAccount.setAccountCreationDate(("2017-01-05T01:02:03.056Z"));

		TelusBillingAccount relationshipTentativeAccount2 = new TelusBillingAccount();
		account.addAccountRelationshipItem(new AccountRelationship().validFor(timePeriod).relationshipType("tentative").account(new AccountRefOrValue().value(relationshipTentativeAccount2)));
		relationshipTentativeAccount2.setBillingAccountNumber(new BigDecimal(123456781));
		relationshipTentativeAccount2.setAccountStatusCd("T");
		//relationshipTentativeAccount2.setAccountCreationDate(OffsetDateTime.parse("2018-01-05T01:02:03.056Z"));
		relationshipTentativeAccount2.setAccountCreationDate("2018-01-05T01:02:03.056Z");


		TelusBillingAccount relationshipOpenAccount2 = new TelusBillingAccount();
		account.addAccountRelationshipItem(new AccountRelationship().validFor(timePeriod).relationshipType("open").account(new AccountRefOrValue().value(relationshipOpenAccount2)));
		relationshipOpenAccount2.setBillingAccountNumber(new BigDecimal(22222222));
		relationshipOpenAccount2.setAccountStatusCd("O");
		//relationshipOpenAccount2.setAccountCreationDate(OffsetDateTime.parse("2020-10-05T01:02:03.056Z"));
		relationshipOpenAccount2.setAccountCreationDate("2020-10-05T01:02:03.056Z");
		relationshipOpenAccount2.setStartServiceDate(OffsetDateTime.parse("2018-08-08T01:02:03.056Z"));
		relationshipOpenAccount2.setTotalProductCount(new BigDecimal(31));
		relationshipOpenAccount2.setStatusActivityCode("activityCodeActive2");
		relationshipOpenAccount2.setStatusActivityReasonCode("statusActivityReasonCodeActive2");

		TelusBillingAccount relationshipOpenAccount = new TelusBillingAccount();
		account.addAccountRelationshipItem(new AccountRelationship().validFor(timePeriod).relationshipType("open").account(new AccountRefOrValue().value(relationshipOpenAccount)));
		relationshipOpenAccount.setBillingAccountNumber(new BigDecimal(111111111));
		relationshipOpenAccount.setAccountStatusCd("O");
		//relationshipOpenAccount.setAccountCreationDate(OffsetDateTime.parse("2018-10-05T01:02:03.056Z"));
		relationshipOpenAccount.setAccountCreationDate("2018-10-05T01:02:03.056Z");
		relationshipOpenAccount.setStartServiceDate(OffsetDateTime.parse("2019-08-08T01:02:03.056Z"));
		relationshipOpenAccount.setTotalProductCount(new BigDecimal(13));
		relationshipOpenAccount.setStatusActivityCode("activityCodeActive");
		relationshipOpenAccount.setStatusActivityReasonCode("statusActivityReasonCodeActive");





		TelusBillingAccountWarningApproval warningApproval = new TelusBillingAccountWarningApproval();
		account.setWarningApproval(warningApproval);
		warningApproval.approvalDate(OffsetDateTime.now());
		warningApproval.approvalExistInd(Boolean.TRUE);

		TelusCreditDecisioningResult telusCreditDecisioningResult = new TelusCreditDecisioningResult();
		account.creditDecisioningResult(new TelusCreditDecisioningResultReOrValue().value(telusCreditDecisioningResult));

		telusCreditDecisioningResult.clpExistingMatchingAccountInd(Boolean.TRUE);
		telusCreditDecisioningResult.creditAssessmentType("creditAssessmentType val");
		telusCreditDecisioningResult.creditAssessmentSubType("creditAssessmentSubType val");
		telusCreditDecisioningResult.creditAssessmentResultCd("creditAssessmentResultCd")
		.creditAssessmentResultReasonCd("creditAssessmentResultReasonCd");

		TelusCreditDecisioningResultDecisionKeys decisionKeys = new TelusCreditDecisioningResultDecisionKeys();
		telusCreditDecisioningResult.decisionKeys(decisionKeys);
		decisionKeys.accountTenureCd("my acctTenureCd");
		decisionKeys.collectionHistoryValueCd("collectionHistoryValueCd");
		decisionKeys.wlsDelinquentInd(Boolean.TRUE);
		decisionKeys.ficoAccountStatusCd("ficoAccountStatusCd");
		decisionKeys.refcApprovalGrantedInd(Boolean.TRUE);
		decisionKeys.refcFlagInd("refcFlagInd val");
		decisionKeys.validDepositOverrideInd("validDepositOverrideInd")
		.assessmentTriggerCd("assessmentTriggerCd")
		.assessmentTriggerValueCd("assessmentTriggerValueCd")
		.bureauReportExistInd(Boolean.TRUE)
		.bureauReportRequiredInd(Boolean.FALSE)
		.bureauTypeCd("bureauTypeCd")
		.nullBureauCreateDateInd("nullBureauCreateDateInd")
		.thinFileInd(Boolean.TRUE)
		;

		TelusCreditDecisioningWarning warning = new TelusCreditDecisioningWarning();
		telusCreditDecisioningResult.addWarningsItem(warning);
		warning.setWarningCategoryCd("warningCategoryCd");
		warning.setWarningCd("warningCd");
		warning.setWarningDetectionDate(OffsetDateTime.now());
		warning.setWarningItemTypeCd("warningItemTypeCd val");
		warning.setWarningStatusCd("warningStatusCd");

		warning = new TelusCreditDecisioningWarning();
		telusCreditDecisioningResult.addWarningsItem(warning);
		warning.setWarningCategoryCd("warningCategoryCd2");
		warning.setWarningCd("warningCd2");
		warning.setWarningDetectionDate(OffsetDateTime.now());
		warning.setWarningItemTypeCd("warningItemTypeCd val2");
		warning.setWarningStatusCd("warningStatusCd2");


		TelusBillingAccountCreditBureauResult creditBureauResult = new TelusBillingAccountCreditBureauResult();
		account.creditBureauResult(creditBureauResult);
		creditBureauResult.errorCd("creditBureauResutErrorCd");


		TelusBillingAccountCreditBureauResultRiskIndicator riskIndicator = new TelusBillingAccountCreditBureauResultRiskIndicator();
		creditBureauResult.riskIndicator(riskIndicator);
		riskIndicator.writeOffCd("writeOffCode val")
		.bankcrupcyInd(Boolean.TRUE)
		.temporarySinInd(Boolean.FALSE)
		.trueThinFileInd(Boolean.TRUE)
		.noHitThinFileInd(Boolean.TRUE)
		.secondaryRiskCd("secondaryRiskCd");

		TelusBillingAccountCreditBureauResultAdjudicationResult adjudicationResult = new TelusBillingAccountCreditBureauResultAdjudicationResult();
		creditBureauResult.setAdjudicationResult(adjudicationResult);
		adjudicationResult.setCreditClassCd("X");

		TelusChannel channel = new TelusChannel();
		fraudCheckPerform.setChannel(new TelusChannelRefOfValue().value(channel) );
		channel.setChannelOrganizationId("orgId");
		channel.setChannelTypeCd("Dealer");
		channel.setSalesRepCd("salesRepCd");
		channel.setDealerCode("123981");


		Individual individual = new Individual();
		customer.setEngagedParty(new RelatedPartyRefOrValue().role("individual").value(individual));


		individual
		.familyName("wong")
		.givenName("joe")
		.middleName("junior")
		.maritalStatus("married")
		.fullName("joe wong");
		//.birthDate(OffsetDateTime.of(LocalDateTime.of(2010, 05, 12, 05, 45), ZoneOffset.UTC));



		ContactMedium addressContactMedium = new ContactMedium().mediumType("ADDRESS");
		individual.addContactMediumItem(new ContactMediumRefOrValue().value(addressContactMedium));
		MediumCharacteristic adderssMediumCharacteristic = new MediumCharacteristic();
		addressContactMedium.characteristic(adderssMediumCharacteristic);

		adderssMediumCharacteristic.street1("street1")
		.street2("street2")
		.street3("street3")
		.street4("street4")
		.street5("street5")
		.city("city")
		.stateOrProvince("BC")
		.country("CA")
		.postCode("A1B1C2")
		.streetName("streetName")
		.civicNumber("civicNumber");

		ContactMedium emailContactMedium = new ContactMedium().mediumType("EMAIL");
		individual.addContactMediumItem(new ContactMediumRefOrValue().value(emailContactMedium));
		MediumCharacteristic emailMediumCharacteristic = new MediumCharacteristic();
		emailContactMedium.characteristic(emailMediumCharacteristic);
		emailMediumCharacteristic.emailAddress("email@yahoo.com");

		ContactMedium homePhoneContactMedium = new ContactMedium().mediumType("HOPH");
		individual.addContactMediumItem(new ContactMediumRefOrValue().value(homePhoneContactMedium));
		MediumCharacteristic homePhoneMediumCharacteristic = new MediumCharacteristic();
		homePhoneContactMedium.characteristic(homePhoneMediumCharacteristic);
		homePhoneMediumCharacteristic.phoneNumber("6041112222");
		homePhoneMediumCharacteristic.contactType("HOME");

		ContactMedium workPhoneContactMedium = new ContactMedium().mediumType("WKPH");
		individual.addContactMediumItem(new ContactMediumRefOrValue().value(workPhoneContactMedium));
		MediumCharacteristic workPhoneMediumCharacteristic = new MediumCharacteristic();
		workPhoneContactMedium.characteristic(workPhoneMediumCharacteristic);
		workPhoneMediumCharacteristic.phoneNumber("6041113333");
		workPhoneMediumCharacteristic.contactType("WORK");

		ContactMedium dayPhoneContactMedium = new ContactMedium().mediumType("DYPH");
		individual.addContactMediumItem(new ContactMediumRefOrValue().value(dayPhoneContactMedium));
		MediumCharacteristic dayPhoneMediumCharacteristic = new MediumCharacteristic();
		dayPhoneContactMedium.characteristic(dayPhoneMediumCharacteristic);
		dayPhoneMediumCharacteristic.phoneNumber("6042225555");
		dayPhoneMediumCharacteristic.contactType("MOBILE");

		TelusIndividualIdentification identification1 = new TelusIndividualIdentification();

		identification1.identificationType("CC")
		.identificationId("501222222222");
		individual.addIndividualIdentificationItem(identification1);
		StringCharacteristic characteristic = new StringCharacteristic();
		characteristic.name("creditCardFirstSixNum");
		characteristic.value("creditCardFirstSixNum");
		identification1.addCharacteristicItem(characteristic);

		characteristic = new StringCharacteristic();
		characteristic.name("creditCardLastFourNum");
		characteristic.value("creditCardLastFourNum");
		identification1.addCharacteristicItem(characteristic);


		TelusIndividualIdentification identification2 = new TelusIndividualIdentification();
		identification2.identificationType("SIN")
		.identificationId("601222222222");
		individual.addIndividualIdentificationItem(identification2);

		TelusIndividualIdentification identification3 = new TelusIndividualIdentification();
		identification3.identificationType("DL")
		.identificationId("801222222228")
		.validFor(new TimePeriod().endDateTime(OffsetDateTime.parse("2021-01-05T01:01:03.056Z")));

		individual.addIndividualIdentificationItem(identification3);
		characteristic = new StringCharacteristic();
		characteristic.name("driverLicenseProvinceCd");
		characteristic.value("driverLicenseProvinceCd");
		identification3.addCharacteristicItem(characteristic);

		TelusIndividualIdentification identification4 = new TelusIndividualIdentification();
		identification4.identificationType("PASSPORT")
		.identificationId("901222222229");
		individual.addIndividualIdentificationItem(identification4);


		return fraudCheckPerform;
	}


}
