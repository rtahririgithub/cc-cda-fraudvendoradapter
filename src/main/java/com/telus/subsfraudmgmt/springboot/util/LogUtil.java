package com.telus.subsfraudmgmt.springboot.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.logging.Log;

import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;



public class LogUtil {
	private static final Log LOG = CustomizedLogFactory.getLog(LogUtil.class);
	public static void logPerformance(String msg){
		LOG.info(msg);
	}

	public static String getStackTrace(Throwable t) {
		String stckTraceStr ="";
		try{
			if(t!= null){
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw, true);
				t.printStackTrace(pw);
				pw.flush();
				sw.flush();
				stckTraceStr ="[ StackTrace : "  + 	sw.toString()  +"EndOfStackTrace]";
				stckTraceStr=removeBrkLine(stckTraceStr);
				stckTraceStr=leadingTrailingEscapeChar(stckTraceStr);		
			}
		}catch (Throwable e){}
		return stckTraceStr;
	}  
	   public static   String removeBrkLine(String str) {
			if(str!=null && !str.isEmpty()){
				try{
					str = str.replaceAll("\\r\\n|\\r|\\n", " ");
				}catch (Throwable e){}
			}
			return str;
		}

	   public static   String leadingTrailingEscapeChar( String str) {
			if(str!=null && !str.isEmpty()){
				try{
				   str = str.startsWith("\"") ? str.substring(1) : str;
				   str = str.endsWith("\"") ? str.substring(0,str.length()-1) : str;
				}catch (Throwable e){}
			}
			return str;
	   }	
}
