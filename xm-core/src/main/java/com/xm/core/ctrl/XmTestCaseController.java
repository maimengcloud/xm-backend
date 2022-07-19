package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmTestCase;
import com.xm.core.service.XmTestCaseService;
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
 * url编制采用rest风格,如对xm_test_case 测试用例的操作有增删改查,对应的url分别为:<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTestCase 表 xm_test_case 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmTestCaseController")
@RequestMapping(value="/**/core/xmTestCase")
@Api(tags={"测试用例操作接口"})
public class XmTestCaseController {
	
	static Logger logger =LoggerFactory.getLogger(XmTestCaseController.class);
	
	@Autowired
	private XmTestCaseService xmTestCaseService;
	 

	Map<String,Object> fieldsMap = toMap(new XmTestCase());
 
	
	@ApiOperation( value = "查询测试用例信息列表",notes=" ")
	@ApiEntityParams( XmTestCase.class )
	@ApiImplicitParams({
			@ApiImplicitParam(name="pageSize",value="每页大小，默认20条",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="count",value="是否计算总记录条数，如果count=true,则计算计算总条数，如果count=false 则不计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student desc",required=false),
 	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestCase.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTestCase( @ApiIgnore @RequestParam Map<String,Object> xmTestCase){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmTestCase, "ids");
		RequestUtils.transformArray(xmTestCase, "menuIds");
		PageUtils.startPage(xmTestCase);
		String id= (String) xmTestCase.get("id");
		String menuId= (String) xmTestCase.get("menuId");
		Object ids=  xmTestCase.get("ids");
		Object menuIds=  xmTestCase.get("menuIds");
		String productId= (String) xmTestCase.get("productId");
		String myUserid= (String) xmTestCase.get("myUserid");
		String projectId= (String) xmTestCase.get("projectId");
		if(   !( StringUtils.hasText(myUserid) ||StringUtils.hasText(id) || StringUtils.hasText(menuId) || StringUtils.hasText(productId)|| StringUtils.hasText(projectId)||menuIds!=null||ids!=null  ) ){
			xmTestCase.put("compete", LoginUtils.getCurrentUserInfo().getUserid());
		}
		List<Map<String,Object>>	xmTestCaseList = xmTestCaseService.selectListMapByWhere(xmTestCase);	//列出XmTestCase列表
		PageUtils.responePage(m, xmTestCaseList);
		m.put("data",xmTestCaseList);

		m.put("tips", tips);
		return m;
	}
	
 

	@ApiOperation( value = "新增一条测试用例信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestCase.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTestCase(@RequestBody XmTestCase xmTestCase) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
		    boolean createPk=false;
			if(!StringUtils.hasText(xmTestCase.getId())) {
			    createPk=true;
				xmTestCase.setId(xmTestCaseService.createKey("id"));
			}
			if(createPk==false){
                 if(xmTestCaseService.selectOneObject(xmTestCase) !=null ){
                    return failed("pk-exists","编号重复，请修改编号再提交");
                }
            }
			User user=LoginUtils.getCurrentUserInfo();
			xmTestCase.setCuserid(user.getUserid());
			xmTestCase.setLuserid(user.getUserid());
			xmTestCase.setLusername(user.getUsername());
			xmTestCase.setCusername(user.getUsername());
			xmTestCase.setCtime(new Date());
			xmTestCase.setLtime(new Date());
			xmTestCase.setCbranchId(user.getBranchId());
			xmTestCaseService.insert(xmTestCase);
			m.put("data",xmTestCase);
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

	@ApiOperation( value = "删除一条测试用例信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmTestCase(@RequestBody XmTestCase xmTestCase){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
            if(!StringUtils.hasText(xmTestCase.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmTestCase xmTestCaseDb = xmTestCaseService.selectOneObject(xmTestCase);
            if( xmTestCaseDb == null ){
                return failed("data-not-exists","数据不存在，无法删除");
            }
			xmTestCaseService.deleteByPk(xmTestCase);
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

	@ApiOperation( value = "根据主键修改一条测试用例信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestCase.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTestCase(@RequestBody XmTestCase xmTestCase) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmTestCase.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmTestCase xmTestCaseDb = xmTestCaseService.selectOneObject(xmTestCase);
            if( xmTestCaseDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			User user=LoginUtils.getCurrentUserInfo();
			xmTestCase.setLuserid(user.getUserid());
			xmTestCase.setLusername(user.getUsername());
			xmTestCase.setLtime(new Date());
			xmTestCaseService.updateSomeFieldByPk(xmTestCase);
			m.put("data",xmTestCase);
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
    @ApiEntityParams( value = XmTestCase.class, props={ }, remark = "测试用例", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTestCase.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmTestCaseMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            List<String> ids= (List<String>) xmTestCaseMap.get("ids");
			if(ids==null || ids.size()==0){
				return failed("ids-0","ids不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("id");
			for (String fieldName : xmTestCaseMap.keySet()) {
				if(fields.contains(fieldName)){
					return failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmTestCaseMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmTestCaseMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return failed("fieldKey-0","没有需要更新的字段");
 			}
			XmTestCase xmTestCase = fromMap(xmTestCaseMap,XmTestCase.class);
			List<XmTestCase> xmTestCasesDb=xmTestCaseService.selectListByIds(ids);
			if(xmTestCasesDb==null ||xmTestCasesDb.size()==0){
				return failed("data-0","记录已不存在");
			}
			List<XmTestCase> can=new ArrayList<>();
			List<XmTestCase> no=new ArrayList<>();
			User user = LoginUtils.getCurrentUserInfo();
			for (XmTestCase xmTestCaseDb : xmTestCasesDb) {
				Tips tips2 = new Tips("检查通过"); 
				if(!tips2.isOk()){
				    no.add(xmTestCaseDb); 
				}else{
					can.add(xmTestCaseDb);
				}
			}
			if(can.size()>0){
                xmTestCaseMap.put("ids",can.stream().map(i->i.getId()).collect(Collectors.toList()));
			    xmTestCaseService.editSomeFields(xmTestCaseMap); 
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

	@ApiOperation( value = "根据主键列表批量删除测试用例信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmTestCase(@RequestBody List<XmTestCase> xmTestCases) {
		Map<String,Object> m = new HashMap<>();
        Tips tips=new Tips("成功删除"); 
        try{ 
            if(xmTestCases.size()<=0){
                return failed("data-0","请上送待删除数据列表");
            }
             List<XmTestCase> datasDb=xmTestCaseService.selectListByIds(xmTestCases.stream().map(i-> i.getId() ).collect(Collectors.toList()));

            List<XmTestCase> can=new ArrayList<>();
            List<XmTestCase> no=new ArrayList<>();
            for (XmTestCase data : datasDb) {
                if(true){
                    can.add(data);
                }else{
                    no.add(data);
                } 
            }
            List<String> msgs=new ArrayList<>();
            if(can.size()>0){
                xmTestCaseService.batchDelete(can);
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
