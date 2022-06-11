package com.xm.core.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.swagger.ApiEntityParams;
import com.xm.core.entity.XmMyFocus;
import com.xm.core.service.XmMyFocusService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.mdp.core.utils.BaseUtils.map;
import static com.mdp.core.utils.BaseUtils.toMap;
import static com.mdp.core.utils.ResponseHelper.failed;

/**
 * url编制采用rest风格,如对xm_my_focus 我关注的项目或者任务的操作有增删改查,对应的url分别为:<br>
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmMyFocus 表 xm_my_focus 当前主键(包括多主键): userid,biz_id,pbiz_id; 
 ***/
@RestController("xm.core.xmMyFocusController")
@RequestMapping(value="/**/core/xmMyFocus")
@Api(tags={"我关注的项目或者任务操作接口"})
public class XmMyFocusController {
	
	static Logger logger =LoggerFactory.getLogger(XmMyFocusController.class);
	
	@Autowired
	private XmMyFocusService xmMyFocusService;
	 

	Map<String,Object> fieldsMap = toMap(new XmMyFocus());
 
	
	@ApiOperation( value = "查询我关注的项目或者任务信息列表",notes=" ")
	@ApiEntityParams( XmMyFocus.class )
	@ApiImplicitParams({
			@ApiImplicitParam(name="pageSize",value="每页大小，默认20条",required=false),
			@ApiImplicitParam(name="pageNum",value="当前页码,从1开始",required=false),
			@ApiImplicitParam(name="total",value="总记录数,服务器端收到0时，会自动计算总记录数，如果上传>0的不自动计算",required=false),
			@ApiImplicitParam(name="count",value="是否计算总记录条数，如果count=true,则计算计算总条数，如果count=false 则不计算",required=false),
			@ApiImplicitParam(name="orderBy",value="排序列 如性别、学生编号排序 orderBy = sex desc,student desc",required=false),
 	})
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMyFocus.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listXmMyFocus( @ApiIgnore @RequestParam Map<String,Object> xmMyFocus){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("查询成功");
		RequestUtils.transformArray(xmMyFocus, "pkList");
		PageUtils.startPage(xmMyFocus);
		List<Map<String,Object>>	xmMyFocusList = xmMyFocusService.selectListMapByWhere(xmMyFocus);	//列出XmMyFocus列表
		PageUtils.responePage(m, xmMyFocusList);
		m.put("data",xmMyFocusList);

		m.put("tips", tips);
		return m;
	}
	
 

	@ApiOperation( value = "新增一条我关注的项目或者任务信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMyFocus.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addXmMyFocus(@RequestBody XmMyFocus xmMyFocus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("关注成功");
		try{
			User user = LoginUtils.getCurrentUserInfo();
			if(!StringUtils.hasText(xmMyFocus.getBizId())) {
				return failed("bizId","业务编号不能为空");
			}
			if(!StringUtils.hasText(xmMyFocus.getPbizId())) {
				return failed("pbizId","上级编号不能为空");
			}
			if(!StringUtils.hasText(xmMyFocus.getFocusType())) {
				return failed("focusType","关注类型不能为空");
			}
			xmMyFocus.setUserid(user.getUserid());
			xmMyFocus.setUsername(user.getUsername());
			if(xmMyFocusService.selectOneObject(xmMyFocus) !=null ){
				return failed("pk-exists","编号重复，请修改编号再提交");
			}
			xmMyFocusService.focus(xmMyFocus);
			m.put("data",xmMyFocus);
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

	@ApiOperation( value = "删除一条我关注的项目或者任务信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delXmMyFocus(@RequestBody XmMyFocus xmMyFocus){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功取消关注");
		try{
			User user = LoginUtils.getCurrentUserInfo();
            if(!StringUtils.hasText(xmMyFocus.getBizId())) {
                 return failed("pk-not-exists","请上送主键参数bizId");
            }
            if(!StringUtils.hasText(xmMyFocus.getPbizId())) {
                 return failed("pk-not-exists","请上送主键参数pbizId");
            }
			xmMyFocus.setUserid(user.getUserid());
            XmMyFocus xmMyFocusDb = xmMyFocusService.selectOneObject(xmMyFocus);
            if( xmMyFocusDb == null ){
                return failed("data-not-exists","数据不存在，无法删除");
            }
			xmMyFocusService.unfocus(xmMyFocusDb);
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
	@ApiOperation( value = "根据主键修改一条我关注的项目或者任务信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMyFocus.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editXmMyFocus(@RequestBody XmMyFocus xmMyFocus) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
            if(!StringUtils.hasText(xmMyFocus.getUserid())) {
                 return failed("pk-not-exists","请上送主键参数userid");
            }
            if(!StringUtils.hasText(xmMyFocus.getBizId())) {
                 return failed("pk-not-exists","请上送主键参数bizId");
            }
            if(!StringUtils.hasText(xmMyFocus.getPbizId())) {
                 return failed("pk-not-exists","请上送主键参数pbizId");
            }
            XmMyFocus xmMyFocusDb = xmMyFocusService.selectOneObject(xmMyFocus);
            if( xmMyFocusDb == null ){
                return failed("data-not-exists","数据不存在，无法修改");
            }
			xmMyFocusService.updateSomeFieldByPk(xmMyFocus);
			m.put("data",xmMyFocus);
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
    @ApiEntityParams( value = XmMyFocus.class, props={ }, remark = "我关注的项目或者任务", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMyFocus.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Map<String,Object> editSomeFields( @ApiIgnore @RequestBody Map<String,Object> xmMyFocusMap) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			List<Map<String,Object>> pkList= (List<Map<String,Object>>) xmMyFocusMap.get("pkList");
			if(pkList==null || pkList.size()==0){
				return failed("pkList-0","pkList不能为空");
			}

			Set<String> fields=new HashSet<>();
            fields.add("userid");
            fields.add("bizId");
            fields.add("pbizId");
			for (String fieldName : xmMyFocusMap.keySet()) {
				if(fields.contains(fieldName)){
					return failed(fieldName+"-no-edit",fieldName+"不允许修改");
				}
			}
			Set<String> fieldKey=xmMyFocusMap.keySet().stream().filter(i-> fieldsMap.containsKey(i)).collect(Collectors.toSet());
			fieldKey=fieldKey.stream().filter(i->!StringUtils.isEmpty(xmMyFocusMap.get(i) )).collect(Collectors.toSet());

			if(fieldKey.size()<=0) {
				return failed("fieldKey-0","没有需要更新的字段");
 			}
			XmMyFocus xmMyFocus = fromMap(xmMyFocusMap,XmMyFocus.class);
			List<XmMyFocus> xmMyFocussDb=xmMyFocusService.selectListByIds(pkList);
			if(xmMyFocussDb==null ||xmMyFocussDb.size()==0){
				return failed("data-0","记录已不存在");
			}
			List<XmMyFocus> can=new ArrayList<>();
			List<XmMyFocus> no=new ArrayList<>();
			User user = LoginUtils.getCurrentUserInfo();
			for (XmMyFocus xmMyFocusDb : xmMyFocussDb) {
				Tips tips2 = new Tips("检查通过"); 
				if(!tips2.isOk()){
				    no.add(xmMyFocusDb); 
				}else{
					can.add(xmMyFocusDb);
				}
			}
			if(can.size()>0){
                xmMyFocusMap.put("pkList",can.stream().map(i->map( "userid",i.getUserid(),  "bizId",i.getBizId(),  "pbizId",i.getPbizId())).collect(Collectors.toList()));
			    xmMyFocusService.editSomeFields(xmMyFocusMap); 
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

	@ApiOperation( value = "根据主键列表批量删除我关注的项目或者任务信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelXmMyFocus(@RequestBody List<XmMyFocus> xmMyFocuss) {
		Map<String,Object> m = new HashMap<>();
        Tips tips=new Tips("成功删除"); 
        try{ 
            if(xmMyFocuss.size()<=0){
                return failed("data-0","请上送待删除数据列表");
            }
             List<XmMyFocus> datasDb=xmMyFocusService.selectListByIds(xmMyFocuss.stream().map(i->map( "userid",i.getUserid() ,  "bizId",i.getBizId() ,  "pbizId",i.getPbizId() )).collect(Collectors.toList()));

            List<XmMyFocus> can=new ArrayList<>();
            List<XmMyFocus> no=new ArrayList<>();
            for (XmMyFocus data : datasDb) {
                if(true){
                    can.add(data);
                }else{
                    no.add(data);
                } 
            }
            List<String> msgs=new ArrayList<>();
            if(can.size()>0){
                xmMyFocusService.batchDelete(can);
                msgs.add(String.format("成功删除%s条数据.",can.size()));
            }
    
            if(no.size()>0){ 
                msgs.add(String.format("以下%s条数据不能删除.【%s】",no.size(),no.stream().map(i-> i.getUserid() +" "+ i.getBizId() +" "+ i.getPbizId() ).collect(Collectors.joining(","))));
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
