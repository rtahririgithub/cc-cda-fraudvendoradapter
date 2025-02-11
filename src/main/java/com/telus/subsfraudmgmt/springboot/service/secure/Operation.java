package com.telus.subsfraudmgmt.springboot.service.secure;


public interface Operation {	 
	
	/**
	 * Abstraction of an operation
	 * @param source the source string value
	 * @return the 
	 */
	public String operate (String source) throws Exception; 
	
	

}
