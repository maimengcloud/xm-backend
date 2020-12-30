package com.qqkj.xm.core.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qqkj.mdp.qx.HasQx;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qqkj.mdp.core.entity.Tips;
import com.qqkj.mdp.core.err.BizException;
import com.qqkj.mdp.core.utils.RequestUtils;
import com.qqkj.mdp.mybatis.PageUtils;
import com.qqkj.xm.core.entity.XmIteration;
import com.qqkj.xm.core.service.XmIterationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * url编制采用rest风格,如对XM.xm_iteration 迭代定义的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmIteration/add <br>
 *  查询: xm/xmIteration/list<br>
 *  模糊查询: xm/xmIteration/listKey<br>
 *  修改: xm/xmIteration/edit <br>
 *  删除: xm/xmIteration/del<br>
 *  批量删除: xm/xmIteration/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmIteration 表 XM.xm_iteration 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmIterationController")
@RequestMapping(value="/**/xm/core/xmIteration")
@Api(tags={"迭代定义操作接口"})
public class XmIterationController {
	
	static Log logger=LogFactory.getLog(XmIterationController.class);
	
	@Autowired
	private XmIterationService xmIterationService;
	 
		
 
	
	@ApiOperation( value = "查询迭代定义信息列表",notes="listXmIteration,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="迭代编码,主键",required=false),
		@ApiImplicitParam(name="branchId",value="机构编号",required=false),
		@ApiImplicitParam(name="iterationName",value="迭代名称",required=false),
		@ApiImplicitParam(name="startTime",value="开始时间",required=false),
		@ApiImplicitParam(name="endTime",value="结束时间",required=false),
		@ApiImplicitParam(name="onlineTime",value="上线时间",required=false),
		@ApiImplicitParam(name="pid",value="上级迭代",required=false),
		@ApiImplicitParam(name="adminUserid",value="负责人",required=false),
		@ApiImplicitParam(name="adminUsername",value="负责人姓名",required=false),
		@ApiImplicitParam(name="ctime",value="创建时间",required=false),
		@ApiImplicitParam(name="budgetCost",value="预算成本",required=false),
		@ApiImplicitParam(name="budgetWorkload",value="预算工作量",required=false),
		@ApiImplicitParam(name="seqNo",value="顺序号",required=false),
		@ApiImplicitParam(name="istatus",value="迭代状态0未结束1已结束",required=false),
		@ApiImplicitParam(name="cuserid",value="创建人编号",required=false),
		@ApiImplicitParam(name="cusername",value="创建人人姓名",required=false),
		@ApiImplicitParam(name="remark",value="备注",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmIteration.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmIteration( @RequestParam Map<String,Object> xmIteration){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmIteration, "ids");
		PageUtils.startPage(xmIteration);
		List<Map<String,Object>>	xmIterationList = xmIterationService.selectListMapByWhere(xmIteration);	//列出XmIteration列表
		PageUtils.responePage(m, xmIterationList);
		m.put("data",xmIterationList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
	@ApiOperation( value = "查询迭代数据，联通状态数据一起带出",notes="") 
	@ApiResponses({
		@ApiResponse(code = 200,response=XmIteration.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listWithState",method=RequestMethod.GET)
	public Map<String,Object> listWithState( @RequestParam Map<String,Object> xmIteration){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmIteration, "ids");
		PageUtils.startPage(xmIteration);
		List<Map<String,Object>>	xmIterationList = xmIterationService.selectListMapByWhereWithState(xmIteration);	//列出XmIteration列表
		PageUtils.responePage(m, xmIterationList);
		m.put("data",xmIterationList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
	/***/
	@ApiOperation( value = "新增一条迭代定义信息",notes="addXmIteration,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmIteration.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmIteration_add",name = "新增迭代计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmIteration(@RequestBody XmIteration xmIteration) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmIteration.getId())) {
				xmIteration.setId(xmIterationService.createKey("id"));
			}else{
				 XmIteration xmIterationQuery = new  XmIteration(xmIteration.getId());
				if(xmIterationService.countByWhere(xmIterationQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmIterationService.insert(xmIteration);
			m.put("data",xmIteration);
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
	@ApiOperation( value = "删除一条迭代定义信息",notes="delXmIteration,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@HasQx(value = "xm_core_xmIteration_del",name = "删除迭代计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmIteration(@RequestBody XmIteration xmIteration){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmIterationService.deleteByPk(xmIteration);
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
	@ApiOperation( value = "根据主键修改一条迭代定义信息",notes="editXmIteration")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmIteration.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmIteration_edit",name = "修改迭代计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmIteration(@RequestBody XmIteration xmIteration) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmIterationService.updateByPk(xmIteration);
			m.put("data",xmIteration);
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



	@HasQx(value = "xm_core_xmIteration_loadTasksToXmIterationState",name = "计算迭代的bug、工作量、人员投入、进度等",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/loadTasksToXmIterationState",method=RequestMethod.POST)
	public Map<String,Object> loadTasksToXmIterationState(@RequestBody XmIteration xmIteration) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			if(xmIteration==null || StringUtils.isEmpty(xmIteration.getId())) {
				tips.setFailureMsg("请输入迭代编号id");
			}else { 
				xmIterationService.loadTasksToXmIterationState(xmIteration.getId());
 			}
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
	@ApiOperation( value = "根据主键列表批量删除迭代定义信息",notes="batchDelXmIteration,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmIteration(@RequestBody List<XmIteration> xmIterations) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmIterations.size()+"条数据"); 
		try{ 
			xmIterationService.batchDelete(xmIterations);
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
