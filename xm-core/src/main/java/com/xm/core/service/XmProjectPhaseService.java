package com.xm.core.service;

import com.mdp.core.entity.Tips;
import com.mdp.core.service.BaseService;
import com.mdp.core.utils.NumberUtil;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmProjectPhase;
import com.xm.core.entity.XmProjectPhase;
import com.xm.core.entity.XmTask;
import com.xm.core.vo.XmProjectGroupVo;
import com.xm.core.vo.XmProjectPhaseVo;
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
public class XmProjectPhaseService extends BaseService {
	
	/** 请在此类添加自定义函数 */

	@Autowired
	XmRecordService xmRecordService;

	@Autowired
	XmProjectGroupService groupService;
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
		List<XmProjectGroupVo> groupVoList=groupService.getProjectGroupVoList(projectId);
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
	public int insert(XmProjectPhase parameter) {
		int i= super.insert(parameter);
		if(StringUtils.hasText(parameter.getParentPhaseId())){
			this.updatePhaseChildrenCntByPhaseId(parameter.getParentPhaseId());
			sumParents(parameter);
		}

		return i;
	}


	@Transactional
	public  int deleteByPk(XmProjectPhase parameter) {
		int i= super.deleteByPk(parameter);
		if(StringUtils.hasText(parameter.getParentPhaseId())){
			this.updatePhaseChildrenCntByPhaseId(parameter.getParentPhaseId());
			sumParents(parameter);
		}
		return i;
	}

	/**
	 * 判断新增预算是否超出项目总预算
	 * @param projectId
	 * @param addPhaseBudgetCost
	 * @param addPhaseBudgetInnerUserAt
	 * @param addPhaseBudgetOutUserAt
	 * @param addPhaseBudgetNouserAt
	 * @param excludePhaseIds
	 * @return
	 */
	public Tips judgetBudget(String projectId,BigDecimal addPhaseBudgetCost,BigDecimal addPhaseBudgetInnerUserAt,BigDecimal addPhaseBudgetOutUserAt,BigDecimal addPhaseBudgetNouserAt,List<String> excludePhaseIds){
		Tips tips=new Tips("检查预算成功");
		Map<String,Object> g=this.selectTotalProjectAndPhaseBudgetCost(projectId,excludePhaseIds);
		BigDecimal phaseBudgetCost=BigDecimal.ZERO; 
		BigDecimal zero=BigDecimal.ZERO;
		
		if(addPhaseBudgetCost==null) {
			addPhaseBudgetCost=BigDecimal.ZERO;
		}
		if(addPhaseBudgetInnerUserAt==null) {
			addPhaseBudgetInnerUserAt=BigDecimal.ZERO;
		}
		if(addPhaseBudgetOutUserAt==null) {
			addPhaseBudgetOutUserAt=BigDecimal.ZERO;
		}
		if(addPhaseBudgetNouserAt==null) {
			addPhaseBudgetNouserAt=BigDecimal.ZERO;
		}
		if(g==null || g.isEmpty()){

		}
		BigDecimal phaseBudgetInnerUserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetInnerUserAt"),zero);
		BigDecimal phaseBudgetOutUserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetOutUserAt"),zero); 
		BigDecimal phaseBudgetNouserAt=NumberUtil.getBigDecimal(g.get("phaseBudgetNouserAt"),zero); 
		
		BigDecimal planInnerUserAt=NumberUtil.getBigDecimal(g.get("planInnerUserAt"),zero);
		BigDecimal planOutUserAt=NumberUtil.getBigDecimal(g.get("planOutUserAt"),zero); 
		BigDecimal planNouserAt=NumberUtil.getBigDecimal(g.get("planNouserAt"),zero); 
		BigDecimal planTotalCost=NumberUtil.getBigDecimal(g.get("planTotalCost"),zero);

		if(addPhaseBudgetInnerUserAt.add(phaseBudgetInnerUserAt).compareTo(planInnerUserAt)>0) {
			tips.setFailureMsg("内部人力预算超出项目内部人力预算"+addPhaseBudgetInnerUserAt.add(phaseBudgetInnerUserAt).subtract(planInnerUserAt)+"元");
			return tips;
		}
		if(addPhaseBudgetOutUserAt.add(phaseBudgetOutUserAt).compareTo(planOutUserAt)>0) {
			tips.setFailureMsg("外部人力预算超出项目外部人力预算"+addPhaseBudgetOutUserAt.add(phaseBudgetOutUserAt).subtract(planOutUserAt)+"元");
			return tips;
		}		
		if(addPhaseBudgetNouserAt.add(phaseBudgetNouserAt).compareTo(planNouserAt)>0) {
			tips.setFailureMsg("非人力预算超出项目非人力预算"+addPhaseBudgetNouserAt.add(phaseBudgetNouserAt).subtract(planNouserAt)+"元");
			return tips;
		}
		
		BigDecimal phaseBudgetCostAt=phaseBudgetCost.add(phaseBudgetInnerUserAt).add(phaseBudgetOutUserAt).add(phaseBudgetNouserAt);  
		phaseBudgetCostAt=phaseBudgetCostAt.add(addPhaseBudgetCost);
		if(phaseBudgetCostAt.compareTo(planTotalCost)>0) {
			tips.setFailureMsg("计划总体预算超出项目总预算"+phaseBudgetCostAt.subtract(planTotalCost)+"元");
			return tips;
		}else {
			return tips;
		} 
		
	}
	@Transactional
	public  int[] doBatchDelete(List<XmProjectPhase> batchValues) {
		int[] result= super.batchDelete(batchValues);

		List<XmProjectPhase> list= batchValues.stream().filter(i->!batchValues.stream().filter(k->k.getId().equals(i.getParentPhaseId())).findAny().isPresent()).collect(Collectors.toList());
		list=list.stream().filter(i-> StringUtils.hasText(i.getParentPhaseId())).collect(Collectors.toList());
		if(list.size()>0){
			this.updateChildrenCntByIds(list.stream().map(i->i.getParentPhaseId()).collect(Collectors.toSet()).stream().collect(Collectors.toList()));
			batchSumParents(batchValues);
		}
		return result;
	}

	public XmProjectPhase autoCalcWorkload(XmProjectPhase phase) {
		BigDecimal phaseBudgetHours=NumberUtil.getBigDecimal(phase.getPhaseBudgetHours(),BigDecimal.ZERO);
		BigDecimal phaseBudgetInnerUserCnt=NumberUtil.getBigDecimal(phase.getPhaseBudgetInnerUserCnt(),BigDecimal.ZERO);
		BigDecimal phaseBudgetOutUserCnt=NumberUtil.getBigDecimal(phase.getPhaseBudgetOutUserCnt(),BigDecimal.ZERO);
		phase.setPhaseBudgetInnerUserWorkload(phaseBudgetInnerUserCnt.multiply(phaseBudgetHours));
		phase.setPhaseBudgetOutUserWorkload(phaseBudgetOutUserCnt.multiply(phaseBudgetHours));
		phase.setPhaseBudgetWorkload(phase.getPhaseBudgetInnerUserWorkload().add(phase.getPhaseBudgetOutUserWorkload()));
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

	@Transactional
	public void batchInsertOrUpdate(List<XmProjectPhaseVo> xmProjectPhases) {
		List<XmProjectPhaseVo> addList=new ArrayList<>();
		List<XmProjectPhaseVo> editList=new ArrayList<>();
		for (XmProjectPhaseVo vo : xmProjectPhases) {
			if("addSub".equals(vo.getOpType())||"add".equals(vo.getOpType())) {
				addList.add(vo);
			}else {
				editList.add(vo);
			}
		}
		if(addList.size()>0) {
			this.batchInsert(addList);

		}

		if(editList.size()>0) {
			this.batchUpdate(editList);
		}

		List<String> ids=new ArrayList<>();
		List<XmProjectPhase> list= xmProjectPhases.stream().filter(i->!xmProjectPhases.stream().filter(k->k.getId().equals(i.getParentPhaseId())).findAny().isPresent()).collect(Collectors.toList());
		list=list.stream().filter(i->StringUtils.hasText(i.getParentPhaseId())).collect(Collectors.toList());
		ids=list.stream().map(i->i.getParentPhaseId()).collect(Collectors.toList());
		ids=ids.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
		if(list.size()>0){
			this.updateChildrenCntByIds(ids);
		}
		this.batchSumParents(xmProjectPhases.stream().map(i->(XmProjectPhase)i).collect(Collectors.toList()));
	}

    public void calcKeyPaths(String projectId) {

    }

    @Transactional
	public void doBatchInsert(List<XmProjectPhase> xmProjectPhases) {
		for (XmProjectPhase xmProjectPhase : xmProjectPhases) {
			long childrenCnt=xmProjectPhases.stream().filter(i->xmProjectPhase.getId().equals(i.getParentPhaseId())).count();
			xmProjectPhase.setChildrenCnt(Integer.valueOf(childrenCnt+""));
			if(childrenCnt>0){
				xmProjectPhase.setNtype("1");
			}
		}
		super.batchInsert(xmProjectPhases);
		List<XmProjectPhase> list= xmProjectPhases.stream().filter(i->!xmProjectPhases.stream().filter(k->k.getId().equals(i.getParentPhaseId())).findAny().isPresent()).collect(Collectors.toList());
		list=list.stream().filter(i->StringUtils.hasText(i.getParentPhaseId())).collect(Collectors.toList());
		if(list.size()>0){
			this.updateChildrenCntByIds(list.stream().map(i->i.getParentPhaseId()).collect(Collectors.toSet()).stream().collect(Collectors.toList()));
		}
		batchSumParents(xmProjectPhases);
	}


	public List<XmProjectPhase> parentIdPathsCalcBeforeSave(List<XmProjectPhase> nodes) {
		List<XmProjectPhase> noExistsList=nodes.stream().filter(i->!nodes.stream().filter(k->k.getId().equals(i.getParentPhaseId())).findAny().isPresent()).collect(Collectors.toList());
		noExistsList=noExistsList.stream().filter(i->StringUtils.hasText(i.getParentPhaseId())).collect(Collectors.toList());
		Map<String,String> hadCalcMap=new HashMap<>();
		for (XmProjectPhase node : noExistsList) {
			if(hadCalcMap.containsKey(node.getParentPhaseId())){
				String idPaths=hadCalcMap.get(node.getParentPhaseId());
				node.setPidPaths(idPaths+node.getId()+",");
			}else{
				this.parentIdPathsCalcBeforeSave(node);
				String idPaths=node.getPidPaths();
				idPaths=idPaths.substring(0,idPaths.length()-node.getId().length()-1);
				hadCalcMap.put(node.getParentPhaseId(),idPaths);
			}
		}
		for (XmProjectPhase node : nodes) {
			if(!StringUtils.hasText(node.getParentPhaseId())){
				node.setPidPaths("0,");
				continue;
			}
			if(hadCalcMap.containsKey(node.getParentPhaseId())){
				String idPaths=hadCalcMap.get(node.getParentPhaseId());
				node.setPidPaths(idPaths+node.getId()+",");
			}else{
				List<XmProjectPhase> pnodeList=this.getParentList(node,nodes);
				XmProjectPhase topParent=pnodeList.get(pnodeList.size()-1);
				String idPath="0,";
				if(hadCalcMap.containsKey(topParent.getParentPhaseId())){
					idPath=hadCalcMap.get(topParent.getParentPhaseId());
				}
				for (int i = pnodeList.size() - 1; i >= 0; i--) {
					idPath=idPath+pnodeList.get(i).getId()+",";
				}
				node.setPidPaths(idPath+node.getId()+",");
			}
		}
		for (XmProjectPhase node : nodes) {
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

	public Tips parentIdPathsCalcBeforeSave(XmProjectPhase currNode) {
		Tips tips = new Tips("成功");
		if (!StringUtils.hasText(currNode.getParentPhaseId()) || "0".equals(currNode.getParentPhaseId())) {
			currNode.setPidPaths("0," + currNode.getId() + ",");
			return tips;
		} else {
			List<XmProjectPhase> parentList=this.getParentList(currNode);
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

	private List<XmProjectPhase> getParentList(XmProjectPhase currNode){
		List<XmProjectPhase> parentList=new ArrayList<>();
		XmProjectPhase current=currNode;
		while (true){
			if(!StringUtils.hasText(currNode.getParentPhaseId()) || "0".equals(currNode.getParentPhaseId())){
				return parentList;
			}
			XmProjectPhase query=new XmProjectPhase();
			query.setId(current.getParentPhaseId());
			current=this.selectOneObject(query);
			if(current==null){
				return parentList;
			}
			parentList.add(current);
		}
	}

	private List<XmProjectPhase> getParentList(XmProjectPhase currNode,List<XmProjectPhase> nodes){
		List<XmProjectPhase> parentList=new ArrayList<>();
		XmProjectPhase current=currNode;
		while (true){
			if(!StringUtils.hasText(currNode.getParentPhaseId()) || "0".equals(currNode.getParentPhaseId())){
				return parentList;
			}
			XmProjectPhase query=new XmProjectPhase();
			query.setId(current.getParentPhaseId());
			current=nodes.stream().filter(i->i.getId().equals(query.getId())).findFirst().get();
			if(current==null){
				return parentList;
			}
			parentList.add(current);
		}
	}


	@Transactional
	public void sumParents(XmProjectPhase node){
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
	public void batchSumParents(List<XmProjectPhase> xmTasks) {
		List<Set<String>> list=new ArrayList<>();
		for (XmProjectPhase node : xmTasks) {
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
			Set<String> allSet=new HashSet<>();
			for (int i = list.size() - 1; i >= 0; i--) {
				allSet.addAll(list.get(i));
			}
			if(allSet.size()>0){
				super.update("sumParents",allSet.stream().collect(Collectors.toList()));
			}


		}

	}
}

