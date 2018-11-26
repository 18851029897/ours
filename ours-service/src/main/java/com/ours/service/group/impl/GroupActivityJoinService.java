package com.ours.service.group.impl;

import com.ours.dao.group.GroupActivityJoinMapper;
import com.ours.dao.group.GroupTopicMapper;
import com.ours.model.group.GroupActivity;
import com.ours.model.group.GroupActivityJoin;
import com.ours.model.group.GroupTopic;
import com.ours.service.group.IGroupActivityJoinService;
import com.ours.service.group.IGroupTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
@Service
public class GroupActivityJoinService implements IGroupActivityJoinService {

    @Autowired
    private GroupActivityJoinMapper groupActivityJoinMapper;


    @Override
    public List<GroupActivityJoin> findGroupActivityJoinList(GroupActivityJoin params) {
        return this.groupActivityJoinMapper.findGroupActivityJoinList(params);
    }

    @Override
    public Integer saveGroupActivityJoin(GroupActivityJoin params) {
        return this.groupActivityJoinMapper.saveGroupActivityJoin(params);
    }
}
