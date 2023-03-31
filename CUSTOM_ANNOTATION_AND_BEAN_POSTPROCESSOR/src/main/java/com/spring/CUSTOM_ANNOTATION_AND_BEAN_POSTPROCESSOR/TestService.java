package com.spring.CUSTOM_ANNOTATION_AND_BEAN_POSTPROCESSOR;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @AutowiredRandomInt(min = 1000, max = 2000)
    private int randomInt;

    @PostConstruct
    void printRandomNumber() {
        System.out.println("Random number is " + randomInt);
    }
}
