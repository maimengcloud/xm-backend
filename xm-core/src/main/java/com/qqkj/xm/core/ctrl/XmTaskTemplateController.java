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
import com.qqkj.xm.core.service.XmTaskTemplateService;
import com.qqkj.xm.core.entity.XmTaskTemplate;
/**
 * url编制采用rest风格,如对XM.xm_task_template xm_task_template的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmTaskTemplate/add <br>
 *  查询: xm/xmTaskTemplate/list<br>
 *  模糊查询: xm/xmTaskTemplate/listKey<br>
 *  修改: xm/xmTaskTemplate/edit <br>
 *  删除: xm/xmTaskTemplate/del<br>
 *  批量删除: xm/xmTaskTemplate/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmTaskTemplate 表 XM.xm_task_template 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmTaskTemplateController")
@RequestMapping(value="/**/xm/core/xmTaskTemplate")
@Api(tags={"xm_task_template操作接口"})
public class XmTaskTemplateController {
	
	static Log logger=LogFactory.getLog(XmTaskTemplateController.class);
	
	@Autowired
	private XmTaskTemplateService xmTaskTemplateService;
	 
		
 
	
	@ApiOperation( value = "查询xm_task_template信息列表",notes="listXmTaskTemplate,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="任务编号,主键",required=false),
		@ApiImplicitParam(name="name",value="任务名称",required=false),
		@ApiImplicitParam(name="parentTaskid",value="父任务编号",required=false),
		@ApiImplicitParam(name="parentTaskname",value="父任务名称",required=false),
		@ApiImplicitParam(name="level",value="任务级别",required=false),
		@ApiImplicitParam(name="sortLevel",value="排序级别",required=false),
		@ApiImplicitParam(name="preTaskid",value="前置任务编号",required=false),
		@ApiImplicitParam(name="preTaskname",value="前置任务名称",required=false),
		@ApiImplicitParam(name="milestone",value="里程碑",required=false),
		@ApiImplicitParam(name="description",value="任务描述",required=false),
		@ApiImplicitParam(name="remarks",value="备注",required=false),
		@ApiImplicitParam(name="createUserid",value="任务创建人编号",required=false),
		@ApiImplicitParam(name="createUsername",value="任务创建人",required=false),
		@ApiImplicitParam(name="createTime",value="创建时间",required=false),
		@ApiImplicitParam(name="budgetCost",value="当前任务预算金额（包括所有成本，不包括下一级）",required=false),
		@ApiImplicitParam(name="budgetWorkload",value="预算工时（不包括下一级）",required=false),
		@ApiImplicitParam(name="taskType",value="0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType",required=false),
		@ApiImplicitParam(name="taskClass",value="1需结算0不需结算",required=false),
		@ApiImplicitParam(name="toTaskCenter",value="是否发布到任务大厅0否1是",required=false),
		@ApiImplicitParam(name="taskSkillNames",value="技能列表,逗号分隔",required=false),
		@ApiImplicitParam(name="taskSkillIds",value="技能编号列表逗号分隔",required=false),
		@ApiImplicitParam(name="taskOut",value="是否可外购",required=false),
		@ApiImplicitParam(name="planType",value="计划类型w1-周,w2-2周,w3-3周,m1-1月,m2-2月,q1-季,q2-半年，y1-年",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskTemplate.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTaskTemplate( @RequestParam Map<String,Object> xmTaskTemplate){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmTaskTemplate, "ids");
		PageUtils.startPage(xmTaskTemplate);
		List<Map<String,Object>>	xmTaskTemplateList = xmTaskTemplateService.selectListMapByWhere(xmTaskTemplate);	//列出XmTaskTemplate列表
		PageUtils.responePage(m, xmTaskTemplateList);
		m.put("data",xmTaskTemplateList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	/***/
	@ApiOperation( value = "新增一条xm_task_template信息",notes="addXmTaskTemplate,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskTemplate.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTaskTemplate(@RequestBody XmTaskTemplate xmTaskTemplate) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmTaskTemplate.getId())) {
				xmTaskTemplate.setId(xmTaskTemplateService.createKey("id"));
			}else{
				 XmTaskTemplate xmTaskTemplateQuery = new  XmTaskTemplate(xmTaskTemplate.getId());
				if(xmTaskTemplateService.countByWhere(xmTaskTemplateQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmTaskTemplateService.insert(xmTaskTemplate);
			m.put("data",xmTaskTemplate);
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
	@ApiOperation( value = "删除一条xm_task_template信息",notes="delXmTaskTemplate,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmTaskTemplate(@RequestBody XmTaskTemplate xmTaskTemplate){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmTaskTemplateService.deleteByPk(xmTaskTemplate);
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
	@ApiOperation( value = "根据主键修改一条xm_task_template信息",notes="editXmTaskTemplate")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskTemplate.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTaskTemplate(@RequestBody XmTaskTemplate xmTaskTemplate) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmTaskTemplateService.updateByPk(xmTaskTemplate);
			m.put("data",xmTaskTemplate);
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
	@ApiOperation( value = "根据主键列表批量删除xm_task_template信息",notes="batchDelXmTaskTemplate,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmTaskTemplate(@RequestBody List<XmTaskTemplate> xmTaskTemplates) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmTaskTemplates.size()+"条数据"); 
		try{ 
			xmTaskTemplateService.batchDelete(xmTaskTemplates);
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
	public Map<String,Object> batchAddXmTaskTemplate(@RequestBody List<XmTaskTemplate> xmTaskTemplates) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmTaskTemplates.size()+"条数据"); 
		try{ 
			xmTaskTemplateService.batchInsert(xmTaskTemplates);
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
	public Map<String,Object> batchEditXmTaskTemplate(@RequestBody List<XmTaskTemplate> xmTaskTemplates) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmTaskTemplates.size()+"条数据"); 
		try{ 
			xmTaskTemplateService.batchUpdate(xmTaskTemplates);
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
