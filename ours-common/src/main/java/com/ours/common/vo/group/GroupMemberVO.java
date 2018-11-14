package com.ours.common.vo.group;

import com.ours.model.group.GroupTag;

import java.util.List;

/**
 * Created by fish on 2018/11/13.
 */
public class GroupMemberVO {

    private Integer id;

    private String photo;

    private String name;

    private Integer identity;

    private Integer status;

    private List<GroupTag> tags;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<GroupTag> getTags() {
        return tags;
    }

    public void setTags(List<GroupTag> tags) {
        this.tags = tags;
    }
}
