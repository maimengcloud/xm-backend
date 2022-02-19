package com.xm.core.ctrl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageSerializable;
import com.mdp.audit.log.client.annotation.AuditLog;
import com.mdp.audit.log.client.annotation.OperType;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.NumberUtil;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.PubTool;
import com.xm.core.entity.XmTask;
import com.xm.core.service.XmProjectGroupService;
import com.xm.core.service.XmRecordService;
import com.xm.core.service.XmTaskService;
import com.xm.core.service.cache.XmTaskCacheService;
import com.xm.core.service.push.XmPushMsgService;
import com.xm.core.vo.XmProjectGroupVo;
import com.xm.core.vo.XmTaskVo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.mdp.core.utils.BaseUtils.map;

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
	XmTaskCacheService xmTaskCacheService;
	
	@Autowired
	private XmTaskService xmTaskService;
	
	@Autowired
    XmProjectGroupService groupService;
	
	@Autowired
	private XmRecordService xmRecordService;
	
	@Autowired
	private XmPushMsgService xmPushMsgService;


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
			@ApiResponse(code = 200,response= XmTask.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/getTask",method=RequestMethod.GET)
	public Map<String,Object> getTask( @RequestParam Map<String,Object> xmTask){
		Map<String,Object> m = new HashMap<>();
		RequestUtils.transformArray(xmTask, "ids");
		RequestUtils.transformArray(xmTask, "skillIds");
		RequestUtils.transformArray(xmTask, "tagIdList");
		PageUtils.startPage(xmTask);
		String taskOut= (String) xmTask.get("taskOut");
		if(!"1".equals(taskOut)){
			String projectId= (String) xmTask.get("projectId");
			String projectPhaseId= (String) xmTask.get("projectPhaseId");
			String myExecuserStatus= (String) xmTask.get("myExecuserStatus");
			String isMy= (String) xmTask.get("isMy");
			String myFocus= (String) xmTask.get("myFocus");
			String createUserid= (String) xmTask.get("createUserid");
			String executorUserid= (String) xmTask.get("executorUserid");
			String menuId= (String) xmTask.get("menuId");
			String productId= (String) xmTask.get("productId");
			String iterationId= (String) xmTask.get("iterationId");
			User user = LoginUtils.getCurrentUserInfo();
			xmTask.put("userid",user.getUserid());
			if( !(StringUtils.hasText(projectId) || StringUtils.hasText(projectPhaseId)
					|| StringUtils.hasText(myExecuserStatus)|| StringUtils.hasText(isMy)|| StringUtils.hasText(myFocus)|| StringUtils.hasText(createUserid)
					|| StringUtils.hasText(executorUserid) || StringUtils.hasText(menuId) || StringUtils.hasText(productId)|| StringUtils.hasText(iterationId)) ){

				xmTask.put("compete",user.getUserid());
			}
		}
		List<Map<String,Object>> xmTaskVoList = xmTaskService.getTask(xmTask);	//列出XmTask列表
		PageUtils.responePage(m,xmTaskVoList);
		if("1".equals(xmTask.get("withParents"))  && !"1".equals(xmTask.get("isTop"))){
			List<String> pidPathsList=xmTaskVoList.stream().map(i->PubTool.getPidPaths((String)i.get("pidPaths"),(String)i.get("id"))).collect(Collectors.toSet()).stream().collect(Collectors.toList());
			List<Map<String,Object>> parentList=xmTaskService.getTask(map("pidPathsList",pidPathsList));
			xmTaskVoList.addAll(parentList);
			m.put("total", NumberUtil.getInteger(m.get("total"),0)+parentList.size());
		}

		m.put("data",xmTaskVoList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}


	@ApiOperation( value = "查询xm_task信息列表-互联网大厅首页专用、免登录",notes="listXmTask,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
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
			@ApiResponse(code = 200,response= XmTask.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/getOutTask",method=RequestMethod.GET)
	public Map<String,Object> getOutTask( @RequestParam Map<String,Object> xmTask){
		Map<String,Object> m = new HashMap<>();

		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmTask, "skillIds");
		PageUtils.startPage(xmTask);
		xmTask.put("taskOut","1");
		String isDefault= (String) xmTask.get("isDefault");
		String pageNum= (String) xmTask.get("pageNum");
		String queryKeys="xm-out-tasks-default-"+pageNum;
		List<Map<String,Object>> xmTaskVoList=new ArrayList<>();
		if(!StringUtils.hasText(isDefault)){
			tips.setFailureMsg("isDefault-not-set","isDefault","isDefault参数必传，默认查询isDefault=1,非默认查询isDefault=0");
		}else if("1".equals(isDefault)){
			PageSerializable<Map<String,Object>> tasks =xmTaskCacheService.getTasks(queryKeys);
			if(tasks==null){
				xmTaskVoList = xmTaskService.getTask(xmTask);	//列出XmTask列表
				tasks=new PageSerializable<>(xmTaskVoList);
				xmTaskCacheService.putTasks(queryKeys,tasks);
				PageUtils.responePage(m,xmTaskVoList);
			}else{
				xmTaskVoList=tasks.getList();
				m.put("total",tasks.getTotal());
			}
		}else {
			xmTaskVoList = xmTaskService.getTask(xmTask);	//列出XmTask列表
			PageUtils.responePage(m,xmTaskVoList);
			if("1".equals(xmTask.get("withParents"))  && !"1".equals(xmTask.get("isTop"))){
				List<String> pidPathsList=xmTaskVoList.stream().map(i-> PubTool.getPidPaths((String)i.get("pidPaths"),(String)i.get("id"))).collect(Collectors.toSet()).stream().collect(Collectors.toList());
				List<Map<String,Object>> parentList=xmTaskService.getTask(map("pidPathsList",pidPathsList));
				xmTaskVoList.addAll(parentList);
				m.put("total", NumberUtil.getInteger(m.get("total"),0)+parentList.size());
			}
		}



		m.put("data",xmTaskVoList);
		m.put("tips", tips);
		return m;
	}

	@ApiOperation( value = "查询任务的信息详情，免登录",notes="taskDetail,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")

	@ApiResponses({
			@ApiResponse(code = 200,response= XmTask.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/shareTaskDetail",method=RequestMethod.GET)
	public Map<String,Object> taskDetail( @RequestParam Map<String,Object> xmTask){
		Tips tips=new Tips("查询成功");
		Map<String,Object> m = new HashMap<>();
		String id=(String) xmTask.get("id");
		String shareKey= (String) xmTask.get("shareKey");
		if(!StringUtils.hasText(id)){
			tips.setFailureMsg("任务编号id必传");
		}
		if(!StringUtils.hasText(shareKey)){
			tips.setFailureMsg("分享码shareKey必传");
		}
		//todo 检测分析妈的正确性
		if(tips.isOk()){
			Map<String,Object> taskDb= xmTaskService.shareTaskDetail(xmTask);
			m.put("data",taskDb);
			m.put("tips", tips);
		}
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


			if(!StringUtils.hasText(xmTaskVo.getNtype())){
				tips.setFailureMsg("节点类型ntype不能为空");
				m.put("tips", tips);
				return m;
			}
			User user=LoginUtils.getCurrentUserInfo();
			xmTaskVo.setCreateUserid(user.getUserid());
			xmTaskVo.setCreateUsername(user.getUsername());
			xmTaskVo.setExecutorUserid(user.getUserid());
			xmTaskVo.setExecutorUsername(user.getUsername());
			xmTaskVo.setCreateTime(new Date());
			xmTaskVo.setCbranchId(user.getBranchId());
			xmTaskVo.setCdeptid(user.getDeptid());
			List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(xmTaskVo.getProjectId());
			if(pgroups==null || pgroups.size()==0){
				tips.setFailureMsg("该项目还未建立项目团队，请先进行团队成员维护");
				m.put("tips", tips);
				return m;
			}
			boolean isHead=groupService.checkUserIsOtherUserTeamHead(pgroups,user.getUserid(),user.getUserid());
			if(!isHead){
				tips.setFailureMsg("您无权新建任务！项目经理、组长可以新建任务。");
				m.put("tips", tips);
				return m;
			}
			xmTaskVo.setRate(BigDecimal.ZERO);
			if( !StringUtils.hasText(xmTaskVo.getMilestone()) ){
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
		RequestUtils.transformArray(xmTask, "tagIdList");
		PageUtils.startPage(xmTask);

		String taskOut= (String) xmTask.get("taskOut");
		if(!"1".equals(taskOut)){
			String projectId= (String) xmTask.get("projectId");
			String projectPhaseId= (String) xmTask.get("projectPhaseId");
			String userid= (String) xmTask.get("userid");
			if( !(StringUtils.hasText(projectId) || StringUtils.hasText(projectPhaseId)|| StringUtils.hasText(userid) ) ){
				User user = LoginUtils.getCurrentUserInfo();
				xmTask.put("cbranchId",user.getBranchId());
			}
		}
		List<Map<String,Object>>	xmTaskList = xmTaskService.selectListMapByWhere(xmTask);	//列出XmTask列表
		PageUtils.responePage(m, xmTaskList);
		m.put("data",xmTaskList);
		Tips tips=new Tips("查询成功");
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
			User user=LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmTask.getProjectId())){
				tips.setFailureMsg("项目编号不能为空");
				m.put("tips", tips);
				return m;
			}
			if(!StringUtils.hasText(xmTask.getId())){
				tips.setFailureMsg("任务编号不能为空");
				m.put("tips", tips);
				return m;
			}

			List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(xmTask.getProjectId());
			if(pgroups==null || pgroups.size()==0){
				tips.setFailureMsg("该项目还未建立项目团队，请先进行团队成员维护");
				m.put("tips", tips);
				return m;
			}
			boolean isHead=groupService.checkUserIsOtherUserTeamHead(pgroups,user.getUserid(),user.getUserid());
			if(!isHead){
				tips.setFailureMsg("您无权删除该任务！项目经理、组长可以删除任务。");
				m.put("tips", tips);
				return m;
			}
			XmTask xmTaskDb=this.xmTaskService.selectOneObject(xmTask);
			if(xmTaskDb==null){
				tips.setFailureMsg("该任务不存在");
				m.put("tips", tips);
				return m;
			}
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
	//@HasQx(value = "xm_core_xmTask_setTaskCreateUser",name = "修改任务责任人",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/setTaskCreateUser",method=RequestMethod.POST)
	public Map<String,Object> setTaskCreateUser(@RequestBody XmTaskVo xmTaskVo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			User user=LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmTaskVo.getProjectId())){
				tips.setFailureMsg("项目编号不能为空");
				m.put("tips", tips);
				return m;
			}
			if(!StringUtils.hasText(xmTaskVo.getId())){
				tips.setFailureMsg("任务编号不能为空");
				m.put("tips", tips);
				return m;
			}
			List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(xmTaskVo.getProjectId());
			if(pgroups==null || pgroups.size()==0){
				tips.setFailureMsg("该项目还未建立项目团队，请先进行团队成员维护");
				m.put("tips", tips);
				return m;
			}
			XmTask xmTaskDb=this.xmTaskService.selectOneObject(xmTaskVo);
			if(xmTaskDb==null){
				tips.setFailureMsg("该任务不存在");
				m.put("tips", tips);
				return m;
			}
			boolean isHead=groupService.checkUserIsOtherUserTeamHead(pgroups,xmTaskDb.getCreateUserid(),user.getUserid());
			if(!isHead){
				boolean isPm=groupService.checkUserIsProjectManager(pgroups,user.getUserid());
				if(!isPm){
					tips.setFailureMsg("您无权修改该该任务的责任人！项目管理者、组长可以修改任务的责任人。");
					m.put("tips", tips);
					return m;
				}
			}
			boolean existsGrouop=groupService.checkUserExistsGroup(xmTaskVo.getProjectId(),xmTaskVo.getCreateUserid());
			if(!existsGrouop){
				tips.setFailureMsg(xmTaskVo.getCreateUsername()+"不是项目组成员，不能作为任务责任人");
				m.put("tips", tips);
				return m;
			}
			XmTask xmTask=new XmTask(xmTaskVo.getId());
			xmTask.setCreateUserid(xmTaskVo.getCreateUserid());
			xmTask.setCreateUsername(xmTaskVo.getCreateUsername());
			 this.xmTaskService.updateSomeFieldByPk(xmTask);
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
	@HasQx(value = "xm_core_xmTask_editXmTask",name = "修改任务",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTask(@RequestBody XmTaskVo xmTaskVo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			User user=LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmTaskVo.getProjectId())){
				tips.setFailureMsg("项目编号不能为空");
				m.put("tips", tips);
				return m;
			}
			if(!StringUtils.hasText(xmTaskVo.getId())){
				tips.setFailureMsg("任务编号不能为空");
				m.put("tips", tips);
				return m;
			}
			List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(xmTaskVo.getProjectId());
			if(pgroups==null || pgroups.size()==0){
				tips.setFailureMsg("该项目还未建立项目团队，请先进行团队成员维护");
				m.put("tips", tips);
				return m;
			}
			XmTask xmTaskDb=this.xmTaskService.selectOneObject(xmTaskVo);
			if(xmTaskDb==null){
				tips.setFailureMsg("该任务不存在");
				m.put("tips", tips);
				return m;
			}
			boolean isHead=groupService.checkUserIsOtherUserTeamHead(pgroups,xmTaskDb.getCreateUserid(),user.getUserid());
			if(!isHead){
				tips.setFailureMsg("您无权修改该任务基础信息！项目经理、组长可以修改任务的基础信息。");
				m.put("tips", tips);
				return m;
			}
			if(StringUtils.hasText(xmTaskDb.getNtype())&&StringUtils.hasText(xmTaskVo.getNtype())&&StringUtils.hasText(xmTaskDb.getParentTaskid())){
				if(!xmTaskDb.getNtype().equals(xmTaskVo.getNtype())){
					if(xmTaskVo.getNtype().equals("1")){
						XmTask xmTaskParentDb=this.xmTaskService.selectOneObject(new XmTask(xmTaskDb.getParentTaskid()));
						if(xmTaskParentDb!=null){
							if(!"1".equals(xmTaskParentDb.getNtype())){
								ResponseHelper.failed("ptask-ntype-0","上级任务"+xmTaskParentDb.getName()+"属于不是任务集,不能下挂任务集");
							}
						}
					}
				}
			}
			BigDecimal taskBudgetCost=BigDecimal.ZERO;
			BigDecimal taskBudgetInnerUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetOutUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetNouserAt=BigDecimal.ZERO;
			String projectPhaseId=null;
			BigDecimal zero=BigDecimal.ZERO;
			List<String> excludeTaskIds=new ArrayList<>();
			projectPhaseId=xmTaskVo.getProjectPhaseId();
			if("1".equals(xmTaskVo.getTaskOut())) {
				taskBudgetOutUserAt=taskBudgetOutUserAt.add(NumberUtil.getBigDecimal(xmTaskVo.getBudgetCost(),zero)); 
			}else { 
				taskBudgetInnerUserAt=taskBudgetInnerUserAt.add(NumberUtil.getBigDecimal(xmTaskVo.getBudgetCost(),zero)); 
			} 
			taskBudgetCost=taskBudgetCost.add(taskBudgetInnerUserAt).add(taskBudgetOutUserAt).add(taskBudgetNouserAt);
			excludeTaskIds.add(xmTaskVo.getId());
			Tips judgetTips=xmTaskService.judgetBudget(projectPhaseId, taskBudgetCost,taskBudgetInnerUserAt,taskBudgetOutUserAt,taskBudgetNouserAt,excludeTaskIds);
			if(judgetTips.isOk()) {
				xmTaskService.updateTask(xmTaskVo); 
				if(!StringUtils.isEmpty(xmTaskVo.getExecutorUserid())) {
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
	@HasQx(value = "xm_core_xmTask_editTime",name = "修改任务时间",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/editTime",method=RequestMethod.POST)
	public Map<String,Object> editTime(@RequestBody XmTask xmTask) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			User user=LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmTask.getProjectId())){
				tips.setFailureMsg("项目编号不能为空");
				m.put("tips", tips);
				return m;
			}
			if(!StringUtils.hasText(xmTask.getId())){
				tips.setFailureMsg("任务编号不能为空");
				m.put("tips", tips);
				return m;
			}
			List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(xmTask.getProjectId());
			if(pgroups==null || pgroups.size()==0){
				tips.setFailureMsg("该项目还未建立项目团队，请先进行团队成员维护");
				m.put("tips", tips);
				return m;
			}
			XmTask xmTaskDb=xmTaskService.selectOneObject(xmTask);
			boolean isHead=groupService.checkUserIsOtherUserTeamHead(pgroups,xmTaskDb.getCreateUserid(),user.getUserid());
			if(!isHead){
				boolean isCreateUser=user.getUserid().equals(xmTaskDb.getCreateUserid());
				boolean isExecUser=user.getUserid().equals(xmTaskDb.getExecutorUserid());
				if( !isCreateUser && !isExecUser ){
					tips.setFailureMsg("您无权修改该任务的计划时间！只有任务执行人、任务负责人、组长、项目经理可以修改任务的进度。");
					m.put("tips", tips);
					return m;
				}
			}
			xmTaskService.updateTime(xmTask);
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
			User user=LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmTask.getProjectId())){
				tips.setFailureMsg("项目编号不能为空");
				m.put("tips", tips);
				return m;
			}
			if(!StringUtils.hasText(xmTask.getId())){
				tips.setFailureMsg("任务编号不能为空");
				m.put("tips", tips);
				return m;
			}
			List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(xmTask.getProjectId());
			if(pgroups==null || pgroups.size()==0){
				tips.setFailureMsg("该项目还未建立项目团队，请先进行团队成员维护");
				m.put("tips", tips);
				return m;
			}
			XmTask xmTaskDb=xmTaskService.selectOneObject(xmTask);
			boolean isHead=groupService.checkUserIsOtherUserTeamHead(pgroups,xmTaskDb.getCreateUserid(),user.getUserid());
			if(!isHead){
				boolean isCreateUser=user.getUserid().equals(xmTaskDb.getCreateUserid());
				boolean isExecUser=user.getUserid().equals(xmTaskDb.getExecutorUserid());
				if( !isCreateUser && !isExecUser ){
					tips.setFailureMsg("您无权修改该任务的进度！只有任务执行人、任务负责人、组长、项目经理可以修改任务的进度。");
					m.put("tips", tips);
					return m;
				}
			}
			xmTaskService.updateProgress(xmTask); 
			if(!StringUtils.isEmpty(xmTask.getExecutorUserid())) {
				if(pgroups!=null && pgroups.size()>0) {
					for (XmProjectGroupVo g : pgroups) {
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

			User user=LoginUtils.getCurrentUserInfo();
			BigDecimal taskBudgetCost=BigDecimal.ZERO;
			BigDecimal taskBudgetInnerUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetOutUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetNouserAt=BigDecimal.ZERO;
			if(xmTasks==null || xmTasks.size()==0){
				tips.setFailureMsg("任务列表不能为空");
				m.put("tips", tips);
				return m;
			}
			XmTask xmTask=xmTasks.get(0);
			String projectPhaseId=xmTask.getProjectPhaseId();
			String projectId=xmTask.getProjectId();
			if( !StringUtils.hasText(projectId) ){
				tips.setFailureMsg("项目编号不能为空");
				m.put("tips", tips);
				return m;
			}
			if( !StringUtils.hasText(projectPhaseId) ){
				tips.setFailureMsg("计划编号不能为空");
				m.put("tips", tips);
				return m;
			}

			List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);
			if(pgroups==null || pgroups.size()==0){
				tips.setFailureMsg("该项目还未建立项目团队，请先进行团队成员维护");
				m.put("tips", tips);
				return m;
			}
			boolean isHead=groupService.checkUserIsOtherUserTeamHead(pgroups,user.getUserid(),user.getUserid());
			if(!isHead){
				tips.setFailureMsg("您无权批量导入任务！项目经理、组长可以批量导入任务。");
				m.put("tips", tips);
				return m;
			}
			BigDecimal zero=BigDecimal.ZERO;
			List<String> excludeTaskIds=new ArrayList<>();
			for (XmTask g : xmTasks) {
				if(!projectPhaseId.equals(g.getProjectPhaseId())){
					tips.setFailureMsg("只能在同一个计划下批量导入任务");
					m.put("tips", tips);
					return m;
				}
				if(!projectId.equals(g.getProjectId())){
					tips.setFailureMsg("只能在同一个项目下批量导入任务");
					m.put("tips", tips);
					return m;
				}
				g.setCreateUserid(user.getUserid());
				g.setCreateUsername(user.getUsername());
				g.setExecutorUserid(user.getUserid());
				g.setExecutorUsername(user.getUsername());
				g.setCbranchId(user.getBranchId());
				g.setCdeptid(user.getDeptid());
				if("1".equals(g.getTaskOut())) {
					taskBudgetOutUserAt=taskBudgetOutUserAt.add(NumberUtil.getBigDecimal(g.getBudgetCost(),zero)); 
				}else { 
					taskBudgetInnerUserAt=taskBudgetInnerUserAt.add(NumberUtil.getBigDecimal(g.getBudgetCost(),zero)); 
				}
				excludeTaskIds.add(g.getId());
			} 
			taskBudgetCost=taskBudgetCost.add(taskBudgetInnerUserAt).add(taskBudgetOutUserAt).add(taskBudgetNouserAt);  

			Tips judgetTips=xmTaskService.judgetBudget(projectPhaseId, taskBudgetCost,taskBudgetInnerUserAt,taskBudgetOutUserAt,taskBudgetNouserAt,excludeTaskIds);
			if(judgetTips.isOk()) {
				for (XmTask task : xmTasks) {
					task.setChildrenCnt( Integer.valueOf(xmTasks.stream().filter(i->task.getId().equals(i.getParentTaskid())).count()+""));
				}

				xmTaskService.parentIdPathsCalcBeforeSave(xmTasks);
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
	@HasQx(value = "xm_core_xmTask_batchRelTasksWithMenu",name = "批量将任务与一个用户故事关联",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchRelTasksWithMenu",method=RequestMethod.POST)
	public Map<String,Object> batchRelTasksWithMenu(@RequestBody List<XmTask> xmTasks) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功"+xmTasks.size()+"条任务数据与用户故事关联");
		try{
			User user=LoginUtils.getCurrentUserInfo();

			if(xmTasks==null || xmTasks.size()==0){
				tips.setFailureMsg("任务列表不能为空");
				m.put("tips", tips);
				return m;
			}
			XmTask xmTask=xmTasks.get(0);
			String projectId=xmTask.getProjectId();
			if( !StringUtils.hasText(projectId) ){
				tips.setFailureMsg("项目编号不能为空");
				m.put("tips", tips);
				return m;
			}

			List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);
			if(pgroups==null || pgroups.size()==0){
				tips.setFailureMsg("该项目还未建立项目团队，请先进行团队成员维护");
				m.put("tips", tips);
				return m;
			}
			List<XmTask> allowTasks=new ArrayList<>();
			List<XmTask> noAllowTasks=new ArrayList<>();
			Map<String,XmTask> xmTaskDbMap=this.xmTaskService.selectTasksMapByTasks(xmTasks);
			for (XmTask task : xmTaskDbMap.values()) {
				if( !projectId.equals(task.getProjectId()) ){
					tips.setFailureMsg("所有任务必须同属于一个项目");
					m.put("tips", tips);
					return m;
				}
				boolean isMyCreate=user.getUserid().equals(task.getCreateUserid());
				if(isMyCreate){
					allowTasks.add(task);
				}else{
					boolean isHead=groupService.checkUserIsOtherUserTeamHead(pgroups,task.getCreateUserid(),user.getUserid());
					if(!isHead){
						noAllowTasks.add(task);
					}else {
						allowTasks.add(task);
					}
				}

			}
			if(allowTasks.size()>0){
				xmTaskService.batchRelTasksWithMenu(allowTasks);
				for (XmTask t : allowTasks) {
					xmRecordService.addXmTaskRecord(t.getProjectId(), t.getId(), "项目-任务-批量更新任务", "将任务"+t.getName()+"与故事【"+t.getMenuId()+"-"+t.getMenuName()+"】关联",JSON.toJSONString(t),null);

				}
				if(noAllowTasks.size()>0){
					tips.setOkMsg(allowTasks.size()+"个任务成功关联用户故事，另外有"+noAllowTasks.size()+"个任务无权操作，只有任务负责人、项目经理、组长可以批量将任务与用户故事进行关联");
				}

			}else{
				if(noAllowTasks.size()>0){
					tips.setFailureMsg(allowTasks.size()+"个任务成功关联用户故事，另外有"+noAllowTasks.size()+"个任务无权操作，只有任务负责人、项目经理、组长可以批量将任务与用户故事进行关联");
				}
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

			User user=LoginUtils.getCurrentUserInfo();

			if(xmTasks==null || xmTasks.size()==0){
				tips.setFailureMsg("任务列表不能为空");
				m.put("tips", tips);
				return m;
			}
			XmTask xmTask=xmTasks.get(0);
			String projectId=xmTask.getProjectId();
			if( !StringUtils.hasText(projectId) ){
				tips.setFailureMsg("项目编号不能为空");
				m.put("tips", tips);
				return m;
			}

			List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);
			if(pgroups==null || pgroups.size()==0){
				tips.setFailureMsg("该项目还未建立项目团队，请先进行团队成员维护");
				m.put("tips", tips);
				return m;
			}
			List<XmTask> allowTasks=new ArrayList<>();
			List<XmTask> noAllowTasks=new ArrayList<>();
			Map<String,XmTask> xmTaskMap=this.xmTaskService.selectTasksMapByTasks(xmTasks);
			for (XmTask task : xmTaskMap.values()) {
				if( !projectId.equals(task.getProjectId()) ){
					tips.setFailureMsg("所有任务必须同属于一个项目");
					m.put("tips", tips);
					return m;
				}
				boolean isHead=groupService.checkUserIsOtherUserTeamHead(pgroups,task.getCreateUserid(),user.getUserid());
				if(!isHead){
					noAllowTasks.add(task);
				}else {
					allowTasks.add(task);
				}

			}
			List<String> noDelList=new ArrayList<>();
			List<XmTask> delTasks=new ArrayList<>();
			allowTasks.forEach(t->{
				try {
					delTasks.add(t);
				} catch (BizException e) {
					noDelList.add(t.getName());
				}
 			});
			if(delTasks.size()>0){
				this.xmTaskService.doBatchDelete(delTasks);
			}

			if(noDelList.size()>0 && allowTasks.size()>noDelList.size()) {
				tips.setOkMsg("成功删除"+(allowTasks.size()-noDelList.size())+"条任务，其中以下任务可能存在未结算的执行人或者存在子任务，不允许删除"+StringUtils.arrayToCommaDelimitedString(noDelList.toArray()));
			}if(noDelList.size()>0 && allowTasks.size()==noDelList.size()) {
				tips.setFailureMsg("无法删除，所选任务都存在未结算执行人或者子任务");
			}else {
				tips.setOkMsg("成功删除"+allowTasks.size()+"条任务");
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
	public Map<String,Object> batchSaveBudget(@RequestBody  List<XmTask> xmTasks) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改"+xmTasks.size()+"条数据"); 
		try{
			User user=LoginUtils.getCurrentUserInfo();

			if(xmTasks==null || xmTasks.size()==0){
				tips.setFailureMsg("任务列表不能为空");
				m.put("tips", tips);
				return m;
			}
			XmTask xmTask=xmTasks.get(0);
			String projectId=xmTask.getProjectId();
			String projectPhaseId=xmTask.getProjectPhaseId();
			if( !StringUtils.hasText(projectId) ){
				tips.setFailureMsg("项目编号不能为空");
				m.put("tips", tips);
				return m;
			}
			if( !StringUtils.hasText(projectPhaseId) ){
				tips.setFailureMsg("计划编号不能为空");
				m.put("tips", tips);
				return m;
			}
			List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);
			if(pgroups==null || pgroups.size()==0){
				tips.setFailureMsg("该项目还未建立项目团队，请先进行团队成员维护");
				m.put("tips", tips);
				return m;
			}

			Map<String,XmTask> allowTasksDbMap=new HashMap<>();
			Map<String,XmTask>  noAllowTasksDbMap=new HashMap<>();
			Map<String,XmTask> xmTaskDbMap=this.xmTaskService.selectTasksMapByTasks(xmTasks);

			Map<String,XmTask> frontParamsTaskMap=new HashMap<>();
			List<XmTask> insertTasks=new ArrayList<>();
			List<XmTask> updateTasks=new ArrayList<>();
			for (XmTask task : xmTasks) {
				if( !projectId.equals(task.getProjectId()) ){
					tips.setFailureMsg("所有任务必须同属于一个项目");
					m.put("tips", tips);
					return m;
				}
				if(!projectPhaseId.equals(task.getProjectPhaseId())){
					tips.setFailureMsg("只能在同一个计划下批量修改任务");
					m.put("tips", tips);
					return m;
				}
				frontParamsTaskMap.put(task.getId(),task);
				if(xmTaskDbMap.containsKey(task.getId())){
					updateTasks.add(task);
				}else {
					task.setCreateUsername(user.getUsername());
					task.setCreateUserid(user.getUserid());
					task.setExecutorUserid(user.getUserid());
					task.setExecutorUsername(user.getUsername());
					task.setCreateTime(new Date());
					insertTasks.add(task);
				}
			}
			for (XmTask task : xmTaskDbMap.values()) {
				if( !projectId.equals(task.getProjectId()) ){
					tips.setFailureMsg("所有任务必须同属于一个项目");
					m.put("tips", tips);
					return m;
				}
				if(!projectPhaseId.equals(task.getProjectPhaseId())){
					tips.setFailureMsg("只能在同一个计划下批量修改任务");
					m.put("tips", tips);
					return m;
				}
					boolean isHead=groupService.checkUserIsOtherUserTeamHead(pgroups,task.getCreateUserid(),user.getUserid());
					if(!isHead){
						noAllowTasksDbMap.put(task.getId(),task);
					}else {
						allowTasksDbMap.put(task.getId(),task);
					}

			}

			BigDecimal taskBudgetCost=BigDecimal.ZERO;
			BigDecimal taskBudgetInnerUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetOutUserAt=BigDecimal.ZERO;
			BigDecimal taskBudgetNouserAt=BigDecimal.ZERO;
			BigDecimal zero=BigDecimal.ZERO;
			List<String> excludeTaskIds=new ArrayList<>();
			for (XmTask g : xmTasks) {
				if(noAllowTasksDbMap.containsKey(g.getId())){
					continue;
				}
				if("1".equals(g.getTaskOut())) {
					taskBudgetOutUserAt=taskBudgetOutUserAt.add(NumberUtil.getBigDecimal(g.getBudgetCost(),zero)); 
				}else { 
					taskBudgetInnerUserAt=taskBudgetInnerUserAt.add(NumberUtil.getBigDecimal(g.getBudgetCost(),zero)); 
				} 
				excludeTaskIds.add(g.getId());
			} 
			taskBudgetCost=taskBudgetCost.add(taskBudgetInnerUserAt).add(taskBudgetOutUserAt).add(taskBudgetNouserAt);  

			Tips judgetTips=xmTaskService.judgetBudget(projectPhaseId, taskBudgetCost,taskBudgetInnerUserAt,taskBudgetOutUserAt,taskBudgetNouserAt,excludeTaskIds);
			if(judgetTips.isOk()) {

				//过滤掉我没有权限的
				List<XmTask> canUpdateTasks=new ArrayList<>();
				List<XmTask> canInsertTasks=new ArrayList<>();
				for (XmTask task : updateTasks) {
					if(allowTasksDbMap.containsKey(task.getId())){
						canUpdateTasks.add(task);
					}
				}
				xmTaskService.batchInsertOrUpdate(insertTasks,canUpdateTasks);
				for (XmTask t : canUpdateTasks) {
					xmRecordService.addXmTaskRecord(t.getProjectId(), t.getId(), "项目-任务-批量修改任务预算", "修改任务预算"+t.getName(),JSON.toJSONString(t),null);

				}
				for (XmTask t : canInsertTasks) {
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
