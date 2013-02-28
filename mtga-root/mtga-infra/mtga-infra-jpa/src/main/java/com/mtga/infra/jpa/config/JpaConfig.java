package com.mtga.infra.jpa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mtga.common.utils.Profiles;
import com.mtga.common.utils.Properties;

@Configuration
@Import(Properties.class)
@Profile(Profiles.JPA)
public class JpaConfig {
    
    @Value("${jpa.url}")
    private String url;
    
    @Value("${jpa.username}")
    private String username;
    
    @Value("${jpa.password}")
    private String password;
    
    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(url, username, password);
    }
    
}
