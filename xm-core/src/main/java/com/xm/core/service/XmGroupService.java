package com.xm.core.service;

import com.mdp.core.entity.Tips;
import com.mdp.safe.client.entity.Dept;
import com.mdp.safe.client.entity.User;
import com.xm.core.entity.XmProduct;
import com.xm.core.entity.XmProject;
import com.xm.core.service.client.SysClient;
import com.xm.core.service.push.XmPushMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectGroup 表 XM.xm_group 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmGroupService")
public class XmGroupService  {


	@Autowired
	XmRecordService xmRecordService;
	  
    
    @Autowired
	XmGroupCacheService groupCacheService;


	@Autowired
	XmProductProjectLinkService xmProductProjectLinkService;

	@Autowired
	private XmProjectService xmProjectService;


	@Autowired
	private XmProductService xmProductService;

    @Autowired
    XmPushMsgService pushMsgService;


	@Autowired
	SysClient sysClient;

    public void clearProjectGroup(String projectId){
		groupCacheService.clearProjectGroups(projectId);
	}
	public void clearProductGroup(String productId){
		groupCacheService.clearProductGroups(productId);
	}



	public Tips checkIsProductAdmOrTeamHeadOrAss(User user, String tardgetUserid, String productId){
		Tips tips = new Tips("成功");
 		boolean isAdm=this.checkUserIsProductAdm(productId, user.getUserid());
		if(!isAdm){ 
			boolean isHead=false;
			if(!isHead){
				return new Tips(false,"not-head","您无权操作！产品经理、组长可以操作。");
			}
		}

		return tips;
	}


	public Tips checkIsProjectAdmOrTeamHeadOrAss(User user, String tardgetUserid, String projectId){
    	Tips tips = new Tips("成功");
 		boolean isAdm=this.checkUserIsProjectAdm(projectId, user.getUserid());
		if(!isAdm){
			 return tips.setErrMsg("");
		}

		return tips;
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


    
    public boolean checkUserExistsProjectGroup(String projectId, String userid){
		 return false;

    }
	public boolean checkUserExistsProductGroup(String productId, String userid){
		 return false;

	} 
    

   
	public static void main(String[] args) {
		String idpaths="0,1,2,3,";
		String[] idpss=idpaths.split(",");
		int lvl=idpss.length;

	}

	public Tips checkProjectStatus(XmProject xmProject){
		Tips tips=new Tips("成功");
		if(xmProject==null){
			tips.setErrMsg("prj-0","项目已不存在");
		} else if("4".equals(xmProject.getStatus())){
			tips.setErrMsg("prj-status-4","项目暂停中，不能操作");
		} else if("9".equals(xmProject.getStatus())){
			tips.setErrMsg("prj-status-9","项目已关闭，不能操作");
		}
		return tips;
	}

	public Tips checkProductStatus(XmProduct xmProduct){
		Tips tips=new Tips("成功");
		if(xmProduct==null){
			tips.setErrMsg("product-0","产品已不存在");
		} else if("3".equals(xmProduct.getPstatus())){
			tips.setErrMsg("pstatus-3","产品已关闭，不能操作");
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
			tips.setErrMsg("no-project-edit-qx","您不是项目【"+xmProject.getName()+"】的管理人员，无权修改项目信息。");
		}
		return tips;
	}


	public Map<String,String> getProductAdmUsers(XmProduct xmProductDb){

		Map<String,String> proUsersMap=new HashMap<>();
		proUsersMap.put(xmProductDb.getPmUserid(),xmProductDb.getPmUsername());
		proUsersMap.put(xmProductDb.getAssUserid(),xmProductDb.getAssUsername());
		proUsersMap.put(xmProductDb.getAdmUserid(),xmProductDb.getAdmUsername());
		return proUsersMap;
	}
	public Tips checkHasProductEditQx(User user,XmProduct xmProductDb) {
		Tips tips=new Tips("成功");
		Map<String,String> proUsersMap=this.getProductAdmUsers(xmProductDb);
		if(!proUsersMap.containsKey(user.getUserid())){
			tips.setErrMsg("no-product-edit-qx","您不是产品【"+xmProductDb.getProductName()+"】的管理人员，无权修改产品信息。");
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


	public List<Dept> getSubDeptList(String pdeptid) {
    	List<Dept> depts= sysClient.listSubDept(pdeptid);
    	return depts;
	}

	public List<Dept> getUserGroups(List<Dept> headGroups, String memUserid) {
    	return new ArrayList<>();
	}

	public boolean checkUserExistsGroup(List<Dept> groups, String memUserid) {
    	return true;
	}

	public boolean checkUserIsOtherUserTeamHeadOrAss(List<Dept> groups, String headUserid, String memUserid) {
    	return true;
	}
}

