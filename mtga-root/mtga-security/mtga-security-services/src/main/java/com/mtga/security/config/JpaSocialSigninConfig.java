package com.mtga.security.config;

import javax.sql.DataSource;

import org.socialsignin.springsocial.security.web.ProviderSignInOrConnectController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

@Configuration
@ComponentScan(basePackages = {JpaSocialSigninConfig.SSS_BASE_PKG })
public class JpaSocialSigninConfig {

    public static final String SSS_BASE_PKG = "org.socialsignin";
    
    private static final String fbId = "473430229372396";
    private static final String fbSecret = "eb00cf5009ced42daf102c76b26dc90a";
    
    @Autowired
    private DataSource dataSource;
    
    @Bean
    public ProviderSignInOrConnectController providerSigninController() {
        ProviderSignInOrConnectController controller = new ProviderSignInOrConnectController();
        controller.setSignInPath("/authenticate");
        controller.setConnectPath("/authenticate");
        return controller;
    }
    
    public UsersConnectionRepository jdbcUsersConnectionRepository() {
        UsersConnectionRepository repo = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator(), Encryptors.noOpText());
        return repo;
    }

    private ConnectionFactoryRegistry connectionFactoryLocator() {
        FacebookConnectionFactory fbFactory = new FacebookConnectionFactory(fbId, fbSecret);
        
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(fbFactory);
        
        return registry;
    }

}
