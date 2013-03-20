package com.mtga.infra.jpa.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mtga.infra.jpa.JpaCardDao;
import com.mtga.infra.jpa.JpaExpansionDao;
import com.mtga.infra.jpa.JpaPlayerDao;
import com.mtga.infra.jpa.config.JpaConfig;
import com.mtga.model.Binder;
import com.mtga.model.BinderPage;
import com.mtga.model.jpa.JpaBinder;
import com.mtga.model.jpa.JpaBinderPage;
import com.mtga.model.jpa.JpaCard;
import com.mtga.model.jpa.JpaCardCollection;
import com.mtga.model.jpa.JpaCastingCost;
import com.mtga.model.jpa.JpaExpansion;
import com.mtga.model.jpa.JpaMtgaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfig.class})
@ActiveProfiles("jpa")
@PropertySource("classpath:dev.properties")
public class JpaBinderTest {
    
    @Autowired
    private JpaPlayerDao players;

    @Autowired
    private JpaExpansionDao expansions;
    
    @Autowired
    private JpaCardDao cards;
    
    @Before
    public void setup() {
        //this call should cascade to delete all binders, binder pages, and card collections
        players.deleteAll();
        cards.deleteAll();
        expansions.deleteAll();
        
        JpaExpansion alpha = new JpaExpansion();
        alpha.setAbbreviation("A");
        alpha.setName("Alpha");
        expansions.save(alpha);
        
        JpaExpansion tenth = new JpaExpansion();
        tenth.setAbbreviation("10th");
        tenth.setName("10th Edition");
        expansions.save(tenth);
    }
    
//    @Test
    public void savecard() {
        JpaCard wog = wog();
        cards.save(wog);
        
        JpaCard card = cards.findByName("Wrath of God");
        System.out.println(card);
    }
    
    @Test
    public void testBinders() {
        JpaCard wog = wog();
        JpaCard lion = lion();
        wog = cards.save(wog);
        lion = cards.save(lion);
        
        JpaBinderPage page = JpaBinderPage.create();
        
        JpaCardCollection coll1 = JpaCardCollection.create(wog);
        wog.addToCollection(coll1);
        coll1.setPage(page);
        
        JpaCardCollection coll2 = JpaCardCollection.create(lion, lion);
        lion.addToCollection(coll2);
        coll2.setPage(page);
        
        page.addCards(0, coll1);   //1x wog
        page.addCards(1, coll2); //2x lion
        
        JpaBinder binder = JpaBinder.create();
        binder.addPage(page);
        page.setBinder(binder);
        
        JpaMtgaPlayer player = new JpaMtgaPlayer();
        player.setBinder(binder);
        binder.setOwner(player);

        System.out.println("Exp values prior to save: " + wog.getExpansion() + " " + lion.getExpansion());
        
        players.save(player);
        
        List<JpaCard> allcards = (List<JpaCard>) cards.findAll();
        assertEquals(2, allcards.size());
    }
    
    private JpaCard wog() {
        JpaCastingCost cc = new JpaCastingCost();
        cc.setString("2WW");
        
        JpaExpansion exp = expansions.findWithCards("10th");
        assertNotNull(exp);
        System.out.println("Found exp: " + exp);
        
        JpaCard wog = JpaCard.create();
        wog.setExpansion(exp);
        wog.setName("Wrath of God");
        wog.setText("Destroy all creatures. They can't be regenerated.");
        wog.setCastingCost(cc);
        
        exp.getCards().add(wog);
        
        return wog;
    }
    
    private JpaCard lion() {
        JpaCastingCost cc = new JpaCastingCost();
        cc.setString("W");
        
        //JpaExpansion exp = expansions.findByAbbr("A");
        JpaExpansion exp = expansions.findWithCards("A");
        assertNotNull(exp);
        System.out.println("Found exp: " + exp);
        
        JpaCard lion = JpaCard.create();
        lion.setExpansion(exp);
        lion.setName("Savannah Lions");
        lion.setCastingCost(cc);
        
        exp.getCards().add(lion);
        
        return lion;
    }
}
