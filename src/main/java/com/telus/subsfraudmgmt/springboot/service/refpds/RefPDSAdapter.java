package com.telus.subsfraudmgmt.springboot.service.refpds;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fico.afm.model.application.ApplicationResponse;
import com.fico.afm.model.application.CaseRule;
import com.fico.afm.model.application.DecisionResults;
import com.fico.afm.model.application.DecisionSummary;
import com.telus.erm.refpds.access.client.CacheLoader;
import com.telus.erm.refpds.access.client.ReferenceData;
import com.telus.erm.refpds.ws.client.BusinessRuleInstanceType;
import com.telus.erm.refpds.ws.client.CodeValueType;
import com.telus.erm.refpds.ws.client.ReferencePDSDataService;
import com.telus.erm.refpds.ws.client.ReferencePDSDataServicePortType;
import com.telus.subsfraudmgmt.api.model.watson.PredictionPredictions;
import com.telus.subsfraudmgmt.api.model.watsonsimulator.Prediction;
import com.telus.subsfraudmgmt.api.model.watsonsimulator.PredictionError;
import com.telus.subsfraudmgmt.api.model.watsonsimulator.WatsonResponseModel;
import com.telus.subsfraudmgmt.springboot.config.Config;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLog;
import com.telus.subsfraudmgmt.springboot.model.response.TPredictionResponse;
import com.telus.subsfraudmgmt.springboot.util.JsonUtil;
import com.fico.afm.model.application.Error;
import com.fico.afm.model.application.ScoreReasonCodeType;
import com.fico.afm.model.application.ScoreType;
import com.fico.afm.model.application.types.RuleDecision;

/**
 *The Rtfd tables loader
 *
 */

public class RefPDSAdapter {
	private  static final Log LOG = new CustomizedLog(RefPDSAdapter.class.getName());
    
	//use to set endpoint
	@Autowired
	private Config config;
	
	private String endPoint;
	
	//The configuration for WLS_RTFD_SIMULATOR_IND in all environments in table CREDIT_OPERATION_PARM
	private List<OperationParamRow> candidateOperationParamRows, candidateWatsonOperationParamRows;
	//simulationKeyToAfmApplicationResponseMap of simulation key to ApplicationResponse simulationKeyToAfmApplicationResponseMap in table RTFD_SIMULATOR_WLS
	private Map<String, ApplicationResponse> simulationKeyToAfmApplicationResponseMap = new HashMap<>();
	private Map<String, TPredictionResponse> watsonSimulationKeyToAfmApplicationResponseMap = new HashMap<>();
	
	//WLS_WATSON_SIMULATOR_IND
	private List<OperationParamRow> fraudAISimulatorOperationParamRows;
	//WATSON_WLS_DORMANT_FLAG
	private List<OperationParamRow> fraudAIDormantOperationParamRows;

	protected ReferencePDSDataServicePortType portType;

    @PostConstruct
	public void initializeAndLoad(){
    	LOG.info( "---in initializeAndLoad..." );
		try {
			if (this.getEndPoint()==null) {
				throw new RuntimeException("RefPDS url not set!");
			}
			//in refpds client jar
			URL wsdlUrl = RefPDSAdapter.class.getResource("/ReferencePDSDataService_v1_0.wsdl");
			ReferencePDSDataService svc = new ReferencePDSDataService(wsdlUrl,
					new QName("http://telus.com/wsdl/ERM/RefPds/ReferencePDSDataService_1", "ReferencePDSDataService"));
			this.portType = svc.getReferencePDSDataServicePort();

			((BindingProvider) portType).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.getEndPoint());

			loadAndProcess();
			 
		} catch (Exception e) {
			LOG.info("initializeAndLoad encountered exception: ", e);
		}
	}


	/**
	 * When calling PortType directly, only difference is the cast
	 * <pre>
	 * for (InstanceType instanceType: refEntity.getInstance()) {
	 *    BusinessRuleInstanceType bi = (BusinessRuleInstanceType)instanceType;
	 * }
	 **/
	private void loadAndProcess() throws Exception {
        LOG.info("Loading using url: '" + this.getEndPoint()+"'");
		CacheLoader ldr = new CacheLoader(portType);
		ReferenceData  refData = ldr.loadReferenceData("WLSTFMSvc");

		List<BusinessRuleInstanceType> bis1 = refData.getBusinessRules("CREDIT_OPERATION_PARM");
//		this.candidateWatsonOperationParamRows = new ArrayList<>();
//		this.candidateOperationParamRows = mapAndFilterAsCanidates(bis1);
		
		this.candidateOperationParamRows = mapAndFilterAsCanidates(bis1,"WLS_RTFD_SIMULATOR_IND");
		this.fraudAISimulatorOperationParamRows= mapAndFilterAsCanidates(bis1,"WLS_WATSON_SIMULATOR_IND");
		this.fraudAIDormantOperationParamRows = mapAndFilterAsCanidates(bis1,"WATSON_WLS_DORMANT_FLAG");
		
/*		for(OperationParamRow opr:candidateWatsonOperationParamRows) {
			System.out.println(opr.getAppId());
			System.out.println(opr.getEnvNum());
			System.out.println(opr.getParamName());
			System.out.println(opr.getValue());
		}*/

		List<BusinessRuleInstanceType> bis2 = refData.getBusinessRules("RTFD_SIMULATOR_WLS");

		List<RtfdSimulatorRow> rtfdSimulatorRows = map(bis2);
		for (RtfdSimulatorRow row: rtfdSimulatorRows) {
			ApplicationResponse response = this.map(row);
			this.simulationKeyToAfmApplicationResponseMap.put(row.getSimulatorKey(), response);
		}
		
		List<BusinessRuleInstanceType> bis3 = refData.getBusinessRules("WATSON_SIMULATOR_WLS");

		List<WatsonSimulatorRow> watsonSimulatorRows = mapWatson(bis3);
		LOG.info(watsonSimulatorRows.size() + " rows added for Watson Simulator");
		for (WatsonSimulatorRow row: watsonSimulatorRows) {
			TPredictionResponse response = this.mapWatsonSimulatorRows(row);
			this.watsonSimulationKeyToAfmApplicationResponseMap.put(row.getSimulatorKey(), response);
		}
		
		LOG.info("Loading using url: '" + this.getEndPoint()+"' completed!");

	}
	
	//INPUT: APPL_ID=WLSCreditAssessment PARM_NM=WLS_RTFD_SIMULATOR_IND, OUTPUT: ENVIR_NM: PT02/IT01, PARM_VALUE_STR, Priority in CREDIT_OPERATION_PARM
	private List<OperationParamRow> mapAndFilterAsCanidates(List<BusinessRuleInstanceType> bis,String parm_nm) {
		List<OperationParamRow> candiates= new ArrayList<>();
		for (BusinessRuleInstanceType bi: safeList(bis)) {
			OperationParamRow row = new OperationParamRow();
			row.setPriority(bi.getPriority());
			for (CodeValueType codeValueType: bi.getInput()) {
				updateRow (codeValueType, row);
			}
			for (CodeValueType codeValueType: bi.getOutput()) {
				updateRow (codeValueType, row);
			}
//			if (row.isCandiateRow()) {
//				candiates.add(row);
//			}
			if (parm_nm.equalsIgnoreCase(row.getParamName())) {
				candiates.add(row);
			}
		}
		return candiates;


	}

	//INPUT: APPL_ID=WLSCreditAssessment PARM_NM=WLS_RTFD_SIMULATOR_IND, OUTPUT: ENVIR_NM: PT02/IT01, PARM_VALUE_STR, Priority in CREDIT_OPERATION_PARM
	private List<OperationParamRow> mapAndFilterAsCanidates(List<BusinessRuleInstanceType> bis) {
		List<OperationParamRow> candiates= new ArrayList<>();
		for (BusinessRuleInstanceType bi: safeList(bis)) {
			OperationParamRow row = new OperationParamRow();
			row.setPriority(bi.getPriority());
			for (CodeValueType codeValueType: bi.getInput()) {
				updateRow (codeValueType, row);
			}
			for (CodeValueType codeValueType: bi.getOutput()) {
				updateRow (codeValueType, row);
			}
			if (row.isCandiateRow()) {
				candiates.add(row);
			} else if(row.isWatsonCandiateRow()) {
				candidateWatsonOperationParamRows.add(row);
			}
		}
		return candiates;


	}

	private void updateRow(CodeValueType codeValueType, OperationParamRow row) {
		String code = codeValueType.getCode();
		String val = codeValueType.getValue().get(0);
	 
		if (code.equals("APPL_ID")) {
			row.setAppId(val);
		}
		else if (code.equals("PARM_NM")) {
			row.setParamName(val);
		}
		else if (code.equals("ENVIR_NM")) {
			row.setEnvNum(val);
		}
		else if (code.equals("PARM_VALUE_STR")) {
			row.setValue(val);
		}
	}

	//INPUT: SIMULATOR_KEY, SIMULATOR_KEY_DESC, output; ERR_CD, CS_RULES_FIRED_TXT, DECSN_SUM_TXT,Priority	
	private List<RtfdSimulatorRow> map(List<BusinessRuleInstanceType> bis) {
		List<RtfdSimulatorRow> resultList = new ArrayList<>();
		for (BusinessRuleInstanceType bi: safeList(bis)) {
			RtfdSimulatorRow row = new RtfdSimulatorRow();
			row.setPriority(bi.getPriority());
			for (CodeValueType codeValueType: bi.getInput()) {
				updateSimulatorRow (codeValueType, row);
			}
			for (CodeValueType codeValueType: bi.getOutput()) {
				updateSimulatorRow (codeValueType, row);
			}
			resultList.add(row);				 
		}
		return resultList;


	}

	//INPUT: SIMULATOR_KEY, SIMULATOR_KEY_DESC, output; ERROR_CD, PREDICTION_TXT, PROBABILITY_FRAUD_VALUE, PROBABILITY_NON_FRAUD_VALUE, Priority	
	private List<WatsonSimulatorRow> mapWatson(List<BusinessRuleInstanceType> bis) {
		List<WatsonSimulatorRow> resultList = new ArrayList<>();
		for (BusinessRuleInstanceType bi: safeList(bis)) {
			WatsonSimulatorRow row = new WatsonSimulatorRow();
			row.setPriority(bi.getPriority());
			for (CodeValueType codeValueType: bi.getInput()) {
				updateWatsonSimulatorRow (codeValueType, row);
			}
			for (CodeValueType codeValueType: bi.getOutput()) {
				updateWatsonSimulatorRow (codeValueType, row);
			}
			resultList.add(row);				 
		}
		return resultList;


	}

	private void updateSimulatorRow(CodeValueType codeValueType, RtfdSimulatorRow row) {
		String code = codeValueType.getCode();
		String val = codeValueType.getValue().get(0);
		 
		if (code.equals("SIMULATOR_KEY")) {
			row.setSimulatorKey(val);
		}
		else if (code.equals("SIMULATOR_KEY_DESC")) {
			row.setSimulatorKeyDesc(val);
		}
		else if (code.equals("ERR_CD")) {
			row.setErrorCd(val);
		}
		else if (code.equals("SCOR_DTLS_TXT")) {
			row.setScoreDetailsTxt(val);
		}
		else if (code.equals("CS_RULES_FIRED_TXT")) {
			row.setCaseRulesFiredTxt(val);
		}
		else if (code.equals("DECSN_SUM_TXT")) {
			
			row.setDecisionSummaryTxt(val);
			
		}
	}

	private void updateWatsonSimulatorRow(CodeValueType codeValueType, WatsonSimulatorRow row) {
		String code = codeValueType.getCode();
		String val = codeValueType.getValue().get(0);
		
//		LOG.info(code + " = " + val);
		 
		if (code.equals("SIMULATOR_KEY")) {
			row.setSimulatorKey(val);
		}
		else if (code.equals("SIMULATOR_KEY_DESC")) {
			row.setSimulatorKeyDesc(val);
		}
		else if (code.equals("ERR_CD")) {
			row.setErrorCd(val);
		}
		else if (code.equals("PREDICTION_TXT")) {
			row.setPredictionTxt(val);
		}
		else if (code.equals("PROB_FRAUD_VAL")) {
			row.setProbFraudValue(val);
		}
		else if (code.equals("PROB_NON_FRAUD_VAL")) {
			
			row.setProbNonFraudValue(val);
			
		}
	}

	private ApplicationResponse map(RtfdSimulatorRow ftfdSimulatorRow) throws Exception {

		ApplicationResponse response = new ApplicationResponse();

		if (ftfdSimulatorRow.getErrorCd() != null) {
			Error error = new Error();
			error.setCode(parseErrorCode(ftfdSimulatorRow.getErrorCd()));
			error.setName(ftfdSimulatorRow.getErrorCd());
			error.setDescription(ftfdSimulatorRow.getErrorCd());
			response.setError(error);		 
		}

		//[ModelName=NeverPayFinal][Score=450][RSNCodes=RS1|RS2], [ModelName=ThirdPartyFinal][Score=340][RSNCodes=RS3|RS4]
		if (ftfdSimulatorRow.getScoreDetailsTxt() != null) {
			String[] scoreDetailArray = ftfdSimulatorRow.getScoreDetailsTxt().split(",");
			for (String scoreDetail: scoreDetailArray) {
				response.getScore().add(this.parseScoreType(scoreDetail));
			}	 
		}

		DecisionResults decisionResults = new DecisionResults(); 

		//[ruleId=PR_MULTI_SIN][proposedDecision=REFER][decision=DCN01][createCase=Y], [ruleId=PR_WARNING_CHECK][proposedDecision=REFER][decision=DCN01][createCase=Y]
		if (ftfdSimulatorRow.getCaseRulesFiredTxt() != null) {
			String[] caseRulesFiredArray = ftfdSimulatorRow.getCaseRulesFiredTxt() .split(",");
			for (String caseRule: caseRulesFiredArray) {
				CaseRule oCaseRule = this.parseCaseRule(caseRule);
				if (oCaseRule!=null && oCaseRule.getRuleId()!=null && !oCaseRule.getRuleId().trim().isEmpty()) {
					decisionResults.getCaseRulesFired().add(oCaseRule);
				}
			}	 
		}
		decisionResults.setSummary(parseDecisionSummary (ftfdSimulatorRow.getDecisionSummaryTxt()));

		response.setDecisionResults(decisionResults);

		return response;

	}
	
	
	private TPredictionResponse mapWatsonSimulatorRows(WatsonSimulatorRow ftfdSimulatorRow) throws Exception {
		String errorCode = null;
		String errorName = "";
		String errorDescription = "";
		String predictionTxt = "";
		String probFraudValue = "";
		String probNonFraudValue = "";
		List<String> strListProbability = new ArrayList<String>();
		
		TPredictionResponse predictionResponse = new TPredictionResponse();
		com.telus.subsfraudmgmt.api.model.watson.Prediction prediction = new com.telus.subsfraudmgmt.api.model.watson.Prediction();
		com.telus.subsfraudmgmt.api.model.watson.PredictionPredictions predictionList = new com.telus.subsfraudmgmt.api.model.watson.PredictionPredictions();
		com.telus.subsfraudmgmt.api.model.watson.Error predictionError = new com.telus.subsfraudmgmt.api.model.watson.Error();
		com.telus.subsfraudmgmt.api.model.watson.ErrorErrors anError  = new  com.telus.subsfraudmgmt.api.model.watson.ErrorErrors();

		//WatsonResponseModel watsonModel = new WatsonResponseModel();
		//PredictionError predictionErrorList = new PredictionError();
		
		//com.telus.subsfraudmgmt.api.model.watson.Prediction singlePredictionModel = new com.telus.subsfraudmgmt.api.model.watson.Prediction();
		predictionList.addFieldsItem("prediction");
		predictionList.addFieldsItem("probability");

		if (ftfdSimulatorRow.getErrorCd() != null && !ftfdSimulatorRow.getErrorCd().equalsIgnoreCase("")) {
			errorCode = ftfdSimulatorRow.getErrorCd();
			errorName = ftfdSimulatorRow.getSimulatorKey();
		    errorDescription = ftfdSimulatorRow.getSimulatorKeyDesc();
		    anError.setCode(errorCode);
		    anError.setMessage(errorDescription);
		    predictionError.addErrorsItem(anError);
			LOG.info(errorCode);
		}
		else {

			if (ftfdSimulatorRow.getPredictionTxt() != null) {
				predictionTxt = ftfdSimulatorRow.getPredictionTxt();
				predictionList.addValuesItem(predictionTxt);
			}
	
			if (ftfdSimulatorRow.getProbFraudValue() != null) {
				probFraudValue = ftfdSimulatorRow.getProbFraudValue();
				strListProbability.add(probFraudValue);
			}
	
			if (ftfdSimulatorRow.getProbNonFraudValue() != null) {
				probNonFraudValue = ftfdSimulatorRow.getProbNonFraudValue();
				strListProbability.add(probNonFraudValue);
			}
			predictionList.addValuesItem(strListProbability);
			prediction.addPredictionsItem(predictionList);
		}
		
		predictionResponse.setFraudPredictionResponseError(predictionError);
		predictionResponse.setFraudPredictionResponse(prediction);

		String json = JsonUtil.generateJsonWithDefaultObjectMapper(predictionResponse);
		LOG.info("json=" + json);
		

		return predictionResponse;
	}
	
	
//	private WatsonResponseModel mapWatsonSimulatorRows(WatsonSimulatorRow ftfdSimulatorRow) throws Exception {
//		String errorCode = null;
//		String errorName = "";
//		String errorDescription = "";
//		String predictionTxt = "";
//		String probFraudValue = "";
//		String probNonFraudValue = "";
//
//		WatsonResponseModel watsonModel = new WatsonResponseModel();
//		List<Prediction> predictionsList = new ArrayList<>();
//		PredictionError predictionErrorList = new PredictionError();
//		
//		
//		Prediction singlePredictionModel = new Prediction();
//		List<String> predictionListFields = Arrays.asList("prediction", "probability");
//		List<List<Object>> predictionListValues = new ArrayList<List<Object>>();
//		
//		List<Object> predictionTxtValuesList = new ArrayList<>();
//		List<Object> probabilityValuesList = new ArrayList<>();
//		
//
//		if (ftfdSimulatorRow.getErrorCd() != null && !ftfdSimulatorRow.getErrorCd().equalsIgnoreCase("")) {
//			errorCode = ftfdSimulatorRow.getErrorCd();
//			errorName = ftfdSimulatorRow.getSimulatorKey();
//		    errorDescription = ftfdSimulatorRow.getSimulatorKeyDesc();
//			predictionErrorList.setCode(errorCode);
//			predictionErrorList.setName(errorName);
//			predictionErrorList.setDescription(errorDescription);
//			LOG.info(errorCode);
//		}
//		else {
//
//			if (ftfdSimulatorRow.getPredictionTxt() != null) {
//				predictionTxt = ftfdSimulatorRow.getPredictionTxt();
//				predictionTxtValuesList.add(predictionTxt);
//			}
//	
//			if (ftfdSimulatorRow.getProbFraudValue() != null) {
//				probFraudValue = ftfdSimulatorRow.getProbFraudValue();
//				probabilityValuesList.add(probFraudValue);
//			}
//	
//			if (ftfdSimulatorRow.getProbNonFraudValue() != null) {
//				probNonFraudValue = ftfdSimulatorRow.getProbNonFraudValue();
//				probabilityValuesList.add(probNonFraudValue);
//			}
//			
//			predictionTxtValuesList.add(probabilityValuesList);
//			predictionListValues.add(predictionTxtValuesList);
//			singlePredictionModel.setFields(predictionListFields);
//			singlePredictionModel.setValues(predictionListValues);
//		}
//		
//		
//		predictionsList.add(singlePredictionModel);
//		
//		watsonModel.setPredictions(predictionsList);
//		watsonModel.setPredictionError(predictionErrorList);
//
//		String json = JsonUtil.generateJsonWithDefaultObjectMapper(watsonModel);
//		LOG.info("json=" + json);
//		
//
//		return watsonModel;
//	}
	
/*
	private String mapWatsonSimulatorRows(WatsonSimulatorRow ftfdSimulatorRow) throws Exception {
		String errorCode = null;
		String errorName = "";
		String errorDescription = "";
		String predictionTxt = "";
		String probFraudValue = "";
		String probNonFraudValue = "";
		String response = "{\r\n" + 
				"   \"predictions\": [\r\n" + 
				"       {\r\n" + 
				"           \"fields\": [\r\n" + 
				"               \"prediction\",\r\n" + 
				"               \"probability\"\r\n" + 
				"           ],\r\n" + 
				"           \"values\": [\r\n" + 
				"               [\r\n" + 
				"                  \""+ predictionTxt + "\",\r\n" + 
				"                   [" + probFraudValue + ", " + probNonFraudValue + "]\r\n" + 
				"               ]\r\n" + 
				"           ]\r\n" + 
				"	     }\r\n" + 
				"	 ]\r\n" + 
				"}\r\n" + 
				"";

		WatsonModel wm = new WatsonModel();
		Prediction pp = new Prediction();
		PredictionError pe = new PredictionError();
		
		
		List<String> fields = Arrays.asList("prediction", "probability");
		List<List<Object>> values = new ArrayList<List<Object>>();
		
		List<Object> pred_txt = new ArrayList<>();
		List<Object> prob_values = new ArrayList<>();
		

		if (ftfdSimulatorRow.getErrorCd() != null && !ftfdSimulatorRow.getErrorCd().equalsIgnoreCase("")) {
			Error error = new Error();
			error.setCode(parseErrorCode(ftfdSimulatorRow.getErrorCd()));
			error.setName(ftfdSimulatorRow.getErrorCd());
			error.setDescription(ftfdSimulatorRow.getErrorCd());
			errorCode = ftfdSimulatorRow.getErrorCd();
			errorName = ftfdSimulatorRow.getSimulatorKey();
		    errorDescription = ftfdSimulatorRow.getSimulatorKeyDesc();
			
			
			
			LOG.info(errorCode);
			
		}

		if (ftfdSimulatorRow.getPredictionTxt() != null) {
			predictionTxt = ftfdSimulatorRow.getPredictionTxt();
			
			
			
			pred_txt.add(predictionTxt);
			
		}

		if (ftfdSimulatorRow.getProbFraudValue() != null) {
			probFraudValue = ftfdSimulatorRow.getProbFraudValue();
			prob_values.add(probFraudValue);
		}
		if (ftfdSimulatorRow.getProbNonFraudValue() != null) {
			probNonFraudValue = ftfdSimulatorRow.getProbNonFraudValue();
			prob_values.add(probNonFraudValue);
		}
		
		
		
		
		
		pp.setFields(fields);
		
		pred_txt.add(prob_values);
		values.add(pred_txt);
		
		
		pp.setValues(values);
		
		List<Prediction> predictionsList = new ArrayList<>();
		predictionsList.add(pp);
		
		wm.setPredictions(predictionsList);
		
		pe.setCode(errorCode);
		pe.setName(errorName);
		pe.setDescription(errorDescription);
		wm.setPredictionError(pe);
		String json = JsonUtil.generateJsonWithDefaultObjectMapper(wm);
		LOG.info("json=" + json);
		

		return response;

	}
*/
	//based on pattern ERR_01 pattern 
	private short parseErrorCode(String erroCode) throws Exception {

		String pattern = "ERR_(\\d+)";
		Pattern r = Pattern.compile(pattern);

		Matcher m = r.matcher(erroCode);
		if (m.find()) {
			String result = m.group(1);
			if (result!=null && !result.trim().isEmpty()) {
				return Short.parseShort(m.group(1));
			}
		}
		return 0;

	}
		
	//[caseRulesDecision=true][blacklistMatchingRulesCount=0] 	
	private DecisionSummary parseDecisionSummary(String decisionSummaryTxt) throws Exception {
		if (decisionSummaryTxt==null || decisionSummaryTxt.trim().isEmpty()) {
			return null;
		}
		DecisionSummary decisonSummary = new DecisionSummary();
		String pattern = "\\[caseRulesDecision=(.*?)\\]\\[blacklistMatchingRulesCount=(.*)\\]";
		boolean containsCaseRulesDecison = decisionSummaryTxt.contains("caseRulesDecision");
		if (!containsCaseRulesDecison) {
			pattern = "\\[blacklistMatchingRulesCount=(.*)\\]";
		}
		Pattern r =Pattern.compile(pattern);

		Matcher m = r.matcher(decisionSummaryTxt);
		while (m.find()) {
			//has to be in m.find()
			if (!containsCaseRulesDecison) {
				decisonSummary.setBlacklistMatchingRulesCount(Integer.parseInt(m.group(1)));
			}
			else {
				decisonSummary.setCaseRulesDecision( m.group(1));
				decisonSummary.setBlacklistMatchingRulesCount(Integer.parseInt(m.group(2)));
			}

		}
		return decisonSummary;


	}
	//[ruleId=PR_HOTLIST_CC][description=Applicant Credit card matched against CC hotlist][proposedDecision=Refer][decision=FRAUD][createCase=Y]
	private CaseRule parseCaseRule(String caseRuleTxt) {
		CaseRule caseRule = new CaseRule();
		String pattern = "\\[ruleId=(.*?)\\]\\[description=(.*?)\\]\\[proposedDecision=(.*?)\\]\\[decision=(.*?)\\]\\[createCase=(.*?)\\]";
		Pattern r =Pattern.compile(pattern);

		Matcher m = r.matcher(caseRuleTxt);

		while (m.find()) {
			//has to be in m.find()
			caseRule.setRuleId(m.group(1));
			caseRule.setDescription(m.group(2));
			caseRule.setProposedDecision(m.group(3));
			//RuleDecision is CLEAR, SUSPECT, FRAUD, TO_BE_INVESTIGATED which has changed to accord with this
			caseRule.setDecision(RuleDecision.valueOf(m.group(4)));
			caseRule.setCreateCase(m.group(5));

		}
		return caseRule;
	}

	//[ModelName=NeverPayFinal][Score=450][RSNCodes=RS1|RS2]
	private ScoreType parseScoreType(String scoreDetailTxt) {

		ScoreType scoreType = new ScoreType();
		String pattern = "\\[ModelName=(.*?)\\]\\[Score=(.*?)\\]\\[RSNCodes=(.*?)\\]";
		Pattern r =Pattern.compile(pattern);

		Matcher m = r.matcher(scoreDetailTxt);

		while (m.find()) {
			//has to be in m.find()
			scoreType.setModelName(m.group(1));
			scoreType.setScore(Short.parseShort((m.group(2))));
			String reasonCodes = m.group(3);
			if(reasonCodes !=null) {
				scoreType.getReasonCodes().addAll(parseReasonCodes(reasonCodes));
			}

		}
		return scoreType;
	}


	private List<ScoreReasonCodeType> parseReasonCodes(String reasonCodesTxt) {

		List<ScoreReasonCodeType> resultCodes= new ArrayList<>();
		//has to escape |
		String[] reasonCodes = reasonCodesTxt.split("\\|");
		for (String reasonCode: reasonCodes) {
			ScoreReasonCodeType o = new ScoreReasonCodeType();
			o.setName(reasonCode);
			resultCodes.add(o);
		}
		return resultCodes;
	}

	protected <T> List<T> safeList( List<T> other ) {
		return other == null ? Collections.EMPTY_LIST : other;
	}

	public List<OperationParamRow> getCandidateOperationParamRows() {
		return candidateOperationParamRows;
	}

	public void setCandidateOperationParamRows(List<OperationParamRow> candidateOperationParamRows) {
		this.candidateOperationParamRows = candidateOperationParamRows;
	}

	public void setWatsonCandidateOperationParamRows(List<OperationParamRow> candidateWatsonOperationParamRows) {
		this.candidateWatsonOperationParamRows = candidateWatsonOperationParamRows;
	}

	public List<OperationParamRow> getWatsonCandidateOperationParamRows() {
		return candidateWatsonOperationParamRows;
	}


	public Map<String, ApplicationResponse> getSimulationKeyToAfmApplicationResponseMap() {
		return simulationKeyToAfmApplicationResponseMap;
	}

	public void setSimulationKeyToAfmApplicationResponseMap(
			Map<String, ApplicationResponse> simulationKeyToAfmApplicationResponseMap) {
		this.simulationKeyToAfmApplicationResponseMap = simulationKeyToAfmApplicationResponseMap;
	}

	public Map<String, TPredictionResponse> getWatsonSimulationKeyToWatsonResponseMap() {
		return watsonSimulationKeyToAfmApplicationResponseMap;
	}

	public void setWatsonSimulationKeyToWatsonResponseMap(
			Map<String, TPredictionResponse> watsonSimulationKeyToAfmApplicationResponseMap) {
		this.watsonSimulationKeyToAfmApplicationResponseMap = watsonSimulationKeyToAfmApplicationResponseMap;
	}
	
	

	/**
	 * @return the fraudAISimulatorOperationParamRows
	 */
	public List<OperationParamRow> getFraudAISimulatorOperationParamRows() {
		return fraudAISimulatorOperationParamRows;
	}


	/**
	 * @param fraudAISimulatorOperationParamRows the fraudAISimulatorOperationParamRows to set
	 */
	public void setFraudAISimulatorOperationParamRows(List<OperationParamRow> fraudAISimulatorOperationParamRows) {
		this.fraudAISimulatorOperationParamRows = fraudAISimulatorOperationParamRows;
	}


	/**
	 * @return the fraudAIDormantOperationParamRows
	 */
	public List<OperationParamRow> getFraudAIDormantOperationParamRows() {
		return fraudAIDormantOperationParamRows;
	}

	/**
	 * @param fraudAIDormantOperationParamRows the fraudAIDormantOperationParamRows to set
	 */
	public void setFraudAIDormantOperationParamRows(List<OperationParamRow> fraudAIDormantOperationParamRows) {
		this.fraudAIDormantOperationParamRows = fraudAIDormantOperationParamRows;
	}


	public String getEndPoint() {
		if (this.endPoint !=null && !this.endPoint.isEmpty()) {
			//support testing
			return this.endPoint;
		}
		return (config !=null)? config.getRefPdsURL(): null;
	}


	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	
	

}
