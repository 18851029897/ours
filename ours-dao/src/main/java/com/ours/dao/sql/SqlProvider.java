package com.ours.dao.sql;

import com.ours.common.util.EmptyUtil;
import com.ours.model.base.BaseSysParam;
import com.ours.model.group.GroupInfo;
import com.ours.model.group.GroupMember;
import com.ours.model.group.GroupTag;
import com.ours.model.user.UserGroup;
import com.ours.model.user.UserInfo;
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

        if(EmptyUtil.isNotEmpty(params.getPageNum())){
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
            if (EmptyUtil.isNotEmpty(params.getModifyTime())) {
                SET("modify_time=#{modifyTime}");
            }
            WHERE("ID=#{id}");
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
}


