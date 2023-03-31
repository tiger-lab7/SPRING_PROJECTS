package com.spring.XML_AND_ANNOTATIONS_CONFIG_PRIORITY;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("SomeBean")
public class SomeBean {
    @Value("CAT BARSIK")
    public String name;

    public void setName(String name) {
        this.name = name;
    }
}
