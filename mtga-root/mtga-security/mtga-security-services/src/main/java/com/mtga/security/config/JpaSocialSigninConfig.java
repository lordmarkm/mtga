package com.mtga.security.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.socialsignin.springsocial.security.signin.SpringSocialSecuritySignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

@Configuration
@ComponentScan(basePackages = {JpaSocialSigninConfig.SSS_BASE_PKG })
@PropertySource({"classpath:social.properties", "classpath:facebook.properties"})
public class JpaSocialSigninConfig {

    static Logger log = LoggerFactory.getLogger(JpaSocialSigninConfig.class);
    
    public static final String SSS_BASE_PKG = "org.socialsignin";
    
    @Autowired
    private Environment env;
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private SpringSocialSecuritySignInService signinService;
    
    @PostConstruct
    public void init() {
        log.info("Jpa Social Signin initialized.");
    }
    
    @Bean(name="springSocialSecurityEntryPoint")
    public LoginUrlAuthenticationEntryPoint springSocialSecurityEntryPoint() {
        String loginUrl = env.getProperty("login.url");
        log.debug("Using login url [{}]", loginUrl);
        return new LoginUrlAuthenticationEntryPoint(loginUrl);
    }
    
    @Bean
    public ProviderSignInController providerSigninController() {
        ProviderSignInController controller = new ProviderSignInController(
            connectionFactoryLocator(), 
            jdbcUsersConnectionRepository(),
            signinService
        );
        controller.setSignUpUrl(env.getProperty("signup.url"));
        controller.setPostSignInUrl(env.getProperty("post-signin.url"));
        controller.setApplicationUrl(env.getProperty("application.secureUrl"));
        return controller;
    }
    
    @Bean
    public UsersConnectionRepository jdbcUsersConnectionRepository() {
        UsersConnectionRepository repo = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator(), Encryptors.noOpText());
        return repo;
    }

    @Bean
    public ConnectionFactoryRegistry connectionFactoryLocator() {
        String fbId = env.getProperty("facebook.app.id");
        String fbSecret = env.getProperty("facebook.app.secret");
        FacebookConnectionFactory fbFactory = new FacebookConnectionFactory(fbId, fbSecret);
        
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(fbFactory);
        
        return registry;
    }

    @Bean
    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
    public ConnectionRepository connectionRepository() {
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return jdbcUsersConnectionRepository().createConnectionRepository(userId);
    }
    
    @Bean
    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)   
    public Facebook facebook() {
        return connectionRepository().getPrimaryConnection(Facebook.class).getApi();
    }
    
    @Bean
    public ConnectController connectController() {
        ConnectController connectController = new ConnectController(connectionFactoryLocator(), 
                connectionRepository());
        connectController.setApplicationUrl(env.getProperty("application.url"));
        return connectController;
    }
}
