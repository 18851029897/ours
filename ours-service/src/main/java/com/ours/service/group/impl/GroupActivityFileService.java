package com.ours.service.group.impl;

import com.ours.dao.group.GroupActivityFileMapper;
import com.ours.dao.group.GroupTopicMapper;
import com.ours.model.group.GroupActivityFile;
import com.ours.model.group.GroupTopic;
import com.ours.service.group.IGroupActivityFileService;
import com.ours.service.group.IGroupTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
@Service
public class GroupActivityFileService implements IGroupActivityFileService {

    @Autowired
    private GroupActivityFileMapper groupActivityFileMapper;


    @Override
    public List<GroupActivityFile> findGroupActivityFileList(GroupActivityFile params) {
        return this.groupActivityFileMapper.findGroupActivityFileList(params);
    }

    @Override
    public Integer saveGroupActivityFile(GroupActivityFile params) {
        return this.groupActivityFileMapper.saveGroupActivityFile(params);
    }
}
