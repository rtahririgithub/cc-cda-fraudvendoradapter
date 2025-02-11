package com.telus.subsfraudmgmt.springboot.model.serializer;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Serialize <code>BigDecimal</code> java object with <code>value</code> java
 * field changed to <code>amount</code> json field.
 * 
 * @author Harry Xu
 *
 */
public class JsonBigDecimalSerializer extends JsonSerializer<BigDecimal> {

	@Override
	public void serialize(BigDecimal bigDecimal, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		if (bigDecimal == null) {
			jgen.writeString((String) null);
		}
		else {
			jgen.writeNumber(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));
		}
		 
	}

}