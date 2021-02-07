package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.core.entity.XmProjectGroupState;
import com.xm.core.service.XmProjectGroupStateService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url编制采用rest风格,如对XM.xm_project_group_state 功能状态表,无需前端维护，所有数据由汇总统计得出的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmProjectGroupState/add <br>
 *  查询: core/xmProjectGroupState/list<br>
 *  模糊查询: core/xmProjectGroupState/listKey<br>
 *  修改: core/xmProjectGroupState/edit <br>
 *  删除: core/xmProjectGroupState/del<br>
 *  批量删除: core/xmProjectGroupState/batchDel<br>
 * 组织 com.qqkj  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmProjectGroupState 表 XM.xm_project_group_state 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectGroupStateController")
@RequestMapping(value="/**/core/xmProjectGroupState")
@Api(tags={"功能状态表,无需前端维护，所有数据由汇总统计得出操作接口"})
public class XmProjectGroupStateController {
	
	static Log logger=LogFactory.getLog(XmProjectGroupStateController.class);
	
	@Autowired
	private XmProjectGroupStateService xmProjectGroupStateService;
	 
		
 
	
	@ApiOperation( value = "查询功能状态表,无需前端维护，所有数据由汇总统计得出信息列表",notes="listXmProjectGroupState,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="planStartTime",value="开始时间",required=false),
		@ApiImplicitParam(name="planEndTime",value="结束时间",required=false),
		@ApiImplicitParam(name="actStartTime",value="实际开始时间",required=false),
		@ApiImplicitParam(name="actEndTime",value="实际结束时间",required=false),
		@ApiImplicitParam(name="planWorkload",value="计划工作量，根据关联任务汇总",required=false),
		@ApiImplicitParam(name="actWorkload",value="实际工作量，根据关联任务汇总",required=false),
		@ApiImplicitParam(name="planCostAmount",value="计划成本，根据关联任务汇总",required=false),
		@ApiImplicitParam(name="actCostAmount",value="实际成本金额根据关联任务汇总",required=false),
		@ApiImplicitParam(name="finishRate",value="总体完成比例0-100之间,根据taskType进行汇总",required=false),
		@ApiImplicitParam(name="demandRate",value="需求完成率0-100之间,根据taskType进行汇总",required=false),
		@ApiImplicitParam(name="designRate",value="设计完成率0-100之间,根据taskType进行汇总",required=false),
		@ApiImplicitParam(name="devRate",value="开发完成率0-100之间,根据taskType进行汇总",required=false),
		@ApiImplicitParam(name="uatRate",value="uat测试完成率0-100之间,根据taskType进行汇总",required=false),
		@ApiImplicitParam(name="sitRate",value="sit测试完成率0-100之间,根据taskType进行汇总",required=false),
		@ApiImplicitParam(name="ctime",value="创建时间",required=false),
		@ApiImplicitParam(name="calcTime",value="汇总时间",required=false),
		@ApiImplicitParam(name="planWorkhours",value="工时数",required=false),
		@ApiImplicitParam(name="planWorkerCnt",value="总人数",required=false),
		@ApiImplicitParam(name="closedBugs",value="总关闭bugs",required=false),
		@ApiImplicitParam(name="activeBugs",value="激活bugs",required=false),
		@ApiImplicitParam(name="confirmedBugs",value="已确认bugs总数",required=false),
		@ApiImplicitParam(name="resolvedBugs",value="已解决bugs总数",required=false),
		@ApiImplicitParam(name="testCases",value="测试案例总数",required=false),
		@ApiImplicitParam(name="execCases",value="测试中案例总数",required=false),
		@ApiImplicitParam(name="designCases",value="设计中案例总数",required=false),
		@ApiImplicitParam(name="finishCases",value="完成案例总数",required=false),
		@ApiImplicitParam(name="iterationCnt",value="关联迭代数",required=false),
		@ApiImplicitParam(name="taskCnt",value="任务数",required=false),
		@ApiImplicitParam(name="finishTaskCnt",value="完成的任务数",required=false),
		@ApiImplicitParam(name="bizDate",value="业务日期yyyy-MM-dd字符串",required=false),
		@ApiImplicitParam(name="bugCnt",value="bug总数",required=false),
		@ApiImplicitParam(name="groupId",value="团队编号",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="projectName",value="项目名称",required=false),
		@ApiImplicitParam(name="groupName",value="团队名称",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectGroupState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectGroupState( @RequestParam Map<String,Object> xmProjectGroupState){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectGroupState, "ids");
		PageUtils.startPage(xmProjectGroupState);
		List<Map<String,Object>>	xmProjectGroupStateList = xmProjectGroupStateService.selectListMapByWhere(xmProjectGroupState);	//列出XmProjectGroupState列表
		PageUtils.responePage(m, xmProjectGroupStateList);
		m.put("data",xmProjectGroupStateList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 

	@ApiOperation( value = "计算bug、task、测试案例、等数据",notes="loadTasksToXmProjectGroupState")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/loadTasksToXmProjectGroupState",method=RequestMethod.POST)
	public Map<String,Object> loadTasksToXmProjectGroupState(@RequestBody Map<String,Object> params) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改数据"); 
		try{ 
			int i= xmProjectGroupStateService.loadTasksToXmProjectGroupState((String) params.get("projectId"));
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
	@ApiOperation( value = "新增一条功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes="addXmProjectGroupState,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectGroupState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectGroupState(@RequestBody XmProjectGroupState xmProjectGroupState) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectGroupState.getId())) {
				xmProjectGroupState.setId(xmProjectGroupStateService.createKey("id"));
			}else{
				 XmProjectGroupState xmProjectGroupStateQuery = new  XmProjectGroupState(xmProjectGroupState.getId());
				if(xmProjectGroupStateService.countByWhere(xmProjectGroupStateQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmProjectGroupStateService.insert(xmProjectGroupState);
			m.put("data",xmProjectGroupState);
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
	@ApiOperation( value = "删除一条功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes="delXmProjectGroupState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectGroupState(@RequestBody XmProjectGroupState xmProjectGroupState){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectGroupStateService.deleteByPk(xmProjectGroupState);
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
	@ApiOperation( value = "根据主键修改一条功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes="editXmProjectGroupState")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectGroupState.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectGroupState(@RequestBody XmProjectGroupState xmProjectGroupState) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectGroupStateService.updateByPk(xmProjectGroupState);
			m.put("data",xmProjectGroupState);
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
	@ApiOperation( value = "根据主键列表批量删除功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes="batchDelXmProjectGroupState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectGroupState(@RequestBody List<XmProjectGroupState> xmProjectGroupStates) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectGroupStates.size()+"条数据"); 
		try{ 
			xmProjectGroupStateService.batchDelete(xmProjectGroupStates);
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
