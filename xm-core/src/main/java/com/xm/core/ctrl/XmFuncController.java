package com.xm.core.ctrl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mdp.core.entity.Result;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.query.QueryTools;
import com.mdp.core.utils.RequestUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.sensitive.SensitiveWordService;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmBranchStateHis;
import com.xm.core.entity.XmFunc;
import com.xm.core.entity.XmProduct;
import com.xm.core.service.XmFuncService;
import com.xm.core.service.XmProductQxService;
import com.xm.core.service.XmProductService;
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
 * url编制采用rest风格,如对xm_func 功能模块表的操作有增删改查,对应的url分别为:<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmFunc 表 xm_func 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmFuncController")
@RequestMapping(value="/**/core/xmFunc")
@Api(tags={"功能模块表操作接口"})
public class XmFuncController {
	
	static Logger logger =LoggerFactory.getLogger(XmFuncController.class);
	
	@Autowired
	private XmFuncService xmFuncService;


	@Autowired
	private XmProductService xmProductService;
	@Autowired
	private XmProductQxService productQxService;

	@Autowired
	SensitiveWordService sensitiveWordService;
	 

	Map<String,Object> fieldsMap = toMap(new XmFunc());
 
	
	@ApiOperation( value = "查询功能模块表信息列表",notes=" ")
	@ApiEntityParams( XmFunc.class )
	@ApiImplicitParams({
			@ApiImplicitParam(name="pageSize",value="每页大小，默认20条",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="count",value="是否计算总记录条数，如果count=true,则计算计算总条数，如果count=false 则不计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student desc",required=false),
 	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmFunc.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Result listXmFunc(@ApiIgnore @RequestParam Map<String,Object> params){
		
		
		RequestUtils.transformArray(params, "ids");		
		IPage page=QueryTools.initPage(params);
		QueryWrapper<XmBranchStateHis> qw = QueryTools.initQueryWrapper(XmBranchStateHis.class , params);
		List<Map<String,Object>> datas = sensitiveWordService.selectListMapByWhere(page,qw,params);
			return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());	//列出XmFunc列表

	}
	
 

	@ApiOperation( value = "新增一条功能模块表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmFunc.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result addXmFunc(@RequestBody XmFunc xmFunc) {

		    boolean createPk=false;
			if(!StringUtils.hasText(xmFunc.getId())) {
			    createPk=true;
				xmFunc.setId(xmFuncService.createKey("id"));
			}
			if(createPk==false){
                 if(xmFuncService.selectOneObject(xmFunc) !=null ){
                    return Result.error("pk-exists","编号重复，请修改编号再提交");
                }
            }
			Set<String> words=sensitiveWordService.getSensitiveWord(xmFunc.getName());
			if(words!=null && words.size()>0){
				return Result.error("name-sensitive-word","名字有敏感词"+words+",请修改后再提交");
			}
			if(!StringUtils.hasText(xmFunc.getProductId())){
				return Result.error("productId-0","产品编号不能为空");
			}
			User user=LoginUtils.getCurrentUserInfo();
			XmProduct xmProduct=xmProductService.getProductFromCache(xmFunc.getProductId());
			tips=productQxService.checkProductQx(xmProduct,2,user);
			if(!tips.isOk()){
				return Result.error(tips);
			}
			xmFunc.setPbranchId(xmProduct.getBranchId());
			xmFuncService.parentIdPathsCalcBeforeSave(xmFunc);
			xmFuncService.insert(xmFunc);
		
	}

	@ApiOperation( value = "删除一条功能模块表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Result delXmFunc(@RequestBody XmFunc xmFunc){

            if(!StringUtils.hasText(xmFunc.getId())) {
                 return Result.error("pk-not-exists","请上送主键参数id");
            }
            XmFunc xmFuncDb = xmFuncService.selectOneObject(xmFunc);
            if( xmFuncDb == null ){
                return Result.error("data-not-exists","数据不存在，无法删除");
            }
            Long childcnt=xmFuncService.countByWhere(map("pid",xmFuncDb.getId()));
            if(childcnt>0){
				return Result.error("childcnt-not-0","至少还有"+childcnt+"个子节点,请先删除子节点，再删除父节点");
			}
			xmFuncService.deleteByPk(xmFunc);
		return Result.ok();
		
	}

	@ApiOperation( value = "根据主键修改一条功能模块表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmFunc.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Result editXmFunc(@RequestBody XmFunc xmFunc) {

            if(!StringUtils.hasText(xmFunc.getId())) {
                 return Result.error("pk-not-exists","请上送主键参数id");
            }
            XmFunc xmFuncDb = xmFuncService.selectOneObject(xmFunc);
            if( xmFuncDb == null ){
                return Result.error("data-not-exists","数据不存在，无法修改");
            }
			xmFuncService.updateSomeFieldByPk(xmFunc);
		
	}

    @ApiOperation( value = "批量修改某些字段",notes="")
    @ApiEntityParams( value = XmFunc.class, props={ }, remark = "功能模块表", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmFunc.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Result editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmFuncMap) {

            List<String> ids= (List<String>) xmFuncMap.get("ids");
			if(ids==null || ids.size()==0){
				return Result.error("ids-0","ids不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("id");
			fields.add("pidPaths");
			for (String fieldName : xmFuncMap.keySet()) {
				if(fields.contains(fieldName)){
					return Result.error(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmFuncMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmFuncMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return Result.error("fieldKey-0","没有需要更新的字段");
 			}
			XmFunc xmFunc = fromMap(xmFuncMap,XmFunc.class);
			List<XmFunc> xmFuncsDb=xmFuncService.selectListByIds(ids);
			if(xmFuncsDb==null ||xmFuncsDb.size()==0){
				return Result.error("data-0","记录已不存在");
			}
			List<XmFunc> can=new ArrayList<>();
			List<XmFunc> no=new ArrayList<>();
			User user = LoginUtils.getCurrentUserInfo();
			for (XmFunc xmFuncDb : xmFuncsDb) {
				Tips tips2 = new Tips("检查通过"); 
				if(!tips2.isOk()){
				    no.add(xmFuncDb); 
				}else{
					can.add(xmFuncDb);
				}
			}
			if(can.size()>0){
				if(xmFuncMap.containsKey("pid")){
					if(can.size()>1){
						return Result.error("pid-1","修改上级归属只能一个个节点修改，不能批量修改");
					}
					xmFuncService.parentIdPathsCalcBeforeSave(can.get(0));
					xmFuncMap.put("pidPaths",can.get(0).getPidPaths());
				}
                xmFuncMap.put("ids",can.stream().map(i->i.getId()).collect(Collectors.toList()));
			    xmFuncService.editSomeFields(xmFuncMap); 
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
			//
		return Result.ok();
		
	}

	@ApiOperation( value = "根据主键列表批量删除功能模块表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Result batchDelXmFunc(@RequestBody List<XmFunc> xmFuncs) {
		
        
        
            if(xmFuncs.size()<=0){
                return Result.error("data-0","请上送待删除数据列表");
            }
             List<XmFunc> datasDb=xmFuncService.selectListByIds(xmFuncs.stream().map(i-> i.getId() ).collect(Collectors.toList()));

            List<XmFunc> can=new ArrayList<>();
            List<XmFunc> no=new ArrayList<>();
            for (XmFunc data : datasDb) {
                if(true){
                    can.add(data);
                }else{
                    no.add(data);
                } 
            }
            List<String> msgs=new ArrayList<>();
            if(can.size()>0){
                xmFuncService.batchDelete(can);
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
        return Result.ok();
        
	} 

}
