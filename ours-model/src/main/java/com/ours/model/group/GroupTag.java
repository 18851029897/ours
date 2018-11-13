package com.ours.model.group;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by fishs on 2018/11/13.
 */
@Entity
@Table(name = "group_tag", schema = "ours", catalog = "")
public class GroupTag {
    private Integer id;
    private Integer groupId;
    private String tagName;
    private Integer sort;
    private Integer isDel;
    private Date createTime;
    private Integer userId;
    private Integer tagType;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "tag_name")
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
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
    @Column(name = "is_del")
    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
    @Column(name = "tag_type")
    public Integer getTagType() {
        return tagType;
    }

    public void setTagType(Integer tagType) {
        this.tagType = tagType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupTag groupTag = (GroupTag) o;

        if (id != null ? !id.equals(groupTag.id) : groupTag.id != null) return false;
        if (groupId != null ? !groupId.equals(groupTag.groupId) : groupTag.groupId != null) return false;
        if (tagName != null ? !tagName.equals(groupTag.tagName) : groupTag.tagName != null) return false;
        if (sort != null ? !sort.equals(groupTag.sort) : groupTag.sort != null) return false;
        if (isDel != null ? !isDel.equals(groupTag.isDel) : groupTag.isDel != null) return false;
        if (createTime != null ? !createTime.equals(groupTag.createTime) : groupTag.createTime != null) return false;
        if (userId != null ? !userId.equals(groupTag.userId) : groupTag.userId != null) return false;
        if (tagType != null ? !tagType.equals(groupTag.tagType) : groupTag.tagType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (isDel != null ? isDel.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (tagType != null ? tagType.hashCode() : 0);
        return result;
    }
}
