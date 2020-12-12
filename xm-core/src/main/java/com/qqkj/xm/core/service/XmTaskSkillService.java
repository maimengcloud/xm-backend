package com.qqkj.xm.core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qqkj.xm.core.entity.XmTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.qqkj.mdp.core.service.BaseService;
import com.qqkj.xm.core.entity.XmTaskSkill;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmTaskSkill 表 XM.xm_task_skill 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmTaskSkillService")
public class XmTaskSkillService extends BaseService {
	

	@Autowired
	XmRecordService xmRecordService;
	
	/** 请在此类添加自定义函数 */
	public void addSkill(List<XmTaskSkill> skillList) {
        skillList.forEach(skill->{
            skill.setId(this.createKey("id"));
            this.insert(skill);
        });
    }
    public void insertOrDelete(List<XmTaskSkill> skillList){
        if(skillList.size() > 0){
            String taskId = skillList.get(0).getTaskId();
            XmTaskSkill query = new XmTaskSkill();
            query.setTaskId(taskId);
            List<XmTaskSkill> oldList = this.selectListByWhere(query);
    
            Map<String,XmTaskSkill> delMap = new HashMap<>();
            
    
            oldList.forEach(old->{
                delMap.put(old.getTaskSkillId(),old);
            });
            List<String> taskSkillIds=new ArrayList<>();
            List<String>  taskSkillNames=new ArrayList<>();
            skillList.forEach(skill -> {
                if(delMap.containsKey(skill.getTaskSkillId())){
                    delMap.remove(skill.getTaskSkillId());
                }
                else{
                    skill.setId(this.createKey("id"));
                    skill.setTaskId(taskId);
                    this.insert(skill);
                }
                
                taskSkillIds.add(skill.getTaskSkillId());
                taskSkillNames.add(skill.getTaskSkillName());
                
                
            });
    
            if(delMap.size() > 0){
                for(XmTaskSkill value : delMap.values()){
                    this.deleteByPk(value);
                }
            }
            

            this.updateXmTaskSkillIdsAndNamesByTaskId(taskId);
        }

    }
    public void updateXmTaskSkillIdsAndNamesByTaskId(String taskId) {
    	super.update("updateXmTaskSkillIdsAndNamesByTaskId", taskId);
    }
}

