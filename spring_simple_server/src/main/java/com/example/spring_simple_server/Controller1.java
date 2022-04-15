package com.example.spring_simple_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class Controller1 {
    @Autowired
    private ConfigurableApplicationContext context;

    @GetMapping
    public String greeter()  {
        String hello = "HELLO!";
        return hello;
    }

    @GetMapping("/cats")
    public List<String> catsNames() {

        return context.getBean(SimpleJDBC_DAO.class).readAllRecords();
    }

}
