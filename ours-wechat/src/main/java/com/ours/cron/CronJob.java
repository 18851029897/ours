package com.ours.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by fish on 2018/11/23.
 */
@Component
public class CronJob {

    private static Logger baseLog = LoggerFactory.getLogger(CronJob.class);


    /**
     * 扫描成员
     */
    @Async
    @Scheduled(cron = "0 0/1 * * * ?") //每分钟启动
    public void memberJob() {
        baseLog.info("定时任务开始执行-->扫描成员表,是否有体验到期ing...");
        baseLog.info("定时任务执行结束-->扫描成员表,是否有体验到期end...");
    }

}
