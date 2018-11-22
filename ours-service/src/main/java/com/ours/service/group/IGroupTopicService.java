package com.ours.service.group;

import com.ours.model.group.GroupTopic;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
public interface IGroupTopicService {

    public int saveGroupTopic(GroupTopic params);

    public List<GroupTopic> findGroupTopicList(GroupTopic params);

}
