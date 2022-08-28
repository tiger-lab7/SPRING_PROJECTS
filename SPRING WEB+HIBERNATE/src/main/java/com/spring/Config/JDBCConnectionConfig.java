package com.spring.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class JDBCConnectionConfig {
    @Bean
    @Scope("singleton")
    public DataSource jdbcDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/demo");
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");
        return dataSource;
    }
}
