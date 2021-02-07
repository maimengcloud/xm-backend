package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.core.entity.XmProjectPhaseTemplate;
import com.xm.core.service.XmProjectPhaseTemplateService;
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
 * url编制采用rest风格,如对XM.xm_project_phase_template 项目阶段模板的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProjectPhaseTemplate/add <br>
 *  查询: xm/xmProjectPhaseTemplate/list<br>
 *  模糊查询: xm/xmProjectPhaseTemplate/listKey<br>
 *  修改: xm/xmProjectPhaseTemplate/edit <br>
 *  删除: xm/xmProjectPhaseTemplate/del<br>
 *  批量删除: xm/xmProjectPhaseTemplate/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectPhaseTemplate 表 XM.xm_project_phase_template 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectPhaseTemplateController")
@RequestMapping(value="/**/xm/core/xmProjectPhaseTemplate")
@Api(tags={"项目阶段模板操作接口"})
public class XmProjectPhaseTemplateController {
	
	static Log logger=LogFactory.getLog(XmProjectPhaseTemplateController.class);
	
	@Autowired
	private XmProjectPhaseTemplateService xmProjectPhaseTemplateService;
	 
		
 
	
	@ApiOperation( value = "查询项目阶段模板信息列表",notes="listXmProjectPhaseTemplate,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="阶段主键,主键",required=false),
		@ApiImplicitParam(name="phaseName",value="阶段名称",required=false),
		@ApiImplicitParam(name="remark",value="备注",required=false),
		@ApiImplicitParam(name="parentPhaseId",value="上级阶段编号",required=false),
		@ApiImplicitParam(name="branchId",value="机构编号",required=false),
		@ApiImplicitParam(name="projectId",value="当前项目编号",required=false),
		@ApiImplicitParam(name="beginDate",value="开始时间",required=false),
		@ApiImplicitParam(name="endDate",value="结束时间",required=false),
		@ApiImplicitParam(name="phaseBudgetHours",value="工时(不包括下一级)-应该大于或等于task中总工时",required=false),
		@ApiImplicitParam(name="phaseBudgetStaffNu",value="投入人员数(不包括下一级)-应该大于或等于task中总人数",required=false),
		@ApiImplicitParam(name="ctime",value="创建时间",required=false),
		@ApiImplicitParam(name="phaseBudgetNouserAt",value="非人力成本总预算(不包括下一级)-应该大于或等于task中非人力总成本",required=false),
		@ApiImplicitParam(name="phaseBudgetInnerUserAt",value="内部人力成本总预算(不包括下一级)-应该大于或等于task中内部人力总成本",required=false),
		@ApiImplicitParam(name="phaseBudgetOutUserAt",value="外购人力成本总预算(不包括下一级)-应该大于或等于task中外购总成本",required=false),
		@ApiImplicitParam(name="phaseBudgetWorkload",value="总工作量单位人时-应该大于或者等于task中的预算总工作量",required=false),
		@ApiImplicitParam(name="taskType",value="0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType",required=false),
		@ApiImplicitParam(name="planType",value="计划类型w1-周,w2-2周,w3-3周,m1-1月,m2-2月,q1-季,q2-半年，y1-年",required=false),
		@ApiImplicitParam(name="seqNo",value="顺序号",required=false),
		@ApiImplicitParam(name="phaseBudgetInnerUserWorkload",value="内部人力工作量总预算(不包括下一级)-应该大于或等于task中内部人力总成本",required=false),
		@ApiImplicitParam(name="phaseBudgetOutUserWorkload",value="外购人力工作量总预算(不包括下一级)-应该大于或等于task中外购总成本",required=false),
		@ApiImplicitParam(name="phaseBudgetInnerUserPrice",value="内部人力成本单价元/人时",required=false),
		@ApiImplicitParam(name="phaseBudgetOutUserPrice",value="外购人力成本单价元/人时",required=false),
		@ApiImplicitParam(name="phaseBudgetOutUserCnt",value="外购人数",required=false),
		@ApiImplicitParam(name="phaseBudgetInnerUserCnt",value="内部人数",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectPhaseTemplate.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectPhaseTemplate( @RequestParam Map<String,Object> xmProjectPhaseTemplate){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectPhaseTemplate, "ids");
		PageUtils.startPage(xmProjectPhaseTemplate);
		List<Map<String,Object>>	xmProjectPhaseTemplateList = xmProjectPhaseTemplateService.selectListMapByWhere(xmProjectPhaseTemplate);	//列出XmProjectPhaseTemplate列表
		PageUtils.responePage(m, xmProjectPhaseTemplateList);
		m.put("data",xmProjectPhaseTemplateList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	/***/
	@ApiOperation( value = "新增一条项目阶段模板信息",notes="addXmProjectPhaseTemplate,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectPhaseTemplate.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectPhaseTemplate(@RequestBody XmProjectPhaseTemplate xmProjectPhaseTemplate) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectPhaseTemplate.getId())) {
				xmProjectPhaseTemplate.setId(xmProjectPhaseTemplateService.createKey("id"));
			}else{
				 XmProjectPhaseTemplate xmProjectPhaseTemplateQuery = new  XmProjectPhaseTemplate(xmProjectPhaseTemplate.getId());
				if(xmProjectPhaseTemplateService.countByWhere(xmProjectPhaseTemplateQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmProjectPhaseTemplateService.insert(xmProjectPhaseTemplate);
			m.put("data",xmProjectPhaseTemplate);
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
	@ApiOperation( value = "删除一条项目阶段模板信息",notes="delXmProjectPhaseTemplate,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectPhaseTemplate(@RequestBody XmProjectPhaseTemplate xmProjectPhaseTemplate){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectPhaseTemplateService.deleteByPk(xmProjectPhaseTemplate);
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
	
	@ApiOperation( value = "根据主键修改一条项目阶段模板信息",notes="editXmProjectPhaseTemplate")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectPhaseTemplate.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectPhaseTemplate(@RequestBody XmProjectPhaseTemplate xmProjectPhaseTemplate) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectPhaseTemplateService.updateByPk(xmProjectPhaseTemplate);
			m.put("data",xmProjectPhaseTemplate);
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
	@ApiOperation( value = "根据主键列表批量删除项目阶段模板信息",notes="batchDelXmProjectPhaseTemplate,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectPhaseTemplate(@RequestBody List<XmProjectPhaseTemplate> xmProjectPhaseTemplates) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectPhaseTemplates.size()+"条数据"); 
		try{ 
			xmProjectPhaseTemplateService.batchDelete(xmProjectPhaseTemplates);
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

	@RequestMapping(value="/batchAdd",method=RequestMethod.POST)
	public Map<String,Object> batchAddXmProjectPhaseTemplate(@RequestBody List<XmProjectPhaseTemplate> xmProjectPhaseTemplates) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectPhaseTemplates.size()+"条数据"); 
		try{ 
			xmProjectPhaseTemplateService.batchInsert(xmProjectPhaseTemplates);
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
	@RequestMapping(value="/batchEdit",method=RequestMethod.POST)
	public Map<String,Object> batchEditXmProjectPhaseTemplate(@RequestBody List<XmProjectPhaseTemplate> xmProjectPhaseTemplates) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectPhaseTemplates.size()+"条数据"); 
		try{ 
			xmProjectPhaseTemplateService.batchUpdate(xmProjectPhaseTemplates);
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
