package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmGroup;
import com.xm.core.entity.XmProduct;
import com.xm.core.entity.XmProject;
import com.xm.core.service.XmGroupService;
import com.xm.core.service.XmProductService;
import com.xm.core.service.XmProjectService;
import com.xm.core.service.XmRecordService;
import com.xm.core.service.cache.XmGroupCacheService;
import com.xm.core.service.push.XmPushMsgService;
import com.xm.core.vo.XmGroupVo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * url编制采用rest风格,如对XM.xm_group xm_group的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmGroup/add <br>
 *  查询: xm/xmGroup/list<br>
 *  模糊查询: xm/xmGroup/listKey<br>
 *  修改: xm/xmGroup/edit <br>
 *  删除: xm/xmGroup/del<br>
 *  批量删除: xm/xmGroup/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectGroup 表 XM.xm_group 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmGroupController")
@RequestMapping(value="/**/xm/core/xmGroup")
@Api(tags={"xm_group操作接口"})
public class XmGroupController {
	
	static Log logger=LogFactory.getLog(XmGroupController.class);
	
	@Autowired
	private XmGroupService xmGroupService;


	@Autowired
	private XmGroupCacheService xmGroupCacheService;
	
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
			@ApiResponse(code = 200,response= XmGroup.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmGroup_updateGroup",name = "批量更新修改项目团队信息",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> updateGroup(@RequestBody XmGroup group) {

		Tips tips=new Tips("小组更新成功");
		Map<String,Object> m = new HashMap<>();
		if(group==null){
			tips.setFailureMsg("小组信息不能为空");
			m.put("tips", tips);
			return m;
		}
		if(!StringUtils.hasText(group.getId())){
			return ResponseHelper.failed("id-0","小组编号不能为空");
		}
		User user=LoginUtils.getCurrentUserInfo();
		XmGroup groupDb=this.xmGroupService.selectOneObject(new XmGroup(group.getId()));
		if(groupDb==null){
			return ResponseHelper.failed("data-0","小组已不存在。");
		}
		if("1".equals(groupDb.getPgClass())){
			XmProduct xmProduct=this.xmProductService.selectOneObject(new XmProduct(groupDb.getProductId()));
			tips=this.xmGroupService.checkProductStatus(xmProduct);
			if(tips.isOk()==false){
				return ResponseHelper.failed(tips);
			}
			tips=this.xmGroupService.checkHasEditProdcutGroupQx(user,group,groupDb,xmProduct);
			if(tips.isOk()==false){
				return ResponseHelper.failed(tips);
			}
		}else{
			XmProject xmProject=this.xmProjectService.getProjectFromCache(groupDb.getProjectId());
			tips=this.xmGroupService.checkProjectStatus(xmProject);
			if(tips.isOk()==false){
				return ResponseHelper.failed(tips);
			}
			tips=this.xmGroupService.checkHasEditProjectGroupQx(user,group,groupDb,xmProject);
			if(tips.isOk()==false){
				return ResponseHelper.failed(tips);
			}
		}
		xmGroupService.parentIdPathsCalcBeforeSave(group);
		tips= xmGroupService.updateGroup(group,groupDb);	//列出XmProjectGroup列表
		if("1".equals(groupDb.getPgClass())){
			xmGroupCacheService.clearProductGroup(groupDb.getProductId());
			xmRecordService.addXmProductGroupRecord(groupDb.getProductId(),groupDb.getId(),"团队-小组-修改小组","修改小组信息【"+groupDb.getGroupName()+"】");
		}else {
			xmGroupCacheService.clearProjectGroup(groupDb.getProjectId());
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
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
			@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false)
	})
	@ApiResponses({
			@ApiResponse(code = 200,response= XmGroup.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmGroup_getGroups",name = "查找项目团队信息",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/getGroups",method=RequestMethod.GET)
	public Map<String,Object> getGroup(@ApiIgnore @RequestParam Map<String,Object> params) {
		Map<String,Object> m = new HashMap<>();
		RequestUtils.transformArray(params, "ids");
		PageUtils.startPage(params);
		List<XmGroupVo>	xmGroupList=new ArrayList<>();
		String iterationId= (String) params.get("iterationId");
		String projectId= (String) params.get("projectId");
		String productId= (String) params.get("productId");
		if(StringUtils.hasText(projectId)){
			xmGroupList = xmGroupService.getProjectGroupVoList(projectId);	//列出XmProjectGroup列表
		}else if(StringUtils.hasText(iterationId)){
			xmGroupList = xmGroupService.getProjectGroupVoListByIterationId(iterationId );	//列出XmProjectGroup列表
		}else  if(StringUtils.hasText(productId)){
			xmGroupList = xmGroupService.getProjectGroupVoListByProductId( productId);	//列出XmProjectGroup列表
		}

		PageUtils.responePage(m, xmGroupList);
		m.put("data",xmGroupList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}


		
 
	
	@ApiOperation( value = "查询xm_group信息列表",notes="listXmProjectGroup,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="groupName",value="团队名称",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmGroup.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectGroup( @ApiIgnore @RequestParam Map<String,Object> xmGroup){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmGroup, "ids");
		PageUtils.startPage(xmGroup);
		User user=LoginUtils.getCurrentUserInfo();
		String projectId= (String) xmGroup.get("projectId");
		String productId= (String) xmGroup.get("productId");
		String iterationId= (String) xmGroup.get("iterationId");
		if(!StringUtils.hasText(projectId) && !StringUtils.hasText(productId) && !StringUtils.hasText(iterationId)){
			xmGroup.put("branchId",user.getBranchId());
			xmGroup.put("orCrowBranchId",user.getBranchId());
		}
		List<Map<String,Object>>	xmGroupList = xmGroupService.selectListMapByWhere(xmGroup);	//列出XmProjectGroup列表
		PageUtils.responePage(m, xmGroupList);
		m.put("data",xmGroupList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}

	@ApiOperation( value = "新增一条xm_group信息",notes="addXmProjectGroup,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response= XmGroup.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmGroup_add",name = "新增项目团队信息",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectGroup(@RequestBody XmGroup xmGroup) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			User u = LoginUtils.getCurrentUserInfo();
			if(!"1".equals(xmGroup.getPgClass())) {
				if(!StringUtils.hasText(xmGroup.getProjectId())){
					return ResponseHelper.failed("projectId-0","项目编号不能为空");
				}
				XmProject project = xmProjectService.getProjectFromCache(xmGroup.getProjectId());
				if(project==null){
					return ResponseHelper.failed("project-0","项目已不存在");
				}
				tips=this.xmGroupService.checkProjectStatus(project);
				if(!tips.isOk()){
					return ResponseHelper.failed(tips);
				}
				Map<String,String> projectAdmMap=xmGroupService.getProjectAdmUsers(project);
				if(!projectAdmMap.containsKey(u.getUserid())) {
					return ResponseHelper.failed("not-project-adm","您不是项目管理人员，不能创建小组。项目级助理以上人员可以创建小组。");
				}
				xmGroup.setProductId(null);

				xmGroup.setBranchId(project.getBranchId());

			}else{
				if(!StringUtils.hasText(xmGroup.getProductId())){
					return ResponseHelper.failed("productId-0","产品编号不能为空");
				}

				XmProduct product = xmProductService.selectOneObject(new XmProduct(xmGroup.getProductId()));
				if(product==null){
					return ResponseHelper.failed("product-0","产品已不存在");
				}
				tips=this.xmGroupService.checkProductStatus(product);
				if(!tips.isOk()){
					return ResponseHelper.failed(tips);
				}
				xmGroup.setBranchId(product.getBranchId());
				Map<String,String> productAdmMap=xmGroupService.getProductAdmUsers(product);
				if(!productAdmMap.containsKey(u.getUserid())) {
					return ResponseHelper.failed("not-product-adm","您不是产品管理人员，不能创建小组。产品级助理及以上人员可以创建小组。");
				}
				xmGroup.setProjectId(null);
			}
			if (StringUtils.isEmpty(xmGroup.getId())) {
				xmGroup.setId(xmGroupService.createKey("id"));
			} else {
				XmGroup xmGroupQuery = new XmGroup(xmGroup.getId());
				if (xmGroupService.countByWhere(xmGroupQuery) > 0) {
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			if(StringUtils.hasText(xmGroup.getBranchId())){
				xmGroup.setBranchId(u.getBranchId());
			}
			this.xmGroupService.parentIdPathsCalcBeforeSave(xmGroup);
			xmGroupService.insert(xmGroup);
			if("1".equals(xmGroup.getPgClass())){
				xmGroupCacheService.clearProductGroup(xmGroup.getProductId());
				xmRecordService.addXmProductGroupRecord(xmGroup.getProductId(),xmGroup.getId(),"团队-小组-新增小组","新增小组【"+xmGroup.getGroupName()+"】");

			}else {
				xmGroupCacheService.clearProjectGroup(xmGroup.getProjectId());
				xmRecordService.addXmProductGroupRecord(xmGroup.getProductId(),xmGroup.getId(),"团队-小组-新增小组","新增小组【"+xmGroup.getGroupName()+"】");
			}
  			m.put("data",xmGroup);
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

	@ApiOperation( value = "删除一条xm_group信息",notes="delXmProjectGroup,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectGroup(@RequestBody XmGroup xmGroup){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			User u = LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmGroup.getId())){
				return ResponseHelper.failed("id-0","请上送小组编号");
			}
			XmGroup groupDb=this.xmGroupService.selectOneObject(xmGroup);
			if(groupDb==null){
				return ResponseHelper.failed("data-0","小组已不存在");
			}
			if(!"1".equals(groupDb.getPgClass())) {
				if(StringUtils.hasText(groupDb.getProjectId())){
					XmProject project = xmProjectService.getProjectFromCache(groupDb.getProjectId());
					if(project==null){
						return ResponseHelper.failed("project-0","项目已不存在");
					}
					Map<String,String> projectAdmMap=xmGroupService.getProjectAdmUsers(project);
					if(!projectAdmMap.containsKey(u.getUserid())) {
						return ResponseHelper.failed("not-project-adm","您不是项目管理人员，不能删除小组。项目级助理以上人员可以删除小组。");
					}
				}


			}else{
				if(!StringUtils.hasText(xmGroup.getProductId())){
					XmProduct product = xmProductService.selectOneObject(new XmProduct(groupDb.getProductId()));
					if(product==null){
						return ResponseHelper.failed("product-0","产品已不存在");
					}
					Map<String,String> productAdmMap=xmGroupService.getProductAdmUsers(product);
					if(!productAdmMap.containsKey(u.getUserid())) {
						return ResponseHelper.failed("not-product-adm","您不是产品管理人员，不能删除小组。产品级助理及以上人员可以删除小组。");
					}
				}

			}
			XmGroup childrenGroupQuery=new XmGroup();
			childrenGroupQuery.setPgroupId(xmGroup.getId());
			long childrenCnt=this.xmGroupService.countByWhere(childrenGroupQuery);
			if(childrenCnt>0){
				return ResponseHelper.failed("childrenCnt-no-0","该小组有下级小组，不能删除。请先删除下级小组。");
			}
			xmGroupService.doDeleteByPk(xmGroup,groupDb);
			if("1".equals(groupDb.getPgClass())){
				xmGroupCacheService.clearProductGroup(groupDb.getProductId());
				xmRecordService.addXmProductGroupRecord(groupDb.getProductId(),groupDb.getId(),"团队-小组-删除小组","删除小组【"+groupDb.getGroupName()+"】");
			}else {
				xmGroupCacheService.clearProjectGroup(groupDb.getProjectId());
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

	


	@ApiOperation( value = "根据主键列表批量删除xm_group信息",notes="batchDelXmProjectGroup,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectGroup(@RequestBody List<XmGroup> xmGroups) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmGroups.size()+"条数据"); 
		try{
			List<XmGroup> groupsDb=this.xmGroupService.selectListByIds(xmGroups.stream().map(i->i.getId()).collect(Collectors.toList()));
			if(groupsDb==null || groupsDb.size()==0){
				return ResponseHelper.failed("data-0","要删除的小组已不存在");
			}
			User user=LoginUtils.getCurrentUserInfo();
			XmGroup groupDb=groupsDb.get(0);
			String pgClass=groupDb.getPgClass();
			String id=groupDb.getProductId();

			List<XmGroup> hasChildNodes=new ArrayList<>();
			List<XmGroup> noQxs=new ArrayList<>();
			List<XmGroup> canDelNodes=new ArrayList<>();
			if("0".equals(pgClass)){
				id=groupDb.getProjectId();
				XmProject prject=this.xmProjectService.getProjectFromCache(id);
				Map<String,String> projectAdmMap=xmGroupService.getProjectAdmUsers(prject);
				if (!projectAdmMap.containsKey(user.getUserid())) {
					return ResponseHelper.failed("not-project-adm","您不是项目管理人员，不能删除小组。项目级助理以上人员可以删除小组。");
				}
			}else{
				id=groupDb.getProductId();
				XmProduct product=this.xmProductService.getProductFromCache( id );
				Map<String,String> productAdmMap=xmGroupService.getProductAdmUsers(product);
				if(!productAdmMap.containsKey(user.getUserid())) {
					return ResponseHelper.failed("not-product-adm","您不是产品管理人员，不能删除小组。产品级助理以上人员可以删除小组。");
				}
			}
			if(canDelNodes.size()>0){
				for (XmGroup canDelNode : canDelNodes) {
					if(!xmGroupService.checkCanDelAllChild(canDelNode,canDelNodes)){
						hasChildNodes.add(canDelNode);
					}else{
						canDelNodes.add(canDelNode);
					}
				}
			}
			if(canDelNodes.size()>0){
				String groupNames=canDelNodes.stream().map(i->i.getGroupName()).collect(Collectors.joining(","));
				if("1".equals(pgClass)){
					xmGroupService.doBatchDeleteProductGroups(canDelNodes);
					xmGroupCacheService.clearProductGroups(groupDb.getProductId());
					xmRecordService.addXmProductGroupRecord(groupDb.getProductId(),groupDb.getId(),"团队-小组-批量删除小组","删除"+canDelNodes.size()+"个小组【"+groupNames+"】");

				}else {
					xmGroupService.doBatchDeleteProjectGroups(canDelNodes);
					xmGroupCacheService.clearProjectGroups(groupDb.getProjectId());
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
