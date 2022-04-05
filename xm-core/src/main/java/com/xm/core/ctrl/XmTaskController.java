package com.xm.core.ctrl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageSerializable;
import com.mdp.audit.log.client.annotation.AuditLog;
import com.mdp.audit.log.client.annotation.OperType;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.BaseUtils;
import com.mdp.core.utils.NumberUtil;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.PubTool;
import com.xm.core.entity.*;
import com.xm.core.service.*;
import com.xm.core.service.cache.XmTaskCacheService;
import com.xm.core.service.push.XmPushMsgService;
import com.xm.core.vo.*;
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
	XmGroupService groupService;
	
	@Autowired
	private XmRecordService xmRecordService;
	
	@Autowired
	private XmPushMsgService xmPushMsgService;
	@Autowired
	private XmProjectService xmProjectService;
	@Autowired
	XmPhaseService xmPhaseService;

	@Autowired
	XmMenuService xmMenusService;

	@Autowired
	XmProductService xmProductService;

	Map<String,Object> fieldsMap = BaseUtils.toMap(new XmTask());

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
			if( !(StringUtils.hasText(projectId)
					|| StringUtils.hasText(myExecuserStatus)|| StringUtils.hasText(isMy)|| StringUtils.hasText(myFocus)|| StringUtils.hasText(createUserid)
					|| StringUtils.hasText(executorUserid) || StringUtils.hasText(menuId) || StringUtils.hasText(productId)|| StringUtils.hasText(iterationId)) ){

				xmTask.put("compete",user.getUserid());
			}
		}
		List<Map<String,Object>> xmTaskVoList = xmTaskService.getTask(xmTask);	//列出XmTask列表
		PageUtils.responePage(m,xmTaskVoList);
		if("1".equals(xmTask.get("withParents"))  && !"1".equals(xmTask.get("isTop"))&& xmTaskVoList.size()>0){
			Set<String> pidPathsSet=new HashSet<>();
			Set<String> idSet=new HashSet<>();
			for (Map<String, Object> map : xmTaskVoList) {
				String id= (String) map.get("id");
				idSet.add(id);
				String pidPaths= (String) map.get("pidPaths");
				pidPaths=PubTool.getPidPaths(pidPaths,id);
				if(pidPaths==null || pidPaths.length()<=2){
					continue;
				}
				pidPathsSet.add(pidPaths);
			}
			if(pidPathsSet!=null && pidPathsSet.size()>0){
				List<Map<String,Object>> parentList=xmTaskService.getTask(map("pidPathsList",pidPathsSet.stream().collect(Collectors.toList())));
				parentList=parentList.stream().filter(i->!idSet.contains(i.get("id"))).collect(Collectors.toList());
				if(parentList!=null && parentList.size()>0){
					xmTaskVoList.addAll(parentList);
					m.put("total", NumberUtil.getInteger(m.get("total"),0)+parentList.size());
				}
			}
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
			if("1".equals(xmTask.get("withParents"))  && !"1".equals(xmTask.get("isTop")) && xmTaskVoList.size()>0){

				Set<String> pidPathsSet=new HashSet<>();
				Set<String> idSet=new HashSet<>();
				for (Map<String, Object> map : xmTaskVoList) {
					String id= (String) map.get("id");
					idSet.add(id);
					String pidPaths= (String) map.get("pidPaths");
					pidPaths=PubTool.getPidPaths(pidPaths,id);
					if(pidPaths.length()<=3){
						continue;
					}
					pidPathsSet.add(pidPaths);
				}

				if(pidPathsSet!=null && pidPathsSet.size()>0){
					List<Map<String,Object>> parentList=xmTaskService.getTask(map("pidPathsList",pidPathsSet.stream().collect(Collectors.toList())));
					parentList=parentList.stream().filter(i->!idSet.contains(i.get("id"))).collect(Collectors.toList());
					if(parentList!=null && parentList.size()>0){
						xmTaskVoList.addAll(parentList);
						m.put("total", NumberUtil.getInteger(m.get("total"),0)+parentList.size());
					}
				}
			}
		}



		m.put("data",xmTaskVoList);
		m.put("tips", tips);
		return m;
	}
	@RequestMapping(value="/getXmTaskAttDist",method=RequestMethod.GET)
	public Map<String,Object> getXmTaskAttDist( @RequestParam Map<String,Object> xmTask){
		User user=LoginUtils.getCurrentUserInfo();
		xmTask.put("branchId",user.getBranchId());
		List<Map<String,Object>> datas= this.xmTaskService.getXmTaskAttDist(xmTask);
		return ResponseHelper.ok("成功",datas);
	}

	@RequestMapping(value="/getXmTaskAgeDist",method=RequestMethod.GET)
	public Map<String,Object> getXmTaskAgeDist( @RequestParam Map<String,Object> xmTask){
		User user=LoginUtils.getCurrentUserInfo();
		xmTask.put("branchId",user.getBranchId());
		List<Map<String,Object>> datas= this.xmTaskService.getXmTaskAgeDist(xmTask);
		return ResponseHelper.ok("成功",datas);
	}


	@RequestMapping(value="/getXmTaskSort",method=RequestMethod.GET)
	public Map<String,Object> getXmTaskSort( @RequestParam Map<String,Object> xmTask){
		User user=LoginUtils.getCurrentUserInfo();
		PageUtils.startPage(xmTask);
		xmTask.put("branchId",user.getBranchId());
		List<Map<String,Object>> datas= this.xmTaskService.getXmTaskSort(xmTask);
		Map<String,Object> m=new HashMap<>();
		PageUtils.responePage(m,datas);
		m.put("data",datas);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	/***/
	@ApiOperation( value = "根据主键批量修改修改任务中的某些字段信息",notes="editXmMenu")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMenu.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTask_editSomeFields",name = "批量修改修改任务中的某些字段",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields(@RequestBody Map<String,Object> xmTaskMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			List<String> ids= (List<String>) xmTaskMap.get("ids");

			if(ids==null || ids.size()==0){
				ResponseHelper.failed("ids-0","ids不能为空");
			}
			XmTask xmTask= BaseUtils.fromMap(xmTaskMap,XmTask.class);
			List<XmTask> xmTasksDb=xmTaskService.selectListByIds(ids);
			if(xmTasksDb==null ||xmTasksDb.size()==0){
				ResponseHelper.failed("tasks-0","该任务已不存在");
			}
			List<XmTask> can=new ArrayList<>();
			List<XmTask> no=new ArrayList<>();
			if(can.size()<=0){
				//return ResponseHelper.failed("noqx","您无权修改选中的任务。");
			}
			Set<String> fields=new HashSet<>();
			fields.add("childrenCnt");
			fields.add("ntype");
			fields.add("pidPaths");
			for (String fieldName : xmTaskMap.keySet()) {
				if(fields.contains(fieldName)){
					return ResponseHelper.failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmTaskMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmTaskMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()>0){
				fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmTaskMap.get(i) )).collect(Collectors.toSet());


				if(fieldKey.contains("budgetWorkload")){//如果调整了预估工时，需要重新计算进度数据
					if(xmTasksDb.size()>0){
						this.xmTaskService.batchUpdateBudgetWorkloadAndRate(xmTasksDb.stream().map(i->i.getId()).collect(Collectors.toSet()).stream().collect(Collectors.toList()),NumberUtil.getBigDecimal(xmTaskMap.get("budgetWorkload")));
						this.xmTaskService.batchSumParents(xmTasksDb);
					}
				}else{
					xmTaskService.editSomeFields(xmTaskMap);
				}
				xmRecordService.addXmTaskRecord(xmTask.getProjectId(),xmTask.getId(),"修改项目任务","修改任务"+xmTask.getMenuName(),"", JSON.toJSONString(xmTask));

			}

			//m.put("data",xmMenu);
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
			tips=groupService.checkIsAdmOrTeamHeadOrAssByPtype(user,user.getUserid(),xmTaskVo.getPtype(),xmTaskVo.getProductId(),xmTaskVo.getProjectId());
			if(!tips.isOk()){
				 return ResponseHelper.failed(tips);
			}
			xmTaskVo.setCreateUserid(user.getUserid());
			xmTaskVo.setCreateUsername(user.getUsername());
			xmTaskVo.setExecutorUserid(user.getUserid());
			xmTaskVo.setExecutorUsername(user.getUsername());
			xmTaskVo.setCreateTime(new Date());
			xmTaskVo.setCbranchId(user.getBranchId());
			xmTaskVo.setCdeptid(user.getDeptid());


			xmTaskVo.setRate(0);
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
					tips.setFailureMsg("编号重复，请修改编号再提交");
					throw new BizException(tips);
				}
			}
			this.xmTaskService.parentIdPathsCalcBeforeSave(xmTaskVo);
			if(xmTaskVo.getBudgetAt()!=null  && xmTaskVo.getBudgetAt().compareTo(BigDecimal.ZERO)>0){
				if("0".equals(xmTaskVo.getPtype()) && xmTaskVo.getLvl()<=1){
					xmTaskService.judgetProjectBudget(xmTaskVo.getProjectId(),xmTaskVo.getBudgetAt(),null);
 				}else{
					tips=xmTaskService.judgetTaskBudget(xmTaskVo.getParentTaskid(), xmTaskVo.getBudgetAt(),null,null,null,null);
				}
			}
			if(tips.isOk()) {
				xmTaskVo = xmTaskService.addTask(xmTaskVo);
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
			String userid= (String) xmTask.get("userid");
			if( !(StringUtils.hasText(projectId) || StringUtils.hasText(userid) ) ){
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
			if(!StringUtils.hasText(xmTask.getId())){
				tips.setFailureMsg("任务编号不能为空");
				m.put("tips", tips);
				return m;
			}
			XmTask xmTaskDb=this.xmTaskService.selectOneObject(xmTask);
			if(xmTaskDb==null){
				return ResponseHelper.failed("data-0","数据已不存在");
			}
			if(xmTaskDb.getChildrenCnt()!=null && xmTaskDb.getChildrenCnt()>0){
				return ResponseHelper.failed("childrenCnt-no-0","有子计划任务不能删除");
			}

			if(xmTaskService.checkExistsExecuser(xmTaskDb)){
				return ResponseHelper.failed("existsExecuser","有待验收、待结算的执行人，不能删除");
			};

			tips=groupService.checkIsAdmOrTeamHeadOrAssByPtype(user,user.getUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
			if(!tips.isOk()){
				return ResponseHelper.failed(tips);
			}
			xmTaskService.deleteTask(xmTaskDb);
			xmRecordService.addXmTaskRecord(xmTaskDb.getProjectId(), xmTaskDb.getId(), "项目-任务-删除任务", "删除任务"+xmTaskDb.getName());

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

	@ApiOperation( value = "根据主键修改一条xm_task信息",notes="setTaskCreateUser")
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
			if(!StringUtils.hasText(xmTaskVo.getId())){
				tips.setFailureMsg("任务编号不能为空");
				m.put("tips", tips);
				return m;
			}
			XmTask xmTaskDb=this.xmTaskService.selectOneObject(xmTaskVo);
			if(xmTaskDb==null){
				tips.setFailureMsg("该任务不存在");
				m.put("tips", tips);
				return m;
			}

			tips=groupService.checkIsAdmOrTeamHeadOrAssByPtype(user,user.getUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
			if(!tips.isOk()){
				return ResponseHelper.failed(tips);
			}
			boolean existsGrouop=groupService.checkUserExistsGroupByPtype(xmTaskDb.getPtype(),xmTaskDb.getProjectId(),xmTaskDb.getProductId(),xmTaskVo.getCreateUserid());
			if(!existsGrouop){
				return ResponseHelper.failed("not-member",xmTaskVo.getCreateUsername()+"不是项目组成员，不能作为任务责任人");
			}
			XmTask xmTask=new XmTask(xmTaskVo.getId());
			xmTask.setCreateUserid(xmTaskVo.getCreateUserid());
			xmTask.setCreateUsername(xmTaskVo.getCreateUsername());
			 this.xmTaskService.updateSomeFieldByPk(xmTask);
			 this.xmRecordService.addXmTaskRecord(xmTaskDb.getProjectId(),xmTaskDb.getId(),"项目-任务-修改任务责任人","修改任务【"+xmTaskDb.getName()+"】责任人。原责任人【"+xmTaskDb.getCreateUsername()+"】，新责任人【"+xmTask.getCreateUsername()+"】");
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
			if(!StringUtils.hasText(xmTaskVo.getId())){
				tips.setFailureMsg("任务编号不能为空");
				m.put("tips", tips);
				return m;
			}

			XmTask xmTaskDb=this.xmTaskService.selectOneObject(xmTaskVo);
			if(xmTaskDb==null){
				return ResponseHelper.failed("data-0","任务已不存在");
			}
			if("1".equals(xmTaskDb.getNtype())){
				 if("0".equals(xmTaskVo.getNtype()) && xmTaskDb.getChildrenCnt()!=null && xmTaskDb.getChildrenCnt()>0){
					 return ResponseHelper.failed("ntype-not-right","当前为计划节点，并且具有"+xmTaskDb.getChildrenCnt()+"个子节点，不能变更为任务节点");
				 }
			}else{
				if(xmTaskDb.getChildrenCnt()!=null && xmTaskDb.getChildrenCnt()>0){
					xmTaskVo.setNtype("1");
				}
			}
			tips=groupService.checkIsAdmOrTeamHeadOrAssByPtype(user,user.getUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
			if(!tips.isOk()){
				return ResponseHelper.failed(tips);
			}

			this.xmTaskService.parentIdPathsCalcBeforeSave(xmTaskVo);
			if(xmTaskVo.getBudgetAt()==null)xmTaskVo.setBudgetAt(BigDecimal.ZERO);
			if(xmTaskDb.getBudgetAt()==null)xmTaskDb.setBudgetAt(BigDecimal.ZERO);
			List<String> excludeIds=new ArrayList<>();
			excludeIds.add(xmTaskDb.getId());
			if( xmTaskDb.getBudgetAt().compareTo(xmTaskVo.getBudgetAt())!=0){
				if("0".equals(xmTaskDb.getPtype()) && xmTaskVo.getLvl()<=1){
					tips=xmTaskService.judgetProjectBudget(xmTaskDb.getProjectId(), xmTaskVo.getBudgetAt(),excludeIds);
				}else if(StringUtils.hasText(xmTaskDb.getParentTaskid())){
					tips=xmTaskService.judgetTaskBudget(xmTaskDb.getParentTaskid(), xmTaskVo.getBudgetAt(),null,null,null,excludeIds);
				}
			}

			if(tips.isOk()) {
				xmTaskService.updateTask(xmTaskVo,xmTaskDb);
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
			if(!StringUtils.hasText(xmTask.getId())){
				tips.setFailureMsg("任务编号不能为空");
				m.put("tips", tips);
				return m;
			}
			XmTask xmTaskDb=xmTaskService.selectOneObject(xmTask);
			if(xmTaskDb==null){
				return ResponseHelper.failed("data-0","任务已不存在");
			}
			tips=groupService.checkIsAdmOrTeamHeadOrAssByPtype(user,user.getUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
			if(!tips.isOk()){
				boolean isCreateUser=user.getUserid().equals(xmTaskDb.getCreateUserid());
				boolean isExecUser=user.getUserid().equals(xmTaskDb.getExecutorUserid());
				if( !isCreateUser && !isExecUser ){
					return ResponseHelper.failed("no-qx-op","您无权修改该任务的计划时间！只有任务执行人、任务负责人、组长、项目经理可以修改任务的进度。");
				}
			}
			xmTaskService.updateTime(xmTask,xmTaskDb);
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
			if(!StringUtils.hasText(xmTask.getId())){
				tips.setFailureMsg("任务编号不能为空");
				m.put("tips", tips);
				return m;
			}

			XmTask xmTaskDb=xmTaskService.selectOneObject(xmTask);
			if(xmTaskDb==null){
				return ResponseHelper.failed("data-0","任务已不存在");
			}

			tips=groupService.checkIsAdmOrTeamHeadOrAssByPtype(user,user.getUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
			if(!tips.isOk()){
				boolean isCreateUser=user.getUserid().equals(xmTaskDb.getCreateUserid());
				boolean isExecUser=user.getUserid().equals(xmTaskDb.getExecutorUserid());
				if( !isCreateUser && !isExecUser ){
					return ResponseHelper.failed("no-qx-op","您无权修改该任务的进度！只有任务执行人、任务负责人、组长、项目经理可以修改任务的进度。");
				}
			}
			xmTaskService.updateProgress(xmTask,xmTaskDb);
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
	public Map<String,Object> batchImportFromTemplate(@RequestBody BatchImportVo batchImportVo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功导入");
		try{
			List<XmTask> xmTasks=batchImportVo.getXmTasks();
			User user=LoginUtils.getCurrentUserInfo();
 			if(xmTasks==null || xmTasks.size()==0){
				tips.setFailureMsg("任务列表不能为空");
				m.put("tips", tips);
				return m;
			}
			if(!StringUtils.hasText(batchImportVo.getPtype())){
				return ResponseHelper.failed("ptype-0","请上送ptype,0代表项目计划（任务），1代表产品计划（任务）");
			}
			if("0".equals(batchImportVo.getPtype()) && !StringUtils.hasText(batchImportVo.getProjectId())){
				return ResponseHelper.failed("projectId-0","请上送项目编号");
			} else if("1".equals(batchImportVo.getPtype()) && !StringUtils.hasText(batchImportVo.getProductId())){
				return ResponseHelper.failed("productId-0","请上送产品编号");
			}else if(!"0".equals(batchImportVo.getPtype()) && !"1".equals(batchImportVo.getPtype())){
				return ResponseHelper.failed("ptype-0","请上送ptype,0代表项目计划（任务），1代表产品计划（任务）");
			}
			String projectId=batchImportVo.getProjectId();
			String productId=batchImportVo.getProductId();
			tips=groupService.checkIsAdmOrTeamHeadOrAssByPtype(user,user.getUserid(),batchImportVo.getPtype(),batchImportVo.getProductId(),batchImportVo.getProjectId());
			if(!tips.isOk()){
				return ResponseHelper.failed(tips);
			}
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
				g.setCreateUserid(user.getUserid());
				g.setCreateUsername(user.getUsername());
				g.setExecutorUserid(user.getUserid());
				g.setExecutorUsername(user.getUsername());
				g.setCbranchId(user.getBranchId());
				g.setExeUserids(null);
				g.setExeUsernames(null);
				g.setCdeptid(user.getDeptid());
				g.setPtype(batchImportVo.getPtype());
				g.setProjectId(projectId);
				g.setProductId(productId);
				if(g.getBudgetAt()==null)g.setBudgetAt(BigDecimal.ZERO);
			}
			xmTaskService.parentIdPathsCalcBeforeSave(xmTasks);
			List<XmTask> tasksLvl1=xmTasks.stream().filter(i->i.getLvl()<=1).collect(Collectors.toList());
			if(tasksLvl1.size()>0){
				BigDecimal totalTaskBudgetAt=BigDecimal.ZERO;
				for (XmTask task : tasksLvl1) {
					totalTaskBudgetAt=totalTaskBudgetAt.add(task.getBudgetAt());
				}
				if("0".equals(batchImportVo.getPtype())&&totalTaskBudgetAt.compareTo(BigDecimal.ZERO)>0){
					tips=xmTaskService.judgetProjectBudget(projectId,totalTaskBudgetAt,tasksLvl1.stream().map(i->i.getId()).collect(Collectors.toList()));
					if(!tips.isOk()){
						tips.setFailureMsg(tips.getMsg()+" 相关任务【"+tasksLvl1.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
						return ResponseHelper.failed(tips);
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
							tips= xmTaskService.judgetTaskBudget(pid,childBudgetAt,null,null,null,childs.stream().map(i->i.getId()).collect(Collectors.toList()));
							if(!tips.isOk()){
								return ResponseHelper.failed("budget-not-enought",tips.getMsg()+" 相关任务【"+childs.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
							}
						}
					}
				}
			}
			if(tips.isOk()) {
				for (XmTask task : xmTasks) {
					task.setChildrenCnt( Integer.valueOf(xmTasks.stream().filter(i->task.getId().equals(i.getParentTaskid())).count()+""));
					if(task.getChildrenCnt()>0){
						task.setNtype("1");
					}else{
						if(task.getLvl()>1){
							task.setNtype("0");
						}else{
							task.setNtype("1");
						}
					}
				}
				xmTaskService.batchImportFromTemplate(xmTasks);
				for (XmTask t : xmTasks) {
					xmRecordService.addXmTaskRecord(t.getProjectId(), t.getId(), "项目-任务-批量新增任务", "新增任务"+t.getName(),"",null);
					
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
	 *
	@ApiOperation( value = "批量将任务与一个项目计划关联",notes="")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmTask_batchRelTasksWithPhase",name = "批量将任务与一个项目计划关联",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchRelTasksWithPhase",method=RequestMethod.POST)
	public Map<String,Object> batchRelTasksWithPhase(@RequestBody BatchRelTasksWithPhase tasksPhase) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功将任务数据与项目计划关联");
		try{
			User user=LoginUtils.getCurrentUserInfo();

			if(tasksPhase==null){
				return ResponseHelper.failed("params-0","参数不能为空");
			}

			String phaseId=tasksPhase.getPhaseId();
			if( !StringUtils.hasText(phaseId) ){
				return ResponseHelper.failed("phaseId-0","项目计划编号不能为空");
			}
			XmProjectPhase xmProjectPhaseDb=this.xmProjectPhaseService.selectOneObject(new XmProjectPhase(phaseId));


			if(xmProjectPhaseDb==null){
				return ResponseHelper.failed("phase-0","计划【"+xmProjectPhaseDb.getName()+"】已不存在");
			}
			if("1".equals(xmProjectPhaseDb.getNtype())){
				return ResponseHelper.failed("phase-ntype-1","【"+xmProjectPhaseDb.getName()+"】属于计划集，无需关联任务。");
			}
			XmProject xmProjectDb=this.xmProjectService.getProjectFromCache(xmProjectPhaseDb.getProjectId());
			if(xmProjectDb==null){
				return ResponseHelper.failed("project-0","项目已不存在");
			}
			if("8".equals(xmProjectDb.getStatus())){
				return ResponseHelper.failed("project-status-8","项目已完成,不能再修改");
			}
			if( "9".equals(xmProjectDb.getStatus())){
				return ResponseHelper.failed("project-status-9","项目关闭,不能再修改");
			}
			List<XmGroupVo> pgroups=groupService.getProjectGroupVoList(xmProjectDb.getId());
			if(pgroups==null || pgroups.size()==0){
				return ResponseHelper.failed("group-0","该项目还未建立项目团队，请先进行团队成员维护");
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
				tips.setOkMsg(msgs.stream().collect(Collectors.joining(" ")));
			}else{
				tips.setFailureMsg(msgs.stream().collect(Collectors.joining(" ")));
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
	 **/
	@ApiOperation( value = "批量将多个任务与一个用户需求关联",notes="")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmTask_batchRelTasksWithMenu",name = "批量将任务与一个用户需求关联",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchRelTasksWithMenu",method=RequestMethod.POST)
	public Map<String,Object> batchRelTasksWithMenu(@RequestBody BatchRelTasksWithMenu tasksMenu) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功将任务与用户需求关联");
		try{
			User user=LoginUtils.getCurrentUserInfo();

			if(tasksMenu==null||tasksMenu.getTaskIds()==null||tasksMenu.getTaskIds().size()==0 ){
				return ResponseHelper.failed("tasks-0","任务列表不能为空");
			};
			if(!StringUtils.hasText(tasksMenu.getMenuId()) ){
				return ResponseHelper.failed("menuId-0","需求编号不能为空");
			};
			XmMenu xmMenuDb=this.xmMenusService.selectOneObject(new XmMenu(tasksMenu.getMenuId()));
			if(xmMenuDb==null){
				return ResponseHelper.failed("menu-0","需求已不存在");
			}

			if("8".equals(xmMenuDb.getStatus())){
				return ResponseHelper.failed("menu-status-8","需求已下线");
			}

			if("9".equals(xmMenuDb.getStatus())){
				return ResponseHelper.failed("menu-status-8","需求已删除");
			}

			XmProduct xmProductDb=xmProductService.getProductFromCache(xmMenuDb.getProductId());
			boolean hasMenuQx=true;
			Tips tips2=groupService.checkIsAdmOrTeamHeadOrAssByPtype(user,user.getUserid(),"1",xmProductDb.getId(),null);
			if(!tips2.isOk()){
				hasMenuQx=false;
			}
			List<XmTask> allowTasks=new ArrayList<>();

			List<XmTask> ntype1Tasks=new ArrayList<>();
			List<XmTask> noAllowTasks=new ArrayList<>();
			List<XmTask> tasksDb=this.xmTaskService.selectTaskListByIds(tasksMenu.getTaskIds());
			for (XmTask xmTask : tasksDb) {
				if("1".equals(xmTask.getNtype())){
					ntype1Tasks.add(xmTask);
					continue;
				}
			}
			if(hasMenuQx==false){
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
					boolean isProjectAdm=groupService.checkUserIsProjectAdm(xmProjectDb,user.getUserid());
					List<XmGroupVo> groupVoList=groupService.getProjectGroupVoList(xmProjectDb.getId());
					if(isProjectAdm==false){
						if(groupVoList==null){
							noAllowTasks.addAll(pt.getValue());
						}else{
							for (XmTask xmTask : pt.getValue()) {
								if(!user.getUserid().equals(xmTask.getCreateUserid()) && !user.getUserid().equals(xmTask.getExecutorUserid())){
									if(!groupService.checkUserIsOtherUserTeamHeadOrAss(groupVoList,xmTask.getCreateUserid(),user.getUserid())){
										if(!groupService.checkUserIsOtherUserTeamHeadOrAss(groupVoList,xmTask.getExecutorUserid(),user.getUserid())){
											noAllowTasks.add(xmTask);
										}
									}
								}
							}
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
				tips.setOkMsg(msgs.stream().collect(Collectors.joining(" ")));
			}else{
				tips.setFailureMsg(msgs.stream().collect(Collectors.joining(" ")));
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
			if(!StringUtils.hasText(xmTask.getId())){
				return ResponseHelper.failed("id-0","任务编号不能为空");
			}
			XmTask xmTaskDb=this.xmTaskService.selectOneObject(xmTask);
			if(xmTaskDb==null){
				return ResponseHelper.failed("data-0","计划任务已不存在");
			}
			String projectId=xmTaskDb.getProjectId();
			String productId=xmTaskDb.getProductId();
			tips=groupService.checkIsAdmOrTeamHeadOrAssByPtype(user,user.getUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
			if(!tips.isOk()){
				return ResponseHelper.failed(tips);
			}
			List<XmTask> allowDelNodes=new ArrayList<>();
			List<XmTask> noAllowNodes=new ArrayList<>();
			Map<String,XmTask> delNodesDbMap=this.xmTaskService.selectTasksMapByTasks(xmTasks);
			List<XmGroupVo> pgroups="0".equals(xmTaskDb.getPtype())? groupService.getProjectGroupVoList(projectId) : groupService.getProductGroupVoList(productId);
			for (XmTask node : delNodesDbMap.values()) {
				if("0".equals(xmTaskDb.getPtype()) && !projectId.equals(node.getProjectId()) ){
					return ResponseHelper.failed("not-same-project","所有任务必须同属于一个项目");
				}else if("1".equals(xmTaskDb.getPtype()) && !productId.equals(node.getProductId()) ){
					return ResponseHelper.failed("not-same-productId","所有任务必须同属于一个产品");
				}
				boolean isHead=groupService.checkUserIsOtherUserTeamHeadOrAss(pgroups,node.getCreateUserid(),user.getUserid());

				if(!isHead){
					noAllowNodes.add(node);
				}else {
					allowDelNodes.add(node);
				}

			}
			if(allowDelNodes.size()==0){
				return ResponseHelper.failed("noqx-del","组长或者管理人员可以删除管辖范围的任务，您无权限删除所选任务");
			}

			List<XmTask> existsExecuserList=new ArrayList<>();
			List<XmTask> noExecuserList=new ArrayList<>();
			if(allowDelNodes.size()>0){
				for (XmTask node : allowDelNodes) {
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
				msgs.add("以下"+hadChildNodes.size()+"个任务存在未删除的子任务，不能删除。【"+hadChildNodes.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
			}
			if(noAllowNodes.size()>0){
				msgs.add("以下"+noAllowNodes.size()+"个任务您无权删除。 【"+noAllowNodes.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
			}
			if(existsExecuserList.size()>0){
				msgs.add("以下"+existsExecuserList.size()+"个任务存在待结算的执行人，不能删除。【"+existsExecuserList.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
			}
			if(canDelNodes.size()==0){
				tips.setFailureMsg(msgs.stream().collect(Collectors.joining(" ")));
			}else{
				tips.setOkMsg(msgs.stream().collect(Collectors.joining(" ")));
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
			Map<String,XmTask> xmTaskDbMap=this.xmTaskService.selectTasksMapByTasks(xmTasks);
			XmTask xmTaskDb=xmTaskDbMap.values().stream().findFirst().isPresent()?xmTaskDbMap.values().stream().findFirst().get():null;
			if(xmTaskDb==null){
				return ResponseHelper.failed("data-0","任务不存在");
			}
			Tips tips2=this.groupService.checkIsAdmOrTeamHeadOrAssByPtype(user,user.getUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
			if(!tips2.isOk()){
				return ResponseHelper.failed(tips2);
			}
			Map<String,XmTask> allowTasksDbMap=new HashMap<>();
			Map<String,XmTask>  noAllowTasksDbMap=new HashMap<>();


			Map<String,XmTask> frontParamsTaskMap=new HashMap<>();
			List<XmTask> insertTasks=new ArrayList<>();
			List<XmTask> updateTasks=new ArrayList<>();
			for (XmTask task : xmTasks) {
				if( "0".equals(xmTaskDb.getPtype()) && !xmTaskDb.getProjectId().equals(task.getProjectId()) ){
					return ResponseHelper.failed("not-same-projectId","所有任务必须同属于一个项目");
				}
				if( "1".equals(xmTaskDb.getPtype()) && !xmTaskDb.getProductId().equals(task.getProductId()) ){
					return ResponseHelper.failed("not-same-productId","所有任务必须同属于一个产品");
				}
				if(task.getBudgetAt()==null){
					task.setBudgetAt(BigDecimal.ZERO);
				}
				if(task.getBudgetWorkload()==null){
					task.setBudgetWorkload(BigDecimal.ZERO);
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
			List<XmGroupVo> pgroups=new ArrayList<>();
			if("0".equals(xmTaskDb.getPtype())){
				pgroups=groupService.getProjectGroupVoList(xmTaskDb.getProjectId());
			}else{
				pgroups=groupService.getProductGroupVoList(xmTaskDb.getProductId());
			}
			for (XmTask task : xmTaskDbMap.values()) {
					boolean isHead=groupService.checkUserIsOtherUserTeamHeadOrAss(pgroups,task.getCreateUserid(),user.getUserid());
					if(!isHead){
						noAllowTasksDbMap.put(task.getId(),task);
					}else {
						allowTasksDbMap.put(task.getId(),task);
					}

			}
			List<XmTask> canOpTasks=xmTasks.stream().filter(i->!noAllowTasksDbMap.containsKey(i.getId())).collect(Collectors.toList());
			this.xmTaskService.parentIdPathsCalcBeforeSave(canOpTasks);
			List<XmTask> tasksLvl1=canOpTasks.stream().filter(i->i.getLvl()<=1).collect(Collectors.toList());
			if(tasksLvl1.size()>0){
				BigDecimal totalTaskBudgetAt=BigDecimal.ZERO;
				for (XmTask task : tasksLvl1) {

					totalTaskBudgetAt=totalTaskBudgetAt.add(task.getBudgetAt());
				}
				if("0".equals(xmTaskDb.getPtype()) && totalTaskBudgetAt.compareTo(BigDecimal.ZERO)>0){
					tips=xmTaskService.judgetProjectBudget(xmTaskDb.getProjectId(),totalTaskBudgetAt,tasksLvl1.stream().map(i->i.getId()).collect(Collectors.toList()));
					if(!tips.isOk()){
						tips.setFailureMsg(tips.getMsg()+" 相关任务【"+tasksLvl1.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
						return ResponseHelper.failed(tips);
					}
				}
			}
			Map<String,List<XmTask>> map=new HashMap<>();
			for (XmTask canOpTask : canOpTasks) {
				if(!StringUtils.hasText(canOpTask.getParentTaskid())||canOpTask.getParentTaskid().equals("0")){
					continue;
				}
				List<XmTask> childs=map.get(canOpTask.getParentTaskid());
				if(childs==null){
					childs=new ArrayList<>();
				}
				childs.add(canOpTask);
				map.put(canOpTask.getParentTaskid(),childs);
			}
			for (Map.Entry<String, List<XmTask>> kv : map.entrySet()) {
				BigDecimal childBudgetAt = BigDecimal.ZERO;
				List<XmTask> childs = kv.getValue();
				for (XmTask child : childs) {
					childBudgetAt = childBudgetAt.add(child.getBudgetAt());
				}
				if (childBudgetAt.compareTo(BigDecimal.ZERO) > 0) {
					tips = xmTaskService.judgetTaskBudget(kv.getKey(), childBudgetAt, null, null, null, childs.stream().map(i -> i.getId()).collect(Collectors.toList()));
					if (!tips.isOk()) {
						return ResponseHelper.failed("budget-not-enought", tips.getMsg() + " 相关任务【" + childs.stream().map(i -> i.getName()).collect(Collectors.joining(",")) + "】");
					}
				}
			}


			//过滤掉我没有权限的
			List<XmTask> canUpdateTasks=canOpTasks.stream().filter(i->xmTaskDbMap.containsKey(i.getId())).collect(Collectors.toList());
			List<XmTask> canInsertTasks=canOpTasks.stream().filter(i->!xmTaskDbMap.containsKey(i.getId())).collect(Collectors.toList());

			xmTaskService.batchInsertOrUpdate(canInsertTasks,canUpdateTasks);
			for (XmTask t : canUpdateTasks) {
				xmRecordService.addXmTaskRecord(t.getProjectId(), t.getId(), "项目-任务-批量修改任务预算", "修改任务预算"+t.getName(),JSON.toJSONString(t),null);

			}
			for (XmTask t : canInsertTasks) {
				xmRecordService.addXmTaskRecord(t.getProjectId(), t.getId(), "项目-任务-批量修改任务预算", "修改任务预算"+t.getName(),JSON.toJSONString(t),null);

			}
			if(canOpTasks.size()<=0){
				tips.setFailureMsg("成功修改0个任务。当前任务均无权限操作，只有组长助理、组长、项目助理、项目经理有权限批量修改预算。");
			}else if(canOpTasks.size()==xmTasks.size()){
				tips.setOkMsg("成功修改"+canOpTasks.size()+"个任务。");
			}else {
				tips.setOkMsg("成功修改"+canOpTasks.size()+"个任务。其中以下任务无权限修改。【"+noAllowTasksDbMap.values().stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
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
	@ApiOperation( value = "批量修改任务的上级",notes="batchChangeParentTask,仅需要上传主键字段")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmTask_batchChangeParentTask",name = "批量修改任务的上级",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchChangeParentTask",method=RequestMethod.POST)
	public Map<String,Object> batchChangeParentTask(@RequestBody BatchChangeParentTaskVo xmTasksVo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改");
		try{
			User user=LoginUtils.getCurrentUserInfo();

			if(xmTasksVo.getTaskIds()==null || xmTasksVo.getTaskIds().size()==0){
				tips.setFailureMsg("任务列表不能为空");
				m.put("tips", tips);
				return m;
			}
			if(!StringUtils.hasText(xmTasksVo.getParentTaskid())){
				return ResponseHelper.failed("parentTaskid-0", "上级编号不能为空");
			}
			List<String> ids=xmTasksVo.getTaskIds().stream().map(i->i).collect(Collectors.toList());
			ids.add(xmTasksVo.getParentTaskid());
			ids=ids.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
			List<XmTask> xmTasks=this.xmTaskService.selectTaskListByIds(ids);
			Optional<XmTask> optional=xmTasks.stream().filter(i->i.getId().equals(xmTasksVo.getParentTaskid())).findAny();
			if(!optional.isPresent()){
				return ResponseHelper.failed("parentTask-0", "上级不存在");
			}
			XmTask parentTask=optional.get();
			if(!"1".equals(parentTask.getNtype())){
				return ResponseHelper.failed("parentTask-ntype-not-1", "【"+parentTask.getName()+"】为任务，不能作为上级节点。请另选上级或者变更其为计划节点");
			}
			Tips tips2=this.groupService.checkIsAdmOrTeamHeadOrAssByPtype(user,user.getUserid(),parentTask.getPtype(),parentTask.getProductId(),parentTask.getProjectId());
			if(!tips2.isOk()){
				return ResponseHelper.failed(tips2);
			}
			xmTasks=xmTasks.stream().filter(i->!i.getId().equals(parentTask.getId())).collect(Collectors.toList());
			List<XmTask> canOpxmTasks=xmTasks.stream().filter(i->!parentTask.getId().equals(i.getParentTaskid())).collect(Collectors.toList());
			List<XmTask> sameParentTasks=xmTasks.stream().filter(i->parentTask.getId().equals(i.getParentTaskid())).collect(Collectors.toList());
			if(canOpxmTasks.size()==0){
				return ResponseHelper.failed("same-parent","所有任务均属于【"+parentTask.getName()+"】,无需再变更");
			}
			if(!"1".equals(parentTask.getPtype())){
				if(canOpxmTasks.stream().filter(i->!i.getProjectId().equals(parentTask.getProjectId())).findAny().isPresent()){
					return ResponseHelper.failed("projectId-not-same", "所有任务或计划必须都是同一个项目之下");
				}
			}else {
				if(canOpxmTasks.stream().filter(i->!i.getProductId().equals(parentTask.getProductId())).findAny().isPresent()){
					return ResponseHelper.failed("productId-not-same", "所有任务或计划必须都是同一个产品之下");
				}
			}

			Map<String,XmTask> allowTasksDbMap=new HashMap<>();
			Map<String,XmTask>  noAllowTasksDbMap=new HashMap<>();
			List<XmGroupVo> pgroups="0".equals(parentTask.getPtype())? groupService.getProjectGroupVoList(parentTask.getProjectId()) : groupService.getProductGroupVoList(parentTask.getProductId());
			boolean isAdm=groupService.checkUserIsPmOrAssByPtype(user.getUserid(),parentTask.getPtype(),parentTask.getProjectId(),parentTask.getProductId());
			if(!isAdm){
				for (XmTask task : canOpxmTasks) {
					boolean isHead=groupService.checkUserIsOtherUserTeamHeadOrAss(pgroups,task.getCreateUserid(),user.getUserid());
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
				if(!allowTasksDbMap.containsKey(t.getParentTaskid())){
					allowTasksDbMap2.put(t.getId(),t);
				}
			}
			Map<String,XmTask> allowTasksDbMap3=new HashMap<>();
			for (XmTask t : allowTasksDbMap2.values()) {
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
				if("1".equals(parentTask.getPtype())){
					this.xmRecordService.addProductXmTaskRecord(parentTask.getProductId(),parentTask.getId(),"批量挂接子节点","成功将以下"+allowTasksDbMap3.size()+"个计划或任务及其所有子项挂接到【"+parentTask.getName()+"】上,【"+allowTasksDbMap3.values().stream().map(i->i.getName()).collect(Collectors.joining(","))+"】;");
				}else {
					this.xmRecordService.addXmTaskRecord(parentTask.getProjectId(),parentTask.getId(),"批量挂接子节点","成功将以下"+allowTasksDbMap3.size()+"个计划或任务及其所有子项挂接到【"+parentTask.getName()+"】上,【"+allowTasksDbMap3.values().stream().map(i->i.getName()).collect(Collectors.joining(","))+"】;");
				}

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
				tips.setOkMsg(msgs.stream().collect(Collectors.joining(" ")));
			}else{
				tips.setFailureMsg(msgs.stream().collect(Collectors.joining(" ")));
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
