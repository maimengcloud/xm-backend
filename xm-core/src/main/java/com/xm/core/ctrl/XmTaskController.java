package com.xm.core.ctrl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mdp.audit.log.client.annotation.AuditLog;
import com.mdp.audit.log.client.annotation.OperType;
import com.mdp.core.entity.Result;
import com.mdp.core.entity.Tips;
import com.mdp.core.query.QueryTools;
import com.mdp.core.utils.BaseUtils;
import com.mdp.core.utils.NumberUtil;
import com.mdp.core.utils.RequestUtils;
import com.mdp.msg.client.PushNotifyMsgService;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.sensitive.SensitiveWordService;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.PubTool;
import com.xm.core.entity.*;
import com.xm.core.queue.XmTaskSumParentsPushService;
import com.xm.core.service.*;
import com.xm.core.service.client.SysClient;
import com.xm.core.service.push.XmPushMsgService;
import com.xm.core.vo.*;
import io.swagger.annotations.*;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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
@Api(tags={"任务操作接口"})
public class XmTaskController {
	
	static Log logger=LogFactory.getLog(XmTaskController.class);
 
	
	@Autowired
	private XmTaskService xmTaskService;
	
	@Autowired
	XmGroupService groupService;
	
	@Autowired
	private XmRecordService xmRecordService;
	
	@Autowired
	private XmPushMsgService xmPushMsgService;
	@Autowired
	private XmProjectService xmProjectService;
	@Autowired
	private XmProjectQxService projectQxService;

	@Autowired
	XmMenuService xmMenusService;

	@Autowired
	XmMenuOperQxService menuOperQxService;

	@Autowired
	XmProductService xmProductService;

	@Autowired
	XmTaskSumParentsPushService pushService;

	@Autowired
	XmTaskExecuserController execuserController;

	@Autowired
	SensitiveWordService sensitiveWordService;


	@Autowired
	PushNotifyMsgService notifyMsgService;

	@Autowired
	SysClient sysClient;


	Map<String,Object> fieldsMap = BaseUtils.toMap(new XmTask());
	Map<String,Object> fieldNameMap=map("id","任务编号","name","任务名称","parentTaskid","父任务编号","parentTaskname","父任务名称","projectId","项目编号","projectName","项目名称","level","任务级别","sortLevel","序号","executorUserid","任务执行人编号","executorUsername","任务执行人","preTaskid","前置任务编号","preTaskname","前置任务名称","startTime","任务开始时间","endTime","任务结束时间","milestone","里程碑","description","任务描述","remarks","备注","createUserid","任务创建人编号（谁创建谁负责）","createUsername","任务创建人（谁创建谁负责）","createTime","创建时间","rate","任务进度0-100（=实际工时/(实际工时+剩余工时)*100）","budgetAt","当前任务预算金额（calc_type=2时预算工时*单价，calc_type=1时下级汇总）","budgetWorkload","预算工时（calc_type=2时手工填写，calc_type=1时下级汇总）","actAt","当前任务实际费用金额（calc_type=2时，取实际工时*单价，calc_type=1时取下级汇总数据）待结算金额","actWorkload","任务取工时表报工工时汇总，","taskState","任务状态0待领取1已领取执行中2已完工3已结算4已关闭","taskType","0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType","taskClass","1需结算0不需结算","toTaskCenter","是否发布到任务大厅0否1是,1时互联网可访问","actStartTime","实际开始时间-任务状态变成执行中的时间","actEndTime","实际结束时间-任务状态变成完工状态时的时间","bizProcInstId","当前流程实例编号","bizFlowState","当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除","phaseId","项目阶段编号(作废)","phaseName","项目阶段名称(作废)","taskSkillNames","技能列表,逗号分隔","exeUsernames","执行人列表逗号分隔如陈x(审核人),王x(监控人)","taskSkillIds","技能编号列表逗号分隔","exeUserids","执行人编号列表逗号分隔如u1(1),u2(2)","taskOut","执行方式-0内研1外购","planType","计划类型w1-周,w2-2周,w3-3周,m1-1月,m2-2月,q1-季,q2-半年，y1-年","settleSchemel","任务结算方案-来自数字字典xmTaskSettleSchemel","menuId","归属功能编号","menuName","归属功能名称","productId","产品编号根据功能变化带进","cbranchId","创建机构","cdeptid","创建部门","tagIds","标签编号，逗号分割","tagNames","标签名称，逗号分割","ntype","节点类型0-任务，1-计划。计划下可建立计划和任务，任务下不允许再扩展。也就是非叶子节点都是计划，叶子节点有可能是计划或者任务","childrenCnt","儿子节点个数","ltime","更新时间","pidPaths","父级id逗号分割，最后一个为本节点节点编号,以,号结尾","lvl","层级0-顶级，1-一级，2-二级，3-三级，4-四级。总共5级","isTpl","是否为模板","keyPath","是否为关键路径上的节点","uniInnerPrice","内部单位工时单价","uniOutPrice","外部单位工时单价","calcType","数据统计方式","ptype","计划分类0-项目，1产品,空为不区分","wtype","报工方式1-强制每日报工，2-工期内报工，0-无需报工","bctrl","报工限制0-不限制，1-不得超出预估工时","initWorkload","原始预估工作量，budget_workload发生变化后，进行备份","shareFee","分享赚佣金","oshare","开启分享赚功能0-否1是","crowd","是否众包0否1是，众包属于外购的一种");

	@ApiOperation( value = "查询任务信息列表",notes="listXmTask,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiEntityParams(XmTask.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderyBy = sex desc, student_id desc",required=false)
	})
	@ApiResponses({
			@ApiResponse(code = 200,response= XmTask.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/getTask",method=RequestMethod.GET)
	public Result getTask(@ApiIgnore @RequestParam Map<String,Object> params){
		
		RequestUtils.transformArray(params, "ids");
		RequestUtils.transformArray(params, "skillIds");
		RequestUtils.transformArray(params, "tagIdList");
		RequestUtils.transformArray(params, "lvls");		
		IPage page=QueryTools.initPage(params);
		String taskOut= (String) params.get("taskOut");
		String projectId= (String) params.get("projectId");
		String myExecuserStatus= (String) params.get("myExecuserStatus");
		String isMy= (String) params.get("isMy");
		String myFocus= (String) params.get("myFocus");
		String createUserid= (String) params.get("createUserid");
		String executorUserid= (String) params.get("executorUserid");
		String menuId= (String) params.get("menuId");
		String productId= (String) params.get("productId");
		String iterationId= (String) params.get("iterationId");
		User user = LoginUtils.getCurrentUserInfo();
		params.put("userid",user.getUserid());
		if( !(StringUtils.hasText(projectId)
				|| StringUtils.hasText(myExecuserStatus)|| StringUtils.hasText(isMy)|| StringUtils.hasText(myFocus)|| StringUtils.hasText(createUserid)
				|| StringUtils.hasText(executorUserid) || StringUtils.hasText(menuId) || StringUtils.hasText(productId)|| StringUtils.hasText(iterationId)) ){

			params.put("compete",user.getUserid());
		}
		QueryWrapper<XmTask> qw = QueryTools.initQueryWrapper(XmTask.class , params);
		List<Map<String,Object>> datas = xmTaskService.getTask(page,qw,params);	//列出XmTask列表
 		if("1".equals(params.get("withParents"))  && !"1".equals(params.get("isTop"))&& datas.size()>0){
			Set<String> pidPathsSet=new HashSet<>();
			Set<String> idSet=new HashSet<>();
			for (Map<String, Object> map : datas) {
				String id= (String) map.get("id");
				idSet.add(id);
				String pidPaths= (String) map.get("pidPaths");
				if(pidPaths==null || pidPaths.length()<=2){
					continue;
				}
				pidPathsSet.addAll(PubTool.getPidSet(pidPaths,id));
			}
			List<String> ids=pidPathsSet.stream().filter(i->!idSet.contains(i)).collect(Collectors.toList());
			if(ids!=null && ids.size()>0){
				QueryWrapper qw2=new QueryWrapper();
				qw2.in("id",ids.toArray());
				List<Map<String,Object>> parentList=xmTaskService.listMaps(qw2);
 				if(parentList!=null && parentList.size()>0){
					datas.addAll(parentList);
					return Result.ok().setData(datas).setTotal(page.getSize()+parentList.size());
				}
			}
		}
		return Result.ok().setData(datas).setTotal(page.getSize());
		
		
		
	}


	@ApiOperation(  value = "查询任务信息列表-互联网大厅首页专用、免登录", notes="listXmTask,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiEntityParams(XmTask.class) 
	@ApiImplicitParams({
 			@ApiImplicitParam(name="pageSize",value="每页大小，默认20条",dataType = "int" ,required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",dataType = "int" ,required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",dataType = "int" ,required=false),			@ApiImplicitParam(name="count",value="是否进行总记录数计算，默认是计算，如果需要关闭，请上送count=false",dataType = "int" ,required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student desc",dataType = "string" ,required=false),
 	}) 
	@ApiResponses({
			@ApiResponse(code = 200,response= XmTask.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/getOutTask",method=RequestMethod.GET)
	public Result getOutTask(@ApiIgnore @RequestParam Map<String,Object> params){
		RequestUtils.transformArray(params, "skillIds");		
		IPage page=QueryTools.initPage(params);
		params.put("taskOut","1");
		params.put("ntype","0");
		params.put("toTaskCenter","1");

		QueryWrapper<XmTask> qw = QueryTools.initQueryWrapper(XmTask.class , params);
		List<Map<String,Object>> datas=xmTaskService.getTask(page,qw,params);

		return Result.ok().setData(datas).setTotal(page.getTotal());
		
		
	}
	@RequestMapping(value="/getXmTaskAttDist",method=RequestMethod.GET)
	public Result getXmTaskAttDist(@ApiIgnore @RequestParam Map<String,Object> params){
		User user=LoginUtils.getCurrentUserInfo();
		params.put("pbranchId",user.getBranchId());

		IPage page=QueryTools.initPage(params);
		QueryWrapper<XmTask> qw = QueryTools.initQueryWrapper(XmTask.class , params);
		List<Map<String,Object>> datas= this.xmTaskService.getXmTaskAttDist(page,qw,params);
		return Result.ok("ok","成功").setData(datas).setTotal(page.getTotal());
	}

	@RequestMapping(value="/getXmTaskAgeDist",method=RequestMethod.GET)
	public Result getXmTaskAgeDist(@ApiIgnore @RequestParam Map<String,Object> params){
		User user=LoginUtils.getCurrentUserInfo();
		params.put("pbranchId",user.getBranchId());

		QueryWrapper<XmTask> qw = QueryTools.initQueryWrapper(XmTask.class , params);
		List<Map<String,Object>> datas= this.xmTaskService.getXmTaskAgeDist(qw,params);
		return Result.ok("ok","成功").setData(datas).setTotal(datas.size());
	}


	@ApiOperation("批量更新任务的浏览量")
	@RequestMapping(value="/upBrowseTimes",method=RequestMethod.POST)
	public Result upBrowseTimes(  @RequestBody List<UpBrowseTimesVo> browseTimesVos){
		User user=LoginUtils.getCurrentUserInfo();
		if(browseTimesVos!=null && browseTimesVos.size()>0){
			for (UpBrowseTimesVo browseTimesVo : browseTimesVos) {
				XmTaskCalcService.putReadNum(browseTimesVo.getTaskId(),browseTimesVo.getNums());
			}
		}

		return Result.ok("成功");
	}

	@ApiOperation("统计所有上级的进度情况")
	@RequestMapping(value="/calcProgress",method=RequestMethod.POST)
	public Result calcProgress( @ApiIgnore @RequestBody XmTask xmTask){
		User user=LoginUtils.getCurrentUserInfo();
		XmTask xmTaskDb=this.xmTaskService.selectOneById(xmTask.getId());
		this.xmTaskService.sumParents(xmTaskDb);
		return Result.ok("成功");
	}
	@RequestMapping(value="/getXmTaskSort",method=RequestMethod.GET)
	public Result getXmTaskSort(@ApiIgnore @RequestParam Map<String,Object> params){
		User user=LoginUtils.getCurrentUserInfo();		
		IPage page=QueryTools.initPage(params);
		params.put("pbranchId",user.getBranchId());
		QueryWrapper<XmTask> qw = QueryTools.initQueryWrapper(XmTask.class , params);
		List<Map<String,Object>> datas= this.xmTaskService.getXmTaskSort(page,qw,params);
		return Result.ok().setData(datas).setTotal(page.getTotal());
		
		
	}
	/***/
	@ApiOperation( value = "根据主键批量修改修改任务中的某些字段信息",notes="editXmMenu")
	@ApiEntityParams( value = XmTask.class, props={ }, remark = "任务", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMenu.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	//@HasQx(value = "xm_core_xmTask_editSomeFields",name = "批量修改修改任务中的某些字段",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Result editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmTaskMap) {

			User user = LoginUtils.getCurrentUserInfo();
			List<String> ids= (List<String>) xmTaskMap.get("ids");

			if(ids==null || ids.size()==0){
				return Result.error("ids-0","ids不能为空");
			}
			if(xmTaskMap.containsKey("executorUserid")){
				if(ids.size()>1){
					List<Tips> errs=new ArrayList<>();
					List<Tips> oks=new ArrayList<>();
					String msg="";
					for (String id : ids) {
						XmTaskExecuser xmTaskExecuser=new XmTaskExecuser();
						xmTaskExecuser.setTaskId(id);
						xmTaskExecuser.setBidUserid((String)xmTaskMap.get("executorUserid"));
						xmTaskExecuser.setBidUsername((String)xmTaskMap.get("executorUsername"));
						Map<String,Object> result=execuserController.addXmTaskExecuser(xmTaskExecuser);
		 				Tips tips= (Tips) result.get("tips");
		 				tips.put("taskId",id);
						if(!tips.isOk()){
							errs.add(tips);
						}else{
							oks.add(tips);
						}


					}
	 				Tips returnTips=new Tips();

					if(errs.size()>0){
						msg="以下"+errs.size()+"个任务更新不成功："+errs.stream().map(i->"["+i.get("taskId")+"]"+i.getMsg()).collect(Collectors.joining(";"));
					}
					if(oks.size()>0){
						msg="成功设置"+oks.size()+"个任务的执行人。"+msg;
						return Result.ok(msg);
					}
					return Result.ok();
				}else if(ids.size()==1){
					XmTaskExecuser xmTaskExecuser=new XmTaskExecuser();
					xmTaskExecuser.setTaskId(ids.get(0));
					xmTaskExecuser.setBidUserid((String)xmTaskMap.get("executorUserid"));
					xmTaskExecuser.setBidUsername((String)xmTaskMap.get("executorUsername"));
					return execuserController.addXmTaskExecuser(xmTaskExecuser);
				}
			}
			Set<String> fields=new HashSet<>();
			fields.add("childrenCnt");
			fields.add("ntype");
			fields.add("pidPaths");
			fields.add("parentTaskid");
			fields.add("parentTaskname");
			fields.add("executorUserid");
			fields.add("quoteFinalAt");
			for (String fieldName : xmTaskMap.keySet()) {
				if(fields.contains(fieldName)){
					return Result.error(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmTaskMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmTaskMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return Result.error("fieldKey-0","没有需要更新的字段");
 			}
			if(fieldKey.contains("budgetAt") && ids.size()>1){
				return Result.error("ids-to0-more","修改预算只能一次修改一条数据");
			}
			XmTask xmTask= BaseUtils.fromMap(xmTaskMap,XmTask.class);
			List<XmTask> xmTasksDb=xmTaskService.selectListByIds(ids);
			if(xmTasksDb==null ||xmTasksDb.size()==0){
				return Result.error("tasks-0","该任务已不存在");
			}
			Map<String,XmProject> projectMap=new HashMap<>();
			
			if(xmTaskMap.containsKey("createUserid")){
				String createUserid=(String) xmTaskMap.get("createUserid");
				String createUsername=(String) xmTaskMap.get("createUsername");
				String cbranchId=(String) xmTaskMap.get("cbranchId");
				Set<String> projects=xmTasksDb.stream().map(i->i.getProjectId()).collect(Collectors.toSet());
				for (String project : projects) {
					XmProject xmProject=xmProjectService.getProjectFromCache(project);
					projectMap.put(xmProject.getId(),xmProject);
	 				Tips  tips1=projectQxService.checkProjectQx(xmProject,2,user,createUserid,createUsername,cbranchId);
					Result.assertIsFalse(tips1);
				}

			}

			List<XmTask> can=new ArrayList<>();
			List<XmTask> no=new ArrayList<>();
			for (XmTask xmTaskDb : xmTasksDb) {
				XmProject xmProject=projectMap.get(xmTaskDb.getProjectId());
				if(xmProject==null || StringUtils.isEmpty(xmProject.getId()) || !projectMap.containsKey(xmProject.getId())){
					xmProject=xmProjectService.getProjectFromCache(xmTaskDb.getProjectId());
					projectMap.put(xmTaskDb.getProjectId(),xmProject);
				}
				if(groupService.checkUserIsProjectAdm(xmProject,user.getUserid())){
					can.add(xmTaskDb);
				}else{
	 				Tips tips =projectQxService.checkProjectQx(xmProject,2,user,xmTaskDb.getCreateUserid(),xmTaskDb.getCreateUsername(),xmTaskDb.getCbranchId());
					if(!tips.isOk()){
						no.add(xmTaskDb);
					}else{
						can.add(xmTaskDb);
					}
				}
			}

			if(can.size()>0 && fieldKey.contains("budgetAt")){

				XmTask taskDb=can.get(0);
				XmProject xmProject=projectMap.get(taskDb.getProjectId());
				BigDecimal budgetAt=NumberUtil.getBigDecimal(xmTaskMap.get("budgetAt"),BigDecimal.ZERO);
				if(xmProject.getMaxTaskAmt()!=null && xmProject.getMaxTaskAmt().compareTo(BigDecimal.ZERO)>0){
					if(budgetAt.compareTo(xmProject.getMaxTaskAmt())>0){
						return Result.error("budgetAt-maxTaskAmt-0",String.format("单个任务的金额超出预算。每个任务的预算最大为%s元",xmProject.getMaxTaskAmt()));
					}
				}
				if("1".equals(xmProject.getBudgetCtrl())){
					if(taskDb.getLvl()<=1){
		 				Tips tips =this.xmTaskService.judgetProjectBudget(taskDb.getProjectId(),budgetAt,Arrays.asList(taskDb.getId()));
		 				Result.assertIsFalse(tips);
					}else {
		 				Tips tips =this.xmTaskService.judgetTaskBudget(taskDb.getParentTaskid(),budgetAt,null,null,null,Arrays.asList(taskDb.getId()));
						Result.assertIsFalse(tips);

					}
				}
			}
			List<XmTask> noExecs=new ArrayList<>();
			if(can.size()>0 && xmTaskMap.containsKey("taskState")){
				String taskState= (String) xmTaskMap.get("taskState");
				if( StringUtils.hasText(taskState)  && !"0".equals(taskState) && !"9".equals(taskState)){
					for (XmTask task : can) {
						if("0".equals(task.getNtype()) && !StringUtils.hasText(task.getExecutorUserid()) && ("0".equals(task.getTaskState())||!StringUtils.hasText(task.getTaskState()))){
							noExecs.add(task);
						}
					}
				}
			}
			can=can.stream().filter(i->!noExecs.stream().filter(k->k.getId().equals(i.getId())).findAny().isPresent()).collect(Collectors.toList());
			if(can.size()>0 && xmTaskMap.containsKey("taskState")){
				String taskState= (String) xmTaskMap.get("taskState");
				if("3".equals(taskState)||"4".equals(taskState)||"9".equals(taskState)){
					xmTaskMap.put("endTime",new Date());
					xmTaskMap.put("actEndTime",new Date());
				}
			}
			if(can.size()>0){
				xmTaskMap.put("ids",can.stream().map(i->i.getId()).collect(Collectors.toList()));

					if(fieldKey.contains("budgetWorkload")){//如果调整了预估工时，需要重新计算进度数据
						if(xmTasksDb.size()>0){
							this.xmTaskService.batchUpdateBudgetWorkloadAndRate(xmTasksDb.stream().map(i->i.getId()).collect(Collectors.toSet()).stream().collect(Collectors.toList()),NumberUtil.getBigDecimal(xmTaskMap.get("budgetWorkload")));
							pushService.pushXmTasks(xmTasksDb);
						}
					}else {
						xmTaskService.editSomeFields(xmTaskMap);
					}
				for (XmTask task : can) {
					xmRecordService.addXmTaskRecord(task.getProjectId(),task.getId(),"项目-任务-批量修改","修改任务"+task.getName(),"", JSON.toJSONString(xmTask));
				}
				if(xmTaskMap.containsKey("createUserid")){
					String createUserid= (String) xmTaskMap.get("createUserid");
					String createUsername= (String) xmTaskMap.get("createUsername");
					for (XmTask task : can) {
						if(!user.getUserid().equals(createUserid) && !"0".equals(task.getStatus())) {
							notifyMsgService.pushMsg(user, createUserid, createUsername, "您成为任务【" + task.getName() + "】的负责人，请注意跟进。",null);
						}
					}
				}


			}
			List<String> msgs=new ArrayList<>();
			if(can.size()>0){
				msgs.add(String.format("成功更新%s个任务",can.size()));
			}
			if(no.size()>0){
				msgs.add(String.format("以下%s个任务无权限更新,【%s】。",no.size(),no.stream().map(i->i.getName()).collect(Collectors.joining(","))));
			}
			if(noExecs.size()>0){
				msgs.add(String.format("以下%s个任务未设置执行人，不能变更为待执行状态,【%s】。",noExecs.size(),noExecs.stream().map(i->i.getName()).collect(Collectors.joining(","))));
			}
			if(can.size()>0){
				return Result.ok(msgs.stream().collect(Collectors.joining()));
			}else {
				return Result.error(msgs.stream().collect(Collectors.joining()));
			} 
		
	}



	@ApiOperation( value = "查询互联网开放的任务的信息详情，免登录",notes="taskDetail,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiEntityParams(value = XmTask.class,props = {"id"})
	@ApiResponses({
			@ApiResponse(code = 200,response= XmTask.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/shareTaskDetail",method=RequestMethod.GET)
	public Result shareTaskDetail(@ApiIgnore @RequestParam Map<String,Object> params){
		
		
		String id=(String) params.get("id");
		String shareKey= (String) params.get("shareKey");
		if(!StringUtils.hasText(id)){
			return Result.error("任务编号id必传");
		}
		if(!StringUtils.hasText(shareKey)){
			//return Result.error("分享码shareKey必传");
		}

			Map<String,Object> taskDb= xmTaskService.shareTaskDetail(params);
			//  检测任务是否可被查询
			if(taskDb==null|| taskDb.isEmpty()){
				return Result.error("data-0","数据不存在");
			}
			String toTaskCenter= (String) taskDb.get("toTaskCenter");
			String crowd= (String) taskDb.get("crowd");

			if( ! "1".equals(crowd) ){
				return Result.error("crowd-0","非众包任务，无权查看");
			}
			if( ! "1".equals(toTaskCenter)){
				return Result.error("toTaskCenter-0","未开放互联网访问权限");
			}
			XmTaskCalcService.putReadNum((String) taskDb.get("id"),1);
			return Result.ok().setData(taskDb);
		
	}


	@ApiOperation( value = "查询任务的信息详情，必须登录",notes="taskDetail,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiEntityParams(value = XmTask.class,props = {"id"})
	@ApiResponses({
			@ApiResponse(code = 200,response= XmTask.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/taskDetail",method=RequestMethod.GET)
	public Result taskDetail(@ApiIgnore @RequestParam Map<String,Object> params){
		
		
		String id=(String) params.get("id");
		if(!StringUtils.hasText(id)){
			return Result.error("任务编号id必传");
		}

			Map<String,Object> taskDb= xmTaskService.shareTaskDetail(params);
			//  检测任务是否可被查询
			if(taskDb==null|| taskDb.isEmpty()){
				return Result.error("data-0","数据不存在");
			}
			XmTaskCalcService.putReadNum((String) taskDb.get("id"),1);

			return Result.ok().setData(taskDb);
		
	}
	@ApiOperation( value = "新增一条任务信息",notes="addXmTask,主键如果为空，后台自动生成")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTask.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	//@HasQx(value = "xm_core_xmTask_addTask",name = "新增任务",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/addTask",method=RequestMethod.POST)
	public Result addTask(@RequestBody XmTaskVo xmTaskVo) {



			if(!StringUtils.hasText(xmTaskVo.getNtype())){
				return Result.error("节点类型ntype不能为空");
				
			}
			if(!StringUtils.hasText(xmTaskVo.getProjectId())){
				return Result.error("projectId-0","项目编号不能为空");
			}

			Set<String> words=sensitiveWordService.getSensitiveWord(xmTaskVo.getName());
			if(words!=null && words.size()>0){
				return Result.error("name-sensitive-word","名字有敏感词"+words+",请修改后再提交");
			}
			words=sensitiveWordService.getSensitiveWord(xmTaskVo.getRemarks());
			if(words!=null && words.size()>0){
				return Result.error("remark-sensitive-word","备注中有敏感词"+words+",请修改后再提交");
			}
			words=sensitiveWordService.getSensitiveWord(xmTaskVo.getDescription());
			if(words!=null && words.size()>0){
				return Result.error("description-sensitive-word","详情中有敏感词"+words+",请修改后再提交");
			}


			User user=LoginUtils.getCurrentUserInfo();
			if(StringUtils.isEmpty(xmTaskVo.getCreateUserid())){
				xmTaskVo.setCreateUserid(user.getUserid());
				xmTaskVo.setCreateUsername(user.getUsername());
			}

			XmProject xmProject=xmProjectService.getProjectFromCache(xmTaskVo.getProjectId());
			Tips tips1=projectQxService.checkProjectQx(xmProject,2,user);
			Result.assertIsFalse(tips1);
			if(StringUtils.hasText(xmTaskVo.getCreateUserid()) && !xmTaskVo.getCreateUserid().equals(user.getUserid())){
 				tips1=projectQxService.checkProjectQx(xmProject,2,user,xmTaskVo.getCreateUserid(),xmTaskVo.getCreateUsername(),null);
				Result.assertIsFalse(tips1);
			}

			if("1".equals(xmProject.getMenuLink()) && "0".equals(xmTaskVo.getNtype())){
				if(!StringUtils.hasText(xmTaskVo.getMenuId())){
					return Result.error("menuId-0","该项目配置了任务必须关联需求，请关联需求后再提交");
				}
			}
			if("1".equals(xmProject.getPhaseLink()) && "0".equals(xmTaskVo.getNtype())){
				if(!StringUtils.hasText(xmTaskVo.getParentTaskid())){
					return Result.error("parentTaskid-0","该项目配置了任务必须关联上级计划，请关联计划后再提交");
				}
			}
			xmTaskVo.setPbranchId(xmProject.getBranchId());
			xmTaskVo.setExecutorUserid(null);
			xmTaskVo.setExecutorUsername(null);
			xmTaskVo.setExeUserids(null);
			xmTaskVo.setExeUsernames(null);
			xmTaskVo.setTagIds(null);
			xmTaskVo.setTaskSkillIds(null);
			xmTaskVo.setTaskSkillNames(null);
			xmTaskVo.setTagNames(null);
			xmTaskVo.setCreateTime(new Date());
			xmTaskVo.setCbranchId(user.getBranchId());
			xmTaskVo.setCdeptid(user.getDeptid());
			xmTaskVo.setTaskState("0");
			xmTaskVo.setEstate("0");
			xmTaskVo.setRate(0);

			if(xmTaskVo.getStartTime()==null){
				xmTaskVo.setStartTime( xmTaskVo.getCreateTime());
			}
			if(xmTaskVo.getEndTime()==null){
				xmTaskVo.setEndTime(DateUtils.addDays(xmTaskVo.getCreateTime(),14));
			}
			if( !StringUtils.hasText(xmTaskVo.getMilestone()) ){
				xmTaskVo.setMilestone("0");
			}
			if(xmTaskVo.getBudgetAt()==null){
				xmTaskVo.setBudgetAt(BigDecimal.ZERO);
			}
			if(StringUtils.isEmpty(xmTaskVo.getId())) {
				xmTaskVo.setId(this.xmTaskService.createKey("id"));
			}else{
				XmTask xmTaskQuery = new  XmTask(xmTaskVo.getId());
				if(this.xmTaskService.countByWhere(xmTaskQuery)>0){
					return Result.error("编号重复，请修改编号再提交");
				}
			}
			this.xmTaskService.parentIdPathsCalcBeforeSave(xmTaskVo);
			if("1".equals(xmProject.getBudgetCtrl())){
				if(xmTaskVo.getBudgetAt()!=null  && xmTaskVo.getBudgetAt().compareTo(BigDecimal.ZERO)>0){
					if(xmTaskVo.getLvl()<=1){
		 				Tips tips =xmTaskService.judgetProjectBudget(xmTaskVo.getProjectId(),xmTaskVo.getBudgetAt(),null);
						Result.assertIsFalse(tips);
					}else{
		 				Tips tips =xmTaskService.judgetTaskBudget(xmTaskVo.getParentTaskid(), xmTaskVo.getBudgetAt(),null,null,null,null);
						Result.assertIsFalse(tips);
					}
				}
			}

			//新增任务技能
			if(xmTaskVo.getSkills()!=null && xmTaskVo.getSkills().size()>0){
				for (XmTaskSkill skill : xmTaskVo.getSkills()) {
					if(!StringUtils.hasText(skill.getSkillId())){
						return Result.error("skillId-0","标签编号不能为空");
					}
					if(!StringUtils.hasText(skill.getSkillName())){
						return Result.error("skillName-0","标签名称不能为空");
					}
					/**
					 *  这个不控制
					if(!StringUtils.hasText(skill.getCategoryId())){
						return Result.error("categoryId-0","标签分类不能为空");
					}
					 */
				}
			}
			xmTaskVo = xmTaskService.addTask(xmTaskVo);
			
		return Result.ok().setData(xmTaskVo);
		
	}


	
	@ApiOperation( value = "查询任务信息列表",notes="listXmTask,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiEntityParams(XmTask.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false)
	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTask.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Result listXmTask(@ApiIgnore @RequestParam Map<String,Object> params){
		 
		RequestUtils.transformArray(params, "ids");
		RequestUtils.transformArray(params, "tagIdList");		
		IPage page=QueryTools.initPage(params);

		String taskOut= (String) params.get("taskOut");
		if(!"1".equals(taskOut)){
			String projectId= (String) params.get("projectId");
			String userid= (String) params.get("userid");
			if( !(StringUtils.hasText(projectId) || StringUtils.hasText(userid) ) ){
				User user = LoginUtils.getCurrentUserInfo();
				params.put("cbranchId",user.getBranchId());
			}
		}
		QueryWrapper<XmTask> qw = QueryTools.initQueryWrapper(XmTask.class , params);
		List<Map<String,Object>> datas = xmTaskService.selectListMapByWhere(page,qw,params);
			return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());	//列出XmTask列表
		
	}
	
	@ApiOperation( value = "删除一条任务信息",notes="delXmTask,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	//@HasQx(value = "xm_core_xmTask_del",name = "删除任务",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Result delXmTask(@RequestBody XmTask xmTask){

			User user=LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmTask.getId())){
				return Result.error("任务编号不能为空");
				
			}
			XmTask xmTaskDb=this.xmTaskService.selectOneObject(xmTask);
			if(xmTaskDb==null){
				return Result.error("data-0","数据已不存在");
			}
			if(xmTaskDb.getChildrenCnt()!=null && xmTaskDb.getChildrenCnt()>0){
				return Result.error("childrenCnt-no-0","有子计划任务不能删除");
			}

			XmProject xmProject=xmProjectService.getProjectFromCache(xmTaskDb.getProjectId());
			if(xmProject!=null && groupService.checkUserIsProjectAdm(xmProject,user.getUserid())){
 				Tips tips1=projectQxService.checkProjectQx(xmProject,2,user,xmTaskDb.getCreateUserid(),xmTaskDb.getCreateUsername(),xmTaskDb.getCbranchId());
				 Result.assertIsFalse(tips1);
			}


			if(xmTaskService.checkExistsExecuser(xmTaskDb)){
				return Result.error("existsExecuser","有待验收、待结算的执行人，不能删除");
			};


			xmTaskService.deleteTask(xmTaskDb);
			xmRecordService.addXmTaskRecord(xmTaskDb.getProjectId(), xmTaskDb.getId(), "项目-任务-删除任务", "删除任务"+xmTaskDb.getName());

		return Result.ok();  
		
	}

	@ApiOperation( value = "根据主键修改一条任务信息",notes="setTaskCreateUser")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTask.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	////@HasQx(value = "xm_core_xmTask_setTaskCreateUser",name = "修改任务责任人",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/setTaskCreateUser",method=RequestMethod.POST)
	public Result setTaskCreateUser(@RequestBody XmTaskVo xmTaskVo) {

			User user=LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmTaskVo.getId())){
				return Result.error("任务编号不能为空");
				
			}
			XmTask xmTaskDb=this.xmTaskService.selectOneObject(xmTaskVo);
			if(xmTaskDb==null){
				return Result.error("该任务不存在");
				
			}


			XmProject xmProject=xmProjectService.getProjectFromCache(xmTaskDb.getProjectId());
			
			if(!groupService.checkUserIsProjectAdm(xmProject,user.getUserid())){
 				Tips tips1=projectQxService.checkProjectQx(xmProject,2,user,xmTaskDb.getCreateUserid(),xmTaskDb.getCreateUsername(),xmTaskDb.getCbranchId());
				Result.assertIsFalse(tips1);
			}

			Tips tips1=projectQxService.checkProjectQx(xmProject,2,user,xmTaskVo.getCreateUserid(),xmTaskVo.getCreateUsername(),xmTaskVo.getCbranchId());
			Result.assertIsFalse(tips1);
			XmTask xmTask=new XmTask(xmTaskVo.getId());
			xmTask.setCreateUserid(xmTaskVo.getCreateUserid());
			xmTask.setCreateUsername(xmTaskVo.getCreateUsername());
			xmTask.setCbranchId(xmTaskVo.getCbranchId());
			 this.xmTaskService.updateSomeFieldByPk(xmTask);
			 this.xmRecordService.addXmTaskRecord(xmTaskDb.getProjectId(),xmTaskDb.getId(),"项目-任务-修改任务责任人","修改任务【"+xmTaskDb.getName()+"】责任人。原责任人【"+xmTaskDb.getCreateUsername()+"】，新责任人【"+xmTask.getCreateUsername()+"】");
			
		return Result.ok();
		
	}
	@ApiOperation( value = "根据主键修改一条任务信息",notes="editXmTask")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTask.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	//@HasQx(value = "xm_core_xmTask_editXmTask",name = "修改任务",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Result editXmTask(@RequestBody XmTaskVo xmTaskVo) {

			User user=LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmTaskVo.getId())){
				return Result.error("任务编号不能为空");
				
			}

			XmTask xmTaskDb=this.xmTaskService.selectOneObject(xmTaskVo);
			if(xmTaskDb==null){
				return Result.error("data-0","任务已不存在");
			}
			if("1".equals(xmTaskDb.getNtype())){
				 if("0".equals(xmTaskVo.getNtype()) && xmTaskDb.getChildrenCnt()!=null && xmTaskDb.getChildrenCnt()>0){
					 return Result.error("ntype-not-right","当前为计划节点，并且具有"+xmTaskDb.getChildrenCnt()+"个子节点，不能变更为任务节点");
				 }
			}else{
				if(xmTaskDb.getChildrenCnt()!=null && xmTaskDb.getChildrenCnt()>0){
					xmTaskVo.setNtype("1");
				}
			}

			XmProject xmProject=xmProjectService.getProjectFromCache(xmTaskDb.getProjectId());
			Tips tips1=projectQxService.checkProjectQx(xmProject,2,user,xmTaskDb.getCreateUserid(),xmTaskDb.getCreateUsername(),xmTaskDb.getCbranchId());
			Result.assertIsFalse(tips1);

			this.xmTaskService.parentIdPathsCalcBeforeSave(xmTaskVo);
			if(xmTaskVo.getBudgetAt()==null)xmTaskVo.setBudgetAt(BigDecimal.ZERO);
			if(xmTaskDb.getBudgetAt()==null)xmTaskDb.setBudgetAt(BigDecimal.ZERO);
			List<String> excludeIds=new ArrayList<>();
			excludeIds.add(xmTaskDb.getId());
			if( "1".equals(xmProject.getBudgetCtrl()) && xmTaskDb.getBudgetAt().compareTo(xmTaskVo.getBudgetAt())!=0){
				if(xmTaskVo.getLvl()<=1){
	 				Tips tips =xmTaskService.judgetProjectBudget(xmTaskDb.getProjectId(), xmTaskVo.getBudgetAt(),excludeIds);
	 				Result.assertIsFalse(tips);
				}else if(StringUtils.hasText(xmTaskDb.getParentTaskid())){
	 				Tips tips =xmTaskService.judgetTaskBudget(xmTaskDb.getParentTaskid(), xmTaskVo.getBudgetAt(),null,null,null,excludeIds);
					Result.assertIsFalse(tips);

				}
			}

			xmTaskService.updateTask(xmTaskVo,xmTaskDb);
			
		return Result.ok().setData(xmTaskVo);
		
	}
	@ApiOperation( value = "根据主键修改一条任务信息",notes="editXmTask")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTask.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	//@HasQx(value = "xm_core_xmTask_editTime",name = "修改任务时间",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/editTime",method=RequestMethod.POST)
	public Result editTime(@RequestBody XmTask xmTask) {

			User user=LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmTask.getId())){
				return Result.error("任务编号不能为空");
				
			}
			XmTask xmTaskDb=xmTaskService.selectOneObject(xmTask);
			if(xmTaskDb==null){
				return Result.error("data-0","任务已不存在");
			}
			XmProject xmProject=xmProjectService.getProjectFromCache(xmTaskDb.getProjectId());
			
			Tips tips1=projectQxService.checkProjectQx(xmProject,2,user,xmTaskDb.getCreateUserid(),xmTaskDb.getCreateUsername(),xmTaskDb.getCbranchId());
			if(!tips1.isOk()){
 				tips1=projectQxService.checkProjectQx(xmProject,2,user,xmTaskDb.getExecutorUserid(),xmTaskDb.getExecutorUsername(),null);
				Result.assertIsFalse(tips1);
			}
			xmTaskService.updateTime(xmTask,xmTaskDb);
			
		return Result.ok();
		
	}

	@ApiOperation( value = "批量导入任务-从模板导入",notes="batchDelXmTask,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	//@HasQx(value = "xm_core_xmTask_batchImportFromTemplate",name = "从模板导入任务",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/batchImportFromTemplate",method=RequestMethod.POST)
	public Result batchImportFromTemplate(@RequestBody BatchImportVo batchImportVo) {

			List<XmTask> xmTasks=batchImportVo.getXmTasks();
			User user=LoginUtils.getCurrentUserInfo();
 			if(xmTasks==null || xmTasks.size()==0){
				return Result.error("任务列表不能为空");
				
			}
			if(!StringUtils.hasText(batchImportVo.getPtype())){
				return Result.error("ptype-0","请上送ptype,0代表项目计划（任务），1代表产品计划（任务）");
			}
			if(!StringUtils.hasText(batchImportVo.getProjectId())){
				return Result.error("projectId-0","请上送项目编号");
			}
			String projectId=batchImportVo.getProjectId();
			String productId=batchImportVo.getProductId();
			XmProject xmProject=xmProjectService.getProjectFromCache(projectId);
			Tips tips1=projectQxService.checkProjectQx(xmProject,2,user);
			Result.assertIsFalse(tips1);
			Map<String,String> newIdMap=new HashMap<>();
			if(!StringUtils.hasText(batchImportVo.getParentTaskid())){
				newIdMap.put(batchImportVo.getParentTaskid(),batchImportVo.getParentTaskid());
			}
			for (XmTask xmTask : xmTasks) {
				newIdMap.put(xmTask.getId(),this.xmTaskService.createKey("id"));
			}
 			for (XmTask g : xmTasks) {
 				g.setId(newIdMap.get(g.getId()));
 				if(StringUtils.hasText(g.getParentTaskid())){
 					if(newIdMap.containsKey(g.getParentTaskid())){
 						g.setParentTaskid(newIdMap.get(g.getParentTaskid()));
					}else{
 						if(StringUtils.hasText(batchImportVo.getParentTaskid())){
							g.setParentTaskid(batchImportVo.getParentTaskid());
						}else{
 							g.setParentTaskid(null);
						}
					}
				}
 				g.setCbranchId(user.getBranchId());
 				g.setPbranchId(xmProject.getBranchId());
				g.setCreateUserid(user.getUserid());
				g.setCreateUsername(user.getUsername());
				g.setExecutorUserid(null);
				g.setExecutorUsername(null);
				g.setCbranchId(user.getBranchId());
				g.setExeUserids(null);
				g.setExeUsernames(null);
				g.setCdeptid(user.getDeptid());
				g.setPtype(batchImportVo.getPtype());
				g.setProjectId(projectId);
				g.setProductId(productId);


				g.setCrmSup("0");
				g.setBidStep("0");
				g.setTaskOut("0");
				g.setCrowd("0");
				g.setEtoPlatTime(null);
				g.setEtoDevTime(null);
				g.setEbackTime(null);
				g.setHotEtime(null);
				g.setHotStime(null);
				g.setBrowseTimes(null);
				g.setActStartTime(null);
				g.setActEndTime(null);
				g.setOshare("0");
				g.setQuoteFinalAt(BigDecimal.ZERO);
				g.setTopEtime(null);
				g.setTopStime(null);
				g.setEstate("0");
				if(g.getBudgetAt()==null)g.setBudgetAt(BigDecimal.ZERO);
			}
			xmTaskService.parentIdPathsCalcBeforeSave(xmTasks);
			List<XmTask> tasksLvl1=xmTasks.stream().filter(i->i.getLvl()<=1).collect(Collectors.toList());
			if("1".equals(xmProject.getBudgetCtrl())){
				if(tasksLvl1.size()>0){
					BigDecimal totalTaskBudgetAt=BigDecimal.ZERO;
					for (XmTask task : tasksLvl1) {
						totalTaskBudgetAt=totalTaskBudgetAt.add(task.getBudgetAt());
					}
					if("0".equals(batchImportVo.getPtype())&&totalTaskBudgetAt.compareTo(BigDecimal.ZERO)>0){
		 				Tips tips =xmTaskService.judgetProjectBudget(projectId,totalTaskBudgetAt,tasksLvl1.stream().map(i->i.getId()).collect(Collectors.toList()));
						if(!tips.isOk()){
							return Result.error(tips.getMsg()+" 相关任务【"+tasksLvl1.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
 						}
					}
				}else{
					List<XmTask> tasks=xmTasks.stream().filter(i->!xmTasks.stream().filter(k->k.getId().equals(i.getParentTaskid())).findAny().isPresent()).collect(Collectors.toList());
					tasks=tasks.stream().filter(i->StringUtils.hasText(i.getParentTaskid())).collect(Collectors.toList());
					if(tasks.size()>0){
						Set<String> parentTaskIdSet=tasks.stream().map(i->i.getParentTaskid()).collect(Collectors.toSet());
						for (String pid : parentTaskIdSet) {
							BigDecimal childBudgetAt=BigDecimal.ZERO;
							List<XmTask> childs=xmTasks.stream().filter(i->pid.equals(i.getParentTaskid())).collect(Collectors.toList());
							for (XmTask child : childs) {
								childBudgetAt=childBudgetAt.add(child.getBudgetAt());
							}
							if(childBudgetAt.compareTo(BigDecimal.ZERO)>0){
				 				Tips tips = xmTaskService.judgetTaskBudget(pid,childBudgetAt,null,null,null,childs.stream().map(i->i.getId()).collect(Collectors.toList()));
								if(!tips.isOk()){
									return Result.error("budget-not-enought",tips.getMsg()+" 相关任务【"+childs.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
								}
							}
						}
					}
				}
			}

 				for (XmTask task : xmTasks) {
					task.setChildrenCnt( Integer.valueOf(xmTasks.stream().filter(i->task.getId().equals(i.getParentTaskid())).count()+""));
					if(task.getChildrenCnt()>0){
						task.setNtype("1");
					}else{
						if(!StringUtils.hasText(task.getNtype())){
							task.setNtype("0");
						}
					}
				xmTaskService.batchImportFromTemplate(xmTasks);
				for (XmTask t : xmTasks) {

					if(!user.getUserid().equals(t.getCreateUserid()) && !"0".equals(t.getStatus())) {
						notifyMsgService.pushMsg(user, t.getCreateUserid(), t.getCreateUsername(),  "您成为任务【" + t.getName() + "】的负责人，请注意跟进。",null);
					}
					xmRecordService.addXmTaskRecord(t.getProjectId(), t.getId(), "项目-任务-批量新增任务", "新增任务"+t.getName(),"",null);
					
				}

			}
		return Result.ok();
	}

	/**
	 *
	@ApiOperation( value = "批量将任务与一个项目计划关联",notes="")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	//@HasQx(value = "xm_core_xmTask_batchRelTasksWithPhase",name = "批量将任务与一个项目计划关联",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/batchRelTasksWithPhase",method=RequestMethod.POST)
	public Result batchRelTasksWithPhase(@RequestBody BatchRelTasksWithPhase tasksPhase) {

			User user=LoginUtils.getCurrentUserInfo();

			if(tasksPhase==null){
				return Result.error("params-0","参数不能为空");
			}

			String phaseId=tasksPhase.getPhaseId();
			if( !StringUtils.hasText(phaseId) ){
				return Result.error("phaseId-0","项目计划编号不能为空");
			}
			XmProjectPhase xmProjectPhaseDb=this.xmProjectPhaseService.selectOneObject(new XmProjectPhase(phaseId));


			if(xmProjectPhaseDb==null){
				return Result.error("phase-0","计划【"+xmProjectPhaseDb.getName()+"】已不存在");
			}
			if("1".equals(xmProjectPhaseDb.getNtype())){
				return Result.error("phase-ntype-1","【"+xmProjectPhaseDb.getName()+"】属于计划集，无需关联任务。");
			}
			XmProject xmProjectDb=this.xmProjectService.getProjectFromCache(xmProjectPhaseDb.getProjectId());
			if(xmProjectDb==null){
				return Result.error("project-0","项目已不存在");
			}
			if("8".equals(xmProjectDb.getStatus())){
				return Result.error("project-status-8","项目已完成,不能再修改");
			}
			if( "9".equals(xmProjectDb.getStatus())){
				return Result.error("project-status-9","项目关闭,不能再修改");
			}
			List<Dept> pgroups=groupService.getProjectGroupVoList(xmProjectDb.getId());
			if(pgroups==null || pgroups.size()==0){
				return Result.error("group-0","该项目还未建立项目团队，请先进行团队成员维护");
			}
			List<XmTask> allowTasks=new ArrayList<>();
			List<XmTask> noAllowTasks=new ArrayList<>();
			List<XmTask> ntype1Tasks=new ArrayList<>();
			List<XmTask> tasksDb=this.xmTaskService.selectTaskListByIds(tasksPhase.getTaskIds());
			for (XmTask task : tasksDb) {
				if("1".equals(task.getNtype())){
					ntype1Tasks.add(task);
					continue;
				}
				boolean isMyCreate=user.getUserid().equals(task.getCreateUserid());
				if(isMyCreate){
					allowTasks.add(task);
				}else{
					boolean isHead=groupService.checkUserIsOtherUserTeamHeadOrAss(pgroups,task.getCreateUserid(),user.getUserid());
					if(!isHead){
						noAllowTasks.add(task);
					}else {
						allowTasks.add(task);
					}
				}

			}
			List<String> msgs=new ArrayList<>();
			if(allowTasks.size()>0){
				BatchRelTasksWithPhase tasksWithPhase=new BatchRelTasksWithPhase();
				tasksWithPhase.setPhaseId(phaseId);
				tasksWithPhase.setTaskIds(allowTasks.stream().map(i->i.getId()).collect(Collectors.toList()));
				xmTaskService.batchRelTasksWithPhase(tasksWithPhase);
			}
			msgs.add("成功将"+allowTasks.size()+"个任务与计划关联。");
			for (XmTask t : allowTasks) {
				xmRecordService.addXmTaskRecord(t.getProjectId(), t.getId(), "项目-任务-批量更新任务", "将任务"+t.getName()+"与计划【"+xmProjectPhaseDb.getId()+"-"+xmProjectPhaseDb.getName()+"】关联",null,null);
			}
			if(ntype1Tasks.size()>0){
				msgs.add("以下"+ntype1Tasks.size()+"个任务属于计划项，无需关联计划。【"+ntype1Tasks.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
			}
			if(noAllowTasks.size()>0){
				msgs.add("以下"+noAllowTasks.size()+"个任务无权操作，只有任务负责人、项目经理、组长可以批量将任务与项目计划进行关联,【"+noAllowTasks.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
			}
			if(allowTasks.size()>0){
				return Result.ok(msgs.stream().collect(Collectors.joining(" ")));
			}else{
				return Result.error(msgs.stream().collect(Collectors.joining(" ")));
			}

		return Result.ok();
		
	}
	 **/
	@ApiOperation( value = "批量将多个任务与一个用户需求关联",notes="")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	//@HasQx(value = "xm_core_xmTask_batchRelTasksWithMenu",name = "批量将任务与一个用户需求关联",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/batchRelTasksWithMenu",method=RequestMethod.POST)
	public Result batchRelTasksWithMenu(@RequestBody BatchRelTasksWithMenu tasksMenu) {

			User user=LoginUtils.getCurrentUserInfo();

			if(tasksMenu==null||tasksMenu.getTaskIds()==null||tasksMenu.getTaskIds().size()==0 ){
				return Result.error("tasks-0","任务列表不能为空");
			};
			if(!StringUtils.hasText(tasksMenu.getMenuId()) ){
				return Result.error("menuId-0","需求编号不能为空");
			};
			XmMenu xmMenuDb= menuOperQxService.getUserCanOpMenuById(tasksMenu.getMenuId(), user.getUserid(), false);

 			if(xmMenuDb==null){
				return Result.error("menu-0","无权限挂接任务到别人负责的需求上");
			}

			if("8".equals(xmMenuDb.getStatus())){
				return Result.error("menu-status-8","需求已下线");
			}

			if("9".equals(xmMenuDb.getStatus())){
				return Result.error("menu-status-8","需求已删除");
			}
			List<XmTask> allowTasks=new ArrayList<>();
			List<XmTask> ntype1Tasks=new ArrayList<>();
			List<XmTask> noAllowTasks=new ArrayList<>();
			List<XmTask> tasksDb=this.xmTaskService.selectTaskListByIds(tasksMenu.getTaskIds());
			for (XmTask xmTask : tasksDb) {
				xmTask.setLtime(new Date());
				if("1".equals(xmTask.getNtype())){
					ntype1Tasks.add(xmTask);
					continue;
				}
			}
			Map<String,List<XmTask>> projectTasksMap=new HashMap<>();
			for (XmTask xmTask : tasksDb) {
				 List<XmTask> projectTasks=projectTasksMap.get(xmTask.getProjectId());
				 if(projectTasks==null){
					projectTasks=new ArrayList<>();
					projectTasksMap.put(xmTask.getProjectId(),projectTasks);
				 }
				projectTasks.add(xmTask);
			}
			
			for (Map.Entry<String, List<XmTask>> pt : projectTasksMap.entrySet()) {
				XmProject xmProjectDb=this.xmProjectService.getProjectFromCache(pt.getKey());
 				Tips tips1=projectQxService.checkProjectQx(xmProjectDb,0,user);
				if(!tips1.isOk()){
						noAllowTasks.addAll(pt.getValue());
				}else{
					for (XmTask xmTask : pt.getValue()) {
		 				tips1=projectQxService.checkProjectQx(xmProjectDb,0,user, xmTask.getCreateUserid(),xmTask.getCreateUsername(),xmTask.getCbranchId());
						if(!tips1.isOk()){
							noAllowTasks.add(xmTask);
						}
					}
				}
			}

			allowTasks=tasksDb.stream().filter(i->!noAllowTasks.stream().filter(k->k.getId().equals(i.getId())).findAny().isPresent()).collect(Collectors.toList());
			allowTasks=allowTasks.stream().filter(i->!ntype1Tasks.stream().filter(k->k.getId().equals(i.getId())).findAny().isPresent()).collect(Collectors.toList());

			List<String> msgs=new ArrayList<>();
			if(allowTasks.size()>0){
				BatchRelTasksWithMenu tasksWithMenu=new BatchRelTasksWithMenu();
				tasksWithMenu.setMenuId(xmMenuDb.getMenuId());
				tasksWithMenu.setTaskIds(allowTasks.stream().map(i->i.getId()).collect(Collectors.toList()));
				xmTaskService.batchRelTasksWithMenu(tasksWithMenu,xmMenuDb);
			}
			msgs.add("成功将"+allowTasks.size()+"个任务与需求关联。");
			for (XmTask t : allowTasks) {
				xmRecordService.addXmTaskRecord(t.getProjectId(), t.getId(), "项目-任务-批量更新任务", "将任务"+t.getName()+"与需求【"+xmMenuDb.getMenuId()+"-"+xmMenuDb.getMenuName()+"】关联",null,null);
			}
			if(ntype1Tasks.size()>0){
				msgs.add("以下"+ntype1Tasks.size()+"个任务属于计划项，无需关联需求。【"+ntype1Tasks.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
			}
			if(noAllowTasks.size()>0){
				msgs.add("以下"+noAllowTasks.size()+"个任务无权操作，只有任务负责人、项目经理、组长、产品组组长、需求管理组人员可以批量将任务与需求进行关联,【"+noAllowTasks.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
			}
			if(allowTasks.size()>0){
				return Result.ok(msgs.stream().collect(Collectors.joining(" ")));
			}else{
				return Result.error(msgs.stream().collect(Collectors.joining(" ")));
			}
		
	} 
	/**
	*/
	@ApiOperation( value = "根据主键列表批量删除任务信息",notes="batchDelXmTask,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	//@HasQx(value = "xm_core_xmTask_batchDel",name = "批量删除任务",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Result batchDelXmTask(@RequestBody List<XmTask> xmTasks) {


			User user=LoginUtils.getCurrentUserInfo();

			if(xmTasks==null || xmTasks.size()==0){
				return Result.error("任务列表不能为空");
				
			}
			XmTask xmTask=xmTasks.get(0);
			if(!StringUtils.hasText(xmTask.getId())){
				return Result.error("id-0","任务编号不能为空");
			}
			XmTask xmTaskDb=this.xmTaskService.selectOneObject(xmTask);
			if(xmTaskDb==null){
				return Result.error("data-0","计划任务已不存在");
			}
			String projectId=xmTaskDb.getProjectId();
			XmProject xmProject=xmProjectService.getProjectFromCache(projectId);
			
			Tips tips=projectQxService.checkProjectQx(xmProject,2,user);
			Result.assertIsFalse(tips);
			List<XmTask> canOper=new ArrayList<>();
			List<XmTask> noOper=new ArrayList<>();
			Map<String,Tips> noTipsMap=new HashMap<>();
			Map<String,XmTask> delNodesDbMap=this.xmTaskService.selectTasksMapByTasks(xmTasks);
			for (XmTask node : delNodesDbMap.values()) {
				if(!projectId.equals(node.getProjectId()) ){
					return Result.error("not-same-project","所有任务必须同属于一个项目");
				}
			}
			if(groupService.checkUserIsProjectAdm(xmProject,user.getUserid())){
				canOper.addAll(delNodesDbMap.values());
			}else{
				for (XmTask node : delNodesDbMap.values()) {
	 				Tips tips1=projectQxService.checkProjectQx(xmProject,2,user,node.getCreateUserid(),node.getCreateUsername(),node.getCbranchId());
					if(!tips1.isOk()){
						noOper.add(node);
						noTipsMap.put(tips1.getMsg(),tips1);
					}else {
						canOper.add(node);
					}

				}
			}

			if(canOper.size()==0){
				return Result.error("noqx-del",String.format("无权限删除，原因【%s】",noTipsMap.keySet().stream().collect(Collectors.joining(";"))));
			}

			List<XmTask> existsExecuserList=new ArrayList<>();
			List<XmTask> noExecuserList=new ArrayList<>();
			if(canOper.size()>0){
				for (XmTask node : canOper) {
					if(this.xmTaskService.checkExistsExecuser(node)){
						existsExecuserList.add(node);
					}else{
						noExecuserList.add(node);
					}
				}
			}
			List<XmTask> hadChildNodes=new ArrayList<>();
			List<XmTask> canDelNodes=new ArrayList<>();
			if(noExecuserList.size()>0){
				for (XmTask node : noExecuserList) {
					boolean canDel=this.xmTaskService.checkCanDelAllChild(node,noExecuserList);
					if(canDel){
						canDelNodes.add(node);
					}else{
						hadChildNodes.add(node);
					}
				}
			}
			if(canDelNodes.size()>0){
				this.xmTaskService.doBatchDelete(canDelNodes);
				xmRecordService.addXmTaskRecord(canDelNodes,"项目-任务-批量删除","删除任务");
			}
			List<String> msgs=new ArrayList<>();
			msgs.add("删除了"+canDelNodes.size()+"个任务。");
			if(hadChildNodes.size()>0){
				msgs.add("以下"+hadChildNodes.size()+"个任务存在未删除的子任务，不能删除。如确实需要删除任务，请先删除子任务。【"+hadChildNodes.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
			}
			if(existsExecuserList.size()>0){
				msgs.add("以下"+existsExecuserList.size()+"个任务存在待结算的执行人，不能删除。如确实需要删除，请在【任务编辑->执行人】中删除执行人后再删除任务【"+existsExecuserList.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
			}
			if(noOper.size()>0){
				msgs.add(String.format("以下%s个任务无权限删除，原因【%s】",noOper.size(),noTipsMap.keySet().stream().collect(Collectors.joining(";"))));
			}
			if(canDelNodes.size()==0){
				return Result.error(msgs.stream().collect(Collectors.joining(" ")));
			}else{
				return Result.ok(msgs.stream().collect(Collectors.joining(" ")));
			}
	}



	/***/
	@ApiOperation( value = "批量修改任务的上级",notes="batchChangeParentTask,仅需要上传主键字段")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	//@HasQx(value = "xm_core_xmTask_batchChangeParentTask",name = "批量修改任务的上级",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/batchChangeParentTask",method=RequestMethod.POST)
	public Result batchChangeParentTask(@RequestBody BatchChangeParentTaskVo xmTasksVo) {

			User user=LoginUtils.getCurrentUserInfo();

			if(xmTasksVo.getTaskIds()==null || xmTasksVo.getTaskIds().size()==0){
				return Result.error("任务列表不能为空");
				
			}
			if(!StringUtils.hasText(xmTasksVo.getParentTaskid())){
				return Result.error("parentTaskid-0", "上级编号不能为空");
			}
			List<String> ids=xmTasksVo.getTaskIds().stream().map(i->i).collect(Collectors.toList());
			ids.add(xmTasksVo.getParentTaskid());
			ids=ids.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
			List<XmTask> xmTasks=this.xmTaskService.selectTaskListByIds(ids);
			Optional<XmTask> optional=xmTasks.stream().filter(i->i.getId().equals(xmTasksVo.getParentTaskid())).findAny();
			if(!optional.isPresent()){
				return Result.error("parentTask-0", "上级不存在");
			}
			XmTask parentTask=optional.get();
			if(!"1".equals(parentTask.getNtype())){
				return Result.error("parentTask-ntype-not-1", "【"+parentTask.getName()+"】为任务，不能作为上级节点。请另选上级或者变更其为计划节点");
			}
			Tips tips2=this.groupService.checkIsProjectAdmOrTeamHeadOrAss(user,user.getUserid(),parentTask.getProjectId());
			Result.assertIsFalse(tips2);
			xmTasks=xmTasks.stream().filter(i->!i.getId().equals(parentTask.getId())).collect(Collectors.toList());
			List<XmTask> canOpxmTasks=xmTasks.stream().filter(i->!parentTask.getId().equals(i.getParentTaskid())).collect(Collectors.toList());
			List<XmTask> sameParentTasks=xmTasks.stream().filter(i->parentTask.getId().equals(i.getParentTaskid())).collect(Collectors.toList());
			if(canOpxmTasks.size()==0){
				return Result.error("same-parent","所有任务均属于【"+parentTask.getName()+"】,无需再变更");
			}
			if(!"1".equals(parentTask.getPtype())){
				if(canOpxmTasks.stream().filter(i->!i.getProjectId().equals(parentTask.getProjectId())).findAny().isPresent()){
					return Result.error("projectId-not-same", "所有任务或计划必须都是同一个项目之下");
				}
			}else {
				if(canOpxmTasks.stream().filter(i->!i.getProductId().equals(parentTask.getProductId())).findAny().isPresent()){
					return Result.error("productId-not-same", "所有任务或计划必须都是同一个产品之下");
				}
			}

			Map<String,XmTask> allowTasksDbMap=new HashMap<>();
			Map<String,XmTask>  noAllowTasksDbMap=new HashMap<>();
			XmProject projectDb=xmProjectService.getProjectFromCache(parentTask.getProjectId());
			List<XmGroupVo> pgroups= groupService.getProjectGroupVoList(projectDb.getId());
			boolean isAdm=groupService.checkUserIsProjectAdm(parentTask.getProjectId(),user.getUserid());
			if(!isAdm){
				for (XmTask task : canOpxmTasks) {
					boolean isHead=groupService.checkUserIsOtherUserTeamHeadOrAss(pgroups,user.getUserid(),task.getCreateUserid());
					if(!isHead){
						noAllowTasksDbMap.put(task.getId(),task);
					}else {
						allowTasksDbMap.put(task.getId(),task);
					}
				}
			}else{
				for (XmTask task : canOpxmTasks) {
						allowTasksDbMap.put(task.getId(),task);
				}
			}
			Map<String,XmTask> allowTasksDbMap2=new HashMap<>();
			for (XmTask t : allowTasksDbMap.values()) {
				t.setLtime(new Date());
				if(!allowTasksDbMap.containsKey(t.getParentTaskid())){
					allowTasksDbMap2.put(t.getId(),t);
				}
			}
			Map<String,XmTask> allowTasksDbMap3=new HashMap<>();
			for (XmTask t : allowTasksDbMap2.values()) {
				t.setLtime(new Date());
				boolean hasChildren=false;
				for (XmTask t2 : allowTasksDbMap2.values()) {
					if(!t2.getId().equals(t.getId()) && t2.getPidPaths().indexOf(t.getPidPaths())>=0 ){
						hasChildren=true;
						break;
					}
				}
				if(hasChildren==false){
					allowTasksDbMap3.put(t.getId(),t);
				}
			}
			if(allowTasksDbMap3.size()>0){
				this.xmTaskService.batchChangeParent(allowTasksDbMap3.values().stream().collect(Collectors.toList()),parentTask);

				this.xmRecordService.addXmTaskRecord(parentTask.getProjectId(),parentTask.getId(),"批量挂接子节点","成功将以下"+allowTasksDbMap3.size()+"个计划或任务及其所有子项挂接到【"+parentTask.getName()+"】上,【"+allowTasksDbMap3.values().stream().map(i->i.getName()).collect(Collectors.joining(","))+"】;");


			}

			List<String> msgs=new ArrayList<>();
			if(allowTasksDbMap3.size()>0){
				msgs.add("成功将以下"+allowTasksDbMap3.size()+"个计划或任务及其所有子项挂接到【"+parentTask.getName()+"】上");
			}
			if(noAllowTasksDbMap.size()>0){
				msgs.add("以下"+noAllowTasksDbMap.size()+"个计划任务无权限操作，【"+noAllowTasksDbMap.values().stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
			}
			if(sameParentTasks.size()>0){
				msgs.add("以下"+sameParentTasks.size()+"个计划任务已属于【"+parentTask.getName()+"】之下，无需变更，【"+sameParentTasks.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
			}
			if(allowTasksDbMap3.size()>0){
				return Result.ok(msgs.stream().collect(Collectors.joining(" ")));
			}else{
				return Result.error(msgs.stream().collect(Collectors.joining(" ")));
			}
		
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
	public Result processApprova( @RequestBody Map<String,Object> flowVars){
			this.xmTaskService.processApprova(flowVars);
			return Result.ok();
	}
}
