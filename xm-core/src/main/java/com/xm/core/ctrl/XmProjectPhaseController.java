package com.xm.core.ctrl;

import com.alibaba.fastjson.JSON;
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
import com.xm.core.entity.XmProjectPhase;
import com.xm.core.entity.XmTask;
import com.xm.core.service.XmProjectGroupService;
import com.xm.core.service.XmProjectPhaseService;
import com.xm.core.service.XmProjectService;
import com.xm.core.service.XmRecordService;
import com.xm.core.vo.XmProjectGroupVo;
import com.xm.core.vo.XmProjectPhaseVo;
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
 * url编制采用rest风格,如对XM.xm_project_phase 项目计划模板的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProjectPhase/add <br>
 *  查询: xm/xmProjectPhase/list<br>
 *  模糊查询: xm/xmProjectPhase/listKey<br>
 *  修改: xm/xmProjectPhase/edit <br>
 *  删除: xm/xmProjectPhase/del<br>
 *  批量删除: xm/xmProjectPhase/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectPhase 表 XM.xm_project_phase 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectPhaseController")
@RequestMapping(value="/**/xm/core/xmProjectPhase")
@Api(tags={"项目计划模板操作接口"})
public class XmProjectPhaseController {
	
	static Log logger=LogFactory.getLog(XmProjectPhaseController.class);
	
	@Autowired
	private XmProjectPhaseService xmProjectPhaseService;

	@Autowired
	private XmProjectGroupService groupService;
		
	@Autowired
	private XmProjectService xmProjectService;
	@Autowired
    XmRecordService xmRecordService;
	
	@ApiOperation( value = "查询项目计划模板信息列表",notes="listXmProjectPhase,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="计划主键,主键",required=false),
		@ApiImplicitParam(name="phaseName",value="计划名称",required=false),
		@ApiImplicitParam(name="remark",value="备注",required=false),
		@ApiImplicitParam(name="parentPhaseId",value="上级计划编号",required=false),
		@ApiImplicitParam(name="branchId",value="机构编号",required=false),
		@ApiImplicitParam(name="projectId",value="当前项目编号",required=false),
		@ApiImplicitParam(name="beginDate",value="开始时间",required=false),
		@ApiImplicitParam(name="endDate",value="结束时间",required=false),
		@ApiImplicitParam(name="phaseBudgetHours",value="工时(不包括下一级)-应该大于或等于task中总工时",required=false),
		@ApiImplicitParam(name="phaseBudgetStaffNu",value="投入人员数(不包括下一级)-应该大于或等于task中总人数",required=false),
		@ApiImplicitParam(name="ctime",value="创建时间",required=false),
		@ApiImplicitParam(name="phaseBudgetNouserAt",value="非人力成本总预算(不包括下一级)-应该大于或等于task中非人力总成本",required=false),
		@ApiImplicitParam(name="phaseBudgetInnerUserAt",value="内部人力成本总预算(不包括下一级)-应该大于或等于task中内部人力总成本",required=false),
		@ApiImplicitParam(name="phaseBudgetOutUserAt",value="外购人力成本总预算(不包括下一级)-应该大于或等于task中外购总成本",required=false),
		@ApiImplicitParam(name="projectBaselineId",value="项目级基线",required=false),
		@ApiImplicitParam(name="bizProcInstId",value="当前流程实例编号",required=false),
		@ApiImplicitParam(name="bizFlowState",value="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",required=false),
		@ApiImplicitParam(name="phaseBudgetWorkload",value="总工作量单位人时-应该大于或者等于task中的预算总工作量",required=false),
		@ApiImplicitParam(name="phaseActWorkload",value="已完成工作量单位人时-从task中的实际工作量算出",required=false),
		@ApiImplicitParam(name="phaseActInnerUserWorkload",value="实际内部人力工作量-来自任务表合计",required=false),
		@ApiImplicitParam(name="phaseActOutUserWorkload",value="实际外购人力工作量-来自任务表合计",required=false),
		@ApiImplicitParam(name="taskType",value="0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType",required=false),
		@ApiImplicitParam(name="planType",value="计划类型w1-周,w2-2周,w3-3周,m1-1月,m2-2月,q1-季,q2-半年，y1-年",required=false),
		@ApiImplicitParam(name="seqNo",value="顺序号",required=false),
		@ApiImplicitParam(name="phaseBudgetInnerUserWorkload",value="内部人力工作量总预算(不包括下一级)-应该大于或等于task中内部人力总成本",required=false),
		@ApiImplicitParam(name="phaseBudgetOutUserWorkload",value="外购人力工作量总预算(不包括下一级)-应该大于或等于task中外购总成本",required=false),
		@ApiImplicitParam(name="actNouserAt",value="实际非人力成本-来自任务表合计",required=false),
		@ApiImplicitParam(name="actInnerUserAt",value="实际内部人力成本-来自任务表合计",required=false),
		@ApiImplicitParam(name="phaseBudgetInnerUserPrice",value="内部人力成本单价元/人时",required=false),
		@ApiImplicitParam(name="phaseBudgetOutUserPrice",value="外购人力成本单价元/人时",required=false),
		@ApiImplicitParam(name="phaseBudgetOutUserCnt",value="外购人数",required=false),
		@ApiImplicitParam(name="phaseBudgetInnerUserCnt",value="内部人数",required=false),
		@ApiImplicitParam(name="actRate",value="实际进度0-100",required=false),
		@ApiImplicitParam(name="phaseStatus",value="计划状态0初始1执行中2完工3关闭4删除中5已删除6暂停",required=false),
		@ApiImplicitParam(name="actOutUserAt",value="实际外部人力成本",required=false),
		@ApiImplicitParam(name="taskCnt",value="任务数",required=false),
		@ApiImplicitParam(name="finishTaskCnt",value="完成的任务数",required=false),
		@ApiImplicitParam(name="iterationCnt",value="迭代数",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectPhase.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectPhase( @RequestParam Map<String,Object> xmProjectPhase){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectPhase, "ids");
		PageUtils.startPage(xmProjectPhase);
		List<Map<String,Object>>	xmProjectPhaseList = xmProjectPhaseService.selectListMapByWhere(xmProjectPhase);	//列出XmProjectPhase列表
		PageUtils.responePage(m, xmProjectPhaseList);
		if("1".equals(xmProjectPhase.get("withParents"))  && !"1".equals(xmProjectPhase.get("isTop")) && xmProjectPhaseList.size()>0){
			Set<String> pidPathsSet=new HashSet<>();
			Set<String> idSet=new HashSet<>();
			for (Map<String, Object> map : xmProjectPhaseList) {
				String id= (String) map.get("id");
				idSet.add(id);
				String pidPaths= (String) map.get("pidPaths");
				pidPaths=PubTool.getPidPaths(pidPaths,id);
				if(pidPaths.length()<=2){
					continue;
				}
				pidPathsSet.add(pidPaths);
			}
			if(pidPathsSet!=null && pidPathsSet.size()>0){
				List<Map<String,Object>> parentList=xmProjectPhaseService.selectListMapByWhere(map("pidPathsList",pidPathsSet.stream().collect(Collectors.toList())));
				parentList=parentList.stream().filter(i->!idSet.contains(i.get("id"))).collect(Collectors.toList());
				if(parentList!=null && parentList.size()>0){
					xmProjectPhaseList.addAll(parentList);
					m.put("total", NumberUtil.getInteger(m.get("total"),0)+parentList.size());
				}
			}
		}
		m.put("data",xmProjectPhaseList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}


	@HasQx(value = "xm_core_xmProjectPhase_setPhaseMngUser",name = "设置计划负责人",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/setPhaseMngUser",method=RequestMethod.POST)
	public Map<String,Object> setPhaseMngUser(@RequestBody XmProjectPhase xmProjectPhase) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功设置");
		try{
			if(StringUtils.isEmpty(xmProjectPhase.getId())) {
				tips.setFailureMsg("计划编号不能为空");
				m.put("tips", tips);
				return m;
			}else if(StringUtils.isEmpty(xmProjectPhase.getId())) {
				tips.setFailureMsg("计划编号不能为空");
				m.put("tips", tips);
				return m;
			}else{
				XmProjectPhase xmProjectPhaseQuery = new  XmProjectPhase(xmProjectPhase.getId());
				XmProjectPhase xmProjectPhaseDb=this.xmProjectPhaseService.selectOneObject(xmProjectPhaseQuery);
				if(xmProjectPhaseDb==null){
					tips.setFailureMsg("计划不存在");
					m.put("tips", tips);
					return m;
				}
				List<XmProjectGroupVo> groupVoList=groupService.getProjectGroupVoList(xmProjectPhaseDb.getProjectId());
				User user = LoginUtils.getCurrentUserInfo();
				boolean meIsPm=groupService.checkUserIsProjectManager(groupVoList,user.getUserid());
				boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
				if( !meIsPm  && !meIsTeamHead ){
					tips.setFailureMsg("您不是组长、也不是项目管理者，不允许设置计划负责人");
					m.put("tips", tips);
					return m;
				}
				boolean meIsHisTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,xmProjectPhase.getMngUserid(),user.getUserid());
				if(  !meIsPm && !meIsHisTeamHead ){
					tips.setFailureMsg("您不是"+xmProjectPhase.getMngUsername()+"的组长，不允许设置其为计划负责人");
					m.put("tips", tips);
					return m;
				}
				if(tips.isOk()){
					XmProjectPhase xmProjectPhaseToUpdate=new XmProjectPhase();
					xmProjectPhaseToUpdate.setId(xmProjectPhase.getId());
					xmProjectPhaseToUpdate.setMngUserid(xmProjectPhase.getMngUserid());
					xmProjectPhaseToUpdate.setMngUsername(xmProjectPhase.getMngUsername());
					this.xmProjectPhaseService.updateSomeFieldByPk(xmProjectPhaseToUpdate);
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

	@ApiOperation( value = "新增一条xm_project_phase信息",notes="addXmProjectPhase,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectPhase.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmProjectPhase_add",name = "创建项目计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectPhase(@RequestBody XmProjectPhase xmProjectPhase) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectPhase.getId())) {
				xmProjectPhase.setId(xmProjectPhaseService.createKey("id"));
			}else{
				 XmProjectPhase xmProjectPhaseQuery = new  XmProjectPhase(xmProjectPhase.getId());
				if(xmProjectPhaseService.countByWhere(xmProjectPhaseQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			User user = LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmProjectPhase.getMngUserid())){
				xmProjectPhase.setMngUserid(user.getUserid());
				xmProjectPhase.setMngUsername(user.getUsername());
			}
			List<XmProjectGroupVo> groupVoList=groupService.getProjectGroupVoList(xmProjectPhase.getProjectId());

			boolean meIsPm=groupService.checkUserIsProjectManager(groupVoList,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是项目管理者，不允许设置计划负责人");
				m.put("tips", tips);
				return m;
			}
			boolean meIsHisTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,xmProjectPhase.getMngUserid(),user.getUserid());
			if(  !meIsPm && !meIsHisTeamHead ){
				tips.setFailureMsg("您不是"+xmProjectPhase.getMngUsername()+"的组长，不允许设置其为计划负责人");
				m.put("tips", tips);
				return m;
			}
			BigDecimal phaseBudgetCost=BigDecimal.ZERO;
			String projectId=null;
			BigDecimal zero=BigDecimal.ZERO; 
			projectId=xmProjectPhase.getProjectId();
			BigDecimal phaseBudgetInnerUserAt=NumberUtil.getBigDecimal(xmProjectPhase.getPhaseBudgetInnerUserAt(),zero);
			BigDecimal phaseBudgetOutUserAt=NumberUtil.getBigDecimal(xmProjectPhase.getPhaseBudgetOutUserAt(),zero); 
			BigDecimal phaseBudgetNouserAt=NumberUtil.getBigDecimal(xmProjectPhase.getPhaseBudgetNouserAt(),zero); 
			phaseBudgetCost=phaseBudgetCost.add(phaseBudgetInnerUserAt).add(phaseBudgetOutUserAt).add(phaseBudgetNouserAt);  
			List<String> excludePhaseIds=new ArrayList<>();
			excludePhaseIds.add(xmProjectPhase.getId());
			Tips judgetTips=xmProjectPhaseService.judgetBudget(projectId, phaseBudgetCost,phaseBudgetInnerUserAt,phaseBudgetOutUserAt,phaseBudgetNouserAt,excludePhaseIds);
			if(judgetTips.isOk()) {
				if(StringUtils.hasText(xmProjectPhase.getParentPhaseId())){
					XmProjectPhase parentDb=xmProjectPhaseService.selectOneObject(new XmProjectPhase(xmProjectPhase.getParentPhaseId()));
					if(parentDb==null){
						return ResponseHelper.failed("p-no-exists","上级计划不存在");
					}
					if(!"1".equals(parentDb.getNtype())){
						return ResponseHelper.failed("p-ntype-no-1","上级【"+parentDb.getPhaseName()+"】不是计划集，不能在其之下建立子计划");
					}
				}
				xmProjectPhaseService.parentIdPathsCalcBeforeSave(xmProjectPhase);
 				xmProjectPhaseService.insert(xmProjectPhase);
				xmRecordService.addXmPhaseRecord(projectId, xmProjectPhase.getId(), "项目-计划-新增计划", "新增计划"+xmProjectPhase.getPhaseName(),JSON.toJSONString(xmProjectPhase),null);
				m.put("data",xmProjectPhase);
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
	/***/
	@ApiOperation( value = "删除一条xm_project_phase信息",notes="delXmProjectPhase,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@HasQx(value = "xm_core_xmProjectPhase_del",name = "删除项目计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectPhase(@RequestBody XmProjectPhase xmProjectPhase){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			List<XmProjectGroupVo> groupVoList=groupService.getProjectGroupVoList(xmProjectPhase.getProjectId());
			User user = LoginUtils.getCurrentUserInfo();
			boolean meIsPm=groupService.checkUserIsProjectManager(groupVoList,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是项目管理者，不允许删除计划");
				m.put("tips", tips);
				return m;
			}
			boolean meIsHisTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,xmProjectPhase.getMngUserid(),user.getUserid());
			if(  !meIsPm && !meIsHisTeamHead ){
				tips.setFailureMsg("您不是"+xmProjectPhase.getMngUsername()+"的组长，不允许删除其负责的计划");
				m.put("tips", tips);
				return m;
			}
			//检查是否由关联的任务，有则不允许删除
			Long exists=this.xmProjectPhaseService.checkExistsTask(xmProjectPhase.getId());
			if(exists>0) {
				tips.setFailureMsg("存在"+exists+"条任务,不允许删除");
			}else {
				Long checkExistsChildren =xmProjectPhaseService.checkExistsChildren(xmProjectPhase.getId());
				if(checkExistsChildren>0) {
					tips.setFailureMsg("存在"+checkExistsChildren+"条子计划,不允许删除");
				}else {

					xmProjectPhaseService.deleteByPk(xmProjectPhase);

					xmRecordService.addXmPhaseRecord(xmProjectPhase.getProjectId(), xmProjectPhase.getId(), "项目-计划-删除计划", "删除计划"+xmProjectPhase.getPhaseName(),JSON.toJSONString(xmProjectPhase),null);
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
	 
	
	/***/
	@ApiOperation( value = "根据主键修改一条xm_project_phase信息",notes="editXmProjectPhase")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectPhase.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmProjectPhase_edit",name = "修改项目计划基础信息",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectPhase(@RequestBody XmProjectPhase xmProjectPhase) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			List<XmProjectGroupVo> groupVoList=groupService.getProjectGroupVoList(xmProjectPhase.getProjectId());
			User user = LoginUtils.getCurrentUserInfo();
			boolean meIsPm=groupService.checkUserIsProjectManager(groupVoList,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是项目管理者，不允许修改计划");
				m.put("tips", tips);
				return m;
			}
			if(!StringUtils.hasText(xmProjectPhase.getMngUserid())){
				xmProjectPhase.setMngUserid(user.getUserid());
				xmProjectPhase.setMngUsername(user.getUsername());
			}
			boolean meIsHisTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,xmProjectPhase.getMngUserid(),user.getUserid());
			if(  !meIsPm && !meIsHisTeamHead ){
				tips.setFailureMsg("您不是"+xmProjectPhase.getMngUsername()+"的组长，不允许修改其负责的计划");
				m.put("tips", tips);
				return m;
			}
			BigDecimal phaseBudgetCost=BigDecimal.ZERO;
			String projectId=null;
			BigDecimal zero=BigDecimal.ZERO; 
			projectId=xmProjectPhase.getProjectId();
			BigDecimal phaseBudgetInnerUserAt=NumberUtil.getBigDecimal(xmProjectPhase.getPhaseBudgetInnerUserAt(),zero);
			BigDecimal phaseBudgetOutUserAt=NumberUtil.getBigDecimal(xmProjectPhase.getPhaseBudgetOutUserAt(),zero); 
			BigDecimal phaseBudgetNouserAt=NumberUtil.getBigDecimal(xmProjectPhase.getPhaseBudgetNouserAt(),zero); 
			phaseBudgetCost=phaseBudgetCost.add(phaseBudgetInnerUserAt).add(phaseBudgetOutUserAt).add(phaseBudgetNouserAt);  
			List<String> excludePhaseIds=new ArrayList<>();
			excludePhaseIds.add(xmProjectPhase.getId());
			Tips judgetTips=xmProjectPhaseService.judgetBudget(projectId, phaseBudgetCost,phaseBudgetInnerUserAt,phaseBudgetOutUserAt,phaseBudgetNouserAt,excludePhaseIds);
			if(judgetTips.isOk()) { 
				xmProjectPhase=xmProjectPhaseService.autoCalcWorkload(xmProjectPhase);
				xmProjectPhaseService.updateByPk(xmProjectPhase);
				xmProjectPhaseService.sumParents(xmProjectPhase);
				xmRecordService.addXmPhaseRecord(xmProjectPhase.getProjectId(), xmProjectPhase.getId(), "项目-计划-修改计划", "修改计划"+xmProjectPhase.getPhaseName(),JSON.toJSONString(xmProjectPhase),null);
				
			}else {
				tips=judgetTips;
			}
			m.put("data",xmProjectPhase);
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
	@ApiOperation( value = "根据主键列表批量删除xm_project_phase信息",notes="batchDelXmProjectPhase,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmProjectPhase_batchDel",name = "批量删除项目计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectPhase(@RequestBody List<XmProjectPhase> xmProjectPhases) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+(xmProjectPhases==null?0:xmProjectPhases.size())+"条数据");
		try{
			if(xmProjectPhases==null || xmProjectPhases.size()==0){
				tips.setFailureMsg("计划不能为空");
				m.put("tips", tips);
				return m;
			}
			XmProjectPhase xmProjectPhase=xmProjectPhases.get(0);
			List<String> noDelList=new ArrayList<>();
			List<String> hasChildList=new ArrayList<>();
			int delCount=0;
			List<XmProjectGroupVo> groupVoList=groupService.getProjectGroupVoList(xmProjectPhase.getProjectId());
			User user = LoginUtils.getCurrentUserInfo();
			boolean meIsPm=groupService.checkUserIsProjectManager(groupVoList,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是项目管理者，不允许删除计划");
				m.put("tips", tips);
				return m;
			}
			List<String> noQxUsernames=new ArrayList<>();
			List<XmProjectPhase> delPhases=new ArrayList<>();
			for (XmProjectPhase phase : xmProjectPhases) {
				boolean meIsHisTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,phase.getMngUserid(),user.getUserid());
				if(  !meIsPm && !meIsHisTeamHead ){
					noQxUsernames.add(phase.getMngUsername());
					continue;
				}
				//检查是否由关联的任务，有则不允许删除
				Long exists=this.xmProjectPhaseService.checkExistsTask(phase.getId());
				if(exists>0) {
					noDelList.add(phase.getPhaseName());
				}else {
					delPhases.add(phase);
				}
			}
			List<XmProjectPhase> canDelNodes=new ArrayList<>();
			for (XmProjectPhase phase : delPhases) {

					boolean canDelAllChild =xmProjectPhaseService.checkCanDelAllChild(phase,xmProjectPhases);
					if(!canDelAllChild) {
						hasChildList.add(phase.getPhaseName());
					}else {
						canDelNodes.add(phase);
 					}
			}
			if(canDelNodes.size()>0){
				this.xmProjectPhaseService.doBatchDelete(delPhases);
			}
			String noQxTips="";
			if(noQxUsernames.size()>0){
				noQxTips="您无权删除以下人员所负责的计划【"+StringUtils.arrayToCommaDelimitedString(noQxUsernames.toArray())+"】";
			}

			if(noDelList.size()>0 && hasChildList.size()>0 ) {
				tips.setOkMsg("成功删除"+(delCount)+"条数据，其中以下数据数据存在任务，不允许删除"+StringUtils.arrayToCommaDelimitedString(noDelList.toArray())+",以下计划存在子计划，不允许删除"
						+StringUtils.arrayToCommaDelimitedString(hasChildList.toArray())+"。"+noQxTips);
			}else if(noDelList.size()>0  ) {
				tips.setOkMsg("成功删除"+(delCount)+"条数据，其中以下数据数据存在任务，不允许删除"+StringUtils.arrayToCommaDelimitedString(noDelList.toArray())+"。"+noQxTips);
			}else if(noDelList.size()>0 && hasChildList.size()>0 ) {
				tips.setOkMsg("成功删除"+(delCount)+"条数据，其中以下计划存在子计划，不允许删除"+StringUtils.arrayToCommaDelimitedString(hasChildList.toArray())+"。"+noQxTips);
			}else {
				tips.setOkMsg("成功删除"+(xmProjectPhases.size())+"条数据"+"。"+noQxTips);
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
	@ApiOperation( value = "根据主键列表批量删除xm_project_phase信息",notes="batchDelXmProjectPhase,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmProjectPhase_batchImportFromTemplate",name = "从模板批量创建项目计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchImportFromTemplate",method=RequestMethod.POST)
	public Map<String,Object> batchImportFromTemplate(@RequestBody List<XmProjectPhase> xmProjectPhases) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功导入"+xmProjectPhases.size()+"条数据"); 
		try{
			if(xmProjectPhases==null || xmProjectPhases.size()==0){
				tips.setFailureMsg("计划不能为空");
				m.put("tips", tips);
				return m;
			}
			XmProjectPhase xmProjectPhase=xmProjectPhases.get(0);
			List<XmProjectGroupVo> groupVoList=groupService.getProjectGroupVoList(xmProjectPhase.getProjectId());
			User user = LoginUtils.getCurrentUserInfo();
			boolean meIsPm=groupService.checkUserIsProjectManager(groupVoList,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是项目管理者，不允许批量导入计划");
				m.put("tips", tips);
				return m;
			}
			BigDecimal phaseBudgetCost=BigDecimal.ZERO;
			BigDecimal phaseBudgetInnerUserAt=BigDecimal.ZERO;
			BigDecimal phaseBudgetOutUserAt=BigDecimal.ZERO;
			BigDecimal phaseBudgetNouserAt=BigDecimal.ZERO;
			String projectId=null;
			BigDecimal zero=BigDecimal.ZERO;
			for (XmProjectPhase g : xmProjectPhases) {
				projectId=g.getProjectId();
				g.setMngUserid(user.getUserid());
				g.setMngUsername(user.getUsername());
				phaseBudgetInnerUserAt=phaseBudgetInnerUserAt.add(NumberUtil.getBigDecimal(g.getPhaseBudgetInnerUserAt(),zero));
				phaseBudgetOutUserAt=phaseBudgetOutUserAt.add(NumberUtil.getBigDecimal(g.getPhaseBudgetOutUserAt(),zero)); 
				phaseBudgetNouserAt=phaseBudgetNouserAt.add(NumberUtil.getBigDecimal(g.getPhaseBudgetNouserAt(),zero)); 
				phaseBudgetCost=phaseBudgetCost.add(phaseBudgetInnerUserAt).add(phaseBudgetOutUserAt).add(phaseBudgetNouserAt); 
				g=xmProjectPhaseService.autoCalcWorkload(g);

			} 
			
			Tips judgetTips=xmProjectPhaseService.judgetBudget(projectId, phaseBudgetCost,phaseBudgetInnerUserAt,phaseBudgetOutUserAt,phaseBudgetNouserAt,null);
			if(judgetTips.isOk()) {
				for (XmProjectPhase projectPhase : xmProjectPhases) {
					projectPhase.setMngUsername(user.getUsername());
					projectPhase.setMngUserid(user.getUserid());
					projectPhase.setCtime(new Date());
					projectPhase.setLtime(new Date());
				}
				xmProjectPhaseService.parentIdPathsCalcBeforeSave(xmProjectPhases);
				xmProjectPhaseService.doBatchInsert(xmProjectPhases);

				for (XmProjectPhase phase : xmProjectPhases) {
					xmRecordService.addXmPhaseRecord(phase.getProjectId(), phase.getId(), "项目-计划-新增计划", "新增计划"+phase.getPhaseName(),JSON.toJSONString(phase),null);
					
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
	/***/
	@ApiOperation( value = "批量修改预算",notes="batchSaveBudget,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmProjectPhase_batchSaveBudget",name = "批量修改项目计划的预算",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchSaveBudget",method=RequestMethod.POST)
	public Map<String,Object> batchSaveBudget(@RequestBody List<XmProjectPhaseVo> xmProjectPhases) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改"+xmProjectPhases.size()+"条数据"); 
		try{
			if(xmProjectPhases==null || xmProjectPhases.size()==0){
				tips.setFailureMsg("计划不能为空");
				m.put("tips", tips);
				return m;
			}
			XmProjectPhase xmProjectPhase=xmProjectPhases.get(0);
			List<XmProjectGroupVo> groupVoList=groupService.getProjectGroupVoList(xmProjectPhase.getProjectId());
			User user = LoginUtils.getCurrentUserInfo();
			boolean meIsPm=groupService.checkUserIsProjectManager(groupVoList,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是项目管理者，不允许修改计划预算");
				m.put("tips", tips);
				return m;
			}
			BigDecimal phaseBudgetCost=BigDecimal.ZERO;
			BigDecimal phaseBudgetInnerUserAt=BigDecimal.ZERO;
			BigDecimal phaseBudgetOutUserAt=BigDecimal.ZERO;
			BigDecimal phaseBudgetNouserAt=BigDecimal.ZERO;
			String projectId=null;
			BigDecimal zero=BigDecimal.ZERO;
			List<String> excludePhaseIds=new ArrayList<>();
			for (XmProjectPhase g : xmProjectPhases) {
				projectId=g.getProjectId();
				phaseBudgetInnerUserAt=phaseBudgetInnerUserAt.add(NumberUtil.getBigDecimal(g.getPhaseBudgetInnerUserAt(),zero));
				phaseBudgetOutUserAt=phaseBudgetOutUserAt.add(NumberUtil.getBigDecimal(g.getPhaseBudgetOutUserAt(),zero)); 
				phaseBudgetNouserAt=phaseBudgetNouserAt.add(NumberUtil.getBigDecimal(g.getPhaseBudgetNouserAt(),zero)); 
				g=xmProjectPhaseService.autoCalcWorkload(g);

				excludePhaseIds.add(g.getId());
			} 
			phaseBudgetCost=phaseBudgetCost.add(phaseBudgetInnerUserAt).add(phaseBudgetOutUserAt).add(phaseBudgetNouserAt);  

			Tips judgetTips=xmProjectPhaseService.judgetBudget(projectId, phaseBudgetCost,phaseBudgetInnerUserAt,phaseBudgetOutUserAt,phaseBudgetNouserAt,excludePhaseIds);
			if(judgetTips.isOk()) {

				for (XmProjectPhaseVo projectPhase : xmProjectPhases) {
					if(!"1".equals(projectPhase.getNtype()) && !"add".equals(projectPhase.getOpType())&& !"addSub".equals(projectPhase.getOpType())){
						if(xmProjectPhases.stream().filter(i->projectPhase.getId().equals(i.getParentPhaseId())).findAny().isPresent()){
							return ResponseHelper.failed("p-ntype-no-1",projectPhase.getPhaseName()+"不是计划集,不允许下挂子计划");
						}
					}
					if("add".equals(projectPhase.getOpType())||"addSub".equals(projectPhase.getOpType())){
						int childrenCnt=Integer.valueOf(xmProjectPhases.stream().filter(i->projectPhase.getId().equals(i.getParentPhaseId())).count()+"");
						if(childrenCnt>0){
							projectPhase.setChildrenCnt(childrenCnt);
							projectPhase.setNtype("1");
						}
					}
				}
				xmProjectPhaseService.parentIdPathsCalcBeforeSave(xmProjectPhases.stream().map(i->(XmProjectPhase)i).collect(Collectors.toList()));
				xmProjectPhaseService.batchInsertOrUpdate(xmProjectPhases);
				for (XmProjectPhase phase : xmProjectPhases) {
					xmRecordService.addXmPhaseRecord(phase.getProjectId(), phase.getId(), "项目-计划-修改计划预算", "修改计划"+phase.getPhaseName(),JSON.toJSONString(phase),null);
					
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
	@ApiOperation( value = "计算bug、task、测试案例、等数据",notes="loadTasksToXmProjectPhase")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmProjectPhase_loadTasksToXmProjectPhase",name = "计算各个计划对应的bug、task、测试案例等数据",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/loadTasksToXmProjectPhase",method=RequestMethod.POST)
	public Map<String,Object> loadTasksToXmProjectPhase(@RequestBody Map<String,Object> params) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改数据"); 
		try{
			String projectId=(String) params.get("projectId");
			List<XmProjectGroupVo> groupVoList=groupService.getProjectGroupVoList(projectId);
			User user = LoginUtils.getCurrentUserInfo();
			boolean meIsPm=groupService.checkUserIsProjectManager(groupVoList,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是项目管理者，不允许发起计划统计任务");
				m.put("tips", tips);
				return m;
			}
			int i= xmProjectPhaseService.loadTasksToXmProjectPhase((String) params.get("projectId"));
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

	@ApiOperation( value = "计算bug、task、测试案例、等数据",notes="loadTasksToXmProjectPhase")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmProjectPhase_loadTasksToXmProjectPhase",name = "计算各个计划对应的bug、task、测试案例等数据",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/calcKeyPaths",method=RequestMethod.POST)
	public Map<String,Object> calcKeyPaths(@RequestBody Map<String,Object> params) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改数据");
		try{
			String projectId=(String) params.get("projectId");
			List<XmProjectGroupVo> groupVoList=groupService.getProjectGroupVoList(projectId);
			User user = LoginUtils.getCurrentUserInfo();
			boolean meIsPm=groupService.checkUserIsProjectManager(groupVoList,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是项目管理者，不允许发起关键路径计算任务");
				m.put("tips", tips);
				return m;
			}
			xmProjectPhaseService.calcKeyPaths((String) params.get("projectId"));
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
