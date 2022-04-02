package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.core.entity.XmIterationState;
import com.xm.core.service.XmIterationStateService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url编制采用rest风格,如对XM.xm_iteration_state 迭代定义的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmIterationState/add <br>
 *  查询: core/xmIterationState/list<br>
 *  模糊查询: core/xmIterationState/listKey<br>
 *  修改: core/xmIterationState/edit <br>
 *  删除: core/xmIterationState/del<br>
 *  批量删除: core/xmIterationState/batchDel<br>
 * 组织 com.qqkj  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmIterationState 表 XM.xm_iteration_state 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmIterationStateController")
@RequestMapping(value="/**/core/xmIterationState")
@Api(tags={"迭代定义操作接口"})
public class XmIterationStateController {
	
	static Log logger=LogFactory.getLog(XmIterationStateController.class);
	
	@Autowired
	private XmIterationStateService xmIterationStateService;
	 
		
 
	
	@ApiOperation( value = "查询迭代定义信息列表",notes="listXmIterationState,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="迭代编码,主键",required=false),
		@ApiImplicitParam(name="distBudgetCost",value="已分配到任务的预算从任务表汇总而来",required=false),
		@ApiImplicitParam(name="distBudgetWorkload",value="已分配到任务的预算工作量从任务表汇总而来",required=false),
		@ApiImplicitParam(name="actCost",value="实际成本从任务表汇总而来",required=false),
		@ApiImplicitParam(name="actWorkload",value="实际工作量从任务表汇总而来",required=false),
		@ApiImplicitParam(name="actStaffNum",value="实际投入人员数",required=false),
		@ApiImplicitParam(name="finishRate",value="进度",required=false),
		@ApiImplicitParam(name="testCases",value="测试案例总数",required=false),
		@ApiImplicitParam(name="execCases",value="测试中案例总数",required=false),
		@ApiImplicitParam(name="designCases",value="设计中案例总数",required=false),
		@ApiImplicitParam(name="finishCases",value="完成案例总数",required=false),
		@ApiImplicitParam(name="projectCnt",value="关联项目数",required=false),
		@ApiImplicitParam(name="productCnt",value="关联产品数",required=false),
		@ApiImplicitParam(name="menuCnt",value="关联需求数",required=false),
		@ApiImplicitParam(name="taskCnt",value="关联任务数",required=false),
		@ApiImplicitParam(name="finishTaskCnt",value="已完成的任务数",required=false),
		@ApiImplicitParam(name="calcTime",value="计算日期",required=false),
		@ApiImplicitParam(name="iterationName",value="迭代名称",required=false),
		@ApiImplicitParam(name="budgetCost",value="预算成本",required=false),
		@ApiImplicitParam(name="budgetWorkload",value="预算工作量",required=false),
		@ApiImplicitParam(name="iterationId",value="迭代编号",required=false),
		@ApiImplicitParam(name="bizDate",value="业务日期yyyy-MM-dd字符串",required=false),
		@ApiImplicitParam(name="closedBugCnt",value="已关闭bug总数",required=false),
		@ApiImplicitParam(name="resolvedBugCnt",value="已解决bug总数",required=false),
		@ApiImplicitParam(name="activeBugCnt",value="激活的bug总数",required=false),
		@ApiImplicitParam(name="confirmedBugCnt",value="已解决bug总数",required=false),
		@ApiImplicitParam(name="bugCnt",value="bug总数",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmIterationState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmIterationState( @RequestParam Map<String,Object> xmIterationState){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmIterationState, "ids");
		PageUtils.startPage(xmIterationState);
		List<Map<String,Object>>	xmIterationStateList = xmIterationStateService.selectListMapByWhere(xmIterationState);	//列出XmIterationState列表
		PageUtils.responePage(m, xmIterationStateList);
		m.put("data",xmIterationStateList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}

	@ApiOperation( value = "计算bug、task、测试案例、等数据",notes="loadTasksToXmIterationState")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/loadTasksToXmIterationState",method=RequestMethod.POST)
	public Map<String,Object> loadTasksToXmIterationState(@RequestBody Map<String,Object> params) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改数据"); 
		try{ 
			int i= xmIterationStateService.loadTasksToXmIterationState((String) params.get("iterationId"));
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
	@ApiOperation( value = "新增一条迭代定义信息",notes="addXmIterationState,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmIterationState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmIterationState(@RequestBody XmIterationState xmIterationState) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmIterationState.getId())) {
				xmIterationState.setId(xmIterationStateService.createKey("id"));
			}else{
				 XmIterationState xmIterationStateQuery = new  XmIterationState(xmIterationState.getId());
				if(xmIterationStateService.countByWhere(xmIterationStateQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmIterationStateService.insert(xmIterationState);
			m.put("data",xmIterationState);
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
	@ApiOperation( value = "删除一条迭代定义信息",notes="delXmIterationState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmIterationState(@RequestBody XmIterationState xmIterationState){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmIterationStateService.deleteByPk(xmIterationState);
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
	@ApiOperation( value = "根据主键修改一条迭代定义信息",notes="editXmIterationState")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmIterationState.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmIterationState(@RequestBody XmIterationState xmIterationState) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmIterationStateService.updateByPk(xmIterationState);
			m.put("data",xmIterationState);
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
	@ApiOperation( value = "根据主键列表批量删除迭代定义信息",notes="batchDelXmIterationState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmIterationState(@RequestBody List<XmIterationState> xmIterationStates) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmIterationStates.size()+"条数据"); 
		try{ 
			xmIterationStateService.batchDelete(xmIterationStates);
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
