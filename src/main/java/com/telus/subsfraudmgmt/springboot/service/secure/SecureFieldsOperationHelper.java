package com.telus.subsfraudmgmt.springboot.service.secure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.Node;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
/**
 * Helper to perform operations encryption, decryption, mask operation on xml or json document for TFM/AFM service.
 * <p>
 * Note that same data, when encrypted twice, the encrypted value are not the same, but both can decrypt back.
 *
 *@author Harry Xu 
 */
public class SecureFieldsOperationHelper {  
	
	private static final String TFM_CONTENT = "content";

	private static final String AFM_CAMEL_CASE_SUBJECT_SSN = "SubjectSsn";

	private static final String TFM_IDENTIFICATION_ID = "identificationId";

	private static final String TFM_IDENTIFICATION_TYPE = "identificationType";

	private static final String TFM_TU_SOCIAL_INSURANCE_NUMBER = "socialInsuranceNumber";

	private static final String TFM_EQX_SUBJECT_SIN = "subjectSin";

	private static final String TFM_PIN = "pin";
	
	//
	private static final String AFM_IDENTIFICATION = "Identification";

	private static final String AFM_VALUE = "value";

	private static final String AFM_NAME = "name";
	
	
	private static List<String> AFM_USER_DATA_SECURE_KEYS = new ArrayList<String>() {{
        //
		//In user data as name, value pair in AFM json string
		//
		add("accPassword");
		
		add("sinNo");
		add("drivrLicnsNo");
		add("creditCardToken");
		add("passport");
		


	}};
	
	private static List<String> AFM_NON_USER_DATA_SECURE_KEYS = new ArrayList<String>() {{
      
		add("primaryIdentificationNumber");
		add("primaryIdentificationSupplemental");

		add("secondaryIdentificationNumber");
		add("secondaryIdentificationSupplemental");


		//from EQX subjectSin, or TU socialInsuranceNumber - note that AFM requires capitalized first letter for now
		add(AFM_CAMEL_CASE_SUBJECT_SSN);
		add("subjectSsn");
		add("SocialInsuranceNumber");//should not happen for AFM ApplicationRequest
		add(TFM_TU_SOCIAL_INSURANCE_NUMBER);
		
	}};
	
	//FOR TFM json string, sensitive info is identificationId if type is this, pin, and subjectSin for EFU, socialInsuranceNumber for TU bureaureport
	private static List<String> TFM_SECURE_IENTIFICATION_TYPES = new ArrayList<String>() {{
	      
		add("CC");
		add("SIN");
		add("DL");
		add("PASSPORT");		 
		
	}};
	 
	
	/**
	 * The input could be a JSONObject, JSONArray, or a Primitive/Wrapper java type object
	 */
	public static void traverseJsonNode(Object object,  Operation operation) throws Exception{
		if (object==null) {
			return;
		}
		else if (object instanceof JSONArray) {
			//Not matched by top json object in our case but nested json value
			JSONArray ar = (JSONArray)object;
			for (Object o: ar) {
				traverseJsonNode(o, operation);
			}
		}else if (object instanceof JSONObject) {
			JSONObject o = (JSONObject)object;
			Map<String, String> changes = new HashMap<>();
			for (String key : o.keySet()) {
				 	 
				Object val = o.get(key);
				if (AFM_NAME.equals(key) &&  AFM_USER_DATA_SECURE_KEYS.contains(val)) {

					//in format of 
					//      {
					//         "name": "accPassword",
					//         "value": "something"
					//       },
					//get sibling key "value" and encrypt corresponding value

					changes.put(AFM_VALUE, operation.operate((String)o.get(AFM_VALUE)));


				}
				else if (AFM_NON_USER_DATA_SECURE_KEYS.contains(key) && (val instanceof String)) {
					
					//in "primaryIdentificationNumber" : "something" format
					changes.put(key, operation.operate((String)val));
			
				}
				//TFM sensitive info - open a json string in firefox, raw Data with pretty print to have a better view
				else if (TFM_PIN.equals(key)) {
					changes.put(TFM_PIN, operation.operate((String)o.get(TFM_PIN)));
				}
				else if (TFM_EQX_SUBJECT_SIN.equals(key)) {
					changes.put(TFM_EQX_SUBJECT_SIN, operation.operate((String)o.get(TFM_EQX_SUBJECT_SIN)));
				}
				else if (TFM_TU_SOCIAL_INSURANCE_NUMBER.equals(key)) {
					changes.put(TFM_TU_SOCIAL_INSURANCE_NUMBER, operation.operate((String)o.get(TFM_TU_SOCIAL_INSURANCE_NUMBER)));
				}
				else if (TFM_IDENTIFICATION_TYPE.equals(key) && TFM_SECURE_IENTIFICATION_TYPES.contains(val)) {
					changes.put(TFM_IDENTIFICATION_ID, operation.operate((String)o.get(TFM_IDENTIFICATION_ID)));
				}
				else if (TFM_CONTENT.equals(key)) {
					String value = o.getAsString(TFM_CONTENT);
					if (value!=null) {
						//apply both so that we do not check if it is EFU or TU
				        //for Equifax 	 
						value = replaceJsonFieldValueInBureauReportString(value, "subjectSin", operation);
						//for TU	
						value = replaceJsonFieldValueInBureauReportString(value, "socialInsuranceNumber", operation);
					}
					
					changes.put(TFM_CONTENT, value);
				}
				else {
					traverseJsonNode(val, operation);
				}
			}
			update (o, changes);
		}else {
			//It is just the value in here: 2020-05-21T19:06:31.776+0000
			

		}

	}
	/**
	* To avoid ConcurrentModificationException from loop and modify using iterator
	*/
	private static void update(JSONObject o, Map<String, String> changes ) {
		for (Map.Entry<String, String> change: changes.entrySet()) {
			o.put(change.getKey(), change.getValue());
		}
	}

	private static String replaceJsonFieldValueInBureauReportString(String buJsonString, String fieldName, Operation operation)
			throws Exception {
		
		String pattern="(\"" + fieldName + "\"\\s*:\\s*)\"(.*?)\""; //"(\"socialInsuranceNumber\"\\s*:\\s*)\"(.*?)\"";
		Pattern r =Pattern.compile(pattern);
		Matcher m = r.matcher(buJsonString);

		while (m.find()) {
			buJsonString = buJsonString.replaceAll(pattern, "$1" + "\""  + operation.operate(m.group(2)) +"\"");
			 
		}
		return buJsonString;
	}
	
	/**
	 * Traverse AFM xml node and apply operation for sensitive fields.
	 * <p>TFM does not have to handle xml.
	 * @param currentNode
	 * @param operation
	 */
	public static void traverseXmlNode(Node currentNode, Operation operation) throws Exception{

		if (currentNode.hasChildNodes()) {

			int len = currentNode.getChildNodes().getLength();
			for (int i = 0; i < len; i++) {
				Node node = currentNode.getChildNodes().item(i);

				if (AFM_IDENTIFICATION.equals(node.getLocalName())) {
					// SubjectSsn is in attribute
					if (node.getAttributes() != null && node.getAttributes().getNamedItem(AFM_CAMEL_CASE_SUBJECT_SSN) != null) {
						Node subjectSsnNode = node.getAttributes().getNamedItem(AFM_CAMEL_CASE_SUBJECT_SSN);
						subjectSsnNode.setTextContent(operation.operate(subjectSsnNode.getTextContent()));
					}
				} else if (AFM_NON_USER_DATA_SECURE_KEYS.contains(node.getLocalName())) {
					// as element
					node.setTextContent(operation.operate(node.getTextContent()));
				} else if (AFM_NAME.equals(node.getLocalName()) && AFM_USER_DATA_SECURE_KEYS.contains(node.getTextContent())) {                 
					Node correspondingValueNode = findChildValueNode(node.getParentNode()); // sibling value node
					if (correspondingValueNode != null) {
						correspondingValueNode.setTextContent(operation.operate(correspondingValueNode.getTextContent()));
					}
				} else {
					traverseXmlNode(node, operation);
				}
			}

		}
	}

	private static Node findChildValueNode(Node parent) {
		if (parent == null || parent.getChildNodes() == null) {
			return null;
		}
		int len = parent.getChildNodes().getLength();
		for (int i = 0; i < len; i++) {
			Node node = parent.getChildNodes().item(i);
			if (AFM_VALUE.equals(node.getLocalName())) {
				return node;
			}
		}
		return null;
	}
	
	public static Object createJSONObject(String jsonString) throws Exception{
		Object object =null; 
		JSONParser jsonParser=new  JSONParser(JSONParser.MODE_PERMISSIVE);
		if (jsonString != null && !jsonString.isEmpty()) {
			//It could be JSONArray, but in our case it is JSONObject for top level
			object = jsonParser.parse(jsonString);
		}
		return object;
	}

}
