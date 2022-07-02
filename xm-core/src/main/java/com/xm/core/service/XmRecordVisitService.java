package com.xm.core.service;

import com.mdp.core.service.BaseService;
import com.xm.core.entity.XmRecordVisit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmRecordVisit 表 xm_record_visit 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmRecordVisitService")
public class XmRecordVisitService extends BaseService {
	static Logger logger =LoggerFactory.getLogger(XmRecordVisitService.class);

	@Autowired
	public void batchAddAndCalc(List<XmRecordVisit> datas) {
		Map<String, Integer> timesMap=new HashMap<>();
		Map<String,Set<String> > usersMap=new HashMap<>();
		for (XmRecordVisit data : datas) {
			String key=data.getBizId();
			Set<String> users=usersMap.get(key);
			if(users==null){
				users=new HashSet<>();
			}
			users.add(data.getOperUserid());
			usersMap.put(key,users);
		}
		for (XmRecordVisit data : datas) {
			String key=data.getBizId();
			Integer times=timesMap.get(key);
			if(times==null){
				times=0;
			}
			times=times+1;
			timesMap.put(key,times);
		}
		List<Map<String,Object>> datasToUpdate=new ArrayList<>();
		for (String key : timesMap.keySet()) {
			Map<String,Object> data=new HashMap<>();
			data.put("id",key);
			data.put("browseTimes",timesMap.get(key));
			data.put("browseUsers",usersMap.get(key).size());
			datasToUpdate.add(data);
		}
		this.batchInsert(datas);
		if(datasToUpdate.size()>0){
			this.update("updateTaskBrowseTimesAndBrowseUsers",datasToUpdate);
		}
	}
}

