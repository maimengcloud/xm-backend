package com.xm.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.mdp.core.service.BaseService;
import com.xm.core.entity.XmProductProjectLink;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmProductProjectLink 表 XM.xm_product_project_link 当前主键(包括多主键): project_id; 
 ***/
@Service("xm.core.xmProductProjectLinkService")
public class XmProductProjectLinkService extends BaseService {
	static Logger logger =LoggerFactory.getLogger(XmProductProjectLinkService.class);

	List<XmProductProjectLink> selectListByIterationId(String iterationId){
		List<XmProductProjectLink> data=super.selectList("selectListByIterationId",iterationId);
		return data;
	}
}

