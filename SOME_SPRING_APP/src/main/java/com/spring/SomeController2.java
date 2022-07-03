package com.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SomeController2 {
    @Value("${messages.greeting}")
    private String helloString;

    @GetMapping(value = "/hello")
    public String helloMessage(Model template) {
        template.addAttribute("helloMessage", helloString);
        return "helloPage";
    }
}
