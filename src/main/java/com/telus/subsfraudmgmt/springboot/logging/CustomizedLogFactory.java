package com.telus.subsfraudmgmt.springboot.logging;

import org.apache.commons.logging.Log;

/**
 * To make <code>CustomizedLog</code> which added functionality to prefix the
 * message.
 * 
 * @author Harry Xu
 *
 */
public class CustomizedLogFactory {
	public static Log getLog(Class<?> aclass) {
		return getLog(aclass.getName());
	}

	public static Log getLog(String name) {
		return new CustomizedLog(name);
	}

}
