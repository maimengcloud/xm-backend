package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.core.entity.XmProjectGroupFormwork;
import com.xm.core.service.XmProjectGroupFormworkService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url编制采用rest风格,如对XM.xm_project_group_formwork xm_project_group_formwork的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProjectGroupFormwork/add <br>
 *  查询: xm/xmProjectGroupFormwork/list<br>
 *  模糊查询: xm/xmProjectGroupFormwork/listKey<br>
 *  修改: xm/xmProjectGroupFormwork/edit <br>
 *  删除: xm/xmProjectGroupFormwork/del<br>
 *  批量删除: xm/xmProjectGroupFormwork/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectGroupFormwork 表 XM.xm_project_group_formwork 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectGroupFormworkController")
@RequestMapping(value="/**/xm/core/xmProjectGroupFormwork")
@Api(tags={"xm_project_group_formwork操作接口"})
public class XmProjectGroupFormworkController {
	
	static Log logger=LogFactory.getLog(XmProjectGroupFormworkController.class);
	
	@Autowired
	private XmProjectGroupFormworkService xmProjectGroupFormworkService;
	 
		
 
	
	@ApiOperation( value = "查询xm_project_group_formwork信息列表",notes="listXmProjectGroupFormwork,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="branchId",value="机构编号",required=false),
		@ApiImplicitParam(name="groupName",value="团队名称",required=false),
		@ApiImplicitParam(name="isPub",value="是否公共，0为否，1为是",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectGroupFormwork.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectGroupFormwork( @RequestParam Map<String,Object> xmProjectGroupFormwork){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectGroupFormwork, "ids");
		PageUtils.startPage(xmProjectGroupFormwork);
		List<Map<String,Object>>	xmProjectGroupFormworkList = xmProjectGroupFormworkService.getAllGroupName(xmProjectGroupFormwork);	//列出XmProjectGroupFormwork列表
		PageUtils.responePage(m, xmProjectGroupFormworkList);
		m.put("data",xmProjectGroupFormworkList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	

	@ApiOperation( value = "新增一条xm_project_group_formwork信息",notes="addXmProjectGroupFormwork,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectGroupFormwork.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectGroupFormwork(@RequestBody XmProjectGroupFormwork xmProjectGroupFormwork) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectGroupFormwork.getId())) {
				xmProjectGroupFormwork.setId(xmProjectGroupFormworkService.createKey("id"));
			}else{
				 XmProjectGroupFormwork xmProjectGroupFormworkQuery = new  XmProjectGroupFormwork(xmProjectGroupFormwork.getId());
				if(xmProjectGroupFormworkService.countByWhere(xmProjectGroupFormworkQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmProjectGroupFormworkService.insert(xmProjectGroupFormwork);
			m.put("data",xmProjectGroupFormwork);
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

	@ApiOperation( value = "删除一条xm_project_group_formwork信息",notes="delXmProjectGroupFormwork,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectGroupFormwork(@RequestBody XmProjectGroupFormwork xmProjectGroupFormwork){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectGroupFormworkService.deleteByPk(xmProjectGroupFormwork);
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
	@ApiOperation( value = "根据主键修改一条xm_project_group_formwork信息",notes="editXmProjectGroupFormwork")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectGroupFormwork.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectGroupFormwork(@RequestBody XmProjectGroupFormwork xmProjectGroupFormwork) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectGroupFormworkService.updateByPk(xmProjectGroupFormwork);
			m.put("data",xmProjectGroupFormwork);
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
	

	
	/**
	@ApiOperation( value = "根据主键列表批量删除xm_project_group_formwork信息",notes="batchDelXmProjectGroupFormwork,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectGroupFormwork(@RequestBody List<XmProjectGroupFormwork> xmProjectGroupFormworks) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectGroupFormworks.size()+"条数据"); 
		try{ 
			xmProjectGroupFormworkService.batchDelete(xmProjectGroupFormworks);
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
