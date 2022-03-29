package com.xm.core.ctrl;

import java.math.BigDecimal;
import java.util.*;

import com.mdp.core.utils.LogUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mysql.cj.protocol.x.XMessage;
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
import com.mdp.core.utils.RequestUtils;
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
}
