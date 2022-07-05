package com.xm.core.ctrl;

import java.util.*;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;

import static com.mdp.core.utils.ResponseHelper.*;
import static com.mdp.core.utils.BaseUtils.*;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.mybatis.PageUtils;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.NumberUtil;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.swagger.ApiEntityParams;
import springfox.documentation.annotations.ApiIgnore;

import com.xm.core.service.XmTaskOrderService;
import com.xm.core.entity.XmTaskOrder;

/**
 * url编制采用rest风格,如对xm_task_order 任务相关费用订单表的操作有增删改查,对应的url分别为:<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTaskOrder 表 xm_task_order 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmTaskOrderController")
@RequestMapping(value="/**/core/xmTaskOrder")
@Api(tags={"任务相关费用订单表操作接口"})
public class XmTaskOrderController {
	
	static Logger logger =LoggerFactory.getLogger(XmTaskOrderController.class);
	
	@Autowired
	private XmTaskOrderService xmTaskOrderService;
	 

	Map<String,Object> fieldsMap = toMap(new XmTaskOrder());
 
	
	@ApiOperation( value = "查询任务相关费用订单表信息列表",notes=" ")
	@ApiEntityParams( XmTaskOrder.class )
	@ApiImplicitParams({
			@ApiImplicitParam(name="pageSize",value="每页大小，默认20条",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="count",value="是否计算总记录条数，如果count=true,则计算计算总条数，如果count=false 则不计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student desc",required=false),
 	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskOrder.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTaskOrder( @ApiIgnore @RequestParam Map<String,Object> xmTaskOrder){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmTaskOrder, "ids");
		PageUtils.startPage(xmTaskOrder);
		List<Map<String,Object>>	xmTaskOrderList = xmTaskOrderService.selectListMapByWhere(xmTaskOrder);	//列出XmTaskOrder列表
		PageUtils.responePage(m, xmTaskOrderList);
		m.put("data",xmTaskOrderList);

		m.put("tips", tips);
		return m;
	}
	
 
	
	/**
	@ApiOperation( value = "新增一条任务相关费用订单表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskOrder.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTaskOrder(@RequestBody XmTaskOrder xmTaskOrder) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
		    boolean createPk=false;
			if(!StringUtils.hasText(xmTaskOrder.getId())) {
			    createPk=true;
				xmTaskOrder.setId(xmTaskOrderService.createKey("id"));
			}
			if(createPk==false){
                 if(xmTaskOrderService.selectOneObject(xmTaskOrder) !=null ){
                    return failed("pk-exists","编号重复，请修改编号再提交");
                }
            }
			xmTaskOrderService.insert(xmTaskOrder);
			m.put("data",xmTaskOrder);
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
	@ApiOperation( value = "删除一条任务相关费用订单表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmTaskOrder(@RequestBody XmTaskOrder xmTaskOrder){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
            if(!StringUtils.hasText(xmTaskOrder.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmTaskOrder xmTaskOrderDb = xmTaskOrderService.selectOneObject(xmTaskOrder);
            if( xmTaskOrderDb == null ){
                return failed("data-not-exists","数据不存在，无法删除");
            }
			xmTaskOrderService.deleteByPk(xmTaskOrder);
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
	@ApiOperation( value = "根据主键修改一条任务相关费用订单表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskOrder.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTaskOrder(@RequestBody XmTaskOrder xmTaskOrder) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmTaskOrder.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmTaskOrder xmTaskOrderDb = xmTaskOrderService.selectOneObject(xmTaskOrder);
            if( xmTaskOrderDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			xmTaskOrderService.updateSomeFieldByPk(xmTaskOrder);
			m.put("data",xmTaskOrder);
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
    @ApiOperation( value = "批量修改某些字段",notes="")
    @ApiEntityParams( value = XmTaskOrder.class, props={ }, remark = "任务相关费用订单表", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskOrder.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmTaskOrderMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            List<String> ids= (List<String>) xmTaskOrderMap.get("ids");
			if(ids==null || ids.size()==0){
				return failed("ids-0","ids不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("id");
			for (String fieldName : xmTaskOrderMap.keySet()) {
				if(fields.contains(fieldName)){
					return failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmTaskOrderMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmTaskOrderMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return failed("fieldKey-0","没有需要更新的字段");
 			}
			XmTaskOrder xmTaskOrder = fromMap(xmTaskOrderMap,XmTaskOrder.class);
			List<XmTaskOrder> xmTaskOrdersDb=xmTaskOrderService.selectListByIds(ids);
			if(xmTaskOrdersDb==null ||xmTaskOrdersDb.size()==0){
				return failed("data-0","记录已不存在");
			}
			List<XmTaskOrder> can=new ArrayList<>();
			List<XmTaskOrder> no=new ArrayList<>();
			User user = LoginUtils.getCurrentUserInfo();
			for (XmTaskOrder xmTaskOrderDb : xmTaskOrdersDb) {
				Tips tips2 = new Tips("检查通过"); 
				if(!tips2.isOk()){
				    no.add(xmTaskOrderDb); 
				}else{
					can.add(xmTaskOrderDb);
				}
			}
			if(can.size()>0){
                xmTaskOrderMap.put("ids",can.stream().map(i->i.getId()).collect(Collectors.toList()));
			    xmTaskOrderService.editSomeFields(xmTaskOrderMap); 
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
	*/

	/**
	@ApiOperation( value = "根据主键列表批量删除任务相关费用订单表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmTaskOrder(@RequestBody List<XmTaskOrder> xmTaskOrders) {
		Map<String,Object> m = new HashMap<>();
        Tips tips=new Tips("成功删除"); 
        try{ 
            if(xmTaskOrders.size()<=0){
                return failed("data-0","请上送待删除数据列表");
            }
             List<XmTaskOrder> datasDb=xmTaskOrderService.selectListByIds(xmTaskOrders.stream().map(i-> i.getId() ).collect(Collectors.toList()));

            List<XmTaskOrder> can=new ArrayList<>();
            List<XmTaskOrder> no=new ArrayList<>();
            for (XmTaskOrder data : datasDb) {
                if(true){
                    can.add(data);
                }else{
                    no.add(data);
                } 
            }
            List<String> msgs=new ArrayList<>();
            if(can.size()>0){
                xmTaskOrderService.batchDelete(can);
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
	*/
}
