package com.xm.core.ctrl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mdp.core.entity.Result;
import com.mdp.core.query.QueryTools;
import com.mdp.core.utils.RequestUtils;
import com.mdp.msg.client.PushNotifyMsgService;
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

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
	public Result listXmMenuComment(@ApiIgnore @RequestParam Map<String,Object> params){
		
		
		RequestUtils.transformArray(params, "ids");		
		IPage page=QueryTools.initPage(params);
		String pid= (String) params.get("pid");
		if(!StringUtils.hasText(pid)){
			params.put("pidIsNull","1");
		}

		QueryWrapper<XmMenuComment> qw = QueryTools.initQueryWrapper(XmMenuComment.class , params);
		List<Map<String,Object>> datas = xmMenuCommentService.selectListMapByWhere(page,qw,params);


		if(datas.size()>0) {
			List<XmMenuComment> children=xmMenuCommentService.selectListByPids(datas.stream().map(k->(String)k.get("id")).collect(Collectors.toList()));

			return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal()).put("children",children);	//列出XmMenuComment列表
		}

		return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());	//列出XmMenuComment列表
	}


	@ApiOperation( value = "新增一条档案评论表信息",notes="addXmMenuComment,主键如果为空，后台自动生成")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMenuComment.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasRole
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result addXmMenuComment(@RequestBody XmMenuComment xmMenuComment) {

			User user=LoginUtils.getCurrentUserInfo();
			XmMenu xmMenuDb=this.xmMenuService.selectOneById(xmMenuComment.getMenuId());
			if(xmMenuDb==null){
				return Result.error("xmMenu-0","需求已不存在");
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
				notifyMsgService.pushMsg(user, xmMenuDb.getMmUserid(), xmMenuDb.getMmUsername(),user.getUsername()+"发表评论："+xmMenuComment.getContext(),null);
			} 
			return Result.ok();
		
	}


	@ApiOperation( value = "删除一条档案评论表信息",notes="delXmMenuComment,仅需要上传主键字段")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Result delXmMenuComment(@RequestBody XmMenuComment xmMenuComment){

			XmMenuComment commentDb=this.xmMenuCommentService.selectOneById(xmMenuComment.getId());
			if(commentDb==null){
				return Result.error("data-0","评论已不存在");
			}
			User user=LoginUtils.getCurrentUserInfo();
			if(!LoginUtils.isSuperAdmin()){
				if(!LoginUtils.isBranchAdmin(commentDb.getBranchId())){
					if(!user.getUserid().equals(commentDb.getUserid())){
						return Result.error("no-qx-0","无权限删除评论");
					}
				}
			}
			xmMenuCommentService.deleteByPk(xmMenuComment);
			if(StringUtils.hasText(commentDb.getPid())){
				xmMenuCommentService.updateChildrenSum(commentDb.getPid(),Integer.valueOf(-1));
			} 
			return Result.ok();
		
	}


	@ApiOperation( value = "点赞评论",notes="praiseComment")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMenuComment.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/praise",method=RequestMethod.POST)
	public Result praiseComment(@RequestBody XmMenuComment xmMenuComment) {

			xmMenuCommentService.praiseComment(xmMenuComment);
			return Result.ok();
		
	}

	@ApiOperation( value = "屏蔽评论",notes="unShowComment")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMenuComment.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/unshow",method=RequestMethod.POST)
	public Result unShowComment(@RequestBody String[] ids) {

		User user=LoginUtils.getCurrentUserInfo();
		List<XmMenuComment> comments=this.xmMenuCommentService.selectListByIds(Arrays.asList(ids));
		if(comments==null || comments.size()==0){
			return Result.error("data-0","评论已不存在");
		}
		boolean isSuperAdmin=LoginUtils.isSuperAdmin();
		for (XmMenuComment comment : comments) {
			if(!isSuperAdmin){
				if(!LoginUtils.isBranchAdmin(comment.getBranchId())){
					if(!user.getUserid().equals(comment.getUserid())){
						return Result.error("无权限修改","无权限屏蔽评论【"+comment.getContext()+"】");
					}
				}
			}
		}
		xmMenuCommentService.unShowComment(ids);
		return Result.ok();
		
	}

	@ApiOperation( value = "打开评论",notes="showComment")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMenuComment.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/show",method=RequestMethod.POST)
	public Result showComment(@RequestBody String[] ids) {

		User user= LoginUtils.getCurrentUserInfo();
		List<XmMenuComment> comments=this.xmMenuCommentService.selectListByIds(Arrays.asList(ids));
		if(comments==null || comments.size()==0){
			return Result.error("data-0","评论已不存在");
		}
		boolean isSuperAdmin=LoginUtils.isSuperAdmin();
		for (XmMenuComment comment : comments) {
			if(!isSuperAdmin){
				if(!LoginUtils.isBranchAdmin(comment.getBranchId())){
					if(!user.getUserid().equals(comment.getUserid())){
						return Result.error("无权限修改","无权限打开此评论【"+comment.getContext()+"】");
					}
				}
			}
		}
		xmMenuCommentService.showComment(ids);
		return Result.ok();
		
	}
	

}
