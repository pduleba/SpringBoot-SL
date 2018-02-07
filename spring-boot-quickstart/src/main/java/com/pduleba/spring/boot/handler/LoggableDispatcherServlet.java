package com.pduleba.spring.boot.handler;

import java.io.IOException;

import javax.servlet.http.*;

import org.springframework.web.servlet.*;
import org.springframework.web.util.*;

public class LoggableDispatcherServlet extends DispatcherServlet {

	private static final long serialVersionUID = 2923805735583620142L;

	@Override
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!(request instanceof ContentCachingRequestWrapper)) {
			request = new ContentCachingRequestWrapper(request);
		}
		if (!(response instanceof ContentCachingResponseWrapper)) {
			response = new ContentCachingResponseWrapper(response);
		}
		HandlerExecutionChain handler = getHandler(request);

		try {
			super.doDispatch(request, response);
		} finally {
			// log(request, response, handler);
			updateResponse(response);
		}
	}

	private void updateResponse(HttpServletResponse response) throws IOException {
		ContentCachingResponseWrapper responseWrapper = WebUtils.getNativeResponse(response,
				ContentCachingResponseWrapper.class);
		responseWrapper.copyBodyToResponse();
	}

}