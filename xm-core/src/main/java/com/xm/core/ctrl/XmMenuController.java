package com.xm.core.ctrl;

import com.alibaba.fastjson.JSON;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.NumberUtil;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.PubTool;
import com.xm.core.entity.XmMenu;
import com.xm.core.entity.XmProjectPhase;
import com.xm.core.entity.XmTask;
import com.xm.core.service.XmMenuService;
import com.xm.core.service.XmProjectGroupService;
import com.xm.core.service.XmRecordService;
import com.xm.core.service.XmTaskService;
import com.xm.core.vo.XmMenuVo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static com.mdp.core.utils.BaseUtils.map;

/**
 * url编制采用rest风格,如对XM.xm_menu 项目菜单表的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmMenu/add <br>
 *  查询: xm/xmMenu/list<br>
 *  模糊查询: xm/xmMenu/listKey<br>
 *  修改: xm/xmMenu/edit <br>
 *  删除: xm/xmMenu/del<br>
 *  批量删除: xm/xmMenu/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmMenu 表 XM.xm_menu 当前主键(包括多主键): menu_id; 
 ***/
@RestController("xm.core.xmMenuController")
@RequestMapping(value="/**/xm/core/xmMenu")
@Api(tags={"项目菜单表操作接口"})
public class XmMenuController {
	
	static Log logger=LogFactory.getLog(XmMenuController.class);
	
	@Autowired
	private XmMenuService xmMenuService;
	 
		
	@Autowired
	private XmTaskService xmTaskService;


	@Autowired
	private XmRecordService xmRecordService;

	@Autowired
	private XmProjectGroupService groupService;
	
	@ApiOperation( value = "查询项目菜单表信息列表",notes="listXmMenu,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="menuId",value="菜单编号,主键",required=false),
		@ApiImplicitParam(name="menuName",value="菜单名称",required=false),
		@ApiImplicitParam(name="pmenuId",value="上级菜单",required=false),
		@ApiImplicitParam(name="productId",value="归属产品编号",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmMenu.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmMenu( @RequestParam Map<String,Object> xmMenu){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmMenu, "menuIds");
		RequestUtils.transformArray(xmMenu, "tagIdList");
		PageUtils.startPage(xmMenu);
		String menuId= (String) xmMenu.get("menuId");
		Object menuIds=  xmMenu.get("menuIds");
		String projectId= (String) xmMenu.get("projectId");
		String mmUserid= (String) xmMenu.get("mmUserid");
		String pmenuId= (String) xmMenu.get("pmenuId");
		String productId= (String) xmMenu.get("productId");
		String excludeIterationId= (String) xmMenu.get("excludeIterationId");

		User user = LoginUtils.getCurrentUserInfo();

		xmMenu.put("userid",user.getUserid());
		if( !StringUtils.hasText(menuId) && !(StringUtils.hasText(projectId) || StringUtils.hasText(mmUserid)|| StringUtils.hasText(pmenuId)||menuIds!=null
				|| StringUtils.hasText(productId) || StringUtils.hasText(excludeIterationId)  ) ){
			xmMenu.put("compete",user.getUserid());
		}
		List<Map<String,Object>>	xmMenuList = xmMenuService.selectListMapByWhere(xmMenu);	//列出XmMenu列表
		PageUtils.responePage(m, xmMenuList);
		if("1".equals(xmMenu.get("withParents"))  && !"1".equals(xmMenu.get("isTop"))&& xmMenuList.size()>0){
			Set<String> pidPathsSet=new HashSet<>();
			Set<String> idSet=new HashSet<>();
			for (Map<String, Object> map : xmMenuList) {
				String id= (String) map.get("menuId");
				idSet.add(id);
				String pidPaths= (String) map.get("pidPaths");
				pidPaths=PubTool.getPidPaths(pidPaths,id);
				if(pidPaths.length()<=2){
					continue;
				}
				pidPathsSet.add(pidPaths);
			}

			if(pidPathsSet!=null && pidPathsSet.size()>0){
				List<Map<String,Object>> parentList=xmMenuService.selectListMapByWhere(map("pidPathsList",pidPathsSet.stream().collect(Collectors.toList())));
				parentList=parentList.stream().filter(i->!idSet.contains(i.get("menuId"))).collect(Collectors.toList());
				if(parentList!=null && parentList.size()>0){
					xmMenuList.addAll(parentList);
					m.put("total", NumberUtil.getInteger(m.get("total"),0)+parentList.size());
				}
			}
		}
		m.put("data",xmMenuList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	

	@RequestMapping(value="/listWithState",method=RequestMethod.GET)
	public Map<String,Object> listWithState( @RequestParam Map<String,Object> xmMenu){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmMenu, "menuIds");
		RequestUtils.transformArray(xmMenu, "tagIdList");
		PageUtils.startPage(xmMenu);
		Tips tips=new Tips("查询成功");
		String menuId= (String) xmMenu.get("menuId");
		Object menuIds=  xmMenu.get("menuIds");
		String projectId= (String) xmMenu.get("projectId");
		String mmUserid= (String) xmMenu.get("mmUserid");
		String pmenuId= (String) xmMenu.get("pmenuId");
		String productId= (String) xmMenu.get("productId");
		String excludeIterationId= (String) xmMenu.get("excludeIterationId");

		User user = LoginUtils.getCurrentUserInfo();

		xmMenu.put("userid",user.getUserid());
		if( !StringUtils.hasText(menuId) && !(StringUtils.hasText(projectId) || StringUtils.hasText(mmUserid)|| StringUtils.hasText(pmenuId)||menuIds!=null
				|| StringUtils.hasText(productId) || StringUtils.hasText(excludeIterationId)  ) ){
			xmMenu.put("compete",user.getUserid());
		}
		List<Map<String,Object>>	xmMenuList = xmMenuService.selectListMapByWhereWithState(xmMenu);	//列出XmMenu列表
		PageUtils.responePage(m, xmMenuList);
		if("1".equals(xmMenu.get("withParents"))  && !"1".equals(xmMenu.get("isTop"))&& xmMenuList.size()>0){
			Set<String> pidPathsSet=new HashSet<>();
			Set<String> idSet=new HashSet<>();
			for (Map<String, Object> map : xmMenuList) {
				String id= (String) map.get("menuId");
				idSet.add(id);
				String pidPaths= (String) map.get("pidPaths");
				pidPaths=PubTool.getPidPaths(pidPaths,id);
				if(pidPaths.length()<=2){
					continue;
				}
				pidPathsSet.add(pidPaths);
			}
			if(pidPathsSet!=null && pidPathsSet.size()>0){
				List<Map<String,Object>> parentList=xmMenuService.selectListMapByWhereWithState(map("pidPathsList",pidPathsSet.stream().collect(Collectors.toList())));
				parentList=parentList.stream().filter(i->!idSet.contains(i.get("menuId"))).collect(Collectors.toList());
				if(parentList!=null && parentList.size()>0){
					xmMenuList.addAll(parentList);
					m.put("total", NumberUtil.getInteger(m.get("total"),0)+parentList.size());
				}
			}
		}

		m.put("data",xmMenuList);
		m.put("tips", tips);
		return m;
	}
	@RequestMapping(value="/listWithPlan",method=RequestMethod.GET)
	public Map<String,Object> listWithPlan( @RequestParam Map<String,Object> xmMenu){
		Map<String,Object> m = new HashMap<>();
		RequestUtils.transformArray(xmMenu, "menuIds");
		RequestUtils.transformArray(xmMenu, "tagIdList");
		PageUtils.startPage(xmMenu);
		Tips tips=new Tips("查询成功");
		String menuId= (String) xmMenu.get("menuId");
		Object menuIds=  xmMenu.get("menuIds");
		String projectId= (String) xmMenu.get("projectId");
		String mmUserid= (String) xmMenu.get("mmUserid");
		String pmenuId= (String) xmMenu.get("pmenuId");
		String productId= (String) xmMenu.get("productId");
		String excludeIterationId= (String) xmMenu.get("excludeIterationId");

		User user = LoginUtils.getCurrentUserInfo();

		xmMenu.put("userid",user.getUserid());
		if( !StringUtils.hasText(menuId) && !(StringUtils.hasText(projectId) || StringUtils.hasText(mmUserid)|| StringUtils.hasText(pmenuId)||menuIds!=null
				|| StringUtils.hasText(productId) || StringUtils.hasText(excludeIterationId)  ) ){
			xmMenu.put("compete",user.getUserid());
		}
		List<Map<String,Object>>	xmMenuList = xmMenuService.selectListMapByWhereWithPlan(xmMenu);	//列出XmMenu列表
		PageUtils.responePage(m, xmMenuList);
		if("1".equals(xmMenu.get("withParents"))  && !"1".equals(xmMenu.get("isTop"))&& xmMenuList.size()>0){
			Set<String> pidPathsSet=new HashSet<>();
			Set<String> idSet=new HashSet<>();
			for (Map<String, Object> map : xmMenuList) {
				String id= (String) map.get("menuId");
				idSet.add(id);
				String pidPaths= (String) map.get("pidPaths");
				pidPaths=PubTool.getPidPaths(pidPaths,id);
				if(pidPaths.length()<=2){
					continue;
				}
				pidPathsSet.add(pidPaths);
			}
			if(pidPathsSet!=null && pidPathsSet.size()>0){
				List<Map<String,Object>> parentList=xmMenuService.selectListMapByWhereWithPlan(map("pidPathsList",pidPathsSet.stream().collect(Collectors.toList())));
				parentList=parentList.stream().filter(i->!idSet.contains(i.get("menuId"))).collect(Collectors.toList());
				if(parentList!=null && parentList.size()>0){
					xmMenuList.addAll(parentList);
					m.put("total", NumberUtil.getInteger(m.get("total"),0)+parentList.size());
				}
			}
		}

		m.put("data",xmMenuList);
		m.put("tips", tips);
		return m;
	}


	@RequestMapping(value="/listWithPhase",method=RequestMethod.GET)
	public Map<String,Object> listWithPhase( @RequestParam Map<String,Object> xmMenu){
		Map<String,Object> m = new HashMap<>();
		RequestUtils.transformArray(xmMenu, "menuIds");
		RequestUtils.transformArray(xmMenu, "tagIdList");
		PageUtils.startPage(xmMenu);
		Tips tips=new Tips("查询成功");
		String menuId= (String) xmMenu.get("menuId");
		Object menuIds=  xmMenu.get("menuIds");
		String projectId= (String) xmMenu.get("projectId");
		String mmUserid= (String) xmMenu.get("mmUserid");
		String pmenuId= (String) xmMenu.get("pmenuId");
		String productId= (String) xmMenu.get("productId");
		String excludeIterationId= (String) xmMenu.get("excludeIterationId");

		User user = LoginUtils.getCurrentUserInfo();

		xmMenu.put("userid",user.getUserid());
		if( !StringUtils.hasText(menuId) && !(StringUtils.hasText(projectId) || StringUtils.hasText(mmUserid)|| StringUtils.hasText(pmenuId)||menuIds!=null
				|| StringUtils.hasText(productId) || StringUtils.hasText(excludeIterationId)  ) ){
			xmMenu.put("compete",user.getUserid());
		}
		List<Map<String,Object>>	xmMenuList = xmMenuService.selectListMapByWhereWithPhase(xmMenu);	//列出XmMenu列表
		PageUtils.responePage(m, xmMenuList);
		if("1".equals(xmMenu.get("withParents"))  && !"1".equals(xmMenu.get("isTop"))&& xmMenuList.size()>0){
			Set<String> pidPathsSet=new HashSet<>();
			Set<String> idSet=new HashSet<>();
			for (Map<String, Object> map : xmMenuList) {
				String id= (String) map.get("menuId");
				idSet.add(id);
				String pidPaths= (String) map.get("pidPaths");
				pidPaths=PubTool.getPidPaths(pidPaths,id);
				if(pidPaths.length()<=2){
					continue;
				}
				pidPathsSet.add(pidPaths);
			}
			if(pidPathsSet!=null && pidPathsSet.size()>0){
				List<Map<String,Object>> parentList=xmMenuService.selectListMapByWhereWithPhase(map("pidPathsList",pidPathsSet.stream().collect(Collectors.toList())));
				parentList=parentList.stream().filter(i->!idSet.contains(i.get("menuId"))).collect(Collectors.toList());
				if(parentList!=null && parentList.size()>0){
					xmMenuList.addAll(parentList);
					m.put("total", NumberUtil.getInteger(m.get("total"),0)+parentList.size());
				}
			}
		}

		m.put("data",xmMenuList);
		m.put("tips", tips);
		return m;
	}
	/***/
	@ApiOperation( value = "新增一条项目菜单表信息",notes="addXmMenu,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMenu.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmMenu_add",name = "新增用户需求",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmMenu(@RequestBody XmMenu xmMenu) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmMenu.getMenuId())) {
				xmMenu.setMenuId(xmMenuService.createKey("menuId"));
			}else{
				 XmMenu xmMenuQuery = new  XmMenu(xmMenu.getMenuId());
				if(xmMenuService.countByWhere(xmMenuQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			User user= LoginUtils.getCurrentUserInfo();
			if(StringUtils.isEmpty(xmMenu.getMmUserid())) {
				xmMenu.setMmUserid(user.getUserid());
				xmMenu.setMmUsername(user.getUsername());
			}
			if(!groupService.calcCanOpMenus(xmMenu)){
				return ResponseHelper.failed("noqx","您无权新增需求。");
			}
			xmMenuService.parentIdPathsCalcBeforeSave(xmMenu);
			xmMenuService.insert(xmMenu);
			xmRecordService.addXmMenuRecord(xmMenu.getProductId(),xmMenu.getMenuId(),"新增产品需求","新增需求"+xmMenu.getMenuName());
			m.put("data",xmMenu);
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
	@ApiOperation( value = "删除一条项目菜单表信息",notes="delXmMenu,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@HasQx(value = "xm_core_xmMenu_del",name = "删除用户需求",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmMenu(@RequestBody XmMenu xmMenu){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			XmTask xmTask = new XmTask();
			xmTask.setMenuId(xmMenu.getMenuId());
			long taskCount=xmTaskService.countByWhere(xmTask);
			if(taskCount>0) {
				tips.setFailureMsg("存在"+taskCount+"个任务关联该需求，不允许删除");
			}else {
					xmMenu=this.xmMenuService.selectOneObject(xmMenu);
					if(xmMenu.getChildrenCnt()!=null && xmMenu.getChildrenCnt()>0){
						return ResponseHelper.failed("hadChild","该需求集有子需求，不能删除");
					}
					if(!groupService.calcCanOpMenus(xmMenu)){
						return ResponseHelper.failed("noqx","您无权删除此需求。");
					}
					xmMenuService.deleteByPk(xmMenu);
					xmRecordService.addXmMenuRecord(xmMenu.getProductId(),xmMenu.getMenuId(),"删除产品需求","删除需求"+xmMenu.getMenuName(),"",JSON.toJSONString(xmMenu));

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
	 
	
	/***/
	@ApiOperation( value = "根据主键修改一条项目菜单表信息",notes="editXmMenu")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMenu.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmMenu_edit",name = "修改用户需求",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmMenu(@RequestBody XmMenu xmMenu) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			if(!StringUtils.hasText(xmMenu.getMenuId())){
				ResponseHelper.failed("menuId-0","menuId不能为空");
			}
			XmMenu xmMenuDb=xmMenuService.selectOneObject(new XmMenu(xmMenu.getMenuId()));
			if(xmMenuDb==null){
				ResponseHelper.failed("menu-0","该需求不存在");
			}
			if(!groupService.calcCanOpMenus(xmMenuDb)){
				return ResponseHelper.failed("noqx","您无权修改此需求。");
			}
			if(StringUtils.hasText(xmMenu.getNtype())&&StringUtils.hasText(xmMenu.getNtype())&&StringUtils.hasText(xmMenuDb.getPmenuId())){
				if(!xmMenuDb.getNtype().equals(xmMenu.getNtype())){
					if(xmMenu.getNtype().equals("1")){
						XmMenu xmMenuParentDb=this.xmMenuService.selectOneObject(new XmMenu(xmMenuDb.getPmenuId()));
						if(xmMenuParentDb!=null){
							if(!"1".equals(xmMenuParentDb.getNtype())){
								ResponseHelper.failed("pmenu-ntype-0","上级需求"+xmMenuParentDb.getMenuName()+"不是需求集,不能下挂需求集");
							}
						}
					}
				}
			}
			xmMenuService.updateByPk(xmMenu);
			xmRecordService.addXmMenuRecord(xmMenu.getProductId(),xmMenu.getMenuId(),"修改产品需求","修改产品需求"+xmMenu.getMenuName(),"", JSON.toJSONString(xmMenu));

			m.put("data",xmMenu);
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
	@ApiOperation( value = "根据主键列表批量删除项目菜单表信息",notes="batchDelXmMenu,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmMenu_batchDel",name = "批量删除用户需求",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmMenu(@RequestBody List<XmMenu> xmMenus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmMenus.size()+"条数据"); 
		try{ 
			List<String> hasChildMenus=new ArrayList<>();
			List<XmMenu> canDelList=new ArrayList<>();
			List<XmMenu> xmMenusDb=this.xmMenuService.selectListByIds(xmMenus.stream().map(i->i.getMenuId()).collect(Collectors.toList()));
			for (XmMenu xmMenu : xmMenusDb) {
				boolean canDel=this.xmMenuService.checkCanDelAllChild(xmMenu,xmMenusDb);
				if(canDel){
					canDelList.add(xmMenu);
				}else{
					hasChildMenus.add(xmMenu.getMenuName());
				}
			}
			List<XmMenu> canDelResult=new ArrayList<>();
			List<XmMenu> noQxResult=new ArrayList<>();
			if(canDelList.size()>0) {
				groupService.calcCanOpMenus(canDelList,canDelResult,noQxResult);
				if(canDelResult.size()>0){
					xmMenuService.doBatchDelete(canDelResult);
 				}
			}
			List<String> msg=new ArrayList<>();
			msg.add("成功删除"+canDelResult.size()+"个需求信息。");
			if(hasChildMenus.size()>0 ) {
				msg.add("以下"+hasChildMenus.size()+"个需求存在子需求，不允许删除。【"+StringUtils.arrayToDelimitedString(hasChildMenus.toArray(), ",")+"】");
			}
			if(noQxResult.size()>0){
				msg.add("无权限操作以下"+noQxResult.size()+"个需求.【"+noQxResult.stream().map(i->i.getMenuName()).collect(Collectors.joining(",")) +"】");
			}
			if(canDelResult.size()==0){
				tips.setFailureMsg(msg.stream().collect(Collectors.joining(" ")));
			}else{
				tips.setOkMsg(msg.stream().collect(Collectors.joining(" ")));
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

	@HasQx(value = "xm_core_xmMenu_batchAdd",name = "批量新增用户需求",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchAdd",method=RequestMethod.POST)
	public Map<String,Object> batchAddXmMenu(@RequestBody List<XmMenu> xmMenus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增"+xmMenus.size()+"条数据"); 
		try{ 
			 
			if(xmMenus.size()>0) {
				List<XmMenu> canEdit=new ArrayList<>();
				List<XmMenu> noQx=new ArrayList<>();
				groupService.calcCanOpMenus(xmMenus,canEdit,noQx);
				if(canEdit.size()>0){
					this.xmMenuService.parentIdPathsCalcBeforeSave(canEdit);
					this.xmMenuService.doBatchInsert(canEdit);
					xmRecordService.addXmMenuRecord(canEdit,"批量新增产品需求","批量新增产品需求");
				}else{
					tips.setFailureMsg("您无权限新增需求。");
				}


			}else {
 				tips.setFailureMsg("没有数据可以新增，请上送数据");
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

	@HasQx(value = "xm_core_xmMenu_batchEdit",name = "批量修改用户需求",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchEdit",method=RequestMethod.POST)
	public Map<String,Object> batchEditXmMenu(@RequestBody List<XmMenuVo> xmMenus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改"+xmMenus.size()+"条数据"); 
		try{
			List<XmMenu> xmMenuList=xmMenus.stream().map(i->(XmMenu)i).collect(Collectors.toList());
			List<XmMenu> canEdit=new ArrayList<>();
			List<XmMenu> noQx=new ArrayList<>();
			groupService.calcCanOpMenus(xmMenuList,canEdit,noQx);
			if(canEdit.size()>0) {
				List<XmMenuVo> xmMenuVos=xmMenus.stream().filter(i->canEdit.stream().filter(k->k.getMenuId().equals(i.getMenuId())).findAny().isPresent()).collect(Collectors.toList());
				this.xmMenuService.parentIdPathsCalcBeforeSave(xmMenuVos.stream().map(i->(XmMenu)i).collect(Collectors.toList()));
				this.xmMenuService.batchInsertOrUpdate(xmMenuVos);
				xmRecordService.addXmMenuRecord(xmMenuList,"批量修改产品需求","批量修改产品需求 ");
			}else {
 				tips.setFailureMsg("您无权限修改数据");
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
}
