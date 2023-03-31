package com.example.SPRING_HIBERNATE_SAVE_GET_ENTITIES.Models;

import java.util.List;

public interface RepositoryOperations {
    public Class getEntityClass();
    List<?> getAll();
    void addEntity(Object entity);
    void deleteAll();

    void deleteOne(String idToDelete);
}
