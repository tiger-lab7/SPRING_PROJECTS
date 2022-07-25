package com.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Scope("singleton")
public class RestTemplateExp {

    String getIndexPage(String resourceURL) {
        RestTemplate restTemplate = new RestTemplate();

        //ResponseEntity<String> responseEntity =
        //        restTemplate.exchange("http://google.com", HttpMethod.GET, null, String.class);
        //System.out.println(responseEntity);


        return restTemplate.getForObject(resourceURL, String.class);
    }
}
