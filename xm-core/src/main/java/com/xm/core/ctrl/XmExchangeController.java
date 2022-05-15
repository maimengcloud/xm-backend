package com.xm.core.ctrl;


import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmExchange;
import com.xm.core.service.XmExchangeService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url编制采用rest风格,如对XM.xm_exchange 功能表的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmExchange/add <br>
 *  查询: xm/xmExchange/list<br>
 *  模糊查询: xm/xmExchange/listKey<br>
 *  修改: xm/xmExchange/edit <br>
 *  删除: xm/xmExchange/del<br>
 *  批量删除: xm/xmExchange/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmExchange 表 XM.xm_exchange 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmExchangeController")
@RequestMapping(value="/**/xm/core/xmExchange")
@Api(tags={"功能表操作接口"})
public class XmExchangeController {
	
	static Log logger=LogFactory.getLog(XmExchangeController.class);
	
	@Autowired
	private XmExchangeService xmExchangeService;



	@ApiOperation( value = "查询功能表信息列表",notes="listXmExchange,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiEntityParams(XmExchange.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmExchange.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmExchange( @ApiIgnore @RequestParam Map<String,Object> xmExchange){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmExchange, "ids");
		PageUtils.startPage(xmExchange);
		List<Map<String,Object>> xmExchangeList = xmExchangeService.selectListMapByWhere(xmExchange);	//列出XmExchange列表
		PageUtils.responePage(m, xmExchangeList);
		m.put("data",xmExchangeList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
 
	

	@ApiOperation( value = "新增一条功能表信息",notes="addXmExchange,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmExchange.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method= RequestMethod.POST)
	public Map<String,Object> addXmExchange(@RequestBody XmExchange xmExchange) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmExchange.getId())) {
				xmExchange.setId(xmExchangeService.createKey("id"));
			}else{
				 XmExchange xmExchangeQuery = new  XmExchange(xmExchange.getId());
				if(xmExchangeService.countByWhere(xmExchangeQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmExchangeService.insert(xmExchange);
			m.put("data",xmExchange);
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

	

	@ApiOperation( value = "删除一条功能表信息",notes="delXmExchange,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@HasQx(value = "xm_core_xmExchange_del",name = "删除评论",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmExchange(@RequestBody XmExchange xmExchange){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmExchangeService.deleteByPk(xmExchange);
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

	@ApiOperation( value = "根据主键修改一条功能表信息",notes="editXmExchange")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmExchange.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmExchange(@RequestBody XmExchange xmExchange) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmExchangeService.updateByPk(xmExchange);
			m.put("data",xmExchange);
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
	@ApiOperation( value = "根据主键列表批量删除功能表信息",notes="batchDelXmExchange,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmExchange(@RequestBody List<XmExchange> xmExchanges) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmExchanges.size()+"条数据"); 
		try{ 
			xmExchangeService.batchDelete(xmExchanges);
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
