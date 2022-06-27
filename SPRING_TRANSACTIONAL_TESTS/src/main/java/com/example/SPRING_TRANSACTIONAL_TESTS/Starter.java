package com.example.SPRING_TRANSACTIONAL_TESTS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class Starter {
    @Autowired
    private DataClassCRUDRepository dataClassCRUDRepository;

    @Autowired
    private DataClassJPARepository dataClassJPARepository;

    private DataClass user;

    @PostConstruct
    public void run() {
        user = new DataClass(1L,"Igor", new Date(2022, 6, 24, 6, 00));
        methodA();

        //dataClassCRUDRepository.findAll().forEach(System.out::println);

        dataClassJPARepository.getByName("Igor").forEach(System.out::println);
    }

    @Transactional
    public void methodA() {
        dataClassCRUDRepository.save(user);
        user.setCurrentTimeStamp(new Date(2022, 6, 24, 7, 30));
        methodB();
    }

    @Transactional
    public void methodB() {
       dataClassCRUDRepository.save(user);
    }
}
