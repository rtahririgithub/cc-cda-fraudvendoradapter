package com.telus.subsfraudmgmt.springboot.model.mixin;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fico.afm.model.application.CaseRuleActionCodeType;
import com.fico.afm.model.application.CaseRuleReasonCodeType;
import com.fico.afm.model.application.types.AliasableNameValuePair;
/**
 * AFM rest service do not want these three in update case (disposition) under "caseRulesFired".
 * @author Harry Xu
 *
 */
public interface CaseRuleMixin {
	
	@JsonIgnore
    abstract List<CaseRuleActionCodeType> getActionCodeList();
	
	@JsonIgnore
    abstract List<CaseRuleReasonCodeType> getReasonCodeList();
	
	@JsonIgnore
    abstract List<AliasableNameValuePair> getUserData();
}
