package com.xm.core.ctrl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mdp.core.entity.Result;
import com.mdp.core.entity.Tips;
import com.mdp.core.query.QueryTools;
import com.mdp.core.utils.RequestUtils;
import com.xm.core.entity.XmProjectTaskTypeState;
import com.xm.core.service.XmProjectTaskTypeStateService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectTaskTypeState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Result listXmProjectTaskTypeState(@ApiIgnore @RequestParam Map<String,Object> params){
		 
		RequestUtils.transformArray(params, "ids");
		QueryWrapper<XXXXXXXX> qw = QueryTools.initQueryWrapper(XXXXXXXX.class , params);
		IPage page=QueryTools.initPage(params);
		List<Map<String,Object>> datas = xmProjectTaskTypeStateService.selectListMapByWhere(page,qw,params);
			return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());	//列出XmProjectTaskTypeState列表
		
		
		
		
	}
	
	@ApiOperation( value = "从任务表汇总数据到项目任务类型汇总表",notes="")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/loadTasksToXmProjectTaskTypeState",method=RequestMethod.POST)
	public Result loadTasksToXmProjectTaskTypeState(@RequestBody XmProjectTaskTypeState xmProjectTaskTypeState){
		
		Tips tips=new Tips("成功更新一个项目数据");
		try{
			if(StringUtils.isEmpty(xmProjectTaskTypeState.getProjectId())) {
				tips.setFailureMsg("项目编号projectId必填");
			}else {
	
				xmProjectTaskTypeStateService.loadTasksToXmProjectTaskTypeState(xmProjectTaskTypeState.getBranchId());
			}
		return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());
		
	}
	
	/**
	@ApiOperation( value = "新增一条按任务类型汇总信息",notes="addXmProjectTaskTypeState,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectTaskTypeState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result addXmProjectTaskTypeState(@RequestBody XmProjectTaskTypeState xmProjectTaskTypeState) {
		
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
		
	}
	*/
	
	/**
	@ApiOperation( value = "删除一条按任务类型汇总信息",notes="delXmProjectTaskTypeState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Result delXmProjectTaskTypeState(@RequestBody XmProjectTaskTypeState xmProjectTaskTypeState){
		
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectTaskTypeStateService.deleteByPk(xmProjectTaskTypeState);
		return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());
		
	}
	 */
	
	/**
	@ApiOperation( value = "根据主键修改一条按任务类型汇总信息",notes="editXmProjectTaskTypeState")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectTaskTypeState.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Result editXmProjectTaskTypeState(@RequestBody XmProjectTaskTypeState xmProjectTaskTypeState) {
		
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectTaskTypeStateService.updateByPk(xmProjectTaskTypeState);
		
	}
	*/
	

	
	/**
	@ApiOperation( value = "根据主键列表批量删除按任务类型汇总信息",notes="batchDelXmProjectTaskTypeState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Result batchDelXmProjectTaskTypeState(@RequestBody List<XmProjectTaskTypeState> xmProjectTaskTypeStates) {
		
		Tips tips=new Tips("成功删除"+xmProjectTaskTypeStates.size()+"条数据"); 
		
			xmProjectTaskTypeStateService.batchDelete(xmProjectTaskTypeStates);
		return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());
		
	} 
	*/
}
