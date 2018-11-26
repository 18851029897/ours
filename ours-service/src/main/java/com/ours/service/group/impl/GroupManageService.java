package com.ours.service.group.impl;

import com.ours.common.back.DataResponse;
import com.ours.common.util.EmptyUtil;
import com.ours.model.group.*;
import com.ours.model.user.UserGroup;
import com.ours.service.file.IFileUploadRemoteService;
import com.ours.service.group.*;
import com.ours.service.user.IUserGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by fish on 2018/11/13.
 */
@Transactional
@Service
public class GroupManageService implements IGroupManageService {

    private static Logger baseLog = LoggerFactory.getLogger(GroupManageService.class);

    @Autowired
    private IGroupInfoService groupInfoService;

    @Autowired
    private IUserGroupService userGroupService;

    @Autowired
    private IFileUploadRemoteService fileUploadRemoteService;

    @Autowired
    private IGroupMemberService groupMemberService;

    @Autowired
    private IGroupTopicService groupTopicService;

    @Autowired
    private IGroupTopicFileService groupTopicFileService;

    @Autowired
    private IGroupActivityService groupActivityService;

    @Autowired
    private IGroupActivityFileService groupActivityFileService;

    @Autowired
    private IGroupActivityJoinService groupActivityJoinService;


    @Override
    public DataResponse saveGroupInfo(GroupInfo params, MultipartFile photo) throws Exception {
        String url = "";
        if (EmptyUtil.isNotEmpty(photo)) {
            baseLog.info("开始上传圈子头像.");
            InputStream input = photo.getInputStream();
            int count = input.available();
            byte[] fileByte = new byte[count];
            input.read(fileByte);
            String fileName = photo.getOriginalFilename();
            baseLog.info("当前上传请求的file的文件名:" + fileName);
            input.read(fileByte);
            fileName = fileName.substring(fileName.lastIndexOf(".") + 1);
            String fileId = this.fileUploadRemoteService.storeFile(fileByte, fileName);
            url = fileId + "." + fileName;
            baseLog.info("结束上传文件");
            baseLog.info("上传后的文件名：" + url);
        }
        //1.保存圈子信息
        params.setGroupPhotoUrl(url);
        params.setModifyTime(new Date());
        params.setCreateTime(new Date());
        this.groupInfoService.saveGroupInfo(params);

        //2.圈子关联用户
        UserGroup bean = new UserGroup();
        bean.setUserId(params.getUserId());
        bean.setGroupId(params.getId());
        bean.setModifyTime(new Date());
        bean.setCreateTime(new Date());
        this.userGroupService.saveUserGroup(bean);

        //3.增加成员
        GroupMember member = new GroupMember();
        member.setUserId(params.getUserId());
        member.setGroupId(params.getId());
        member.setMemberIdentity(2);//圈主
        member.setCreateTime(new Date());
        this.groupMemberService.saveGroupMember(member);

        return new DataResponse(1000, "success", params);
    }

    @Override
    public DataResponse joinGroupInfo(UserGroup params) throws Exception {
        //1.user_group新增一条记录
        this.userGroupService.saveUserGroup(params);

        //2.圈子成员表新增一条记录
        GroupMember member = new GroupMember();
        member.setUserId(params.getUserId());
        member.setGroupId(params.getGroupId());
        member.setMemberIdentity(0);//成员

        GroupInfo group = this.groupInfoService.findGroupInfo(new GroupInfo(params.getGroupId()));
        if (group.getGroupType().intValue() == 0) {
            member.setMemberStatus(0);//免费的圈子进入是成员
        } else {
            member.setMemberStatus(3);//收费的圈子进入是体验中
        }
        member.setCreateTime(new Date());
        this.groupMemberService.saveGroupMember(member);
        return new DataResponse(1000, "success", params);
    }

    @Override
    public DataResponse updateGroupInfo(GroupInfo params, MultipartFile photo) throws Exception {
        String url = "";
        if (EmptyUtil.isNotEmpty(photo)) {
            baseLog.info("开始上传圈子头像.");
            InputStream input = photo.getInputStream();
            int count = input.available();
            byte[] fileByte = new byte[count];
            input.read(fileByte);
            String fileName = photo.getOriginalFilename();
            baseLog.info("当前上传请求的file的文件名:" + fileName);
            input.read(fileByte);
            fileName = fileName.substring(fileName.lastIndexOf(".") + 1);
            String fileId = this.fileUploadRemoteService.storeFile(fileByte, fileName);
            url = fileId + "." + fileName;
            baseLog.info("结束上传文件");
            baseLog.info("上传后的文件名：" + url);
        }
        //1.圈子更新信息
        if (EmptyUtil.isNotEmpty(url)) {
            params.setGroupPhotoUrl(url);
        }
        params.setModifyTime(new Date());
        this.groupInfoService.updateGroupInfo(params);
        return new DataResponse(1000, "success", params);
    }

    @Override
    public DataResponse saveTopic(GroupTopic params, String imageNames, String audioNames) throws Exception {
        //1.保存主题信息
        params.setModifyTime(new Date());
        params.setCreateTime(new Date());
        this.groupTopicService.saveGroupTopic(params);

        if (EmptyUtil.isNotEmpty(imageNames)) {
            //2.保存文件信息
            String[] images = imageNames.split(",");
            //处理图片
            for (int i = 0; i < images.length; i++) {
                GroupTopicFile image = new GroupTopicFile(images[i], 0, params.getId(), new Date());
                this.groupTopicFileService.saveGroupTopicFile(image);
            }
        }

        if (EmptyUtil.isNotEmpty(audioNames)) {
            //处理音频
            String[] audios = audioNames.split(",");
            for (int i = 0; i < audios.length; i++) {
                GroupTopicFile audio = new GroupTopicFile(audios[i], 1, params.getId(), new Date());
                this.groupTopicFileService.saveGroupTopicFile(audio);
            }
        }

        return new DataResponse(1000, "success", params);
    }

    @Override
    public DataResponse saveActivity(GroupActivity params, String imageNames, String audioNames) throws Exception {
        //1.保存主题信息
        params.setModifyTime(new Date());
        params.setCreateTime(new Date());
        this.groupActivityService.saveGroupActivity(params);

        if (EmptyUtil.isNotEmpty(imageNames)) {
            //2.保存文件信息
            String[] images = imageNames.split(",");
            //处理图片
            for (int i = 0; i < images.length; i++) {
                GroupActivityFile image = new GroupActivityFile(images[i], 0, params.getId(), new Date());
                this.groupActivityFileService.saveGroupActivityFile(image);
            }
        }

        if (EmptyUtil.isNotEmpty(audioNames)) {
            //处理音频
            String[] audios = audioNames.split(",");
            for (int i = 0; i < audios.length; i++) {
                GroupActivityFile audio = new GroupActivityFile(audios[i], 1, params.getId(), new Date());
                this.groupActivityFileService.saveGroupActivityFile(audio);
            }
        }

        return new DataResponse(1000, "success", params);
    }
}
