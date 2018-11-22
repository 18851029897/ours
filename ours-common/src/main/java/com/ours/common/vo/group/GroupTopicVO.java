package com.ours.common.vo.group;

import com.ours.model.group.GroupTopic;
import com.ours.model.group.GroupTopicFile;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
public class GroupTopicVO extends GroupTopic {

    private String userName;

    private Integer isMaster = 0;

    private List<GroupTopicFile> files;

    private String tagName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getIsMaster() {
        return isMaster;
    }

    public void setIsMaster(Integer isMaster) {
        this.isMaster = isMaster;
    }

    public List<GroupTopicFile> getFiles() {
        return files;
    }

    public void setFiles(List<GroupTopicFile> files) {
        this.files = files;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
