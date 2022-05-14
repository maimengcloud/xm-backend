package com.xm.core.ctrl;


import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.xm.core.entity.XmExchange;
import com.xm.core.service.XmExchangeService;
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
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="评论编号,主键",required=false),
		@ApiImplicitParam(name="taskId",value="功能编号",required=false),
		@ApiImplicitParam(name="taskName",value="功能名称",required=false),
		@ApiImplicitParam(name="projectId",value="归属产品编号",required=false),
		@ApiImplicitParam(name="remark",value="备注",required=false),
		@ApiImplicitParam(name="pid",value="上级评论编号",required=false),
		@ApiImplicitParam(name="cuserid",value="评论人编号",required=false),
		@ApiImplicitParam(name="cusername",value="评论人名称",required=false),
		@ApiImplicitParam(name="ctime",value="评论时间",required=false),
		@ApiImplicitParam(name="cbranchId",value="评论人所属机构",required=false),
		@ApiImplicitParam(name="adopt",value="是否采纳0否1采纳",required=false),
		@ApiImplicitParam(name="adoptUserid",value="采纳人编号",required=false),
		@ApiImplicitParam(name="adoptUsername",value="采纳人名称",required=false),
		@ApiImplicitParam(name="adoptTime",value="采纳时间",required=false),
		@ApiImplicitParam(name="closed",value="关闭该评论0否1是",required=false),
		@ApiImplicitParam(name="puserid",value="上级用户编号",required=false),
		@ApiImplicitParam(name="pusername",value="上级姓名",required=false),
		@ApiImplicitParam(name="premark",value="上级备注",required=false),
		@ApiImplicitParam(name="notifyUserids",value="本评论需要同步给的人列表,逗号分隔",required=false),
		@ApiImplicitParam(name="notifyChannels",value="发送通知渠道inner-email/wxpub/sms/im/out-email等逗号分割",required=false),
		@ApiImplicitParam(name="notifyUsernames",value="通知用户姓名逗号分隔",required=false),
		@ApiImplicitParam(name="cuserHeadImg",value="发言人头像地址",required=false),
		@ApiImplicitParam(name="replyType",value="回复方式1引用2回复",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmExchange.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmExchange( @RequestParam Map<String,Object> xmExchange){
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
