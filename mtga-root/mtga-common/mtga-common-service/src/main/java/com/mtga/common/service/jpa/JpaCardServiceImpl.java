package com.mtga.common.service.jpa;

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
import com.mtga.model.jpa.JpaCard;
import com.mtga.model.jpa.JpaCastingCost;
import com.mtga.model.jpa.JpaExpansion;
import com.mtga.model.mtg.Card;
import com.mtga.model.mtg.CastingCost;
import com.mtga.model.mtg.Expansion;

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
        return cards.save(card);
    }
    
    @Override
    public Iterable<Card> findAll() {
        return cards.findAll();
    }

    @Override
    public Collection<Card> findByNameLike(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Card card) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Card create(String name) {
        // TODO Auto-generated method stub
        return null;
    }

}
