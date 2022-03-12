package com.xm.core.vo;

import java.util.List;

public class BatchChangeParentTaskVo {

    List<String> taskIds;

    String parentTaskid;

    public List<String> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<String> taskIds) {
        this.taskIds = taskIds;
    }

    public String getParentTaskid() {
        return parentTaskid;
    }

    public void setParentTaskid(String parentTaskid) {
        this.parentTaskid = parentTaskid;
    }
}
