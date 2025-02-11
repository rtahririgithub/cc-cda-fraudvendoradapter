package com.telus.subsfraudmgmt.springboot.model.serializer;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fico.afm.model.application.types.Monetary;

/**
 * Serialize <code>Monetary</code> java object with <code>value</code> java
 * field changed to <code>amount</code> json field.
 * 
 * @author Harry Xu
 *
 */
public class JsonMonetarySerializer extends JsonSerializer<Monetary> {

	@Override
	public void serialize(Monetary monetary, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		jgen.writeStartObject();
		
		if (monetary == null || monetary.getValue()==null && monetary.getCurrency()==null) {
			jgen.writeNumberField("amount", (BigDecimal) null);
			jgen.writeStringField("currency", (String) null); 
		} else {
			jgen.writeNumberField("amount", monetary.getValue().setScale(2, BigDecimal.ROUND_HALF_UP));
			jgen.writeStringField("currency", monetary.getCurrency());

		}
		
		jgen.writeEndObject();

	}

}