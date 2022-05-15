package com.xm.core.ctrl;

import com.alibaba.fastjson.JSON;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.BaseUtils;
import com.mdp.core.utils.NumberUtil;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.PubTool;
import com.xm.core.entity.XmMenu;
import com.xm.core.entity.XmTask;
import com.xm.core.queue.XmMenuSumParentsPushService;
import com.xm.core.service.XmGroupService;
import com.xm.core.service.XmMenuService;
import com.xm.core.service.XmRecordService;
import com.xm.core.service.XmTaskService;
import com.xm.core.vo.BatchChangeParentMenuVo;
import com.xm.core.vo.XmGroupVo;
import com.xm.core.vo.XmMenuVo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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
	private XmGroupService groupService;


	@Autowired
	XmMenuSumParentsPushService pushService;


	Map<String,Object> fieldsMap = BaseUtils.toMap(new XmMenu());
	
	@ApiOperation( value = "查询项目菜单表信息列表",notes="listXmMenu,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="menuId",value="菜单编号,主键",required=false),
		@ApiImplicitParam(name="menuName",value="菜单名称",required=false),
		@ApiImplicitParam(name="pmenuId",value="上级菜单",required=false),
		@ApiImplicitParam(name="productId",value="归属产品编号",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmMenu.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmMenu( @ApiIgnore @RequestParam Map<String,Object> xmMenu){
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
				if(pidPaths==null || pidPaths.length()<=2){
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
	public Map<String,Object> listWithState( @ApiIgnore @RequestParam Map<String,Object> xmMenu){
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
				if(pidPaths==null || pidPaths.length()<=2){
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
	public Map<String,Object> listWithPlan( @ApiIgnore @RequestParam Map<String,Object> xmMenu){
		return this.listWithState(xmMenu);
	}

	@RequestMapping(value="/getXmMenuAttDist",method=RequestMethod.GET)
	public Map<String,Object> getXmMenuAttDist( @ApiIgnore @RequestParam Map<String,Object> xmMenu){
		User user=LoginUtils.getCurrentUserInfo();
		xmMenu.put("branchId",user.getBranchId());
		List<Map<String,Object>> datas= this.xmMenuService.getXmMenuAttDist(xmMenu);
		return ResponseHelper.ok("ok","成功",datas);
	}

	@RequestMapping(value="/getXmMenuAgeDist",method=RequestMethod.GET)
	public Map<String,Object> getXmMenuAgeDist( @ApiIgnore @RequestParam Map<String,Object> xmMenu){
		User user=LoginUtils.getCurrentUserInfo();
		xmMenu.put("branchId",user.getBranchId());
		List<Map<String,Object>> datas= this.xmMenuService.getXmMenuAgeDist(xmMenu);
		return ResponseHelper.ok("ok","成功",datas);
	}

	@RequestMapping(value="/getXmMenuSort",method=RequestMethod.GET)
	public Map<String,Object> getXmMenuSort( @ApiIgnore @RequestParam Map<String,Object> xmMenu){
		User user=LoginUtils.getCurrentUserInfo();
		PageUtils.startPage(xmMenu);
		xmMenu.put("branchId",user.getBranchId());
		List<Map<String,Object>> datas= this.xmMenuService.getXmMenuSort(xmMenu);
		Map<String,Object> m=new HashMap<>();
		PageUtils.responePage(m,datas);
		m.put("data",datas);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}

	@RequestMapping(value="/listWithPhase",method=RequestMethod.GET)
	public Map<String,Object> listWithPhase( @ApiIgnore @RequestParam Map<String,Object> xmMenu){
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
				if(pidPaths==null || pidPaths.length()<=2){
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
			xmMenu.setStatus("0");
			xmMenu.setChildrenCnt(0);
			if(!StringUtils.hasText(xmMenu.getProposerId())){
				xmMenu.setProposerId(user.getUserid());
				xmMenu.setProposerName(user.getUsername());
			}
			xmMenu.setCtime(new Date());
			xmMenu.setLtime(new Date());
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
				List<String> ids=new ArrayList<>();
				ids.add(xmMenu.getMenuId());
					List<XmMenu> xmMenus=this.xmMenuService.selectListByIdsWithsChildrenCnt(ids);
					if(xmMenus==null || xmMenus.size()==0){
						return ResponseHelper.failed("data-0","数据不存在");
					}
				xmMenu=xmMenus.get(0);
					if(xmMenu.getChildrenCnt()!=null && xmMenu.getChildrenCnt()>0){
						return ResponseHelper.failed("hadChild","该需求有子需求，不能删除");
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

			if("1".equals(xmMenuDb.getNtype())){
				if("0".equals(xmMenu.getNtype()) && xmMenuDb.getChildrenCnt()!=null && xmMenuDb.getChildrenCnt()>0){
					return ResponseHelper.failed("ntype-not-right","当前为需求池，并且具有"+xmMenuDb.getChildrenCnt()+"个子需求池或子需求，不能变更为需求");
				}
			}else{
				if(xmMenuDb.getChildrenCnt()!=null && xmMenuDb.getChildrenCnt()>0){
					xmMenu.setNtype("1");
				}
			}
			xmMenu.setLtime(new Date());
			xmMenuService.updateSomeFieldByPk(xmMenu);
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
	@ApiOperation( value = "根据主键修改一条项目菜单表信息",notes="editXmMenu")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMenu.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmMenu_editSomeFields",name = "修改用户需求中的某些字段",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields(@RequestBody Map<String,Object> xmMenuMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			List<String> menuIds= (List<String>) xmMenuMap.get("menuIds");

			if(menuIds==null || menuIds.size()==0){
				ResponseHelper.failed("menuIds-0","menuIds不能为空");
			}
			XmMenu xmMenu= BaseUtils.fromMap(xmMenuMap,XmMenu.class);
			List<XmMenu> xmMenusDb=xmMenuService.selectListByIds(menuIds);
			if(xmMenusDb==null ||xmMenusDb.size()==0){
				ResponseHelper.failed("menus-0","该需求已不存在");
			}
			List<XmMenu> can=new ArrayList<>();
			List<XmMenu> no=new ArrayList<>();
			groupService.calcCanOpMenus(xmMenusDb,can,no);
			if(can.size()<=0){
				return ResponseHelper.failed("noqx","您无权修改选中的需求。");
			}
			Set<String> fields=new HashSet<>();
			fields.add("childrenCnt");
			fields.add("ntype");
			fields.add("pidPaths");
			for (String fieldName : xmMenuMap.keySet()) {
				if(fields.contains(fieldName)){
					return ResponseHelper.failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmMenuMap.keySet().stream().filter(i->fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmMenuMap.get(i) )).collect(Collectors.toSet());
			xmMenuMap.put("ltime",new Date());
			xmMenuService.editSomeFields(xmMenuMap);
			xmRecordService.addXmMenuRecord(xmMenu.getProductId(),xmMenu.getMenuId(),"修改产品需求","修改产品需求"+xmMenu.getMenuName(),"", JSON.toJSONString(xmMenu));

			//m.put("data",xmMenu);
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
			List<XmMenu> noExists=new ArrayList<>();
			List<String> hasChildMenus=new ArrayList<>();
			List<XmMenu> canDelList=new ArrayList<>();
			List<XmMenu> xmMenusDb=this.xmMenuService.selectListByIdsWithsChildrenCnt(xmMenus.stream().map(i->i.getMenuId()).collect(Collectors.toList()));
			for (XmMenu xmMenu : xmMenusDb) {
				boolean canDel=this.xmMenuService.checkCanDelAllChild(xmMenu,xmMenusDb);
				if(canDel){
					canDelList.add(xmMenu);
				}else{
					hasChildMenus.add(xmMenu.getMenuName());
				}
			}
			noExists=noExists.stream().filter(i->!xmMenusDb.stream().filter(k->k.getMenuId().equals(i.getMenuId())).findAny().isPresent()).collect(Collectors.toList());
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
			if(noExists.size()>0){
				msg.add("以下"+noExists.size()+"个需求已不存在，【"+noExists.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
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


	@ApiOperation( value = "批量修改需求的上级",notes="batchChangeParentMenu,仅需要上传主键字段")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmMenu_batchChangeParentMenu",name = "批量修改需求的上级",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchChangeParentMenu",method=RequestMethod.POST)
	public Map<String,Object> batchChangeParentMenu(@RequestBody BatchChangeParentMenuVo parentMenuVo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改");
		try{
			User user=LoginUtils.getCurrentUserInfo();

			if(parentMenuVo.getMenuIds()==null || parentMenuVo.getMenuIds().size()==0){
				tips.setFailureMsg("需求列表不能为空");
				m.put("tips", tips);
				return m;
			}
			if(!StringUtils.hasText(parentMenuVo.getPmenuId())){
				return ResponseHelper.failed("parentMenuid-0", "上级编号不能为空");
			}
			List<String> ids=parentMenuVo.getMenuIds().stream().collect(Collectors.toList());
			ids.add(parentMenuVo.getPmenuId());
			ids=ids.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
			List<XmMenu> xmMenus=this.xmMenuService.selectListByIds(ids);
			Optional<XmMenu> optional=xmMenus.stream().filter(i->i.getMenuId().equals(parentMenuVo.getPmenuId())).findAny();
			if(!optional.isPresent()){
				return ResponseHelper.failed("parentMenu-0", "上级不存在");
			}
			XmMenu parentMenu=optional.get();
			if(!"1".equals(parentMenu.getNtype())){
				return ResponseHelper.failed("parentMenu-ntype-not-1", "【"+parentMenu.getMenuName()+"】为需求，不能作为上级节点。请另选上级或者变更其为需求池节点");
			}
			Tips tips2=this.groupService.checkIsAdmOrTeamHeadOrAssByPtype(user,user.getUserid(),"1",parentMenu.getProductId(),null);
			if(!tips2.isOk()){
				return ResponseHelper.failed(tips2);
			}
			xmMenus=xmMenus.stream().filter(i->!i.getMenuId().equals(parentMenu.getMenuId())).collect(Collectors.toList());
			List<XmMenu> canOpxmMenus=xmMenus.stream().filter(i->!parentMenu.getMenuId().equals(i.getPmenuId())).collect(Collectors.toList());
			List<XmMenu> sameParentMenus=xmMenus.stream().filter(i->parentMenu.getMenuId().equals(i.getPmenuId())).collect(Collectors.toList());
			if(canOpxmMenus.size()==0){
				return ResponseHelper.failed("same-parent","所有需求均属于【"+parentMenu.getMenuName()+"】,无需再变更");
			}
			if(canOpxmMenus.stream().filter(i->!i.getProductId().equals(parentMenu.getProductId())).findAny().isPresent()){
				return ResponseHelper.failed("productId-not-same", "所有需求必须都是同一个产品之下");
			}

			Map<String,XmMenu> allowMenusDbMap=new HashMap<>();
			Map<String,XmMenu>  noAllowMenusDbMap=new HashMap<>();
			List<XmGroupVo> pgroups=groupService.getProductGroupVoList(parentMenu.getProductId());
			boolean isAdm=groupService.checkUserIsPmOrAssByPtype(user.getUserid(),"1",null,parentMenu.getProductId());
			if(!isAdm){
				for (XmMenu menu : canOpxmMenus) {
					boolean isHead=groupService.checkUserIsOtherUserTeamHeadOrAss(pgroups,menu.getMmUserid(),user.getUserid());
					if(!isHead){
						noAllowMenusDbMap.put(menu.getMenuId(),menu);
					}else {
						allowMenusDbMap.put(menu.getMenuId(),menu);
					}
				}
			}else{
				for (XmMenu task : canOpxmMenus) {
					allowMenusDbMap.put(task.getMenuId(),task);
				}
			}
			Map<String,XmMenu> allowMenusDbMap2=new HashMap<>();
			for (XmMenu t : allowMenusDbMap.values()) {
				if(!allowMenusDbMap.containsKey(t.getPmenuId())){
					allowMenusDbMap2.put(t.getMenuId(),t);
				}
			}
			Map<String,XmMenu> allowMenusDbMap3=new HashMap<>();
			for (XmMenu t : allowMenusDbMap2.values()) {
				boolean hasChildren=false;
				for (XmMenu t2 : allowMenusDbMap2.values()) {
					if(!t2.getMenuId().equals(t.getMenuId()) && t2.getPidPaths().indexOf(t.getPidPaths())>=0 ){
						hasChildren=true;
						break;
					}
				}
				if(hasChildren==false){
					allowMenusDbMap3.put(t.getMenuId(),t);
				}
			}
			if(allowMenusDbMap3.size()>0){
				this.xmMenuService.batchChangeParent(allowMenusDbMap3.values().stream().collect(Collectors.toList()),parentMenu);
 				this.xmRecordService.addXmMenuRecord(parentMenu.getProductId(),parentMenu.getMenuId(),"批量挂接子节点","成功将以下"+allowMenusDbMap3.size()+"个需求及其所有子项挂接到【"+parentMenu.getMenuName()+"】上,【"+allowMenusDbMap3.values().stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】;");

			}

			List<String> msgs=new ArrayList<>();
			if(allowMenusDbMap3.size()>0){
				msgs.add("成功将以下"+allowMenusDbMap3.size()+"个需求及其所有子项挂接到【"+parentMenu.getMenuName()+"】上");
			}
			if(noAllowMenusDbMap.size()>0){
				msgs.add("以下"+noAllowMenusDbMap.size()+"个需求无权限操作，【"+noAllowMenusDbMap.values().stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
			}
			if(sameParentMenus.size()>0){
				msgs.add("以下"+sameParentMenus.size()+"个需求已属于【"+parentMenu.getMenuName()+"】之下，无需变更，【"+sameParentMenus.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
			}
			if(allowMenusDbMap3.size()>0){
				tips.setOkMsg(msgs.stream().collect(Collectors.joining(" ")));
			}else{
				tips.setFailureMsg(msgs.stream().collect(Collectors.joining(" ")));
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
