package com.xm.core.service;

import com.alibaba.fastjson.JSON;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.service.BaseService;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmProject;
import com.xm.core.entity.XmProjectGroup;
import com.xm.core.entity.XmProjectGroupUser;
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
					xmProjectGroupUser.setId(xmProjectGroupUserService.createKey("id"));
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
						guser2.setProjectId(projectId);
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
						gu.setId(this.createKey("id"));
						gu.setProjectId(projectId);
						gu.setJoinTime(new Date());
						gu.setStatus("0");
        				if(isPm || isProjectCreate ){ //项目创建者、管理者平躺
							allUsersAdd.add(gu);
						}else{
        					//小组长可以添加人，但是不能设置组长
        					if(!gu.getUserid().equals(user.getUserid())){//不允许自己加自己
								XmProjectGroupVo xmProjectGroupVo = groupVoMap.get(gu.getGroupId());
								if (this.checkUserIsTeamHead(xmProjectGroupVo, user.getUserid())) {
									gu.setIsHead("0");
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
								u.setId(xmProjectGroupUserService.createKey("id"));
								u.setGroupId(gvo.getId());
								u.setProjectId(projectId);
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
        				u2.setId(u.getId());
        				u2.setIsHead(u.getIsHead());
        				allUsersEdit2.add(u2);
        				xmProjectGroupUserService.updateSomeFieldByPk(u2);
        				xmRecordService.addXmGroupRecord(projectId, u2.getGroupId(),"项目-团队-变更小组成员状态", "变更["+u.getUsername()+"]为 "+("0".equals(u2.getIsHead())?"普通组员":"组长"),u2.getUserid(),null); 
        			});  
        		} 
        		
        	}
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
    
    public List<XmProjectGroupVo>  getUserGroups(String projectId,String userid){
    	List<XmProjectGroupVo> xmProjectGroupVoList=this.getProjectGroupVoList(projectId);
    	return this.getUserGroups(xmProjectGroupVoList, userid);
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
	
}

