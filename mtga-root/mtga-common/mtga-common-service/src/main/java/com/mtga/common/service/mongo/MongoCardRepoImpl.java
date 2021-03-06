package com.mtga.common.service.mongo;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.mtga.common.service.CardRepo;
import com.mtga.common.utils.Profiles;
import com.mtga.common.utils.Repos;
import com.mtga.infra.mongo.MongoCardDao;
import com.mtga.model.mongo.MongoCard;
import com.mtga.model.mtg.Card;

@Service
@Profile(Profiles.MONGO)
@EnableMongoRepositories(basePackages = Repos.MONGO_REPOS_PKG)
public class MongoCardRepoImpl { //implements CardRepo {

    private static Logger log = LoggerFactory.getLogger(MongoCardRepoImpl.class);
    
    @Autowired
    private MongoCardDao cards;
    
    @PostConstruct
    public void init() {
        log.info("Loaded card repo: {}", cards);
    }
    
    public Card create(String name) {
        MongoCard card = new MongoCard();
        card.setName(name);
        return card;
    }
    
    public Card update(Card card) {
        return cards.save((MongoCard)card);
    }
    
    public Collection<Card> findByNameLike(String name) {
        return new ArrayList<Card>(cards.findByNameLike(name));
    }
    
    public Collection<Card> findAll() {
        return new ArrayList<Card>((Collection<? extends Card>) cards.findAll());
    }
    
    public void delete(Card card) {
        cards.delete((MongoCard)card);
    }

    public byte[] getImage(String exp, String name) {
        MongoCard card = cards.getImage(exp, name);
        log.debug("Got card : {}", card);
        return card.getImage().toBytes();
    }
    
}
