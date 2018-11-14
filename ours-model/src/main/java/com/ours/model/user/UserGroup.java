package com.ours.model.user;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by fish on 2018/11/13.
 */
@Entity
@Table(name = "user_group", schema = "ours", catalog = "")
public class UserGroup {
    private Integer id;
    private Integer userId;
    private Integer groupId;
    private Integer sort;
    private Date modifyTime;
    private Date createTime;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "group_id")
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "modify_time")
    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGroup userGroup = (UserGroup) o;

        if (id != userGroup.id) return false;
        if (userId != null ? !userId.equals(userGroup.userId) : userGroup.userId != null) return false;
        if (groupId != null ? !groupId.equals(userGroup.groupId) : userGroup.groupId != null) return false;
        if (sort != null ? !sort.equals(userGroup.sort) : userGroup.sort != null) return false;
        if (modifyTime != null ? !modifyTime.equals(userGroup.modifyTime) : userGroup.modifyTime != null) return false;
        if (createTime != null ? !createTime.equals(userGroup.createTime) : userGroup.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (modifyTime != null ? modifyTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
