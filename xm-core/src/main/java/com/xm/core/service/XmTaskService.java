package com.xm.core.service;

import com.alibaba.fastjson.JSONObject;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.service.BaseService;
import com.mdp.core.utils.BaseUtils;
import com.mdp.core.utils.DateUtils;
import com.mdp.core.utils.NumberUtil;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmMenu;
import com.xm.core.entity.XmTask;
import com.xm.core.entity.XmTaskSkill;
import com.xm.core.queue.XmTaskSumParentsPushService;
import com.xm.core.vo.BatchRelTasksWithMenu;
import com.xm.core.vo.BatchRelTasksWithPhase;
import com.xm.core.vo.XmGroupVo;
import com.xm.core.vo.XmTaskVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmTask 表 XM.xm_task 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmTaskService")
public class XmTaskService extends BaseService {
	
	final String TYPE = "任务";

	@Autowired
	XmTaskExecuserService xmTaskExecuserService;
	
	@Autowired
	XmAttachmentService xmAttachmentService;
	
	@Autowired
    XmExchangeService xmExchangeService;
	
	@Autowired
	XmRecordService xmRecordService;
	
	@Autowired
    XmTaskSkillService xmTaskSkillService;

	@Autowired
	XmTaskSumParentsPushService pushService;


	@Autowired
	XmGroupService groupService;

	@Transactional
	public   int[] doBatchDelete(List<XmTask> batchValues) {
		int[] i2= super.batchDelete(batchValues);
		pushService.pushXmTasks(batchValues);
		return i2;
	}

	public Map<String,Object> selectTotalPhaseAndTaskBudgetCost(String phaseId, List<String> excludeTaskIds){
		Map<String,Object> p=new HashMap<>();
		p.put("phaseId", phaseId); 
		p.put("excludeTaskIds", excludeTaskIds);
		return this.selectOne("selectTotalPhaseAndTaskBudgetCost", p);
	} 
	

	/**
	 * 判断新增预算是否超出项目总预算
	 * @param addTaskBudgetCost
	 * @return
	 */
	public Tips judgetPhaseBudget(String phaseId, BigDecimal addTaskBudgetCost, BigDecimal addTaskBudgetIuserAt, BigDecimal addTaskBudgetOuserAt, BigDecimal addTaskBudgetNouserAt, List<String> excludeTaskIds){
		Tips tips=new Tips("成功");
		if(!StringUtils.hasText(phaseId)){
			tips.setFailureMsg("phaseId参数不能为空");
			return tips;
		}
		Map<String,Object> g=this.selectTotalPhaseAndTaskBudgetCost(phaseId,excludeTaskIds);
		if(g==null || g.isEmpty()){
			return tips;
		}
		BigDecimal phaseBudgetCost=BigDecimal.ZERO;
		BigDecimal zero=BigDecimal.ZERO;
		
		if(addTaskBudgetCost==null) {
			addTaskBudgetCost=BigDecimal.ZERO;
		}
		if(addTaskBudgetIuserAt==null) {
			addTaskBudgetIuserAt=BigDecimal.ZERO;
		}
		if(addTaskBudgetOuserAt==null) {
			addTaskBudgetOuserAt=BigDecimal.ZERO;
		}
		if(addTaskBudgetNouserAt==null) {
			addTaskBudgetNouserAt=BigDecimal.ZERO;
		}
		BigDecimal phaseBudgetAt=NumberUtil.getBigDecimal(g.get("phaseBudgetAt"),zero);
		BigDecimal phaseBudgetIuserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetIuserAt"),zero);
		BigDecimal phaseBudgetOuserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetOuserAt"),zero); 
		BigDecimal phaseBudgetNouserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetNouserAt"),zero); 
		
		BigDecimal taskBudgetIuserAt=NumberUtil.getBigDecimal(g.get("taskBudgetIuserAt"),zero);
		BigDecimal taskBudgetOuserAt=NumberUtil.getBigDecimal(g.get("taskBudgetOuserAt"),zero); 
		BigDecimal taskBudgetNouserAt=NumberUtil.getBigDecimal(g.get("taskBudgetNouserAt"),zero); 
		BigDecimal taskBudgetTotalCost=NumberUtil.getBigDecimal(g.get("budgetCost"),zero);  
		
		/**
		if(addTaskBudgetIuserAt.add(taskBudgetIuserAt).compareTo(phaseBudgetIuserAt)>0) {
			tips.setFailureMsg("内部人力预算超出项目内部人力预算");
			return tips;
		}
		if(addTaskBudgetOuserAt.add(taskBudgetOuserAt).compareTo(phaseBudgetOuserAt)>0) {
			tips.setFailureMsg("外部人力预算超出项目外部人力预算");
			return tips;
		}		
		if(addTaskBudgetNouserAt.add(taskBudgetNouserAt).compareTo(phaseBudgetNouserAt)>0) {
			tips.setFailureMsg("非人力预算超出项目非人力预算");
			return tips;
		}
		**/
		BigDecimal totalTaskBudgetAt=taskBudgetTotalCost.add(addTaskBudgetCost);
		if(phaseBudgetAt.compareTo(totalTaskBudgetAt)<0) {
			tips.setFailureMsg("任务合计总预算超出计划总预算"+totalTaskBudgetAt.subtract(phaseBudgetAt)+"元");
			return tips;
		}else {
			return tips;
		} 
		
	}
	/**
	 *
	 *
	 ifnull(p.budget_cost,0) as budget_cost,
	 ifnull(p.budget_workload,0) as budget_workload,
	 sum( ifnull(res.budget_cost,0) ) AS child_budget_cost,
	 sum( ifnull(res.budget_workload,0) ) AS child_budget_workload
	 * 判断新增预算是否超出项目总预算
	 * @param addTaskBudgetCost
	 * @return
	 */
	public Tips judgetTaskBudget(String parentTaskid, BigDecimal addTaskBudgetCost, BigDecimal addTaskBudgetIuserAt, BigDecimal addTaskBudgetOuserAt, BigDecimal addTaskBudgetNouserAt, List<String> excludeTaskIds){
		Tips tips=new Tips("成功");
		if(!StringUtils.hasText(parentTaskid)){
			tips.setFailureMsg("parentTaskid参数不能为空");
			return tips;
		}
		Map<String,Object> g=this.selectTotalTaskBudgetCost(parentTaskid,excludeTaskIds);
		if(g==null || g.isEmpty()){
			return tips;
		}

		BigDecimal budgetCost=NumberUtil.getBigDecimal(g.get("budgetCost"),BigDecimal.ZERO);
		BigDecimal childBudgetCost=NumberUtil.getBigDecimal(g.get("childBudgetCost"),BigDecimal.ZERO);
		childBudgetCost=childBudgetCost.add(addTaskBudgetCost);
		if(budgetCost.compareTo(childBudgetCost)<0) {
			tips.setFailureMsg("任务合计总预算超出上级总预算"+childBudgetCost.subtract(budgetCost)+"元");
			return tips;
		}else {
			return tips;
		}

	}

	private Map<String, Object> selectTotalTaskBudgetCost(String parentTaskid, List<String> excludeTaskIds) {
		return selectOne("selectTotalTaskBudgetCost",map("parentTaskid",parentTaskid,"excludeTaskIds",excludeTaskIds));
	}

	public void updateTaskChildrenCntByTaskId(String taskId){
		super.update("updateTaskChildrenCntByTaskId",taskId);
	}

	public List<Map<String,Object>> getTask(Map<String,Object> xmTask){  
		List<Map<String,Object>> mapList = this.selectListMapByWhere(xmTask);//所有数据 
		return mapList;
	}
	@Transactional
	public XmTaskVo addTask(XmTaskVo xmTaskVo){
		Tips tips = new Tips();

		User user = LoginUtils.getCurrentUserInfo();
		xmTaskVo.setCreateUserid(user.getUserid());
		xmTaskVo.setCreateUsername(user.getUsername());
		xmTaskVo.setCreateTime(new Date());
		xmTaskVo.setRate(0);
		xmTaskVo.setSortLevel(xmTaskVo.getSortLevel());
		if(StringUtils.isEmpty(xmTaskVo.getMilestone())){
			xmTaskVo.setMilestone("0");
		}
		XmTask xmTask = new XmTask();
		BeanUtils.copyProperties(xmTaskVo,xmTask);
		this.insert(xmTask);
		if(StringUtils.hasText(xmTask.getParentTaskid())){
			pushService.pushXmTask(xmTask);
		}
		//新增/更新附件
		//xmAttachmentService.insertOrUpdate(xmTaskVo.getId(),TYPE,xmTaskVo.getAttachment());
		
//		新增任务技能
//		xmTaskSkillService.addSkill(xmTaskVo.getSkill());
		xmTaskExecuserService.updateXmTaskExeUseridsAndUsernamesByTaskId(xmTaskVo.getId());
		
		xmTaskSkillService.updateXmTaskSkillIdsAndNamesByTaskId(xmTaskVo.getId());
		
		//新增日志
		xmRecordService.addXmTaskRecord(xmTask.getProjectId(), xmTask.getId(), "项目-任务-新增任务", "新增任务"+xmTask.getName()); 
		
		return xmTaskVo;
	}
	/**
	 * 有执行人，有子任务都不允许删除
	 * @param xmTask
	 */
	@Transactional
	public void deleteTask(XmTask xmTask) {
		this.deleteByPk(xmTask);
		if(StringUtils.hasText(xmTask.getParentTaskid())){
			pushService.pushXmTask(xmTask);
		}
	}
	@Transactional
	public void updateTask(XmTaskVo xmTaskVo,XmTask xmTaskDb) {
		XmTask xmTask = new XmTask();
		BeanUtils.copyProperties(xmTaskVo,xmTask);
		xmTask.setSortLevel(xmTaskVo.getSortLevel());
		if(StringUtils.isEmpty(xmTask.getMilestone())){
			xmTask.setMilestone("0");
		}
		xmTask.setLtime(new Date());
		this.updateSomeFieldByPk(xmTask);
		if(StringUtils.hasText(xmTaskDb.getParentTaskid())){
			pushService.pushXmTask(xmTaskDb);
		}
		xmRecordService.addXmTaskRecord(xmTask.getProjectId(), xmTask.getId(), "项目-任务-更新任务基础信息", "更新任务"+xmTask.getName(),JSONObject.toJSONString(xmTask),null);  
	}

	@Transactional
	public void updateTime(XmTask xmTask,XmTask xmTaskDb) {
		//XmTask oldValue = this.selectOneObject(new XmTask(xmTask.getId()));
		XmTask xmTask2=new XmTask();
		xmTask2.setId(xmTask.getId());
		xmTask2.setStartTime(xmTask.getStartTime());
		xmTask2.setEndTime(xmTask.getEndTime());
		xmTask2.setActStartTime(xmTask.getActStartTime());
		xmTask2.setActEndTime(xmTask.getActEndTime());
		this.updateSomeFieldByPk(xmTask);
		if(StringUtils.hasText(xmTaskDb.getParentTaskid())){
			pushService.pushXmTask(xmTaskDb);
		}
		//更新父任务的进度
		//updateParentProgress(xmTask.getParentTaskid());
		xmRecordService.addXmTaskRecord(xmTask.getProjectId(), xmTask.getId(), "项目-任务-计划", "更新任务计划开始时间为"+
				DateUtils.format(xmTask.getStartTime(),"yyyy-MM-dd")+",计划结束时间为"+DateUtils.format(xmTask.getEndTime(),"yyyy-MM-dd")+
				"实际开始时间:"+DateUtils.format(xmTask.getActStartTime(),"yyyy-MM-dd")+",实际结束时间为"+DateUtils.format(xmTask.getActEndTime(),"yyyy-MM-dd"));
	}
	@Transactional
	public void updateProgress(XmTask xmTask,XmTask xmTaskDb) {
		//XmTask oldValue = this.selectOneObject(new XmTask(xmTask.getId()));
		XmTask xmTask2=new XmTask();
		xmTask2.setId(xmTask.getId());
		xmTask2.setRate(xmTask.getRate());
		if(xmTaskDb.getBudgetWorkload()==null){
			xmTaskDb.setBudgetWorkload(BigDecimal.ZERO);
		}
		xmTask2.setActWorkload(xmTaskDb.getBudgetWorkload().multiply(BigDecimal.valueOf(xmTask.getRate())).divide(BigDecimal.valueOf(100)));
		this.updateSomeFieldByPk(xmTask);

		if(StringUtils.hasText(xmTaskDb.getParentTaskid())){
			pushService.pushXmTask(xmTaskDb);
		}
		//更新父任务的进度
		//updateParentProgress(xmTask.getParentTaskid());
		xmRecordService.addXmTaskRecord(xmTask.getProjectId(), xmTask.getId(), "项目-任务-进度", "更新任务进度为"+xmTask2.getRate());   
	}
	public Map<String,XmTask> selectTasksMapByTasks(List<XmTask> xmTasks){
		List<String> ids=new ArrayList<>();
		for (XmTask xmTask : xmTasks) {
			ids.add(xmTask.getId());
		}
		List<XmTask> tasks= this.selectTaskListByIds(ids);
		Map<String,XmTask> map=new HashMap<>();
		for (XmTask task : tasks) {
			map.put(task.getId(),task);
		}
		return map;
	}
	public List<XmTask> selectTaskListByTasks(List<XmTask> xmTasks){
		List<String> ids=new ArrayList<>();
		for (XmTask xmTask : xmTasks) {
			ids.add(xmTask.getId());
		}
		return this.selectTaskListByIds(ids);
	}
	public List<XmTask> selectTaskListByIds(List<String> ids){
		return super.selectList("selectTaskListByIds",map("ids",ids));
	}


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
	@Transactional
	public void processApprova(Map<String, Object> flowVars) {
		String eventName=(String) flowVars.get("eventName");
		String agree=(String) flowVars.get("agree");
		String bizKey=(String) flowVars.get("bizKey");
		XmTask bizXmTask=null;
		if("xm_task_approva".equals(bizKey) ) {
			if(!flowVars.containsKey("data")) {
				throw new BizException("缺乏任务信息，请将任务信息放在flowVars.data中");
			}
			bizXmTask= BaseUtils.fromMap((Map)flowVars.get("data"), XmTask.class);
			flowVars.put("xmTaskId", bizXmTask.getId());
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
				bizQuery.put("id", bizXmTask.getId());
				if(StringUtils.isEmpty(bizXmTask.getId())) {
					throw new BizException("请上送任务编号flowVars.data.id");
				}
				List<Map<String,Object>> bizList=this.selectListMapByWhere(bizQuery);
				if(bizList==null || bizList.size()==0) {
					throw new BizException("没有找到对应项目任务单,项目任务单为【"+bizXmTask.getId()+"】");
				}else {
					Map<String,Object> bizObject=bizList.get(0);
					if("1".equals(bizObject.get("bizFlowState"))) {
						throw new BizException("该项目任务单正在审批中，不能再发起审批");
					}
				}
				flowVars.put("id", this.createKey("id"));
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
	@Transactional
	public void updateFlowStateByProcInst(String flowState,Map<String, Object> flowVars) {
		if(StringUtils.hasText((String) flowVars.get("xmTaskId"))){
			XmTask xmTask=new XmTask();
			xmTask.setId((String) flowVars.get("taskId"));
			xmTask.setBizFlowState(flowState);
			xmTask.setBizProcInstId((String) flowVars.get("procInstId"));
			this.updateSomeFieldByPk(xmTask);
		}
	}
	@Transactional
	public void batchImportFromTemplate(List<XmTask> xmTasks) {
		this.batchInsert(xmTasks);
		this.pushService.pushXmTasks(xmTasks);
		
	}
	
	/**
	 * 批量更新任务的需求为新的需求或者更新为空
	 * @param tasksWithMenu
	 */
	@Transactional
	public void batchRelTasksWithMenu(BatchRelTasksWithMenu tasksWithMenu,XmMenu xmMenuDb) {
		Map<String,Object> map=map("menuId",tasksWithMenu.getMenuId(),"menuName",xmMenuDb.getMenuName(),"productId",xmMenuDb.getProductId(),"taskIds",tasksWithMenu.getTaskIds());
		 super.update("batchRelTasksWithMenu",map);
	}

	@Transactional
	public void batchInsertOrUpdate(List<XmTask> insertXmTasks,List<XmTask> editXmTasks) {
		List<XmTask> all=new ArrayList<>();
		if(insertXmTasks!=null && insertXmTasks.size()>0) {
			this.batchInsert(insertXmTasks);
			all.addAll(insertXmTasks);
		}
		if(editXmTasks!=null && editXmTasks.size()>0) {
			this.batchUpdate(editXmTasks);
			all.addAll(editXmTasks);
		}
		if(all.size()>0){
			this.pushService.pushXmTasks(all);
		}
	}

	public Map<String,Object> shareTaskDetail(Map<String, Object> xmTask) {
		return this.selectOne("shareTaskDetail",xmTask);
	}

	public void updateChildrenCntByIds(List<String> ids) {
		super.update("updateChildrenCntByIds",ids);
	}


	public List<XmTask> parentIdPathsCalcBeforeSave(List<XmTask> nodes) {
		List<XmTask> noExistsList=nodes.stream().filter(i->!nodes.stream().filter(k->k.getId().equals(i.getParentTaskid())).findAny().isPresent()).collect(Collectors.toList());
		noExistsList=noExistsList.stream().filter(i->StringUtils.hasText(i.getParentTaskid())).collect(Collectors.toList());
		Map<String,String> hadCalcMap=new HashMap<>();
		for (XmTask node : noExistsList) {
			if(hadCalcMap.containsKey(node.getParentTaskid())){
				String idPaths=hadCalcMap.get(node.getParentTaskid());
				node.setPidPaths(idPaths+node.getId()+",");
			}else{
				this.parentIdPathsCalcBeforeSave(node);
				String idPaths=node.getPidPaths();
				idPaths=idPaths.substring(0,idPaths.length()-node.getId().length()-1);
				hadCalcMap.put(node.getParentTaskid(),idPaths);
			}
		}
		for (XmTask node : nodes) {
			if(!StringUtils.hasText(node.getParentTaskid())){
				node.setPidPaths("0,"+node.getId()+",");
				continue;
			}
			if(hadCalcMap.containsKey(node.getParentTaskid())){
				String idPaths=hadCalcMap.get(node.getParentTaskid());
				node.setPidPaths(idPaths+node.getId()+",");
			}else{
				List<XmTask> pnodeList=this.getParentList(node,nodes);
				if(pnodeList==null ||pnodeList.size()==0){
					node.setPidPaths("0,"+node.getParentTaskid()+","+node.getId()+",");
					continue;
				}
				XmTask topParent=pnodeList.get(pnodeList.size()-1);
				String idPath="0,";
				if(hadCalcMap.containsKey(topParent.getParentTaskid())){
					idPath=hadCalcMap.get(topParent.getParentTaskid());
				}
				for (int i = pnodeList.size() - 1; i >= 0; i--) {
					idPath=idPath+pnodeList.get(i).getId()+",";
				}
				node.setPidPaths(idPath+node.getId()+",");
			}
		}
		for (XmTask node : nodes) {
			String idPaths=node.getPidPaths();
			String[] idpss=idPaths.split(",");
			node.setLvl(idpss.length-1);
		}
		return nodes;
	}

	public static void main(String[] args) {
		String idpaths="0,1,2,3,";
		String[] idpss=idpaths.split(",");
		int lvl=idpss.length;

	}

	public Tips parentIdPathsCalcBeforeSave(XmTask currNode) {
		Tips tips = new Tips("成功");
		if (!StringUtils.hasText(currNode.getParentTaskid()) || "0".equals(currNode.getParentTaskid())) {
			currNode.setPidPaths("0," + currNode.getId() + ",");
			currNode.setLvl(1);
			return tips;
		} else {
			List<XmTask> parentList=this.getParentList(currNode);
			if(parentList==null ||parentList.size()==0){
				currNode.setPidPaths("0,"+currNode.getParentTaskid()+","+currNode.getId()+",");
				currNode.setLvl(2);
				return tips;
			}
			String idPath="0,";
			for (int i = parentList.size() - 1; i >= 0; i--) {
				idPath=idPath+parentList.get(i).getId()+",";
			}
			currNode.setPidPaths(idPath+currNode.getId()+",");

			String idPaths=currNode.getPidPaths();
			String[] idpss=idPaths.split(",");
			currNode.setLvl(idpss.length-1);
		}
		return tips;
	}

	private List<XmTask> getParentList(XmTask currNode){
		List<XmTask> parentList=new ArrayList<>();
		XmTask current=currNode;
		while (true){
			if(!StringUtils.hasText(current.getParentTaskid()) || "0".equals(current.getParentTaskid())){
				return parentList;
			}
			XmTask query=new XmTask();
			query.setId(current.getParentTaskid());
			current=this.selectOneObject(query);
			if(current==null){
				return parentList;
			}
			parentList.add(current);
		}
	}

	private List<XmTask> getParentList(XmTask currNode,List<XmTask> nodes){
		List<XmTask> parentList=new ArrayList<>();
		XmTask current=currNode;
		while (true){
			if(!StringUtils.hasText(current.getParentTaskid()) || "0".equals(current.getParentTaskid())){
				return parentList;
			}
			XmTask query=new XmTask();
			query.setId(current.getParentTaskid());
			Optional<XmTask> optional=nodes.stream().filter(i->i.getId().equals(query.getId())).findFirst();
			if(optional.isPresent()){
				current=optional.get();
				parentList.add(current);
			}else{
				return parentList;
			}

		}
	}


	@Transactional
	public void sumParents(XmTask node){
		String id=node.getId();
		String pidPaths=node.getPidPaths();
		if(!StringUtils.hasText(pidPaths)){
			return;
		}
		if(!pidPaths.startsWith("0,")){
			return;
		}
		if("0".equals(node.getNtype())&&pidPaths.endsWith(id+",")){
			pidPaths=pidPaths.substring(2,pidPaths.indexOf(id));
		}else{
			pidPaths=pidPaths.substring(2);
		}

		if(!StringUtils.hasText(pidPaths)){
			return;
		}
		String[] pidPathss=pidPaths.split(",");
		List<String> pidPathsList=new ArrayList<>();
		for (int i = pidPathss.length-1; i >=0; i--) {
			pidPathsList.add(pidPathss[i]);
		}
		if(pidPathsList.size()>0){
			super.update("sumParents",pidPathsList	);
		}

	}
	@Transactional
	public void batchSumParents(List<XmTask> xmTasks) {
		List<Set<String>> list=new ArrayList<>();
		for (XmTask node : xmTasks) {
			String id=node.getId();
			String pidPaths=node.getPidPaths();
			if(!StringUtils.hasText(pidPaths)){
				continue;
			}
			if(!pidPaths.startsWith("0,")){
				continue;
			}
			if("0".equals(node.getNtype())){
				pidPaths=pidPaths.substring(2,pidPaths.indexOf(id));
			}else{
				pidPaths=pidPaths.substring(2);
			}

			if(!StringUtils.hasText(pidPaths)){
				continue;
			}
			String[] pidPathss=pidPaths.split(",");
			for (int i = 0; i <pidPathss.length; i++) {
				if(list.size()<=i){
					list.add(new HashSet<>());
				}
				Set<String> set=list.get(i);
				set.add(pidPathss[i]);
			}
			if(list.size()<=0){
				return;
			}
			Set<String> allSet=new HashSet<>();
			for (int i = list.size() - 1; i >= 0; i--) {
				Set<String> set=list.get(i);
				if(set.size()>0){
					List<String> ids=set.stream().filter(k->!allSet.contains(k)).collect(Collectors.toList());
					if(ids.size()>0){
						allSet.addAll(ids.stream().collect(Collectors.toSet()));
						super.update("batchSumParents", ids);
					}

				}

			}


		}

	}


	public boolean checkExistsExecuser(XmTask node) {
		if("1".equals(node.getNtype())){
			return false;
		}
		String exec=node.getExeUserids();
		if(!StringUtils.hasText(exec)){
			return false;
		}
		if(exec.indexOf("(1)")>0 || exec.indexOf("(2)")>0|| exec.indexOf("(3)")>0|| exec.indexOf("(4)")>0|| exec.indexOf("(5)")>0){
			return true;
		}
		return false;
	}

	/**
	 * 检查是否能删除干净所有儿子孙子节点。
	 * @param delNode 当前删除节点
	 * @param delNodes 本批量需要删除的全部节点
	 * @return
	 */
	public boolean checkCanDelAllChild(XmTask delNode, List<XmTask> delNodes) {
		if(delNode==null){
			return true;
		}
		if(delNode.getChildrenCnt()==null||delNode.getChildrenCnt()<=0){
			return true;
		}
		List<XmTask> childList=delNodes.stream().filter(i->delNode.getId().equals(i.getParentTaskid())).collect(Collectors.toList());
		if(childList==null||childList.size()<delNode.getChildrenCnt()){
			return false;
		}
		for (XmTask n : childList) {
			if (!this.checkCanDelAllChild(n, delNodes)) {
				return false;
			}
		}
		return true;

	}

	public void batchRelTasksWithPhase(BatchRelTasksWithPhase tasksPhase) {
		super.update("batchRelTasksWithPhase",tasksPhase);
	}

	public Map<String,Object> calcProjectAndTaskBudget(String projectId,List<String> excludeTaskIds){
		Map<String,Object> map=new HashMap<>();
		if(excludeTaskIds!=null){
			map.put("excludeTaskIds",excludeTaskIds);
		}
		map.put("projectId",projectId);
		return super.selectOne("calcProjectAndTaskBudget",map);
	}
	public Tips judgetProjectBudget(String projectId, BigDecimal addBudgetCost, List<String> excludeTaskIds) {
		Tips tips=new Tips("成功");
		Map<String,Object> data=this.calcProjectAndTaskBudget(projectId,excludeTaskIds);
		if(data==null || data.isEmpty()){
			tips.setFailureMsg("项目不存在");
			return tips;
		}
		BigDecimal planTotalCost=NumberUtil.getBigDecimal(map().get("planTotalCost"),BigDecimal.ZERO);
		BigDecimal taskBudgetCost=NumberUtil.getBigDecimal(map().get("budgetCost"),BigDecimal.ZERO);
		BigDecimal chaochu=taskBudgetCost.add(addBudgetCost).subtract(planTotalCost);
		if(chaochu.compareTo(BigDecimal.ZERO)>0){
			tips.setFailureMsg("超出项目总预算"+chaochu+"元");
			return tips;
		}
		return tips;
	}

	public List<XmTask> listTenTaskByProjectIdAndProductId(String projectId,String productId) {

		return super.selectList("listTenTaskByProjectIdAndProductId",map("projectId", projectId, "productId", productId));
	}


	public List<XmTask> listTenTaskByProjectIdAndIterationId(String projectId, String iterationId) {

		return super.selectList("listTenTaskByProjectIdAndIterationId", map("projectId", projectId, "iterationId", iterationId));
	}

	@Transactional
	public void batchChangeParent(List<XmTask> xmTasks,XmTask parentTask) {
		super.update("batchChangeParent",map("taskIds",xmTasks.stream().map(i->i.getId()).collect(Collectors.toList()),"parentTaskid",parentTask.getId(),"parentPidPaths",parentTask.getPidPaths()));
		pushService.pushXmTask(parentTask);
	}

	/**
	 * 结算审批通过后，更新任务表数据
	 * @param taskId
	 */
	public void updateActCostAndActWorkloadAfterSettle(String taskId,String toTaskState) {
		super.update("updateActCostAndActWorkloadAfterSettle",map("id",taskId,"taskState",toTaskState));
	}

	public void calcWorkloadByRecord(String id) {
		if(!StringUtils.hasText(id)){
			return;
		}
		List<String> ids=new ArrayList<>();
		ids.add(id);
		calcWorkloadByRecord(ids);
	}
	public void calcWorkloadByRecord(List<String> ids) {
		if(ids==null || ids.size()<=0){
			return;
		}
		ids=ids.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
		super.update("calcWorkloadByRecord",ids);
	}

	public void batchUpdateBudgetWorkloadAndRate(List<String> ids,BigDecimal budgetWorkload) {
		super.update("batchUpdateBudgetWorkloadAndRate",map("ids",ids,"budgetWorkload",budgetWorkload));
	}

	public List<Map<String, Object>> getXmTaskAttDist(Map<String, Object> xmTask) {
		return super.selectList("getXmTaskAttDist",xmTask);
	}

	public List<Map<String, Object>> getXmTaskAgeDist(Map<String, Object> xmTask) {
		return super.selectList("getXmTaskAgeDist",xmTask);
	}

	public List<Map<String, Object>> getXmTaskSort(Map<String, Object> xmTask) {
		return super.selectList("getXmTaskSort",xmTask);
	}
}

