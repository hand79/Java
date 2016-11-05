package com.max.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.max.boot.web.TestProperty;

//@RequestMapping("/")
@Controller
public class DispathServlet {

	@Autowired
	TestProperty testProperty;
	
	@RequestMapping(value = "/")
	public ModelAndView root(){
		ModelAndView  model = new ModelAndView("index");
		return model; 
	}
	
	@RequestMapping(value = "/index")
	public String index(){
		return "index"; 
	}
	
	//test 
	@RequestMapping(value = "/indexPage")
	public @ResponseBody String indexPage(){
		return "TODO! IndexPage~"; 
	}
	
	@RequestMapping(value = "/test")
	public String test(){
		return "test! HellWord!";
	}
	
	@RequestMapping(value = "/testProperty")
	public String testProperty(){
		return testProperty.toString();
	}
	
}
