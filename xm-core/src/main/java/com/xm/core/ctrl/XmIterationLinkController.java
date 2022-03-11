package com.xm.core.ctrl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mdp.core.utils.ResponseHelper;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmIterationLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.mdp.mybatis.PageUtils;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.xm.core.service.XmIterationLinkService;

/**
 * url编制采用rest风格,如对XM.xm_iteration_product_link 迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmIterationLink/add <br>
 *  查询: core/xmIterationLink/list<br>
 *  模糊查询: core/xmIterationLink/listKey<br>
 *  修改: core/xmIterationLink/edit <br>
 *  删除: core/xmIterationLink/del<br>
 *  批量删除: core/xmIterationLink/batchDel<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmIterationLink 表 XM.xm_iteration_product_link 当前主键(包括多主键): iteration_id,product_id; 
 ***/
@RestController("xm.core.xmIterationLinkController")
@RequestMapping(value="/**/core/xmIterationLink")
@Api(tags={"迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表操作接口"})
public class XmIterationLinkController {
	
	static Logger logger =LoggerFactory.getLogger(XmIterationLinkController.class);
	
	@Autowired
	private XmIterationLinkService xmIterationLinkService;
	 
		
 
	
	@ApiOperation( value = "查询迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表信息列表",notes=" ") 
	@ApiResponses({
		@ApiResponse(code = 200,response= XmIterationLink.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmIterationLink( @RequestParam Map<String,Object> xmIterationLink){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmIterationLink, "iterationIdsproductIds");
		PageUtils.startPage(xmIterationLink);
		List<Map<String,Object>>	xmIterationLinkList = xmIterationLinkService.selectListMapByWhere(xmIterationLink);	//列出XmIterationLink列表
		PageUtils.responePage(m, xmIterationLinkList);
		m.put("data",xmIterationLinkList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	@ApiOperation( value = "查询迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表信息列表",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200,response= XmIterationLink.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listWithProductInfo",method=RequestMethod.GET)
	public Map<String,Object> listWithProductInfo( @RequestParam Map<String,Object> xmIterationLink){
		Map<String,Object> m = new HashMap<>();
		RequestUtils.transformArray(xmIterationLink, "iterationIdsproductIds");
		PageUtils.startPage(xmIterationLink);
		List<Map<String,Object>>	xmIterationLinkList = xmIterationLinkService.listWithProductInfo(xmIterationLink);	//列出XmIterationLink列表
		PageUtils.responePage(m, xmIterationLinkList);
		m.put("data",xmIterationLinkList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	@ApiOperation( value = "查询迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表信息列表",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200,response= XmIterationLink.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listWithProjectInfo",method=RequestMethod.GET)
	public Map<String,Object> listWithProjectInfo( @RequestParam Map<String,Object> xmIterationLink){
		Map<String,Object> m = new HashMap<>();
		RequestUtils.transformArray(xmIterationLink, "iterationIdsproductIds");
		PageUtils.startPage(xmIterationLink);
		List<Map<String,Object>>	xmIterationLinkList = xmIterationLinkService.listWithProjectInfo(xmIterationLink);	//列出XmIterationLink列表
		PageUtils.responePage(m, xmIterationLinkList);
		m.put("data",xmIterationLinkList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	

	@ApiOperation( value = "新增一条迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response= XmIterationLink.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmIterationLink(@RequestBody XmIterationLink xmIterationLink) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{

			if(StringUtils.isEmpty(xmIterationLink.getIterationId())) {
			     return ResponseHelper.failed("iterationId-0","请上送迭代编号");
			}
			if(StringUtils.isEmpty(xmIterationLink.getProId())) {
				return ResponseHelper.failed("proId-0","请上送产品编号或项目编号");
			}

			if(StringUtils.isEmpty(xmIterationLink.getLtype())) {
				return ResponseHelper.failed("ltype-0","请上送关联类型");
			}
			if(xmIterationLinkService.selectOneObject(xmIterationLink) !=null ){
				tips.setFailureMsg("该产品或者项目已经在迭代中，无需再添加");
				m.put("tips", tips);
				return m;
			}
			User user= LoginUtils.getCurrentUserInfo();
			xmIterationLink.setCuserid(user.getUserid());
			xmIterationLink.setCusername(user.getUsername());
			xmIterationLink.setCtime(new Date());
			xmIterationLink.setLinkStatus("1");
			xmIterationLinkService.insert(xmIterationLink);
			m.put("data",xmIterationLink);
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

	@ApiOperation( value = "删除一条迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmIterationLink(@RequestBody XmIterationLink xmIterationLink){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			if(StringUtils.isEmpty(xmIterationLink.getIterationId())) {
				return ResponseHelper.failed("iterationId-0","请上送迭代编号");
			}
			if(StringUtils.isEmpty(xmIterationLink.getProId())) {
				return ResponseHelper.failed("proId-0","请上送产品编号或项目编号");
			}
			xmIterationLinkService.deleteByPk(xmIterationLink);
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
	@ApiOperation( value = "根据主键修改一条迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmIterationLink.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmIterationLink(@RequestBody XmIterationLink xmIterationLink) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmIterationLinkService.updateByPk(xmIterationLink);
			m.put("data",xmIterationLink);
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
	@ApiOperation( value = "根据主键列表批量删除迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmIterationLink(@RequestBody List<XmIterationLink> xmIterationLinks) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmIterationLinks.size()+"条数据"); 
		try{ 
			xmIterationLinkService.batchDelete(xmIterationLinks);
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
