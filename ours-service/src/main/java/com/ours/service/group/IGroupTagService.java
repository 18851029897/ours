package com.ours.service.group;

import com.ours.model.group.GroupTag;

import java.util.List;

/**
 * Created by fishs on 2018/11/13.
 */
public interface IGroupTagService {

    public int saveGroupTag(GroupTag params);

    public List<GroupTag> findGroupTagList(GroupTag params);

    public GroupTag findGroupTag(GroupTag params);

}
