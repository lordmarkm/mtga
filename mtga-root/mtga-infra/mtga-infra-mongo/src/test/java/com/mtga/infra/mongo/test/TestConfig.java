package com.mtga.infra.mongo.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mtga.common.utils.Repos;

@Configuration
@ComponentScan(basePackages = {"com.mtga.infra.mongo"})
@EnableMongoRepositories(Repos.MONGO_REPOS_PKG)
public class TestConfig {

}
