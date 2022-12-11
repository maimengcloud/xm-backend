package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.msg.client.PushNotifyMsgService;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasRole;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmMenu;
import com.xm.core.entity.XmMenuComment;
import com.xm.core.service.XmMenuCalcService;
import com.xm.core.service.XmMenuCommentService;
import com.xm.core.service.XmMenuService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;
import java.util.stream.Collectors;

import static com.mdp.core.utils.BaseUtils.toMap;

/**
 * url编制采用rest风格,如对xm_menu_comment 档案评论表的操作有增删改查,对应的url分别为:<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmMenuComment 表 xm_menu_comment 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmMenuCommentController")
@RequestMapping(value="/**/core/xmMenuComment")
@Api(tags={"档案评论表操作接口"})
public class XmMenuCommentController {
	
	static Logger logger =LoggerFactory.getLogger(XmMenuCommentController.class);
	
	@Autowired
	private XmMenuCommentService xmMenuCommentService;
	
	@Autowired
	XmMenuService xmMenuService;

	@Autowired
	PushNotifyMsgService notifyMsgService;
	 

	Map<String,Object> fieldsMap = toMap(new XmMenuComment());
 
	
	@ApiOperation( value = "查询档案评论表信息列表",notes=" ")
	@ApiEntityParams( XmMenuComment.class )
	@ApiImplicitParams({
			@ApiImplicitParam(name="pageSize",value="每页大小，默认20条",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="count",value="是否计算总记录条数，如果count=true,则计算计算总条数，如果count=false 则不计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student desc",required=false),
 	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMenuComment.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmMenuComment( @ApiIgnore @RequestParam Map<String,Object> xmMenuComment){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmMenuComment, "ids");
		PageUtils.startPage(xmMenuComment);
		String pid= (String) xmMenuComment.get("pid");
		if(!StringUtils.hasText(pid)){
			xmMenuComment.put("pidIsNull","1");
		}

		List<Map<String,Object>>	xmMenuCommentList = xmMenuCommentService.selectListMapByWhere(xmMenuComment);	//列出XmMenuComment列表

		if(xmMenuCommentList.size()>0) {
			List<Map<String, Object>> children=xmMenuCommentService.selectListByPids(xmMenuCommentList.stream().map(k->(String)k.get("id")).collect(Collectors.toList()));
			m.put("children", children);
		}

		PageUtils.responePage(m, xmMenuCommentList);
		m.put("data",xmMenuCommentList);

		m.put("tips", tips);
		return m;
	}


	@ApiOperation( value = "新增一条档案评论表信息",notes="addXmMenuComment,主键如果为空，后台自动生成")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMenuComment.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasRole
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmMenuComment(@RequestBody XmMenuComment xmMenuComment) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功评论");
		try{
			User user=LoginUtils.getCurrentUserInfo();
			XmMenu xmMenuDb=this.xmMenuService.selectOneById(xmMenuComment.getMenuId());
			if(xmMenuDb==null){
				return ResponseHelper.failed("xmMenu-0","需求已不存在");
			}
			xmMenuComment.setId(xmMenuCommentService.createKey("id"));
			xmMenuComment.setBranchId(user.getBranchId());
			xmMenuComment.setUserid(user.getUserid());
			xmMenuComment.setUsername(user.getUsername());
			xmMenuComment.setCdate(new Date());
			xmMenuComment.setIp(RequestUtils.getIpAddr(RequestUtils.getRequest()));
			xmMenuCommentService.insert(xmMenuComment);
			if(StringUtils.hasText(xmMenuComment.getPid())){
				xmMenuCommentService.updateChildrenSum(xmMenuComment.getPid(),Integer.valueOf(1));
			}
			XmMenuCalcService.commentsSet.add(xmMenuComment.getMenuId());
			if(!user.getUserid().equals(xmMenuDb.getMmUserid())){
				notifyMsgService.pushMsg(user, xmMenuDb.getMmUserid(), xmMenuDb.getMmUsername(),"10",xmMenuDb.getMenuId(),xmMenuComment.getId(),user.getUsername()+"发表评论："+xmMenuComment.getContext());
			}
			m.put("data",xmMenuComment);
		}catch (BizException e) {
			tips=e.getTips();
			logger.error("执行异常",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("执行异常",e);
		}
		m.put("tips", tips);
		return m;
	}


	@ApiOperation( value = "删除一条档案评论表信息",notes="delXmMenuComment,仅需要上传主键字段")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmMenuComment(@RequestBody XmMenuComment xmMenuComment){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			XmMenuComment commentDb=this.xmMenuCommentService.selectOneById(xmMenuComment.getId());
			if(commentDb==null){
				return ResponseHelper.failed("data-0","评论已不存在");
			}
			User user=LoginUtils.getCurrentUserInfo();
			if(!LoginUtils.isSuperAdmin()){
				if(!LoginUtils.isBranchAdmin(commentDb.getBranchId())){
					if(!user.getUserid().equals(commentDb.getUserid())){
						return ResponseHelper.failed("no-qx-0","无权限删除评论");
					}
				}
			}
			xmMenuCommentService.deleteByPk(xmMenuComment);
			if(StringUtils.hasText(commentDb.getPid())){
				xmMenuCommentService.updateChildrenSum(commentDb.getPid(),Integer.valueOf(-1));
			}
		}catch (BizException e) {
			tips=e.getTips();
			logger.error("执行异常",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("执行异常",e);
		}
		m.put("tips", tips);
		return m;
	}


	@ApiOperation( value = "点赞评论",notes="praiseComment")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMenuComment.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/praise",method=RequestMethod.POST)
	public Map<String,Object> praiseComment(@RequestBody XmMenuComment xmMenuComment) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmMenuCommentService.update("praiseComment", xmMenuComment);

			m.put("data",xmMenuComment);
		}catch (BizException e) {
			tips=e.getTips();
			logger.error("执行异常",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("执行异常",e);
		}
		m.put("tips", tips);
		return m;
	}

	@ApiOperation( value = "屏蔽评论",notes="unShowComment")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMenuComment.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/unshow",method=RequestMethod.POST)
	public Map<String,Object> unShowComment(@RequestBody String[] ids) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功屏蔽评论");
		try{
			User user=LoginUtils.getCurrentUserInfo();
			List<XmMenuComment> comments=this.xmMenuCommentService.selectListByIds(Arrays.asList(ids));
			if(comments==null || comments.size()==0){
				return ResponseHelper.failed("data-0","评论已不存在");
			}
			boolean isSuperAdmin=LoginUtils.isSuperAdmin();
			for (XmMenuComment comment : comments) {
				if(!isSuperAdmin){
					if(!LoginUtils.isBranchAdmin(comment.getBranchId())){
						if(!user.getUserid().equals(comment.getUserid())){
							return ResponseHelper.failed("无权限修改","无权限屏蔽评论【"+comment.getContext()+"】");
						}
					}
				}
			}
			xmMenuCommentService.unShowComment(ids);
		}catch (BizException e) {
			tips=e.getTips();
			logger.error("执行异常",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("执行异常",e);
		}
		m.put("tips", tips);
		return m;
	}

	@ApiOperation( value = "打开评论",notes="showComment")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMenuComment.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/show",method=RequestMethod.POST)
	public Map<String,Object> showComment(@RequestBody String[] ids) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功打开评论");
		try{
			User user= LoginUtils.getCurrentUserInfo();
			List<XmMenuComment> comments=this.xmMenuCommentService.selectListByIds(Arrays.asList(ids));
			if(comments==null || comments.size()==0){
				return ResponseHelper.failed("data-0","评论已不存在");
			}
			boolean isSuperAdmin=LoginUtils.isSuperAdmin();
			for (XmMenuComment comment : comments) {
				if(!isSuperAdmin){
					if(!LoginUtils.isBranchAdmin(comment.getBranchId())){
						if(!user.getUserid().equals(comment.getUserid())){
							return ResponseHelper.failed("无权限修改","无权限打开此评论【"+comment.getContext()+"】");
						}
					}
				}
			}
			xmMenuCommentService.showComment(ids);
		}catch (BizException e) {
			tips=e.getTips();
			logger.error("执行异常",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("执行异常",e);
		}
		m.put("tips", tips);
		return m;
	}
	
	/**
	@ApiOperation( value = "新增一条档案评论表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMenuComment.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmMenuComment(@RequestBody XmMenuComment xmMenuComment) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
		    boolean createPk=false;
			if(!StringUtils.hasText(xmMenuComment.getId())) {
			    createPk=true;
				xmMenuComment.setId(xmMenuCommentService.createKey("id"));
			}
			if(createPk==false){
                 if(xmMenuCommentService.selectOneObject(xmMenuComment) !=null ){
                    return failed("pk-exists","编号重复，请修改编号再提交");
                }
            }
			xmMenuCommentService.insert(xmMenuComment);
			m.put("data",xmMenuComment);
		}catch (BizException e) { 
			tips=e.getTips();
			logger.error("",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("",e);
		}  
		m.put("tips", tips);
		return m;
	}
	*/
	
	/**
	@ApiOperation( value = "删除一条档案评论表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmMenuComment(@RequestBody XmMenuComment xmMenuComment){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
            if(!StringUtils.hasText(xmMenuComment.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmMenuComment xmMenuCommentDb = xmMenuCommentService.selectOneObject(xmMenuComment);
            if( xmMenuCommentDb == null ){
                return failed("data-not-exists","数据不存在，无法删除");
            }
			xmMenuCommentService.deleteByPk(xmMenuComment);
		}catch (BizException e) { 
			tips=e.getTips();
			logger.error("",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("",e);
		}  
		m.put("tips", tips);
		return m;
	}
	 */
	
	/**
	@ApiOperation( value = "根据主键修改一条档案评论表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMenuComment.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmMenuComment(@RequestBody XmMenuComment xmMenuComment) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmMenuComment.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmMenuComment xmMenuCommentDb = xmMenuCommentService.selectOneObject(xmMenuComment);
            if( xmMenuCommentDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			xmMenuCommentService.updateSomeFieldByPk(xmMenuComment);
			m.put("data",xmMenuComment);
		}catch (BizException e) { 
			tips=e.getTips();
			logger.error("",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("",e);
		}  
		m.put("tips", tips);
		return m;
	}
	*/

	/**
    @ApiOperation( value = "批量修改某些字段",notes="")
    @ApiEntityParams( value = XmMenuComment.class, props={ }, remark = "档案评论表", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMenuComment.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmMenuCommentMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            List<String> ids= (List<String>) xmMenuCommentMap.get("ids");
			if(ids==null || ids.size()==0){
				return failed("ids-0","ids不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("id");
			for (String fieldName : xmMenuCommentMap.keySet()) {
				if(fields.contains(fieldName)){
					return failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmMenuCommentMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmMenuCommentMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return failed("fieldKey-0","没有需要更新的字段");
 			}
			XmMenuComment xmMenuComment = fromMap(xmMenuCommentMap,XmMenuComment.class);
			List<XmMenuComment> xmMenuCommentsDb=xmMenuCommentService.selectListByIds(ids);
			if(xmMenuCommentsDb==null ||xmMenuCommentsDb.size()==0){
				return failed("data-0","记录已不存在");
			}
			List<XmMenuComment> can=new ArrayList<>();
			List<XmMenuComment> no=new ArrayList<>();
			User user = LoginUtils.getCurrentUserInfo();
			for (XmMenuComment xmMenuCommentDb : xmMenuCommentsDb) {
				Tips tips2 = new Tips("检查通过"); 
				if(!tips2.isOk()){
				    no.add(xmMenuCommentDb); 
				}else{
					can.add(xmMenuCommentDb);
				}
			}
			if(can.size()>0){
                xmMenuCommentMap.put("ids",can.stream().map(i->i.getId()).collect(Collectors.toList()));
			    xmMenuCommentService.editSomeFields(xmMenuCommentMap); 
			}
			List<String> msgs=new ArrayList<>();
			if(can.size()>0){
				msgs.add(String.format("成功更新以下%s条数据",can.size()));
			}
			if(no.size()>0){
				msgs.add(String.format("以下%s个数据无权限更新",no.size()));
			}
			if(can.size()>0){
				tips.setOkMsg(msgs.stream().collect(Collectors.joining()));
			}else {
				tips.setFailureMsg(msgs.stream().collect(Collectors.joining()));
			}
			//m.put("data",xmMenu);
		}catch (BizException e) {
			tips=e.getTips();
			logger.error("",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("",e);
		}
		m.put("tips", tips);
		return m;
	}
	*/

	/**
	@ApiOperation( value = "根据主键列表批量删除档案评论表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmMenuComment(@RequestBody List<XmMenuComment> xmMenuComments) {
		Map<String,Object> m = new HashMap<>();
        Tips tips=new Tips("成功删除"); 
        try{ 
            if(xmMenuComments.size()<=0){
                return failed("data-0","请上送待删除数据列表");
            }
             List<XmMenuComment> datasDb=xmMenuCommentService.selectListByIds(xmMenuComments.stream().map(i-> i.getId() ).collect(Collectors.toList()));

            List<XmMenuComment> can=new ArrayList<>();
            List<XmMenuComment> no=new ArrayList<>();
            for (XmMenuComment data : datasDb) {
                if(true){
                    can.add(data);
                }else{
                    no.add(data);
                } 
            }
            List<String> msgs=new ArrayList<>();
            if(can.size()>0){
                xmMenuCommentService.batchDelete(can);
                msgs.add(String.format("成功删除%s条数据.",can.size()));
            }
    
            if(no.size()>0){ 
                msgs.add(String.format("以下%s条数据不能删除.【%s】",no.size(),no.stream().map(i-> i.getId() ).collect(Collectors.joining(","))));
            }
            if(can.size()>0){
                 tips.setOkMsg(msgs.stream().collect(Collectors.joining()));
            }else {
                tips.setFailureMsg(msgs.stream().collect(Collectors.joining()));
            }
        }catch (BizException e) { 
            tips=e.getTips();
            logger.error("",e);
        }catch (Exception e) {
            tips.setFailureMsg(e.getMessage());
            logger.error("",e);
        }  
        m.put("tips", tips);
        return m;
	} 
	*/
}
