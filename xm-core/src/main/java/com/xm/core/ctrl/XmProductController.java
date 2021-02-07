package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.common.entity.User;
import com.mdp.safe.common.utils.LoginUtils;
import com.xm.core.entity.XmProduct;
import com.xm.core.service.XmProductService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
		RequestUtils.transformArray(xmProduct, "ids");
		PageUtils.startPage(xmProduct);
		List<Map<String,Object>>	xmProductList = xmProductService.selectListMapByWhere(xmProduct);	//列出XmProduct列表
		PageUtils.responePage(m, xmProductList);
		m.put("data",xmProductList);
		Tips tips=new Tips("查询成功");
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
		RequestUtils.transformArray(xmProduct, "ids");
		PageUtils.startPage(xmProduct);
		List<Map<String,Object>>	xmProductList = xmProductService.selectListMapByWhereWithState(xmProduct);	//列出XmProduct列表
		PageUtils.responePage(m, xmProductList);
		m.put("data",xmProductList);
		Tips tips=new Tips("查询成功");
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
	public Map<String,Object> addXmProduct(@RequestBody XmProduct xmProduct) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProduct.getId())) {
				xmProduct.setId(xmProductService.createKey("id"));
			}else{
				 XmProduct xmProductQuery = new  XmProduct(xmProduct.getId());
				if(xmProductService.countByWhere(xmProductQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			User user=LoginUtils.getCurrentUserInfo();
			if(StringUtils.isEmpty(xmProduct.getPmUserid())) {
				xmProduct.setPmUserid(user.getUserid());
				xmProduct.setPmUsername(user.getUsername());
			}
			xmProduct.setCtime(new Date());
			xmProductService.insert(xmProduct);
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
			long projects=xmProductService.checkExistsProject(xmProduct.getId());
			
			if(projects>0) {
				tips.setFailureMsg("该产品有"+projects+"个项目关联，不允许删除，请先解绑项目");
			}else {
				long menus=xmProductService.checkExistsMenu(xmProduct.getId());
				if(menus>0) {
					tips.setFailureMsg("该产品有"+menus+"个故事关联，不允许删除，请先解绑故事");
				}else { 
					xmProductService.deleteByPk(xmProduct);
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
			xmProductService.updateByPk(xmProduct);
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
			List<String> hasProjects=new ArrayList<>();
			List<String> hasMenus=new ArrayList<>();
			List<XmProduct> canDelList=new ArrayList<>();
			for (XmProduct xmProduct : xmProducts) {
				long projects=xmProductService.checkExistsProject(xmProduct.getId());
				if(projects>0) {
					hasProjects.add(xmProduct.getProductName());
				}else {
					long menus=xmProductService.checkExistsMenu(xmProduct.getId());
					if(menus>0) { 
						hasMenus.add(xmProduct.getProductName());
					}else {  
						canDelList.add(xmProduct);
					}

					
				}
			}
			if(canDelList.size()>0) {
				xmProductService.batchDelete(canDelList);
			}
			String msg="成功删除"+canDelList+"条产品信息";
			if(hasProjects.size()>0 ) {
				msg=msg+",【"+StringUtils.arrayToDelimitedString(hasProjects.toArray(), ",")+"】存在项目关联，不允许删除";
			} 
			if(hasMenus.size()>0 ) {
				msg=msg+",【"+StringUtils.arrayToDelimitedString(hasMenus.toArray(), ",")+"】存在故事关联，不允许删除";
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
	
}
