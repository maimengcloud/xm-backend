package com.xm.core.service;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.service.BaseService;
import com.mdp.core.utils.BaseUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmQuestion;
import com.xm.core.entity.XmQuestionHandle;
import com.xm.core.vo.XmQuestionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmQuestion 表 XM.xm_question 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmQuestionService")
public class XmQuestionService extends BaseService {
    
    @Autowired
    XmAttachmentService xmAttachmentService;
    
    @Autowired
    XmQuestionHandleService xmQuestionHandleService;
    
	@Autowired
	XmRecordService xmRecordService;
	
	/** 请在此类添加自定义函数 */
    public List<Map<String,Object>> getQuestion (Map<String,Object> params) {
    
        List<Map<String,Object>> xmQuestionList = this.selectListMapByWhere(params); 
        return xmQuestionList;
    }
    
    public XmQuestionVo addQuestion( XmQuestionVo xmQuestionVo) {
        Tips tips = new Tips();
        if(StringUtils.isEmpty(xmQuestionVo.getId())) {
            xmQuestionVo.setId(this.createKey("id"));
        }
        xmQuestionVo.setCreateTime(new Date());
        xmQuestionVo.setLtime(new Date());
        XmQuestion xmQuestion = new XmQuestion();
        BeanUtils.copyProperties(xmQuestionVo,xmQuestion);
        xmQuestion.setBugStatus("1");
        this.insert(xmQuestion);

		XmQuestionHandle handle=new XmQuestionHandle();
		handle.setReceiptMessage(xmQuestionVo.getReceiptMessage());
		handle.setHandleStatus(xmQuestionVo.getBugStatus());
		handle.setCreateTime(new Date());
		handle.setReceiptTime(new Date());
		handle.setHandlerUserid(xmQuestion.getCreateUserid());
		handle.setHandlerUsername(xmQuestion.getCreateUsername());
		handle.setLastUpdateTime(new Date());
		handle.setHandleSolution(xmQuestionVo.getSolution());
		handle.setQuestionId(xmQuestionVo.getId());
		handle.setTargetUserid(xmQuestionVo.getHandlerUserid());
		handle.setTargetUsername(xmQuestionVo.getHandlerUsername());
		handle.setId(this.xmQuestionHandleService.createKey("id"));
		xmQuestionHandleService.insert(handle);

        if(xmQuestionVo.getAttachment()!=null && xmQuestionVo.getAttachment().size()>0) {
        	xmAttachmentService.insertOrUpdate(xmQuestionVo.getId(),"问题",xmQuestionVo.getAttachment());
        } 
        return xmQuestionVo;
    }
    /**
     * 更新问题状态，同时插入历史记录表
     * @param xmQuestionVo
     * @return
     */
    public XmQuestionVo updateQuestion(XmQuestionVo xmQuestionVo) {
    	User currentUser=LoginUtils.getCurrentUserInfo();
		xmQuestionVo.setLtime(new Date());

		xmQuestionVo.setRemarks(xmQuestionVo.getReceiptMessage());

        this.updateSomeFieldByPk(xmQuestionVo);
        
        XmQuestionHandle handle=new XmQuestionHandle();
        handle.setReceiptMessage(xmQuestionVo.getReceiptMessage());
        handle.setHandleStatus(xmQuestionVo.getBugStatus());
        handle.setCreateTime(new Date());
        handle.setReceiptTime(new Date());
        handle.setHandlerUserid(currentUser.getUserid());
        handle.setHandlerUsername(currentUser.getUsername());
        handle.setLastUpdateTime(new Date());
        handle.setHandleSolution(xmQuestionVo.getSolution());
        handle.setQuestionId(xmQuestionVo.getId());
        handle.setTargetUserid(xmQuestionVo.getHandlerUserid());
        handle.setTargetUsername(xmQuestionVo.getHandlerUsername());
        handle.setId(this.xmQuestionHandleService.createKey("id"));
        xmQuestionHandleService.insert(handle);
        //xmAttachmentService.insertOrUpdate(xmQuestionVo.getId(),"问题",xmQuestionVo.getAttachment());
        return xmQuestionVo;
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
		String agree=(String) flowVars.get("agree"); 
 		String questionId;  
		String bizKey=(String) flowVars.get("bizKey");
		if("xm_question_up_approva".equals(bizKey) ) { 
			if(!flowVars.containsKey("data")) {
				throw new BizException("缺乏问题信息，请将问题编号放在flowVars.data.id中");
			} 
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
			XmQuestion bizQuestion= BaseUtils.fromMap((Map)flowVars.get("data"), XmQuestion.class); 
			questionId=bizQuestion.getId();
			flowVars.put("questionId", bizQuestion.getId());
			if("PROCESS_STARTED".equals(eventName)) {   
				Map<String,Object> bizQuery=new HashMap<>(); 
				bizQuery.put("id", questionId);
				if(StringUtils.isEmpty(questionId)) {
					throw new BizException("请上送问题编号flowVars.data.id");
				} 
				List<Map<String,Object>> bizList=this.selectListMapByWhere(bizQuery);
				if(bizList==null || bizList.size()==0) {
					throw new BizException("没有找到对应问题单,问题单为【"+questionId+"】");
				}else {
					Map<String,Object> bizObject=bizList.get(0);
					if("1".equals(bizObject.get("bizFlowState"))) {
						throw new BizException("该问题单正在审批中，不能再发起审批");
					}
				}
				flowVars.put("id", this.createKey("id"));
					this.insert("insertProcessApprova", flowVars);   
					this.updateFlowStateByProcInst("1", flowVars);
			}else if("PROCESS_COMPLETED".equals(eventName)) {
				if("1".equals(agree)) { 
					this.updateFlowStateByProcInst("2", flowVars); 
					
				}else { 
					this.updateFlowStateByProcInst("3", flowVars);
				} 
			}else if("PROCESS_CANCELLED".equals(eventName)) { 
				this.updateFlowStateByProcInst("4", flowVars);
			}
		} 
	}
	
	private void updateFlowStateByProcInstForDeleteSuccess(Map<String, Object> flowVars) {
		this.update("updateFlowStateByProcInstForDeleteSuccess", flowVars);
		
	}

	public void updateFlowStateByProcInst(String flowState,Map<String, Object> flowVars) {
		flowVars.put("flowState", flowState);
		flowVars.put("bizFlowState", flowState);
		if("1".equals(flowState)) {
			flowVars.put("bizProcInstId", flowVars.get("procInstId"));
		}
		this.update("updateProcessApprova", flowVars);
	}


    public List<Map<String, Object>> getXmQuestionAttDist(Map<String, Object> xmQuestion) {
		return super.selectList("getXmQuestionAttDist",xmQuestion);
    }

	public List<Map<String, Object>> getXmQuestionAgeDist(Map<String, Object> xmQuestion) {
		return super.selectList("getXmQuestionAgeDist",xmQuestion);
	}

	public List<Map<String, Object>> getXmQuestionSort(Map<String, Object> xmQuestion) {
		return super.selectList("getXmQuestionSort",xmQuestion);
	}
}

