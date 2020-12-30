package com.qqkj.xm.core.ctrl;

import java.math.BigDecimal;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.qqkj.mdp.qx.HasQx;
import com.qqkj.xm.core.vo.XmProjectGroupVo;
import com.qqkj.xm.core.vo.XmTaskVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.qqkj.mdp.mybatis.PageUtils;
import com.qqkj.mdp.safe.common.entity.User;
import com.qqkj.mdp.safe.common.utils.LoginUtils;
import com.qqkj.mdp.core.utils.NumberUtil;
import com.qqkj.mdp.core.utils.RequestUtils;
import com.qqkj.audit.log.client.annotation.AuditLog;
import com.qqkj.audit.log.client.annotation.OperType;
import com.qqkj.mdp.core.entity.Tips;
import com.qqkj.mdp.core.err.BizException;
import com.qqkj.xm.core.service.XmProjectGroupService;
import com.qqkj.xm.core.service.XmRecordService;
import com.qqkj.xm.core.service.XmTaskService;
import com.qqkj.xm.core.service.push.XmPushMsgService;
import com.qqkj.xm.core.entity.XmTask;
import com.qqkj.xm.core.entity.XmTask;
/**
 * url编制采用rest风格,如对XM.xm_task xm_task的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmTask/add <br>
 *  查询: xm/xmTask/list<br>
 *  模糊查询: xm/xmTask/listKey<br>
 *  修改: xm/xmTask/edit <br>
 *  删除: xm/xmTask/del<br>
 *  批量删除: xm/xmTask/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmTask 表 XM.xm_task 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmTaskController")
@RequestMapping(value="/**/xm/core/xmTask")
@Api(tags={"xm_task操作接口"})
public class XmTaskController {
	
	static Log logger=LogFactory.getLog(XmTaskController.class);
	
	@Autowired
	private XmTaskService xmTaskService;
	
	@Autowired
	XmProjectGroupService groupService;
	
	@Autowired
	private XmRecordService xmRecordService;
	
	@Autowired
	private XmPushMsgService  xmPushMsgService;


	@ApiOperation( value = "查询xm_task信息列表",notes="listXmTask,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({
			@ApiImplicitParam(name="id",value="任务编号,主键",required=false),
			@ApiImplicitParam(name="name",value="任务名称",required=false),
			@ApiImplicitParam(name="parentTaskid",value="父任务编号",required=false),
			@ApiImplicitParam(name="parentTaskname",value="父任务名称",required=false),
			@ApiImplicitParam(name="projectId",value="项目编号",required=false),
			@ApiImplicitParam(name="projectName",value="项目名称",required=false),
			@ApiImplicitParam(name="level",value="任务级别",required=false),
			@ApiImplicitParam(name="sortLevel",value="排序级别",required=false),
			@ApiImplicitParam(name="executorUserid",value="任务执行人编号",required=false),
			@ApiImplicitParam(name="executorUsername",value="任务执行人",required=false),
			@ApiImplicitParam(name="preTaskid",value="前置任务编号",required=false),
			@ApiImplicitParam(name="preTaskname",value="前置任务名称",required=false),
			@ApiImplicitParam(name="startTime",value="任务开始时间",required=false),
			@ApiImplicitParam(name="endTime",value="任务结束时间",required=false),
			@ApiImplicitParam(name="milestone",value="里程碑",required=false),
			@ApiImplicitParam(name="description",value="任务描述",required=false),
			@ApiImplicitParam(name="remarks",value="备注",required=false),
			@ApiImplicitParam(name="createUserid",value="任务创建人编号",required=false),
			@ApiImplicitParam(name="createUsername",value="任务创建人",required=false),
			@ApiImplicitParam(name="createTime",value="创建时间",required=false),
			@ApiImplicitParam(name="rate",value="任务进度",required=false),
			@ApiImplicitParam(name="budgetCost",value="当前任务预算金额（包括所有成本，包括直接下一级）",required=false),
			@ApiImplicitParam(name="budgetWorkload",value="预算工时（包括直接下级）",required=false),
			@ApiImplicitParam(name="actCost",value="当前任务实际费用金额（包括所有成本，包括直接下一级）",required=false),
			@ApiImplicitParam(name="actWorkload",value="实际工时（包括直接下级）",required=false),
			@ApiImplicitParam(name="taskState",value="任务状态0待领取1已领取执行中2已完工3已结算",required=false),
			@ApiImplicitParam(name="taskType",value="1可外包0不可外包",required=false),
			@ApiImplicitParam(name="taskClass",value="1需结算0不需结算",required=false),
			@ApiImplicitParam(name="toTaskCenter",value="是否发布到任务大厅0否1是",required=false),
			@ApiImplicitParam(name="actStartTime",value="实际开始时间",required=false),
			@ApiImplicitParam(name="actEndTime",value="实际结束时间",required=false),
			@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
			@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
			@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false)
	})
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTask.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/getTask",method=RequestMethod.GET)
	public Map<String,Object> getTask( @RequestParam Map<String,Object> xmTask){
		Map<String,Object> m = new HashMap<>();
		RequestUtils.transformArray(xmTask, "ids");
		PageUtils.startPage(xmTask);
		List<Map<String,Object>> xmTaskVoList = xmTaskService.getTask(xmTask);	//列出XmTask列表
		PageUtils.responePage(m,xmTaskVoList);
		m.put("data",xmTaskVoList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}

	@ApiOperation( value = "新增一条xm_task信息",notes="addXmTask,主键如果为空，后台自动生成")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTask.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTask_addTask",name = "新增任务",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/addTask",method=RequestMethod.POST)
	public Map<String,Object> addTask(@RequestBody XmTaskVo xmTaskVo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{ 
			 
			xmTaskVo.setCreateTime(new Date());
			xmTaskVo.setRate(BigDecimal.ZERO);
			if(xmTaskVo.getMilestone() == ""){
				xmTaskVo.setMilestone("0");
			} 
			String projectPhaseId=xmTaskVo.getProjectPhaseId();
			BigDecimal zero=BigDecimal.ZERO;   
			BigDecimal taskBudgetCost=BigDecimal.ZERO;
			BigDecimal taskBudgetInnerUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetOutUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetNouserAt=BigDecimal.ZERO;   
			if("1".equals(xmTaskVo.getTaskOut())) {
				taskBudgetOutUserAt=taskBudgetOutUserAt.add(NumberUtil.getBigDecimal(xmTaskVo.getBudgetCost(),zero)); 
			}else { 
				taskBudgetInnerUserAt=taskBudgetInnerUserAt.add(NumberUtil.getBigDecimal(xmTaskVo.getBudgetCost(),zero)); 
			} 
			taskBudgetCost=taskBudgetCost.add(taskBudgetInnerUserAt).add(taskBudgetOutUserAt).add(taskBudgetNouserAt);   
			Tips judgetTips=xmTaskService.judgetBudget(projectPhaseId, taskBudgetCost,taskBudgetInnerUserAt,taskBudgetOutUserAt,taskBudgetNouserAt,null);
			if(judgetTips.isOk()) {
				xmTaskVo = xmTaskService.addTask(xmTaskVo); 
			}else {
				tips=judgetTips;
			}
			m.put("data",xmTaskVo);
		}catch (BizException e) {
			tips=e.getTips();
			logger.error("",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("",e);
		}
		m.put("tips", tips);
		return m;
	}


	
	@ApiOperation( value = "查询xm_task信息列表",notes="listXmTask,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="任务编号,主键",required=false),
		@ApiImplicitParam(name="name",value="任务名称",required=false),
		@ApiImplicitParam(name="parentTaskid",value="父任务编号",required=false),
		@ApiImplicitParam(name="parentTaskname",value="父任务名称",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="projectName",value="项目名称",required=false),
		@ApiImplicitParam(name="level",value="任务级别",required=false),
		@ApiImplicitParam(name="sortLevel",value="排序级别",required=false),
		@ApiImplicitParam(name="executorUserid",value="任务执行人编号",required=false),
		@ApiImplicitParam(name="executorUsername",value="任务执行人",required=false),
		@ApiImplicitParam(name="preTaskid",value="前置任务编号",required=false),
		@ApiImplicitParam(name="preTaskname",value="前置任务名称",required=false),
		@ApiImplicitParam(name="startTime",value="任务开始时间",required=false),
		@ApiImplicitParam(name="endTime",value="任务结束时间",required=false),
		@ApiImplicitParam(name="milestone",value="里程碑",required=false),
		@ApiImplicitParam(name="description",value="任务描述",required=false),
		@ApiImplicitParam(name="remarks",value="备注",required=false),
		@ApiImplicitParam(name="createUserid",value="任务创建人编号",required=false),
		@ApiImplicitParam(name="createUsername",value="任务创建人",required=false),
		@ApiImplicitParam(name="createTime",value="创建时间",required=false),
		@ApiImplicitParam(name="rate",value="任务进度",required=false),
		@ApiImplicitParam(name="budgetCost",value="当前任务预算金额（包括所有成本，包括直接下一级）",required=false),
		@ApiImplicitParam(name="budgetWorkload",value="预算工时（包括直接下级）",required=false),
		@ApiImplicitParam(name="actCost",value="当前任务实际费用金额（包括所有成本，包括直接下一级）",required=false),
		@ApiImplicitParam(name="actWorkload",value="实际工时（包括直接下级）",required=false),
		@ApiImplicitParam(name="taskState",value="任务状态0待领取1已领取执行中2已完工3已结算",required=false),
		@ApiImplicitParam(name="taskType",value="1可外包0不可外包",required=false),
		@ApiImplicitParam(name="taskClass",value="1需结算0不需结算",required=false),
		@ApiImplicitParam(name="toTaskCenter",value="是否发布到任务大厅0否1是",required=false),
		@ApiImplicitParam(name="actStartTime",value="实际开始时间",required=false),
		@ApiImplicitParam(name="actEndTime",value="实际结束时间",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false)
	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTask.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTask( @RequestParam Map<String,Object> xmTask){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmTask, "ids");
		PageUtils.startPage(xmTask);
		List<Map<String,Object>>	xmTaskList = xmTaskService.selectListMapByWhere(xmTask);	//列出XmTask列表
		PageUtils.responePage(m, xmTaskList);
		m.put("data",xmTaskList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 

	@ApiOperation( value = "新增一条xm_task信息",notes="addXmTask,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTask.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTask_add",name = "新增任务",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTask(@RequestBody XmTask xmTask) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmTask.getId())) {
				xmTask.setId(xmTaskService.createKey("id"));
			}else{
				 XmTask xmTaskQuery = new  XmTask(xmTask.getId());
				if(xmTaskService.countByWhere(xmTaskQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmTask.setCreateTime(new Date());
			xmTask.setRate(BigDecimal.ZERO);
			if(xmTask.getMilestone() == ""){
				xmTask.setMilestone("0");
			} 
			String projectPhaseId=xmTask.getProjectPhaseId();
			BigDecimal zero=BigDecimal.ZERO;   
			BigDecimal taskBudgetCost=BigDecimal.ZERO;
			BigDecimal taskBudgetInnerUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetOutUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetNouserAt=BigDecimal.ZERO;  
			List<String> excludePhaseIds=new ArrayList<>();  
			if("1".equals(xmTask.getTaskOut())) {
				taskBudgetOutUserAt=taskBudgetOutUserAt.add(NumberUtil.getBigDecimal(xmTask.getBudgetCost(),zero)); 
			}else { 
				taskBudgetInnerUserAt=taskBudgetInnerUserAt.add(NumberUtil.getBigDecimal(xmTask.getBudgetCost(),zero)); 
			} 
			taskBudgetCost=taskBudgetCost.add(taskBudgetInnerUserAt).add(taskBudgetOutUserAt).add(taskBudgetNouserAt);  
			excludePhaseIds.add(xmTask.getId());
			Tips judgetTips=xmTaskService.judgetBudget(projectPhaseId, taskBudgetCost,taskBudgetInnerUserAt,taskBudgetOutUserAt,taskBudgetNouserAt,excludePhaseIds);
			if(judgetTips.isOk()) {
				xmTaskService.insert(xmTask);
				xmRecordService.addXmTaskRecord(xmTask.getProjectId(), xmTask.getId(), "项目-任务-新增任务", "新增任务"+xmTask.getName(),JSON.toJSONString(xmTask),null); 
			}else {
				tips=judgetTips;
			}
			m.put("data",xmTask);
		}catch (BizException e) { 
			tips=e.getTips();
			logger.error("",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("",e);
		}  
		m.put("tips", tips);
		return m;
	}
	
	@ApiOperation( value = "删除一条xm_task信息",notes="delXmTask,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@HasQx(value = "xm_core_xmTask_del",name = "删除任务",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmTask(@RequestBody XmTask xmTask){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmTaskService.deleteTask(xmTask);
		}catch (BizException e) {
			tips=e.getTips();
			logger.error("",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("",e);
		}  
		m.put("tips", tips);
		return m;
	}
	
	@ApiOperation( value = "根据主键修改一条xm_task信息",notes="editXmTask")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTask.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTask_editXmTask",name = "修改任务",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTask(@RequestBody XmTaskVo xmTaskVo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{			 
			BigDecimal taskBudgetCost=BigDecimal.ZERO;
			BigDecimal taskBudgetInnerUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetOutUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetNouserAt=BigDecimal.ZERO;
			String projectPhaseId=null;
			BigDecimal zero=BigDecimal.ZERO;
			List<String> excludePhaseIds=new ArrayList<>(); 
			projectPhaseId=xmTaskVo.getProjectPhaseId();
			if("1".equals(xmTaskVo.getTaskOut())) {
				taskBudgetOutUserAt=taskBudgetOutUserAt.add(NumberUtil.getBigDecimal(xmTaskVo.getBudgetCost(),zero)); 
			}else { 
				taskBudgetInnerUserAt=taskBudgetInnerUserAt.add(NumberUtil.getBigDecimal(xmTaskVo.getBudgetCost(),zero)); 
			} 
			taskBudgetCost=taskBudgetCost.add(taskBudgetInnerUserAt).add(taskBudgetOutUserAt).add(taskBudgetNouserAt);  
			excludePhaseIds.add(xmTaskVo.getId());
			Tips judgetTips=xmTaskService.judgetBudget(projectPhaseId, taskBudgetCost,taskBudgetInnerUserAt,taskBudgetOutUserAt,taskBudgetNouserAt,excludePhaseIds);
			if(judgetTips.isOk()) {
				xmTaskService.updateTask(xmTaskVo); 
				if(!StringUtils.isEmpty(xmTaskVo.getExecutorUserid())) {
					User user=LoginUtils.getCurrentUserInfo();
					List<XmProjectGroupVo> groups=groupService.getUserGroups(xmTaskVo.getProjectId(), xmTaskVo.getExecutorUserid());
					if(groups!=null && groups.size()>0) {
						for (XmProjectGroupVo g : groups) {
							xmPushMsgService.pushGroupMsg(user.getBranchId(), g.getId(), user.getUserid(), user.getUsername(), user.getUsername()+"修改了任务【"+xmTaskVo.getName()+"】信息");
						}
					}
				}
				//xmRecordService.addXmTaskRecord(xmTaskVo.getProjectPhaseId(), xmTaskVo.getId(), "项目-任务-修改任务", "修改任务"+xmTaskVo.getName(),JSON.toJSONString(xmTaskVo),null); 
			}else {
				tips=judgetTips;
			}
			m.put("data",xmTaskVo);
		}catch (BizException e) {
			tips=e.getTips();
			logger.error("",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("",e);
		}
		m.put("tips", tips);
		return m;
	}
	
	@ApiOperation( value = "根据主键修改一条xm_task信息",notes="editXmTask")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTask.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTask_editProgress",name = "修改任务进度百分比",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/editProgress",method=RequestMethod.POST)
	public Map<String,Object> editProgress(@RequestBody XmTask xmTask) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmTaskService.updateProgress(xmTask); 
			if(!StringUtils.isEmpty(xmTask.getExecutorUserid())) {
				User user=LoginUtils.getCurrentUserInfo();
				List<XmProjectGroupVo> groups=groupService.getUserGroups(xmTask.getProjectId(), xmTask.getExecutorUserid());
				if(groups!=null && groups.size()>0) {
					for (XmProjectGroupVo g : groups) {
						xmPushMsgService.pushGroupMsg(user.getBranchId(), g.getId(), user.getUserid(), user.getUsername(), user.getUsername()+"将任务【"+xmTask.getName()+"】进度更新为"+xmTask.getRate()+"%");
					}
				}
			}
			
			m.put("data",xmTask);
		}catch (BizException e) {
			tips=e.getTips();
			logger.error("",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("",e);
		}
		m.put("tips", tips);
		return m;
	}

	@ApiOperation( value = "批量导入任务-从模板导入",notes="batchDelXmTask,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmTask_batchImportFromTemplate",name = "从模板导入任务",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchImportFromTemplate",method=RequestMethod.POST)
	public Map<String,Object> batchImportFromTemplate(@RequestBody List<XmTask> xmTasks) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功导入"+xmTasks.size()+"条数据"); 
		try{ 
			 
			
			BigDecimal taskBudgetCost=BigDecimal.ZERO;
			BigDecimal taskBudgetInnerUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetOutUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetNouserAt=BigDecimal.ZERO;
			String projectPhaseId=null;
			BigDecimal zero=BigDecimal.ZERO;
			List<String> excludePhaseIds=new ArrayList<>();
			for (XmTask g : xmTasks) {
				projectPhaseId=g.getProjectPhaseId();
				if("1".equals(g.getTaskOut())) {
					taskBudgetOutUserAt=taskBudgetOutUserAt.add(NumberUtil.getBigDecimal(g.getBudgetCost(),zero)); 
				}else { 
					taskBudgetInnerUserAt=taskBudgetInnerUserAt.add(NumberUtil.getBigDecimal(g.getBudgetCost(),zero)); 
				} 
				excludePhaseIds.add(g.getId());
			} 
			taskBudgetCost=taskBudgetCost.add(taskBudgetInnerUserAt).add(taskBudgetOutUserAt).add(taskBudgetNouserAt);  

			Tips judgetTips=xmTaskService.judgetBudget(projectPhaseId, taskBudgetCost,taskBudgetInnerUserAt,taskBudgetOutUserAt,taskBudgetNouserAt,excludePhaseIds);
			if(judgetTips.isOk()) {
				xmTaskService.batchImportFromTemplate(xmTasks);
				for (XmTask t : xmTasks) {
					xmRecordService.addXmTaskRecord(t.getProjectId(), t.getId(), "项目-任务-批量新增任务", "新增任务"+t.getName(),JSON.toJSONString(t),null);
					
				}
			}else {
				tips=judgetTips;
			}
			
		}catch (BizException e) { 
			tips=e.getTips();
			logger.error("",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("",e);
		}  
		m.put("tips", tips);
		return m;
	} 
	@ApiOperation( value = "批量将多个任务与一个用户故事关联",notes="")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmTask_batchRelTasksWithMenu",name = "从故事导入任务",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchRelTasksWithMenu",method=RequestMethod.POST)
	public Map<String,Object> batchRelTasksWithMenu(@RequestBody List<XmTask> xmTasks) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功导入"+xmTasks.size()+"条数据"); 
		try{ 
			  
				xmTaskService.batchRelTasksWithMenu(xmTasks);
				for (XmTask t : xmTasks) {
					xmRecordService.addXmTaskRecord(t.getProjectId(), t.getId(), "项目-任务-批量更新任务", "将任务"+t.getName()+"与故事【"+t.getMenuId()+"-"+t.getMenuName()+"】关联",JSON.toJSONString(t),null);
					
				} 
			
		}catch (BizException e) { 
			tips=e.getTips();
			logger.error("",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("",e);
		}  
		m.put("tips", tips);
		return m;
	} 
	/**
	*/
	@ApiOperation( value = "根据主键列表批量删除xm_task信息",notes="batchDelXmTask,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmTask_batchDel",name = "批量删除任务",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmTask(@RequestBody List<XmTask> xmTasks) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmTasks.size()+"条数据"); 
		try{ 
			List<String> noDelList=new ArrayList<>();
			xmTasks.forEach(t->{
				try {
					xmTaskService.deleteTask(t);
				} catch (BizException e) {
					noDelList.add(t.getName());
				}
 			});
			if(noDelList.size()>0 && xmTasks.size()>noDelList.size()) {
				tips.setOkMsg("成功删除"+(xmTasks.size()-noDelList.size())+"条任务，其中以下任务可能存在未结算的执行人或者存在子任务，不允许删除"+StringUtils.arrayToCommaDelimitedString(noDelList.toArray()));
			}if(noDelList.size()>0 && xmTasks.size()==noDelList.size()) {
				tips.setFailureMsg("无法删除，所选任务都存在未结算执行人或者子任务");
			}else {
				tips.setOkMsg("成功删除"+xmTasks.size()+"条任务");
			}
		}catch (BizException e) { 
			tips=e.getTips();
			logger.error("",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("",e);
		}  
		m.put("tips", tips);
		return m;
	} 
	

	/***/
	@ApiOperation( value = "批量修改预算",notes="batchSaveBudget,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmTask_batchSaveBudget",name = "批量修改任务预算",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchSaveBudget",method=RequestMethod.POST)
	public Map<String,Object> batchSaveBudget(@RequestBody  List<XmTaskVo> xmTasks) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改"+xmTasks.size()+"条数据"); 
		try{ 
			BigDecimal taskBudgetCost=BigDecimal.ZERO;
			BigDecimal taskBudgetInnerUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetOutUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetNouserAt=BigDecimal.ZERO;
			String projectPhaseId=null;
			BigDecimal zero=BigDecimal.ZERO;
			List<String> excludePhaseIds=new ArrayList<>();
			for (XmTask g : xmTasks) {
				projectPhaseId=g.getProjectPhaseId();
				if("1".equals(g.getTaskOut())) {
					taskBudgetOutUserAt=taskBudgetOutUserAt.add(NumberUtil.getBigDecimal(g.getBudgetCost(),zero)); 
				}else { 
					taskBudgetInnerUserAt=taskBudgetInnerUserAt.add(NumberUtil.getBigDecimal(g.getBudgetCost(),zero)); 
				} 
				excludePhaseIds.add(g.getId());
			} 
			taskBudgetCost=taskBudgetCost.add(taskBudgetInnerUserAt).add(taskBudgetOutUserAt).add(taskBudgetNouserAt);  

			Tips judgetTips=xmTaskService.judgetBudget(projectPhaseId, taskBudgetCost,taskBudgetInnerUserAt,taskBudgetOutUserAt,taskBudgetNouserAt,excludePhaseIds);
			if(judgetTips.isOk()) {
				xmTaskService.batchInsertOrUpdate(xmTasks);
				for (XmTask t : xmTasks) {
					xmRecordService.addXmTaskRecord(t.getProjectId(), t.getId(), "项目-任务-批量修改任务预算", "修改任务预算"+t.getName(),JSON.toJSONString(t),null);
					
				}
			}else {
				tips=judgetTips;
			}
			
		}catch (BizException e) { 
			tips=e.getTips();
			logger.error("",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("",e);
		}  
		m.put("tips", tips);
		return m;
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
	 *            
	 * 其中 create/complete/assignment/delete事件是需要在模型中人工节点上配置了委托代理表达式 ${taskBizCallListener}才会推送过来。
	 * 在人工任务节点上配置 任务监听器  建议事件为 complete,其它assignment/create/complete/delete也可以，一般建议在complete,委托代理表达式 ${taskBizCallListener}
	 * 
	 * @param flowVars {flowBranchId,agree,procInstId,assignee,actId,taskName,mainTitle,branchId,bizKey,commentMsg,eventName,modelKey} 等 
	 * @return 如果tips.isOk==false，将影响流程提交
	 **/
	@AuditLog(firstMenu="办公平台",secondMenu="项目任务管理",func="processApprova",funcDesc="任务审核",operType=OperType.UPDATE)
	@RequestMapping(value="/processApprova",method=RequestMethod.POST)
	public Map<String,Object> processApprova( @RequestBody Map<String,Object> flowVars){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		  
		try{ 
			
			this.xmTaskService.processApprova(flowVars);
			logger.debug("procInstId====="+flowVars.get("procInstId"));
		}catch (BizException e) { 
			tips=e.getTips();
			logger.error("执行异常",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("执行异常",e);
		}  
		m.put("tips", tips);
		return m;
	}
}
