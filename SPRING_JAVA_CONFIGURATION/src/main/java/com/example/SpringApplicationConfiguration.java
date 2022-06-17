package com.example;

import com.example.data.CatList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringApplicationConfiguration {

    @Bean
    public CatList catList() {
        return new CatList();
    }

    @Bean
    public CatHotel catHotel(CatList catList) {
        return new CatHotel(catList);
    }
}
