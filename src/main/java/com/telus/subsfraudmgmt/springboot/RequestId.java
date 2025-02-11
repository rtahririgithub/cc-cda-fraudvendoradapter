package com.telus.subsfraudmgmt.springboot;

/**
 * 
 * Thread local representation of request id.
 * 
 * 
 * @author Harry Xu
 */
public class RequestId {
	private static final String UNDEFINED_REQUEST_ID = "requestId?";
	
	private RequestId() { }
	
	private static ThreadLocal<String> holder = new ThreadLocal<String>() {
	    @Override
		protected synchronized String initialValue() {
			return UNDEFINED_REQUEST_ID;
		}
	};

	/**
	 * Get the value in ThreadLocal
	 * @return the value in ThreadLocal
	 */
	public static String get() {
		return holder.get();
	}

	/**
	 * set the value in ThreadLocal
	 *  @param requestId the value to set in ThreadLocal
	 */
	public static void set(String requestId) {
		holder.set(requestId);
	}
	
	/**
	 * Remove the value from thread local
	 */
	public static void remove() {
		holder.remove();
	}
}
