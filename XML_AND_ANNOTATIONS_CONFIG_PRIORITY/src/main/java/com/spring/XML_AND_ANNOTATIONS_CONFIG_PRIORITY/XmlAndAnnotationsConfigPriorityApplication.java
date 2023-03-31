package com.spring.XML_AND_ANNOTATIONS_CONFIG_PRIORITY;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:ApplicationContext.xml")
public class XmlAndAnnotationsConfigPriorityApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlAndAnnotationsConfigPriorityApplication.class, args);
	}

}
