package com.ours.service.group;

import com.ours.model.group.GroupActivity;
import com.ours.model.group.GroupTopic;

import java.util.List;

/**
 * Created by fish on 2018/11/25.
 */
public interface IGroupActivityService {

    List<GroupActivity> findGroupActivityList(GroupActivity params);

    GroupActivity findGroupActivity(GroupTopic params);

    Integer saveGroupActivity(GroupActivity params);

    Integer updateGroupActivity(GroupActivity params);
}
