package com.telus.subsfraudmgmt.springboot.util;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer.ObjectMapperType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer.ObjectMapperType;
/**
 * Provider object to json and json to object mapping util, and a properly configured jackson object mapper.
 * @author Harry Xu
 *
 */

public class JsonUtil {

	/**
	 * Generates JSON string of the given object based on annotation and default object mapper
	 *
	 * @param request The object to be processed.
	 * @param objectMapper the jackson object mapper to use which is resolved by the caller.
	 * @return The JSON string representation.
	 */
	public static String generateJson(Object request, ObjectMapper objectMapper) throws JsonProcessingException {

		if (request != null) {
			//TODO:return objectMapper.enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(request);
			return objectMapper.writeValueAsString(request);
		}
		throw new RuntimeException("input object is null!");

	}
	
	public static String generateJsonPredict(Object request, ObjectMapper objectMapper) throws JsonProcessingException {
	       // Create an instance of ObjectMapper
	    objectMapper = new ObjectMapper();
	    objectMapper.registerModule(new JavaTimeModule()); // Register the JavaTimeModule

		if (request != null) {
			//TODO:return objectMapper.enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(request);
			return objectMapper.writeValueAsString(request);
		}
		throw new RuntimeException("input object is null!");

	}
	/**
	 * Deserialize JSON string to an object with specified type using the object mapper resolved by the caller.
	 *
	 * @param json The json string to be processed.
	 * @param objectMapper the jackson object mapper to use which is resolved by the caller.
	 * @return the object with specified type.
	 */
	public static <T> T fromJson(String json, Class<T> t, ObjectMapper objectMapper) throws JsonMappingException, JsonParseException, IOException  {
		return (T) objectMapper.readValue(json.getBytes("UTF-8"), t);

	}

	public static <T> T fromJsonWithDefaultObjectMapper(String json, Class<T> t) throws JsonMappingException, JsonParseException, IOException  {
		return (T) fromJson(json, t, getDefaultObjectMapper());

	}


	public static String generateJsonWithDefaultObjectMapper(Object request) throws JsonProcessingException {
		return generateJson(request, getDefaultObjectMapper());

	}
	
	public static String testUseJsonWithDefaultObjectMapper(Object request) {
		try {
			return generateJson(request, getDefaultObjectMapper());
		}catch (Exception e) {
			e.printStackTrace();
			return "Exception: " + e.getMessage();
		}

	}

	

	/**
	 * Default usage for non-command client to use to return consistent response json format
	 * @return 
	 */
	public static ObjectMapper getDefaultObjectMapper() {
		return ObjectMapperConfigurer.getConfiguredObjectMapper(ObjectMapperType.HONOR_XX_DATE_TIME);
	}

}
