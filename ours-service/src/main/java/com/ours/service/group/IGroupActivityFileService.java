package com.ours.service.group;

import com.ours.model.group.GroupActivityFile;

import java.util.List;

/**
 * Created by fish on 2018/11/25.
 */
public interface IGroupActivityFileService {

    List<GroupActivityFile> findGroupActivityFileList(GroupActivityFile params);

    Integer saveGroupActivityFile(GroupActivityFile params);
}
