package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmTestCase;
import com.xm.core.service.XmTestCaseService;
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
 * url编制采用rest风格,如对XM.xm_test_case 测试用例的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmTestCase/add <br>
 *  查询: core/xmTestCase/list<br>
 *  模糊查询: core/xmTestCase/listKey<br>
 *  修改: core/xmTestCase/edit <br>
 *  删除: core/xmTestCase/del<br>
 *  批量删除: core/xmTestCase/batchDel<br>
 * 组织 com.qqkj  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTestCase 表 XM.xm_test_case 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmTestCaseController")
@RequestMapping(value="/**/core/xmTestCase")
@Api(tags={"测试用例操作接口"})
public class XmTestCaseController {
	
	static Log logger=LogFactory.getLog(XmTestCaseController.class);
	
	@Autowired
	private XmTestCaseService xmTestCaseService;
	 
		
 
	
	@ApiOperation( value = "查询测试用例信息列表",notes="listXmTestCase,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="caseName",value="标题",required=false),
		@ApiImplicitParam(name="caseRemark",value="备注",required=false),
		@ApiImplicitParam(name="testStep",value="测试步骤",required=false),
		@ApiImplicitParam(name="expectResult",value="期望结果",required=false),
		@ApiImplicitParam(name="menuId",value="关联的故事",required=false),
		@ApiImplicitParam(name="menuName",value="关联故事名",required=false),
		@ApiImplicitParam(name="ctime",value="创建时间",required=false),
		@ApiImplicitParam(name="ltime",value="更新时间",required=false),
		@ApiImplicitParam(name="luserid",value="更新人编号",required=false),
		@ApiImplicitParam(name="lusername",value="更新人姓名",required=false),
		@ApiImplicitParam(name="cbranchId",value="创建机构",required=false),
		@ApiImplicitParam(name="moduleId",value="模块编号",required=false),
		@ApiImplicitParam(name="moduleName",value="模块名称",required=false),
		@ApiImplicitParam(name="caseStatus",value="用例状态1正常0废弃",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmTestCase.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTestCase( @RequestParam Map<String,Object> xmTestCase){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmTestCase, "ids");
		RequestUtils.transformArray(xmTestCase, "menuIds");
		PageUtils.startPage(xmTestCase);
		String id= (String) xmTestCase.get("id");
		String menuId= (String) xmTestCase.get("menuId");
		Object ids=  xmTestCase.get("ids");
		Object menuIds=  xmTestCase.get("menuIds");
		String productId= (String) xmTestCase.get("productId");
		String projectId= (String) xmTestCase.get("projectId");
		if(   !( StringUtils.hasText(id) || StringUtils.hasText(menuId) || StringUtils.hasText(productId)|| StringUtils.hasText(projectId)||menuIds!=null||ids!=null  ) ){
			xmTestCase.put("compete", LoginUtils.getCurrentUserInfo().getUserid());
		}
		List<Map<String,Object>>	xmTestCaseList = xmTestCaseService.selectListMapByWhere(xmTestCase);	//列出XmTestCase列表
		PageUtils.responePage(m, xmTestCaseList);
		m.put("data",xmTestCaseList);

		m.put("tips", tips);
		return m;
	}
	
 
	
	/***/
	@ApiOperation( value = "新增一条测试用例信息",notes="addXmTestCase,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestCase.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTestCase_batchAdd",name = "新增测试用例",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTestCase(@RequestBody XmTestCase xmTestCase) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmTestCase.getId())) {
				xmTestCase.setId(xmTestCaseService.createKey("id"));
			}else{
				 XmTestCase xmTestCaseQuery = new  XmTestCase(xmTestCase.getId());
				if(xmTestCaseService.countByWhere(xmTestCaseQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmTestCaseService.insert(xmTestCase);
			m.put("data",xmTestCase);
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
	@ApiOperation( value = "删除一条测试用例信息",notes="delXmTestCase,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@HasQx(value = "xm_core_xmTestCase_del",name = "删除测试用例",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmTestCase(@RequestBody XmTestCase xmTestCase){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmTestCaseService.deleteByPk(xmTestCase);
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
	
	
	/**	*/
	@ApiOperation( value = "根据主键修改一条测试用例信息",notes="editXmTestCase")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestCase.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmTestCase_edit",name = "修改测试用例",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTestCase(@RequestBody XmTestCase xmTestCase) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmTestCaseService.updateByPk(xmTestCase);
			m.put("data",xmTestCase);
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
	@ApiOperation( value = "根据主键列表批量删除测试用例信息",notes="batchDelXmTestCase,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmTestCase_batchDel",name = "批量删除测试用例",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmTestCase(@RequestBody List<XmTestCase> xmTestCases) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmTestCases.size()+"条数据"); 
		try{ 
			xmTestCaseService.batchDelete(xmTestCases);
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
