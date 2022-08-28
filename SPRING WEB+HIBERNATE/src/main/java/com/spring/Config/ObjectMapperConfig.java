package com.spring.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ObjectMapperConfig {
    @Bean
    @Scope("prototype")
    ObjectMapper getJsonObjectMapper() {
        return new ObjectMapper();
    }
}
