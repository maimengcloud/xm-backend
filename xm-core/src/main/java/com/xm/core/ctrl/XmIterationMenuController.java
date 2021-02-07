package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.safe.common.entity.User;
import com.mdp.safe.common.utils.LoginUtils;
import com.xm.core.entity.XmIterationMenu;
import com.xm.core.service.XmIterationMenuService;
import com.xm.core.service.push.XmMenuPushMsgService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private XmIterationMenuService xmIterationMenuService;
	

	
	@Autowired
    XmMenuPushMsgService xmMenuPushMsgService;

 
	
	@ApiOperation( value = "查询迭代定义信息列表",notes="listXmIterationMenu,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="iterationId",value="对应的迭代编号",required=false),
		@ApiImplicitParam(name="menuId",value="故事编号",required=false),
		@ApiImplicitParam(name="productId",value="产品编号",required=false),
		@ApiImplicitParam(name="ctime",value="关联时间",required=false),
		@ApiImplicitParam(name="relStatus",value="关联状态0不再关联1正常关联",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmIterationMenu.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmIterationMenu( @RequestParam Map<String,Object> xmIterationMenu){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmIterationMenu, "ids");
		PageUtils.startPage(xmIterationMenu);
		List<Map<String,Object>>	xmIterationMenuList = xmIterationMenuService.selectListMapByWhere(xmIterationMenu);	//列出XmIterationMenu列表
		PageUtils.responePage(m, xmIterationMenuList);
		m.put("data",xmIterationMenuList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
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
	public Map<String,Object> delXmIterationMenu(@RequestBody XmIterationMenu xmIterationMenu){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmIterationMenuService.deleteByPk(xmIterationMenu);
			User user = LoginUtils.getCurrentUserInfo(); 
			this.xmMenuPushMsgService.pushMenuRelUsersMsg(user.getBranchId(), xmIterationMenu.getMenuId(), user.getUserid(), user.getUsername(), user.getUsername()+"将故事【"+xmIterationMenu.getMenuId()+"】移出迭代");
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
	public Map<String,Object> batchDelXmIterationMenu(@RequestBody List<XmIterationMenu> xmIterationMenus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmIterationMenus.size()+"条数据"); 
		try{ 

			xmIterationMenuService.batchDelete(xmIterationMenus);
			User user = LoginUtils.getCurrentUserInfo(); 

			for (XmIterationMenu xmIterationMenu : xmIterationMenus) {
				this.xmMenuPushMsgService.pushMenuRelUsersMsg(user.getBranchId(), xmIterationMenu.getMenuId(), user.getUserid(), user.getUsername(), user.getUsername()+"将故事【"+xmIterationMenu.getMenuId()+"】移出迭代");

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
	@RequestMapping(value="/batchAdd",method=RequestMethod.POST)
	public Map<String,Object> batchAddXmIterationMenu(@RequestBody List<XmIterationMenu> xmIterationMenus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增"+xmIterationMenus.size()+"条数据"); 
		try{ 
			if(xmIterationMenus==null || xmIterationMenus.size()==0) {
				
			}else {

				for (XmIterationMenu xmIterationMenu : xmIterationMenus) {
					xmIterationMenu.setCtime(new Date());
					xmIterationMenu.setRelStatus("1");
					xmIterationMenu.setId(xmIterationMenuService.createKey("id"));
				}
				xmIterationMenuService.batchInsert(xmIterationMenus);
				
				User user = LoginUtils.getCurrentUserInfo(); 

				for (XmIterationMenu xmIterationMenu : xmIterationMenus) {

					this.xmMenuPushMsgService.pushMenuRelUsersMsg(user.getBranchId(), xmIterationMenu.getMenuId(), user.getUserid(), user.getUsername(), user.getUsername()+"将故事【"+xmIterationMenu.getMenuId()+"】加入迭代");

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
}
