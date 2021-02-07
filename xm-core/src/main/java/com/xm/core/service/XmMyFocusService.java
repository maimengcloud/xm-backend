package com.xm.core.service;

import com.mdp.core.err.BizException;
import com.mdp.core.service.BaseService;
import com.xm.core.entity.XmMyFocus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmMyFocus 表 XM.xm_my_focus 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmMyFocusService")
public class XmMyFocusService extends BaseService {

	

	@Autowired
	XmRecordService xmRecordService;
	/**
	 * 取消关注
	 * @param xmMyFocus
	 */
	public void unfocus(XmMyFocus xmMyFocus) {
		 if(StringUtils.isEmpty(xmMyFocus.getId())) {
			 if("project".equals(xmMyFocus.getFocusType())) {
				 if(StringUtils.isEmpty(xmMyFocus.getProjectId())) {
					 throw new BizException("projectId参数必须上传");
				 }
				 if(StringUtils.isEmpty(xmMyFocus.getUserid())) {
					 throw new BizException("userid参数必须上传");
				 }
				 this.deleteByWhere(xmMyFocus);
				 xmRecordService.addXmProjectRecord(xmMyFocus.getProjectId(), "项目-取消关注项目", xmMyFocus.getUsername()+"取消关注项目"+xmMyFocus.getProjectName());

			 }else if("task".equals(xmMyFocus.getFocusType())) {
				 if(StringUtils.isEmpty(xmMyFocus.getProjectId())) {
					 throw new BizException("taskId参数必须上传");
				 }
				 if(StringUtils.isEmpty(xmMyFocus.getUserid())) {
					 throw new BizException("userid参数必须上传");
				 }
				 
				 this.deleteByWhere(xmMyFocus); 
				 xmRecordService.addXmTaskRecord(xmMyFocus.getProjectId(), xmMyFocus.getTaskId(), "项目-任务-取消关注", xmMyFocus.getUsername()+"取消关注任务"+xmMyFocus.getTaskName());
			 }else {
				 throw new BizException("focusType参数必须上传，取值project/task");
			 }
			 
		 }else { 
			 this.deleteByPk(xmMyFocus);
			 if("project".equals(xmMyFocus.getFocusType())) {
				 if(StringUtils.isEmpty(xmMyFocus.getProjectId())) { 
				 } else if(StringUtils.isEmpty(xmMyFocus.getUserid())) { 
				 }else { 
					 xmRecordService.addXmProjectRecord(xmMyFocus.getProjectId(), "项目-取消关注项目", xmMyFocus.getUsername()+"取消关注项目"+xmMyFocus.getProjectName());
					
				 }
			 }else if("task".equals(xmMyFocus.getFocusType())) {
				 if(StringUtils.isEmpty(xmMyFocus.getProjectId())) { 
				 } else if(StringUtils.isEmpty(xmMyFocus.getUserid())) { 
				 }else { 
					 xmRecordService.addXmTaskRecord(xmMyFocus.getProjectId(), xmMyFocus.getTaskId(), "项目-任务-取消关注", xmMyFocus.getUsername()+"取消关注任务"+xmMyFocus.getTaskName());
				 }
				 
			 } 
		 }
		  
		
	}
	
	/**
	 * 关注项目或者任务
	 * @param xmMyFocus
	 */
	public void focus(XmMyFocus xmMyFocus) { 
		 if("project".equals(xmMyFocus.getFocusType())) {
			 if(StringUtils.isEmpty(xmMyFocus.getProjectId())) {
				 throw new BizException("projectId参数必须上传");
			 }
			 if(StringUtils.isEmpty(xmMyFocus.getUserid())) {
				 throw new BizException("userid参数必须上传");
			 }
			 XmMyFocus query=new XmMyFocus();
			 query.setFocusType(xmMyFocus.getFocusType());
			 query.setUserid(xmMyFocus.getUserid());
			 query.setProjectId(xmMyFocus.getProjectId());
			 List<XmMyFocus> dblist=this.selectListByWhere(query);
			 if(dblist !=null && dblist.size()>0) {
				 return;
			 }else {
				 this.insert(xmMyFocus); 
				 xmRecordService.addXmProjectRecord(xmMyFocus.getProjectId(), "项目-关注项目", xmMyFocus.getUsername()+"关注了项目"+xmMyFocus.getProjectName());
			 } 
		 }else if("task".equals(xmMyFocus.getFocusType())) {
			 if(StringUtils.isEmpty(xmMyFocus.getProjectId())) {
				 throw new BizException("taskId参数必须上传");
			 }
			 if(StringUtils.isEmpty(xmMyFocus.getUserid())) {
				 throw new BizException("userid参数必须上传");
			 }

			 XmMyFocus query=new XmMyFocus();
			 query.setFocusType(xmMyFocus.getFocusType());
			 query.setUserid(xmMyFocus.getUserid());
			 query.setTaskId(xmMyFocus.getTaskId());
			 List<XmMyFocus> dblist=this.selectListByWhere(query);
			 if(dblist !=null && dblist.size()>0) {
				 return;
			 }else {
				 this.insert(xmMyFocus);
				 xmRecordService.addXmTaskRecord(xmMyFocus.getProjectId(), xmMyFocus.getTaskId(), "项目-任务-关注任务", xmMyFocus.getUsername()+"关注了任务"+xmMyFocus.getTaskName());
			 } 
		 }else {
			 throw new BizException("focusType参数必须上传，取值project/task");
		 } 
		
	}
	
	/** 请在此类添加自定义函数 */

}

