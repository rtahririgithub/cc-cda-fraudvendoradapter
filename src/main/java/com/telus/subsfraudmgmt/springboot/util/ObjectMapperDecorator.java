package com.telus.subsfraudmgmt.springboot.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fico.afm.model.application.Applicant;
import com.fico.afm.model.application.BureauReport;
import com.fico.afm.model.application.BureauReportType;
import com.fico.afm.model.application.BureauReports;
import com.fico.afm.model.application.EfuBureauReport;
import com.fico.afm.model.application.TuBureauReport;
import com.fico.afm.model.application.XpnBureauReport;
import com.fico.afm.model.application.cdac.tu.MessageText;
import com.telus.subsfraudmgmt.springboot.model.deserializer.BureauReportTypeDeserializer;
import com.telus.subsfraudmgmt.springboot.model.deserializer.JsonBureauReportDeserializer;
import com.telus.subsfraudmgmt.springboot.model.deserializer.JsonBureauReportsDeserializer;
import com.telus.subsfraudmgmt.springboot.model.mixin.ApplicantMixIn;
import com.telus.subsfraudmgmt.springboot.model.mixin.BureauReportMixin;
import com.telus.subsfraudmgmt.springboot.model.mixin.EfuBureauReportMixin;
import com.telus.subsfraudmgmt.springboot.model.mixin.TuBureauReportMixin;
import com.telus.subsfraudmgmt.springboot.model.mixin.XpnBureauReportMixin;
import com.telus.subsfraudmgmt.springboot.model.mixin.tu.TuBMessageTextMixin;
import com.telus.subsfraudmgmt.springboot.model.namingstrategy.AFMParsedResponseUppercaseAwareNameStrategy;
import com.telus.subsfraudmgmt.springboot.model.serializer.JsonBureauReportTypeSerializer;
import com.telus.subsfraudmgmt.springboot.model.serializer.JsonBureauReportsSerializer;
/**
 * Decorate front ObjectMaper to handle AFM bureauReport related the properties.
 * <p>To be used by FruadCheckApiConcreteController and FraudCheckTransactionListenerController.
 * @author Harry Xu
 *
 */
public class ObjectMapperDecorator {
	
	public static void addAFMFeature(ObjectMapper objectMapper) {
		//consider ParsedReponse is using uppercase first letter and use abstract BureauReport 
		//, without it the ParsedResponse will be empty
    	objectMapper.setPropertyNamingStrategy(new AFMParsedResponseUppercaseAwareNameStrategy());
        SimpleModule module = new SimpleModule();
    	module.addSerializer(BureauReports.class, new JsonBureauReportsSerializer());
    	module.addDeserializer(BureauReports.class, new JsonBureauReportsDeserializer());

    	module.addDeserializer(BureauReport.class, new JsonBureauReportDeserializer());

    	module.addSerializer(BureauReportType.class, new JsonBureauReportTypeSerializer());
    	module.addDeserializer(BureauReportType.class, new BureauReportTypeDeserializer());

    	//to change field names from bureauReports to bureauReport 
    	objectMapper.addMixIn(Applicant.class, ApplicantMixIn.class);
    	objectMapper.addMixIn(BureauReport.class, BureauReportMixin.class);

    	objectMapper.addMixIn(EfuBureauReport.class, EfuBureauReportMixin.class);
    	objectMapper.addMixIn(TuBureauReport.class, TuBureauReportMixin.class);
    	objectMapper.addMixIn(XpnBureauReport.class, XpnBureauReportMixin.class);
    	//value should not be send to avoid 400 BAD Request
    	objectMapper.addMixIn(MessageText.class, TuBMessageTextMixin.class);

    	objectMapper.registerModule(module);
	}

}
