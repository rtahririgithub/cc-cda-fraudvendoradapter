package com.telus.subsfraudmgmt.springboot.util.xmlvalidate;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.commons.logging.Log;
import org.w3c.dom.ls.LSInput;

import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;

/**
 * String input reader
 *
 */
public class StringLSInput implements LSInput {

	private Log logger = CustomizedLogFactory.getLog(this.getClass());

	private String publicId;

	private String systemId;

	private BufferedInputStream inputStream;

	/**
	 * Constructor.
	 * 
	 * @param publicId
	 * @param sysId
	 * @param input
	 */
	public StringLSInput(String publicId, String sysId, InputStream input) {
		this.publicId = publicId;
		this.systemId = sysId;
		this.inputStream = new BufferedInputStream(input);
	}

	@Override
	public String getPublicId() {
		return publicId;
	}

	@Override
	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}

	@Override
	public String getBaseURI() {
		return null;
	}

	@Override
	public InputStream getByteStream() {
		return null;
	}

	@Override
	public boolean getCertifiedText() {
		return false;
	}

	@Override
	public Reader getCharacterStream() {
		return null;
	}

	@Override
	public String getEncoding() {
		return null;
	}

	/**
	 * The method used to read xml schema file
	 */
	@Override
	public String getStringData() {

		synchronized (inputStream) {

			try {
				byte[] input = new byte[inputStream.available()];
				int bytesRead = inputStream.read(input);
				if (bytesRead > 0) {
					return new String(input);
				} else {
					return "";
				}
			} catch (IOException e) {
				logger.error(e);
			}
			return null;
		}
	}

	@Override
	public void setBaseURI(String baseURI) {
	}

	@Override
	public void setByteStream(InputStream byteStream) {
	}

	@Override
	public void setCertifiedText(boolean certifiedText) {
	}

	@Override
	public void setCharacterStream(Reader characterStream) {
	}

	@Override
	public void setEncoding(String encoding) {
	}

	@Override
	public void setStringData(String stringData) {
	}

	@Override
	public String getSystemId() {
		return systemId;
	}

	@Override
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public BufferedInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(BufferedInputStream inputStream) {
		this.inputStream = inputStream;
	}

}