package com.xm.core.ctrl;

import com.mdp.audit.log.client.annotation.AuditLog;
import com.mdp.audit.log.client.annotation.OperType;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.meta.client.service.ItemService;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmTask;
import com.xm.core.entity.XmTaskExecuser;
import com.xm.core.service.XmGroupService;
import com.xm.core.service.XmGroupUserService;
import com.xm.core.service.XmTaskExecuserService;
import com.xm.core.service.XmTaskService;
import com.xm.core.vo.XmGroupVo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.mdp.core.utils.BaseUtils.map;

/**
 * url编制采用rest风格,如对XM.xm_task_execuser xm_task_execuser的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmTaskExecuser/add <br>
 *  查询: xm/xmTaskExecuser/list<br>
 *  模糊查询: xm/xmTaskExecuser/listKey<br>
 *  修改: xm/xmTaskExecuser/edit <br>
 *  删除: xm/xmTaskExecuser/del<br>
 *  批量删除: xm/xmTaskExecuser/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmTaskExecuser 表 XM.xm_task_execuser 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmTaskExecuserController")
@RequestMapping(value="/**/xm/core/xmTaskExecuser")
@Api(tags={"xm_task_execuser操作接口"})
public class XmTaskExecuserController {
	
	static Log logger=LogFactory.getLog(XmTaskExecuserController.class);
	
	@Autowired
	private XmTaskExecuserService xmTaskExecuserService;

	@Autowired
	private XmTaskService xmTaskService;
	 
	@Autowired
	XmGroupUserService xmProjectGroupUserService;

	@Autowired
	ItemService itemService;
	

	@Autowired
    XmGroupService groupService;
	
	@ApiOperation( value = "查询xm_task_execuser信息列表",notes="listXmTaskExecuser,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="编号,主键",required=false),
		@ApiImplicitParam(name="createTime",value="创建时间",required=false),
		@ApiImplicitParam(name="taskId",value="任务id",required=false),
		@ApiImplicitParam(name="userid",value="执行人id",required=false),
		@ApiImplicitParam(name="startTime",value="加入时间",required=false),
		@ApiImplicitParam(name="endTime",value="离开时间",required=false),
		@ApiImplicitParam(name="status",value="执行人状态0候选排队中1执行任务中1离开任务",required=false),
		@ApiImplicitParam(name="remarks",value="备注",required=false),
		@ApiImplicitParam(name="settleAmount",value="结算金额",required=false),
		@ApiImplicitParam(name="settleHour",value="结算工时",required=false),
		@ApiImplicitParam(name="settleStatus",value="结算状态0未结算1已结算2无需结算",required=false),
		@ApiImplicitParam(name="settleTime",value="结算时间",required=false),
		@ApiImplicitParam(name="createUserid",value="创建人",required=false),
		@ApiImplicitParam(name="createUsername",value="创建人姓名",required=false),
		@ApiImplicitParam(name="username",value="执行人姓名",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmTaskExecuser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTaskExecuser( @RequestParam Map<String,Object> xmTaskExecuser){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmTaskExecuser, "ids");
		PageUtils.startPage(xmTaskExecuser);
		List<Map<String,Object>>	xmTaskExecuserList = xmTaskExecuserService.selectListMapByWhere(xmTaskExecuser);	//列出XmTaskExecuser列表
		PageUtils.responePage(m, xmTaskExecuserList);
		m.put("data",xmTaskExecuserList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	@ApiOperation( value = "新增一条xm_task_execuser信息",notes="addXmTaskExecuser,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskExecuser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTaskExecuser_add",name = "新增任务执行者",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTaskExecuser(@RequestBody XmTaskExecuser xmTaskExecuser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			String projectId=xmTaskExecuser.getProjectId();
			 User user=LoginUtils.getCurrentUserInfo();
			XmTask xmTask=xmTaskService.selectOneObject(new XmTask(xmTaskExecuser.getTaskId()));
			if(xmTask==null){
				tips.setFailureMsg("任务已不存在");
				m.put("tips", tips);
				return m;
			}

			if(!"0".equals(xmTask.getTaskState()) && !"1".equals(xmTask.getTaskState()) ){
				tips.setFailureMsg("该任务已经处于完工、结算状态，不允许再修改");
				m.put("tips", tips);
				return m;
			}
			 if(user.getUserid().equals(xmTaskExecuser.getUserid())){//自己作为候选人
				 xmTaskExecuserService.addExecuser(xmTaskExecuser);
				 m.put("data",xmTaskExecuser);
			 }else {
				 boolean isPm=groupService.checkUserIsProjectAdm(xmTask.getProjectId(),user.getUserid());
				 if(!isPm){
					 List<XmGroupVo> myGgroups=groupService.getProjectGroupVoList(projectId);
					 boolean isTeamHeader= groupService.checkUserIsOtherUserTeamHeadOrAss(myGgroups,xmTaskExecuser.getCreateUserid(),user.getUserid());
					 if(!isTeamHeader){
					 	return ResponseHelper.failed("no-qx","您无权操作！只有任务负责人、组长、项目管理者可以给任务分配候选人。");
					 }
				 }
					 xmTaskExecuserService.addExecuser(xmTaskExecuser);
					 m.put("data",xmTaskExecuser);
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
	
	@ApiOperation( value = "执行人离开任务",notes="editXmTaskExecuser")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskExecuser.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTaskExecuser_leave",name = "执行人离开任务",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/leave",method=RequestMethod.POST)
	public Map<String,Object> leave(@RequestBody List<XmTaskExecuser> xmTaskExecusers) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			if(xmTaskExecusers==null || xmTaskExecusers.size()==0){
				tips.setFailureMsg("执行人列表不能为空");
				m.put("tips", tips);
				return m;
			}
			User user=LoginUtils.getCurrentUserInfo();
			List<XmTaskExecuser> xmTaskExecuserListDb=this.xmTaskExecuserService.selectListByIds(xmTaskExecusers.stream().map(i->map("taskId",i.getTaskId(),"userid",i.getUserid())).collect(Collectors.toList()));
			if(xmTaskExecuserListDb==null || xmTaskExecuserListDb.size()==0){
				return ResponseHelper.failed("data-0","执行人/候选人都已不存在");
			}
			String taskId=xmTaskExecuserListDb.get(0).getTaskId();
			XmTask xmTask= xmTaskService.selectOneObject(new XmTask(xmTaskExecuserListDb.get(0).getTaskId()));
			if(xmTask==null ){
				tips.setFailureMsg("任务已不存在");
				m.put("tips", tips);
				return m;
			}
			boolean isTaskCreater=user.getUserid().equals(xmTask.getCreateUserid());
			boolean isExe=user.getUserid().equals(xmTask.getExecutorUserid());
			List<String> noAllowUsers=new ArrayList<>();
			List<XmTaskExecuser> allowUsers=new ArrayList<>();
			List<String> allowUserNames=new ArrayList<>();
 			boolean isPm=groupService.checkUserIsPmOrAssByPtype(user.getUserid(),xmTask.getPtype(),xmTask.getProjectId(),xmTask.getProductId());

			for (XmTaskExecuser xmTaskExecuser : xmTaskExecuserListDb) {
				if(!taskId.equals(xmTaskExecuser.getTaskId())){
					tips.setFailureMsg("批量操作只允许在同一个任务进行");
					break;
				}
 				if(!user.getUserid().equals(xmTaskExecuser.getUserid())) {//只有组长、任务责任人可以请别人请离开任务
 					if(isTaskCreater||isExe||isPm){
						allowUsers.add(xmTaskExecuser);
						allowUserNames.add(xmTaskExecuser.getUsername());
					}else{
						Tips tips2=groupService.checkIsAdmOrTeamHeadOrAssByPtype(user,xmTaskExecuser.getUserid(),xmTask.getPtype(),xmTask.getProductId(),xmTask.getProjectId());
						if(tips2.isOk()==false){
							noAllowUsers.add(xmTaskExecuser.getUsername());
							continue;
						}
 					}
				}else {//自己离开任务，可以的
					allowUsers.add(xmTaskExecuser);
					allowUserNames.add(xmTaskExecuser.getUsername());
				}
			} 
			if(tips.isOk() && allowUsers.size()>0) {
				xmTaskExecuserService.batchLeave(allowUsers);

			}
			List<String> msgs=new ArrayList<>();
			if(noAllowUsers.size()>0){
				String allowUserNamesStr=StringUtils.arrayToDelimitedString(allowUserNames.toArray(), "、");
				msgs.add("成功将【"+allowUserNamesStr+"】请离任务;");
			}
			if(noAllowUsers.size()>0){
				String allowUserNamesStr=StringUtils.arrayToDelimitedString(noAllowUsers.toArray(), "、");
				msgs.add("以下人员您无权操作，【"+allowUserNamesStr+"】;");
			}
			if(allowUserNames.size()>0){
				tips.setOkMsg(msgs.stream().collect(Collectors.joining(" ")));
			}

			if(allowUserNames.size()>0){
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
	@ApiOperation( value = "候选人变更为执行人",notes="editXmTaskExecuser")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskExecuser.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTaskExecuser_execute",name = "修改任务执行人基础信息",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/execute",method=RequestMethod.POST)
	public Map<String,Object> execute(@RequestBody  XmTaskExecuser xmTaskExecuser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			/**
			 * 如果是候选人变更为执行人，需要检查该候选人是否已加入项目中的某个组
			 */
			String projectId=xmTaskExecuser.getProjectId();
			String taskId=xmTaskExecuser.getTaskId();
			XmTask xmTask= xmTaskService.selectOneObject(new XmTask(taskId));
			if(xmTask==null ){
				tips.setFailureMsg("任务已不存在");
				m.put("tips", tips);
				return m;
			}

			if(!"0".equals(xmTask.getTaskState()) && !"1".equals(xmTask.getTaskState()) ){
				tips.setFailureMsg("该任务已经处于完工、结算状态，不允许再修改");
				m.put("tips", tips);
				return m;
			}
			User user=LoginUtils.getCurrentUserInfo();
			boolean isTaskCreater=user.getUserid().equals(xmTask.getCreateUserid());
			 List<XmGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);
 			boolean isHead= groupService.checkUserIsOtherUserTeamHeadOrAss(pgroups, xmTaskExecuser.getUserid(), user.getUserid());
			if( isHead || isTaskCreater ) {
				//放行，组长和任务责任人可以将候选人变更为执行人
			} else{
				if(user.getUserid().equals(xmTaskExecuser.getUserid())){
					tips.setFailureMsg("您无权将自己变更为执行人");
				}else {
					tips.setFailureMsg("权限不足！任务责任人、组长可以变更候选人为执行人");
				}
			}
			if(tips.isOk()) {

				boolean exists=groupService.checkUserExistsGroup(pgroups, xmTaskExecuser.getUserid());
				 
				if(exists) {
					
					//一个任务只能一个执行人
					xmTaskExecuserService.becomeExecute(xmTaskExecuser); 
				}
				if(!exists) {
					tips.setFailureMsg("变更不成功，原因：候选人不在项目组中，请先将候选人加入项目团队中。");
				}else {
					tips.setOkMsg("变更成功");
				}
				m.put("data",xmTaskExecuser);

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

	@ApiOperation( value = "候选人报价",notes="quotePrice")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskExecuser.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTaskExecuser_quotePrice",name = "项目中的任务报价",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/quotePrice",method=RequestMethod.POST)
	public Map<String,Object> quotePrice(@RequestBody XmTaskExecuser xmTaskExecuser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			String taskId=xmTaskExecuser.getTaskId();
			XmTask xmTask= xmTaskService.selectOneObject(new XmTask(taskId));
			if(xmTask==null ){
				tips.setFailureMsg("任务已不存在");
				m.put("tips", tips);
				return m;
			}
			if(!"0".equals(xmTask.getTaskState()) && !"1".equals(xmTask.getTaskState()) ){
				tips.setFailureMsg("该任务已经处于完工、结算计划，不允许再修改报价");
				m.put("tips", tips);
				return m;
			}
			if(!"0".equals(xmTask.getTaskState())){
				return ResponseHelper.failed("taskState-not-0","当前任务状态不是候选、待领取状态，不能修改报价信息");
			}
			User user=LoginUtils.getCurrentUserInfo();
			boolean isTaskCreater=user.getUserid().equals(xmTask.getCreateUserid());
			String projectId=xmTaskExecuser.getProjectId();
 			if(!user.getUserid().equals(xmTaskExecuser.getUserid())) {
 				 List<XmGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);
				boolean isHead= groupService.checkUserIsOtherUserTeamHeadOrAss(pgroups, xmTaskExecuser.getUserid(), user.getUserid());
				if( !isHead && !isTaskCreater ) {
					tips.setFailureMsg("无权操作！自己、任务责任人、组长可以修改任务的报价信息");
				}
			} 
			if(tips.isOk()) {
				XmTaskExecuser xmTaskExecuserDb = xmTaskExecuserService.selectOneObject(new XmTaskExecuser(xmTaskExecuser.getTaskId(),xmTaskExecuser.getUserid()));
				if("0".equals(xmTaskExecuserDb.getStatus())) {
					xmTaskExecuserService.quotePrice(xmTaskExecuser);
					m.put("data",xmTaskExecuser);
				}else {
					tips.setFailureMsg("只有任务处于候选状态时可以修改报价信息");
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
	@ApiOperation( value = "变更为候选人",notes="quotePrice")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskExecuser.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTaskExecuser_candidate",name = "变更成为任务候选人",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/candidate",method=RequestMethod.POST)
	public Map<String,Object> becomeCandidate(@RequestBody XmTaskExecuser xmTaskExecuser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			String taskId=xmTaskExecuser.getTaskId();
			XmTask xmTask= xmTaskService.selectOneObject(new XmTask(taskId));
			if(xmTask==null ){
				tips.setFailureMsg("任务已不存在");
				m.put("tips", tips);
				return m;
			}
			if(!"0".equals(xmTask.getTaskState()) && !"1".equals(xmTask.getTaskState()) ){
				tips.setFailureMsg("该任务已经不需要候选人");
				m.put("tips", tips);
				return m;
			}
			User user=LoginUtils.getCurrentUserInfo();
			boolean isTaskCreater=user.getUserid().equals(xmTask.getCreateUserid());
			String projectId=xmTaskExecuser.getProjectId();
 			if(!user.getUserid().equals(xmTaskExecuser.getUserid())) {
 				 List<XmGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);

				boolean isHead= groupService.checkUserIsOtherUserTeamHeadOrAss(pgroups, xmTaskExecuser.getUserid(), user.getUserid());
				if( !isHead && !isTaskCreater ) {
					tips.setFailureMsg("无权操作！任务责任人、组长可以邀请用户成为任务候选人，普通用户可以自己申请成为候选人");
				}
			} 
			if(tips.isOk()) {
				xmTaskExecuserService.becomeCandidate(xmTaskExecuser);
				m.put("data",xmTaskExecuser);

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
	@ApiOperation( value = "删除一条xm_task_execuser信息",notes="delXmTaskExecuser,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@HasQx(value = "xm_core_xmTaskExecuser_del",name = "删除项目中任务的执行人",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmTaskExecuser(@RequestBody XmTaskExecuser xmTaskExecuser){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			String taskId=xmTaskExecuser.getTaskId();
			XmTask xmTask= xmTaskService.selectOneObject(new XmTask(taskId));
			if(xmTask==null ){
				tips.setFailureMsg("任务已不存在");
				m.put("tips", tips);
				return m;
			}
			User user=LoginUtils.getCurrentUserInfo();
			boolean isTaskCreater=user.getUserid().equals(xmTask.getCreateUserid());
			String projectId=xmTaskExecuser.getProjectId();
			if(!user.getUserid().equals(xmTaskExecuser.getUserid())) {
				 List<XmGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);
				boolean isHead= groupService.checkUserIsOtherUserTeamHeadOrAss(pgroups, xmTaskExecuser.getUserid(), user.getUserid());
				if( !isHead && !isTaskCreater ) {
					tips.setFailureMsg("无权操作！只有自己、任务责任人、组长可以删除任务执行人.");
				}
			} 
			if(tips.isOk()) { 
				XmTaskExecuser xmTaskExecuserDb = xmTaskExecuserService.selectOneObject(new XmTaskExecuser(xmTaskExecuser.getTaskId(),xmTaskExecuser.getUserid()));
				if(xmTaskExecuserDb !=null ) {
					if( "0".equals( xmTaskExecuserDb.getStatus() )  || "7".equals( xmTaskExecuserDb.getStatus() ) || "8".equals( xmTaskExecuserDb.getStatus() ) ) {
						xmTaskExecuserService.delete(xmTaskExecuser); 
						m.put("data",xmTaskExecuser);
					}else {
						tips.setFailureMsg("只有候选、放弃任务、黑名单中的数据可以被删除");
					}
				}
				else {
					tips.setFailureMsg("没有查到数据");
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
}
