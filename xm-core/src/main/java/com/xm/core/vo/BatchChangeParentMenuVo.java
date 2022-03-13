package com.xm.core.vo;

import java.util.List;

public class BatchChangeParentMenuVo {

    List<String> menuIds;

    String pmenuId;

    public List<String> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<String> menuIds) {
        this.menuIds = menuIds;
    }

    public String getPmenuId() {
        return pmenuId;
    }

    public void setPmenuId(String pmenuId) {
        this.pmenuId = pmenuId;
    }
}
