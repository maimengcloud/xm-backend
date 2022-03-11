package com.xm.core.ctrl;

import java.util.*;
import java.util.stream.Collectors;

import com.mdp.core.utils.ResponseHelper;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmTask;
import com.xm.core.service.XmGroupService;
import com.xm.core.service.XmTaskService;
import org.aspectj.weaver.ResolvedPointcutDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.mdp.mybatis.PageUtils;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.BaseUtils;
import com.mdp.core.utils.RequestUtils;
import com.xm.core.service.XmProductProjectLinkService;
import com.xm.core.entity.XmProductProjectLink;
/**
 * url编制采用rest风格,如对XM.xm_product_project_link 产品与项目的关联关系表，一般由产品经理挂接项目到产品上的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmProductProjectLink/add <br>
 *  查询: core/xmProductProjectLink/list<br>
 *  模糊查询: core/xmProductProjectLink/listKey<br>
 *  修改: core/xmProductProjectLink/edit <br>
 *  删除: core/xmProductProjectLink/del<br>
 *  批量删除: core/xmProductProjectLink/batchDel<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmProductProjectLink 表 XM.xm_product_project_link 当前主键(包括多主键): project_id; 
 ***/
@RestController("xm.core.xmProductProjectLinkController")
@RequestMapping(value="/**/core/xmProductProjectLink")
@Api(tags={"产品与项目的关联关系表，一般由产品经理挂接项目到产品上操作接口"})
public class XmProductProjectLinkController {
	
	static Logger logger =LoggerFactory.getLogger(XmProductProjectLinkController.class);
	
	@Autowired
	private XmProductProjectLinkService xmProductProjectLinkService;
	@Autowired
	XmGroupService xmGroupService;

	@Autowired
	XmTaskService xmTaskService;
	
	@ApiOperation( value = "查询产品与项目的关联关系表，一般由产品经理挂接项目到产品上信息列表",notes=" ") 
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProductProjectLink.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProductProjectLink( @RequestParam Map<String,Object> xmProductProjectLink){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProductProjectLink, "projectIds");
		PageUtils.startPage(xmProductProjectLink);
		List<Map<String,Object>>	xmProductProjectLinkList = xmProductProjectLinkService.selectListMapByWhere(xmProductProjectLink);	//列出XmProductProjectLink列表
		PageUtils.responePage(m, xmProductProjectLinkList);
		m.put("data",xmProductProjectLinkList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 

	@ApiOperation( value = "新增一条产品与项目的关联关系表，一般由产品经理挂接项目到产品上信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProductProjectLink.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProductProjectLink(@RequestBody XmProductProjectLink xmProductProjectLink) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功加入");
		try{
			User user = LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmProductProjectLink.getProductId())){
				return ResponseHelper.failed("productId-0","产品编号不能为空");
			}
			if(!StringUtils.hasText(xmProductProjectLink.getProjectId())){
				return ResponseHelper.failed("projectId-0","项目编号不能为空");
			}
			 if(xmProductProjectLinkService.selectOneObject(xmProductProjectLink) !=null ){
				tips.setFailureMsg("已加入，无需再添加");
				m.put("tips", tips);
				return m;
			}
			if(!xmGroupService.checkUserIsProductAdm(xmProductProjectLink.getProductId(),user.getUserid())){
				if(!xmGroupService.checkUserIsProjectAdm(xmProductProjectLink.getProjectId(),user.getUserid())){
					return ResponseHelper.failed("not-pm","您不是项目管理人员、也不是产品管理人员，无权关联");
				}
			};
			xmProductProjectLink.setCtime(new Date());
			xmProductProjectLink.setLinkStatus("1");
			xmProductProjectLink.setCuserid(user.getUserid());
			xmProductProjectLink.setCusername(user.getUsername());
			xmProductProjectLinkService.insert(xmProductProjectLink);
			m.put("data",xmProductProjectLink);
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

	@ApiOperation( value = "删除一条产品与项目的关联关系表，一般由产品经理挂接项目到产品上信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProductProjectLink(@RequestBody XmProductProjectLink xmProductProjectLink){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			User user = LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmProductProjectLink.getProductId())){
				return ResponseHelper.failed("productId-0","产品编号不能为空");
			}
			if(!StringUtils.hasText(xmProductProjectLink.getProjectId())){
				return ResponseHelper.failed("projectId-0","项目编号不能为空");
			}
			if(!xmGroupService.checkUserIsProductAdm(xmProductProjectLink.getProductId(),user.getUserid())){
				if(!xmGroupService.checkUserIsProjectAdm(xmProductProjectLink.getProjectId(),user.getUserid())){
					return ResponseHelper.failed("not-pm","您不是项目管理人员、也不是产品管理人员，无权取消关联");
				}
			};
			List<XmTask> tasks=xmTaskService.listTenTaskByProductId(xmProductProjectLink.getProductId());
			if(tasks!=null && tasks.size()>0){
				return ResponseHelper.failed("tasks-not-0","存在至少"+tasks.size()+"个任务与产品关联，不能移出.关联任务【"+tasks.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
			}
			xmProductProjectLinkService.deleteByPk(xmProductProjectLink);
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
	@ApiOperation( value = "根据主键修改一条产品与项目的关联关系表，一般由产品经理挂接项目到产品上信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProductProjectLink.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProductProjectLink(@RequestBody XmProductProjectLink xmProductProjectLink) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProductProjectLinkService.updateByPk(xmProductProjectLink);
			m.put("data",xmProductProjectLink);
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
	@ApiOperation( value = "根据主键列表批量删除产品与项目的关联关系表，一般由产品经理挂接项目到产品上信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProductProjectLink(@RequestBody List<XmProductProjectLink> xmProductProjectLinks) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProductProjectLinks.size()+"条数据"); 
		try{ 
			xmProductProjectLinkService.batchDelete(xmProductProjectLinks);
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
