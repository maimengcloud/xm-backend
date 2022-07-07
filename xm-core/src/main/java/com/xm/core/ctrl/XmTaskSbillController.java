package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.*;
import com.mdp.mybatis.PageUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmTask;
import com.xm.core.entity.XmTaskSbill;
import com.xm.core.entity.XmTaskSbillDetail;
import com.xm.core.entity.XmTaskWorkload;
import com.xm.core.service.XmTaskSbillDetailService;
import com.xm.core.service.XmTaskSbillService;
import com.xm.core.service.XmTaskService;
import com.xm.core.service.XmTaskWorkloadService;
import com.xm.core.vo.BatchJoinToSbillVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.mdp.core.utils.BaseUtils.map;
/**
 * url编制采用rest风格,如对xm_task_sbill 任务结算表的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmTaskSbill/add <br>
 *  查询: core/xmTaskSbill/list<br>
 *  模糊查询: core/xmTaskSbill/listKey<br>
 *  修改: core/xmTaskSbill/edit <br>
 *  删除: core/xmTaskSbill/del<br>
 *  批量删除: core/xmTaskSbill/batchDel<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTaskSbill 表 xm_task_sbill 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmTaskSbillController")
@RequestMapping(value="/**/core/xmTaskSbill")
@Api(tags={"任务结算表操作接口"})
public class XmTaskSbillController {
	
	static Logger logger =LoggerFactory.getLogger(XmTaskSbillController.class);
	
	@Autowired
	private XmTaskSbillService xmTaskSbillService;
	@Autowired
	XmTaskSbillDetailService xmTaskSbillDetailService;

	@Autowired
	XmTaskService xmTaskService;


	@Autowired
	XmTaskWorkloadService xmTaskWorkloadService;

	
	@ApiOperation( value = "查询任务结算表信息列表",notes=" ") 
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskSbill.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTaskSbill( @ApiIgnore @RequestParam Map<String,Object> xmTaskSbill){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmTaskSbill, "ids");
		PageUtils.startPage(xmTaskSbill);
		User user=LoginUtils.getCurrentUserInfo();
		xmTaskSbill.put("branchId",user.getBranchId());
		List<Map<String,Object>>	xmTaskSbillList = xmTaskSbillService.selectListMapByWhere(xmTaskSbill);	//列出XmTaskSbill列表
		PageUtils.responePage(m, xmTaskSbillList);
		m.put("data",xmTaskSbillList);

		m.put("tips", tips);
		return m;
	}
	
 
	

	@ApiOperation( value = "新增一条任务结算表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskSbill.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTaskSbill(@RequestBody XmTaskSbill xmTaskSbill) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
		    boolean createPk=false;
			if(StringUtils.isEmpty(xmTaskSbill.getId())) {
			    createPk=true;
				xmTaskSbill.setId(xmTaskSbillService.createKey("id"));
			}
			if(createPk==false){
                 if(xmTaskSbillService.selectOneObject(xmTaskSbill) !=null ){
                    tips.setFailureMsg("编号重复，请修改编号再提交");
                    m.put("tips", tips);
                    return m;
                }
            }
			User user = LoginUtils.getCurrentUserInfo();
			xmTaskSbill.setAmt(BigDecimal.ZERO);
			xmTaskSbill.setCtime(new Date());
			xmTaskSbill.setCuserid(user.getUserid());
			xmTaskSbill.setCusername(user.getUsername());
			xmTaskSbill.setBizDate(DateUtils.getDate("yyyy-MM-dd"));
			xmTaskSbill.setBranchId(user.getBranchId());
			xmTaskSbill.setDeptid(user.getDeptid());
			xmTaskSbill.setWorkload(BigDecimal.ZERO);
			xmTaskSbill.setBizFlowState("0");
			xmTaskSbill.setBizProcInstId(xmTaskSbill.getId());
			xmTaskSbill.setLtime(new Date());
			xmTaskSbill.setStatus("0");
			xmTaskSbill.setFmsg("");

			xmTaskSbillService.insert(xmTaskSbill);
			m.put("data",xmTaskSbill);
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

	

	@ApiOperation( value = "删除一条任务结算表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmTaskSbill(@RequestBody XmTaskSbill xmTaskSbill){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		if(!"0".equals(xmTaskSbill.getStatus())){
			tips.setFailureMsg("只有待提交的结算单才能删除");
			m.put("tips", tips);
			return m;
		}
		if(!("0".equals(xmTaskSbill.getBizFlowState()) || "4".equals(xmTaskSbill.getBizFlowState()))){
			tips.setFailureMsg("已发审数据不允许删除");
			m.put("tips", tips);
			return m;
		}
		try{
			//删除结算单时候，要一起恢复工时单为未加入结算状态
			xmTaskSbillService.deleteByPkAndReturnWorkload(xmTaskSbill);
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



	@ApiOperation( value = "批量将工时加入到一个结算单中",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskSbill.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/batchJoinToSbill",method=RequestMethod.POST)
	public Map<String,Object> batchJoinToSbill(@RequestBody BatchJoinToSbillVo batchJoinToSbill) {

		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		if(!StringUtils.hasText(batchJoinToSbill.getSbillId())){
			return ResponseHelper.failed("sbillId-0","请上送结算单编号");
		}
		if(batchJoinToSbill.getWorkloadIds()==null){
			return ResponseHelper.failed("workloadIds-0","请上送workloadIds");
		}
		User user=LoginUtils.getCurrentUserInfo();
		try{
			XmTaskSbill sbillDb=this.xmTaskSbillService.selectOneById(batchJoinToSbill.getSbillId());
			if(sbillDb==null){
				return ResponseHelper.failed("sbill-0","结算单不存在");
			}
			if(!"0".equals(sbillDb.getStatus())){
				return ResponseHelper.failed("status-not-0","结算单已提交，不允许再加入工时");
			}
			if(!user.getUserid().equals(sbillDb.getCuserid())){
				return ResponseHelper.failed("cuserid-0","结算单不是您的结算单，您不能操作");
			}
			List<XmTaskWorkload> workloadsDb=xmTaskWorkloadService.selectListByIds(batchJoinToSbill.getWorkloadIds());
			if(workloadsDb==null || workloadsDb.size()<=0){
				return ResponseHelper.failed("workloadsDb-0","工时单已不存在");
			}
			List<XmTaskWorkload> workloadsDb2=workloadsDb.stream().filter(i->!StringUtils.hasText(i.getSbillId()) && "1".equals(i.getSstatus())&&"1".equals(i.getWstatus())).collect(Collectors.toList());
 			if(workloadsDb2==null || workloadsDb2.size()<=0){
				return ResponseHelper.failed("workloadsDb-0","不存在可以结算的工时单。");
			}

			if(workloadsDb2.stream().map(i->i.getProjectId()).collect(Collectors.toSet()).size()>1){
				return ResponseHelper.failed("projectId-not-1","不能一次性处理多个项目的工时单，请选择同一个项目的工时单再尝试。");
			}
			String projectId= sbillDb.getProjectId();
			if(workloadsDb2.stream().filter(k->!k.getProjectId().equals(projectId)).findAny().isPresent()){
				return ResponseHelper.failed("projectId-0",String.format("结算单项目编号为%s,请选择同项目的工时单加入结算单。",projectId));
			}
			List<XmTask> xmTasksDb=this.xmTaskService.selectListByIds(workloadsDb2.stream().map(i->i.getTaskId()).collect(Collectors.toList()));
			if(xmTasksDb==null || xmTasksDb.size()==0){
				return ResponseHelper.failed("xmTasksDb-0","相关任务已不存在。");
			}
			List<XmTask> xmTasksDb2=xmTasksDb.stream().filter(i->!"2".equals(i.getTaskState())).collect(Collectors.toList());
			if(xmTasksDb2==null || xmTasksDb2.size()==0){
				return ResponseHelper.failed("taskState-not-2","任务必须是已完工状态才能结算。");
			}
			List<XmTaskWorkload> workloadsDb3=workloadsDb2.stream().filter(i->xmTasksDb2.stream().filter(k->k.getId().equals(i.getTaskId())).findAny().isPresent()).collect(Collectors.toList());


			//检查是否已有同样的数据加入了结算单，如果有，需要合并
			List<Map<String,Object>> userTasks=workloadsDb3.stream().map(i->map("userid",i.getUserid(),"taskId",i.getTaskId())).collect(Collectors.toList());
			Map<String,Object> userTasksMap=map("userTasks",userTasks);
			List<XmTaskSbillDetail> details=xmTaskSbillDetailService.selectListByUserTasks(userTasksMap);
			List<XmTaskSbillDetail> sameSbillDetails=details.stream().filter(i->sbillDb.getId().equals(i.getSbillId())).collect(Collectors.toList());
			List<XmTaskSbillDetail> othSbillDetails=details.stream().filter(i->!sbillDb.getId().equals(i.getSbillId())).collect(Collectors.toList());
 			for (XmTaskSbillDetail i : othSbillDetails) {
				if(!"4".equals(i.getSstatus())){
					return ResponseHelper.failed("user-task-exists-not-4",String.format("任务【%s】，人员【%s】存在未完成的结算单【%s】，暂时不允许发起结算。",i.getTaskName(),i.getUsername(),i.getSbillId()));
				}
			}
			if(sameSbillDetails!=null && sameSbillDetails.size()>0){
				for (XmTaskSbillDetail detail : sameSbillDetails) {
					//进行合并操作
					for (XmTaskWorkload xmTaskWorkload : workloadsDb3) {
						if(detail.getUserid().equals(xmTaskWorkload.getUserid()) && detail.getTaskId().equals(xmTaskWorkload.getTaskId())){
							detail.setWorkload(NumberUtil.getBigDecimal(detail.getWorkload(),BigDecimal.ZERO).add(NumberUtil.getBigDecimal(xmTaskWorkload.getWorkload(),BigDecimal.ZERO)));
							detail.setSworkload(NumberUtil.getBigDecimal(detail.getSworkload(),BigDecimal.ZERO).add(NumberUtil.getBigDecimal(xmTaskWorkload.getWorkload(),BigDecimal.ZERO)));
						}
					}
				}
			}


			List<XmTaskWorkload> workloadsDb4=workloadsDb3.stream().filter(i->!sameSbillDetails.stream().filter(k->k.getUserid().equals(i.getUserid()) && k.getTaskId().equals(i.getTaskId())).findAny().isPresent()).collect(Collectors.toList());
			Map<String,XmTaskSbillDetail> detailMap=new HashMap<>();
			for (XmTaskWorkload xmTaskWorkload : workloadsDb4) {
				XmTaskSbillDetail detail=detailMap.get(xmTaskWorkload.getUserid()+"-"+xmTaskWorkload.getTaskId());
				if(detail==null){
					detail=new XmTaskSbillDetail();
					BeanUtils.copyProperties(xmTaskWorkload,detail);
					XmTask xmTask=xmTasksDb2.stream().filter(i->i.getId().equals(xmTaskWorkload.getTaskId())).findAny().get();
					detail.setSworkload(NumberUtil.getBigDecimal(xmTaskWorkload.getWorkload(),BigDecimal.ZERO));
					detail.setId(this.xmTaskSbillDetailService.createKey("id"));
					detail.setBizDate(DateUtils.getDate("yyyy-MM-dd"));
					detail.setBizMonth(DateUtils.getDate("yyyy-MM"));
					detail.setSbillId(batchJoinToSbill.getSbillId());
					detail.setProjectId(projectId);
					detail.setBranchId(user.getBranchId());
					detail.setCtime(new Date());
					detail.setBudgetAt(xmTask.getBudgetAt());
					detail.setBudgetWorkload(xmTask.getBudgetWorkload());
					detail.setQuoteAt(xmTask.getQuoteFinalAt());
					detail.setTaskOut(xmTask.getTaskOut());
					detail.setCrowd(xmTask.getCrowd());
					detail.setSschemel(xmTask.getSettleSchemel());
					detail.setShareFee(xmTask.getShareFee());
					detail.setOshare(xmTask.getOshare());
					detailMap.put(xmTaskWorkload.getUserid()+"-"+xmTaskWorkload.getTaskId(),detail);
				}else{
					detail.setWorkload(detail.getWorkload().add(NumberUtil.getBigDecimal(xmTaskWorkload.getWorkload(),BigDecimal.ZERO)));
					detail.setSworkload(detail.getSworkload().add(NumberUtil.getBigDecimal(xmTaskWorkload.getWorkload(),BigDecimal.ZERO)));
				}

			}
			List<XmTaskSbillDetail> canAdd= detailMap.values().stream().collect(Collectors.toList());
			for (XmTaskSbillDetail d : canAdd) {
				List<XmTaskSbillDetail> othDetails=othSbillDetails.stream().filter(i->i.getTaskId().equals(d.getTaskId()) && i.getUserid().equals(d.getUserid())).collect(Collectors.toList());
				BigDecimal tactAt=BigDecimal.ZERO;
				for (XmTaskSbillDetail othDetail : othDetails) {
					tactAt=tactAt.add(othDetail.getAmt());
				}
				d.setTactAt(tactAt);
				this.xmTaskSbillDetailService.preCalcSamt(d);

			}
			this.xmTaskSbillService.batchJoinToSbill(workloadsDb4.stream().map(i->i.getId()).collect(Collectors.toList()), canAdd,sameSbillDetails);


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

	@ApiOperation( value = "根据主键修改一条任务结算表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskSbill.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTaskSbill(@RequestBody XmTaskSbill xmTaskSbill) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		if(!"0".equals(xmTaskSbill.getStatus())){
			tips.setFailureMsg("只能修改待提交的结算单");
			m.put("tips", tips);
			return m;
		}
		if(!("0".equals(xmTaskSbill.getBizFlowState()) || "4".equals(xmTaskSbill.getBizFlowState()))){
			tips.setFailureMsg("已发审数据不允许修改");
			m.put("tips", tips);
			return m;
		}
		try{
			xmTaskSbill.setLtime(new Date());
			xmTaskSbillService.updateByPk(xmTaskSbill);
			m.put("data",xmTaskSbill);
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

	

	
	/**
	@ApiOperation( value = "根据主键列表批量删除任务结算表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmTaskSbill(@RequestBody List<XmTaskSbill> xmTaskSbills) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmTaskSbills.size()+"条数据");
		try{
			xmTaskSbillService.batchDelete(xmTaskSbills);
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

	@ApiOperation( value = "流程审批信息，审批通过则更新sbill审批状态",notes="从workflow传过来")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@RequestMapping(value="/processApprova",method=RequestMethod.POST)
	public Map<String,Object> sbillProcessApprova(@RequestBody Map<String,Object> paramMap) {
		Map<String,Object> map=new HashMap<>();
		Tips tips=new Tips("成功更新结算单状态");

		String sbillId= (String) paramMap.get("sbillId");
		if( !StringUtils.hasText(sbillId)){
			tips.setFailureMsg("结算单ID必传");
			map.put("tips", tips);
			return map;
		}
		map.putAll(paramMap);

		try{
			this.xmTaskSbillService.processApprova(map);
			logger.debug("procInstId====="+paramMap.get("procInstId"));
		}catch (BizException e) {
			tips=e.getTips();
			logger.error("执行异常",e);
		}catch (Exception e) {
			tips.setFailureMsg(e.getMessage());
			logger.error("执行异常",e);
		}
		map.put("tips", tips);
		return map;
	}
}
