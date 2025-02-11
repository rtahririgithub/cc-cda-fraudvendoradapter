package com.telus.subsfraudmgmt.springboot.model.deserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fico.afm.model.application.BureauReport;
import com.fico.afm.model.application.BureauReports;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;

/**
 * Deserialize <code>BureauReports</code> json array object to <code>BureauReports</code>
 * 
 * @author Harry Xu 
 *
 */
@SuppressWarnings("serial")
public class JsonBureauReportsDeserializer extends StdDeserializer<BureauReports> {

	private static final Log LOG = CustomizedLogFactory.getLog(JsonBureauReportsDeserializer.class);

	public JsonBureauReportsDeserializer() { 
		this(null);
	}

	public JsonBureauReportsDeserializer(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public BureauReports deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {

		ObjectMapper mapper = (ObjectMapper)jsonparser.getCodec();
		JsonNode bureauReportsNode = mapper.readTree(jsonparser);
	    
		BureauReports bureauReports = new BureauReports();
		
		if (bureauReportsNode != null) {
			List<BureauReport> reports= mapper.readValue(bureauReportsNode.toString(), new TypeReference<List<BureauReport>>(){});
			bureauReports.getBureauReport().addAll(reports);
		}else {
			//use empty list
			bureauReports.getBureauReport().addAll(new ArrayList<BureauReport>());
		}
		  
		return bureauReports;


	}

}