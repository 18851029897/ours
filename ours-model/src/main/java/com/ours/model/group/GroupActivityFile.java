package com.ours.model.group;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by fish on 2018/11/25.
 */
@Entity
@Table(name = "group_activity_file", schema = "ours", catalog = "")
public class GroupActivityFile {
    private Integer id;
    private Integer activityId;
    private String fileName;
    private Integer fileType;
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
    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "file_type")
    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public GroupActivityFile() {
    }

    public GroupActivityFile(Integer activityId) {
        this.activityId = activityId;
    }

    public GroupActivityFile(String fileName, Integer fileType, Integer activityId, Date createTime) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.activityId = activityId;
        this.createTime = createTime;
    }
}
