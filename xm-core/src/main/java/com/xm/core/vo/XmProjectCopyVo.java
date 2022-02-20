package com.xm.core.vo;

public class XmProjectCopyVo {
    String id;//原项目编号
    String code;//新项目编码
    String name;//新项目名称
    String isTpl;//是否复制为模板项目 0否1是
    String copyPhase;//是否复制计划 0否1是
    String copyTask;//是否复制任务  0否1是
    String copyGrup;//是否复制组织架构 0否1是

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsTpl() {
        return isTpl;
    }

    public void setIsTpl(String isTpl) {
        this.isTpl = isTpl;
    }

    public String getCopyPhase() {
        return copyPhase;
    }

    public void setCopyPhase(String copyPhase) {
        this.copyPhase = copyPhase;
    }

    public String getCopyTask() {
        return copyTask;
    }

    public void setCopyTask(String copyTask) {
        this.copyTask = copyTask;
    }

    public String getCopyGrup() {
        return copyGrup;
    }

    public void setCopyGrup(String copyGrup) {
        this.copyGrup = copyGrup;
    }
}
