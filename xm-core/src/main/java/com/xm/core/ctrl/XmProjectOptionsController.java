package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.core.entity.XmProjectOptions;
import com.xm.core.service.XmProjectOptionsService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url编制采用rest风格,如对XM.xm_project_options xm_project_options的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProjectOptions/add <br>
 *  查询: xm/xmProjectOptions/list<br>
 *  模糊查询: xm/xmProjectOptions/listKey<br>
 *  修改: xm/xmProjectOptions/edit <br>
 *  删除: xm/xmProjectOptions/del<br>
 *  批量删除: xm/xmProjectOptions/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectOptions 表 XM.xm_project_options 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectOptionsController")
@RequestMapping(value="/**/xm/core/xmProjectOptions")
@Api(tags={"xm_project_options操作接口"})
public class XmProjectOptionsController {
	
	static Log logger=LogFactory.getLog(XmProjectOptionsController.class);
	
	@Autowired
	private XmProjectOptionsService xmProjectOptionsService;
	 
		
 
	
	@ApiOperation( value = "查询xm_project_options信息列表",notes="listXmProjectOptions,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="branchId",value="机构编号",required=false),
		@ApiImplicitParam(name="optionType",value="选项类型，0项目类型，1紧急程度，2优先程度",required=false),
		@ApiImplicitParam(name="name",value="选项名字",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectOptions.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectOptions( @ApiIgnore @RequestParam Map<String,Object> xmProjectOptions){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectOptions, "ids");
		PageUtils.startPage(xmProjectOptions);
		List<Map<String,Object>>	xmProjectOptionsList = xmProjectOptionsService.selectListMapByWhere(xmProjectOptions);	//列出XmProjectOptions列表
		PageUtils.responePage(m, xmProjectOptionsList);
		m.put("data",xmProjectOptionsList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	/**
	@ApiOperation( value = "新增一条xm_project_options信息",notes="addXmProjectOptions,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectOptions.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectOptions(@RequestBody XmProjectOptions xmProjectOptions) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectOptions.getId())) {
				xmProjectOptions.setId(xmProjectOptionsService.createKey("id"));
			}else{
				 XmProjectOptions xmProjectOptionsQuery = new  XmProjectOptions(xmProjectOptions.getId());
				if(xmProjectOptionsService.countByWhere(xmProjectOptionsQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmProjectOptionsService.insert(xmProjectOptions);
			m.put("data",xmProjectOptions);
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
	@ApiOperation( value = "删除一条xm_project_options信息",notes="delXmProjectOptions,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectOptions(@RequestBody XmProjectOptions xmProjectOptions){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectOptionsService.deleteByPk(xmProjectOptions);
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
	@ApiOperation( value = "根据主键修改一条xm_project_options信息",notes="editXmProjectOptions")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectOptions.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectOptions(@RequestBody XmProjectOptions xmProjectOptions) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectOptionsService.updateByPk(xmProjectOptions);
			m.put("data",xmProjectOptions);
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
	@ApiOperation( value = "根据主键列表批量删除xm_project_options信息",notes="batchDelXmProjectOptions,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectOptions(@RequestBody List<XmProjectOptions> xmProjectOptionss) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectOptionss.size()+"条数据"); 
		try{ 
			xmProjectOptionsService.batchDelete(xmProjectOptionss);
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
