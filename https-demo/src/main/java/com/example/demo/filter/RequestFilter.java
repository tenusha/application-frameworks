package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class RequestFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) res;

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, application/json");
		//response.setHeader("Access-Control-Expose-Headers", "Location");
		
		HttpServletRequest currentRequest = (HttpServletRequest) req;
		MultipleReadHttpRequest wrappedRequest = new MultipleReadHttpRequest(currentRequest);

		chain.doFilter(wrappedRequest, res);
	}

	@Override
	public void init(FilterConfig filterConfig) {
		// Do nothing
	}

	@Override
	public void destroy() {
		// Do nothing
	}

}