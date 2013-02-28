package com.mtga.common.service.jpa;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.mtga.common.service.CardService;
import com.mtga.common.utils.Profiles;
import com.mtga.common.utils.Repos;
import com.mtga.infra.jpa.JpaCardRepo;
import com.mtga.model.jpa.JpaCard;
import com.mtga.model.jpa.JpaCastingCost;
import com.mtga.model.jpa.JpaExpansion;
import com.mtga.model.mtg.Card;
import com.mtga.model.mtg.CastingCost;
import com.mtga.model.mtg.Expansion;

@Service
@Profile(Profiles.JPA)
@EnableJpaRepositories(basePackages=Repos.JPA_REPOS_PKG)
public class JpaCardServiceImpl implements CardService {

    private static Logger log = LoggerFactory.getLogger(JpaCardServiceImpl.class);
    
    @Autowired
    private JpaCardRepo cards;
    
    @PostConstruct
    public void init() {
        log.info("Loaded card repo: {}", cards);
    }
    
    @Override
    public void findAll() {
        cards.deleteAll();
        
        Card c = new JpaCard();
        c.setName("Wrath of God");
        
        Expansion e = new JpaExpansion();
        c.setExpansion(e);
        
        CastingCost cc = new JpaCastingCost();
        c.setCastingCost(cc);
        
        cards.save(c);
        
        log.debug("Found {} objects", cards.count());
        log.debug("Find all result: {}", cards.findAll());
    }

}
