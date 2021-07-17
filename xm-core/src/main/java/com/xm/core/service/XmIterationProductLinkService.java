package com.xm.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.mdp.core.service.BaseService;
import com.xm.core.entity.XmIterationProductLink;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmIterationProductLink 表 XM.xm_iteration_product_link 当前主键(包括多主键): iteration_id,product_id; 
 ***/
@Service("xm.core.xmIterationProductLinkService")
public class XmIterationProductLinkService extends BaseService {
	static Logger logger =LoggerFactory.getLogger(XmIterationProductLinkService.class);
	/** 请在此类添加自定义函数 */

}

