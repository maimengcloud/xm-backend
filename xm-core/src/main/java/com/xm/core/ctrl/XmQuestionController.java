package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.common.entity.User;
import com.mdp.safe.common.utils.LoginUtils;
import com.qqkj.audit.log.client.annotation.AuditLog;
import com.qqkj.audit.log.client.annotation.OperType;
import com.xm.core.entity.XmQuestion;
import com.xm.core.service.XmQuestionService;
import com.xm.core.service.push.XmPushMsgService;
import com.xm.core.vo.XmQuestionVo;
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
 * url编制采用rest风格,如对XM.xm_question xm_question的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmQuestion/add <br>
 *  查询: xm/xmQuestion/list<br>
 *  模糊查询: xm/xmQuestion/listKey<br>
 *  修改: xm/xmQuestion/edit <br>
 *  删除: xm/xmQuestion/del<br>
 *  批量删除: xm/xmQuestion/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmQuestion 表 XM.xm_question 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmQuestionController")
@RequestMapping(value="/**/xm/core/xmQuestion")
@Api(tags={"xm_question操作接口"})
public class XmQuestionController {
	
	static Log logger=LogFactory.getLog(XmQuestionController.class);
	
	@Autowired
	private XmQuestionService xmQuestionService;
	 
	@Autowired
	private XmPushMsgService xmPushMsgService;
 
	
	@ApiOperation( value = "查询xm_question信息列表",notes="listXmQuestion,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="问题编号,主键",required=false),
		@ApiImplicitParam(name="name",value="问题标题",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="projectName",value="项目名称",required=false),
		@ApiImplicitParam(name="taskId",value="任务编号",required=false),
		@ApiImplicitParam(name="taskName",value="任务名称",required=false),
		@ApiImplicitParam(name="endTime",value="到期时间",required=false),
		@ApiImplicitParam(name="askUserid",value="提出人编号",required=false),
		@ApiImplicitParam(name="askUsername",value="提出人",required=false),
		@ApiImplicitParam(name="handlerUserid",value="处理人编号",required=false),
		@ApiImplicitParam(name="handlerUsername",value="处理人",required=false),
		@ApiImplicitParam(name="priority",value="优先级别",required=false),
		@ApiImplicitParam(name="solution",value="解决方案:",required=false),
		@ApiImplicitParam(name="description",value="问题描述",required=false),
		@ApiImplicitParam(name="createUserid",value="问题创建人编号",required=false),
		@ApiImplicitParam(name="createUsername",value="问题创建人",required=false),
		@ApiImplicitParam(name="createTime",value="创建时间",required=false),
		@ApiImplicitParam(name="bugStatus",value="create创建（active激活）–confirm确认（confirmed已确认）–solve解决（resolved已解决）–close关闭（closed已关闭）",required=false),
		@ApiImplicitParam(name="bizProcInstId",value="当前流程实例编号",required=false),
		@ApiImplicitParam(name="bizFlowState",value="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",required=false),
		@ApiImplicitParam(name="menuId",value="菜单编号",required=false),
		@ApiImplicitParam(name="menuName",value="菜单名称",required=false),
		@ApiImplicitParam(name="planWorkload",value="预估工时单位人时",required=false),
		@ApiImplicitParam(name="planCostAmount",value="预估成本金额",required=false),
		@ApiImplicitParam(name="totalActWorkload",value="实际工时",required=false),
		@ApiImplicitParam(name="totalActCostAmount",value="实际总金额",required=false),
		@ApiImplicitParam(name="expectResult",value="期望结果",required=false),
		@ApiImplicitParam(name="opStep",value="操作步骤",required=false),
		@ApiImplicitParam(name="currResult",value="当前结果",required=false),
		@ApiImplicitParam(name="refRequire",value="相关需求",required=false),
		@ApiImplicitParam(name="bugSeverity",value="严重程度1、2、3、4，分别对应：致命缺陷、严重缺陷、普通缺陷、轻微缺陷",required=false),
		@ApiImplicitParam(name="bugType",value="BUG类型1、2、3、4，分别对应：代码错误、低级缺陷、设计缺陷、配置相关、安全相关、性能问题、其他",required=false),
		@ApiImplicitParam(name="tagIds",value="标签id列表逗号分隔",required=false),
		@ApiImplicitParam(name="tagNames",value="标签名称列表逗号分隔",required=false),
		@ApiImplicitParam(name="urls",value="链接地址列表逗号分隔",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmQuestion.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmQuestion( @RequestParam Map<String,Object> xmQuestion){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmQuestion, "ids");
		PageUtils.startPage(xmQuestion);
		List<Map<String,Object>>	xmQuestionList = xmQuestionService.getQuestion(xmQuestion);	//列出XmQuestion列表
		PageUtils.responePage(m, xmQuestionList);
		m.put("data",xmQuestionList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	@ApiOperation( value = "新增一条xm_question信息",notes="addXmQuestion,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmQuestion.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmQuestion_add",name = "新增bug",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmQuestion(@RequestBody XmQuestionVo xmQuestionVo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			User user=LoginUtils.getCurrentUserInfo();
			xmQuestionService.addQuestion(xmQuestionVo);
			if(!StringUtils.isEmpty(xmQuestionVo.getHandlerUserid())) {
				xmPushMsgService.pushPrichatMsgToIm(user.getBranchId(), user.getUserid(), user.getUsername(), xmQuestionVo.getHandlerUserid(),xmQuestionVo.getHandlerUsername(), user.getUsername()+"创建bug【"+xmQuestionVo.getName()+"】并指派给"+xmQuestionVo.getHandlerUsername());
			}
			m.put("data",xmQuestionVo);
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
	@ApiOperation( value = "删除一条xm_question信息",notes="delXmQuestion,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmQuestion(@RequestBody XmQuestion xmQuestion){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmQuestionService.deleteByPk(xmQuestion);
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
	
	@ApiOperation( value = "根据主键修改一条xm_question信息",notes="editXmQuestion")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmQuestion.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmQuestion_edit",name = "修改bug",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmQuestion(@RequestBody XmQuestionVo xmQuestionVo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			User user=LoginUtils.getCurrentUserInfo();

			xmQuestionService.updateQuestion(xmQuestionVo);
			if(!StringUtils.isEmpty(xmQuestionVo.getHandlerUserid())) {
				xmPushMsgService.pushPrichatMsgToIm(user.getBranchId(), user.getUserid(), user.getUsername(), xmQuestionVo.getHandlerUserid(),xmQuestionVo.getHandlerUsername(), user.getUsername()+"修改bug【"+xmQuestionVo.getName()+"】");
			}
			m.put("data",xmQuestionVo);
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
	
	@ApiOperation( value = "根据主键修改一条xm_question信息",notes="editXmQuestion")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmQuestion.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmQuestion_editStatus",name = "修改bug状态",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/editStatus",method=RequestMethod.POST)
	public Map<String,Object> editStatus(@RequestBody XmQuestion xmQuestion) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmQuestionService.updateSomeFieldByPk(xmQuestion);
			User user=LoginUtils.getCurrentUserInfo(); 
 			if(!StringUtils.isEmpty(xmQuestion.getHandlerUserid())) {
				xmPushMsgService.pushPrichatMsgToIm(user.getBranchId(), user.getUserid(), user.getUsername(), xmQuestion.getHandlerUserid(),xmQuestion.getHandlerUsername(), user.getUsername()+"修改bug【"+xmQuestion.getName()+"】状态");
			}
			m.put("data",xmQuestion);
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
	@ApiOperation( value = "根据主键列表批量删除xm_question信息",notes="batchDelXmQuestion,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmQuestion(@RequestBody List<XmQuestion> xmQuestions) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmQuestions.size()+"条数据"); 
		try{ 
			xmQuestionService.batchDelete(xmQuestions);
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
	@AuditLog(firstMenu="办公平台",secondMenu="项目问题管理",func="processApprova",funcDesc="项目问题审核",operType=OperType.UPDATE)
	@RequestMapping(value="/processApprova",method=RequestMethod.POST)
	public Map<String,Object> processApprova( @RequestBody Map<String,Object> flowVars){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		  
		try{ 
			
			this.xmQuestionService.processApprova(flowVars);
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
