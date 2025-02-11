package com.telus.subsfraudmgmt.springboot.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;



public class GeneralUtil {
	private static final Log LOG = CustomizedLogFactory.getLog(GeneralUtil.class);
	
	public static String readFromResourceFolder(String fileName) throws Exception {

		InputStream inputStream = GeneralUtil.class.getResourceAsStream(fileName);
		StringBuilder stringBuilder = new StringBuilder();
		try (Reader reader = new BufferedReader(
				new InputStreamReader(inputStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
			int c = 0;
			while ((c = reader.read()) != -1) {
				stringBuilder.append((char) c);
			}
		}
		return stringBuilder.toString();
	}
	
	public static String recusiveToString(Object o) {
		 return new ReflectionToStringBuilder(o, new RecursiveToStringStyle()).toString();
	}
	
	public static String reflectionToString(Object o) {
		 return new ReflectionToStringBuilder(o, ToStringStyle.DEFAULT_STYLE).toString();
	}
	
	public static String finalizeRequestId(String requestId) {
		if (requestId == null) {
			requestId = "tfm-" + UUID.randomUUID().toString();
		} else {
			requestId = "t-" + requestId;
		}
		return requestId;
	}

	/**
	 * Copy non null properties from source object to destination object matched by property name
	 * <p>For Boolean the get method has to be get instead of is.
	 * 
	 * @param source the source object
	 * @param the destination object
	 * @return null properties as an array
	 */
	public static List<String> copyNonNullProperties(Object source, Object destination){
		String[] nullProperties = getNullPropertyNames(source);
		//third argument is ignorable properties
		BeanUtils.copyProperties(source, destination, nullProperties);
		return Arrays.asList(nullProperties);
	}

	/**
	 * Returns an array of null properties of an object
	 * @param object An object to get the the property names which has a null value.
	 * @return the array of null properties of an object 
	 */ 
	private static String[] getNullPropertyNames (Object object) {

		final BeanWrapper src = new BeanWrapperImpl(object);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> nullPropertyNames = new HashSet<>();
		for(java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null) {
				nullPropertyNames.add(pd.getName());
			}
		}
		String[] result = new String[nullPropertyNames.size()];
		return nullPropertyNames.toArray(result);
	}
	
	public static long safeStringToLong(String value) {
		try {
			return Long.parseLong(value);
		}catch (RuntimeException e) {
			LOG.warn("safeStringToLong(..) throws excepion for value '" + value+"'", e);
			return 0;
		}
	}
	
	public static long safeBigDecimalToLong(BigDecimal value) {
		try {
			return Long.parseLong(value.toString());
		}catch (RuntimeException e) {
			LOG.warn("safeBigDecimalToLong(..) throws excepion for value '" + value+"'", e);
			return 0;
		}
	}
	
	  public static String getStackTrace(Throwable t) {
			 if(t!= null){
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw, true);
				t.printStackTrace(pw);
				pw.flush();
				sw.flush();
			String stckTraceStr ="[ StackTrace : "  + 	sw.toString()  +"EndOfStackTrace]";
			stckTraceStr=removeBrkLine(stckTraceStr);
			stckTraceStr=leadingTrailingEscapeChar(stckTraceStr);		
			return stckTraceStr;
			}
			return "";
		} 
	   	private static   String leadingTrailingEscapeChar( String str) {
			try{
			   str = str.startsWith("\"") ? str.substring(1) : str;
			   str = str.endsWith("\"") ? str.substring(0,str.length()-1) : str;
			}catch (Throwable e){
				LOG.warn("leadingTrailingEscapeChar(...) throws excepion ", e);
			}
			return str;
		}	
		private static   String removeBrkLine(String str) {
			try{
				str = str.replaceAll("\\r\\n|\\r|\\n", " ");
			}catch (Throwable e){
				LOG.warn("removeBrkLine(...) throws excepion ", e);
			}
			return str;
		}	
		
		public static List<String> castObjectListToStringList(List<Object> objList){
			List<String> strProbFraudValues=new ArrayList<String>(2);
		    Iterator<Object> iter = objList.iterator();
			while(iter.hasNext()){
				Object obj=iter.next();
				if (obj instanceof List) {
					for (Object object : ((List<?>) obj).toArray()) {
						strProbFraudValues.add(Objects.toString(object, null));			
					}
				}
			  
			}
			return strProbFraudValues;
		}
		public static void printProxy(String url) {
	      try {
				 // Specify the target URL
				URI uri = new URI(url);

	        // Retrieve the default proxy selector
	        ProxySelector proxySelector = ProxySelector.getDefault();
	        if(proxySelector==null)
	        		return;
	        // Use the proxy selector to get the list of proxies for the target URL
	        List<Proxy> proxies = proxySelector.select(uri);

	        // Iterate over the list of proxies
	        for (Proxy proxy : proxies) {
	            // Check if the proxy is of type HTTP or SOCKS
	            if (proxy.type() == Proxy.Type.HTTP || proxy.type() == Proxy.Type.SOCKS) {
	                InetSocketAddress address = (InetSocketAddress) proxy.address();
	                String host = address.getHostName();
	                int port = address.getPort();

	                // Print the proxy host and port
	                System.out.println("Proxy Host: " + host);
	                System.out.println("Proxy Port: " + port);
	            }
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	        
	    }	
		public static void removeProxy(String url ){
	       
	        try {
	            // Specify the target URL
	            URI uri = new URI(url);

	            // Remove proxy configuration for the specific URL
	            System.clearProperty("https.proxyHost");
	            System.clearProperty("https.proxyPort");

	            // Refresh the default proxy selector
	            ProxySelector.setDefault(null);	
			} catch (Exception e) {
				e.printStackTrace();
			}
	   }
	
		
}
