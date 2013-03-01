package com.mtga.web.controller.admin;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(AdminController.DOMAIN)
public interface AdminController {

    public static String DOMAIN = "admin";
    
    public static String VIEW_ADMIN = "admin";
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView admin(Principal principal);
    
}
