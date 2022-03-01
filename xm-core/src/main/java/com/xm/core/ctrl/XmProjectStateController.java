package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.core.entity.XmProductState;
import com.xm.core.entity.XmProjectState;
import com.xm.core.service.XmProjectStateService;
import com.xm.core.service.cache.XmProjectCacheService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url编制采用rest风格,如对XM.xm_project_state 项目指标日统计表的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProjectState/add <br>
 *  查询: xm/xmProjectState/list<br>
 *  模糊查询: xm/xmProjectState/listKey<br>
 *  修改: xm/xmProjectState/edit <br>
 *  删除: xm/xmProjectState/del<br>
 *  批量删除: xm/xmProjectState/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectState 表 XM.xm_project_state 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectStateController")
@RequestMapping(value="/**/xm/core/xmProjectState")
@Api(tags={"项目指标日统计表操作接口"})
public class XmProjectStateController {
	
	static Log logger=LogFactory.getLog(XmProjectStateController.class);
	
	@Autowired
	private XmProjectStateService xmProjectStateService;

	@Autowired
	XmProjectCacheService projectCacheService;
 
	
	@ApiOperation( value = "查询项目指标日统计表信息列表",notes="listXmProjectState,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="bizDate",value="统计日期yyyy-mm-dd类型",required=false),
		@ApiImplicitParam(name="totalFileCnt",value="文件数据",required=false),
		@ApiImplicitParam(name="totalBugCnt",value="bug数目",required=false),
		@ApiImplicitParam(name="totalTaskCnt",value="任务数",required=false),
		@ApiImplicitParam(name="totalBudgetNouserAmount",value="项目总非人力预算-来自项目表",required=false),
		@ApiImplicitParam(name="projectName",value="项目名称",required=false),
		@ApiImplicitParam(name="totalStaffCnt",value="总参与人数",required=false),
		@ApiImplicitParam(name="calCtime",value="统计执行日期",required=false),
		@ApiImplicitParam(name="calStatus",value="0-暂时的1稳定的，暂时的可以被覆盖，稳定的不允许覆盖",required=false),
		@ApiImplicitParam(name="totalCostNouserAmount",value="项目总非人力成本",required=false),
		@ApiImplicitParam(name="totalClosedBugCnt",value="已关闭bug总数",required=false),
		@ApiImplicitParam(name="totalResolvedBugCnt",value="已解决bug总数",required=false),
		@ApiImplicitParam(name="totalCompleteTaskCnt",value="已完成任务总数-来自任务表",required=false),
		@ApiImplicitParam(name="totalPhaseCnt",value="项目计划数",required=false),
		@ApiImplicitParam(name="totalCompletePhaseCnt",value="项目计划已完成数",required=false),
		@ApiImplicitParam(name="totalNeedPayAmount",value="待付款总金额",required=false),
		@ApiImplicitParam(name="totalFinishPayAmount",value="已付款总金额",required=false),
		@ApiImplicitParam(name="totalNeedColAmount",value="待收款总金额",required=false),
		@ApiImplicitParam(name="totalFinishColAmount",value="已收款总金额",required=false),
		@ApiImplicitParam(name="totalCostUserAmount",value="项目总人力成本",required=false),
		@ApiImplicitParam(name="totalBudgetInnerUserAmount",value="项目总内部人力预算-来自项目表",required=false),
		@ApiImplicitParam(name="totalPlanWorkload",value="项目总预算工作量-来自项目表",required=false),
		@ApiImplicitParam(name="totalRiskCnt",value="项目风险总数",required=false),
		@ApiImplicitParam(name="totalCompleteRiskCnt",value="已完成风险总数",required=false),
		@ApiImplicitParam(name="branchId",value="机构编号",required=false),
		@ApiImplicitParam(name="branchName",value="机构名称",required=false),
		@ApiImplicitParam(name="totalBudgetOutUserAmount",value="项目总外购人力预算-来自项目表",required=false),
		@ApiImplicitParam(name="totalCompleteWorkload",value="已完成工作量-来自计划中实际完成工作量",required=false),
		@ApiImplicitParam(name="totalCostInnerUserAmount",value="项目总内部人力成本金额",required=false),
		@ApiImplicitParam(name="totalCostOutUserAmount",value="项目总外购人力成本金额",required=false),
		@ApiImplicitParam(name="totalProgress",value="项目进度0~100之间，来自任务表",required=false),
		@ApiImplicitParam(name="totalActiveBugCnt",value="激活的bug总数",required=false),
		@ApiImplicitParam(name="totalConfirmedBugCnt",value="已解决bug总数",required=false),
		@ApiImplicitParam(name="projectStatus",value="项目状态，0-初始，1-立项中，2-执行中，3-已结项，4-暂停",required=false),
		@ApiImplicitParam(name="totalActWorkload",value="实际总工作量，来自任务表",required=false),
		@ApiImplicitParam(name="totalActOutWorkload",value="实际外购总工作量，来自任务表",required=false),
		@ApiImplicitParam(name="totalActInnerWorkload",value="实际内部总工作量，来自任务表",required=false),
		@ApiImplicitParam(name="totalTaskBudgetCostAt",value="已经分配到任务的总预算",required=false),
		@ApiImplicitParam(name="totalTaskOutCnt",value="外购任务数，来自任务表",required=false),
		@ApiImplicitParam(name="totalNeedPayCnt",value="待付款笔数",required=false),
		@ApiImplicitParam(name="totalFinishPayCnt",value="完成付款总比数",required=false),
		@ApiImplicitParam(name="totalFinishPayUserCnt",value="已付款总人数",required=false),
		@ApiImplicitParam(name="totalNeedPayUserCnt",value="待付款总人数",required=false),
		@ApiImplicitParam(name="totalPlanInnerUserWorkload",value="内部人力总工作量-应该大于或等于计划内部人力总成本",required=false),
		@ApiImplicitParam(name="totalPlanOutUserWorkload",value="外购人力总工作量-应该大于或等于计划外购人力总成本",required=false),
		@ApiImplicitParam(name="testCases",value="测试案例总数",required=false),
		@ApiImplicitParam(name="execCases",value="测试中案例总数",required=false),
		@ApiImplicitParam(name="designCases",value="设计中案例总数",required=false),
		@ApiImplicitParam(name="finishCases",value="完成案例总数",required=false),
		@ApiImplicitParam(name="iterationCnt",value="迭代数",required=false),
		@ApiImplicitParam(name="productCnt",value="产品数",required=false),
		@ApiImplicitParam(name="menuCnt",value="需求数",required=false),
		@ApiImplicitParam(name="taskCnt",value="任务数",required=false),
		@ApiImplicitParam(name="finishTaskCnt",value="完成的任务数",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectState( @RequestParam Map<String,Object> xmProjectState){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectState, "ids");
		PageUtils.startPage(xmProjectState);
		List<Map<String,Object>>	xmProjectStateList = xmProjectStateService.selectListMapByWhere(xmProjectState);	//列出XmProjectState列表
		PageUtils.responePage(m, xmProjectStateList);
		m.put("data",xmProjectStateList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	@ApiOperation( value = "查询功能状态表,无需前端维护，所有数据由汇总统计得出信息列表",notes="listXmProductState,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")

	@ApiResponses({
			@ApiResponse(code = 200,response= XmProductState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list/portal",method=RequestMethod.GET)
	public Map<String,Object> listXmProductStateForPortal( @RequestParam Map<String,Object> xmProductState){
		Map<String,Object> m = new HashMap<>();
		RequestUtils.transformArray(xmProductState, "ids");
		PageUtils.startPage(xmProductState);
		List<Map<String,Object>>	xmProjectStateList = projectCacheService.getPortalProjectStates();	//列出XmProductState列表
		if(xmProjectStateList==null){
			xmProjectStateList=xmProjectStateService.selectPortalProjectStates(xmProductState);
			projectCacheService.putPortalProjectStates(xmProjectStateList);
		}
		PageUtils.responePage(m, xmProjectStateList);
		m.put("data",xmProjectStateList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	 
	 
	@ApiOperation( value = "从任务单抽取实际工作量等统计数据更新到状态报告中",notes="")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/loadTasksToXmProjectState",method=RequestMethod.POST)
	public Map<String,Object> loadTasksToXmProjectState(@RequestBody XmProjectState xmProjectState){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条项目数据");
		try{
			if(StringUtils.isEmpty(xmProjectState.getProjectId())) {
				tips.setFailureMsg("项目编号projectId必填");
			}else {
	
				xmProjectStateService.loadTasksToXmProjectState(xmProjectState.getProjectId());
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
	@ApiOperation( value = "从结算单抽取实际成本等统计数据更新到状态报告中",notes="")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/loadTasksSettleToXmProjectState",method=RequestMethod.POST)
	public Map<String,Object> loadTasksSettleToXmProjectState(@RequestBody XmProjectState xmProjectState){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条项目数据");
		try{
			if(StringUtils.isEmpty(xmProjectState.getProjectId())) {
				tips.setFailureMsg("项目编号projectId必填");
			}else {
	
				xmProjectStateService.loadTasksSettleToXmProjectState(xmProjectState.getProjectId());
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
	@ApiOperation( value = "新增一条项目指标日统计表信息",notes="addXmProjectState,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectState(@RequestBody XmProjectState xmProjectState) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectState.getId())) {
				xmProjectState.setId(xmProjectStateService.createKey("id"));
			}else{
				 XmProjectState xmProjectStateQuery = new  XmProjectState(xmProjectState.getId());
				if(xmProjectStateService.countByWhere(xmProjectStateQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmProjectStateService.insert(xmProjectState);
			m.put("data",xmProjectState);
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
	@ApiOperation( value = "删除一条项目指标日统计表信息",notes="delXmProjectState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectState(@RequestBody XmProjectState xmProjectState){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectStateService.deleteByPk(xmProjectState);
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
	@ApiOperation( value = "根据主键修改一条项目指标日统计表信息",notes="editXmProjectState")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectState.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectState(@RequestBody XmProjectState xmProjectState) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectStateService.updateByPk(xmProjectState);
			m.put("data",xmProjectState);
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
	@ApiOperation( value = "根据主键列表批量删除项目指标日统计表信息",notes="batchDelXmProjectState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectState(@RequestBody List<XmProjectState> xmProjectStates) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectStates.size()+"条数据"); 
		try{ 
			xmProjectStateService.batchDelete(xmProjectStates);
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
}
