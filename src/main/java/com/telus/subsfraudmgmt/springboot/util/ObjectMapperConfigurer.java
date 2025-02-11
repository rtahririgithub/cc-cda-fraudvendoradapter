package com.telus.subsfraudmgmt.springboot.util;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fico.afm.model.application.Address;
import com.fico.afm.model.application.Applicant;
import com.fico.afm.model.application.BureauReport;
import com.fico.afm.model.application.BureauReportType;
import com.fico.afm.model.application.BureauReports;
import com.fico.afm.model.application.CaseRule;
import com.fico.afm.model.application.EfuBureauReport;
import com.fico.afm.model.application.TuBureauReport;
import com.fico.afm.model.application.XpnBureauReport;
import com.fico.afm.model.application.cdac.tu.MessageText;
import com.fico.afm.model.application.types.Monetary;
import com.fico.afm.model.application.types.SearchConditionType;
import com.telus.subsfraudmgmt.springboot.model.deserializer.BureauReportTypeDeserializer;
import com.telus.subsfraudmgmt.springboot.model.deserializer.JsonBureauReportDeserializer;
import com.telus.subsfraudmgmt.springboot.model.deserializer.JsonBureauReportsDeserializer;
import com.telus.subsfraudmgmt.springboot.model.deserializer.JsonCalendarDeserializer;
import com.telus.subsfraudmgmt.springboot.model.deserializer.JsonMonetaryDeserializer;
import com.telus.subsfraudmgmt.springboot.model.deserializer.SearchConditionTypeDeserializer;
import com.telus.subsfraudmgmt.springboot.model.mixin.AddressPropertyFilterMixIn;
import com.telus.subsfraudmgmt.springboot.model.mixin.ApplicantMixIn;
import com.telus.subsfraudmgmt.springboot.model.mixin.BureauReportMixin;
import com.telus.subsfraudmgmt.springboot.model.mixin.CaseRuleMixin;
import com.telus.subsfraudmgmt.springboot.model.mixin.EfuBureauReportMixin;
import com.telus.subsfraudmgmt.springboot.model.mixin.PropertyFilterMixIn;
import com.telus.subsfraudmgmt.springboot.model.mixin.TuBureauReportMixin;
import com.telus.subsfraudmgmt.springboot.model.mixin.XpnBureauReportMixin;
import com.telus.subsfraudmgmt.springboot.model.mixin.tu.TuBMessageTextMixin;
import com.telus.subsfraudmgmt.springboot.model.namingstrategy.AFMParsedResponseUppercaseAwareNameStrategy;
import com.telus.subsfraudmgmt.springboot.model.serializer.JsonBigDecimalSerializer;
import com.telus.subsfraudmgmt.springboot.model.serializer.JsonBureauReportTypeSerializer;
import com.telus.subsfraudmgmt.springboot.model.serializer.JsonBureauReportsSerializer;
import com.telus.subsfraudmgmt.springboot.model.serializer.JsonCalendarNoXXSerializer;
import com.telus.subsfraudmgmt.springboot.model.serializer.JsonCalendarXXSerializer;
import com.telus.subsfraudmgmt.springboot.model.serializer.JsonCalendarXXXSerializer;
import com.telus.subsfraudmgmt.springboot.model.serializer.JsonMonetarySerializer;
/**
 * Configurer to provide appropriate mapper for each type.
 * @author Harry Xu
 *
 */
public class ObjectMapperConfigurer {
	public static Map<String, ObjectMapper> OBJECT_MAPPERS= new HashMap<>();
	
	public static ObjectMapper getConfiguredObjectMapper(ObjectMapperType  objectMapperType) {
		ObjectMapper objectMapper = OBJECT_MAPPERS.get(objectMapperType.name());
		if (objectMapper!=null) {
			return objectMapper;
		}

		//1. create basic one with naming strategy, and FAIL_ON_UNKONWN_PROPERTIES, NON_NULL features.
		ObjectMapper mapper = createBasicObjectMapper();

		//2. add mixings that uses jacksons annotations
		addAnnotatedMixinsFor(mapper);
		
		//3.special serialization and deserialization classes without jackson annotation
		addDatabindModuleByObjectMapperType(objectMapperType, mapper);

		//put to mapper map at last
		OBJECT_MAPPERS.put(objectMapperType.name(), mapper);
		
		return mapper;
	}

	private static ObjectMapper createBasicObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		//use custom Name strategy due to BureauReports used Upper camel case key names
		mapper.setPropertyNamingStrategy(new AFMParsedResponseUppercaseAwareNameStrategy());
		
		// whether or not to Configure ObjectMapper to exclude null and empty fields when serializing
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		mapper.setFilterProvider(buildSimpleFilterProvider());
		return mapper;
	}
	
	private static SimpleFilterProvider buildSimpleFilterProvider() {
		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter("addressFilter", SimpleBeanPropertyFilter.serializeAllExcept("street6","street7", "label"));
		filterProvider.addFilter("generalFilter",
				SimpleBeanPropertyFilter.serializeAllExcept("label", "applicationSectionAuto"));
		return filterProvider;
	}
	
	private static void addAnnotatedMixinsFor(ObjectMapper mapper) {
		//global for all classes
		mapper.addMixIn(Object.class, PropertyFilterMixIn.class); 
		//for Address only
		mapper.addMixIn(Address.class, AddressPropertyFilterMixIn.class); 

		//to change field names from bureauReports to bureauReport 
		mapper.addMixIn(Applicant.class, ApplicantMixIn.class);
		
		//to ignore properties actionCodeList and reasonCodeList that vendor did not take in update case
		mapper.addMixIn(CaseRule.class, CaseRuleMixin.class);
		
		//For BureauReport morphism
        mapper.addMixIn(BureauReport.class, BureauReportMixin.class);
		
        //for getBureauReport() -> ParsedResponseList for three kinds of concrete bureau report
		mapper.addMixIn(EfuBureauReport.class, EfuBureauReportMixin.class);
		mapper.addMixIn(TuBureauReport.class, TuBureauReportMixin.class);
		mapper.addMixIn(XpnBureauReport.class, XpnBureauReportMixin.class);
		//value should not be send to avoid 400 BAD Request
		mapper.addMixIn(MessageText.class, TuBMessageTextMixin.class);
		
	}


	private static void addDatabindModuleByObjectMapperType(ObjectMapperType objectMapperType, ObjectMapper mapper) {
		SimpleModule module = new SimpleModule();
		
		module.addSerializer(BureauReports.class, new JsonBureauReportsSerializer());
		module.addDeserializer(BureauReports.class, new JsonBureauReportsDeserializer());
		
		module.addDeserializer(BureauReport.class, new JsonBureauReportDeserializer());
		
		module.addSerializer(BureauReportType.class, new JsonBureauReportTypeSerializer());
		module.addDeserializer(BureauReportType.class, new BureauReportTypeDeserializer());
		
		module.addSerializer(Monetary.class, new JsonMonetarySerializer());
		module.addDeserializer(Monetary.class, new JsonMonetaryDeserializer());
		
		module.addSerializer(BigDecimal.class, new JsonBigDecimalSerializer());

		//pick different xsd:date, xsd:datetime serializers based on ObjectMapperType
		module.addSerializer(Calendar.class, selectCalendarSerializer(objectMapperType));
		
		module.addDeserializer(Calendar.class, new JsonCalendarDeserializer());

		module.addDeserializer(SearchConditionType.class, new SearchConditionTypeDeserializer());


		mapper.registerModule(module);
	}
	
	/**
	 * Type of ObjectMapper that has different date or datetime serialization of
	 * java object. format.
	 * <p>
	 * AFM Vendor needs different date/datetime format for different apis, and the
	 * user of object can request a particularly configured ObjectMapper that fits
	 * the context.
	 * 
	 * @author Harry Xu
	 *
	 */
    public static enum ObjectMapperType {
    	HONOR_XX_DATE_TIME, //allow "yyyy-MM-dd'T'HH:mm:ss.SSSXX" for xsd:datetime, or "yyyy-MM-ddXX" for xsd:date e.g. 2020-02-20T13:02:11.056-0700, 2020-02-21-0700
    	HONOR_XXX_DATE_TIME, //serialize as: 2020-02-20T13:02:11.056-07:00 for xsd:datetime, 2020-02-07:00 for xsd:date
    	HONOR_NO_X_DATE_TIME; //serialize as: 2020-02-20T13:02:11.056 for xsd:datetime,  2020-02-07 for xsd:date
    	
    }
    
    private static JsonSerializer<Calendar> selectCalendarSerializer(ObjectMapperType objectMapperType) {
    	if (ObjectMapperType.HONOR_XX_DATE_TIME.equals(objectMapperType)) {
    		return new JsonCalendarXXSerializer();
    	}
    	else if (ObjectMapperType.HONOR_XXX_DATE_TIME.equals(objectMapperType)) {
    		return new JsonCalendarXXXSerializer();
    	}
    	else {
    		return new JsonCalendarNoXXSerializer();
    	}
    }

}
