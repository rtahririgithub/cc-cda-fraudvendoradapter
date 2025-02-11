package com.telus.subsfraudmgmt.springboot.service;

/**
 *Mask multiple sensitive field values in json string using mask *** for logging
 * 
 * @author Harry Xu
 *
 */
public interface MaskingService {
	/**
	 * Mask multiple sensitive field values in json string using mask *** for logging
	 * @param sourceJson the source json string to mask sensitive field values
	 * @return json string with sensitive field values masked
	 * @throws Exception
	 */
	String maskJsonSecureValues(String sourceJson) throws Exception; 

	/**
	 * Mask multiple sensitive field values in json string using mask *** and logging if logging level is reached
	 * @param sourceJson the source json string to mask sensitive field values
	 * @return json string with sensitive field values masked
	 * @throws Exception
	 */
	void maskAndLogJsonString(String sourceJson) throws Exception; 

	/**
	 * Mask multiple sensitive field values in xml string using mask *** for
	 * logging
	 * 
	 * @param sourceXml the source xml string to mask sensitive field values
	 * @return xml string with sensitive field values masked
	 * @throws Exception
	 */
	String maskXmlSecureValues(String sourceXml) throws Exception;


	/**
	 * Mask multiple sensitive field values in xml string using mask *** and logging if logging level is reached
	 * 
	 * @param sourceXml the source xml string to mask sensitive field values
	 * @return xml string with sensitive field values masked
	 * @throws Exception
	 */
	void maskAndLogXmlString(String sourceXml) throws Exception;

}
