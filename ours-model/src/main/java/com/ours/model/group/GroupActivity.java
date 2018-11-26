package com.ours.model.group;

import com.ours.model.page.PageSearch;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by fish on 2018/11/25.
 */
@Entity
@Table(name = "group_activity", schema = "ours", catalog = "")
public class GroupActivity extends PageSearch{
    private Integer id;
    private Integer groupId;
    private Integer userId;
    private Integer tagId;
    private String activityTitle;
    private String activityContent;
    private Integer activityType;
    private BigDecimal activityPrice;
    private Integer activityRead;
    private Integer activityCount;
    private Integer isDel;
    private Integer isEnd;
    private Integer status;
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
    @Column(name = "tag_id")
    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "activity_title")
    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    @Basic
    @Column(name = "activity_content")
    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    @Basic
    @Column(name = "activity_type")
    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    @Basic
    @Column(name = "activity_price")
    public BigDecimal getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(BigDecimal activityPrice) {
        this.activityPrice = activityPrice;
    }

    @Basic
    @Column(name = "activity_read")
    public Integer getActivityRead() {
        return activityRead;
    }

    public void setActivityRead(Integer activityRead) {
        this.activityRead = activityRead;
    }

    @Basic
    @Column(name = "activity_count")
    public Integer getActivityCount() {
        return activityCount;
    }

    public void setActivityCount(Integer activityCount) {
        this.activityCount = activityCount;
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
    @Column(name = "is_end")
    public Integer getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(Integer isEnd) {
        this.isEnd = isEnd;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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


    public GroupActivity() {
    }

    public GroupActivity(Integer id) {
        this.id = id;
    }

    public GroupActivity(Integer groupId, Integer status) {
        this.groupId = groupId;
        this.status = status;
    }

    public GroupActivity(Integer groupId, Integer userId, Integer status) {
        this.groupId = groupId;
        this.userId = userId;
        this.status = status;
    }

}
