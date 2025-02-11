package com.telus.subsfraudmgmt.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.secretmanager.SecretManagerTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.telus.framework.crypto.Crypto;
import com.telus.framework.crypto.EncryptionUtil;
import com.telus.framework.crypto.impl.jce.AlgorithmParamSpecGenerator;
import com.telus.framework.crypto.impl.jce.IvParamSpecGenerator;
import com.telus.framework.crypto.impl.pilot.PilotCryptoImpl;

@Configuration
public class CryptoConfig {
	@Autowired 
	SecretManagerTemplate secretManagerTemplate;
	
	@Value("${cryptoConfig.key1}")
	private String key1;
			
	@Value("${cryptoConfig.key2}")
	private String key2;
	
	@Value("${cryptoConfig.key3}")
	private String key3;
	
	@Value("${cryptoConfig.cipherProvider}")
	private String cipherProvider;
	
	@Value("${cryptoConfig.cipherTransformation}")
	private String cipherTransformation;
	
	@Value("${cryptoConfig.keystoreType}")
	private String keystoreType;
	
	@Value("${cryptoConfig.enableCrdDocumentEncryption}")
	private String enableCrdDocumentEncryption;
	
	@Value("${cryptoConfig.keyStoreFilePath}")
	private String keyStoreFilePath;
	
	@Value("${cryptoConfig.keystorefile}")
	private String keystorefile;
	
	@Value("${cryptoConfig.keyAlias}")
	private String keyAlias;
	
	@Value("${cryptoConfig.keyPassword}")
	private String keyPassword;

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
	
	public String getKeystorefile() {		
		return keystorefile;
	}
	public void setKeystorefile(String keystorefile) {
		byte[] x = secretManagerTemplate.getSecretBytes(keystorefile);
		
		this.keystorefile = keystorefile;
	}
		
	public String getKeyAlias() {
		return keyAlias;
	}
	public void setKeyAlias(String keyAlias) {
		this.keyAlias = keyAlias;
	}
	public String getKeyPassword() {
		return keyPassword;
	}
	public void setKeyPassword(String keyPW) {
		this.keyPassword = keyPW;
	}


	  public AlgorithmParamSpecGenerator algorithmParamSpecGenerator() {
		    return new IvParamSpecGenerator(Boolean.TRUE);
		  }

		  @Bean
		public JceCryptoImplLocal createJceCryptoImplLocal() {
			JceCryptoImplLocal bean = new JceCryptoImplLocal();
			  
			try {
			    PilotCryptoImpl pilotCrypto = new PilotCryptoImpl();
			    
			    pilotCrypto.setKey1(secretManagerTemplate.getSecretString(key1));
			    pilotCrypto.setKey2(secretManagerTemplate.getSecretString(key2));
			    pilotCrypto.setKey3(secretManagerTemplate.getSecretString(key3));
			    pilotCrypto.init();
			    
				EncryptionUtil.setCrypto(pilotCrypto);		
				bean.setAlgorithmParamSpecGenerator(algorithmParamSpecGenerator());
				bean.setEncodeBase64(Boolean.TRUE);
				bean.setKeyAlias(EncryptionUtil.decryptHex(keyAlias));
				bean.setKeyPassword(EncryptionUtil.decryptHex(secretManagerTemplate.getSecretString(keyPassword)));
				byte[] keystore_content = secretManagerTemplate.getSecretBytes(keystorefile);
				bean.init(keystore_content);
				
			} catch (Throwable e) {
				e.printStackTrace();
			}
			return bean;
		}

	

}
