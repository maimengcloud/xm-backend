package com.xm.core.ctrl;

import com.mdp.audit.log.client.annotation.AuditLog;
import com.mdp.audit.log.client.annotation.OperType;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.BaseUtils;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.msg.client.PushNotifyMsgService;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmMenu;
import com.xm.core.entity.XmQuestion;
import com.xm.core.entity.XmQuestionHandle;
import com.xm.core.service.XmQuestionHandleService;
import com.xm.core.service.XmQuestionService;
import com.xm.core.service.XmRecordService;
import com.xm.core.service.push.XmPushMsgService;
import com.xm.core.vo.XmQuestionVo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;
import java.util.stream.Collectors;

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

	@Autowired
	private XmRecordService xmRecordService;

	@Autowired
	XmQuestionHandleService xmQuestionHandleService;


	@Autowired
	PushNotifyMsgService notifyMsgService;

	Map<String,Object> fieldsMap = BaseUtils.toMap(new XmQuestion());
	
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
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmQuestion.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmQuestion( @ApiIgnore @RequestParam Map<String,Object> xmQuestion){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmQuestion, "ids");
		RequestUtils.transformArray(xmQuestion, "menuIds");
		RequestUtils.transformArray(xmQuestion, "tagIdList");
		PageUtils.startPage(xmQuestion);
		User user = LoginUtils.getCurrentUserInfo();
		if(LoginUtils.isBranchAdmin()){
			xmQuestion.put("branchId",user.getBranchId());
		}else {
			xmQuestion.put("compete",user.getUserid());
		}


		List<Map<String,Object>>	xmQuestionList = xmQuestionService.getQuestion(xmQuestion);	//列出XmQuestion列表
		PageUtils.responePage(m, xmQuestionList);
		m.put("data",xmQuestionList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}


	@RequestMapping(value="/getXmQuestionAttDist",method=RequestMethod.GET)
	public Map<String,Object> getXmQuestionAttDist( @ApiIgnore @RequestParam Map<String,Object> xmQuestion){
		User user=LoginUtils.getCurrentUserInfo();
		xmQuestion.put("branchId",user.getBranchId());
		List<Map<String,Object>> datas= this.xmQuestionService.getXmQuestionAttDist(xmQuestion);
		return ResponseHelper.ok("ok","成功",datas);
	}

	@RequestMapping(value="/getXmQuestionAgeDist",method=RequestMethod.GET)
	public Map<String,Object> getXmQuestionAgeDist( @ApiIgnore @RequestParam Map<String,Object> xmQuestion){
		User user=LoginUtils.getCurrentUserInfo();
		xmQuestion.put("branchId",user.getBranchId());
		List<Map<String,Object>> datas= this.xmQuestionService.getXmQuestionAgeDist(xmQuestion);
		return ResponseHelper.ok("ok","成功",datas);
	}

	@RequestMapping(value="/getXmQuestionSort",method=RequestMethod.GET)
	public Map<String,Object> getXmQuestionSort( @ApiIgnore @RequestParam Map<String,Object> xmQuestion){
		User user=LoginUtils.getCurrentUserInfo();
		PageUtils.startPage(xmQuestion);
		xmQuestion.put("branchId",user.getBranchId());
		List<Map<String,Object>> datas= this.xmQuestionService.getXmQuestionSort(xmQuestion);
		Map<String,Object> m=new HashMap<>();
		PageUtils.responePage(m,datas);
		m.put("data",datas);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}

	@ApiOperation( value = "新增一条xm_question信息",notes="addXmQuestion,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmQuestion.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmQuestion_add",name = "新增bug",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmQuestion(@RequestBody XmQuestionVo xmQuestionVo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(!StringUtils.hasText(xmQuestionVo.getProjectId())){
				tips.setFailureMsg("项目编号projectId必传");
				m.put("tips", tips);
				return m;
			}
			User user=LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmQuestionVo.getQtype())){
				xmQuestionVo.setQtype("1");
			}
			xmQuestionService.addQuestion(xmQuestionVo);
			if(!StringUtils.isEmpty(xmQuestionVo.getHandlerUserid())) {
				notifyMsgService.pushMsg(user,xmQuestionVo.getHandlerUserid(),xmQuestionVo.getHandlerUsername(),"5",xmQuestionVo.getProductId(),xmQuestionVo.getId(),"您有新的bug【"+xmQuestionVo.getName()+"】需要处理，请尽快修复！");
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
	@HasQx(value = "xm_core_xmQuestion_edit",name = "修改bug",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
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
	@HasQx(value = "xm_core_xmQuestion_editStatus",name = "修改bug状态",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
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


	/***/
	@ApiOperation( value = "根据主键修改一条项目菜单表信息",notes="editSomeFields")
	@ApiResponses({
			@ApiResponse(code = 200,response= XmMenu.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmQuestion_editSomeFields",name = "修改bug的某些字段",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields(@RequestBody Map<String,Object> xmQuestionMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			User user=LoginUtils.getCurrentUserInfo();
			List<String> ids= (List<String>) xmQuestionMap.get("ids");

			if(ids==null || ids.size()==0){
				ResponseHelper.failed("ids-0","ids不能为空");
			}
 			List<XmQuestion> xmQuestionsDb=xmQuestionService.selectListByIds(ids);
			if(xmQuestionsDb==null ||xmQuestionsDb.size()==0){
				ResponseHelper.failed("bugs-0","该bug已不存在");
			}
			Set<String> fieldKey=xmQuestionMap.keySet().stream().filter(i->fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmQuestionMap.get(i) )).collect(Collectors.toSet());
			if(fieldKey.size()>0){
				Set<String> fields=new HashSet<>();
				for (String fieldName : xmQuestionMap.keySet()) {
					if(fields.contains(fieldName)){
						return ResponseHelper.failed(fieldName+"-no-edit",fieldName+"不允许修改");
					}
				}
				xmQuestionService.editSomeFields(xmQuestionMap);
				String remarks= (String) xmQuestionMap.get("remarks");
				String handlerUsername= (String) xmQuestionMap.get("handlerUsername");
				String bugStatus= (String) xmQuestionMap.get("bugStatus");

				List<XmQuestionHandle> handles=new ArrayList<>();
				Map<String,Object> map=new HashMap<>();
				map.putAll(xmQuestionMap);
				map.remove("ids");
				for (XmQuestion xmQuestionVo : xmQuestionsDb) {
					Map<String,Object> m2=BaseUtils.toMap(xmQuestionVo);
					m2.putAll(map);
					xmQuestionVo=BaseUtils.fromMap(m2,XmQuestion.class);
					XmQuestionHandle handle=new XmQuestionHandle();
					if(StringUtils.hasText(remarks)){
						handle.setReceiptMessage(user.getUsername()+"修改缺陷处理意见为："+xmQuestionVo.getRemarks());
					}else if(StringUtils.hasText(handlerUsername)){
						handle.setReceiptMessage(user.getUsername()+"将缺陷指派给"+handlerUsername);
						notifyMsgService.pushMsg(user,xmQuestionVo.getHandlerUserid(),xmQuestionVo.getHandlerUsername(),"5",xmQuestionVo.getProductId(),xmQuestionVo.getId(),"您有新的bug【"+xmQuestionVo.getName()+"】需要处理，请尽快修复！");

					}else if(StringUtils.hasText(bugStatus)){
						handle.setReceiptMessage(user.getUsername()+"将缺陷状态改为"+bugStatus);
					}else{
						handle.setReceiptMessage(user.getUsername()+"修改了缺陷信息"+map.toString());
					}

					handle.setHandleStatus(xmQuestionVo.getBugStatus());
					handle.setCreateTime(new Date());
					handle.setReceiptTime(new Date());
					handle.setHandlerUserid(xmQuestionVo.getCreateUserid());
					handle.setHandlerUsername(xmQuestionVo.getCreateUsername());
					handle.setLastUpdateTime(new Date());
					handle.setHandleSolution(xmQuestionVo.getSolution());
					handle.setQuestionId(xmQuestionVo.getId());
					handle.setTargetUserid(xmQuestionVo.getHandlerUserid());
					handle.setTargetUsername(xmQuestionVo.getHandlerUsername());
					handle.setId(this.xmQuestionHandleService.createKey("id"));
					handles.add(handle);
				}

				xmQuestionHandleService.batchAddAsync(handles);

			}


			//m.put("data",xmMenu);
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

	@ApiOperation( value = "根据主键列表批量删除xm_question信息",notes="batchDelXmQuestion,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmQuestion(@RequestBody List<XmQuestion> xmQuestions) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmQuestions.size()+"条数据"); 
		try{
			User user=LoginUtils.getCurrentUserInfo();
			List<XmQuestion> xmQuestionsDb=xmQuestionService.selectListByIds(xmQuestions.stream().map(i->i.getId()).collect(Collectors.toList()));
			List<XmQuestion> canDel=new ArrayList<>();
			List<XmQuestion> noMyCreate=new ArrayList<>();
			for (XmQuestion xmQuestion : xmQuestionsDb) {
				if(!user.getUserid().equals(xmQuestion.getCreateUserid())){
					noMyCreate.add(xmQuestion);
				}else {
					canDel.add(xmQuestion);
				}
			}
			if(canDel.size()>0){
				xmQuestionService.batchDelete(canDel);
				List<XmQuestionHandle> handles=new ArrayList<>();
				for (XmQuestion xmQuestionVo : canDel) {
					XmQuestionHandle handle=new XmQuestionHandle();
					handle.setReceiptMessage(user.getUsername()+"删除了缺陷:"+xmQuestionVo.getName());
					handle.setHandleStatus(xmQuestionVo.getBugStatus());
					handle.setCreateTime(new Date());
					handle.setReceiptTime(new Date());
					handle.setHandlerUserid(xmQuestionVo.getCreateUserid());
					handle.setHandlerUsername(xmQuestionVo.getCreateUsername());
					handle.setLastUpdateTime(new Date());
					handle.setHandleSolution(xmQuestionVo.getSolution());
					handle.setQuestionId(xmQuestionVo.getId());
					handle.setTargetUserid(xmQuestionVo.getHandlerUserid());
					handle.setTargetUsername(xmQuestionVo.getHandlerUsername());
					handle.setId(this.xmQuestionHandleService.createKey("id"));
					handles.add(handle);
				}
				xmQuestionHandleService.batchAddAsync(handles);
			}

			List<String> msgs=new ArrayList<>();
			if(canDel.size()>0){
				msgs.add(String.format("删除了%s个缺陷。",canDel.size()));
			}
			if(noMyCreate.size()>0){
				msgs.add(String.format("以下%s个缺陷不属于您创建的缺陷，无权限删除。",noMyCreate.size()));
			}
			if(canDel.size()>0){
				tips.setOkMsg(msgs.stream().collect(Collectors.joining()));
			}else{
				tips.setFailureMsg(msgs.stream().collect(Collectors.joining()));
			}

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
