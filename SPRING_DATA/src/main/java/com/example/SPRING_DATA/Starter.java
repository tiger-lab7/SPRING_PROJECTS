package com.example.SPRING_DATA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
public class Starter {

    @Autowired
    UsersRepository usersRepository;

    //@PostConstruct
    @Transactional
    public void startDBPersistent() {
        User user = new User();
        user.setId(3L);
        user.setName("Barsik");
        usersRepository.save(user);
    }

    @PostConstruct
    public void readDBRecords() {
        Optional<User> user = usersRepository.findByName("Igor");
        user.ifPresent(System.out::println);

        usersRepository.findAll().forEach(System.out::println);
    }
}
