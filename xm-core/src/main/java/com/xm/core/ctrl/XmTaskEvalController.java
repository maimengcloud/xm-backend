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

import com.xm.core.service.XmTaskEvalService;
import com.xm.core.entity.XmTaskEval;

/**
 * url编制采用rest风格,如对xm_task_eval xm_task_eval的操作有增删改查,对应的url分别为:<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTaskEval 表 xm_task_eval 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmTaskEvalController")
@RequestMapping(value="/**/core/xmTaskEval")
@Api(tags={"xm_task_eval操作接口"})
public class XmTaskEvalController {
	
	static Logger logger =LoggerFactory.getLogger(XmTaskEvalController.class);
	
	@Autowired
	private XmTaskEvalService xmTaskEvalService;
	 

	Map<String,Object> fieldsMap = toMap(new XmTaskEval());
 
	
	@ApiOperation( value = "查询xm_task_eval信息列表",notes=" ")
	@ApiEntityParams( XmTaskEval.class )
	@ApiImplicitParams({
			@ApiImplicitParam(name="pageSize",value="每页大小，默认20条",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="count",value="是否计算总记录条数，如果count=true,则计算计算总条数，如果count=false 则不计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student desc",required=false),
 	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskEval.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTaskEval( @ApiIgnore @RequestParam Map<String,Object> xmTaskEval){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmTaskEval, "ids");
		PageUtils.startPage(xmTaskEval);
		List<Map<String,Object>>	xmTaskEvalList = xmTaskEvalService.selectListMapByWhere(xmTaskEval);	//列出XmTaskEval列表
		PageUtils.responePage(m, xmTaskEvalList);
		m.put("data",xmTaskEvalList);

		m.put("tips", tips);
		return m;
	}
	
 
	
	/**
	@ApiOperation( value = "新增一条xm_task_eval信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskEval.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTaskEval(@RequestBody XmTaskEval xmTaskEval) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
		    boolean createPk=false;
			if(!StringUtils.hasText(xmTaskEval.getId())) {
			    createPk=true;
				xmTaskEval.setId(xmTaskEvalService.createKey("id"));
			}
			if(createPk==false){
                 if(xmTaskEvalService.selectOneObject(xmTaskEval) !=null ){
                    return failed("pk-exists","编号重复，请修改编号再提交");
                }
            }
			xmTaskEvalService.insert(xmTaskEval);
			m.put("data",xmTaskEval);
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
	@ApiOperation( value = "删除一条xm_task_eval信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmTaskEval(@RequestBody XmTaskEval xmTaskEval){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
            if(!StringUtils.hasText(xmTaskEval.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmTaskEval xmTaskEvalDb = xmTaskEvalService.selectOneObject(xmTaskEval);
            if( xmTaskEvalDb == null ){
                return failed("data-not-exists","数据不存在，无法删除");
            }
			xmTaskEvalService.deleteByPk(xmTaskEval);
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
	@ApiOperation( value = "根据主键修改一条xm_task_eval信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskEval.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTaskEval(@RequestBody XmTaskEval xmTaskEval) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmTaskEval.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmTaskEval xmTaskEvalDb = xmTaskEvalService.selectOneObject(xmTaskEval);
            if( xmTaskEvalDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			xmTaskEvalService.updateSomeFieldByPk(xmTaskEval);
			m.put("data",xmTaskEval);
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
    @ApiEntityParams( value = XmTaskEval.class, props={ }, remark = "xm_task_eval", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskEval.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmTaskEvalMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            List<String> ids= (List<String>) xmTaskEvalMap.get("ids");
			if(ids==null || ids.size()==0){
				return failed("ids-0","ids不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("id");
			for (String fieldName : xmTaskEvalMap.keySet()) {
				if(fields.contains(fieldName)){
					return failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmTaskEvalMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmTaskEvalMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return failed("fieldKey-0","没有需要更新的字段");
 			}
			XmTaskEval xmTaskEval = fromMap(xmTaskEvalMap,XmTaskEval.class);
			List<XmTaskEval> xmTaskEvalsDb=xmTaskEvalService.selectListByIds(ids);
			if(xmTaskEvalsDb==null ||xmTaskEvalsDb.size()==0){
				return failed("data-0","记录已不存在");
			}
			List<XmTaskEval> can=new ArrayList<>();
			List<XmTaskEval> no=new ArrayList<>();
			User user = LoginUtils.getCurrentUserInfo();
			for (XmTaskEval xmTaskEvalDb : xmTaskEvalsDb) {
				Tips tips2 = new Tips("检查通过"); 
				if(!tips2.isOk()){
				    no.add(xmTaskEvalDb); 
				}else{
					can.add(xmTaskEvalDb);
				}
			}
			if(can.size()>0){
                xmTaskEvalMap.put("ids",can.stream().map(i->i.getId()).collect(Collectors.toList()));
			    xmTaskEvalService.editSomeFields(xmTaskEvalMap); 
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
	@ApiOperation( value = "根据主键列表批量删除xm_task_eval信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmTaskEval(@RequestBody List<XmTaskEval> xmTaskEvals) {
		Map<String,Object> m = new HashMap<>();
        Tips tips=new Tips("成功删除"); 
        try{ 
            if(xmTaskEvals.size()<=0){
                return failed("data-0","请上送待删除数据列表");
            }
             List<XmTaskEval> datasDb=xmTaskEvalService.selectListByIds(xmTaskEvals.stream().map(i-> i.getId() ).collect(Collectors.toList()));

            List<XmTaskEval> can=new ArrayList<>();
            List<XmTaskEval> no=new ArrayList<>();
            for (XmTaskEval data : datasDb) {
                if(true){
                    can.add(data);
                }else{
                    no.add(data);
                } 
            }
            List<String> msgs=new ArrayList<>();
            if(can.size()>0){
                xmTaskEvalService.batchDelete(can);
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
