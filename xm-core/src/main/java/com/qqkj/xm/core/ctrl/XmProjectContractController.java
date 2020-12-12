package com.qqkj.xm.core.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qqkj.mdp.core.entity.Tips;
import com.qqkj.mdp.core.utils.RequestUtils;
import com.qqkj.mdp.mybatis.PageUtils;
import com.qqkj.xm.core.entity.XmProjectContract;
import com.qqkj.xm.core.service.XmProjectContractService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * url编制采用rest风格,如对XM.xm_project_contract xm_project_contract的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProjectContract/add <br>
 *  查询: xm/xmProjectContract/list<br>
 *  模糊查询: xm/xmProjectContract/listKey<br>
 *  修改: xm/xmProjectContract/edit <br>
 *  删除: xm/xmProjectContract/del<br>
 *  批量删除: xm/xmProjectContract/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectContract 表 XM.xm_project_contract 当前主键(包括多主键): ht_id; 
 ***/
@RestController("xm.core.xmProjectContractController")
@RequestMapping(value="/**/xm/core/xmProjectContract")
@Api(tags={"xm_project_contract操作接口"})
public class XmProjectContractController {
	
	static Log logger=LogFactory.getLog(XmProjectContractController.class);
	
	@Autowired
	private XmProjectContractService xmProjectContractService;
	 
 
	
	@ApiOperation( value = "查询xm_project_contract信息列表",notes="listXmProjectContract,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="htId",value="合同编号,主键",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectContract.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectContract( @RequestParam Map<String,Object> contractCard){
		Map<String,Object> m = new HashMap<>();
		RequestUtils.transformArray(contractCard, "htIds");
		PageUtils.startPage(contractCard); 
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	/**
	@ApiOperation( value = "新增一条xm_project_contract信息",notes="addXmProjectContract,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectContract.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectContract(@RequestBody XmProjectContract xmProjectContract) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectContract.getHtId())) {
				xmProjectContract.setHtId(xmProjectContractService.createKey("htId"));
			}else{
				 XmProjectContract xmProjectContractQuery = new  XmProjectContract(xmProjectContract.getHtId());
				if(xmProjectContractService.countByWhere(xmProjectContractQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmProjectContractService.insert(xmProjectContract);
			m.put("data",xmProjectContract);
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
	@ApiOperation( value = "删除一条xm_project_contract信息",notes="delXmProjectContract,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectContract(@RequestBody XmProjectContract xmProjectContract){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectContractService.deleteByPk(xmProjectContract);
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
	@ApiOperation( value = "根据主键修改一条xm_project_contract信息",notes="editXmProjectContract")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectContract.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectContract(@RequestBody XmProjectContract xmProjectContract) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectContractService.updateByPk(xmProjectContract);
			m.put("data",xmProjectContract);
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
	@ApiOperation( value = "根据主键列表批量删除xm_project_contract信息",notes="batchDelXmProjectContract,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectContract(@RequestBody List<XmProjectContract> xmProjectContracts) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectContracts.size()+"条数据"); 
		try{ 
			xmProjectContractService.batchDelete(xmProjectContracts);
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
