package com.telus.subsfraudmgmt.springboot.model.serializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
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
public class JsonCalendarXXSerializer extends JsonSerializer<Calendar> {
	
	private static final Log LOG = CustomizedLogFactory.getLog(JsonCalendarXXSerializer.class);

	@Override
	public void serialize(Calendar value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException { 


		if (value == null) {
			jgen.writeString((String) null);
		} else {
			String fieldName = jgen.getOutputContext().getCurrentName();

			SimpleDateFormat formatter = null;
			if (DateFieldsBindingUtil.isDateOnlyField(fieldName)) {
				formatter = new SimpleDateFormat("yyyy-MM-ddXXX");
			} else {
				formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXX"); //has -0700 suffix or Z if offset is zoro which is needed for json payload
			}

			formatter.setTimeZone(TimeZone.getTimeZone("UTC")); //to format uTC string
			String dateAsString = formatter.format(value.getTime());
			dateAsString = dateAsString.replace("Z", "+0000");
			jgen.writeString(dateAsString);


		}

	}

}