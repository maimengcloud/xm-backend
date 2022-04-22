package com.xm.core.ctrl;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.LongUnaryOperator;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;

import com.alibaba.fastjson.JSON;
import com.mdp.core.utils.BaseUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.*;
import com.xm.core.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import static com.mdp.core.utils.ResponseHelper.*;
import static com.mdp.core.utils.BaseUtils.*;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.mybatis.PageUtils;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.NumberUtil;

/**
 * url编制采用rest风格,如对xm_task_workload 工时登记表的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmTaskWorkload/add <br>
 *  查询: core/xmTaskWorkload/list<br>
 *  模糊查询: core/xmTaskWorkload/listKey<br>
 *  修改: core/xmTaskWorkload/edit <br>
 *  删除: core/xmTaskWorkload/del<br>
 *  批量删除: core/xmTaskWorkload/batchDel<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTaskWorkload 表 xm_task_workload 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmTaskWorkloadController")
@RequestMapping(value="/**/core/xmTaskWorkload")
@Api(tags={"工时登记表操作接口"})
public class XmTaskWorkloadController {
	
	static Logger logger =LoggerFactory.getLogger(XmTaskWorkloadController.class);
	
	@Autowired
	private XmTaskWorkloadService xmTaskWorkloadService;

	@Autowired
	XmTaskService xmTaskService;

	@Autowired
	XmGroupService xmGroupService;
	@Autowired
	XmMenuService xmMenuService;
	@Autowired
	XmTaskSbillService xmTaskSbillService;


	Map<String,Object> fieldsMap = BaseUtils.toMap(new XmTaskWorkload());
 
	
	@ApiOperation( value = "查询工时登记表信息列表",notes=" ") 
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskWorkload.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTaskWorkload( @RequestParam Map<String,Object> xmTaskWorkload){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmTaskWorkload, "ids");
		RequestUtils.transformArray( xmTaskWorkload, "wstatuses");
		RequestUtils.transformArray( xmTaskWorkload, "sstatuses");
		PageUtils.startPage(xmTaskWorkload);
		String taskId= (String) xmTaskWorkload.get("taskId");
		String sbillId= (String) xmTaskWorkload.get("sbillId");
		String projectId= (String) xmTaskWorkload.get("projectId");
		String userid= (String) xmTaskWorkload.get("userid");
		User user=LoginUtils.getCurrentUserInfo();
		List<Map<String,Object>>	xmTaskWorkloadList = xmTaskWorkloadService.selectListMapByWhere(xmTaskWorkload);	//列出XmTaskWorkload列表
		PageUtils.responePage(m, xmTaskWorkloadList);
		m.put("data",xmTaskWorkloadList);

		m.put("tips", tips);
		return m;
	}
	@ApiOperation( value = "查询项目每日登记工时情况",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskWorkload.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listProjectWorkloadSetDay",method=RequestMethod.GET)
	public Map<String,Object> listProjectWorkloadSetDay( @RequestParam Map<String,Object> xmTaskWorkload){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		PageUtils.startPage(xmTaskWorkload);
		List<Map<String,Object>>	xmTaskWorkloadList = xmTaskWorkloadService.listProjectWorkloadSetDay(xmTaskWorkload);	//列出XmTaskWorkload列表
		PageUtils.responePage(m, xmTaskWorkloadList);
		m.put("data",xmTaskWorkloadList);

		m.put("tips", tips);
		return m;
	}


	@ApiOperation( value = "查询项目每月登记工时情况",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskWorkload.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listProjectWorkloadSetMonth",method=RequestMethod.GET)
	public Map<String,Object> listProjectWorkloadSetMonth( @RequestParam Map<String,Object> xmTaskWorkload){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		PageUtils.startPage(xmTaskWorkload);
		List<Map<String,Object>>	xmTaskWorkloadList = xmTaskWorkloadService.listProjectWorkloadSetMonth(xmTaskWorkload);	//列出XmTaskWorkload列表
		PageUtils.responePage(m, xmTaskWorkloadList);
		m.put("data",xmTaskWorkloadList);

		m.put("tips", tips);
		return m;
	}

	@ApiOperation( value = "新增一条工时登记表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskWorkload.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTaskWorkload(@RequestBody XmTaskWorkload xmTaskWorkload) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			User user= LoginUtils.getCurrentUserInfo();
			xmTaskWorkload.setId(xmTaskWorkloadService.createKey("id"));

			if(!StringUtils.hasText(xmTaskWorkload.getTaskId())) {
				return failed("taskId-0","请上送任务编号");
			}

			if(!StringUtils.hasText(xmTaskWorkload.getBizDate())) {
				return failed("bizDate-0","请上送日期");
			}
			if(xmTaskWorkload.getWorkload()==null) {
				return failed("workload-0","工时不能为空");
			}

			if(xmTaskWorkload.getWorkload().compareTo(BigDecimal.ZERO)==0) {
				return failed("workload-0","工时不能为0");
			}
			XmTaskWorkload xmTaskWorkloadCount=new XmTaskWorkload();
			//xmTaskWorkloadCount.setUserid(user.getUserid());
			xmTaskWorkloadCount.setBizDate(xmTaskWorkload.getBizDate());
			xmTaskWorkloadCount.setTaskId(xmTaskWorkload.getTaskId());
			long count=this.xmTaskWorkloadService.countByWhere(xmTaskWorkloadCount);
			if(count>0){
				return failed("data-1","当前任务今天已经报工");
			}
			XmTask xmTaskDb=this.xmTaskService.selectOneObject(new XmTask(xmTaskWorkload.getTaskId()));
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
				Tips isCreate=xmGroupService.checkIsAdmOrTeamHeadOrAssByPtype(user,xmTaskDb.getCreateUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
				if(!isCreate.isOk()){
					Tips isExec=xmGroupService.checkIsAdmOrTeamHeadOrAssByPtype(user,xmTaskDb.getExecutorUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
					if(!isExec.isOk()){
						return failed("noqx-0","你无权针对该业务进行报工");
					}

				}
			}
			xmTaskWorkload.setCtime(new Date());
			xmTaskWorkload.setCuserid(user.getUserid());
			if(!StringUtils.hasText(xmTaskWorkload.getUserid())){
				xmTaskWorkload.setUserid(user.getUserid());
				xmTaskWorkload.setUsername(user.getUsername());
			}

			xmTaskWorkload.setWstatus("0");
			xmTaskWorkload.setProjectId(xmTaskDb.getProjectId());
			xmTaskWorkloadService.insert(xmTaskWorkload);
			if(xmTaskWorkload.getRworkload()!=null && BigDecimal.ZERO.compareTo(xmTaskWorkload.getRworkload())<0){
				BigDecimal newBudgetWorkload= xmTaskWorkload.getRworkload().add(NumberUtil.getBigDecimal(xmTaskWorkload.getWorkload(),BigDecimal.ZERO)).add(NumberUtil.getBigDecimal(xmTaskDb.getActWorkload(),BigDecimal.ZERO));
				List<String> ids=new ArrayList<>();
				ids.add(xmTaskDb.getId());
				this.xmTaskService.batchUpdateBudgetWorkloadAndRate(ids,newBudgetWorkload );
			}
			this.xmTaskService.calcWorkloadByRecord(xmTaskDb.getId());
			this.xmTaskService.sumParents(xmTaskDb);
			m.put("data",xmTaskWorkload);
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
		@ApiResponse(code = 200,response=XmTaskWorkload.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTaskWorkload(@RequestBody XmTaskWorkload xmTaskWorkload) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmTaskWorkload.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmTaskWorkload xmTaskWorkloadDb = xmTaskWorkloadService.selectOneObject(xmTaskWorkload);
            if( xmTaskWorkloadDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			XmTask xmTaskDb=this.xmTaskService.selectOneObject(new XmTask(xmTaskWorkloadDb.getTaskId()));
			if(xmTaskDb==null ){
				return failed("data-0","任务已不存在");
			}
			if("1".equals(xmTaskDb.getNtype())){
				return failed("ntype-1",xmTaskDb.getName()+"为计划，不是任务，不用登记工时");
			}
			User user= LoginUtils.getCurrentUserInfo();
			if(!(user.getUserid().equals(xmTaskDb.getCreateUserid())|| user.getUserid().equals(xmTaskDb.getExecutorUserid()))){
				Tips isCreate=xmGroupService.checkIsAdmOrTeamHeadOrAssByPtype(user,xmTaskDb.getCreateUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
				if(!isCreate.isOk()){
					Tips isExec=xmGroupService.checkIsAdmOrTeamHeadOrAssByPtype(user,xmTaskDb.getExecutorUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
					if(!isExec.isOk()){
						return failed("noqx-0","你无权针对该业务进行报工");
					}

				}
			}
			xmTaskWorkloadService.updateSomeFieldByPk(xmTaskWorkload);
		this.xmTaskService.sumParents(xmTaskDb);

			this.xmTaskService.calcWorkloadByRecord(xmTaskWorkload.getTaskId());

			m.put("data",xmTaskWorkload);
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
	public Map<String,Object> batchDelXmTaskWorkload(@RequestBody List<XmTaskWorkload> xmTaskWorkloads) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmTaskWorkloads.size()+"条数据"); 
		try{
			if(xmTaskWorkloads.stream().filter(i->!StringUtils.hasText(i.getId())).findAny().isPresent()){
				return ResponseHelper.failed("id-0","主键不能为空");
			}
			xmTaskWorkloads = xmTaskWorkloadService.selectListByIds(xmTaskWorkloads.stream().map(i->i.getId()).collect(Collectors.toList()));
			if(xmTaskWorkloads==null || xmTaskWorkloads.size()==0){
				return ResponseHelper.failed("data-0","工时已不存在");
			}
			User user= LoginUtils.getCurrentUserInfo();
			List<String> taskIds=xmTaskWorkloads.stream().map(i->i.getTaskId()).collect(Collectors.toSet()).stream().collect(Collectors.toList());
			List<XmTask> tasksDb=this.xmTaskService.selectListByIds(taskIds);
			Map<String,XmTask> taskMap=new HashMap<>();
			Map<String,XmTask> canDelTaskMap=new HashMap<>();
			for (XmTask xmTask : tasksDb) {
				taskMap.put(xmTask.getId(),xmTask);
			}
			Set<String> xmMenuIds=new HashSet<>();
			for (XmTask xmTaskDb : tasksDb) {
				if(!(user.getUserid().equals(xmTaskDb.getCreateUserid())|| user.getUserid().equals(xmTaskDb.getExecutorUserid()))){
					Tips isCreate=xmGroupService.checkIsAdmOrTeamHeadOrAssByPtype(user,xmTaskDb.getCreateUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
					if(!isCreate.isOk()){
						Tips isExec=xmGroupService.checkIsAdmOrTeamHeadOrAssByPtype(user,xmTaskDb.getExecutorUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
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
			List<XmTaskWorkload> canDel=new ArrayList<>();
			List<XmTaskWorkload> state1Ndel=new ArrayList<>();
			List<XmTaskWorkload> noQxDel=new ArrayList<>();
			for (XmTaskWorkload xmTaskWorkload : xmTaskWorkloads) {
				 if(canDelTaskMap.containsKey(xmTaskWorkload.getTaskId())){
				 	if(!"1".equals(xmTaskWorkload.getWstatus())){
				 		canDel.add(xmTaskWorkload);
					} else{
						state1Ndel.add(xmTaskWorkload);
					}
				 }else{
				 	if(!taskMap.containsKey(xmTaskWorkload.getTaskId())){//对应任务已被删除，不存在了
				 		if(!"1".equals(xmTaskWorkload.getWstatus())){
							canDel.add(xmTaskWorkload);
						}else{
							state1Ndel.add(xmTaskWorkload);
						}
					}else{
						noQxDel.add(xmTaskWorkload);
					}
				 }
			}

			List<String> msgs=new ArrayList<>();
			if(canDel.size()>0){
				xmTaskWorkloadService.batchDelete(canDel);
				this.xmTaskService.calcWorkloadByRecord(canDelTaskMap.keySet().stream().collect(Collectors.toList()));
				this.xmTaskService.batchSumParents(canDelTaskMap.values().stream().collect(Collectors.toList()));
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



	@ApiOperation( value = "",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskWorkload.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/batchSetSbillIdNull",method=RequestMethod.POST)
	public Map<String,Object> batchSetSbillIdNull(@RequestBody List<XmTaskWorkload> xmTaskWorkloads) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功移出结算单");
		try{

			List<String> ids= xmTaskWorkloads.stream().map(i->i.getId()).collect(Collectors.toList());
			if(ids==null || ids.size()==0){
				return ResponseHelper.failed("ids-0","工时变化ids不能为空");
			}

			User user= LoginUtils.getCurrentUserInfo();

			List<XmTaskWorkload> list=this.xmTaskWorkloadService.selectListByIds(ids);
			if(list.size()==0){
				return ResponseHelper.failed("data-0","工时明细不存在");
			}

			List<XmTaskSbill> xmTaskSbills=this.xmTaskSbillService.selectListByIds(list.stream().map(i->i.getSbillId()).collect(Collectors.toSet()).stream().collect(Collectors.toList()));
			Map<String,XmTaskSbill> canBillMap=new HashMap<>();
			for (XmTaskSbill xmTaskSbill : xmTaskSbills) {
				if(user.getUserid().equals(xmTaskSbill.getCuserid())){
					if("0".equals(xmTaskSbill.getStatus())){
						canBillMap.put(xmTaskSbill.getId(),xmTaskSbill);
					}
				}
			}
			List<XmTaskWorkload> canChanges=list.stream().filter(i->canBillMap.containsKey(i.getSbillId())).collect(Collectors.toList());
			List<XmTaskWorkload> noChanges=list.stream().filter(i->!canBillMap.containsKey(i.getSbillId())).collect(Collectors.toList());
			if(canChanges.size()>0){
				xmTaskWorkloadService.batchSetSbillIdNull(canChanges.stream().map(i->i.getId()).collect(Collectors.toList()));

			}
			List<String> msgs=new ArrayList<>();
			if(canChanges.size()>0){
				msgs.add("成功将"+canChanges.size()+"条工时移出结算单");
			}

			if(noChanges.size()>0){
				msgs.add("有"+noChanges.size()+"条工时对应的结算单不是待提交状态，不允许更改");
			}
			if(canChanges.size()>0){
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

	@ApiOperation( value = "",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskWorkload.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editWorkloadToSbill",method=RequestMethod.POST)
	public Map<String,Object> editWorkloadToSbill(@RequestBody Map<String,Object> params) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功添加到结算单");
		try{

			List<String> ids= (List<String>) params.get("ids");
			if(ids==null || ids.size()==0){
				return ResponseHelper.failed("ids-0","工时变化ids不能为空");
			}
			String sbillId= (String) params.get("sbillId");
			if(!StringUtils.hasText(sbillId)){
				return ResponseHelper.failed("sbillId-0","结算单变编号不能为空");
			}
			XmTaskSbill xmTaskSbillDb=this.xmTaskSbillService.selectOneObject(new XmTaskSbill(sbillId));
			if(xmTaskSbillDb==null){
				return ResponseHelper.failed("sbillId-0","结算单不存在");
			}
			if(!"0".equals(xmTaskSbillDb.getStatus())){
				return ResponseHelper.failed("status-not-0","结算单已提交，不允许再更改");
			}
			User user= LoginUtils.getCurrentUserInfo();
			if(!user.getUserid().equals(xmTaskSbillDb.getCuserid())){
				return ResponseHelper.failed("cuserid-0","结算单不属于您的，无权修改");
			}
			List<XmTaskWorkload> list=this.xmTaskWorkloadService.selectListByIds(ids);
			if(list.size()==0){
				return ResponseHelper.failed("data-0","工时明细不存在");
			}
			List<XmTaskWorkload> canChanges=list.stream().filter(i->"1".equals(i.getSstatus()) && "1".equals(i.getWstatus())).collect(Collectors.toList());
			List<XmTaskWorkload> sstatusNot1=list.stream().filter(i->!"1".equals(i.getSstatus()) || !"1".equals(i.getWstatus())).collect(Collectors.toList());

			if(canChanges.size()>0){
				xmTaskWorkloadService.editWorkloadToSbill(sbillId,canChanges);
			}
			List<String> msgs=new ArrayList<>();
			if(canChanges.size()>0){
				msgs.add("成功将"+canChanges.size()+"条工时加入结算单");
			}

			if(sstatusNot1.size()>0){
				msgs.add("有"+sstatusNot1.size()+"条工时不是待结算状态，不允许更改");
			}
			if(canChanges.size()>0){
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


	@ApiOperation( value = "批量更新工时表状态各个字段",notes="xmTaskWorkloadMap")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMenu.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTaskWorkload_editSomeFields",name = "批量修改修改任务中的某些字段",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields(@RequestBody Map<String,Object> xmTaskWorkloadMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			List<String> ids= (List<String>) xmTaskWorkloadMap.get("ids");

			if(ids==null || ids.size()==0){
				return ResponseHelper.failed("ids-0","ids不能为空");
			}
			Set<String> fields=new HashSet<>();
			fields.add("workload");
			fields.add("userid");
			fields.add("username");
			fields.add("projectId");
			fields.add("sbillId");

			for (String fieldName : xmTaskWorkloadMap.keySet()) {
				if(fields.contains(fieldName)){
					return ResponseHelper.failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			List<XmTaskWorkload> xmTaskWorkloadsDb=xmTaskWorkloadService.selectListByIds(ids);
			if(xmTaskWorkloadsDb==null ||xmTaskWorkloadsDb.size()==0){
				return ResponseHelper.failed("tasks-0","该工时已不存在");
			}
			String wstatus= (String) xmTaskWorkloadMap.get("wstatus");
			String sstatus= (String) xmTaskWorkloadMap.get("sstatus");
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
			List<String> taskIds=xmTaskWorkloadsDb.stream().map(i->i.getTaskId()).collect(Collectors.toSet()).stream().collect(Collectors.toList());

			Map<String,XmTask> taskMap=new HashMap<>();
			if(xmTaskWorkloadMap.containsKey("sstatus") && "1".equals(sstatus)){
				List<XmTask> tasks=this.xmTaskService.selectListByIds(taskIds);
				for (XmTask task : tasks) {
					taskMap.put(task.getId(),task);
				}
			}

			List<XmTaskWorkload> canChanges=new ArrayList<>();
			List<XmTaskWorkload> sstatusNot01=new ArrayList<>();
			List<XmTaskWorkload> taskStateNot34=new ArrayList<>();
			for (XmTaskWorkload xmTaskWorkload : xmTaskWorkloadsDb) {
				if(!"1".equals(xmTaskWorkload.getSstatus()) && !"0".equals(xmTaskWorkload.getSstatus()) &&StringUtils.hasText(xmTaskWorkload.getSstatus())){
					sstatusNot01.add(xmTaskWorkload);
				}else{
					if(xmTaskWorkloadMap.containsKey("sstatus") && "1".equals(sstatus)){
						XmTask task=taskMap.get(xmTaskWorkload.getTaskId());
						if(task==null || (!"2".equals(task.getTaskState()) && !"3".equals(task.getTaskState()))){
							taskStateNot34.add(xmTaskWorkload);
							continue;
						}
					}
					canChanges.add(xmTaskWorkload);
				}
			}



			if(canChanges.size()>0){
				xmTaskWorkloadMap.put("ids",canChanges.stream().map(i->i.getId()).collect(Collectors.toList()));
				Set<String> fieldKey=xmTaskWorkloadMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
				fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmTaskWorkloadMap.get(i) )).collect(Collectors.toSet());

				if(fieldKey.size()>0){
					List<String> sbillIds= canChanges.stream().filter(i->StringUtils.hasText(i.getSbillId())).map(i->i.getSbillId()).collect(Collectors.toSet()).stream().collect(Collectors.toList());

					xmTaskWorkloadService.editSomeFieldsWithSbillIds(xmTaskWorkloadMap,sbillIds);

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
