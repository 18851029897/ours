package com.ours.service.group.impl;

import com.ours.dao.group.GroupTopicMapper;
import com.ours.model.group.GroupTopic;
import com.ours.service.group.IGroupTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
@Service
public class GroupTopicService implements IGroupTopicService {

    @Autowired
    private GroupTopicMapper groupTopicMapper;

    @Override
    public Integer saveGroupTopic(GroupTopic params) {
        return this.groupTopicMapper.saveGroupTopic(params);
    }

    @Override
    public List<GroupTopic> findGroupTopicList(GroupTopic params) {
        return this.groupTopicMapper.findGroupTopicList(params);
    }

    @Override
    public GroupTopic findGroupTopic(GroupTopic params) {
        return this.groupTopicMapper.findGroupTopic(params);
    }

    @Override
    public Integer updateGroupTopic(GroupTopic params) {
        return this.groupTopicMapper.updateGroupTopic(params);
    }
}
