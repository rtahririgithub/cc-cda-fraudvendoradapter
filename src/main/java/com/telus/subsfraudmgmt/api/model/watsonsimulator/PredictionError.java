package com.telus.subsfraudmgmt.api.model.watsonsimulator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PredictionError{
	 @JsonProperty("code") 
	 public String getCode() { 
			 return this.code; } 
	 public void setCode(String code) { 
			 this.code = code; } 
	 String code;
	 @JsonProperty("name") 
	 public String getName() { 
			 return this.name; } 
	 public void setName(String name) { 
			 this.name = name; } 
	 String name;
	 @JsonProperty("description") 
	 public String getDescription() { 
			 return this.description; } 
	 public void setDescription(String description) { 
			 this.description = description; } 
	 String description;
	}
