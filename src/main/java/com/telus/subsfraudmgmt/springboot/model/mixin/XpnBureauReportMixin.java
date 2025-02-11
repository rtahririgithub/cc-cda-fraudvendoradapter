package com.telus.subsfraudmgmt.springboot.model.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fico.afm.model.application.cdac.xpn.ParsedResponseList;
/**
 * AFM uses ParsedResponseList for property
 * @author Harry Xu
 *
 */
public interface XpnBureauReportMixin {
	
	@JsonProperty("ParsedResponseList")
	abstract ParsedResponseList getBureauReport();


}
