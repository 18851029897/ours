package com.ours.common.vo.group;

import com.ours.model.group.GroupActivity;
import com.ours.model.group.GroupActivityFile;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
public class GroupActivityVO extends GroupActivity {

    private String userName;

    private Integer isMaster = 0;

    private List<GroupActivityFile> files;

    private String tagName;

    private Integer places;

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

    public List<GroupActivityFile> getFiles() {
        return files;
    }

    public void setFiles(List<GroupActivityFile> files) {
        this.files = files;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }
}
