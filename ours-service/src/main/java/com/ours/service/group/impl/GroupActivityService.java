package com.ours.service.group.impl;

import com.ours.dao.group.GroupActivityMapper;
import com.ours.dao.group.GroupTopicMapper;
import com.ours.model.group.GroupActivity;
import com.ours.model.group.GroupTopic;
import com.ours.service.group.IGroupActivityService;
import com.ours.service.group.IGroupTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
@Service
public class GroupActivityService implements IGroupActivityService {

    @Autowired
    private GroupActivityMapper groupActivityMapper;


    @Override
    public List<GroupActivity> findGroupActivityList(GroupActivity params) {
        return this.groupActivityMapper.findGroupActivityList(params);
    }

    @Override
    public GroupActivity findGroupActivity(GroupActivity params) {
        return this.groupActivityMapper.findGroupActivity(params);
    }

    @Override
    public Integer saveGroupActivity(GroupActivity params) {
        return this.groupActivityMapper.saveGroupActivity(params);
    }

    @Override
    public Integer updateGroupActivity(GroupActivity params) {
        return this.groupActivityMapper.updateGroupActivity(params);
    }
}
