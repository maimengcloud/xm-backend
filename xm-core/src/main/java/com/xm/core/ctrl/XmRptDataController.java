package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmRptData;
import com.xm.core.service.XmRptDataService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mdp.core.utils.BaseUtils.toMap;
import static com.mdp.core.utils.ResponseHelper.failed;

/**
 * url编制采用rest风格,如对xm_rpt_data xm_rpt_data的操作有增删改查,对应的url分别为:<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmRptData 表 xm_rpt_data 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmRptDataController")
@RequestMapping(value="/**/core/xmRptData")
@Api(tags={"xm_rpt_data操作接口"})
public class XmRptDataController {
	
	static Logger logger =LoggerFactory.getLogger(XmRptDataController.class);
	
	@Autowired
	private XmRptDataService xmRptDataService;
	 

	Map<String,Object> fieldsMap = toMap(new XmRptData());
 
	
	@ApiOperation( value = "查询xm_rpt_data信息列表",notes=" ")
	@ApiEntityParams( XmRptData.class )
	@ApiImplicitParams({
			@ApiImplicitParam(name="pageSize",value="每页大小，默认20条",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="count",value="是否计算总记录条数，如果count=true,则计算计算总条数，如果count=false 则不计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student desc",required=false),
 	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmRptData.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmRptData( @ApiIgnore @RequestParam Map<String,Object> xmRptData){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmRptData, "ids");
		PageUtils.startPage(xmRptData);
		List<Map<String,Object>>	xmRptDataList = xmRptDataService.selectListMapByWhere(xmRptData);	//列出XmRptData列表
		PageUtils.responePage(m, xmRptDataList);
		m.put("data",xmRptDataList);

		m.put("tips", tips);
		return m;
	}
	
 

	@ApiOperation( value = "新增一条xm_rpt_data信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmRptData.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmRptData(@RequestBody XmRptData xmRptData) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
		    boolean createPk=false;
			if(!StringUtils.hasText(xmRptData.getId())) {
			    createPk=true;
				xmRptData.setId(xmRptDataService.createKey("id"));
			}
			if(createPk==false){
                 if(xmRptDataService.selectOneObject(xmRptData) !=null ){
                    return failed("pk-exists","编号重复，请修改编号再提交");
                }
            }
			xmRptDataService.insert(xmRptData);
			m.put("data",xmRptData);
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

	@ApiOperation( value = "删除一条xm_rpt_data信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmRptData(@RequestBody XmRptData xmRptData){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
            if(!StringUtils.hasText(xmRptData.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmRptData xmRptDataDb = xmRptDataService.selectOneObject(xmRptData);
            if( xmRptDataDb == null ){
                return failed("data-not-exists","数据不存在，无法删除");
            }
			xmRptDataService.deleteByPk(xmRptData);
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
	
	/**
	@ApiOperation( value = "根据主键修改一条xm_rpt_data信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmRptData.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmRptData(@RequestBody XmRptData xmRptData) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmRptData.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmRptData xmRptDataDb = xmRptDataService.selectOneObject(xmRptData);
            if( xmRptDataDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			xmRptDataService.updateSomeFieldByPk(xmRptData);
			m.put("data",xmRptData);
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
    @ApiEntityParams( value = XmRptData.class, props={ }, remark = "xm_rpt_data", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmRptData.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmRptDataMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            List<String> ids= (List<String>) xmRptDataMap.get("ids");
			if(ids==null || ids.size()==0){
				return failed("ids-0","ids不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("id");
			for (String fieldName : xmRptDataMap.keySet()) {
				if(fields.contains(fieldName)){
					return failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmRptDataMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmRptDataMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return failed("fieldKey-0","没有需要更新的字段");
 			}
			XmRptData xmRptData = fromMap(xmRptDataMap,XmRptData.class);
			List<XmRptData> xmRptDatasDb=xmRptDataService.selectListByIds(ids);
			if(xmRptDatasDb==null ||xmRptDatasDb.size()==0){
				return failed("data-0","记录已不存在");
			}
			List<XmRptData> can=new ArrayList<>();
			List<XmRptData> no=new ArrayList<>();
			User user = LoginUtils.getCurrentUserInfo();
			for (XmRptData xmRptDataDb : xmRptDatasDb) {
				Tips tips2 = new Tips("检查通过"); 
				if(!tips2.isOk()){
				    no.add(xmRptDataDb); 
				}else{
					can.add(xmRptDataDb);
				}
			}
			if(can.size()>0){
                xmRptDataMap.put("ids",can.stream().map(i->i.getId()).collect(Collectors.toList()));
			    xmRptDataService.editSomeFields(xmRptDataMap); 
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
	@ApiOperation( value = "根据主键列表批量删除xm_rpt_data信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmRptData(@RequestBody List<XmRptData> xmRptDatas) {
		Map<String,Object> m = new HashMap<>();
        Tips tips=new Tips("成功删除"); 
        try{ 
            if(xmRptDatas.size()<=0){
                return failed("data-0","请上送待删除数据列表");
            }
             List<XmRptData> datasDb=xmRptDataService.selectListByIds(xmRptDatas.stream().map(i-> i.getId() ).collect(Collectors.toList()));

            List<XmRptData> can=new ArrayList<>();
            List<XmRptData> no=new ArrayList<>();
            for (XmRptData data : datasDb) {
                if(true){
                    can.add(data);
                }else{
                    no.add(data);
                } 
            }
            List<String> msgs=new ArrayList<>();
            if(can.size()>0){
                xmRptDataService.batchDelete(can);
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
