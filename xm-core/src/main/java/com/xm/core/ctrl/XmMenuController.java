package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmMenu;
import com.xm.core.entity.XmTask;
import com.xm.core.service.XmMenuService;
import com.xm.core.service.XmTaskService;
import com.xm.core.vo.XmMenuVo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		PageUtils.startPage(xmMenu);
		List<Map<String,Object>>	xmMenuList = xmMenuService.selectListMapByWhere(xmMenu);	//列出XmMenu列表
		PageUtils.responePage(m, xmMenuList);
		m.put("data",xmMenuList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	

	@RequestMapping(value="/listWithState",method=RequestMethod.GET)
	public Map<String,Object> listWithState( @RequestParam Map<String,Object> xmMenu){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmMenu, "menuIds");
		PageUtils.startPage(xmMenu);
		Tips tips=new Tips("查询成功"); 
			List<Map<String,Object>>	xmMenuList = xmMenuService.selectListMapByWhereWithState(xmMenu);	//列出XmMenu列表
			PageUtils.responePage(m, xmMenuList);
			m.put("data",xmMenuList);  
		m.put("tips", tips);
		return m;
	}
	@RequestMapping(value="/listWithPlan",method=RequestMethod.GET)
	public Map<String,Object> listWithPlan( @RequestParam Map<String,Object> xmMenu){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmMenu, "menuIds");
		PageUtils.startPage(xmMenu);
		Tips tips=new Tips("查询成功");
		if(StringUtils.isEmpty(xmMenu.get("projectId"))) {
			tips.setFailureMsg("项目编号projectId必传");
		}else {
			List<Map<String,Object>>	xmMenuList = xmMenuService.selectListMapByWhereWithPlan(xmMenu);	//列出XmMenu列表
			PageUtils.responePage(m, xmMenuList);
			m.put("data",xmMenuList);
		}

		
		m.put("tips", tips);
		return m;
	}
	/***/
	@ApiOperation( value = "新增一条项目菜单表信息",notes="addXmMenu,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMenu.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmMenu_add",name = "新增用户故事",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
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
			xmMenuService.insert(xmMenu);
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
	@HasQx(value = "xm_core_xmMenu_del",name = "删除用户故事",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmMenu(@RequestBody XmMenu xmMenu){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			XmTask xmTask = new XmTask();
			xmTask.setMenuId(xmMenu.getMenuId());
			long taskCount=xmTaskService.countByWhere(xmTask);
			if(taskCount>0) {
				tips.setFailureMsg("存在"+taskCount+"个任务关联该故事，不允许删除");
			}else {
				XmMenu query=new XmMenu();
				query.setPmenuId(xmMenu.getMenuId());
				long childCount=xmMenuService.countByWhere(query);
				if(childCount>0) { 
					tips.setFailureMsg("存在"+childCount+"个子故事关联该故事，不允许删除");
				}else {
					xmMenuService.deleteByPk(xmMenu);
				}
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
	@HasQx(value = "xm_core_xmMenu_edit",name = "修改用户故事",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmMenu(@RequestBody XmMenu xmMenu) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmMenuService.updateByPk(xmMenu);
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
	@HasQx(value = "xm_core_xmMenu_batchDel",name = "批量删除用户故事",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmMenu(@RequestBody List<XmMenu> xmMenus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmMenus.size()+"条数据"); 
		try{ 
			List<String> hasTasksMenus=new ArrayList<>();
			List<String> hasChildMenus=new ArrayList<>();
			List<XmMenu> canDelList=new ArrayList<>();
			for (XmMenu xmMenu : xmMenus) {
				XmMenu query=new XmMenu();
				query.setPmenuId(xmMenu.getMenuId());
				long childCount=xmMenuService.countByWhere(query);
				if(childCount>0) {
					hasChildMenus.add(xmMenu.getMenuName());
				}else {
					XmTask xmTask = new XmTask();
					xmTask.setMenuId(xmMenu.getMenuId());
					long taskCount=xmTaskService.countByWhere(xmTask);
					if(taskCount>0) { 
						hasTasksMenus.add(xmMenu.getMenuName());
					}else {  
						canDelList.add(xmMenu);
					}

					
				}
			}
			if(canDelList.size()>0) {
				xmMenuService.batchDelete(canDelList);
			}
			String msg="成功删除"+canDelList.size()+"个故事信息";
			if(hasTasksMenus.size()>0 ) {
				msg=msg+",【"+StringUtils.arrayToDelimitedString(hasTasksMenus.toArray(), ",")+"】存在任务关联，不允许删除";
			} 
			if(hasChildMenus.size()>0 ) {
				msg=msg+",【"+StringUtils.arrayToDelimitedString(hasChildMenus.toArray(), ",")+"】存在子故事，不允许删除";
			} 
			tips.setOkMsg(msg);
			
			
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

	@HasQx(value = "xm_core_xmMenu_batchAdd",name = "批量新增用户故事",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchAdd",method=RequestMethod.POST)
	public Map<String,Object> batchAddXmMenu(@RequestBody List<XmMenu> xmMenus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增"+xmMenus.size()+"条数据"); 
		try{ 
			 
			if(xmMenus.size()>0) {
				this.xmMenuService.batchInsert(xmMenus);
				
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

	@HasQx(value = "xm_core_xmMenu_batchEdit",name = "批量修改用户故事",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchEdit",method=RequestMethod.POST)
	public Map<String,Object> batchEditXmMenu(@RequestBody List<XmMenuVo> xmMenus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改"+xmMenus.size()+"条数据"); 
		try{ 
			 
			if(xmMenus.size()>0) {
				this.xmMenuService.batchInsertOrUpdate(xmMenus);
				
 			}else {
 				tips.setFailureMsg("没有数据可以修改，请上送数据");
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
