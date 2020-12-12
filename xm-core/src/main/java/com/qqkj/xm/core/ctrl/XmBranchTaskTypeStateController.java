package com.qqkj.xm.core.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qqkj.mdp.core.context.ContextHolder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.qqkj.mdp.mybatis.PageUtils; 
import com.qqkj.mdp.core.utils.RequestUtils;
import com.qqkj.mdp.core.entity.Tips;
import com.qqkj.mdp.core.err.BizException;
import com.qqkj.mdp.core.service.SequenceService;
import com.qqkj.xm.core.service.XmBranchTaskTypeStateService;
import com.qqkj.xm.core.entity.XmBranchState;
import com.qqkj.xm.core.entity.XmBranchTaskTypeState;
/**
 * url编制采用rest风格,如对XM.xm_branch_task_type_state 按机构编号任务类型汇总的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmBranchTaskTypeState/add <br>
 *  查询: core/xmBranchTaskTypeState/list<br>
 *  模糊查询: core/xmBranchTaskTypeState/listKey<br>
 *  修改: core/xmBranchTaskTypeState/edit <br>
 *  删除: core/xmBranchTaskTypeState/del<br>
 *  批量删除: core/xmBranchTaskTypeState/batchDel<br>
 * 组织 com.qqkj  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmBranchTaskTypeState 表 XM.xm_branch_task_type_state 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmBranchTaskTypeStateController")
@RequestMapping(value="/**/core/xmBranchTaskTypeState")
@Api(tags={"按机构编号任务类型汇总操作接口"})
public class XmBranchTaskTypeStateController {
	
	static Log logger=LogFactory.getLog(XmBranchTaskTypeStateController.class);
	
	@Autowired
	private XmBranchTaskTypeStateService xmBranchTaskTypeStateService;
	 
		
 
	
	@ApiOperation( value = "查询按机构编号任务类型汇总信息列表",notes="listXmBranchTaskTypeState,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="taskType",value="任务类型",required=false),
		@ApiImplicitParam(name="planWorkload",value="工作量",required=false),
		@ApiImplicitParam(name="planAmount",value="预算金额",required=false),
		@ApiImplicitParam(name="actWorkload",value="实际完成工作量",required=false),
		@ApiImplicitParam(name="actAmount",value="实际完成金额",required=false),
		@ApiImplicitParam(name="branchId",value="机构编号",required=false),
		@ApiImplicitParam(name="bizDate",value="业务日期yyyy-MM-dd型",required=false),
		@ApiImplicitParam(name="calcTime",value="计算日期",required=false),
		@ApiImplicitParam(name="planOutUserAt",value="外购资金预算",required=false),
		@ApiImplicitParam(name="planInnerUserAt",value="内购资金预算",required=false),
		@ApiImplicitParam(name="actOutUserAt",value="实际外购成本",required=false),
		@ApiImplicitParam(name="actInnerUserAt",value="实际内购成本",required=false),
		@ApiImplicitParam(name="planOutUserWorkload",value="计划外购工作量",required=false),
		@ApiImplicitParam(name="planInnerUserWorkload",value="计划内购工作量",required=false),
		@ApiImplicitParam(name="actOutUserWorkload",value="实际外购工作量",required=false),
		@ApiImplicitParam(name="actInnerUserWorkload",value="实际内购工作量",required=false),
		@ApiImplicitParam(name="planNouserAt",value="计划非人力成本",required=false),
		@ApiImplicitParam(name="actNouserAt",value="实际非人力成本",required=false),
		@ApiImplicitParam(name="branchName",value="机构名称",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmBranchTaskTypeState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmBranchTaskTypeState( @RequestParam Map<String,Object> xmBranchTaskTypeState){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmBranchTaskTypeState, "ids");
		PageUtils.startPage(xmBranchTaskTypeState);
		List<Map<String,Object>>	xmBranchTaskTypeStateList = xmBranchTaskTypeStateService.selectListMapByWhere(xmBranchTaskTypeState);	//列出XmBranchTaskTypeState列表
		PageUtils.responePage(m, xmBranchTaskTypeStateList);
		m.put("data",xmBranchTaskTypeStateList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	@ApiOperation( value = "从项目任务类型汇总表汇总数据到机构任务类型汇总表",notes="")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/loadProjectTaskTypeStateToXmBranchTaskTypeState",method=RequestMethod.POST)
	public Map<String,Object> loadProjectTaskTypeStateToXmBranchTaskTypeState(@RequestBody XmBranchState xmBranchState){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一个机构数据");
		try{
			if(StringUtils.isEmpty(xmBranchState.getBranchId())) {
				tips.setFailureMsg("机构编号branchId必填");
			}else {
	
				xmBranchTaskTypeStateService.loadProjectTaskTypeStateToXmBranchTaskTypeState(xmBranchState.getBranchId());
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
	@ApiOperation( value = "新增一条按机构编号任务类型汇总信息",notes="addXmBranchTaskTypeState,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmBranchTaskTypeState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmBranchTaskTypeState(@RequestBody XmBranchTaskTypeState xmBranchTaskTypeState) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmBranchTaskTypeState.getId())) {
				xmBranchTaskTypeState.setId(xmBranchTaskTypeStateService.createKey("id"));
			}else{
				 XmBranchTaskTypeState xmBranchTaskTypeStateQuery = new  XmBranchTaskTypeState(xmBranchTaskTypeState.getId());
				if(xmBranchTaskTypeStateService.countByWhere(xmBranchTaskTypeStateQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmBranchTaskTypeStateService.insert(xmBranchTaskTypeState);
			m.put("data",xmBranchTaskTypeState);
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
	@ApiOperation( value = "删除一条按机构编号任务类型汇总信息",notes="delXmBranchTaskTypeState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmBranchTaskTypeState(@RequestBody XmBranchTaskTypeState xmBranchTaskTypeState){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmBranchTaskTypeStateService.deleteByPk(xmBranchTaskTypeState);
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
	@ApiOperation( value = "根据主键修改一条按机构编号任务类型汇总信息",notes="editXmBranchTaskTypeState")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmBranchTaskTypeState.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmBranchTaskTypeState(@RequestBody XmBranchTaskTypeState xmBranchTaskTypeState) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmBranchTaskTypeStateService.updateByPk(xmBranchTaskTypeState);
			m.put("data",xmBranchTaskTypeState);
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
	@ApiOperation( value = "根据主键列表批量删除按机构编号任务类型汇总信息",notes="batchDelXmBranchTaskTypeState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmBranchTaskTypeState(@RequestBody List<XmBranchTaskTypeState> xmBranchTaskTypeStates) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmBranchTaskTypeStates.size()+"条数据"); 
		try{ 
			xmBranchTaskTypeStateService.batchDelete(xmBranchTaskTypeStates);
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
