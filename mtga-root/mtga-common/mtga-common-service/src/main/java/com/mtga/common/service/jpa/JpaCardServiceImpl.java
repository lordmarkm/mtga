package com.mtga.common.service.jpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mtga.common.service.CardRepo;
import com.mtga.common.utils.Profiles;
import com.mtga.common.utils.Repos;
import com.mtga.infra.jpa.JpaCardDao;
import com.mtga.model.CardCollection;
import com.mtga.model.jpa.JpaCard;
import com.mtga.model.jpa.JpaCardCollection;
import com.mtga.model.mtg.Card;

@Service
@Profile(Profiles.JPA)
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages=Repos.JPA_REPOS_PKG)
public class JpaCardServiceImpl implements CardRepo {

    private static Logger log = LoggerFactory.getLogger(JpaCardServiceImpl.class);
    
    @Autowired
    private JpaCardDao cards;
    
    @PostConstruct
    public void init() {
        log.info("Loaded card repo: {}", cards);
    }
    
    @Override
    public Card update(Card card) {
        return cards.save((JpaCard)card);
    }
    
    @Override
    public Collection<Card> findAll() {
        return new ArrayList<Card>((Collection<JpaCard>)cards.findAll());
    }

    @Override
    public Collection<Card> findByNameLike(String name) {
        return new ArrayList<Card>(cards.findByNameLike(name));
    }

    @Override
    public void delete(Card card) {
        cards.delete((JpaCard)card);
    }

    @Override
    public Card create(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public byte[] getImage(String exp, String name) {
       JpaCard card = cards.findByNameAndExpansion(name, exp);
       return card.getImage().toBytes();
    }

}
