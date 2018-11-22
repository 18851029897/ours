package com.ours.model.group;

import com.ours.model.page.PageSearch;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by fish on 2018/11/22.
 */
@Entity
@Table(name = "group_topic", schema = "ours", catalog = "")
public class GroupTopic extends PageSearch {
    private Integer id;
    private Integer groupId;
    private Integer userId;
    private Integer tagId;
    private String topicTitle;
    private String topicContent;
    private Integer topicType;
    private BigDecimal topicPrice;
    private Integer topicShow;
    private Integer topicRead;
    private Integer isTop;
    private Integer isDel;
    private Integer isGood;
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
    @Column(name = "topic_title")
    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    @Basic
    @Column(name = "topic_content")
    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    @Basic
    @Column(name = "topic_type")
    public Integer getTopicType() {
        return topicType;
    }

    public void setTopicType(Integer topicType) {
        this.topicType = topicType;
    }

    @Basic
    @Column(name = "topic_price")
    public BigDecimal getTopicPrice() {
        return topicPrice;
    }

    public void setTopicPrice(BigDecimal topicPrice) {
        this.topicPrice = topicPrice;
    }

    @Basic
    @Column(name = "topic_show")
    public Integer getTopicShow() {
        return topicShow;
    }

    public void setTopicShow(Integer topicShow) {
        this.topicShow = topicShow;
    }

    @Basic
    @Column(name = "topic_read")
    public Integer getTopicRead() {
        return topicRead;
    }

    public void setTopicRead(Integer topicRead) {
        this.topicRead = topicRead;
    }

    @Basic
    @Column(name = "is_top")
    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
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
    @Column(name = "is_good")
    public Integer getIsGood() {
        return isGood;
    }

    public void setIsGood(Integer isGood) {
        this.isGood = isGood;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupTopic that = (GroupTopic) o;

        if (id != that.id) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (tagId != null ? !tagId.equals(that.tagId) : that.tagId != null) return false;
        if (topicTitle != null ? !topicTitle.equals(that.topicTitle) : that.topicTitle != null) return false;
        if (topicContent != null ? !topicContent.equals(that.topicContent) : that.topicContent != null) return false;
        if (topicType != null ? !topicType.equals(that.topicType) : that.topicType != null) return false;
        if (topicPrice != null ? !topicPrice.equals(that.topicPrice) : that.topicPrice != null) return false;
        if (topicShow != null ? !topicShow.equals(that.topicShow) : that.topicShow != null) return false;
        if (topicRead != null ? !topicRead.equals(that.topicRead) : that.topicRead != null) return false;
        if (isTop != null ? !isTop.equals(that.isTop) : that.isTop != null) return false;
        if (isDel != null ? !isDel.equals(that.isDel) : that.isDel != null) return false;
        if (isGood != null ? !isGood.equals(that.isGood) : that.isGood != null) return false;
        if (modifyTime != null ? !modifyTime.equals(that.modifyTime) : that.modifyTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (tagId != null ? tagId.hashCode() : 0);
        result = 31 * result + (topicTitle != null ? topicTitle.hashCode() : 0);
        result = 31 * result + (topicContent != null ? topicContent.hashCode() : 0);
        result = 31 * result + (topicType != null ? topicType.hashCode() : 0);
        result = 31 * result + (topicPrice != null ? topicPrice.hashCode() : 0);
        result = 31 * result + (topicShow != null ? topicShow.hashCode() : 0);
        result = 31 * result + (topicRead != null ? topicRead.hashCode() : 0);
        result = 31 * result + (isTop != null ? isTop.hashCode() : 0);
        result = 31 * result + (isDel != null ? isDel.hashCode() : 0);
        result = 31 * result + (isGood != null ? isGood.hashCode() : 0);
        result = 31 * result + (modifyTime != null ? modifyTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    public GroupTopic() {
    }

    public GroupTopic(Integer groupId, Integer status) {
        this.groupId = groupId;
        this.status = status;
    }

    public GroupTopic(Integer groupId, Integer userId, Integer status) {
        this.groupId = groupId;
        this.userId = userId;
        this.status = status;
    }
}
