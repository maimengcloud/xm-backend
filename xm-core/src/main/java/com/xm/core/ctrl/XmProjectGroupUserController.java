package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.mybatis.PageUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmProduct;
import com.xm.core.entity.XmProject;
import com.xm.core.entity.XmProjectGroup;
import com.xm.core.entity.XmProjectGroupUser;
import com.xm.core.service.*;
import com.xm.core.service.cache.XmProjectGroupCacheService;
import com.xm.core.service.push.XmPushMsgService;
import com.xm.core.vo.XmProjectGroupVo;
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
 * url编制采用rest风格,如对XM.xm_project_group_user xm_project_group_user的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmProjectGroupUser/add <br>
 *  查询: core/xmProjectGroupUser/list<br>
 *  模糊查询: core/xmProjectGroupUser/listKey<br>
 *  修改: core/xmProjectGroupUser/edit <br>
 *  删除: core/xmProjectGroupUser/del<br>
 *  批量删除: core/xmProjectGroupUser/batchDel<br>
 * 组织 com.qqkj  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmProjectGroupUser 表 XM.xm_project_group_user 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectGroupUserController")
@RequestMapping(value="/**/core/xmProjectGroupUser")
@Api(tags={"xm_project_group_user操作接口"})
public class XmProjectGroupUserController {
	
	static Log logger=LogFactory.getLog(XmProjectGroupUserController.class);
	
	@Autowired
	private XmProjectGroupUserService xmProjectGroupUserService;


	@Autowired
	private XmProjectService xmProjectService;


	@Autowired
	private XmProductService xmProductService;

	@Autowired
	XmProjectGroupService xmProjectGroupService;


	@Autowired
	XmRecordService xmRecordService;

	@Autowired
	XmPushMsgService pushMsgService;
 
	
	@ApiOperation( value = "查询xm_project_group_user信息列表",notes="listXmProjectGroupUser,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="joinTime",value="加入时间",required=false),
		@ApiImplicitParam(name="groupId",value="团队编号",required=false),
		@ApiImplicitParam(name="userid",value="团队成员编号",required=false),
		@ApiImplicitParam(name="username",value="团队成员",required=false),
		@ApiImplicitParam(name="isHead",value="是否组长，1是，0否",required=false),
		@ApiImplicitParam(name="outTime",value="离队时间",required=false),
		@ApiImplicitParam(name="status",value="当前状态0参与中1已退出团队",required=false),
		@ApiImplicitParam(name="bizProcInstId",value="当前流程实例编号",required=false),
		@ApiImplicitParam(name="bizFlowState",value="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectGroupUser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectGroupUser( @RequestParam Map<String,Object> xmProjectGroupUser){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectGroupUser, "ids");
		PageUtils.startPage(xmProjectGroupUser);
		List<Map<String,Object>>	xmProjectGroupUserList = xmProjectGroupUserService.selectListMapByWhere(xmProjectGroupUser);	//列出XmProjectGroupUser列表
		PageUtils.responePage(m, xmProjectGroupUserList);
		m.put("data",xmProjectGroupUserList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 

	@ApiOperation( value = "新增一条xm_project_group_user信息",notes="addXmProjectGroupUser,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectGroupUser.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectGroupUser(@RequestBody XmProjectGroupUser gu) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{

			if(!StringUtils.hasText(gu.getGroupId())||!StringUtils.hasText(gu.getUserid())){
				return ResponseHelper.failed("pk-0","请上送小组编号，用户编号groupId,userid");
			}
			if(!StringUtils.hasText(gu.getPgClass())){
				return ResponseHelper.failed("pgClass-0","请上送小组类型pgClass");
			}
			String pgClass=gu.getPgClass();
			User user=LoginUtils.getCurrentUserInfo();
			if("1".equals(pgClass)){

				if(!StringUtils.hasText(gu.getProductId())){
					return ResponseHelper.failed("productId-0","请上送小组归属产品编号");
				}
				XmProduct xmProduct=this.xmProductService.getProductFromCache(gu.getProductId());
				if(xmProduct==null){
					return ResponseHelper.failed("product-0","产品已不存在");
				}
				if(!xmProjectGroupService.checkUserIsProductAdm(xmProduct, user.getUserid())){
					XmProjectGroupVo xmProjectGroupVo=this.xmProjectGroupService.getProductGroupFromCache(xmProduct.getId(),gu.getGroupId());
					if(xmProjectGroupVo==null){
						return ResponseHelper.failed("group-0","小组已不存在");
					}
					boolean isHead=xmProjectGroupService.checkUserIsTeamHeadOrAss(xmProjectGroupVo,user.getUserid());
					if(isHead==false){
						return ResponseHelper.failed("not-leader-ass","组长、副组长、组长助理以上人员可以添加小组成员。");
					}
				}
			}else{
				if(!StringUtils.hasText(gu.getProjectId())){
					return ResponseHelper.failed("projectId-0","请上送小组归属项目编号");
				}

				XmProject xmProject=this.xmProjectService.getProjectFromCache(gu.getProjectId());
				if(xmProject==null){
					return ResponseHelper.failed("product-0","产品已不存在");
				}
				if(!xmProjectGroupService.checkUserIsProjectAdm(xmProject, user.getUserid())){
					XmProjectGroupVo xmProjectGroupVo=this.xmProjectGroupService.getProjectGroupFromCache(xmProject.getId(),gu.getGroupId());
					if(xmProjectGroupVo==null){
						return ResponseHelper.failed("group-0","小组已不存在");
					}
					boolean isHead=xmProjectGroupService.checkUserIsTeamHeadOrAss(xmProjectGroupVo,user.getUserid());
					if(isHead==false){
						return ResponseHelper.failed("not-leader-ass","组长、副组长、组长助理以上人员可以添加小组成员。");
					}
				}
			}

			if(xmProjectGroupUserService.countByWhere(gu)>0){
				tips.setFailureMsg("该用户已在小组中");
				m.put("tips", tips);
				return m;
			}
			xmProjectGroupUserService.insert(gu);
			Map<String,Object> usermap=new HashMap<>();
			usermap.put("userid", gu.getUserid());
			usermap.put("username", gu.getUsername());
			List<Map<String,Object>> users=new ArrayList<>();
			users.add(usermap);
			pushMsgService.pushJoinChannelGroupMsg(user.getBranchId(), gu.getGroupId(), users);
			if("1".equals(pgClass)){
				xmProjectGroupService.clearProductGroup(gu.getProductId());
				xmRecordService.addXmGroupRecord(gu.getProductId(),gu.getGroupId(), "产品-团队-新增小组成员", "增加组员["+gu.getUsername()+"]",gu.getUserid(),null);
			}else{
				xmProjectGroupService.clearProjectGroup(gu.getProjectId());
				xmRecordService.addXmGroupRecord(gu.getProjectId(),gu.getGroupId(), "项目-团队-新增小组成员", "增加组员["+gu.getUsername()+"]",gu.getUserid(),null);
			}

			m.put("data",gu);
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

	@ApiOperation( value = "删除一条xm_project_group_user信息",notes="delXmProjectGroupUser,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectGroupUser(@RequestBody XmProjectGroupUser gu){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			if(!StringUtils.hasText(gu.getGroupId())||!StringUtils.hasText(gu.getUserid())){
				return ResponseHelper.failed("pk-0","请上送小组编号，用户编号groupId,userid");
			}
			gu=this.xmProjectGroupUserService.selectOneObject(gu);
			if(gu==null){
				return ResponseHelper.failed("data-0","小组组员已不存在");
			}
			String pgClass=gu.getPgClass();
			User user=LoginUtils.getCurrentUserInfo();
			if("1".equals(pgClass)){

				if(!StringUtils.hasText(gu.getProductId())){
					return ResponseHelper.failed("productId-0","请上送小组归属产品编号");
				}
				XmProduct xmProduct=this.xmProductService.getProductFromCache(gu.getProductId());
				if(xmProduct==null){
					return ResponseHelper.failed("product-0","产品已不存在");
				}
				if(!xmProjectGroupService.checkUserIsProductAdm(xmProduct, user.getUserid())){
					XmProjectGroupVo xmProjectGroupVo=this.xmProjectGroupService.getProductGroupFromCache(xmProduct.getId(),gu.getGroupId());
					if(xmProjectGroupVo==null){
						return ResponseHelper.failed("group-0","小组已不存在");
					}
					boolean isHead=xmProjectGroupService.checkUserIsTeamHeadOrAss(xmProjectGroupVo,user.getUserid());
					if(isHead==false){
						return ResponseHelper.failed("not-leader-ass","组长、副组长、组长助理以上人员可以删除小组成员。");
					}
				}
			}else{
				if(!StringUtils.hasText(gu.getProjectId())){
					return ResponseHelper.failed("projectId-0","请上送小组归属项目编号");
				}

				XmProject xmProject=this.xmProjectService.getProjectFromCache(gu.getProjectId());
				if(xmProject==null){
					return ResponseHelper.failed("project-0","项目已不存在");
				}
				if(!xmProjectGroupService.checkUserIsProjectAdm(xmProject, user.getUserid())){
					XmProjectGroupVo xmProjectGroupVo=this.xmProjectGroupService.getProjectGroupFromCache(xmProject.getId(),gu.getGroupId());
					if(xmProjectGroupVo==null){
						return ResponseHelper.failed("group-0","小组已不存在");
					}
					boolean isHead=xmProjectGroupService.checkUserIsTeamHeadOrAss(xmProjectGroupVo,user.getUserid());
					if(isHead==false){
						return ResponseHelper.failed("not-leader-ass","组长、副组长、组长助理以上人员可以删除小组成员。");
					}
				}
			}
			xmProjectGroupUserService.deleteByPk(gu);
			Map<String,Object> usermap=new HashMap<>();
			usermap.put("userid", gu.getUserid());
			usermap.put("username", gu.getUsername());
			List<Map<String,Object>> users=new ArrayList<>();
			users.add(usermap);
			pushMsgService.pushLeaveChannelGroupMsg(user.getBranchId(), gu.getGroupId(), users);
			if("1".equals(pgClass)){

				xmProjectGroupService.clearProductGroup(gu.getProductId());
				xmRecordService.addXmGroupRecord(gu.getProductId(),gu.getGroupId(), "项目-团队-删除小组成员", "删除组员["+gu.getUsername()+"]",gu.getUserid(),null);
			}else{
				xmProjectGroupService.clearProjectGroup(gu.getProjectId());
				xmRecordService.addXmGroupRecord(gu.getProjectId(),gu.getGroupId(), "项目-团队-删除小组成员", "删除组员["+gu.getUsername()+"]",gu.getUserid(),null);
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

	@ApiOperation( value = "根据主键修改一条xm_project_group_user信息",notes="editXmProjectGroupUser")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectGroupUser.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectGroupUser(@RequestBody XmProjectGroupUser gu0) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			if(!StringUtils.hasText(gu0.getGroupId())||!StringUtils.hasText(gu0.getUserid())){
				return ResponseHelper.failed("pk-0","请上送小组编号，用户编号groupId,userid");
			}
			XmProjectGroupUser gu=this.xmProjectGroupUserService.selectOneObject(gu0);
			if(gu==null){
				return ResponseHelper.failed("data-0","小组已不存在");
			}
			String pgClass=gu.getPgClass();
			User user=LoginUtils.getCurrentUserInfo();
			if("1".equals(pgClass)){

				if(!StringUtils.hasText(gu.getProductId())){
					return ResponseHelper.failed("productId-0","请上送小组归属产品编号");
				}
				XmProduct xmProduct=this.xmProductService.getProductFromCache(gu.getProductId());
				if(xmProduct==null){
					return ResponseHelper.failed("product-0","产品已不存在");
				}
				if(!xmProjectGroupService.checkUserIsProductAdm(xmProduct, user.getUserid())){
					XmProjectGroupVo xmProjectGroupVo=this.xmProjectGroupService.getProductGroupFromCache(xmProduct.getId(),gu.getGroupId());
					if(xmProjectGroupVo==null){
						return ResponseHelper.failed("group-0","小组已不存在");
					}
					boolean isHead=xmProjectGroupService.checkUserIsTeamHeadOrAss(xmProjectGroupVo,user.getUserid());
					if(isHead==false){
						return ResponseHelper.failed("not-leader-ass","组长、副组长、组长助理以上人员可以修改小组成员。");
					}
				}
			}else{
				if(!StringUtils.hasText(gu.getProjectId())){
					return ResponseHelper.failed("projectId-0","请上送小组归属项目编号");
				}

				XmProject xmProject=this.xmProjectService.getProjectFromCache(gu.getProjectId());
				if(xmProject==null){
					return ResponseHelper.failed("product-0","产品已不存在");
				}
				if(!xmProjectGroupService.checkUserIsProjectAdm(xmProject, user.getUserid())){
					XmProjectGroupVo xmProjectGroupVo=this.xmProjectGroupService.getProductGroupFromCache(xmProject.getId(),gu.getGroupId());
					if(xmProjectGroupVo==null){
						return ResponseHelper.failed("group-0","小组已不存在");
					}
					boolean isHead=xmProjectGroupService.checkUserIsTeamHeadOrAss(xmProjectGroupVo,user.getUserid());
					if(isHead==false){
						return ResponseHelper.failed("not-leader-ass","组长、副组长、组长助理以上人员可以修改小组成员。");
					}
				}
			}
			xmProjectGroupUserService.updateSomeFieldByPk(gu0);

			if("0".equals(pgClass)){

				xmProjectGroupService.clearProjectGroup(gu.getProjectId());
				xmRecordService.addXmGroupRecord(gu.getProjectId(), gu.getGroupId(),"项目-团队-修改小组成员信息", "变更["+gu.getUsername()+"]");
			}else {

				xmProjectGroupService.clearProductGroup(gu.getProductId());
				xmRecordService.addXmGroupRecord(gu.getProductId(), gu.getGroupId(),"项目-团队-修改小组成员信息", "变更["+gu.getUsername()+"]");
			}

			m.put("data",gu);
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


	@ApiOperation( value = "根据主键列表批量新增xm_project_group_user信息",notes="batchAddXmProjectGroupUser,仅需要上传主键字段")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@RequestMapping(value="/batchAdd",method=RequestMethod.POST)
	public Map<String,Object> batchAddXmProjectGroupUser(@RequestBody List<XmProjectGroupUser> gus) {
		Map<String,Object> m = new HashMap<>();
		if(gus==null || gus.size()==0){
			return ResponseHelper.failed("data-0","请上送要删除的小组成员");
		}
		Tips tips=new Tips("成功新增"+gus.size()+"条数据");
		try{
			if(gus.stream().filter(i->!StringUtils.hasText(i.getUserid())||!StringUtils.hasText(i.getGroupId())).findAny().isPresent()){
				return ResponseHelper.failed("userid-or-groupId-0","请上送用户编号及小组编号");
			}else{
				for (XmProjectGroupUser gu : gus) {
					if(!"1".equals(gu.getPgClass())&&!StringUtils.hasText(gu.getProjectId())){
						return ResponseHelper.failed("projectId-0","项目编号不能为空");
					}else if("1".equals(gu.getPgClass())&&!StringUtils.hasText(gu.getProductId()))
						return ResponseHelper.failed("productId-0","产品编号不能为空");
					}

			}
			List<XmProjectGroupUser> gusDb=this.xmProjectGroupUserService.selectListByIds(gus);
			//过滤掉已经存在的
			List<XmProjectGroupUser> gusNoExists=gus.stream().filter(i->!(gusDb.stream().filter(k->k.getGroupId().equals(i.getGroupId())&&k.getUserid().equals(i.getUserid()))).findAny().isPresent()).collect(Collectors.toList());
			if(gusNoExists.size()==0){
				return ResponseHelper.failed("user-had-exists","成功添加0个组员。以下用户已在小组中，不用再添加。【"+gusDb.stream().map(i->i.getUsername()).collect(Collectors.joining(","))+"】");
			}
			User user=LoginUtils.getCurrentUserInfo();
			XmProjectGroupUser gu=gusNoExists.get(0);
			String productId=gu.getProductId();
			String projectId=gu.getProjectId();
			String pgClass=gu.getPgClass();
			List<XmProjectGroupUser> gus2=new ArrayList<>();
			XmProduct xmProduct=null;
			XmProject xmProject=null;
			if("1".equals(pgClass)){
				xmProduct=this.xmProductService.getProductFromCache(gu.getProductId());
				if(xmProduct==null){
					return ResponseHelper.failed("product-0","产品已不存在");
				}
				gus2=gusNoExists.stream().filter(i->productId.equals(i.getProductId())).collect(Collectors.toList());
				if(gus2.size()<gusNoExists.size()){
					return ResponseHelper.failed("data-0","批量新增只能新增同一个产品的成员。");
				}
			}else {
				xmProject=this.xmProjectService.getProjectFromCache(gu.getProjectId());
				if(xmProject==null){
					return ResponseHelper.failed("project-0","项目已不存在");
				}
				gus2=gusNoExists.stream().filter(i->projectId.equals(i.getProjectId())).collect(Collectors.toList());
				if(gus2.size()<gusNoExists.size()){
					return ResponseHelper.failed("data-0","批量新增只能新增同一个项目的成员。");
				}
			}

			Set<String> groupIds=gusNoExists.stream().map(i->i.getGroupId()).collect(Collectors.toSet());
			List<XmProjectGroupUser> canAddUsers=new ArrayList<>();
			Map<String,List<XmProjectGroupUser>> groupUsersMap=new HashMap<>();
			for (String groupId : groupIds) {
				if("1".equals(pgClass)){
					boolean isPm=xmProjectGroupService.checkUserIsProductAdm(xmProduct,user.getUserid());
					if(!isPm){
						XmProjectGroupVo xmProjectGroupVo=this.xmProjectGroupService.getProductGroupFromCache(xmProduct.getId(),groupId);
						if(xmProjectGroupVo==null){
							continue;
						}
						boolean isHead=xmProjectGroupService.checkUserIsTeamHeadOrAss(xmProjectGroupVo,user.getUserid());
						if(isHead==false){
							continue;
						}
					}
				}else {
					boolean isPm=xmProjectGroupService.checkUserIsProjectAdm(xmProject,user.getUserid());
					if(!isPm){
						XmProjectGroupVo xmProjectGroupVo=this.xmProjectGroupService.getProjectGroupFromCache(xmProject.getId(),groupId);
						if(xmProjectGroupVo==null){
							continue;
						}
						boolean isHead=xmProjectGroupService.checkUserIsTeamHeadOrAss(xmProjectGroupVo,user.getUserid());
						if(isHead==false){
							continue;
						}
					}
				}
				List<XmProjectGroupUser> cdus=gus2.stream().filter(i->groupId.equals(i.getGroupId())).collect(Collectors.toList());
				canAddUsers.addAll(cdus);
				groupUsersMap.put(groupId,cdus);
			}
			List<String> msg=new ArrayList<>();
			msg.add("成功新增"+canAddUsers.size()+"个小组用户.");
			if(canAddUsers.size()>0){
				xmProjectGroupUserService.batchInsert(canAddUsers);
			}
 			if(canAddUsers.size()<gus.size()){
				msg.add("以下"+gusDb.size()+"个小组用户已在组里，无需再添加。【"+gusDb.stream().map(i->i.getUsername()).collect(Collectors.joining(","))+"】");
			}
			if(canAddUsers.size()!=0){
				tips.setOkMsg(msg.stream().collect(Collectors.joining(" ")));
			}else{
				tips.setFailureMsg(msg.stream().collect(Collectors.joining(" ")));
			}
			groupUsersMap.forEach((groupId,groupUsers)->{

				List<Map<String,Object>> users=groupUsers.stream().map(i->map("userid",i.getUserid(),"username",i.getUsername())).collect(Collectors.toList());
				pushMsgService.pushJoinChannelGroupMsg(user.getBranchId(),groupId, users);
				if("0".equals(pgClass)){

					xmProjectGroupService.clearProjectGroup(projectId);
					xmRecordService.addXmGroupRecord(projectId,groupId, "项目-团队-新增小组成员", "新增组员["+groupUsers.stream().map(i->i.getUsername()).collect(Collectors.joining(","))+"]",user.getUserid(),null);
				}else{
					xmProjectGroupService.clearProductGroup(productId);
					xmRecordService.addXmGroupRecord(productId,groupId, "产品-团队-新增小组成员", "新增组员["+groupUsers.stream().map(i->i.getUsername()).collect(Collectors.joining(","))+"]",user.getUserid(),null);
				}
			});


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


	@ApiOperation( value = "根据主键列表批量删除xm_project_group_user信息",notes="batchDelXmProjectGroupUser,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectGroupUser(@RequestBody List<XmProjectGroupUser> gus) {
		Map<String,Object> m = new HashMap<>();
		if(gus==null || gus.size()==0){
			return ResponseHelper.failed("data-0","请上送要删除的小组成员");
		}
		Tips tips=new Tips("成功删除"+gus.size()+"条数据");
		try{
			List<XmProjectGroupUser> gusDb=this.xmProjectGroupUserService.selectListByIds(gus);
			if(gusDb.size()==0){
				return ResponseHelper.failed("data-0","要删除的数据已不存在。");
			}
			User user=LoginUtils.getCurrentUserInfo();
			XmProjectGroupUser gu=gusDb.get(0);
			String productId=gu.getProductId();
			String projectId=gu.getProjectId();
			String pgClass=gu.getPgClass();
			List<XmProjectGroupUser> gus2=new ArrayList<>();
			XmProduct xmProduct=null;
			XmProject xmProject=null;
			if("1".equals(pgClass)){
				xmProduct=this.xmProductService.getProductFromCache(gu.getProductId());
				if(xmProduct==null){
					return ResponseHelper.failed("product-0","产品已不存在");
				}
				gus2=gusDb.stream().filter(i->productId.equals(i.getProductId())).collect(Collectors.toList());
				if(gus2.size()<gusDb.size()){
					return ResponseHelper.failed("data-0","批量删除只能删除同一个产品的成员。");
				}
			}else {
				xmProject=this.xmProjectService.getProjectFromCache(gu.getProjectId());
				if(xmProject==null){
					return ResponseHelper.failed("project-0","项目已不存在");
				}
				gus2=gusDb.stream().filter(i->projectId.equals(i.getProjectId())).collect(Collectors.toList());
				if(gus2.size()<gusDb.size()){
					return ResponseHelper.failed("data-0","批量删除只能删除同一个项目的成员。");
				}
			}

			Set<String> groupIds=gusDb.stream().map(i->i.getGroupId()).collect(Collectors.toSet());
			List<XmProjectGroupUser> canDelUsers=new ArrayList<>();
			Map<String,List<XmProjectGroupUser>> groupUsersMap=new HashMap<>();
			for (String groupId : groupIds) {
				if("1".equals(pgClass)){
					boolean isPm=xmProjectGroupService.checkUserIsProductAdm(xmProduct,user.getUserid());
					if(!isPm){
						XmProjectGroupVo xmProjectGroupVo=this.xmProjectGroupService.getProductGroupFromCache(xmProduct.getId(),groupId);
						if(xmProjectGroupVo==null){
							 continue;
						}
						boolean isHead=xmProjectGroupService.checkUserIsTeamHeadOrAss(xmProjectGroupVo,user.getUserid());
						if(isHead==false){
							continue;
						}
					}
				}else {
					boolean isPm=xmProjectGroupService.checkUserIsProjectAdm(xmProject,user.getUserid());
					if(!isPm){
						XmProjectGroupVo xmProjectGroupVo=this.xmProjectGroupService.getProjectGroupFromCache(xmProject.getId(),groupId);
						if(xmProjectGroupVo==null){
							continue;
						}
						boolean isHead=xmProjectGroupService.checkUserIsTeamHeadOrAss(xmProjectGroupVo,user.getUserid());
						if(isHead==false){
							continue;
						}
					}
				}
				List<XmProjectGroupUser> cdus=gus2.stream().filter(i->groupId.equals(i.getGroupId())).collect(Collectors.toList());
				canDelUsers.addAll(cdus);
				groupUsersMap.put(groupId,cdus);
			}
			List<String> msg=new ArrayList<>();
			msg.add("成功删除"+canDelUsers.size()+"个小组用户.");
			if(canDelUsers.size()>0){
				xmProjectGroupUserService.doBatchDelete(canDelUsers);
			}
			List<String> noDelUsers=new ArrayList<>();
			if(canDelUsers.size()<gus.size()){

				for (XmProjectGroupUser gu0 : gus) {
					if(!canDelUsers.stream().filter(i->i.getUserid().equals(gu0.getUserid())&&i.getGroupId().equals(gu0.getGroupId())).findAny().isPresent()){
						noDelUsers.add(gu0.getUsername());
					}
				}
				msg.add("以下"+noDelUsers.size()+"个小组用户无权限删除。【"+noDelUsers.stream().collect(Collectors.toSet()).stream().collect(Collectors.joining(","))+"】");
 			}
			if(canDelUsers.size()!=0){
				tips.setOkMsg(msg.stream().collect(Collectors.joining(" ")));
			}else{
				tips.setFailureMsg(msg.stream().collect(Collectors.joining(" ")));
			}
			groupUsersMap.forEach((groupId,groupUsers)->{

				List<Map<String,Object>> users=groupUsers.stream().map(i->map("userid",i.getUserid(),"username",i.getUsername())).collect(Collectors.toList());
				pushMsgService.pushLeaveChannelGroupMsg(user.getBranchId(),groupId, users);
				if("0".equals(pgClass)){

					xmProjectGroupService.clearProjectGroup(projectId);
					xmRecordService.addXmGroupRecord(projectId,groupId, "项目-团队-删除小组成员", "删除组员["+groupUsers.stream().map(i->i.getUsername()).collect(Collectors.joining(","))+"]",user.getUserid(),null);
				}else{
					xmProjectGroupService.clearProductGroup(productId);
					xmRecordService.addXmGroupRecord(productId,groupId, "产品-团队-删除小组成员", "删除组员["+groupUsers.stream().map(i->i.getUsername()).collect(Collectors.joining(","))+"]",user.getUserid(),null);
				}
			});


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
