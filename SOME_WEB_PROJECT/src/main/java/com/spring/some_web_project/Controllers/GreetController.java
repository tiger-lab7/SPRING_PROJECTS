package com.spring.some_web_project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class GreetController {
	@GetMapping
	@ResponseBody
	public String greeter(@RequestParam("name") String name) {
		return "HELLO " + name + "!";
	}

}


