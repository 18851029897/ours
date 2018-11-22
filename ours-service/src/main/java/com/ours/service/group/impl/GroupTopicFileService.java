package com.ours.service.group.impl;

import com.ours.dao.group.GroupTopicFileMapper;
import com.ours.model.group.GroupTopicFile;
import com.ours.service.group.IGroupTopicFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
@Service
public class GroupTopicFileService implements IGroupTopicFileService {

    @Autowired
    private GroupTopicFileMapper groupTopicFileMapper;

    @Override
    public int saveGroupTopicFile(GroupTopicFile params) {
        return this.groupTopicFileMapper.saveGroupTopicFile(params);
    }

    @Override
    public List<GroupTopicFile> findGroupTopicFileList(GroupTopicFile params) {
        return this.groupTopicFileMapper.findGroupTopicFileList(params);
    }
}
