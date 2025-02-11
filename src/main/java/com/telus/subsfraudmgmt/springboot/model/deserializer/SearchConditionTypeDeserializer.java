package com.telus.subsfraudmgmt.springboot.model.deserializer;

import java.io.IOException;
import org.apache.commons.logging.Log;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fico.afm.model.application.types.SearchConditionType;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;

/**
 * Deserialize <code>SearchConditionType</code> json object to <code>SearchConditionType</code> java object.
 * 
 * @author Harry Xu
 *
 */
@SuppressWarnings("serial")
public class SearchConditionTypeDeserializer extends StdDeserializer<SearchConditionType> {

	private static final Log LOG = CustomizedLogFactory.getLog(SearchConditionTypeDeserializer.class);

	public SearchConditionTypeDeserializer() {
		this(null);
	}

	public SearchConditionTypeDeserializer(Class<?> clazz) { 
		super(clazz);
	}

	@Override
	public SearchConditionType deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException{

		JsonNode searchConditionTypeNode = jsonparser.getCodec().readTree(jsonparser);

		if (searchConditionTypeNode == null) {
			return null;
		}

		String value = searchConditionTypeNode.asText();
		for (SearchConditionType type: SearchConditionType.values()) {
			if (type.value().equalsIgnoreCase(value)) {
				return type;
			}
		}
		throw new IOException("failed to serialize '" + searchConditionTypeNode.toString()+"'");

	}

}