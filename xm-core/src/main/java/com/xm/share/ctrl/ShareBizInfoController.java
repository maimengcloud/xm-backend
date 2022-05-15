package com.xm.share.ctrl;

import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.mybatis.PageUtils;
import com.xm.share.entity.ShareBizInfo;
import com.xm.share.service.ShareBizInfoService;
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
 * url编制采用rest风格,如对XM.xm_share_biz_info 分享行为记录表的操作有增删改查,对应的url分别为:<br>
 *  新增: share/shareBizInfo/add <br>
 *  查询: share/shareBizInfo/list<br>
 *  模糊查询: share/shareBizInfo/listKey<br>
 *  修改: share/shareBizInfo/edit <br>
 *  删除: share/shareBizInfo/del<br>
 *  批量删除: share/shareBizInfo/batchDel<br>
 * 组织 com  顶级模块 xm 大模块 share 小模块 <br>
 * 实体 ShareBizInfo 表 XM.xm_share_biz_info 当前主键(包括多主键): share_key; 
 ***/
@RestController("xm.share.shareBizInfoController")
@RequestMapping(value="/**/share/shareBizInfo")
@Api(tags={"分享行为记录表操作接口"})
public class ShareBizInfoController {
	
	static Logger logger =LoggerFactory.getLogger(ShareBizInfoController.class);
	
	@Autowired
	private ShareBizInfoService shareBizInfoService;

	@Autowired
	private ShareReceInfoService shareReceInfoService;
 
	
	@ApiOperation( value = "查询分享行为记录表信息列表",notes=" ") 
	@ApiResponses({
		@ApiResponse(code = 200,response=ShareBizInfo.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String,Object> listShareBizInfo( @ApiIgnore @RequestParam Map<String,Object> shareBizInfo){
		Map<String,Object> m = new HashMap<>(); 
		RequestUtils.transformArray(shareBizInfo, "shareKeys");
		PageUtils.startPage(shareBizInfo);
		List<Map<String,Object>>	shareBizInfoList = shareBizInfoService.selectListMapByWhere(shareBizInfo);	//列出ShareBizInfo列表
		PageUtils.responePage(m, shareBizInfoList);
		m.put("data",shareBizInfoList);
		Tips tips=new Tips("查询成功");
		m.put("tips", tips);
		return m;
	}
	
 
	
	/***/
	@ApiOperation( value = "新增一条分享行为记录表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=ShareBizInfo.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> addShareBizInfo(@RequestBody ShareBizInfo shareBizInfo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功新增一条数据");
		try{
			shareBizInfo.setShareKey(shareBizInfoService.createKey("shareKey"));
			//todo 检查是否已经分享过 通过biz_pk_id+share_userid进行判断
			ShareBizInfo queryBizInfo=new ShareBizInfo();
			queryBizInfo.setBizPkId(shareBizInfo.getBizPkId());
			queryBizInfo.setBizType(shareBizInfo.getBizType());
			queryBizInfo.setBizSubPkId(shareBizInfo.getBizSubPkId());
			queryBizInfo.setShareUserid(shareBizInfo.getShareUserid());
			List<ShareBizInfo> myShareBizInfos=shareBizInfoService.selectListByWhere(queryBizInfo);
			if(myShareBizInfos!=null && myShareBizInfos.size()>0){
				tips.setOkMsg("分享成功");
				m.put("tips", tips);
				m.put("data",myShareBizInfos.get(0));
				return m;
			}
			//todo 检查我是否接受的别人的分享的第二次分享 通过biz_pk_id+share_userid判断
			ShareBizInfo queryBizInfo2=new ShareBizInfo();
			queryBizInfo2.setBizPkId(shareBizInfo.getBizPkId());
			queryBizInfo2.setBizType(shareBizInfo.getBizType());
			queryBizInfo2.setBizSubPkId(shareBizInfo.getBizSubPkId());
			queryBizInfo2.setShareUserid(shareBizInfo.getShareUserid());
			List<ShareBizInfo> myParentShareBizInfos=shareBizInfoService.selectList("selectMyParentShareBizInfo",queryBizInfo2);
			if(myParentShareBizInfos!=null && myParentShareBizInfos.size()>0){
				 ShareBizInfo myParentShareBizInfoDb=myParentShareBizInfos.get(0);
				shareBizInfo.setPshareKey(myParentShareBizInfoDb.getShareKey());
				shareBizInfo.setPshareUserid(myParentShareBizInfoDb.getShareUserid());
				shareBizInfo.setPshareUsername(myParentShareBizInfoDb.getShareUsername());
			}
			shareBizInfoService.insert(shareBizInfo);
			m.put("data",shareBizInfo);
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
	@ApiOperation( value = "删除一条分享行为记录表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Map<String,Object> delShareBizInfo(@RequestBody ShareBizInfo shareBizInfo){
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除一条数据");
		try{
			shareBizInfoService.deleteByPk(shareBizInfo);
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
	@ApiOperation( value = "根据主键修改一条分享行为记录表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=ShareBizInfo.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,Object> editShareBizInfo(@RequestBody ShareBizInfo shareBizInfo) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功更新一条数据");
		try{
			shareBizInfoService.updateByPk(shareBizInfo);
			m.put("data",shareBizInfo);
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
	@ApiOperation( value = "根据主键列表批量删除分享行为记录表信息",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Map<String,Object> batchDelShareBizInfo(@RequestBody List<ShareBizInfo> shareBizInfos) {
		Map<String,Object> m = new HashMap<>();
		Tips tips=new Tips("成功删除"+shareBizInfos.size()+"条数据"); 
		try{ 
			shareBizInfoService.batchDelete(shareBizInfos);
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
