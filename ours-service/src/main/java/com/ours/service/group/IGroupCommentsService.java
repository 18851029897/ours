package com.ours.service.group;

import com.ours.model.group.GroupComments;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
public interface IGroupCommentsService {

    int saveGroupComments(GroupComments params);

    List<GroupComments> findGroupCommentsList(GroupComments params);

}
