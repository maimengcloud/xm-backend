package com.xm.core.ctrl;

import com.alibaba.fastjson.JSON;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.NumberUtil;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.audit.log.client.annotation.AuditLog;
import com.mdp.audit.log.client.annotation.OperType;
import com.xm.core.entity.XmProjectMBudgetCostUser;
import com.xm.core.service.XmProjectMBudgetCostUserService;
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
@RestController("xm.core.xmProjectMBudgetCostUserController")
@RequestMapping(value="/**/xm/core/xmProjectMBudgetCostUser")
@Api(tags={"xm_project_m_budget_cost_user操作接口"})
public class XmProjectMBudgetCostUserController {
	
	static Log logger=LogFactory.getLog(XmProjectMBudgetCostUserController.class);
	
	@Autowired
	private XmProjectMBudgetCostUserService xmProjectMBudgetCostUserService;
	 
		

	@Autowired
    XmRecordService xmRecordService;
	
	@ApiOperation( value = "查询xm_project_m_budget_cost_user信息列表",notes="listXmProjectMBudgetCostUser,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="userid",value="项目成员编号",required=false),
		@ApiImplicitParam(name="budgetCost",value="预算金额/每月",required=false),
		@ApiImplicitParam(name="remark",value="备注",required=false),
		@ApiImplicitParam(name="username",value="用户名",required=false),
		@ApiImplicitParam(name="subjectId",value="预算科目编号",required=false),
		@ApiImplicitParam(name="bizzStartDate",value="费用归属周期开始日期",required=false),
		@ApiImplicitParam(name="bizzEndDate",value="费用归属周期结束日期",required=false),
		@ApiImplicitParam(name="bizzMonth",value="费用归属月份yyyy-mm",required=false),
		@ApiImplicitParam(name="bizProcInstId",value="当前流程实例编号",required=false),
		@ApiImplicitParam(name="bizFlowState",value="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",required=false),
		@ApiImplicitParam(name="projectPhaseId",value="项目阶段",required=false),
		@ApiImplicitParam(name="costType",value="成本类型0人力1内部人力2外购人力",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectMBudgetCostUser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectMBudgetCostUser( @RequestParam Map<String,Object> xmProjectMBudgetCostUser){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectMBudgetCostUser, "ids");
		PageUtils.startPage(xmProjectMBudgetCostUser);
		List<Map<String,Object>>	xmProjectMBudgetCostUserList = xmProjectMBudgetCostUserService.selectListMapByWhere(xmProjectMBudgetCostUser);	//列出XmProjectMBudgetCostUser列表
		PageUtils.responePage(m, xmProjectMBudgetCostUserList);
		m.put("data",xmProjectMBudgetCostUserList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectMBudgetCostUser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listSum",method=RequestMethod.GET)
	public Map<String,Object> listSum( @RequestParam Map<String,Object> xmProjectMBudgetCostUser){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectMBudgetCostUser, "ids");
		PageUtils.startPage(xmProjectMBudgetCostUser);
		List<Map<String,Object>>	xmProjectMBudgetCostUserList = xmProjectMBudgetCostUserService.listSum(xmProjectMBudgetCostUser);	//列出XmProjectMBudgetCostUser列表
		PageUtils.responePage(m, xmProjectMBudgetCostUserList);
		m.put("data",xmProjectMBudgetCostUserList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	 
	@ApiOperation( value = "新增一条xm_project_m_budget_cost_user信息",notes="addXmProjectMBudgetCostUser,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectMBudgetCostUser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectMBudgetCostUser(@RequestBody XmProjectMBudgetCostUser xmProjectMBudgetCostUser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectMBudgetCostUser.getId())) {
				xmProjectMBudgetCostUser.setId(xmProjectMBudgetCostUserService.createKey("id"));
			}else{
				 XmProjectMBudgetCostUser xmProjectMBudgetCostUserQuery = new  XmProjectMBudgetCostUser(xmProjectMBudgetCostUser.getId());
				if(xmProjectMBudgetCostUserService.countByWhere(xmProjectMBudgetCostUserQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			} 
			String projectId=xmProjectMBudgetCostUser.getProjectId();
			BigDecimal zero=BigDecimal.ZERO;  
			BigDecimal budgetCostUser=NumberUtil.getBigDecimal(xmProjectMBudgetCostUser.getBudgetCost(),zero); 

		    BigDecimal addBudgetCostInnerUserAt=BigDecimal.ZERO;
		    BigDecimal addBudgetCostOutUserAt=BigDecimal.ZERO;
			if("1".equals(xmProjectMBudgetCostUser.getCostType())) {
				addBudgetCostInnerUserAt=budgetCostUser;
			}else {
				addBudgetCostOutUserAt=budgetCostUser;
			}
			Tips judgetTips=xmProjectMBudgetCostUserService.judgetBudget(projectId,budgetCostUser, addBudgetCostInnerUserAt, addBudgetCostOutUserAt,null);
			if(judgetTips.isOk()) {  
				xmProjectMBudgetCostUserService.insert(xmProjectMBudgetCostUser);
				xmRecordService.addXmBudgetRecord(projectId, xmProjectMBudgetCostUser.getId(), "项目-预算-人力-增加", "增加预算"+xmProjectMBudgetCostUser.getBudgetCost(),JSON.toJSONString(xmProjectMBudgetCostUser),null);
				
				m.put("data",xmProjectMBudgetCostUser);
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
	
	@ApiOperation( value = "删除一条xm_project_m_budget_cost_user信息",notes="delXmProjectMBudgetCostUser,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectMBudgetCostUser(@RequestBody XmProjectMBudgetCostUser xmProjectMBudgetCostUser){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectMBudgetCostUserService.deleteByPk(xmProjectMBudgetCostUser);
			xmRecordService.addXmBudgetRecord(xmProjectMBudgetCostUser.getProjectId(), xmProjectMBudgetCostUser.getId(), "项目-预算-人力-删除", "删除预算"+xmProjectMBudgetCostUser.getBudgetCost(),JSON.toJSONString(xmProjectMBudgetCostUser),null);

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
	
	@ApiOperation( value = "根据主键修改一条xm_project_m_budget_cost_user信息",notes="editXmProjectMBudgetCostUser")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectMBudgetCostUser.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectMBudgetCostUser(@RequestBody XmProjectMBudgetCostUser xmProjectMBudgetCostUser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{

			String projectId=xmProjectMBudgetCostUser.getProjectId();
			BigDecimal zero=BigDecimal.ZERO;  
			BigDecimal budgetCostUser=NumberUtil.getBigDecimal(xmProjectMBudgetCostUser.getBudgetCost(),zero); 

		    BigDecimal addBudgetCostInnerUserAt=BigDecimal.ZERO;
		    BigDecimal addBudgetCostOutUserAt=BigDecimal.ZERO;
		    
		    List<String> excludeIds=new ArrayList<>();
		    excludeIds.add(xmProjectMBudgetCostUser.getId());
			if("1".equals(xmProjectMBudgetCostUser.getCostType())) {
				addBudgetCostInnerUserAt=budgetCostUser;
			}else {
				addBudgetCostOutUserAt=budgetCostUser;
			} 
			Tips judgetTips=xmProjectMBudgetCostUserService.judgetBudget(projectId, budgetCostUser,addBudgetCostInnerUserAt,addBudgetCostOutUserAt,excludeIds);
			if(judgetTips.isOk()) {   
				xmProjectMBudgetCostUserService.updateByPk(xmProjectMBudgetCostUser);
				xmRecordService.addXmBudgetRecord(xmProjectMBudgetCostUser.getProjectId(), xmProjectMBudgetCostUser.getId(), "项目-预算-人力-修改", "修改预算为"+xmProjectMBudgetCostUser.getBudgetCost(),JSON.toJSONString(xmProjectMBudgetCostUser),null);

				m.put("data",xmProjectMBudgetCostUser);
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
	

	
	 
	@ApiOperation( value = "根据主键列表批量删除xm_project_m_budget_cost_user信息",notes="batchDelXmProjectMBudgetCostUser,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectMBudgetCostUser(@RequestBody List<XmProjectMBudgetCostUser> xmProjectMBudgetCostUsers) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectMBudgetCostUsers.size()+"条数据"); 
		try{ 
			xmProjectMBudgetCostUserService.batchDelete(xmProjectMBudgetCostUsers);
			for (XmProjectMBudgetCostUser xmProjectMBudgetCostUser : xmProjectMBudgetCostUsers) {
				xmRecordService.addXmBudgetRecord(xmProjectMBudgetCostUser.getProjectId(), xmProjectMBudgetCostUser.getId(), "项目-预算-人力-删除", "删除预算额"+xmProjectMBudgetCostUser.getBudgetCost(),JSON.toJSONString(xmProjectMBudgetCostUser),null);

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
	public Map<String,Object> batchEditXmProjectMBudgetCostUser(@RequestBody List<XmProjectMBudgetCostUser> xmProjectMBudgetCostUsers) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改"+xmProjectMBudgetCostUsers.size()+"条数据"); 
		try{ 
			 
			BigDecimal budgetCostUser=BigDecimal.ZERO;
			BigDecimal budgetCostInserUser=BigDecimal.ZERO;
			BigDecimal budgetCostUserOutUser=BigDecimal.ZERO;
			String projectId=null;
			BigDecimal zero=BigDecimal.ZERO;  
			List<String> excludeIds=new ArrayList<>();
			for (XmProjectMBudgetCostUser costUser : xmProjectMBudgetCostUsers) {
				excludeIds.add(costUser.getId());
				projectId=costUser.getProjectId(); 
				BigDecimal add=NumberUtil.getBigDecimal(costUser.getBudgetCost(),zero);
				budgetCostUser=budgetCostUser.add(NumberUtil.getBigDecimal(costUser.getBudgetCost(),zero)); 
				if("1".equals(costUser.getCostType())) {
					budgetCostInserUser=budgetCostInserUser.add(add);
				}else {
					budgetCostUserOutUser=budgetCostUserOutUser.add(add);
				}
			}
			Tips judgetTips=xmProjectMBudgetCostUserService.judgetBudget(projectId, budgetCostUser,budgetCostInserUser,budgetCostUserOutUser,excludeIds);
			if(judgetTips.isOk()) {    
				xmProjectMBudgetCostUserService.batchUpdate(xmProjectMBudgetCostUsers);

				for (XmProjectMBudgetCostUser xmProjectMBudgetCostUser : xmProjectMBudgetCostUsers) {
					xmRecordService.addXmBudgetRecord(xmProjectMBudgetCostUser.getProjectId(), xmProjectMBudgetCostUser.getId(), "项目-预算-人力-修改", "修改预算额"+xmProjectMBudgetCostUser.getBudgetCost(),JSON.toJSONString(xmProjectMBudgetCostUser),null);
				}
				m.put("data", xmProjectMBudgetCostUsers); 
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
	@ApiOperation( value = "批量新增",notes="batchAddXmProjectMCostUser")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchAdd",method=RequestMethod.POST)
	public Map<String,Object> batchAddXmProjectMBudgetCostUser(@RequestBody List<XmProjectMBudgetCostUser> xmProjectMBudgetCostUsers) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功增加"+xmProjectMBudgetCostUsers.size()+"条数据"); 
		try{ 
			xmProjectMBudgetCostUsers.forEach(g->{
				g.setId(xmProjectMBudgetCostUserService.createKey("id")); 
			});
			BigDecimal budgetCostUser=BigDecimal.ZERO;
			BigDecimal budgetCostInserUser=BigDecimal.ZERO;
			BigDecimal budgetCostUserOutUser=BigDecimal.ZERO;
			String projectId=null;
			BigDecimal zero=BigDecimal.ZERO;  
			for (XmProjectMBudgetCostUser costUser : xmProjectMBudgetCostUsers) {
				projectId=costUser.getProjectId(); 
				BigDecimal add=NumberUtil.getBigDecimal(costUser.getBudgetCost(),zero);
				budgetCostUser=budgetCostUser.add(NumberUtil.getBigDecimal(costUser.getBudgetCost(),zero)); 
				if("1".equals(costUser.getCostType())) {
					budgetCostInserUser=budgetCostInserUser.add(add);
				}else {
					budgetCostUserOutUser=budgetCostUserOutUser.add(add);
				}
			}
			Tips judgetTips=xmProjectMBudgetCostUserService.judgetBudget(projectId, budgetCostUser,budgetCostInserUser,budgetCostUserOutUser,null);
			if(judgetTips.isOk()) {    
				xmProjectMBudgetCostUserService.batchInsert(xmProjectMBudgetCostUsers);

				for (XmProjectMBudgetCostUser xmProjectMBudgetCostUser : xmProjectMBudgetCostUsers) {
					xmRecordService.addXmBudgetRecord(xmProjectMBudgetCostUser.getProjectId(), xmProjectMBudgetCostUser.getId(), "项目-预算-人力-增加", "增加预算额"+xmProjectMBudgetCostUser.getBudgetCost(),JSON.toJSONString(xmProjectMBudgetCostUser),null);
				}
				m.put("data", xmProjectMBudgetCostUsers); 
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
	@AuditLog(firstMenu="办公平台",secondMenu="项目成本",func="processApprova",funcDesc="人力成本结算流程审批",operType=OperType.UPDATE)
	@RequestMapping(value="/processApprova",method=RequestMethod.POST)
	public Map<String,Object> processApprova( @RequestBody Map<String,Object> flowVars){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		  
		try{ 
			
			this.xmProjectMBudgetCostUserService.processApprova(flowVars);
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
