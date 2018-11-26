package com.ours.service.group;

import com.ours.common.back.DataResponse;
import com.ours.model.group.GroupActivity;
import com.ours.model.group.GroupInfo;
import com.ours.model.group.GroupTopic;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by fish on 2018/11/13.
 */
public interface IGroupManageService {

    DataResponse saveGroupInfo(GroupInfo params, MultipartFile photo) throws Exception;

    DataResponse updateGroupInfo(GroupInfo params, MultipartFile photo) throws Exception;

    DataResponse saveTopic(GroupTopic params, String imageNames, String audioNames) throws Exception;

    DataResponse saveActivity(GroupActivity params, String imageNames, String audioNames) throws Exception;
}
