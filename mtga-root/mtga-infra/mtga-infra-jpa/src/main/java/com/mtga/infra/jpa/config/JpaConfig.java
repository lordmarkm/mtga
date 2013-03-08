package com.mtga.infra.jpa.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate3.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mtga.common.utils.Profiles;
import com.mtga.model.jpa.JpaCard;
import com.mtga.model.jpa.JpaCastingCost;
import com.mtga.model.jpa.JpaExpansion;

@Configuration
@Import(com.mtga.common.utils.Properties.class)
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

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SessionFactory sessionFactory;
    
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

    @SuppressWarnings("rawtypes")
    private Class[] annotatedClasses = new Class[] {
            JpaCard.class,
            JpaCastingCost.class,
            JpaExpansion.class
    };

    @Bean
    public SessionFactory sessionFactory() throws Exception {

        Properties hProps = new Properties();
        hProps.load(new ClassPathResource("hibernate.properties").getInputStream());

        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(dataSource);
        sf.setAnnotatedClasses(annotatedClasses);
        sf.setHibernateProperties(hProps);
        return sf.getObject();

    }
    
    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager tm = new HibernateTransactionManager();
        tm.setDataSource(dataSource);
        tm.setSessionFactory(sessionFactory);
        return tm;
    }
    
    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }
    
//    @Bean
//    public

}
