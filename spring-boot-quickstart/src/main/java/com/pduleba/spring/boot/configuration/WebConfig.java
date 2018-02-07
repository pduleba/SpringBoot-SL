package com.pduleba.spring.boot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

		// http://localhost:8080/controller.xml
		// instead of
		// http://localhost:8080/controller + header Accept=application/xml
		configurer.favorPathExtension(true).

		// http://localhost:8080/controller?mediaType=xml
		// instead of
		// http://localhost:8080/controller + header Accept=application/xml
		favorParameter(false).
		// the favour parameter is set to "mediaType" instead of default "format"
		parameterName("mediaType").
		mediaType("xml", MediaType.APPLICATION_XML).
		mediaType("json", MediaType.APPLICATION_JSON).

		// ignore the Accept headers
		// http://localhost:8080/controller + header Accept=application/xml
		ignoreAcceptHeader(true).

		// dont use Java Activation Framework since we are manually specifying the
		// mediatypes required below
		useJaf(false)

		// defaults
		.defaultContentType(MediaType.APPLICATION_JSON);
	}
}