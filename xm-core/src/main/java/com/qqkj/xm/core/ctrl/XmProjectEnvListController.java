package com.qqkj.xm.core.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qqkj.audit.base.annotation.AuditLog;
import com.qqkj.audit.base.annotation.OperType;
import com.qqkj.mdp.core.context.ContextHolder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.qqkj.mdp.mybatis.PageUtils; 
import com.qqkj.mdp.core.utils.RequestUtils;
import com.qqkj.mdp.core.entity.Tips;
import com.qqkj.mdp.core.err.BizException;
import com.qqkj.mdp.core.service.SequenceService;
import com.qqkj.xm.core.service.XmProjectEnvListService;
import com.qqkj.xm.core.entity.XmProjectEnvList;
/**
 * url编制采用rest风格,如对XM.xm_project_env_list xm_project_env_list的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProjectEnvList/add <br>
 *  查询: xm/xmProjectEnvList/list<br>
 *  模糊查询: xm/xmProjectEnvList/listKey<br>
 *  修改: xm/xmProjectEnvList/edit <br>
 *  删除: xm/xmProjectEnvList/del<br>
 *  批量删除: xm/xmProjectEnvList/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectEnvList 表 XM.xm_project_env_list 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectEnvListController")
@RequestMapping(value="/**/xm/core/xmProjectEnvList")
@Api(tags={"xm_project_env_list操作接口"})
public class XmProjectEnvListController {
	
	static Log logger=LogFactory.getLog(XmProjectEnvListController.class);
	
	@Autowired
	private XmProjectEnvListService xmProjectEnvListService;
	 
		
 
	
	@ApiOperation( value = "查询xm_project_env_list信息列表",notes="listXmProjectEnvList,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="remark",value="备注说明",required=false),
		@ApiImplicitParam(name="ipAddress",value="ip地址",required=false),
		@ApiImplicitParam(name="port",value="访问端口",required=false),
		@ApiImplicitParam(name="projectId",value="归属项目组",required=false),
		@ApiImplicitParam(name="projectName",value="归属项目组名称",required=false),
		@ApiImplicitParam(name="accessUserid",value="访问用户编号",required=false),
		@ApiImplicitParam(name="accessPassword",value="访问密码",required=false),
		@ApiImplicitParam(name="effect",value="作用说明",required=false),
		@ApiImplicitParam(name="accessUrl",value="访问链接",required=false),
		@ApiImplicitParam(name="webIpAddress",value="外网ip地址",required=false),
		@ApiImplicitParam(name="webPort",value="外网端口",required=false),
		@ApiImplicitParam(name="otherRemark",value="其它说明",required=false),
		@ApiImplicitParam(name="createUserid",value="添加人员",required=false),
		@ApiImplicitParam(name="createUsername",value="添加人员姓名",required=false),
		@ApiImplicitParam(name="createTime",value="添加时间",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectEnvList.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectEnvList( @RequestParam Map<String,Object> xmProjectEnvList){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectEnvList, "ids");
		PageUtils.startPage(xmProjectEnvList);
		List<Map<String,Object>>	xmProjectEnvListList = xmProjectEnvListService.selectListMapByWhere(xmProjectEnvList);	//列出XmProjectEnvList列表
		PageUtils.responePage(m, xmProjectEnvListList);
		m.put("data",xmProjectEnvListList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	@ApiOperation( value = "新增一条xm_project_env_list信息",notes="addXmProjectEnvList,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectEnvList.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectEnvList(@RequestBody XmProjectEnvList xmProjectEnvList) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			xmProjectEnvListService.addEnvList(xmProjectEnvList);
//			if(StringUtils.isEmpty(xmProjectEnvList.getId())) {
//				xmProjectEnvList.setId(xmProjectEnvListService.createKey("id"));
//			}else{
//				 XmProjectEnvList xmProjectEnvListQuery = new  XmProjectEnvList(xmProjectEnvList.getId());
//				if(xmProjectEnvListService.countByWhere(xmProjectEnvListQuery)>0){
//					tips.setFailureMsg("编号重复，请修改编号再提交");
//					m.put("tips", tips);
//					return m;
//				}
//			}
//			xmProjectEnvListService.insert(xmProjectEnvList);
			m.put("data",xmProjectEnvList);
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
	
	@ApiOperation( value = "删除一条xm_project_env_list信息",notes="delXmProjectEnvList,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectEnvList(@RequestBody XmProjectEnvList xmProjectEnvList){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectEnvListService.deleteByPk(xmProjectEnvList);
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
	
	@ApiOperation( value = "根据主键修改一条xm_project_env_list信息",notes="editXmProjectEnvList")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectEnvList.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectEnvList(@RequestBody XmProjectEnvList xmProjectEnvList) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectEnvListService.updateByPk(xmProjectEnvList);
			m.put("data",xmProjectEnvList);
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
	

	
	@ApiOperation( value = "根据主键列表批量删除xm_project_env_list信息",notes="batchDelXmProjectEnvList,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectEnvList(@RequestBody List<XmProjectEnvList> xmProjectEnvLists) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectEnvLists.size()+"条数据"); 
		try{ 
			xmProjectEnvListService.batchDelete(xmProjectEnvLists);
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
	@AuditLog(firstMenu="办公平台",secondMenu="项目环境清单",func="processApprova",funcDesc="环境配置审核",operType=OperType.UPDATE)
	@RequestMapping(value="/processApprova",method=RequestMethod.POST)
	public Map<String,Object> processApprova( @RequestBody Map<String,Object> flowVars){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		  
		try{ 
			
			this.xmProjectEnvListService.processApprova(flowVars);
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
