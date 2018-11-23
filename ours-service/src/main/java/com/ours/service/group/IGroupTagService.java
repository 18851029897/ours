package com.ours.service.group;

import com.ours.model.group.GroupTag;

import java.util.List;

/**
 * Created by fishs on 2018/11/13.
 */
public interface IGroupTagService {

    Integer saveGroupTag(GroupTag params);

    List<GroupTag> findGroupTagList(GroupTag params);

    GroupTag findGroupTag(GroupTag params);

}
