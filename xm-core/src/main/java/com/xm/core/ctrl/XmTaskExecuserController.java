package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.NumberUtil;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.meta.client.service.ItemService;
import com.mdp.msg.client.PushNotifyMsgService;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmProject;
import com.xm.core.entity.XmTask;
import com.xm.core.entity.XmTaskExecuser;
import com.xm.core.service.*;
import com.xm.core.service.client.MkClient;
import com.xm.core.service.client.SysClient;
import com.xm.core.vo.XmGroupVo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
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
	private XmProjectService xmProjectService;
	 
	@Autowired
	XmGroupUserService xmGroupUserService;


	@Autowired
	PushNotifyMsgService notifyMsgService;

	@Autowired
	ItemService itemService;

	@Autowired
	MkClient mkClient;

	@Autowired
	SysClient sysClient;
	

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
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmTaskExecuser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTaskExecuser( @ApiIgnore @RequestParam Map<String,Object> xmTaskExecuser){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmTaskExecuser, "ids");
		PageUtils.startPage(xmTaskExecuser);
		User user=LoginUtils.getCurrentUserInfo();
		String projectId= (String) xmTaskExecuser.get("projectId");
		if(StringUtils.hasText(projectId)){
			if(!groupService.checkUserExistsGroup(projectId,user.getUserid())){
				xmTaskExecuser.put("linkBranchId",user.getBranchId());
			}
		}else{
			xmTaskExecuser.put("linkBranchId",user.getBranchId());
		}


		List<Map<String,Object>>	xmTaskExecuserList = xmTaskExecuserService.selectListMapByWhere(xmTaskExecuser);	//列出XmTaskExecuser列表
		PageUtils.responePage(m, xmTaskExecuserList);
		m.put("data",xmTaskExecuserList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}


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
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
			@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false)
	})
	@ApiResponses({
			@ApiResponse(code = 200,response= XmTaskExecuser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listWithTask",method=RequestMethod.GET)
	public Map<String,Object> listXmTaskExecuserWithTask( @ApiIgnore @RequestParam Map<String,Object> xmTaskExecuser){
		Map<String,Object> m = new HashMap<>();
		RequestUtils.transformArray(xmTaskExecuser, "ids");
		PageUtils.startPage(xmTaskExecuser);
		User user=LoginUtils.getCurrentUserInfo();
		String projectId= (String) xmTaskExecuser.get("projectId");
		if(StringUtils.hasText(projectId)){
			if(!groupService.checkUserExistsGroup(projectId,user.getUserid())){
				xmTaskExecuser.put("linkBranchId",user.getBranchId());
			}
		}else{
			xmTaskExecuser.put("linkBranchId",user.getBranchId());
		}
		List<Map<String,Object>>	xmTaskExecuserList = xmTaskExecuserService.selectListMapByWhereWithTask(xmTaskExecuser);	//列出XmTaskExecuser列表
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
	@HasQx(value = "xm_core_xmTaskExecuser_add",name = "新增任务执行者",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTaskExecuser(@RequestBody XmTaskExecuser xmTaskExecuser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{

			 User user=LoginUtils.getCurrentUserInfo();
			XmTask xmTask=xmTaskService.selectOneObject(new XmTask(xmTaskExecuser.getTaskId()));
			if(xmTask==null){
				tips.setFailureMsg("任务已不存在");
				m.put("tips", tips);
				return m;
			}
			String projectId=xmTask.getProjectId();
			XmProject xmProjectDb=this.xmProjectService.getProjectFromCache(projectId);
			xmTaskExecuser.setProjectId(projectId);
			xmTaskExecuser.setBranchId(xmProjectDb.getBranchId());
			if(!"0".equals(xmTask.getTaskState()) && !"1".equals(xmTask.getTaskState()) ){
				tips.setFailureMsg("该任务已经处于完工、结算状态，不允许再修改");
				m.put("tips", tips);
				return m;
			}
			boolean isBranch=false;
			if(!xmTaskExecuser.getUserid().equals(user.getUserid())){
				User userDb=sysClient.getUserByUserid(xmTaskExecuser.getUserid());
				if(userDb==null){
					return ResponseHelper.failed("userid-0","候选人不存在");
				}
				isBranch=!"0".equals(userDb.getMemType());
 				xmTaskExecuser.setExecUserBranchId(userDb.getBranchId());
			}else{
				isBranch=!"0".equals(user.getMemType());
				xmTaskExecuser.setExecUserBranchId(user.getBranchId());
			}
			boolean isPm=groupService.checkUserIsProjectAdm(xmTask.getProjectId(),user.getUserid());
			boolean isTeamHeader=false;
			List<XmGroupVo> myGgroups=groupService.getProjectGroupVoList(projectId);
			if(!isPm){
 				isTeamHeader= groupService.checkUserIsOtherUserTeamHeadOrAss(myGgroups,user.getUserid(),xmTask.getCreateUserid());
			}
			if(!user.getUserid().equals(xmTaskExecuser.getUserid()) ){//只有上级可以拉人
				if(!isPm && !isTeamHeader){
					return ResponseHelper.failed("no-qx","您无权操作！只有任务负责人、组长、项目管理者可以给任务分配候选人。");
				}
			}else{
				if(!"1".equals(xmTask.getCrowd())){//如果是众包任务，自己可以直接加入，如果不是众包任务，必须任务负责人、组长、经理等拉人作为执行人
					if(!isPm && !isTeamHeader){
						return ResponseHelper.failed("no-qx","您无权操作！只有任务负责人、组长、项目管理者可以给任务分配执行人。");
					}
				}
			}
			if("1".equals(xmTask.getCrowd())){
				Map<String,Object> result=null;
				if(!isBranch){
					result=mkClient.checkAndGetMemberInterests(xmTaskExecuser.getUserid(),xmTask.getBudgetAt(),xmTask.getBudgetWorkload(),1);
				}else{
					result= sysClient.checkAndGetBranchInterests(xmTaskExecuser.getExecUserBranchId(),xmTask.getBudgetAt(),xmTask.getBudgetWorkload(),1);
				}
				Tips tips2= (Tips) result.get("tips");
				if(!tips2.isOk()){
					return ResponseHelper.failed(tips2);
				}
				Map<String,Object> data= (Map<String, Object>) result.get("data");
				if(data!=null && data.containsKey("sfeeRate")){
					xmTaskExecuser.setSfeeRate(NumberUtil.getInteger(data.get("sfeeRate"),0));
					if(xmTaskExecuser.getQuoteAmount()!=null){
						xmTaskExecuser.setSfee(xmTaskExecuser.getQuoteAmount().multiply(BigDecimal.valueOf(xmTaskExecuser.getSfeeRate()/100)));
					}
				}
				xmTaskExecuser.setStatus("0");   //如果是众包，智能添加为候选人
			}else {
				//如果不是众包，需要判断是否已加入项目组组织架构中，如未加入，需要提示其先加入
				boolean exists=groupService.checkUserExistsGroup(myGgroups, xmTaskExecuser.getUserid());
				if(!exists) {
					tips.setFailureMsg(xmTaskExecuser.getUsername()+"不在项目组织架构中，请先将其拉入项目组织架构中");
					return ResponseHelper.failed("user-not-in-project",xmTaskExecuser.getUsername()+"不在项目组织架构中，请先将其拉入项目组织架构中");
				}
				//检查是否已经存在执行人
				XmTaskExecuser query=new XmTaskExecuser();
				query.setTaskId(xmTask.getId());
				List<XmTaskExecuser> xmTaskExecusersDb=this.xmTaskExecuserService.selectListByWhere(query);
				if(xmTaskExecusersDb !=null && xmTaskExecusersDb.size()>0) {
					for (XmTaskExecuser exe : xmTaskExecusersDb) {
						if(!"0".equals(exe.getStatus()) && !"7".equals(exe.getStatus())) {
							throw new BizException(exe.getUsername()+"是当前执行人，不允许再添加其它执行人。如需更换，请在【执行人管理】变更【"+exe.getUsername()+"】的执行人身份");
						}
					}
				}
				xmTaskExecuser.setStatus("1");//如果不是众包，则添加为执行人

			}
			xmTaskExecuserService.addExecuser(xmTaskExecuser);
			if(isBranch){
				sysClient.pushBidsAfterBidSuccess(xmTaskExecuser.getExecUserBranchId(),xmTask.getBudgetAt(),xmTask.getBudgetWorkload(),1);
			}else {
				mkClient.pushBidsAfterBidSuccess(xmTaskExecuser.getUserid(),xmTask.getBudgetAt(),xmTask.getBudgetWorkload(),1);
			}
			m.put("data",xmTaskExecuser);
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
	@HasQx(value = "xm_core_xmTaskExecuser_leave",name = "执行人离开任务",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
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
 			boolean isPm=groupService.checkUserIsProjectAdm(xmTask.getProjectId(),user.getUserid());

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
						Tips tips2=groupService.checkIsAdmOrTeamHeadOrAss(user,xmTaskExecuser.getUserid(),xmTask.getProjectId());
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
			if(allowUsers.size()>0){
				String allowUserNamesStr=StringUtils.arrayToDelimitedString(allowUserNames.toArray(), "、");
				msgs.add("成功将【"+allowUserNamesStr+"】请离任务;");
			}
			if(noAllowUsers.size()>0){
				String allowUserNamesStr=StringUtils.arrayToDelimitedString(noAllowUsers.toArray(), "、");
				msgs.add("以下人员您无权操作，【"+allowUserNamesStr+"】;");
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
	@HasQx(value = "xm_core_xmTaskExecuser_execute",name = "修改任务执行人基础信息",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
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
 			boolean isHead= groupService.checkUserIsOtherUserTeamHeadOrAss(pgroups, user.getUserid(), xmTaskExecuser.getUserid());
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
					xmTaskExecuserService.becomeExecute(xmTask,xmTaskExecuser);
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
	@HasQx(value = "xm_core_xmTaskExecuser_quotePrice",name = "项目中的任务报价",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
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
			if("2".equals(xmTask.getEstate())||"3".equals(xmTask.getEstate())){
				return ResponseHelper.failed("estate-not-0-1-3","当前任务已缴纳保证金，无法再变更报价信息。");
			}
			User user=LoginUtils.getCurrentUserInfo();
			boolean isTaskCreater=user.getUserid().equals(xmTask.getCreateUserid());
			String projectId=xmTaskExecuser.getProjectId();
 			if(!user.getUserid().equals(xmTaskExecuser.getUserid())) {
 				 List<XmGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);
				boolean isHead= groupService.checkUserIsOtherUserTeamHeadOrAss(pgroups, user.getUserid(), xmTaskExecuser.getUserid());
				if( !isHead && !isTaskCreater ) {
					tips.setFailureMsg("无权操作！自己、任务责任人、组长可以修改任务的报价信息");
				}
			} 
			if(tips.isOk()) {
				XmTaskExecuser xmTaskExecuserDb = xmTaskExecuserService.selectOneObject(new XmTaskExecuser(xmTaskExecuser.getTaskId(),xmTaskExecuser.getUserid()));
				if("0".equals(xmTaskExecuserDb.getStatus())) {
					xmTaskExecuserService.quotePrice(xmTaskExecuser);
					notifyMsgService.pushMsg(user, xmTask.getCreateUserid(), xmTask.getCreateUsername(), "2", xmTask.getProjectId(), xmTask.getId(), user.getUsername()+"修改任务【" + xmTask.getId() + "-" + xmTask.getName() + "】的报价信息，请尽快选标！");

					m.put("data",xmTaskExecuser);
				}else {
					tips.setFailureMsg("只有修改处于候选状态的投标人的报价信息");
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
	@HasQx(value = "xm_core_xmTaskExecuser_candidate",name = "变更成为任务候选人",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
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

				boolean isHead= groupService.checkUserIsOtherUserTeamHeadOrAss(pgroups, user.getUserid(), xmTaskExecuser.getUserid());
				if( !isHead && !isTaskCreater ) {
					tips.setFailureMsg("无权操作！任务责任人、组长可以邀请用户成为任务候选人，普通用户可以自己申请成为候选人");
				}
			} 
			if(tips.isOk()) {
				xmTaskExecuserService.becomeCandidate(xmTaskExecuser);
				notifyMsgService.pushMsg(user, xmTask.getCreateUserid(), xmTask.getCreateUsername(), "2", xmTask.getProjectId(), xmTask.getId(), user.getUsername()+"投标任务【" + xmTask.getId() + "-" + xmTask.getName() + "】，请尽快选标！");

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
	@HasQx(value = "xm_core_xmTaskExecuser_del",name = "删除项目中任务的执行人",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
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
				boolean isHead= groupService.checkUserIsOtherUserTeamHeadOrAss(pgroups, user.getUserid(), xmTaskExecuser.getUserid());
				if( !isHead && !isTaskCreater ) {
					tips.setFailureMsg("无权操作！只有自己、任务责任人、组长可以删除任务执行人.");
				}
			} 
			if(tips.isOk()) { 
				XmTaskExecuser xmTaskExecuserDb = xmTaskExecuserService.selectOneObject(new XmTaskExecuser(xmTaskExecuser.getTaskId(),xmTaskExecuser.getUserid()));
				if(xmTaskExecuserDb !=null ) {
					if( "0".equals( xmTaskExecuserDb.getStatus() )  || "7".equals( xmTaskExecuserDb.getStatus() ) || "8".equals( xmTaskExecuserDb.getStatus() ) ) {
						xmTaskExecuserService.delete(xmTaskExecuser);
						notifyMsgService.pushMsg(user, xmTask.getCreateUserid(), xmTask.getCreateUsername(), "2", xmTask.getProjectId(), xmTask.getId(), xmTaskExecuserDb.getUsername()+"离开任务【" + xmTask.getId() + "-" + xmTask.getName() + "】！");
						notifyMsgService.pushMsg(user, xmTaskExecuserDb.getUserid(), xmTaskExecuserDb.getUsername(), "2", xmTask.getProjectId(), xmTask.getId(), "您已离开任务【" + xmTask.getId() + "-" + xmTask.getName() + "】！");

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
