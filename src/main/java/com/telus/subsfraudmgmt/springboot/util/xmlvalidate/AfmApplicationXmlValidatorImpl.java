package com.telus.subsfraudmgmt.springboot.util.xmlvalidate;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * AfmApplicationXmlValidator implementation to validate xml against
 * application.xsd.
 * 
 * @author Harry Xu
 *
 */

public class AfmApplicationXmlValidatorImpl implements AfmApplicationXmlValidator {

	private static final String AFMSCHEMAS_APPLICATION_XSD = "/afmschemas/application.xsd";
	private static final String AFMSCHEMAS = "/afmschemas";

	@Override
	public Document validateAfmApplicationXml(StringWriter stringWriter, XmlParsingErrorHandler errorHandler)
			throws AfmApplicationValidatorException {

		try {

			String schemaLang = "http://www.w3.org/2001/XMLSchema";

			SchemaFactory schemaFactory = SchemaFactory.newInstance(schemaLang);
			ResourceResolver resolver = new ResourceResolver();
			resolver.setPrefix(AFMSCHEMAS);// set this prefix since your schema is not in the root of classpath
			schemaFactory.setResourceResolver(resolver);
			schemaFactory.setErrorHandler(errorHandler);

			InputStream inputStream = AfmApplicationXmlValidatorImpl.class
					.getResourceAsStream(AFMSCHEMAS_APPLICATION_XSD);// classpath resource
			StreamSource streamSource = new StreamSource(inputStream);
			Schema schema = schemaFactory.newSchema(streamSource);

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			documentBuilderFactory.setSchema(schema);
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			documentBuilder.setErrorHandler(errorHandler);

			java.io.Reader reader = new java.io.StringReader(stringWriter.toString());

			Document doc = documentBuilder.parse(new InputSource(reader));
			return doc;
			
		} catch (Exception e) {
			throw new AfmApplicationValidatorException(errorHandler.getErrors());

		}

	}

}
