package com.spring.JERSEY_GLASSFISH;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

// В отличие от обычного Spring Boot, Jersey требует подобной регистрации контроллеров в классе ResourceConfig

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(SimpleController.class);
    }
}