package com.xm.core.service;

import com.alibaba.fastjson.JSONObject;
import com.mdp.core.err.BizException;
import com.mdp.core.service.BaseService;
import com.mdp.core.utils.BaseUtils;
import com.mdp.core.utils.DateUtils;
import com.mdp.core.utils.NumberUtil;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmProjectMCostUser;
import com.xm.core.entity.XmTask;
import com.xm.core.entity.XmTaskExecuser;
import com.xm.core.service.client.CashOperateServie;
import com.xm.core.service.client.MkClient;
import com.xm.core.service.push.XmPushMsgService;
import com.xm.core.vo.XmProjectGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmTaskExecuser 表 XM.xm_task_execuser 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmTaskExecuserService")
public class XmTaskExecuserService extends BaseService {

	/** 请在此类添加自定义函数 */

	@Autowired
	XmRecordService xmRecordService;
	
	@Autowired
	XmTaskService xmTaskService;
	
	@Autowired
    XmGroupService groupService;
	
	
	@Autowired
	XmProjectMCostUserService xmProjectMCostUserService;
	
	@Autowired
    XmPushMsgService pushMsgService ;

	@Autowired
	CashOperateServie cashOperateServie;

	@Autowired
	MkClient mkClient;
	
	public void addExecuser(XmTaskExecuser xmTaskExecuser){
		User user = LoginUtils.getCurrentUserInfo();
		XmTaskExecuser xmTaskExecuserQuery=new XmTaskExecuser();
		xmTaskExecuserQuery.setTaskId(xmTaskExecuser.getTaskId());
		xmTaskExecuserQuery.setUserid(xmTaskExecuser.getUserid()); 
		List<XmTaskExecuser> userDb=this.selectListByWhere(xmTaskExecuserQuery);
		if(userDb.size()>0) {
			throw new BizException(xmTaskExecuser.getUsername()+"已在任务中，不允许再添加");
		}
		xmTaskExecuser.setId(this.createKey("id"));
		xmTaskExecuser.setCreateUserid(user.getUserid());
		xmTaskExecuser.setCreateUsername(user.getUsername());
		xmTaskExecuser.setCreateTime(new Date());
		xmTaskExecuser.setStartTime(new Date());
		xmTaskExecuser.setStatus("0");
		this.insert(xmTaskExecuser);
		updateXmTaskExeUseridsAndUsernamesByTaskId(xmTaskExecuser.getTaskId()); 
		
		String imMsg=xmTaskExecuser.getUsername()+"成为任务【"+xmTaskExecuser.getTaskId()+"-"+xmTaskExecuser.getTaskName()+"】的候选人";
		this.pushMsgService.pushPrichatMsgToIm(user.getBranchId(),user.getUserid(),user.getUsername(), xmTaskExecuser.getUserid(), xmTaskExecuser.getUsername(),imMsg);
		this.pushMsgService.pushCreateCssGroupMsg(user.getBranchId(), xmTaskExecuser.getUserid(), xmTaskExecuser.getUsername(), imMsg);
		xmRecordService.addXmTaskRecord(xmTaskExecuser.getProjectId(), xmTaskExecuser.getTaskId(), "项目-任务-增加候选人", "任务增加候选人"+xmTaskExecuser.getUsername(),JSONObject.toJSONString(xmTaskExecuser),null);
	}
	/**
	 * 提交任务给测试人员测试
	 * @param xmTaskExecuser
	 */
	public void toTest(XmTaskExecuser xmTaskExecuser){
		User user = LoginUtils.getCurrentUserInfo(); 
		XmTaskExecuser xmTaskExecuserNew = new XmTaskExecuser();
		xmTaskExecuserNew.setId(xmTaskExecuser.getId());
		xmTaskExecuserNew.setStatus("2");
		this.updateSomeFieldByPk(xmTaskExecuserNew);
			updateXmTaskExeUseridsAndUsernamesByTaskId(xmTaskExecuser.getTaskId()); 
			String imMsg=xmTaskExecuser.getUsername()+"提交任务【"+xmTaskExecuser.getTaskId()+"-"+xmTaskExecuser.getTaskName()+"】，请安排测试";
 			this.pushMsgService.pushCreateCssGroupMsg(user.getBranchId(), xmTaskExecuser.getUserid(), xmTaskExecuser.getUsername(), imMsg);
			xmRecordService.addXmTaskRecord(xmTaskExecuser.getProjectId(), xmTaskExecuser.getTaskId(), "项目-任务-提交任务测试", "提交任务测试"+xmTaskExecuser.getUsername(),JSONObject.toJSONString(xmTaskExecuser),null);
		
		
	}

	public void testFail(XmTaskExecuser xmTaskExecuser) {
		User user = LoginUtils.getCurrentUserInfo(); 
		XmTaskExecuser xmTaskExecuserNew = new XmTaskExecuser();
		xmTaskExecuserNew.setId(xmTaskExecuser.getId());
		xmTaskExecuserNew.setStatus("4");
		this.updateSomeFieldByPk(xmTaskExecuserNew);
			updateXmTaskExeUseridsAndUsernamesByTaskId(xmTaskExecuser.getTaskId()); 
			String imMsg=xmTaskExecuser.getUsername()+"的任务【"+xmTaskExecuser.getTaskId()+"-"+xmTaskExecuser.getTaskName()+"】测试不通过";
 			this.pushMsgService.pushCreateCssGroupMsg(user.getBranchId(), xmTaskExecuser.getUserid(), xmTaskExecuser.getUsername(), imMsg);
			xmRecordService.addXmTaskRecord(xmTaskExecuser.getProjectId(), xmTaskExecuser.getTaskId(), "项目-任务-任务测试", "测试不通过",JSONObject.toJSONString(xmTaskExecuser),null);
		
		
		
	}
	public void testSuccess(XmTaskExecuser xmTaskExecuser) {
		User user = LoginUtils.getCurrentUserInfo(); 
		XmTaskExecuser xmTaskExecuserNew = new XmTaskExecuser();
		xmTaskExecuserNew.setId(xmTaskExecuser.getId());
		xmTaskExecuserNew.setStatus("3");
		this.updateSomeFieldByPk(xmTaskExecuserNew);
			updateXmTaskExeUseridsAndUsernamesByTaskId(xmTaskExecuser.getTaskId()); 
			String imMsg=xmTaskExecuser.getUsername()+"的任务【"+xmTaskExecuser.getTaskId()+"-"+xmTaskExecuser.getTaskName()+"】测试通过";
 			this.pushMsgService.pushCreateCssGroupMsg(user.getBranchId(), xmTaskExecuser.getUserid(), xmTaskExecuser.getUsername(), imMsg);
			xmRecordService.addXmTaskRecord(xmTaskExecuser.getProjectId(), xmTaskExecuser.getTaskId(), "项目-任务-提交任务测试", "提交任务测试"+xmTaskExecuser.getUsername(),JSONObject.toJSONString(xmTaskExecuser),null);
		
		
		
	}
	/**
	 * 本人或者组长可以变更
	 * @param xmTaskExecuserList
	 */
	public void batchLeave(List<XmTaskExecuser> xmTaskExecuserList){ 
		String projectId=xmTaskExecuserList.get(0).getProjectId();
		String taskId="";
		List<String> usernames=new ArrayList<>();
		
		 User user=LoginUtils.getCurrentUserInfo();
		 List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);
 		for (XmTaskExecuser xmTaskExecuser : xmTaskExecuserList) {
			List<XmProjectGroupVo> userGroups=groupService.getUserGroups(pgroups, xmTaskExecuser.getUserid()); 
			XmTaskExecuser xmTaskExecuser2=new XmTaskExecuser();
			xmTaskExecuser2.setId(xmTaskExecuser.getId());
			xmTaskExecuser2.setStatus("7");
			this.updateSomeFieldByPk(xmTaskExecuser2);   
			projectId=xmTaskExecuser.getProjectId();
			taskId=xmTaskExecuser.getTaskId(); 
			usernames.add(xmTaskExecuser.getUsername());
			
			/**
			 * 下面为推送任务执行人变更im通知消息
			 */
			List<Map<String,Object>> users=new ArrayList<>();
			Map<String,Object> userMap=new HashMap<>();
			userMap.put("userid", xmTaskExecuser.getUserid());
			userMap.put("username", xmTaskExecuser.getUsername());
			users.add(userMap);
			String imMsg=xmTaskExecuser.getUsername()+"放弃任务【"+xmTaskExecuser.getTaskId()+"-"+xmTaskExecuser.getTaskName()+"】";

			for (XmProjectGroupVo g : userGroups) {
				this.pushMsgService.pushGroupMsg(user.getBranchId(), g.getId(), xmTaskExecuser.getUserid(), xmTaskExecuser.getUsername(),  imMsg);
 				this.pushMsgService.pushLeaveChannelGroupMsg(user.getBranchId(), g.getId(), users); 
			}
			this.pushMsgService.pushCssMsg(user.getBranchId(), xmTaskExecuser.getUserid(), xmTaskExecuser.getUsername(), imMsg);

		}  
			updateXmTaskExeUseridsAndUsernamesByTaskId(taskId);
			String usernamestr=StringUtils.arrayToDelimitedString(usernames.toArray(), ",");
			xmRecordService.addXmTaskRecord(projectId, taskId, "项目-任务-执行人离开", usernamestr+"离开任务",JSONObject.toJSONString(xmTaskExecuserList),null);
		 
			
		
	}
	
	/**
	 * 一个任务只能有一个执行人，如果要把候选人变成执行人，必须把其它执行人变更为候选人
	 * 本人或者组长可以变更
	 * @param xmTaskExecuser
	 */
	public void becomeExecute(XmTaskExecuser xmTaskExecuser){
		String projectId=xmTaskExecuser.getProjectId();
		String taskId=xmTaskExecuser.getTaskId();
 		 List<XmProjectGroupVo> pgroups=groupService.getProjectGroupVoList(projectId);
		 User user=LoginUtils.getCurrentUserInfo();
 
 		List<XmProjectGroupVo> userGroups=groupService.getUserGroups(pgroups, xmTaskExecuser.getUserid()); 
 		XmTaskExecuser query=new XmTaskExecuser(); 
 		query.setTaskId(taskId);
 		 List<XmTaskExecuser> xmTaskExecusersDb=this.selectListByWhere(query);
 		 if(xmTaskExecusersDb !=null && xmTaskExecusersDb.size()>0) {
 			 for (XmTaskExecuser exe : xmTaskExecusersDb) {
				if(!xmTaskExecuser.getUserid().equals(exe.getUserid())) {
					if(!"0".equals(exe.getStatus()) && !"7".equals(exe.getStatus())) {
						throw new BizException(exe.getUsername()+"是当前执行人，不允许再添加其它执行人");
					}
				}else {
					if(!"0".equals(exe.getStatus())) {
						throw new BizException(exe.getUsername()+"不是候选人，不允许变更为执行人");
					} 
				}
			}
 		 }
  			XmTaskExecuser xmTaskExecuser2=new XmTaskExecuser();
			xmTaskExecuser2.setId(xmTaskExecuser.getId());
			xmTaskExecuser2.setStatus("1"); 
			xmTaskExecuser2.setIsLeader("1");
			this.updateSomeFieldByPk(xmTaskExecuser2);
			/** 
			 * 下面为推送任务执行人变更im通知消息
			 */
 			String imMsg=xmTaskExecuser.getUsername()+"变更为任务["+xmTaskExecuser.getTaskId()+"-"+xmTaskExecuser.getTaskName()+"]执行人"; 
			for (XmProjectGroupVo g : userGroups) { 
				this.pushMsgService.pushGroupMsg(user.getBranchId(),g.getId(),  xmTaskExecuser.getUserid(), xmTaskExecuser.getUsername(),imMsg );
				this.pushMsgService.pushPrichatMsgToIm(user.getBranchId(), user.getUserid(),user.getUsername(),xmTaskExecuser.getUserid(), xmTaskExecuser.getUsername(),imMsg);
			}
			this.pushMsgService.pushCssMsg(user.getBranchId(), xmTaskExecuser.getUserid(), xmTaskExecuser.getUsername(), imMsg); 
 
		updateXmTaskExeUseridsAndUsernamesByTaskId(taskId);
 		xmRecordService.addXmTaskRecord(projectId, taskId, "项目-任务-变更为执行人", xmTaskExecuser.getUsername()+"变更为任务执行人",null,null);
	}
	/**
	 * 结算
	 * 1 当前结算金额+已结算金额应该<=任务总预算
	 * 2 每个人的结算金额应该<=报价金额
	 * @param xmTaskExecuserList
	 */
	public void batchSettle(String execuserProcInstId,List<XmTaskExecuser> xmTaskExecuserList){
		if(xmTaskExecuserList==null || xmTaskExecuserList.size()<=0) {
			return;
		}
		XmTaskExecuser one=xmTaskExecuserList.get(0);
		String projectId=one.getProjectId();
		String taskId=one.getTaskId();
		
		List<String> usernames=new ArrayList<>();
		String subjectId="rwcl";
		String subjectName="任务酬劳";
		Map<String,Object> params=new HashMap<>();
		params.put("projectId", projectId); 
		params.put("taskId", taskId);
		XmTask task=xmTaskService.selectOneObject(new XmTask(taskId));
		String projectName=task.getProjectName();
		List<Map<String,Object>> actCostAmountList=xmProjectMCostUserService.listSumForSettleGroupByTaskIdAndUserid(params);
		BigDecimal addSettleAmount=BigDecimal.ZERO;
		BigDecimal allActCostAmount=BigDecimal.ZERO;
		BigDecimal taskBudgetCost=NumberUtil.getBigDecimal(task.getBudgetCost(),BigDecimal.ZERO);
		Map<String,Map<String,Object>> actCostAmountMap=new HashMap<>();
		XmTaskExecuser execuserQuery=new XmTaskExecuser();
		execuserQuery.setTaskId(taskId);
		execuserQuery.setProjectId(projectId);
		List<XmTaskExecuser> execuserDBList=this.selectListByWhere(execuserQuery);
		Map<String,XmTaskExecuser> xmTaskExecuserDBMap=new HashMap<>();
		for (XmTaskExecuser xmTaskExecuser : execuserDBList) {
			xmTaskExecuserDBMap.put(xmTaskExecuser.getUserid(), xmTaskExecuser);
		}
		for (Map<String, Object> map : actCostAmountList) {
			BigDecimal actCostAmount=NumberUtil.getBigDecimal(map.get("actCostAmount"), BigDecimal.ZERO);
			allActCostAmount=allActCostAmount.add(actCostAmount); 
			actCostAmountMap.put((String) map.get("userid"), map);
		}
		for (XmTaskExecuser xmTaskExecuser : xmTaskExecuserList) {
			XmTaskExecuser xmTaskExecuserDB =xmTaskExecuserDBMap.get(xmTaskExecuser.getUserid());
			if(xmTaskExecuserDB==null) {
				throw  new BizException(xmTaskExecuser.getUsername()+"不在执行人列表中，不允许结算");
			}
			
			if("0".equals(xmTaskExecuserDB.getStatus())) {
				throw  new BizException(xmTaskExecuser.getUsername()+"候选排队中人员不能申请结算");
			}
			//结算状态0未结算1已部分结算2无需结算4已申请结算5结算失败6已全部结算
			// 0/1/5状态可以结算
			if("2".equals(xmTaskExecuserDB.getSettleStatus())) {
				throw  new BizException(xmTaskExecuser.getUsername()+"无需结算");
			}
			if("4".equals(xmTaskExecuserDB.getSettleStatus())) {
				throw  new BizException(xmTaskExecuserDB.getUsername()+"已有申请在审核中，不能再申请");
			}
			if("6".equals(xmTaskExecuserDB.getSettleStatus())) {
				throw  new BizException(xmTaskExecuserDB.getUsername()+"已经结算完毕，不能再申请");
			}
			if( StringUtils.hasText(xmTaskExecuserDB.getSettleStatus()) && !"0".equals(xmTaskExecuserDB.getSettleStatus()) && !"1".equals(xmTaskExecuserDB.getSettleStatus()) && !"5".equals(xmTaskExecuserDB.getSettleStatus())) {
				throw  new BizException(xmTaskExecuserDB.getUsername()+"暂时还不能申请结算");
			}
			BigDecimal settleAmount=NumberUtil.getBigDecimal(xmTaskExecuser.getSettleAmount(), BigDecimal.ZERO); 
			BigDecimal quoteAmount=NumberUtil.getBigDecimal(xmTaskExecuserDB.getQuoteAmount(), BigDecimal.ZERO); 
			

			BigDecimal userActCostAmount=BigDecimal.ZERO;
			Map<String, Object>  userActCostAmountRow = (Map<String, Object>) actCostAmountMap.get(xmTaskExecuser.getUserid());
			if(userActCostAmountRow!=null) {
				userActCostAmount=NumberUtil.getBigDecimal(userActCostAmountRow.get("actCostAmount"),BigDecimal.ZERO);  
			}
			if(settleAmount.add(userActCostAmount).compareTo(quoteAmount)>0) {
				throw new BizException(xmTaskExecuserDB.getUsername()+"的结算金额不能大于报价金额,剩余"+quoteAmount.subtract(userActCostAmount)+"元可结算");
			} 
			if(settleAmount.add(userActCostAmount).compareTo(taskBudgetCost)>0) {
				throw new BizException(xmTaskExecuserDB.getUsername()+"的总结算金额不能大于任务总预算金额");
			}
		}

		if(allActCostAmount.add(addSettleAmount).compareTo(taskBudgetCost)>0) {
			throw new BizException(task.getName()+"结算总金额已经超出任务预算");
		} 
		for (XmTaskExecuser xmTaskExecuser : xmTaskExecuserList) {
			
			BigDecimal userActCostAmount=BigDecimal.ZERO;
			Map<String, Object>  userActCostAmountRow = (Map<String, Object>) actCostAmountMap.get(xmTaskExecuser.getUserid());
			if(userActCostAmountRow!=null) {
				userActCostAmount=NumberUtil.getBigDecimal(userActCostAmountRow.get("actCostAmount"),BigDecimal.ZERO);  
			}
			XmTaskExecuser xmTaskExecuserDB =xmTaskExecuserDBMap.get(xmTaskExecuser.getUserid());
			XmTaskExecuser xmTaskExecuser2=new XmTaskExecuser();
			xmTaskExecuser2.setId(xmTaskExecuser.getId()); 
			xmTaskExecuser2.setSettleStatus("4");
			xmTaskExecuser2.setSettleAmount(xmTaskExecuser.getSettleAmount().add(userActCostAmount));
			xmTaskExecuser2.setSettleWorkload(xmTaskExecuser.getSettleWorkload());
			xmTaskExecuser2.setSettleTime(new Date());
			this.updateSomeFieldByPk(xmTaskExecuser2);   
			projectId=xmTaskExecuser.getProjectId();
			taskId=xmTaskExecuser.getTaskId(); 
			usernames.add(xmTaskExecuserDB.getUsername());
			
			XmProjectMCostUser costUser=new XmProjectMCostUser();
			costUser.setUserid(xmTaskExecuser.getUserid());
			costUser.setUsername(xmTaskExecuserDB.getUsername());
			costUser.setActCostAmount(xmTaskExecuser.getSettleAmount());
			costUser.setActWorkload(xmTaskExecuser.getSettleWorkload());
			costUser.setBizDate(DateUtils.getDate());
			costUser.setBizMonth(DateUtils.getDate().substring(0, 7));
			costUser.setSubjectId(subjectId);
			costUser.setSubjectId(subjectName);
			costUser.setBizzStartDate(xmTaskExecuser.getStartTime());
			costUser.setBizzEndDate(xmTaskExecuser.getEndTime());
			costUser.setBizFlowState("0");
			costUser.setCostType("1".equals(task.getTaskOut())?"1":"2");
			costUser.setTaskId(xmTaskExecuser.getTaskId());
			costUser.setTaskName(task.getName());
			costUser.setCreateTime(new Date());
			costUser.setProjectId(xmTaskExecuser.getProjectId());
			costUser.setProjectName(projectName);
			costUser.setProjectPhaseName(task.getProjectPhaseName());
			costUser.setProjectPhaseId(task.getProjectPhaseName());
			costUser.setId(this.xmProjectMCostUserService.createKey("id"));
			costUser.setExecuserProcInstId(execuserProcInstId);
			costUser.setExecuserStatus("0");
			this.xmProjectMCostUserService.insert(costUser);
			xmRecordService.addXmCostRecord(projectId, taskId, "项目-任务-执行人进行结算", costUser.getUsername()+"提交结算",JSONObject.toJSONString(costUser),null);
			this.pushMsgService.pushCssMsg(xmTaskExecuser.getBranchId(), costUser.getUserid(), costUser.getUsername(),  costUser.getUsername()+"提交任务【"+xmTaskExecuser.getTaskId()+"-"+xmTaskExecuser.getTaskName()+"】结算");
		} 
		//updateXmTaskExeUseridsAndUsernamesByTaskId(taskId);
		String usernamestr=StringUtils.arrayToDelimitedString(usernames.toArray(), ",");
		xmRecordService.addXmTaskRecord(projectId, taskId, "项目-任务-执行人进行结算", usernamestr+"提交结算",JSONObject.toJSONString(xmTaskExecuserList),null);
	}
	
	
	 
	

	public void becomeCandidate(XmTaskExecuser xmTaskExecuser) {
		XmTaskExecuser xmTaskExecuserNew=new XmTaskExecuser();
		xmTaskExecuserNew.setId(xmTaskExecuser.getId()); 
		xmTaskExecuserNew.setQuoteWeekday(xmTaskExecuser.getQuoteWeekday());
		xmTaskExecuserNew.setQuoteWorkload(xmTaskExecuser.getQuoteWorkload());
		xmTaskExecuserNew.setQuoteAmount(xmTaskExecuser.getQuoteAmount());
		xmTaskExecuserNew.setQuoteEndTime(xmTaskExecuser.getQuoteEndTime());
		xmTaskExecuserNew.setQuoteStartTime(xmTaskExecuser.getQuoteStartTime());
		xmTaskExecuserNew.setSkillRemark(xmTaskExecuser.getSkillRemark()); 
		xmTaskExecuserNew.setStatus("0");
		this.updateSomeFieldByPk(xmTaskExecuserNew);
		updateXmTaskExeUseridsAndUsernamesByTaskId(xmTaskExecuser.getTaskId());
		this.pushMsgService.pushCssMsg(xmTaskExecuser.getBranchId(), xmTaskExecuser.getUserid(), xmTaskExecuser.getUsername(),  xmTaskExecuser.getUsername()+"变更为候选人并提交关于任务【"+xmTaskExecuser.getTaskId()+"-"+xmTaskExecuser.getTaskName()+"】报价信息");

		xmRecordService.addXmTaskRecord(xmTaskExecuser.getProjectId(), xmTaskExecuser.getTaskId(), "项目-任务-候选人报价", xmTaskExecuser.getUsername()+"变更为候选人并提交报价信息",JSONObject.toJSONString(xmTaskExecuser),null);
	}
	public void quotePrice(XmTaskExecuser xmTaskExecuser) {
		XmTaskExecuser xmTaskExecuserNew=new XmTaskExecuser();
		xmTaskExecuserNew.setId(xmTaskExecuser.getId()); 
		xmTaskExecuserNew.setQuoteWeekday(xmTaskExecuser.getQuoteWeekday());
		xmTaskExecuserNew.setQuoteWorkload(xmTaskExecuser.getQuoteWorkload());
		xmTaskExecuserNew.setQuoteAmount(xmTaskExecuser.getQuoteAmount());
		xmTaskExecuserNew.setQuoteEndTime(xmTaskExecuser.getQuoteEndTime());
		xmTaskExecuserNew.setQuoteStartTime(xmTaskExecuser.getQuoteStartTime());
		xmTaskExecuserNew.setSkillRemark(xmTaskExecuser.getSkillRemark()); 
		this.updateSomeFieldByPk(xmTaskExecuserNew);
		this.pushMsgService.pushCssMsg(xmTaskExecuser.getBranchId(), xmTaskExecuser.getUserid(), xmTaskExecuser.getUsername(),  xmTaskExecuser.getUsername()+"提交关于任务【"+xmTaskExecuser.getTaskId()+"-"+xmTaskExecuser.getTaskName()+"】报价信息");

		xmRecordService.addXmTaskRecord(xmTaskExecuser.getProjectId(), xmTaskExecuser.getTaskId(), "项目-任务-候选人报价", xmTaskExecuser.getUsername()+"提交报价信息",JSONObject.toJSONString(xmTaskExecuser),null);
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
	 *            TASK_COMPLETED_FORM_DATA_UPDATE 人工任务提交完成后，智能表单数据更新
	 *            
	 * 其中 create/complete/assignment/delete事件是需要在模型中人工节点上配置了委托代理表达式 ${taskBizCallListener}才会推送过来。
	 * 在人工任务节点上配置 任务监听器  建议事件为 complete,其它assignment/create/complete/delete也可以，一般建议在complete,委托代理表达式 ${taskBizCallListener}
	 * 
	 * @param flowVars {flowBranchId,agree,procInstId,startUserid,assignee,actId,taskName,mainTitle,branchId,bizKey,commentMsg,eventName,modelKey} 等 
	 * @return 如果tips.isOk==false，将影响流程提交
	 **/
	public void processApprova(Map<String, Object> flowVars) { 
		String eventName=(String) flowVars.get("eventName"); 

		String procInstId=(String) flowVars.get("procInstId");  
		String agree=(String) flowVars.get("agree"); 
 		String bizKey=(String) flowVars.get("bizKey"); 
		XmTaskExecuser bizExecuser=null;
		if("xm_task_execuser_settle_approva".equals(bizKey) ) { 
			if(!flowVars.containsKey("data")) {
				throw new BizException("请上送结算业务数据flowVars.data");
			}
			bizExecuser = BaseUtils.fromMap((Map)flowVars.get("data"), XmTaskExecuser.class); 
			if(bizExecuser.getSettleAmount()==null || bizExecuser.getSettleAmount().compareTo(BigDecimal.ZERO)==0) {
				throw new BizException("结算金额不能为0");
			}
			if(StringUtils.isEmpty(bizExecuser.getId())) {
				throw new BizException("执行编号不能为空");
			}
			if(StringUtils.isEmpty(bizExecuser.getUserid())) {
				throw new BizException("结算人员编号不能为空");
			}
			if(StringUtils.isEmpty(bizExecuser.getUsername())) {
				throw new BizException("结算人员姓名不能为空");
			}
			if(StringUtils.isEmpty(bizExecuser.getProjectId())) {
				throw new BizException("项目编号不能为空");
			}
			if(StringUtils.isEmpty(bizExecuser.getTaskId())) {
				throw new BizException("任务编号不能为空");
			} 
			if(StringUtils.isEmpty(bizExecuser.getBranchId())) {
				throw new BizException("机构编号不能为空");
			} 
			flowVars.put("execuserId", bizExecuser.getId());
			flowVars.put("projectId", bizExecuser.getProjectId());
		}else {
			throw new BizException("不支持的业务,请上送业务编码【bizKey】参数");
		}
		if("complete".equals(eventName)) { 
			if("1".equals(agree)) {
				this.updateFlowStateByProcInst("", flowVars);
			}else {
				this.updateFlowStateByProcInst("", flowVars);
			}
		}else {
			if("PROCESS_STARTED".equals(eventName)) {    
				 
				XmTaskExecuser execuser=new XmTaskExecuser();
				execuser.setId(bizExecuser.getId());
				execuser.setBranchId(bizExecuser.getBranchId());
				execuser.setProjectId(bizExecuser.getProjectId());
				execuser.setTaskId(bizExecuser.getTaskId());
				execuser.setUserid(bizExecuser.getUserid());
				execuser.setSettleAmount(bizExecuser.getSettleAmount());
				execuser.setSettleWorkload(bizExecuser.getSettleWorkload()); 
				List<XmTaskExecuser> execuserList=new ArrayList<>();
				execuserList.add(execuser);
				this.batchSettle(procInstId,execuserList); 
				flowVars.put("id", this.createKey("id"));
					this.insert("insertProcessApprova", flowVars);   
					flowVars.put("settleStatus", "4");
					flowVars.put("status","5");
					this.updateFlowStateByProcInst("1", flowVars);
			}else if("PROCESS_COMPLETED".equals(eventName)) {
				if("1".equals(agree)) { //结算通过，需要调用财务系统进行记账结算到用户的结算账户中。//用户可以通过该账户提现取现金
					// 需要调用财务系统进行记账结算到用户的结算账户中。用户可以通过该账户提现取现金
					cashOperateServie.shopBalancePayToClient(bizExecuser.getBranchId(),"platform",bizExecuser.getId(),bizExecuser.getSettleAmount(),bizExecuser.getTaskName()+"结算费用给执行人",bizExecuser.getUserid(),bizExecuser.getBranchId());
					// 需要调用营销系统，计算佣金
					mkClient.pushActiExecOrder(bizExecuser.getTaskId(), bizExecuser.getUserid(), bizExecuser.getUsername(),bizExecuser.getBranchId(),bizExecuser.getTaskId(),new BigDecimal(1),bizExecuser.getSettleAmount(),bizExecuser.getSettleAmount(),bizExecuser.getSettleWorkload(),bizExecuser.getTaskName());
					flowVars.put("settleStatus","6");
					flowVars.put("status","6");
					this.updateFlowStateByProcInst("2", flowVars); 
					//结算通过,更新费用表状态未1，申请通过
					this.xmProjectMCostUserService.updateExecuserStatusByExecuserProcInstId(procInstId,"1");
					
				}else { 
					//结算申请不通过，需要删除成本表中相关数据，还原执行表中相关数据
					flowVars.put("settleStatus", "5");
					flowVars.put("status","3");
					this.updateFlowStateByProcInst("3", flowVars);
					this.xmProjectMCostUserService.deleteByExecuserProcInstId(procInstId);
				} 
			}else if("PROCESS_CANCELLED".equals(eventName)) { 
				flowVars.put("settleStatus", "0");
				flowVars.put("status", "3");
				this.updateFlowStateByProcInst("4", flowVars);
				this.xmProjectMCostUserService.deleteByExecuserProcInstId(procInstId);
				//结算申请不通过，需要删除成本表中相关数据，还原执行表中相关数据
			}
		} 
	}
	
	private void updateFlowStateByProcInstForDeleteSuccess(Map<String, Object> flowVars) {
		this.update("updateFlowStateByProcInstForDeleteSuccess", flowVars);
		
	}

	public void delete(XmTaskExecuser xmTaskExecuser){
		super.deleteByPk(xmTaskExecuser);
		this.updateXmTaskExeUseridsAndUsernamesByTaskId(xmTaskExecuser.getTaskId());
	}
	/**
	 * 将执行人编号，姓名同步到task中的exe_userids,exe_usernames两个字段
	 * @param taskId
	 */
	public void updateXmTaskExeUseridsAndUsernamesByTaskId(String taskId) {
		this.update("updateXmTaskExeUseridsAndUsernamesByTaskId", taskId);
	}
	/**
	 * 将执行人编号，姓名同步到task中的exe_userids,exe_usernames两个字段
	 * @param taskId
	 */
	public void updateXmTaskExeUseridsAndUsernamesAndTaskStateByTaskId(String taskId,String targetTaskState) {
		Map<String,Object> task=new HashMap<>();
		task.put("targetTaskState",targetTaskState);
		task.put("taskId",taskId);
		this.update("updateXmTaskExeUseridsAndUsernamesAndTaskStateByTaskId", task);
	}
	
	public void updateFlowStateByProcInst(String flowState,Map<String, Object> flowVars) {
		flowVars.put("flowState", flowState);
		flowVars.put("bizFlowState", flowState);
		if("1".equals(flowState)) {
			flowVars.put("bizProcInstId", flowVars.get("procInstId"));
		}
		this.update("updateProcessApprova", flowVars);
	}
  

}

