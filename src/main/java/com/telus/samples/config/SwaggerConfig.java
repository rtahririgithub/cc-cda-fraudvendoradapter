/**
 * ===========================================================================
 * This sample code is created by the Architecture as Code team at TELUS. The
 * main purpose of this code is to give developers at TELUS a reference and
 * starting point for their projects. As a TELUS Developer, you may update your
 * copy of this code per your needs.
 * ===========================================================================
 * Last updated: 02-12-2022 Description: Sample configuration class for
 * Springfox Swagger, many "upper-level" fields in the swagger JSON are defined
 * here.
 * ===========================================================================
 */
/*
 * package com.telus.samples.config;
 * 
 * import java.lang.reflect.Field; import java.util.ArrayList; import
 * java.util.Arrays; import java.util.HashSet; import java.util.List; import
 * java.util.stream.Collectors;
 * 
 * import org.springframework.beans.BeansException; import
 * org.springframework.beans.factory.config.BeanPostProcessor; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.util.ReflectionUtils; import
 * org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
 * 
 * import springfox.documentation.builders.ApiInfoBuilder; import
 * springfox.documentation.builders.PathSelectors; import
 * springfox.documentation.builders.RequestHandlerSelectors; import
 * springfox.documentation.service.ApiInfo; import
 * springfox.documentation.service.Contact; import
 * springfox.documentation.service.StringVendorExtension; import
 * springfox.documentation.service.Tag; import
 * springfox.documentation.spi.DocumentationType; import
 * springfox.documentation.spring.web.plugins.Docket; import
 * springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;
 * 
 * @Configuration public class SwaggerConfig {
 * 
 *//**
	 * Returns a configuration builder for Springfox, note that the endpoints to be
	 * documented are currently determined by paths()
	 */
/*
 * @Bean public Docket api() {
 * 
 * return new Docket(DocumentationType.SWAGGER_2) .apiInfo(this.apiInfo())
 * .select() .apis(RequestHandlerSelectors.any())
 * .paths(PathSelectors.regex("/user(.*)")) .build() .tags( new Tag("x-apiname",
 * null), new Tag("x-api-engagement-num", null), new Tag("x-cmdbid", null), new
 * Tag("x-tps", null), new Tag("x-responsetime", null), new Tag("x-tmfdomain",
 * null) ) .protocols(new HashSet<>(Arrays.asList("http", "https")))
 * .extensions(new ArrayList<>(Arrays.asList( new
 * StringVendorExtension("x-apiname", "demoApiName"), new
 * StringVendorExtension("x-api-engagement-num","910"), new
 * StringVendorExtension("x-cmdbid", "21740"), new
 * StringVendorExtension("x-tps", "1000"), new
 * StringVendorExtension("x-responsetime", "3000"), new
 * StringVendorExtension("x-tmfdomain", "common") ))) .pathMapping("/"); }
 * 
 * private ApiInfo apiInfo() { return new
 * ApiInfoBuilder().title("Sample API with Springdocs")
 * .description("This is a simple API application made with Spring Boot and documented with Springfox"
 * ) .version("0.1") .contact(new Contact("Some One", "https://aUrl.com",
 * "someone@example.com")) .build(); }
 * 
 *//**
	 * Compatibility bean for Springfox to work with Spring Boot 2.6.x+
	 *//*
		 * @Bean public static BeanPostProcessor
		 * springfoxHandlerProviderBeanPostProcessor() { return new BeanPostProcessor()
		 * {
		 * 
		 * @Override public Object postProcessAfterInitialization(Object bean, String
		 * beanName) throws BeansException { if (bean instanceof
		 * WebMvcRequestHandlerProvider) {
		 * customizeSpringfoxHandlerMappings(getHandlerMappings(bean)); } return bean; }
		 * 
		 * private <T extends RequestMappingInfoHandlerMapping> void
		 * customizeSpringfoxHandlerMappings(List<T> mappings) { List<T> copy =
		 * mappings.stream() .filter(mapping -> mapping.getPatternParser() == null)
		 * .collect(Collectors.toList()); mappings.clear(); mappings.addAll(copy); }
		 * 
		 * @SuppressWarnings("unchecked") private List<RequestMappingInfoHandlerMapping>
		 * getHandlerMappings(Object bean) { try { Field field =
		 * ReflectionUtils.findField(bean.getClass(), "handlerMappings"); if (field !=
		 * null) { field.setAccessible(true); return
		 * (List<RequestMappingInfoHandlerMapping>) field.get(bean); } else { throw new
		 * NullPointerException(); } } catch (IllegalArgumentException |
		 * IllegalAccessException e) { throw new IllegalStateException(e); } } }; } }
		 */