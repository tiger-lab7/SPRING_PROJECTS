package com.example.SPRING_TRANSACTIONAL_TESTS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DataClassJPARepository extends JpaRepository<DataClass, Long> {

    @Query("from DataClass o where o.name = :name")
    List<DataClass> getByName(@Param("name") String name);
}
