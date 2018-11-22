package com.ours.service.group;

import com.ours.common.back.DataResponse;
import com.ours.model.group.GroupInfo;
import com.ours.model.group.GroupTopic;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by fish on 2018/11/13.
 */
public interface IGroupManageService {

    public DataResponse saveGroupInfo(GroupInfo params, MultipartFile photo) throws Exception;

    public DataResponse updateGroupInfo(GroupInfo params, MultipartFile photo) throws Exception;

    public DataResponse saveTopic(GroupTopic params, String imageNames, String audioNames) throws Exception;
}
