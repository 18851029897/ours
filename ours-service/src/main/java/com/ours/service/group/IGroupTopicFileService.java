package com.ours.service.group;

import com.ours.model.group.GroupTopicFile;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
public interface IGroupTopicFileService {

    public int saveGroupTopicFile(GroupTopicFile params);

    public List<GroupTopicFile> findGroupTopicFileList(GroupTopicFile params);

}
