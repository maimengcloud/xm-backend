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
import com.qqkj.xm.core.service.XmRecordService;
import com.qqkj.xm.core.entity.XmRecord;
/**
 * url编制采用rest风格,如对XM.xm_record xm_record的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmRecord/add <br>
 *  查询: xm/xmRecord/list<br>
 *  模糊查询: xm/xmRecord/listKey<br>
 *  修改: xm/xmRecord/edit <br>
 *  删除: xm/xmRecord/del<br>
 *  批量删除: xm/xmRecord/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmRecord 表 XM.xm_record 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmRecordController")
@RequestMapping(value="/**/xm/core/xmRecord")
@Api(tags={"xm_record操作接口"})
public class XmRecordController {
	
	static Log logger=LogFactory.getLog(XmRecordController.class);
	
	@Autowired
	private XmRecordService xmRecordService;
	 
		
 
	
	@ApiOperation( value = "查询xm_record信息列表",notes="listXmRecord,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="日志编号,主键",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="operUserid",value="操作人id",required=false),
		@ApiImplicitParam(name="operUsername",value="操作人名字",required=false),
		@ApiImplicitParam(name="operTime",value="操作时间",required=false),
		@ApiImplicitParam(name="objType",value="操作对象project/task",required=false),
		@ApiImplicitParam(name="action",value="操作的id",required=false),
		@ApiImplicitParam(name="oldValue",value="历史值",required=false),
		@ApiImplicitParam(name="newValue",value="新值",required=false),
		@ApiImplicitParam(name="remarks",value="备注",required=false),
		@ApiImplicitParam(name="taskId",value="任务编号",required=false),
		@ApiImplicitParam(name="reqNo",value="请求编号，用于跟踪日志",required=false),
		@ApiImplicitParam(name="branchId",value="机构编号",required=false),
		@ApiImplicitParam(name="ip",value="ip地址",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmRecord.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},pageInfo:{total:总记录数},data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmRecord( @RequestParam Map<String,Object> xmRecord){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmRecord, "ids");
		PageUtils.startPage(xmRecord);
		List<Map<String,Object>>	xmRecordList = xmRecordService.selectListMapByWhere(xmRecord);	//列出XmRecord列表
		PageUtils.responePage(m, xmRecordList);
		m.put("data",xmRecordList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	/**
	@ApiOperation( value = "新增一条xm_record信息",notes="addXmRecord,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmRecord.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmRecord(@RequestBody XmRecord xmRecord) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmRecord.getId())) {
				xmRecord.setId(xmRecordService.createKey("id"));
			}else{
				 XmRecord xmRecordQuery = new  XmRecord(xmRecord.getId());
				if(xmRecordService.countByWhere(xmRecordQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmRecordService.insert(xmRecord);
			m.put("data",xmRecord);
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
	@ApiOperation( value = "删除一条xm_record信息",notes="delXmRecord,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmRecord(@RequestBody XmRecord xmRecord){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmRecordService.deleteByPk(xmRecord);
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
	@ApiOperation( value = "根据主键修改一条xm_record信息",notes="editXmRecord")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmRecord.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmRecord(@RequestBody XmRecord xmRecord) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmRecordService.updateByPk(xmRecord);
			m.put("data",xmRecord);
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
	@ApiOperation( value = "根据主键列表批量删除xm_record信息",notes="batchDelXmRecord,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmRecord(@RequestBody List<XmRecord> xmRecords) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmRecords.size()+"条数据"); 
		try{ 
			xmRecordService.batchDelete(xmRecords);
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
