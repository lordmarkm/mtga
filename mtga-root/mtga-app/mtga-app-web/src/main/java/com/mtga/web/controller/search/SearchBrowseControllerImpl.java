package com.mtga.web.controller.search;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
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
    
    @Autowired
    private Environment env;

    private int cardsPerPage = 10;
    
    @PostConstruct
    public void init() {
        cardsPerPage = Integer.valueOf(env.getProperty("browse.cardsperpage"));
    }
    
    @Override
    public ModelAndView searchBrowse(HttpServletRequest request, Principal principal) {
        String name = ControllerUtils.name(request, principal);
        log.debug("Browse page requested by request by {}", name);

        Page<? extends Card> allcards = cards.findAll(0, cardsPerPage);
        
        log.debug("Found {} cards. First card: {}", allcards.getNumberOfElements(),
                allcards.getContent().isEmpty() ? "none" : allcards.getContent().get(0));
        
        ModelAndView mav = new ModelAndView("browse/browse")
            .addObject("cards", allcards);
        
        return mav;
    }

}
