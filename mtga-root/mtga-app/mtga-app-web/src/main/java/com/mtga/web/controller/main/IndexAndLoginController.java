package com.mtga.web.controller.main;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mtga.web.utils.ControllerUtils;

@Controller
@RequestMapping("/")
public class IndexAndLoginController {

	private static Logger log = LoggerFactory.getLogger(IndexAndLoginController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(Principal principal, HttpServletRequest request) {
	    String name = ControllerUtils.name(request, principal);
		log.debug("Index request by {}", name);
		
		ModelAndView m = new ModelAndView("index");
		m.addObject("name", name);
		
		return m;
	}
	
    @RequestMapping("/login/")
    public String sociallogin(HttpServletRequest request) {
        String referrer = request.getHeader("referer");
        log.debug("Referrer: {}", referrer);
        
        if(null != referrer) {
            request.getSession(true).setAttribute("originalUrl", referrer);
        }
        
        return "auth/login";
    }
	
}
