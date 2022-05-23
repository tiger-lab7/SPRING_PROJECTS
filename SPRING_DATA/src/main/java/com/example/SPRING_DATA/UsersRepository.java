package com.example.SPRING_DATA;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Long> {

    Optional<User> findByName(String name);
    Iterable<User> findAll();
}
