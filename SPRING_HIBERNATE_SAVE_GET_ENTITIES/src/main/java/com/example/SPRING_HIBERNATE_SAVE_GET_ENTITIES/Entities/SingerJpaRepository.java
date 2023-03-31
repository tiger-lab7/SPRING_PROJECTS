package com.example.SPRING_HIBERNATE_SAVE_GET_ENTITIES.Entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SingerJpaRepository extends JpaRepository<Singer, Long> {

    @Query(value = "delete from Singer s where s.id = :idToDelete")
    void deleteOne(@Param("idToDelete") String idToDelete);

}
