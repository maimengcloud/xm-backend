package com.xm.core.ctrl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mdp.core.entity.Result;
import com.mdp.core.query.QueryTools;
import com.mdp.core.utils.RequestUtils;
import com.xm.core.entity.XmProjectKpiHis;
import com.xm.core.service.XmProjectKpiHisService;
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
 * url编制采用rest风格,如对XM.xm_project_kpi_his xm_project_kpi_his的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProjectKpiHis/add <br>
 *  查询: xm/xmProjectKpiHis/list<br>
 *  模糊查询: xm/xmProjectKpiHis/listKey<br>
 *  修改: xm/xmProjectKpiHis/edit <br>
 *  删除: xm/xmProjectKpiHis/del<br>
 *  批量删除: xm/xmProjectKpiHis/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectKpiHis 表 XM.xm_project_kpi_his 当前主键(包括多主键): kpi_id; 
 ***/
@RestController("xm.core.xmProjectKpiHisController")
@RequestMapping(value="/**/xm/core/xmProjectKpiHis")
@Api(tags={"xm_project_kpi_his操作接口"})
public class XmProjectKpiHisController {
	
	static Log logger=LogFactory.getLog(XmProjectKpiHisController.class);
	
	@Autowired
	private XmProjectKpiHisService xmProjectKpiHisService;
	 
		
 
	
	@ApiOperation( value = "查询xm_project_kpi_his信息列表",notes="listXmProjectKpiHis,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="kpiId",value="kpi主表主键,主键",required=false),
		@ApiImplicitParam(name="projectId",value="项目编号",required=false),
		@ApiImplicitParam(name="branchId",value="机构编码",required=false),
		@ApiImplicitParam(name="kpiIndex",value="指标编号",required=false),
		@ApiImplicitParam(name="kpiName",value="指标名称",required=false),
		@ApiImplicitParam(name="maxValue",value="最大值",required=false),
		@ApiImplicitParam(name="minValue",value="最小值",required=false),
		@ApiImplicitParam(name="score",value="得分0~10分",required=false),
		@ApiImplicitParam(name="scoreDate",value="评分日期",required=false),
		@ApiImplicitParam(name="bizFlowState",value="流程状态",required=false),
		@ApiImplicitParam(name="bizProcInstId",value="流程实例编号",required=false),
		@ApiImplicitParam(name="kpiValue",value="kpi当前值",required=false),
		@ApiImplicitParam(name="cdate",value="创建日期",required=false),
		@ApiImplicitParam(name="id",value="主键",required=false),
		@ApiImplicitParam(name="remark",value="备注",required=false),
		@ApiImplicitParam(name="calcType",value="考核方式0月1季度3半年4一年",required=false),
		@ApiImplicitParam(name="nextCalcDate",value="下次考核开始时间",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectKpiHis.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Result listXmProjectKpiHis(@ApiIgnore @RequestParam Map<String,Object> params){
		 
		RequestUtils.transformArray(params, "kpiIds");
		QueryWrapper<XXXXXXXX> qw = QueryTools.initQueryWrapper(XXXXXXXX.class , params);
		IPage page=QueryTools.initPage(params);
		List<Map<String,Object>> datas = xmProjectKpiHisService.selectListMapByWhere(page,qw,params);
			return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());	//列出XmProjectKpiHis列表
		
		
		
		
	}
	
 
	
	/**
	@ApiOperation( value = "新增一条xm_project_kpi_his信息",notes="addXmProjectKpiHis,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectKpiHis.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result addXmProjectKpiHis(@RequestBody XmProjectKpiHis xmProjectKpiHis) {
		
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectKpiHis.getKpiId())) {
				xmProjectKpiHis.setKpiId(xmProjectKpiHisService.createKey("kpiId"));
			}else{
				 XmProjectKpiHis xmProjectKpiHisQuery = new  XmProjectKpiHis(xmProjectKpiHis.getKpiId());
				if(xmProjectKpiHisService.countByWhere(xmProjectKpiHisQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmProjectKpiHisService.insert(xmProjectKpiHis);
		
	}
	*/
	
	/**
	@ApiOperation( value = "删除一条xm_project_kpi_his信息",notes="delXmProjectKpiHis,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Result delXmProjectKpiHis(@RequestBody XmProjectKpiHis xmProjectKpiHis){
		
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectKpiHisService.deleteByPk(xmProjectKpiHis);
		return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());
		
	}
	 */
	
	/**
	@ApiOperation( value = "根据主键修改一条xm_project_kpi_his信息",notes="editXmProjectKpiHis")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectKpiHis.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Result editXmProjectKpiHis(@RequestBody XmProjectKpiHis xmProjectKpiHis) {
		
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectKpiHisService.updateByPk(xmProjectKpiHis);
		
	}
	*/
	

	
	/**
	@ApiOperation( value = "根据主键列表批量删除xm_project_kpi_his信息",notes="batchDelXmProjectKpiHis,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Result batchDelXmProjectKpiHis(@RequestBody List<XmProjectKpiHis> xmProjectKpiHiss) {
		
		Tips tips=new Tips("成功删除"+xmProjectKpiHiss.size()+"条数据"); 
		
			xmProjectKpiHisService.batchDelete(xmProjectKpiHiss);
		return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());
		
	} 
	*/
}
