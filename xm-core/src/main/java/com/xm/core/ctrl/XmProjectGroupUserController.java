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
import com.xm.core.vo.XmProjectGroupUserVo;
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
	public Map<String,Object> addXmProjectGroupUser(@RequestBody XmProjectGroupUserVo gu) {
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
					XmProjectGroupVo xmProjectGroupVo=this.xmProjectGroupService.getProductGroupFromCache(xmProject.getId(),gu.getGroupId());
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
			if("1".equals(0)){
				xmRecordService.addXmGroupRecord("",gu.getGroupId(), "产品-团队-新增小组成员", "增加组员["+gu.getUsername()+"]",gu.getUserid(),null);
			}else{
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
	public Map<String,Object> delXmProjectGroupUser(@RequestBody XmProjectGroupUserVo gu){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			if(!StringUtils.hasText(gu.getGroupId())||!StringUtils.hasText(gu.getUserid())){
				return ResponseHelper.failed("pk-0","请上送小组编号，用户编号groupId,userid");
			}
			gu=this.xmProjectGroupUserService.selectOneObject(gu);

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
					XmProjectGroupVo xmProjectGroupVo=this.xmProjectGroupService.getProductGroupFromCache(xmProject.getId(),gu.getGroupId());
					if(xmProjectGroupVo==null){
						return ResponseHelper.failed("group-0","小组已不存在");
					}
					boolean isHead=xmProjectGroupService.checkUserIsTeamHeadOrAss(xmProjectGroupVo,user.getUserid());
					if(isHead==false){
						return ResponseHelper.failed("not-leader-ass","组长、副组长、组长助理以上人员可以添加小组成员。");
					}
				}
			}
			xmProjectGroupUserService.deleteByPk(gu);
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
	public Map<String,Object> editXmProjectGroupUser(@RequestBody XmProjectGroupUser xmProjectGroupUser) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectGroupUserService.updateByPk(xmProjectGroupUser);
			m.put("data",xmProjectGroupUser);
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
	public Map<String,Object> batchDelXmProjectGroupUser(@RequestBody List<XmProjectGroupUser> xmProjectGroupUsers) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectGroupUsers.size()+"条数据"); 
		try{ 
			xmProjectGroupUserService.batchDelete(xmProjectGroupUsers);
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
