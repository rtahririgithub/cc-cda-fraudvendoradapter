package com.telus.subsfraudmgmt.api.modelmapper.afm;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.fico.afm.model.application.ApplicationResponse;
import com.fico.afm.model.application.CaseRule;
import com.fico.afm.model.application.DecisionSummary;
import com.telus.subsfraudmgmt.api.model.FraudAnalyticModelScore;
import com.telus.subsfraudmgmt.api.model.FraudCheck;
import com.telus.subsfraudmgmt.api.model.FraudCheckDecisioningError;
import com.telus.subsfraudmgmt.api.model.FraudDecisionCaseRulesFired;
import com.telus.subsfraudmgmt.api.model.FraudDecisionMatchingRulesFired;
import com.telus.subsfraudmgmt.api.model.FraudDecisionSummary;
import com.telus.subsfraudmgmt.api.modelmapper.common.MapperCommon;
import com.fico.afm.model.application.Error;
import com.fico.afm.model.application.MatchingRule;
import com.fico.afm.model.application.ScoreReasonCodeType;
import com.fico.afm.model.application.ScoreType;

@Mapper(componentModel="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@MapperConfig(unmappedTargetPolicy=ReportingPolicy.WARN)
public interface ApplicationResponseMapper extends MapperCommon {

	ApplicationResponseMapper INSTANCE = Mappers.getMapper( ApplicationResponseMapper.class );

	//Top level
	@Mapping(source = "error", target = "decisioningError", qualifiedByName = "fromErrorToDecisionError")
	@Mapping(source = "score", target = "fraudAnalyticModelScore")
	@Mapping(source = "decisionResults.summary", target = "fraudDecisioningRuleResult.fraudDecisionSummary")
	@Mapping(source = "decisionResults.caseRulesFired", target = "fraudDecisioningRuleResult.fraudDecisionCaseRulesFired")
	@Mapping(source = "decisionResults.matchingRulesFired", target = "fraudDecisioningRuleResult.fraudDecisionMatchingRulesFired")
	FraudCheck applicationResponseToFraudCheck(ApplicationResponse applicationResponse);
	
	//sub map Error to FraudCheckDecisioningError
	@Mapping(source = "code", target = "code")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "description", target = "description")
	FraudCheckDecisioningError fromErrorToDecisionError(Error error);
	
	//sub map ScoreType (score element) to FraudAnalyticModelScore
	@Mapping(source = "modelName", target = "modelName")
	@Mapping(source = "score", target = "scoreNumber")
	@Mapping(source = "reasonCodes", target = "scoreNumberReasonCodes", qualifiedByName="mapScoreReasonCodeTypeToString")
	FraudAnalyticModelScore fromScoreTypeToFraudAnalyticModelScore(ScoreType scoreType);
	List<String> mapScoreReasonCodeTypesToStrings(List<ScoreReasonCodeType> scoreReasonCodeTypes); 
	default String mapScoreReasonCodeTypeToString(ScoreReasonCodeType scoreReasonCodeType) {
		if (scoreReasonCodeType ==null) {
			return null;
		}
		return scoreReasonCodeType.getName();
	}
	
	//auto mapping missed this
	@Mapping(source = "blacklistMatchingRulesCount", target = "blacklistmatchingRulesCount")
	FraudDecisionSummary fromDecisionSummaryToFraudDecisionSummary (DecisionSummary decisionSummary) ;
	
	//auto mapping missed this - case difference
	@Mapping(source = "ruleId", target = "ruleID")
	FraudDecisionCaseRulesFired fromCaseRuleToFraudDecisionCaseRulesFired (CaseRule caseRule) ;
	
	//auto mapping missed this - case difference
	@Mapping(source = "ruleId", target = "ruleID")
	FraudDecisionMatchingRulesFired fromCaseRuleToFraudDecisionMatchingRulesFired (MatchingRule matchingRule) ;

}
