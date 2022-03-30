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
import com.xm.core.entity.XmProductCopyVo;
import com.xm.core.entity.XmProductProjectLink;
import com.xm.core.service.XmProductService;
import com.xm.core.service.XmGroupService;
import com.xm.core.service.XmProductStateService;
import com.xm.core.service.XmRecordService;
import com.xm.core.vo.XmProductAddVo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * url编制采用rest风格,如对XM.xm_product 产品表的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProduct/add <br>
 *  查询: xm/xmProduct/list<br>
 *  模糊查询: xm/xmProduct/listKey<br>
 *  修改: xm/xmProduct/edit <br>
 *  删除: xm/xmProduct/del<br>
 *  批量删除: xm/xmProduct/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProduct 表 XM.xm_product 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProductController")
@RequestMapping(value="/**/xm/core/xmProduct")
@Api(tags={"产品表操作接口"})
public class XmProductController {
	
	static Log logger=LogFactory.getLog(XmProductController.class);
	
	@Autowired
	private XmProductService xmProductService;

	@Autowired
	private XmGroupService groupService;


	@Autowired
	private XmRecordService xmRecordService;

	@Value("${mdp.platform-branch-id:platform-branch-001}")
	String platformBranchId="platform-branch-001";
	@Autowired
	XmProductStateService xmProductStateService;
	@ApiOperation( value = "查询产品表信息列表",notes="listXmProduct,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="菜单编号,主键",required=false),
		@ApiImplicitParam(name="productName",value="菜单名称",required=false),
		@ApiImplicitParam(name="branchId",value="机构号",required=false),
		@ApiImplicitParam(name="remark",value="备注",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProduct.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProduct( @RequestParam Map<String,Object> xmProduct){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmProduct, "ids");
		PageUtils.startPage(xmProduct);
		String id= (String) xmProduct.get("id");
		Object ids=  xmProduct.get("ids");
		String projectId= (String) xmProduct.get("projectId");
		String pmUserid= (String) xmProduct.get("pmUserid");
		String queryScope= (String) xmProduct.get("queryScope");
		User user = LoginUtils.getCurrentUserInfo();
		if("branchId".equals(queryScope)){
			xmProduct.put("branchId",user.getBranchId());
		}else if("compete".equals(queryScope)){
			xmProduct.put("branchId",null);
			xmProduct.put("compete",user.getUserid());
		}else if("productId".equals(queryScope)){
			if(!StringUtils.hasText(id)){
				tips.setFailureMsg("产品编号id必输");
				m.put("tips", tips);
				return m;
			}
		}


		xmProduct.put("userid",user.getUserid());
		if( !StringUtils.hasText(queryScope) && !(StringUtils.hasText(id) || StringUtils.hasText(projectId)|| StringUtils.hasText(pmUserid)||ids!=null
				 ||ids!=null ) ){
			xmProduct.put("compete",user.getUserid());
		}
		if(!StringUtils.hasText((String) xmProduct.get("isTpl"))){
			xmProduct.put("isTpl","0");
		}else{
			if("1".equals(xmProduct.get("isTpl"))){
				xmProduct.remove("branchId");
				xmProduct.put("myBranchId",user.getBranchId());
				xmProduct.put("platformBranchId",platformBranchId);
			}
		}
		List<Map<String,Object>>	xmProductList = xmProductService.selectListMapByWhere(xmProduct);	//列出XmProduct列表
		PageUtils.responePage(m, xmProductList);
		m.put("data",xmProductList);

		m.put("tips", tips);
		return m;
	}
	@ApiOperation( value = "查询产品表信息列表连同相关状态数据一起带出",notes="") 
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProduct.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listWithState",method=RequestMethod.GET)
	public Map<String,Object> listWithState( @RequestParam Map<String,Object> xmProduct){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmProduct, "ids");
		PageUtils.startPage(xmProduct);
		String id= (String) xmProduct.get("id");
		Object ids=  xmProduct.get("ids");
		String projectId= (String) xmProduct.get("projectId");
		String pmUserid= (String) xmProduct.get("pmUserid");
		String queryScope= (String) xmProduct.get("queryScope");
		User user = LoginUtils.getCurrentUserInfo();
		if("branchId".equals(queryScope)){
			xmProduct.put("branchId",user.getBranchId());
		}else if("compete".equals(queryScope)){
			xmProduct.put("branchId",null);
			xmProduct.put("compete",user.getUserid());
		}else if("productId".equals(queryScope)){
			if(!StringUtils.hasText(id)){
				tips.setFailureMsg("产品编号id必输");
				m.put("tips", tips);
				return m;
			}
		}

		xmProduct.put("userid",user.getUserid());
		if( !StringUtils.hasText(queryScope) && !(StringUtils.hasText(id) || StringUtils.hasText(projectId)|| StringUtils.hasText(pmUserid)||ids!=null
				||ids!=null ) ){
			xmProduct.put("compete",user.getUserid());
		}
		if(!StringUtils.hasText((String) xmProduct.get("isTpl"))){
			xmProduct.put("isTpl","0");
		}else{
			if("1".equals(xmProduct.get("isTpl"))){
				xmProduct.remove("branchId");
				xmProduct.put("myBranchId",user.getBranchId());
				xmProduct.put("platformBranchId",platformBranchId);
			}
		}
		List<Map<String,Object>>	xmProductList = xmProductService.selectListMapByWhereWithState(xmProduct);	//列出XmProduct列表
		PageUtils.responePage(m, xmProductList);
		m.put("data",xmProductList);

		m.put("tips", tips);
		return m;
	}

	/***/
	@ApiOperation( value = "新增一条产品表信息",notes="addXmProduct,主键如果为空，后台自动生成")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmProduct.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmProduct_copyTo",name = "通过复制创建产品/战略规划等",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/copyTo",method=RequestMethod.POST)
	public Map<String,Object> copyTo(@RequestBody XmProductCopyVo xmProduct) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("拷贝成功");
		try{
			User user= LoginUtils.getCurrentUserInfo();
			if( !StringUtils.hasText(xmProduct.getId())){
				return ResponseHelper.failed("id-0","请上送原产品编号参数id");
			}
			if( !StringUtils.hasText(xmProduct.getProductName())){
				return ResponseHelper.failed("productName-0","请上送新产品名称");
			}
			if(StringUtils.hasText(xmProduct.getCode())){
				XmProduct pq=new XmProduct();
				pq.setBranchId(user.getBranchId());
				pq.setCode(xmProduct.getCode());
				List<XmProduct> xmProductList=this.xmProductService.selectListByWhere(pq);
				if(xmProductList!=null && xmProductList.size()>0){
					return ResponseHelper.failed("code-exists","产品编码【"+xmProduct.getCode()+"】已存在，，请重新输入新的产品编码，如果为空，后台自动生成");
				}
			}

			XmProduct xmProductNew=xmProductService.copyTo(user,xmProduct);
			xmRecordService.addXmProductRecord(xmProductNew.getId(),"通过拷贝创建产品","拷贝项目【"+xmProduct.getId()+"】【"+xmProduct.getProductName()+"】,创建新的项目【"+xmProductNew.getId()+"】【"+xmProductNew.getProductName()+"】","参数:"+ JSON.toJSONString(xmProduct),"");
			m.put("data",xmProductNew);
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
	@ApiOperation( value = "新增一条产品表信息",notes="addXmProduct,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProduct.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmProduct_add",name = "创建产品/战略规划等",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProduct(@RequestBody XmProductAddVo xmProduct) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("创建产品成功");
		try{
			User user=LoginUtils.getCurrentUserInfo();
			if(StringUtils.isEmpty(xmProduct.getCode())) {
				return ResponseHelper.failed("code-0","","产品代号不能为空");
			}else{
				 XmProduct xmProductQuery = new  XmProduct();
				xmProductQuery.setBranchId(user.getBranchId());
				xmProductQuery.setCode(xmProduct.getCode());
				if(xmProductService.countByWhere(xmProductQuery)>0){
					tips.setFailureMsg("产品代号已存在，请修改再提交");
					m.put("tips", tips);
					return m;
				}
			}
			if(xmProduct.getLinks()!=null && xmProduct.getLinks().size()>0){
				for (XmProductProjectLink link : xmProduct.getLinks()) {
					if(!StringUtils.hasText(link.getProjectId())) {
						return ResponseHelper.failed("projectId-0", "", "关联项目编号不能为空");
					}
				}
			}
			if(!StringUtils.hasText(xmProduct.getProductName())){
				return ResponseHelper.failed("productName-0","","产品名称不能为空");
			}
			if(StringUtils.isEmpty(xmProduct.getPmUserid())) {
				xmProduct.setPmUserid(user.getUserid());
				xmProduct.setPmUsername(user.getUsername());
			}
			xmProduct.setId(this.xmProductService.createProductId(xmProduct.getCode()));
			xmProduct.setCtime(new Date());
			xmProduct.setLtime(new Date());
			if(!StringUtils.hasText(xmProduct.getIsTpl())){
				xmProduct.setIsTpl("0");
			}
			xmProduct.setBizFlowState("0");
			xmProduct.setPstatus("0");
			xmProduct.setDel("0");
			xmProduct.setLocked("0");
			if(xmProduct.getLinks()!=null && xmProduct.getLinks().size()>0){
				for (XmProductProjectLink link : xmProduct.getLinks()) {
					 link.setProductId(xmProduct.getId());
					 link.setCusername(user.getUsername());
					 link.setCuserid(user.getUserid());
					 link.setLinkStatus("1");
					 link.setCtime(new Date());
				}
			}
			xmProductService.addProduct(xmProduct);
			xmRecordService.addXmProductRecord(xmProduct.getId(),"创建产品","创建产品【"+xmProduct.getId()+"】【"+xmProduct.getProductName()+"】");
			xmProductStateService.loadTasksToXmProductState(xmProduct.getId());
			m.put("data",xmProduct);
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
	@ApiOperation( value = "从回收站恢复产品",notes="unDelXmProduct,仅需要上传主键字段")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@HasQx(value = "xm_core_xmProduct_unDel",name = "从回收站恢复产品等",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/unDel",method=RequestMethod.POST)
	public Map<String,Object> unDelXmProduct(@RequestBody XmProduct xmProduct){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功从回收站恢复产品");
		try{
			if(!StringUtils.hasText(xmProduct.getId())){
				return ResponseHelper.failed("id-0","","产品编号不能为空");
			}
			User user=LoginUtils.getCurrentUserInfo();
			XmProduct xmProductDb=xmProductService.getProductFromCache(xmProduct.getId());
			if(xmProductDb==null){
				return ResponseHelper.failed("data-0","产品已不存在");
			}else if(!"1".equals(xmProductDb.getDel())){
				return ResponseHelper.failed("del-not-1","该产品不是已删除状态");
			}else if(!user.getBranchId().equals(xmProductDb.getBranchId())){
				return ResponseHelper.failed("branchId-not-right","该产品不属于您所在的机构，不允许操作");
			}else if(!groupService.checkUserIsProductAdm(xmProductDb,user.getUserid())){
				return ResponseHelper.failed("pmUserid-not-right","您不是该产品产品负责人,也不是产品助理，不允许操作");
			}
			/**
			 if(!"1".equals(xmProductDb.getIsTpl())){
			 long menus=xmProductService.checkExistsMenu(xmProduct.getId());
			 if(menus>0) {
			 return ResponseHelper.failed("had-menus","该产品有"+menus+"个需求关联，不允许删除，请先解绑需求");

			 }
			 }
			 **/
			XmProduct xmProductDel=new XmProduct();
			xmProductDel.setId(xmProductDb.getId());
			xmProductDel.setDel("0");
			xmProductDel.setLtime(new Date());
			xmProductService.updateSomeFieldByPk(xmProductDel);
			xmProductService.clearCache(xmProduct.getId());
			xmRecordService.addXmProductRecord(xmProduct.getId(),"从回收站恢复产品",user.getUsername()+"从回收站恢复产品产品【"+xmProductDb.getId()+"】【"+xmProductDb.getProductName()+"】","",JSON.toJSONString(xmProductDb));

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
	@ApiOperation( value = "删除一条产品表信息",notes="delXmProduct,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@HasQx(value = "xm_core_xmProduct_del",name = "删除产品/战略规划等",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProduct(@RequestBody XmProduct xmProduct){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			if(!StringUtils.hasText(xmProduct.getId())){
				return ResponseHelper.failed("id-0","","产品编号不能为空");
			}
 			User user=LoginUtils.getCurrentUserInfo();
			 XmProduct xmProductDb=xmProductService.getProductFromCache(xmProduct.getId());
			 if(xmProductDb==null){
				return ResponseHelper.failed("data-0","产品已不存在");
			 }else if(!"0".equals(xmProductDb.getPstatus())&&!"3".equals(xmProductDb.getPstatus())){
				 return ResponseHelper.failed("pstatus-not-0-3","该产品不是初始、已关闭状态，不允许删除");
			 }else if(!user.getBranchId().equals(xmProductDb.getBranchId())){
				 return ResponseHelper.failed("branchId-not-right","该产品不属于您所在的机构，不允许删除");
			 }else if(!groupService.checkUserIsProductAdm(xmProductDb,user.getUserid())){
				 return ResponseHelper.failed("pmUserid-not-right","您不是该产品产品负责人,也不是产品助理，不允许删除");
			 }
			 /**
			 if(!"1".equals(xmProductDb.getIsTpl())){
				 long menus=xmProductService.checkExistsMenu(xmProduct.getId());
				 if(menus>0) {
					 return ResponseHelper.failed("had-menus","该产品有"+menus+"个需求关联，不允许删除，请先解绑需求");

				 }
			 }
			  **/
			 XmProduct xmProductDel=new XmProduct();
			 xmProductDel.setId(xmProductDb.getId());
			 xmProductDel.setDel("1");
			xmProductDel.setLtime(new Date());
			 xmProductService.updateSomeFieldByPk(xmProductDel);
			xmProductService.clearCache(xmProduct.getId());
			xmRecordService.addXmProductRecord(xmProduct.getId(),"删除产品",user.getUsername()+"删除产品【"+xmProductDb.getId()+"】【"+xmProductDb.getProductName()+"】","",JSON.toJSONString(xmProductDb));

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
	@ApiOperation( value = "创建产品代号",notes="createProductCode")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmProduct.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmProduct_createProductCode",name = "创建产品代号",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/createProductCode",method=RequestMethod.POST)
	public Map<String,Object> createProductCode() {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功创建产品代号");
		try{
			User user=LoginUtils.getCurrentUserInfo();
			String data=this.xmProductService.createProductCode(user.getBranchId());
			m.put("data",data);
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
	@ApiOperation( value = "根据主键修改一条产品表信息",notes="editXmProduct")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProduct.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmProduct_edit",name = "修改产品/战略规划等基本信息",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProduct(@RequestBody XmProduct xmProduct) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			XmProduct xmProductDb=xmProductService.getProductFromCache(xmProduct.getId());
			if(xmProductDb==null){
				return ResponseHelper.failed("product-0","产品已不存在");
			}
			User user=LoginUtils.getCurrentUserInfo();
			if(!groupService.checkUserIsProductAdm(xmProductDb,user.getUserid())){
				return ResponseHelper.failed("no-qx-0","您无权修改该产品");
			}
			xmProduct.setLtime(new Date());
			xmProductService.updateSomeFieldByPk(xmProduct);
			xmProductService.clearCache(xmProduct.getId());
			xmRecordService.addXmProductRecord(xmProduct.getId(),"修改产品","修改产品【"+xmProductDb.getId()+"】【"+xmProductDb.getProductName()+"】",JSON.toJSONString(xmProduct),JSON.toJSONString(xmProductDb));

			m.put("data",xmProduct);
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
	@ApiOperation( value = "根据主键列表批量删除产品表信息",notes="batchDelXmProduct,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmProduct_batchDel",name = "批量删除产品/战略规划等基本信息",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProduct(@RequestBody List<XmProduct> xmProducts) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProducts.size()+"条数据"); 
		try{
			User user=LoginUtils.getCurrentUserInfo();
 			List<XmProduct> canDelList=new ArrayList<>();
			List<Tips> errTips=new ArrayList<>();
			for (XmProduct xmProduct : xmProducts) {
				Tips otips=new Tips();
				if(!StringUtils.hasText(xmProduct.getId())){
					otips.setFailureMsg("id-0","","产品编号不能为空");
					errTips.add(otips);
					continue;
				}
				XmProduct xmProductDb=xmProductService.getProductFromCache(xmProduct.getId());

				if(xmProductDb==null){
					otips.setFailureMsg("data-0","","产品【"+xmProductDb.getProductName()+"】已不存在");
				}else if(!"0".equals(xmProductDb.getPstatus())&&!"3".equals(xmProductDb.getPstatus())){
					otips.setFailureMsg("pstatus-not-0-3","产品【"+xmProductDb.getProductName()+"】不是初始、已关闭状态，不允许删除");
 				}else if(!user.getBranchId().equals(xmProductDb.getBranchId())){
					otips.setFailureMsg("branchId-not-right","产品【"+xmProductDb.getProductName()+"】不属于您所在的机构，不允许删除");
 				}else if(!groupService.checkUserIsProductAdm(xmProductDb,user.getUserid())){
					otips.setFailureMsg("pmUserid-not-right","您不是产品【"+xmProductDb.getProductName()+"】负责人,也不是产品助理，不允许删除");
 				}else{
					if(!"1".equals(xmProductDb.getIsTpl())){
						long menus=xmProductService.checkExistsMenu(xmProduct.getId());
						if(menus>0) {
							otips.setFailureMsg("had-menus","产品【"+xmProductDb.getProductName()+"】有"+menus+"个需求关联，不允许删除，请先解绑需求");
						}
					}
				}

				if(otips.isOk()){
					canDelList.add(xmProductDb);
				}else {
					errTips.add(tips);
				}
			}
			if(canDelList.size()>0) {
				//xmProductService.doBatchDelete(canDelList);//不允许批量删除
				for (XmProduct xmProduct : canDelList) {
					xmProductService.clearCache(xmProduct.getId());
					xmRecordService.addXmProductRecord(xmProduct.getId(),"批量删除产品","批量删除产品【"+xmProduct.getId()+"】【"+xmProduct.getProductName()+"】","",JSON.toJSONString(xmProduct));

				}


			}
			String msg="成功删除"+canDelList.size()+"条产品信息";
			if(canDelList.size()==xmProducts.size()){
				tips.setOkMsg(msg);
			}else{
				if(errTips.size()>0 && canDelList.size()>0){
					String errmsg=errTips.stream().map(i->i.getMsg()).collect(Collectors.joining(" "));
					tips.setOkMsg(msg+"\n"+errmsg);
				}else{
					tips.setFailureMsg(errTips.stream().map(i->i.getMsg()).collect(Collectors.joining(" ")));
				}
			}
			return tips;

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
	
}
