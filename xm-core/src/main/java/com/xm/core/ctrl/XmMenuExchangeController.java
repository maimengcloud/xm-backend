package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmMenuExchange;
import com.xm.core.service.XmMenuExchangeService;
import com.xm.core.service.push.XmMenuPushMsgService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * url编制采用rest风格,如对XM.xm_menu_exchange 功能表的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmMenuExchange/add <br>
 *  查询: xm/xmMenuExchange/list<br>
 *  模糊查询: xm/xmMenuExchange/listKey<br>
 *  修改: xm/xmMenuExchange/edit <br>
 *  删除: xm/xmMenuExchange/del<br>
 *  批量删除: xm/xmMenuExchange/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmMenuExchange 表 XM.xm_menu_exchange 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmMenuExchangeController")
@RequestMapping(value="/**/xm/core/xmMenuExchange")
@Api(tags={"功能表操作接口"})
public class XmMenuExchangeController {
	
	static Log logger=LogFactory.getLog(XmMenuExchangeController.class);
	
	@Autowired
	private XmMenuExchangeService xmMenuExchangeService;
	 
	@Autowired
    XmMenuPushMsgService pushMsgService ;
 
	
	@ApiOperation( value = "查询功能表信息列表",notes="listXmMenuExchange,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="评论编号,主键",required=false),
		@ApiImplicitParam(name="menuId",value="功能编号",required=false),
		@ApiImplicitParam(name="menuName",value="功能名称",required=false),
		@ApiImplicitParam(name="productId",value="归属产品编号",required=false),
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
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmMenuExchange.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmMenuExchange( @RequestParam Map<String,Object> xmMenuExchange){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmMenuExchange, "ids");
		PageUtils.startPage(xmMenuExchange);
		if(  !StringUtils.hasText((String) xmMenuExchange.get("branchId"))){
			xmMenuExchange.put("branchId",LoginUtils.getCurrentUserInfo().getBranchId());
		}
		List<Map<String,Object>>	xmMenuExchangeList = xmMenuExchangeService.selectListMapByWhere(xmMenuExchange);	//列出XmMenuExchange列表
		PageUtils.responePage(m, xmMenuExchangeList);
		m.put("data",xmMenuExchangeList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	/***/
	@ApiOperation( value = "新增一条功能表信息",notes="addXmMenuExchange,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMenuExchange.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmMenuExchange_add",name = "发布故事评论",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmMenuExchange(@RequestBody XmMenuExchange xmMenuExchange) {
		Map<String,Object> m = new HashMap<>();
 		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmMenuExchange.getId())) {
				xmMenuExchange.setId(this.xmMenuExchangeService.createKey("id"));
			} 
			xmMenuExchange.setCtime(new Date());
			xmMenuExchangeService.insert(xmMenuExchange);
			String imMsg=xmMenuExchange.getCusername()+"发表关于故事【"+xmMenuExchange.getMenuId()+"-"+xmMenuExchange.getMenuName()+"】的评论："+xmMenuExchange.getRemark();
			pushMsgService.pushMenuRelUsersMsg(xmMenuExchange.getCbranchId(), xmMenuExchange.getMenuId(), xmMenuExchange.getCuserid(), xmMenuExchange.getCusername(), imMsg);
			m.put("data",xmMenuExchange);
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
	@ApiOperation( value = "删除一条功能表信息",notes="delXmMenuExchange,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@HasQx(value = "xm_core_xmMenuExchange_del",name = "删除故事评论",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmMenuExchange(@RequestBody XmMenuExchange xmMenuExchange){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmMenuExchangeService.deleteByPk(xmMenuExchange);
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
	@ApiOperation( value = "根据主键修改一条功能表信息",notes="editXmMenuExchange")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMenuExchange.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmMenuExchange_edit",name = "修改故事评论",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmMenuExchange(@RequestBody XmMenuExchange xmMenuExchange) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmMenuExchangeService.updateByPk(xmMenuExchange);
			m.put("data",xmMenuExchange);
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
	@ApiOperation( value = "根据主键列表批量删除功能表信息",notes="batchDelXmMenuExchange,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmMenuExchange_batchDel",name = "批量删除故事评论",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmMenuExchange(@RequestBody List<XmMenuExchange> xmMenuExchanges) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmMenuExchanges.size()+"条数据"); 
		try{ 
			xmMenuExchangeService.batchDelete(xmMenuExchanges);
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
