package com.ours.dao.sql;

import com.ours.common.util.EmptyUtil;
import com.ours.model.base.BaseSysParam;
import com.ours.model.group.GroupInfo;
import com.ours.model.user.UserInfo;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by fish on 2018/10/29.
 */
public class SqlProvider {

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
        System.out.println(sql);
        return sql;
    }


    /**
     * 保存用户信息
     *
     * @param params
     * @return
     */
    public String saveUserInfo(UserInfo params) {
        return new SQL() {
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
    }


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
        System.out.println(sql);
        return sql;
    }

    public String saveGroupInfo(GroupInfo params) {
        return new SQL() {
            {
                INSERT_INTO("group_info");
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
    }

}
