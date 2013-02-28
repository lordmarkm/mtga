package com.mtga.infra.jpa.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mtga.common.utils.Profiles;
import com.mtga.common.utils.Properties;

@Configuration
@Import(Properties.class)
@Profile(Profiles.JPA)
public class JpaConfig {
    
    @Value("${jpa.driverClass")
    private String driverClass;
    
    @Value("${jpa.url}")
    private String url;
    
    @Value("${jpa.username}")
    private String username;
    
    @Value("${jpa.password}")
    private String password;
    
    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        
        //c3p0-specific properties follow
        dataSource.setAcquireIncrement(1);
        dataSource.setMinPoolSize(2);
        dataSource.setMaxPoolSize(5);
        dataSource.setMaxIdleTime(600);
        
        return dataSource;
    }
    
    @Bean
    public SessionFactory sessionFactory() {
        //TODO configure here instead, or use persistence unit
        return null;
    }
    
}
