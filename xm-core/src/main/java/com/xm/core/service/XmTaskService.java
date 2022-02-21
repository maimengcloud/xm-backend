package com.xm.core.service;

import com.alibaba.fastjson.JSONObject;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.service.BaseService;
import com.mdp.core.utils.BaseUtils;
import com.mdp.core.utils.DateUtils;
import com.mdp.core.utils.NumberUtil;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmMenu;
import com.xm.core.entity.XmTask;
import com.xm.core.entity.XmTaskSkill;
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

	@Transactional
	public   int[] doBatchDelete(List<XmTask> batchValues) {
		int[] i2= super.batchDelete(batchValues);
		List<XmTask> list= batchValues.stream().filter(i->!batchValues.stream().filter(k->k.getId().equals(i.getParentTaskid())).findAny().isPresent()).collect(Collectors.toList());
		list=list.stream().filter(i->StringUtils.hasText(i.getParentTaskid())).collect(Collectors.toList());
		if(list.size()>0){
			this.updateChildrenCntByIds(list.stream().map(i->i.getParentTaskid()).collect(Collectors.toSet()).stream().collect(Collectors.toList()));
		}
		return i2;
	}

	public Map<String,Object> selectTotalPhaseAndTaskBudgetCost(String projectPhaseId, List<String> excludeTaskIds){
		Map<String,Object> p=new HashMap<>();
		p.put("projectPhaseId", projectPhaseId); 
		p.put("excludeTaskIds", excludeTaskIds);
		return this.selectOne("selectTotalPhaseAndTaskBudgetCost", p);
	} 
	/**
	 * 判断新增预算是否超出项目总预算
	 * @param addTaskBudgetCost
	 * @return
	 */
	public Tips judgetBudget(String projectPhaseId,BigDecimal addTaskBudgetCost,BigDecimal addTaskBudgetInnerUserAt,BigDecimal addTaskBudgetOutUserAt,BigDecimal addTaskBudgetNouserAt,List<String> excludeTaskIds){
		Tips tips=new Tips("检查预算成功");
		if(!StringUtils.hasText(projectPhaseId)){
			tips.setFailureMsg("projectPhaseId参数不能为空");
			return tips;
		}
		Map<String,Object> g=this.selectTotalPhaseAndTaskBudgetCost(projectPhaseId,excludeTaskIds);
		if(g==null || g.isEmpty()){
			return tips;
		}
		BigDecimal phaseBudgetCost=BigDecimal.ZERO;
		BigDecimal zero=BigDecimal.ZERO;
		
		if(addTaskBudgetCost==null) {
			addTaskBudgetCost=BigDecimal.ZERO;
		}
		if(addTaskBudgetInnerUserAt==null) {
			addTaskBudgetInnerUserAt=BigDecimal.ZERO;
		}
		if(addTaskBudgetOutUserAt==null) {
			addTaskBudgetOutUserAt=BigDecimal.ZERO;
		}
		if(addTaskBudgetNouserAt==null) {
			addTaskBudgetNouserAt=BigDecimal.ZERO;
		} 
		BigDecimal phaseBudgetInnerUserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetInnerUserAt"),zero);
		BigDecimal phaseBudgetOutUserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetOutUserAt"),zero); 
		BigDecimal phaseBudgetNouserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetNouserAt"),zero); 
		
		BigDecimal taskBudgetInnerUserAt=NumberUtil.getBigDecimal(g.get("taskBudgetInnerUserAt"),zero);
		BigDecimal taskBudgetOutUserAt=NumberUtil.getBigDecimal(g.get("taskBudgetOutUserAt"),zero); 
		BigDecimal taskBudgetNouserAt=NumberUtil.getBigDecimal(g.get("taskBudgetNouserAt"),zero); 
		BigDecimal taskBudgetTotalCost=NumberUtil.getBigDecimal(g.get("budgetCost"),zero);  
		
		
		if(addTaskBudgetInnerUserAt.add(taskBudgetInnerUserAt).compareTo(phaseBudgetInnerUserAt)>0) {
			tips.setFailureMsg("内部人力预算超出项目内部人力预算");
			return tips;
		}
		if(addTaskBudgetOutUserAt.add(taskBudgetOutUserAt).compareTo(phaseBudgetOutUserAt)>0) {
			tips.setFailureMsg("外部人力预算超出项目外部人力预算");
			return tips;
		}		
		if(addTaskBudgetNouserAt.add(taskBudgetNouserAt).compareTo(phaseBudgetNouserAt)>0) {
			tips.setFailureMsg("非人力预算超出项目非人力预算");
			return tips;
		}
		
		BigDecimal phaseBudgetCostAt=phaseBudgetCost.add(phaseBudgetInnerUserAt).add(phaseBudgetOutUserAt).add(phaseBudgetNouserAt);  
		if(phaseBudgetCostAt.compareTo(taskBudgetTotalCost)<0) {
			tips.setFailureMsg("任务合计总预算超出计划总预算");
			return tips;
		}else {
			return tips;
		} 
		
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
		if(StringUtils.isEmpty(xmTaskVo.getId())) {
			xmTaskVo.setId(this.createKey("id"));
		}else{
			XmTask xmTaskQuery = new  XmTask(xmTaskVo.getId());
			if(this.countByWhere(xmTaskQuery)>0){
				tips.setFailureMsg("编号重复，请修改编号再提交");
				throw new BizException(tips);
			}
		}
		User user = LoginUtils.getCurrentUserInfo();
		xmTaskVo.setCreateUserid(user.getUserid());
		xmTaskVo.setCreateUsername(user.getUsername());
		xmTaskVo.setCreateTime(new Date());
		xmTaskVo.setRate(BigDecimal.ZERO);
		xmTaskVo.setSortLevel(xmTaskVo.getSortLevel());
		if(StringUtils.isEmpty(xmTaskVo.getMilestone())){
			xmTaskVo.setMilestone("0");
		}
		this.parentIdPathsCalcBeforeSave(xmTaskVo);
		XmTask xmTask = new XmTask();
		BeanUtils.copyProperties(xmTaskVo,xmTask);
		this.insert(xmTask);

		if(StringUtils.hasText(xmTask.getParentTaskid())){
			this.updateTaskChildrenCntByTaskId(xmTask.getParentTaskid());
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
	 * 检查该任务是否有子任务，有不允许删除
	 * @param taskId
	 * @return
	 */
	public boolean checkExistsChildren(String taskId) {
		Long i=this.selectOne("checkExistsChildren", taskId);
		return i>0;
	}
	/**
	 * 有执行人，有子任务都不允许删除
	 * @param xmTask
	 */
	@Transactional
	public void deleteTask(XmTask xmTask) {
		this.deleteByPk(xmTask);
		if(StringUtils.hasText(xmTask.getParentTaskid())){
			this.updateTaskChildrenCntByTaskId(xmTask.getParentTaskid());
		}
		this.sumParents(xmTask);
	}
	
	private Long checkExistsExecuser(String taskId) {
		Long i= this.selectOne("checkExistsExecuser", taskId);
		return i;
	}
	@Transactional
	public void updateTask(XmTaskVo xmTaskVo) { 
		XmTask xmTask = new XmTask();
		BeanUtils.copyProperties(xmTaskVo,xmTask);
		xmTask.setSortLevel(xmTaskVo.getSortLevel());
		if(StringUtils.isEmpty(xmTask.getMilestone())){
			xmTask.setMilestone("0");
		}
		this.updateSomeFieldByPk(xmTask);  
		xmRecordService.addXmTaskRecord(xmTask.getProjectId(), xmTask.getId(), "项目-任务-更新任务基础信息", "更新任务"+xmTask.getName(),JSONObject.toJSONString(xmTask),null);  
	}

	@Transactional
	public void updateTime(XmTask xmTask) {
		//XmTask oldValue = this.selectOneObject(new XmTask(xmTask.getId()));
		XmTask xmTask2=new XmTask();
		xmTask2.setId(xmTask.getId());
		xmTask2.setStartTime(xmTask.getStartTime());
		xmTask2.setEndTime(xmTask.getEndTime());
		xmTask2.setActStartTime(xmTask.getActStartTime());
		xmTask2.setActEndTime(xmTask.getActEndTime());
		this.updateSomeFieldByPk(xmTask);

		//更新父任务的进度
		//updateParentProgress(xmTask.getParentTaskid());
		xmRecordService.addXmTaskRecord(xmTask.getProjectId(), xmTask.getId(), "项目-任务-计划", "更新任务计划开始时间为"+
				DateUtils.format(xmTask.getStartTime(),"yyyy-MM-dd")+",计划结束时间为"+DateUtils.format(xmTask.getEndTime(),"yyyy-MM-dd")+
				"实际开始时间:"+DateUtils.format(xmTask.getActStartTime(),"yyyy-MM-dd")+",实际结束时间为"+DateUtils.format(xmTask.getActEndTime(),"yyyy-MM-dd"));
	}
	@Transactional
	public void updateProgress(XmTask xmTask) {
		//XmTask oldValue = this.selectOneObject(new XmTask(xmTask.getId()));
		XmTask xmTask2=new XmTask();
		xmTask2.setId(xmTask.getId());
		xmTask2.setRate(xmTask.getRate());
		this.updateSomeFieldByPk(xmTask);
		
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
	@Transactional
	private void updateFlowStateByProcInstForDeleteSuccess(Map<String, Object> flowVars) {
		this.update("updateFlowStateByProcInstForDeleteSuccess", flowVars);
		
	}
	@Transactional
	public void updateFlowStateByProcInst(String flowState,Map<String, Object> flowVars) {
		flowVars.put("flowState", flowState);
		flowVars.put("bizFlowState", flowState);
		if("1".equals(flowState)) {
			flowVars.put("bizProcInstId", flowVars.get("procInstId"));
		}
		this.update("updateProcessApprova", flowVars);
	}
	@Transactional
	public void batchImportFromTemplate(List<XmTask> xmTasks) {
		this.batchInsert(xmTasks);
		List<XmTask> list= xmTasks.stream().filter(i->!xmTasks.stream().filter(k->k.getId().equals(i.getParentTaskid())).findAny().isPresent()).collect(Collectors.toList());
		list=list.stream().filter(i->StringUtils.hasText(i.getParentTaskid())).collect(Collectors.toList());
		if(list.size()>0){
			this.updateChildrenCntByIds(list.stream().map(i->i.getParentTaskid()).collect(Collectors.toSet()).stream().collect(Collectors.toList()));
		}
		
	}
	
	/**
	 * 批量更新任务的需求为新的需求或者更新为空
	 * @param xmTasks
	 */
	@Transactional
	public void batchRelTasksWithMenu(List<XmTask> xmTasks) {
		for (XmTask xmTask : xmTasks) {
			this.update("relTaskWithMenu", xmTask);
		}
	}

	@Transactional
	public void batchInsertOrUpdate(List<XmTask> insertXmTasks,List<XmTask> editXmTasks) {
		if(insertXmTasks!=null && insertXmTasks.size()>0) {
			this.batchInsert(insertXmTasks);
			List<XmTask> list= insertXmTasks.stream().filter(i->!insertXmTasks.stream().filter(k->k.getId().equals(i.getParentTaskid())).findAny().isPresent()).collect(Collectors.toList());
			list=list.stream().filter(i->StringUtils.hasText(i.getParentTaskid())).collect(Collectors.toList());
			if(list.size()>0){
				this.updateChildrenCntByIds(list.stream().map(i->i.getParentTaskid()).collect(Collectors.toSet()).stream().collect(Collectors.toList()));
			}

		}
		if(editXmTasks!=null && editXmTasks.size()>0) {
			this.batchUpdate(editXmTasks);
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
			Set<String> allSet=new HashSet<>();
			for (int i = list.size() - 1; i >= 0; i--) {
				allSet.addAll(list.get(i));
			}
			if(allSet.size()>0){
				super.update("sumParents",allSet.stream().collect(Collectors.toList()));
			}


		}

	}


	public boolean checkExistsExecuser(XmTask node) {
		String exec=node.getExeUserids();
		if(!StringUtils.hasText(exec)){
			return false;
		}
		if(exec.indexOf("(1)")>0 || exec.indexOf("(2)")>0|| exec.indexOf("(3)")>0|| exec.indexOf("(4)")>0|| exec.indexOf("(5)")>0){
			return false;
		}
		return true;
	}
}

