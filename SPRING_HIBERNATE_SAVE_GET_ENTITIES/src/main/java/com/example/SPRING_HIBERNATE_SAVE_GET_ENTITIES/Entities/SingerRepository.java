package com.example.SPRING_HIBERNATE_SAVE_GET_ENTITIES.Entities;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SingerRepository extends CrudRepository<Singer, Integer> {
    List<Singer> findAll();
}
