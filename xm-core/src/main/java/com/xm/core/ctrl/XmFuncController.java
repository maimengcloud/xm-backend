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

import com.xm.core.service.XmFuncService;
import com.xm.core.entity.XmFunc;

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
	public Map<String,Object> listXmFunc( @ApiIgnore @RequestParam Map<String,Object> xmFunc){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmFunc, "ids");
		PageUtils.startPage(xmFunc);
		List<Map<String,Object>>	xmFuncList = xmFuncService.selectListMapByWhere(xmFunc);	//列出XmFunc列表
		PageUtils.responePage(m, xmFuncList);
		m.put("data",xmFuncList);

		m.put("tips", tips);
		return m;
	}
	
 
	
	/**
	@ApiOperation( value = "新增一条功能模块表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmFunc.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmFunc(@RequestBody XmFunc xmFunc) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
		    boolean createPk=false;
			if(!StringUtils.hasText(xmFunc.getId())) {
			    createPk=true;
				xmFunc.setId(xmFuncService.createKey("id"));
			}
			if(createPk==false){
                 if(xmFuncService.selectOneObject(xmFunc) !=null ){
                    return failed("pk-exists","编号重复，请修改编号再提交");
                }
            }
			xmFuncService.insert(xmFunc);
			m.put("data",xmFunc);
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
	@ApiOperation( value = "删除一条功能模块表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmFunc(@RequestBody XmFunc xmFunc){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
            if(!StringUtils.hasText(xmFunc.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmFunc xmFuncDb = xmFuncService.selectOneObject(xmFunc);
            if( xmFuncDb == null ){
                return failed("data-not-exists","数据不存在，无法删除");
            }
			xmFuncService.deleteByPk(xmFunc);
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
	@ApiOperation( value = "根据主键修改一条功能模块表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmFunc.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmFunc(@RequestBody XmFunc xmFunc) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmFunc.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmFunc xmFuncDb = xmFuncService.selectOneObject(xmFunc);
            if( xmFuncDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			xmFuncService.updateSomeFieldByPk(xmFunc);
			m.put("data",xmFunc);
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
    @ApiEntityParams( value = XmFunc.class, props={ }, remark = "功能模块表", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmFunc.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmFuncMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            List<String> ids= (List<String>) xmFuncMap.get("ids");
			if(ids==null || ids.size()==0){
				return failed("ids-0","ids不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("id");
			for (String fieldName : xmFuncMap.keySet()) {
				if(fields.contains(fieldName)){
					return failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmFuncMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmFuncMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return failed("fieldKey-0","没有需要更新的字段");
 			}
			XmFunc xmFunc = fromMap(xmFuncMap,XmFunc.class);
			List<XmFunc> xmFuncsDb=xmFuncService.selectListByIds(ids);
			if(xmFuncsDb==null ||xmFuncsDb.size()==0){
				return failed("data-0","记录已不存在");
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
	@ApiOperation( value = "根据主键列表批量删除功能模块表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmFunc(@RequestBody List<XmFunc> xmFuncs) {
		Map<String,Object> m = new HashMap<>();
        Tips tips=new Tips("成功删除"); 
        try{ 
            if(xmFuncs.size()<=0){
                return failed("data-0","请上送待删除数据列表");
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
