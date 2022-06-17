package com.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                new AnnotationConfigApplicationContext(SpringApplicationConfiguration.class);

        CatHotel catHotel = configurableApplicationContext.getBean(CatHotel.class);
        catHotel.printAllCats();
    }
}
