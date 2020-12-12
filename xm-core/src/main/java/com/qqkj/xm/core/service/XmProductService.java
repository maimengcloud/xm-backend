package com.qqkj.xm.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qqkj.mdp.core.service.BaseService;
import com.qqkj.xm.core.entity.XmProject;
import com.qqkj.xm.core.entity.XmMenu;
import com.qqkj.xm.core.entity.XmProduct;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProduct 表 XM.xm_product 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmProductService")
public class XmProductService extends BaseService {
	
	/** 请在此类添加自定义函数 */
	
	@Autowired
	XmProjectService xmProjectService;
	
	@Autowired
	XmMenuService xmMenuService;
	/**
	 * 产品不直接根项目关联，此函数作废了
	 * @param productId
	 * @return
	 */
	@Deprecated
	public  long checkExistsProject(String productId) { 
		return 0;
	}
	public  long checkExistsMenu(String productId) {
		XmMenu p=new XmMenu();
		p.setProductId(productId);
		return xmMenuService.countByWhere(p);
	}
	
	/**
	 * 连同产品关联的状态数据一起带出
	 * @param xmMenu
	 * @return
	 */
	public List<Map<String, Object>> selectListMapByWhereWithState(Map<String, Object> iterationMap) {
		// TODO Auto-generated method stub
		return this.selectList("selectListMapByWhereWithState", iterationMap);
	}
}

