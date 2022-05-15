package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.mybatis.PageUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmIterationLink;
import com.xm.core.entity.XmMenu;
import com.xm.core.entity.XmTask;
import com.xm.core.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	@Autowired
	private XmIterationService xmIterationService;


	@Autowired
	private XmTaskService xmTaskService;


	@Autowired
	private XmMenuService xmMenuService;

	@Autowired
	XmGroupService xmGroupService;

	
	@ApiOperation( value = "查询迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表信息列表",notes=" ")
	@ApiEntityParams(XmIterationLink.class)
	@ApiResponses({
		@ApiResponse(code = 200,response= XmIterationLink.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmIterationLink( @ApiIgnore @RequestParam Map<String,Object> xmIterationLink){
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
	public Map<String,Object> listWithProductInfo( @ApiIgnore @RequestParam Map<String,Object> xmIterationLink){
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
	@ApiEntityParams(XmIterationLink.class)
	@ApiResponses({
			@ApiResponse(code = 200,response= XmIterationLink.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listWithProjectInfo",method=RequestMethod.GET)
	public Map<String,Object> listWithProjectInfo( @ApiIgnore @RequestParam Map<String,Object> xmIterationLink){
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
			if("1".equals(xmIterationLink.getLtype())){
				if(!xmGroupService.checkUserIsProductAdm(xmIterationLink.getProId(),user.getUserid())){
					return ResponseHelper.failed("no-product-qx","您不是产品管理人员，无权将该产品与迭代关联");
				};
			}else if("0".equals(xmIterationLink.getLtype())){
				if(!xmGroupService.checkUserIsProjectAdm(xmIterationLink.getProId(),user.getUserid())){
					return ResponseHelper.failed("no-project-qx","您不是项目管理人员，无权将该项目与迭代关联");
				};
			}else{
				return ResponseHelper.failed("ltype-not-0|1","请上送正确的关联类型");
			}

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
			xmIterationLink=this.xmIterationLinkService.selectOneObject(xmIterationLink);
			if(xmIterationLink==null){
				return ResponseHelper.failed("data-0","该关联关系已不存在");
			}
			User user= LoginUtils.getCurrentUserInfo();
			if("1".equals(xmIterationLink.getLtype())){
				if(!xmGroupService.checkUserIsProductAdm(xmIterationLink.getProId(),user.getUserid())){
					return ResponseHelper.failed("no-product-qx","您不是产品管理人员，无权将该产品移出迭代");
				};
				//检查是否有需求关联这个迭代，如果有，不允许删除
				List<XmMenu> menus= xmMenuService.listTenMenuByProductIdAndIterationId(xmIterationLink.getProId(),xmIterationLink.getIterationId());
				if(menus!=null && menus.size()>0){
					return ResponseHelper.failed("menus-not-0","存在至少"+menus.size()+"个需求与迭代关联，不能移出.关联需求【"+menus.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
				}
			}else if("0".equals(xmIterationLink.getLtype())){
				if(!xmGroupService.checkUserIsProjectAdm(xmIterationLink.getProId(),user.getUserid())){
					return ResponseHelper.failed("no-project-qx","您不是项目管理人员，无权将该项目移出迭代");
				};
				//检查是否有任务关联这个迭代，如果有，不允许删除
				List<XmTask> tasks= xmTaskService.listTenTaskByProjectIdAndIterationId(xmIterationLink.getProId(),xmIterationLink.getIterationId());
				if(tasks!=null && tasks.size()>0){
					return ResponseHelper.failed("tasks-not-0","存在至少"+tasks.size()+"个任务与迭代关联，不能移出.关联任务【"+tasks.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
				}
			}else{
				return ResponseHelper.failed("ltype-not-0|1","请上送正确的关联类型");
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
