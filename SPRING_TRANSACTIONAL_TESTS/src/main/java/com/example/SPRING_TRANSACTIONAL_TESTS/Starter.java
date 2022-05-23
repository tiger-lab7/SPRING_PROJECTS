package com.example.SPRING_TRANSACTIONAL_TESTS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.Instant;

@Component
public class Starter {
    @Autowired
    private DataClassCRUDRepository dataClassCRUDRepository;

    @Autowired
    private DataClassJPARepository dataClassJPARepository;

    private DataClass user;

    @PostConstruct
    public void run() {
        user = new DataClass("Igor", Instant.parse("2022-05-20T22:00:00.00Z"));
        method1();

        //dataClassCRUDRepository.findAll().forEach(System.out::println);

        dataClassJPARepository.getByName("Igor").forEach(System.out::println);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void method1() {
        dataClassCRUDRepository.save(user);
        user.setAddTime(Instant.parse("2022-01-20T22:00:00.00Z"));
        method2();
    }

    @Transactional
    public void method2() {
       dataClassCRUDRepository.save(user);
    }
}
