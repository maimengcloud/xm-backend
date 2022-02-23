package com.xm.core.ctrl;

import com.alibaba.fastjson.JSON;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmProduct;
import com.xm.core.entity.XmProject;
import com.xm.core.entity.XmProjectGroup;
import com.xm.core.entity.XmProjectGroupUser;
import com.xm.core.service.XmProductService;
import com.xm.core.service.XmProjectGroupService;
import com.xm.core.service.XmProjectService;
import com.xm.core.service.XmRecordService;
import com.xm.core.service.cache.XmProjectGroupCacheService;
import com.xm.core.service.push.XmPushMsgService;
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
 * url编制采用rest风格,如对XM.xm_project_group xm_project_group的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProjectGroup/add <br>
 *  查询: xm/xmProjectGroup/list<br>
 *  模糊查询: xm/xmProjectGroup/listKey<br>
 *  修改: xm/xmProjectGroup/edit <br>
 *  删除: xm/xmProjectGroup/del<br>
 *  批量删除: xm/xmProjectGroup/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectGroup 表 XM.xm_project_group 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectGroupController")
@RequestMapping(value="/**/xm/core/xmProjectGroup")
@Api(tags={"xm_project_group操作接口"})
public class XmProjectGroupController {
	
	static Log logger=LogFactory.getLog(XmProjectGroupController.class);
	
	@Autowired
	private XmProjectGroupService xmProjectGroupService;


	@Autowired
	private XmProjectGroupCacheService xmProjectGroupCacheService;
	
	@Autowired
	private XmProjectService xmProjectService;


	@Autowired
	private XmProductService xmProductService;
	
	@Autowired
    XmPushMsgService pushMsgService;

	@Autowired
    XmRecordService xmRecordService;

	@ApiOperation( value = "删除旧团队，新增新团队",notes="")
	@ApiResponses({
			@ApiResponse(code = 200,response= XmProjectGroup.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmProjectGroup_updateGroup",name = "批量更新修改项目团队信息",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> updateGroup(@RequestBody XmProjectGroup group) {

		Tips tips=new Tips("小组更新成功");
		Map<String,Object> m = new HashMap<>();
		if(group==null){
			tips.setFailureMsg("小组信息不能为空");
			m.put("tips", tips);
			return m;
		}
		if(StringUtils.hasText(group.getId())){
			return ResponseHelper.failed("id-0","小组编号不能为空");
		}
		User user=LoginUtils.getCurrentUserInfo();
		XmProjectGroup groupDb=this.xmProjectGroupService.selectOneObject(new XmProjectGroup(group.getId()));
		if(groupDb==null){
			return ResponseHelper.failed("data-0","小组已不存在。");
		}
		if("1".equals(groupDb.getPgClass())){
			XmProduct xmProduct=this.xmProductService.selectOneObject(new XmProduct(groupDb.getProductId()));
			tips=this.xmProjectGroupService.checkProductStatus(xmProduct);
			if(tips.isOk()==false){
				return ResponseHelper.failed(tips);
			}
			tips=this.xmProjectGroupService.checkHasEditProdcutGroupQx(user,group,groupDb,xmProduct);
			if(tips.isOk()==false){
				return ResponseHelper.failed(tips);
			}
		}else{
			XmProject xmProject=this.xmProjectService.getProjectFromCache(groupDb.getProjectId());
			tips=this.xmProjectGroupService.checkProjectStatus(xmProject);
			if(tips.isOk()==false){
				return ResponseHelper.failed(tips);
			}
			tips=this.xmProjectGroupService.checkHasEditProjectGroupQx(user,group,groupDb,xmProject);
			if(tips.isOk()==false){
				return ResponseHelper.failed(tips);
			}
		}
		xmProjectGroupService.parentIdPathsCalcBeforeSave(group);
		tips= xmProjectGroupService.updateGroup(group,groupDb);	//列出XmProjectGroup列表
		if("1".equals(groupDb.getPgClass())){
			xmProjectGroupCacheService.clearProductGroup(groupDb.getProductId(),groupDb.getId());
			xmRecordService.addXmProductGroupRecord(groupDb.getProductId(),groupDb.getId(),"团队-小组-修改小组","修改小组信息【"+groupDb.getGroupName()+"】");
		}else {
			xmProjectGroupCacheService.clearProjectGroup(groupDb.getProjectId(),groupDb.getId());
			xmRecordService.addXmGroupRecord(groupDb.getProjectId(),groupDb.getId(),"团队-小组-修改小组","修改小组信息【"+groupDb.getGroupName()+"】");

		}


		m.put("tips", tips);
		return m;
	}

	@ApiOperation( value = "根据项目Id拿到团队",notes="")
	@ApiImplicitParams({
			@ApiImplicitParam(name="id",value="主键,主键",required=false),
			@ApiImplicitParam(name="groupName",value="团队名称",required=false),
			@ApiImplicitParam(name="projectId",value="项目编号",required=false),
			@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
			@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
			@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false)
	})
	@ApiResponses({
			@ApiResponse(code = 200,response=XmProjectGroup.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmProjectGroup_getGroup",name = "查找项目团队信息",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/getGroup",method=RequestMethod.GET)
	public Map<String,Object> getGroup(@RequestParam Map<String,Object> params) {
		Map<String,Object> m = new HashMap<>();
		RequestUtils.transformArray(params, "ids");
		PageUtils.startPage(params);
		List<XmProjectGroupVo>	xmProjectGroupList=new ArrayList<>();
		String iterationId= (String) params.get("iterationId");
		String projectId= (String) params.get("projectId");
		String productId= (String) params.get("productId");
		if(StringUtils.hasText(projectId)){
			xmProjectGroupList = xmProjectGroupService.getProjectGroupVoList(projectId);	//列出XmProjectGroup列表
		}else if(StringUtils.hasText(iterationId)){
			xmProjectGroupList = xmProjectGroupService.getProjectGroupVoListByIterationId(iterationId );	//列出XmProjectGroup列表
		}else  if(StringUtils.hasText(productId)){
			xmProjectGroupList = xmProjectGroupService.getProjectGroupVoListByProductId( productId);	//列出XmProjectGroup列表
		}

		PageUtils.responePage(m, xmProjectGroupList);
		m.put("data",xmProjectGroupList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}


		
 
	
	@ApiOperation( value = "查询xm_project_group信息列表",notes="listXmProjectGroup,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="groupName",value="团队名称",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectGroup.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectGroup( @RequestParam Map<String,Object> xmProjectGroup){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectGroup, "ids");
		PageUtils.startPage(xmProjectGroup);
		List<Map<String,Object>>	xmProjectGroupList = xmProjectGroupService.selectListMapByWhere(xmProjectGroup);	//列出XmProjectGroup列表
		PageUtils.responePage(m, xmProjectGroupList);
		m.put("data",xmProjectGroupList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}

	@ApiOperation( value = "新增一条xm_project_group信息",notes="addXmProjectGroup,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectGroup.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmProjectGroup_add",name = "新增项目团队信息",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectGroup(@RequestBody XmProjectGroup xmProjectGroup) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			User u = LoginUtils.getCurrentUserInfo();
			if(!"1".equals(xmProjectGroup.getPgClass())) {
				if(!StringUtils.hasText(xmProjectGroup.getProjectId())){
					return ResponseHelper.failed("projectId-0","项目编号不能为空");
				}
				XmProject project = xmProjectService.getProjectFromCache(xmProjectGroup.getProjectId());
				if(project==null){
					return ResponseHelper.failed("project-0","项目已不存在");
				}
				tips=this.xmProjectGroupService.checkProjectStatus(project);
				if(!tips.isOk()){
					return ResponseHelper.failed(tips);
				}
				Map<String,String> projectAdmMap=xmProjectGroupService.getProjectAdmUsers(project);
				if (projectAdmMap.containsKey(u.getUserid())) {
					return ResponseHelper.failed("not-project-adm","您不是项目管理人员，不能创建小组。项目级助理以上人员可以创建小组。");
				}

			}else{
				if(!StringUtils.hasText(xmProjectGroup.getProductId())){
					return ResponseHelper.failed("productId-0","产品编号不能为空");
				}
				XmProduct product = xmProductService.selectOneObject(new XmProduct(xmProjectGroup.getProductId()));
				if(product==null){
					return ResponseHelper.failed("product-0","产品已不存在");
				}
				tips=this.xmProjectGroupService.checkProductStatus(product);
				if(!tips.isOk()){
					return ResponseHelper.failed(tips);
				}
				Map<String,String> productAdmMap=xmProjectGroupService.getProductAdmUsers(product);
				if (productAdmMap.containsKey(u.getUserid())) {
					return ResponseHelper.failed("not-product-adm","您不是产品管理人员，不能创建小组。产品级助理及以上人员可以创建小组。");
				}
			}
			if (StringUtils.isEmpty(xmProjectGroup.getId())) {
				xmProjectGroup.setId(xmProjectGroupService.createKey("id"));
			} else {
				XmProjectGroup xmProjectGroupQuery = new XmProjectGroup(xmProjectGroup.getId());
				if (xmProjectGroupService.countByWhere(xmProjectGroupQuery) > 0) {
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			this.xmProjectGroupService.parentIdPathsCalcBeforeSave(xmProjectGroup);
			xmProjectGroupService.insert(xmProjectGroup);
			if("1".equals(xmProjectGroup.getPgClass())){
				xmProjectGroupCacheService.clearProductGroup(xmProjectGroup.getProductId(),xmProjectGroup.getId());
				xmRecordService.addXmProductGroupRecord(xmProjectGroup.getProductId(),xmProjectGroup.getId(),"团队-小组-新增小组","新增小组【"+xmProjectGroup.getGroupName()+"】");

			}else {
				xmProjectGroupCacheService.clearProjectGroup(xmProjectGroup.getProjectId(),xmProjectGroup.getId());
				xmRecordService.addXmProductGroupRecord(xmProjectGroup.getProductId(),xmProjectGroup.getId(),"团队-小组-新增小组","新增小组【"+xmProjectGroup.getGroupName()+"】");
			}
  			m.put("data",xmProjectGroup);
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

	@ApiOperation( value = "删除一条xm_project_group信息",notes="delXmProjectGroup,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectGroup(@RequestBody XmProjectGroup xmProjectGroup){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			User u = LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmProjectGroup.getId())){
				return ResponseHelper.failed("id-0","请上送小组编号");
			}
			XmProjectGroup groupDb=this.xmProjectGroupService.selectOneObject(xmProjectGroup);
			if(groupDb==null){
				return ResponseHelper.failed("data-0","小组已不存在");
			}
			if(!"1".equals(groupDb.getPgClass())) {
				if(StringUtils.hasText(groupDb.getProjectId())){
					XmProject project = xmProjectService.getProjectFromCache(xmProjectGroup.getProjectId());
					if(project==null){
						return ResponseHelper.failed("project-0","项目已不存在");
					}
					Map<String,String> projectAdmMap=xmProjectGroupService.getProjectAdmUsers(project);
					if (projectAdmMap.containsKey(u.getUserid())) {
						return ResponseHelper.failed("not-project-adm","您不是项目管理人员，不能删除小组。项目级助理以上人员可以删除小组。");
					}
				}


			}else{
				if(!StringUtils.hasText(xmProjectGroup.getProductId())){
					XmProduct product = xmProductService.selectOneObject(new XmProduct(xmProjectGroup.getProductId()));
					if(product==null){
						return ResponseHelper.failed("product-0","产品已不存在");
					}
					Map<String,String> productAdmMap=xmProjectGroupService.getProductAdmUsers(product);
					if (productAdmMap.containsKey(u.getUserid())) {
						return ResponseHelper.failed("not-product-adm","您不是产品管理人员，不能删除小组。产品级助理及以上人员可以删除小组。");
					}
				}

			}
			if(groupDb.getChildrenCnt()!=null && groupDb.getChildrenCnt()>0){
				return ResponseHelper.failed("childrenCnt-no-0","该小组有下级小组，不能删除。请先删除下级小组。");
			}
			xmProjectGroupService.doDeleteByPk(xmProjectGroup,groupDb);
			if("1".equals(groupDb.getPgClass())){
				xmProjectGroupCacheService.clearProductGroup(groupDb.getProductId(),groupDb.getId());
				xmRecordService.addXmProductGroupRecord(groupDb.getProductId(),groupDb.getId(),"团队-小组-删除小组","删除小组【"+groupDb.getGroupName()+"】");
			}else {
				xmProjectGroupCacheService.clearProjectGroup(groupDb.getProjectId(),groupDb.getId());
				xmRecordService.addXmGroupRecord(groupDb.getProjectId(),groupDb.getId(),"团队-小组-删除小组","删除小组【"+groupDb.getGroupName()+"】");

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

	


	@ApiOperation( value = "根据主键列表批量删除xm_project_group信息",notes="batchDelXmProjectGroup,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectGroup(@RequestBody List<XmProjectGroup> xmProjectGroups) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectGroups.size()+"条数据"); 
		try{
			List<XmProjectGroup> groupsDb=this.xmProjectGroupService.selectListByIds(xmProjectGroups.stream().map(i->i.getId()).collect(Collectors.toList()));
			if(groupsDb==null || groupsDb.size()==0){
				return ResponseHelper.failed("data-0","要删除的小组已不存在");
			}
			User user=LoginUtils.getCurrentUserInfo();
			XmProjectGroup groupDb=groupsDb.get(0);
			String pgClass=groupDb.getPgClass();
			String id=groupDb.getProductId();

			List<XmProjectGroup> hasChildNodes=new ArrayList<>();
			List<XmProjectGroup> noQxs=new ArrayList<>();
			List<XmProjectGroup> canDelNodes=new ArrayList<>();
			if("0".equals(pgClass)){
				id=groupDb.getProjectId();
				XmProject prject=this.xmProjectService.getProjectFromCache(id);
				Map<String,String> projectAdmMap=xmProjectGroupService.getProjectAdmUsers(prject);
				if (projectAdmMap.containsKey(user.getUserid())) {
					return ResponseHelper.failed("not-project-adm","您不是项目管理人员，不能删除小组。项目级助理以上人员可以删除小组。");
				}
			}else{
				id=groupDb.getProductId();
				XmProduct product=this.xmProductService.selectOneObject(new XmProduct(id));
				Map<String,String> productAdmMap=xmProjectGroupService.getProductAdmUsers(product);
				if (productAdmMap.containsKey(user.getUserid())) {
					return ResponseHelper.failed("not-product-adm","您不是产品管理人员，不能删除小组。产品级助理以上人员可以删除小组。");
				}
			}
			if(canDelNodes.size()>0){
				for (XmProjectGroup canDelNode : canDelNodes) {
					if(!xmProjectGroupService.checkCanDelAllChild(canDelNode,canDelNodes)){
						hasChildNodes.add(canDelNode);
					}else{
						canDelNodes.add(canDelNode);
					}
				}
			}
			if(canDelNodes.size()>0){
				String groupNames=canDelNodes.stream().map(i->i.getGroupName()).collect(Collectors.joining(","));
				if("1".equals(pgClass)){
					xmProjectGroupService.doBatchDeleteProductGroups(canDelNodes);
					xmProjectGroupCacheService.clearProductGroups(groupDb.getProductId());
					xmRecordService.addXmProductGroupRecord(groupDb.getProductId(),groupDb.getId(),"团队-小组-批量删除小组","删除"+canDelNodes.size()+"个小组【"+groupNames+"】");

				}else {
					xmProjectGroupService.doBatchDeleteProjectGroups(canDelNodes);
					xmProjectGroupCacheService.clearProjectGroups(groupDb.getProjectId());
					xmRecordService.addXmGroupRecord(groupDb.getProjectId(),groupDb.getId(),"团队-小组-批量删除小组","删除"+canDelNodes.size()+"个小组【"+groupNames+"】");

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
