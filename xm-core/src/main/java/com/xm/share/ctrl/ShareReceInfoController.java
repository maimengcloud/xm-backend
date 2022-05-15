package com.xm.share.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.share.entity.ShareReceInfo;
import com.xm.share.service.ShareReceInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * url编制采用rest风格,如对XM.xm_share_rece_info 分享后接收人行为记录表的操作有增删改查,对应的url分别为:<br>
 *  新增: share/shareReceInfo/add <br>
 *  查询: share/shareReceInfo/list<br>
 *  模糊查询: share/shareReceInfo/listKey<br>
 *  修改: share/shareReceInfo/edit <br>
 *  删除: share/shareReceInfo/del<br>
 *  批量删除: share/shareReceInfo/batchDel<br>
 * 组织 com  顶级模块 xm 大模块 share 小模块 <br>
 * 实体 ShareReceInfo 表 XM.xm_share_rece_info 当前主键(包括多主键): id; 
 ***/
@RestController("xm.share.shareReceInfoController")
@RequestMapping(value="/**/share/shareReceInfo")
@Api(tags={"分享后接收人行为记录表操作接口"})
public class ShareReceInfoController {
	
	static Logger logger =LoggerFactory.getLogger(ShareReceInfoController.class);
	
	@Autowired
	private ShareReceInfoService shareReceInfoService;
	 
		
 
	
	@ApiOperation( value = "查询分享后接收人行为记录表信息列表",notes=" ") 
	@ApiResponses({
		@ApiResponse(code = 200,response=ShareReceInfo.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listShareReceInfo( @ApiIgnore @RequestParam Map<String,Object> shareReceInfo){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(shareReceInfo, "ids");
		PageUtils.startPage(shareReceInfo);
		List<Map<String,Object>>	shareReceInfoList = shareReceInfoService.selectListMapByWhere(shareReceInfo);	//列出ShareReceInfo列表
		PageUtils.responePage(m, shareReceInfoList);
		m.put("data",shareReceInfoList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	/**
	 */
	@ApiOperation( value = "新增一条分享后接收人行为记录表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=ShareReceInfo.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addShareReceInfo(@RequestBody ShareReceInfo shareReceInfo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			shareReceInfo.setId(shareReceInfoService.createKey("id"));
			ShareReceInfo query=new ShareReceInfo();
			query.setShareKey(shareReceInfo.getShareKey());
			query.setReceiverId(shareReceInfo.getReceiverId());
			List<ShareReceInfo> myShareReceInfos=this.shareReceInfoService.selectListByWhere(query);
			if(myShareReceInfos!=null && myShareReceInfos.size()>0){
				tips.setOkMsg("成功");
				m.put("tips", tips);
			}
			shareReceInfoService.insert(shareReceInfo);
			m.put("data",shareReceInfo);
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
	@ApiOperation( value = "删除一条分享后接收人行为记录表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delShareReceInfo(@RequestBody ShareReceInfo shareReceInfo){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			shareReceInfoService.deleteByPk(shareReceInfo);
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
	@ApiOperation( value = "根据主键修改一条分享后接收人行为记录表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=ShareReceInfo.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editShareReceInfo(@RequestBody ShareReceInfo shareReceInfo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			shareReceInfoService.updateByPk(shareReceInfo);
			m.put("data",shareReceInfo);
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
	@ApiOperation( value = "根据主键列表批量删除分享后接收人行为记录表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelShareReceInfo(@RequestBody List<ShareReceInfo> shareReceInfos) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+shareReceInfos.size()+"条数据"); 
		try{ 
			shareReceInfoService.batchDelete(shareReceInfos);
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
