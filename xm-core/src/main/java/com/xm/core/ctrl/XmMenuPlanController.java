package com.xm.core.ctrl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mdp.core.entity.Result;
import com.mdp.core.entity.Tips;
import com.mdp.core.query.QueryTools;
import com.mdp.core.utils.RequestUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmBranchStateHis;
import com.xm.core.entity.XmMenuPlan;
import com.xm.core.service.XmMenuPlanService;
import com.xm.core.service.push.XmMenuPushMsgService;
import com.xm.core.vo.XmMenuPlanVo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;
/**
 * url编制采用rest风格,如对XM.xm_menu_plan 功能计划表,无需前端维护，所有数据由汇总统计得出的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmMenuPlan/add <br>
 *  查询: xm/xmMenuPlan/list<br>
 *  模糊查询: xm/xmMenuPlan/listKey<br>
 *  修改: xm/xmMenuPlan/edit <br>
 *  删除: xm/xmMenuPlan/del<br>
 *  批量删除: xm/xmMenuPlan/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmMenuPlan 表 XM.xm_menu_plan 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmMenuPlanController")
@RequestMapping(value="/**/xm/core/xmMenuPlan")
@Api(tags={"功能计划表,无需前端维护，所有数据由汇总统计得出操作接口"})
public class XmMenuPlanController {
	
	static Log logger=LogFactory.getLog(XmMenuPlanController.class);
	
	@Autowired
	private XmMenuPlanService xmMenuPlanService;
	 
	@Autowired
    XmMenuPushMsgService pushMsgService ;
 
	
	@ApiOperation( value = "查询功能计划表,无需前端维护，所有数据由汇总统计得出信息列表",notes="listXmMenuPlan,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="projectName",value="项目名称",required=false),
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
		@ApiImplicitParam(name="testCases",value="测试案例总数",required=false),
		@ApiImplicitParam(name="execCases",value="测试中案例总数",required=false),
		@ApiImplicitParam(name="designCases",value="设计中案例总数",required=false),
		@ApiImplicitParam(name="finishCases",value="完成案例总数",required=false),
		@ApiImplicitParam(name="iterationCnt",value="关联迭代数",required=false),
		@ApiImplicitParam(name="taskCnt",value="任务数",required=false),
		@ApiImplicitParam(name="finishTaskCnt",value="完成的任务数",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMenuPlan.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Result listXmMenuPlan(@ApiIgnore @RequestParam Map<String,Object> params){
		 
		RequestUtils.transformArray(params, "ids");
		RequestUtils.transformArray(params, "tagIdList");		
		IPage page=QueryTools.initPage(params);
		QueryWrapper<XmMenuPlan> qw = QueryTools.initQueryWrapper(XmMenuPlan.class , params);
		List<Map<String,Object>> datas = xmMenuPlanService.selectListMapByWhere(page,qw,params);
			return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());	//列出XmMenuPlan列表
		
	}
	
 
	
	/***/
	@ApiOperation( value = "新增一条功能计划表,无需前端维护，所有数据由汇总统计得出信息",notes="addXmMenuPlan,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMenuPlan.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	//@HasQx(value = "xm_core_xmMenuPlan_add",name = "新增需求计划",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result addXmMenuPlan(@RequestBody XmMenuPlan xmMenuPlan) {

			if(xmMenuPlanService.countByWhere(xmMenuPlan)>0){
				tips.setFailureMsg("编号重复，请修改编号再提交");
				m.put("tips", tips);
				return m;
			}
			xmMenuPlanService.insert(xmMenuPlan);
			return Result.ok();
	}
	
	
	/***/
	@ApiOperation( value = "删除一条功能计划表,无需前端维护，所有数据由汇总统计得出信息",notes="delXmMenuPlan,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	//@HasQx(value = "xm_core_xmMenuPlan_del",name = "删除需求计划",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Result delXmMenuPlan(@RequestBody XmMenuPlan xmMenuPlan){
		 
			xmMenuPlanService.deleteByPk(xmMenuPlan);
			User user = LoginUtils.getCurrentUserInfo();
			pushMsgService.pushMenuRelUsersMsg(user.getBranchId(), xmMenuPlan.getMenuId(), user.getUserid(), user.getUsername(), xmMenuPlan.getMenuName()+"相关计划删除");
		return Result.ok();		
	}
	 
	
	/***/
	@ApiOperation( value = "根据主键修改一条功能计划表,无需前端维护，所有数据由汇总统计得出信息",notes="editXmMenuPlan")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMenuPlan.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	//@HasQx(value = "xm_core_xmMenuPlan_edit",name = "修改需求计划",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Result editXmMenuPlan(@RequestBody XmMenuPlan xmMenuPlan) {
		 	
			xmMenuPlanService.updateByPk(xmMenuPlan); 
			User user = LoginUtils.getCurrentUserInfo();
			pushMsgService.pushMenuRelUsersMsg(user.getBranchId(), xmMenuPlan.getMenuId(), user.getUserid(), user.getUsername(),  user.getUsername()+"对需求【"+xmMenuPlan.getMenuName()+"】相关计划进行调整，需求负责人为【"+xmMenuPlan.getChargeUsername()+"】");
		return Result.ok();
	}
	
	

	
	/***/
	@ApiOperation( value = "根据主键列表批量删除功能计划表,无需前端维护，所有数据由汇总统计得出信息",notes="batchDelXmMenuPlan,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	//@HasQx(value = "xm_core_xmMenuPlan_batchDel",name = "批量删除需求计划",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Result batchDelXmMenuPlan(@RequestBody List<XmMenuPlan> xmMenuPlans) {
		 
			xmMenuPlanService.batchDelete(xmMenuPlans);
		return Result.ok();		
	} 
	@ApiOperation( value = "根据主键列表批量删除功能计划表,无需前端维护，所有数据由汇总统计得出信息",notes="batchEditXmMenuPlan,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	//@HasQx(value = "xm_core_xmMenuPlan_batchEdit",name = "批量修改需求计划",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/batchEdit",method=RequestMethod.POST)
	public Result batchEditXmMenuPlan(@RequestBody List<XmMenuPlan> xmMenuPlans) {
		 
			xmMenuPlanService.batchUpdate(xmMenuPlans);
			User user = LoginUtils.getCurrentUserInfo();

			for (XmMenuPlan xmMenuPlan : xmMenuPlans) {
				pushMsgService.pushMenuRelUsersMsg(user.getBranchId(), xmMenuPlan.getMenuId(), user.getUserid(), user.getUsername(),  user.getUsername()+"对需求【"+xmMenuPlan.getMenuName()+"】相关计划进行调整，需求负责人为【"+xmMenuPlan.getChargeUsername()+"】");
			}
		return Result.ok();		
	} 
	@ApiOperation( value = "根据主键列表批量删除功能计划表,无需前端维护，所有数据由汇总统计得出信息",notes="batchEditXmMenuPlan,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	//@HasQx(value = "xm_core_xmMenuPlan_batchAddPlanByProjectIdAndMenuList",name = "由分配到项目的需求创建需求计划",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/batchAddPlanByProjectIdAndMenuList",method=RequestMethod.POST)
	public Result batchAddPlanByProjectIdAndMenuList(@RequestBody XmMenuPlanVo vo) {
	 	xmMenuPlanService.batchAddPlanByProjectIdAndMenuList(vo.getProjectId(), vo.getProjectName(), vo.getXmMenus());
		return Result.ok();		
	} 	 

	@ApiOperation( value = "计算bug、task、测试案例、等数据",notes="loadTasksToXmMenuPlan")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	//@HasQx(value = "xm_core_xmMenuPlan_loadTasksToXmMenuPlan",name = "计算需求对应的bug、task、测试案例等数据",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/loadTasksToXmMenuPlan",method=RequestMethod.POST)
	public Result loadTasksToXmMenuPlan(@RequestBody Map<String,Object> params) {
 
			int i= xmMenuPlanService.loadTasksToXmMenuPlan((String) params.get("projectId"));
		return Result.ok();		
	}  
}
