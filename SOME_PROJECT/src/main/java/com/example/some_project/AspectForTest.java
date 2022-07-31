package com.example.some_project;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

//@EnableAspectJAutoProxy
@Aspect
@Component
public class AspectForTest {
    @Pointcut("execution(public * com.example.some_project.Repository.DataSourceBean.*(..))")
    public void testPointcut() {
        System.out.println("================================Test started=========================");
    }
}
