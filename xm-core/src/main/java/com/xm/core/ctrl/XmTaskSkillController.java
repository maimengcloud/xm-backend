package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.xm.core.entity.XmTaskSkill;
import com.xm.core.service.XmTaskSkillService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url编制采用rest风格,如对XM.xm_task_skill xm_task_skill的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmTaskSkill/add <br>
 *  查询: xm/xmTaskSkill/list<br>
 *  模糊查询: xm/xmTaskSkill/listKey<br>
 *  修改: xm/xmTaskSkill/edit <br>
 *  删除: xm/xmTaskSkill/del<br>
 *  批量删除: xm/xmTaskSkill/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmTaskSkill 表 XM.xm_task_skill 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmTaskSkillController")
@RequestMapping(value="/**/xm/core/xmTaskSkill")
@Api(tags={"xm_task_skill操作接口"})
public class XmTaskSkillController {
	
	static Log logger=LogFactory.getLog(XmTaskSkillController.class);
	
	@Autowired
	private XmTaskSkillService xmTaskSkillService;
	 
		
 
	
	@ApiOperation( value = "查询xm_task_skill信息列表",notes="listXmTaskSkill,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="taskId",value="任务编号",required=false),
		@ApiImplicitParam(name="taskSkillId",value="技能要求",required=false),
		@ApiImplicitParam(name="taskSkillName",value="技能名称",required=false),
		@ApiImplicitParam(name="skillRemarks",value="技能描述",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmTaskSkill.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTaskSkill( @RequestParam Map<String,Object> xmTaskSkill){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmTaskSkill, "ids");
		PageUtils.startPage(xmTaskSkill);
		List<Map<String,Object>>	xmTaskSkillList = xmTaskSkillService.selectListMapByWhere(xmTaskSkill);	//列出XmTaskSkill列表
		PageUtils.responePage(m, xmTaskSkillList);
		m.put("data",xmTaskSkillList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
	@ApiOperation( value = "批量添加技能",notes="batchDelXmTaskSkill,仅需要上传主键字段")
	@ApiResponses({
	@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmTaskSkill_batchAdd",name = "批量新增任务的技能要求",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchAdd",method=RequestMethod.POST)
	public Map<String,Object> batchAddSkill(@RequestBody List<XmTaskSkill> xmTaskSkills) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功添加"+xmTaskSkills.size()+"条数据");
		try{
			xmTaskSkillService.insertOrDelete(xmTaskSkills);
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
	@ApiOperation( value = "新增一条xm_task_skill信息",notes="addXmTaskSkill,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskSkill.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTaskSkill(@RequestBody XmTaskSkill xmTaskSkill) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmTaskSkill.getId())) {
				xmTaskSkill.setId(xmTaskSkillService.createKey("id"));
			}else{
				 XmTaskSkill xmTaskSkillQuery = new  XmTaskSkill(xmTaskSkill.getId());
				if(xmTaskSkillService.countByWhere(xmTaskSkillQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmTaskSkillService.insert(xmTaskSkill);
			m.put("data",xmTaskSkill);
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
	
	@ApiOperation( value = "删除一条xm_task_skill信息",notes="delXmTaskSkill,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@HasQx(value = "xm_core_xmTaskSkill_del",name = "删除任务的技能要求",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmTaskSkill(@RequestBody XmTaskSkill xmTaskSkill){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmTaskSkillService.deleteByPk(xmTaskSkill);
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
	@ApiOperation( value = "根据主键修改一条xm_task_skill信息",notes="editXmTaskSkill")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskSkill.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTaskSkill(@RequestBody XmTaskSkill xmTaskSkill) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmTaskSkillService.updateByPk(xmTaskSkill);
			m.put("data",xmTaskSkill);
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
	@ApiOperation( value = "根据主键列表批量删除xm_task_skill信息",notes="batchDelXmTaskSkill,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmTaskSkill(@RequestBody List<XmTaskSkill> xmTaskSkills) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmTaskSkills.size()+"条数据"); 
		try{ 
			xmTaskSkillService.batchDelete(xmTaskSkills);
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
