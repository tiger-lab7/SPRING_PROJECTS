package com.spring.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@EnableAspectJAutoProxy // !!!
@Aspect
@Component
public class MyAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.spring.SomeService.*(..))")
    public void callInSomeService() {
        logger.info("Intercept call method in SomeService object!");
    }

    @Before("callInSomeService()")
    public void beforeCallMyMethod(JoinPoint joinPoint) {
        String jointPointArgs = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(" , ", "arg:", ""));
        logger.info("Before call method: " + joinPoint + " " + jointPointArgs);
    }

    @After("callInSomeService()")
    public void afterCallingMyMethod(JoinPoint joinPoint) {
        logger.info("After call method " + joinPoint);
    }
}
