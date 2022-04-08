package com.xm.core.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.xm.core.service.XmProductStateHisService;
import com.xm.core.entity.XmProductStateHis;
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
	public Map<String,Object> listXmProductStateHis( @RequestParam Map<String,Object> xmProductStateHis){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmProductStateHis, "pkList");
		PageUtils.startPage(xmProductStateHis);
		List<Map<String,Object>>	xmProductStateHisList = xmProductStateHisService.selectListMapByWhere(xmProductStateHis);	//列出XmProductStateHis列表
		PageUtils.responePage(m, xmProductStateHisList);
		m.put("data",xmProductStateHisList);

		m.put("tips", tips);
		return m;
	}
	
 
	
	/**
	@ApiOperation( value = "新增一条功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProductStateHis.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmProductStateHis(@RequestBody XmProductStateHis xmProductStateHis) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
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
			m.put("data",xmProductStateHis);
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
	@ApiOperation( value = "删除一条功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmProductStateHis(@RequestBody XmProductStateHis xmProductStateHis){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
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
	@ApiOperation( value = "根据主键修改一条功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmProductStateHis.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmProductStateHis(@RequestBody XmProductStateHis xmProductStateHis) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
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
			m.put("data",xmProductStateHis);
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
	@ApiOperation( value = "根据主键列表批量删除功能状态表,无需前端维护，所有数据由汇总统计得出信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmProductStateHis(@RequestBody List<XmProductStateHis> xmProductStateHiss) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+xmProductStateHiss.size()+"条数据"); 
		try{ 
			xmProductStateHisService.batchDelete(xmProductStateHiss);
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
