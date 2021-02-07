package com.xm.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.Monitor.Guard;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.xm.core.entity.XmProjectGroupUser;
import com.xm.core.service.cache.XmProjectGroupCacheService;
import com.xm.core.service.push.XmPushMsgService;
import com.xm.core.vo.XmProjectGroupVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdp.core.service.BaseService;
import com.mdp.safe.common.entity.User;
import com.mdp.safe.common.utils.LoginUtils;
import com.xm.core.entity.XmProject;
import com.xm.core.entity.XmProjectGroup;
import org.springframework.util.StringUtils;

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
    //更新项目团队
    public List<XmProjectGroupVo> updateGroup(String projectId,List<XmProjectGroupVo> xmProjectGroupVoList) { 
	    XmProjectGroup group = new XmProjectGroup();
	    group.setProjectId(projectId);
	    List<XmProjectGroup> groupListDb = this.selectListByWhere(group);
	    List<XmProjectGroup> delGroups=new ArrayList<>();
		User user=LoginUtils.getCurrentUserInfo();
		XmProject project = xmProjectService.getProjectFromCache(projectId);   
		List<XmProjectGroupVo>  projectGroupVos=this.getProjectGroupVoList(projectId); 
		 List<XmProjectGroupVo>  myGroupVos=this.getUserGroups(projectGroupVos, user.getUserid());

 		boolean isProjectCreate=user.getUserid().equals(project.getCreateUserid()); 
		boolean isPm = this.checkUserIsProjectManager(projectGroupVos, user.getUserid()); 
		 
	    //查出需要删除的组进行删除组及关联组成员
	    groupListDb.forEach(g->{  
	    	
	    	if(xmProjectGroupVoList.stream().noneMatch(new Predicate<XmProjectGroupVo>() {

				@Override
				public boolean test(XmProjectGroupVo t) {
					 if(t.getGroupName().equals(g.getGroupName())) {
						 t.setId(g.getId());
						 return true;
					 }else {
						 return false;
					 } 
				}
			})) {
	    		delGroups.add(g);
	    	}
	    	
	    });
	    if(delGroups.size()>0) {

	    	if(!isProjectCreate) {
	    		if(!isPm) {
	    			throw new BizException("你既不是项目创建人，也不是项目经理，不允许删除项目小组，项目创建人为【"+project.getCreateUsername()+"】");
	    		}
	    	}
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
	    		xmProjectGroupVoAdd.add(vo);
	    	}else {
	    		xmProjectGroupVoEdit.add(vo);
	    	}
	    });
    	List<XmProjectGroupUser> allUsersFromUi=new ArrayList<>();

	    if(xmProjectGroupVoAdd.size()>0) {
	    	if(!isProjectCreate) {
	    		if(!isPm) {
	    			throw new BizException("你不是项目创建人,也不是项目经理，不允许新增该项目的小组,项目创建人为【"+project.getCreateUsername()+"】");
	    		}
	    	}
	    	 
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
        if(xmProjectGroupVoEdit.size()>0) { 
        	xmProjectGroupVoEdit.forEach(gvo -> {
 
	            gvo.setProjectId(projectId);
	            XmProjectGroup g = new XmProjectGroup();
	            BeanUtils.copyProperties(gvo,g);
	            xmProjectGroupService.updateSomeFieldByPk(g);

	            List<XmProjectGroupUser> guser = gvo.getGroupUsers();
	            if( guser !=null && guser.size()>0) {
	            	for (XmProjectGroupUser guser2 : guser) {
						guser2.setGroupId(gvo.getId());
						guser2.setProjectId(projectId);
						allUsersFromUi.add(guser2);
					} 
	            }
	            
	            if(guser==null || guser.size()==0) {
	            	if(!isProjectCreate) {
	    	    		if(!isPm) {
	    	    			
	    	    			throw new BizException("你不是项目创建人,也不是项目经理，不允许清空【"+gvo.getGroupName()+"】整个小组所有成员");
	    	    		}
	    	    	}
	    	    	 
	            	XmProjectGroupUser userDel = new XmProjectGroupUser();
	                userDel.setGroupId(gvo.getId());
	            	int i=xmProjectGroupUserService.delete("deleteByGroupId",userDel);
	            	if(i>0) { 
		            	xmRecordService.addXmGroupRecord(projectId,gvo.getId(), "项目-团队-删除小组成员", "删除小组["+gvo.getGroupName()+"]中所有组员["+i+"]个",JSON.toJSONString(gvo),null); 
	            	}
	            }
	        }); 
        	
        	if(allUsersFromUi.size()>0) {
        		List<XmProjectGroupUser> groupUserList=this.xmProjectGroupUserService.selectGroupUserListByProjectId(projectId); 
        		List<XmProjectGroupUser> allUsersAdd=new ArrayList<>();
        		List<XmProjectGroupUser> allUsersDel=new ArrayList<>(); 
        		List<XmProjectGroupUser> allUsersEdit=new ArrayList<>();
	            //找出新增的用户插入
	            //找出删除的用户进行删除
        		
        		allUsersFromUi.forEach(gu->{
        			boolean existsInDb=false;
        			XmProjectGroupUser currDbUser=null;
        			for (XmProjectGroupUser t : groupUserList) {
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
        				allUsersAdd.add(gu);
        			}else {
        				if(currDbUser.getIsHead()!=null && gu.getIsHead() !=null ) {
        					if(!currDbUser.getIsHead().equals(gu.getIsHead())) {
        						currDbUser.setIsHead(gu.getIsHead());
                				allUsersEdit.add(currDbUser);
        					} 
        				}else if(currDbUser.getIsHead()==null && gu.getIsHead() !=null ) {
    						currDbUser.setIsHead(gu.getIsHead());
            				allUsersEdit.add(currDbUser);
        				}else if(currDbUser.getIsHead()==null && gu.getIsHead() ==null ) {

    						currDbUser.setIsHead("0");
            				allUsersEdit.add(currDbUser);
        				}
        				
        			} 
        		}); 
        		groupUserList.forEach(gu->{
        			if(allUsersFromUi.stream().noneMatch(new Predicate<XmProjectGroupUser>() {

						@Override
						public boolean test(XmProjectGroupUser t) {
							// TODO Auto-generated method stub
							return t.getGroupId().equals(gu.getGroupId()) && t.getUserid().equals(gu.getUserid());
						}
        				
					})) {
        				allUsersDel.add(gu);
        			}
        		});
        		if(allUsersAdd.size()>0) {
        			for (XmProjectGroupUser gu : allUsersAdd) {
        		    	if(!isProjectCreate) {
        		    		if(!isPm) {
        		    			boolean isHead=false;
        		    			for (XmProjectGroupVo g : myGroupVos) {
									if(g.getId().equals(gu.getGroupId())) {
										List<XmProjectGroupUser> myGus=g.getGroupUsers();
										if(myGus!=null && myGus.size()>0) {
											for (XmProjectGroupUser mgu : myGus) {
												if(mgu.getUserid().equals(user.getUserid())) {
													if("1".equals(mgu.getIsHead())) {
														isHead=true;
														break;
													}
												}
											}
										}
 									}
									if(isHead) {
										break;
									}
								}
        		    			if(!isHead) {
        		    				throw new BizException("你既不是项目创建人，也不是项目经理，也不是组长，不允许增加小组成员");
        		    			}
        		    			
        		    		}
        		    	}
					}
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
        			for (XmProjectGroupUser gu : allUsersDel) {
        		    	if(!isProjectCreate) {
        		    		if(!isPm) {
        		    			boolean isHead=false;
        		    			for (XmProjectGroupVo g : myGroupVos) {
									if(g.getId().equals(gu.getGroupId())) {
										List<XmProjectGroupUser> myGus=g.getGroupUsers();
										if(myGus!=null && myGus.size()>0) {
											for (XmProjectGroupUser mgu : myGus) {
												if(mgu.getUserid().equals(user.getUserid())) {
													if("1".equals(mgu.getIsHead())) {
														isHead=true;
														break;
													}
												}
											}
										}
 									}
									if(isHead) {
										break;
									}
								}
        		    			if(!isHead) {
        		    				throw new BizException("你既不是项目创建人，也不是项目经理，也不是组长，不允许删除小组成员");
        		    			}
        		    			
        		    		}
        		    	}
					}
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
	            	if(!isProjectCreate) {
	    	    		if(!isPm) { 
	    	    			throw new BizException("你不是项目创建人,也不是项目经理，不能调整组长");
	    	    		}
	    	    	}
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

        return xmProjectGroupVoList;
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
    	return userGroups.size()>0;
    }
    
    /**
     * 检查某个人是否另外一个人的组长
     * @param xmProjectGroupVoList
     * @param memUserid
     * @param headUserid
     * @return
     */
    public boolean  checkUserIsHead( List<XmProjectGroupVo> xmProjectGroupVoList,String memUserid,String headUserid){
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
  
  public boolean checkUserIsProjectManager( List<XmProjectGroupVo> xmProjectGroupVoList ,String headUserid) {
	  if(xmProjectGroupVoList==null || xmProjectGroupVoList.size()==0) {
		  return false;
	  }
  	List<XmProjectGroupUser> getProjectManagers=this.getProjectManagers(xmProjectGroupVoList);
	  if(getProjectManagers==null || getProjectManagers.size()==0) {
		  return false;
	  }
  	for (XmProjectGroupUser user : getProjectManagers) {
		if( user.getUserid().equals(headUserid)) {
			return true;
		}
    	
	}
  	return false;
  }
	
}

