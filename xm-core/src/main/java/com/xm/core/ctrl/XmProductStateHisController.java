package com.xm.core.ctrl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mdp.core.entity.Result;
import com.mdp.core.query.QueryTools;
import com.mdp.core.utils.RequestUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmProductStateHis;
import com.xm.core.service.XmProductStateHisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;
/**
 * url编制采用rest风格,如对xm_product_state_his 功能状态表,无需前端维护，所有数据由汇总统计得出的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmProductStateHis/add <br>
 *  查询: core/xmProductStateHis/list<br>
 *  模糊查询: core/xmProductStateHis/listKey<br>
 *  修改: core/xmProductStateHis/edit <br>
 *  删除: core/xmProductStateHis/del<br>
 *  批量删除: core/xmProductStateHis/batchDel<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmProductStateHis 表 xm_product_state_his 当前主键(包括多主键): product_id,biz_date; 
 ***/
@RestController("xm.core.xmProductStateHisController")
@RequestMapping(value="/**/core/xmProductStateHis")
@Api(tags={"功能状态表,无需前端维护，所有数据由汇总统计得出操作接口"})
public class XmProductStateHisController {
	
	static Logger logger =LoggerFactory.getLogger(XmProductStateHisController.class);
	
	@Autowired
	private XmProductStateHisService xmProductStateHisService;
	 
		
 
	
	@ApiOperation( value = "查询功能状态表,无需前端维护，所有数据由汇总统计得出信息列表",notes=" ") 
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProductStateHis.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Result listXmProductStateHis(@ApiIgnore @RequestParam Map<String,Object> params){
		
		
		RequestUtils.transformArray(params, "pkList");		
		IPage page=QueryTools.initPage(params);
		User user= LoginUtils.getCurrentUserInfo();
		params.put("branchId",user.getBranchId());
		QueryWrapper<XmBranchStateHis> qw = QueryTools.initQueryWrapper(XmBranchStateHis.class , params);
		List<Map<String,Object>> datas = QueryTools.xmProductStateHisService(page,qw,params);
			return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());	//列出XmProductStateHis列表

	}
	
 
	
	/**
	@ApiOperation( value = "新增一条功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProductStateHis.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result addXmProductStateHis(@RequestBody XmProductStateHis xmProductStateHis) {

		    boolean createPk=false;
			if(!StringUtils.hasText(xmProductStateHis.getProductId())) {
			    createPk=true;
				xmProductStateHis.setProductId(xmProductStateHisService.createKey("productId"));
			}
			if(!StringUtils.hasText(xmProductStateHis.getBizDate())) {
			    createPk=true;
				xmProductStateHis.setBizDate(xmProductStateHisService.createKey("bizDate"));
			}
			if(createPk==false){
                 if(xmProductStateHisService.selectOneObject(xmProductStateHis) !=null ){
                    return failed("pk-exists","编号重复，请修改编号再提交");
                }
            }
			xmProductStateHisService.insert(xmProductStateHis);
		
	}
	*/
	
	/**
	@ApiOperation( value = "删除一条功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Result delXmProductStateHis(@RequestBody XmProductStateHis xmProductStateHis){

            if(!StringUtils.hasText(xmProductStateHis.getProductId())) {
                 return failed("pk-not-exists","请上送主键参数productId");
            }
            if(!StringUtils.hasText(xmProductStateHis.getBizDate())) {
                 return failed("pk-not-exists","请上送主键参数bizDate");
            }
            XmProductStateHis xmProductStateHisDb = xmProductStateHisService.selectOneObject(xmProductStateHis);
            if( xmProductStateHisDb == null ){
                return failed("data-not-exists","数据不存在，无法删除");
            }
			xmProductStateHisService.deleteByPk(xmProductStateHis);
		return Result.ok();
		
	}
	 */
	
	/**
	@ApiOperation( value = "根据主键修改一条功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProductStateHis.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Result editXmProductStateHis(@RequestBody XmProductStateHis xmProductStateHis) {

            if(!StringUtils.hasText(xmProductStateHis.getProductId())) {
                 return failed("pk-not-exists","请上送主键参数productId");
            }
            if(!StringUtils.hasText(xmProductStateHis.getBizDate())) {
                 return failed("pk-not-exists","请上送主键参数bizDate");
            }
            XmProductStateHis xmProductStateHisDb = xmProductStateHisService.selectOneObject(xmProductStateHis);
            if( xmProductStateHisDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			xmProductStateHisService.updateSomeFieldByPk(xmProductStateHis);
		
	}
	*/
	

	
	/**
	@ApiOperation( value = "根据主键列表批量删除功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Result batchDelXmProductStateHis(@RequestBody List<XmProductStateHis> xmProductStateHiss) {
		
		
		
			xmProductStateHisService.batchDelete(xmProductStateHiss);
		return Result.ok();
		
	} 
	*/
}
