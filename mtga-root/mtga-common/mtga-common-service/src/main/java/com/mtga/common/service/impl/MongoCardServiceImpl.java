package com.mtga.common.service.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.mtga.common.service.CardService;
import com.mtga.common.utils.Profiles;
import com.mtga.common.utils.Repos;
import com.mtga.infra.mongo.MongoCardRepo;

@Service
//@Profile(Profiles.MONGO)
@EnableMongoRepositories(basePackages=Repos.MONGO_REPOS)
public class MongoCardServiceImpl implements CardService {

    private static Logger log = LoggerFactory.getLogger(MongoCardServiceImpl.class);
    
    @Autowired
    private MongoCardRepo cards;
    
    @PostConstruct
    public void init() {
        log.info("Loaded card repo: {}", cards);
    }
    
}
