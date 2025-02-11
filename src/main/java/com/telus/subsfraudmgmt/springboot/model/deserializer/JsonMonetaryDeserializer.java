package com.telus.subsfraudmgmt.springboot.model.deserializer;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.commons.logging.Log;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fico.afm.model.application.types.Monetary;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;

/**
 * Deserialize <code>Monetary</code> json object with <code>amount</code> json
 * field changed to <code>value</code> java field.
 * 
 * @author Harry Xu
 *
 */
@SuppressWarnings("serial")
public class JsonMonetaryDeserializer extends StdDeserializer<Monetary> {

	private static final Log LOG = CustomizedLogFactory.getLog(JsonMonetaryDeserializer.class);

	public JsonMonetaryDeserializer() {
		this(null);
	}

	public JsonMonetaryDeserializer(Class<?> clazz) { 
		super(clazz);
	}

	@Override
	public Monetary deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException, JsonProcessingException {

		JsonNode moneyNode = jsonparser.getCodec().readTree(jsonparser);

		if (moneyNode == null) {
			return null;
		}
		//for get application by id, the field name is "value", while update disposition code requires "amount"
		JsonNode amountNode = moneyNode.get("amount");
		if (amountNode==null) {
			amountNode = moneyNode.get("value");
		}
		Monetary monetary = new Monetary();
		monetary.setValue(new BigDecimal(amountNode.asText()));
		monetary.setCurrency(moneyNode.get("currency").textValue());
		return monetary;


	}

}