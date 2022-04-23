package com.xm.core.vo;

import java.util.List;

public class BatchJoinToSbillVo {

    List<UserTaskVo> userTasks;

    String sbillId;


    public void setSbillId(String sbillId) {
        this.sbillId = sbillId;
    }

    public String getSbillId() {
        return sbillId;
    }

    public List<UserTaskVo> getUserTasks() {
        return userTasks;
    }

    public void setUserTasks(List<UserTaskVo> userTasks) {
        this.userTasks = userTasks;
    }
}

