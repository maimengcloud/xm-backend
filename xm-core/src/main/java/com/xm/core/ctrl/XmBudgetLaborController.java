package com.xm.core.ctrl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mdp.core.entity.Result;
import com.mdp.core.entity.Tips;
import com.mdp.core.query.QueryTools;
import com.mdp.core.utils.RequestUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmBudgetLabor;
import com.xm.core.service.XmBudgetLaborService;
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

/**
 * url编制采用rest风格,如对xm_budget_labor 项目人力成本预算的操作有增删改查,对应的url分别为:<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmBudgetLabor 表 xm_budget_labor 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmBudgetLaborController")
@RequestMapping(value="/**/core/xmBudgetLabor")
@Api(tags={"项目人力成本预算操作接口"})
public class XmBudgetLaborController {
	
	static Logger logger =LoggerFactory.getLogger(XmBudgetLaborController.class);
	
	@Autowired
	private XmBudgetLaborService xmBudgetLaborService;
	 

	Map<String,Object> fieldsMap = toMap(new XmBudgetLabor());
 
	
	@ApiOperation( value = "查询项目人力成本预算信息列表",notes=" ")
	@ApiEntityParams( XmBudgetLabor.class )
	@ApiImplicitParams({
			@ApiImplicitParam(name="pageSize",value="每页大小，默认20条",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="count",value="是否计算总记录条数，如果count=true,则计算计算总条数，如果count=false 则不计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student desc",required=false),
 	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmBudgetLabor.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Result listXmBudgetLabor(@ApiIgnore @RequestParam Map<String,Object> params){
		
		
		RequestUtils.transformArray(params, "ids");		
		IPage page=QueryTools.initPage(params);
		QueryWrapper<XmBudgetLabor> qw = QueryTools.initQueryWrapper(XmBudgetLabor.class , params);
		List<Map<String,Object>> datas = xmBudgetLaborService.selectListMapByWhere(page,qw,params);
			return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());	//列出XmBudgetLabor列表

	}

	@ApiResponses({
			@ApiResponse(code = 200,response= XmBudgetLabor.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listSum",method=RequestMethod.GET)
	public Result listSum(@ApiIgnore @RequestParam Map<String,Object> params){
		
		RequestUtils.transformArray(params, "ids");		
		IPage page=QueryTools.initPage(params);
		List<Map<String,Object>>	data = xmBudgetLaborService.listSum(params);	//列出XmProjectMBudgetCostUser列表 
		return Result.ok().setData(data);
		
		
	}

	@ApiOperation( value = "新增一条项目人力成本预算信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmBudgetLabor.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result addXmBudgetLabor(@RequestBody XmBudgetLabor xmBudgetLabor) {

		    boolean createPk=false;
			if(!StringUtils.hasText(xmBudgetLabor.getId())) {
			    createPk=true;
				xmBudgetLabor.setId(xmBudgetLaborService.createKey("id"));
			}
			if(createPk==false){
                 if(xmBudgetLaborService.selectOneObject(xmBudgetLabor) !=null ){
                    return Result.error("pk-exists","编号重复，请修改编号再提交");
                }
            }
			xmBudgetLaborService.insert(xmBudgetLabor);
			
		return Result.ok();  
		
	}

	@ApiOperation( value = "删除一条项目人力成本预算信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Result delXmBudgetLabor(@RequestBody XmBudgetLabor xmBudgetLabor){

            if(!StringUtils.hasText(xmBudgetLabor.getId())) {
                 return Result.error("pk-not-exists","请上送主键参数id");
            }
            XmBudgetLabor xmBudgetLaborDb = xmBudgetLaborService.selectOneObject(xmBudgetLabor);
            if( xmBudgetLaborDb == null ){
                return Result.error("data-not-exists","数据不存在，无法删除");
            }
			xmBudgetLaborService.deleteByPk(xmBudgetLabor);
		return Result.ok();
		
	}

	@ApiOperation( value = "根据主键修改一条项目人力成本预算信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmBudgetLabor.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Result editXmBudgetLabor(@RequestBody XmBudgetLabor xmBudgetLabor) {

            if(!StringUtils.hasText(xmBudgetLabor.getId())) {
                 return Result.error("pk-not-exists","请上送主键参数id");
            }
            XmBudgetLabor xmBudgetLaborDb = xmBudgetLaborService.selectOneObject(xmBudgetLabor);
            if( xmBudgetLaborDb == null ){
                return Result.error("data-not-exists","数据不存在，无法修改");
            }
			xmBudgetLaborService.updateSomeFieldByPk(xmBudgetLabor);
		return Result.ok();
	}

    @ApiOperation( value = "批量修改某些字段",notes="")
    @ApiEntityParams( value = XmBudgetLabor.class, props={ }, remark = "项目人力成本预算", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmBudgetLabor.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Result editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmBudgetLaborMap) {

            List<String> ids= (List<String>) xmBudgetLaborMap.get("ids");
			if(ids==null || ids.size()==0){
				return Result.error("ids-0","ids不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("id");
			for (String fieldName : xmBudgetLaborMap.keySet()) {
				if(fields.contains(fieldName)){
					return Result.error(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmBudgetLaborMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmBudgetLaborMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return Result.error("fieldKey-0","没有需要更新的字段");
 			}
			XmBudgetLabor xmBudgetLabor = fromMap(xmBudgetLaborMap,XmBudgetLabor.class);
			List<XmBudgetLabor> xmBudgetLaborsDb=xmBudgetLaborService.selectListByIds(ids);
			if(xmBudgetLaborsDb==null ||xmBudgetLaborsDb.size()==0){
				return Result.error("data-0","记录已不存在");
			}
			List<XmBudgetLabor> can=new ArrayList<>();
			List<XmBudgetLabor> no=new ArrayList<>();
			User user = LoginUtils.getCurrentUserInfo();
			for (XmBudgetLabor xmBudgetLaborDb : xmBudgetLaborsDb) {
 				Tips tips2 = new Tips("检查通过"); 
				if(!tips2.isOk()){
				    no.add(xmBudgetLaborDb); 
				}else{
					can.add(xmBudgetLaborDb);
				}
			}
			if(can.size()>0){
                xmBudgetLaborMap.put("ids",can.stream().map(i->i.getId()).collect(Collectors.toList()));
			    xmBudgetLaborService.editSomeFields(xmBudgetLaborMap); 
			}
			List<String> msgs=new ArrayList<>();
			if(can.size()>0){
				msgs.add(String.format("成功更新以下%s条数据",can.size()));
			}
			if(no.size()>0){
				msgs.add(String.format("以下%s个数据无权限更新",no.size()));
			}
			if(can.size()>0){
				return Result.ok(msgs.stream().collect(Collectors.joining()));
			}else {
				return Result.error(msgs.stream().collect(Collectors.joining()));
			} 
		
	}


	@ApiOperation( value = "批量新增人力预算",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	})
	@RequestMapping(value="/batchAdd",method=RequestMethod.POST)
	public Result batchAddXmBudgetLabor(@RequestBody List<XmBudgetLabor> xmBudgetLabors) {

			if(xmBudgetLabors.size()<=0){
				return Result.error("data-0","请上送待新增数据列表");
			}
			List<XmBudgetLabor> datasDb=xmBudgetLabors;
			List<XmBudgetLabor> can=new ArrayList<>();
			List<XmBudgetLabor> no=new ArrayList<>();
			for (XmBudgetLabor data : datasDb) {
				if(true){
					data.setId(this.xmBudgetLaborService.createKey("id"));
					can.add(data);
				}else{
					no.add(data);
				}
			}
			List<String> msgs=new ArrayList<>();
			if(can.size()>0){
				xmBudgetLaborService.batchInsert(can);
				msgs.add(String.format("成功新增%s条数据.",can.size()));
			}

			if(no.size()>0){
				msgs.add(String.format("以下%s条数据不能新增.【%s】",no.size(),no.stream().map(i-> i.getId() ).collect(Collectors.joining(","))));
			}
			if(can.size()>0){
				return Result.ok(msgs.stream().collect(Collectors.joining()));
			}else {
				return Result.error(msgs.stream().collect(Collectors.joining()));
			}
		
	}

	@ApiOperation( value = "根据主键列表批量删除项目人力成本预算信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Result batchDelXmBudgetLabor(@RequestBody List<XmBudgetLabor> xmBudgetLabors) {
		
        
        
            if(xmBudgetLabors.size()<=0){
                return Result.error("data-0","请上送待删除数据列表");
            }
             List<XmBudgetLabor> datasDb=xmBudgetLaborService.selectListByIds(xmBudgetLabors.stream().map(i-> i.getId() ).collect(Collectors.toList()));

            List<XmBudgetLabor> can=new ArrayList<>();
            List<XmBudgetLabor> no=new ArrayList<>();
            for (XmBudgetLabor data : datasDb) {
                if(true){
                    can.add(data);
                }else{
                    no.add(data);
                } 
            }
            List<String> msgs=new ArrayList<>();
            if(can.size()>0){
                xmBudgetLaborService.batchDelete(can);
                msgs.add(String.format("成功删除%s条数据.",can.size()));
            }
    
            if(no.size()>0){ 
                msgs.add(String.format("以下%s条数据不能删除.【%s】",no.size(),no.stream().map(i-> i.getId() ).collect(Collectors.joining(","))));
            }
            if(can.size()>0){
                 return Result.ok(msgs.stream().collect(Collectors.joining()));
            }else {
                return Result.error(msgs.stream().collect(Collectors.joining()));
            } 
        
	} 

}
