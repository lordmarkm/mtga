package com.mtga.infra.mongo.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.mtga.common.utils.Profiles;
import com.mtga.infra.mongo.MongoCardDao;
import com.mtga.model.mongo.MongoCard;
import com.mtga.model.mongo.MongoCastingCost;
import com.mtga.model.mongo.MongoExpansion;
import com.mtga.model.mtg.Card;
import com.mtga.model.mtg.Expansion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, loader=AnnotationConfigContextLoader.class)
@ActiveProfiles(Profiles.MONGO)
public class MongoCardDaoTest {

    private static Logger log = LoggerFactory.getLogger(MongoCardDaoTest.class);

    @Autowired
    private MongoCardDao dao;

    @Test
    public void testDao() {
        assertNotNull(dao);
        log.info("Got dao: {}", dao);
        
        insert();
        retrieve();
        delete();
    }
    
    private void insert() {
        MongoExpansion exp = new MongoExpansion();
        exp.setName("Ravnica");
        exp.setAbbreviation("RAV");

        MongoCastingCost cc = new MongoCastingCost();
        cc.setString("1W");
        
        MongoCard card = new MongoCard();
        card.setExpansion(exp);
        card.setCastingCost(cc);
        card.setName("Pacifism");
        
        dao.save(card);
    }
    
    private Card retrieve() {
        MongoCard card = dao.findByNameLike("Pacifism").iterator().next();
        assertNotNull("Couldn't find the card we just inserted", card);
        log.debug("Card id: {}", card.getId());
        return card;
    }
    
    private void delete() {
        dao.delete((MongoCard)retrieve());
    }
    
}