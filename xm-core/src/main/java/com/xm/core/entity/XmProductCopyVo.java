package com.xm.core.entity;

public class XmProductCopyVo {

    String id;//原产品编号

    String code;//新的产品编码
    String productName;//新的产品名称

    String isTpl;//是否拷贝为模板

    String copyMenu;//是否拷贝需求
    String copyPhase;//是否复制计划 0否1是
    String copyGroup;//是否复制组织架构 0否1是
    String copyGroupUser;//是否复制组织架构中用户 0否1是

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getIsTpl() {
        return isTpl;
    }

    public void setIsTpl(String isTpl) {
        this.isTpl = isTpl;
    }

    public String getCopyMenu() {
        return copyMenu;
    }

    public void setCopyMenu(String copyMenu) {
        this.copyMenu = copyMenu;
    }

    public String getCopyPhase() {
        return copyPhase;
    }

    public void setCopyPhase(String copyPhase) {
        this.copyPhase = copyPhase;
    }

    public String getCopyGroup() {
        return copyGroup;
    }

    public void setCopyGroup(String copyGroup) {
        this.copyGroup = copyGroup;
    }

    public String getCopyGroupUser() {
        return copyGroupUser;
    }

    public void setCopyGroupUser(String copyGroupUser) {
        this.copyGroupUser = copyGroupUser;
    }
}
