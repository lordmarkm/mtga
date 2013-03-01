package com.mtga.web.controller.admin;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AdminControllerImpl implements AdminController {

    private static Logger log = LoggerFactory.getLogger(AdminControllerImpl.class);
    
    @Override
    public ModelAndView admin(Principal principal) {
        
        log.info("Admin page requested by {}", principal);
        
        return new ModelAndView(VIEW_ADMIN);
    }

}
