package com.xm.core.service;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.service.BaseService;
import com.mdp.core.utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectMCostUser 表 XM.xm_project_m_cost_user 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmProjectMCostUserService")
public class XmProjectMCostUserService extends BaseService {
	
	/** 请在此类添加自定义函数 */

	@Autowired
	XmRecordService xmRecordService;

	/**
	 * 流程审批过程中回调该接口，更新业务数据
	 * 如果发起流程时上送了restUrl，则无论流程中是否配置了监听器都会在流程发生以下事件时推送数据过来
	 * eventName: PROCESS_STARTED 流程启动完成 全局
	 *            PROCESS_COMPLETED 流程正常结束 全局
	 *            PROCESS_CANCELLED 流程删除 全局
	 *            create 人工任务启动
	 *            complete 人工任务完成  
	 *            assignment 人工任务分配给了具体的人
	 *            delete 人工任务被删除
	 *            TASK_COMPLETED_FORM_DATA_UPDATE 人工任务提交完成后，智能表单数据更新
	 *            
	 * 其中 create/complete/assignment/delete事件是需要在模型中人工节点上配置了委托代理表达式 ${taskBizCallListener}才会推送过来。
	 * 在人工任务节点上配置 任务监听器  建议事件为 complete,其它assignment/create/complete/delete也可以，一般建议在complete,委托代理表达式 ${taskBizCallListener}
	 * 
	 * @param flowVars {flowBranchId,agree,procInstId,startUserid,assignee,actId,taskName,mainTitle,branchId,bizKey,commentMsg,eventName,modelKey} 等 
	 * @return 如果tips.isOk==false，将影响流程提交
	 **/
	public void processApprova(Map<String, Object> flowVars) { 
		String eventName=(String) flowVars.get("eventName"); 
		String agree=(String) flowVars.get("agree"); 
		String branchId=(String) flowVars.get("branchId"); 
		String costId=(String) flowVars.get("costId");  
		String bizKey=(String) flowVars.get("bizKey");
		if("xm_project_cost_user_approva".equals(bizKey) ) { 
		}else {
			throw new BizException("不支持的业务,请上送业务编码【bizKey】参数");
		}
		if("complete".equals(eventName)) { 
			if("1".equals(agree)) {
				this.updateFlowStateByProcInst("", flowVars);
			}else {
				this.updateFlowStateByProcInst("", flowVars);
			}
		}else {
			if("PROCESS_STARTED".equals(eventName)) {   
				Map<String,Object> bizQuery=new HashMap<>(); 
				bizQuery.put("costId", costId);
				if(StringUtils.isEmpty(costId)) {
					throw new BizException("请上送costId");
				}
				if(StringUtils.isEmpty(branchId)) {
					throw new BizException("请上送branchId");
				} 
				List<Map<String,Object>> bizList=this.selectListMapByWhere(bizQuery);
				if(bizList==null || bizList.size()==0) {
					throw new BizException("没有找到对应成本单,成本单为【"+costId+"】");
				}else {
					Map<String,Object> bizObject=bizList.get(0);
					if("1".equals(bizObject.get("bizFlowState"))) {
						throw new BizException("该成本单正在审批中，不能再发起审批");
					}
				}
				flowVars.put("id", this.createKey("id"));
					this.insert("insertProcessApprova", flowVars);   
					this.updateFlowStateByProcInst("1", flowVars);
			}else if("PROCESS_COMPLETED".equals(eventName)) {
				if("1".equals(agree)) { 
					this.updateFlowStateByProcInst("2", flowVars); 
					
				}else { 
					this.updateFlowStateByProcInst("3", flowVars);
				} 
			}else if("PROCESS_CANCELLED".equals(eventName)) { 
				this.updateFlowStateByProcInst("4", flowVars);
			}
		} 
	}
	
	private void updateFlowStateByProcInstForDeleteSuccess(Map<String, Object> flowVars) {
		this.update("updateFlowStateByProcInstForDeleteSuccess", flowVars);
		
	}

	public void updateFlowStateByProcInst(String flowState,Map<String, Object> flowVars) {
		flowVars.put("flowState", flowState);
		flowVars.put("bizFlowState", flowState);
		if("1".equals(flowState)) {
			flowVars.put("bizProcInstId", flowVars.get("procInstId"));
		}
		this.update("updateProcessApprova", flowVars);
	}
	public List<Map<String,Object>> listSum(Map<String,Object> params){
		return this.selectList("listSum", params);
	}
	public List<Map<String,Object>> listSumForSettleGroupByTaskIdAndUserid(Map<String,Object> params){
		return this.selectList("listSumForSettleGroupByTaskIdAndUserid", params);
	}
	
	/**
	 * 查询项目及计划总预算，用于判断是否超出预算 
	 */
	public Map<String,Object> selectTotalProjectAndUserActCost(String projectId,List<String> excludeIds){
		Map<String,Object> p=new HashMap<>();
		p.put("projectId", projectId); 
		p.put("excludeIds", excludeIds);
		return this.selectOne("selectTotalProjectAndUserActCost", p); 
	}
	
	/**
	 * 判断新增预算是否超出项目总预算
	 * @param projectId
	 * @param addTotalBudgetCost
	 * @return
	 */
	public Tips judgetBudget(String projectId,BigDecimal addTotalBudgetCost,BigDecimal addBudgetCostIuserAt,BigDecimal addBudgetCostOuserAt,List<String> excludeIds){
		Tips tips=new Tips("检查预算成功");
		Map<String,Object> g=this.selectTotalProjectAndUserActCost(projectId,excludeIds);
		BigDecimal totalBudgetCost=BigDecimal.ZERO; 
		BigDecimal zero=BigDecimal.ZERO; 
		
		addTotalBudgetCost=NumberUtil.getBigDecimal(addTotalBudgetCost,zero);  
		addBudgetCostIuserAt=NumberUtil.getBigDecimal(addBudgetCostIuserAt,zero);  
		addBudgetCostOuserAt=NumberUtil.getBigDecimal(addBudgetCostOuserAt,zero); 
		
		BigDecimal actCostUserAmount=NumberUtil.getBigDecimal(g.get("actCostUserAmount"),zero); 
		BigDecimal actCostIuserAmount=NumberUtil.getBigDecimal(g.get("actCostIuserAmount"),zero); 
		BigDecimal actCostOuserAmount=NumberUtil.getBigDecimal(g.get("actCostOuserAmount"),zero); 
		
		
		BigDecimal planIuserAt=NumberUtil.getBigDecimal(g.get("planIuserAt"),zero);
		BigDecimal planOuserAt=NumberUtil.getBigDecimal(g.get("planOuserAt"),zero);  
		BigDecimal planUserAt=totalBudgetCost.add(planIuserAt).add(planOuserAt);  
		
		if(actCostIuserAmount.add(addBudgetCostIuserAt).compareTo(planIuserAt)>0) {
			tips.setFailureMsg("内部人力总支出超出项目内部人力预算");
			return tips;
		}
		if(actCostOuserAmount.add(addBudgetCostOuserAt).compareTo(planOuserAt)>0) {
			tips.setFailureMsg("外购人力总支出超出项目总外购人力预算");
			return tips;
		}
		
		BigDecimal actCostUserAmountUser = actCostUserAmount.add(addTotalBudgetCost);
		if(actCostUserAmountUser.compareTo(planUserAt)>0) {
			tips.setFailureMsg("人力总支出已超出项目总人力预算");
			return tips;
		}else {
			return tips;
		} 
		
	}

	public int updateExecuserStatusByExecuserProcInstId(String execuserProcInstId,String execuserStatus) {
			Map<String,Object> m=new HashMap<>();
			m.put("execuserProcInstId", execuserProcInstId);
			m.put("execuserStatus", execuserStatus);
		 return this.update("updateExecuserStatusByExecuserProcInstId", m);
	}
	
	public int deleteByExecuserProcInstId(String execuserProcInstId) {
		Map<String,Object> m=new HashMap<>();
		m.put("execuserProcInstId", execuserProcInstId);
	 return this.update("deleteByExecuserProcInstId", m);
	}
}

