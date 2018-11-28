package com.ours.dao.sql;

import com.ours.common.util.EmptyUtil;
import com.ours.model.base.BaseSysParam;
import com.ours.model.group.*;
import com.ours.model.user.UserGroup;
import com.ours.model.user.UserInfo;
import com.ours.model.user.UserOrder;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;

/**
 * Created by fish on 2018/10/29.
 */
public class SqlProvider {

    private static Logger baseLog = LoggerFactory.getLogger(SqlProvider.class);

    /**
     * 基础参数表
     *
     * @param params
     * @return
     */
    public String findValueByKey(BaseSysParam params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("base_sys_param");
            if (EmptyUtil.isNotEmpty(params.getParamKey())) {
                WHERE("PARAM_KEY=#{paramKey}");
            }
        }}.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 保存用户信息
     *
     * @param params
     * @return
     */
    public String saveUserInfo(UserInfo params) {
        String sql = new SQL() {
            {
                INSERT_INTO("user_info");
                if (EmptyUtil.isNotEmpty(params.getNickName())) {
                    VALUES("nickname", "#{nickName}");
                }
                if (EmptyUtil.isNotEmpty(params.getOpenId())) {
                    VALUES("openid", "#{openId}");
                }
                if (EmptyUtil.isNotEmpty(params.getSex())) {
                    VALUES("sex", "#{sex}");
                }
                if (EmptyUtil.isNotEmpty(params.getProvince())) {
                    VALUES("province", "#{province}");
                }
                if (EmptyUtil.isNotEmpty(params.getCity())) {
                    VALUES("city", "#{city}");
                }
                if (EmptyUtil.isNotEmpty(params.getCountry())) {
                    VALUES("country", "#{country}");
                }
                if (EmptyUtil.isNotEmpty(params.getUnionId())) {
                    VALUES("unionid", "#{unionId}");
                }
                if (EmptyUtil.isNotEmpty(params.getPhone())) {
                    VALUES("phone", "#{phone}");
                }
                if (EmptyUtil.isNotEmpty(params.getHeadImgUrl())) {
                    VALUES("headimgurl", "#{headImgUrl}");
                }
                if (EmptyUtil.isNotEmpty(params.getSubscribe())) {
                    VALUES("subscribe", "#{subscribe}");
                }
                if (EmptyUtil.isNotEmpty(params.getPayAmount())) {
                    VALUES("pay_amount", "#{payAmount}");
                }
                if (EmptyUtil.isNotEmpty(params.getInviteUserId())) {
                    VALUES("invite_user_id", "#{inviteUserId}");
                }
                if (EmptyUtil.isNotEmpty(params.getModifyTime())) {
                    VALUES("modify_time", "#{modifyTime}");
                }
                if (EmptyUtil.isNotEmpty(params.getCreateTime())) {
                    VALUES("create_time", "#{createTime}");
                }
            }
        }.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 更新用户信息
     *
     * @param params
     * @return
     */
    public String updateUserInfo(UserInfo params) {
        String sql = new SQL() {{
            UPDATE("user_info");
            if (EmptyUtil.isNotEmpty(params.getNickName())) {
                SET("nickname=#{nickName}");
            }
            if (EmptyUtil.isNotEmpty(params.getSex())) {
                SET("sex=#{sex}");
            }
            if (EmptyUtil.isNotEmpty(params.getProvince())) {
                SET("province=#{province}");
            }
            if (EmptyUtil.isNotEmpty(params.getCity())) {
                SET("city=#{city}");
            }
            if (EmptyUtil.isNotEmpty(params.getCountry())) {
                SET("country=#{country}");
            }
            if (EmptyUtil.isNotEmpty(params.getUnionId())) {
                SET("unionid=#{unionId}");
            }
            if (EmptyUtil.isNotEmpty(params.getPhone())) {
                SET("phone=#{phone}");
            }
            if (EmptyUtil.isNotEmpty(params.getHeadImgUrl())) {
                SET("headimgurl=#{headImgUrl}");
            }
            if (EmptyUtil.isNotEmpty(params.getSubscribe())) {
                SET("subscribe=#{subscribe}");
            }
            if (EmptyUtil.isNotEmpty(params.getPayAmount())) {
                SET("pay_amount=#{payAmount}");
            }
            if (EmptyUtil.isNotEmpty(params.getInviteUserId())) {
                SET("invite_user_id=#{inviteUserId}");
            }
            if (EmptyUtil.isNotEmpty(params.getModifyTime())) {
                SET("modify_time=#{modifyTime}");
            }
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                WHERE("USER_ID=#{userId}");
            }
            if (EmptyUtil.isNotEmpty(params.getOpenId())) {
                WHERE("OPENID=#{openId}");
            }

        }}.toString();
        baseLog.info(sql);
        return sql;
    }

    /**
     * 查询用户信息
     *
     * @param params
     * @return
     */
    public String findUserInfo(UserInfo params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("user_info");
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                WHERE("USER_ID=#{userId}");
            }
            if (EmptyUtil.isNotEmpty(params.getOpenId())) {
                WHERE("OPENID=#{openId}");
            }
        }}.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 查询用户的圈子列表
     *
     * @param params
     * @return
     */

    public String findUserGroupList(UserGroup params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("user_group");
            if (EmptyUtil.isNotEmpty(params.getId())) {
                WHERE("ID=#{id}");
            }
            if (EmptyUtil.isNotEmpty(params.getGroupId())) {
                WHERE("GROUP_ID=#{groupId}");
            }
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                WHERE("USER_ID=#{userId}");
            }
            ORDER_BY("SORT DESC");
        }}.toString();
        baseLog.info(sql);
        return sql;

    }

    /**
     * 保存用户的圈子
     *
     * @param params
     * @return
     */
    public String saveUserGroup(UserGroup params) {
        String sql = new SQL() {{
            INSERT_INTO("user_group");
            if (EmptyUtil.isNotEmpty(params.getGroupId())) {
                VALUES("group_id", "#{groupId}");
            }
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                VALUES("user_id", "#{userId}");
            }
            if (EmptyUtil.isNotEmpty(params.getSort())) {
                VALUES("sort", "#{sort}");
            }
            if (EmptyUtil.isNotEmpty(params.getModifyTime())) {
                VALUES("modify_time", "#{modifyTime}");
            }
            if (EmptyUtil.isNotEmpty(params.getCreateTime())) {
                VALUES("create_time", "#{createTime}");
            }
        }}.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 更新用户圈子
     *
     * @param params
     * @return
     */
    public String updateUserGroup(UserGroup params) {
        String sql = new SQL() {{
            UPDATE("user_group");
            if (EmptyUtil.isNotEmpty(params.getSort())) {
                SET("SORT=#{sort}");
            }
            WHERE("ID=#{id}");
        }}.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 查询圈子列表
     *
     * @param params
     * @return
     */

    public String findGroupInfoList(GroupInfo params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("group_info");
            if (EmptyUtil.isNotEmpty(params.getId())) {
                WHERE("ID=#{id}");
            }
            if (EmptyUtil.isNotEmpty(params.getGroupName())) {
                WHERE("GROUP_NAME=#{groupName}");
            }
            WHERE("IS_DEL=0");
        }}.toString();
        baseLog.info(sql);
        return sql;
    }

    /**
     * 保存圈子
     *
     * @param params
     * @return
     */
    public String saveGroupInfo(GroupInfo params) {
        String sql = new SQL() {
            {
                INSERT_INTO("group_info");
                if (EmptyUtil.isNotEmpty(params.getUserId())) {
                    VALUES("user_id", "#{userId}");
                }
                if (EmptyUtil.isNotEmpty(params.getGroupName())) {
                    VALUES("group_name", "#{groupName}");
                }
                if (EmptyUtil.isNotEmpty(params.getGroupTitle())) {
                    VALUES("group_title", "#{groupTitle}");
                }
                if (EmptyUtil.isNotEmpty(params.getGroupPhotoUrl())) {
                    VALUES("group_photo_url", "#{groupPhotoUrl}");
                }
                if (EmptyUtil.isNotEmpty(params.getGroupDesc())) {
                    VALUES("group_desc", "#{groupDesc}");
                }
                if (EmptyUtil.isNotEmpty(params.getGroupType())) {
                    VALUES("group_type", "#{groupType}");
                }
                if (EmptyUtil.isNotEmpty(params.getGroupPrice())) {
                    VALUES("group_price", "#{groupPrice}");
                }
                if (EmptyUtil.isNotEmpty(params.getValidityDay())) {
                    VALUES("validity_day", "#{validityDay}");
                }
                if (EmptyUtil.isNotEmpty(params.getFreeDay())) {
                    VALUES("free_day", "#{freeDay}");
                }
                if (EmptyUtil.isNotEmpty(params.getModifyTime())) {
                    VALUES("modify_time", "#{modifyTime}");
                }
                if (EmptyUtil.isNotEmpty(params.getCreateTime())) {
                    VALUES("create_time", "#{createTime}");
                }
            }
        }.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 查询标签列表
     *
     * @param params
     * @return
     */
    public String findGroupTagList(GroupTag params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("group_tag");
            if (EmptyUtil.isNotEmpty(params.getId())) {
                WHERE("ID=#{id}");
            }
            if (EmptyUtil.isNotEmpty(params.getGroupId())) {
                WHERE("GROUP_ID=#{groupId}");
            }
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                WHERE("USER_ID=#{userId}");
            }
            if (EmptyUtil.isNotEmpty(params.getTagType())) {
                WHERE("TAG_TYPE=#{tagType}");
            }
            WHERE("IS_DEL=0");
        }}.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 保存标签
     *
     * @param params
     * @return
     */
    public String saveGroupTag(GroupTag params) {
        String sql = new SQL() {{
            INSERT_INTO("group_tag");
            if (EmptyUtil.isNotEmpty(params.getGroupId())) {
                VALUES("group_id", "#{groupId}");
            }
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                VALUES("user_id", "#{userId}");
            }
            if (EmptyUtil.isNotEmpty(params.getTagName())) {
                VALUES("tag_name", "#{tagName}");
            }
            if (EmptyUtil.isNotEmpty(params.getSort())) {
                VALUES("sort", "#{sort}");
            }
            if (EmptyUtil.isNotEmpty(params.getTagType())) {
                VALUES("tag_type", "#{tagType}");
            }
            if (EmptyUtil.isNotEmpty(params.getCreateTime())) {
                VALUES("create_time", "#{createTime}");
            }
        }}.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 查询成员列表
     *
     * @param params
     * @return
     */
    public String findGroupMemberList(GroupMember params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("group_member");

            if (EmptyUtil.isNotEmpty(params.getId())) {
                WHERE("ID=#{id}");
            }
            if (EmptyUtil.isNotEmpty(params.getGroupId())) {
                WHERE("GROUP_ID=#{groupId}");
            }
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                WHERE("USER_ID=#{userId}");
            }
            if (EmptyUtil.isNotEmpty(params.getMemberIdentity())) {
                WHERE("MEMBER_IDENTITY=#{memberIdentity}");
            }
            if (EmptyUtil.isNotEmpty(params.getMemberStatus())) {
                WHERE("MEMBER_STATUS=#{memberStatus}");
            }
            ORDER_BY("CREATE_TIME ASC");
        }}.toString();

        if (EmptyUtil.isNotEmpty(params.getPageNum())) {
            sql += " LIMIT " + params.getPageNum() * params.getPageSize() + "," + params.getPageSize();
        }
        baseLog.info(sql);
        return sql;
    }


    /**
     * 保存成员
     *
     * @param params
     * @return
     */
    public String saveGroupMember(GroupMember params) {
        String sql = new SQL() {{
            INSERT_INTO("group_member");
            if (EmptyUtil.isNotEmpty(params.getGroupId())) {
                VALUES("group_id", "#{groupId}");
            }
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                VALUES("user_id", "#{userId}");
            }
            if (EmptyUtil.isNotEmpty(params.getMemberIdentity())) {
                VALUES("member_identity", "#{memberIdentity}");
            }
            if (EmptyUtil.isNotEmpty(params.getCreateTime())) {
                VALUES("create_time", "#{createTime}");
            }
        }}.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 更新圈子信息
     *
     * @param params
     * @return
     */
    public String updateGroupInfo(GroupInfo params) {
        String sql = new SQL() {{
            UPDATE("group_info");
            if (EmptyUtil.isNotEmpty(params.getGroupName())) {
                SET("group_name=#{groupName}");
            }
            if (EmptyUtil.isNotEmpty(params.getGroupTitle())) {
                SET("group_title=#{groupTitle}");
            }
            if (EmptyUtil.isNotEmpty(params.getGroupPhotoUrl())) {
                SET("group_photo_url=#{groupPhotoUrl}");
            }
            if (EmptyUtil.isNotEmpty(params.getGroupDesc())) {
                SET("group_desc=#{groupDesc}");
            }
            if (EmptyUtil.isNotEmpty(params.getGroupType())) {
                SET("group_type=#{groupType}");
            }
            if (EmptyUtil.isNotEmpty(params.getGroupPrice())) {
                SET("group_price=#{groupPrice}");
            }
            if (EmptyUtil.isNotEmpty(params.getValidityDay())) {
                SET("validity_day=#{validityDay}");
            }
            if (EmptyUtil.isNotEmpty(params.getFreeDay())) {
                SET("free_day=#{freeDay}");
            }
            if (EmptyUtil.isNotEmpty(params.getIsDel())) {
                SET("is_del=#{isDel}");
            }
            if (EmptyUtil.isNotEmpty(params.getIsTopic())) {
                SET("is_topic=#{isTopic}");
            }
            if (EmptyUtil.isNotEmpty(params.getIsActivity())) {
                SET("is_activity=#{isActivity}");
            }
            if (EmptyUtil.isNotEmpty(params.getModifyTime())) {
                SET("modify_time=#{modifyTime}");
            }
            WHERE("ID=#{id}");
        }}.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 更新圈子会员信息
     *
     * @param params
     * @return
     */
    public String updateGroupMember(GroupMember params) {
        String sql = new SQL() {{
            UPDATE("group_member");
            if (EmptyUtil.isNotEmpty(params.getMemberIdentity())) {
                SET("member_identity=#{memberIdentity}");
            }
            if (EmptyUtil.isNotEmpty(params.getMemberStatus())) {
                SET("member_status=#{memberStatus}");
            }
            WHERE("group_id=#{groupId} and user_id=#{userId}");
        }}.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 保存主题
     *
     * @param params
     * @return
     */
    public String saveGroupTopic(GroupTopic params) {
        String sql = new SQL() {{
            INSERT_INTO("group_topic");
            if (EmptyUtil.isNotEmpty(params.getGroupId())) {
                VALUES("group_id", "#{groupId}");
            }
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                VALUES("user_id", "#{userId}");
            }
            if (EmptyUtil.isNotEmpty(params.getTagId())) {
                VALUES("tag_id", "#{tagId}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicTitle())) {
                VALUES("topic_title", "#{topicTitle}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicContent())) {
                VALUES("topic_content", "#{topicContent}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicType())) {
                VALUES("topic_type", "#{topicType}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicPrice())) {
                VALUES("topic_price", "#{topicPrice}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicShow())) {
                VALUES("topic_show", "#{topicShow}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicRead())) {
                VALUES("topic_read", "#{topicRead}");
            }
            if (EmptyUtil.isNotEmpty(params.getIsTop())) {
                VALUES("is_top", "#{isTop}");
            }
            if (EmptyUtil.isNotEmpty(params.getIsDel())) {
                VALUES("is_del", "#{isDel}");
            }
            if (EmptyUtil.isNotEmpty(params.getIsGood())) {
                VALUES("is_good", "#{isGood}");
            }
            if (EmptyUtil.isNotEmpty(params.getStatus())) {
                VALUES("status", "#{status}");
            }
            if (EmptyUtil.isNotEmpty(params.getModifyTime())) {
                VALUES("modify_time", "#{modifyTime}");
            }
            if (EmptyUtil.isNotEmpty(params.getCreateTime())) {
                VALUES("create_time", "#{createTime}");
            }
        }}.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 保存主题文件
     *
     * @param params
     * @return
     */
    public String saveGroupTopicFile(GroupTopicFile params) {
        String sql = new SQL() {{
            INSERT_INTO("group_topic_file");
            if (EmptyUtil.isNotEmpty(params.getFileName())) {
                VALUES("file_name", "#{fileName}");
            }
            if (EmptyUtil.isNotEmpty(params.getFileType())) {
                VALUES("file_type", "#{fileType}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicId())) {
                VALUES("topic_id", "#{topicId}");
            }
            if (EmptyUtil.isNotEmpty(params.getCreateTime())) {
                VALUES("create_time", "#{createTime}");
            }
        }}.toString();
        baseLog.info(sql);
        return sql;
    }

    /**
     * 主题列表
     *
     * @param params
     * @return
     */
    public String findGroupTopicList(GroupTopic params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("group_topic");

            if (EmptyUtil.isNotEmpty(params.getId())) {
                WHERE("ID=#{id}");
            }
            if (EmptyUtil.isNotEmpty(params.getGroupId())) {
                WHERE("GROUP_ID=#{groupId}");
            }
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                WHERE("USER_ID=#{userId}");
            }
            if (EmptyUtil.isNotEmpty(params.getStatus())) {
                WHERE("STATUS=#{status}");
            }
        }}.toString();

        if (EmptyUtil.isNotEmpty(params.getPageNum())) {
            sql += " LIMIT " + params.getPageNum() * params.getPageSize() + "," + params.getPageSize();
        }
        baseLog.info(sql);
        return sql;
    }


    /**
     * 主题文件列表
     *
     * @param params
     * @return
     */
    public String findGroupTopicFileList(GroupTopicFile params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("group_topic_file");

            if (EmptyUtil.isNotEmpty(params.getId())) {
                WHERE("ID=#{id}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicId())) {
                WHERE("TOPIC_ID=#{topicId}");
            }
        }}.toString();

        baseLog.info(sql);
        return sql;
    }


    /**
     * 保存评论
     *
     * @param params
     * @return
     */
    public String saveGroupComments(GroupComments params) {
        String sql = new SQL() {{
            INSERT_INTO("group_comments");
            if (EmptyUtil.isNotEmpty(params.getType())) {
                VALUES("type", "#{type}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicId())) {
                VALUES("topic_id", "#{topicId}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityId())) {
                VALUES("activity_id", "#{activityId}");
            }
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                VALUES("user_id", "#{userId}");
            }
            if (EmptyUtil.isNotEmpty(params.getContent())) {
                VALUES("content", "#{content}");
            }
            if (EmptyUtil.isNotEmpty(params.getCreateTime())) {
                VALUES("create_time", "#{createTime}");
            }
        }}.toString();
        baseLog.info(sql);
        return sql;
    }

    /**
     * 评论列表
     *
     * @param params
     * @return
     */
    public String findGroupCommentsList(GroupComments params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("group_comments");
            if (EmptyUtil.isNotEmpty(params.getId())) {
                WHERE("ID=#{id}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicId())) {
                WHERE("topic_id=#{topicId}");
            }
        }}.toString();

        if (EmptyUtil.isNotEmpty(params.getPageNum())) {
            sql += " LIMIT " + params.getPageNum() * params.getPageSize() + "," + params.getPageSize();
        }
        baseLog.info(sql);
        return sql;
    }


    /**
     * 更新主题信息
     *
     * @param params
     * @return
     */
    public String updateGroupTopic(GroupTopic params) {
        String sql = new SQL() {{
            UPDATE("group_topic");
            if (EmptyUtil.isNotEmpty(params.getTagId())) {
                SET("tag_id=#{tagId}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicTitle())) {
                SET("topic_title=#{topicTitle}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicContent())) {
                SET("topic_content=#{topicContent}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicType())) {
                SET("topic_type=#{topicType}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicPrice())) {
                SET("topic_price=#{topicPrice}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicShow())) {
                SET("topic_show=#{topicShow}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicRead())) {
                SET("topic_read=#{topicRead}");
            }
            if (EmptyUtil.isNotEmpty(params.getIsTop())) {
                SET("is_top=#{isTop}");
            }
            if (EmptyUtil.isNotEmpty(params.getIsDel())) {
                SET("is_del=#{isDel}");
            }
            if (EmptyUtil.isNotEmpty(params.getIsGood())) {
                SET("is_good=#{isGood}");
            }
            if (EmptyUtil.isNotEmpty(params.getStatus())) {
                SET("status=#{status}");
            }
            if (EmptyUtil.isNotEmpty(params.getModifyTime())) {
                SET("modify_time=#{modifyTime}");
            }
            WHERE("ID=#{id}");
        }}.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 活动列表
     *
     * @param params
     * @return
     */
    public String findGroupActivityList(GroupActivity params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("group_activity");

            if (EmptyUtil.isNotEmpty(params.getId())) {
                WHERE("ID=#{id}");
            }
            if (EmptyUtil.isNotEmpty(params.getGroupId())) {
                WHERE("GROUP_ID=#{groupId}");
            }
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                WHERE("USER_ID=#{userId}");
            }
            if (EmptyUtil.isNotEmpty(params.getStatus())) {
                WHERE("STATUS=#{status}");
            }
        }}.toString();

        if (EmptyUtil.isNotEmpty(params.getPageNum())) {
            sql += " LIMIT " + params.getPageNum() * params.getPageSize() + "," + params.getPageSize();
        }
        baseLog.info(sql);
        return sql;
    }


    /**
     * 保存活动
     *
     * @param params
     * @return
     */
    public String saveGroupActivity(GroupActivity params) {
        String sql = new SQL() {{
            INSERT_INTO("group_activity");
            if (EmptyUtil.isNotEmpty(params.getGroupId())) {
                VALUES("group_id", "#{groupId}");
            }
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                VALUES("user_id", "#{userId}");
            }
            if (EmptyUtil.isNotEmpty(params.getTagId())) {
                VALUES("tag_id", "#{tagId}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityTitle())) {
                VALUES("activity_title", "#{activityTitle}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityContent())) {
                VALUES("activity_content", "#{activityContent}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityType())) {
                VALUES("activity_type", "#{activityType}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityPrice())) {
                VALUES("activity_price", "#{activityPrice}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityRead())) {
                VALUES("activity_read", "#{activityRead}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityCount())) {
                VALUES("activity_count", "#{activityCount}");
            }
            if (EmptyUtil.isNotEmpty(params.getIsDel())) {
                VALUES("is_del", "#{isDel}");
            }
            if (EmptyUtil.isNotEmpty(params.getIsEnd())) {
                VALUES("is_end", "#{isEnd}");
            }
            if (EmptyUtil.isNotEmpty(params.getStatus())) {
                VALUES("status", "#{status}");
            }
            if (EmptyUtil.isNotEmpty(params.getModifyTime())) {
                VALUES("modify_time", "#{modifyTime}");
            }
            if (EmptyUtil.isNotEmpty(params.getCreateTime())) {
                VALUES("create_time", "#{createTime}");
            }
        }}.toString();
        baseLog.info(sql);
        return sql;
    }

    /**
     * 更新主题信息
     *
     * @param params
     * @return
     */
    public String updateGroupActivity(GroupActivity params) {
        String sql = new SQL() {{
            UPDATE("group_activity");
            if (EmptyUtil.isNotEmpty(params.getTagId())) {
                SET("tag_id=#{tagId}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityTitle())) {
                SET("activity_title=#{topicTitle}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityContent())) {
                SET("activity_content=#{topicContent}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityType())) {
                SET("activity_type=#{topicType}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityPrice())) {
                SET("activity_price=#{topicPrice}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityRead())) {
                SET("activity_read=#{topicRead}");
            }
            if (EmptyUtil.isNotEmpty(params.getIsDel())) {
                SET("is_del=#{isDel}");
            }
            if (EmptyUtil.isNotEmpty(params.getIsEnd())) {
                SET("is_end=#{isEnd}");
            }
            if (EmptyUtil.isNotEmpty(params.getStatus())) {
                SET("status=#{status}");
            }
            if (EmptyUtil.isNotEmpty(params.getModifyTime())) {
                SET("modify_time=#{modifyTime}");
            }
            WHERE("ID=#{id}");
        }}.toString();
        baseLog.info(sql);
        return sql;
    }

    /**
     * 保存活动文件
     *
     * @param params
     * @return
     */
    public String saveGroupActivityFile(GroupActivityFile params) {
        String sql = new SQL() {{
            INSERT_INTO("group_activity_file");
            if (EmptyUtil.isNotEmpty(params.getFileName())) {
                VALUES("file_name", "#{fileName}");
            }
            if (EmptyUtil.isNotEmpty(params.getFileType())) {
                VALUES("file_type", "#{fileType}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityId())) {
                VALUES("activity_id", "#{activityId}");
            }
            if (EmptyUtil.isNotEmpty(params.getCreateTime())) {
                VALUES("create_time", "#{createTime}");
            }
        }}.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 活动文件列表
     *
     * @param params
     * @return
     */
    public String findGroupActivityFileList(GroupActivityFile params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("group_activity_file");

            if (EmptyUtil.isNotEmpty(params.getId())) {
                WHERE("ID=#{id}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityId())) {
                WHERE("ACTIVITY_ID=#{activityId}");
            }
        }}.toString();

        baseLog.info(sql);
        return sql;
    }


    /**
     * 加入活动
     *
     * @param params
     * @return
     */
    public String saveGroupActivityJoin(GroupActivityJoin params) {
        String sql = new SQL() {{
            INSERT_INTO("group_activity_join");
            if (EmptyUtil.isNotEmpty(params.getActivityId())) {
                VALUES("activity_id", "#{activityId}");
            }
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                VALUES("user_id", "#{userId}");
            }
            if (EmptyUtil.isNotEmpty(params.getCreateTime())) {
                VALUES("create_time", "#{createTime}");
            }
        }}.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 活动成员列表
     *
     * @param params
     * @return
     */
    public String findGroupActivityJoinList(GroupActivityJoin params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("group_activity_join");

            if (EmptyUtil.isNotEmpty(params.getId())) {
                WHERE("ID=#{id}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityId())) {
                WHERE("ACTIVITY_ID=#{activityId}");
            }
        }}.toString();

        baseLog.info(sql);
        return sql;
    }


    /**
     * 保存用户订单
     *
     * @param params
     * @return
     */
    public String saveUserOrder(UserOrder params) {
        String sql = new SQL() {{
            INSERT_INTO("user_order");
            if (EmptyUtil.isNotEmpty(params.getOrderNo())) {
                VALUES("order_no", "#{orderNo}");
            }
            if (EmptyUtil.isNotEmpty(params.getTradeNo())) {
                VALUES("trade_no", "#{tradeNo}");
            }
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                VALUES("user_id", "#{userId}");
            }
            if (EmptyUtil.isNotEmpty(params.getOrderType())) {
                VALUES("order_type", "#{orderType}");
            }
            if (EmptyUtil.isNotEmpty(params.getGroupId())) {
                VALUES("group_id", "#{groupId}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicId())) {
                VALUES("topic_id", "#{topicId}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityId())) {
                VALUES("activity_id", "#{activityId}");
            }
            if (EmptyUtil.isNotEmpty(params.getBody())) {
                VALUES("body", "#{body}");
            }
            if (EmptyUtil.isNotEmpty(params.getPayAmount())) {
                VALUES("pay_amount", "#{payAmount}");
            }
            if (EmptyUtil.isNotEmpty(params.getRemark())) {
                VALUES("remark", "#{activityId}");
            }
            if (EmptyUtil.isNotEmpty(params.getModifyTime())) {
                VALUES("modify_time", "#{createTime}");
            }
            if (EmptyUtil.isNotEmpty(params.getCreateTime())) {
                VALUES("create_time", "#{createTime}");
            }
        }}.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 更新用户订单
     *
     * @param params
     * @return
     */
    public String updateUserOrder(UserOrder params) {
        String sql = new SQL() {{
            UPDATE("user_order");
            if (EmptyUtil.isNotEmpty(params.getStatus())) {
                SET("trade_no=#{tradeNo}");
            }
            if (EmptyUtil.isNotEmpty(params.getStatus())) {
                SET("status=#{status}");
            }
            if (EmptyUtil.isNotEmpty(params.getSuccessTime())) {
                SET("success_time=#{successTime}");
            }
            if (EmptyUtil.isNotEmpty(params.getModifyTime())) {
                SET("modify_time=#{modifyTime}");
            }
            WHERE("order_no=#{orderNo}");
        }}.toString();
        baseLog.info(sql);
        return sql;
    }


    /**
     * 查询用户订单
     *
     * @param params
     * @return
     */
    public String findUserOrder(UserOrder params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("user_order");
            if (EmptyUtil.isNotEmpty(params.getOrderNo())) {
                WHERE("ORDER_NO=#{orderNo}");
            }
            if (EmptyUtil.isNotEmpty(params.getUserId())) {
                WHERE("USER_ID=#{userId}");
            }
            if (EmptyUtil.isNotEmpty(params.getGroupId())) {
                WHERE("GROUP_ID=#{groupId}");
            }
            if (EmptyUtil.isNotEmpty(params.getTopicId())) {
                WHERE("TOPIC_ID=#{topicId}");
            }
            if (EmptyUtil.isNotEmpty(params.getActivityId())) {
                WHERE("ACTIVITY_ID=#{activityId}");
            }
            if (EmptyUtil.isNotEmpty(params.getStatus())) {
                WHERE("STATUS=#{status}");
            }
        }}.toString();
        baseLog.info(sql);
        return sql;
    }

}


