package com.xm.core.vo;

import java.util.List;

public class BatchRelTasksWithPhase {

    String projectPhaseId;

    List<String> taskIds;

    public String getPhaseId() {
        return projectPhaseId;
    }

    public void setPhaseId(String projectPhaseId) {
        this.projectPhaseId = projectPhaseId;
    }

    public List<String> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<String> taskIds) {
        this.taskIds = taskIds;
    }
}
