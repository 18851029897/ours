package com.ours.service.group;

import com.ours.model.group.GroupTopic;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
public interface IGroupTopicService {

    Integer saveGroupTopic(GroupTopic params);

    List<GroupTopic> findGroupTopicList(GroupTopic params);

    Integer updateGroupTopic(GroupTopic params);

}
