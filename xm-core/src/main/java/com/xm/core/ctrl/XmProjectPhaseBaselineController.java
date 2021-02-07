package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.core.entity.XmProjectPhaseBaseline;
import com.xm.core.service.XmProjectPhaseBaselineService;
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
 * url编制采用rest风格,如对XM.xm_project_phase_baseline xm_project_phase_baseline的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProjectPhaseBaseline/add <br>
 *  查询: xm/xmProjectPhaseBaseline/list<br>
 *  模糊查询: xm/xmProjectPhaseBaseline/listKey<br>
 *  修改: xm/xmProjectPhaseBaseline/edit <br>
 *  删除: xm/xmProjectPhaseBaseline/del<br>
 *  批量删除: xm/xmProjectPhaseBaseline/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectPhaseBaseline 表 XM.xm_project_phase_baseline 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectPhaseBaselineController")
@RequestMapping(value="/**/xm/core/xmProjectPhaseBaseline")
@Api(tags={"xm_project_phase_baseline操作接口"})
public class XmProjectPhaseBaselineController {
	
	static Log logger=LogFactory.getLog(XmProjectPhaseBaselineController.class);
	
	@Autowired
	private XmProjectPhaseBaselineService xmProjectPhaseBaselineService;
	 
		
 
	
	@ApiOperation( value = "查询xm_project_phase_baseline信息列表",notes="listXmProjectPhaseBaseline,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="基线主键,主键",required=false),
		@ApiImplicitParam(name="baseCtime",value="基线建立时间",required=false),
		@ApiImplicitParam(name="projectPhaseId",value="阶段主键",required=false),
		@ApiImplicitParam(name="phaseName",value="阶段名称",required=false),
		@ApiImplicitParam(name="remark",value="备注",required=false),
		@ApiImplicitParam(name="parentPhaseId",value="上级阶段编号",required=false),
		@ApiImplicitParam(name="branchId",value="机构编号",required=false),
		@ApiImplicitParam(name="projectId",value="当前项目编号",required=false),
		@ApiImplicitParam(name="beginDate",value="开始时间",required=false),
		@ApiImplicitParam(name="endDate",value="结束时间",required=false),
		@ApiImplicitParam(name="planWorkingHours",value="工时",required=false),
		@ApiImplicitParam(name="planWorkingStaffNu",value="投入人员数",required=false),
		@ApiImplicitParam(name="ctime",value="创建时间",required=false),
		@ApiImplicitParam(name="totalBudgetNouser",value="非人力成本总预算",required=false),
		@ApiImplicitParam(name="totalBudgetInnerUser",value="内部人力成本总预算",required=false),
		@ApiImplicitParam(name="totalBudgetOutUser",value="外购人力成本总预算",required=false),
		@ApiImplicitParam(name="baseRemark",value="基线备注",required=false),
		@ApiImplicitParam(name="projectBaselineId",value="项目级基线",required=false),
		@ApiImplicitParam(name="bizProcInstId",value="当前流程实例编号",required=false),
		@ApiImplicitParam(name="bizFlowState",value="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectPhaseBaseline.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectPhaseBaseline( @RequestParam Map<String,Object> xmProjectPhaseBaseline){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectPhaseBaseline, "ids");
		PageUtils.startPage(xmProjectPhaseBaseline);
		List<Map<String,Object>>	xmProjectPhaseBaselineList = xmProjectPhaseBaselineService.selectListMapByWhere(xmProjectPhaseBaseline);	//列出XmProjectPhaseBaseline列表
		PageUtils.responePage(m, xmProjectPhaseBaselineList);
		m.put("data",xmProjectPhaseBaselineList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	/**
	@ApiOperation( value = "新增一条xm_project_phase_baseline信息",notes="addXmProjectPhaseBaseline,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectPhaseBaseline.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectPhaseBaseline(@RequestBody XmProjectPhaseBaseline xmProjectPhaseBaseline) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectPhaseBaseline.getId())) {
				xmProjectPhaseBaseline.setId(xmProjectPhaseBaselineService.createKey("id"));
			}else{
				 XmProjectPhaseBaseline xmProjectPhaseBaselineQuery = new  XmProjectPhaseBaseline(xmProjectPhaseBaseline.getId());
				if(xmProjectPhaseBaselineService.countByWhere(xmProjectPhaseBaselineQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmProjectPhaseBaselineService.insert(xmProjectPhaseBaseline);
			m.put("data",xmProjectPhaseBaseline);
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
	@ApiOperation( value = "删除一条xm_project_phase_baseline信息",notes="delXmProjectPhaseBaseline,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectPhaseBaseline(@RequestBody XmProjectPhaseBaseline xmProjectPhaseBaseline){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectPhaseBaselineService.deleteByPk(xmProjectPhaseBaseline);
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
	@ApiOperation( value = "根据主键修改一条xm_project_phase_baseline信息",notes="editXmProjectPhaseBaseline")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectPhaseBaseline.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectPhaseBaseline(@RequestBody XmProjectPhaseBaseline xmProjectPhaseBaseline) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectPhaseBaselineService.updateByPk(xmProjectPhaseBaseline);
			m.put("data",xmProjectPhaseBaseline);
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
	@ApiOperation( value = "根据主键列表批量删除xm_project_phase_baseline信息",notes="batchDelXmProjectPhaseBaseline,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectPhaseBaseline(@RequestBody List<XmProjectPhaseBaseline> xmProjectPhaseBaselines) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectPhaseBaselines.size()+"条数据"); 
		try{ 
			xmProjectPhaseBaselineService.batchDelete(xmProjectPhaseBaselines);
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
