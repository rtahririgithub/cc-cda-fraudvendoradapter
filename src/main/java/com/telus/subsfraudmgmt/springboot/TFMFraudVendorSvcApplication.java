package com.telus.subsfraudmgmt.springboot;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class })
@EnableSwagger2
@ComponentScan(
		basePackages = 
		{ 
			"com.telus.subsfraudmgmt.springboot",
			"com.telus.subsfraudmgmt.springboot.config",
			"com.telus.subsfraudmgmt.api", 
			"io.swagger.configuration",
			"com.telus.kong.api.security"
			
		}
		)
//@MapperScan("com.telus.subsfraudmgmt.springboot.mybatis")

public class TFMFraudVendorSvcApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(TFMFraudVendorSvcApplication.class, args);
		// @EnableWebMvc plus this to make wrong url visit expose
		// NoHandlerFoundException
		DispatcherServlet dispatcherServlet = (DispatcherServlet) ctx.getBean("dispatcherServlet");
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

	}

	@Bean
	public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
		return new BeanFactoryPostProcessor() {

			@Override
			public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
				BeanDefinition bean = beanFactory.getBeanDefinition(
						DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);

				bean.getPropertyValues().add("loadOnStartup", 1);
			}
		};
	}

}
