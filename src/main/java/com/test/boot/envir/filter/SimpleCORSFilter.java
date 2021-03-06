package com.test.boot.envir.filter;

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
public class SimpleCORSFilter  implements Filter{
	 	 	

	public SimpleCORSFilter() {
		System.out.println("*************SimpleCORSFilter()");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

		System.out.println("*************   doFilter() ********************");
	    HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) res;
	    
	    System.out.println("*************   doFilter() ******************** : request.getHeader(\"Origin\") :: "+request.getHeader("Origin"));

	    if(request.getHeader("Origin")==null) {
	    	request.getHeader("http://awsbootpoc-env.us-east-1.elasticbeanstalk.com");
	    }else {
	    	
	    	response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	    }
	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

	    chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filterConfig) {
		System.out.println("*************init()");
	}

	@Override
	public void destroy() {
	}

}
