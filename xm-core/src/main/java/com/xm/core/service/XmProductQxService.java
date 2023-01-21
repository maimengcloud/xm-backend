package com.xm.core.service;

import com.mdp.core.entity.Tips;
import com.mdp.safe.client.entity.User;
import com.xm.core.QxTool;
import com.xm.core.entity.XmProduct;
import com.xm.core.service.client.SysClient;
import com.xm.core.vo.XmGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class XmProductQxService {


    @Autowired
    XmGroupService xmGroupService;


    @Autowired
    SysClient sysClient;


    /**
     *
     * @param xmProduct
     * @param teamType 0-需求人员 1-测试人员,2-迭代人员
     * @param head
     * @return
     */
    public Tips checkProductQx(XmProduct xmProduct, int teamType, User head){
        return this.checkProductQx(null,xmProduct,teamType,head);
    }

    /**
     *
     * @param groupsMap 产品组缓存数据，当需要循环执行时，避免多次查询缓存与数据库
     * @param xmProduct
     * @param teamType 0-需求人员 1-测试人员,2-迭代人员
     * @param head
     * @return
     */
    public Tips checkProductQx(Map<String,List<XmGroupVo>> groupsMap,XmProduct xmProduct,int teamType,User head){
        Tips tips=this.checkProductScopeQx(groupsMap,xmProduct,teamType,head.getUserid(),head.getUsername(),head.getBranchId());
        return tips;
    }
    /**
     *
     * @param groupsMap 产品组缓存数据，当需要循环执行时，避免多次查询缓存与数据库
     * @param xmProduct
     * @param teamType 0-需求人员 1-测试人员,2-迭代人员
     * @param head
     * @return
     */
    public Tips checkProductQx(Map<String,List<XmGroupVo>> groupsMap,XmProduct xmProduct,int teamType,User head,String memUserid,String memUsername,String memBranchId){
        Tips tips=new Tips("成功");
        boolean headIsPm=xmGroupService.checkUserIsProductAdm(xmProduct,head.getUserid());
        if(headIsPm){
            return tips;
        }
        tips=this.checkProductScopeQx(groupsMap,xmProduct,teamType,head,memUserid,memUsername,memBranchId);
        if(!tips.isOk()){
            return tips;
        }
        return this.checkProductTransmitQx(groupsMap,xmProduct,teamType,head,memUserid,memUsername);
    }



    public Tips checkProductScopeQx(Map<String,List<XmGroupVo>> groupsMap,XmProduct xmProduct,int teamType,User head,String memUserid,String memUsername,String memBranchId){
        Tips tips=new Tips("成功");

        if(!StringUtils.hasText(memUserid)|| memUserid.equals(head.getUserid())){
            return this.checkProductScopeQx(groupsMap,xmProduct,teamType,head.getUserid(),head.getUsername(),head.getBranchId());
        }
        String headUsername=StringUtils.hasText(head.getUsername())?head.getUsername():head.getUserid();
        String scopeQx= QxTool.getProductScopeQx(xmProduct.getQxCode(),teamType);
        memUsername=StringUtils.hasText(memUsername)?memUsername:memUserid;

        boolean headIsPm=xmGroupService.checkUserIsProductAdm(xmProduct,head.getUserid()); 
        if("1".equals(scopeQx)){//同组织
            if( !headIsPm && !head.getBranchId().equals(xmProduct.getBranchId())){
                tips.setFailureMsg("pdqx-scope-branch-0",String.format("产品【%s】只开放给同企业人员,【%s】不在企业【%s】中。",xmProduct.getId(),headUsername,xmProduct.getBranchId()));
                return tips;
            }
            if(xmGroupService.checkUserIsProductAdm(xmProduct,memUserid)){
                return tips;
            }
            if(StringUtils.hasText(memBranchId)){
                User sysU=sysClient.getUserByUserid(memUserid);
                if(sysU==null || StringUtils.isEmpty(sysU.getUserid())){
                    return tips;
                }
                if(sysU.getBranchId().equals(xmProduct.getBranchId())){
                    return tips;
                }
            }else if (memBranchId.equals(xmProduct.getBranchId())){
                return tips;
            }
            tips.setFailureMsg("pdqx-scope-branch-1",String.format("产品【%s】只开放给同企业人员,【%s】不在企业【%s】中。",xmProduct.getId(),memUsername,xmProduct.getBranchId()));
            return tips;


        }else if("2".equals(scopeQx)){//同产品
            List<XmGroupVo> groups=this.getProductGroupsFromLocalCache(groupsMap,xmProduct.getId());
            if( !headIsPm && !xmGroupService.checkUserExistsGroup(groups, head.getUserid())){
                tips.setFailureMsg("pdqx-scope-product-0",String.format("产品【%s】只开放给同一个产品团队人员,【%s】不在产品团队中。",xmProduct.getId(),headUsername));
                return tips;
            };
                 if(xmGroupService.checkUserIsProductAdm(xmProduct,memUserid)){
                    return tips;
                }
                if( xmGroupService.checkUserExistsGroup(groups,memUserid) ){
                    return tips;
                }; 
            tips.setFailureMsg("pdqx-scope-product-1",String.format("产品【%s】只开放给同一个产品团队人员,【%s】不在产品团队中。",xmProduct.getId(),memUsername));
            return tips;
        }else if("3".equals(scopeQx)){//同小组
            List<XmGroupVo> groups=this.getProductGroupsFromLocalCache(groupsMap,xmProduct.getId());
            List<XmGroupVo> headGroups=groups;

            if( !headIsPm ){
                headGroups=xmGroupService.getUserGroups(groups,head.getUserid());
                if( headGroups==null || headGroups.size()==0 ){
                    tips.setFailureMsg("pdqx-scope-team-1",String.format("产品【%s】只开放给同一个产品团队下同一个小组人员,【%s】不在产品团队中。",xmProduct.getId(),headUsername));
                    return tips;
                }
            }
            
                if(xmGroupService.checkUserIsProductAdm(xmProduct,memUserid)){
                    return tips;
                }
                List<XmGroupVo> memGroups=xmGroupService.getUserGroups(headGroups,memUserid);
                if( memGroups!=null && memGroups.size()>0 ){
                    return tips;
                }
            tips.setFailureMsg("pdqx-scope-team-2",String.format("产品【%s】只开放给同一个产品团队下同一个小组人员,【%s】不在产品团队中。",xmProduct.getId(),memUsername));
            return tips;
        }
        return tips;
    }

    /**
     * 检查用户是否满足产品权限控制要求
     * @param xmProduct
     * @param teamType
     * @param memUserid
     * @param memUsername 只用于显示
     * @param memBranchId
     * @return
     */
    public Tips checkProductScopeQx(Map<String,List<XmGroupVo>> groupsMap,XmProduct xmProduct,int teamType,String memUserid,String memUsername,String memBranchId){
        Tips tips=new Tips("成功");
        String scopeQx= QxTool.getProductScopeQx(xmProduct.getQxCode(),teamType);
        boolean isPm=xmGroupService.checkUserIsProductAdm(xmProduct,memUserid);
        if(isPm){
            return tips;
        }
        memUsername=StringUtils.hasText(memUsername)?memUsername:memUserid;
        if("1".equals(scopeQx)){//同组织
            if(!StringUtils.hasText(memBranchId)){
                User sysUser=sysClient.getUserByUserid(memUserid);
                if(sysUser==null || StringUtils.isEmpty(sysUser.getUserid())){
                    //如果账户不存在，可能已注销，再判断没有意义，会导致企业无法操作遗留数据问题
                    //tips.setFailureMsg("no-qx-branchId","产品【"+xmProduct.getId()+"】只开放给同企业人员。");
                    return tips;
                }
                memBranchId=sysUser.getBranchId();
                if(!sysUser.getBranchId().equals(xmProduct.getBranchId())){
                    tips.setFailureMsg("pdqx-scope-branch-0",String.format("产品【%s】只开放给同企业人员,【%s】不在企业【%s】中。",xmProduct.getId(),memUsername,xmProduct.getBranchId()));
                    return tips;
                }
            }else{
                if(!memBranchId.equals(xmProduct.getBranchId())){
                    tips.setFailureMsg("pdqx-scope-branch-0",String.format("产品【%s】只开放给同企业人员,【%s】不在企业【%s】中。",xmProduct.getId(),memUsername,xmProduct.getBranchId()));
                    return tips;
                }
            }

        }else if("2".equals(scopeQx)){//同产品
            if(!xmGroupService.checkUserExistsGroup(getProductGroupsFromLocalCache(groupsMap,xmProduct.getId()), memUserid)){
                tips.setFailureMsg("pdqx-scope-product-0",String.format("产品【%s】只开放给同一个产品团队人员,【%s】不在产品团队中。",xmProduct.getId(),memUsername));
                return tips;
            };
        }else if("3".equals(scopeQx)){//同小组

            if(!xmGroupService.checkUserExistsGroup(getProductGroupsFromLocalCache(groupsMap,xmProduct.getId()), memUserid)){
                tips.setFailureMsg("pdqx-scope-team-0",String.format("产品【%s】只开放给同一个产品团队下同一个小组人员,【%s】不在产品团队中。",xmProduct.getId(),memUsername));
                return tips;
            }
        }
        return tips;
    }


    public Tips checkProductTransmitQx(Map<String,List<XmGroupVo>> groupsMap,XmProduct xmProduct,int teamType,User head){
        return checkProductTransmitQx(groupsMap,xmProduct,teamType,head,null,null);
    }
    public Tips checkProductTransmitQx(Map<String,List<XmGroupVo>> groupsMap,XmProduct xmProduct,int teamType,User head,String memUserid,String memUsername){
        Tips tips=new Tips("成功");
        if(!StringUtils.hasText(memUserid) || memUserid.equals(head.getUserid())){
            return tips;
        }
        String transmitQx= QxTool.getProductTransmitQx(xmProduct.getQxCode(),teamType);
        if("0".equals(transmitQx)){//不检查上下级关系
            return tips;
        }else if("1".equals(transmitQx)){//检查上下级关系
            if(StringUtils.isEmpty(memUserid)||head.getUserid().equals(memUserid)){
                return tips;
            }

            List<XmGroupVo> groups=getProductGroupsFromLocalCache(groupsMap,xmProduct.getId());
            if(xmGroupService.checkUserIsOtherUserTeamHeadOrAss(groups, head.getUserid(), memUserid)){
                return tips;
            }
            tips.setFailureMsg("pdqx-transmit-0",
                    String.format("产品【%s】开启了上下级关系检查，您当前账户【%s】不属于账户【%s】的上级，无权操作。",xmProduct.getId(),head.getUsername(),memUsername));


        }
        return tips;
    }

    public Tips checkProductQxBatch(Map<String,List<XmGroupVo>> groupsMap,XmProduct xmProduct,int teamType,User head,String ...memUserids){
        Tips tips=new Tips("成功");
        tips=this.checkProductScopeQxBatch(groupsMap,xmProduct,teamType,head,memUserids);
        if(!tips.isOk()){
            return tips;
        }
        return this.checkProductTransmitQxBatch(groupsMap,xmProduct,teamType,head.getUserid(),memUserids);
    }

    public Tips checkProductQxBatch(XmProduct xmProduct,int teamType,User head,String ...memUserids){
        Tips tips=new Tips("成功");
        if(xmGroupService.checkUserIsProductAdm(xmProduct,head.getUserid())){
            return tips;
        }
        Map<String,List<XmGroupVo>> groupsMap=new HashMap<>();
        tips=this.checkProductScopeQxBatch(groupsMap,xmProduct,teamType,head,memUserids);
        if(!tips.isOk()){
            return tips;
        }
        return this.checkProductTransmitQxBatch(groupsMap,xmProduct,teamType,head.getUserid(),memUserids);
    }

    public Tips checkProductScopeQxBatch(Map<String,List<XmGroupVo>> groupsMap,XmProduct xmProduct,int teamType,User head,String ...memUserids){
        Tips tips=new Tips("成功");

        if(memUserids==null || memUserids.length==0){
            return this.checkProductScopeQx(groupsMap,xmProduct,teamType,head.getUserid(),head.getUsername(),head.getBranchId());
        }
        Set<String> memUseridSet= Arrays.stream(memUserids).filter(k->StringUtils.hasText(k)&&!k.equals(head.getUserid())).collect(Collectors.toSet());
        if(memUseridSet.size()==0){
            return this.checkProductScopeQx(groupsMap,xmProduct,teamType,head.getUserid(),head.getUsername(),head.getBranchId());
        }
        String username=head.getUsername();
        String scopeQx= QxTool.getProductScopeQx(xmProduct.getQxCode(),teamType);
        boolean headIsPm=xmGroupService.checkUserIsProductAdm(xmProduct,head.getUserid());
        if("1".equals(scopeQx)){//同组织
            if( !headIsPm && !head.getBranchId().equals(xmProduct.getBranchId())){
                tips.setFailureMsg("pdqx-scope-branch-0",String.format("产品【%s】只开放给同企业人员,【%s】不在企业【%s】中。",xmProduct.getId(),username,xmProduct.getBranchId()));
                return tips;
            }
            boolean isAllNull=true;
            for (String memUserid : memUseridSet) {//只要有一个满足条件即可
                if(xmGroupService.checkUserIsProductAdm(xmProduct,memUserid)){
                    return tips;
                }
                User sysU=sysClient.getUserByUserid(memUserid);
                if(sysU==null || StringUtils.isEmpty(sysU.getUserid())){
                    continue;
                }
                isAllNull=false;
                if(sysU.getBranchId().equals(xmProduct.getBranchId())){
                    return tips;
                }
            }
            if(isAllNull){
                return tips;
            }else{
                tips.setFailureMsg("pdqx-scope-branch-1",String.format("产品【%s】只开放给同企业人员,【%s】不在企业【%s】中。",xmProduct.getId(),memUseridSet.stream().collect(Collectors.joining(",")),xmProduct.getBranchId()));
                return tips;
            }


        }else if("2".equals(scopeQx)){//同产品
            List<XmGroupVo> groups=this.getProductGroupsFromLocalCache(groupsMap,xmProduct.getId());
            if( !headIsPm && !xmGroupService.checkUserExistsGroup(groups, head.getUserid())){
                tips.setFailureMsg("pdqx-scope-product-0",String.format("产品【%s】只开放给同一个产品团队人员,【%s】不在产品团队中。",xmProduct.getId(),username));
                return tips;
            };
            for (String memUserid : memUseridSet) {
                if(xmGroupService.checkUserIsProductAdm(xmProduct,memUserid)){
                    return tips;
                }
                if( xmGroupService.checkUserExistsGroup(groups,memUserid) ){
                    return tips;
                };
            }
            tips.setFailureMsg("pdqx-scope-product-1",String.format("产品【%s】只开放给同一个产品团队人员,【%s】不在产品团队中。",xmProduct.getId(),memUseridSet.stream().collect(Collectors.joining(","))));
            return tips;
        }else if("3".equals(scopeQx)){//同小组
            List<XmGroupVo> groups=this.getProductGroupsFromLocalCache(groupsMap,xmProduct.getId());
            List<XmGroupVo> headGroups=groups;

            if( !headIsPm ){
                headGroups=xmGroupService.getUserGroups(groups,head.getUserid());
                if( headGroups==null || headGroups.size()==0 ){
                    tips.setFailureMsg("pdqx-scope-team-1",String.format("产品【%s】只开放给同一个产品团队下同一个小组人员,【%s】不在产品团队中。",xmProduct.getId(),username));
                    return tips;
                }
            }
            for (String memUserid : memUseridSet) {
                if(xmGroupService.checkUserIsProductAdm(xmProduct,memUserid)){
                    return tips;
                }
                List<XmGroupVo> memGroups=xmGroupService.getUserGroups(headGroups,memUserid);
                if( memGroups!=null && memGroups.size()>0 ){
                    return tips;
                }
            }
            tips.setFailureMsg("pdqx-scope-team-2",String.format("产品【%s】只开放给同一个产品团队下同一个小组人员,【%s】不在产品团队中。",xmProduct.getId(),memUseridSet.stream().collect(Collectors.joining(","))));
            return tips;
        }
        return tips;
    }


    List<XmGroupVo> getProductGroupsFromLocalCache(Map<String,List<XmGroupVo>> groupsMap,String productId){
        List<XmGroupVo> groupVoList=null;
        if(groupsMap!=null && groupsMap.containsKey(productId)){
            groupVoList=groupsMap.get(productId);
        }else{
            groupVoList=xmGroupService.getProductGroupVoList(productId);
            if(groupsMap!=null){
                groupsMap.put(productId,groupVoList);
            }
        }
        return groupVoList;
    }


    public Tips checkProductTransmitQxBatch(Map<String,List<XmGroupVo>> groupsMap,XmProduct xmProduct,int teamType,String headUserid,String ...memUserids){
        Tips tips=new Tips("成功");
        String transmitQx= QxTool.getProductTransmitQx(xmProduct.getQxCode(),teamType);
        if("0".equals(transmitQx)){//不检查上下级关系
            return tips;
        }else if("1".equals(transmitQx)){//检查上下级关系
            if(memUserids==null || memUserids.length==0){
                return tips;
            }
            Set<String> memUseridSet= Arrays.stream(memUserids).filter(k->StringUtils.hasText(k) && !k.equals(headUserid)).collect(Collectors.toSet());
            if(memUseridSet.size()==0){
                return tips;
            }
            List<XmGroupVo> groups=getProductGroupsFromLocalCache(groupsMap,xmProduct.getId());
            for (String memUserid : memUseridSet) {
                if(xmGroupService.checkUserIsOtherUserTeamHeadOrAss(groups,headUserid,memUserid)){
                    return tips;
                }
            }
            tips.setFailureMsg("pdqx-transmit-0",
                    String.format("产品【%s】开启了上下级关系检查，您当前账户不属于【%s】中任意账户的上级，无权操作。",xmProduct.getId(),memUseridSet.stream().collect(Collectors.joining(","))));


        }
        return tips;
    }
}
