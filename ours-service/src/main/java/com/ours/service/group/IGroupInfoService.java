package com.ours.service.group;

import com.ours.model.group.GroupInfo;

import java.util.List;

/**
 * Created by fish on 2018/11/12.
 */
public interface IGroupInfoService {

    Integer saveGroupInfo(GroupInfo params);

    Integer updateGroupInfo(GroupInfo params);

    List<GroupInfo> findGroupInfoList(GroupInfo params);

    GroupInfo findGroupInfo(GroupInfo params);

}
