package com.telus.subsfraudmgmt.springboot;

import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fico.afm.model.application.ApplicationDetails;
import com.fico.afm.model.application.ApplicationRequest;
import com.fico.afm.model.application.ApplicationResponse;
import com.telus.subsfraudmgmt.api.PredictionApi;
import com.telus.subsfraudmgmt.api.model.Entity;
import com.telus.subsfraudmgmt.api.model.FraudCheckPerform;
import com.telus.subsfraudmgmt.api.model.watson.Prediction;
import com.telus.subsfraudmgmt.api.model.watson.PredictionPerform;
import com.telus.subsfraudmgmt.api.model.watson.PredictionPerformInputData;
import com.telus.subsfraudmgmt.api.model.watsonsimulator.WatsonResponseModel;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.FraudCheckPerformAggregateMapper;
import com.telus.subsfraudmgmt.api.modelvalidator.FraudCheckPerformValidator;
import com.telus.subsfraudmgmt.springboot.config.Config;
import com.telus.subsfraudmgmt.springboot.config.Config.WebService;
import com.telus.subsfraudmgmt.springboot.controller.FraudCheckAdapterController;
import com.telus.subsfraudmgmt.springboot.model.request.TApplicationRequest;
//import com.telus.subsfraudmgmt.springboot.config.SubsFraudMgmtSvcSecurityConfig;
//import com.telus.subsfraudmgmt.springboot.mybatis.FraudTransactionMapper;
import com.telus.subsfraudmgmt.springboot.service.CryptoService;
import com.telus.subsfraudmgmt.springboot.util.AFMXmlUtil;
import com.telus.subsfraudmgmt.springboot.util.JsonUtil;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer.ObjectMapperType;

import io.swagger.RFC3339DateFormat;
/**
 * Introduced to warm up class loading in order to reduce the delay for first request after server up.
 * <p>Warm up include spring validation, xml jaxb binding context. Others include json, encryption, Mybatis.
 * <p>When server changes, tomcat related stuff can be removed.
 * @author Harry Xu 
 *
 */
@Component
//@Profile("!test")
public class AppStartupRunner implements ApplicationRunner {
	
	private static final Log LOG = LogFactory.getLog(AppStartupRunner.class);
	
	//@Autowired
	//private SubsFraudMgmtSvcSecurityConfig subsFraudMgmtSvcSecurityConfig;

	//@Autowired
	//private CryptoService cryptoService;

	//@Autowired
	//private FraudTransactionMapper fraudCheckTransactionMapper;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		LOG.info("--- AppStartupRunner run(..) ---");
		/*
		LOG.info("	--- web security warmup ---");
		try {	
			UsernamePasswordAuthenticationToken authReq= new UsernamePasswordAuthenticationToken("warmer", "***");
			Authentication auth = subsFraudMgmtSvcSecurityConfig.authenticationManagerBean().authenticate(authReq);	
		}catch (Exception e) {		 
		}
		*/
		LOG.info("	--- web security warmup done ---");	
		
		LOG.info("	--- jaxb context init ---");
		try {	
			//to make it fast even for first call 			
			DocumentBuilderFactory.newInstance();
			AFMXmlUtil.getJAXBContext(ApplicationRequest.class);
			AFMXmlUtil.getJAXBContext(ApplicationResponse.class);
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("	--- jaxb context init done ---");		
		
		LOG.info("	--- json object mapper warmup ---");
		try {		
			for (ObjectMapperType type: ObjectMapperType.values()) {
				ObjectMapperConfigurer.getConfiguredObjectMapper(type);
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("	--- json object mapper warmup done ---");

		LOG.info("	--- validation, encryption , mapstructwarmup ---");
		try {
			//warm up dates
			OffsetDateTime.now();
			OffsetDateTime.parse("2016-01-05T01:09:23.056Z");
			DateTimeFormatter.ISO_OFFSET_DATE.toFormat();
			 
			warmupFraudCheck();			
		}catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("	--- validation, encryption , mapstructwarmup done ---");	

		LOG.info("	--- Mybatis warmup ---");
		try {	
			//this.fraudCheckTransactionMapper.ping();
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("	--- Mybatis warmup done ---");	
		LOG.info("--- AppStartupRunner run(..) all done ---");
	}

	private void warmupFraudCheck() {

		FraudCheckPerform fraudCheckPerform = FraudCheckPerformDummyBuilder.build();
/*
		try {
			ObjectMapper om = buildRightObjectMapper();
			String json = JsonUtil.generateJson(fraudCheckPerform, om);
			JsonUtil.fromJson(json, FraudCheckPerform.class,  om);

			String encrypted=cryptoService.encryptJsonSecureValues(json);
			String decrypted=cryptoService.decryptJsonSecureValues(encrypted);
		}catch (Exception e) {
			e.printStackTrace();
		}
*/
		try {
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<Object>> violations = validator.validate(fraudCheckPerform);

			fraudCheckPerform.toString();
			List<String> validationMessages = FraudCheckPerformValidator.INSTANCE.validate(fraudCheckPerform);
		}catch (Exception e) {
			e.printStackTrace();
		}

		try {
			ApplicationRequest applicationRequest = FraudCheckPerformAggregateMapper.INSTANCE.fromFraudCheckPerformToApplicationRequest(fraudCheckPerform);
		    
		}catch (Exception e) {
			e.printStackTrace();
		}

		warmupPredictionApi();
		
		warmupAFMAPI();
		
	}
	@Autowired
	FraudCheckAdapterController aFraudCheckAdapterController;
	
	@Autowired
	ObjectMapper objectMapper;
	private void warmupPredictionApi() {
		

		
		PredictionPerform predictionPerform = new PredictionPerform();
		java.util.List<PredictionPerformInputData> inputData = new java.util.ArrayList<PredictionPerformInputData>();
		PredictionPerformInputData aInputData= new PredictionPerformInputData();
		
		List<Object> fields =new java.util.ArrayList<Object>();
		fields.add("warmup");
		aInputData.setFields(fields);
		
		List<Object> values =new java.util.ArrayList<Object>();
		aInputData.setValues(values);
		
		inputData.add(aInputData);

		predictionPerform.setInputData(inputData);
		
		
        String dummyWarmupJsonRequest = "{\"input_data\":[{\"values\":[{\"externalApplicationId\":\"200618\",\"externalCreditAssessmentId\":\"200618\",\"applicationDateTime\":\"2021-08-18T22:11:37.237Z\",\"customer\":{\"role\":\"customer\",\"value\":{\"@type\":\"Customer\",\"@type\":\"Customer\",\"engagedParty\":{\"role\":\"individual\",\"value\":{\"@type\":\"Individual\",\"@type\":\"Individual\",\"contactMedium\":[{\"value\":{\"mediumType\":\"ADDRESS\",\"characteristic\":{\"city\":\"TORONTO\",\"country\":\"CAN\",\"postCode\":\"M3C1Z1\",\"stateOrProvince\":\"ON\",\"street1\":\"300 CONSILIUM PL\",\"streetName\":\"CONSILIUM PL\",\"civicNumber\":\"300\"}}},{\"value\":{\"mediumType\":\"EMAIL\",\"characteristic\":{\"emailAddress\":\"dasd@telus.com\"}}},{\"value\":{\"mediumType\":\"HOPH\",\"characteristic\":{\"contactType\":\"HOME\",\"phoneNumber\":\"4162342344\"}}}],\"birthDate\":\"1978-01-01T00:00:00Z\",\"givenName\":\"DUPTESTFNAMEB\",\"familyName\":\"SUPTESTLNAMEB\",\"fullName\":\"DUPTESTFNAMEB SUPTESTLNAMEB\",\"individualIdentification\":[{\"@type\":\"TelusIndividualIdentification\",\"@type\":\"TelusIndividualIdentification\",\"identificationId\":\"***\",\"identificationType\":\"CC\",\"characteristic\":[{\"@type\":\"StringCharacteristic\",\"@type\":\"StringCharacteristic\",\"name\":\"creditCardFirstSixNum\",\"value\":\"123456\"},{\"@type\":\"StringCharacteristic\",\"@type\":\"StringCharacteristic\",\"name\":\"creditCardLastFourNum\",\"value\":\"7890\"}]},{\"@type\":\"TelusIndividualIdentification\",\"@type\":\"TelusIndividualIdentification\",\"identificationId\":\"***\",\"identificationType\":\"SIN\"},{\"@type\":\"TelusIndividualIdentification\",\"@type\":\"TelusIndividualIdentification\",\"identificationId\":\"***\",\"identificationType\":\"DL\",\"validFor\":{\"endDateTime\":\"2021-01-05T01:01:03.056Z\"},\"characteristic\":[{\"@type\":\"StringCharacteristic\",\"@type\":\"StringCharacteristic\",\"name\":\"driverLicenseProvinceCd\",\"value\":\"BC\"}]},{\"@type\":\"TelusIndividualIdentification\",\"@type\":\"TelusIndividualIdentification\",\"identificationId\":\"***\",\"identificationType\":\"PASSPORT\"}]}},\"account\":[{\"value\":{\"@type\":\"TelusBillingAccount\",\"@type\":\"TelusBillingAccount\",\"billingAccountNumber\":200618,\"accountCreationDate\":\"2021-08-18T00:00:00Z\",\"brandCd\":\"TELUS\",\"accountTypeCd\":\"I\",\"accountSubTypeCd\":\"R\",\"accountStatusCd\":\"T\",\"accountStatusDate\":\"2021-08-18T00:00:00Z\",\"statusActivityCode\":\"TEN\",\"statusActivityReasonCode\":\"NB  \",\"homeProvince\":\"ON\",\"dealerRepCode\":\"A0010000010000\",\"pin\":\"1234\",\"totalProductCount\":2,\"totalExistingProductCount\":0,\"totalRequestedProductCount\":2,\"totalMatchingAccountCount\":4,\"totalProductCountForAllMatchingAccounts\":0,\"warningApproval\":{},\"creditBureauResult\":{\"creationDate\":\"2021-08-18T00:00:00Z\",\"adjudicationResult\":{\"creditClassCd\":\"D\"},\"riskIndicator\":{\"bankcrupcyInd\":false,\"secondaryRiskCd\":\"NON-FRAUD\",\"temporarySinInd\":false,\"trueThinFileInd\":false,\"noHitThinFileInd\":false}},\"creditDecisioningResult\":{\"value\":{\"creditAssessmentId\":\"656561\",\"creditAssessmentType\":\"FULL_ASSESSMENT\",\"creditAssessmentSubType\":\"ADDON\",\"clpExistingMatchingAccountInd\":false,\"creditAssessmentResultCd\":\"REFC\",\"creditAssessmentResultReasonCd\":\"CRDF-000047\",\"decisionKeys\":{\"accountTenureCd\":\"NEW\",\"collectionHistoryValueCd\":\"L\",\"wlsDelinquentInd\":false,\"ficoAccountStatusCd\":\"TENTATIVE\",\"refcApprovalGrantedInd\":false,\"refcFlagInd\":\"Y\",\"ValidDepositOverrideInd\":\"N\",\"assessmentTriggerCd\":\"ADD_ON\",\"assessmentTriggerValueCd\":\"L\",\"bureauReportExistInd\":true,\"bureauReportRequiredInd\":false,\"bureauTypeCd\":\"EQUIFAX\",\"nullBureauCreateDateInd\":\"N\",\"thinFileInd\":false},\"warnings\":[{\"warningCategoryCd\":\"IDF\",\"warningCd\":\"IDENTITY_FRAUD_01\",\"warningDetectionDate\":\"2021-08-18T00:00:00Z\",\"warningItemTypeCd\":\"DL\",\"warningStatusCd\":\"UNVERIFIED\"},{\"warningCategoryCd\":\"BCW\",\"warningCd\":\"4\",\"warningDetectionDate\":\"2021-08-18T00:00:00Z\",\"warningStatusCd\":\"UNVERIFIED\"},{\"warningCategoryCd\":\"BLF\",\"warningCd\":\"F\",\"warningDetectionDate\":\"2021-08-18T00:00:00Z\",\"warningItemTypeCd\":\"SN\",\"warningStatusCd\":\"INACTIVE\"}]}}}}],\"creditProfile\":[{\"role\":\"value\",\"value\":{\"@type\":\"TelusCreditProfile\",\"@type\":\"TelusCreditProfile\",\"creditScore\":520,\"riskLevelNumber\":400,\"riskLevelDecisionCd\":\"TNSCONCM0042\",\"creditClassCd\":\"D\",\"creditDecisionCd\":\"TGTNELCM0028\",\"creditProgramName\":\"DEP\",\"bureauDecisionCode\":\"TDF\",\"averageSecurityDepositList\":0,\"bureauReportAttachment\":{\"value\":{\"@type\":\"Attachment\",\"@type\":\"Attachment\",\"attachmentType\":\"json\",\"contentSourceCode\":\"EQUIFAX\",\"content\":\"[\\r\\n  [\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"header\\\": {\\r\\n        \\\"languageIndicator\\\": \\\"E\\\",\\r\\n        \\\"alertIndicatorFlag\\\": \\\"N\\\",\\r\\n        \\\"reportType\\\": \\\"FULL\\\",\\r\\n        \\\"subjectSuffix\\\": \\\"\\\",\\r\\n        \\\"customerReferenceNumber\\\": \\\"36787923\\\",\\r\\n        \\\"cardAlertFlag\\\": \\\"\\\",\\r\\n        \\\"outputFormatCode\\\": \\\"E\\\",\\r\\n        \\\"ecoaInquiryType\\\": \\\"I\\\",\\r\\n        \\\"safescanIdByte2\\\": \\\"\\\",\\r\\n        \\\"equifaxMemberNumber\\\": \\\"451UT00411\\\",\\r\\n        \\\"dateOfLastActivity\\\": \\\"12172019\\\",\\r\\n        \\\"safescanByte1\\\": \\\"0\\\",\\r\\n        \\\"subjectLastName\\\": \\\"ROBERTS\\\",\\r\\n        \\\"subjectSin\\\": \\\"***\\\",\\r\\n        \\\"subjectMiddleName\\\": \\\"CLARK\\\",\\r\\n        \\\"subjectDateOfBirth\\\": \\\"04061982\\\",\\r\\n        \\\"multipleFileIndicator\\\": \\\"0\\\",\\r\\n        \\\"depositAlertFlag\\\": \\\"\\\",\\r\\n        \\\"consumerReferralCode\\\": \\\"045\\\",\\r\\n        \\\"fileSinceDate\\\": \\\"04262002\\\",\\r\\n        \\\"spouseFirstName\\\": \\\"\\\",\\r\\n        \\\"hitNoHitDesignatorCode\\\": \\\"1\\\",\\r\\n        \\\"subjectFirstName\\\": \\\"ZACHARY\\\",\\r\\n        \\\"dateOfThisReport\\\": \\\"02132020\\\",\\r\\n        \\\"creditFileWarningMessage\\\": \\\"\\\",\\r\\n        \\\"segmentCounters\\\": \\\"01010104000001010100000001030000000000000000040000000000210001\\\",\\r\\n        \\\"totalNumberOfInquiries\\\": \\\"\\\"\\r\\n      },\\r\\n      \\\"warning\\\": {}\\r\\n    }\\r\\n  ],\\r\\n  [\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"currentAddress\\\": {\\r\\n        \\\"postalCode\\\": \\\"S4T4B8\\\",\\r\\n        \\\"recordCode\\\": \\\"CA\\\",\\r\\n        \\\"province\\\": \\\"SK\\\",\\r\\n        \\\"streetNumber\\\": \\\"1400\\\",\\r\\n        \\\"streetName\\\": \\\"QUEEN ST\\\",\\r\\n        \\\"residenceSince\\\": \\\"102019\\\",\\r\\n        \\\"indicatorCode\\\": \\\"C\\\",\\r\\n        \\\"city\\\": \\\"REGINA\\\"\\r\\n      },\\r\\n      \\\"warning\\\": {}\\r\\n    }\\r\\n  ],\\r\\n  [\\r\\n    {\\r\\n      \\\"formerAddress1\\\": {\\r\\n        \\\"postalCode\\\": \\\"S4X2Z1\\\",\\r\\n        \\\"recordCode\\\": \\\"FA\\\",\\r\\n        \\\"province\\\": \\\"SK\\\",\\r\\n        \\\"streetNumber\\\": \\\"6585\\\",\\r\\n        \\\"streetName\\\": \\\"ROCHDALE BLVD APT 3\\\",\\r\\n        \\\"residenceSince\\\": \\\"012019\\\",\\r\\n        \\\"indicatorCode\\\": \\\"T\\\",\\r\\n        \\\"city\\\": \\\"REGINA\\\"\\r\\n      },\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {}\\r\\n    }\\r\\n  ],\\r\\n  [\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"formerAddress2\\\": {\\r\\n        \\\"postalCode\\\": \\\"S4P1K7\\\",\\r\\n        \\\"recordCode\\\": \\\"F2\\\",\\r\\n        \\\"province\\\": \\\"SK\\\",\\r\\n        \\\"streetNumber\\\": \\\"1651\\\",\\r\\n        \\\"streetName\\\": \\\"MONTREAL ST\\\",\\r\\n        \\\"residenceSince\\\": \\\"082014\\\",\\r\\n        \\\"indicatorCode\\\": \\\"T\\\",\\r\\n        \\\"city\\\": \\\"REGINA\\\"\\r\\n      },\\r\\n      \\\"warning\\\": {}\\r\\n    }\\r\\n  ],\\r\\n  [\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"alsoKnownAs\\\": {\\r\\n        \\\"middleName\\\": \\\"Jones\\\",\\r\\n        \\\"recordCode\\\": \\\"AK\\\",\\r\\n        \\\"lastName\\\": \\\"ROBERTS\\\",\\r\\n        \\\"firstName\\\": \\\"ZACH\\\",\\r\\n        \\\"suffix\\\": \\\"XX\\\",\\r\\n        \\\"legalNameChange\\\": \\\"\\\",\\r\\n        \\\"spouseName\\\": \\\"\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"alsoKnownAs\\\": {\\r\\n        \\\"middleName\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"AK\\\",\\r\\n        \\\"lastName\\\": \\\"ROBERTS\\\",\\r\\n        \\\"firstName\\\": \\\"ZACK\\\",\\r\\n        \\\"suffix\\\": \\\"XX\\\",\\r\\n        \\\"legalNameChange\\\": \\\"\\\",\\r\\n        \\\"spouseName\\\": \\\"\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"alsoKnownAs\\\": {\\r\\n        \\\"middleName\\\": \\\"CLARK\\\",\\r\\n        \\\"recordCode\\\": \\\"AK\\\",\\r\\n        \\\"lastName\\\": \\\"ROBERTS\\\",\\r\\n        \\\"firstName\\\": \\\"ZACK\\\",\\r\\n        \\\"suffix\\\": \\\"XX\\\",\\r\\n        \\\"legalNameChange\\\": \\\"\\\",\\r\\n        \\\"spouseName\\\": \\\"\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"alsoKnownAs\\\": {\\r\\n        \\\"middleName\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"AK\\\",\\r\\n        \\\"lastName\\\": \\\"ROBERTS\\\",\\r\\n        \\\"firstName\\\": \\\"ZACHERY\\\",\\r\\n        \\\"suffix\\\": \\\"XX\\\",\\r\\n        \\\"legalNameChange\\\": \\\"\\\",\\r\\n        \\\"spouseName\\\": \\\"\\\"\\r\\n      }\\r\\n    }\\r\\n  ],\\r\\n  [\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"currentEmployment\\\": {\\r\\n        \\\"dateLeft\\\": \\\"\\\",\\r\\n        \\\"verificationStatu\\\": \\\"\\\",\\r\\n        \\\"cityOfEmployment\\\": \\\"\\\",\\r\\n        \\\"occupation\\\": \\\"\\\",\\r\\n        \\\"monthlySalary\\\": \\\"\\\",\\r\\n        \\\"dateVerified\\\": \\\"\\\",\\r\\n        \\\"provinceOfEmployment\\\": \\\"\\\",\\r\\n        \\\"employer\\\": \\\"PEOPLE READY\\\",\\r\\n        \\\"recordCode\\\": \\\"ES\\\",\\r\\n        \\\"dateEmployed\\\": \\\"\\\"\\r\\n      }\\r\\n    }\\r\\n  ],\\r\\n  [\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"formerEmployment1\\\": {\\r\\n        \\\"dateLeft\\\": \\\"\\\",\\r\\n        \\\"verificationStatu\\\": \\\"\\\",\\r\\n        \\\"cityOfEmployment\\\": \\\"\\\",\\r\\n        \\\"occupation\\\": \\\"BUSBOY\\\",\\r\\n        \\\"monthlySalary\\\": \\\"\\\",\\r\\n        \\\"dateVerified\\\": \\\"\\\",\\r\\n        \\\"provinceOfEmployment\\\": \\\"\\\",\\r\\n        \\\"employer\\\": \\\"PRINCE ALBERT INN\\\",\\r\\n        \\\"recordCode\\\": \\\"EF\\\",\\r\\n        \\\"dateEmployed\\\": \\\"\\\"\\r\\n      },\\r\\n      \\\"warning\\\": {}\\r\\n    }\\r\\n  ],\\r\\n  [\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"formerEmployment2\\\": {\\r\\n        \\\"dateLeft\\\": \\\"\\\",\\r\\n        \\\"verificationStatu\\\": \\\"\\\",\\r\\n        \\\"cityOfEmployment\\\": \\\"\\\",\\r\\n        \\\"occupation\\\": \\\"\\\",\\r\\n        \\\"monthlySalary\\\": \\\"\\\",\\r\\n        \\\"dateVerified\\\": \\\"\\\",\\r\\n        \\\"provinceOfEmployment\\\": \\\"\\\",\\r\\n        \\\"employer\\\": \\\"SELF\\\",\\r\\n        \\\"recordCode\\\": \\\"E2\\\",\\r\\n        \\\"dateEmployed\\\": \\\"\\\"\\r\\n      }\\r\\n    }\\r\\n  ],\\r\\n  [\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"BELL MOBILITY\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"800\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"12172019\\\",\\r\\n        \\\"memberNumber\\\": \\\"481UT02445\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"5099904\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"SASK TEL\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"877\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"10302019\\\",\\r\\n        \\\"memberNumber\\\": \\\"057UT00217\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"2802395\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"VIRGIN MOBILE\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"800\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"10302019\\\",\\r\\n        \\\"memberNumber\\\": \\\"481UT02437\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"5099904\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"SASK TEL\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"877\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"09192019\\\",\\r\\n        \\\"memberNumber\\\": \\\"057UT00217\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"2802395\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"BELL MOBILITY\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"800\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"09122019\\\",\\r\\n        \\\"memberNumber\\\": \\\"481UT02445\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"5099904\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"CAP ONE\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"800\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"07232019\\\",\\r\\n        \\\"memberNumber\\\": \\\"481BB36399\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"4813239\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"HOME TRUST COMPANY\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"877\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"07022019\\\",\\r\\n        \\\"memberNumber\\\": \\\"481FS00411\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"9032133\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"BELL MOBILITY\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"800\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"10252018\\\",\\r\\n        \\\"memberNumber\\\": \\\"481UT02445\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"5099904\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"PRESIDENTS CHOICE MC\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"866\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"07142018\\\",\\r\\n        \\\"memberNumber\\\": \\\"481ON03485\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"2467262\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"PRESIDENTS CHOICE MC\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"866\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"04212018\\\",\\r\\n        \\\"memberNumber\\\": \\\"481ON02354\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"2467262\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"BELL MOBILITY\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"800\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"12292017\\\",\\r\\n        \\\"memberNumber\\\": \\\"481UT02445\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"5099904\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"VIRGIN MOBILE\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"800\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"11212017\\\",\\r\\n        \\\"memberNumber\\\": \\\"481UT02437\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"5099904\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"BELL MOBILITY\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"800\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"11212017\\\",\\r\\n        \\\"memberNumber\\\": \\\"481UT02445\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"5099904\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"BMO 2203\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"800\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"11072017\\\",\\r\\n        \\\"memberNumber\\\": \\\"481BB27274\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"2632263\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"TELUS COMMUNICATIONS\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"416\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"10252017\\\",\\r\\n        \\\"memberNumber\\\": \\\"451UT00171\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"2797844\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"PRESIDENTS CHOICE MC\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"866\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"10112017\\\",\\r\\n        \\\"memberNumber\\\": \\\"481ON02354\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"2467262\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"VIRGIN MOBILE\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"800\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"10092017\\\",\\r\\n        \\\"memberNumber\\\": \\\"481UT02437\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"5099904\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"BELL MOBILITY\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"800\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"10092017\\\",\\r\\n        \\\"memberNumber\\\": \\\"481UT02445\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"5099904\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"CAPONE BANK\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"800\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"09232017\\\",\\r\\n        \\\"memberNumber\\\": \\\"400BB17960\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"4813239\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"SASK TEL MOBILITY\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"877\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"09132017\\\",\\r\\n        \\\"memberNumber\\\": \\\"057UT00050\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"2802395\\\"\\r\\n      }\\r\\n    },\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"warning\\\": {},\\r\\n      \\\"inquiries\\\": {\\r\\n        \\\"extension\\\": \\\"\\\",\\r\\n        \\\"recordCode\\\": \\\"IQ\\\",\\r\\n        \\\"nameOfMember\\\": \\\"TDCT\\\",\\r\\n        \\\"telephoneAreaCode\\\": \\\"866\\\",\\r\\n        \\\"dateOfInquiry\\\": \\\"07052017\\\",\\r\\n        \\\"memberNumber\\\": \\\"481BB16632\\\",\\r\\n        \\\"telephoneNumber\\\": \\\"2223456\\\"\\r\\n      }\\r\\n    }\\r\\n  ],\\r\\n  [\\r\\n    {\\r\\n      \\\"error\\\": {},\\r\\n      \\\"bureauScore\\\": {\\r\\n        \\\"firstReasonCode\\\": \\\"71\\\",\\r\\n        \\\"rejectMessageCode\\\": \\\"\\\",\\r\\n        \\\"productScore\\\": \\\"00449\\\",\\r\\n        \\\"fourthReasonCode\\\": \\\"91\\\",\\r\\n        \\\"productIdentifier\\\": \\\"SC\\\",\\r\\n        \\\"thirdReasonCode\\\": \\\"83\\\",\\r\\n        \\\"recordCode\\\": \\\"BS\\\",\\r\\n        \\\"secondReasonCode\\\": \\\"55\\\",\\r\\n        \\\"reserved\\\": \\\"\\\"\\r\\n      },\\r\\n      \\\"warning\\\": {}\\r\\n    }\\r\\n  ]\\r\\n]\\r\\n\"}}}}]}},\"channel\":{\"value\":{\"@type\":\"TelusChannel\",\"@type\":\"TelusChannel\",\"channelOrganizationId\":\"wcdpTest\",\"channelTypeCd\":\"DEFAULT\",\"salesRepCd\":\"0000\",\"dealerCode\":\"A001000001\"}}}]}]}\r\n"
        		+ "";
        try {
			predictionPerform = objectMapper.readValue(dummyWarmupJsonRequest, PredictionPerform.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		try {
			aFraudCheckAdapterController.externalServicesFacade.performFraudPrediction(predictionPerform );
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	private void warmupAFMAPI() {
		TApplicationRequest tRequest = new TApplicationRequest();
		ApplicationRequest aApplicationRequest = new ApplicationRequest();
		aApplicationRequest.setId(new BigInteger("0"));
		ApplicationDetails aApplicationDetails = new ApplicationDetails();
		aApplicationDetails.setApplicationId("warmup");
		aApplicationRequest.setApplication(aApplicationDetails);;
		tRequest.setApplicationRequest(aApplicationRequest );
				
		FraudCheckPerform aFraudCheckPerform = new FraudCheckPerform();
		aFraudCheckPerform.setExternalApplicationId("warmup");
		tRequest.setFraudCheckPerform(aFraudCheckPerform);
		tRequest.setPostXml(false);
		
        String dummyWarmupJsonRequest = "{\"requestId\":\"200618\",\"applicationRequest\":{\"header\":{\"clientId\":\"RTFDCREDIT\",\"createDateTime\":\"2021-08-18T22:11:37.237+00:00\",\"gmtOffset\":0.0,\"applicationSector\":\"TELECOMMUNICATIONS\"},\"application\":{\"applicationId\":\"200618\",\"applicationDateTime\":\"2021-08-18T22:11:37.237+00:00\",\"portfolio\":\"TELUS\",\"applicationMethod\":\"OTHERS\",\"serviceRepresentativeId\":\"0000\",\"sourceCurrencyCode\":\"CAD\",\"targetCurrencyCode\":\"124\",\"currencyConversionRate\":1.0,\"applicant\":[{\"userData\":[{\"name\":\"accountCreateDate\",\"value\":\"2021-08-18T00:00:00Z\"},{\"name\":\"accountId\",\"value\":\"200618\"},{\"name\":\"assmtRsltCd\",\"value\":\"REFC\"},{\"name\":\"assmtRsltRsnCd\",\"value\":\"CRDF-000047\"},{\"name\":\"assmtTrigCd\",\"value\":\"ADD_ON\"},{\"name\":\"assmtTrigValCd\",\"value\":\"L\"},{\"name\":\"banStatus\",\"value\":\"T\"},{\"name\":\"bankruptcyInd\",\"value\":\"false\"},{\"name\":\"burDecsnCd\",\"value\":\"TDF\"},{\"name\":\"burRptExistInd\",\"value\":\"true\"},{\"name\":\"burRptRequiredInd\",\"value\":\"false\"},{\"name\":\"burTypeCd\",\"value\":\"EQUIFAX\"},{\"name\":\"cbRequestApplicantCardNumberInd\",\"value\":\"true\"},{\"name\":\"cbRequestApplicantDLInd\",\"value\":\"true\"},{\"name\":\"cbRequestApplicantNationalIDInd\",\"value\":\"true\"},{\"name\":\"cbRequestApplicantPassportInd\",\"value\":\"true\"},{\"name\":\"creditCardFirstSix\",\"value\":\"123456\"},{\"name\":\"creditCardToken\",\"value\":\"***\"},{\"name\":\"credtCardLastFour\",\"value\":\"7890\"},{\"name\":\"drivrLicnsExpDt\",\"value\":\"2021-01-05T01:01:03.056Z\"},{\"name\":\"drivrLicnsNo\",\"value\":\"***\"},{\"name\":\"drivrLicnsState\",\"value\":\"BC\"},{\"name\":\"fullNm\",\"value\":\"DUPTESTFNAMEB SUPTESTLNAMEB\"},{\"name\":\"noHitThinFileInd\",\"value\":\"false\"},{\"name\":\"nullBurCreateDateInd\",\"value\":\"N\"},{\"name\":\"passport\",\"value\":\"***\"},{\"name\":\"secndyRiskCd\",\"value\":\"NON-FRAUD\"},{\"name\":\"sinNo\",\"value\":\"***\"},{\"name\":\"statusActvCode\",\"value\":\"TEN\"},{\"name\":\"statusActvRsnCode\",\"value\":\"NB\"},{\"name\":\"tempSinInd\",\"value\":\"false\"},{\"name\":\"thinFileInd\",\"value\":\"N\"},{\"name\":\"totalDuplicateBanCounts\",\"value\":\"4\"},{\"name\":\"totalDuplicateBanSubCounts\",\"value\":\"0\"},{\"name\":\"trueThinFileInd\",\"value\":\"false\"},{\"name\":\"watson_prb_value_fraud_1\",\"value\":\"0.00455\"},{\"name\":\"watson_prb_value_nonfraud_1\",\"value\":\"0.99545\"},{\"name\":\"watson_prediction_value_1\",\"value\":\"non fraud\"}],\"name\":{\"first\":\"DUPTESTFNAMEB\",\"last\":\"SUPTESTLNAMEB\"},\"address\":[{\"userData\":[{\"name\":\"adrStreetName\",\"value\":\"CONSILIUM PL\"},{\"name\":\"civicNo\",\"value\":\"300\"},{\"name\":\"homeProvince\",\"value\":\"ON\"}],\"street1\":\"300 CONSILIUM PL\",\"city\":\"TORONTO\",\"stateOrProvince\":\"ON\",\"postalCode\":\"M3C1Z1\",\"countryCode\":\"CAN\"}],\"phone\":[{\"phoneNumber\":\"4162342344\",\"phoneType\":\"HOME\"}],\"email\":{\"emailAddress\":\"dasd@telus.com\"},\"birthDate\":\"1978-01-01T00:00:00.000+00:00\",\"gender\":\"UNKNOWN\",\"primaryIdentificationType\":\"NATIONAL_ID\",\"primaryIdentificationNumber\":\"***\",\"primaryIdentificationSupplemental\":\"***\",\"secondaryIdentificationType\":\"DRIVERS_LICENSE\",\"secondaryIdentificationNumber\":\"***\",\"secondaryIdentificationSupplemental\":\"***\",\"type\":\"PRIMARY_APPLICANT\",\"bureauReport\":[{\"type\":\"Equifax\",\"identificationNumber\":\"200618\",\"ParsedResponseList\":{\"ParsedResponse\":[{\"HeaderList\":{\"Header\":{\"SourceSegment\":\"FULL\",\"DateOfThisReport\":\"02132020\",\"BureauArfVersion\":\"E\",\"UserReference\":\"36787923\",\"SubscriberNumber\":\"451UT00411\",\"ConsumerReferralCode\":\"045\",\"MultipleFileIndicator\":\"0\",\"EcoaInquiryType\":\"I\",\"HitOrNoHitDesignatorCode\":\"1\",\"FileSinceDate\":\"04262002\",\"DateOfLastActivity\":\"12172019\",\"SegmentCounters\":\"01010104000001010100000001030000000000000000040000000000210001\",\"SafescanCode\":\"0\"}},\"IdentificationList\":{\"Identification\":[{\"SourceSegment\":\"FULL\",\"SubjectSsn\":\"***\",\"SubjectDateOfBirth\":\"04061982\"}]},\"NameOrAliasList\":{\"NameOrAlias\":[{\"SourceSegment\":\"AK\",\"LastName\":\"ROBERTS\",\"FirstName\":\"ZACH\",\"MiddleName\":\"Jones\",\"Suffix\":\"XX\"},{\"SourceSegment\":\"AK\",\"LastName\":\"ROBERTS\",\"FirstName\":\"ZACK\",\"Suffix\":\"XX\"},{\"SourceSegment\":\"AK\",\"LastName\":\"ROBERTS\",\"FirstName\":\"ZACK\",\"MiddleName\":\"CLARK\",\"Suffix\":\"XX\"},{\"SourceSegment\":\"AK\",\"LastName\":\"ROBERTS\",\"FirstName\":\"ZACHERY\",\"Suffix\":\"XX\"},{\"SourceSegment\":\"FULL\",\"LastName\":\"ROBERTS\",\"FirstName\":\"ZACHARY\",\"MiddleName\":\"CLARK\"}]},\"AddressList\":{\"Address\":[{\"SourceSegment\":\"CA\",\"StreetNumber\":\"1400\",\"StreetName\":\"QUEEN ST\",\"City\":\"REGINA\",\"State\":\"SK\",\"ZipCode\":\"S4T4B8\",\"SourceIndicator\":\"C\",\"ResidenceSince\":\"102019\"},{\"SourceSegment\":\"FA\",\"StreetNumber\":\"6585\",\"StreetName\":\"ROCHDALE BLVD APT 3\",\"City\":\"REGINA\",\"State\":\"SK\",\"ZipCode\":\"S4X2Z1\",\"SourceIndicator\":\"T\",\"ResidenceSince\":\"012019\"},{\"SourceSegment\":\"F2\",\"StreetNumber\":\"1651\",\"StreetName\":\"MONTREAL ST\",\"City\":\"REGINA\",\"State\":\"SK\",\"ZipCode\":\"S4P1K7\",\"SourceIndicator\":\"T\",\"ResidenceSince\":\"082014\"}]},\"EmploymentList\":{\"Employment\":[{\"SourceSegment\":\"ES\",\"Employer\":\"PEOPLE READY\"},{\"SourceSegment\":\"EF\",\"Employer\":\"PRINCE ALBERT INN\",\"Occupation\":\"BUSBOY\"},{\"SourceSegment\":\"E2\",\"Employer\":\"SELF\"}]},\"InquiryList\":{\"Inquiry\":[{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"12172019\",\"SubscriberNumber\":\"481UT02445\",\"SubscriberName\":\"BELL MOBILITY\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"10302019\",\"SubscriberNumber\":\"057UT00217\",\"SubscriberName\":\"SASK TEL\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"10302019\",\"SubscriberNumber\":\"481UT02437\",\"SubscriberName\":\"VIRGIN MOBILE\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"09192019\",\"SubscriberNumber\":\"057UT00217\",\"SubscriberName\":\"SASK TEL\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"09122019\",\"SubscriberNumber\":\"481UT02445\",\"SubscriberName\":\"BELL MOBILITY\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"07232019\",\"SubscriberNumber\":\"481BB36399\",\"SubscriberName\":\"CAP ONE\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"07022019\",\"SubscriberNumber\":\"481FS00411\",\"SubscriberName\":\"HOME TRUST COMPANY\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"10252018\",\"SubscriberNumber\":\"481UT02445\",\"SubscriberName\":\"BELL MOBILITY\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"07142018\",\"SubscriberNumber\":\"481ON03485\",\"SubscriberName\":\"PRESIDENTS CHOICE MC\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"04212018\",\"SubscriberNumber\":\"481ON02354\",\"SubscriberName\":\"PRESIDENTS CHOICE MC\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"12292017\",\"SubscriberNumber\":\"481UT02445\",\"SubscriberName\":\"BELL MOBILITY\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"11212017\",\"SubscriberNumber\":\"481UT02437\",\"SubscriberName\":\"VIRGIN MOBILE\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"11212017\",\"SubscriberNumber\":\"481UT02445\",\"SubscriberName\":\"BELL MOBILITY\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"11072017\",\"SubscriberNumber\":\"481BB27274\",\"SubscriberName\":\"BMO 2203\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"10252017\",\"SubscriberNumber\":\"451UT00171\",\"SubscriberName\":\"TELUS COMMUNICATIONS\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"10112017\",\"SubscriberNumber\":\"481ON02354\",\"SubscriberName\":\"PRESIDENTS CHOICE MC\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"10092017\",\"SubscriberNumber\":\"481UT02437\",\"SubscriberName\":\"VIRGIN MOBILE\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"10092017\",\"SubscriberNumber\":\"481UT02445\",\"SubscriberName\":\"BELL MOBILITY\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"09232017\",\"SubscriberNumber\":\"400BB17960\",\"SubscriberName\":\"CAPONE BANK\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"09132017\",\"SubscriberNumber\":\"057UT00050\",\"SubscriberName\":\"SASK TEL MOBILITY\"},{\"SourceSegment\":\"IQ\",\"InquiryDate\":\"07052017\",\"SubscriberNumber\":\"481BB16632\",\"SubscriberName\":\"TDCT\"}]},\"ScoringList\":{\"Scoring\":[{\"SourceSegment\":\"BS\",\"Score\":\"00449\",\"FirstReasonCode\":\"71\",\"SecondReasonCode\":\"55\",\"ThirdReasonCode\":\"83\",\"FourthReasonCode\":\"91\"}]}}],\"ReportDate\":\"2021-08-18T00:00:00.000Z\",\"Version\":\"5\"}}]}],\"applicationSectionTelco\":{\"userData\":[{\"name\":\"accPassword\",\"value\":\"1234\"},{\"name\":\"acctStatCd\",\"value\":\"T\"},{\"name\":\"acctStatDt\",\"value\":\"2021-08-18T00:00:00.000Z\"},{\"name\":\"acctSubTyp\",\"value\":\"R\"},{\"name\":\"acctTenureCd\",\"value\":\"NEW\"},{\"name\":\"acctTypCd\",\"value\":\"I\"},{\"name\":\"carSubtypCd\",\"value\":\"ADDON\"},{\"name\":\"carTypCd\",\"value\":\"FULL_ASSESSMENT\"},{\"name\":\"cbCreditClass\",\"value\":\"D\"},{\"name\":\"channel\",\"value\":\"DEFAULT\"},{\"name\":\"chnlOrgCd\",\"value\":\"wcdpTest\"},{\"name\":\"clpMatchingAcctInd\",\"value\":\"false\"},{\"name\":\"collHistValCd\",\"value\":\"L\"},{\"name\":\"crdPrgmNmCd\",\"value\":\"DEP\"},{\"name\":\"creditClassCd\",\"value\":\"D\"},{\"name\":\"creditDecsnCd\",\"value\":\"TGTNELCM0028\"},{\"name\":\"dealerRepCode\",\"value\":\"A0010000010000\"},{\"name\":\"delinqInd\",\"value\":\"false\"},{\"name\":\"ficoAcctStatCd\",\"value\":\"TENTATIVE\"},{\"name\":\"refcApprvlGrantedInd\",\"value\":\"false\"},{\"name\":\"refcFlgInd\",\"value\":\"Y\"},{\"name\":\"riskLvlDecsnCd\",\"value\":\"TNSCONCM0042\"},{\"name\":\"riskLvlNum\",\"value\":\"400\"},{\"name\":\"securDepAmt\",\"value\":\"0\"},{\"name\":\"totalExistSubNum\",\"value\":\"0\"},{\"name\":\"totalReqSubNum\",\"value\":\"2\"},{\"name\":\"totalSubNum\",\"value\":\"2\"},{\"name\":\"validDepOvrdInd\",\"value\":\"N\"},{\"name\":\"warnCatgyCd0\",\"value\":\"IDF\"},{\"name\":\"warnCd0\",\"value\":\"IDENTITY_FRAUD_01\"},{\"name\":\"warnDetectionDt0\",\"value\":\"2021-08-18T00:00:00.000Z\"},{\"name\":\"warnItemTypeCd0\",\"value\":\"DL\"},{\"name\":\"warnStatCd0\",\"value\":\"UNVERIFIED\"},{\"name\":\"warnCatgyCd1\",\"value\":\"BCW\"},{\"name\":\"warnCd1\",\"value\":\"4\"},{\"name\":\"warnDetectionDt1\",\"value\":\"2021-08-18T00:00:00.000Z\"},{\"name\":\"warnStatCd1\",\"value\":\"UNVERIFIED\"},{\"name\":\"warnCatgyCd2\",\"value\":\"BLF\"},{\"name\":\"warnCd2\",\"value\":\"F\"},{\"name\":\"warnDetectionDt2\",\"value\":\"2021-08-18T00:00:00.000Z\"},{\"name\":\"warnItemTypeCd2\",\"value\":\"SN\"},{\"name\":\"warnStatCd2\",\"value\":\"INACTIVE\"}],\"packageType\":\"INDIVIDUAL\",\"monthlyFee\":99.99,\"handsetValue\":999.99,\"dealerCode\":\"A001000001\"}}}}\r\n"
        		+ "";
        try {
        	tRequest = objectMapper.readValue(dummyWarmupJsonRequest, TApplicationRequest.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		try {
			aFraudCheckAdapterController.externalServicesFacade.performFraudCheck(tRequest );
		} catch (Exception e) {
		}
	}
	
	public ObjectMapper buildRightObjectMapper() {
		ObjectMapper objectMapper= new ObjectMapper();

		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		objectMapper.addMixIn(Entity.class, EntityMixin.class);
		RFC3339DateFormat format = new io.swagger.RFC3339DateFormat();
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		objectMapper.setDateFormat(format);
		
		return objectMapper;

	}

}
