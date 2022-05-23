package com.example.SPRING_ANNOTATIONS;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamController {

    @GetMapping(value = "/request_param")
    public String sayHelloToParam(Model model, @RequestParam int id, @RequestParam String name) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "simple_index";
    }
}
