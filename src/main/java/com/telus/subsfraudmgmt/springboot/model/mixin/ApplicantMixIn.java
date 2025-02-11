package com.telus.subsfraudmgmt.springboot.model.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fico.afm.model.application.BureauReports;
/**
 * ApplicantMixIn to change bureautReports to bureauReport json element.
 * @author Harry Xu
 *
 */
public interface ApplicantMixIn {
	@JsonProperty("bureauReport")
    abstract BureauReports getBureauReports();
}
