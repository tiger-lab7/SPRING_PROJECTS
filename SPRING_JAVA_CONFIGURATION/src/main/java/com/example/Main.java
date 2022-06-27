package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    @Autowired
    private static ConfigurableApplicationContext configurableApplicationContext;

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                new AnnotationConfigApplicationContext(SpringApplicationConfiguration.class);

        CatHotel catHotel = configurableApplicationContext.getBean(CatHotel.class);
        catHotel.printAllCats();
    }
}
