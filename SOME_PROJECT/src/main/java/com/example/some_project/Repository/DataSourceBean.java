package com.example.some_project.Repository;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Component
@Scope("singleton")
public class DataSourceBean {
    @PersistenceContext
    EntityManager entityManager;

    public DataSource getDataSource() {
        EntityManagerFactoryInfo info = (EntityManagerFactoryInfo) entityManager.getEntityManagerFactory();
        return info.getDataSource();
    }

    @PostConstruct
    void postConstructMethod() {

    }
}
