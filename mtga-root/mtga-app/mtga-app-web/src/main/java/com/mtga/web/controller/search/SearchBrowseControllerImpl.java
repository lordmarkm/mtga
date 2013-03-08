package com.mtga.web.controller.search;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.mtga.common.service.CardRepo;
import com.mtga.model.mongo.MongoCard;
import com.mtga.model.mongo.MongoCardCollection;
import com.mtga.model.mtg.Card;
import com.mtga.web.utils.ControllerUtils;

@Component
public class SearchBrowseControllerImpl implements SearchBrowseController {

    private static final Logger log = LoggerFactory.getLogger(SearchBrowseControllerImpl.class);
    
    @Autowired
    private CardRepo cards;
    
    @Override
    public MongoCardCollection getAllCards() {
        
        List<MongoCard> mongocards = new ArrayList<MongoCard>();
        Collection<Card> c = (Collection<Card>)(cards.findAll());
        for(Card cc : c) {
            mongocards.add((MongoCard)cc);
        }
        return new MongoCardCollection(mongocards);
        
    }
    
    @Override
    public ModelAndView searchBrowse(HttpServletRequest request, Principal principal) {
        
        String name = ControllerUtils.name(request, principal);
        log.debug("Browse page requested by request by {}", name);

        Collection<Card> allcards = (Collection<Card>) cards.findAll();
        
        ModelAndView mav = new ModelAndView("browse/browse")
            .addObject("cards", allcards);
        
        return mav;
    }

}
