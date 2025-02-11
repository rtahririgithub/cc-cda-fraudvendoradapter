package com.telus.subsfraudmgmt.springboot.config;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate myRestTemplate() {
    	RestTemplate restTemplate = new RestTemplate(); 
		List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
		converters.removeIf(httpMessageConverter -> httpMessageConverter instanceof StringHttpMessageConverter);
		converters.add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(restTemplate.getRequestFactory()));
        return restTemplate;
    }
 

    
    @Bean
    public RestTemplate myRestTemplateDisablesCertificateVerification() throws Exception {
	     try {
	    	 RestTemplate restTemplateDisablesCertificateVerification;
			// Create a custom SSL context that trusts all certificates
			SSLContext sslContext = SSLContextBuilder.create().loadTrustMaterial(new TrustAllStrategy()).build();

			// Configure the HttpClient to use the custom SSL context and disable hostname verification
			HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
			requestFactory.setHttpClient(HttpClients.custom()
			        .setSSLContext(sslContext)
			        .setSSLHostnameVerifier(new NoopHostnameVerifier())
			        .build());

			// Create a custom RestTemplate using the custom HttpClient
			restTemplateDisablesCertificateVerification = new RestTemplate(requestFactory);
			 
			List<HttpMessageConverter<?>> converters = restTemplateDisablesCertificateVerification.getMessageConverters();
			converters.removeIf(httpMessageConverter -> httpMessageConverter instanceof StringHttpMessageConverter);
			converters.add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));			
			return restTemplateDisablesCertificateVerification;
	     } catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    	
        
    }    
}
