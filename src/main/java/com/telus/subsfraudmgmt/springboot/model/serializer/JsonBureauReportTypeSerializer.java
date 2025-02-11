package com.telus.subsfraudmgmt.springboot.model.serializer;

import java.io.IOException;
import org.apache.commons.logging.Log;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fico.afm.model.application.BureauReportType;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;

/**
 * Serialize <code>BureauReport</code> using toString
 * 
 * @author Harry Xu
 *
 */
public class JsonBureauReportTypeSerializer extends JsonSerializer<BureauReportType> {

	private static final Log LOG = CustomizedLogFactory.getLog(JsonBureauReportTypeSerializer.class);

	@Override
	public void serialize(BureauReportType bureauReportType, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException { 
		
		if (bureauReportType !=null) {
			ObjectMapper objectMapper =(ObjectMapper)jgen.getCodec();
			objectMapper.writeValue(jgen, bureauReportType.value());
		}
	}

}