package com.xm.core.ctrl;

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
import com.xm.core.entity.XmMenu;
import com.xm.core.entity.XmTask;
import com.xm.core.entity.XmWorkload;
import com.xm.core.queue.XmTaskSumParentsPushService;
import com.xm.core.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.mdp.core.utils.ResponseHelper.failed;

/**
 * url编制采用rest风格,如对xm_workload 工时登记表的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmWorkload/add <br>
 *  查询: core/xmWorkload/list<br>
 *  模糊查询: core/xmWorkload/listKey<br>
 *  修改: core/xmWorkload/edit <br>
 *  删除: core/xmWorkload/del<br>
 *  批量删除: core/xmWorkload/batchDel<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmWorkload 表 xm_workload 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmWorkloadController")
@RequestMapping(value="/**/core/xmWorkload")
@Api(tags={"工时登记表操作接口"})
public class XmWorkloadController {
	
	static Logger logger =LoggerFactory.getLogger(XmWorkloadController.class);
	
	@Autowired
	private XmWorkloadService xmWorkloadService;

	@Autowired
	XmTaskService xmTaskService;

	@Autowired
	XmGroupService xmGroupService;
	@Autowired
	XmMenuService xmMenuService;
	@Autowired
	XmTaskSbillService xmTaskSbillService;

	@Autowired
	XmTaskSumParentsPushService pushService;


	Map<String,Object> fieldsMap = BaseUtils.toMap(new XmWorkload());
 
	
	@ApiOperation( value = "查询工时登记表信息列表",notes=" ") 
	@ApiResponses({
		@ApiResponse(code = 200,response= XmWorkload.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmWorkload( @ApiIgnore @RequestParam Map<String,Object> xmWorkload){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmWorkload, "ids");
		RequestUtils.transformArray( xmWorkload, "wstatuses");
		RequestUtils.transformArray( xmWorkload, "sstatuses");
		PageUtils.startPage(xmWorkload);
		String taskId= (String) xmWorkload.get("taskId");
		String sbillId= (String) xmWorkload.get("sbillId");
		String projectId= (String) xmWorkload.get("projectId");
		String userid= (String) xmWorkload.get("userid");
		User user=LoginUtils.getCurrentUserInfo();
		xmWorkload.put("linkBranchId",user.getBranchId());
		List<Map<String,Object>>	xmWorkloadList = xmWorkloadService.selectListMapByWhere(xmWorkload);	//列出XmWorkload列表
		PageUtils.responePage(m, xmWorkloadList);
		m.put("data",xmWorkloadList);

		m.put("tips", tips);
		return m;
	}
	@ApiOperation( value = "查询项目每日登记工时情况",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200,response= XmWorkload.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listProjectWorkloadSetDay",method=RequestMethod.GET)
	public Map<String,Object> listProjectWorkloadSetDay( @ApiIgnore @RequestParam Map<String,Object> xmWorkload){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		PageUtils.startPage(xmWorkload);
		User user=LoginUtils.getCurrentUserInfo();
		xmWorkload.put("linkBranchId",user.getBranchId());
		List<Map<String,Object>>	xmWorkloadList = xmWorkloadService.listProjectWorkloadSetDay(xmWorkload);	//列出XmWorkload列表
		PageUtils.responePage(m, xmWorkloadList);
		m.put("data",xmWorkloadList);

		m.put("tips", tips);
		return m;
	}


	@ApiOperation( value = "查询项目每月登记工时情况",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200,response= XmWorkload.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listProjectWorkloadSetMonth",method=RequestMethod.GET)
	public Map<String,Object> listProjectWorkloadSetMonth( @ApiIgnore @RequestParam Map<String,Object> xmWorkload){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		PageUtils.startPage(xmWorkload);
		User user=LoginUtils.getCurrentUserInfo();
		xmWorkload.put("linkBranchId",user.getBranchId());
		List<Map<String,Object>>	xmWorkloadList = xmWorkloadService.listProjectWorkloadSetMonth(xmWorkload);	//列出XmWorkload列表
		PageUtils.responePage(m, xmWorkloadList);
		m.put("data",xmWorkloadList);

		m.put("tips", tips);
		return m;
	}


	@ApiOperation( value = "按任务及报工人查询待确认工时",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200,response= XmWorkload.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/ListGroupByTaskIdAndUserid",method=RequestMethod.GET)
	public Map<String,Object> ListGroupByTaskIdAndUserid( @ApiIgnore @RequestParam Map<String,Object> xmWorkload){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmWorkload, "ids");
		RequestUtils.transformArray( xmWorkload, "wstatuses");
		RequestUtils.transformArray( xmWorkload, "sstatuses");
		PageUtils.startPage(xmWorkload);
		User user=LoginUtils.getCurrentUserInfo();
		xmWorkload.put("linkBranchId",user.getBranchId());
		String queryScope= (String) xmWorkload.get("queryScope");
		if("my".equals(queryScope)){
			xmWorkload.put("userid",user.getUserid());
		}
		List<Map<String,Object>>	xmWorkloadList = xmWorkloadService.ListGroupByTaskIdAndUserid(xmWorkload);	//列出XmWorkload列表
		PageUtils.responePage(m, xmWorkloadList);
		m.put("data",xmWorkloadList);

		m.put("tips", tips);
		return m;
	}

	@ApiOperation( value = "按任务及报工人查询待确认工时",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200,response= XmWorkload.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/ListGroupByTaskIdAndUseridToSet",method=RequestMethod.GET)
	public Map<String,Object> ListGroupByTaskIdAndUseridToSet( @ApiIgnore @RequestParam Map<String,Object> xmWorkload){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmWorkload, "ids");
		RequestUtils.transformArray( xmWorkload, "wstatuses");
		RequestUtils.transformArray( xmWorkload, "sstatuses");
		PageUtils.startPage(xmWorkload);
		String queryScope= (String) xmWorkload.get("queryScope");
		User user=LoginUtils.getCurrentUserInfo();
		xmWorkload.put("linkBranchId",user.getBranchId());
		if("my".equals(queryScope)){
			xmWorkload.put("userid",user.getUserid());
		}
		List<Map<String,Object>>	xmWorkloadList = xmWorkloadService.ListGroupByTaskIdAndUseridToSet(xmWorkload);	//列出XmWorkload列表
		PageUtils.responePage(m, xmWorkloadList);
		m.put("data",xmWorkloadList);

		m.put("tips", tips);
		return m;
	}


	@ApiOperation( value = "新增一条工时登记表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response= XmWorkload.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmWorkload(@RequestBody XmWorkload xmWorkload) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			User user= LoginUtils.getCurrentUserInfo();
			xmWorkload.setId(xmWorkloadService.createKey("id"));

			if(!StringUtils.hasText(xmWorkload.getTaskId())) {
				return failed("taskId-0","请上送任务编号");
			}

			if(!StringUtils.hasText(xmWorkload.getUserid())){
				return failed("userid-0","请上送工作人员编号");
			}
			if(!StringUtils.hasText(xmWorkload.getUbranchId())){
				return failed("ubranchId-0","请上送工作人员归属机构");
			}

			if(!StringUtils.hasText(xmWorkload.getBizDate())) {
				return failed("bizDate-0","请上送日期");
			}
			if(xmWorkload.getWorkload()==null) {
				return failed("workload-0","工时不能为空");
			}

			if(xmWorkload.getWorkload().compareTo(BigDecimal.ZERO)==0) {
				return failed("workload-0","工时不能为0");
			}
			XmWorkload xmWorkloadCount=new XmWorkload();
			//xmWorkloadCount.setUserid(user.getUserid());
			xmWorkloadCount.setBizDate(xmWorkload.getBizDate());
			xmWorkloadCount.setTaskId(xmWorkload.getTaskId());
			long count=this.xmWorkloadService.countByWhere(xmWorkloadCount);
			if(count>0){
				return failed("data-1","当前任务今天已经报工");
			}
			XmTask xmTaskDb=this.xmTaskService.selectOneObject(new XmTask(xmWorkload.getTaskId()));
			if(xmTaskDb==null ){
				return failed("data-0","任务已不存在");
			}
			if("1".equals(xmTaskDb.getNtype())){
				return failed("ntype-1",xmTaskDb.getName()+"为计划，不是任务，不用登记工时");
			}
			if("3".equals(xmTaskDb.getTaskState())){
				return failed("taskState-3",xmTaskDb.getName()+"已结算完毕，不能再提交工时");
			}
			if(!(user.getUserid().equals(xmTaskDb.getCreateUserid())|| user.getUserid().equals(xmTaskDb.getExecutorUserid()))){
				Tips isCreate=xmGroupService.checkIsAdmOrTeamHeadOrAss(user,xmTaskDb.getCreateUserid(),xmTaskDb.getProjectId());
				if(!isCreate.isOk()){
					Tips isExec=xmGroupService.checkIsAdmOrTeamHeadOrAss(user,xmTaskDb.getExecutorUserid(),xmTaskDb.getProjectId());
					if(!isExec.isOk()){
						return failed("noqx-0","你无权针对该业务进行报工");
					}

				}
			}
			xmWorkload.setCtime(new Date());
			xmWorkload.setCuserid(user.getUserid());

			xmWorkload.setWstatus("0");
			xmWorkload.setProjectId(xmTaskDb.getProjectId());
			xmWorkload.setBranchId(xmTaskDb.getCbranchId());
			xmWorkloadService.insert(xmWorkload);
			if(xmWorkload.getRworkload()!=null && BigDecimal.ZERO.compareTo(xmWorkload.getRworkload())<=0){
				BigDecimal newBudgetWorkload= xmWorkload.getRworkload().add(NumberUtil.getBigDecimal(xmWorkload.getWorkload(),BigDecimal.ZERO)).add(NumberUtil.getBigDecimal(xmTaskDb.getActWorkload(),BigDecimal.ZERO));
				List<String> ids=new ArrayList<>();
				ids.add(xmTaskDb.getId());
				this.xmTaskService.batchUpdateBudgetWorkloadAndRate(ids,newBudgetWorkload );
			}
			this.xmTaskService.calcWorkloadByRecord(xmTaskDb.getId());
			pushService.pushXmTask(xmTaskDb);
			m.put("data",xmWorkload);
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
	@ApiOperation( value = "根据主键修改一条工时登记表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response= XmWorkload.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmWorkload(@RequestBody XmWorkload xmWorkload) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmWorkload.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmWorkload xmWorkloadDb = xmWorkloadService.selectOneObject(xmWorkload);
            if( xmWorkloadDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			XmTask xmTaskDb=this.xmTaskService.selectOneObject(new XmTask(xmWorkloadDb.getTaskId()));
			if(xmTaskDb==null ){
				return failed("data-0","任务已不存在");
			}
			if("1".equals(xmTaskDb.getNtype())){
				return failed("ntype-1",xmTaskDb.getName()+"为计划，不是任务，不用登记工时");
			}
			User user= LoginUtils.getCurrentUserInfo();
			if(!(user.getUserid().equals(xmTaskDb.getCreateUserid())|| user.getUserid().equals(xmTaskDb.getExecutorUserid()))){
				Tips isCreate=xmGroupService.checkIsAdmOrTeamHeadOrAss(user,xmTaskDb.getCreateUserid(),xmTaskDb.getProjectId());
				if(!isCreate.isOk()){
					Tips isExec=xmGroupService.checkIsAdmOrTeamHeadOrAss(user,xmTaskDb.getExecutorUserid(),xmTaskDb.getProjectId());
					if(!isExec.isOk()){
						return failed("noqx-0","你无权针对该业务进行报工");
					}

				}
			}
			xmWorkloadService.updateSomeFieldByPk(xmWorkload);
			pushService.pushXmTask(xmTaskDb);
			this.xmTaskService.calcWorkloadByRecord(xmWorkload.getTaskId());

			m.put("data",xmWorkload);
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
	

	@ApiOperation( value = "根据主键列表批量删除工时登记表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmWorkload(@RequestBody List<XmWorkload> xmWorkloads) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmWorkloads.size()+"条数据"); 
		try{
			if(xmWorkloads.stream().filter(i->!StringUtils.hasText(i.getId())).findAny().isPresent()){
				return ResponseHelper.failed("id-0","主键不能为空");
			}
			xmWorkloads = xmWorkloadService.selectListByIds(xmWorkloads.stream().map(i->i.getId()).collect(Collectors.toList()));
			if(xmWorkloads==null || xmWorkloads.size()==0){
				return ResponseHelper.failed("data-0","工时已不存在");
			}
			User user= LoginUtils.getCurrentUserInfo();
			List<String> taskIds=xmWorkloads.stream().map(i->i.getTaskId()).collect(Collectors.toSet()).stream().collect(Collectors.toList());
			List<XmTask> tasksDb=this.xmTaskService.selectListByIds(taskIds);
			Map<String,XmTask> taskMap=new HashMap<>();
			Map<String,XmTask> canDelTaskMap=new HashMap<>();
			for (XmTask xmTask : tasksDb) {
				taskMap.put(xmTask.getId(),xmTask);
			}
			Set<String> xmMenuIds=new HashSet<>();
			for (XmTask xmTaskDb : tasksDb) {
				if(!(user.getUserid().equals(xmTaskDb.getCreateUserid())|| user.getUserid().equals(xmTaskDb.getExecutorUserid()))){
					Tips isCreate=xmGroupService.checkIsAdmOrTeamHeadOrAss(user,xmTaskDb.getCreateUserid(),xmTaskDb.getProjectId());
					if(!isCreate.isOk()){
						Tips isExec=xmGroupService.checkIsAdmOrTeamHeadOrAss(user,xmTaskDb.getExecutorUserid(),xmTaskDb.getProjectId());
						if(!isExec.isOk()){
							break;
						}

					}
				}
				canDelTaskMap.put(xmTaskDb.getId(),xmTaskDb);
				if(StringUtils.hasText(xmTaskDb.getMenuId())){
					xmMenuIds.add(xmTaskDb.getMenuId());
				}
			}
			List<XmWorkload> canDel=new ArrayList<>();
			List<XmWorkload> state1Ndel=new ArrayList<>();
			List<XmWorkload> noQxDel=new ArrayList<>();
			for (XmWorkload xmWorkload : xmWorkloads) {
				 if(canDelTaskMap.containsKey(xmWorkload.getTaskId())){
				 	if(!"1".equals(xmWorkload.getWstatus())){
				 		canDel.add(xmWorkload);
					} else{
						state1Ndel.add(xmWorkload);
					}
				 }else{
				 	if(!taskMap.containsKey(xmWorkload.getTaskId())){//对应任务已被删除，不存在了
				 		if(!"1".equals(xmWorkload.getWstatus())){
							canDel.add(xmWorkload);
						}else{
							state1Ndel.add(xmWorkload);
						}
					}else{
						noQxDel.add(xmWorkload);
					}
				 }
			}

			List<String> msgs=new ArrayList<>();
			if(canDel.size()>0){
				xmWorkloadService.batchDelete(canDel);
				this.xmTaskService.calcWorkloadByRecord(canDelTaskMap.keySet().stream().collect(Collectors.toList()));
 				pushService.pushXmTasks(canDelTaskMap.values().stream().collect(Collectors.toList()));
				msgs.add("成功删除"+canDel.size()+"条工时单据。");
			}
			if(state1Ndel.size()>0){
 				msgs.add("以下"+state1Ndel.size()+"条工时单据状态为确认状态，不允许删除。【"+state1Ndel.stream().map(i->i.getUsername()+i.getBizDate()).collect(Collectors.joining(","))+"】");
			}
			if(noQxDel.size()>0){
				msgs.add("以下"+noQxDel.size()+"条工时单据无权限删除，您只能删除你负责的任务的工时单据，【"+noQxDel.stream().map(i->i.getUsername()+i.getBizDate()).collect(Collectors.joining(","))+"】.");
			}
			if(canDel.size()>0){
				tips.setOkMsg(msgs.stream().collect(Collectors.joining()));
			}else{
				tips.setFailureMsg(msgs.stream().collect(Collectors.joining()));
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





	@ApiOperation( value = "批量更新工时表状态各个字段",notes="xmWorkloadMap")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMenu.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmWorkload_editSomeFields",name = "批量修改修改任务中的某些字段",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields(@RequestBody Map<String,Object> xmWorkloadMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			List<String> ids= (List<String>) xmWorkloadMap.get("ids");

			if(ids==null || ids.size()==0){
				return ResponseHelper.failed("ids-0","ids不能为空");
			}
			Set<String> fields=new HashSet<>();
			fields.add("workload");
			fields.add("userid");
			fields.add("username");
			fields.add("projectId");
			fields.add("sbillId");

			for (String fieldName : xmWorkloadMap.keySet()) {
				if(fields.contains(fieldName)){
					return ResponseHelper.failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			List<XmWorkload> xmWorkloadsDb= xmWorkloadService.selectListByIds(ids);
			if(xmWorkloadsDb==null ||xmWorkloadsDb.size()==0){
				return ResponseHelper.failed("tasks-0","该工时已不存在");
			}
			String wstatus= (String) xmWorkloadMap.get("wstatus");
			String sstatus= (String) xmWorkloadMap.get("sstatus");
			if(StringUtils.hasText(sstatus)){
				if(!"0".equals(sstatus) && !"1".equals(sstatus)){
					return ResponseHelper.failed("sstatus-not-01","只能修改为无需结算或者待结算");
				}
			}
			if(StringUtils.hasText(wstatus)){
				if(!"0".equals(wstatus) && !"1".equals(wstatus) ){
					return ResponseHelper.failed("wstatus-not-01","工时状态不正确");
				}
			}
			List<String> taskIds=xmWorkloadsDb.stream().map(i->i.getTaskId()).collect(Collectors.toSet()).stream().collect(Collectors.toList());

			Map<String,XmTask> taskMap=new HashMap<>();
			if(xmWorkloadMap.containsKey("sstatus") && "1".equals(sstatus)){
				List<XmTask> tasks=this.xmTaskService.selectListByIds(taskIds);
				for (XmTask task : tasks) {
					taskMap.put(task.getId(),task);
				}
			}

			List<XmWorkload> canChanges=new ArrayList<>();
			List<XmWorkload> sstatusNot01=new ArrayList<>();
			List<XmWorkload> taskStateNot34=new ArrayList<>();
			for (XmWorkload xmWorkload : xmWorkloadsDb) {
				if(!"1".equals(xmWorkload.getSstatus()) && !"0".equals(xmWorkload.getSstatus()) &&StringUtils.hasText(xmWorkload.getSstatus())){
					sstatusNot01.add(xmWorkload);
				}else{
					if(xmWorkloadMap.containsKey("sstatus") && "1".equals(sstatus)){
						XmTask task=taskMap.get(xmWorkload.getTaskId());
						if(task==null || (!"2".equals(task.getTaskState()) && !"3".equals(task.getTaskState()))){
							taskStateNot34.add(xmWorkload);
							continue;
						}
					}
					canChanges.add(xmWorkload);
				}
			}



			if(canChanges.size()>0){
				xmWorkloadMap.put("ids",canChanges.stream().map(i->i.getId()).collect(Collectors.toList()));
				Set<String> fieldKey=xmWorkloadMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
				fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmWorkloadMap.get(i) )).collect(Collectors.toSet());

				if(fieldKey.size()>0){
					xmWorkloadService.editSomeFieldsWithSbillIds(xmWorkloadMap,null);
				}
			}
			List<String> msgs=new ArrayList<>();
			if(canChanges.size()>0){
				msgs.add("成功修改"+canChanges.size()+"条工时清单");
			}

			if(sstatusNot01.size()>0){
				msgs.add("有"+sstatusNot01.size()+"条工时不是待结算状态，不允许更改");
			}
			if(taskStateNot34.size()>0){
				msgs.add("有"+taskStateNot34.size()+"条工时对应的任务不是已完工状态，不允许进入结算池");
			}
			if(canChanges.size()>0){
				tips.setOkMsg(msgs.stream().collect(Collectors.joining()));
			}else{
				tips.setFailureMsg(msgs.stream().collect(Collectors.joining()));
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
}
