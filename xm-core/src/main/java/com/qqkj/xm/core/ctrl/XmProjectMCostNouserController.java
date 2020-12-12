package com.qqkj.xm.core.ctrl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.qqkj.audit.base.annotation.AuditLog;
import com.qqkj.audit.base.annotation.OperType;
import com.qqkj.mdp.core.entity.Tips;
import com.qqkj.mdp.core.err.BizException;
import com.qqkj.mdp.core.utils.NumberUtil;
import com.qqkj.mdp.core.utils.RequestUtils;
import com.qqkj.mdp.mybatis.PageUtils;
import com.qqkj.xm.core.entity.XmProjectMCostNouser;
import com.qqkj.xm.core.service.XmProjectMCostNouserService;
import com.qqkj.xm.core.service.XmRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * url编制采用rest风格,如对XM.xm_project_m_cost_nouser xm_project_m_cost_nouser的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProjectMCostNouser/add <br>
 *  查询: xm/xmProjectMCostNouser/list<br>
 *  模糊查询: xm/xmProjectMCostNouser/listKey<br>
 *  修改: xm/xmProjectMCostNouser/edit <br>
 *  删除: xm/xmProjectMCostNouser/del<br>
 *  批量删除: xm/xmProjectMCostNouser/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectMCostNouser 表 XM.xm_project_m_cost_nouser 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectMCostNouserController")
@RequestMapping(value="/**/xm/core/xmProjectMCostNouser")
@Api(tags={"xm_project_m_cost_nouser操作接口"})
public class XmProjectMCostNouserController {
	
	static Log logger=LogFactory.getLog(XmProjectMCostNouserController.class);
	
	@Autowired
	private XmProjectMCostNouserService xmProjectMCostNouserService;
	 

	@Autowired
	XmRecordService xmRecordService;
 
	
	@ApiOperation( value = "查询xm_project_m_cost_nouser信息列表",notes="listXmProjectMCostNouser,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="userid",value="用户编号",required=false),
		@ApiImplicitParam(name="createTime",value="创建时间",required=false),
		@ApiImplicitParam(name="sendCostTime",value="费用发放时间",required=false),
		@ApiImplicitParam(name="username",value="用户名称",required=false),
		@ApiImplicitParam(name="projectName",value="项目名称",required=false),
		@ApiImplicitParam(name="remark",value="备注",required=false),
		@ApiImplicitParam(name="taskId",value="任务编号",required=false),
		@ApiImplicitParam(name="taskName",value="任务名称",required=false),
		@ApiImplicitParam(name="subjectId",value="科目编号",required=false),
		@ApiImplicitParam(name="bizzStartDate",value="费用归属周期开始日期",required=false),
		@ApiImplicitParam(name="bizzEndDate",value="费用归属周期结束日期",required=false),
		@ApiImplicitParam(name="bizProcInstId",value="当前流程实例编号",required=false),
		@ApiImplicitParam(name="bizFlowState",value="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",required=false),
		@ApiImplicitParam(name="projectPhaseId",value="项目计划阶段编号",required=false),
		@ApiImplicitParam(name="actCostAmount",value="实际成本金额",required=false),
		@ApiImplicitParam(name="costType",value="成本类型0非人力1内部人力2外购人力",required=false),
		@ApiImplicitParam(name="bizMonth",value="业务归属月份yyyy-mm",required=false),
		@ApiImplicitParam(name="bizDate",value="业务归属日期yyyy-mm-dd",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectMCostNouser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectMCostNouser( @RequestParam Map<String,Object> xmProjectMCostNouser){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectMCostNouser, "ids");
		PageUtils.startPage(xmProjectMCostNouser);
		List<Map<String,Object>>	xmProjectMCostNouserList = xmProjectMCostNouserService.selectListMapByWhere(xmProjectMCostNouser);	//列出XmProjectMCostNouser列表
		PageUtils.responePage(m, xmProjectMCostNouserList);
		m.put("data",xmProjectMCostNouserList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
	
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectMCostNouser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listSum",method=RequestMethod.GET)
	public Map<String,Object> listSum( @RequestParam Map<String,Object> xmProjectMCostNouser){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectMCostNouser, "ids");
		PageUtils.startPage(xmProjectMCostNouser);
		List<Map<String,Object>>	xmProjectMCostNouserList = xmProjectMCostNouserService.listSum(xmProjectMCostNouser);	//列出xmProjectMCostNouser列表
		PageUtils.responePage(m, xmProjectMCostNouserList);
		m.put("data",xmProjectMCostNouserList);
		Tips tips=new Tips("查询成功");
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
			
			this.xmProjectMCostNouserService.processApprova(flowVars);
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
	/***/
	@ApiOperation( value = "新增一条xm_project_m_cost_nouser信息",notes="addXmProjectMCostNouser,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectMCostNouser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectMCostNouser(@RequestBody XmProjectMCostNouser xmProjectMCostNouser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectMCostNouser.getId())) {
				xmProjectMCostNouser.setId(xmProjectMCostNouserService.createKey("id"));
			}else{
				 XmProjectMCostNouser xmProjectMCostNouserQuery = new  XmProjectMCostNouser(xmProjectMCostNouser.getId());
				if(xmProjectMCostNouserService.countByWhere(xmProjectMCostNouserQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmProjectMCostNouserService.insert(xmProjectMCostNouser);
			m.put("data",xmProjectMCostNouser);
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
	
	
	/** */
	@ApiOperation( value = "删除一条xm_project_m_cost_nouser信息",notes="delXmProjectMCostNouser,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectMCostNouser(@RequestBody XmProjectMCostNouser xmProjectMCostNouser){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectMCostNouserService.deleteByPk(xmProjectMCostNouser);
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
	@ApiOperation( value = "根据主键修改一条xm_project_m_cost_nouser信息",notes="editXmProjectMCostNouser")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectMCostNouser.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectMCostNouser(@RequestBody XmProjectMCostNouser xmProjectMCostNouser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectMCostNouserService.updateByPk(xmProjectMCostNouser);
			m.put("data",xmProjectMCostNouser);
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
	@ApiOperation( value = "根据主键列表批量删除xm_project_m_cost_nouser信息",notes="batchDelXmProjectMCostNouser,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectMCostNouser(@RequestBody List<XmProjectMCostNouser> xmProjectMCostNousers) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectMCostNousers.size()+"条数据"); 
		try{ 
			xmProjectMCostNouserService.batchDelete(xmProjectMCostNousers);
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
	public Map<String,Object> batchEditXmProjectMCostNouser(@RequestBody List<XmProjectMCostNouser> xmProjectMCostNousers) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增"+xmProjectMCostNousers.size()+"条数据"); 
		try{ 
			xmProjectMCostNousers.forEach(g->{
				g.setId(xmProjectMCostNouserService.createKey("id")); 
			});
			
			BigDecimal budgetCostUser=BigDecimal.ZERO;
			String projectId=null;
			BigDecimal zero=BigDecimal.ZERO;  
			List<String> excludeIds=new ArrayList<>();
			for (XmProjectMCostNouser costUser : xmProjectMCostNousers) {
				excludeIds.add(costUser.getId());
				projectId=costUser.getProjectId(); 
				budgetCostUser=budgetCostUser.add(NumberUtil.getBigDecimal(costUser.getActCostAmount(),zero)); 
			}
			Tips judgetTips=xmProjectMCostNouserService.judgetBudget(projectId, budgetCostUser,excludeIds);
			if(judgetTips.isOk()) {     
				xmProjectMCostNouserService.batchUpdate(xmProjectMCostNousers);
				for (XmProjectMCostNouser xmProjectMCostNouser : xmProjectMCostNousers) {
					xmRecordService.addXmCostRecord(xmProjectMCostNouser.getProjectId(), xmProjectMCostNouser.getId(), "项目-成本-非人力-修改", "修改成本额"+xmProjectMCostNouser.getActCostAmount(),JSON.toJSONString(xmProjectMCostNouser),null);
				}
				m.put("data", xmProjectMCostNousers);
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
	public Map<String,Object> batchAddXmProjectMCostNouser(@RequestBody List<XmProjectMCostNouser> xmProjectMCostNousers) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增"+xmProjectMCostNousers.size()+"条数据"); 
		try{ 
			xmProjectMCostNousers.forEach(g->{
				g.setId(xmProjectMCostNouserService.createKey("id")); 
			});
			
			BigDecimal budgetCostUser=BigDecimal.ZERO;
			String projectId=null;
			BigDecimal zero=BigDecimal.ZERO;  
			for (XmProjectMCostNouser costUser : xmProjectMCostNousers) {
				projectId=costUser.getProjectId(); 
				budgetCostUser=budgetCostUser.add(NumberUtil.getBigDecimal(costUser.getActCostAmount(),zero)); 
			}
			Tips judgetTips=xmProjectMCostNouserService.judgetBudget(projectId, budgetCostUser,null);
			if(judgetTips.isOk()) {     
				xmProjectMCostNouserService.batchInsert(xmProjectMCostNousers);
				for (XmProjectMCostNouser xmProjectMCostNouser : xmProjectMCostNousers) {
					xmRecordService.addXmCostRecord(xmProjectMCostNouser.getProjectId(), xmProjectMCostNouser.getId(), "项目-成本-非人力-增加", "增加成本额"+xmProjectMCostNouser.getActCostAmount(),JSON.toJSONString(xmProjectMCostNouser),null);
				}
				m.put("data", xmProjectMCostNousers);
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
}
