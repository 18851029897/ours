package com.ours.model.group;

import com.ours.model.page.PageSearch;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by fish on 2018/11/13.
 */
@Entity
@Table(name = "group_member", schema = "ours", catalog = "")
public class GroupMember extends PageSearch {
    private Integer id;
    private Integer groupId;
    private Integer userId;
    private Date createTime;
    private Integer memberIdentity;
    private Integer memberStatus;

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
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
    @Column(name = "member_identity")
    public Integer getMemberIdentity() {
        return memberIdentity;
    }

    public void setMemberIdentity(Integer memberIdentity) {
        this.memberIdentity = memberIdentity;
    }

    @Basic
    @Column(name = "member_status")
    public Integer getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(Integer memberStatus) {
        this.memberStatus = memberStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupMember that = (GroupMember) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (memberIdentity != null ? !memberIdentity.equals(that.memberIdentity) : that.memberIdentity != null)
            return false;
        if (memberStatus != null ? !memberStatus.equals(that.memberStatus) : that.memberStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (memberIdentity != null ? memberIdentity.hashCode() : 0);
        result = 31 * result + (memberStatus != null ? memberStatus.hashCode() : 0);
        return result;
    }

    public GroupMember() {
    }

    public GroupMember(Integer id) {
        this.id = id;
    }
}
