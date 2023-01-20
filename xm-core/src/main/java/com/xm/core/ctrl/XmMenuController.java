package com.xm.core.ctrl;

import com.alibaba.fastjson.JSON;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.BaseUtils;
import com.mdp.core.utils.NumberUtil;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.msg.client.PushNotifyMsgService;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.sensitive.SensitiveWordService;
import com.xm.core.PubTool;
import com.xm.core.entity.XmMenu;
import com.xm.core.entity.XmProduct;
import com.xm.core.entity.XmTask;
import com.xm.core.queue.XmMenuSumParentsPushService;
import com.xm.core.service.*;
import com.xm.core.vo.BatchChangeParentMenuVo;
import com.xm.core.vo.XmGroupVo;
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
import static com.mdp.core.utils.ResponseHelper.failed;

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
	private XmProductService productService;

	@Autowired
	XmMenuSumParentsPushService pushService;


	@Autowired
	PushNotifyMsgService notifyMsgService;

	@Autowired
	XmMenuOperQxService menuOperQxService;
	@Autowired
	SensitiveWordService sensitiveWordService;


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
		RequestUtils.transformArray(xmMenu, "dclasss");
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
			Set<String> originIdSet=new HashSet<>();
			for (Map<String, Object> map : xmMenuList) {
				String id= (String) map.get("menuId");
				originIdSet.add(id);
				String pidPaths= (String) map.get("pidPaths");
				if(pidPaths==null || pidPaths.length()<=2){
					continue;
				}
				pidPathsSet.addAll(PubTool.getPidSet(pidPaths,id));
			}
			List<String> menusIds=pidPathsSet.stream().filter(i->!originIdSet.contains(i)).collect(Collectors.toList());
			if(menusIds!=null && menusIds.size()>0){
				List<Map<String,Object>> parentList=xmMenuService.selectListMapByWhere(map("menuIds",menusIds));
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
		RequestUtils.transformArray(xmMenu, "dclasss");
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
			Set<String> originIdSet=new HashSet<>();
			for (Map<String, Object> map : xmMenuList) {
				String id= (String) map.get("menuId");
				originIdSet.add(id);
				String pidPaths= (String) map.get("pidPaths");
				if(pidPaths==null || pidPaths.length()<=2){
					continue;
				}
				pidPathsSet.addAll(PubTool.getPidSet(pidPaths,id));
			}
			List<String> menusIds=pidPathsSet.stream().filter(i->!originIdSet.contains(i)).collect(Collectors.toList());
			if(menusIds!=null && menusIds.size()>0){
				List<Map<String,Object>> parentList=xmMenuService.selectListMapByWhereWithState(map("menuIds",menusIds));
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

	/***/
	@ApiOperation( value = "新增一条项目菜单表信息",notes="addXmMenu,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMenu.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmMenu_add",name = "新增用户需求",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
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
			Set<String> words=sensitiveWordService.getSensitiveWord(xmMenu.getMenuName());
			if(words!=null && words.size()>0){
				return failed("name-sensitive-word","名字有敏感词"+words+",请修改后再提交");
			}
			words=sensitiveWordService.getSensitiveWord(xmMenu.getRemark());
			if(words!=null && words.size()>0){
				return failed("remark-sensitive-word","备注中有敏感词"+words+",请修改后再提交");
			}
			if(!StringUtils.hasText(xmMenu.getMenuName())){
				return failed("menuName-0","需求名称不能为空");
			}

			if(!StringUtils.hasText(xmMenu.getProductId())){
				return failed("productId-0","需求归属产品不能为空");
			}
			User user= LoginUtils.getCurrentUserInfo();
			if(StringUtils.isEmpty(xmMenu.getMmUserid())) {
				xmMenu.setMmUserid(user.getUserid());
				xmMenu.setMmUsername(user.getUsername());
			}
			if(!StringUtils.hasText(xmMenu.getPmenuId())|| "0".equals(xmMenu.getPmenuId())){
				if(!"1".equals(xmMenu.getDclass())){
					return ResponseHelper.failed("dclass-not-1","一级需求目录只能是史诗");
				}
			}

			XmProduct xmProduct= productService.getProductFromCache(xmMenu.getProductId());
			if(xmProduct==null){
				return ResponseHelper.failed("data-0","产品已不存在");
			}
			tips=groupService.checkProductQx(xmProduct,1,user);
			if(!tips.isOk()){
				return failed(tips);
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
			notifyMsgService.pushMsg(user,xmMenu.getMmUserid(),xmMenu.getMmUsername(),"4",xmMenu.getProductId(),xmMenu.getMenuId(),"您成为需求【"+xmMenu.getMenuName()+"】的负责人，请跟进需求！");

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
	@HasQx(value = "xm_core_xmMenu_del",name = "删除用户需求",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmMenu(@RequestBody XmMenu xmMenu){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			User user=LoginUtils.getCurrentUserInfo();
			XmTask xmTask = new XmTask();
			if(StringUtils.isEmpty(xmMenu.getMenuId())){
				return ResponseHelper.failed("menuId-0","需求编号不能为空");
			}
			xmTask.setMenuId(xmMenu.getMenuId());
			long taskCount=xmTaskService.countByWhere(xmTask);
			if(taskCount>0) {
				tips.setFailureMsg("存在"+taskCount+"个任务关联该需求，不允许删除");
				return ResponseHelper.failed(tips);
			}else {
				XmMenu xmMenuDb=this.xmMenuService.selectOneById(xmMenu.getMenuId());
				if(xmMenuDb==null){
					return ResponseHelper.failed("data-0","该需求已不存在");
				}
				XmMenu xmMenuCount=new XmMenu();
				xmMenuCount.setPmenuId(xmMenu.getMenuId());
				long childrenCnt=this.xmMenuService.countByWhere(xmMenuCount);
				if(childrenCnt>0){
					return ResponseHelper.failed("childrenCnt-1","存在"+childrenCnt+"个子需求，不允许删除,请先删除子需求");
				}
				XmProduct xmProduct= productService.getProductFromCache(xmMenuDb.getProductId());
				if(xmProduct==null){
					return ResponseHelper.failed("product-data-0","产品已不存在");
				}
				tips=groupService.checkProductQx(xmProduct,1,user,xmMenuDb.getMmUserid());
				if(!tips.isOk()){
					return failed(tips);
				}
				xmMenuService.deleteByPk(xmMenu);
				xmRecordService.addXmMenuRecord(xmMenuDb.getProductId(),xmMenu.getMenuId(),"删除产品需求","删除需求"+xmMenuDb.getMenuName(),"",JSON.toJSONString(xmMenu));

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
	@HasQx(value = "xm_core_xmMenu_edit",name = "修改用户需求",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmMenu(@RequestBody XmMenu xmMenu) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			User user=LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmMenu.getMenuId())){
				ResponseHelper.failed("menuId-0","menuId不能为空");
			}
			XmMenu xmMenuDb=this.xmMenuService.selectOneById(xmMenu.getMenuId());
			XmProduct xmProduct= productService.getProductFromCache(xmMenuDb.getProductId());
			if(xmProduct==null){
				return ResponseHelper.failed("product-data-0","产品已不存在");
			}
			tips=groupService.checkProductQx(xmProduct,1,user,xmMenuDb.getMmUserid());
			if(!tips.isOk()){
				return failed(tips);
			}

			if("1".equals(xmMenuDb.getNtype())){
				if("0".equals(xmMenu.getNtype()) && xmMenuDb.getChildrenCnt()!=null && xmMenuDb.getChildrenCnt()>0){
					return ResponseHelper.failed("ntype-not-right","当前为"+("1".equals(xmMenuDb.getDclass())?"史诗":"特性")+"，并且具有"+xmMenuDb.getChildrenCnt()+"个子项，不能变更为故事");
				}
			}else{
				if(xmMenuDb.getChildrenCnt()!=null && xmMenuDb.getChildrenCnt()>0){
					xmMenu.setNtype("1");
				}
			}
			xmMenu.setLtime(new Date());
			xmMenuService.updateSomeFieldByPk(xmMenu);
			xmRecordService.addXmMenuRecord(xmMenuDb.getProductId(),xmMenuDb.getMenuId(),"修改产品需求","修改产品需求"+xmMenuDb.getMenuName(),JSON.toJSONString(xmMenu),"");

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
	@HasQx(value = "xm_core_xmMenu_editSomeFields",name = "修改用户需求中的某些字段",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields(@RequestBody Map<String,Object> xmMenuMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			User user=LoginUtils.getCurrentUserInfo();
			List<String> menuIds= (List<String>) xmMenuMap.get("menuIds");

			if(menuIds==null || menuIds.size()==0){
				return ResponseHelper.failed("menuIds-0","menuIds不能为空");
			}

			Set<String> fields=new HashSet<>();
			fields.add("childrenCnt");
			fields.add("ntype");
			fields.add("pidPaths");
			fields.add("pmenuId");
			for (String fieldName : xmMenuMap.keySet()) {
				if(fields.contains(fieldName)){
					return ResponseHelper.failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}

			Set<String> fieldKey=xmMenuMap.keySet().stream().filter(i->fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmMenuMap.get(i) )).collect(Collectors.toSet());
			if(fieldKey.size()<=0) {
				return ResponseHelper.failed("fieldKey-0","没有需要更新的字段");
			}

			XmMenu xmMenu= BaseUtils.fromMap(xmMenuMap,XmMenu.class);
			List<XmMenu> xmMenusDb=this.xmMenuService.selectListByIds(menuIds);
			if(xmMenusDb==null ||xmMenusDb.size()==0){
				return ResponseHelper.failed("menus-0","需求均已不存在");
			}
			XmMenu xmMenuDb=xmMenusDb.get(0);
			if(xmMenusDb.stream().filter(k->!xmMenuDb.getProductId().equals(k.getProductId())).findAny().isPresent()){
				return ResponseHelper.failed("no-same-productId","批量操作只能在同一个产品进行。");
			}

			XmProduct xmProduct= productService.getProductFromCache(xmMenuDb.getProductId());
			if(xmProduct==null){
				return ResponseHelper.failed("product-data-0","产品已不存在");
			}
			Map<String,List<XmGroupVo>> groupsMap=new HashMap<>();
			tips=groupService.checkProductQx(groupsMap,xmProduct,1,user);
			if(!tips.isOk()){
				return failed(tips);
			}
			if(xmMenuMap.containsKey("mmUserid")){
				String mmUserid= (String) xmMenuMap.get("mmUserid");
				String mmUsername= (String) xmMenuMap.get("mmUsername");
				if(!user.getUserid().equals(mmUserid)){
					tips=groupService.checkProductQx(groupsMap,xmProduct,1,user,mmUserid);
					if(!tips.isOk()){
						return failed(tips);
					}
				}
			}
			List<XmMenu> canOper=new ArrayList<>();
			List<XmMenu> noOper=new ArrayList<>();
			Map<String,Tips> noOperTips=new HashMap<>();
			for (XmMenu xm : xmMenusDb) {
				tips=groupService.checkProductQx(groupsMap,xmProduct,1,user,xm.getMmUserid());
				if(tips.isOk()){
					canOper.add(xm);
				}else{
					noOper.add(xm);
					noOperTips.put(tips.getMsg(),tips);
				}
			}
			if(canOper.size()>0){
				xmMenuMap.put("ltime",new Date());
				xmMenuMap.put("ids",canOper.stream().map(k->k.getMenuId()).collect(Collectors.toList()));
				xmMenuService.editSomeFields(xmMenuMap);
				if(xmMenuMap.containsKey("mmUserid")){
					for (XmMenu menu : canOper) {
						notifyMsgService.pushMsg(user,xmMenu.getMmUserid(),xmMenu.getMmUsername(),"4",menu.getProductId(),menu.getMenuId(),"您成为需求【"+menu.getMenuName()+"】的负责人，请跟进需求！");
					}

				}

				xmMenuMap.remove("ltime");
				xmMenuMap.remove("menuIds");
				String json=JSON.toJSONString(xmMenu);
				for (XmMenu canDb : canOper) {

					xmRecordService.addXmMenuRecord(canDb.getProductId(),canDb.getMenuId(),"修改产品需求","修改产品需求"+canDb.getMenuName(),json, "");
				}
			}

			List<String> msgs=new ArrayList<>();
			if(canOper.size()>0){
				msgs.add(String.format("修改了%s个需求。",canOper.size()));
			}
			if(noOper.size()>0){
				msgs.add(String.format("其中%s个需求，无权限修改。原因【%s】",noOper.size(),noOperTips.keySet().stream().collect(Collectors.joining(";"))));
			}
			if(canOper.size()>0){
				tips.setOkMsg(msgs.stream().collect(Collectors.joining()));
			}else{
				tips.setFailureMsg(msgs.stream().collect(Collectors.joining()));
			}
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
	@HasQx(value = "xm_core_xmMenu_batchDel",name = "批量删除用户需求",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmMenu(@RequestBody List<XmMenu> xmMenus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmMenus.size()+"条数据"); 
		try{
			User user=LoginUtils.getCurrentUserInfo();
			List<String> hasChildMenus=new ArrayList<>();
			List<XmMenu> canDelList=new ArrayList<>();
			List<String> menuIds=xmMenus.stream().map(k->k.getMenuId()).collect(Collectors.toSet()).stream().collect(Collectors.toList());
			if(menuIds==null||menuIds.size()<=0){
				return ResponseHelper.failed("menuIds-0","需求编号不能为空");
			}
			List<XmMenu> xmMenusDb=this.xmMenuService.selectListByIdsWithsChildrenCnt(menuIds);
			if(xmMenusDb==null ||xmMenusDb.size()==0){
				return ResponseHelper.failed("menus-0","需求均已不存在");
			}
			XmMenu xmMenuDb=xmMenusDb.get(0);
			if(xmMenusDb.stream().filter(k->!xmMenuDb.getProductId().equals(k.getProductId())).findAny().isPresent()){
				return ResponseHelper.failed("no-same-productId","批量操作只能在同一个产品进行。");
			}

			List<XmMenu> canOper=new ArrayList<>();
			List<XmMenu> noOper=new ArrayList<>();
			Map<String,Tips> noOperTips=new HashMap<>();
			Map<String,List<XmGroupVo>> groupsMap=new HashMap<>();
			XmProduct xmProduct= productService.getProductFromCache(xmMenuDb.getProductId());
			if(xmProduct==null){
				return ResponseHelper.failed("product-data-0","产品已不存在");
			}
			for (XmMenu xm : xmMenusDb) {
				tips=groupService.checkProductQx(groupsMap,xmProduct,1,user,xm.getMmUserid());
				if(tips.isOk()){
					canOper.add(xm);
				}else{
					noOper.add(xm);
					noOperTips.put(tips.getMsg(),tips);
				}
			}

			if(canOper.size()>0){
				for (XmMenu xmMenu : canOper) {
					boolean canDel=this.xmMenuService.checkCanDelAllChild(xmMenu,canOper);
					if(canDel){
						canDelList.add(xmMenu);
					}else{
						hasChildMenus.add(xmMenu.getMenuName());
					}
				}
				if(canDelList.size()>0) {
					xmMenuService.doBatchDelete(canDelList);
				}
				for (XmMenu canDb : canDelList) {
					xmRecordService.addXmMenuRecord(canDb.getProductId(),canDb.getMenuId(),"删除产品需求","删除产品需求"+canDb.getMenuName(), "",JSON.toJSONString(canDb));
				}
			}


			List<String> msgs=new ArrayList<>();
			if(canDelList.size()>0){
				msgs.add(String.format("修改了%s个需求。",canDelList.size()));
			}
			if(noOper.size()>0){
				msgs.add(String.format("其中%s个需求，无权限删除。原因【%s】",noOper.size(),noOperTips.keySet().stream().collect(Collectors.joining(";"))));
			}
			if(hasChildMenus.size()>0){
				msgs.add(String.format("其中%s个需求，存在子需求，不能删除。分别是【%s】",hasChildMenus.size(),hasChildMenus.stream().collect(Collectors.joining(","))));
			}
			if(canDelList.size()>0){
				tips.setOkMsg(msgs.stream().collect(Collectors.joining()));
			}else{
				tips.setFailureMsg(msgs.stream().collect(Collectors.joining()));
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

	@HasQx(value = "xm_core_xmMenu_batchAdd",name = "批量新增用户需求",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/batchAdd",method=RequestMethod.POST)
	public Map<String,Object> batchAddXmMenu(@RequestBody List<XmMenu> xmMenus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增"+xmMenus.size()+"条数据"); 
		try{ 
			 
			if(xmMenus.size()>0) {
				List<XmMenu> canEdit=new ArrayList<>();
				List<XmMenu> noQx=new ArrayList<>();
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



	@ApiOperation( value = "批量修改需求的上级",notes="batchChangeParentMenu,仅需要上传主键字段")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmMenu_batchChangeParentMenu",name = "批量修改需求的上级",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/batchChangeParentMenu",method=RequestMethod.POST)
	public Map<String,Object> batchChangeParentMenu(@RequestBody BatchChangeParentMenuVo parentMenuVo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改");
		try{
			User user=LoginUtils.getCurrentUserInfo();

			if(parentMenuVo.getMenuIds()==null || parentMenuVo.getMenuIds().size()==0){
				tips.setFailureMsg("需求列表不能为空");
				m.put("tips", tips);
				ResponseHelper.failed("menuIds-0", "需求列表编号不能为空");
			}
			if(!StringUtils.hasText(parentMenuVo.getPmenuId())){
				return ResponseHelper.failed("parentMenuid-0", "上级编号不能为空");
			}

			List<String> ids=parentMenuVo.getMenuIds().stream().collect(Collectors.toList());
			ids.add(parentMenuVo.getPmenuId());
			ids=ids.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
			List<XmMenu> xmMenusDb=this.xmMenuService.selectListByIds(ids);
			if(xmMenusDb==null ||xmMenusDb.size()==0){
				return ResponseHelper.failed("menus-0","需求均已不存在");
			}
			XmMenu xmMenuDb=xmMenusDb.get(0);
			if(xmMenusDb.stream().filter(k->!xmMenuDb.getProductId().equals(k.getProductId())).findAny().isPresent()){
				return ResponseHelper.failed("no-same-productId","批量操作只能在同一个产品进行。");
			}
			Optional<XmMenu> optional=xmMenusDb.stream().filter(k->k.getMenuId().equals(parentMenuVo.getPmenuId())).findAny();
			if(!optional.isPresent()){
				return ResponseHelper.failed("no-parent","上级需求不存在");
			}
			XmMenu parentDb=optional.get();
			if( !"1".equals(parentDb.getDclass()) && !"2".equals(parentDb.getDclass()) && !"0".equals(parentDb.getDclass())){
				return ResponseHelper.failed("parentMenu-dclass-not-1", "【"+parentDb.getMenuName()+"】为故事，不能作为上级节点。请另选上级。");
			}
			List<XmMenu> canOper=new ArrayList<>();
			List<XmMenu> noOper=new ArrayList<>();
			Map<String,Tips> noOperTips=new HashMap<>();
			Map<String,List<XmGroupVo>> groupsMap=new HashMap<>();
			XmProduct xmProduct= productService.getProductFromCache(xmMenuDb.getProductId());
			if(xmProduct==null){
				return ResponseHelper.failed("product-data-0","产品已不存在");
			}
			for (XmMenu xm : xmMenusDb) {
				tips=groupService.checkProductQx(groupsMap,xmProduct,1,user,xm.getMmUserid());
				if(tips.isOk()){
					canOper.add(xm);
				}else{
					if(xm.getMenuId().equals(parentDb.getMenuId())){
						return ResponseHelper.failed("pmenu-id-0",String.format("无权限挂接需求到【%s】,原因【%s】",xm.getMenuName(),tips.getMsg()));
					}
					noOper.add(xm);
					noOperTips.put(tips.getMsg(),tips);
				}
			}

			xmMenusDb=canOper.stream().filter(i->!i.getMenuId().equals(parentDb.getMenuId())).collect(Collectors.toList());
			List<XmMenu> canOpxmMenus=xmMenusDb.stream().filter(i->!parentDb.getMenuId().equals(i.getPmenuId())).collect(Collectors.toList());
			List<XmMenu> sameParentMenus=xmMenusDb.stream().filter(i->parentDb.getMenuId().equals(i.getPmenuId())).collect(Collectors.toList());
			if(canOpxmMenus.size()==0){
				return ResponseHelper.failed("same-parent","所有需求均属于【"+parentDb.getMenuName()+"】,无需再变更");
			}
			if(canOpxmMenus.stream().filter(i->!i.getProductId().equals(parentDb.getProductId())).findAny().isPresent()){
				return ResponseHelper.failed("productId-not-same", "所有需求必须都是同一个产品之下");
			}

			Map<String,XmMenu> allowMenusDbMap=new HashMap<>();
			Map<String,XmMenu>  noAllowMenusDbMap=new HashMap<>();
			for (XmMenu menu : canOpxmMenus) {
				allowMenusDbMap.put(menu.getMenuId(),menu);
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
				this.xmMenuService.batchChangeParent(allowMenusDbMap3.values().stream().collect(Collectors.toList()),parentDb);
 				this.xmRecordService.addXmMenuRecord(parentDb.getProductId(),parentDb.getMenuId(),"批量挂接子节点","成功将以下"+allowMenusDbMap3.size()+"个需求及其所有子项挂接到【"+parentDb.getMenuName()+"】上,【"+allowMenusDbMap3.values().stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】;");

			}

			List<String> msgs=new ArrayList<>();
			if(allowMenusDbMap3.size()>0){
				msgs.add("成功将以下"+allowMenusDbMap3.size()+"个需求及其所有子项挂接到【"+parentDb.getMenuName()+"】上");
			}
			if(noAllowMenusDbMap.size()>0){
				msgs.add("以下"+noAllowMenusDbMap.size()+"个需求无权限操作，【"+noAllowMenusDbMap.values().stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
			}
			if(sameParentMenus.size()>0){
				msgs.add("以下"+sameParentMenus.size()+"个需求已属于【"+parentDb.getMenuName()+"】之下，无需变更，【"+sameParentMenus.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
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
