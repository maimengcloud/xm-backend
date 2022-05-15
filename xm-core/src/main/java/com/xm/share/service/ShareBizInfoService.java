package com.xm.share.service;

import com.mdp.core.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com  顶级模块 xm 大模块 share 小模块 <br>
 * 实体 ShareBizInfo 表 XM.xm_share_biz_info 当前主键(包括多主键): share_key; 
 ***/
@Service("xm.share.shareBizInfoService")
public class ShareBizInfoService extends BaseService {
	static Logger logger =LoggerFactory.getLogger(ShareBizInfoService.class);
	/** 请在此类添加自定义函数 */

}

