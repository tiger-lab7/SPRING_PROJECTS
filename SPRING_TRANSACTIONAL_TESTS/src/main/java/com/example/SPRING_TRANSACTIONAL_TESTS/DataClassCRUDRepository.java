package com.example.SPRING_TRANSACTIONAL_TESTS;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DataClassCRUDRepository extends CrudRepository<DataClass, Long> {
    List<DataClass> findAll();
}
