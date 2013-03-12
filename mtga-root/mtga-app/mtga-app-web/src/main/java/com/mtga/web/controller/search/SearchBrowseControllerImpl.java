package com.mtga.web.controller.search;

import java.security.Principal;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.mtga.common.service.CardRepo;
import com.mtga.model.mtg.Card;
import com.mtga.web.utils.ControllerUtils;

@Component
public class SearchBrowseControllerImpl implements SearchBrowseController {

    private static final Logger log = LoggerFactory.getLogger(SearchBrowseControllerImpl.class);
    
    @Autowired
    private CardRepo cards;
    
    @Override
    public ModelAndView searchBrowse(HttpServletRequest request, Principal principal) {
        
        String name = ControllerUtils.name(request, principal);
        log.debug("Browse page requested by request by {}", name);

        Collection<Card> allcards = (Collection<Card>) cards.findAll();
        log.debug("Found {} cards. First card: {}", allcards.size(), allcards.size() > 0 ? allcards.iterator().next() : "none");
        
        ModelAndView mav = new ModelAndView("browse/browse")
            .addObject("cards", allcards);
        
        return mav;
    }

}
