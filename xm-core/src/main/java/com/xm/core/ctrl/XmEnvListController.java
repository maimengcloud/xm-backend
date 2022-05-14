package com.xm.core.ctrl;

import com.mdp.audit.log.client.annotation.AuditLog;
import com.mdp.audit.log.client.annotation.OperType;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.xm.core.entity.XmEnvList;
import com.xm.core.service.XmEnvListService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url编制采用rest风格,如对XM.xm_env_list xm_env_list的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmEnvList/add <br>
 *  查询: xm/xmEnvList/list<br>
 *  模糊查询: xm/xmEnvList/listKey<br>
 *  修改: xm/xmEnvList/edit <br>
 *  删除: xm/xmEnvList/del<br>
 *  批量删除: xm/xmEnvList/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmEnvList 表 XM.xm_env_list 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmEnvListController")
@RequestMapping(value="/**/xm/core/xmEnvList")
@Api(tags={"xm_env_list操作接口"})
public class XmEnvListController {
	
	static Log logger=LogFactory.getLog(XmEnvListController.class);
	
	@Autowired
	private XmEnvListService xmEnvListService;
	 
		
 
	
	@ApiOperation( value = "查询xm_env_list信息列表",notes="listXmEnvList,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="remark",value="备注说明",required=false),
		@ApiImplicitParam(name="ipAddress",value="内网ip地址",required=false),
		@ApiImplicitParam(name="port",value="内网访问端口",required=false),
		@ApiImplicitParam(name="branchId",value="归属机构",required=false),
		@ApiImplicitParam(name="accessUserid",value="访问用户编号",required=false),
		@ApiImplicitParam(name="accessPassword",value="访问密码",required=false),
		@ApiImplicitParam(name="effect",value="作用说明",required=false),
		@ApiImplicitParam(name="accessUrl",value="访问链接",required=false),
		@ApiImplicitParam(name="supplier",value="供应商",required=false),
		@ApiImplicitParam(name="webIpAddress",value="外网ip地址",required=false),
		@ApiImplicitParam(name="webPort",value="外网端口",required=false),
		@ApiImplicitParam(name="otherRemark",value="其它说明",required=false),
		@ApiImplicitParam(name="createUserid",value="添加人员",required=false),
		@ApiImplicitParam(name="createUsername",value="添加人员姓名",required=false),
		@ApiImplicitParam(name="createTime",value="添加时间",required=false),
		@ApiImplicitParam(name="envState",value="状态0不可用1已启用2已过期",required=false),
		@ApiImplicitParam(name="startTime",value="有效日期开始",required=false),
		@ApiImplicitParam(name="endTime",value="有效日期结束",required=false),
		@ApiImplicitParam(name="feeAmount",value="费用",required=false),
		@ApiImplicitParam(name="feeRule",value="计费规则",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmEnvList.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmEnvList( @RequestParam Map<String,Object> xmEnvList){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmEnvList, "ids");
		PageUtils.startPage(xmEnvList);
		List<Map<String,Object>>	xmEnvListList = xmEnvListService.selectListMapByWhere(xmEnvList);	//列出XmEnvList列表
		PageUtils.responePage(m, xmEnvListList);
		m.put("data",xmEnvListList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	@ApiOperation( value = "新增一条xm_env_list信息",notes="addXmEnvList,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmEnvList.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmEnvList_add",name = "新建环境清单",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmEnvList(@RequestBody XmEnvList xmEnvList) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			xmEnvListService.addEnv(xmEnvList);
			m.put("data",xmEnvList);
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

	@ApiOperation( value = "删除一条xm_env_list信息",notes="delXmEnvList,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@HasQx(value = "xm_core_xmEnvList_del",name = "删除环境清单",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmEnvList(@RequestBody XmEnvList xmEnvList){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmEnvListService.deleteByPk(xmEnvList);
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

	@ApiOperation( value = "根据主键修改一条xm_env_list信息",notes="editXmEnvList")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmEnvList.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmEnvList_edit",name = "修改环境清单",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmEnvList(@RequestBody XmEnvList xmEnvList) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmEnvListService.updateByPk(xmEnvList);
			m.put("data",xmEnvList);
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


	
	@ApiOperation( value = "根据主键列表批量删除xm_env_list信息",notes="batchDelXmEnvList,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmEnvList_batchDel",name = "批量删除环境清单",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmEnvList(@RequestBody List<XmEnvList> xmEnvLists) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmEnvLists.size()+"条数据"); 
		try{ 
			xmEnvListService.batchDelete(xmEnvLists);
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
	 * 流程审批过程中回调该接口，更新业务数据
	 * 如果发起流程时上送了restUrl，则无论流程中是否配置了监听器都会在流程发生以下事件时推送数据过来
	 * eventName: PROCESS_STARTED 流程启动完成 全局
	 *            PROCESS_COMPLETED 流程正常结束 全局
	 *            PROCESS_CANCELLED 流程删除 全局
	 *            create 人工任务启动
	 *            complete 人工任务完成  
	 *            assignment 人工任务分配给了具体的人
	 *            delete 人工任务被删除
	 *            
	 * 其中 create/complete/assignment/delete事件是需要在模型中人工节点上配置了委托代理表达式 ${taskBizCallListener}才会推送过来。
	 * 在人工任务节点上配置 任务监听器  建议事件为 complete,其它assignment/create/complete/delete也可以，一般建议在complete,委托代理表达式 ${taskBizCallListener}
	 * 
	 * @param flowVars {flowBranchId,agree,procInstId,assignee,actId,taskName,mainTitle,branchId,bizKey,commentMsg,eventName,modelKey} 等 
	 * @return 如果tips.isOk==false，将影响流程提交
	 **/
	@AuditLog(firstMenu="办公平台",secondMenu="项目惯例",func="processApprova",funcDesc="项目环境清单审批",operType=OperType.UPDATE)
	@RequestMapping(value="/processApprova",method=RequestMethod.POST)
	public Map<String,Object> processApprova( @RequestBody Map<String,Object> flowVars){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		  
		try{ 
			
			this.xmEnvListService.processApprova(flowVars);
			logger.debug("procInstId====="+flowVars.get("procInstId"));
		}catch (BizException e) { 
			tips=e.getTips();
			logger.error("执行异常",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("执行异常",e);
		}  
		m.put("tips", tips);
		return m;
	}
}
