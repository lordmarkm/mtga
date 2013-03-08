package com.mtga.web.controller.search;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtga.model.mongo.MongoCardCollection;

@Controller
@RequestMapping(SearchBrowseController.domain)
public interface SearchBrowseController {

    public static final String domain = "search";
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView searchBrowse(HttpServletRequest request, Principal principal);

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody MongoCardCollection getAllCards();
    
}
