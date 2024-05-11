package com.example.myhealthblock.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {
    @Bean
    public Logger controllerLogger() {
        return LoggerFactory.getLogger("controller-logger");
    }

    @Bean
    public Logger serviceLogger() {
        return LoggerFactory.getLogger("service-logger");
    }

    @Bean
    public Logger repositoryLogger() {
        return LoggerFactory.getLogger("repository-logger");
    }

    @Bean
    public Logger adapterLogger() {
        return LoggerFactory.getLogger("adapter-logger");
    }
}
