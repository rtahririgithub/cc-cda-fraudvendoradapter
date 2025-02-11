package com.telus.subsfraudmgmt.springboot.service;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.annotation.PostConstruct;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException; 

import com.telus.framework.crypto.EncryptionUtil;
import com.telus.framework.crypto.impl.jce.IvParamSpecGenerator;
import com.telus.framework.crypto.impl.jce.JceCryptoImpl;
import com.telus.framework.crypto.impl.pilot.PilotCryptoImpl;
import com.telus.subsfraudmgmt.springboot.config.Config;
import com.telus.subsfraudmgmt.springboot.config.CryptoConfig;
import com.telus.subsfraudmgmt.springboot.config.JceCryptoImplLocal;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.service.secure.SecureFieldsOperationHelper;
import com.telus.subsfraudmgmt.springboot.service.secure.Operation;

import org.apache.commons.logging.Log;
import net.minidev.json.JSONObject;

/**
 * Provide encryption and decryption service for individual value and multiple sensitive fields in a json document.
 * 
 * @author Harry Xu 
 *
 */

@Component
public class CryptoServiceImpl implements CryptoService{

	private static final Log LOGGER = CustomizedLogFactory.getLog(CryptoServiceImpl.class);
	
	private Operation encryptionOp = new Operation() {
		@Override
		public String operate(String value) throws Exception{
			return encryptValue(value);
		}
	};
	
	private Operation decryptionOp = new Operation() {
		@Override
		public String operate(String value) throws Exception{
			return decryptValue(value);
		}
	};
	
	@Autowired
	private CryptoConfig cryptoConfig;

	public void setConfig(CryptoConfig val) {
		this.cryptoConfig = val;
	}

	
	
	@Autowired
	private JceCryptoImplLocal jceCryptoImplLocal;
	//private JceCryptoImpl jceCryptoImpl;

	public CryptoServiceImpl() {
	}
/*
	@PostConstruct
	public void initialize() {
		
		try {
			config.createJceCryptoImplLocal();
		} catch (Exception e) {
			LOGGER.warn("jceCryptoImpl initialize failed", e);
		}
	}
	*/

	/**
	 * Encrypt individual value
	 * @param toEncrypt the value to encrypt
	 * @return encrypted value in string
	 * @throws Exception
	 */
	public String encryptValue(String toEncrypt) throws Exception{
		if (this.getJceCryptoImplLocal() ==null) {
			reinitiaze();
		}
        if (toEncrypt==null) {
        	return null;
        }
		byte[] bytes = jceCryptoImplLocal.encrypt(toEncrypt.getBytes());
		return new String(bytes);
	}


	/**
	 * Decrypt individual value
	 * @param toDecrypt the value to decrypt
	 * @return decrypted value in string
	 * @throws Exception
	 */
	public String decryptValue(String toDecrypt) throws Exception{
		if (this.getJceCryptoImplLocal() ==null) {
			reinitiaze();
		}
		if (toDecrypt==null) {
        	return null;
        }
		byte[] decryptedBytes = jceCryptoImplLocal.decrypt(toDecrypt.getBytes());
		return new String(decryptedBytes);

	}
	/**
	 * Encrypt multiple sensitive field values in json string
	 * @param sourceJson the source json string to encrypt sensitive field values
	 * @return json string with sensitive field values encrypted
	 * @throws Exception
	 */
	public String encryptJsonSecureValues(String sourceJson) throws Exception {
		if (this.getJceCryptoImplLocal() ==null) {
			reinitiaze();
		}
		//top level json object is either JSONObject or JSONArray
		Object jsonObjectOrArray =  SecureFieldsOperationHelper.createJSONObject(sourceJson);
		 
		SecureFieldsOperationHelper.traverseJsonNode(jsonObjectOrArray, encryptionOp);
		return jsonObjectOrArray.toString();

	}

	/**
	 * Decrypt previously encrypted multiple sensitive field values in json string
	 * @param sourceJson the source json string to decrypt already encypted sensitive field values
	 * @return json string with sensitive field values decrypted
	 * @throws Exception
	 */
	public String decryptJsonSecureValues(String sourceJson) throws Exception {
		if (this.getJceCryptoImplLocal() ==null) {
			reinitiaze();
		}
		//top level json object is either JSONObject or JSONArray
		Object jsonObjectOrArray =  SecureFieldsOperationHelper.createJSONObject(sourceJson);
		 
		SecureFieldsOperationHelper.traverseJsonNode(jsonObjectOrArray, decryptionOp);
		return jsonObjectOrArray.toString();

	}
	
	
	public String encryptXmlSecureValues(String sourceXml) throws Exception {
		if (this.getJceCryptoImplLocal() ==null) {
			reinitiaze();
		}
		Document doc = xmlStringToDoc(sourceXml);
		//doc.getDocumentElement().normalize();
		Element root = doc.getDocumentElement(); // gets the root element
	 
		SecureFieldsOperationHelper.traverseXmlNode(root, encryptionOp); 

		return xmlDocToString(doc);

	}

	

	public String decryptXmlSecureValues(String sourceXml) throws Exception {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		// LocalName will work
		dbFactory.setNamespaceAware(true);
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader(sourceXml)));
		//doc.getDocumentElement().normalize();
		Element root = doc.getDocumentElement(); // gets the root element
	 
		SecureFieldsOperationHelper.traverseXmlNode(root, decryptionOp); 

		return xmlDocToString(doc);


	}

	private Document xmlStringToDoc(String sourceXml) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		// LocalName will work
		dbFactory.setNamespaceAware(true);
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader(sourceXml)));
		return doc;
	}
	
	private String xmlDocToString(Document doc)
			throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
		StringWriter stringWriter = new StringWriter();
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.transform(new DOMSource(doc), new StreamResult(stringWriter));
		return  stringWriter.toString();
	}



	private void reinitiaze() throws Exception {
		cryptoConfig.createJceCryptoImplLocal();
		if (this.getJceCryptoImplLocal()==null) {
			throw new Exception("JceCryptoImpl not reinitialized successfully!");
		}
	}


	public JceCryptoImplLocal getJceCryptoImplLocal() {
		return jceCryptoImplLocal;
	}

	public void setJceCryptoImplLocal(JceCryptoImplLocal jce) {
		this.jceCryptoImplLocal = jce;
	}

}
