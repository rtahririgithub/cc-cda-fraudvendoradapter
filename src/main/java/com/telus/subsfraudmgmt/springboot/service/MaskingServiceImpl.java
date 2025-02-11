package com.telus.subsfraudmgmt.springboot.service;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import com.telus.subsfraudmgmt.springboot.service.secure.SecureFieldsOperationHelper;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLog;
import com.telus.subsfraudmgmt.springboot.service.secure.Operation;

import net.minidev.json.JSONObject;
/**
 * Mask sensitive fields for a AFM invoking json or xml document using three *.
 *<p>Note that it does not handle TFM json and thus we should not log json input in VendorAdapterFraudCheckInvokerCommand
 * @author Harry Xu
 *
 */
@Component
public class MaskingServiceImpl implements MaskingService{
	
	private static final Log LOG = new CustomizedLog(MaskingServiceImpl.class.getName());
	
	public static final Operation MASKING_OPeration = new Operation() {
		@Override
		public String operate(String source) throws Exception{
			//mask operation
			return "***";
		}
	};
	
	public MaskingServiceImpl() {
	}


	@Override
	public  String maskJsonSecureValues(String sourceJson) throws Exception {
		//top level json object is either JSONObject or JSONArray
		Object jsonObjectOrArray =  SecureFieldsOperationHelper.createJSONObject(sourceJson);
		SecureFieldsOperationHelper.traverseJsonNode(jsonObjectOrArray, MASKING_OPeration);

		return jsonObjectOrArray.toString();

	}	
	@Override
	public void maskAndLogJsonString(String sourceJson) throws Exception {
		if (LOG.isInfoEnabled()) {		 
			String masked="";
			if (sourceJson!=null && !sourceJson.isEmpty()) {	
			 masked = maskJsonSecureValues(sourceJson);
			}
			LOG.info("secureLogging json: '" + masked + "'");
		} 
	}

	@Override
	public String maskXmlSecureValues(String sourceXml) throws Exception {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		// LocalName will work
		dbFactory.setNamespaceAware(true);
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new InputSource(new StringReader(sourceXml)));
		//doc.getDocumentElement().normalize();
		Element root = doc.getDocumentElement(); // gets the root element
		
		Operation operation = new Operation() {
			@Override
			public String operate(String source) throws Exception{
				//mask operation
				return "***";
			}
		};
		SecureFieldsOperationHelper.traverseXmlNode(root, operation); 

		StringWriter stringWriter = new StringWriter();
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.transform(new DOMSource(doc), new StreamResult(stringWriter));
		return  stringWriter.toString();

	}
	@Override
	public void maskAndLogXmlString(String sourceXml) throws Exception {
		if (LOG.isInfoEnabled()) {
			String masked =  maskXmlSecureValues(sourceXml);
			LOG.info("secureLogging xml: '" + masked + "'");
		}
	}

}
