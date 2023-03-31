package com.spring.XML_AND_ANNOTATIONS_CONFIG_PRIORITY;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final SomeBean bean;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Runner(SomeBean bean) {
        this.bean = bean;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(bean.name);
    }
}
