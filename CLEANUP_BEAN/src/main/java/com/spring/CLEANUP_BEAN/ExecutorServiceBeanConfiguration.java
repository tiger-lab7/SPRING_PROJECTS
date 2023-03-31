package com.spring.CLEANUP_BEAN;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ExecutorServiceBeanConfiguration {

    @Bean(name = "MyThreadPool")
    ExecutorService startThreadPoolExecutor() {

        return new ThreadPoolExecutor(10,
                100,
                0,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>());

    }
}
