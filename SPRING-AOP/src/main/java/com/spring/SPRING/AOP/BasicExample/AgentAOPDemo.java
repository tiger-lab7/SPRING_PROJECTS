package com.spring.SPRING.AOP.BasicExample;

import org.springframework.aop.framework.ProxyFactory;

public class AgentAOPDemo {
    public static void main(String... args) {
        Agent target = new Agent();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new AgentDecorator());
        pf.setTarget(target);

        Agent proxy = (Agent) pf.getProxy();

        target.speak("I am");
        System.out.println(" ");
        proxy.speak("I am");
    }
}
