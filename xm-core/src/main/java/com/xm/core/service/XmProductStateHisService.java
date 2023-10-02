package com.xm.core.service;

import com.mdp.core.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmProductStateHis 表 xm_product_state_his 当前主键(包括多主键): product_id,biz_date; 
 ***/
@Service("xm.core.xmProductStateHisService")
public class XmProductStateHisService extends BaseService<XmProductStateHisMapper,XmProductStateHis> {
	static Logger logger =LoggerFactory.getLogger(XmProductStateHisService.class);

}

