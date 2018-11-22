package com.ours.common.vo.group;

import com.ours.model.group.GroupComments;
import com.ours.model.group.GroupTag;

import java.util.Date;
import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
public class GroupCommentsVO {

    private Integer id;

    private Date time;

    private String userName;

    private String userPhoto;

    private String content;

    private List<GroupTag> tags;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<GroupTag> getTags() {
        return tags;
    }

    public void setTags(List<GroupTag> tags) {
        this.tags = tags;
    }
}
