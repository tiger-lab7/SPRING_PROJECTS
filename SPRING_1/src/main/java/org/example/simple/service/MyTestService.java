package org.example.simple.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("MyBean")
@Scope("prototype")
public class MyTestService implements TestService {


    private String message;

    @PostConstruct
    private void postConstruct() {
        message = "Я осваиваю Spring!";
        System.out.println(" Активировано аннотацией @PostConstruct после создания бина");
    }

    public void testMessage() {
        System.out.println(message);

    }

}
