package com.telus.subsfraudmgmt.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:appCtx.properties")
public class AppCtx {

	@Value("${appId}")
	private String appId;

	@Value("${cmdbAppID}")
	private String cmdbAppID;
	
	@Value("${appName}")
	private String appName;


	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getCmdbAppID() {
		return cmdbAppID;
	}

	public void setCmdbAppID(String cmdbAppID) {
		this.cmdbAppID = cmdbAppID;
	}
	
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

}
