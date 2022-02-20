package com.xm.core.entity;

public class XmProductCopyVo {

    String id;//原产品编号

    String code;//新的产品编码
    String productName;//新的产品名称

    String isTpl;//是否拷贝为模板

    String copyMenu;//是否拷贝需求

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
