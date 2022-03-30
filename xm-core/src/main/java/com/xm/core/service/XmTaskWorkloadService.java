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


	@Transactional(rollbackFor = Exception.class)
	public void editWorkloadToSbill(Map<String,Object> params){
		//查询出相关工时单、结算单
		Map<String,Object> query = new HashMap<>();
		query.put("ids",params.get("ids"));
		List<Map<String,Object>> workloads = this.selectListMapByWhere(query);
		XmTaskSbill xmTaskSbill = new XmTaskSbill();
		xmTaskSbill.setId((String) params.get("sbillId"));
		xmTaskSbill = xmTaskSbillService.selectOneObject(xmTaskSbill);
		//累加工时、结算金额
		BigDecimal totalWork = BigDecimal.ZERO;
		BigDecimal totalSamt = BigDecimal.ZERO;
		for (Map<String, Object> workload : workloads) {
			totalWork = totalWork.add((BigDecimal) workload.get("workload"));
			totalSamt = totalSamt.add((BigDecimal) workload.get("samt"));
			workload.put("sbillId",xmTaskSbill.getId());
			workload.put("sstatus","2");
			workload.put("stime", DateUtils.getDatetime());
		}
		xmTaskSbill.setWorkload(xmTaskSbill.getWorkload().add(totalWork));
		xmTaskSbill.setAmt(xmTaskSbill.getAmt().add(totalSamt));
		xmTaskSbill.setLtime(new Date());
		xmTaskSbillService.updateByPk(xmTaskSbill);
		this.batchUpdate(workloads);
	}

}

