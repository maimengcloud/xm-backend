package com.qqkj.xm.core.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qqkj.mdp.core.context.ContextHolder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.qqkj.mdp.mybatis.PageUtils; 
import com.qqkj.mdp.core.utils.RequestUtils;
import com.qqkj.mdp.core.entity.Tips;
import com.qqkj.mdp.core.err.BizException;
import com.qqkj.mdp.core.service.SequenceService;
import com.qqkj.xm.core.service.XmAttachmentService;
import com.qqkj.xm.core.entity.XmAttachment;
/**
 * url编制采用rest风格,如对XM.xm_attachment xm_attachment的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmAttachment/add <br>
 *  查询: xm/xmAttachment/list<br>
 *  模糊查询: xm/xmAttachment/listKey<br>
 *  修改: xm/xmAttachment/edit <br>
 *  删除: xm/xmAttachment/del<br>
 *  批量删除: xm/xmAttachment/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmAttachment 表 XM.xm_attachment 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmAttachmentController")
@RequestMapping(value="/**/xm/core/xmAttachment")
@Api(tags={"xm_attachment操作接口"})
public class XmAttachmentController {
	
	static Log logger=LogFactory.getLog(XmAttachmentController.class);
	
	@Autowired
	private XmAttachmentService xmAttachmentService;
	 
		
 
	
	@ApiOperation( value = "查询xm_attachment信息列表",notes="listXmAttachment,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="originType",value="附件来源类型，0任务，1问题，2文档",required=false),
		@ApiImplicitParam(name="originId",value="来源id",required=false),
		@ApiImplicitParam(name="name",value="附件名字",required=false),
		@ApiImplicitParam(name="addr",value="附件地址",required=false),
		@ApiImplicitParam(name="type",value="附件类型",required=false),
		@ApiImplicitParam(name="remark",value="备注说明",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmAttachment.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmAttachment( @RequestParam Map<String,Object> xmAttachment){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmAttachment, "ids");
		PageUtils.startPage(xmAttachment);
		List<Map<String,Object>>	xmAttachmentList = xmAttachmentService.selectListMapByWhere(xmAttachment);	//列出XmAttachment列表
		PageUtils.responePage(m, xmAttachmentList);
		m.put("data",xmAttachmentList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	/**
	@ApiOperation( value = "新增一条xm_attachment信息",notes="addXmAttachment,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmAttachment.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmAttachment(@RequestBody XmAttachment xmAttachment) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmAttachment.getId())) {
				xmAttachment.setId(xmAttachmentService.createKey("id"));
			}else{
				 XmAttachment xmAttachmentQuery = new  XmAttachment(xmAttachment.getId());
				if(xmAttachmentService.countByWhere(xmAttachmentQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmAttachmentService.insert(xmAttachment);
			m.put("data",xmAttachment);
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
	@ApiOperation( value = "删除一条xm_attachment信息",notes="delXmAttachment,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmAttachment(@RequestBody XmAttachment xmAttachment){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmAttachmentService.deleteByPk(xmAttachment);
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
	@ApiOperation( value = "根据主键修改一条xm_attachment信息",notes="editXmAttachment")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmAttachment.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmAttachment(@RequestBody XmAttachment xmAttachment) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmAttachmentService.updateByPk(xmAttachment);
			m.put("data",xmAttachment);
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
	@ApiOperation( value = "根据主键列表批量删除xm_attachment信息",notes="batchDelXmAttachment,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmAttachment(@RequestBody List<XmAttachment> xmAttachments) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmAttachments.size()+"条数据"); 
		try{ 
			xmAttachmentService.batchDelete(xmAttachments);
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
