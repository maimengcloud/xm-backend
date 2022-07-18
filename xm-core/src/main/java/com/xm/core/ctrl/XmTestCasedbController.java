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

import com.xm.core.service.XmTestCasedbService;
import com.xm.core.entity.XmTestCasedb;

/**
 * url编制采用rest风格,如对xm_test_casedb 测试用例库的操作有增删改查,对应的url分别为:<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTestCasedb 表 xm_test_casedb 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmTestCasedbController")
@RequestMapping(value="/**/core/xmTestCasedb")
@Api(tags={"测试用例库操作接口"})
public class XmTestCasedbController {
	
	static Logger logger =LoggerFactory.getLogger(XmTestCasedbController.class);
	
	@Autowired
	private XmTestCasedbService xmTestCasedbService;
	 

	Map<String,Object> fieldsMap = toMap(new XmTestCasedb());
 
	
	@ApiOperation( value = "查询测试用例库信息列表",notes=" ")
	@ApiEntityParams( XmTestCasedb.class )
	@ApiImplicitParams({
			@ApiImplicitParam(name="pageSize",value="每页大小，默认20条",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="count",value="是否计算总记录条数，如果count=true,则计算计算总条数，如果count=false 则不计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student desc",required=false),
 	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestCasedb.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTestCasedb( @ApiIgnore @RequestParam Map<String,Object> xmTestCasedb){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmTestCasedb, "ids");
		PageUtils.startPage(xmTestCasedb);
		List<Map<String,Object>>	xmTestCasedbList = xmTestCasedbService.selectListMapByWhere(xmTestCasedb);	//列出XmTestCasedb列表
		PageUtils.responePage(m, xmTestCasedbList);
		m.put("data",xmTestCasedbList);

		m.put("tips", tips);
		return m;
	}
	
 
	
	/**
	@ApiOperation( value = "新增一条测试用例库信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestCasedb.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTestCasedb(@RequestBody XmTestCasedb xmTestCasedb) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
		    boolean createPk=false;
			if(!StringUtils.hasText(xmTestCasedb.getId())) {
			    createPk=true;
				xmTestCasedb.setId(xmTestCasedbService.createKey("id"));
			}
			if(createPk==false){
                 if(xmTestCasedbService.selectOneObject(xmTestCasedb) !=null ){
                    return failed("pk-exists","编号重复，请修改编号再提交");
                }
            }
			xmTestCasedbService.insert(xmTestCasedb);
			m.put("data",xmTestCasedb);
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
	@ApiOperation( value = "删除一条测试用例库信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmTestCasedb(@RequestBody XmTestCasedb xmTestCasedb){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
            if(!StringUtils.hasText(xmTestCasedb.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmTestCasedb xmTestCasedbDb = xmTestCasedbService.selectOneObject(xmTestCasedb);
            if( xmTestCasedbDb == null ){
                return failed("data-not-exists","数据不存在，无法删除");
            }
			xmTestCasedbService.deleteByPk(xmTestCasedb);
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
	@ApiOperation( value = "根据主键修改一条测试用例库信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTestCasedb.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTestCasedb(@RequestBody XmTestCasedb xmTestCasedb) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmTestCasedb.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmTestCasedb xmTestCasedbDb = xmTestCasedbService.selectOneObject(xmTestCasedb);
            if( xmTestCasedbDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			xmTestCasedbService.updateSomeFieldByPk(xmTestCasedb);
			m.put("data",xmTestCasedb);
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
    @ApiEntityParams( value = XmTestCasedb.class, props={ }, remark = "测试用例库", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTestCasedb.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmTestCasedbMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            List<String> ids= (List<String>) xmTestCasedbMap.get("ids");
			if(ids==null || ids.size()==0){
				return failed("ids-0","ids不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("id");
			for (String fieldName : xmTestCasedbMap.keySet()) {
				if(fields.contains(fieldName)){
					return failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmTestCasedbMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmTestCasedbMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return failed("fieldKey-0","没有需要更新的字段");
 			}
			XmTestCasedb xmTestCasedb = fromMap(xmTestCasedbMap,XmTestCasedb.class);
			List<XmTestCasedb> xmTestCasedbsDb=xmTestCasedbService.selectListByIds(ids);
			if(xmTestCasedbsDb==null ||xmTestCasedbsDb.size()==0){
				return failed("data-0","记录已不存在");
			}
			List<XmTestCasedb> can=new ArrayList<>();
			List<XmTestCasedb> no=new ArrayList<>();
			User user = LoginUtils.getCurrentUserInfo();
			for (XmTestCasedb xmTestCasedbDb : xmTestCasedbsDb) {
				Tips tips2 = new Tips("检查通过"); 
				if(!tips2.isOk()){
				    no.add(xmTestCasedbDb); 
				}else{
					can.add(xmTestCasedbDb);
				}
			}
			if(can.size()>0){
                xmTestCasedbMap.put("ids",can.stream().map(i->i.getId()).collect(Collectors.toList()));
			    xmTestCasedbService.editSomeFields(xmTestCasedbMap); 
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
	@ApiOperation( value = "根据主键列表批量删除测试用例库信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmTestCasedb(@RequestBody List<XmTestCasedb> xmTestCasedbs) {
		Map<String,Object> m = new HashMap<>();
        Tips tips=new Tips("成功删除"); 
        try{ 
            if(xmTestCasedbs.size()<=0){
                return failed("data-0","请上送待删除数据列表");
            }
             List<XmTestCasedb> datasDb=xmTestCasedbService.selectListByIds(xmTestCasedbs.stream().map(i-> i.getId() ).collect(Collectors.toList()));

            List<XmTestCasedb> can=new ArrayList<>();
            List<XmTestCasedb> no=new ArrayList<>();
            for (XmTestCasedb data : datasDb) {
                if(true){
                    can.add(data);
                }else{
                    no.add(data);
                } 
            }
            List<String> msgs=new ArrayList<>();
            if(can.size()>0){
                xmTestCasedbService.batchDelete(can);
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
