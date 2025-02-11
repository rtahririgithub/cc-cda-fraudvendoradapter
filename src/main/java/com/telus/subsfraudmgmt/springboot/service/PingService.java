package com.telus.subsfraudmgmt.springboot.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telus.subsfraudmgmt.springboot.config.AppCtx;
import com.telus.subsfraudmgmt.springboot.model.Ping;


@Service
public class PingService {
	public static final String S_HTTP_STATUS_200 = "200";
	public static final String S_HTTP_STATUS_SUCCESS = "Success";
	public static final String S_SERVICE_DESC="This service provides operations: fraud check, fraud file create delete, and disposition update for app and case.";


	@Autowired
	private AppCtx appCtx;
	
	private final Log log = LogFactory.getLog(PingService.class);
	
	/**
	 * provide ping message
	 */
	public String getPingMessage() {
		
		Ping ping = new Ping();
		
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SZ");
	    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String currentUtcTime = sdf.format(cal.getTime());
		
		Ping.PingResult result = ping.getPingResult();
		result.setDescriptionTxt(S_SERVICE_DESC);
		result.setNameTxt(appCtx.getAppName());
		result.setTimestamp(currentUtcTime);

		Ping.Status status = result.getStatus();

		status.setStatusCd(S_HTTP_STATUS_200);
		status.setStatusTxt(S_HTTP_STATUS_SUCCESS);
		status.setSystemErrorTimeStamp(currentUtcTime);

		result.setStatus(status);
		
		return toJson(ping, false);
	}

	private String toJson(Ping ping,
			boolean htmlFormat) {

		String htmlPrefix = "<pre><code>";
		String htmlSuffix = "</pre></code>";

		String jsonProps = "ERROR";

		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonProps = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ping.PingResult());

		} catch (Exception e) {
			String errMsg = "Unable to marshall Ping object into JSON: "+ e.getMessage();
			log.error("PingService:ERROR" + errMsg, e);

		}

		if (htmlFormat) {
			jsonProps = htmlPrefix + jsonProps + htmlSuffix;
		}

		return jsonProps;
	}


}
