package com.pduleba.spring.boot.handler;

import org.springframework.context.annotation.*;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class ErrorHandlerConfig {

	// @Bean
	// public ServletRegistrationBean dispatcherRegistration() {
	// return new ServletRegistrationBean(dispatcherServlet());
	// }
	//
	// @Bean(name =
	// DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
	// public DispatcherServlet dispatcherServlet() {
	// return new LoggableDispatcherServlet();
	// }

	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
		CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
		loggingFilter.setIncludeClientInfo(true);
		loggingFilter.setIncludeQueryString(true);
		loggingFilter.setIncludePayload(true);
		return loggingFilter;
	}
}
