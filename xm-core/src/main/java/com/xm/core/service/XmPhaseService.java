package com.xm.core.service;

import com.mdp.core.entity.Tips;
import com.mdp.core.service.BaseService;
import com.mdp.core.utils.NumberUtil;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmPhase;
import com.xm.core.vo.XmGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectPhase 表 XM.xm_project_phase 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmProjectPhaseService")
public class XmPhaseService extends BaseService {
	
	/** 请在此类添加自定义函数 */

	@Autowired
	XmRecordService xmRecordService;

	@Autowired
    XmGroupService groupService;
	/**
	 * 查询项目及计划总预算，用于判断是否超出预算 
	 */
	public Map<String,Object> selectTotalProjectAndPhaseBudgetCost(String projectId,List<String> excludePhaseIds){
		Map<String,Object> p=new HashMap<>();
		p.put("projectId", projectId); 
		p.put("excludePhaseIds", excludePhaseIds);
		return this.selectOne("selectTotalProjectAndPhaseBudgetCost", p); 
	}
	public Tips checkUserHasQxToOperProjectPhase(String projectId,String mngUserid,String mngUsername,String myUserid){
		Tips tips = new Tips("成功");
		List<XmGroupVo> groupVoList=groupService.getProjectGroupVoList(projectId);
		User user = LoginUtils.getCurrentUserInfo();
		boolean meIsPm=groupService.checkUserIsProjectManager(groupVoList,user.getUserid());
		boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
		if( !meIsPm  && !meIsTeamHead ){
			tips.setFailureMsg("您不是组长、也不是项目管理者，不允许设置计划负责人");
			return tips;
		}
		boolean meIsHisTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,mngUserid,myUserid);
		if(  !meIsPm && !meIsHisTeamHead ){
			tips.setFailureMsg("您不是"+mngUsername+"的组长，不允许设置其为计划负责人");
 			return tips;
		}
		return tips;
	}
	@Transactional
	public int insert(XmPhase parameter) {
		int i= super.insert(parameter);
		if(StringUtils.hasText(parameter.getParentId())){
 			sumParents(parameter);
		}

		return i;
	}


	@Transactional
	public  int deleteByPk(XmPhase parameter) {
		int i= super.deleteByPk(parameter);
		if(StringUtils.hasText(parameter.getParentId())){
			sumParents(parameter);
		}
		return i;
	}

	/**
	 * 判断新增预算是否超出项目总预算
	 * @param projectId
	 * @param addPhaseBudgetCost
	 * @param addBudgetIuserAt
	 * @param addBudgetOuserAt
	 * @param addBudgetNouserAt
	 * @param excludePhaseIds
	 * @return
	 */
	public Tips judgetProjectBudget(String projectId, BigDecimal addPhaseBudgetCost, BigDecimal addBudgetIuserAt, BigDecimal addBudgetOuserAt, BigDecimal addBudgetNouserAt, List<String> excludePhaseIds){
		Tips tips=new Tips("检查预算成功");
		Map<String,Object> g=this.selectTotalProjectAndPhaseBudgetCost(projectId,excludePhaseIds);
		BigDecimal phaseBudgetCost=BigDecimal.ZERO; 
		BigDecimal zero=BigDecimal.ZERO;
		
		if(addPhaseBudgetCost==null) {
			addPhaseBudgetCost=BigDecimal.ZERO;
		}
		if(addBudgetIuserAt==null) {
			addBudgetIuserAt=BigDecimal.ZERO;
		}
		if(addBudgetOuserAt==null) {
			addBudgetOuserAt=BigDecimal.ZERO;
		}
		if(addBudgetNouserAt==null) {
			addBudgetNouserAt=BigDecimal.ZERO;
		}
		if(g==null || g.isEmpty()){

		}
		BigDecimal phaseBudgetIuserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetIuserAt"),zero);
		BigDecimal phaseBudgetOuserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetOuserAt"),zero); 
		BigDecimal phaseBudgetNouserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetNouserAt"),zero); 
		
		BigDecimal planIuserAt=NumberUtil.getBigDecimal(g.get("planIuserAt"),zero);
		BigDecimal planOuserAt=NumberUtil.getBigDecimal(g.get("planOuserAt"),zero); 
		BigDecimal planNouserAt=NumberUtil.getBigDecimal(g.get("planNouserAt"),zero); 
		BigDecimal planTotalCost=NumberUtil.getBigDecimal(g.get("planTotalCost"),zero);

		if(addBudgetIuserAt.add(phaseBudgetIuserAt).compareTo(planIuserAt)>0) {
			tips.setFailureMsg("内部人力预算超出项目内部人力预算"+addBudgetIuserAt.add(phaseBudgetIuserAt).subtract(planIuserAt)+"元");
			return tips;
		}
		if(addBudgetOuserAt.add(phaseBudgetOuserAt).compareTo(planOuserAt)>0) {
			tips.setFailureMsg("外部人力预算超出项目外部人力预算"+addBudgetOuserAt.add(phaseBudgetOuserAt).subtract(planOuserAt)+"元");
			return tips;
		}		
		if(addBudgetNouserAt.add(phaseBudgetNouserAt).compareTo(planNouserAt)>0) {
			tips.setFailureMsg("非人力预算超出项目非人力预算"+addBudgetNouserAt.add(phaseBudgetNouserAt).subtract(planNouserAt)+"元");
			return tips;
		}
		
		BigDecimal phaseBudgetAt=phaseBudgetCost.add(phaseBudgetIuserAt).add(phaseBudgetOuserAt).add(phaseBudgetNouserAt);  
		phaseBudgetAt=phaseBudgetAt.add(addPhaseBudgetCost);
		if(phaseBudgetAt.compareTo(planTotalCost)>0) {
			tips.setFailureMsg("计划总体预算超出项目总预算"+phaseBudgetAt.subtract(planTotalCost)+"元");
			return tips;
		}else {
			return tips;
		} 
		
	}
	@Transactional
	public  int[] doBatchDelete(List<XmPhase> batchValues) {
		int[] result= super.batchDelete(batchValues);
			batchSumParents(batchValues);
			return result;
	}

	public XmPhase autoCalcWorkload(XmPhase phase) {
		BigDecimal phaseBudgetHours=NumberUtil.getBigDecimal(phase.getBudgetHours(),BigDecimal.ZERO);
		BigDecimal phaseBudgetIuserCnt=NumberUtil.getBigDecimal(phase.getBudgetIuserCnt(),BigDecimal.ZERO);
		BigDecimal phaseBudgetOuserCnt=NumberUtil.getBigDecimal(phase.getBudgetOuserCnt(),BigDecimal.ZERO);
		phase.setBudgetIuserWorkload(phaseBudgetIuserCnt.multiply(phaseBudgetHours));
		phase.setBudgetOuserWorkload(phaseBudgetOuserCnt.multiply(phaseBudgetHours));
		phase.setBudgetWorkload(phase.getBudgetIuserWorkload().add(phase.getBudgetOuserWorkload()));
		return phase;
		
	} 
	/**
	 * 计算bug、task、测试案例、等数据
	 * @param projectId
	 * @return
	 */
	public int loadTasksToXmProjectPhase(String projectId) {
		 
		return this.update("loadTasksToXmProjectPhase", projectId);
	}

	/**
	 * 计算bug、task、测试案例、等数据
	 * @param productId
	 * @return
	 */
	public int loadTasksToXmProductPhase(String productId) {

		return this.update("loadTasksToXmProductPhase", productId);
	}
	public Long checkExistsTask(String phaseId) {
		Long i= this.selectOne("checkExistsTask", phaseId);
		return i;
	}
	public void updateChildrenCntByIds(List<String> ids) {
		super.update("updateChildrenCntByIds",ids);
	}

	public void updatePhaseChildrenCntByPhaseId(String phaseId){
		super.update("updatePhaseChildrenCntByPhaseId",phaseId);
	}

	public Long checkExistsChildren(String phaseId) {
		Long i= this.selectOne("checkExistsChildren", phaseId);
		return i;
	}

	/**
	 * 检查是否能删除干净所有儿子孙子节点。
	 * @param delNode 当前删除节点
	 * @param delNodes 本批量需要删除的全部节点
	 * @return
	 */
	public boolean checkCanDelAllChild(XmPhase delNode, List<XmPhase> delNodes) {
		if(delNode==null){
			return true;
		}
		if(delNode.getChildrenCnt()==null||delNode.getChildrenCnt()<=0){
			return true;
		}
		List<XmPhase> childList=delNodes.stream().filter(i->delNode.getId().equals(i.getParentId())).collect(Collectors.toList());
		if(childList==null||childList.size()<delNode.getChildrenCnt()){
			return false;
		}
		for (XmPhase n : childList) {
			if (!this.checkCanDelAllChild(n, delNodes)) {
				return false;
			}
		}
		return true;

	}
	@Transactional
	public void batchInsertOrUpdate(List<XmPhase> inserts, List<XmPhase> updates) {
		List<XmPhase> addList=inserts;
		List<XmPhase> editList=updates;
		List<XmPhase> all=new ArrayList<>();
		if(addList.size()>0) {
			all.addAll(addList);
			this.batchInsert(addList);

		}
		if(editList.size()>0) {
			all.addAll(editList);
			this.batchUpdate(editList);
		}
		this.batchSumParents(all);
	}

    public void calcKeyPaths(String projectId) {

    }

    @Transactional
	public void doBatchInsert(List<XmPhase> xmProjectPhases) {
		for (XmPhase xmProjectPhase : xmProjectPhases) {
			long childrenCnt=xmProjectPhases.stream().filter(i->xmProjectPhase.getId().equals(i.getParentId())).count();
			xmProjectPhase.setChildrenCnt(Integer.valueOf(childrenCnt+""));
			if(childrenCnt>0){
				xmProjectPhase.setNtype("1");
			}
		}
		super.batchInsert(xmProjectPhases);
		batchSumParents(xmProjectPhases);
	}


	public List<XmPhase> parentIdPathsCalcBeforeSave(List<XmPhase> nodes) {
		List<XmPhase> noExistsList=nodes.stream().filter(i->!nodes.stream().filter(k->k.getId().equals(i.getParentId())).findAny().isPresent()).collect(Collectors.toList());
		noExistsList=noExistsList.stream().filter(i->StringUtils.hasText(i.getParentId())).collect(Collectors.toList());
		Map<String,String> hadCalcMap=new HashMap<>();
		for (XmPhase node : noExistsList) {
			if(hadCalcMap.containsKey(node.getParentId())){
				String idPaths=hadCalcMap.get(node.getParentId());
				node.setPidPaths(idPaths+node.getId()+",");
			}else{
				this.parentIdPathsCalcBeforeSave(node);
				String idPaths=node.getPidPaths();
				idPaths=idPaths.substring(0,idPaths.length()-node.getId().length()-1);
				hadCalcMap.put(node.getParentId(),idPaths);
			}
		}
		for (XmPhase node : nodes) {
			if(!StringUtils.hasText(node.getParentId())){
				node.setPidPaths("0,"+node.getId()+",");
				continue;
			}
			if(hadCalcMap.containsKey(node.getParentId())){
				String idPaths=hadCalcMap.get(node.getParentId());
				node.setPidPaths(idPaths+node.getId()+",");
			}else{
				List<XmPhase> pnodeList=this.getParentList(node,nodes);
				if(pnodeList==null ||pnodeList.size()==0){
					node.setPidPaths("0,"+node.getParentId()+","+node.getId()+",");
					continue;
				}
				XmPhase topParent=pnodeList.get(pnodeList.size()-1);
				String idPath="0,";
				if(hadCalcMap.containsKey(topParent.getParentId())){
					idPath=hadCalcMap.get(topParent.getParentId());
				}
				for (int i = pnodeList.size() - 1; i >= 0; i--) {
					idPath=idPath+pnodeList.get(i).getId()+",";
				}
				node.setPidPaths(idPath+node.getId()+",");
			}
		}
		for (XmPhase node : nodes) {
			String idPaths=node.getPidPaths();
			String[] idpss=idPaths.split(",");
			node.setLvl(idpss.length-1);
		}
		return nodes;
	}

	public static void main(String[] args) {
		String idpaths="0,1,2,3,";
		String[] idpss=idpaths.split(",");
		int lvl=idpss.length;

	}

	public Tips parentIdPathsCalcBeforeSave(XmPhase currNode) {
		Tips tips = new Tips("成功");
		if (!StringUtils.hasText(currNode.getParentId()) || "0".equals(currNode.getParentId())) {
			currNode.setPidPaths("0," + currNode.getId() + ",");
			currNode.setLvl(1);
			return tips;
		} else {
			List<XmPhase> parentList=this.getParentList(currNode);
			if(parentList==null ||parentList.size()==0){
				currNode.setPidPaths("0,"+currNode.getParentId()+","+currNode.getId()+",");
				currNode.setLvl(2);
				return tips;
			}
			String idPath="0,";
			for (int i = parentList.size() - 1; i >= 0; i--) {
				idPath=idPath+parentList.get(i).getId()+",";
			}
			currNode.setPidPaths(idPath+currNode.getId()+",");

			String idPaths=currNode.getPidPaths();
			String[] idpss=idPaths.split(",");
			currNode.setLvl(idpss.length-1);
		}
		return tips;
	}

	private List<XmPhase> getParentList(XmPhase currNode){
		List<XmPhase> parentList=new ArrayList<>();
		XmPhase current=currNode;
		while (true){
			if(!StringUtils.hasText(current.getParentId()) || "0".equals(current.getParentId())){
				return parentList;
			}
			XmPhase query=new XmPhase();
			query.setId(current.getParentId());
			current=this.selectOneObject(query);
			if(current==null){
				return parentList;
			}
			parentList.add(current);
		}
	}

	private List<XmPhase> getParentList(XmPhase currNode, List<XmPhase> nodes){
		List<XmPhase> parentList=new ArrayList<>();
		XmPhase current=currNode;
		while (true){
			if(!StringUtils.hasText(current.getParentId()) || "0".equals(current.getParentId())){
				return parentList;
			}
			XmPhase query=new XmPhase();
			query.setId(current.getParentId());
			Optional<XmPhase> optional=nodes.stream().filter(i->i.getId().equals(query.getId())).findFirst();
			if(!optional.isPresent()){
				current=optional.get();
				parentList.add(current);
			}else {
				return parentList;
			}
		}
	}


	@Transactional
	public void sumParents(XmPhase node){
		String id=node.getId();
		String pidPaths=node.getPidPaths();
		if(!StringUtils.hasText(pidPaths)){
			return;
		}
		if(!pidPaths.startsWith("0,")){
			return;
		}
		if("0".equals(node.getNtype())){
			pidPaths=pidPaths.substring(2,pidPaths.indexOf(id));
		}else{
			pidPaths=pidPaths.substring(2);
		}

		if(!StringUtils.hasText(pidPaths)){
			return;
		}
		String[] pidPathss=pidPaths.split(",");
		List<String> pidPathsList=new ArrayList<>();
		for (int i = pidPathss.length-1; i >=0; i--) {
			pidPathsList.add(pidPathss[i]);
		}
		if(pidPathsList.size()>0){
			super.update("sumParents",pidPathsList	);
		}

	}
	@Transactional
	public void batchSumParents(List<XmPhase> xmProjectPhases) {
		List<Set<String>> list=new ArrayList<>();
		for (XmPhase node : xmProjectPhases) {
			String id=node.getId();
			String pidPaths=node.getPidPaths();
			if(!StringUtils.hasText(pidPaths)){
				continue;
			}
			if(!pidPaths.startsWith("0,")){
				continue;
			}
			if("0".equals(node.getNtype())){
				pidPaths=pidPaths.substring(2,pidPaths.indexOf(id));
			}else{
				pidPaths=pidPaths.substring(2);
			}

			if(!StringUtils.hasText(pidPaths)){
				continue;
			}
			String[] pidPathss=pidPaths.split(",");
			for (int i = 0; i <pidPathss.length; i++) {
				if(list.size()<=i){
					list.add(new HashSet<>());
				}
				Set<String> set=list.get(i);
				set.add(pidPathss[i]);
			}
			if(list.size()<=0){
				return;
			}
			Set<String> allSet=new HashSet<>();
			for (int i = list.size() - 1; i >= 0; i--) {
				Set<String> set=list.get(i);
				if(set.size()>0){
					List<String> ids=set.stream().filter(k->!allSet.contains(k)).collect(Collectors.toList());
					if(ids.size()>0){
						allSet.addAll(ids.stream().collect(Collectors.toSet()));
						super.update("batchSumParents", ids);
					}

				}

			}


		}

	}

	@Transactional
	public void editByPk(XmPhase xmProjectPhase) {
		super.updateByPk(xmProjectPhase);
		this.sumParents(xmProjectPhase);
	}


	/**
	 * 判断新增预算是否超出产品总预算
	 * @param productId
	 * @param addPhaseBudgetCost
	 * @param addBudgetIuserAt
	 * @param addBudgetOuserAt
	 * @param addBudgetNouserAt
	 * @param excludePhaseIds
	 * @return
	 */
	public Tips judgetProductBudget(String productId,BigDecimal addPhaseBudgetCost,BigDecimal addBudgetIuserAt,BigDecimal addBudgetOuserAt,BigDecimal addBudgetNouserAt,List<String> excludePhaseIds){
		Tips tips=new Tips("检查预算成功");
		Map<String,Object> g=this.selectTotalProductAndPhaseBudgetCost(productId,excludePhaseIds);
		BigDecimal phaseBudgetCost=BigDecimal.ZERO;
		BigDecimal zero=BigDecimal.ZERO;

		if(addPhaseBudgetCost==null) {
			addPhaseBudgetCost=BigDecimal.ZERO;
		}
		if(addBudgetIuserAt==null) {
			addBudgetIuserAt=BigDecimal.ZERO;
		}
		if(addBudgetOuserAt==null) {
			addBudgetOuserAt=BigDecimal.ZERO;
		}
		if(addBudgetNouserAt==null) {
			addBudgetNouserAt=BigDecimal.ZERO;
		}
		BigDecimal phaseBudgetIuserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetIuserAt"),zero);
		BigDecimal phaseBudgetOuserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetOuserAt"),zero);
		BigDecimal phaseBudgetNouserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetNouserAt"),zero);

		/**
		 *
		 p.pbudget_workload,
		 p.pbudget_amount,
		 p.pmenu_budget_workload,
		 p.pmenu_budget_amount
		 */
		BigDecimal pbudgetWorkload=NumberUtil.getBigDecimal(g.get("pbudgetWorkload"),zero);
		BigDecimal planTotalCost=NumberUtil.getBigDecimal(g.get("pbudgetAmount"),zero);


		BigDecimal phaseBudgetAt=phaseBudgetCost.add(phaseBudgetIuserAt).add(phaseBudgetOuserAt).add(phaseBudgetNouserAt);
		phaseBudgetAt=phaseBudgetAt.add(addPhaseBudgetCost);
		if(phaseBudgetAt.compareTo(planTotalCost)>0) {
			tips.setFailureMsg("计划总体预算超出产品总预算"+phaseBudgetAt.subtract(planTotalCost)+"元");
			return tips;
		}else {
			return tips;
		}

	}

	/**
	 * 查询产品及计划总预算，用于判断是否超出预算
	 */
	public Map<String,Object> selectTotalProductAndPhaseBudgetCost(String productId,List<String> excludePhaseIds){
		Map<String,Object> p=new HashMap<>();
		p.put("productId", productId);
		p.put("excludePhaseIds", excludePhaseIds);
		return this.selectOne("selectTotalProductAndPhaseBudgetCost", p);
	}
	public Map<String,Object> selectPhaseBudgetCost(String phaseId,List<String> excludePhaseIds){
		Map<String,Object> p=new HashMap<>();
		p.put("id", phaseId);
		p.put("excludePhaseIds", excludePhaseIds);
		return this.selectOne("selectPhaseBudgetCost", p);
	}

	public void calcPhaseBudgetAmount(XmPhase phase){
		if(phase.getBudgetIuserAt()==null){
			phase.setBudgetIuserAt(BigDecimal.ZERO);
		}
		if(phase.getBudgetNouserAt()==null){
			phase.setBudgetNouserAt(BigDecimal.ZERO);
		}
		if(phase.getBudgetOuserAt()==null){
			phase.setBudgetOuserAt(BigDecimal.ZERO);
		}
		if(phase.getBudgetAt()==null){
			phase.setBudgetAt(BigDecimal.ZERO);
		}
		phase.setBudgetAt(phase.getBudgetIuserAt().add(phase.getBudgetNouserAt()).add(phase.getBudgetOuserAt()));
	}

	/**
	 * 		res2.id,
	 * 		res2.phase_budget_workload,
	 * 		res2.phase_budget_nouser_at,
	 * 		res2.phase_budget_inner_user_at,
	 * 		res2.phase_budget_out_user_at,
	 * 		res2.phase_budget_at,
	 * 		res0.child_phase_budget_workload,
	 * 		res0.child_phase_budget_nouser_at,
	 * 		res0.child_phase_budget_inner_user_at,
	 * 		res0.child_phase_budget_out_user_at,
	 * 		res0.child_phase_budget_at
	 * @param parentPhaseId
	 * @param phaseBudgetCost
	 * @param phaseBudgetIuserAt
	 * @param phaseBudgetOuserAt
	 * @param phaseBudgetNouserAt
	 * @param excludePhaseIds
	 * @return
	 */
	public Tips judgetPhaseBudget(String parentPhaseId, BigDecimal phaseBudgetCost, BigDecimal phaseBudgetIuserAt, BigDecimal phaseBudgetOuserAt, BigDecimal phaseBudgetNouserAt, List<String> excludePhaseIds) {
		Tips tips= new Tips("检查通过");
		Map<String,Object> phaseBudget=this.selectPhaseBudgetCost(parentPhaseId,excludePhaseIds);
		if(phaseBudget==null || phaseBudget.isEmpty()){
			tips.setFailureMsg("计划不存在");
		}else{
			BigDecimal childBudgetAt=NumberUtil.getBigDecimal(phaseBudget.get("childBudgetAt"),BigDecimal.ZERO);

			BigDecimal phaseBudgetAt=NumberUtil.getBigDecimal(phaseBudget.get("phaseBudgetAt"),BigDecimal.ZERO);

			if(childBudgetAt.add(phaseBudgetCost).compareTo(phaseBudgetAt)>0){
				tips.setFailureMsg("预算金额超出剩余预算金额"+childBudgetAt.add(phaseBudgetCost).subtract(phaseBudgetAt)+"元");
			}
		}
		return tips;
	}

	public int loaMenusToXmProductPhase(String productId) {
		return super.update("loaMenusToXmProductPhase",productId);
	}
}

