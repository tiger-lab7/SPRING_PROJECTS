package com.spring.FACTORIAL_WEB_COUNTER.Controllers;

import com.spring.FACTORIAL_WEB_COUNTER.Models.CashedFactorialCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FactorialController {
    @Autowired
    CashedFactorialCounter factorialCounter;

    @GetMapping("/fact")
    ResponseEntity<String> getFactorial(@RequestParam("n") long n) {
        return new ResponseEntity<>(factorialCounter.getFactorial(n).toString(), HttpStatus.OK);
    }
}
