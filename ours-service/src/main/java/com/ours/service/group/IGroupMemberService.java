package com.ours.service.group;

import com.ours.model.group.GroupMember;

import java.util.List;

/**
 * Created by fish on 2018/11/13.
 */
public interface IGroupMemberService {

   List<GroupMember> findGroupMemberList(GroupMember params);

   GroupMember findGroupMember(GroupMember params);

   Integer saveGroupMember(GroupMember params);

    Integer updateGroupMember(GroupMember params);

}
