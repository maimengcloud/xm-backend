package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmTestCaseExec;
import com.xm.core.service.XmTestCaseExecService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url编制采用rest风格,如对XM.xm_test_case_exec xm_test_case_exec的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmTestCaseExec/add <br>
 *  查询: core/xmTestCaseExec/list<br>
 *  模糊查询: core/xmTestCaseExec/listKey<br>
 *  修改: core/xmTestCaseExec/edit <br>
 *  删除: core/xmTestCaseExec/del<br>
 *  批量删除: core/xmTestCaseExec/batchDel<br>
 * 组织 com.qqkj  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTestCaseExec 表 XM.xm_test_case_exec 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmTestCaseExecController")
@RequestMapping(value="/**/core/xmTestCaseExec")
@Api(tags={"xm_test_case_exec操作接口"})
public class XmTestCaseExecController {
	
	static Log logger=LogFactory.getLog(XmTestCaseExecController.class);
	
	@Autowired
	private XmTestCaseExecService xmTestCaseExecService;
	 
		
 
	
	@ApiOperation( value = "查询xm_test_case_exec信息列表",notes="listXmTestCaseExec,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="执行编号,主键",required=false),
		@ApiImplicitParam(name="execUserid",value="执行人",required=false),
		@ApiImplicitParam(name="startTime",value="开始时间",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="projectName",value="项目名称",required=false),
		@ApiImplicitParam(name="caseId",value="测试案例编号",required=false),
		@ApiImplicitParam(name="caseName",value="测试案例名称",required=false),
		@ApiImplicitParam(name="endTime",value="到期时间",required=false),
		@ApiImplicitParam(name="remark",value="问题描述",required=false),
		@ApiImplicitParam(name="createUserid",value="问题创建人编号",required=false),
		@ApiImplicitParam(name="createUsername",value="问题创建人",required=false),
		@ApiImplicitParam(name="createTime",value="创建时间",required=false),
		@ApiImplicitParam(name="execStatus",value="0新建1测试中2已完成",required=false),
		@ApiImplicitParam(name="iterationId",value="迭代编号",required=false),
		@ApiImplicitParam(name="iterationName",value="迭代名称",required=false),
		@ApiImplicitParam(name="execUsername",value="执行人姓名",required=false),
		@ApiImplicitParam(name="taskId",value="归属测试任务编号",required=false),
		@ApiImplicitParam(name="taskName",value="归属测试任务名称",required=false),
		@ApiImplicitParam(name="menuId",value="需求编号",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmTestCaseExec.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTestCaseExec( @RequestParam Map<String,Object> xmTestCaseExec){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmTestCaseExec, "ids");
		RequestUtils.transformArray(xmTestCaseExec, "menuIds");
		PageUtils.startPage(xmTestCaseExec);
		Tips tips=new Tips("查询成功");
		String id= (String) xmTestCaseExec.get("id");
		String menuId= (String) xmTestCaseExec.get("menuId");
		Object ids=  xmTestCaseExec.get("ids");
		Object menuIds=  xmTestCaseExec.get("menuIds");
		String projectId= (String) xmTestCaseExec.get("projectId");
		String productId= (String) xmTestCaseExec.get("productId");
		String caseId= (String) xmTestCaseExec.get("caseId");
		if(   !( StringUtils.hasText(caseId)||StringUtils.hasText(id) || StringUtils.hasText(menuId) || StringUtils.hasText(projectId)|| StringUtils.hasText(productId)||menuIds!=null||ids!=null  ) ){
			xmTestCaseExec.put("compete", LoginUtils.getCurrentUserInfo().getUserid());
		}
		List<Map<String,Object>>	xmTestCaseExecList = xmTestCaseExecService.selectListMapByWhere(xmTestCaseExec);	//列出XmTestCaseExec列表
		PageUtils.responePage(m, xmTestCaseExecList);
		m.put("data",xmTestCaseExecList);

		m.put("tips", tips);
		return m;
	}
	
 
	
	/***/
	@ApiOperation( value = "新增一条xm_test_case_exec信息",notes="addXmTestCaseExec,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestCaseExec.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTestCaseExec_add",name = "新增测试计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTestCaseExec(@RequestBody XmTestCaseExec xmTestCaseExec) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmTestCaseExec.getId())) {
				xmTestCaseExec.setId(xmTestCaseExecService.createKey("id"));
			}else{
				 XmTestCaseExec xmTestCaseExecQuery = new  XmTestCaseExec(xmTestCaseExec.getId());
				if(xmTestCaseExecService.countByWhere(xmTestCaseExecQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmTestCaseExecService.insert(xmTestCaseExec);
			m.put("data",xmTestCaseExec);
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
	
	
	/** */
	@ApiOperation( value = "删除一条xm_test_case_exec信息",notes="delXmTestCaseExec,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@HasQx(value = "xm_core_xmTestCaseExec_del",name = "删除测试计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmTestCaseExec(@RequestBody XmTestCaseExec xmTestCaseExec){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmTestCaseExecService.deleteByPk(xmTestCaseExec);
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
	@ApiOperation( value = "根据主键修改一条xm_test_case_exec信息",notes="editXmTestCaseExec")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestCaseExec.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTestCaseExec_edit",name = "修改测试计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTestCaseExec(@RequestBody XmTestCaseExec xmTestCaseExec) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmTestCaseExecService.updateByPk(xmTestCaseExec);
			m.put("data",xmTestCaseExec);
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
	@ApiOperation( value = "根据主键列表批量删除xm_test_case_exec信息",notes="batchDelXmTestCaseExec,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmTestCaseExec_batchDel",name = "批量删除测试计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmTestCaseExec(@RequestBody List<XmTestCaseExec> xmTestCaseExecs) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmTestCaseExecs.size()+"条数据"); 
		try{ 
			xmTestCaseExecService.batchDelete(xmTestCaseExecs);
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
	@ApiOperation( value = "批量新增")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmTestCaseExec_batchAdd",name = "批量新增测试计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchAdd",method=RequestMethod.POST)
	public Map<String,Object> batchAddXmTestCaseExec(@RequestBody List<XmTestCaseExec> xmTestCaseExecs) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增"+xmTestCaseExecs.size()+"条数据"); 
		try{ 
			/**
			 * 根据caseId,projectId判断是否重复，重复的应该忽略
			 */
			List<String> caseIds=new ArrayList<>();
			String projectId="";
			for (XmTestCaseExec ce : xmTestCaseExecs) {
				caseIds.add(ce.getCaseId());
				projectId=ce.getProjectId();
			}
			List<XmTestCaseExec> existsList=this.xmTestCaseExecService.listByProjectAndCaseIds(projectId,caseIds);
			List<XmTestCaseExec> canAddList=new ArrayList<>();
			for (XmTestCaseExec xmTestCaseExec : xmTestCaseExecs) {
				boolean exists=false;
				for (XmTestCaseExec ce : existsList) {
					if(xmTestCaseExec.getProjectId().equals(ce.getProjectId()) && xmTestCaseExec.getCaseId().equals(ce.getCaseId())) {
						exists=true;
						break;
					}
					
				}
				if(exists==false) {
					canAddList.add(xmTestCaseExec);
				}
			}
			if(canAddList.size()>0) {
				xmTestCaseExecService.batchInsert(canAddList);
			}
			tips.setOkMsg("成功新增"+canAddList.size()+"条数据，忽略已存在的"+(xmTestCaseExecs.size()-canAddList.size())+"条数据");
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
	@ApiOperation( value = "批量修改")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmTestCaseExec_batchEdit",name = "批量修改测试计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchEdit",method=RequestMethod.POST)
	public Map<String,Object> batchEditXmTestCaseExec(@RequestBody List<XmTestCaseExec> xmTestCaseExecs) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改"+xmTestCaseExecs.size()+"条数据"); 
		try{ 
			xmTestCaseExecService.batchUpdate(xmTestCaseExecs);
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
