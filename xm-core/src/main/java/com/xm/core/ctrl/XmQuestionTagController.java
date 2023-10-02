package com.xm.core.ctrl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mdp.core.entity.Result;
import com.mdp.core.query.QueryTools;
import com.mdp.core.utils.RequestUtils;
import com.xm.core.entity.XmQuestionTag;
import com.xm.core.service.XmQuestionTagService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * url编制采用rest风格,如对XM.xm_question_tag 问题标签关联表的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmQuestionTag/add <br>
 *  查询: xm/xmQuestionTag/list<br>
 *  模糊查询: xm/xmQuestionTag/listKey<br>
 *  修改: xm/xmQuestionTag/edit <br>
 *  删除: xm/xmQuestionTag/del<br>
 *  批量删除: xm/xmQuestionTag/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmQuestionTag 表 XM.xm_question_tag 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmQuestionTagController")
@RequestMapping(value="/**/xm/core/xmQuestionTag")
@Api(tags={"问题标签关联表操作接口"})
public class XmQuestionTagController {
	
	static Log logger=LogFactory.getLog(XmQuestionTagController.class);
	
	@Autowired
	private XmQuestionTagService xmQuestionTagService;
	 
		
 
	
	@ApiOperation( value = "查询问题标签关联表信息列表",notes="listXmQuestionTag,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
		@ApiImplicitParam(name="questionId",value="问题编号",required=false),
		@ApiImplicitParam(name="tagId",value="标签编号",required=false),
		@ApiImplicitParam(name="tagName",value="标签名称",required=false),
		@ApiImplicitParam(name="ctime",value="添加时间",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmQuestionTag.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Result listXmQuestionTag(@ApiIgnore @RequestParam Map<String,Object> params){
		 
		RequestUtils.transformArray(params, "ids");		
		IPage page=QueryTools.initPage(params);
		QueryWrapper<XmBranchStateHis> qw = QueryTools.initQueryWrapper(XmBranchStateHis.class , params);
		List<Map<String,Object>> datas = xmQuestionTagService.selectListMapByWhere(page,qw,params);
			return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());	//列出XmQuestionTag列表
		
	}
	
 
	
	/**
	@ApiOperation( value = "新增一条问题标签关联表信息",notes="addXmQuestionTag,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmQuestionTag.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result addXmQuestionTag(@RequestBody XmQuestionTag xmQuestionTag) {

			if(StringUtils.isEmpty(xmQuestionTag.getId())) {
				xmQuestionTag.setId(xmQuestionTagService.createKey("id"));
			}else{
				 XmQuestionTag xmQuestionTagQuery = new  XmQuestionTag(xmQuestionTag.getId());
				if(xmQuestionTagService.countByWhere(xmQuestionTagQuery)>0){
					return Result.error("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmQuestionTagService.insert(xmQuestionTag);
		
	}
	*/
	
	/**
	@ApiOperation( value = "删除一条问题标签关联表信息",notes="delXmQuestionTag,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Result delXmQuestionTag(@RequestBody XmQuestionTag xmQuestionTag){

			xmQuestionTagService.deleteByPk(xmQuestionTag);
		return Result.ok();
		
	}
	 */
	
	/**
	@ApiOperation( value = "根据主键修改一条问题标签关联表信息",notes="editXmQuestionTag")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmQuestionTag.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Result editXmQuestionTag(@RequestBody XmQuestionTag xmQuestionTag) {

			xmQuestionTagService.updateByPk(xmQuestionTag);
		
	}
	*/
	

	
	/**
	@ApiOperation( value = "根据主键列表批量删除问题标签关联表信息",notes="batchDelXmQuestionTag,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Result batchDelXmQuestionTag(@RequestBody List<XmQuestionTag> xmQuestionTags) {
		
		
		
			xmQuestionTagService.batchDelete(xmQuestionTags);
		return Result.ok();
		
	} 
	*/
}
