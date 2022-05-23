package com.example.SPRING_ANNOTATIONS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseBodyController {

    @PostMapping(value = "/response_body")
    @ResponseBody
    public String controller3(@RequestBody User user) {
        return "Hello from Spring! " +  user.getId() + " " + user.getName();
    }
}
