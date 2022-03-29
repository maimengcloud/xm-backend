package com.xm.core.ctrl;

import java.math.BigDecimal;
import java.util.*;

import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmGroup;
import com.xm.core.entity.XmTask;
import com.xm.core.service.XmGroupService;
import com.xm.core.service.XmTaskService;
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
import com.mdp.core.utils.NumberUtil;
import com.xm.core.service.XmTaskWorkloadService;
import com.xm.core.entity.XmTaskWorkload;
/**
 * url编制采用rest风格,如对xm_task_workload 工时登记表的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmTaskWorkload/add <br>
 *  查询: core/xmTaskWorkload/list<br>
 *  模糊查询: core/xmTaskWorkload/listKey<br>
 *  修改: core/xmTaskWorkload/edit <br>
 *  删除: core/xmTaskWorkload/del<br>
 *  批量删除: core/xmTaskWorkload/batchDel<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTaskWorkload 表 xm_task_workload 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmTaskWorkloadController")
@RequestMapping(value="/**/core/xmTaskWorkload")
@Api(tags={"工时登记表操作接口"})
public class XmTaskWorkloadController {
	
	static Logger logger =LoggerFactory.getLogger(XmTaskWorkloadController.class);
	
	@Autowired
	private XmTaskWorkloadService xmTaskWorkloadService;

	@Autowired
	XmTaskService xmTaskService;

	@Autowired
	XmGroupService xmGroupService;
 
	
	@ApiOperation( value = "查询工时登记表信息列表",notes=" ") 
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskWorkload.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTaskWorkload( @RequestParam Map<String,Object> xmTaskWorkload){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmTaskWorkload, "ids");
		PageUtils.startPage(xmTaskWorkload);
		List<Map<String,Object>>	xmTaskWorkloadList = xmTaskWorkloadService.selectListMapByWhere(xmTaskWorkload);	//列出XmTaskWorkload列表
		PageUtils.responePage(m, xmTaskWorkloadList);
		m.put("data",xmTaskWorkloadList);

		m.put("tips", tips);
		return m;
	}
	
 

	@ApiOperation( value = "新增一条工时登记表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskWorkload.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTaskWorkload(@RequestBody XmTaskWorkload xmTaskWorkload) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
		    boolean createPk=false;
			if(!StringUtils.hasText(xmTaskWorkload.getId())) {
			    createPk=true;
				xmTaskWorkload.setId(xmTaskWorkloadService.createKey("id"));
			}
			if(createPk==false){
                 if(xmTaskWorkloadService.selectOneObject(xmTaskWorkload) !=null ){
                    return failed("pk-exists","编号重复，请修改编号再提交");
                }
            }
			if(!StringUtils.hasText(xmTaskWorkload.getTaskId())) {
				return failed("taskId-0","请上送任务编号");
			}
			if(xmTaskWorkload.getWorkload()==null) {
				return failed("workload-0","工时不能为空");
			}

			if(xmTaskWorkload.getWorkload().compareTo(BigDecimal.ZERO)==0) {
				return failed("workload-0","工时不能为0");
			}
			XmTask xmTaskDb=this.xmTaskService.selectOneObject(new XmTask(xmTaskWorkload.getTaskId()));
			if(xmTaskDb==null ){
				return failed("data-0","任务已不存在");
			}
			User user= LoginUtils.getCurrentUserInfo();
			if(!(user.getUserid().equals(xmTaskDb.getCreateUserid())|| user.getUserid().equals(xmTaskDb.getExecutorUserid()))){
				Tips isCreate=xmGroupService.checkIsAdmOrTeamHeadOrAssByPtype(user,xmTaskDb.getCreateUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
				if(!isCreate.isOk()){
					Tips isExec=xmGroupService.checkIsAdmOrTeamHeadOrAssByPtype(user,xmTaskDb.getExecutorUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
					if(!isExec.isOk()){
						return failed("noqx-0","你无权针对该业务进行报工");
					}

				}
			}
			xmTaskWorkload.setCtime(new Date());
			xmTaskWorkload.setCuserid(user.getUserid());
			if(!StringUtils.hasText(xmTaskWorkload.getUserid())){
				xmTaskWorkload.setUserid(user.getUserid());
				xmTaskWorkload.setUsername(user.getUsername());
			}
			xmTaskWorkload.setWstatus("0");
			xmTaskWorkloadService.insert(xmTaskWorkload);
			m.put("data",xmTaskWorkload);
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


	@ApiOperation( value = "删除一条工时登记表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmTaskWorkload(@RequestBody XmTaskWorkload xmTaskWorkload){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
            if(!StringUtils.hasText(xmTaskWorkload.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
			if(!StringUtils.hasText(xmTaskWorkload.getTaskId())) {
				return failed("taskId-0","请上送任务编号");
			}
			XmTask xmTaskDb=this.xmTaskService.selectOneObject(new XmTask(xmTaskWorkload.getTaskId()));
			if(xmTaskDb==null ){
				return failed("data-0","任务已不存在");
			}
			User user= LoginUtils.getCurrentUserInfo();
			if(!(user.getUserid().equals(xmTaskDb.getCreateUserid())|| user.getUserid().equals(xmTaskDb.getExecutorUserid()))){
				Tips isCreate=xmGroupService.checkIsAdmOrTeamHeadOrAssByPtype(user,xmTaskDb.getCreateUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
				if(!isCreate.isOk()){
					Tips isExec=xmGroupService.checkIsAdmOrTeamHeadOrAssByPtype(user,xmTaskDb.getExecutorUserid(),xmTaskDb.getPtype(),xmTaskDb.getProductId(),xmTaskDb.getProjectId());
					if(!isExec.isOk()){
						return failed("noqx-0","你无权针对该业务进行报工");
					}

				}
			}
			xmTaskWorkloadService.deleteByPk(xmTaskWorkload);
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
	

	@ApiOperation( value = "根据主键修改一条工时登记表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskWorkload.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTaskWorkload(@RequestBody XmTaskWorkload xmTaskWorkload) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmTaskWorkload.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmTaskWorkload xmTaskWorkloadDb = xmTaskWorkloadService.selectOneObject(xmTaskWorkload);
            if( xmTaskWorkloadDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			xmTaskWorkloadService.updateSomeFieldByPk(xmTaskWorkload);
			m.put("data",xmTaskWorkload);
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
	@ApiOperation( value = "根据主键列表批量删除工时登记表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmTaskWorkload(@RequestBody List<XmTaskWorkload> xmTaskWorkloads) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmTaskWorkloads.size()+"条数据"); 
		try{ 
			xmTaskWorkloadService.batchDelete(xmTaskWorkloads);
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
	 * 用于结算单
	 * */
	@ApiOperation( value = "查询工时登记表信息列表",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskWorkload.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listByProject",method=RequestMethod.GET)
	public Map<String,Object> listXmTaskWorkloadByProject( @RequestParam Map<String,Object> xmTaskWorkload){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		PageUtils.startPage(xmTaskWorkload);
		List<Map<String,Object>>	xmTaskWorkloadList = xmTaskWorkloadService.selectList("selectListMapByProject",xmTaskWorkload);	//列出XmTaskWorkload列表
		PageUtils.responePage(m, xmTaskWorkloadList);
		m.put("data",xmTaskWorkloadList);

		m.put("tips", tips);
		return m;
	}
}
