package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmBudgetNlabor;
import com.xm.core.entity.XmProjectMBudgetCostNouser;
import com.xm.core.service.XmBudgetNlaborService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mdp.core.utils.BaseUtils.toMap;

/**
 * url编制采用rest风格,如对xm_budget_nlabor 项目人力成本预算的操作有增删改查,对应的url分别为:<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmBudgetNlabor 表 xm_budget_nlabor 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmBudgetNlaborController")
@RequestMapping(value="/**/core/xmBudgetNlabor")
@Api(tags={"项目人力成本预算操作接口"})
public class XmBudgetNlaborController {
	
	static Logger logger =LoggerFactory.getLogger(XmBudgetNlaborController.class);
	
	@Autowired
	private XmBudgetNlaborService xmBudgetNlaborService;
	 

	Map<String,Object> fieldsMap = toMap(new XmBudgetNlabor());
 
	
	@ApiOperation( value = "查询项目人力成本预算信息列表",notes=" ")
	@ApiEntityParams( XmBudgetNlabor.class )
	@ApiImplicitParams({
			@ApiImplicitParam(name="pageSize",value="每页大小，默认20条",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="count",value="是否计算总记录条数，如果count=true,则计算计算总条数，如果count=false 则不计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student desc",required=false),
 	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmBudgetNlabor.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmBudgetNlabor( @ApiIgnore @RequestParam Map<String,Object> xmBudgetNlabor){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmBudgetNlabor, "ids");
		PageUtils.startPage(xmBudgetNlabor);
		List<Map<String,Object>>	xmBudgetNlaborList = xmBudgetNlaborService.selectListMapByWhere(xmBudgetNlabor);	//列出XmBudgetNlabor列表
		PageUtils.responePage(m, xmBudgetNlaborList);
		m.put("data",xmBudgetNlaborList);

		m.put("tips", tips);
		return m;
	}

	@ApiResponses({
			@ApiResponse(code = 200,response= XmBudgetNlabor.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listSum",method=RequestMethod.GET)
	public Map<String,Object> listSum( @ApiIgnore @RequestParam Map<String,Object> xmBudgetNlabor){
		Map<String,Object> m = new HashMap<>();
		RequestUtils.transformArray(xmBudgetNlabor, "ids");
		PageUtils.startPage(xmBudgetNlabor);
		List<Map<String,Object>>	data = xmBudgetNlaborService.listSum(xmBudgetNlabor);	//列出xmProjectMBudgetCostNouser列表
		PageUtils.responePage(m, data);
		m.put("data",data);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
	/**
	@ApiOperation( value = "新增一条项目人力成本预算信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmBudgetNlabor.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmBudgetNlabor(@RequestBody XmBudgetNlabor xmBudgetNlabor) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
		    boolean createPk=false;
			if(!StringUtils.hasText(xmBudgetNlabor.getId())) {
			    createPk=true;
				xmBudgetNlabor.setId(xmBudgetNlaborService.createKey("id"));
			}
			if(createPk==false){
                 if(xmBudgetNlaborService.selectOneObject(xmBudgetNlabor) !=null ){
                    return failed("pk-exists","编号重复，请修改编号再提交");
                }
            }
			xmBudgetNlaborService.insert(xmBudgetNlabor);
			m.put("data",xmBudgetNlabor);
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
	@ApiOperation( value = "删除一条项目人力成本预算信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmBudgetNlabor(@RequestBody XmBudgetNlabor xmBudgetNlabor){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
            if(!StringUtils.hasText(xmBudgetNlabor.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmBudgetNlabor xmBudgetNlaborDb = xmBudgetNlaborService.selectOneObject(xmBudgetNlabor);
            if( xmBudgetNlaborDb == null ){
                return failed("data-not-exists","数据不存在，无法删除");
            }
			xmBudgetNlaborService.deleteByPk(xmBudgetNlabor);
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
	@ApiOperation( value = "根据主键修改一条项目人力成本预算信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmBudgetNlabor.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmBudgetNlabor(@RequestBody XmBudgetNlabor xmBudgetNlabor) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmBudgetNlabor.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmBudgetNlabor xmBudgetNlaborDb = xmBudgetNlaborService.selectOneObject(xmBudgetNlabor);
            if( xmBudgetNlaborDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			xmBudgetNlaborService.updateSomeFieldByPk(xmBudgetNlabor);
			m.put("data",xmBudgetNlabor);
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
    @ApiEntityParams( value = XmBudgetNlabor.class, props={ }, remark = "项目人力成本预算", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmBudgetNlabor.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmBudgetNlaborMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            List<String> ids= (List<String>) xmBudgetNlaborMap.get("ids");
			if(ids==null || ids.size()==0){
				return failed("ids-0","ids不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("id");
			for (String fieldName : xmBudgetNlaborMap.keySet()) {
				if(fields.contains(fieldName)){
					return failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmBudgetNlaborMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmBudgetNlaborMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return failed("fieldKey-0","没有需要更新的字段");
 			}
			XmBudgetNlabor xmBudgetNlabor = fromMap(xmBudgetNlaborMap,XmBudgetNlabor.class);
			List<XmBudgetNlabor> xmBudgetNlaborsDb=xmBudgetNlaborService.selectListByIds(ids);
			if(xmBudgetNlaborsDb==null ||xmBudgetNlaborsDb.size()==0){
				return failed("data-0","记录已不存在");
			}
			List<XmBudgetNlabor> can=new ArrayList<>();
			List<XmBudgetNlabor> no=new ArrayList<>();
			User user = LoginUtils.getCurrentUserInfo();
			for (XmBudgetNlabor xmBudgetNlaborDb : xmBudgetNlaborsDb) {
				Tips tips2 = new Tips("检查通过"); 
				if(!tips2.isOk()){
				    no.add(xmBudgetNlaborDb); 
				}else{
					can.add(xmBudgetNlaborDb);
				}
			}
			if(can.size()>0){
                xmBudgetNlaborMap.put("ids",can.stream().map(i->i.getId()).collect(Collectors.toList()));
			    xmBudgetNlaborService.editSomeFields(xmBudgetNlaborMap); 
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
	@ApiOperation( value = "根据主键列表批量删除项目人力成本预算信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmBudgetNlabor(@RequestBody List<XmBudgetNlabor> xmBudgetNlabors) {
		Map<String,Object> m = new HashMap<>();
        Tips tips=new Tips("成功删除"); 
        try{ 
            if(xmBudgetNlabors.size()<=0){
                return failed("data-0","请上送待删除数据列表");
            }
             List<XmBudgetNlabor> datasDb=xmBudgetNlaborService.selectListByIds(xmBudgetNlabors.stream().map(i-> i.getId() ).collect(Collectors.toList()));

            List<XmBudgetNlabor> can=new ArrayList<>();
            List<XmBudgetNlabor> no=new ArrayList<>();
            for (XmBudgetNlabor data : datasDb) {
                if(true){
                    can.add(data);
                }else{
                    no.add(data);
                } 
            }
            List<String> msgs=new ArrayList<>();
            if(can.size()>0){
                xmBudgetNlaborService.batchDelete(xmBudgetNlabors);
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
