package com.qqkj.xm.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qqkj.mdp.core.service.BaseService;
import com.qqkj.xm.core.entity.XmProjectGroupFormwork;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectGroupFormwork 表 XM.xm_project_group_formwork 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmProjectGroupFormworkService")
public class XmProjectGroupFormworkService extends BaseService {


	@Autowired
	XmRecordService xmRecordService;
	
    public List<Map<String, Object>> getAllGroupName(Map<String, Object> map) {
        return this.getDao().selectList(this.statement("selectAllGroupFormWork"), map);
    }
	/** 请在此类添加自定义函数 */

}

