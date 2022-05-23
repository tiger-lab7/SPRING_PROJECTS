package com.example.spring_simple_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class ControllerGreet {
    @Autowired
    private SimpleJDBC_DAO simpleJDBCDao;

    @GetMapping
    public String greeter()  {
        String hello = "HELLO!";
        return hello;
    }

    @GetMapping("/cats")
    public List<String> catsNames() {

        return simpleJDBCDao.readAllRecords();
    }

}
