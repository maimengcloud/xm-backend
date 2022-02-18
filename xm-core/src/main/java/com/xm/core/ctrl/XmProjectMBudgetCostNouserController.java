package com.xm.core.ctrl;

import com.alibaba.fastjson.JSON;
import com.mdp.audit.log.client.annotation.AuditLog;
import com.mdp.audit.log.client.annotation.OperType;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.NumberUtil;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.core.entity.XmProjectMBudgetCostNouser;
import com.xm.core.service.XmProjectMBudgetCostNouserService;
import com.xm.core.service.XmRecordService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * url编制采用rest风格,如对XM.xm_project_m_budget_cost_nouser xm_project_m_budget_cost_nouser的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProjectMBudgetCostNouser/add <br>
 *  查询: xm/xmProjectMBudgetCostNouser/list<br>
 *  模糊查询: xm/xmProjectMBudgetCostNouser/listKey<br>
 *  修改: xm/xmProjectMBudgetCostNouser/edit <br>
 *  删除: xm/xmProjectMBudgetCostNouser/del<br>
 *  批量删除: xm/xmProjectMBudgetCostNouser/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectMBudgetCostNouser 表 XM.xm_project_m_budget_cost_nouser 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectMBudgetCostNouserController")
@RequestMapping(value="/**/xm/core/xmProjectMBudgetCostNouser")
@Api(tags={"xm_project_m_budget_cost_nouser操作接口"})
public class XmProjectMBudgetCostNouserController {
	
	static Log logger=LogFactory.getLog(XmProjectMBudgetCostNouserController.class);
	
	@Autowired
	private XmProjectMBudgetCostNouserService xmProjectMBudgetCostNouserService;
	 

	@Autowired
    XmRecordService xmRecordService;
 
	
	@ApiOperation( value = "查询xm_project_m_budget_cost_nouser信息列表",notes="listXmProjectMBudgetCostNouser,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="budgetCost",value="预算金额",required=false),
		@ApiImplicitParam(name="remark",value="备注",required=false),
		@ApiImplicitParam(name="subjectId",value="预算科目",required=false),
		@ApiImplicitParam(name="bizzStartDate",value="费用归属周期开始日期",required=false),
		@ApiImplicitParam(name="bizzEndDate",value="费用归属周期结束日期",required=false),
		@ApiImplicitParam(name="bizProcInstId",value="当前流程实例编号",required=false),
		@ApiImplicitParam(name="bizFlowState",value="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",required=false),
		@ApiImplicitParam(name="projectPhaseId",value="计划",required=false),
		@ApiImplicitParam(name="costType",value="成本类型0非人力1内部人力2外购人力",required=false),
		@ApiImplicitParam(name="bizzMonth",value="费用归属月份yyyy-mm",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectMBudgetCostNouser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectMBudgetCostNouser( @RequestParam Map<String,Object> xmProjectMBudgetCostNouser){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectMBudgetCostNouser, "ids");
		PageUtils.startPage(xmProjectMBudgetCostNouser);
		List<Map<String,Object>>	xmProjectMBudgetCostNouserList = xmProjectMBudgetCostNouserService.selectListMapByWhere(xmProjectMBudgetCostNouser);	//列出XmProjectMBudgetCostNouser列表
		PageUtils.responePage(m, xmProjectMBudgetCostNouserList);
		m.put("data",xmProjectMBudgetCostNouserList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectMBudgetCostNouser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listSum",method=RequestMethod.GET)
	public Map<String,Object> listSum( @RequestParam Map<String,Object> xmProjectMBudgetCostNouser){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectMBudgetCostNouser, "ids");
		PageUtils.startPage(xmProjectMBudgetCostNouser);
		List<Map<String,Object>>	xmProjectMBudgetCostNouserList = xmProjectMBudgetCostNouserService.listSum(xmProjectMBudgetCostNouser);	//列出xmProjectMBudgetCostNouser列表
		PageUtils.responePage(m, xmProjectMBudgetCostNouserList);
		m.put("data",xmProjectMBudgetCostNouserList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	/***/
	@ApiOperation( value = "新增一条xm_project_m_budget_cost_nouser信息",notes="addXmProjectMBudgetCostNouser,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectMBudgetCostNouser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectMBudgetCostNouser(@RequestBody XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectMBudgetCostNouser.getId())) {
				xmProjectMBudgetCostNouser.setId(xmProjectMBudgetCostNouserService.createKey("id"));
			}else{
				 XmProjectMBudgetCostNouser xmProjectMBudgetCostNouserQuery = new  XmProjectMBudgetCostNouser(xmProjectMBudgetCostNouser.getId());
				if(xmProjectMBudgetCostNouserService.countByWhere(xmProjectMBudgetCostNouserQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			String projectId=xmProjectMBudgetCostNouser.getProjectId();
			BigDecimal zero=BigDecimal.ZERO;  
			BigDecimal budgetCostUser=NumberUtil.getBigDecimal(xmProjectMBudgetCostNouser.getBudgetCost(),zero); 
			Tips judgetTips=xmProjectMBudgetCostNouserService.judgetBudget(projectId, budgetCostUser,null);
			if(judgetTips.isOk()) {   
				xmProjectMBudgetCostNouserService.insert(xmProjectMBudgetCostNouser);
				xmRecordService.addXmBudgetRecord(projectId, xmProjectMBudgetCostNouser.getId(), "项目-预算-非人力-增加", "增加预算"+xmProjectMBudgetCostNouser.getBudgetCost(),JSON.toJSONString(xmProjectMBudgetCostNouser),null);
				m.put("data",xmProjectMBudgetCostNouser);
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
	@ApiOperation( value = "删除一条xm_project_m_budget_cost_nouser信息",notes="delXmProjectMBudgetCostNouser,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectMBudgetCostNouser(@RequestBody XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectMBudgetCostNouserService.deleteByPk(xmProjectMBudgetCostNouser);
			xmRecordService.addXmBudgetRecord(xmProjectMBudgetCostNouser.getProjectId(), xmProjectMBudgetCostNouser.getId(), "项目-预算-非人力-删除", "删除预算"+xmProjectMBudgetCostNouser.getBudgetCost(),JSON.toJSONString(xmProjectMBudgetCostNouser),null);

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
	@ApiOperation( value = "根据主键修改一条xm_project_m_budget_cost_nouser信息",notes="editXmProjectMBudgetCostNouser")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectMBudgetCostNouser.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectMBudgetCostNouser(@RequestBody XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			String projectId=xmProjectMBudgetCostNouser.getProjectId();
			BigDecimal zero=BigDecimal.ZERO;  
			BigDecimal budgetCostUser=NumberUtil.getBigDecimal(xmProjectMBudgetCostNouser.getBudgetCost(),zero); 
			List<String> excludeIds=new ArrayList<>();
			excludeIds.add(xmProjectMBudgetCostNouser.getId());
			Tips judgetTips=xmProjectMBudgetCostNouserService.judgetBudget(projectId, budgetCostUser,excludeIds);
			if(judgetTips.isOk()) {  

				xmProjectMBudgetCostNouserService.updateByPk(xmProjectMBudgetCostNouser);
				xmRecordService.addXmBudgetRecord(xmProjectMBudgetCostNouser.getProjectId(), xmProjectMBudgetCostNouser.getId(), "项目-预算-非人力-修改", "修改预算为"+xmProjectMBudgetCostNouser.getBudgetCost(),JSON.toJSONString(xmProjectMBudgetCostNouser),null);

				m.put("data",xmProjectMBudgetCostNouser);
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
	@ApiOperation( value = "根据主键列表批量删除xm_project_m_budget_cost_nouser信息",notes="batchDelXmProjectMBudgetCostNouser,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectMBudgetCostNouser(@RequestBody List<XmProjectMBudgetCostNouser> xmProjectMBudgetCostNousers) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectMBudgetCostNousers.size()+"条数据"); 
		try{ 
			xmProjectMBudgetCostNouserService.batchDelete(xmProjectMBudgetCostNousers);
			for (XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser : xmProjectMBudgetCostNousers) {
				xmRecordService.addXmBudgetRecord(xmProjectMBudgetCostNouser.getProjectId(), xmProjectMBudgetCostNouser.getId(), "项目-预算-非人力-删除", "删除预算额"+xmProjectMBudgetCostNouser.getBudgetCost(),JSON.toJSONString(xmProjectMBudgetCostNouser),null);

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
	@ApiOperation( value = "批量修改",notes="batchEdit")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchEdit",method=RequestMethod.POST)
	public Map<String,Object> batchEditXmProjectMBudgetCostNouser(@RequestBody List<XmProjectMBudgetCostNouser> xmProjectMBudgetCostNousers) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增"+xmProjectMBudgetCostNousers.size()+"条数据"); 
		try{ 
			xmProjectMBudgetCostNousers.forEach(g->{
				g.setId(xmProjectMBudgetCostNouserService.createKey("id")); 
			});
			
			BigDecimal budgetCostUser=BigDecimal.ZERO;
			String projectId=null;
			BigDecimal zero=BigDecimal.ZERO;  
			List<String> excludeIds=new ArrayList<>();
			for (XmProjectMBudgetCostNouser costUser : xmProjectMBudgetCostNousers) {
				excludeIds.add(costUser.getId());
				projectId=costUser.getProjectId(); 
				budgetCostUser=budgetCostUser.add(NumberUtil.getBigDecimal(costUser.getBudgetCost(),zero)); 
			}
			Tips judgetTips=xmProjectMBudgetCostNouserService.judgetBudget(projectId, budgetCostUser,excludeIds);
			if(judgetTips.isOk()) {     
				xmProjectMBudgetCostNouserService.batchUpdate(xmProjectMBudgetCostNousers);
				for (XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser : xmProjectMBudgetCostNousers) {
					xmRecordService.addXmBudgetRecord(xmProjectMBudgetCostNouser.getProjectId(), xmProjectMBudgetCostNouser.getId(), "项目-预算-非人力-修改", "修改预算额"+xmProjectMBudgetCostNouser.getBudgetCost(),JSON.toJSONString(xmProjectMBudgetCostNouser),null);
				}
				m.put("data", xmProjectMBudgetCostNousers);
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
	@ApiOperation( value = "批量新增",notes="batchAddXmProjectMCostNouser")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchAdd",method=RequestMethod.POST)
	public Map<String,Object> batchAddXmProjectMBudgetCostNouser(@RequestBody List<XmProjectMBudgetCostNouser> xmProjectMBudgetCostNousers) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增"+xmProjectMBudgetCostNousers.size()+"条数据"); 
		try{ 
			xmProjectMBudgetCostNousers.forEach(g->{
				g.setId(xmProjectMBudgetCostNouserService.createKey("id")); 
			});
			
			BigDecimal budgetCostUser=BigDecimal.ZERO;
			String projectId=null;
			BigDecimal zero=BigDecimal.ZERO;  
			for (XmProjectMBudgetCostNouser costUser : xmProjectMBudgetCostNousers) {
				projectId=costUser.getProjectId(); 
				budgetCostUser=budgetCostUser.add(NumberUtil.getBigDecimal(costUser.getBudgetCost(),zero)); 
			}
			Tips judgetTips=xmProjectMBudgetCostNouserService.judgetBudget(projectId, budgetCostUser,null);
			if(judgetTips.isOk()) {     
				xmProjectMBudgetCostNouserService.batchInsert(xmProjectMBudgetCostNousers);
				for (XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser : xmProjectMBudgetCostNousers) {
					xmRecordService.addXmBudgetRecord(xmProjectMBudgetCostNouser.getProjectId(), xmProjectMBudgetCostNouser.getId(), "项目-预算-非人力-增加", "增加预算额"+xmProjectMBudgetCostNouser.getBudgetCost(),JSON.toJSONString(xmProjectMBudgetCostNouser),null);
				}
				m.put("data", xmProjectMBudgetCostNousers);
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
	@AuditLog(firstMenu="办公平台",secondMenu="项目成本",func="processApprova",funcDesc="非人力成本结算流程审批",operType=OperType.UPDATE)
	@RequestMapping(value="/processApprova",method=RequestMethod.POST)
	public Map<String,Object> processApprova( @RequestBody Map<String,Object> flowVars){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		  
		try{ 
			
			this.xmProjectMBudgetCostNouserService.processApprova(flowVars);
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
