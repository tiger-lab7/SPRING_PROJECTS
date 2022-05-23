package com.example.SPRING_WEB_IN_DOCKER;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping(value = "/")
    public String getGreeting(Model model, @RequestParam String name) {
        model.addAttribute("name", name);
        return "index";
    }
}
