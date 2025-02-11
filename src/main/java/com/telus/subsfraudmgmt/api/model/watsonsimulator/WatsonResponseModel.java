package com.telus.subsfraudmgmt.api.model.watsonsimulator;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
//import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */



public class WatsonResponseModel {
 @JsonProperty("predictions") 
 public List<Prediction> getPredictions() { 
		 return this.predictions; } 
 public void setPredictions(List<Prediction> predictions) { 
		 this.predictions = predictions; } 
 List<Prediction> predictions;
 @JsonProperty("predictionError") 
 public PredictionError getPredictionError() { 
		 return this.predictionError; } 
 public void setPredictionError(PredictionError predictionError) { 
		 this.predictionError = predictionError; } 
 PredictionError predictionError;
}

