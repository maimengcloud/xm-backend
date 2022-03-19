package com.xm.core.vo;

import com.xm.core.entity.XmTask;

import java.util.List;

public class BatchImportVo {


    List<XmTask> xmTasks;
    String parentTaskid;
    String projectId;
    String productId;
    String ptype;

    public List<XmTask> getXmTasks() {
        return xmTasks;
    }

    public void setXmTasks(List<XmTask> xmTasks) {
        this.xmTasks = xmTasks;
    }

    public String getParentTaskid() {
        return parentTaskid;
    }

    public void setParentTaskid(String parentTaskid) {
        this.parentTaskid = parentTaskid;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }
}
