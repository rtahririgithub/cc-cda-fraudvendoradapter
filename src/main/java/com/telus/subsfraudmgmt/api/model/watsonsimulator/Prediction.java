package com.telus.subsfraudmgmt.api.model.watsonsimulator;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prediction{
	 @JsonProperty("fields") 
	 public List<String> getFields() { 
			 return this.fields; } 
	 public void setFields(List<String> fields) { 
			 this.fields = fields; } 
	 List<String> fields;
	 @JsonProperty("values") 
	 public List<List<Object>> getValues() { 
			 return this.values; } 
	 public void setValues(List<List<Object>> values) { 
			 this.values = values; } 
	 List<List<Object>> values;
	}

