package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.core.entity.XmProjectKpi;
import com.xm.core.service.XmProjectKpiService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url编制采用rest风格,如对XM.xm_project_kpi xm_project_kpi的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProjectKpi/add <br>
 *  查询: xm/xmProjectKpi/list<br>
 *  模糊查询: xm/xmProjectKpi/listKey<br>
 *  修改: xm/xmProjectKpi/edit <br>
 *  删除: xm/xmProjectKpi/del<br>
 *  批量删除: xm/xmProjectKpi/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectKpi 表 XM.xm_project_kpi 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmProjectKpiController")
@RequestMapping(value="/**/xm/core/xmProjectKpi")
@Api(tags={"xm_project_kpi操作接口"})
public class XmProjectKpiController {
	
	static Log logger=LogFactory.getLog(XmProjectKpiController.class);
	
	@Autowired
	private XmProjectKpiService xmProjectKpiService;
	 
		
 
	
	@ApiOperation( value = "查询xm_project_kpi信息列表",notes="listXmProjectKpi,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({  
		@ApiImplicitParam(name="id",value="主键,主键",required=false),
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
		@ApiImplicitParam(name="remark",value="备注",required=false),
		@ApiImplicitParam(name="calcType",value="考核方式0月1季度3半年4一年",required=false),
		@ApiImplicitParam(name="nextCalcDate",value="下次考核开始时间",required=false),
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="currentPage",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderFields",value="排序列 如性别、学生编号排序 ['sex','studentId']",required=false),
		@ApiImplicitParam(name="orderDirs",value="排序方式,与orderFields对应，升序 asc,降序desc 如 性别 升序、学生编号降序 ['asc','desc']",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmProjectKpi.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProjectKpi( @RequestParam Map<String,Object> xmProjectKpi){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmProjectKpi, "ids");
		PageUtils.startPage(xmProjectKpi);
		List<Map<String,Object>>	xmProjectKpiList = xmProjectKpiService.selectListMapByWhere(xmProjectKpi);	//列出XmProjectKpi列表
		PageUtils.responePage(m, xmProjectKpiList);
		m.put("data",xmProjectKpiList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	/***/
	@ApiOperation( value = "新增一条xm_project_kpi信息",notes="addXmProjectKpi,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectKpi.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectKpi(@RequestBody XmProjectKpi xmProjectKpi) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(StringUtils.isEmpty(xmProjectKpi.getId())) {
				xmProjectKpi.setId(xmProjectKpiService.createKey("id"));
			}else{
				 XmProjectKpi xmProjectKpiQuery = new  XmProjectKpi(xmProjectKpi.getId());
				if(xmProjectKpiService.countByWhere(xmProjectKpiQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			xmProjectKpiService.insert(xmProjectKpi);
			m.put("data",xmProjectKpi);
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
	
	
	/***/
	@ApiOperation( value = "删除一条xm_project_kpi信息",notes="delXmProjectKpi,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectKpi(@RequestBody XmProjectKpi xmProjectKpi){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			xmProjectKpiService.deleteByPk(xmProjectKpi);
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
	 
	
	/***/
	@ApiOperation( value = "根据主键修改一条xm_project_kpi信息",notes="editXmProjectKpi")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProjectKpi.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectKpi(@RequestBody XmProjectKpi xmProjectKpi) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			xmProjectKpiService.updateByPk(xmProjectKpi);
			m.put("data",xmProjectKpi);
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
	
	

	
	/***/
	@ApiOperation( value = "根据主键列表批量删除xm_project_kpi信息",notes="batchDelXmProjectKpi,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectKpi(@RequestBody List<XmProjectKpi> xmProjectKpis) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProjectKpis.size()+"条数据"); 
		try{ 
			xmProjectKpiService.batchDelete(xmProjectKpis);
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
	
}
