package com.baldwin.mtga.web.main;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

	private static Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(Principal principal, HttpServletRequest request) {
	    String name = principal != null ? principal.getName() : request.getHeader("x-forwarded-for") != null ? request.getHeader("x-forwarded-for") : request.getRemoteAddr();
		log.debug("Index request by {}", name);
		
		ModelAndView m = new ModelAndView("index");
		m.addObject("name", name);
		
		return m;
	}
	
}
