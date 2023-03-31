package com.example.SpringDataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:embedded-h2-cfg.xml")
public class SpringDataSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataSourceApplication.class, args);
	}
}
