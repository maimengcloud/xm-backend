package com.xm.core.ctrl;

import com.mdp.core.entity.Result;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmIteration;
import com.xm.core.entity.XmMenu;
import com.xm.core.service.*;
import com.xm.core.service.push.XmMenuPushMsgService;
import com.xm.core.vo.XmIterationMenuVo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

	@Autowired
	XmMenuOperQxService operQxService;

	@Autowired
	XmIterationService xmIterationService;


	@Autowired
    XmGroupService groupService;

	@Autowired
	XmMenuController xmMenuController;


	@Autowired
	XmRecordService xmRecordService;

	@ApiOperation( value = "查询迭代定义信息列表",notes="listXmIterationMenu,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiEntityParams(XmIterationMenuVo.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
			@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false)
	})
	@ApiResponses({
			@ApiResponse(code = 200,response= Map.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Result listXmIterationMenu(@ApiIgnore @RequestParam Map<String,Object> params){
		 return xmMenuController.listWithState(params);
	}


	@ApiOperation( value = "删除一条迭代定义信息",notes="delXmIterationMenu,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Result delXmIterationMenu(@RequestBody XmIterationMenuVo xmIterationMenus){ 
		
		return batchDelXmIterationMenu(xmIterationMenus); 
	}
	

	@ApiOperation( value = "根据主键列表批量删除迭代定义信息",notes="batchDelXmIterationMenu,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Result batchDelXmIterationMenu(@RequestBody XmIterationMenuVo xmIterationMenus) {

			User user= LoginUtils.getCurrentUserInfo();
			List<String> menuIds=xmIterationMenus.getMenuIds();
			if(menuIds==null || menuIds.size()==0){
				return ResponseHelper.failed("menuIds-0","用户故事编号不能为空");
			}
			List<XmMenu> menus=operQxService.getUserCanOpMenusByIds(menuIds,user.getUserid(),false);
			if(menus==null || menus.size()==0){
				return ResponseHelper.failed("menus-0","无权限操作");
			}
			List<XmMenu> canOpList=menus;
 			List<XmMenu> notJoins=new ArrayList<>();
			List<XmMenu> status7=new ArrayList<>();
			List<XmMenu> canDels=new ArrayList<>();
			for (XmMenu menu : canOpList) {
				if(!StringUtils.hasText(menu.getIterationId())){
					notJoins.add(menu);
					continue;
				}
				if("7".equals(menu.getStatus())){
					status7.add(menu);
					continue;
				}
				canDels.add(menu);
			}
			List<String> msgs=new ArrayList<>();
			if(canDels.size()>0){
				msgs.add("成功将"+canDels.size()+"个用户故事移出迭代");
				xmIterationMenus.setMenuIds(canDels.stream().map(i->i.getMenuId()).collect(Collectors.toList()));
				xmMenuService.batchUnIteration(xmIterationMenus);
				xmRecordService.addXmMenuRecord(canDels,"产品-迭代-用户故事移出迭代","将用户故事移出迭代.");
				//this.xmMenuPushMsgService.pushMenuRelUsersMsg(user.getBranchId(), xmIterationMenu.getMenuId(), user.getUserid(), user.getUsername(), user.getUsername()+"将用户故事【"+xmIterationMenu.getMenuId()+"】加入迭代");
			}
			if(status7.size()>0){
				msgs.add("有"+status7.size()+"个用户故事状态为已上线,不能移出迭代。【"+status7.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
			}
			if(notJoins.size()>0){
				msgs.add("有"+notJoins.size()+"个用户故事未加入迭代，无需移出。【"+notJoins.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
			}
			if(canDels.size()==0){
				return Result.error(msgs.stream().collect(Collectors.joining(" ")));
			}else {
				return Result.ok(msgs.stream().collect(Collectors.joining(" ")));
			}
		
	} 
	@RequestMapping(value="/batchAdd",method=RequestMethod.POST)
	public Result batchAddXmIterationMenu(@RequestBody XmIterationMenuVo xmIterationMenus) {

			User user=LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmIterationMenus.getIterationId())){
				return ResponseHelper.failed("iterationId-0","迭代编号不能为空");
			}
			List<String> menuIds=xmIterationMenus.getMenuIds();
			if(menuIds==null || menuIds.size()==0){
				return ResponseHelper.failed("menuIds-0","用户故事编号不能为空");
			}
			List<XmMenu> menus=operQxService.getUserCanOpMenusByIds(menuIds,user.getUserid(),false);
			if(menus==null || menus.size()==0){
				return ResponseHelper.failed("no-qx-0","无权限操作");
			}
 			List<XmMenu> canOpList=menus;
			List<XmMenu> hadJoin=new ArrayList<>();
			List<XmMenu> ntype1=new ArrayList<>();
			List<XmMenu> status789=new ArrayList<>();
			List<XmMenu> canAdds=new ArrayList<>();
			for (XmMenu menu : canOpList) {
				if(StringUtils.hasText(menu.getIterationId())){
					hadJoin.add(menu);
					continue;
				}
				if(!"0".equals(menu.getNtype())){
					ntype1.add(menu);
					continue;
				}
				if("7".equals(menu.getStatus())||"8".equals(menu.getStatus())||"9".equals(menu.getStatus())){
					status789.add(menu);
					continue;
				}
				canAdds.add(menu);
			}
			List<String> msgs=new ArrayList<>();
			if(canAdds.size()>0){
				XmIteration xmIteration=xmIterationService.selectOneObject(new XmIteration(xmIterationMenus.getIterationId()));
				if(!"0".equals(xmIteration.getIphase()) && !"1".equals(xmIteration.getIphase())){
					return ResponseHelper.failed("iphase-not-0-1",xmIteration.getIterationName()+"已过了用户故事评审阶段，不能再添加用户故事");
				}
				if(xmIteration==null){
					return ResponseHelper.failed("iteration-0","迭代不存在");
				}
				msgs.add("成功将"+canAdds.size()+"个用户故事加入迭代");
				if("1".equals(xmIteration.getIstatus())||"7".equals(xmIteration.getIphase())){
					return ResponseHelper.failed("istatus-1","迭代已关闭");
				}
				xmIterationMenus.setIterationName(xmIteration.getIterationName());
				xmIterationMenus.setMenuIds(canAdds.stream().map(i->i.getMenuId()).collect(Collectors.toList()));
				xmMenuService.batchIteration(xmIterationMenus);
				xmRecordService.addXmMenuRecord(canAdds,"产品-迭代-用户故事加入迭代","将用户故事加入迭代.");

				//this.xmMenuPushMsgService.pushMenuRelUsersMsg(user.getBranchId(), xmIterationMenu.getMenuId(), user.getUserid(), user.getUsername(), user.getUsername()+"将用户故事【"+xmIterationMenu.getMenuId()+"】加入迭代");
			}
			if(status789.size()>0){
				msgs.add("有"+status789.size()+"个用户故事状态为已上线、已下线、已删除状态，不能加入迭代。【"+status789.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
			}
			if(hadJoin.size()>0){
				msgs.add("有"+hadJoin.size()+"个用户故事已加入迭代，不能重复加入。【"+hadJoin.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
			}
			if(ntype1.size()>0){
				msgs.add("有"+ntype1.size()+"个为史诗/特性，不用加入迭代。【"+ntype1.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
			}
			if(canAdds.size()==0){
				return Result.error(msgs.stream().collect(Collectors.joining(" ")));
			}else {
				return Result.ok(msgs.stream().collect(Collectors.joining(" ")));
			}
		
	} 
}
