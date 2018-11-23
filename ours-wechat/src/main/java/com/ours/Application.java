package com.ours;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by fish on 2018/7/26.
 */
@SpringBootApplication
@EnableScheduling   //开启定时任务
@EnableAsync        //开启异步调用方法
public class Application extends SpringBootServletInitializer {

    private static Logger baseLog = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        baseLog.info("application start success!");
    }
}
