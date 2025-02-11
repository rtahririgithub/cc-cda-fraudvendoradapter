package com.telus.subsfraudmgmt.springboot;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import com.telus.erm.refpds.ws.client.ReferencePDSDataServicePortType;

@Configuration
public class RefPdsConfig {

	@Value("${refPdsURL}")
	private String referencePdsEndpoint;

	@Bean
	public JaxWsPortProxyFactoryBean refpdsServiceBean() throws IOException {
		JaxWsPortProxyFactoryBean factory = new JaxWsPortProxyFactoryBean();
		Resource wsdlResource = new ClassPathResource("ReferencePDSDataService_v1_0.wsdl");
		factory.setServiceInterface(ReferencePDSDataServicePortType.class);
		factory.setWsdlDocumentResource(wsdlResource);
		factory.setEndpointAddress(referencePdsEndpoint);
		factory.setServiceName("ReferencePDSDataService");
		factory.setPortName("ReferencePDSDataServicePort");
		factory.setNamespaceUri("http://telus.com/wsdl/ERM/RefPds/ReferencePDSDataService_1");
		return factory;
	}

	@Bean
	public ReferencePDSDataServicePortType refpdsService() throws IOException {
		return (ReferencePDSDataServicePortType) refpdsServiceBean().getObject();
	}

	@Bean(initMethod = "initializeCache")
	public RefPdsClient refPdsClient() throws IOException {
		RefPdsClient refPdsClient = new RefPdsClient();
		refPdsClient.setService(refpdsService());
		refPdsClient.setAppId("WLSTFMSvc");
		return refPdsClient;
	}
}