package com.telus.subsfraudmgmt.springboot.service.command;

public interface Command {
	/**
	 * Execute request to produce response.
	 * @param request the request object.
	 * @return the response the object.
	 */
	Object execute(Object request) throws Exception;
	
	

}
