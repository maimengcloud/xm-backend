package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmGroupState;
import com.xm.core.service.XmGroupStateService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url编制采用rest风格,如对XM.xm_group_state 功能状态表,无需前端维护，所有数据由汇总统计得出的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmGroupState/add <br>
 *  查询: core/xmGroupState/list<br>
 *  模糊查询: core/xmGroupState/listKey<br>
 *  修改: core/xmGroupState/edit <br>
 *  删除: core/xmGroupState/del<br>
 *  批量删除: core/xmGroupState/batchDel<br>
 * 组织 com.qqkj  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmProjectGroupState 表 XM.xm_group_state 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmGroupStateController")
@RequestMapping(value="/**/core/xmGroupState")
@Api(tags={"功能状态表,无需前端维护，所有数据由汇总统计得出操作接口"})
public class XmGroupStateController {
	
	static Log logger=LogFactory.getLog(XmGroupStateController.class);
	
	@Autowired
	private XmGroupStateService xmGroupStateService;
	 
		
 
	
	@ApiOperation( value = "查询功能状态表,无需前端维护，所有数据由汇总统计得出信息列表",notes="listXmProjectGroupState,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiEntityParams(XmGroupState.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmGroupState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectGroupState( @ApiIgnore @RequestParam Map<String,Object> xmGroupState){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmGroupState, "ids");
		PageUtils.startPage(xmGroupState);
		List<Map<String,Object>>	xmGroupStateList = xmGroupStateService.selectListMapByWhere(xmGroupState);	//列出XmProjectGroupState列表
		PageUtils.responePage(m, xmGroupStateList);
		m.put("data",xmGroupStateList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 

	@ApiOperation( value = "计算bug、task、测试案例、等数据",notes="loadTasksToXmProjectGroupState")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/loadTasksToXmProjectGroupState",method=RequestMethod.POST)
	public Map<String,Object> loadTasksToXmProjectGroupState(@RequestBody Map<String,Object> params) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改数据"); 
		try{ 
			int i= xmGroupStateService.loadTasksToXmProjectGroupState((String) params.get("projectId"));
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
	@ApiOperation( value = "新增一条功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes="addXmProjectGroupState,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectGroupState.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectGroupState(@RequestBody XmProjectGroupState xmGroupState) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmGroupState.getId())) {
				xmGroupState.setId(xmGroupStateService.createKey("id"));
			}else{
				 XmProjectGroupState xmGroupStateQuery = new  XmProjectGroupState(xmGroupState.getId());
				if(xmGroupStateService.countByWhere(xmGroupStateQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmGroupStateService.insert(xmGroupState);
			m.put("data",xmGroupState);
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
	@ApiOperation( value = "删除一条功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes="delXmProjectGroupState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectGroupState(@RequestBody XmProjectGroupState xmGroupState){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmGroupStateService.deleteByPk(xmGroupState);
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
	@ApiOperation( value = "根据主键修改一条功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes="editXmProjectGroupState")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectGroupState.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectGroupState(@RequestBody XmProjectGroupState xmGroupState) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmGroupStateService.updateByPk(xmGroupState);
			m.put("data",xmGroupState);
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
	@ApiOperation( value = "根据主键列表批量删除功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes="batchDelXmProjectGroupState,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectGroupState(@RequestBody List<XmProjectGroupState> xmGroupStates) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmGroupStates.size()+"条数据"); 
		try{ 
			xmGroupStateService.batchDelete(xmGroupStates);
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
