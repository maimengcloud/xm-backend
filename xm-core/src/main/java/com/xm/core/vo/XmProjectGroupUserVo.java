package com.xm.core.vo;

import com.xm.core.entity.XmProjectGroupUser;

public class XmProjectGroupUserVo extends XmProjectGroupUser {

    String pgClass;

    String projectId;


    String productId;

    public String getPgClass() {
        return pgClass;
    }

    public void setPgClass(String pgClass) {
        this.pgClass = pgClass;
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


}
