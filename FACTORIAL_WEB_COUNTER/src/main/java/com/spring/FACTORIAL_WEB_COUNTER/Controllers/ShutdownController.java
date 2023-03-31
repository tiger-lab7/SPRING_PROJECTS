package com.spring.FACTORIAL_WEB_COUNTER.Controllers;

import com.spring.FACTORIAL_WEB_COUNTER.Models.CashedFactorialCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShutdownController {
    @Autowired
    CashedFactorialCounter cashedFactorialCounter;

    @GetMapping(value = "/exit")
    ResponseEntity<String> shutDownApp() {
        cashedFactorialCounter.persistFactorialResults();
        return new ResponseEntity<>("Server has been shot down", HttpStatus.OK);
    }
}
