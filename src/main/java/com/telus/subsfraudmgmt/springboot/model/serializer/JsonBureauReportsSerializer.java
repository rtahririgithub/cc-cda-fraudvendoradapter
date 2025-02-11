package com.telus.subsfraudmgmt.springboot.model.serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fico.afm.model.application.BureauReport;
import com.fico.afm.model.application.BureauReports;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;

/**
 * Serialize <code>BureauReports</code> java object to array json object as required by AFM rest service.
 * <p>Note that ApplicantMix interface also changed fieldname from "bureauReports" to "bureauReport"
 * 
 * @author Harry Xu
 *
 */
public class JsonBureauReportsSerializer extends JsonSerializer<BureauReports> {

	private static final Log LOG = CustomizedLogFactory.getLog(JsonBureauReportsSerializer.class);

	@Override
	public void serialize(BureauReports bureauReports, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {  
		 
		ObjectMapper objectMapper =(ObjectMapper)jgen.getCodec();
		List<BureauReport> list= bureauReports.getBureauReport();
		
		jgen.writeStartArray();
		for (BureauReport bureauReport: list) {
			objectMapper.writeValue(jgen, bureauReport);
		}
		jgen.writeEndArray();

	}

}