package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmCostNlabor;
import com.xm.core.service.XmCostNlaborService;
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
 * url编制采用rest风格,如对xm_cost_nlabor 项目实际人工成本费用的操作有增删改查,对应的url分别为:<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmCostNlabor 表 xm_cost_nlabor 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmCostNlaborController")
@RequestMapping(value="/**/core/xmCostNlabor")
@Api(tags={"项目实际人工成本费用操作接口"})
public class XmCostNlaborController {
	
	static Logger logger =LoggerFactory.getLogger(XmCostNlaborController.class);
	
	@Autowired
	private XmCostNlaborService xmCostNlaborService;
	 

	Map<String,Object> fieldsMap = toMap(new XmCostNlabor());
 
	
	@ApiOperation( value = "查询项目实际人工成本费用信息列表",notes=" ")
	@ApiEntityParams( XmCostNlabor.class )
	@ApiImplicitParams({
			@ApiImplicitParam(name="pageSize",value="每页大小，默认20条",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="count",value="是否计算总记录条数，如果count=true,则计算计算总条数，如果count=false 则不计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student desc",required=false),
 	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmCostNlabor.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmCostNlabor( @ApiIgnore @RequestParam Map<String,Object> xmCostNlabor){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmCostNlabor, "ids");
		PageUtils.startPage(xmCostNlabor);
		List<Map<String,Object>>	xmCostNlaborList = xmCostNlaborService.selectListMapByWhere(xmCostNlabor);	//列出XmCostNlabor列表
		PageUtils.responePage(m, xmCostNlaborList);
		m.put("data",xmCostNlaborList);

		m.put("tips", tips);
		return m;
	}


	@ApiResponses({
			@ApiResponse(code = 200,response= XmCostNlabor.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listSum",method=RequestMethod.GET)
	public Map<String,Object> listSum( @ApiIgnore @RequestParam Map<String,Object> xmCostNlabor){
		Map<String,Object> m = new HashMap<>();
		RequestUtils.transformArray(xmCostNlabor, "ids");
		PageUtils.startPage(xmCostNlabor);
		List<Map<String,Object>>	data = xmCostNlaborService.listSum(xmCostNlabor);	//列出xmProjectMCostNouser列表
		PageUtils.responePage(m, data);
		m.put("data",data);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
	/**
	@ApiOperation( value = "新增一条项目实际人工成本费用信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmCostNlabor.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmCostNlabor(@RequestBody XmCostNlabor xmCostNlabor) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
		    boolean createPk=false;
			if(!StringUtils.hasText(xmCostNlabor.getId())) {
			    createPk=true;
				xmCostNlabor.setId(xmCostNlaborService.createKey("id"));
			}
			if(createPk==false){
                 if(xmCostNlaborService.selectOneObject(xmCostNlabor) !=null ){
                    return failed("pk-exists","编号重复，请修改编号再提交");
                }
            }
			xmCostNlaborService.insert(xmCostNlabor);
			m.put("data",xmCostNlabor);
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
	@ApiOperation( value = "删除一条项目实际人工成本费用信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmCostNlabor(@RequestBody XmCostNlabor xmCostNlabor){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
            if(!StringUtils.hasText(xmCostNlabor.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmCostNlabor xmCostNlaborDb = xmCostNlaborService.selectOneObject(xmCostNlabor);
            if( xmCostNlaborDb == null ){
                return failed("data-not-exists","数据不存在，无法删除");
            }
			xmCostNlaborService.deleteByPk(xmCostNlabor);
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
	@ApiOperation( value = "根据主键修改一条项目实际人工成本费用信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmCostNlabor.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmCostNlabor(@RequestBody XmCostNlabor xmCostNlabor) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmCostNlabor.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmCostNlabor xmCostNlaborDb = xmCostNlaborService.selectOneObject(xmCostNlabor);
            if( xmCostNlaborDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			xmCostNlaborService.updateSomeFieldByPk(xmCostNlabor);
			m.put("data",xmCostNlabor);
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
    @ApiEntityParams( value = XmCostNlabor.class, props={ }, remark = "项目实际人工成本费用", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmCostNlabor.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmCostNlaborMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            List<String> ids= (List<String>) xmCostNlaborMap.get("ids");
			if(ids==null || ids.size()==0){
				return failed("ids-0","ids不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("id");
			for (String fieldName : xmCostNlaborMap.keySet()) {
				if(fields.contains(fieldName)){
					return failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmCostNlaborMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmCostNlaborMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return failed("fieldKey-0","没有需要更新的字段");
 			}
			XmCostNlabor xmCostNlabor = fromMap(xmCostNlaborMap,XmCostNlabor.class);
			List<XmCostNlabor> xmCostNlaborsDb=xmCostNlaborService.selectListByIds(ids);
			if(xmCostNlaborsDb==null ||xmCostNlaborsDb.size()==0){
				return failed("data-0","记录已不存在");
			}
			List<XmCostNlabor> can=new ArrayList<>();
			List<XmCostNlabor> no=new ArrayList<>();
			User user = LoginUtils.getCurrentUserInfo();
			for (XmCostNlabor xmCostNlaborDb : xmCostNlaborsDb) {
				Tips tips2 = new Tips("检查通过"); 
				if(!tips2.isOk()){
				    no.add(xmCostNlaborDb); 
				}else{
					can.add(xmCostNlaborDb);
				}
			}
			if(can.size()>0){
                xmCostNlaborMap.put("ids",can.stream().map(i->i.getId()).collect(Collectors.toList()));
			    xmCostNlaborService.editSomeFields(xmCostNlaborMap); 
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
	@ApiOperation( value = "根据主键列表批量删除项目实际人工成本费用信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmCostNlabor(@RequestBody List<XmCostNlabor> xmCostNlabors) {
		Map<String,Object> m = new HashMap<>();
        Tips tips=new Tips("成功删除"); 
        try{ 
            if(xmCostNlabors.size()<=0){
                return failed("data-0","请上送待删除数据列表");
            }
             List<XmCostNlabor> datasDb=xmCostNlaborService.selectListByIds(xmCostNlabors.stream().map(i-> i.getId() ).collect(Collectors.toList()));

            List<XmCostNlabor> can=new ArrayList<>();
            List<XmCostNlabor> no=new ArrayList<>();
            for (XmCostNlabor data : datasDb) {
                if(true){
                    can.add(data);
                }else{
                    no.add(data);
                } 
            }
            List<String> msgs=new ArrayList<>();
            if(can.size()>0){
                xmCostNlaborService.batchDelete(xmCostNlabors);
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
