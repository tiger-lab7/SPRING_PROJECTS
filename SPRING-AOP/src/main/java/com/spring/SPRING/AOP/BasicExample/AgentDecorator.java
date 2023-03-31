package com.spring.SPRING.AOP.BasicExample;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AgentDecorator implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String firstArg = (String) invocation.getArguments()[0];
        System.out.println("Arg in method is " + firstArg);

        System.out.print("James ");
        Object retVal = invocation.proceed();

        System.out.print("!");
        return retVal;
    }
}
