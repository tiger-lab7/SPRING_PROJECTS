package com.example.ADD_BEAN_AT_RUNTIME;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class AddBeanCommandController {
    @Autowired
    ConfigurableApplicationContext context;

    @GetMapping(value = "/")
    ResponseEntity<String> addBean() {
        // Trying add bean to context
        context.getBeanFactory().registerSingleton(BeanClass.class.getCanonicalName(), new BeanClass());

        // Checking
        BeanClass beanClass = null;
        try {
            beanClass = context.getBean(BeanClass.class);
        } catch (NoSuchBeanDefinitionException ex) {
        }
        return (beanClass != null) ? new ResponseEntity<>(beanClass.toString(), HttpStatus.OK)
                : new ResponseEntity<>("No such bean", HttpStatus.I_AM_A_TEAPOT);
    }
}

class BeanClass {
    int n = 1;
    String name = "Cat";

    @Override
    public String toString() {
        return "BeanClass{" +
                "n=" + n +
                ", name='" + name + '\'' +
                '}';
    }
}
