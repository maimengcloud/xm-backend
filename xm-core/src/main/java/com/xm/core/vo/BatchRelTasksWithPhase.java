package com.xm.core.vo;

import java.util.List;

public class BatchRelTasksWithPhase {

    String projectPhaseId;

    List<String> taskIds;

    public String getProjectPhaseId() {
        return projectPhaseId;
    }

    public void setProjectPhaseId(String projectPhaseId) {
        this.projectPhaseId = projectPhaseId;
    }

    public List<String> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<String> taskIds) {
        this.taskIds = taskIds;
    }
}
