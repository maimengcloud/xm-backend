package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmMenu;
import com.xm.core.entity.XmProduct;
import com.xm.core.entity.XmProjectGroup;
import com.xm.core.service.XmMenuService;
import com.xm.core.service.XmProductService;
import com.xm.core.service.XmProjectGroupService;
import com.xm.core.service.XmRecordService;
import com.xm.core.service.push.XmMenuPushMsgService;
import com.xm.core.vo.XmPhaseMenusVo;
import com.xm.core.vo.XmPhaseMenusVo;
import com.xm.core.vo.XmProjectGroupVo;
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
import java.util.stream.Collectors;

/**
 * url编制采用rest风格,如对XM.xm_iteration_menu 计划定义的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmPhaseMenu/add <br>
 *  查询: xm/xmPhaseMenu/list<br>
 *  模糊查询: xm/xmPhaseMenu/listKey<br>
 *  修改: xm/xmPhaseMenu/edit <br>
 *  删除: xm/xmPhaseMenu/del<br>
 *  批量删除: xm/xmPhaseMenu/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmPhaseMenu 表 XM.xm_iteration_menu 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmPhaseMenuController")
@RequestMapping(value="/**/xm/core/xmPhaseMenu")
@Api(tags={"计划定义操作接口"})
public class XmPhaseMenuController {
	
	static Log logger=LogFactory.getLog(XmPhaseMenuController.class);
	

	
	@Autowired
    XmMenuPushMsgService xmMenuPushMsgService;

	@Autowired
	XmMenuService xmMenuService;

	@Autowired
	XmMenuController xmMenuController;

	@Autowired
	XmProjectGroupService groupService;


	@Autowired
	XmProductService xmProductService;

	@Autowired
	XmRecordService xmRecordService;

	@ApiOperation( value = "查询计划定义信息列表",notes="listXmPhaseMenu,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({
			@ApiImplicitParam(name="id",value="主键,主键",required=false),
			@ApiImplicitParam(name="phaseId",value="对应的计划编号",required=false),
			@ApiImplicitParam(name="menuId",value="需求编号",required=false),
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
			@ApiResponse(code = 200,response= Map.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listWithPhase( @RequestParam Map<String,Object> xmPhaseMenu){
		 return xmMenuController.listWithPhase(xmPhaseMenu);
	}
 
	

	@ApiOperation( value = "根据主键列表批量删除计划定义信息",notes="batchDelXmPhaseMenu,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmPhaseMenu(@RequestBody XmPhaseMenusVo xmPhaseMenus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功将需求移出计划");
		try{
			List<String> menuIds=xmPhaseMenus.getMenuIds();
			if(menuIds==null || menuIds.size()==0){
				return ResponseHelper.failed("menuIds-0","需求编号不能为空");
			}
			List<XmMenu> menus=xmMenuService.selectListByIds(menuIds);
			if(menus==null || menus.size()==0){
				return ResponseHelper.failed("menus-0","需求已不存在");
			}
			 


			List<XmMenu> noQxOpList=new ArrayList<>();
			List<XmMenu> canOpList=new ArrayList<>();
			groupService.calcCanOpMenus(menus,canOpList,noQxOpList);
			/**
			if(menus.stream().filter(i->!productId.equals(i.getProductId())).findAny().isPresent()){
				return ResponseHelper.failed("productId-0","批量操作的需求必须是同一个产品下的需求。");
			}
			 **/
			List<XmMenu> notJoins=new ArrayList<>();
			List<XmMenu> status7=new ArrayList<>();
			List<XmMenu> canDels=new ArrayList<>();
			for (XmMenu menu : canOpList) {
				if(!StringUtils.hasText(menu.getPhaseId())){
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
			msgs.add("成功将"+canDels.size()+"个需求移出计划");
			if(canDels.size()>0){
				xmPhaseMenus.setMenuIds(canDels.stream().map(i->i.getMenuId()).collect(Collectors.toList()));
				xmMenuService.batchUnProductPhase(xmPhaseMenus);
				xmRecordService.addXmMenuRecord( canDels,"产品-计划-批量将需求移出","将需求移出计划");
				//this.xmMenuPushMsgService.pushMenuRelUsersMsg(user.getBranchId(), xmPhaseMenu.getMenuId(), user.getUserid(), user.getUsername(), user.getUsername()+"将需求【"+xmPhaseMenu.getMenuId()+"】加入计划");
			}
			if(noQxOpList.size()>0){
				msgs.add("有"+noQxOpList.size()+"个需求无权限操作，【"+noQxOpList.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
			}
			if(status7.size()>0){
				msgs.add("有"+status7.size()+"个需求状态为已上线,不能移出计划，【"+status7.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
			}
			if(notJoins.size()>0){
				msgs.add("有"+notJoins.size()+"个需求未加入计划，无需移出，【"+notJoins.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
			}
			if(canDels.size()==0){
				tips.setFailureMsg(msgs.stream().collect(Collectors.joining(";")));
			}else {
				tips.setOkMsg(msgs.stream().collect(Collectors.joining(";")));
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
	public Map<String,Object> batchAddXmPhaseMenu(@RequestBody XmPhaseMenusVo xmPhaseMenus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功将需求与计划关联");
		try{ 
			if(!StringUtils.hasText(xmPhaseMenus.getPhaseId())){
				return ResponseHelper.failed("phaseId-0","计划编号不能为空");
			}
			List<String> menuIds=xmPhaseMenus.getMenuIds();
			if(menuIds==null || menuIds.size()==0){
				return ResponseHelper.failed("menuIds-0","需求编号不能为空");
			}
			List<XmMenu> menus=xmMenuService.selectListByIds(menuIds);
			if(menus==null || menus.size()==0){
				return ResponseHelper.failed("menus-0","需求已不存在");
			}

			List<XmMenu> noQxOpList=new ArrayList<>();
			List<XmMenu> canOpList=new ArrayList<>();
			groupService.calcCanOpMenus(menus,canOpList,noQxOpList);
			List<XmMenu> hadJoin=new ArrayList<>();
			List<XmMenu> ntype1=new ArrayList<>();
			List<XmMenu> status789=new ArrayList<>();
			List<XmMenu> canAdds=new ArrayList<>();
			for (XmMenu menu : canOpList) {
				if(StringUtils.hasText(menu.getPhaseId())){
					hadJoin.add(menu);
					continue;
				}
				if("1".equals(menu.getNtype())){
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
			msgs.add("成功将"+canAdds.size()+"个需求加入计划");
			if(canAdds.size()>0){

				xmPhaseMenus.setMenuIds(canAdds.stream().map(i->i.getMenuId()).collect(Collectors.toList()));
				xmMenuService.batchProductPhase(xmPhaseMenus);
				xmRecordService.addXmMenuRecord( canAdds,"产品-计划-批量将需求加入计划","将需求加入计划");

				//this.xmMenuPushMsgService.pushMenuRelUsersMsg(user.getBranchId(), xmPhaseMenu.getMenuId(), user.getUserid(), user.getUsername(), user.getUsername()+"将需求【"+xmPhaseMenu.getMenuId()+"】加入计划");
			}

			if(noQxOpList.size()>0){
				msgs.add("有"+noQxOpList.size()+"个需求无权限操作，【"+noQxOpList.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
			}
			if(status789.size()>0){
				msgs.add("有"+status789.size()+"个需求状态为已上线、已下线、已删除状态，不能加入计划。【"+status789.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
			}
			if(hadJoin.size()>0){
				msgs.add("有"+hadJoin.size()+"个需求已加入计划，不能重复加入。【"+hadJoin.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
			}
			if(ntype1.size()>0){
				msgs.add("有"+ntype1.size()+"个需求为需求集，不用加入计划。【"+ntype1.stream().map(i->i.getMenuName()).collect(Collectors.joining(","))+"】");
			}
			if(canAdds.size()==0){
				tips.setFailureMsg(msgs.stream().collect(Collectors.joining(";")));
			}else {
				tips.setOkMsg(msgs.stream().collect(Collectors.joining(";")));
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
