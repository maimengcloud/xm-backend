package com.xm.core.service;

import com.mdp.core.entity.Tips;
import com.mdp.core.service.BaseService;
import com.mdp.safe.client.entity.User;
import com.xm.core.entity.XmIteration;
import com.xm.core.entity.XmProduct;
import com.xm.core.entity.XmProject;
import com.xm.core.vo.XmIterationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmIteration 表 XM.xm_iteration 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmIterationService")
public class XmIterationService extends BaseService {

	@Autowired
	XmIterationLinkService xmIterationLinkService;



	
	/**
	 * 调用存储过程计算指定迭代的任务预算数据
	 * call load_tasks_to_xm_iteration_state(inIterationId)
	 */
	public void loadTasksToXmIterationState(String inIterationId) {
		this.update("load_tasks_to_xm_iteration_state", inIterationId);
	}

	/**
	 * 连同功能关联的状态数据一起带出
	 * @param iterationMap
	 * @return
	 */
	public List<Map<String, Object>> selectListMapByWhereWithState(Map<String, Object> iterationMap) {
		// TODO Auto-generated method stub
		return this.selectList("selectListMapByWhereWithState", iterationMap);
	}

	@Transactional
    public void addIteration(XmIterationVo xmIteration) {
		super.insert(xmIteration);
		this.xmIterationLinkService.batchInsert(xmIteration.getLinks());

    }

	public String createIterationId( Long count){
		String seq=(count%10000+1)+"";
		int preLength=4-seq.length();
		if(preLength>0){
			for (int i = 0; i < preLength; i++) {
				seq="0"+seq;
			}
		}
		String code=sequenceService.getCommonNo("IT{date:yyyy}-"+seq+"-{rands:4}");
		return code;

	}
}

