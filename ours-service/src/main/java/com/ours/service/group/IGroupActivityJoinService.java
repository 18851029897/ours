package com.ours.service.group;

import com.ours.model.group.GroupActivityJoin;

import java.util.List;

/**
 * Created by fish on 2018/11/25.
 */
public interface IGroupActivityJoinService {

    List<GroupActivityJoin> findGroupActivityJoinList(GroupActivityJoin params);

    Integer saveGroupActivityJoin(GroupActivityJoin params);

}
