package com.programcreek.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.owasp.encoder.Encode;
 
@Controller
public class HelloWorldController {
	String message = "Welcome to Spring MVC! You know this is dynamic message :-)";
 
	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		
		String modifiedName = new String(Encode.forHtml(name));

		System.out.println("AKE: supplied input in query string is " + name);
 
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		mv.addObject("modifiedName", modifiedName);
		return mv;
	}
}
