package com.xm.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdp.core.service.BaseService;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectKpi 表 XM.xm_project_kpi 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmProjectKpiService")
public class XmProjectKpiService extends BaseService {
	
	/** 请在此类添加自定义函数 */

	@Autowired
	XmRecordService xmRecordService;
}

