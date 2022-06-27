package com.example;

import com.example.data.CatList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.example")
public class SpringApplicationConfiguration {

    @Bean
    public Object catList() {
        return CatList.INSTANCE;
    }

    @Bean
    public CatHotel catHotel(CatList catList) {
        return new CatHotel(catList);
    }
}
