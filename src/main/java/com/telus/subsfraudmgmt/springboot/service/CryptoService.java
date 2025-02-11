package com.telus.subsfraudmgmt.springboot.service;

/**
 * Provide encryption and decryption service for individual value and multiple sensitive fields in a json or xml document.
 * 
 * @author Harry Xu
 *
 */
public interface CryptoService {
	/**
	 * Encrypt individual value
	 * @param toEncrypt the value to encrypt
	 * @return encrypted value in string
	 * @throws Exception
	 */
	String encryptValue(String toEncrypt) throws Exception;
	/**
	 * Decrypt individual value
	 * @param toDecrypt the value to decrypt
	 * @return decrypted value in string
	 * @throws Exception
	 */
	String decryptValue(String toDecrypt) throws Exception;
	/**
	 * Encrypt multiple sensitive field values in json string
	 * @param sourceJson the source json string to encrypt sensitive field values
	 * @return json string with sensitive field values encrypted
	 * @throws Exception
	 */
	String encryptJsonSecureValues(String sourceJson) throws Exception;

	/**
	 * Decrypt previously encrypted multiple sensitive field values in json string
	 * @param sourceJson the source json string to decrypt already encypted sensitive field values
	 * @return json string with sensitive field values decrypted
	 * @throws Exception
	 */
	String decryptJsonSecureValues(String sourceJson) throws Exception;
	
	/**
	 * Encrypt multiple sensitive field values in xml string
	 * @param sourceXml the source xml string to encrypt sensitive field values
	 * @return xml string with sensitive field values encrypted
	 * @throws Exception 
	 */
	String encryptXmlSecureValues(String sourceXml) throws Exception;

	/**
	 * Decrypt previously encrypted multiple sensitive field values in xml string
	 * @param sourceXml the source xml string to decrypt already encypted sensitive field values
	 * @return xml string with sensitive field values decrypted
	 * @throws Exception
	 */
	String decryptXmlSecureValues(String sourceXml) throws Exception;
}
