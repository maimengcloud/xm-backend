package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmTestPlan;
import com.xm.core.service.XmTestPlanService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;
import java.util.stream.Collectors;

import static com.mdp.core.utils.BaseUtils.fromMap;
import static com.mdp.core.utils.BaseUtils.toMap;
import static com.mdp.core.utils.ResponseHelper.failed;

/**
 * url编制采用rest风格,如对xm_test_plan 测试计划的操作有增删改查,对应的url分别为:<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTestPlan 表 xm_test_plan 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmTestPlanController")
@RequestMapping(value="/**/core/xmTestPlan")
@Api(tags={"测试计划操作接口"})
public class XmTestPlanController {
	
	static Logger logger =LoggerFactory.getLogger(XmTestPlanController.class);
	
	@Autowired
	private XmTestPlanService xmTestPlanService;
	 

	Map<String,Object> fieldsMap = toMap(new XmTestPlan());
 
	
	@ApiOperation( value = "查询测试计划信息列表",notes=" ")
	@ApiEntityParams( XmTestPlan.class )
	@ApiImplicitParams({
			@ApiImplicitParam(name="pageSize",value="每页大小，默认20条",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="count",value="是否计算总记录条数，如果count=true,则计算计算总条数，如果count=false 则不计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student desc",required=false),
 	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestPlan.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTestPlan( @ApiIgnore @RequestParam Map<String,Object> xmTestPlan){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmTestPlan, "ids");
		User user=LoginUtils.getCurrentUserInfo();
		if(!user.getBranchId().equals(xmTestCasedbDb.getCbranchId())){
			return failed("cbranchId-err","该测试库不属于您企业，不能修改");
		}
		PageUtils.startPage(xmTestPlan);
		List<Map<String,Object>>	xmTestPlanList = xmTestPlanService.selectListMapByWhere(xmTestPlan);	//列出XmTestPlan列表
		PageUtils.responePage(m, xmTestPlanList);
		m.put("data",xmTestPlanList);

		m.put("tips", tips);
		return m;
	}
	
 

	@ApiOperation( value = "新增一条测试计划信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestPlan.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTestPlan(@RequestBody XmTestPlan xmTestPlan) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
		    boolean createPk=false;
			if(!StringUtils.hasText(xmTestPlan.getId())) {
			    createPk=true;
				xmTestPlan.setId(xmTestPlanService.createKey("id"));
			}
			if(createPk==false){
                 if(xmTestPlanService.selectOneObject(xmTestPlan) !=null ){
                    return failed("pk-exists","编号重复，请修改编号再提交");
                }
            }
			if(!StringUtils.hasText(xmTestPlan.getProjectId())){
				return failed("projectId-0","项目编号不能为空");
			}

			if(!StringUtils.hasText(xmTestPlan.getProductId())){
				return failed("productId-0","产品编号不能为空");
			}

			if(!StringUtils.hasText(xmTestPlan.getCasedbId())){
				return failed("casedbId-0","测试用例库编号不能为空");
			}
			User user=LoginUtils.getCurrentUserInfo();
			xmTestPlan.setCuserid(user.getUserid());
			xmTestPlan.setCusername(user.getUsername());
			xmTestPlan.setCtime(new Date());
			xmTestPlanService.insert(xmTestPlan);
			m.put("data",xmTestPlan);
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

	@ApiOperation( value = "删除一条测试计划信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmTestPlan(@RequestBody XmTestPlan xmTestPlan){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
            if(!StringUtils.hasText(xmTestPlan.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmTestPlan xmTestPlanDb = xmTestPlanService.selectOneObject(xmTestPlan);
            if( xmTestPlanDb == null ){
                return failed("data-not-exists","数据不存在，无法删除");
            }
			xmTestPlanService.deleteByPk(xmTestPlan);
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

	@ApiOperation( value = "根据主键修改一条测试计划信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestPlan.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTestPlan(@RequestBody XmTestPlan xmTestPlan) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmTestPlan.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmTestPlan xmTestPlanDb = xmTestPlanService.selectOneObject(xmTestPlan);
            if( xmTestPlanDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			xmTestPlanService.updateSomeFieldByPk(xmTestPlan);
			m.put("data",xmTestPlan);
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
    @ApiEntityParams( value = XmTestPlan.class, props={ }, remark = "测试计划", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTestPlan.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmTestPlanMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            List<String> ids= (List<String>) xmTestPlanMap.get("ids");
			if(ids==null || ids.size()==0){
				return failed("ids-0","ids不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("id");
			for (String fieldName : xmTestPlanMap.keySet()) {
				if(fields.contains(fieldName)){
					return failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmTestPlanMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmTestPlanMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return failed("fieldKey-0","没有需要更新的字段");
 			}
			XmTestPlan xmTestPlan = fromMap(xmTestPlanMap,XmTestPlan.class);
			List<XmTestPlan> xmTestPlansDb=xmTestPlanService.selectListByIds(ids);
			if(xmTestPlansDb==null ||xmTestPlansDb.size()==0){
				return failed("data-0","记录已不存在");
			}
			List<XmTestPlan> can=new ArrayList<>();
			List<XmTestPlan> no=new ArrayList<>();
			User user = LoginUtils.getCurrentUserInfo();
			for (XmTestPlan xmTestPlanDb : xmTestPlansDb) {
				Tips tips2 = new Tips("检查通过"); 
				if(!tips2.isOk()){
				    no.add(xmTestPlanDb); 
				}else{
					can.add(xmTestPlanDb);
				}
			}
			if(can.size()>0){
                xmTestPlanMap.put("ids",can.stream().map(i->i.getId()).collect(Collectors.toList()));
			    xmTestPlanService.editSomeFields(xmTestPlanMap); 
			}
			List<String> msgs=new ArrayList<>();
			if(can.size()>0){
				msgs.add(String.format("成功更新以下%s条数据",can.size()));
			}
			if(no.size()>0){
				msgs.add(String.format("以下%s个数据无权限更新",no.size()));
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

	@ApiOperation( value = "根据主键列表批量删除测试计划信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmTestPlan(@RequestBody List<XmTestPlan> xmTestPlans) {
		Map<String,Object> m = new HashMap<>();
        Tips tips=new Tips("成功删除"); 
        try{ 
            if(xmTestPlans.size()<=0){
                return failed("data-0","请上送待删除数据列表");
            }
             List<XmTestPlan> datasDb=xmTestPlanService.selectListByIds(xmTestPlans.stream().map(i-> i.getId() ).collect(Collectors.toList()));

            List<XmTestPlan> can=new ArrayList<>();
            List<XmTestPlan> no=new ArrayList<>();
            for (XmTestPlan data : datasDb) {
                if(true){
                    can.add(data);
                }else{
                    no.add(data);
                } 
            }
            List<String> msgs=new ArrayList<>();
            if(can.size()>0){
                xmTestPlanService.batchDelete(can);
                msgs.add(String.format("成功删除%s条数据.",can.size()));
            }
    
            if(no.size()>0){ 
                msgs.add(String.format("以下%s条数据不能删除.【%s】",no.size(),no.stream().map(i-> i.getId() ).collect(Collectors.joining(","))));
            }
            if(can.size()>0){
                 tips.setOkMsg(msgs.stream().collect(Collectors.joining()));
            }else {
                tips.setFailureMsg(msgs.stream().collect(Collectors.joining()));
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

}
