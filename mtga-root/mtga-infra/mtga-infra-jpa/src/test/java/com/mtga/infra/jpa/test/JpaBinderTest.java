package com.mtga.infra.jpa.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
import com.mtga.model.mtg.MtgaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfig.class})
@ActiveProfiles("jpa")
public class JpaBinderTest {
    
    @Autowired
    private SessionFactory sessions;
    
    @Before
    public void drop() {
        
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
        
        MtgaPlayer player = new JpaMtgaPlayer();
        player.setBinder(binder);
        binder.setOwner(player);

        Session session = sessions.openSession(); // not part of a transaction, so we need to open a session manually
        session.save(player);
        
        JpaCard woog = (JpaCard) session.createCriteria(JpaCard.class)
            .add(Restrictions.eq("name", "Wrath of God"))
            .uniqueResult();
        
        System.out.println(woog.getCollections().size());
    }
    
    private JpaCard wog() {
        CastingCost cc = new JpaCastingCost();
        cc.setString("2WW");
        
        Expansion exp = new JpaExpansion();
        exp.setAbbreviation("10th");
        exp.setName("10th Edition");
        
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
        
        Expansion exp = new JpaExpansion();
        exp.setAbbreviation("A");
        exp.setName("Alpha");
        
        JpaCard lion = JpaCard.create();
        lion.setExpansion(exp);
        lion.setName("Savannah Lions");
        lion.setCastingCost(cc);
        
        return lion;
    }
}
