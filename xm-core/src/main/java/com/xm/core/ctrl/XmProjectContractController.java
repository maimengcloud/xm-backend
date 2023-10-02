package com.xm.core.ctrl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mdp.core.entity.Result;
import com.mdp.core.query.QueryTools;
import com.mdp.core.utils.RequestUtils;
import com.xm.core.entity.XmProjectContract;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;
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
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectContract.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Result listXmProjectContract(@ApiIgnore @RequestParam Map<String,Object> params){
		
		RequestUtils.transformArray(params, "htIds");		
		IPage page=QueryTools.initPage(params);
		QueryWrapper<XmProjectContract> qw=QueryTools.initQueryWrapper(XmProjectContract.class,params);
		List<Map<String,Object>> datas= xmProjectContractService.selectListMapByWhere(page,qw,params);
		return Result.ok().setData(datas).setTotal(page.getTotal());
		
	}
	
 
	
	/**
	@ApiOperation( value = "新增一条xm_project_contract信息",notes="addXmProjectContract,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectContract.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result addXmProjectContract(@RequestBody XmProjectContract xmProjectContract) {

			if(StringUtils.isEmpty(xmProjectContract.getHtId())) {
				xmProjectContract.setHtId(xmProjectContractService.createKey("htId"));
			}else{
				 XmProjectContract xmProjectContractQuery = new  XmProjectContract(xmProjectContract.getHtId());
				if(xmProjectContractService.countByWhere(xmProjectContractQuery)>0){
					return Result.error("编号重复，请修改编号再提交");
					
				}
			}
			xmProjectContractService.insert(xmProjectContract);
		
	}
	*/
	
	/**
	@ApiOperation( value = "删除一条xm_project_contract信息",notes="delXmProjectContract,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Result delXmProjectContract(@RequestBody XmProjectContract xmProjectContract){

			xmProjectContractService.deleteByPk(xmProjectContract);
		return Result.ok();
		
	}
	 */
	
	/**
	@ApiOperation( value = "根据主键修改一条xm_project_contract信息",notes="editXmProjectContract")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectContract.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Result editXmProjectContract(@RequestBody XmProjectContract xmProjectContract) {

			xmProjectContractService.updateByPk(xmProjectContract);
		
	}
	*/
	

	
	/**
	@ApiOperation( value = "根据主键列表批量删除xm_project_contract信息",notes="batchDelXmProjectContract,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Result batchDelXmProjectContract(@RequestBody List<XmProjectContract> xmProjectContracts) {
		
		
		
			xmProjectContractService.batchDelete(xmProjectContracts);
		return Result.ok();
		
	} 
	*/
}
