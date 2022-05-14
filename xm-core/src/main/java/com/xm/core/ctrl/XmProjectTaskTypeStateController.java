package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.core.entity.XmProjectTaskTypeState;
import com.xm.core.service.XmProjectTaskTypeStateService;
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
 * url编制采用rest风格,如对XM.xm_project_task_type_state 按任务类型汇总的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmProjectTaskTypeState/add <br>
 *  查询: core/xmProjectTaskTypeState/list<br>
 *  模糊查询: core/xmProjectTaskTypeState/listKey<br>
 *  修改: core/xmProjectTaskTypeState/edit <br>
 *  删除: core/xmProjectTaskTypeState/del<br>
 *  批量删除: core/xmProjectTaskTypeState/batchDel<br>
 * 组织 com.qqkj  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmProjectTaskTypeState 表 XM.xm_project_task_type_state 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectTaskTypeStateController")
@RequestMapping(value="/**/core/xmProjectTaskTypeState")
@Api(tags={"按任务类型汇总操作接口"})
public class XmProjectTaskTypeStateController {
	
	static Log logger=LogFactory.getLog(XmProjectTaskTypeStateController.class);
	
	@Autowired
	private XmProjectTaskTypeStateService xmProjectTaskTypeStateService;
	 
		
 
	
	@ApiOperation( value = "查询按任务类型汇总信息列表",notes="listXmProjectTaskTypeState,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="projectName",value="项目名称",required=false),
		@ApiImplicitParam(name="taskType",value="任务类型",required=false),
		@ApiImplicitParam(name="planWorkload",value="工作量",required=false),
		@ApiImplicitParam(name="planAmount",value="预算金额",required=false),
		@ApiImplicitParam(name="actWorkload",value="实际完成工作量",required=false),
		@ApiImplicitParam(name="actAmount",value="实际完成金额",required=false),
		@ApiImplicitParam(name="branchId",value="机构编号",required=false),
		@ApiImplicitParam(name="bizDate",value="业务日期yyyy-MM-dd型",required=false),
		@ApiImplicitParam(name="calcTime",value="计算日期",required=false),
		@ApiImplicitParam(name="planOuserAt",value="外购资金预算",required=false),
		@ApiImplicitParam(name="planIuserAt",value="内购资金预算",required=false),
		@ApiImplicitParam(name="actOuserAt",value="实际外购成本",required=false),
		@ApiImplicitParam(name="actIuserAt",value="实际内购成本",required=false),
		@ApiImplicitParam(name="planOuserWorkload",value="计划外购工作量",required=false),
		@ApiImplicitParam(name="planIuserWorkload",value="计划内购工作量",required=false),
		@ApiImplicitParam(name="actOuserWorkload",value="实际外购工作量",required=false),
		@ApiImplicitParam(name="actIuserWorkload",value="实际内购工作量",required=false),
		@ApiImplicitParam(name="planNouserAt",value="计划非人力成本",required=false),
		@ApiImplicitParam(name="actNouserAt",value="实际非人力成本",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectTaskTypeState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectTaskTypeState( @RequestParam Map<String,Object> xmProjectTaskTypeState){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectTaskTypeState, "ids");
		PageUtils.startPage(xmProjectTaskTypeState);
		List<Map<String,Object>>	xmProjectTaskTypeStateList = xmProjectTaskTypeStateService.selectListMapByWhere(xmProjectTaskTypeState);	//列出XmProjectTaskTypeState列表
		PageUtils.responePage(m, xmProjectTaskTypeStateList);
		m.put("data",xmProjectTaskTypeStateList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
	@ApiOperation( value = "从任务表汇总数据到项目任务类型汇总表",notes="")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/loadTasksToXmProjectTaskTypeState",method=RequestMethod.POST)
	public Map<String,Object> loadTasksToXmProjectTaskTypeState(@RequestBody XmProjectTaskTypeState xmProjectTaskTypeState){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一个项目数据");
		try{
			if(StringUtils.isEmpty(xmProjectTaskTypeState.getProjectId())) {
				tips.setFailureMsg("项目编号projectId必填");
			}else {
	
				xmProjectTaskTypeStateService.loadTasksToXmProjectTaskTypeState(xmProjectTaskTypeState.getBranchId());
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
	@ApiOperation( value = "新增一条按任务类型汇总信息",notes="addXmProjectTaskTypeState,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectTaskTypeState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectTaskTypeState(@RequestBody XmProjectTaskTypeState xmProjectTaskTypeState) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectTaskTypeState.getId())) {
				xmProjectTaskTypeState.setId(xmProjectTaskTypeStateService.createKey("id"));
			}else{
				 XmProjectTaskTypeState xmProjectTaskTypeStateQuery = new  XmProjectTaskTypeState(xmProjectTaskTypeState.getId());
				if(xmProjectTaskTypeStateService.countByWhere(xmProjectTaskTypeStateQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmProjectTaskTypeStateService.insert(xmProjectTaskTypeState);
			m.put("data",xmProjectTaskTypeState);
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
	@ApiOperation( value = "删除一条按任务类型汇总信息",notes="delXmProjectTaskTypeState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectTaskTypeState(@RequestBody XmProjectTaskTypeState xmProjectTaskTypeState){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectTaskTypeStateService.deleteByPk(xmProjectTaskTypeState);
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
	@ApiOperation( value = "根据主键修改一条按任务类型汇总信息",notes="editXmProjectTaskTypeState")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectTaskTypeState.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectTaskTypeState(@RequestBody XmProjectTaskTypeState xmProjectTaskTypeState) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectTaskTypeStateService.updateByPk(xmProjectTaskTypeState);
			m.put("data",xmProjectTaskTypeState);
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
	@ApiOperation( value = "根据主键列表批量删除按任务类型汇总信息",notes="batchDelXmProjectTaskTypeState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectTaskTypeState(@RequestBody List<XmProjectTaskTypeState> xmProjectTaskTypeStates) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectTaskTypeStates.size()+"条数据"); 
		try{ 
			xmProjectTaskTypeStateService.batchDelete(xmProjectTaskTypeStates);
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
