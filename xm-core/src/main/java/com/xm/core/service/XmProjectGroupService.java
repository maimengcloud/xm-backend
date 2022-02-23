package com.xm.core.service;

import com.alibaba.fastjson.JSON;
import com.mdp.core.entity.Tips;
import com.mdp.core.service.BaseService;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.*;
import com.xm.core.service.cache.XmProjectGroupCacheService;
import com.xm.core.service.push.XmPushMsgService;
import com.xm.core.vo.XmProjectGroupVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectGroup 表 XM.xm_project_group 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmProjectGroupService")
public class XmProjectGroupService extends BaseService {


	@Autowired
	XmRecordService xmRecordService;
	
    @Autowired
    XmProjectGroupService xmProjectGroupService;

    @Autowired
    XmProjectGroupUserService xmProjectGroupUserService;
    
    @Autowired
    XmProjectGroupCacheService groupCacheService;

	@Autowired
    XmIterationProductLinkService xmIterationProductLinkService;

	@Autowired
	XmProductProjectLinkService xmProductProjectLinkService;

	@Autowired
	private XmProjectService xmProjectService;


	@Autowired
	private XmProductService xmProductService;

    @Autowired
    XmPushMsgService pushMsgService;

	/** 请在此类添加自定义函数 */
	public List<XmProjectGroupVo> getProjectGroupVoList(String projectId) {
		List<XmProjectGroupVo>	groupVoList=new ArrayList<>();
		List<XmProjectGroupVo>	groupVoList2  = groupCacheService.getProjectGroups(projectId);
		if(groupVoList2==null) { 
			
		    XmProjectGroup group = new XmProjectGroup();
		    group.setProjectId(projectId);
		    List<XmProjectGroup> groupList = this.selectListByWhere(group);
		     if(groupList==null || groupList.size()==0) {
		    	 groupCacheService.putProjectGroups(projectId, groupVoList);
		    	 return groupVoList;
		     }
		    List<XmProjectGroupUser> groupUserList=this.xmProjectGroupUserService.selectGroupUserListByProjectId(projectId); 
		    if(groupUserList==null || groupUserList.size()==0) {
		    	 groupCacheService.putProjectGroups(projectId, groupVoList);
		    	 return groupVoList;
		    }
		    groupList.forEach(g -> { 
	            XmProjectGroupVo gvo = new XmProjectGroupVo();
	            BeanUtils.copyProperties(g,gvo);
	            List<XmProjectGroupUser> groupUsers=new ArrayList<>();
	            groupUserList.forEach(gu -> {
	            	if(g.getId().equals(gu.getGroupId())) {
	            		groupUsers.add(gu);
	            	}
	            });
	            gvo.setGroupUsers(groupUsers );
	            groupVoList.add(gvo);
	        });
		    groupCacheService.putProjectGroups(projectId, groupVoList);
		    return groupVoList;
		}else {
			return groupVoList2;
		}
	    
    }

	public boolean checkUserIsProjectAdm(XmProject xmProject,String userid){
		if(xmProject==null){
			return false;
		}
		Map<String,String> map=this.getProjectAdmUsers(xmProject);
		if(map.containsKey(userid)){
			return true;
		}
		return false;
	}
    public boolean checkUserIsProjectAdm(String projectId,String userid){
		XmProject xmProject=xmProjectService.getProjectFromCache(projectId);
		if(xmProject==null){
			return false;
		}
		Map<String,String> map=this.getProjectAdmUsers(xmProject);
		if(map.containsKey(userid)){
			return true;
		}
		return false;
	}

	public boolean checkUserIsProductAdm(XmProduct xmProduct,String userid){
		if(xmProduct==null){
			return false;
		}
		Map<String,String> map=this.getProductAdmUsers(xmProduct);
		if(map.containsKey(userid)){
			return true;
		}
		return false;
	}
	public boolean checkUserIsProductAdm(String productId,String userid){
		XmProduct xmProduct=xmProductService.getProductFromCache(productId);
		if(xmProduct==null){
			return false;
		}
		Map<String,String> map=this.getProductAdmUsers(xmProduct);
		if(map.containsKey(userid)){
			return true;
		}
		return false;
	}
	public List<XmProjectGroupVo> getProductGroupVoList(String productId) {
		List<XmProjectGroupVo>	groupVoList=new ArrayList<>();
		List<XmProjectGroupVo>	groupVoList2  = groupCacheService.getProductGroups(productId);
		if(groupVoList2==null) {

			XmProjectGroup group = new XmProjectGroup();
			group.setProductId(productId);
			List<XmProjectGroup> groupList = this.selectListByWhere(group);
			if(groupList==null || groupList.size()==0) {
				groupCacheService.putProductGroups(productId, groupVoList);
				return groupVoList;
			}
			List<XmProjectGroupUser> groupUserList=this.xmProjectGroupUserService.selectGroupUserListByProductId(productId);
			if(groupUserList==null || groupUserList.size()==0) {
				groupCacheService.putProductGroups(productId, groupVoList);
				return groupVoList;
			}
			groupList.forEach(g -> {
				XmProjectGroupVo gvo = new XmProjectGroupVo();
				BeanUtils.copyProperties(g,gvo);
				List<XmProjectGroupUser> groupUsers=new ArrayList<>();
				groupUserList.forEach(gu -> {
					if(g.getId().equals(gu.getGroupId())) {
						groupUsers.add(gu);
					}
				});
				gvo.setGroupUsers(groupUsers );
				groupVoList.add(gvo);
			});
			groupCacheService.putProductGroups(productId, groupVoList);
			return groupVoList;
		}else {
			return groupVoList2;
		}

	}
	/**
	 * 新增项目时，同时新增项目团队及小组组员等
	 * @param projectId
	 * @param xmProjectGroupVoList
	 */
	@Transactional
	public void addGroups(String projectId,List<XmProjectGroupVo> xmProjectGroupVoList) {
		List<XmProjectGroup> groups=new ArrayList<>();
		List<XmProjectGroupUser> groupUsers=new ArrayList<>();
		for (XmProjectGroupVo xmProjectGroupVo : xmProjectGroupVoList) {
			XmProjectGroup group=new XmProjectGroup();
			xmProjectGroupVo.setId(this.createKey("id"));
			BeanUtils.copyProperties(xmProjectGroupVo, group);
			groups.add(group);
			List<XmProjectGroupUser> groupUsersTemp=xmProjectGroupVo.getGroupUsers();
			if(groupUsersTemp==null || groupUsersTemp.size()==0) {
				continue;
			}else {
				for (XmProjectGroupUser xmProjectGroupUser : groupUsersTemp) {
					xmProjectGroupUser.setGroupId(group.getId());
					xmProjectGroupUser.setJoinTime(new Date());
					xmProjectGroupUser.setStatus("0");
					groupUsers.add(xmProjectGroupUser);
				}
				
			}
		}
		if(groups.size()>0) {
			this.batchInsert(groups);
			User u=LoginUtils.getCurrentUserInfo();

			for (XmProjectGroupVo group : xmProjectGroupVoList) {
				List<XmProjectGroupUser> users=group.getGroupUsers();
				List<Map<String,Object>> umaps=new ArrayList<>();
				for (XmProjectGroupUser xmProjectGroupUser : users) {
					Map<String,Object> u2=new HashMap<>();
					u2.put("userid", xmProjectGroupUser.getUserid());
					u2.put("username", xmProjectGroupUser.getUsername());
					umaps.add(u2);

				}
 				pushMsgService.pushChannelGroupCreateMsg(u.getBranchId(),group.getProjectId(),group.getId(), group.getId(), group.getGroupName(), u.getUserid(), u.getUsername(), umaps,"新增小组["+group.getGroupName()+"]及以下组员："+StringUtils.arrayToDelimitedString(group.getGroupUsers().toArray(), ","));
				if(group.getGroupUsers()!=null && group.getGroupUsers().size()>0) {
					xmRecordService.addXmGroupRecord(projectId, group.getId(),"项目-团队-新增小组", "新增小组["+group.getGroupName()+"]及以下组员："+StringUtils.arrayToDelimitedString(group.getGroupUsers().toArray(), ","),JSON.toJSONString(group),null);

				}else {
					xmRecordService.addXmGroupRecord(projectId, group.getId(),"项目-团队-新增小组", "新增小组["+group.getGroupName()+"]",JSON.toJSONString(group),null);

				}
				
			}
		}
		if(groupUsers.size()>0) {
			xmProjectGroupUserService.batchInsert(groupUsers);
		}
		groupCacheService.putProjectGroups(projectId, null);
	}
    /*
     * 更新项目团队
     * 1.项目管理者、项目创建人可以添加项目小组
     * 2.小组长可以添加本小组成员、清空本小组所有成员
     * 3.项目管理者、创建人可以任意添加删除成员
     * 4.项目管理者、创建人可以调整小组组长
     */
	@Transactional
	public Tips updateGroup(XmProjectGroup group,XmProjectGroup groupDb) {
		Tips tips=new Tips("成功");
		super.updateSomeFieldByPk(group);
		this.sumParents(group);
		return tips;
    }


    public void pushMsg(User user,XmProjectGroup g,List<Map<String,Object>> users){
		pushMsgService.pushChannelGroupCreateMsg(user.getBranchId(),g.getProjectId(),g.getId(), g.getId(), g.getGroupName(), user.getUserid(), user.getUsername(), users,"新增小组["+g.getGroupName()+"]及以下组员："+ users.stream().map(i->(String)i.get("username")).collect(Collectors.joining(",")));

	}

	/**
	 * 获取用户在某个项目中的组
	 * @param projectId
	 * @param userid
	 * @return
	 */
    public List<XmProjectGroupVo> getUserGroupsByProjectId(String projectId, String userid){
    	List<XmProjectGroupVo> xmProjectGroupVoList=this.getProjectGroupVoList(projectId);
    	return this.getUserGroups(xmProjectGroupVoList, userid);
    }
	/**
	 * 获取用户在某个项目中的组
	 * @param productId
	 * @param userid
	 * @return
	 */
	public List<XmProjectGroupVo> getUserGroupsByProductId(String productId, String userid){
		List<XmProjectGroupVo> xmProjectGroupVoList=this.getProductGroupVoList(productId);
		return this.getUserGroups(xmProjectGroupVoList, userid);
	}

	/**
	 * 检查用户是否在一些组中任意个组当组长
	 * @param xmProjectGroupVoList
	 * @param teamHeadUserid
	 * @return
	 */
	public boolean  checkUserIsHeadInGroups( List<XmProjectGroupVo> xmProjectGroupVoList,String teamHeadUserid){
		if(xmProjectGroupVoList==null || xmProjectGroupVoList.size()==0)return false;
		if(!StringUtils.hasText(teamHeadUserid)){
			return false;
		}
		for (XmProjectGroupVo xmProjectGroupVo : xmProjectGroupVoList) {
			if(teamHeadUserid.equals(xmProjectGroupVo.getLeaderUserid())){
				return true;
			}

		}
		return false;
	}

	/**
	 * 检查用户是否在指定的小组中做组长
	 * @param xmProjectGroupVoList
	 * @param groupId
	 * @param teamHeadUserid
	 * @return
	 */
	public boolean  checkUserIsHeadInGroup( List<XmProjectGroupVo> xmProjectGroupVoList,String groupId,String teamHeadUserid){
		if(xmProjectGroupVoList==null || xmProjectGroupVoList.size()==0)return false;
		if(!StringUtils.hasText(teamHeadUserid)){
			return false;
		}
		if(!StringUtils.hasText(groupId)){
			return false;
		}

		for (XmProjectGroupVo xmProjectGroupVo : xmProjectGroupVoList) {
			if(groupId.equals(xmProjectGroupVo.getId())){
				 if(teamHeadUserid.equals(xmProjectGroupVo.getLeaderUserid())){
				 	return true;
				 }
			}
		}
		return false;
	}
    public List<XmProjectGroupVo> getUserGroups(List<XmProjectGroupVo> xmProjectGroupVoList, String userid){
     	List<XmProjectGroupVo> userGroups=new ArrayList<>();
     	if(xmProjectGroupVoList==null) {
     		return userGroups;
     	}
		for (XmProjectGroupVo g : xmProjectGroupVoList) {
			if(userid.equals(g.getLeaderUserid())||userid.equals(g.getAssUserid())){
				userGroups.add(g);
			}else{
				List<XmProjectGroupUser> gus=g.getGroupUsers();
				boolean exists=false;
				if(gus==null) {
					continue;
				}
				for (XmProjectGroupUser gu : gus) {
					if(userid.equals(gu.getUserid())) {
						exists=true;
						break;
					}
				}
				if(exists) {
					userGroups.add(g);

				}
			}
		}
    	return userGroups;
    }
    public boolean  checkUserExistsGroup(String projectId,String userid){
    	List<XmProjectGroupVo> userGroups= getUserGroupsByProjectId(projectId,userid);
    	return userGroups!=null && userGroups.size()>0;
    }
	/**
	 * 检查某个人是否为指定的小组的组长
	 * @param xmProjectGroupVo
	 * @param headUserid
	 * @return
	 */
	public boolean checkUserIsTeamHead(XmProjectGroupVo xmProjectGroupVo, String headUserid){
		if(xmProjectGroupVo==null){
			return false;
		}
		if(headUserid.equals(xmProjectGroupVo.getLeaderUserid())){
			return true;
		}
		return false;

	}
	/**
	 * 检查某个人是否为指定的小组的组长\副组长\助理
	 * @param xmProjectGroupVo
	 * @param headUserid
	 * @return
	 */
	public boolean checkUserIsTeamHeadOrAss(XmProjectGroupVo xmProjectGroupVo, String headUserid){
		if(xmProjectGroupVo==null){
			return false;
		}
		if(headUserid.equals(xmProjectGroupVo.getLeaderUserid())||headUserid.equals(xmProjectGroupVo.getAssUserid())){
			return true;
		}
		return false;

	}
    /**
     * 检查某个人是否另外一个人的组长
     * @param xmProjectGroupVoList
     * @param memUserid
     * @param headUserid
     * @return
     */
    public boolean checkUserIsOtherUserTeamHead(List<XmProjectGroupVo> xmProjectGroupVoList, String memUserid, String headUserid){
    	if(xmProjectGroupVoList==null || xmProjectGroupVoList.size()==0) {
    		return false;
    	}
    	
    	List<XmProjectGroupVo> userGroups=this.getUserGroups(xmProjectGroupVoList, memUserid);
    	if(userGroups==null || userGroups.size()==0) {
    		return false;
    	}
    	for (XmProjectGroupVo ug : userGroups) {
    		if(headUserid.equals(ug.getLeaderUserid())){
    			return true;
			}
    	}
    	return false;
    }

	/**
	 * 检查某个人是否另外一个人的组长
	 * @param xmProjectGroupVoList
	 * @param memUserid
	 * @param headUserid
	 * @return
	 */
	public boolean checkUserIsOtherUserTeamHeadOrAss(List<XmProjectGroupVo> xmProjectGroupVoList, String memUserid, String headUserid){
		if(xmProjectGroupVoList==null || xmProjectGroupVoList.size()==0) {
			return false;
		}

		List<XmProjectGroupVo> userGroups=this.getUserGroups(xmProjectGroupVoList, memUserid);
		if(userGroups==null || userGroups.size()==0) {
			return false;
		}
		for (XmProjectGroupVo ug : userGroups) {
			if(headUserid.equals(ug.getLeaderUserid())||headUserid.equals(ug.getAssUserid())){
				return true;
			}
		}
		return false;
	}
  public  List<XmProjectGroupUser> getProjectManagers( List<XmProjectGroupVo> xmProjectGroupVoList){
    	for (XmProjectGroupVo g : xmProjectGroupVoList) {
    		if("nbxmjl".equals(g.getPgTypeId())) {
    			return g.getGroupUsers();
    		}
        	
		}
		return null;
    	
    }



	/**
	 * 检测某个用户是否属于项目组的内部管理团队成员，内部管理组成员
	 * @param xmProjectGroupVoList
	 * @param pmUserid
	 * @return
	 */
  public boolean checkUserIsProjectManager( List<XmProjectGroupVo> xmProjectGroupVoList ,String pmUserid) {
	  if(xmProjectGroupVoList==null || xmProjectGroupVoList.size()==0) {
		  return false;
	  }
  	List<XmProjectGroupUser> getProjectManagers=this.getProjectManagers(xmProjectGroupVoList);
	  if(getProjectManagers==null || getProjectManagers.size()==0) {
		  return false;
	  }
  	for (XmProjectGroupUser user : getProjectManagers) {
		if( user.getUserid().equals(pmUserid)) {
			return true;
		}
    	
	}
  	return false;
  }


	public List<XmProjectGroupVo> getProjectGroupVoListByIterationId(String iterationId) {

		List<XmProductProjectLink> list=this.xmProductProjectLinkService.selectListByIterationId(iterationId);
		List<XmProjectGroupVo> datas=new ArrayList<>();
		if(list!=null && list.size()>0){
			for (XmProductProjectLink productProjectLink : list) {
				List<XmProjectGroupVo> data0=this.getProjectGroupVoList(productProjectLink.getProjectId());
				if(data0!=null && data0.size()>0){
					datas.addAll(data0);
				}
			}
		}
		return datas;
	}

	/**
	 * 根据产品编号查询团队
	 * @param productId
	 * @return
	 */
	public List<XmProjectGroupVo> getProjectGroupVoListByProductId(String productId) {
		List<XmProjectGroupVo> data0=this.getProductGroupVoList(productId);
		return data0;
	}



	public List<XmProjectGroup> parentIdPathsCalcBeforeSave(List<XmProjectGroup> nodes) {
		List<XmProjectGroup> noExistsList=nodes.stream().filter(i->!nodes.stream().filter(k->k.getId().equals(i.getPgroupId())).findAny().isPresent()).collect(Collectors.toList());
		noExistsList=noExistsList.stream().filter(i->StringUtils.hasText(i.getPgroupId())).collect(Collectors.toList());
		Map<String,String> hadCalcMap=new HashMap<>();
		for (XmProjectGroup node : noExistsList) {
			if(hadCalcMap.containsKey(node.getPgroupId())){
				String idPaths=hadCalcMap.get(node.getPgroupId());
				node.setPidPaths(idPaths+node.getId()+",");
			}else{
				this.parentIdPathsCalcBeforeSave(node);
				String idPaths=node.getPidPaths();
				idPaths=idPaths.substring(0,idPaths.length()-node.getId().length()-1);
				hadCalcMap.put(node.getPgroupId(),idPaths);
			}
		}
		for (XmProjectGroup node : nodes) {
			if(!StringUtils.hasText(node.getPgroupId())){
				node.setPidPaths("0,"+node.getId()+",");
				continue;
			}
			if(hadCalcMap.containsKey(node.getPgroupId())){
				String idPaths=hadCalcMap.get(node.getPgroupId());
				node.setPidPaths(idPaths+node.getId()+",");
			}else{
				List<XmProjectGroup> pnodeList=this.getParentList(node,nodes);
				if(pnodeList==null ||pnodeList.size()==0){
					node.setPidPaths("0,"+node.getPgroupId()+","+node.getId()+",");
					continue;
				}
				XmProjectGroup topParent=pnodeList.get(pnodeList.size()-1);
				String idPath="0,";
				if(hadCalcMap.containsKey(topParent.getPgroupId())){
					idPath=hadCalcMap.get(topParent.getPgroupId());
				}
				for (int i = pnodeList.size() - 1; i >= 0; i--) {
					idPath=idPath+pnodeList.get(i).getId()+",";
				}
				node.setPidPaths(idPath+node.getId()+",");
			}
		}
		for (XmProjectGroup node : nodes) {
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

	public Tips checkProjectStatus(XmProject xmProject){
		Tips tips=new Tips("成功");
		if(xmProject==null){
			tips.setFailureMsg("prj-0","项目已不存在");
		} else if("4".equals(xmProject.getStatus())){
			tips.setFailureMsg("prj-status-4","项目暂停中，不能操作");
		} else if("9".equals(xmProject.getStatus())){
			tips.setFailureMsg("prj-status-9","项目已关闭，不能操作");
		}
		return tips;
	}
	public Tips checkHasProjectEditQx(User user,XmProject xmProject){
 		Tips tips=new Tips("成功");
		Map<String,String> pmUserMap=new HashMap<>();
		pmUserMap.put(xmProject.getCreateUserid(),xmProject.getCreateUsername());
		pmUserMap.put(xmProject.getPmUserid(),xmProject.getPmUsername());
		pmUserMap.put(xmProject.getAdmUserid(),xmProject.getAdmUsername());
		pmUserMap.put(xmProject.getAssUserid(),xmProject.getAssUsername());
		if(!pmUserMap.containsKey(user.getUserid())){
			tips.setFailureMsg("no-project-edit-qx","您不是项目【"+xmProject.getName()+"】的管理人员，无权修改项目信息。");
		}
		return tips;
	}
	public Tips checkProductStatus( XmProduct xmProductDb) {
		Tips tips=new Tips("成功");
		if(xmProductDb==null){
			tips.setFailureMsg("product-0","产品已不存在");
		} else if("3".equals(xmProductDb.getPstatus())){
			tips.setFailureMsg("pstatus-3","产品已经关闭，不能再操作");
		}
		return tips;
	}

	public Map<String,String> getProductAdmUsers(XmProduct xmProductDb){

		Map<String,String> proUsersMap=new HashMap<>();
		proUsersMap.put(xmProductDb.getPmUserid(),xmProductDb.getPmUsername());
		proUsersMap.put(xmProductDb.getAssUserid(),xmProductDb.getAssUserid());
		proUsersMap.put(xmProductDb.getAdmUserid(),xmProductDb.getAdmUserid());
		return proUsersMap;
	}
	public Tips checkHasProductEditQx(User user,XmProduct xmProductDb) {
		Tips tips=new Tips("成功");
		Map<String,String> proUsersMap=this.getProductAdmUsers(xmProductDb);
		if(!proUsersMap.containsKey(user.getUserid())){
			tips.setFailureMsg("no-product-edit-qx","您不是产品【"+xmProductDb.getProductName()+"】的管理人员，无权修改产品信息。");
		}
		return tips;
	}

	public Tips checkHasEditProdcutGroupQx(User user,XmProjectGroup group,XmProjectGroup groupDb,XmProduct xmProductDb){
		Tips tips = new Tips("成功");
		if(groupDb==null){
			tips.setFailureMsg("data-0","该小组已不存在");
			return tips;
		}
		Map<String,String> proUsersMap=this.getProductAdmUsers(xmProductDb);

			if(StringUtils.hasText(group.getAssUserid()) && !group.getAssUserid().equals(groupDb.getAssUserid())){
				if(!proUsersMap.containsKey(user.getUserid()) && !user.getUserid().equals(groupDb.getLeaderUserid())){
					tips.setFailureMsg("no-qx-change-pro-g-assUserid","您无权限修改小组助理.组长及以上人员可以修改。");
				}
			}
			if(StringUtils.hasText(group.getLeaderUserid()) && !group.getLeaderUserid().equals(groupDb.getLeaderUserid())){
				if(!proUsersMap.containsKey(user.getUserid())){
					tips.setFailureMsg("no-qx-change-pro-g-leaderUserid","您无权限修改小组组长.产品级助理及以上人员可以修改。");
				}
			}
			if(StringUtils.hasText(group.getPgroupId()) && !group.getPgroupId().equals(groupDb.getPgroupId())){
				if(!proUsersMap.containsKey(user.getUserid())){
					tips.setFailureMsg("no-qx-change-g-pgroupId","您无权限修改小组归属上级单位.产品级助理及以上人员可以修改。");
				}
			}
		return tips;
	}

	public Map<String,String> getProjectAdmUsers(XmProject xmProject){
		Map<String,String> pmUserMap=new HashMap<>();
		pmUserMap.put(xmProject.getCreateUserid(),xmProject.getCreateUsername());
		pmUserMap.put(xmProject.getPmUserid(),xmProject.getPmUsername());
		pmUserMap.put(xmProject.getAdmUserid(),xmProject.getAdmUsername());
		pmUserMap.put(xmProject.getAssUserid(),xmProject.getAssUsername());
		return pmUserMap;
	}
	public Tips checkHasEditProjectGroupQx(User user,XmProjectGroup group,XmProjectGroup groupDb,XmProject xmProject){
		Tips tips = new Tips("成功");
		if(groupDb==null){
			tips.setFailureMsg("data-0","该小组已不存在");
			return tips;
		}

		Map<String,String> pmUserMap=this.getProjectAdmUsers(xmProject);
			if(!pmUserMap.containsKey(user.getUserid())){
				if(!user.getUserid().equals(groupDb.getLeaderUserid()) && !user.getUserid().equals(groupDb.getAssUserid())){
					tips.setFailureMsg("not-prj-group-adm-user","您无权修改小组信息。 组长助理及以上人员有权限修改。");
					return tips;
				}
			}
			if(StringUtils.hasText(group.getAssUserid()) && !group.getAssUserid().equals(groupDb.getAssUserid())){
				if(!pmUserMap.containsKey(user.getUserid()) && !user.getUserid().equals(groupDb.getLeaderUserid())){
					tips.setFailureMsg("no-qx-change-prj-g-assUserid","您无权限修改小组助理.组长及以上人员可以修改。");
					return tips;
				}
			}
			if(StringUtils.hasText(group.getLeaderUserid()) && !group.getLeaderUserid().equals(groupDb.getLeaderUserid())){
				if(!pmUserMap.containsKey(user.getUserid())){
					tips.setFailureMsg("no-qx-change-prj-g-leaderUserid","您无权限修改小组组长.项目级助理及以上人员可以修改。");
					return tips;
				}
			}
			if(StringUtils.hasText(group.getPgroupId()) && !group.getPgroupId().equals(groupDb.getPgroupId())){
				if(!pmUserMap.containsKey(user.getUserid())){
					tips.setFailureMsg("no-qx-change-prj-g-pgroupId","您无权限修改小组归属上级单位.项目级助理及以上人员可以修改。");
					return tips;
				}
			}

		return tips;
	}

	public Tips parentIdPathsCalcBeforeSave(XmProjectGroup currNode) {
		Tips tips = new Tips("成功");
		if (!StringUtils.hasText(currNode.getPgroupId()) || "0".equals(currNode.getPgroupId())) {
			currNode.setPidPaths("0," + currNode.getId() + ",");
			return tips;
		} else {
			List<XmProjectGroup> parentList=this.getParentList(currNode);
			if(parentList==null ||parentList.size()==0){
				currNode.setPidPaths("0,"+currNode.getPgroupId()+","+currNode.getId()+",");
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

	private List<XmProjectGroup> getParentList(XmProjectGroup currNode){
		List<XmProjectGroup> parentList=new ArrayList<>();
		XmProjectGroup current=currNode;
		while (true){
			if(!StringUtils.hasText(current.getPgroupId()) || "0".equals(current.getPgroupId())){
				return parentList;
			}
			XmProjectGroup query=new XmProjectGroup();
			query.setId(current.getPgroupId());
			current=this.selectOneObject(query);
			if(current==null){
				return parentList;
			}
			parentList.add(current);
		}
	}

	private List<XmProjectGroup> getParentList(XmProjectGroup currNode,List<XmProjectGroup> nodes){
		List<XmProjectGroup> parentList=new ArrayList<>();
		XmProjectGroup current=currNode;
		while (true){
			if(!StringUtils.hasText(current.getPgroupId()) || "0".equals(current.getPgroupId())){
				return parentList;
			}
			XmProjectGroup query=new XmProjectGroup();
			query.setId(current.getPgroupId());
			Optional<XmProjectGroup> optional=nodes.stream().filter(i->i.getId().equals(query.getId())).findFirst();
			if(optional.isPresent()){
				current=optional.get();
				parentList.add(current);
			}else{
				return parentList;
			}

		}
	}


	@Transactional
	public void sumParents(XmProjectGroup node){
		String id=node.getId();
		String pidPaths=node.getPidPaths();
		if(!StringUtils.hasText(pidPaths)){
			return;
		}
		if(!pidPaths.startsWith("0,")){
			return;
		}
		if("0".equals(node.getNtype())&&pidPaths.endsWith(id+",")){
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
	public void batchSumParents(List<XmProjectGroup> xmTasks) {
		List<Set<String>> list=new ArrayList<>();
		for (XmProjectGroup node : xmTasks) {
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


	/**
	 * 检查是否能删除干净所有儿子孙子节点。
	 * @param delNode 当前删除节点
	 * @param delNodes 本批量需要删除的全部节点
	 * @return
	 */
	public boolean checkCanDelAllChild(XmProjectGroup delNode, List<XmProjectGroup> delNodes) {
		if(delNode==null){
			return true;
		}
		if(delNode.getChildrenCnt()==null||delNode.getChildrenCnt()<=0){
			return true;
		}
		List<XmProjectGroup> childList=delNodes.stream().filter(i->delNode.getId().equals(i.getPgroupId())).collect(Collectors.toList());
		if(childList==null||childList.size()<delNode.getChildrenCnt()){
			return false;
		}
		for (XmProjectGroup n : childList) {
			if (!this.checkCanDelAllChild(n, delNodes)) {
				return false;
			}
		}
		return true;

	}

	@Transactional
	public void doDeleteByPk(XmProjectGroup xmProjectGroup,XmProjectGroup groupDb) {
		super.deleteByPk(xmProjectGroup);
		this.sumParents(groupDb);
	}

	public List<XmProjectGroup> selectListByIds(List<String> ids) {
		return super.selectList("selectListByIds",ids);
	}

	@Transactional
	public void doBatchDeleteProductGroups(List<XmProjectGroup> canDelNodes) {
		super.batchDelete(canDelNodes);
		batchSumParents(canDelNodes);
	}

	@Transactional
	public void doBatchDeleteProjectGroups(List<XmProjectGroup> canDelNodes) {
		super.batchDelete(canDelNodes);
		batchSumParents(canDelNodes);
	}

	public XmProjectGroupVo getProductGroupFromCache(String productId, String groupId) {
		XmProjectGroupVo groupVo=groupCacheService.getProductGroup(productId,groupId);
		if(groupVo==null){
			XmProjectGroup group=this.selectOneObject(new XmProjectGroup(groupId));
			if(group==null){
				return null;
			}else{
				XmProjectGroupUser xmProjectGroupUser=new XmProjectGroupUser();
				xmProjectGroupUser.setGroupId(groupId);
				List<XmProjectGroupUser> users=this.xmProjectGroupUserService.selectListByWhere(xmProjectGroupUser);
				XmProjectGroupVo xmProjectGroupVo=new XmProjectGroupVo();
				BeanUtils.copyProperties(group,xmProjectGroupVo);
				xmProjectGroupVo.setGroupUsers(users);
				this.groupCacheService.putProductGroup(xmProjectGroupVo);
				return xmProjectGroupVo;
			}
		}else {
			return groupVo;
		}
	}
}

