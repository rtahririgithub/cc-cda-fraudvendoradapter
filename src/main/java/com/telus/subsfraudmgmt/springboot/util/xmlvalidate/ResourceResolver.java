package com.telus.subsfraudmgmt.springboot.util.xmlvalidate;

import java.io.InputStream;

import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

/**
 * Implementation of <code>LSResourceResolver</code>
 * 
 * @author Harry Xu
 *
 */
public class ResourceResolver implements LSResourceResolver {

	private String prefix;

	@Override
	public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {

		String prefixSystemId = prefix + "/" + systemId;
		InputStream resourceAsStream = this.getClass().getResourceAsStream(prefixSystemId);
		return new StringLSInput(publicId, prefixSystemId, resourceAsStream);
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
