package com.ours.service.group.impl;

import com.ours.dao.group.GroupMemberMapper;
import com.ours.model.group.GroupMember;
import com.ours.service.group.IGroupMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fish on 2018/11/13.
 */
@Service
public class GroupMemberService implements IGroupMemberService {

    @Autowired
    private GroupMemberMapper groupMemberMapper;

    @Override
    public List<GroupMember> findGroupMemberList(GroupMember params) {
        return this.groupMemberMapper.findGroupMemberList(params);
    }

    @Override
    public GroupMember findGroupMember(GroupMember params) {
        return this.groupMemberMapper.findGroupMember(params);
    }

    @Override
    public Integer saveGroupMember(GroupMember params) {
        return this.groupMemberMapper.saveGroupMember(params);
    }

    @Override
    public Integer updateGroupMember(GroupMember params) {
        return this.groupMemberMapper.updateGroupMember(params);
    }
}
