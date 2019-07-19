package com.service.zuulservice;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class ZuulAuthFilter extends ZuulFilter{

	@Override
	public Object run() throws ZuulException {
		String auth = "Authenticating successful";
		System.out.println("$$$$$$$$$$$$$$$$ZUUL FILTER INVOKED$$$$$$$$$$$$$$$$$$$");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
