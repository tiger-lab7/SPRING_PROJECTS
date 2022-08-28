package com.spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class StartPageController {
    private List<String> tasks = List.of("Send message", "Create program");

    @GetMapping
    public String startPage(Model template) {
        int currentHour = new Date().getHours();
        String time = (currentHour > 0 && currentHour < 8)? "night" : "day";
        template.addAttribute("time", time);
        template.addAttribute("tasks", tasks);
        return "startPage";
    }
}
