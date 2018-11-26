package com.ours.model.group;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by fish on 2018/11/25.
 */
@Entity
@Table(name = "group_activity_join", schema = "ours", catalog = "")
public class GroupActivityJoin {
    private Integer id;
    private Integer activityId;
    private Integer userId;
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
    @Column(name = "activity_id")
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
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

    public GroupActivityJoin() {
    }

    public GroupActivityJoin(Integer activityId) {
        this.activityId = activityId;
    }
}
