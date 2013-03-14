//package com.mtga.admin.service.test;
//
//import static org.junit.Assert.*;
//
//import java.util.Collection;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//
//import com.mtga.admin.service.AdminService;
//import com.mtga.common.service.config.ServiceConfig;
//import com.mtga.common.utils.Profiles;
//import com.mtga.model.mongo.MongoCard;
//import com.mtga.model.mtg.Card;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes={TestConfig.class, ServiceConfig.class}, loader=AnnotationConfigContextLoader.class)
//@ActiveProfiles(Profiles.MONGO)
//public class MongoAdminServiceTest {
//
//    @Autowired
//    private AdminService admin;
//    
//    @Test
//    public void testAdminService() {
//        String cardname = "Pacifism";
//        
//        assertNotNull(admin);
//        
//        Card card = new MongoCard();
//        card.setName(cardname);
//        
//        admin.update(card);
//        Collection<Card> found = (Collection<Card>)admin.findByName(cardname);
//        
//        assertNotNull(found);
//        assertFalse("Saved card could not be found", found.isEmpty());
//        
//        admin.delete(card);
//        found = (Collection<Card>)admin.findByName(cardname);
//        assertNotNull(found);
////        assertTrue("Card was not deleted :(", found.isEmpty());
//        
//    }
//    
//}
