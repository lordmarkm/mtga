package com.mtga.infra.mongo.test;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

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
import com.mtga.model.mtg.Card;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, loader=AnnotationConfigContextLoader.class)
@ActiveProfiles(Profiles.MONGO)
public class MongoCardDaoTest {

    private static Logger log = LoggerFactory.getLogger(MongoCardDaoTest.class);

    @Autowired
    private MongoCardDao dao;

    @Test
    public void testDao() throws IOException {
        assertNotNull(dao);
        log.info("Got dao: {}", dao);
        
        insert();
        retrieve();
        delete();
    }
    
    private void insert() throws IOException {
        MongoCard card = (MongoCard) DummyCardCreator.wog();
        dao.save(card);
        
    }
    
    private Card retrieve() {
        MongoCard card = dao.findByNameLike("Wrath of God").iterator().next();
        assertNotNull("Couldn't find the card we just inserted", card);
        log.debug("Card id: {}", card.getId());
        return card;
    }
    
    private void delete() {
        dao.delete((MongoCard)retrieve());
    }
    
}
