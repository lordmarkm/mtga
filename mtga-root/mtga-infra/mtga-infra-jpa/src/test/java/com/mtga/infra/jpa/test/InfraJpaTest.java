package com.mtga.infra.jpa.test;

import static org.junit.Assert.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mtga.infra.jpa.config.JpaConfig;
import com.mtga.model.jpa.JpaCard;
import com.mtga.model.jpa.JpaCastingCost;
import com.mtga.model.jpa.JpaExpansion;
import com.mtga.model.mtg.Card;
import com.mtga.model.mtg.CastingCost;
import com.mtga.model.mtg.Expansion;

/**
 * @author mbmartinez
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfig.class})
@ActiveProfiles("jpa")
public class InfraJpaTest {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void retrieveAccount() {
        Expansion tenth = create10th();
        insert(tenth);
        Card wog = retrieve();
        wog.setExpansion(tenth);
        delete(wog);
        delete(tenth);
    }
    
    private Card wog() {
        CastingCost cc = new JpaCastingCost();
        cc.setString("2WW");
        
        Card wog = new JpaCard();
        wog.setName("Wrath of God");
        wog.setText("Destroy all creatures. They can't be regenerated.");
        wog.setCastingCost(cc);
        
        return wog;
    }
    
    private Expansion create10th() {
        Expansion e = new JpaExpansion();
        e.setAbbreviation("10th");
        e.setName("10th Edition");

        Session session = sessionFactory.openSession(); // not part of a transaction, so we need to open a session manually
        session.save(e);
        
        return e;
    }
    
    private void insert(Expansion exp) {
        Card wog = wog();
        wog.setExpansion(exp);
        
        Session session = sessionFactory.openSession(); // not part of a transaction, so we need to open a session manually
        
        session.save(wog);
        session.flush();
        session.close();
    }
    
    private Card retrieve() {
        Session session = sessionFactory.openSession(); // not part of a transaction, so we need to open a session manually
        Query query = session.createQuery("from JpaCard c where c.name=:name")
                .setString("name", "Wrath of God");
        Card card = (Card) query.uniqueResult();
        session.close();
        
        assertNotNull(card);
        assertNotNull(card.getCastingCost());
        assertEquals("2WW", card.getCastingCost().getString());

        return card;
    }
    
    private void delete(Object o) {
        
        Session session = sessionFactory.openSession(); // not part of a transaction, so we need to open a session manually
        session.delete(o);
        session.flush();
        session.close();

    }

}

