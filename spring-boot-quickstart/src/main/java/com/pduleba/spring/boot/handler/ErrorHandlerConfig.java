package com.pduleba.spring.boot.handler;

import java.util.Map;

import org.springframework.boot.autoconfigure.web.*;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.DispatcherServlet;

import com.pduleba.spring.boot.App;

@Configuration
public class ErrorHandlerConfig {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(App.class);

	// RESTFULL ERROR HANDLING :: I Approach
	@Bean
	public ServletRegistrationBean dispatcherRegistration() {
		return new ServletRegistrationBean(dispatcherServlet());
	}

	@Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
	public DispatcherServlet dispatcherServlet() {
		return new LoggableDispatcherServlet();
	}

	// RESTFULL ERROR HANDLING :: II Approach
	@Bean
	public ErrorAttributes errorAttributes() {
		return new DefaultErrorAttributes() {
			@Override
			public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes,
					boolean includeStackTrace) {
				Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
				log.error("ErrorHandler (I Approach) :: " + errorAttributes.toString());
				return errorAttributes;
			}
		};
	}
}
