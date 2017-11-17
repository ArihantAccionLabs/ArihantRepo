package com.test.boot.envir.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@Autowired 
	HttpServletRequest req;
	
	@Autowired
	ServletRequest request;
	
	@Autowired
	ServletResponse response;
	
	@RequestMapping("/")
	public String UserManagement(ModelMap model) throws Exception{
		System.out.println("IndexController------------------------");
		return "sample";
	}
	
}
