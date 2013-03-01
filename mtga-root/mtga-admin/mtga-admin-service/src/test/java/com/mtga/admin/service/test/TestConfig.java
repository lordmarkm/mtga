package com.mtga.admin.service.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.mtga.admin.service", "com.mtga.infra.mongo"})
public class TestConfig {

}
