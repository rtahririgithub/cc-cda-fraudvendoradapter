package com.telus.subsfraudmgmt.springboot.model.deserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.logging.Log;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.model.serializer.DateFieldsBindingUtil;

@SuppressWarnings("serial")
public class JsonCalendarDeserializer extends StdDeserializer<Calendar> {

	private static final Log LOG = CustomizedLogFactory.getLog(JsonCalendarDeserializer.class);

	public JsonCalendarDeserializer() {
		this(null);
	}

	public JsonCalendarDeserializer(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public Calendar deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {

		try {
			String dateStr = jsonparser.getText();
			 
			if (dateStr == null) {
				return null;
			}

			String fieldName = jsonparser.getCurrentName();

			String[] patterns  = null;
			if (isLong(dateStr)) {
				//for get case by id
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(Long.parseLong(dateStr)); 
				return calendar;
			}
			//to make it flexible for possible patterns
			else if (DateFieldsBindingUtil.isDateOnlyField(fieldName)) {
				patterns= new String[] {"yyyy-MM-dd", "yyyy-MM-ddXXX"}; 
			} else {
				//pattern= "yyyy-MM-dd'T'HH:mm:ss.SSSZ"; //format+0000 suffix
				patterns= new String[] {"yyyy-MM-dd'T'HH:mm:ssXXX","yyyy-MM-dd'T'HH:mm:ss.SSSXX", "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", "yyyy-MM-dd'T'HH:mm:ss"};
			}
			return parseAsDateUsingFormats(patterns, dateStr);
		}catch (IOException e) {
			LOG.warn("deserialize ecountered exception: " + e.getMessage());
			throw e;
		}

	}
	
	private boolean isLong(String dateString) {
		return dateString.matches("^[0-9]+$") && dateString.length() > 5;
	}
	
	private Calendar parseAsDateUsingFormats(String[] patterns, String value) throws IOException {
		IOException  lastException= null; 
		
		for (String pattern: patterns) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				Date date = sdf.parse(value); 
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date); 
				return calendar;
			}catch (ParseException e) {
				lastException =new IOException(e);
			}
		}
		if (lastException==null) {
			lastException = new IOException("failed to parse value as date: '"+ value+"'");
		}
		throw lastException;
		
	}

}