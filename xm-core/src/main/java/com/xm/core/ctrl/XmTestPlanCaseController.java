package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmTestPlanCase;
import com.xm.core.service.XmTestPlanCaseService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;
import java.util.stream.Collectors;

import static com.mdp.core.utils.BaseUtils.*;
import static com.mdp.core.utils.ResponseHelper.failed;

/**
 * url编制采用rest风格,如对xm_test_plan_case 测试计划与用例关系表的操作有增删改查,对应的url分别为:<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTestPlanCase 表 xm_test_plan_case 当前主键(包括多主键): case_id,plan_id; 
 ***/
@RestController("xm.core.xmTestPlanCaseController")
@RequestMapping(value="/**/core/xmTestPlanCase")
@Api(tags={"测试计划与用例关系表操作接口"})
public class XmTestPlanCaseController {
	
	static Logger logger =LoggerFactory.getLogger(XmTestPlanCaseController.class);
	
	@Autowired
	private XmTestPlanCaseService xmTestPlanCaseService;
	 

	Map<String,Object> fieldsMap = toMap(new XmTestPlanCase());
 
	
	@ApiOperation( value = "查询测试计划与用例关系表信息列表",notes=" ")
	@ApiEntityParams( XmTestPlanCase.class )
	@ApiImplicitParams({
			@ApiImplicitParam(name="pageSize",value="每页大小，默认20条",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="count",value="是否计算总记录条数，如果count=true,则计算计算总条数，如果count=false 则不计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student desc",required=false),
 	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestPlanCase.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTestPlanCase( @ApiIgnore @RequestParam Map<String,Object> xmTestPlanCase){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmTestPlanCase, "pkList");
		PageUtils.startPage(xmTestPlanCase);
		List<Map<String,Object>>	xmTestPlanCaseList = xmTestPlanCaseService.selectListMapByWhere(xmTestPlanCase);	//列出XmTestPlanCase列表
		PageUtils.responePage(m, xmTestPlanCaseList);
		m.put("data",xmTestPlanCaseList);

		m.put("tips", tips);
		return m;
	}
	
 
	

	@ApiOperation( value = "新增一条测试计划与用例关系表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestPlanCase.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTestPlanCase(@RequestBody XmTestPlanCase xmTestPlanCase) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
		    boolean createPk=false;
			if(!StringUtils.hasText(xmTestPlanCase.getCaseId())) {
			    createPk=true;
				xmTestPlanCase.setCaseId(xmTestPlanCaseService.createKey("caseId"));
			}
			if(!StringUtils.hasText(xmTestPlanCase.getPlanId())) {
			    createPk=true;
				xmTestPlanCase.setPlanId(xmTestPlanCaseService.createKey("planId"));
			}
			if(createPk==false){
                 if(xmTestPlanCaseService.selectOneObject(xmTestPlanCase) !=null ){
                    return failed("pk-exists","编号重复，请修改编号再提交");
                }
            }
			xmTestPlanCaseService.insert(xmTestPlanCase);
			m.put("data",xmTestPlanCase);
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

	@ApiOperation( value = "删除一条测试计划与用例关系表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmTestPlanCase(@RequestBody XmTestPlanCase xmTestPlanCase){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
            if(!StringUtils.hasText(xmTestPlanCase.getCaseId())) {
                 return failed("pk-not-exists","请上送主键参数caseId");
            }
            if(!StringUtils.hasText(xmTestPlanCase.getPlanId())) {
                 return failed("pk-not-exists","请上送主键参数planId");
            }
            XmTestPlanCase xmTestPlanCaseDb = xmTestPlanCaseService.selectOneObject(xmTestPlanCase);
            if( xmTestPlanCaseDb == null ){
                return failed("data-not-exists","数据不存在，无法删除");
            }
			xmTestPlanCaseService.deleteByPk(xmTestPlanCase);
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

	@ApiOperation( value = "根据主键修改一条测试计划与用例关系表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestPlanCase.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTestPlanCase(@RequestBody XmTestPlanCase xmTestPlanCase) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmTestPlanCase.getCaseId())) {
                 return failed("pk-not-exists","请上送主键参数caseId");
            }
            if(!StringUtils.hasText(xmTestPlanCase.getPlanId())) {
                 return failed("pk-not-exists","请上送主键参数planId");
            }
            XmTestPlanCase xmTestPlanCaseDb = xmTestPlanCaseService.selectOneObject(xmTestPlanCase);
            if( xmTestPlanCaseDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			xmTestPlanCaseService.updateSomeFieldByPk(xmTestPlanCase);
			m.put("data",xmTestPlanCase);
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
    @ApiEntityParams( value = XmTestPlanCase.class, props={ }, remark = "测试计划与用例关系表", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTestPlanCase.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmTestPlanCaseMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			List<Map<String,Object>> pkList= (List<Map<String,Object>>) xmTestPlanCaseMap.get("pkList");
			if(pkList==null || pkList.size()==0){
				return failed("pkList-0","pkList不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("caseId");
            fields.add("planId");
			for (String fieldName : xmTestPlanCaseMap.keySet()) {
				if(fields.contains(fieldName)){
					return failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmTestPlanCaseMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmTestPlanCaseMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return failed("fieldKey-0","没有需要更新的字段");
 			}
			XmTestPlanCase xmTestPlanCase = fromMap(xmTestPlanCaseMap,XmTestPlanCase.class);
			List<XmTestPlanCase> xmTestPlanCasesDb=xmTestPlanCaseService.selectListByIds(pkList);
			if(xmTestPlanCasesDb==null ||xmTestPlanCasesDb.size()==0){
				return failed("data-0","记录已不存在");
			}
			List<XmTestPlanCase> can=new ArrayList<>();
			List<XmTestPlanCase> no=new ArrayList<>();
			User user = LoginUtils.getCurrentUserInfo();
			for (XmTestPlanCase xmTestPlanCaseDb : xmTestPlanCasesDb) {
				Tips tips2 = new Tips("检查通过"); 
				if(!tips2.isOk()){
				    no.add(xmTestPlanCaseDb); 
				}else{
					can.add(xmTestPlanCaseDb);
				}
			}
			if(can.size()>0){
                xmTestPlanCaseMap.put("pkList",can.stream().map(i->map( "caseId",i.getCaseId(),  "planId",i.getPlanId())).collect(Collectors.toList()));
			    xmTestPlanCaseService.editSomeFields(xmTestPlanCaseMap); 
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

	@ApiOperation( value = "根据主键列表批量删除测试计划与用例关系表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmTestPlanCase(@RequestBody List<XmTestPlanCase> xmTestPlanCases) {
		Map<String,Object> m = new HashMap<>();
        Tips tips=new Tips("成功删除"); 
        try{ 
            if(xmTestPlanCases.size()<=0){
                return failed("data-0","请上送待删除数据列表");
            }
             List<XmTestPlanCase> datasDb=xmTestPlanCaseService.selectListByIds(xmTestPlanCases.stream().map(i->map( "caseId",i.getCaseId() ,  "planId",i.getPlanId() )).collect(Collectors.toList()));

            List<XmTestPlanCase> can=new ArrayList<>();
            List<XmTestPlanCase> no=new ArrayList<>();
            for (XmTestPlanCase data : datasDb) {
                if(true){
                    can.add(data);
                }else{
                    no.add(data);
                } 
            }
            List<String> msgs=new ArrayList<>();
            if(can.size()>0){
                xmTestPlanCaseService.batchDelete(can);
                msgs.add(String.format("成功删除%s条数据.",can.size()));
            }
    
            if(no.size()>0){ 
                msgs.add(String.format("以下%s条数据不能删除.【%s】",no.size(),no.stream().map(i-> i.getCaseId() +" "+ i.getPlanId() ).collect(Collectors.joining(","))));
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
