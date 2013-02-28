package com.mtga.infra.mongo.config;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mtga.common.utils.Profiles;
import com.mtga.common.utils.Properties;

@Configuration
@Import(Properties.class)
@Profile(Profiles.MONGO)
public class MongoConfig {

    @Value("${mongodb.dbname}")
    private String dbName;
    
    @Value("${mongodb.host}")
    private String host;
    
    @Value("${mongodb.port}")
    private int port;
    
    @Value("${mongodb.username}")
    private String username;
    
    @Value("${mongodb.password}")
    private String password;
    
    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        MongoTemplate template = new MongoTemplate(mongo(), dbName, mongoCredentials());
        return template;
    }

    protected Mongo mongo() throws UnknownHostException {
        Mongo mongo = new Mongo(host, port);
        return mongo;
    }
    
    protected UserCredentials mongoCredentials() {
        UserCredentials creds = new UserCredentials(username, password);
        return creds;
    }
    
    
    
}