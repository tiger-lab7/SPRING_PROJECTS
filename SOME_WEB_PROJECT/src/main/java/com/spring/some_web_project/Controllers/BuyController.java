package com.spring.some_web_project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
class HomeController {
	@GetMapping(value = "/home")
	public String greeter() {
		return "index";
	}
}

@Controller
public class BuyController {
	@PostMapping(value = "/home")
	void buyItem(@RequestBody String request) {
		System.out.println(request);
	}
}
