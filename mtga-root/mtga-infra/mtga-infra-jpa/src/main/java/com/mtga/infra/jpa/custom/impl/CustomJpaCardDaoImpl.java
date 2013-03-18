package com.mtga.infra.jpa.custom.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mtga.infra.jpa.custom.CustomJpaCardDao;
import com.mtga.model.jpa.JpaCard;
import com.mtga.model.mtg.Card;

@Transactional
public class CustomJpaCardDaoImpl implements CustomJpaCardDao {

    @Autowired
    private SessionFactory sessions;
    
    @Override
    public JpaCard findByNameAndExpansion(String name, String abbr) {
       return (JpaCard) sessions.getCurrentSession().createCriteria(JpaCard.class)
           .createAlias(Card.EXP_ABBR, "abbr")
           .add(Restrictions.eq("abbr", abbr))
           .add(Restrictions.like(Card.NAME, like(name)))
           .uniqueResult();
    }
    
    private String like(String like) {
        return "%" + like + "%";
    }

}
