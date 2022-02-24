package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.mybatis.PageUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmIteration;
import com.xm.core.entity.XmIterationMenu;
import com.xm.core.entity.XmMenu;
import com.xm.core.service.XmIterationMenuService;
import com.xm.core.service.XmMenuService;
import com.xm.core.service.push.XmMenuPushMsgService;
import com.xm.core.vo.XmIterationMenuVo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * url编制采用rest风格,如对XM.xm_iteration_menu 迭代定义的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmIterationMenu/add <br>
 *  查询: xm/xmIterationMenu/list<br>
 *  模糊查询: xm/xmIterationMenu/listKey<br>
 *  修改: xm/xmIterationMenu/edit <br>
 *  删除: xm/xmIterationMenu/del<br>
 *  批量删除: xm/xmIterationMenu/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmIterationMenu 表 XM.xm_iteration_menu 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmIterationMenuController")
@RequestMapping(value="/**/xm/core/xmIterationMenu")
@Api(tags={"迭代定义操作接口"})
public class XmIterationMenuController {
	
	static Log logger=LogFactory.getLog(XmIterationMenuController.class);
	

	
	@Autowired
    XmMenuPushMsgService xmMenuPushMsgService;

	@Autowired
	XmMenuService xmMenuService;

	
 
	
	/**
	@ApiOperation( value = "新增一条迭代定义信息",notes="addXmIterationMenu,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmIterationMenu.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmIterationMenu(@RequestBody XmIterationMenu xmIterationMenu) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmIterationMenu.getId())) {
				xmIterationMenu.setId(xmIterationMenuService.createKey("id"));
			}else{
				 XmIterationMenu xmIterationMenuQuery = new  XmIterationMenu(xmIterationMenu.getId());
				if(xmIterationMenuService.countByWhere(xmIterationMenuQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmIterationMenuService.insert(xmIterationMenu);
			m.put("data",xmIterationMenu);
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
	
	/** */
	@ApiOperation( value = "删除一条迭代定义信息",notes="delXmIterationMenu,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmIterationMenu(@RequestBody XmIterationMenuVo xmIterationMenus){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmMenuService.batchUnIteration(xmIterationMenus);
			User user = LoginUtils.getCurrentUserInfo(); 
			this.xmMenuPushMsgService.pushMenuRelUsersMsg(user.getBranchId(), xmIterationMenu.getMenuId(), user.getUserid(), user.getUsername(), user.getUsername()+"将需求【"+xmIterationMenu.getMenuId()+"】移出迭代");
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
	@ApiOperation( value = "根据主键修改一条迭代定义信息",notes="editXmIterationMenu")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmIterationMenu.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmIterationMenu(@RequestBody XmIterationMenu xmIterationMenu) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmIterationMenuService.updateByPk(xmIterationMenu);
			m.put("data",xmIterationMenu);
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
	

	
	/***/
	@ApiOperation( value = "根据主键列表批量删除迭代定义信息",notes="batchDelXmIterationMenu,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmIterationMenu(@RequestBody XmIterationMenuVo xmIterationMenus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmIterationMenus.getMenuIds().size()+"条数据");
		try{
			xmMenuService.batchUnIteration(xmIterationMenus);

			User user = LoginUtils.getCurrentUserInfo();
			this.xmMenuPushMsgService.pushMenuRelUsersMsg(user.getBranchId(), xmIterationMenu.getMenuId(), user.getUserid(), user.getUsername(), user.getUsername()+"将需求【"+xmIterationMenu.getMenuId()+"】移出迭代");

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
	@RequestMapping(value="/batchAdd",method=RequestMethod.POST)
	public Map<String,Object> batchAddXmIterationMenu(@RequestBody XmIterationMenuVo xmIterationMenus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功将需求发布到迭代中");
		try{ 
			if(!StringUtils.hasText(xmIterationMenus.getIterationId())){
				return ResponseHelper.failed("iterationId-0","迭代编号不能为空");
			}
			List<String> menuIds=xmIterationMenus.getMenuIds();
			if(menuIds==null || menuIds.size()==0){
				return ResponseHelper.failed("menuIds-0","需求编号不能为空");
			}
			List<XmMenu> menus=xmMenuService.selectListByIds(menuIds);
			List<XmMenu> hadJoin=menus.stream().filter(i->StringUtils.hasText(i.getIterationId())).collect(Collectors.toList());
			List<String> msgs=new ArrayList<>();
			if(menus!=null && menus.size()==menuIds.size()){
				return ResponseHelper.failed("menus-had-iteration","需求全部都已加入迭代，不能重复加入。");
			}
				List<String> menuNames = menus.stream().map(XmMenu::getMenuName).collect(Collectors.toList());
				String menusNameStr=StringUtils.arrayToDelimitedString(menuNames.toArray(),",");
				msgs.add("以下需求已加入迭代计划，不能重复加入。"+menusNameStr);
				xmMenuService.batchIteration(xmIterationMenus);

				User user = LoginUtils.getCurrentUserInfo();

				for (XmIterationMenu xmIterationMenu : xmIterationMenus) {

					this.xmMenuPushMsgService.pushMenuRelUsersMsg(user.getBranchId(), xmIterationMenu.getMenuId(), user.getUserid(), user.getUsername(), user.getUsername()+"将需求【"+xmIterationMenu.getMenuId()+"】加入迭代");

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
