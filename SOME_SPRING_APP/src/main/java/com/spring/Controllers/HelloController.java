package com.spring.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @Value("${messages.greeting}")
    private String helloString;

    @GetMapping(value = "/hello", produces = "html/text")
    public String helloMessage(Model template) {
        template.addAttribute("helloMessage", helloString);
        return "helloPage";
    }
}
