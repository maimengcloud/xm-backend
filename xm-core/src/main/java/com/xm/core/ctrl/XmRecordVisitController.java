package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.ResponseHelper;
import com.mdp.mybatis.PageUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmRecordVisit;
import com.xm.core.service.XmRecordVisitService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

import static com.mdp.core.utils.BaseUtils.toMap;

/**
 * url编制采用rest风格,如对xm_record_visit 重要页面访问记录的操作有增删改查,对应的url分别为:<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmRecordVisit 表 xm_record_visit 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmRecordVisitController")
@RequestMapping(value="/**/core/xmRecordVisit")
@Api(tags={"重要页面访问记录操作接口"})
public class XmRecordVisitController {
	
	static Logger logger =LoggerFactory.getLogger(XmRecordVisitController.class);
	
	@Autowired
	private XmRecordVisitService xmRecordVisitService;

	List<XmRecordVisit> datas=new ArrayList<>();
	 

	Map<String,Object> fieldsMap = toMap(new XmRecordVisit());
 
	
	@ApiOperation( value = "查询重要页面访问记录信息列表",notes=" ")
	@ApiEntityParams( XmRecordVisit.class )
	@ApiImplicitParams({
			@ApiImplicitParam(name="pageSize",value="每页大小，默认20条",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="count",value="是否计算总记录条数，如果count=true,则计算计算总条数，如果count=false 则不计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student desc",required=false),
 	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmRecordVisit.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmRecordVisit( @ApiIgnore @RequestParam Map<String,Object> xmRecordVisit){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmRecordVisit, "ids");
		PageUtils.startPage(xmRecordVisit);
		List<Map<String,Object>>	xmRecordVisitList = xmRecordVisitService.selectListMapByWhere(xmRecordVisit);	//列出XmRecordVisit列表
		PageUtils.responePage(m, xmRecordVisitList);
		m.put("data",xmRecordVisitList);

		m.put("tips", tips);
		return m;
	}
	
 

	@ApiOperation( value = "新增一条重要页面访问记录信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmRecordVisit.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmRecordVisit(@RequestBody XmRecordVisit xmRecordVisit) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			if(!StringUtils.hasText(xmRecordVisit.getBizId())){
				return ResponseHelper.failed("bizId-0","bizId不能为空");
			}
			if(!StringUtils.hasText(xmRecordVisit.getPbizId())){
				return ResponseHelper.failed("pbizId-0","pbizId不能为空");
			}
			if(!StringUtils.hasText(xmRecordVisit.getObjType())){
				return ResponseHelper.failed("objType-0","objType不能为空");
			}
			User user= LoginUtils.getCurrentUserInfo();
			xmRecordVisit.setId(this.xmRecordVisitService.createKey("id"));
			xmRecordVisit.setGloNo(MDC.get("gloNo"));
			xmRecordVisit.setOperTime(new Date());
			xmRecordVisit.setOperUserid(user.getUserid());
			xmRecordVisit.setOperUsername(user.getUsername());
			xmRecordVisit.setBranchId(user.getBranchId());
			xmRecordVisit.setIp(RequestUtils.getIpAddr(RequestUtils.getRequest()));

			this.datas.add(xmRecordVisit);
			if(this.datas.size()>100){
				xmRecordVisitService.batchAddAndCalc(this.datas);
				this.datas.clear();
			}
			m.put("data",xmRecordVisit);
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
	@ApiOperation( value = "删除一条重要页面访问记录信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmRecordVisit(@RequestBody XmRecordVisit xmRecordVisit){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
            if(!StringUtils.hasText(xmRecordVisit.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmRecordVisit xmRecordVisitDb = xmRecordVisitService.selectOneObject(xmRecordVisit);
            if( xmRecordVisitDb == null ){
                return failed("data-not-exists","数据不存在，无法删除");
            }
			xmRecordVisitService.deleteByPk(xmRecordVisit);
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
	@ApiOperation( value = "根据主键修改一条重要页面访问记录信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmRecordVisit.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmRecordVisit(@RequestBody XmRecordVisit xmRecordVisit) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmRecordVisit.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmRecordVisit xmRecordVisitDb = xmRecordVisitService.selectOneObject(xmRecordVisit);
            if( xmRecordVisitDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			xmRecordVisitService.updateSomeFieldByPk(xmRecordVisit);
			m.put("data",xmRecordVisit);
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
    @ApiEntityParams( value = XmRecordVisit.class, props={ }, remark = "重要页面访问记录", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmRecordVisit.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmRecordVisitMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            List<String> ids= (List<String>) xmRecordVisitMap.get("ids");
			if(ids==null || ids.size()==0){
				return failed("ids-0","ids不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("id");
			for (String fieldName : xmRecordVisitMap.keySet()) {
				if(fields.contains(fieldName)){
					return failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmRecordVisitMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmRecordVisitMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return failed("fieldKey-0","没有需要更新的字段");
 			}
			XmRecordVisit xmRecordVisit = fromMap(xmRecordVisitMap,XmRecordVisit.class);
			List<XmRecordVisit> xmRecordVisitsDb=xmRecordVisitService.selectListByIds(ids);
			if(xmRecordVisitsDb==null ||xmRecordVisitsDb.size()==0){
				return failed("data-0","记录已不存在");
			}
			List<XmRecordVisit> can=new ArrayList<>();
			List<XmRecordVisit> no=new ArrayList<>();
			User user = LoginUtils.getCurrentUserInfo();
			for (XmRecordVisit xmRecordVisitDb : xmRecordVisitsDb) {
				Tips tips2 = new Tips("检查通过"); 
				if(!tips2.isOk()){
				    no.add(xmRecordVisitDb); 
				}else{
					can.add(xmRecordVisitDb);
				}
			}
			if(can.size()>0){
                xmRecordVisitMap.put("ids",can.stream().map(i->i.getId()).collect(Collectors.toList()));
			    xmRecordVisitService.editSomeFields(xmRecordVisitMap); 
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
	@ApiOperation( value = "根据主键列表批量删除重要页面访问记录信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmRecordVisit(@RequestBody List<XmRecordVisit> xmRecordVisits) {
		Map<String,Object> m = new HashMap<>();
        Tips tips=new Tips("成功删除"); 
        try{ 
            if(xmRecordVisits.size()<=0){
                return failed("data-0","请上送待删除数据列表");
            }
             List<XmRecordVisit> datasDb=xmRecordVisitService.selectListByIds(xmRecordVisits.stream().map(i-> i.getId() ).collect(Collectors.toList()));

            List<XmRecordVisit> can=new ArrayList<>();
            List<XmRecordVisit> no=new ArrayList<>();
            for (XmRecordVisit data : datasDb) {
                if(true){
                    can.add(data);
                }else{
                    no.add(data);
                } 
            }
            List<String> msgs=new ArrayList<>();
            if(can.size()>0){
                xmRecordVisitService.batchDelete(can);
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
