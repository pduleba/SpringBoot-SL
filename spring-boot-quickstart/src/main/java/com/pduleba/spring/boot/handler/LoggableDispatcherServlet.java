package com.pduleba.spring.boot.handler;

import java.io.*;

import javax.servlet.http.*;

import org.springframework.web.servlet.*;
import org.springframework.web.util.*;

public class LoggableDispatcherServlet extends DispatcherServlet {

	private static final long serialVersionUID = 843988381166635080L;

	@Override
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!(request instanceof ContentCachingRequestWrapper)) {
			request = new ContentCachingRequestWrapper(request);
		}
		if (!(response instanceof ContentCachingResponseWrapper)) {
			response = new ContentCachingResponseWrapper(response);
		}

		try {
			super.doDispatch(request, response);
		} finally {
			HandlerExecutionChain handler = getHandler(request);
			log(request, response, handler);
			updateResponse(response);
		}
	}

	private void log(HttpServletRequest requestToCache, HttpServletResponse responseToCache,
			HandlerExecutionChain handler) {
		String payload = getResponsePayload(responseToCache);
		logger.error("ErrorHandler (II Approach) :: " + payload);
	}

	private String getResponsePayload(HttpServletResponse response) {
		ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(response,
				ContentCachingResponseWrapper.class);
		if (wrapper != null) {

			byte[] buf = wrapper.getContentAsByteArray();
			if (buf.length > 0) {
				int length = Math.min(buf.length, 5120);
				try {
					return new String(buf, 0, length, wrapper.getCharacterEncoding());
				} catch (UnsupportedEncodingException ex) {
					// NOOP
				}
			}
		}
		return "[unknown]";
	}

	private void updateResponse(HttpServletResponse response) throws IOException {
		ContentCachingResponseWrapper responseWrapper = WebUtils.getNativeResponse(response,
				ContentCachingResponseWrapper.class);
		responseWrapper.copyBodyToResponse();
	}

}