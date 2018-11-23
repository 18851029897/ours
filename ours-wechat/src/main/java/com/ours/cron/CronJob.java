package com.ours.cron;

import com.ours.common.util.DateUtil;
import com.ours.dao.group.GroupMemberMapper;
import com.ours.model.group.GroupMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by fish on 2018/11/23.
 */
@Component
public class CronJob {

    private static Logger baseLog = LoggerFactory.getLogger(CronJob.class);

    @Autowired
    private GroupMemberMapper groupMemberMapper;

    /**
     * 扫描成员
     */
    @Async
    @Scheduled(cron = "0 0/1 * * * ?") //每分钟启动
    public void memberJob() {
        long start = System.currentTimeMillis();
        baseLog.info("定时任务开始执行-->扫描成员表,是否有体验到期ing...");
        GroupMember params = new GroupMember();
        params.setMemberStatus(3);
        List<GroupMember> members = this.groupMemberMapper.findGroupMemberList(params);
        int count = 0;
        for (int i = 0; i < members.size(); i++) {
            if (DateUtil.differentDaysByMillisecond(members.get(i).getCreateTime(), new Date()) > 3) {
                GroupMember bean = members.get(i);
                bean.setMemberStatus(2);
                this.groupMemberMapper.updateGroupMember(bean);
                count++;
            }
        }
        long end = System.currentTimeMillis();
        baseLog.info("定时任务执行结束-->扫描成员表,是否有体验到期end...耗时:" + (end - start) + "ms, 处理" + count + "条数据.");
    }

}
