package com.ours.controller.group;

import com.ours.common.back.DataResponse;
import com.ours.common.util.EmptyUtil;
import com.ours.common.vo.group.GroupCommentsVO;
import com.ours.common.vo.group.GroupInfoVO;
import com.ours.common.vo.group.GroupMemberVO;
import com.ours.common.vo.group.GroupTopicVO;
import com.ours.common.vo.user.UserGroupVO;
import com.ours.model.group.*;
import com.ours.model.user.UserGroup;
import com.ours.model.user.UserInfo;
import com.ours.service.group.*;
import com.ours.service.user.IUserGroupService;
import com.ours.service.user.IUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fish on 2018/11/12.
 */
@Controller
@RequestMapping("group")
public class GroupController {

    private static Logger baseLog = LoggerFactory.getLogger(GroupController.class);

    @Autowired
    private IGroupInfoService groupInfoService;

    @Autowired
    private IGroupManageService groupManageService;

    @Autowired
    private IUserGroupService userGroupService;

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private IGroupMemberService groupMemberService;

    @Autowired
    private IGroupTagService groupTagService;

    @Autowired
    private IGroupTopicService groupTopicService;

    @Autowired
    private IGroupTopicFileService groupTopicFileService;

    @Autowired
    private IGroupCommentsService groupCommentsService;

    /**
     * 新增圈子
     *
     * @param params
     * @param photo
     * @param userId
     * @return
     */
    @RequestMapping(value = "/saveGroupInfo", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse saveGroupInfo(GroupInfo params, MultipartFile photo) {
        try {
            return this.groupManageService.saveGroupInfo(params, photo);
        } catch (Exception e) {
            e.printStackTrace();
            return new DataResponse(1001, e.getMessage());
        }
    }


    /**
     * 更新圈子
     *
     * @param params
     * @param photo
     * @param userId
     * @return
     */
    @RequestMapping(value = "/updateGroupInfo", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse updateGroupInfo(GroupInfo params, MultipartFile photo) {
        try {
            return this.groupManageService.updateGroupInfo(params, photo);
        } catch (Exception e) {
            e.printStackTrace();
            return new DataResponse(1001, e.getMessage());
        }

    }


    /**
     * 查询所有圈子
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/findGroupInfo", method = RequestMethod.GET)
    @ResponseBody
    public DataResponse findGroupInfo(GroupInfo params) {
        List<GroupInfo> data = this.groupInfoService.findGroupInfoList(params);
        List<GroupInfoVO> result = new ArrayList<GroupInfoVO>();
        for (int i = 0; i < data.size(); i++) {
            GroupInfoVO record = new GroupInfoVO();
            BeanUtils.copyProperties(data.get(i), record);
            if (params.getUserId().intValue() == data.get(i).getUserId()) {
                record.setIsMaster(1);
            }
            result.add(record);
        }
        return new DataResponse(1000, "success", result);
    }

    /**
     * 查询用户所在的圈子
     *
     * @return
     */
    @RequestMapping(value = "/findGroupInfoByUser", method = RequestMethod.GET)
    @ResponseBody
    public DataResponse findGroupInfoByUser(UserGroup params) {
        List<UserGroupVO> data = new ArrayList<UserGroupVO>();
        List<UserGroup> userGroups = this.userGroupService.findUserGroupList(params);
        for (int i = 0; i < userGroups.size(); i++) {
            GroupInfo bean = new GroupInfo();
            bean.setId(userGroups.get(i).getGroupId());
            bean = this.groupInfoService.findGroupInfo(bean);

            UserGroupVO record = new UserGroupVO();
            record.setId(userGroups.get(i).getId());
            record.setName(bean.getGroupName());
            record.setSort(userGroups.get(i).getSort());
            record.setGroupId(userGroups.get(i).getGroupId());
            data.add(record);
        }
        return new DataResponse(1000, "success", data);
    }


    /**
     * 更新用户圈子
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/updateUserGroup", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse updateUserGroup(UserGroup params) {
        this.userGroupService.updateUserGroup(params);
        return new DataResponse(1000, "success", params);
    }

    /**
     * 获取圈子成员
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/findGroupMember", method = RequestMethod.GET)
    @ResponseBody
    public DataResponse findGroupMember(GroupMember params) {
        List<GroupMemberVO> result = new ArrayList<GroupMemberVO>();
        List<GroupMember> data = this.groupMemberService.findGroupMemberList(params);
        for (int i = 0; i < data.size(); i++) {
            GroupMemberVO record = new GroupMemberVO();
            UserInfo userInfo = this.userInfoService.findUserInfo(new UserInfo(data.get(i).getUserId()));
            List<GroupTag> tags = this.groupTagService.findGroupTagList(new GroupTag(data.get(i).getGroupId(), data.get(i).getUserId(), 0));
            record.setId(data.get(i).getId());
            record.setPhoto(userInfo.getHeadImgUrl());
            record.setName(userInfo.getNickName());
            record.setIdentity(data.get(i).getMemberIdentity());
            record.setStatus(data.get(i).getMemberStatus());
            record.setTags(tags);
            result.add(record);
        }
        return new DataResponse(1000, "success", result);
    }


    /**
     * 更新群成员
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/updateGroupMember", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse updateGroupMember(GroupMember params) {
        this.groupMemberService.updateGroupMember(params);
        return new DataResponse(1000, "success", params);
    }

    /**
     * 查询标签
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/findGroupTag", method = RequestMethod.GET)
    @ResponseBody
    public DataResponse findGroupTag(GroupTag params) {
        List<GroupTag> tags = this.groupTagService.findGroupTagList(params);
        return new DataResponse(1000, "success", tags);
    }


    /**
     * 设置标签
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/saveGroupTag", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse saveGroupTag(GroupTag params) {
        this.groupTagService.saveGroupTag(params);
        return new DataResponse(1000, "success", params);
    }


    /**
     * 是否已在圈子
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/isInGroup", method = RequestMethod.GET)
    @ResponseBody
    public DataResponse isInGroup(GroupMember params) {
        GroupMember record = this.groupMemberService.findGroupMember(params);
        if (EmptyUtil.isEmpty(record)) {
            return new DataResponse(1000, "success", 0);
        } else {
            return new DataResponse(1000, "success", 1);
        }
    }


    /**
     * 发布主题
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/saveTopic", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse saveTopic(GroupTopic params, String imageNames, String audioNames) {
        try {
            return this.groupManageService.saveTopic(params, imageNames, audioNames);
        } catch (Exception e) {
            e.printStackTrace();
            return new DataResponse(1001, e.getMessage());
        }
    }

    /**
     * 主题列表
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/findTopicList", method = RequestMethod.GET)
    @ResponseBody
    public DataResponse findTopicList(GroupTopic params) {
        List<GroupTopic> data = new ArrayList<GroupTopic>();
        //1. 先查出所有已经发布的.
        GroupTopic release = new GroupTopic(params.getGroupId(), 1);
        List<GroupTopic> releaseList = this.groupTopicService.findGroupTopicList(release);

        //如果传userId, 查出自己未发布的.
        if (EmptyUtil.isNotEmpty(params.getUserId())) {
            //2. 再查出自己未发布的.
            GroupTopic unRelease = new GroupTopic(params.getGroupId(), params.getUserId(), 0);
            List<GroupTopic> unReleaseList = this.groupTopicService.findGroupTopicList(unRelease);
            data.addAll(unReleaseList);
        }

        //3. 两个list合并
        data.addAll(releaseList);

        List<GroupTopicVO> result = new ArrayList<GroupTopicVO>();
        for (int i = 0; i < data.size(); i++) {
            //处理主题信息
            GroupTopicVO record = new GroupTopicVO();
            BeanUtils.copyProperties(data.get(i), record);

            //处理用户信息
            UserInfo userInfo = this.userInfoService.findUserInfo(new UserInfo(data.get(i).getUserId()));
            record.setUserName(userInfo.getNickName());

            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                //是否为圈主
                GroupInfo groupInfo = this.groupInfoService.findGroupInfo(new GroupInfo(data.get(i).getGroupId()));
                if (groupInfo.getUserId() == data.get(i).getUserId()) {
                    record.setIsMaster(1);
                }
            }

            //处理文件信息
            List<GroupTopicFile> files = this.groupTopicFileService.findGroupTopicFileList(new GroupTopicFile(data.get(i).getId()));
            record.setFiles(files);

            //处理标签信息
            GroupTag tag = this.groupTagService.findGroupTag(new GroupTag(data.get(i).getTagId()));
            record.setTagName(tag.getTagName());

            result.add(record);
        }

        return new DataResponse(1000, "success", result);
    }


    /**
     * 保存评论
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/saveGroupComments", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse saveGroupComments(GroupComments params) {
        params.setCreateTime(new Date());
        this.groupCommentsService.saveGroupComments(params);
        return new DataResponse(1000, "success", params);
    }


    /**
     * 评论列表
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/findGroupCommentsList", method = RequestMethod.GET)
    @ResponseBody
    public DataResponse findGroupCommentsList(GroupComments params, Integer groupId) {
        List<GroupComments> data = this.groupCommentsService.findGroupCommentsList(params);
        List<GroupCommentsVO> result = new ArrayList<GroupCommentsVO>();
        for (int i = 0; i < data.size(); i++) {
            GroupCommentsVO record = new GroupCommentsVO();
            record.setId(data.get(i).getId());
            record.setContent(data.get(i).getContent());
            record.setTime(data.get(i).getCreateTime());
            UserInfo userInfo = this.userInfoService.findUserInfo(new UserInfo(data.get(i).getUserId()));
            record.setUserName(userInfo.getNickName());
            record.setUserPhoto(userInfo.getHeadImgUrl());
            List<GroupTag> tags = this.groupTagService.findGroupTagList(new GroupTag(groupId, data.get(i).getUserId(), 0));
            record.setTags(tags);
            result.add(record);
        }
        return new DataResponse(1000, "success", result);
    }


    /**
     * 评论列表
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/updateGroupTopic", method = RequestMethod.GET)
    @ResponseBody
    public DataResponse updateGroupTopic(GroupTopic params) {
        this.groupTopicService.updateGroupTopic(params);
        return new DataResponse(1000, "success", params);
    }


}
