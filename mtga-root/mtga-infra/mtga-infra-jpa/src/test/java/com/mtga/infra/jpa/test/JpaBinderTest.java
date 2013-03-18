package com.mtga.infra.jpa.test;

import static org.junit.Assert.*;

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
import com.mtga.model.CardCollection;
import com.mtga.model.jpa.JpaBinder;
import com.mtga.model.jpa.JpaBinderPage;
import com.mtga.model.jpa.JpaCard;
import com.mtga.model.jpa.JpaCardCollection;
import com.mtga.model.jpa.JpaCastingCost;
import com.mtga.model.jpa.JpaExpansion;
import com.mtga.model.jpa.JpaMtgaPlayer;
import com.mtga.model.mtg.CastingCost;
import com.mtga.model.mtg.Expansion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfig.class})
@ActiveProfiles("test")
@PropertySource("classpath:test.properties")
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
    
    @Test
    public void testBinders() {
        JpaCard wog = wog();
        JpaCard lion = lion();
        
        BinderPage page = JpaBinderPage.create();
        
        CardCollection coll1 = JpaCardCollection.create(wog);
        wog.addToCollection(coll1);
        coll1.setPage(page);
        
        CardCollection coll2 = JpaCardCollection.create(lion, lion);
        lion.addToCollection(coll2);
        coll2.setPage(page);
        
        page.addCards(0, coll1);   //1x wog
        page.addCards(1, coll2); //2x lion
        
        Binder binder = JpaBinder.create();
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
        CastingCost cc = new JpaCastingCost();
        cc.setString("2WW");
        
        Expansion exp = expansions.findByAbbr("10th");
        assertNotNull(exp);
        
        JpaCard wog = JpaCard.create();
        wog.setExpansion(exp);
        wog.setName("Wrath of God");
        wog.setText("Destroy all creatures. They can't be regenerated.");
        wog.setCastingCost(cc);
        
        return wog;
    }
    
    private JpaCard lion() {
        CastingCost cc = new JpaCastingCost();
        cc.setString("W");
        
        Expansion exp = expansions.findByAbbr("A");
        assertNotNull(exp);
        
        JpaCard lion = JpaCard.create();
        lion.setExpansion(exp);
        lion.setName("Savannah Lions");
        lion.setCastingCost(cc);
        
        return lion;
    }
}
