package com.mtga.common.service.mongo;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.mtga.common.service.CardService;
import com.mtga.common.utils.Profiles;
import com.mtga.common.utils.Repos;
import com.mtga.infra.mongo.MongoCardRepo;
import com.mtga.model.mongo.MongoCard;
import com.mtga.model.mongo.MongoCastingCost;
import com.mtga.model.mongo.MongoExpansion;
import com.mtga.model.mtg.Card;
import com.mtga.model.mtg.CastingCost;
import com.mtga.model.mtg.Expansion;

@Service
@Profile(Profiles.MONGO)
@EnableMongoRepositories(basePackages=Repos.MONGO_REPOS_PKG)
public class MongoCardServiceImpl implements CardService {

    private static Logger log = LoggerFactory.getLogger(MongoCardServiceImpl.class);
    
    @Autowired
    private MongoCardRepo cards;
    
    @PostConstruct
    public void init() {
        log.info("Loaded card repo: {}", cards);
    }
    
    @Override
    public void findAll() {
        cards.deleteAll();
        
        Card c = new MongoCard();
        c.setName("Wrath of God");
        
        Expansion e = new MongoExpansion();
        c.setExpansion(e);
        
        CastingCost cc = new MongoCastingCost();
        c.setCastingCost(cc);
        
        cards.save(c);
        
        log.debug("Found {} objects", cards.count());
        log.debug("Find all result: {}", cards.findAll());
    }
    
}
