package com.spring;

import org.springframework.stereotype.Component;

@Component
public class RabbitReceiverA {

    public void receiveMessage(String message) {
        System.out.println("Receiver A. Message received: " + message);
    }

}
