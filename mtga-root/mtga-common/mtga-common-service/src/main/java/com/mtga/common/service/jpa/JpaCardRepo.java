package com.mtga.common.service.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mtga.common.service.CardRepo;
import com.mtga.common.utils.Profiles;
import com.mtga.common.utils.Repos;
import com.mtga.infra.jpa.JpaCardDao;
import com.mtga.model.jpa.JpaCard;
import com.mtga.model.mtg.Card;

@Service
@Profile(Profiles.JPA)
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages=Repos.JPA_REPOS_PKG)
public class JpaCardRepo implements CardRepo {

    @Autowired
    private JpaCardDao cards;
    
    @Override
    public Card create(String name) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Page<JpaCard> findAll(int page, int size) {
        PageRequest request = new PageRequest(page, size);
        return cards.findAll(request);
    }

    public Page<JpaCard> findByNameLike(String name, int page, int size) {
        PageRequest request = new PageRequest(page, size);
        return cards.findByNameLike(request, name);
    }
    
    @Override
    public void delete(Card card) {
        cards.delete((JpaCard)card);
    }

    @Override
    public byte[] getImage(String exp, String name) {
       JpaCard card = cards.findByNameAndExpansion(name, exp);
       return card.getImage().toBytes();
    }

    @Override
    public Card update(Card card) {
        // TODO Auto-generated method stub
        return null;
    }

}
