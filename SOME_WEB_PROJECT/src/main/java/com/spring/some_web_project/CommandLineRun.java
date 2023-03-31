package com.spring.some_web_project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class CommandLineRun implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger("my logger");

	@Override
	public void run(String... args) throws Exception {
		logger.info("SPRING SERVER STARTED!");
		
	}

}
