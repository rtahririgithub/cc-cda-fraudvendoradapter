package com.telus.subsfraudmgmt.springboot.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.apache.commons.logging.Log;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.util.xmlvalidate.AfmApplicationXmlValidatorImpl;
import com.telus.subsfraudmgmt.springboot.util.xmlvalidate.XmlParsingErrorHandler;

/**
 * Conversion between java object and xml, and validation of xml based on
 * application.xsd.
 */
public class AFMXmlUtil {
	private static final Log LOG = CustomizedLogFactory.getLog(AFMXmlUtil.class);
	
    //JAXBContext instance creation is expensive, use className to JAXBContext map to cache
	private static Map<String, JAXBContext> CACHE = new HashMap<>();

	public static JAXBContext getJAXBContext(Class<?> aClass) throws JAXBException{
		JAXBContext o= CACHE.get(aClass.getName());
		if (o !=null) {
			return o;
		}
		o = JAXBContext.newInstance(aClass);
	    CACHE.put(aClass.getName(), o);
	    return o;
	}
	/**
	 * convert an object to xml based on JAXB annotation
	 * 
	 * @param Object o the object to convert to xml string
	 * @param t      the object type
	 * @return the xml corresponding to the object with the specified type
	 */
	public static <T> String javaToXml(Object o, Class<T> t) throws JAXBException{
		LOG.info("javaToXml invoked for class: " + t.getName());
		long start = System.currentTimeMillis();

		try {
			JAXBContext jaxbContext = getJAXBContext(t);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setEventHandler(new ValidationEventHandler() {
				public boolean handleEvent( ValidationEvent event ) {
					return false;
				}
			});
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(o, sw);
			return sw.toString();
		}finally {
			long end= System.currentTimeMillis();
			long diff =  (end-start)/1000;
			LOG.info("----javaToXml takes in seconds: " + diff);
		}

	}

	/**
	 * convert xml to the desired type object based on JAXB annotation
	 * 
	 * @param appXML Application in xml
	 * @return the desired type java object
	 */
	public static <T> T xmlToJava(String appXML, Class<T> t) throws JAXBException{
		LOG.info("xmlToJava invoked for class: " + t.getName());
		long start = System.currentTimeMillis();
		try {
			JAXBContext jaxbContext = getJAXBContext(t);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			jaxbUnmarshaller.setEventHandler(new ValidationEventHandler() {
				public boolean handleEvent( ValidationEvent event ) {
					return false;
				}
			});

			return (T) jaxbUnmarshaller.unmarshal(new StringReader(appXML));
		}finally {
			long end= System.currentTimeMillis();
			long diff =  (end-start)/1000;
			LOG.info("----xmlToJava takes in seconds: " + diff);
		}

	}

	/**
	 * Validate against xml against application.xsd
	 * 
	 * @param appXML the xml to validate
	 */
	public static void validateXmlAgainstAppSchema(String appXML) throws Exception{
		try {
			StringWriter stringWriter = new StringWriter();
			stringWriter.write(appXML);
			new AfmApplicationXmlValidatorImpl().validateAfmApplicationXml(stringWriter, new XmlParsingErrorHandler());
		} catch (Exception e) {
			LOG.error("validate xml against app schema: \n    " + e.toString() + "\n");
			throw e;

		}

	}

}
