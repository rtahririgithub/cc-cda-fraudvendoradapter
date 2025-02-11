package com.telus.subsfraudmgmt.springboot;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.telus.erm.referenceods.domain.ReferenceDecode;
import com.telus.erm.referenceods.domain.ReferenceMessageDecode;
import com.telus.erm.referenceods.domain.RuleOutput;
import com.telus.erm.refpds.access.client.CacheLoader;
import com.telus.erm.refpds.access.client.ReferenceData;
import com.telus.erm.refpds.access.client.ReferencePdsHelper;
import com.telus.erm.refpds.ws.client.ReferencePDSDataServicePortType;

/**
 * This is copied from ReferencePdsAccess.java so that we can customize the
 * initialization logic
 */
public class RefPdsClient {

	private static Log log = LogFactory.getLog(RefPdsClient.class);
	public static final String LANG_EN = "EN";
	public static final String LANG_FR = "FR";
	private ReferencePDSDataServicePortType service;
	private ReferenceData refData;
	private boolean isInitialized = false;
	private String appId;

	public RefPdsClient() {
	}

	private ReferencePdsHelper getHelper() {
		return new ReferencePdsHelper(getRefData());
	}

	public ReferenceData getRefData() {
		if (!isInitialized) {
			initializeCache();
		}

		if (!isInitialized) {
			throw new RuntimeException("Reference PDS Data Failed to Initialize");
		} else {
			return refData;
		}
	}

	public void refresh() {
		initializeCache();
	}

	public String getLastRefreshDateAndTime() {
		return refData == null ? "Not initialized" : refData.getLoadTime();
	}

	public String getTablesLoaded() {
		return refData == null ? "No tables loaded" : refData.getLoadedTables().toString();
	}

	public ReferenceDecode getDecode(String tableName, String lang, String aCode) {
		return getHelper().getDecode(tableName, lang, aCode);
	}

	/**
	 * @deprecated
	 */
	@SuppressWarnings("rawtypes")
	@Deprecated
	public Collection getView(String tableName, String lang) {
		return getHelper().getAllReferenceDecodes(tableName, lang);
	}

	@SuppressWarnings("rawtypes")
	public Collection getReferenceDecodes(String tableName, String lang) {
		return getHelper().getReferenceDecodes(tableName, lang);
	}

	@SuppressWarnings("rawtypes")
	public Collection getAllReferenceDecodes(String tableName, String lang) {
		return getHelper().getAllReferenceDecodes(tableName, lang);
	}

	public Boolean validateCode(String tableName, String aCode) {
		return getHelper().validateCode(tableName, aCode);
	}

	public Boolean validateCode(String tableName, String aCode, String bCode) {
		return getHelper().validateCode(tableName, aCode, bCode);
	}

	public ReferenceMessageDecode getMessage(String aMessageCode, String lang) {
		return getHelper().getMessage(aMessageCode, lang);
	}

	/**
	 * @deprecated
	 */
	@SuppressWarnings("rawtypes")
	@Deprecated
	public Collection getXrefDecodeView(String aXrefName, String aParentCode, String lang) {
		return getHelper().getAllXrefDecodes(aXrefName, aParentCode, lang);
	}

	@SuppressWarnings("rawtypes")
	public Collection getXrefDecodes(String aXrefName, String aParentCode, String lang) {
		return getHelper().getXrefDecodes(aXrefName, aParentCode, lang);
	}

	@SuppressWarnings("rawtypes")
	public Collection getAllXrefDecodes(String aXrefName, String aParentCode, String lang) {
		return getHelper().getAllXrefDecodes(aXrefName, aParentCode, lang);
	}

	@SuppressWarnings("rawtypes")
	public Collection getXrefParentCodes(String aXrefName, String aChildCode) {
		return getHelper().getXrefParentCodes(aXrefName, aChildCode);
	}

	public RuleOutput evaluateRule(String tableName, Map<String, String> input) {
		return getHelper().evaluateRule(tableName, input);
	}

	public List<RuleOutput> lookup(String tableName, Map<String, String> input) {
		return getHelper().lookup(tableName, input);
	}

	public String getDecodeText(String tableName, String lang, String aCode) {
		return getHelper().getDecodeText(tableName, lang, aCode);
	}

	public Map<String, String> getDecodes(String tableName, String language, String currCode) {
		return getHelper().getDecodes(tableName, language, currCode);
	}

	public String getMessageText(String aMessageCode, String lang) {
		return getHelper().getMessageText(aMessageCode, lang);
	}

	public Map<String, String> getXrefDecodeViewMap(String aXrefName, String aParentCode, String lang) {
		return getHelper().getXrefDecodeViewMap(aXrefName, aParentCode, lang);
	}

	public void initializeCache() {
		log.debug("initializing cache");
		try {
			CacheLoader ldr = new CacheLoader(service);
			refData = ldr.loadReferenceData(appId);
			isInitialized = true;
		} catch (Exception var1) {
			log.error("RefPDS Cache initialization Error", var1);
		}

	}

	public void setService(ReferencePDSDataServicePortType service) {
		this.service = service;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

}
