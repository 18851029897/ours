package com.ours.service.group.impl;

import com.ours.dao.group.GroupTagMapper;
import com.ours.model.group.GroupTag;
import com.ours.service.group.IGroupTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fish on 2018/11/13.
 */
@Service
public class GroupTagService implements IGroupTagService {

    @Autowired
    private GroupTagMapper groupTagMapper;

    @Override
    public int saveGroupTag(GroupTag params) {
        return this.groupTagMapper.saveGroupTag(params);
    }

    @Override
    public List<GroupTag> findGroupTagList(GroupTag params) {
        return this.groupTagMapper.findGroupTagList(params);
    }
}
