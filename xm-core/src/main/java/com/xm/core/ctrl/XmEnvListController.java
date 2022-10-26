package com.xm.core.ctrl;

import com.mdp.audit.log.client.annotation.AuditLog;
import com.mdp.audit.log.client.annotation.OperType;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.mybatis.PageUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmEnvList;
import com.xm.core.service.XmEnvListService;
import com.xm.core.service.XmGroupService;
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



	@Autowired
	XmGroupService xmGroupService;
 
	
	@ApiOperation( value = "查询xm_env_list信息列表",notes="listXmEnvList,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiEntityParams(XmEnvList.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmEnvList.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmEnvList( @ApiIgnore @RequestParam Map<String,Object> xmEnvList){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmEnvList, "ids");
		PageUtils.startPage(xmEnvList);
		User user=LoginUtils.getCurrentUserInfo();
		xmEnvList.put("userid",user.getUserid());
		xmEnvList.put("branchId",user.getBranchId());
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
	//@HasQx(value = "xm_core_xmEnvList_add",name = "新建环境清单",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmEnvList(@RequestBody XmEnvList xmEnvList) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(!StringUtils.hasText(xmEnvList.getProjectId())){
				return ResponseHelper.failed("projectId-0","项目编号不能为空");
			}
			if(!StringUtils.hasText(xmEnvList.getName())){
				return ResponseHelper.failed("name-0","名称不能为空");
			}
			User user= LoginUtils.getCurrentUserInfo();
			if(StringUtils.hasText(xmEnvList.getProjectId())){
				boolean inProjectGroup=xmGroupService.checkUserExistsGroup(xmEnvList.getProjectId(),user.getUserid());
				if(!inProjectGroup){
					return ResponseHelper.failed("no-in-project","您不在项目中【"+xmEnvList.getProjectId()+"】，不能添加环境清单");
				}
			}

			if(!StringUtils.hasText(xmEnvList.getReadQx())){
				return ResponseHelper.failed("readQx-0","请选中读权限");
			}
			if(!StringUtils.hasText(xmEnvList.getWriteQx())){
				return ResponseHelper.failed("writeQx-0","请选中写权限");
			}
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
	//@HasQx(value = "xm_core_xmEnvList_del",name = "删除环境清单",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmEnvList(@RequestBody XmEnvList xmEnvList){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			XmEnvList xmEnvListDb=this.xmEnvListService.selectOneById(xmEnvList.getId());
			if(xmEnvListDb==null){
				return ResponseHelper.failed("data-0","数据已不存在");
			}
			User user=LoginUtils.getCurrentUserInfo();
			if(StringUtils.hasText(xmEnvListDb.getWriteQx()) && !"0".equals(xmEnvListDb.getWriteQx()) && user.getUserid().equals(xmEnvListDb.getCreateUserid())){
				String writeQx=xmEnvListDb.getWriteQx();
				if("1".equals(writeQx)){//同一机构可写
					if(!user.getBranchId().equals(xmEnvListDb.getBranchId())){
						return ResponseHelper.failed("writeQx-err-1","您无权更改");
					}
				}else if("2".equals(writeQx)){//同一机构同一项目可写
					boolean inProject=this.xmGroupService.checkUserExistsGroup(xmEnvListDb.getProjectId(), user.getUserid());
					if(!inProject){
						return ResponseHelper.failed("writeQx-err-2","您不在项目【"+xmEnvListDb.getProjectId()+"】,无权更改");
					}
				}else if("3".equals(writeQx)){//同一机构同一项目可写
					Tips isHeader=this.xmGroupService.checkIsAdmOrTeamHeadOrAss(user,xmEnvListDb.getCreateUserid(),xmEnvListDb.getProjectId());
 					if(!isHeader.isOk()){
						return ResponseHelper.failed("writeQx-err-3","您不是【"+xmEnvListDb.getCreateUsername()+"】的上级,无权更改");
					}
				}
			}
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
	//@HasQx(value = "xm_core_xmEnvList_edit",name = "修改环境清单",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmEnvList(@RequestBody XmEnvList xmEnvList) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			XmEnvList xmEnvListDb=this.xmEnvListService.selectOneById(xmEnvList.getId());
			if(xmEnvListDb==null){
				return ResponseHelper.failed("data-0","数据已不存在");
			}
			User user=LoginUtils.getCurrentUserInfo();
			if(StringUtils.hasText(xmEnvListDb.getWriteQx()) && !"0".equals(xmEnvListDb.getWriteQx()) && user.getUserid().equals(xmEnvListDb.getCreateUserid())){
				String writeQx=xmEnvListDb.getWriteQx();
				if("1".equals(writeQx)){//同一机构可写
					if(!user.getBranchId().equals(xmEnvListDb.getBranchId())){
						return ResponseHelper.failed("writeQx-err-1","您无权更改");
					}
				}else if("2".equals(writeQx)){//同一机构同一项目可写
					boolean inProject=this.xmGroupService.checkUserExistsGroup(xmEnvListDb.getProjectId(), user.getUserid());
					if(!inProject){
						return ResponseHelper.failed("writeQx-err-2","您不在项目【"+xmEnvListDb.getProjectId()+"】,无权更改");
					}
				}else if("3".equals(writeQx)){//同一机构同一项目可写
					Tips isHeader=this.xmGroupService.checkIsAdmOrTeamHeadOrAss(user,xmEnvListDb.getCreateUserid(),xmEnvListDb.getProjectId());
					if(!isHeader.isOk()){
						return ResponseHelper.failed("writeQx-err-3","您不是【"+xmEnvListDb.getCreateUsername()+"】的上级,无权更改");
					}
				}
			}
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


	/**
	@ApiOperation( value = "根据主键列表批量删除xm_env_list信息",notes="batchDelXmEnvList,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmEnvList_batchDel",name = "批量删除环境清单",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
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
	**/


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
