package com.ours.service.group.impl;

import com.ours.dao.group.GroupCommentsMapper;
import com.ours.model.group.GroupComments;
import com.ours.service.group.IGroupCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
@Service
public class GroupCommentsService implements IGroupCommentsService {

    @Autowired
    private GroupCommentsMapper groupCommentsMapper;

    @Override
    public int saveGroupComments(GroupComments params) {
        return this.groupCommentsMapper.saveGroupComments(params);
    }

    @Override
    public List<GroupComments> findGroupCommentsList(GroupComments params) {
        return this.groupCommentsMapper.findGroupCommentsList(params);
    }
}
