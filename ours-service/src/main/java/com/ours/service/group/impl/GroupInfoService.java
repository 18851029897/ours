package com.ours.service.group.impl;

import com.ours.dao.group.GroupInfoMapper;
import com.ours.model.group.GroupInfo;
import com.ours.service.group.IGroupInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fish on 2018/11/12.
 */
@Service
public class GroupInfoService implements IGroupInfoService {

    @Autowired
    private GroupInfoMapper groupInfoMapper;

    @Override
    public int saveGroupInfo(GroupInfo params) {
        return this.groupInfoMapper.saveGroupInfo(params);
    }

    @Override
    public List<GroupInfo> findGroupInfoList(GroupInfo params) {
        return this.groupInfoMapper.findGroupInfoList(params);
    }

    @Override
    public GroupInfo findGroupInfo(GroupInfo params) {
        return this.groupInfoMapper.findGroupInfo(params);
    }
}
