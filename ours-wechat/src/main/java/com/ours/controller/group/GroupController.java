package com.ours.controller.group;

import com.ours.common.back.DataResponse;
import com.ours.common.util.EmptyUtil;
import com.ours.common.vo.group.GroupMemberVO;
import com.ours.common.vo.user.UserGroupVO;
import com.ours.model.group.GroupInfo;
import com.ours.model.group.GroupMember;
import com.ours.model.group.GroupTag;
import com.ours.model.user.UserGroup;
import com.ours.model.user.UserInfo;
import com.ours.service.group.IGroupInfoService;
import com.ours.service.group.IGroupManageService;
import com.ours.service.group.IGroupMemberService;
import com.ours.service.group.IGroupTagService;
import com.ours.service.user.IUserGroupService;
import com.ours.service.user.IUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

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
    public DataResponse saveGroupInfo(GroupInfo params, MultipartFile photo, Integer userId) {
        try {
            return this.groupManageService.saveGroupInfo(params, photo, userId);
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
    public DataResponse updateGroupInfo(GroupInfo params, MultipartFile photo, Integer userId) {
        try {
            return this.groupManageService.updateGroupInfo(params, photo, userId);
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
        return new DataResponse(1000, "success", this.groupInfoService.findGroupInfoList(params));
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
            List<GroupTag> tags = this.groupTagService.findGroupTagList(new GroupTag(data.get(i).getGroupId(), data.get(i).getUserId()));
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
        if(EmptyUtil.isEmpty(record)){
            return new DataResponse(1000, "success", 0);
        }else{
            return new DataResponse(1000, "success", 1);
        }
    }


}
