package com.pduleba.spring.boot.handler;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.*;

//@Component
class LogRequestFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(LogRequestFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
		ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);

		int responseStatus = wrappedResponse.getStatusCode();

		if (responseStatus == 500) {
			String requestUri = wrappedRequest.getRequestURI();
			byte[] responseBodyBytes = wrappedResponse.getContentAsByteArray();
			logger.error("{}, {}, {}", responseStatus, requestUri, new String(responseBodyBytes));
		}

		filterChain.doFilter(wrappedRequest, response);
	}
}