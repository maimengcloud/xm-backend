package com.xm.core.service;

import org.springframework.stereotype.Service;
import com.mdp.core.service.BaseService;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmProductState 表 XM.xm_product_state 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmProductStateService")
public class XmProductStateService extends BaseService {
	
	/**
	 * 计算bug、task、测试案例、等数据
	 * @param productId
	 * @return
	 */
	public int loadTasksToXmProductState(String productId) {
		 
		return this.update("loadTasksToXmProductState", productId);
	}

}

