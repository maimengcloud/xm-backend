package com.xm.core.service;

import com.mdp.core.err.BizException;
import com.mdp.core.service.BaseService;
import com.mdp.safe.client.entity.User;
import com.xm.core.entity.*;
import com.xm.core.service.cache.XmProductCacheService;
import com.xm.core.vo.XmProductAddVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProduct 表 XM.xm_product 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmProductService")
public class XmProductService extends BaseService {


	@Value("${mdp.platform-branch-id:platform-branch-001}")
	String platformBranchId="platform-branch-001";
	
	@Autowired
	XmProjectService xmProjectService;
	
	@Autowired
	XmMenuService xmMenuService;

	@Autowired
	XmProductCacheService xmProductCacheService;


	@Autowired
    XmGroupService groupService;

	@Autowired
	XmGroupUserService groupUserService;


	@Autowired
    XmPhaseService xmProjectPhaseService;

	@Autowired
	XmProductProjectLinkService linkService;


	
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
	public XmProduct getProductFromCache(String productId) {
		XmProduct productCahce=xmProductCacheService.getProduct(productId);
		if(productCahce==null) {
			productCahce = this.selectOneObject(new XmProduct(productId));
			xmProductCacheService.putProduct(productId, productCahce);
			return productCahce;
		}
		return productCahce;
	}
	public void clearCache(String productId){
		xmProductCacheService.clear(productId);
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

	@Transactional
    public XmProduct copyTo(User user, XmProductCopyVo xmProduct) {
		XmProduct pq=new XmProduct();
		pq.setId(xmProduct.getId());
		XmProduct xmProductDb=this.selectOneObject(pq);
		if(xmProductDb==null){
			throw new BizException("产品不存在");
		}

		if(!"1".equals(xmProductDb.getIsTpl())){
			if(!user.getBranchId().equals(xmProductDb.getBranchId())){
				throw new BizException("您无权复制其它组织的产品。");
			}
		}else{
			if(!user.getBranchId().equals(xmProductDb.getBranchId())){
				if(!platformBranchId.equals(xmProductDb.getBranchId())){
					throw new BizException("您无权复制其它组织的产品");
				}
			}
		}
		String isTpl=xmProduct.getIsTpl();
		XmProduct xmProductTo=new XmProduct();
		BeanUtils.copyProperties(xmProductDb,xmProductTo);
		xmProductTo.setProductName(xmProduct.getProductName());
		xmProductTo.setCode(xmProduct.getCode());
		if(!StringUtils.hasText(xmProduct.getCode())){
			xmProductTo.setCode(createProductCode(user.getBranchId()));
		}
		xmProductTo.setId(this.createProductId(xmProductTo.getCode()));
		xmProductTo.setBranchId(user.getBranchId());
		xmProductTo.setDeptid(user.getDeptid());
		xmProductTo.setDeptName(user.getDeptName());
		xmProductTo.setAdmUserid(user.getUserid());
		xmProductTo.setAdmUsername(user.getUsername());
		xmProductTo.setPmUserid(user.getUserid());
		xmProductTo.setPmUsername(user.getUsername());
		xmProductTo.setCtime(new Date());
		xmProductTo.setPstatus("0");
		xmProductTo.setIsTpl(isTpl);
		xmProductTo.setAssUserid(user.getUserid());
		xmProductTo.setAssUsername(user.getUsername());
		xmProductTo.setBizProcInstId(null);
		xmProductTo.setBizFlowState("0");
		xmProductTo.setLtime(new Date());
		xmProductTo.setDel("0");
		xmProductTo.setLocked("0");
		if(xmProduct.getProductName().equals(xmProductDb.getProductName())){
			xmProductTo.setProductName(xmProduct.getProductName()+"(复制)");
		}
		this.insert(xmProductTo);


		Map<String,String> newPhaseIdMap=new HashMap<>();
		if("1".equals(xmProduct.getCopyPhase())){
			XmPhase phaseQuery=new XmPhase();
			phaseQuery.setProductId(xmProductDb.getId());
			List<XmPhase> xmProjectPhases=this.xmProjectPhaseService.selectListByWhere(phaseQuery);
			if(xmProjectPhases!=null && xmProjectPhases.size()>0){
				for (XmPhase node : xmProjectPhases) {
					String id=this.xmProjectPhaseService.createKey("id");
					newPhaseIdMap.put(node.getId(),id);
				}
				for (XmPhase node : xmProjectPhases) {
					String oldId=node.getId();
					String newId=newPhaseIdMap.get(oldId);
					node.setProjectId(null);
					node.setProductId(xmProductTo.getId());
					node.setId(newId);
					if(StringUtils.hasText(node.getParentId())){
						node.setParentId(newPhaseIdMap.get(node.getParentId()));
					}

					node.setCtime(new Date());
					node.setMngUserid(user.getUserid());
					node.setMngUsername(user.getUsername());
					node.setIsTpl(isTpl);
					node.setBranchId(user.getBranchId());
					node.setBizFlowState("");
					node.setBizProcInstId(null);
				}
				this.xmProjectPhaseService.parentIdPathsCalcBeforeSave(xmProjectPhases);
				this.xmProjectPhaseService.doBatchInsert(xmProjectPhases);
			}

		}
		Map<String,String>	newMenuIdMap=new HashMap<>();
		if("1".equals(xmProduct.getCopyMenu())){
			XmMenu mq=new XmMenu();
			mq.setProductId(xmProduct.getId());
			List<XmMenu> xmMenus=this.xmMenuService.selectListByWhere(mq);

			if(xmMenus!=null && xmMenus.size()>0){
				for (XmMenu node : xmMenus) {
					newMenuIdMap.put(node.getMenuId(),this.xmMenuService.createKey("id"));
				}
				for (XmMenu node : xmMenus) {
					String oldId=node.getMenuId();
					String newId=newMenuIdMap.get(oldId);
					node.setMenuId(newId);
					node.setProductId(xmProductTo.getId());
					node.setPmenuId(newMenuIdMap.get(node.getPmenuId()));
					node.setPhaseId(newPhaseIdMap.get(node.getPhaseId()));
					node.setCtime(new Date());
					node.setMmUserid(user.getUserid());
					node.setMmUsername(user.getUsername());
					node.setIterationId(null);
				}
				this.xmMenuService.parentIdPathsCalcBeforeSave(xmMenus);
				this.xmMenuService.doBatchInsert(xmMenus);
			}
		}

		List<XmGroup> groupsDb=new ArrayList<>();
		Map<String, String> newGroupIdMap = new HashMap<>();
		if( "1".equals(xmProduct.getCopyGroup())||"1".equals(xmProduct.getCopyGroupUser())) {
			XmGroup groupQ = new XmGroup();
			groupQ.setProductId(xmProductDb.getId());
			groupsDb = this.groupService.selectListByWhere(groupQ);
			if (groupsDb != null && groupsDb.size() > 0) {
				for (XmGroup group : groupsDb) {
					newGroupIdMap.put(group.getId(), this.groupService.createKey("id"));
				}
				for (XmGroup node : groupsDb) {
					String oldId = node.getId();
					String newId = newGroupIdMap.get(oldId);
					node.setProductId(xmProductTo.getId());
					node.setId(newId);
					node.setPgroupId(newGroupIdMap.get(node.getPgroupId()));
					node.setBranchId(user.getBranchId());
					node.setProjectId(null);
					node.setCtime(new Date());
					node.setAssUserid(user.getUserid());
					node.setAssUsername(user.getUsername());
					node.setLeaderUserid(user.getUserid());
					node.setLeaderUsername(user.getUsername());
					node.setIsTpl(isTpl);
					node.setPgClass("1");
				}
				this.groupService.parentIdPathsCalcBeforeSave(groupsDb);
				this.groupService.batchInsert(groupsDb);
			}
		}
		if(groupsDb.size()>0 && "1".equals(xmProduct.getCopyGroupUser())){
			XmGroupUser userQ=new XmGroupUser();
			userQ.setProductId(xmProductDb.getId());
			List<XmGroupUser> usersDb=this.groupUserService.selectGroupUserListByProductId(xmProductDb.getId());
			if(usersDb!=null && usersDb.size()>0){
				for (XmGroupUser node : usersDb) {
					node.setProjectId(null);
					node.setProductId(xmProductTo.getId());
					node.setGroupId(newGroupIdMap.get(node.getGroupId()));
					node.setStatus("0");
					node.setJoinTime(new Date());
					node.setPgClass("1");
				}
				this.groupUserService.batchInsert(usersDb);
			}
		}
		xmProduct.setProductName(xmProductDb.getProductName());
		return xmProductTo;
    }

	public String createProductCode(String branchId){
		XmProduct product=new XmProduct();
		product.setBranchId(branchId);
		long count=this.countByWhere(product);
		String seq=(count+1)+"";
		int preLength=6-seq.length();

		if(preLength>0){
			for (int i = 0; i < preLength; i++) {
				seq="0"+seq;
			}
		}
		String code=sequenceService.getCommonNo("pro-{date:yyyyMMdd}-"+seq+"-{rand:2}");
		return code;

	}
	public String createProductId(String code){
		String id=sequenceService.getCommonNo(code+"-{rands:4}");
		XmProduct xmProduct=new XmProduct(id);
		long idcount=this.countByWhere(xmProduct);
		while (idcount>0){
			id=sequenceService.getCommonNo(code+"-{rands:4}");
			xmProduct=new XmProduct(id);
			idcount=this.countByWhere(xmProduct);
		}
		return id;

	}
	@Transactional
	public void doDeleteByPk(XmProduct xmProduct) {
		XmMenu xmMenu=new XmMenu();
		xmMenu.setProductId(xmProduct.getId());
		this.xmMenuService.deleteByWhere(xmMenu);
		super.deleteByPk(xmProduct);
	}

	public void doBatchDelete(List<XmProduct> canDelList) {
		this.xmMenuService.doBatchDeleteByProductIds(canDelList.stream().map(i->i.getId()).collect(Collectors.toList()));
		super.batchDelete(canDelList);
	}

	@Transactional
    public void addProduct(XmProductAddVo xmProduct) {
		super.insert(xmProduct);
		if(xmProduct.getLinks()!=null && xmProduct.getLinks().size()>0){
			linkService.batchInsert(xmProduct.getLinks());
		}
    }
}

