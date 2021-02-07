package com.xm.core.service;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdp.core.service.BaseService;
import com.mdp.core.service.SequenceService;
import com.xm.core.entity.XmProject;
import com.xm.core.entity.XmProjectBaseline;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectBaseline 表 XM.xm_project_baseline 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmProjectBaselineService")
public class XmProjectBaselineService extends BaseService {
	
	/** 请在此类添加自定义函数 */
	@Autowired
	SequenceService sequenceService;
	
	/**
	 * 创建基线
	 * @param project 一定要从数据库先查询，否则基线数据不全
	 * @return
	 */
	public  XmProjectBaseline createBaseline(XmProject project,String remark){
		XmProjectBaseline projectBase=new XmProjectBaseline();
		BeanUtils.copyProperties(project, projectBase);
		projectBase.setId(this.createKey("id"));
		projectBase.setCtime(new Date());
		projectBase.setBaseRemark(remark);
		projectBase.setBaselineId(sequenceService.getCommonNo("{date:yyyyMMddHHmmssS}-{rand:4}"));
		this.insert(projectBase);
		return projectBase;
	}
	

}

