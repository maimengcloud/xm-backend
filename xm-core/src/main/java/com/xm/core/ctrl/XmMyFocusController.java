package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.core.entity.XmMyFocus;
import com.xm.core.service.XmMyFocusService;
import com.xm.core.service.XmRecordService;
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
 * url编制采用rest风格,如对XM.xm_my_focus xm_my_focus的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmMyFocus/add <br>
 *  查询: xm/xmMyFocus/list<br>
 *  模糊查询: xm/xmMyFocus/listKey<br>
 *  修改: xm/xmMyFocus/edit <br>
 *  删除: xm/xmMyFocus/del<br>
 *  批量删除: xm/xmMyFocus/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmMyFocus 表 XM.xm_my_focus 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmMyFocusController")
@RequestMapping(value="/**/xm/core/xmMyFocus")
@Api(tags={"xm_my_focus操作接口"})
public class XmMyFocusController {
	
	static Log logger=LogFactory.getLog(XmMyFocusController.class);
	
	@Autowired
	private XmMyFocusService xmMyFocusService;
	 
		

	@Autowired
    XmRecordService xmRecordService;
	
	@ApiOperation( value = "查询xm_my_focus信息列表",notes="listXmMyFocus,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="userid",value="用户编号",required=false),
		@ApiImplicitParam(name="username",value="用户名称",required=false),
		@ApiImplicitParam(name="taskId",value="关注的任务主键",required=false),
		@ApiImplicitParam(name="focusType",value="对象类型项目-project/任务-task",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="projectName",value="项目名称",required=false),
		@ApiImplicitParam(name="taskName",value="任务名称",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmMyFocus.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmMyFocus( @RequestParam Map<String,Object> xmMyFocus){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmMyFocus, "ids");
		PageUtils.startPage(xmMyFocus);
		List<Map<String,Object>>	xmMyFocusList = xmMyFocusService.selectListMapByWhere(xmMyFocus);	//列出XmMyFocus列表
		PageUtils.responePage(m, xmMyFocusList);
		m.put("data",xmMyFocusList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	/***/
	@ApiOperation( value = "新增一条xm_my_focus信息",notes="addXmMyFocus,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMyFocus.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmMyFocus(@RequestBody XmMyFocus xmMyFocus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功关注");
		try{
			if(StringUtils.isEmpty(xmMyFocus.getId())) {
				xmMyFocus.setId(xmMyFocusService.createKey("id"));
			}else{
				 XmMyFocus xmMyFocusQuery = new  XmMyFocus(xmMyFocus.getId());
				if(xmMyFocusService.countByWhere(xmMyFocusQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmMyFocusService.focus(xmMyFocus);
			
			m.put("data",xmMyFocus);
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
	@ApiOperation( value = "删除一条xm_my_focus信息",notes="delXmMyFocus,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmMyFocus(@RequestBody XmMyFocus xmMyFocus){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("取消关注成功");
		try{
			xmMyFocusService.unfocus(xmMyFocus);
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
	@ApiOperation( value = "根据主键修改一条xm_my_focus信息",notes="editXmMyFocus")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMyFocus.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmMyFocus(@RequestBody XmMyFocus xmMyFocus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmMyFocusService.updateByPk(xmMyFocus);
			m.put("data",xmMyFocus);
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
	@ApiOperation( value = "根据主键列表批量删除xm_my_focus信息",notes="batchDelXmMyFocus,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmMyFocus(@RequestBody List<XmMyFocus> xmMyFocuss) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmMyFocuss.size()+"条数据"); 
		try{ 
			xmMyFocusService.batchDelete(xmMyFocuss);
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
