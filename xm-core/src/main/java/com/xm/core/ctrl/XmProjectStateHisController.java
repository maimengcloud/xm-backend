package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.core.entity.XmProjectStateHis;
import com.xm.core.service.XmProjectStateHisService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url编制采用rest风格,如对XM.xm_project_state_his 项目指标日统计表的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmProjectStateHis/add <br>
 *  查询: core/xmProjectStateHis/list<br>
 *  模糊查询: core/xmProjectStateHis/listKey<br>
 *  修改: core/xmProjectStateHis/edit <br>
 *  删除: core/xmProjectStateHis/del<br>
 *  批量删除: core/xmProjectStateHis/batchDel<br>
 * 组织 com.qqkj  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmProjectStateHis 表 XM.xm_project_state_his 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectStateHisController")
@RequestMapping(value="/**/core/xmProjectStateHis")
@Api(tags={"项目指标日统计表操作接口"})
public class XmProjectStateHisController {
	
	static Log logger=LogFactory.getLog(XmProjectStateHisController.class);
	
	@Autowired
	private XmProjectStateHisService xmProjectStateHisService;
	 
		
 
	
	@ApiOperation( value = "查询项目指标日统计表信息列表",notes="listXmProjectStateHis,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="bizDate",value="统计日期yyyy-mm-dd类型",required=false),
		@ApiImplicitParam(name="totalFileCnt",value="文件数据",required=false),
		@ApiImplicitParam(name="totalBugCnt",value="bug数目",required=false),
		@ApiImplicitParam(name="totalTaskCnt",value="任务数",required=false),
		@ApiImplicitParam(name="totalBudgetNouserAmount",value="项目总非人力预算-来自项目表",required=false),
		@ApiImplicitParam(name="projectName",value="项目名称",required=false),
		@ApiImplicitParam(name="totalStaffCnt",value="总参与人数",required=false),
		@ApiImplicitParam(name="calcTime",value="统计执行日期",required=false),
		@ApiImplicitParam(name="calcStatus",value="0-暂时的1稳定的，暂时的可以被覆盖，稳定的不允许覆盖",required=false),
		@ApiImplicitParam(name="totalCostNouserAmount",value="项目总非人力成本",required=false),
		@ApiImplicitParam(name="totalClosedBugCnt",value="已关闭bug总数",required=false),
		@ApiImplicitParam(name="totalResolvedBugCnt",value="已解决bug总数",required=false),
		@ApiImplicitParam(name="totalCompleteTaskCnt",value="已完成任务总数-来自任务表",required=false),
		@ApiImplicitParam(name="totalPhaseCnt",value="项目计划数",required=false),
		@ApiImplicitParam(name="totalCompletePhaseCnt",value="项目计划已完成数",required=false),
		@ApiImplicitParam(name="totalNeedPayAmount",value="待付款总金额",required=false),
		@ApiImplicitParam(name="totalFinishPayAmount",value="已付款总金额",required=false),
		@ApiImplicitParam(name="totalNeedColAmount",value="待收款总金额",required=false),
		@ApiImplicitParam(name="totalFinishColAmount",value="已收款总金额",required=false),
		@ApiImplicitParam(name="totalCostUserAmount",value="项目总人力成本",required=false),
		@ApiImplicitParam(name="totalBudgetInnerUserAmount",value="项目总内部人力预算-来自项目表",required=false),
		@ApiImplicitParam(name="totalPlanWorkload",value="项目总预算工作量-来自项目表",required=false),
		@ApiImplicitParam(name="totalRiskCnt",value="项目风险总数",required=false),
		@ApiImplicitParam(name="totalCompleteRiskCnt",value="已完成风险总数",required=false),
		@ApiImplicitParam(name="branchId",value="机构编号",required=false),
		@ApiImplicitParam(name="branchName",value="机构名称",required=false),
		@ApiImplicitParam(name="totalBudgetOutUserAmount",value="项目总外购人力预算-来自项目表",required=false),
		@ApiImplicitParam(name="totalCompleteWorkload",value="已完成工作量-来自计划中实际完成工作量",required=false),
		@ApiImplicitParam(name="totalCostInnerUserAmount",value="项目总内部人力成本金额",required=false),
		@ApiImplicitParam(name="totalCostOutUserAmount",value="项目总外购人力成本金额",required=false),
		@ApiImplicitParam(name="totalProgress",value="项目进度0~100之间，来自任务表",required=false),
		@ApiImplicitParam(name="totalActiveBugCnt",value="激活的bug总数",required=false),
		@ApiImplicitParam(name="totalConfirmedBugCnt",value="已解决bug总数",required=false),
		@ApiImplicitParam(name="projectStatus",value="项目状态，0-初始，1-立项中，2-执行中，3-已结项，4-暂停",required=false),
		@ApiImplicitParam(name="totalActWorkload",value="实际总工作量，来自任务表",required=false),
		@ApiImplicitParam(name="totalActOutWorkload",value="实际外购总工作量，来自任务表",required=false),
		@ApiImplicitParam(name="totalActInnerWorkload",value="实际内部总工作量，来自任务表",required=false),
		@ApiImplicitParam(name="totalTaskBudgetCostAt",value="已经分配到任务的总预算",required=false),
		@ApiImplicitParam(name="totalTaskOutCnt",value="外购任务数，来自任务表",required=false),
		@ApiImplicitParam(name="totalNeedPayCnt",value="待付款笔数",required=false),
		@ApiImplicitParam(name="totalFinishPayCnt",value="完成付款总比数",required=false),
		@ApiImplicitParam(name="totalFinishPayUserCnt",value="已付款总人数",required=false),
		@ApiImplicitParam(name="totalNeedPayUserCnt",value="待付款总人数",required=false),
		@ApiImplicitParam(name="totalPlanInnerUserWorkload",value="内部人力总工作量-应该大于或等于计划内部人力总成本",required=false),
		@ApiImplicitParam(name="totalPlanOutUserWorkload",value="外购人力总工作量-应该大于或等于计划外购人力总成本",required=false),
		@ApiImplicitParam(name="testCases",value="测试案例总数",required=false),
		@ApiImplicitParam(name="execCases",value="测试中案例总数",required=false),
		@ApiImplicitParam(name="designCases",value="设计中案例总数",required=false),
		@ApiImplicitParam(name="finishCases",value="完成案例总数",required=false),
		@ApiImplicitParam(name="iterationCnt",value="迭代数",required=false),
		@ApiImplicitParam(name="productCnt",value="产品数",required=false),
		@ApiImplicitParam(name="menuCnt",value="故事数",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectStateHis.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectStateHis( @RequestParam Map<String,Object> xmProjectStateHis){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectStateHis, "ids");
		PageUtils.startPage(xmProjectStateHis);
		List<Map<String,Object>>	xmProjectStateHisList = xmProjectStateHisService.selectListMapByWhere(xmProjectStateHis);	//列出XmProjectStateHis列表
		PageUtils.responePage(m, xmProjectStateHisList);
		m.put("data",xmProjectStateHisList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	/**
	@ApiOperation( value = "新增一条项目指标日统计表信息",notes="addXmProjectStateHis,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectStateHis.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectStateHis(@RequestBody XmProjectStateHis xmProjectStateHis) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectStateHis.getId())) {
				xmProjectStateHis.setId(xmProjectStateHisService.createKey("id"));
			}else{
				 XmProjectStateHis xmProjectStateHisQuery = new  XmProjectStateHis(xmProjectStateHis.getId());
				if(xmProjectStateHisService.countByWhere(xmProjectStateHisQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmProjectStateHisService.insert(xmProjectStateHis);
			m.put("data",xmProjectStateHis);
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
	@ApiOperation( value = "删除一条项目指标日统计表信息",notes="delXmProjectStateHis,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectStateHis(@RequestBody XmProjectStateHis xmProjectStateHis){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectStateHisService.deleteByPk(xmProjectStateHis);
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
	@ApiOperation( value = "根据主键修改一条项目指标日统计表信息",notes="editXmProjectStateHis")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectStateHis.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectStateHis(@RequestBody XmProjectStateHis xmProjectStateHis) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectStateHisService.updateByPk(xmProjectStateHis);
			m.put("data",xmProjectStateHis);
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
	@ApiOperation( value = "根据主键列表批量删除项目指标日统计表信息",notes="batchDelXmProjectStateHis,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectStateHis(@RequestBody List<XmProjectStateHis> xmProjectStateHiss) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectStateHiss.size()+"条数据"); 
		try{ 
			xmProjectStateHisService.batchDelete(xmProjectStateHiss);
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
