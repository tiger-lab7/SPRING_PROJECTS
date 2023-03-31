package com.spring.CLEANUP_BEAN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;

@Component
public class StartProcessBean {
    private final ExecutorService executorService;

    public StartProcessBean(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @PostConstruct
    void startProcess() {
        executorService.execute(() -> {
            while (true) {
                System.out.println("Hello");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
