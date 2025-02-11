package com.telus.subsfraudmgmt.springboot.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gcp.secretmanager.SecretManagerTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import org.apache.commons.logging.Log;
/**
 * hold web service connections config from applicaiton.yaml file 
 *
 */

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class Config {

	private static final Log LOG = CustomizedLogFactory.getLog(Config.class);
	
	@Autowired
	private Environment environment;
	
	private boolean useXmlToAFMScore;
	private boolean enableCUDPub;
	private String refPdsURL; 
	
	private TeluspubInvocationExecutorConfig teluspubInvocationExecutorConfig;
	
	private Connections connections;
	
	//private CryptoConfig cryptoConfig;
	
    //one of local, dv, it01, ... from application yaml
	public String getActiveProfile() {
		return environment.getActiveProfiles()[0];
	}
	public boolean isUseXmlToAFMScore() {	
		return useXmlToAFMScore;
	}
	public void setUseXmlToAFMScore(boolean useXmlToAFMScore) {
		this.useXmlToAFMScore = useXmlToAFMScore;
	}
	public boolean isEnableCUDPub() {
		return enableCUDPub;
	}
	public void setEnableCUDPub(boolean enableCUDPub) {
		this.enableCUDPub = enableCUDPub;
	}
	public String getRefPdsURL() {
		return refPdsURL;
	}
	public void setRefPdsURL(String refPdsURL) {
		this.refPdsURL = refPdsURL;
	}
	public TeluspubInvocationExecutorConfig getTeluspubInvocationExecutorConfig() {
		return teluspubInvocationExecutorConfig;
	}
	public void setTeluspubInvocationExecutorConfig(TeluspubInvocationExecutorConfig teluspubInvocationExecutorConfig) {
		this.teluspubInvocationExecutorConfig = teluspubInvocationExecutorConfig;
	}
	public Connections getConnections() {
		return connections;
	}
	public void setConnections(Connections connections) {
		this.connections = connections;
	}
	/*
	public CryptoConfig getCryptoConfig() {
		return cryptoConfig;
	}
	public void setCryptoConfig(CryptoConfig cryptoConfig) {
		this.cryptoConfig = cryptoConfig;
	}
	*/

	public static class TeluspubInvocationExecutorConfig {
		private int corePoolSize=2;
		private int maxPoolSize=10;
		private int queueCapacity=100;
	 
		public int getCorePoolSize() {
			return corePoolSize;
		}
		public void setCorePoolSize(int corePoolSize) {
			this.corePoolSize = corePoolSize;
		}
		public int getMaxPoolSize() {
			return maxPoolSize;
		}
		public void setMaxPoolSize(int maxPoolSize) {
			this.maxPoolSize = maxPoolSize;
		}
		public int getQueueCapacity() {
			return queueCapacity;
		}
		public void setQueueCapacity(int queueCapacity) {
			this.queueCapacity = queueCapacity;
		}	
	}
	
	public static class Connections {

		private List<WebService> webServices = new ArrayList<>();

		public List<WebService> getWebServices() {
			return webServices;
		}
		
		public WebService getWebService(String name) {
			for (WebService webService: webServices) {
				if (name.equals(webService.getName())) {					 
					return webService;
				}
			}
			LOG.warn("did not find webservice with name: '" + name +"'");
			return null;
		}
		
		public void setWebServices(List<WebService> webServices) {
			this.webServices = webServices;
		}
	}


	public static class WebService {

		private String name;
		private String username;
		private String password;
		private String endpointAddress;
		private String tokenUrl;
		private String scopeId;

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEndpointAddress() {
			return endpointAddress;
		}
		public void setEndpointAddress(String endpointAddress) {
			this.endpointAddress = endpointAddress;
		}
		/**
		 * @return the tokenUrl
		 */
		public String getTokenUrl() {
			return tokenUrl;
		}
		/**
		 * @param tokenUrl the tokenUrl to set
		 */
		public void setTokenUrl(String tokenUrl) {
			this.tokenUrl = tokenUrl;
		}
		/**
		 * @return the scopeId
		 */
		public String getScopeId() {
			return scopeId;
		}
		/**
		 * @param scopeId the scopeId to set
		 */
		public void setScopeId(String scopeId) {
			this.scopeId = scopeId;
		}
		
	}
	/*
	public static class CryptoConfig {
		private String key1;
		private String key2;
		private String key3;
		private String cipherProvider;
		private String cipherTransformation;
		private String keystoreType;
		private String enableCrdDocumentEncryption;
		private String keyStoreFilePath;
		private String keyAlias;
		private String keyPW;

		public String getKey1() {
			return key1;
		}
		public void setKey1(String key1) {

			this.key1 = key1;
		}
		public String getKey2() {
			return key2;
		}
		public void setKey2(String key2) {
			this.key2 = key2;
		}
		public String getKey3() {
			return key3;
		}
		public void setKey3(String key3) {
			this.key3 = key3;
		}
		public String getCipherProvider() {
			return cipherProvider;
		}
		public void setCipherProvider(String cipherProvider) {
			this.cipherProvider = cipherProvider;
		}
		public String getCipherTransformation() {
			return cipherTransformation;
		}
		public void setCipherTransformation(String cipherTransformation) {
			this.cipherTransformation = cipherTransformation;
		}
		public String getKeystoreType() {
			return keystoreType;
		}
		public void setKeystoreType(String keystoreType) {
			this.keystoreType = keystoreType;
		}
		public String getEnableCrdDocumentEncryption() {
			return enableCrdDocumentEncryption;
		}
		public void setEnableCrdDocumentEncryption(String enableCrdDocumentEncryption) {
			this.enableCrdDocumentEncryption = enableCrdDocumentEncryption;
		}
		public String getKeyStoreFilePath() {
			return keyStoreFilePath;
		}
		public void setKeyStoreFilePath(String keyStoreFilePath) {
			this.keyStoreFilePath = keyStoreFilePath;
		}
		public String getKeyAlias() {
			return keyAlias;
		}
		public void setKeyAlias(String keyAlias) {
			this.keyAlias = keyAlias;
		}
		public String getKeyPW() {
			return keyPW;
		}
		public void setKeyPW(String keyPW) {
			this.keyPW = keyPW;
		}
		
	}
	*/

}
