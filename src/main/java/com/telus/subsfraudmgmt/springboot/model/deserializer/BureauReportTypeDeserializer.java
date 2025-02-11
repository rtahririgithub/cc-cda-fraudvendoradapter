package com.telus.subsfraudmgmt.springboot.model.deserializer;

import java.io.IOException;
import org.apache.commons.logging.Log;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fico.afm.model.application.BureauReportType;
import com.fico.afm.model.application.types.SearchConditionType;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;

/**
 * Deserialize <code>SearchConditionType</code> json object to <code>SearchConditionType</code> java object.
 * 
 * @author Harry Xu
 *
 */
@SuppressWarnings("serial")
public class BureauReportTypeDeserializer extends StdDeserializer<BureauReportType> {

	private static final Log LOG = CustomizedLogFactory.getLog(BureauReportType.class);

	public BureauReportTypeDeserializer() {
		this(null);
	}

	public BureauReportTypeDeserializer(Class<?> clazz) { 
		super(clazz);
	}

	@Override
	public BureauReportType deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException{

		JsonNode bureauReportType = jsonparser.getCodec().readTree(jsonparser);

		if (bureauReportType == null) {
			return null;
		}

		String value = bureauReportType.asText();
		for (BureauReportType type: BureauReportType.values()) {
			if (type.value().equalsIgnoreCase(value)) {
				return type;
			}
		}
		throw new IOException("failed to serialize '" + bureauReportType.toString()+"'");

	}

}