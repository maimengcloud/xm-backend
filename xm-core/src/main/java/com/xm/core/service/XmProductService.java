package com.xm.core.service;

import com.mdp.core.err.BizException;
import com.mdp.core.service.BaseService;
import com.mdp.safe.client.entity.User;
import com.xm.core.entity.XmMenu;
import com.xm.core.entity.XmProduct;
import com.xm.core.entity.XmProductCopyVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * @param iterationMap
	 * @return
	 */
	public List<Map<String, Object>> selectListMapByWhereWithState(Map<String, Object> iterationMap) {
		// TODO Auto-generated method stub
		return this.selectList("selectListMapByWhereWithState", iterationMap);
	}

    public XmProduct copyTo(User user, XmProductCopyVo xmProduct) {
		XmProduct pq=new XmProduct();
		pq.setId(xmProduct.getId());
		XmProduct xmProductDb=this.selectOneObject(pq);
		if(xmProductDb==null){
			throw new BizException("产品不存在");
		}
		XmProduct xmProductTo=new XmProduct();
		BeanUtils.copyProperties(xmProductDb,xmProductTo);
		xmProductTo.setId(null);
		xmProductTo.setProductName(xmProduct.getProductName());
		xmProductTo.setCode(xmProduct.getCode());
		xmProductTo.setBranchId(user.getBranchId());
		xmProductTo.setDeptid(user.getDeptid());
		xmProductTo.setDeptName(user.getDeptName());
		xmProductTo.setAdmUserid(user.getUserid());
		xmProductTo.setAdmUsername(user.getUsername());
		xmProductTo.setPmUserid(user.getUserid());
		xmProductTo.setPmUsername(user.getUsername());
		xmProductTo.setCtime(new Date());
		xmProductTo.setAssistantUserid(user.getUserid());
		xmProductTo.setAssistantUsername(user.getUsername());
		if(xmProduct.getProductName().equals(xmProductDb.getProductName())){
			xmProductTo.setProductName(xmProduct.getProductName()+"(复制)");
		}
		if("1".equals(xmProduct.getIsTpl())){
			xmProductTo.setIsTpl("1");
		}
		if("1".equals(xmProduct.getCopyMenu())){
			XmMenu mq=new XmMenu();
			mq.setProductId(xmProduct.getId());
			List<XmMenu> xmMenus=this.xmMenuService.selectListByWhere(mq);
			Map<String,String>	idMap=new HashMap<>();
			if(xmMenus!=null && xmMenus.size()>0){
				for (XmMenu node : xmMenus) {
					idMap.put(node.getMenuId(),this.xmMenuService.createKey("id"));
				}
				for (XmMenu node : xmMenus) {
					String oldId=node.getMenuId();
					String newId=idMap.get(oldId);
					node.setMenuId(newId);
					node.setProductId(xmProductTo.getId());
					node.setPmenuId(idMap.get(node.getPmenuId()));
					node.setCtime(new Date());
					node.setMmUserid(user.getUserid());
					node.setMmUsername(user.getUsername());
				}
				this.xmMenuService.parentIdPathsCalcBeforeSave(xmMenus);
				this.xmMenuService.doBatchInsert(xmMenus);
			}
		}
		return xmProductTo;
    }
}

