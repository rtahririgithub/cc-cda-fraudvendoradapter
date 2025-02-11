package com.telus.subsfraudmgmt.springboot.model.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fico.afm.model.application.BureauReportType;
import com.fico.afm.model.application.EfuBureauReport;
import com.fico.afm.model.application.OtherBureauReport;
import com.fico.afm.model.application.TuBureauReport;
import com.fico.afm.model.application.XpnBureauReport;
/**
 * BureauReportMixin to define Polymorphism 
 * @author Harry Xu
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true )
@JsonSubTypes({
  @JsonSubTypes.Type(value = EfuBureauReport.class, name = "Equifax"),
  @JsonSubTypes.Type(value = TuBureauReport.class, name = "TransUnion"),
  @JsonSubTypes.Type(value = XpnBureauReport.class, name = "Experian"),
  @JsonSubTypes.Type(value = OtherBureauReport.class, name = "Other")
})
public interface BureauReportMixin {
	//not to have double "type":"Equifax" or "type":"TraunsUnion"
	@JsonIgnore
	public BureauReportType getType();

}
