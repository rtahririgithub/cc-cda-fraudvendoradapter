package com.telus.subsfraudmgmt.springboot.model.serializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.logging.Log;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;

/**
 * Serialize java <code>Calendar</code> into json date or ISO date.
 * <p>
 * Should be synchronize with <code>JsonCalendarDeserializer</code>
 * in terms of pattern and timezone.
 * 
 * see https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
 * 
 * @author Harry Xu
 *
 */
public class JsonCalendarNoXXSerializer extends JsonSerializer<Calendar> {
	
	private static final Log LOG = CustomizedLogFactory.getLog(JsonCalendarNoXXSerializer.class);
	
	 
	@Override
	public void serialize(Calendar value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException { 


		if (value == null) {
			jgen.writeString((String) null);
		} else {
			String fieldName = jgen.getOutputContext().getCurrentName();

			SimpleDateFormat formatter = null;
			if (DateFieldsBindingUtil.isDateOnlyField(fieldName)) {
				formatter = new SimpleDateFormat("yyyy-MM-dd");
			} else {
				formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");  
			}				 
			//formatter.setTimeZone(TimeZone.getTimeZone("UTC")); this causing 055+0000 to 000Z thus should not set UTC timezone
			String dateAsString = formatter.format(value.getTime());
			jgen.writeString(dateAsString);


		}

	}

}