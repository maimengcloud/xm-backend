package com.xm.core.service;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.service.BaseService;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmFile;
import com.xm.core.vo.XmFileVo;
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
 * 实体 XmFile 表 XM.xm_file 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmFileService")
public class XmFileService extends BaseService<XmFileMapper,XmFile> {
    
    final String Type = "文档";

    @Autowired
    XmAttachmentService xmAttachmentService;
    
    @Autowired
    XmRecordService xmRecordService;

	
	/** 请在此类添加自定义函数 */

    public List<Map<String,Object>> getFile(Map<String,Object> params) {
        List<Map<String,Object>> fs = this.selectListMapByWhere(params); 
        return fs;
    }

    public Map<String,Object> updateFile(XmFileVo xmFileVo){
        XmFile xmFile = new XmFile();
        BeanUtils.copyProperties(xmFileVo,xmFile);
        this.updateSomeFieldByPk(xmFile);
        if(xmFileVo.getAttachment()!=null && xmFileVo.getAttachment().size()>0){
			xmAttachmentService.insertOrUpdate(xmFileVo.getId(),Type,xmFileVo.getAttachment());
		}
        return null;
    }


    public XmFileVo addFile(XmFileVo xmFileVo){
        Tips tips = new Tips();
        if(StringUtils.isEmpty(xmFileVo.getId())) {
            xmFileVo.setId(this.createKey("id"));
        }else{
            XmFile xmFileQuery = new  XmFile(xmFileVo.getId());
            if(this.countByWhere(xmFileQuery)>0){
                tips.setFailureMsg("编号重复，请修改编号再提交");
                throw new BizException(tips);
            }
        }

        User user = LoginUtils.getCurrentUserInfo();
        xmFileVo.setCreateUserid(user.getUserid());
        xmFileVo.setCreateUsername(user.getUsername());
        xmFileVo.setCreateTime(new Date());
        
        XmFile xmFile = new XmFile();
        BeanUtils.copyProperties(xmFileVo,xmFile);
        this.insert(xmFile);
        if(xmFileVo.getAttachment()!=null && xmFileVo.getAttachment().size()>0){
			xmAttachmentService.insertOrUpdate(xmFileVo.getId(),Type,xmFileVo.getAttachment());
		}
        xmRecordService.addXmProjectRecord(xmFileVo.getProjectId(), "项目-增加文档", "增加文档"+xmFile.getName());
        return xmFileVo;
    }
    
    public void deleteFile(XmFile xmFile) {
        this.deleteByPk(xmFile);
        xmRecordService.addXmProjectRecord(xmFile.getProjectId(), "项目-删除文档", "删除文档"+xmFile.getName(),xmFile.getId(),null); 
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
		String branchId=(String) flowVars.get("branchId"); 
		String fileId=(String) flowVars.get("fileId");  
		String bizKey=(String) flowVars.get("bizKey");
		if("xm_file_approva".equals(bizKey) ) { 
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
				Map<String,Object> bizQuery=new HashMap<>(); 
				bizQuery.put("fileId", fileId);
				if(StringUtils.isEmpty(fileId)) {
					throw new BizException("请上送fileId");
				}
				if(StringUtils.isEmpty(branchId)) {
					throw new BizException("请上送branchId");
				} 
				List<Map<String,Object>> bizList=this.selectListMapByWhere(bizQuery);
				if(bizList==null || bizList.size()==0) {
					throw new BizException("没有找到对应文档,文档为【"+fileId+"】");
				}else {
					Map<String,Object> bizObject=bizList.get(0);
					if("1".equals(bizObject.get("bizFlowState"))) {
						throw new BizException("该文档正在审批中，不能再发起审批");
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
		baseMapper.updateFlowStateByProcInstForDeleteSuccess( flowVars);
		
	}

	public void updateFlowStateByProcInst(String flowState,Map<String, Object> flowVars) {
		flowVars.put("flowState", flowState);
		flowVars.put("bizFlowState", flowState);
		if("1".equals(flowState)) {
			flowVars.put("bizProcInstId", flowVars.get("procInstId"));
		}
		baseMapper.updateProcessApprova( flowVars);
	}

}