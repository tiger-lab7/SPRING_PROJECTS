package com.spring;

import org.springframework.stereotype.Component;

@Component
public class RabbitReceiverB {

    public void receiveMessage(String message) {
        System.out.println("Receiver B. Message received: " + message);
    }
}
