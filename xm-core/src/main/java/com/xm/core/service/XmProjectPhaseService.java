package com.xm.core.service;

import com.mdp.core.entity.Tips;
import com.mdp.core.service.BaseService;
import com.mdp.core.utils.NumberUtil;
import com.xm.core.entity.XmProjectPhase;
import com.xm.core.vo.XmProjectPhaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectPhase 表 XM.xm_project_phase 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmProjectPhaseService")
public class XmProjectPhaseService extends BaseService {
	
	/** 请在此类添加自定义函数 */

	@Autowired
	XmRecordService xmRecordService;
	/**
	 * 查询项目及阶段计划总预算，用于判断是否超出预算 
	 */
	public Map<String,Object> selectTotalProjectAndPhaseBudgetCost(String projectId,List<String> excludePhaseIds){
		Map<String,Object> p=new HashMap<>();
		p.put("projectId", projectId); 
		p.put("excludePhaseIds", excludePhaseIds);
		return this.selectOne("selectTotalProjectAndPhaseBudgetCost", p); 
	}
	
	/**
	 * 判断新增预算是否超出项目总预算
	 * @param projectId
	 * @param addPhaseBudgetCost
	 * @param addPhaseBudgetInnerUserAt
	 * @param addPhaseBudgetOutUserAt
	 * @param addPhaseBudgetNouserAt
	 * @param excludePhaseIds
	 * @return
	 */
	public Tips judgetBudget(String projectId,BigDecimal addPhaseBudgetCost,BigDecimal addPhaseBudgetInnerUserAt,BigDecimal addPhaseBudgetOutUserAt,BigDecimal addPhaseBudgetNouserAt,List<String> excludePhaseIds){
		Tips tips=new Tips("检查预算成功");
		Map<String,Object> g=this.selectTotalProjectAndPhaseBudgetCost(projectId,excludePhaseIds);
		BigDecimal phaseBudgetCost=BigDecimal.ZERO; 
		BigDecimal zero=BigDecimal.ZERO;
		
		if(addPhaseBudgetCost==null) {
			addPhaseBudgetCost=BigDecimal.ZERO;
		}
		if(addPhaseBudgetInnerUserAt==null) {
			addPhaseBudgetInnerUserAt=BigDecimal.ZERO;
		}
		if(addPhaseBudgetOutUserAt==null) {
			addPhaseBudgetOutUserAt=BigDecimal.ZERO;
		}
		if(addPhaseBudgetNouserAt==null) {
			addPhaseBudgetNouserAt=BigDecimal.ZERO;
		}
		if(g==null || g.isEmpty()){

		}
		BigDecimal phaseBudgetInnerUserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetInnerUserAt"),zero);
		BigDecimal phaseBudgetOutUserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetOutUserAt"),zero); 
		BigDecimal phaseBudgetNouserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetNouserAt"),zero); 
		
		BigDecimal planInnerUserAt=NumberUtil.getBigDecimal(g.get("planInnerUserAt"),zero);
		BigDecimal planOutUserAt=NumberUtil.getBigDecimal(g.get("planOutUserAt"),zero); 
		BigDecimal planNouserAt=NumberUtil.getBigDecimal(g.get("planNouserAt"),zero); 
		BigDecimal planTotalCost=NumberUtil.getBigDecimal(g.get("planTotalCost"),zero);

		if(addPhaseBudgetInnerUserAt.add(phaseBudgetInnerUserAt).compareTo(planInnerUserAt)>0) {
			tips.setFailureMsg("内部人力预算超出项目内部人力预算"+addPhaseBudgetInnerUserAt.add(phaseBudgetInnerUserAt).subtract(planInnerUserAt)+"元");
			return tips;
		}
		if(addPhaseBudgetOutUserAt.add(phaseBudgetOutUserAt).compareTo(planOutUserAt)>0) {
			tips.setFailureMsg("外部人力预算超出项目外部人力预算"+addPhaseBudgetOutUserAt.add(phaseBudgetOutUserAt).subtract(planOutUserAt)+"元");
			return tips;
		}		
		if(addPhaseBudgetNouserAt.add(phaseBudgetNouserAt).compareTo(planNouserAt)>0) {
			tips.setFailureMsg("非人力预算超出项目非人力预算"+addPhaseBudgetNouserAt.add(phaseBudgetNouserAt).subtract(planNouserAt)+"元");
			return tips;
		}
		
		BigDecimal phaseBudgetCostAt=phaseBudgetCost.add(phaseBudgetInnerUserAt).add(phaseBudgetOutUserAt).add(phaseBudgetNouserAt);  
		phaseBudgetCostAt=phaseBudgetCostAt.add(addPhaseBudgetCost);
		if(phaseBudgetCostAt.compareTo(planTotalCost)>0) {
			tips.setFailureMsg("阶段计划总体预算超出项目总预算"+phaseBudgetCostAt.subtract(planTotalCost)+"元");
			return tips;
		}else {
			return tips;
		} 
		
	}
	
	public XmProjectPhase autoCalcWorkload(XmProjectPhase phase) {
		BigDecimal phaseBudgetHours=NumberUtil.getBigDecimal(phase.getPhaseBudgetHours(),BigDecimal.ZERO);
		BigDecimal phaseBudgetInnerUserCnt=NumberUtil.getBigDecimal(phase.getPhaseBudgetInnerUserCnt(),BigDecimal.ZERO);
		BigDecimal phaseBudgetOutUserCnt=NumberUtil.getBigDecimal(phase.getPhaseBudgetOutUserCnt(),BigDecimal.ZERO);
		phase.setPhaseBudgetInnerUserWorkload(phaseBudgetInnerUserCnt.multiply(phaseBudgetHours));
		phase.setPhaseBudgetOutUserWorkload(phaseBudgetOutUserCnt.multiply(phaseBudgetHours));
		phase.setPhaseBudgetWorkload(phase.getPhaseBudgetInnerUserWorkload().add(phase.getPhaseBudgetOutUserWorkload()));
		return phase;
		
	} 
	/**
	 * 计算bug、task、测试案例、等数据
	 * @param projectId
	 * @return
	 */
	public int loadTasksToXmProjectPhase(String projectId) {
		 
		return this.update("loadTasksToXmProjectPhase", projectId);
	}
	public Long checkExistsTask(String phaseId) {
		Long i= this.selectOne("checkExistsTask", phaseId);
		return i;
	}
	
	public Long checkExistsChildren(String phaseId) {
		Long i= this.selectOne("checkExistsChildren", phaseId);
		return i;
	}

	@Transactional
	public void batchInsertOrUpdate(List<XmProjectPhaseVo> xmProjectPhases) {
		List<XmProjectPhaseVo> addList=new ArrayList<>();
		List<XmProjectPhaseVo> editList=new ArrayList<>();
		for (XmProjectPhaseVo vo : xmProjectPhases) {
			if("addSub".equals(vo.getOpType())||"add".equals(vo.getOpType())) {
				addList.add(vo);
			}else {
				editList.add(vo);
			}
		}
		if(addList.size()>0) {
			this.batchInsert(addList);
		}
		if(editList.size()>0) {
			this.batchUpdate(editList);
		}
	}
	
}

