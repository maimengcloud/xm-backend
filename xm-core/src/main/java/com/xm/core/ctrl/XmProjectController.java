package com.xm.core.ctrl;

import com.alibaba.fastjson.JSON;
import com.mdp.audit.log.client.annotation.AuditLog;
import com.mdp.audit.log.client.annotation.OperType;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmProductProjectLink;
import com.xm.core.entity.XmProject;
import com.xm.core.service.*;
import com.xm.core.vo.XmGroupVo;
import com.xm.core.vo.XmProjectCopyVo;
import com.xm.core.vo.XmProjectVo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url编制采用rest风格,如对XM.xm_project xm_project的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProject/add <br>
 *  查询: xm/xmProject/list<br>
 *  模糊查询: xm/xmProject/listKey<br>
 *  修改: xm/xmProject/edit <br>
 *  删除: xm/xmProject/del<br>
 *  批量删除: xm/xmProject/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProject 表 XM.xm_project 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectController")
@RequestMapping(value="/**/xm/core/xmProject")
@Api(tags={"xm_project操作接口"})
public class XmProjectController {
	
	static Log logger=LogFactory.getLog(XmProjectController.class);
	
	@Autowired
	private XmProjectService xmProjectService;
	@Autowired
	private XmGroupService groupService;


	@Autowired
	private XmRecordService xmRecordService;

	@Autowired
	private XmPhaseService xmProjectPhaseService;

	@Value("${mdp.platform-branch-id:platform-branch-001}")
	String platformBranchId="platform-branch-001";

	@Autowired
	XmProjectStateService xmProjectStateService;

	@Autowired
	private XmTaskService xmTaskService;

	@ApiOperation( value = "查询xm_project信息列表",notes="listXmProject,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="项目编号,主键",required=false),
		@ApiImplicitParam(name="code",value="项目代号",required=false),
		@ApiImplicitParam(name="name",value="项目名称",required=false),
		@ApiImplicitParam(name="xmType",value="项目类型",required=false),
		@ApiImplicitParam(name="startTime",value="项目开始时间",required=false),
		@ApiImplicitParam(name="endTime",value="项目结束时间",required=false),
		@ApiImplicitParam(name="urgent",value="紧急程度",required=false),
		@ApiImplicitParam(name="priority",value="优先程度",required=false),
		@ApiImplicitParam(name="description",value="项目描述",required=false),
		@ApiImplicitParam(name="createUserid",value="项目创建人编号",required=false),
		@ApiImplicitParam(name="createUsername",value="项目创建人",required=false),
		@ApiImplicitParam(name="createTime",value="创建时间",required=false),
		@ApiImplicitParam(name="assess",value="项目考核",required=false),
		@ApiImplicitParam(name="assessRemarks",value="考核备注",required=false),
		@ApiImplicitParam(name="status",value="项目状态，0立项中，1审批中，2已退回，3进行中，4已结束",required=false),
		@ApiImplicitParam(name="branchId",value="机构编号",required=false),
		@ApiImplicitParam(name="totalBudgetCost",value="总预算",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProject.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProject( @ApiIgnore @RequestParam Map<String,Object> xmProject){
		Map<String,Object> m = new HashMap<>();
		RequestUtils.transformArray(xmProject, "ids"); 
		RequestUtils.transformArray(xmProject, "pgTypeIds");
		PageUtils.startPage(xmProject);
		String id= (String) xmProject.get("id");
		Object ids=  xmProject.get("ids");
		String productId= (String) xmProject.get("productId");
		String myFocus= (String) xmProject.get("myFocus");
		String myExecuserStatus= (String) xmProject.get("myExecuserStatus");
		Object pgTypeIds=   xmProject.get("pgTypeIds");
		String createUserid= (String) xmProject.get("createUserid");
		User user = LoginUtils.getCurrentUserInfo();
		xmProject.put("userid",user.getUserid());
		if( !(StringUtils.hasText(id) || StringUtils.hasText(myFocus)|| StringUtils.hasText(productId)||ids!=null
				|| StringUtils.hasText(myExecuserStatus)||pgTypeIds!=null|| StringUtils.hasText(createUserid)) ){
			if(!LoginUtils.isBranchAdmin()){
				xmProject.put("compete",user.getUserid());
			}
		}
		if(!StringUtils.hasText((String) xmProject.get("isTpl"))){
			xmProject.put("isTpl","0");
		}else{
			if("1".equals(xmProject.get("isTpl"))){
				xmProject.remove("branchId");
				xmProject.put("linkBranchId",user.getBranchId());
				xmProject.put("platformBranchId",platformBranchId);
			}
		}
		xmProject.put("linkBranchId",user.getBranchId());
		xmProject.put("platformBranchId",platformBranchId);
		List<Map<String,Object>> xmProjectList = xmProjectService.getProject(xmProject);	//列出XmProject列表
		PageUtils.responePage(m, xmProjectList);
		m.put("data",xmProjectList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	

	@ApiOperation( value = "新增一条xm_project信息",notes="addXmProject,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProject.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@HasQx(value = "xm_core_xmProject_add",name = "创建项目",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	public Map<String,Object> addXmProject(@RequestBody XmProjectVo xmProjectVo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功创建项目");
		try{
			if(!StringUtils.hasText(xmProjectVo.getName())){
				return ResponseHelper.failed("name-0","项目名称不能为空");
			}
			if(xmProjectVo.getLinks()!=null && xmProjectVo.getLinks().size()>0){
				for (XmProductProjectLink link : xmProjectVo.getLinks()) {
					if(!StringUtils.hasText(link.getProductId())){
						return ResponseHelper.failed("productId-0","关联的产品编号不能为空");
					}
				}
			}
				xmProjectService.saveProject(xmProjectVo);
				xmProjectService.clearProject(xmProjectVo.getId());
			xmProjectStateService.loadTasksToXmProjectState(xmProjectVo.getId());
				m.put("data",xmProjectVo);
			
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
	@ApiOperation( value = "从回收站恢复项目",notes="unDelXmProject,仅需要上传主键字段")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@RequestMapping(value="/unDel",method=RequestMethod.POST)
	@HasQx(value = "xm_core_xmProject_unDel",name = "从回收站恢复项目",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	public Map<String,Object> unDelXmProject(@RequestBody XmProject xmProject){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功从回收站恢复项目");
		try{
			User user= LoginUtils.getCurrentUserInfo();
			XmProject xmProjectDb=this.xmProjectService.getProjectFromCache(xmProject.getId());
			if(xmProjectDb==null){
				tips.setFailureMsg("项目不存在");
			}
			if(!user.getBranchId().equals(xmProjectDb.getBranchId())){
				return ResponseHelper.failed("branchId-not-right","该项目不属于您的组织，不允许您进行恢复");
			}
			if(!"1".equals(xmProjectDb.getDel())){
				return ResponseHelper.failed("status-not-0","该项目不属于删除状态，不允许恢复");
			}
			if(this.groupService.checkUserIsProjectAdm(xmProjectDb,user.getUserid())){
				XmProject xmProjectUpdate=new XmProject();
				xmProjectUpdate.setId(xmProjectDb.getId());
				xmProjectUpdate.setDel("0");
				xmProjectUpdate.setLtime(new Date());
				xmProjectService.updateSomeFieldByPk(xmProjectUpdate);
				xmProjectService.clearProject(xmProject.getId());
				xmRecordService.addXmProjectRecord(xmProject.getId(),"项目-从回收站恢复项目",user.getUsername()+"从回收站恢复项目【"+xmProjectDb.getName()+"】", null, JSON.toJSONString(xmProjectDb));

			}else {
				tips.setFailureMsg("您不是该项目管理人员，无权从回收站恢复项目");
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
	@ApiOperation( value = "删除一条xm_project信息",notes="delXmProject,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	@HasQx(value = "xm_core_xmProject_del",name = "删除项目",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	public Map<String,Object> delXmProject(@RequestBody XmProject xmProject){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			User user= LoginUtils.getCurrentUserInfo();
			XmProject xmProjectDb=this.xmProjectService.getProjectFromCache(xmProject.getId());
			if(xmProjectDb==null){
				tips.setFailureMsg("项目不存在");
			}
			if(!user.getBranchId().equals(xmProjectDb.getBranchId())){
				return ResponseHelper.failed("branchId-not-right","该项目不属于您的组织，不允许您进行删除");
			}
			if(this.groupService.checkUserIsProjectAdm(xmProjectDb,user.getUserid())){
				XmProject xmProjectUpdate=new XmProject();
				xmProjectUpdate.setId(xmProjectDb.getId());
				xmProjectUpdate.setDel("1");
				xmProjectUpdate.setLtime(new Date());
				xmProjectService.updateSomeFieldByPk(xmProjectUpdate);
				xmProjectService.clearProject(xmProject.getId());
				xmRecordService.addXmProjectRecord(xmProject.getId(),"项目-删除",user.getUsername()+"删除项目【"+xmProjectDb.getName()+"】", null, JSON.toJSONString(xmProjectDb));

			}else {
				tips.setFailureMsg("您不是该项目管理人员，无权删除");
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
	
	@ApiOperation( value = "根据主键修改一条xm_project信息",notes="editXmProject")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmProject.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmProject_editAssess",name = "修改项目估算",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/editAssess",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectAssess(@RequestBody XmProject xmProject) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{

			User user= LoginUtils.getCurrentUserInfo();
			if( !StringUtils.hasText(xmProject.getId())){
				tips.setFailureMsg("项目不存在");
				m.put("tips", tips);
				return m;
			}
			XmProject xmProjectDb=this.xmProjectService.getProjectFromCache(xmProject.getId());
			if(xmProjectDb==null){
				tips.setFailureMsg("项目不存在");
				m.put("tips", tips);
				return m;
			}
			List<XmGroupVo> groups=this.groupService.getProjectGroupVoList(xmProjectDb.getId());
			boolean isCreate=user.getUserid().equals(xmProjectDb.getCreateUserid());
			boolean isPm=groupService.checkUserIsProjectAdm(xmProjectDb,user.getUserid());
			if( !isCreate && !isPm ) {
				tips.setFailureMsg("您无权操作！项目创建人、项目经理才能修改项目基础数据");
				m.put("tips", tips);
				return m;
			}
			xmProjectService.updateByPk(xmProject);
			xmProjectService.clearProject(xmProject.getId());
			xmRecordService.addXmProjectRecord(xmProject.getId(),"项目-项目估算","修改项目【"+xmProjectDb.getName()+"】的预算数据", JSON.toJSONString(xmProject), JSON.toJSONString(xmProjectDb));
			m.put("data",xmProject);
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
	@ApiOperation( value = "创建项目代号",notes="createProjectCode")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmProject.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmProject_createProjectCode",name = "创建项目代号",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/createProjectCode",method=RequestMethod.POST)
	public Map<String,Object> createProjectCode() {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("创建项目代号成功");
		try{
			User user= LoginUtils.getCurrentUserInfo();
			String code=this.xmProjectService.createProjectCode(user.getBranchId());
			m.put("data",code);
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
	@ApiOperation( value = "根据主键修改一条xm_project信息",notes="editXmProject")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmProject.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmProject_editStatus",name = "修改项目状态",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/editStatus",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectStatus(@RequestBody XmProject xmProject) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("状态更新成功");
		try{

			User user= LoginUtils.getCurrentUserInfo();
			if( !StringUtils.hasText(xmProject.getId())){
				tips.setFailureMsg("项目不存在");
				m.put("tips", tips);
				return m;
			}
			XmProject xmProjectDb=this.xmProjectService.getProjectFromCache(xmProject.getId());
			if(xmProjectDb==null){
				tips.setFailureMsg("项目不存在");
				m.put("tips", tips);
				return m;
			}
			List<XmGroupVo> groups=this.groupService.getProjectGroupVoList(xmProjectDb.getId());
			boolean isCreate=user.getUserid().equals(xmProjectDb.getCreateUserid());
			boolean isPm=groupService.checkUserIsProjectAdm(xmProjectDb,user.getUserid());
			if( !isCreate && !isPm ) {
				tips.setFailureMsg("您无权操作！项目创建人、项目经理才能修改项目状态");
				m.put("tips", tips);
				return m;
			}
			xmProjectService.updateStatus(xmProject);
			xmProjectService.clearProject(xmProject.getId());
			xmRecordService.addXmProjectRecord(xmProject.getId(),"项目-项目状态变更","修改项目【"+xmProjectDb.getName()+"】的状态", xmProject.getStatus(),xmProjectDb.getStatus());


			m.put("data",xmProject);
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
	
	@ApiOperation( value = "根据主键修改一条xm_project信息",notes="editXmProject")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmProject.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmProject_editBudget",name = "修改项目预算",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/editBudget",method=RequestMethod.POST)
	public Map<String,Object> editBudget(@RequestBody XmProject xmProject) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("预算更新成功");
		try{
			User user= LoginUtils.getCurrentUserInfo();
			if( !StringUtils.hasText(xmProject.getId())){
				tips.setFailureMsg("项目编号不能为空");
				m.put("tips", tips);
				return m;
			}
			XmProject xmProjectDb=this.xmProjectService.getProjectFromCache(xmProject.getId());
			if(xmProjectDb==null){
				tips.setFailureMsg("项目不存在");
				m.put("tips", tips);
				return m;
			}
			List<XmGroupVo> groups=this.groupService.getProjectGroupVoList(xmProjectDb.getId());
			boolean isCreate=user.getUserid().equals(xmProjectDb.getCreateUserid());
			boolean isPm=groupService.checkUserIsProjectAdm(xmProjectDb,user.getUserid());
			if( !isCreate && !isPm ) {
				tips.setFailureMsg("您无权操作！项目创建人、项目经理才能修改项目预算");
				m.put("tips", tips);
				return m;
			}
			xmProjectService.editBudget(xmProject);
			xmProjectService.clearProject(xmProject.getId());
			xmRecordService.addXmProjectRecord(xmProject.getId(),"项目-项目预算","修改项目【"+xmProjectDb.getName()+"】的预算数据", JSON.toJSONString(xmProject), JSON.toJSONString(xmProjectDb));

			m.put("data",xmProject);
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
	
	@ApiOperation( value = "根据主键修改一条xm_project信息",notes="editXmProject")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProject.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmProject_edit",name = "修改项目基础信息",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProject(@RequestBody XmProject xmProject) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			User user= LoginUtils.getCurrentUserInfo();
			if( !StringUtils.hasText(xmProject.getId())){
				tips.setFailureMsg("项目不存在");
				m.put("tips", tips);
				return m;
			}
			XmProject xmProjectDb=this.xmProjectService.getProjectFromCache(xmProject.getId());
			if(xmProjectDb==null){
				tips.setFailureMsg("项目不存在");
				m.put("tips", tips);
				return m;
			}
			List<XmGroupVo> groups=this.groupService.getProjectGroupVoList(xmProjectDb.getId());
			boolean isCreate=user.getUserid().equals(xmProjectDb.getCreateUserid());
			boolean isPm=groupService.checkUserIsProjectAdm(xmProjectDb,user.getUserid());
			if( !isCreate && !isPm ) {
				tips.setFailureMsg("您无权操作！项目创建人、项目经理才能修改项目基础信息");
				m.put("tips", tips);
				return m;
			}
			xmProjectService.updateProject(xmProject);
			xmProjectService.clearProject(xmProject.getId());
			xmRecordService.addXmProjectRecord(xmProject.getId(),"项目-修改","修改项目【"+xmProjectDb.getName()+"】的基础信息", JSON.toJSONString(xmProject), JSON.toJSONString(xmProjectDb));

			m.put("data",xmProject);
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

	@ApiOperation( value = "存为模板",notes="editXmProject")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmProject.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmProject_copy_to",name = "存为新项目",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/copyTo",method=RequestMethod.POST)
	public Map<String,Object> copyTo(@RequestBody XmProjectCopyVo xmProject) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			User user= LoginUtils.getCurrentUserInfo();
			if( !StringUtils.hasText(xmProject.getId())){
				return ResponseHelper.failed("id-0","请上送原项目编号参数id");
			}
			if( !StringUtils.hasText(xmProject.getName())){
				return ResponseHelper.failed("name-0","请上送新项目名称");
			}
			if(StringUtils.hasText(xmProject.getCode())){
				XmProject pq=new XmProject();
				pq.setBranchId(user.getBranchId());
				pq.setCode(xmProject.getCode());
				List<XmProject> xmProjectList=this.xmProjectService.selectListByWhere(pq);
				if(xmProjectList!=null && xmProjectList.size()>0){
					return ResponseHelper.failed("code-exists","项目代号【"+xmProject.getCode()+"】已存在，，请重新输入新的项目代号，如果为空，后台自动生成");
				}
			}
			XmProject xmProjectDb=this.xmProjectService.getProjectFromCache(xmProject.getId());
			if(xmProjectDb==null){
				tips.setFailureMsg("项目不存在");
				m.put("tips", tips);
				return m;
			}
			XmProject xmProjectTo=this.xmProjectService.copyProject(user,xmProject);

			xmProjectStateService.loadTasksToXmProjectState(xmProjectTo.getId());
			xmRecordService.addXmProjectRecord(xmProjectTo.getId(),"项目-通过拷贝创建新项目","拷贝项目【"+xmProjectTo.getName()+"】,创建新的项目【】", JSON.toJSONString(xmProjectTo), JSON.toJSONString(xmProjectDb));

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
	@ApiOperation( value = "根据主键列表批量删除xm_project信息",notes="batchDelXmProject,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProject(@RequestBody List<XmProject> xmProjects) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjects.size()+"条数据"); 
		try{ 
			xmProjectService.batchDelete(xmProjects);
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
	@AuditLog(firstMenu="办公平台",secondMenu="项目管理",func="processApprova",funcDesc="项目立项等审批",operType=OperType.UPDATE)
	@RequestMapping(value="/processApprova",method=RequestMethod.POST)
	public Map<String,Object> processApprova( @RequestBody Map<String,Object> flowVars){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		  
		try{ 
			
			this.xmProjectService.processApprova(flowVars);
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
