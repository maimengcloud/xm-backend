package com.xm.core.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.mdp.core.utils.DateUtils;
import com.mdp.core.utils.MapUtils;
import com.mdp.core.utils.RequestUtils;
import com.xm.core.entity.XmTaskSbill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdp.core.service.BaseService;
import static com.mdp.core.utils.BaseUtils.*;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;

import com.xm.core.entity.XmTaskWorkload;
import org.springframework.transaction.annotation.Transactional;

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



	@Transactional
	public void editWorkloadToSbill(String sbillId, List<XmTaskWorkload> canChanges) {
		xmTaskSbillService.updateByWorkloadList(sbillId);
		this.batchEditSbillId(sbillId,canChanges.stream().map(i->i.getId()).collect(Collectors.toList()));
	}

	private void batchEditSbillId(String sbillId, List<String> ids) {
		Map<String,Object> map=map("sbillId",sbillId,"ids",ids);
		super.update("batchEditSbillId",map);
	}



	public List<Map<String, Object>> listProjectWorkloadSetDay(Map<String, Object> xmTaskWorkload) {
		return super.selectList("listProjectWorkloadSetDay",xmTaskWorkload);
	}
	public List<Map<String, Object>> listProjectWorkloadSetMonth(Map<String, Object> xmTaskWorkload) {
		return super.selectList("listProjectWorkloadSetMonth",xmTaskWorkload);
	}


	public List<Map<String,Object>> listTaskWorkloadBySbillIdGroupByUseridAndTaskId(String sbillId) {
		return this.selectList("listTaskWorkloadBySbillIdGroupByUseridAndTaskId",sbillId);
	}
}

