package com.xm.core.ctrl;

import com.alibaba.fastjson.JSON;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.BaseUtils;
import com.mdp.core.utils.RequestUtils;
import com.mdp.msg.client.PushNotifyMsgService;
import com.mdp.mybatis.PageUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.sensitive.SensitiveWordService;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmIteration;
import com.xm.core.entity.XmProduct;
import com.xm.core.service.*;
import com.xm.core.vo.XmIterationVo;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;
import java.util.stream.Collectors;

import static com.mdp.core.utils.BaseUtils.fromMap;
import static com.mdp.core.utils.ResponseHelper.failed;

/**
 * url编制采用rest风格,如对XM.xm_iteration 迭代定义的操作有增删改查,对应的url分别为:<br>
 *  新增: xm/xmIteration/add <br>
 *  查询: xm/xmIteration/list<br>
 *  模糊查询: xm/xmIteration/listKey<br>
 *  修改: xm/xmIteration/edit <br>
 *  删除: xm/xmIteration/del<br>
 *  批量删除: xm/xmIteration/batchDel<br>
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmIteration 表 XM.xm_iteration 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmIterationController")
@RequestMapping(value="/**/xm/core/xmIteration")
@Api(tags={"迭代定义操作接口"})
public class XmIterationController {
	
	static Log logger=LogFactory.getLog(XmIterationController.class);
	
	@Autowired
	private XmIterationService xmIterationService;



	@Autowired
	private XmProductService xmProductService;


	@Autowired
	private XmRecordService  xmRecordService;


	@Autowired
	private XmGroupService  groupService;

	@Autowired
	XmIterationStateService xmIterationStateService;

	@Autowired
	XmProductQxService productQxService;


	@Autowired
	PushNotifyMsgService notifyMsgService;
	@Autowired
	SensitiveWordService sensitiveWordService;

	Map<String,Object> fieldsMap = BaseUtils.toMap(new XmIteration());


	@ApiOperation( value = "查询迭代定义信息列表",notes="listXmIteration,条件之间是 and关系,模糊查询写法如 {studentName:'%才哥%'}")
	@ApiEntityParams(XmIteration.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageSize",value="每页记录数",required=false),
		@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
		@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
		@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student_id desc",required=false),
		@ApiImplicitParam(name="count",value="是否进行总条数计算,count=true|false",required=false) 
	})
	@ApiResponses({
		@ApiResponse(code = 200,response= XmIteration.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmIteration( @ApiIgnore @RequestParam Map<String,Object> xmIteration){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmIteration, "ids");
		PageUtils.startPage(xmIteration);
		String id= (String) xmIteration.get("id");
		Object ids=  xmIteration.get("ids");
		String productId= (String) xmIteration.get("productId");
		String adminUserid= (String) xmIteration.get("adminUserid");
		String menuId= (String) xmIteration.get("menuId");
		String queryScope=(String) xmIteration.get("queryScope");
		String branchId=(String) xmIteration.get("branchId");
		String linkProjectId=(String) xmIteration.get("linkProjectId");
		User user = LoginUtils.getCurrentUserInfo();
		xmIteration.put("userid",user.getUserid());
		if(  !( StringUtils.hasText(branchId)|| StringUtils.hasText(id) || StringUtils.hasText(productId)|| StringUtils.hasText(menuId)||ids!=null
				|| StringUtils.hasText(adminUserid) ) ){
			if(LoginUtils.isBranchAdmin()){
				xmIteration.put("branchId",user.getBranchId());
			}else{
				if(!StringUtils.hasText(productId) && !StringUtils.hasText(linkProjectId)){
					xmIteration.put("compete",user.getUserid());
				}else{
					xmIteration.put("branchId",user.getBranchId());
				}
			}
		}
		if("branchId".equals(queryScope)){
			xmIteration.put("branchId",user.getBranchId());
		}
		List<Map<String,Object>>	xmIterationList = xmIterationService.selectListMapByWhere(xmIteration);	//列出XmIteration列表
		PageUtils.responePage(m, xmIterationList);
		m.put("data",xmIterationList);

		m.put("tips", tips);
		return m;
	}
	
	@ApiOperation( value = "查询迭代数据，联通状态数据一起带出",notes="") 
	@ApiResponses({
		@ApiResponse(code = 200,response=XmIteration.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listWithState",method=RequestMethod.GET)
	public Map<String,Object> listWithState( @ApiIgnore @RequestParam Map<String,Object> xmIteration){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(xmIteration, "ids");
		PageUtils.startPage(xmIteration);

		String id= (String) xmIteration.get("id");
		Object ids=  xmIteration.get("ids");
		String productId= (String) xmIteration.get("productId");
		String adminUserid= (String) xmIteration.get("adminUserid");
		String menuId= (String) xmIteration.get("menuId");
		String queryScope=(String) xmIteration.get("queryScope");
		String branchId=(String) xmIteration.get("branchId");
		String linkProjectId=(String) xmIteration.get("linkProjectId");
		User user = LoginUtils.getCurrentUserInfo();
		xmIteration.put("userid",user.getUserid());
		if(  !(StringUtils.hasText(branchId)|| StringUtils.hasText(id) || StringUtils.hasText(productId)|| StringUtils.hasText(menuId)||ids!=null
				|| StringUtils.hasText(adminUserid) ) ){
			if(LoginUtils.isBranchAdmin()){
				xmIteration.put("branchId",user.getBranchId());
			}else{
				if(!StringUtils.hasText(productId) && !StringUtils.hasText(linkProjectId)){
					xmIteration.put("compete",user.getUserid());
				}else{
					xmIteration.put("branchId",user.getBranchId());
				}
			}
		}
		if("branchId".equals(queryScope)){
			xmIteration.put("branchId",user.getBranchId());
		}
		List<Map<String,Object>>	xmIterationList = xmIterationService.selectListMapByWhereWithState(xmIteration);	//列出XmIteration列表
		PageUtils.responePage(m, xmIterationList);
		m.put("data",xmIterationList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
	/***/
	@ApiOperation( value = "新增一条迭代定义信息",notes="addXmIteration,主键如果为空，后台自动生成")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmIteration.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	//@HasQx(value = "xm_core_xmIteration_add",name = "新增迭代计划",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmIteration(@RequestBody XmIterationVo xmIteration) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			XmIteration q=new XmIteration();
			User user= LoginUtils.getCurrentUserInfo();

			Set<String> words=sensitiveWordService.getSensitiveWord(xmIteration.getIterationName());
			if(words!=null && words.size()>0){
				return failed("name-sensitive-word","名字有敏感词"+words+",请修改后再提交");
			}
			words=sensitiveWordService.getSensitiveWord(xmIteration.getRemark());
			if(words!=null && words.size()>0){
				return failed("remark-sensitive-word","备注中有敏感词"+words+",请修改后再提交");
			}
			q.setBranchId(user.getBranchId());
			Long count=this.xmIterationService.countByWhere(q);
			xmIteration.setId(this.xmIterationService.createIterationId(count));
			xmIteration.setSeqNo(Long.toString(count+1));
			xmIteration.setCtime(new Date());
			xmIteration.setCuserid(user.getUserid());
			xmIteration.setCusername(user.getUsername());
			xmIteration.setIstatus("0");
			xmIteration.setIphase("0");
			XmProduct xmProductDb=xmProductService.getProductFromCache(xmIteration.getProductId());
			tips=productQxService.checkProductQx(xmProductDb,3,user);
			if(!tips.isOk()){
				return failed(tips);
			}

			xmIteration.setBranchId(xmProductDb.getBranchId());

			if(!StringUtils.hasText(xmIteration.getAdminUserid())){
				xmIteration.setAdminUserid(user.getUserid());
				xmIteration.setAdminUsername(user.getUsername());
			}else if(!xmIteration.getAdminUserid().equals(user.getUserid())){
				boolean isPm=groupService.checkUserIsProductAdm(xmProductDb,user.getUserid());
				if( !isPm ){
					tips = productQxService.checkProductQx(null,xmProductDb,3,user,xmIteration.getAdminUserid(),xmIteration.getAdminUsername(),null);
					if(!tips.isOk()){
						return failed(tips);
					}
				}
			}



			notifyMsgService.pushMsg(user,xmIteration.getAdminUserid(),xmIteration.getAdminUsername(),"6",xmIteration.getProductId(),xmIteration.getId(),"您成为迭代【"+xmIteration.getIterationName()+"】管理员，请及时跟进。");
			xmIterationService.addIteration(xmIteration);
			xmIterationStateService.loadTasksToXmIterationState(xmIteration.getId());
			xmRecordService.addXmIterationRecord(xmIteration.getId(),"迭代-新增","新增迭代"+xmIteration.getIterationName());
			m.put("data",xmIteration);
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
	@ApiOperation( value = "删除一条迭代定义信息",notes="delXmIteration,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	})
	//@HasQx(value = "xm_core_xmIteration_del",name = "删除迭代计划",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmIteration(@RequestBody XmIteration xmIteration){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			if(!StringUtils.hasText(xmIteration.getId())){
				return failed("id-0","请上送迭代编号");
			}
			XmIteration iterationDb=this.xmIterationService.selectOneById(xmIteration.getId());
			if(iterationDb==null){
				return failed("data-0","迭代不存在");
			}
			User user=LoginUtils.getCurrentUserInfo();
			XmProduct xmProductDb=xmProductService.getProductFromCache(iterationDb.getProductId());
			boolean isPm=groupService.checkUserIsProductAdm(xmProductDb,user.getUserid());
 			if( !isPm ){
 				tips = productQxService.checkProductQx(null,xmProductDb,3,user,iterationDb.getAdminUserid(),iterationDb.getAdminUsername(),null);
 				if(!tips.isOk()){
					return failed(tips);
				}
			}


			xmIterationService.deleteByPk(xmIteration);
			xmRecordService.addXmIterationRecord(xmIteration.getId(),"迭代-删除","删除迭代"+iterationDb.getIterationName(),"", JSON.toJSONString(iterationDb));

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
	@ApiOperation( value = "根据主键修改一条迭代定义信息",notes="editXmIteration")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmIteration.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	//@HasQx(value = "xm_core_xmIteration_edit",name = "修改迭代计划",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmIteration(@RequestBody XmIteration xmIteration) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			if(!StringUtils.hasText(xmIteration.getId())){
				return failed("id-0","请上送迭代编号");
			}
			XmIteration iterationDb=this.xmIterationService.selectOneById(xmIteration.getId());
			if(iterationDb==null){
				return failed("data-0","迭代不存在");
			}
			User user=LoginUtils.getCurrentUserInfo();
			XmProduct xmProductDb=xmProductService.getProductFromCache(iterationDb.getProductId());
			boolean isPm=groupService.checkUserIsProductAdm(xmProductDb,user.getUserid());
			if( !isPm ){
				tips = productQxService.checkProductQx(null,xmProductDb,3,user,iterationDb.getAdminUserid(),iterationDb.getAdminUsername(),null);
				if(!tips.isOk()){
					return failed(tips);
				}
			}
			xmIteration.setAdminUserid(null);//不允许更改负责人
			xmIteration.setAdminUsername(null);
			xmIterationService.updateByPk(xmIteration);
			xmRecordService.addXmIterationRecord(xmIteration.getId(),"迭代-修改","修改迭代"+iterationDb.getIterationName(),JSON.toJSONString(xmIteration), JSON.toJSONString(iterationDb));
			m.put("data",xmIteration);
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

	@ApiOperation( value = "批量修改某些字段",notes="")
	@ApiEntityParams( value = XmIteration.class, props={ }, remark = "迭代定义", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmIteration.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmIterationMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			List<String> ids= (List<String>) xmIterationMap.get("ids");
			if(ids==null || ids.size()==0){
				return failed("ids-0","ids不能为空");
			}

			Set<String> fields=new HashSet<>();
			fields.add("id");
			for (String fieldName : xmIterationMap.keySet()) {
				if(fields.contains(fieldName)){
					return failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmIterationMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmIterationMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return failed("fieldKey-0","没有需要更新的字段");
			}
			XmIteration xmIteration = fromMap(xmIterationMap,XmIteration.class);
			List<XmIteration> xmIterationsDb=xmIterationService.selectListByIds(ids);
			if(xmIterationsDb==null ||xmIterationsDb.size()==0){
				return failed("data-0","记录已不存在");
			}


			List<XmIteration> can=new ArrayList<>();
			List<XmIteration> no=new ArrayList<>();
			Map<String,Tips> noTipsMap=new HashMap<>();
			User user = LoginUtils.getCurrentUserInfo();
			XmIteration iterationDb=xmIterationsDb.get(0);
			if(xmIterationsDb.stream().filter(k->!k.getProductId().equals(iterationDb.getProductId())).findAny().isPresent()){
				return failed("data-0","批量修改只能修改同一个产品下的迭代记录");
			}
			XmProduct xmProductDb=xmProductService.getProductFromCache(iterationDb.getProductId());


			if(xmIterationMap.containsKey("adminUserid")){
				String adminUserid= (String) xmIterationMap.get("adminUserid");
				String adminUsername= (String) xmIterationMap.get("adminUsername");
				if(StringUtils.hasText(adminUserid)){
					tips=productQxService.checkProductQx(null,xmProductDb,3,user,adminUserid,adminUsername,null);
					if(!tips.isOk()){
						return failed(tips);
					}
				}
			}

			boolean isPm=groupService.checkUserIsProductAdm(xmProductDb,user.getUserid());
			for (XmIteration iterationDb2 : xmIterationsDb) {
				if( !isPm ){
					tips=productQxService.checkProductQx(null,xmProductDb,3,user,iterationDb2.getAdminUserid(),iterationDb2.getAdminUsername(),null);
					if(!tips.isOk()){
						no.add(iterationDb2);
						noTipsMap.put(tips.getMsg(),tips);
					}else{
						can.add(iterationDb2);
					}
				}else{
					can.add(iterationDb2);
				}
			}
			if(can.size()>0){
				xmIterationMap.put("ids",can.stream().map(i->i.getId()).collect(Collectors.toList()));
				xmIterationService.editSomeFields(xmIterationMap);
				if(xmIterationMap.containsKey("adminUserid")){
					String adminUserid= (String) xmIterationMap.get("adminUserid");
					String adminUsername= (String) xmIterationMap.get("adminUsername");
					if(StringUtils.hasText(adminUserid)){
						for (XmIteration iteration : can) {
							notifyMsgService.pushMsg(user,adminUserid,adminUsername,"6",iteration.getProductId(),iteration.getId(),"您成为迭代【"+iteration.getIterationName()+"】管理员，请及时跟进。");
						}
					}

				}
			}
			List<String> msgs=new ArrayList<>();
			if(can.size()>0){
				msgs.add(String.format("成功更新以下%s条数据",can.size()));
			}
			if(no.size()>0){
				msgs.add(String.format("以下%s个数据无权限更新，原因【%s】",no.size(),noTipsMap.keySet().stream().collect(Collectors.joining(";"))));
			}
			if(can.size()>0){
				tips.setOkMsg(msgs.stream().collect(Collectors.joining()));
			}else {
				tips.setFailureMsg(msgs.stream().collect(Collectors.joining()));
			}
			//m.put("data",xmMenu);
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

	//@HasQx(value = "xm_core_xmIteration_loadTasksToXmIterationState",name = "计算迭代的bug、工作量、人员投入、进度等",moduleId = "xm-project",moduleName = "管理端-项目管理系统")
	@RequestMapping(value="/loadTasksToXmIterationState",method=RequestMethod.POST)
	public Map<String,Object> loadTasksToXmIterationState(@RequestBody XmIteration xmIteration) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			if(!StringUtils.hasText(xmIteration.getId())){
				return failed("id-0","请上送迭代编号");
			}
			if(xmIteration==null || StringUtils.isEmpty(xmIteration.getId())) {
				tips.setFailureMsg("请输入迭代编号id");
			}else {
				XmIteration iterationDb=this.xmIterationService.selectOneObject(xmIteration);
				if(iterationDb==null){
					return failed("data-0","迭代不存在");
				}
				xmIterationService.loadTasksToXmIterationState(xmIteration.getId());
				xmRecordService.addXmIterationRecord(xmIteration.getId(),"迭代-汇总","汇总计算迭代数据"+iterationDb.getIterationName());

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
	
	/**
	@ApiOperation( value = "根据主键列表批量删除迭代定义信息",notes="batchDelXmIteration,仅需要上传主键字段")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmIteration(@RequestBody List<XmIteration> xmIterations) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmIterations.size()+"条数据"); 
		try{ 
			xmIterationService.batchDelete(xmIterations);
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
