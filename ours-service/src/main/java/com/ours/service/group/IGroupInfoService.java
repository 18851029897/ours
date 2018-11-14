package com.ours.service.group;

import com.ours.model.group.GroupInfo;

import java.util.List;

/**
 * Created by fish on 2018/11/12.
 */
public interface IGroupInfoService {

    int saveGroupInfo(GroupInfo params);

    List<GroupInfo> findGroupInfoList(GroupInfo params);
    
    GroupInfo findGroupInfo(GroupInfo params);

}
