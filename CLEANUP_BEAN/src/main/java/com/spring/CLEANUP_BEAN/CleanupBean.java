package com.spring.CLEANUP_BEAN;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

@Component
public class CleanupBean implements DisposableBean {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ExecutorService executorService;

    public CleanupBean() {
        super();
    }

    @Override
    public void destroy() throws Exception {
        logger.info("Destroy process started");
        executorService.shutdown();
        logger.info("Destroy process finished");
    }
}
