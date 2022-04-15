package com.example.spring_simple_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringSimpleServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSimpleServerApplication.class, args);
    }

}
