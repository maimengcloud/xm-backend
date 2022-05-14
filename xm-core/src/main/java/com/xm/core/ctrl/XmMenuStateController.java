package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.core.entity.XmMenuState;
import com.xm.core.service.XmMenuStateService;
import com.xm.core.vo.XmMenuStateVo;
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
 * url编制采用rest风格,如对XM.xm_menu_state 功能状态表,无需前端维护，所有数据由汇总统计得出的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmMenuState/add <br>
 *  查询: xm/xmMenuState/list<br>
 *  模糊查询: xm/xmMenuState/listKey<br>
 *  修改: xm/xmMenuState/edit <br>
 *  删除: xm/xmMenuState/del<br>
 *  批量删除: xm/xmMenuState/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmMenuState 表 XM.xm_menu_state 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmMenuStateController")
@RequestMapping(value="/**/xm/core/xmMenuState")
@Api(tags={"功能状态表,无需前端维护，所有数据由汇总统计得出操作接口"})
public class XmMenuStateController {
	
	static Log logger=LogFactory.getLog(XmMenuStateController.class);
	
	@Autowired
	private XmMenuStateService xmMenuStateService;
	 
		
 
	
	@ApiOperation( value = "查询功能状态表,无需前端维护，所有数据由汇总统计得出信息列表",notes="listXmMenuState,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="menuId",value="功能编号",required=false),
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
		@ApiImplicitParam(name="onlineStatus",value="上线状态0未上线1上线成功",required=false),
		@ApiImplicitParam(name="onlineTime",value="上线时间",required=false),
		@ApiImplicitParam(name="planStatus",value="计划状态0初始1正常2暂停3延误4结束5关闭",required=false),
		@ApiImplicitParam(name="chargeUserid",value="负责人编号",required=false),
		@ApiImplicitParam(name="chargeUsername",value="负责人姓名",required=false),
		@ApiImplicitParam(name="menuStatus",value="状态0初始1设计中2开发中3测试中4uat测试2已上线3已下线4已删除",required=false),
		@ApiImplicitParam(name="ctime",value="创建时间",required=false),
		@ApiImplicitParam(name="ltime",value="更新时间",required=false),
		@ApiImplicitParam(name="cuserid",value="创建人编号",required=false),
		@ApiImplicitParam(name="cusername",value="创建人姓名",required=false),
		@ApiImplicitParam(name="calcTime",value="汇总时间",required=false),
		@ApiImplicitParam(name="menuName",value="菜单名字",required=false),
		@ApiImplicitParam(name="planWorkhours",value="工时数",required=false),
		@ApiImplicitParam(name="planWorkerCnt",value="总人数",required=false),
		@ApiImplicitParam(name="closedBugs",value="总关闭bugs",required=false),
		@ApiImplicitParam(name="activeBugs",value="激活bugs",required=false),
		@ApiImplicitParam(name="confirmedBugs",value="已确认bugs总数",required=false),
		@ApiImplicitParam(name="resolvedBugs",value="已解决bugs总数",required=false),
		@ApiImplicitParam(name="productId",value="产品编号",required=false),
		@ApiImplicitParam(name="productName",value="产品名称",required=false),
		@ApiImplicitParam(name="testCases",value="测试案例总数",required=false),
		@ApiImplicitParam(name="execCases",value="测试中案例总数",required=false),
		@ApiImplicitParam(name="designCases",value="设计中案例总数",required=false),
		@ApiImplicitParam(name="finishCases",value="完成案例总数",required=false),
		@ApiImplicitParam(name="projectCnt",value="关联项目数",required=false),
		@ApiImplicitParam(name="iterationCnt",value="关联迭代数",required=false),
		@ApiImplicitParam(name="taskCnt",value="任务数",required=false),
		@ApiImplicitParam(name="finishTaskCnt",value="完成的任务数",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmMenuState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmMenuState( @RequestParam Map<String,Object> xmMenuState){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmMenuState, "ids");
		PageUtils.startPage(xmMenuState);
		List<Map<String,Object>>	xmMenuStateList = xmMenuStateService.selectListMapByWhere(xmMenuState);	//列出XmMenuState列表
		PageUtils.responePage(m, xmMenuStateList);
		m.put("data",xmMenuStateList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	/***/
	@ApiOperation( value = "新增一条功能计划表,无需前端维护，所有数据由汇总统计得出信息",notes="addXmMenuState,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMenuState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmMenuState(@RequestBody XmMenuState xmMenuState) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(xmMenuStateService.countByWhere(xmMenuState)>0){
				tips.setFailureMsg("编号重复，请修改编号再提交");
				m.put("tips", tips);
				return m;
			}
			xmMenuStateService.insert(xmMenuState);
			m.put("data",xmMenuState);
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
	@ApiOperation( value = "删除一条功能计划表,无需前端维护，所有数据由汇总统计得出信息",notes="delXmMenuState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmMenuState(@RequestBody XmMenuState xmMenuState){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmMenuStateService.deleteByPk(xmMenuState);
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
	@ApiOperation( value = "根据主键修改一条功能计划表,无需前端维护，所有数据由汇总统计得出信息",notes="editXmMenuState")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMenuState.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmMenuState(@RequestBody XmMenuState xmMenuState) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmMenuStateService.updateByPk(xmMenuState);
			m.put("data",xmMenuState);
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
	@ApiOperation( value = "根据主键列表批量删除功能计划表,无需前端维护，所有数据由汇总统计得出信息",notes="batchDelXmMenuState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmMenuState(@RequestBody List<XmMenuState> xmMenuStates) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmMenuStates.size()+"条数据"); 
		try{ 
			xmMenuStateService.batchDelete(xmMenuStates);
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
	@ApiOperation( value = "根据主键列表批量删除功能计划表,无需前端维护，所有数据由汇总统计得出信息",notes="batchEditXmMenuState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchEdit",method=RequestMethod.POST)
	public Map<String,Object> batchEditXmMenuState(@RequestBody List<XmMenuState> xmMenuStates) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改"+xmMenuStates.size()+"条数据"); 
		try{ 
			xmMenuStateService.batchUpdate(xmMenuStates);
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
	@ApiOperation( value = "根据主键列表批量删除功能计划表,无需前端维护，所有数据由汇总统计得出信息",notes="batchEditXmMenuState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchAddStateByProductIdAndMenuList",method=RequestMethod.POST)
	public Map<String,Object> batchAddStateByProductIdAndMenuList(@RequestBody XmMenuStateVo vo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改"+vo.getXmMenus().size()+"条数据"); 
		try{ 
			tips = xmMenuStateService.batchAddStateByProductIdAndMenuList(vo.getProductId(), vo.getProductName(), vo.getXmMenus());
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
	
	@ApiOperation( value = "计算bug、task、测试案例、等数据",notes="loadTasksToXmMenuState")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/loadTasksToXmMenuState",method=RequestMethod.POST)
	public Map<String,Object> loadTasksToXmMenuState(@RequestBody Map<String,Object> params) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改数据"); 
		try{ 
			int i= xmMenuStateService.loadTasksToXmMenuState((String) params.get("productId"));
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
