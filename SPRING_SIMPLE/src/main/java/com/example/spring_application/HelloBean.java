package com.example.spring_application;

import org.springframework.stereotype.Component;

@Component
public class HelloBean implements HelloPrinter {
    public String helloMessage;

    public void setPhrase(String phrase) {
        helloMessage = phrase;
    }
    public void printHello() {
        System.out.println(helloMessage);
    }
}
