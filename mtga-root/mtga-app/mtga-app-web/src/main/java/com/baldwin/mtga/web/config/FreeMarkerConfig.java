package com.baldwin.mtga.web.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class FreeMarkerConfig extends WebMvcConfigurerAdapter {

    private static Logger log = LoggerFactory.getLogger(FreeMarkerConfig.class);

    @PostConstruct
    public void init() {
        log.debug("Initializing Freemarker configuration.");
    }
    
    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer result = new FreeMarkerConfigurer();
        result.setTemplateLoaderPath("/WEB-INF/view/");
        return result;
    }
    
    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver fmvr = new FreeMarkerViewResolver();
        fmvr.setCache(true);
        fmvr.setPrefix("");
        fmvr.setSuffix(".ftl");
        fmvr.setExposeSpringMacroHelpers(true);
        return fmvr;
    }
    
}
