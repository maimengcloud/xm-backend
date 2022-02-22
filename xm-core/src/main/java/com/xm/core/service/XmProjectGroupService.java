package com.xm.core.service;

import com.alibaba.fastjson.JSON;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.service.BaseService;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.*;
import com.xm.core.service.cache.XmProjectGroupCacheService;
import com.xm.core.service.push.XmPushMsgService;
import com.xm.core.vo.XmProjectGroupVo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Predicate;
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
    XmPushMsgService pushMsgService;

	/** 请在此类添加自定义函数 */
	public List<XmProjectGroupVo> getProjectGroupVoList(String projectId) { 
		List<XmProjectGroupVo>	groupVoList=new ArrayList<>();
		List<XmProjectGroupVo>	groupVoList2  = groupCacheService.getGroups(projectId);
		if(groupVoList2==null) { 
			
		    XmProjectGroup group = new XmProjectGroup();
		    group.setProjectId(projectId);
		    List<XmProjectGroup> groupList = this.selectListByWhere(group);
		     if(groupList==null || groupList.size()==0) {
		    	 groupCacheService.putGroups(projectId, groupVoList);
		    	 return groupVoList;
		     }
		    List<XmProjectGroupUser> groupUserList=this.xmProjectGroupUserService.selectGroupUserListByProjectId(projectId); 
		    if(groupUserList==null || groupUserList.size()==0) {
		    	 groupCacheService.putGroups(projectId, groupVoList);
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
		    groupCacheService.putGroups(projectId, groupVoList);
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
		groupCacheService.putGroups(projectId, null);
	}
    /*
     * 更新项目团队
     * 1.项目管理者、项目创建人可以添加项目小组
     * 2.小组长可以添加本小组成员、清空本小组所有成员
     * 3.项目管理者、创建人可以任意添加删除成员
     * 4.项目管理者、创建人可以调整小组组长
     */
	@Transactional
	public Tips updateGroup(String projectId,List<XmProjectGroupVo> xmProjectGroupVoList) {
	    XmProjectGroup group = new XmProjectGroup();
	    group.setProjectId(projectId);
	    List<XmProjectGroup> groupListDb = this.selectListByWhere(group);
	    List<XmProjectGroup> delGroups=new ArrayList<>();
		User user=LoginUtils.getCurrentUserInfo();
		XmProject project = xmProjectService.getProjectFromCache(projectId);   
		List<XmProjectGroupVo>  projectGroupVos=this.getProjectGroupVoList(projectId);
		Map<String,XmProjectGroupVo> groupVoMap=new HashMap<>();
		if(projectGroupVos!=null && projectGroupVos.size()>0){
			for (XmProjectGroupVo projectGroupVo : projectGroupVos) {
				groupVoMap.put(projectGroupVo.getId(),projectGroupVo);
			}
		}
		List<String> tipsList=new ArrayList<>();

 		boolean isProjectCreate=user.getUserid().equals(project.getCreateUserid()); 
		boolean isPm = this.checkUserIsProjectManager(projectGroupVos, user.getUserid());
		boolean isHeadPm=this.checkUserIsHeadProjectManager(projectGroupVos,user.getUserid());
		 
	    //查出需要删除的组进行删除组及关联组成员
	    groupListDb.forEach(g->{  
	    	
	    	if(xmProjectGroupVoList.stream().noneMatch(new Predicate<XmProjectGroupVo>() {

				@Override
				public boolean test(XmProjectGroupVo t) {
					 if(t.getGroupName().equals(g.getGroupName())) {
						 t.setId(g.getId());
						 t.setPgTypeId(g.getPgTypeId());
						 t.setPgTypeName(g.getPgTypeName());
						 return true;
					 }else {

						 return false;
					 } 
				}
			})) {
				if(!isProjectCreate) {
					if(!isPm) {

						throw new BizException("无权操作！只有项目创建人、项目管理者可以删除小组");
					}
				}
				if("nbxmjl".equals(g.getPgTypeId())  ){
					throw new BizException("无权操作！"+g.getGroupName()+"小组性质属于"+g.getPgTypeName()+"，永远不能删除。");
				}
	    		delGroups.add(g);
	    	}
	    	
	    });

	    
	    //查询新增的组进行增加并添加组成员,同时查出修改的组进行更新组及成员
	    List<XmProjectGroupVo> xmProjectGroupVoAdd=new ArrayList<>();
	    List<XmProjectGroupVo> xmProjectGroupVoEdit=new ArrayList<>();
	    xmProjectGroupVoList.forEach(vo->{
	    	if(groupListDb.stream().noneMatch(new Predicate<XmProjectGroup>() {
				@Override
				public boolean test(XmProjectGroup t) {
					return t.getGroupName().equals(vo.getGroupName());
				}
			})) {
				if( isProjectCreate || isPm ) {
					xmProjectGroupVoAdd.add(vo);
				}else{
					throw new BizException("您无权操作！只有项目创建人、项目管理人员可创建小组");
				}
	    	}else {
	    		xmProjectGroupVoEdit.add(vo);
	    	}
	    });
    	List<XmProjectGroupUser> allUsersFromUi=new ArrayList<>();


        if(xmProjectGroupVoEdit.size()>0) {
        	xmProjectGroupVoEdit.forEach(gvo -> {
	            gvo.setProjectId(projectId);
	            XmProjectGroup g = new XmProjectGroup();
	            BeanUtils.copyProperties(gvo,g);
	            //xmProjectGroupService.updateSomeFieldByPk(g);
	            List<XmProjectGroupUser> guser = gvo.getGroupUsers();
	            if( guser !=null && guser.size()>0) {
	            	for (XmProjectGroupUser guser2 : guser) {
						guser2.setGroupId(gvo.getId());
						allUsersFromUi.add(guser2);
					} 
	            }
	        });
        	
        	if(allUsersFromUi.size()>0) {
        		List<XmProjectGroupUser> groupUserDbList=this.xmProjectGroupUserService.selectGroupUserListByProjectId(projectId);
        		List<XmProjectGroupUser> allUsersAdd=new ArrayList<>();
        		List<XmProjectGroupUser> allUsersDel=new ArrayList<>(); 
        		List<XmProjectGroupUser> allUsersEdit=new ArrayList<>();
	            //找出新增的用户插入
	            //找出删除的用户进行删除
        		
        		allUsersFromUi.forEach(gu->{
        			boolean existsInDb=false;
        			XmProjectGroupUser currDbUser=null;
        			for (XmProjectGroupUser t : groupUserDbList) {
						if(t.getGroupId().equals(gu.getGroupId()) && t.getUserid().equals(gu.getUserid())) {
							existsInDb=true;
							currDbUser=t;
							break;
						}
					}
        			if(!existsInDb) {
						gu.setJoinTime(new Date());
						gu.setStatus("0");
        				if(isPm || isProjectCreate ){ //项目创建者、管理者平躺
							allUsersAdd.add(gu);
						}else{
        					//小组长可以添加人，但是不能设置组长
        					if(!gu.getUserid().equals(user.getUserid())){//不允许自己加自己
								XmProjectGroupVo xmProjectGroupVo = groupVoMap.get(gu.getGroupId());
								if (this.checkUserIsTeamHead(xmProjectGroupVo, user.getUserid())) {
									allUsersAdd.add(gu);
								}else{
									tipsList.add(gu.getUsername()+"添加到小组"+xmProjectGroupVo.getGroupName()+"不成功！只有项目创建人、管理者、组长可以添加人员。");
								}
							}else{
								tipsList.add("普通用户不允许自己添加自己");
							}
						}

        			}else {
        				if(!StringUtils.hasText(currDbUser.getIsHead())){
							currDbUser.setIsHead("0");
						}
						if(!StringUtils.hasText(gu.getIsHead())){
							gu.setIsHead("0");
						}
						if(!currDbUser.getIsHead().equals(gu.getIsHead())){
							//需要判断我是不是项目创建者、管理者，如果不是则无权利去指定小组组长
							XmProjectGroupVo xmProjectGroupVo = groupVoMap.get(gu.getGroupId());
								if("nbxmjl".equals(xmProjectGroupVo.getPgTypeId())){
									if(isProjectCreate || isHeadPm ){
										currDbUser.setIsHead(gu.getIsHead());
										allUsersEdit.add(currDbUser);
									}else{
										tipsList.add(currDbUser.getUsername()+"组长身份变更被忽略，只有项目创建者、项目经理可以变更项目经理身份");
									}

								}else{
									if(isPm || isProjectCreate){
										currDbUser.setIsHead(gu.getIsHead());
										allUsersEdit.add(currDbUser);
									}else{
										tipsList.add(currDbUser.getUsername()+"组长身份变更被忽略，只有项目创建者、管理者可以变更组长身份");
									}
								}


						}
        			} 
        		}); 
        		groupUserDbList.forEach(gu->{
        			if(allUsersFromUi.stream().noneMatch(new Predicate<XmProjectGroupUser>() {
						@Override
						public boolean test(XmProjectGroupUser t) {
 							return t.getGroupId().equals(gu.getGroupId()) && t.getUserid().equals(gu.getUserid());
						}
        				
					})) {
        				// 普通用户不允许删除任何人包括自己，组长可以删除小组除了自己外所有人员。项目创建人、管理者可以删除任何人
						 if(isProjectCreate || isPm || isHeadPm ){
							 XmProjectGroupVo xmProjectGroupVo = groupVoMap.get(gu.getGroupId());
							if(!gu.getUserid().equals(user.getUserid())){
								if("nbxmjl".equals(xmProjectGroupVo.getPgTypeId())){
									if(isHeadPm || isProjectCreate ){
										allUsersDel.add(gu);
									}else{
										tipsList.add(gu.getUsername()+"移出小组"+xmProjectGroupVo.getGroupName()+"不成功，只有项目经理、项目创建者可以把其他管理者请出内部管理组");
									}
								}else{
									allUsersDel.add(gu);
								}
							}else{

								if("nbxmjl".equals(xmProjectGroupVo.getPgTypeId())){
									tipsList.add("项目管理者不允许把自己从内部项目经理组中删除");
								}else{
									allUsersDel.add(gu);
								}
							}
						}else{
							if(!gu.getUserid().equals(user.getUserid())) {//删除自己也是不可以的
								XmProjectGroupVo xmProjectGroupVo = groupVoMap.get(gu.getGroupId());
								if (this.checkUserIsTeamHead(xmProjectGroupVo, user.getUserid())) {
									allUsersDel.add(gu);
								}else{
									tipsList.add("您不是"+gu.getUsername()+"组长，无权将其移出小组"+xmProjectGroupVo.getGroupName()+"!");
								}
							}else{
								tipsList.add("普通用户不允许删除自己");
							}
						}

        			}
        		});




        		if(allUsersAdd.size()>0) {
        			xmProjectGroupUserService.batchInsert(allUsersAdd); 
        			allUsersAdd.forEach(u->{
        				Map<String,Object> usermap=new HashMap<>();
        				usermap.put("userid", u.getUserid());
        				usermap.put("username", u.getUsername());
        				List<Map<String,Object>> users=new ArrayList<>();
        				users.add(usermap);
        				pushMsgService.pushJoinChannelGroupMsg(user.getBranchId(), u.getGroupId(), users);
        				xmRecordService.addXmGroupRecord(projectId,u.getGroupId(), "项目-团队-新增小组成员", "增加组员["+u.getUsername()+"]",u.getUserid(),null); 
        			});
        			
	            	
        		}
        		if(allUsersDel.size()>0) {
        			xmProjectGroupUserService.batchDelete(allUsersDel);
        			allUsersDel.forEach(u->{
        				Map<String,Object> usermap=new HashMap<>();
        				usermap.put("userid", u.getUserid());
        				usermap.put("username", u.getUsername());
        				List<Map<String,Object>> users=new ArrayList<>();
        				users.add(usermap);
        				pushMsgService.pushLeaveChannelGroupMsg(user.getBranchId(), u.getGroupId(), users);
        				xmRecordService.addXmGroupRecord(projectId,u.getGroupId(), "项目-团队-删除小组成员", "删除组员["+u.getUsername()+"]",u.getUserid(),null); 
        			}); 

        		} 
        		if(allUsersEdit.size()>0) {
            		List<XmProjectGroupUser> allUsersEdit2=new ArrayList<>();
        			allUsersEdit.forEach(u->{
        				XmProjectGroupUser u2=new XmProjectGroupUser();
        				allUsersEdit2.add(u2);
        				xmProjectGroupUserService.updateSomeFieldByPk(u2);
        				xmRecordService.addXmGroupRecord(projectId, u2.getGroupId(),"项目-团队-变更小组成员状态", "变更["+u.getUsername()+"]为 "+("0".equals(u2.getIsHead())?"普通组员":"组长"),u2.getUserid(),null); 
        			});  
        		} 
        		
        	}
        }

		if(delGroups.size()>0) {
			delGroups.forEach(g->{

				XmProjectGroupUser UserDel = new XmProjectGroupUser();
				UserDel.setGroupId(g.getId());
				xmProjectGroupUserService.delete("deleteByGroupId",UserDel);
				XmProjectGroup delGroup=new XmProjectGroup();
				delGroup.setId(g.getId());
				this.deleteByPk(delGroup);
				pushMsgService.pushChannelGroupRemoveMsg(user.getBranchId(), g.getId());
				xmRecordService.addXmGroupRecord(projectId, g.getId(),"项目-团队-删除小组", "删除小组["+g.getGroupName()+"]",g.getId(),null);
			});

		}
		if(xmProjectGroupVoAdd.size()>0) {
			xmProjectGroupVoAdd.forEach(gvo -> {
				gvo.setId(xmProjectGroupService.createKey("id"));
				gvo.setProjectId(projectId);
				XmProjectGroup g = new XmProjectGroup();
				BeanUtils.copyProperties(gvo,g);
				xmProjectGroupService.insert(g);
				List<XmProjectGroupUser> guser = gvo.getGroupUsers();
				List<String> addGroupUsernames=new ArrayList<>();
				List<Map<String,Object>> users=new ArrayList<>();
				if(guser != null && guser.size() > 0) {
					guser.forEach(u -> {
						Map<String,Object> userMap=new HashMap<>();
						userMap.put("userid", u.getUserid());
						userMap.put("username", u.getUsername());
						users.add(userMap);
						u.setGroupId(gvo.getId());
						u.setJoinTime(new Date());
						u.setStatus("0");
						addGroupUsernames.add(u.getUsername());
						xmProjectGroupUserService.insert(u);
						allUsersFromUi.add(u);
					});
				}
				pushMsgService.pushChannelGroupCreateMsg(user.getBranchId(),g.getProjectId(),g.getId(), g.getId(), g.getGroupName(), user.getUserid(), user.getUsername(), users,"新增小组["+gvo.getGroupName()+"]及以下组员："+StringUtils.arrayToDelimitedString(addGroupUsernames.toArray(), ","));

				xmRecordService.addXmGroupRecord(projectId, gvo.getId(),"项目-团队-新增小组", "新增小组["+gvo.getGroupName()+"]及以下组员："+StringUtils.arrayToDelimitedString(addGroupUsernames.toArray(), ","),JSON.toJSONString(gvo),null);

			});
		}
		groupCacheService.putGroups(projectId, null);

        Tips tips=new Tips("全部更新成功");
        if(tipsList.size()>0){
        	String tipsMsg=StringUtils.arrayToDelimitedString(tipsList.toArray(),";");
        	tips.setOkMsg("更新成功，但是有部分更新被忽略，原因如下："+tipsMsg);
        	return tips;
		}else{
        	return tips;
		}
    }

	/**
	 * 获取用户在某个项目中的组
	 * @param projectId
	 * @param userid
	 * @return
	 */
    public List<XmProjectGroupVo>  getUserGroups(String projectId,String userid){
    	List<XmProjectGroupVo> xmProjectGroupVoList=this.getProjectGroupVoList(projectId);
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
			List<XmProjectGroupUser> gus=xmProjectGroupVo.getGroupUsers();
			if(gus==null) {
				continue;
			}
			for (XmProjectGroupUser gu : gus) {
				if(teamHeadUserid.equals(gu.getUserid()) && "1".equals(gu.getIsHead())) {
					 return true;
				}
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
				List<XmProjectGroupUser> gus=xmProjectGroupVo.getGroupUsers();
				if(gus==null) {
					continue;
				}
				for (XmProjectGroupUser gu : gus) {
					if(teamHeadUserid.equals(gu.getUserid()) && "1".equals(gu.getIsHead())) {
						return true;
					}
				}
			}
		}
		return false;
	}
    public List<XmProjectGroupVo>  getUserGroups( List<XmProjectGroupVo> xmProjectGroupVoList,String userid){
     	List<XmProjectGroupVo> userGroups=new ArrayList<>();
     	if(xmProjectGroupVoList==null) {
     		return userGroups;
     	}
    	for (XmProjectGroupVo xmProjectGroupVo : xmProjectGroupVoList) {
    		List<XmProjectGroupUser> gus=xmProjectGroupVo.getGroupUsers();
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
				userGroups.add(xmProjectGroupVo);

    		}
		}
    	return userGroups;
    }
    public boolean  checkUserExistsGroup(String projectId,String userid){
    	List<XmProjectGroupVo> userGroups=getUserGroups(projectId,userid);
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
		List<XmProjectGroupUser> gus= xmProjectGroupVo.getGroupUsers();
		if(gus==null || gus.size()==0){
			return false;
		}
		for (XmProjectGroupUser guser : gus) {
			if(guser.getUserid().equals(headUserid)) {
				if("1".equals(guser.getIsHead())) {
					return true;
				}
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
    public boolean checkUserIsOtherUserTeamHead(List<XmProjectGroupVo> xmProjectGroupVoList, String memUserid, String headUserid){
    	if(xmProjectGroupVoList==null || xmProjectGroupVoList.size()==0) {
    		return false;
    	}
    	
    	List<XmProjectGroupVo> userGroups=this.getUserGroups(xmProjectGroupVoList, memUserid);
    	if(userGroups==null || userGroups.size()==0) {
    		return false;
    	}
    	boolean isHead=false;
    	for (XmProjectGroupVo ug : userGroups) {
    	
    		List<XmProjectGroupUser> gus= ug.getGroupUsers();
    		for (XmProjectGroupUser guser : gus) {
    			if(guser.getUserid().equals(headUserid)) {
    				if("1".equals(guser.getIsHead())) {
    					isHead=true;
    					break;
    				}
    			}
    		}
    		if(isHead) {
    			break;
    		}
    	}
    	return isHead;
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
	 * 找到项目管理者
	 * @param xmProjectGroupVoList
	 * @return
	 */
	public XmProjectGroupUser getHeadProjectManager( List<XmProjectGroupVo> xmProjectGroupVoList){
    	List<XmProjectGroupUser> getProjectManagers=this.getProjectManagers(xmProjectGroupVoList);
    	if(getProjectManagers==null || getProjectManagers.size()==0) {
    		return null;
    	}
    	for (XmProjectGroupUser user : getProjectManagers) {
    		if( "1".equals(user.getIsHead())) {
    			return user;
    		}
        	
		}
		return null;
    }

	/**
	 * 检测某个用户是否项目管理者
	 * @param xmProjectGroupVoList
	 * @param headPmUserid
	 * @return
	 */
	public boolean checkUserIsHeadProjectManager( List<XmProjectGroupVo> xmProjectGroupVoList,String headPmUserid){
		 XmProjectGroupUser groupUser=this.getHeadProjectManager(xmProjectGroupVoList);
		 if(groupUser!=null){
		 	if(groupUser.getUserid().equals(headPmUserid)){
		 		return true;
			}
		 }
		 return false;
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
		XmProductProjectLink xmProductProjectLink=new XmProductProjectLink();
		xmProductProjectLink.setProductId(productId);
		List<XmProductProjectLink> list=this.xmProductProjectLinkService.selectListByWhere(xmProductProjectLink);
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


	public boolean checkExistsExecuser(XmProjectGroup node) {
		String exec=node.getExeUserids();
		if(!StringUtils.hasText(exec)){
			return false;
		}
		if(exec.indexOf("(1)")>0 || exec.indexOf("(2)")>0|| exec.indexOf("(3)")>0|| exec.indexOf("(4)")>0|| exec.indexOf("(5)")>0){
			return true;
		}
		return false;
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
}

