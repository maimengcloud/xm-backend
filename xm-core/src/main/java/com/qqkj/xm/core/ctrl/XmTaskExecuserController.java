package com.qqkj.xm.core.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qqkj.audit.log.client.annotation.AuditLog;
import com.qqkj.audit.log.client.annotation.OperType;
import com.qqkj.mdp.core.context.ContextHolder;
import com.qqkj.mdp.qx.HasQx;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import com.qqkj.mdp.mybatis.PageUtils;
import com.qqkj.mdp.safe.common.entity.User;
import com.qqkj.mdp.safe.common.utils.LoginUtils;
import com.qqkj.mdp.core.utils.RequestUtils;
import com.qqkj.mdp.core.entity.Tips;
import com.qqkj.mdp.core.err.BizException;
import com.qqkj.mdp.core.service.SequenceService;
import com.qqkj.xm.core.service.XmProjectGroupService;
import com.qqkj.xm.core.service.XmProjectGroupUserService;
import com.qqkj.xm.core.service.XmTaskExecuserService;
import com.qqkj.xm.core.vo.XmProjectGroupVo;
import com.qqkj.xm.core.entity.XmProjectGroupUser;
import com.qqkj.xm.core.entity.XmTaskExecuser;
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
	XmProjectGroupUserService xmProjectGroupUserService;
	

	@Autowired
	XmProjectGroupService groupService;
	
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
		@ApiResponse(code = 200,response=XmTaskExecuser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
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
			if(!user.getUserid().equals(xmTaskExecuser.getUserid())) {
				 List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(projectId); 
				boolean isHead= groupService.checkUserIsHead(pgroups, xmTaskExecuser.getUserid(), user.getUserid());
				if(!isHead ) {
					tips.setFailureMsg(user.getUsername()+"不是"+xmTaskExecuser.getUsername()+"的组长，无权修改"); 
				}
			} 
			if(tips.isOk()) {

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
			String projectId=xmTaskExecusers.get(0).getProjectId();
			 User user=LoginUtils.getCurrentUserInfo();
			 List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);
			 List<String> noAllowUsers=new ArrayList<>();
			 List<XmTaskExecuser> allowUsers=new ArrayList<>();

			for (XmTaskExecuser xmTaskExecuser : xmTaskExecusers) {
 				if(!user.getUserid().equals(xmTaskExecuser.getUserid())) {
					boolean isHead= groupService.checkUserIsHead(pgroups, xmTaskExecuser.getUserid(), user.getUserid());
					if(!isHead ) {
						//throw new BizException(user.getUsername()+"不是"+xmTaskExecuser.getUsername()+"的组长，无权修改");
						noAllowUsers.add(xmTaskExecuser.getUsername());
						continue;
					}else {
						allowUsers.add(xmTaskExecuser);
					}
				}else {
					allowUsers.add(xmTaskExecuser);
				}
			} 
			if(allowUsers.size()>0) {
				xmTaskExecuserService.batchLeave(allowUsers); 

			}else {
				String usernamestr=StringUtils.arrayToDelimitedString(noAllowUsers.toArray(), "、"); 
				tips.setFailureMsg("你不是【"+usernamestr+"】的组长，不允许变更");
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
			 List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);
			 User user=LoginUtils.getCurrentUserInfo(); 
			boolean isHead= groupService.checkUserIsHead(pgroups, xmTaskExecuser.getUserid(), user.getUserid());
			if(!isHead ) {
				tips.setFailureMsg(user.getUsername()+"不是"+xmTaskExecuser.getUsername()+"的组长，无权修改"); 
			} 
			if(tips.isOk()) {

				boolean exists=groupService.checkUserExistsGroup(projectId, xmTaskExecuser.getUserid());
				 
				if(exists) {
					
					//一个任务只能一个执行人
					xmTaskExecuserService.becomeExecute(xmTaskExecuser); 
				}
				if(!exists) {
					tips.setFailureMsg("变更不成功，原因：候选人不在项目组中，请先加入项目团队中。");
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

	@ApiOperation( value = "提交任务测试",notes="editXmTaskExecuser")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskExecuser.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTaskExecuser_toTest",name = "提交任务到测试",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/toTest",method=RequestMethod.POST)
	public Map<String,Object> toTest(@RequestBody  XmTaskExecuser xmTaskExecuser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			/**
			 * 如果是提交测试，需要检查提交人是本人还是组长，本人或者组长才有权提交任务测试
			 */
			 User user=LoginUtils.getCurrentUserInfo(); 
			if(!user.getUserid().equals(xmTaskExecuser.getUserid())) {
				String projectId=xmTaskExecuser.getProjectId();
				 List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);
				boolean isHead= groupService.checkUserIsHead(pgroups, xmTaskExecuser.getUserid(), user.getUserid());
				if(!isHead ) {
					tips.setFailureMsg(user.getUsername()+"不是"+xmTaskExecuser.getUsername()+"的组长，无权修改"); 
				} 
			}
			
			if(tips.isOk()) { 
				xmTaskExecuserService.toTest(xmTaskExecuser);  
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
	@ApiOperation( value = "测试通过",notes="editXmTaskExecuser")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskExecuser.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTaskExecuser_testSuccess",name = "变更任务为测试通过",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/testSuccess",method=RequestMethod.POST)
	public Map<String,Object> testSuccess(@RequestBody  XmTaskExecuser xmTaskExecuser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{  
			 User user=LoginUtils.getCurrentUserInfo(); 
				String projectId=xmTaskExecuser.getProjectId();
				 List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);
				boolean isHead= groupService.checkUserIsHead(pgroups, xmTaskExecuser.getUserid(), user.getUserid());
				if(!isHead ) {
					if(user.getUserid().equals(xmTaskExecuser.getUserid())) {
						tips.setFailureMsg(user.getUsername()+"不是组长，无权修改"); 
					}else {
						tips.setFailureMsg(user.getUsername()+"不是"+xmTaskExecuser.getUsername()+"的组长，无权修改"); 
					}
					
				} 
			
			if(tips.isOk()) { 
				xmTaskExecuserService.testSuccess(xmTaskExecuser);  
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

	@ApiOperation( value = "测试不通过",notes="editXmTaskExecuser")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskExecuser.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTaskExecuser_testFail",name = "变更任务状态为测试失败",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/testFail",method=RequestMethod.POST)
	public Map<String,Object> testFalse(@RequestBody  XmTaskExecuser xmTaskExecuser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{  
			 User user=LoginUtils.getCurrentUserInfo(); 
				String projectId=xmTaskExecuser.getProjectId();
				 List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);
				boolean isHead= groupService.checkUserIsHead(pgroups, xmTaskExecuser.getUserid(), user.getUserid());
				if(!isHead ) {
					if(user.getUserid().equals(xmTaskExecuser.getUserid())) {
						tips.setFailureMsg(user.getUsername()+"不是组长，无权修改"); 
					}else {
						tips.setFailureMsg(user.getUsername()+"不是"+xmTaskExecuser.getUsername()+"的组长，无权修改"); 
					}
					
				} 
			
			if(tips.isOk()) { 
				xmTaskExecuserService.testFail(xmTaskExecuser);  
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
	 * 必须走流程审批，前端不能提交
	@ApiOperation( value = "执行人结算",notes="editXmTaskExecuser")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskExecuser.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/settle",method=RequestMethod.POST)
	public Map<String,Object> settle(@RequestBody List<XmTaskExecuser> xmTaskExecuser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmTaskExecuserService.batchSettle("",xmTaskExecuser);
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
	 **/
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
			String projectId=xmTaskExecuser.getProjectId();
			 User user=LoginUtils.getCurrentUserInfo(); 
 			if(!user.getUserid().equals(xmTaskExecuser.getUserid())) {
 				 List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);

				boolean isHead= groupService.checkUserIsHead(pgroups, xmTaskExecuser.getUserid(), user.getUserid());
				if(!isHead ) {
					tips.setFailureMsg(user.getUsername()+"不是"+xmTaskExecuser.getUsername()+"的组长，无权修改"); 
				}
			} 
			if(tips.isOk()) {
				XmTaskExecuser xmTaskExecuserDb = xmTaskExecuserService.selectOneObject(new XmTaskExecuser(xmTaskExecuser.getId()));
				if(xmTaskExecuserDb!=null && !"0".equals(xmTaskExecuserDb.getStatus())) {
					xmTaskExecuserService.quotePrice(xmTaskExecuser);
					m.put("data",xmTaskExecuser);
				}else {
					tips.setFailureMsg("只有候选状态时可以修改报价信息");
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
			String projectId=xmTaskExecuser.getProjectId();
			 User user=LoginUtils.getCurrentUserInfo(); 
 			if(!user.getUserid().equals(xmTaskExecuser.getUserid())) {
 				 List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);

				boolean isHead= groupService.checkUserIsHead(pgroups, xmTaskExecuser.getUserid(), user.getUserid());
				if(!isHead ) {
					tips.setFailureMsg(user.getUsername()+"不是"+xmTaskExecuser.getUsername()+"的组长，无权修改"); 
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
			String projectId=xmTaskExecuser.getProjectId();
			 User user=LoginUtils.getCurrentUserInfo(); 
			if(!user.getUserid().equals(xmTaskExecuser.getUserid())) {
				 List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(projectId); 
				boolean isHead= groupService.checkUserIsHead(pgroups, xmTaskExecuser.getUserid(), user.getUserid());
				if(!isHead ) {
					tips.setFailureMsg(user.getUsername()+"不是"+xmTaskExecuser.getUsername()+"的组长，无权删除"); 
				}
			} 
			if(tips.isOk()) { 
				XmTaskExecuser xmTaskExecuserDb = xmTaskExecuserService.selectOneObject(new XmTaskExecuser(xmTaskExecuser.getId()));
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
	 
	/**
	 * 敏感数据不允许随意修改
	@ApiOperation( value = "根据主键修改一条xm_task_execuser信息",notes="editXmTaskExecuser")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskExecuser.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTaskExecuser(@RequestBody XmTaskExecuser xmTaskExecuser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmTaskExecuserService.updateSomeFieldByPk(xmTaskExecuser);
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
	
	**/
	
	/**
	@ApiOperation( value = "根据主键列表批量删除xm_task_execuser信息",notes="batchDelXmTaskExecuser,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmTaskExecuser(@RequestBody List<XmTaskExecuser> xmTaskExecusers) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmTaskExecusers.size()+"条数据"); 
		try{ 
			xmTaskExecuserService.batchDelete(xmTaskExecusers);
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
	*/


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
	@AuditLog(firstMenu="办公平台",secondMenu="项目执行人管理",func="processApprova",funcDesc="任务分配/结算审核",operType=OperType.UPDATE)
	@RequestMapping(value="/processApprova",method=RequestMethod.POST)
	public Map<String,Object> processApprova( @RequestBody Map<String,Object> flowVars){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		  
		try{ 
			
			this.xmTaskExecuserService.processApprova(flowVars);
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
