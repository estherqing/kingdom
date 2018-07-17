package com.esther.code.modules.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	 private final Logger log = LoggerFactory.getLogger(LoginController.class);  
	
	@RequestMapping("login.do")
	public ModelAndView test(String username, ModelAndView view) {
		
		view.setViewName("test");
		view.addObject("attr", username);
		log.info("==============login controller==============");
		return view;
	}

}
