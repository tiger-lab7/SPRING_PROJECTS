package com.example.SPRING_ANNOTATIONS;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hello")
public class SimpleController {

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String helloPrinter(Model model) {
        return "index";
    }
}
