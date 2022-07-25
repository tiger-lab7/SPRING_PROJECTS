package com.spring;

import com.spring.Entities.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class IndexController {
    @Autowired
    RestTemplateExp restTemplateExp;

    @GetMapping(value = "/{proxyRequest}")
    public @ResponseBody String proxyRequest(@PathVariable("proxyRequest") String proxyReq) {
        return restTemplateExp.getIndexPage("http://" + proxyReq);
    }

}


