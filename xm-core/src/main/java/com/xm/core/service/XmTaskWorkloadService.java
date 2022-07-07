package com.xm.core.service;

import com.mdp.core.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTaskWorkload 表 xm_task_workload 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmTaskWorkloadService")
public class XmTaskWorkloadService extends BaseService {
	static Logger logger =LoggerFactory.getLogger(XmTaskWorkloadService.class);

	@Autowired
	XmTaskSbillService xmTaskSbillService;



	public List<Map<String, Object>> listProjectWorkloadSetDay(Map<String, Object> xmTaskWorkload) {
		return super.selectList("listProjectWorkloadSetDay",xmTaskWorkload);
	}
	public List<Map<String, Object>> listProjectWorkloadSetMonth(Map<String, Object> xmTaskWorkload) {
		return super.selectList("listProjectWorkloadSetMonth",xmTaskWorkload);
	}


	public List<Map<String,Object>> listTaskWorkloadBySbillIdGroupByUseridAndTaskId(String sbillId) {
		return this.selectList("listTaskWorkloadBySbillIdGroupByUseridAndTaskId",sbillId);
	}

	public void updateStatusBySbillIdBySbillDel(String sbillId) {
		super.update("updateStatusBySbillIdBySbillDel",sbillId);
	}


	@Transactional
	public void editSomeFieldsWithSbillIds(Map<String, Object> xmTaskWorkloadMap, List<String> sbillIds) {
		super.editSomeFields(xmTaskWorkloadMap);
	}

	public void updateStatusBySbillIdByFlowState(String sbillId,String sstatus) {
		super.update("updateStatusBySbillIdByFlowState",map("sbillId",sbillId,"sstatus",sstatus));
	}

	public List<Map<String, Object>> ListGroupByTaskIdAndUserid(Map<String, Object> xmTaskWorkload) {
		return super.selectList("selectListMapGroupByTaskIdAndUserid",xmTaskWorkload);
	}

	public List<Map<String, Object>> ListGroupByTaskIdAndUseridToSet(Map<String, Object> xmTaskWorkload) {
		return super.selectList("ListGroupByTaskIdAndUseridToSet",xmTaskWorkload);
	}

    public void updateStatusAfterJoinSbill(Map<String,Object> details) {
		super.update("updateStatusAfterJoinSbill",details);
    }

	public void updateStatusAfterDetailDel(List<String> detailIds) {
		super.update("updateStatusAfterDetailDel",detailIds);
	}

	@Override
	public String createKey(String keyName) {
		return "TW"+sequenceService.getCommonNo("{date62:yyyyMMddHHmmss}{rands:4}");
	}
}

