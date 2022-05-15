package com.xm.core.ctrl;

import com.alibaba.fastjson.JSON;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.NumberUtil;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.mybatis.PageUtils;
import com.mdp.qx.HasQx;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.PubTool;
import com.xm.core.entity.XmPhase;
import com.xm.core.entity.XmProduct;
import com.xm.core.service.XmGroupService;
import com.xm.core.service.XmPhaseService;
import com.xm.core.service.XmProductService;
import com.xm.core.service.XmRecordService;
import com.xm.core.vo.XmGroupVo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.mdp.core.utils.BaseUtils.map;

/**
 * url编制采用rest风格,如对XM.xm_phase 项目计划模板的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmProjectPhase/add <br>
 *  查询: xm/xmProjectPhase/list<br>
 *  模糊查询: xm/xmProjectPhase/listKey<br>
 *  修改: xm/xmProjectPhase/edit <br>
 *  删除: xm/xmProjectPhase/del<br>
 *  批量删除: xm/xmProjectPhase/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectPhase 表 XM.xm_phase 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmPhaseController")
@RequestMapping(value="/**/xm/core/xmPhase")
@Api(tags={"项目计划模板操作接口"})
public class XmPhaseController {

	static Log logger=LogFactory.getLog(XmPhaseController.class);

	@Autowired
	private XmPhaseService xmPhaseService;

	@Autowired
	private XmGroupService groupService;

	@Autowired
	private XmProductService xmProductService;


	@Autowired
	XmRecordService xmRecordService;

	@ApiOperation( value = "查询项目计划模板信息列表",notes="listXmProductPhase,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiImplicitParams({
			@ApiImplicitParam(name="id",value="计划主键,主键",required=false),
			@ApiImplicitParam(name="phaseName",value="计划名称",required=false),
			@ApiImplicitParam(name="remark",value="备注",required=false),
			@ApiImplicitParam(name="parentPhaseId",value="上级计划编号",required=false),
			@ApiImplicitParam(name="branchId",value="机构编号",required=false),
			@ApiImplicitParam(name="productId",value="当前项目编号",required=false),
			@ApiImplicitParam(name="beginDate",value="开始时间",required=false),
			@ApiImplicitParam(name="endDate",value="结束时间",required=false),
			@ApiImplicitParam(name="phaseBudgetHours",value="工时(不包括下一级)-应该大于或等于task中总工时",required=false),
			@ApiImplicitParam(name="phaseBudgetStaffNu",value="投入人员数(不包括下一级)-应该大于或等于task中总人数",required=false),
			@ApiImplicitParam(name="ctime",value="创建时间",required=false),
			@ApiImplicitParam(name="phaseBudgetNouserAt",value="非人力成本总预算(不包括下一级)-应该大于或等于task中非人力总成本",required=false),
			@ApiImplicitParam(name="phaseBudgetIuserAt",value="内部人力成本总预算(不包括下一级)-应该大于或等于task中内部人力总成本",required=false),
			@ApiImplicitParam(name="phaseBudgetOuserAt",value="外购人力成本总预算(不包括下一级)-应该大于或等于task中外购总成本",required=false),
			@ApiImplicitParam(name="projectBaselineId",value="项目级基线",required=false),
			@ApiImplicitParam(name="bizProcInstId",value="当前流程实例编号",required=false),
			@ApiImplicitParam(name="bizFlowState",value="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",required=false),
			@ApiImplicitParam(name="phaseBudgetWorkload",value="总工作量单位人时-应该大于或者等于task中的预算总工作量",required=false),
			@ApiImplicitParam(name="phaseActWorkload",value="已完成工作量单位人时-从task中的实际工作量算出",required=false),
			@ApiImplicitParam(name="phaseActIuserWorkload",value="实际内部人力工作量-来自任务表合计",required=false),
			@ApiImplicitParam(name="phaseActOuserWorkload",value="实际外购人力工作量-来自任务表合计",required=false),
			@ApiImplicitParam(name="taskType",value="0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType",required=false),
			@ApiImplicitParam(name="planType",value="计划类型w1-周,w2-2周,w3-3周,m1-1月,m2-2月,q1-季,q2-半年，y1-年",required=false),
			@ApiImplicitParam(name="seqNo",value="顺序号",required=false),
			@ApiImplicitParam(name="phaseBudgetIuserWorkload",value="内部人力工作量总预算(不包括下一级)-应该大于或等于task中内部人力总成本",required=false),
			@ApiImplicitParam(name="phaseBudgetOuserWorkload",value="外购人力工作量总预算(不包括下一级)-应该大于或等于task中外购总成本",required=false),
			@ApiImplicitParam(name="actNouserAt",value="实际非人力成本-来自任务表合计",required=false),
			@ApiImplicitParam(name="actIuserAt",value="实际内部人力成本-来自任务表合计",required=false),
			@ApiImplicitParam(name="phaseBudgetIuserPrice",value="内部人力成本单价元/人时",required=false),
			@ApiImplicitParam(name="phaseBudgetOuserPrice",value="外购人力成本单价元/人时",required=false),
			@ApiImplicitParam(name="phaseBudgetOuserCnt",value="外购人数",required=false),
			@ApiImplicitParam(name="phaseBudgetIuserCnt",value="内部人数",required=false),
			@ApiImplicitParam(name="actRate",value="实际进度0-100",required=false),
			@ApiImplicitParam(name="phaseStatus",value="计划状态0初始1执行中2完工3关闭4删除中5已删除6暂停",required=false),
			@ApiImplicitParam(name="actOuserAt",value="实际外部人力成本",required=false),
			@ApiImplicitParam(name="taskCnt",value="任务数",required=false),
			@ApiImplicitParam(name="finishTaskCnt",value="完成的任务数",required=false),
			@ApiImplicitParam(name="iterationCnt",value="迭代数",required=false),
			@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
			@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false)
	})
	@ApiResponses({
			@ApiResponse(code = 200,response= XmPhase.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmProductPhase( @ApiIgnore @RequestParam Map<String,Object> xmProjectPhase){
		Map<String,Object> m = new HashMap<>();
		RequestUtils.transformArray(xmProjectPhase, "ids");
		PageUtils.startPage(xmProjectPhase);
		List<Map<String,Object>>	xmProjectPhaseList = xmPhaseService.selectListMapByWhere(xmProjectPhase);	//列出XmProjectPhase列表
		PageUtils.responePage(m, xmProjectPhaseList);
		if("1".equals(xmProjectPhase.get("withParents"))  && !"1".equals(xmProjectPhase.get("isTop")) && xmProjectPhaseList.size()>0){
			Set<String> pidPathsSet=new HashSet<>();
			Set<String> idSet=new HashSet<>();
			for (Map<String, Object> map : xmProjectPhaseList) {
				String id= (String) map.get("id");
				idSet.add(id);
				String pidPaths= (String) map.get("pidPaths");
				pidPaths=PubTool.getPidPaths(pidPaths,id);
				if(pidPaths==null || pidPaths.length()<=2){
					continue;
				}
				pidPathsSet.add(pidPaths);
			}
			if(pidPathsSet!=null && pidPathsSet.size()>0){
				List<Map<String,Object>> parentList= xmPhaseService.selectListMapByWhere(map("pidPathsList",pidPathsSet.stream().collect(Collectors.toList())));
				parentList=parentList.stream().filter(i->!idSet.contains(i.get("id"))).collect(Collectors.toList());
				if(parentList!=null && parentList.size()>0){
					xmProjectPhaseList.addAll(parentList);
					m.put("total", NumberUtil.getInteger(m.get("total"),0)+parentList.size());
				}
			}
		}
		m.put("data",xmProjectPhaseList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}


	@HasQx(value = "xm_core_xmPhase_setPhaseMngUser",name = "设置计划负责人",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/setPhaseMngUser",method=RequestMethod.POST)
	public Map<String,Object> setPhaseMngUser(@RequestBody XmPhase xmProjectPhase) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功设置");
		try{
			if(StringUtils.isEmpty(xmProjectPhase.getId())) {
				tips.setFailureMsg("计划编号不能为空");
				m.put("tips", tips);
				return m;
			}else{
				XmPhase xmProjectPhaseQuery = new XmPhase(xmProjectPhase.getId());
				XmPhase xmProjectPhaseDb=this.xmPhaseService.selectOneObject(xmProjectPhaseQuery);
				if(xmProjectPhaseDb==null){
					tips.setFailureMsg("计划不存在");
					m.put("tips", tips);
					return m;
				}
				XmProduct xmProduct=this.xmProductService.getProductFromCache(xmProjectPhaseDb.getProductId());
				List<XmGroupVo> groupVoList=groupService.getProjectGroupVoList(xmProjectPhaseDb.getProductId());
				User user = LoginUtils.getCurrentUserInfo();
				boolean meIsPm=groupService.checkUserIsProductAdm(xmProduct,user.getUserid());
				boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
				if( !meIsPm  && !meIsTeamHead ){
					tips.setFailureMsg("您不是组长、也不是产品管理者，不允许设置计划负责人");
					m.put("tips", tips);
					return m;
				}
				boolean meIsHisTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,xmProjectPhase.getMngUserid(),user.getUserid());
				if(  !meIsPm && !meIsHisTeamHead ){
					tips.setFailureMsg("您不是"+xmProjectPhase.getMngUsername()+"的组长，不允许设置其为计划负责人");
					m.put("tips", tips);
					return m;
				}
				if(tips.isOk()){
					XmPhase xmProjectPhaseToUpdate=new XmPhase();
					xmProjectPhaseToUpdate.setId(xmProjectPhase.getId());
					xmProjectPhaseToUpdate.setMngUserid(xmProjectPhase.getMngUserid());
					xmProjectPhaseToUpdate.setMngUsername(xmProjectPhase.getMngUsername());
					this.xmPhaseService.updateSomeFieldByPk(xmProjectPhaseToUpdate);
					this.xmRecordService.addProductPhaseRecord(xmProduct.getId(),xmProjectPhase.getId(),"产品-计划-设置计划负责人","计划负责人由【"+xmProjectPhaseDb.getMngUsername()+"】变更为【"+xmProjectPhase.getMngUsername()+"】");
				}
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

	@ApiOperation( value = "新增一条xm_phase信息",notes="addXmProjectPhase,主键如果为空，后台自动生成")
	@ApiResponses({
			@ApiResponse(code = 200,response= XmPhase.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmPhase_add",name = "创建项目计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProjectPhase(@RequestBody XmPhase xmProjectPhase) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(!StringUtils.hasText(xmProjectPhase.getProductId())){
				return ResponseHelper.failed("productId-0","请上送项目编号");
			}
			if(StringUtils.isEmpty(xmProjectPhase.getId())) {
				xmProjectPhase.setId(xmPhaseService.createKey("id"));
			}else{
				XmPhase xmProjectPhaseQuery = new XmPhase(xmProjectPhase.getId());
				if(xmPhaseService.countByWhere(xmProjectPhaseQuery)>0){
					tips.setFailureMsg("编号重复，请修改编号再提交");
					m.put("tips", tips);
					return m;
				}
			}
			User user = LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmProjectPhase.getMngUserid())){
				xmProjectPhase.setMngUserid(user.getUserid());
				xmProjectPhase.setMngUsername(user.getUsername());
			}
			XmProduct xmProduct=this.xmProductService.getProductFromCache(xmProjectPhase.getProductId());
			List<XmGroupVo> groupVoList=groupService.getProjectGroupVoList(xmProjectPhase.getProductId());

			boolean meIsPm=groupService.checkUserIsProductAdm(xmProduct,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是产品管理者，不允许设置计划负责人");
				m.put("tips", tips);
				return m;
			}
			boolean meIsHisTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,xmProjectPhase.getMngUserid(),user.getUserid());
			if(  !meIsPm && !meIsHisTeamHead ){
				tips.setFailureMsg("您不是"+xmProjectPhase.getMngUsername()+"的组长，不允许设置其为计划负责人");
				m.put("tips", tips);
				return m;
			}
			List<String> excludePhaseIds=new ArrayList<>();
			excludePhaseIds.add(xmProjectPhase.getId());
			xmPhaseService.calcPhaseBudgetAmount(xmProjectPhase);
			xmPhaseService.parentIdPathsCalcBeforeSave(xmProjectPhase);
			if(xmProjectPhase.getLvl()==1){
				if("1".equals(xmProduct.getBudgetCtrl())){
					tips= xmPhaseService.judgetProductBudget(xmProduct.getId(),xmProjectPhase.getBudgetAt(),null,null,null,excludePhaseIds);
				}
			}else {
				if("1".equals(xmProduct.getPhaseBudgetCtrl())) {
					tips = xmPhaseService.judgetPhaseBudget(xmProjectPhase.getParentId(), xmProjectPhase.getBudgetAt(), null, null, null, excludePhaseIds);
				}
			}
			if(!tips.isOk()){
				return ResponseHelper.failed(tips);
			}
			XmPhase parentDb= xmPhaseService.selectOneObject(new XmPhase(xmProjectPhase.getParentId()));
			if(parentDb==null){
				return ResponseHelper.failed("p-no-exists","上级计划不存在");
			}
			if(!"1".equals(parentDb.getNtype())){
				return ResponseHelper.failed("p-ntype-no-1","上级【"+parentDb.getName()+"】不是计划集，不能在其之下建立子计划");
			}
			xmPhaseService.insert(xmProjectPhase);
			xmRecordService.addProductPhaseRecord(xmProduct.getId(), xmProjectPhase.getId(), "产品-计划-新增计划", "新增计划"+xmProjectPhase.getName(),JSON.toJSONString(xmProjectPhase),null);
			m.put("data",xmProjectPhase);
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
	@ApiOperation( value = "删除一条xm_phase信息",notes="delXmProjectPhase,仅需要上传主键字段")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	@HasQx(value = "xm_core_xmPhase_del",name = "删除项目计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProjectPhase(@RequestBody XmPhase xmProjectPhase){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			if(!StringUtils.hasText(xmProjectPhase.getId())){
				return ResponseHelper.failed("id-0","请上送计划编号");
			}
			XmPhase xmProjectPhaseDb=this.xmPhaseService.selectOneObject(xmProjectPhase);
			if(xmProjectPhaseDb==null){
				return ResponseHelper.failed("data-0","该计划已不存在");
			}
			XmProduct xmProduct=this.xmProductService.getProductFromCache(xmProjectPhaseDb.getProductId());
			List<XmGroupVo> groupVoList=groupService.getProjectGroupVoList(xmProjectPhaseDb.getProductId());
			User user = LoginUtils.getCurrentUserInfo();
			boolean meIsPm=groupService.checkUserIsProductAdm(xmProduct,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是产品管理者，不允许删除计划");
				m.put("tips", tips);
				return m;
			}
			boolean meIsHisTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,xmProjectPhaseDb.getMngUserid(),user.getUserid());
			if(  !meIsPm && !meIsHisTeamHead ){
				tips.setFailureMsg("您不是"+xmProjectPhaseDb.getMngUsername()+"的组长，不允许删除其负责的计划");
				m.put("tips", tips);
				return m;
			}
			//检查是否由关联的任务，有则不允许删除
			Long exists=this.xmPhaseService.checkExistsTask(xmProjectPhase.getId());
			if(exists>0) {
				tips.setFailureMsg("存在"+exists+"条任务,不允许删除");
			}else {

				if(xmProjectPhaseDb.getChildrenCnt()!=null && xmProjectPhaseDb.getChildrenCnt()>0){
					tips.setFailureMsg("存在"+xmProjectPhaseDb.getChildrenCnt()+"条子计划,不允许删除");
				} else {
					xmPhaseService.deleteByPk(xmProjectPhaseDb);
					xmRecordService.addProductPhaseRecord(xmProjectPhaseDb.getProductId(), xmProjectPhaseDb.getId(), "产品-计划-删除计划", "删除计划"+xmProjectPhaseDb.getName(),"",JSON.toJSONString(xmProjectPhaseDb));
				}
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


	/***/
	@ApiOperation( value = "根据主键修改一条xm_phase信息",notes="editXmProjectPhase")
	@ApiResponses({
			@ApiResponse(code = 200,response= XmPhase.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@HasQx(value = "xm_core_xmPhase_edit",name = "修改项目计划基础信息",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProjectPhase(@RequestBody XmPhase xmProjectPhase) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			if(!StringUtils.hasText(xmProjectPhase.getId())){
				return ResponseHelper.failed("id-0","请上送计划编号");
			}
			XmPhase xmProjectPhaseDb=this.xmPhaseService.selectOneObject(xmProjectPhase);
			if(xmProjectPhaseDb==null){
				return ResponseHelper.failed("data-0","该计划已不存在");
			}
			XmProduct xmProduct=this.xmProductService.getProductFromCache(xmProjectPhase.getProductId());
			List<XmGroupVo> groupVoList=groupService.getProjectGroupVoList(xmProjectPhase.getProductId());
			User user = LoginUtils.getCurrentUserInfo();
			boolean meIsPm=groupService.checkUserIsProductAdm(xmProduct,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是产品管理者，不允许修改计划");
				m.put("tips", tips);
				return m;
			}
			if(!StringUtils.hasText(xmProjectPhase.getMngUserid())){
				xmProjectPhase.setMngUserid(user.getUserid());
				xmProjectPhase.setMngUsername(user.getUsername());
			}
			boolean meIsHisTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,xmProjectPhase.getMngUserid(),user.getUserid());
			if(  !meIsPm && !meIsHisTeamHead ){
				tips.setFailureMsg("您不是"+xmProjectPhase.getMngUsername()+"的组长，不允许修改其负责的计划");
				m.put("tips", tips);
				return m;
			}
			xmProjectPhase= xmPhaseService.autoCalcWorkload(xmProjectPhase);
			xmPhaseService.calcPhaseBudgetAmount(xmProjectPhase);
			List<String> excludePhaseIds=new ArrayList<>();
			excludePhaseIds.add(xmProjectPhase.getId());

			//如果修改了预算数据，才进行预算判断
			if(xmProjectPhaseDb.getBudgetAt()!=null && xmProjectPhaseDb.getBudgetAt().compareTo(xmProjectPhase.getBudgetAt())!=0){
				if(xmProjectPhase.getLvl()==1){
					if("1".equals(xmProduct.getBudgetCtrl())){
						tips=this.xmPhaseService.judgetProductBudget(xmProduct.getId(),xmProjectPhase.getBudgetAt(),null,null,null,excludePhaseIds);
					}
				}else{
					if("1".equals(xmProduct.getPhaseBudgetCtrl())) {
						tips = this.xmPhaseService.judgetPhaseBudget(xmProjectPhase.getParentId(), xmProjectPhase.getBudgetAt(), null, null, null, excludePhaseIds);
					}
				}

			}
			if(!tips.isOk()) {
				return ResponseHelper.failed(tips);
			}
			xmPhaseService.editByPk(xmProjectPhase);
			xmRecordService.addProductPhaseRecord(xmProjectPhase.getProductId(), xmProjectPhase.getId(), "产品-计划-修改计划", "修改计划"+xmProjectPhase.getName(),JSON.toJSONString(xmProjectPhase),null);

			m.put("data",xmProjectPhase);
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
	@ApiOperation( value = "根据主键列表批量删除xm_phase信息",notes="batchDelXmProjectPhase,仅需要上传主键字段")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmPhase_batchDel",name = "批量删除项目计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProjectPhase(@RequestBody List<XmPhase> xmProjectPhases) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+(xmProjectPhases==null?0:xmProjectPhases.size())+"条数据");
		try{
			if(xmProjectPhases==null || xmProjectPhases.size()==0){
				tips.setFailureMsg("计划不能为空");
				m.put("tips", tips);
				return m;
			}
			XmPhase xmProjectPhase=xmProjectPhases.get(0);
			if(!StringUtils.hasText(xmProjectPhase.getProductId())){
				tips.setFailureMsg("项目编号不能为空");
				m.put("tips", tips);
				return m;
			}
			XmProduct xmProduct=this.xmProductService.getProductFromCache(xmProjectPhase.getProductId());
			List<String> existsTaskList=new ArrayList<>();
			List<String> hasChildList=new ArrayList<>();
			List<XmGroupVo> groupVoList=groupService.getProjectGroupVoList(xmProjectPhase.getProductId());
			User user = LoginUtils.getCurrentUserInfo();
			boolean meIsPm=groupService.checkUserIsProductAdm(xmProduct,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是产品管理者，不允许删除计划");
				m.put("tips", tips);
				return m;
			}
			List<String> noQxUsernames=new ArrayList<>();
			List<XmPhase> delPhases=new ArrayList<>();
			List<XmPhase> xmProjectPhaseListDb=this.xmPhaseService.selectListByIds(xmProjectPhases.stream().map(i->i.getId()).collect(Collectors.toList()));
			for (XmPhase phase : xmProjectPhaseListDb) {
				boolean meIsHisTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,phase.getMngUserid(),user.getUserid());
				if(  !meIsPm && !meIsHisTeamHead ){
					noQxUsernames.add(phase.getMngUsername());
					continue;
				}
				//检查是否由关联的任务，有则不允许删除
				Long exists=this.xmPhaseService.checkExistsTask(phase.getId());
				if(exists>0) {
					existsTaskList.add(phase.getName());
				}else {
					delPhases.add(phase);
				}
			}
			List<XmPhase> canDelNodes=new ArrayList<>();
			for (XmPhase phase : delPhases) {

				boolean canDelAllChild = xmPhaseService.checkCanDelAllChild(phase,delPhases);
				if(!canDelAllChild) {
					hasChildList.add(phase.getName());
				}else {
					canDelNodes.add(phase);
				}
			}
			if(canDelNodes.size()>0){
				this.xmPhaseService.doBatchDelete(canDelNodes);
				xmRecordService.addProductPhaseRecord(xmProjectPhase.getProductId(), "", "产品-计划-批量删除计划", "批量删除计划"+canDelNodes.stream().map(i->i.getName()).collect(Collectors.joining(",")),"",JSON.toJSONString(canDelNodes));

			}
			List<String> msgs=new ArrayList<>();
			msgs.add("成功删除"+canDelNodes.size()+"条数据。");
			if(noQxUsernames.size()>0){
				msgs.add("您无权删除以下人员所负责的计划【"+StringUtils.arrayToCommaDelimitedString(noQxUsernames.toArray())+"】");
			}
			if(hasChildList.size()>0){
				msgs.add("以下计划存在子计划，不允许删除。【"+hasChildList.stream().collect(Collectors.joining(","))+"】");
			}

			if(existsTaskList.size()>0){
				msgs.add("以下计划存在关联的任务，不允许删除。【"+existsTaskList.stream().collect(Collectors.joining(","))+"】");
			}
			if(canDelNodes.size()==0){
				tips.setFailureMsg(msgs.stream().collect(Collectors.joining(" ")));
			}else{
				tips.setOkMsg(msgs.stream().collect(Collectors.joining(" ")));
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
	/***/
	@ApiOperation( value = "根据主键列表批量删除xm_phase信息",notes="batchDelXmProjectPhase,仅需要上传主键字段")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmPhase_batchImportFromTemplate",name = "从模板批量创建项目计划",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchImportFromTemplate",method=RequestMethod.POST)
	public Map<String,Object> batchImportFromTemplate(@RequestBody List<XmPhase> xmProjectPhases) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功导入"+xmProjectPhases.size()+"条数据");
		try{
			if(xmProjectPhases==null || xmProjectPhases.size()==0){
				tips.setFailureMsg("计划不能为空");
				m.put("tips", tips);
				return m;
			}
			XmPhase xmProjectPhase=xmProjectPhases.get(0);

			if(!StringUtils.hasText(xmProjectPhase.getProductId())){
				return ResponseHelper.failed("productId-0","请上送项目编号");
			}
			XmProduct xmProduct=this.xmProductService.getProductFromCache(xmProjectPhase.getProductId());
			List<XmGroupVo> groupVoList=groupService.getProjectGroupVoList(xmProjectPhase.getProductId());
			User user = LoginUtils.getCurrentUserInfo();
			boolean meIsPm=groupService.checkUserIsProductAdm(xmProduct,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHeadOrAss(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是产品管理者，不允许批量导入计划");
				m.put("tips", tips);
				return m;
			}
			String productId=null;
			for (XmPhase g : xmProjectPhases) {
				productId=g.getProductId();
				g.setMngUserid(user.getUserid());
				g.setMngUsername(user.getUsername());
				g= xmPhaseService.autoCalcWorkload(g);
				xmPhaseService.calcPhaseBudgetAmount(g);

			}
			xmPhaseService.parentIdPathsCalcBeforeSave(xmProjectPhases);
			List<XmPhase> l1Phases=xmProjectPhases.stream().filter(i->1==i.getLvl()).collect(Collectors.toList());
			if(l1Phases==null ||l1Phases.size()==0){//如果是导入到某个计划之下，
				//找到导入的树中最上面的节点
				List<XmPhase> noExists=xmProjectPhases.stream().filter(i->!xmProjectPhases.stream().filter(k->k.getId().equals(i.getParentId())).findAny().isPresent()).collect(Collectors.toList());
				//根据同一个父亲归类
				Map<String,List<XmPhase>> map=new HashMap<>();
				for (XmPhase noExist : noExists) {
					List<XmPhase> phases=map.get(noExist.getParentId());
					if(phases==null){
						phases=new ArrayList<>();
						map.put(noExist.getParentId(),phases);
					}
					phases.add(noExist);
				}
				for (Map.Entry<String, List<XmPhase>> kv : map.entrySet()) {
					String parentId=kv.getKey();
					List<XmPhase> children=kv.getValue();
					BigDecimal phaseTotalBudgetAt=BigDecimal.ZERO;
					List<String> excludeIds=children.stream().map(i->i.getId()).collect(Collectors.toList());
					for (XmPhase child : children) {
						phaseTotalBudgetAt=phaseTotalBudgetAt.add(child.getBudgetAt());
					}
					if("1".equals(xmProduct.getPhaseBudgetCtrl())){
						Tips tips2= xmPhaseService.judgetPhaseBudget(parentId,phaseTotalBudgetAt,null,null,null,excludeIds);
						if(!tips2.isOk()){
							tips2.setFailureMsg(tips2.getMsg()+" 相关计划为【"+children.stream().map(i->i.getName()).collect(Collectors.joining(","))+"】");
							return ResponseHelper.failed(tips2);
						}
					}
				}
			}else{//直接导入到项目之下，需要判断当前一级预算是否超出项目总预算
				BigDecimal phaseTotalBudgetWorkload=BigDecimal.ZERO;
				BigDecimal phaseTotalBudgetAt=BigDecimal.ZERO;
				for (XmPhase l1Phase : l1Phases) {
					phaseTotalBudgetWorkload=phaseTotalBudgetWorkload.add(l1Phase.getBudgetWorkload());
					phaseTotalBudgetAt=phaseTotalBudgetAt.add(l1Phase.getBudgetAt());
				}
				if("1".equals(xmProduct.getBudgetCtrl())) {
					tips = xmPhaseService.judgetProductBudget(productId, phaseTotalBudgetAt, null, null, null, l1Phases.stream().map(i -> i.getId()).collect(Collectors.toList()));
					if (!tips.isOk()) {
						return ResponseHelper.failed(tips);
					}
				}
			}
			if(tips.isOk()) {
				for (XmPhase projectPhase : xmProjectPhases) {
					projectPhase.setMngUsername(user.getUsername());
					projectPhase.setMngUserid(user.getUserid());
					projectPhase.setCtime(new Date());
					projectPhase.setLtime(new Date());
				}
				xmPhaseService.doBatchInsert(xmProjectPhases);

				for (XmPhase phase : xmProjectPhases) {
					xmRecordService.addProductPhaseRecord(phase.getProductId(), phase.getId(), "产品-计划-新增计划", "新增计划"+phase.getName(),JSON.toJSONString(phase),null);

				}
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
	/***/
	@ApiOperation( value = "批量修改预算",notes="batchSaveBudget,仅需要上传主键字段")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmPhase_batchSaveBudget",name = "批量修改项目计划的预算",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/batchSaveBudget",method=RequestMethod.POST)
	public Map<String,Object> batchSaveBudget(@RequestBody List<XmPhase> xmProjectPhases) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改"+xmProjectPhases.size()+"条数据");
		try{
			if(xmProjectPhases==null || xmProjectPhases.size()==0){
				tips.setFailureMsg("计划不能为空");
				m.put("tips", tips);
				return m;
			}
			XmPhase xmProjectPhase=xmProjectPhases.get(0);
			if(!StringUtils.hasText(xmProjectPhase.getProductId())){
				return ResponseHelper.failed("productId-0","请上送项目编号");
			}

			XmProduct xmProduct=this.xmProductService.getProductFromCache(xmProjectPhase.getProductId());
			List<XmGroupVo> groupVoList=groupService.getProjectGroupVoList(xmProjectPhase.getProductId());
			User user = LoginUtils.getCurrentUserInfo();
			boolean meIsPm=groupService.checkUserIsProductAdm(xmProduct,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是产品管理者，不允许修改计划预算");
				m.put("tips", tips);
				return m;
			}
			String productId=null;
			for (XmPhase g : xmProjectPhases) {
				productId=g.getProductId();
				g= xmPhaseService.autoCalcWorkload(g);
				xmPhaseService.calcPhaseBudgetAmount(g);
			}
			xmPhaseService.parentIdPathsCalcBeforeSave(xmProjectPhases);
			List<XmPhase> l1Phases=xmProjectPhases.stream().filter(i->1==i.getLvl()).collect(Collectors.toList());
			if(l1Phases==null ||l1Phases.size()==0){//如果是导入到某个计划之下，{//直接导入到项目之下，需要判断当前一级预算是否超出项目总预算
				BigDecimal phaseTotalBudgetWorkload=BigDecimal.ZERO;
				BigDecimal phaseTotalBudgetAt=BigDecimal.ZERO;
				for (XmPhase l1Phase : l1Phases) {
					phaseTotalBudgetWorkload=phaseTotalBudgetWorkload.add(l1Phase.getBudgetWorkload());
					phaseTotalBudgetAt=phaseTotalBudgetAt.add(l1Phase.getBudgetAt());
				}
				if("1".equals(xmProduct.getBudgetCtrl())){
					tips= xmPhaseService.judgetProductBudget(productId,phaseTotalBudgetAt,null,null,null,l1Phases.stream().map(i->i.getId()).collect(Collectors.toList()));
					if(!tips.isOk()){
						return ResponseHelper.failed(tips);
					}
				}
			}
			//找到导入的树中最上面的节点
			List<XmPhase> parentNoNulls=  xmProjectPhases.stream().filter(i->StringUtils.hasText(i.getParentId())&&!"0".equals(i.getParentId())).collect(Collectors.toList());
			//根据同一个父亲归类
			Map<String,List<XmPhase>> map=new HashMap<>();
			for (XmPhase phase : parentNoNulls) {
				List<XmPhase> phases=map.get(phase.getParentId());
				if(phases==null){
					phases=new ArrayList<>();
					map.put(phase.getParentId(),phases);
				}
				phases.add(phase);
			}
			for (Map.Entry<String, List<XmPhase>> kv : map.entrySet()) {
				String parentId=kv.getKey();
				List<XmPhase> children=kv.getValue();
				BigDecimal phaseTotalBudgetAt=BigDecimal.ZERO;
				List<String> excludeIds=children.stream().map(i->i.getId()).collect(Collectors.toList());
				for (XmPhase child : children) {
					phaseTotalBudgetAt=phaseTotalBudgetAt.add(child.getBudgetAt());
				}
				if("1".equals(xmProduct.getPhaseBudgetCtrl())) {
					Tips tips2 = xmPhaseService.judgetPhaseBudget(parentId, phaseTotalBudgetAt, null, null, null, excludeIds);
					if (!tips2.isOk()) {
						tips2.setFailureMsg(tips2.getMsg() + " 相关计划为【" + children.stream().map(i -> i.getName()).collect(Collectors.joining(",")) + "】");
						return ResponseHelper.failed(tips2);
					}
				}
			}


			for (XmPhase projectPhase : xmProjectPhases) {
				int childrenCnt=Integer.valueOf(xmProjectPhases.stream().filter(i->projectPhase.getId().equals(i.getParentId())).count()+"");
				if(childrenCnt>0){
					projectPhase.setChildrenCnt(childrenCnt);
					projectPhase.setNtype("1");
				}
			}
			List<XmPhase> xmProjectPhaseListDb= xmPhaseService.selectListByIds(xmProjectPhases.stream().map(i->i.getId()).collect(Collectors.toList()));

			List<XmPhase> inserts=xmProjectPhases.stream().filter(i->!xmProjectPhaseListDb.stream().filter(k->k.getId().equals(i.getId())).findAny().isPresent()).collect(Collectors.toList());
			List<XmPhase> updates=xmProjectPhases.stream().filter(i->xmProjectPhaseListDb.stream().filter(k->k.getId().equals(i.getId())).findAny().isPresent()).collect(Collectors.toList());
			xmPhaseService.batchInsertOrUpdate(inserts,updates);
			for (XmPhase phase : xmProjectPhases) {
				xmRecordService.addProductPhaseRecord(phase.getProductId(), phase.getId(), "产品-计划-修改计划预算", "修改计划"+phase.getName(),JSON.toJSONString(phase),null);

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
	@ApiOperation( value = "计算bug、task、测试案例、等数据",notes="loaMenusToXmProductPhase")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmPhase_loadTasksToXmProjectPhase",name = "计算各个计划对应的bug、task、测试案例等数据",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/loaMenusToXmProductPhase",method=RequestMethod.POST)
	public Map<String,Object> loadTasksToXmProjectPhase(@RequestBody Map<String,Object> params) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改数据");
		try{
			String productId=(String) params.get("productId");

			if(!StringUtils.hasText(productId)){
				return ResponseHelper.failed("productId-0","请上送项目编号");
			}
			List<XmGroupVo> groupVoList=groupService.getProjectGroupVoList(productId);
			User user = LoginUtils.getCurrentUserInfo();

			XmProduct xmProduct=this.xmProductService.getProductFromCache(productId);
			boolean meIsPm=groupService.checkUserIsProductAdm(xmProduct,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是产品管理者，不允许发起计划统计任务");
				m.put("tips", tips);
				return m;
			}
			int i= xmPhaseService.loaMenusToXmProductPhase(xmProduct.getId());
			xmRecordService.addProductPhaseRecord(xmProduct.getId(), "", "产品-计划-汇总统计", "计算项目计划进度","",null);


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

	@ApiOperation( value = "关键路径计算",notes="calcKeyPaths")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmPhase_calcKeyPaths",name = "关键路径计算",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/calcKeyPaths",method=RequestMethod.POST)
	public Map<String,Object> calcKeyPaths(@RequestBody Map<String,Object> params) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功修改数据");
		try{
			String productId=(String) params.get("productId");

			if(!StringUtils.hasText(productId)){
				return ResponseHelper.failed("productId-0","请上送项目编号");
			}
			List<XmGroupVo> groupVoList=groupService.getProjectGroupVoList(productId);
			User user = LoginUtils.getCurrentUserInfo();

			XmProduct xmProduct=this.xmProductService.getProductFromCache(productId);
			boolean meIsPm=groupService.checkUserIsProductAdm(xmProduct,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是产品管理者，不允许发起关键路径计算任务");
				m.put("tips", tips);
				return m;
			}
			xmPhaseService.calcKeyPaths((String) params.get("productId"));
			xmRecordService.addProductPhaseRecord(xmProduct.getId(), "", "产品-计划-关键路径计算", "计算项目计划关键路径","",null);

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
	@ApiOperation( value = "查询产品与计划汇总数据",notes="selectTotalProductAndPhaseBudgetCost")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@HasQx(value = "xm_core_xmPhase_selectTotalProductAndPhaseBudgetCost",name = "查询产品与计划汇总数据",categoryId = "admin-xm",categoryName = "管理端-项目管理系统")
	@RequestMapping(value="/selectTotalProductAndPhaseBudgetCost",method=RequestMethod.POST)
	public Map<String,Object> getProjectBudgetWithsPhaseBudget(@RequestBody Map<String,Object> params) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功查询预算数据");
		try{
			String productId=(String) params.get("productId");
			if(!StringUtils.hasText(productId)){
				return ResponseHelper.failed("productId-0","请上送项目编号");
			}
			List<XmGroupVo> groupVoList=groupService.getProjectGroupVoList(productId);
			User user = LoginUtils.getCurrentUserInfo();

			XmProduct xmProduct=this.xmProductService.getProductFromCache(productId);
			boolean meIsPm=groupService.checkUserIsProductAdm(xmProduct,user.getUserid());
			boolean meIsTeamHead=groupService.checkUserIsOtherUserTeamHead(groupVoList,user.getUserid(),user.getUserid());
			if( !meIsPm  && !meIsTeamHead ){
				tips.setFailureMsg("您不是组长、也不是产品管理者，不允许查询产品与计划汇总数据");
				m.put("tips", tips);
				return m;
			}
			Map<String,Object> data= xmPhaseService.selectTotalProjectAndPhaseBudgetCost((String) params.get("productId"),null);
			m.put("data",data);
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
