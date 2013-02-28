package com.mtga.infra.mongo.config;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoURI;

@Configuration
public class MongoConfig {

    @Value("${mongodb.dbname}")
    private String dbName;
    
    @Value("${mongodb.url}")
    private String dbUrl;
    
    @Value("${mongodb.username}")
    private String username;
    
    @Value("${mongodb.password}")
    private String password;
    
    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        MongoTemplate template = new MongoTemplate(mongo(), dbName, mongoCredentials());
        return template;
    }

    protected MongoURI mongoURI() {
        MongoURI uri = new MongoURI(dbUrl);
        return uri;
    }
    
    protected Mongo mongo() throws UnknownHostException {
        Mongo mongo = new Mongo(mongoURI());
        return mongo;
    }
    
    protected UserCredentials mongoCredentials() {
        UserCredentials creds = new UserCredentials(username, password);
        return creds;
    }
    
    
    
}
