package com.xm.core.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.xm.core.service.XmIterationProductLinkService;

/**
 * url编制采用rest风格,如对XM.xm_iteration_product_link 迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmIterationProductLink/add <br>
 *  查询: core/xmIterationProductLink/list<br>
 *  模糊查询: core/xmIterationProductLink/listKey<br>
 *  修改: core/xmIterationProductLink/edit <br>
 *  删除: core/xmIterationProductLink/del<br>
 *  批量删除: core/xmIterationProductLink/batchDel<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmIterationProductLink 表 XM.xm_iteration_product_link 当前主键(包括多主键): iteration_id,product_id; 
 ***/
@RestController("xm.core.xmIterationProductLinkController")
@RequestMapping(value="/**/core/xmIterationProductLink")
@Api(tags={"迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表操作接口"})
public class XmIterationLinkController {
	
	static Logger logger =LoggerFactory.getLogger(XmIterationLinkController.class);
	
	@Autowired
	private XmIterationProductLinkService xmIterationProductLinkService;
	 
		
 
	
	@ApiOperation( value = "查询迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表信息列表",notes=" ") 
	@ApiResponses({
		@ApiResponse(code = 200,response= XmIterationLink.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmIterationProductLink( @RequestParam Map<String,Object> xmIterationProductLink){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmIterationProductLink, "iterationIdsproductIds");
		PageUtils.startPage(xmIterationProductLink);
		List<Map<String,Object>>	xmIterationProductLinkList = xmIterationProductLinkService.selectListMapByWhere(xmIterationProductLink);	//列出XmIterationProductLink列表
		PageUtils.responePage(m, xmIterationProductLinkList);
		m.put("data",xmIterationProductLinkList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	

	@ApiOperation( value = "新增一条迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response= XmIterationLink.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmIterationProductLink(@RequestBody XmIterationLink xmIterationProductLink) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
		    boolean createPk=false;
			if(StringUtils.isEmpty(xmIterationProductLink.getIterationId())) {
			    createPk=true;
				xmIterationProductLink.setIterationId(xmIterationProductLinkService.createKey("iterationId"));
			}
			if(StringUtils.isEmpty(xmIterationProductLink.getProductId())) {
			    createPk=true;
				xmIterationProductLink.setProductId(xmIterationProductLinkService.createKey("productId"));
			}
			if(createPk==false){
                 if(xmIterationProductLinkService.selectOneObject(xmIterationProductLink) !=null ){
                    tips.setFailureMsg("该产品已经在迭代中，无需再添加");
                    m.put("tips", tips);
                    return m;
                }
            }
			xmIterationProductLinkService.insert(xmIterationProductLink);
			m.put("data",xmIterationProductLink);
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
	public Map<String,Object> delXmIterationProductLink(@RequestBody XmIterationLink xmIterationProductLink){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmIterationProductLinkService.deleteByPk(xmIterationProductLink);
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
		@ApiResponse(code = 200,response=XmIterationProductLink.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmIterationProductLink(@RequestBody XmIterationProductLink xmIterationProductLink) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmIterationProductLinkService.updateByPk(xmIterationProductLink);
			m.put("data",xmIterationProductLink);
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
	public Map<String,Object> batchDelXmIterationProductLink(@RequestBody List<XmIterationProductLink> xmIterationProductLinks) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmIterationProductLinks.size()+"条数据"); 
		try{ 
			xmIterationProductLinkService.batchDelete(xmIterationProductLinks);
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
