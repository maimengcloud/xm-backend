package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.core.entity.XmProjectBaseline;
import com.xm.core.service.XmProjectBaselineService;
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
 * url编制采用rest风格,如对XM.xm_project_baseline xm_project_baseline的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProjectBaseline/add <br>
 *  查询: xm/xmProjectBaseline/list<br>
 *  模糊查询: xm/xmProjectBaseline/listKey<br>
 *  修改: xm/xmProjectBaseline/edit <br>
 *  删除: xm/xmProjectBaseline/del<br>
 *  批量删除: xm/xmProjectBaseline/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectBaseline 表 XM.xm_project_baseline 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectBaselineController")
@RequestMapping(value="/**/xm/core/xmProjectBaseline")
@Api(tags={"xm_project_baseline操作接口"})
public class XmProjectBaselineController {
	
	static Log logger=LogFactory.getLog(XmProjectBaselineController.class);
	
	@Autowired
	private XmProjectBaselineService xmProjectBaselineService;
	 
		
 
	
	@ApiOperation( value = "查询xm_project_baseline信息列表",notes="listXmProjectBaseline,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="基线表主键,主键",required=false),
		@ApiImplicitParam(name="code",value="项目代号",required=false),
		@ApiImplicitParam(name="name",value="项目名称",required=false),
		@ApiImplicitParam(name="xmType",value="项目类型",required=false),
		@ApiImplicitParam(name="startTime",value="项目开始时间",required=false),
		@ApiImplicitParam(name="endTime",value="项目结束时间",required=false),
		@ApiImplicitParam(name="urgent",value="紧急程度",required=false),
		@ApiImplicitParam(name="priority",value="优先程度",required=false),
		@ApiImplicitParam(name="description",value="项目描述",required=false),
		@ApiImplicitParam(name="createUserid",value="项目创建人编号",required=false),
		@ApiImplicitParam(name="createUsername",value="项目创建人",required=false),
		@ApiImplicitParam(name="createTime",value="创建时间",required=false),
		@ApiImplicitParam(name="assess",value="项目考核",required=false),
		@ApiImplicitParam(name="assessRemarks",value="考核备注",required=false),
		@ApiImplicitParam(name="status",value="项目状态，0-初始，1-立项中，2-执行中，3-已结项，4-暂停",required=false),
		@ApiImplicitParam(name="branchId",value="机构编号",required=false),
		@ApiImplicitParam(name="planTotalCost",value="总预算",required=false),
		@ApiImplicitParam(name="bizProcInstId",value="当前流程实例编号",required=false),
		@ApiImplicitParam(name="bizFlowState",value="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",required=false),
		@ApiImplicitParam(name="planNouserAt",value="非人力成本总预算-应该大于或等于阶段计划非人力总成本",required=false),
		@ApiImplicitParam(name="planInnerUserAt",value="内部人力成本总预算-应该大于或等于阶段计划内部人力总成本",required=false),
		@ApiImplicitParam(name="planOutUserAt",value="外购人力成本总预算-应该大于或等于阶段计划外购人力总成本",required=false),
		@ApiImplicitParam(name="locked",value="是否锁定整个项目不允许变化0否1是",required=false),
		@ApiImplicitParam(name="baseTime",value="基线时间",required=false),
		@ApiImplicitParam(name="baseRemark",value="基线备注",required=false),
		@ApiImplicitParam(name="baselineId",value="基线主键",required=false),
		@ApiImplicitParam(name="planWorkload",value="总预算工作量-应该大于或等于阶段计划总工作量",required=false),
		@ApiImplicitParam(name="totalReceivables",value="总预计收款金额",required=false),
		@ApiImplicitParam(name="budgetMarginRate",value="预估毛利率",required=false),
		@ApiImplicitParam(name="contractAmt",value="合同总金额",required=false),
		@ApiImplicitParam(name="planInnerUserPrice",value="内部人力成本单价元/人时",required=false),
		@ApiImplicitParam(name="planOutUserPrice",value="外购人力成本单价元/人时",required=false),
		@ApiImplicitParam(name="planOutUserCnt",value="外购人数",required=false),
		@ApiImplicitParam(name="planInnerUserCnt",value="内部人数",required=false),
		@ApiImplicitParam(name="planWorkingHours",value="预计工作小时数目",required=false),
		@ApiImplicitParam(name="taxRate",value="税率",required=false),
		@ApiImplicitParam(name="planInnerUserWorkload",value="内部人力总工作量-应该大于或等于阶段计划内部人力总成本",required=false),
		@ApiImplicitParam(name="planOutUserWorkload",value="外购人力总工作量-应该大于或等于阶段计划外购人力总成本",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="ctime",value="创建时间",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectBaseline.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectBaseline( @RequestParam Map<String,Object> xmProjectBaseline){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectBaseline, "ids");
		PageUtils.startPage(xmProjectBaseline);
		List<Map<String,Object>>	xmProjectBaselineList = xmProjectBaselineService.selectListMapByWhere(xmProjectBaseline);	//列出XmProjectBaseline列表
		PageUtils.responePage(m, xmProjectBaselineList);
		m.put("data",xmProjectBaselineList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	/**
	@ApiOperation( value = "新增一条xm_project_baseline信息",notes="addXmProjectBaseline,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectBaseline.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectBaseline(@RequestBody XmProjectBaseline xmProjectBaseline) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectBaseline.getId())) {
				xmProjectBaseline.setId(xmProjectBaselineService.createKey("id"));
			}else{
				 XmProjectBaseline xmProjectBaselineQuery = new  XmProjectBaseline(xmProjectBaseline.getId());
				if(xmProjectBaselineService.countByWhere(xmProjectBaselineQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmProjectBaselineService.insert(xmProjectBaseline);
			m.put("data",xmProjectBaseline);
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
	@ApiOperation( value = "删除一条xm_project_baseline信息",notes="delXmProjectBaseline,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectBaseline(@RequestBody XmProjectBaseline xmProjectBaseline){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectBaselineService.deleteByPk(xmProjectBaseline);
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
	@ApiOperation( value = "根据主键修改一条xm_project_baseline信息",notes="editXmProjectBaseline")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectBaseline.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectBaseline(@RequestBody XmProjectBaseline xmProjectBaseline) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectBaselineService.updateByPk(xmProjectBaseline);
			m.put("data",xmProjectBaseline);
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
	@ApiOperation( value = "根据主键列表批量删除xm_project_baseline信息",notes="batchDelXmProjectBaseline,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectBaseline(@RequestBody List<XmProjectBaseline> xmProjectBaselines) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectBaselines.size()+"条数据"); 
		try{ 
			xmProjectBaselineService.batchDelete(xmProjectBaselines);
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
