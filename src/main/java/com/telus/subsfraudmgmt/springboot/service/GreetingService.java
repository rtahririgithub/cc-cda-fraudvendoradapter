package com.telus.subsfraudmgmt.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	
	private static final String template = "Hello friend, %s!";
	
	/**
	 * Returns Greeting for a given name, and increases the counter.
	 * @param counter
	 * @param name
	 * @return Greeting message
	 */
	public String getGreetingMessage(String name) {
		
		 return String.format(template, name);
	}
	
	
	

}
