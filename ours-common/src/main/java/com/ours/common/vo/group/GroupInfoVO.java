package com.ours.common.vo.group;

import com.ours.model.group.GroupInfo;

/**
 * Created by fish on 2018/11/21.
 */
public class GroupInfoVO extends GroupInfo {

    private Integer isMaster = 0;

    public Integer getIsMaster() {
        return isMaster;
    }

    public void setIsMaster(Integer isMaster) {
        this.isMaster = isMaster;
    }
}
