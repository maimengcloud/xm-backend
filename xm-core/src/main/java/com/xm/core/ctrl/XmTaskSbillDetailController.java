package com.xm.core.ctrl;

import java.util.*;
import java.util.stream.Collectors;

import com.mdp.core.utils.ResponseHelper;
import com.xm.core.entity.XmTaskSbill;
import com.xm.core.service.XmTaskSbillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
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
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;

import com.xm.core.service.XmTaskSbillDetailService;
import com.xm.core.entity.XmTaskSbillDetail;

/**
 * url编制采用rest风格,如对xm_task_sbill_detail 工时登记表的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmTaskSbillDetail/add <br>
 *  查询: core/xmTaskSbillDetail/list<br>
 *  模糊查询: core/xmTaskSbillDetail/listKey<br>
 *  修改: core/xmTaskSbillDetail/edit <br>
 *  删除: core/xmTaskSbillDetail/del<br>
 *  批量删除: core/xmTaskSbillDetail/batchDel<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTaskSbillDetail 表 xm_task_sbill_detail 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.xmTaskSbillDetailController")
@RequestMapping(value="/**/core/xmTaskSbillDetail")
@Api(tags={"工时登记表操作接口"})
public class XmTaskSbillDetailController {
	
	static Logger logger =LoggerFactory.getLogger(XmTaskSbillDetailController.class);
	
	@Autowired
	private XmTaskSbillDetailService xmTaskSbillDetailService;

	@Autowired
	private XmTaskSbillService xmTaskSbillService;

	Map<String,Object> fieldsMap = toMap(new XmTaskSbillDetail());
 
	
	@ApiOperation( value = "查询工时登记表信息列表",notes=" ") 
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskSbillDetail.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmTaskSbillDetail( @RequestParam Map<String,Object> xmTaskSbillDetail){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmTaskSbillDetail, "ids");
		PageUtils.startPage(xmTaskSbillDetail);
		User user=LoginUtils.getCurrentUserInfo();
		xmTaskSbillDetail.put("branchId",user.getBranchId());
		List<Map<String,Object>>	xmTaskSbillDetailList = xmTaskSbillDetailService.selectListMapByWhere(xmTaskSbillDetail);	//列出XmTaskSbillDetail列表
		PageUtils.responePage(m, xmTaskSbillDetailList);
		m.put("data",xmTaskSbillDetailList);

		m.put("tips", tips);
		return m;
	}
	@ApiOperation( value = "查询个人支出费用按月分布报表",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskSbillDetail.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listSumSamtGroupByUseridBizMonth",method=RequestMethod.GET)
	public Map<String,Object> listSumSamtGroupByUseridBizMonth( @RequestParam Map<String,Object> xmTaskSbillDetail){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		String bizYear= (String) xmTaskSbillDetail.get("bizYear");
		if(!StringUtils.hasText(bizYear)){
			return ResponseHelper.failed("bizYear-0","年份不能为空");
		}
		User user=LoginUtils.getCurrentUserInfo();
		xmTaskSbillDetail.put("branchId",user.getBranchId());
		List<Map<String,Object>>	xmTaskSbillDetailList = xmTaskSbillDetailService.listSumSamtGroupByUseridBizMonth(xmTaskSbillDetail);	//列出XmTaskSbillDetail列表

		m.put("data",xmTaskSbillDetailList);

		m.put("tips", tips);
		return m;
	}
	@ApiOperation( value = "查询项目支出费用按月分布报表",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskSbillDetail.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listSumSamtGroupByProjectIdBizMonth",method=RequestMethod.GET)
	public Map<String,Object> listSumSamtGroupByProjectIdBizMonth( @RequestParam Map<String,Object> xmTaskSbillDetail){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		String bizYear= (String) xmTaskSbillDetail.get("bizYear");
		if(!StringUtils.hasText(bizYear)){
			return ResponseHelper.failed("bizYear-0","年份不能为空");
		}
		User user=LoginUtils.getCurrentUserInfo();
		xmTaskSbillDetail.put("branchId",user.getBranchId());
		List<Map<String,Object>>	xmTaskSbillDetailList = xmTaskSbillDetailService.listSumSamtGroupByProjectIdBizMonth(xmTaskSbillDetail);	//列出XmTaskSbillDetail列表

		m.put("data",xmTaskSbillDetailList);

		m.put("tips", tips);
		return m;
	}
	@ApiOperation( value = "查询机构支出费用按月分布报表",notes=" ")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskSbillDetail.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/listSumSamtGroupByBranchIdBizMonth",method=RequestMethod.GET)
	public Map<String,Object> listSumSamtGroupByBranchIdBizMonth( @RequestParam Map<String,Object> xmTaskSbillDetail){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		String bizYear= (String) xmTaskSbillDetail.get("bizYear");
		if(!StringUtils.hasText(bizYear)){
			return ResponseHelper.failed("bizYear-0","年份不能为空");
		}
		User user=LoginUtils.getCurrentUserInfo();
		xmTaskSbillDetail.put("branchId",user.getBranchId());
		List<Map<String,Object>>	xmTaskSbillDetailList = xmTaskSbillDetailService.listSumSamtGroupByBranchIdBizMonth(xmTaskSbillDetail);	//列出XmTaskSbillDetail列表

		m.put("data",xmTaskSbillDetailList);

		m.put("tips", tips);
		return m;
	}
	/**
	@ApiOperation( value = "新增一条工时登记表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskSbillDetail.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmTaskSbillDetail(@RequestBody XmTaskSbillDetail xmTaskSbillDetail) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
		    boolean createPk=false;
			if(!StringUtils.hasText(xmTaskSbillDetail.getId())) {
			    createPk=true;
				xmTaskSbillDetail.setId(xmTaskSbillDetailService.createKey("id"));
			}
			if(createPk==false){
                 if(xmTaskSbillDetailService.selectOneObject(xmTaskSbillDetail) !=null ){
                    return failed("pk-exists","编号重复，请修改编号再提交");
                }
            }
			xmTaskSbillDetailService.insert(xmTaskSbillDetail);
			m.put("data",xmTaskSbillDetail);
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

	@ApiOperation( value = "删除一条工时登记表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmTaskSbillDetail(@RequestBody XmTaskSbillDetail xmTaskSbillDetail){
		 return batchDelXmTaskSbillDetail(Arrays.asList(xmTaskSbillDetail));
	}
	
	/**
	@ApiOperation( value = "根据主键修改一条工时登记表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskSbillDetail.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmTaskSbillDetail(@RequestBody XmTaskSbillDetail xmTaskSbillDetail) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmTaskSbillDetail.getId())) {
                 return failed("pk-not-exists","请上送主键参数id");
            }
            XmTaskSbillDetail xmTaskSbillDetailDb = xmTaskSbillDetailService.selectOneObject(xmTaskSbillDetail);
            if( xmTaskSbillDetailDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			xmTaskSbillDetailService.updateSomeFieldByPk(xmTaskSbillDetail);
			m.put("data",xmTaskSbillDetail);
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

    @ApiOperation( value = "批量修改某些字段",notes="")
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskSbillDetail.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields(@RequestBody Map<String,Object> xmTaskSbillDetailMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            List<String> ids= (List<String>) xmTaskSbillDetailMap.get("ids");
			if(ids==null || ids.size()==0){
				return failed("ids-0","ids不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("id");
            fields.add("samt");
            fields.add("quoteAt");
            fields.add("tactAt");
            fields.add("userid");
            fields.add("taskId");
            fields.add("projectId");
			for (String fieldName : xmTaskSbillDetailMap.keySet()) {
				if(fields.contains(fieldName)){
					return failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmTaskSbillDetailMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmTaskSbillDetailMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return failed("fieldKey-0","没有需要更新的字段");
 			}
			XmTaskSbillDetail xmTaskSbillDetail = fromMap(xmTaskSbillDetailMap,XmTaskSbillDetail.class);
			List<XmTaskSbillDetail> xmTaskSbillDetailsDb=xmTaskSbillDetailService.selectListByIds(ids);
			if(xmTaskSbillDetailsDb==null ||xmTaskSbillDetailsDb.size()==0){
				return failed("data-0","记录已不存在");
			}
			if(fieldKey.contains("othFee")){
				if(xmTaskSbillDetailsDb.size()>1){
					return failed("data-not-1","其他费用的修改只能一次修改一条记录，不能批量修改");
				}else{
					XmTaskSbillDetail detail=xmTaskSbillDetailsDb.get(0);
					this.xmTaskSbillDetailService.preCalcSamt(detail);
					this.xmTaskSbillDetailService.updateSomeFieldByPk(detail);
					this.xmTaskSbillService.updateBySbillDetailList(Arrays.asList(detail.getSbillId()));
					return ResponseHelper.ok("成功");
				}
			}
			List<XmTaskSbillDetail> can=new ArrayList<>();
			List<XmTaskSbillDetail> no=new ArrayList<>();
			User user = LoginUtils.getCurrentUserInfo();
			for (XmTaskSbillDetail xmTaskSbillDetailDb : xmTaskSbillDetailsDb) {
				Tips tips2 = new Tips("检查通过"); 
				if(!tips2.isOk()){
				    no.add(xmTaskSbillDetailDb); 
				}else{
					can.add(xmTaskSbillDetailDb);
				}
			}
			if(can.size()>0){
                xmTaskSbillDetailMap.put("ids",can.stream().map(i->i.getId()).collect(Collectors.toList()));
			    xmTaskSbillDetailService.doEditSomeFields(xmTaskSbillDetailMap,can.stream().map(i->i.getSbillId()).collect(Collectors.toSet()).stream().collect(Collectors.toList()));
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

	@ApiOperation( value = "根据主键列表批量删除工时登记表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmTaskSbillDetail(@RequestBody List<XmTaskSbillDetail> xmTaskSbillDetails) {
		Map<String,Object> m = new HashMap<>();
        Tips tips=new Tips("成功删除"); 
        try{
        	User user=LoginUtils.getCurrentUserInfo();
            if(xmTaskSbillDetails.size()<=0){
                return failed("data-0","请上送待删除数据列表");
            }
             List<XmTaskSbillDetail> datasDb=xmTaskSbillDetailService.selectListByIds(xmTaskSbillDetails.stream().map(i-> i.getId() ).collect(Collectors.toList()));
			String sbillId=datasDb.get(0).getSbillId();
			if(datasDb.stream().filter(i->!sbillId.equals(i.getSbillId())).findAny().isPresent()){
				return failed("sbillId-0","只能删除同一个结算单的清单");
			}
			XmTaskSbill xmTaskSbill=xmTaskSbillService.selectOneById(sbillId);
			if(!user.getUserid().equals(xmTaskSbill.getCuserid())){
				return failed("sbillId-0","该结算单不是您创建的，您不能删除其清单");
			}
			if(!"0".equals(xmTaskSbill.getStatus())){
				return failed("status-not-0","结算单已提交，不允许更改");
			}
            List<XmTaskSbillDetail> can=new ArrayList<>();
            List<XmTaskSbillDetail> no=new ArrayList<>();
            for (XmTaskSbillDetail data : datasDb) {
                if(true){
                    can.add(data);
                }else{
                    no.add(data);
                } 
            }
            List<String> msgs=new ArrayList<>();
            if(can.size()>0){
                xmTaskSbillDetailService.batchDoDelete(can);
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
}
