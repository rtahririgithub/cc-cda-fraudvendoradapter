package com.telus.subsfraudmgmt.springboot.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.telus.subsfraudmgmt.springboot.RequestId;
/**
 * Implement our own Log for message to be prefixable.
 * <p>Delegate to jcl SLF4jLogFactory.
 * @author Harry Xu
 *
 */
public class CustomizedLog implements org.apache.commons.logging.Log{

	private Log targetLog = LogFactory.getLog(CustomizedLog.class);

	public CustomizedLog() {
		targetLog = LogFactory.getLog(CustomizedLog.class);
	}

	public CustomizedLog(String arg) {
		targetLog = LogFactory.getLog(arg);
	}
	
	@Override
	public boolean isDebugEnabled() {
		return targetLog.isDebugEnabled();
	}

	@Override
	public boolean isErrorEnabled() {
		return targetLog.isErrorEnabled();
	}

	@Override
	public boolean isFatalEnabled() {
		return targetLog.isFatalEnabled();
	}

	@Override
	public boolean isInfoEnabled() {
		return targetLog.isInfoEnabled();
	}

	@Override
	public boolean isTraceEnabled() {
		return targetLog.isTraceEnabled();
	}

	@Override
	public boolean isWarnEnabled() {
		return targetLog.isWarnEnabled();
	}

	@Override
	public void trace(Object message) {
		targetLog.trace(wrapMessae(message));
		
	}

	@Override
	public void trace(Object message, Throwable t) {
		targetLog.trace(wrapMessae(message), t);
		
	}

	@Override
	public void debug(Object message) {
		targetLog.debug(wrapMessae(message));
		
	}

	@Override
	public void debug(Object message, Throwable t) {
		targetLog.debug(wrapMessae(message), t);
		
	}

	@Override
	public void info(Object message) {
		targetLog.info(wrapMessae(message));
		
	}

	@Override
	public void info(Object message, Throwable t) {
		targetLog.info(wrapMessae(message), t);
		
	}

	@Override
	public void warn(Object message) {
		targetLog.warn(wrapMessae(message));
		
	}

	@Override
	public void warn(Object message, Throwable t) {
		targetLog.warn(wrapMessae(message), t);
		
	}

	@Override
	public void error(Object message) {
		targetLog.error(wrapMessae(message));
		
	}

	@Override
	public void error(Object message, Throwable t) {
		targetLog.error(wrapMessae(message), t);
		
	}

	@Override
	public void fatal(Object message) {
		targetLog.fatal(wrapMessae(message));
		
	}

	@Override
	public void fatal(Object message, Throwable t) {
		targetLog.fatal(wrapMessae(message), t);
		
	}
	
	private static String wrapMessae(Object message) {
		return RequestId.get() + " -- " +  message;
	}

}
