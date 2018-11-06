package com.ours;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by fish on 2018/7/26.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    private static Logger baseLog = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        baseLog.info("application start success!");
    }
}
