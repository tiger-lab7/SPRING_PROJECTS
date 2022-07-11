package com.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RabbitSender implements CommandLineRunner { // auto start

    private final RabbitTemplate rabbitTemplate;
    private final RabbitReceiverA receiver;

    public RabbitSender(RabbitReceiverA receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> catList = List.of("SNEJOK", "VASILEK", "PUSHOK", "BARSIK");
        for(var cat: catList) {
            System.out.println("Sending message...");
            rabbitTemplate.convertAndSend(
                    RabbitMQConfiguration.topicExchangeName,
                    "hello.queue.1",
                    "Hello from RabbitMQ " + cat);
        }
        Thread.sleep(1000);
    }
}