package com.xm.core.ctrl;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import com.mdp.core.utils.*;
import com.mdp.safe.client.cache.ModuleBranchRedisCacheService;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.tpa.client.entity.AppShopConfig;
import com.mysql.cj.protocol.x.XMessage;
import com.xm.core.entity.XmTaskSbillDetail;
import com.xm.core.service.XmTaskSbillDetailService;
import com.xm.core.service.XmTaskService;
import com.xm.core.service.XmTaskWorkloadService;
import com.xm.core.vo.BatchJoinToSbillVo;
import com.xm.core.vo.UserTaskVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import static com.mdp.core.utils.ResponseHelper.*;
import static com.mdp.core.utils.BaseUtils.*;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.mybatis.PageUtils;
import com.xm.core.service.XmTaskSbillService;
import com.xm.core.entity.XmTaskSbill;
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
	public Map<String,Object> listXmTaskSbill( @RequestParam Map<String,Object> xmTaskSbill){
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
			xmTaskSbill.setBizDate(user.getBranchId());
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
		if(batchJoinToSbill.getUserTasks()==null){
			return ResponseHelper.failed("userTasks-0","请上送userTasks");
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
 			List<Map<String,Object>> toSetUserTasks=xmTaskWorkloadService.ListGroupByTaskIdAndUseridToSet(map("userTasks",batchJoinToSbill.getUserTasks()));
			if(toSetUserTasks==null && toSetUserTasks.size()==0){
				return ResponseHelper.failed("userTasks-0","不存在需要结算的用户列表");
			}
			if(toSetUserTasks.stream().filter(i->!"2".equals(i.get("taskState"))).findAny().isPresent()){
				return ResponseHelper.failed("taskState-not-2","任务不是完工状态，不允许结算");
			}
			String projectId= sbillDb.getProjectId();
			if(toSetUserTasks.stream().filter(i->!projectId.equals(i.get("projectId"))).findAny().isPresent()){
				return ResponseHelper.failed("projectId-not-same","请选择同一个项目的任务加入工时单");
			}
			//检查是否已有同样的数据加入了结算单，如果有，需要合并
			BatchJoinToSbillVo batchJoinToSbillQuery=new BatchJoinToSbillVo();
			batchJoinToSbillQuery.setUserTasks(batchJoinToSbill.getUserTasks());
			List<XmTaskSbillDetail> details=xmTaskSbillDetailService.selectListByUserTasks(batchJoinToSbillQuery);
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
					for (Map<String, Object> toSetUserTask : toSetUserTasks) {
						if(detail.getUserid().equals(toSetUserTask.get("userid")) && detail.getTaskId().equals(toSetUserTask.get("taskId"))){
							detail.setWorkload(NumberUtil.getBigDecimal(detail.getWorkload(),BigDecimal.ZERO).add(NumberUtil.getBigDecimal(toSetUserTask.get("workload"),BigDecimal.ZERO)));
							detail.setSworkload(NumberUtil.getBigDecimal(detail.getSworkload(),BigDecimal.ZERO).add(NumberUtil.getBigDecimal(toSetUserTask.get("workload"),BigDecimal.ZERO)));
						}
					}
				}
			}

			List<XmTaskSbillDetail> canAdd=new ArrayList<>();
			for (Map<String,Object> userTask : toSetUserTasks) {
				XmTaskSbillDetail detail= BaseUtils.fromMap(userTask,XmTaskSbillDetail.class);
				if(sameSbillDetails.stream().filter(i->i.getTaskId().equals(detail.getTaskId()) && i.getUserid().equals(detail.getUserid())).findAny().isPresent()){
					continue;
				}
				detail.setId(this.xmTaskSbillDetailService.createKey("id"));
				detail.setBizDate(DateUtils.getDate("yyyy-MM-dd"));
				detail.setBizMonth(DateUtils.getDate("yyyy-MM"));
				detail.setSbillId(batchJoinToSbill.getSbillId());
				detail.setProjectId(projectId);
				detail.setBranchId(user.getBranchId());
				detail.setCtime(new Date());
				canAdd.add(detail);
			}
			for (XmTaskSbillDetail d : canAdd) {
				List<XmTaskSbillDetail> othDetails=othSbillDetails.stream().filter(i->i.getTaskId().equals(d.getTaskId()) && i.getUserid().equals(d.getUserid())).collect(Collectors.toList());
				BigDecimal tactAt=BigDecimal.ZERO;
				for (XmTaskSbillDetail othDetail : othDetails) {
					tactAt=tactAt.add(othDetail.getAmt());
				}
				d.setTactAt(tactAt);
				this.xmTaskSbillDetailService.preCalcSamt(d);

			}
			this.xmTaskSbillService.batchJoinToSbill(canAdd,sameSbillDetails);


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
