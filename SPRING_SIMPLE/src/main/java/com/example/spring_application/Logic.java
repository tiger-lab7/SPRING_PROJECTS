package com.example.spring_application;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

@Component("Logic")
public class Logic {

    @Autowired
    HelloBean helloBean;

    @SneakyThrows
    void start() {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/properties.xml");
        FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/project.properties");
        Properties properties = new Properties();
        properties.loadFromXML(fileInputStream);
        properties.store(fileOutputStream, "Stored properties!");

        helloBean.setPhrase("Hello " + properties.get("name"));
        helloBean.printHello();
    }
}
