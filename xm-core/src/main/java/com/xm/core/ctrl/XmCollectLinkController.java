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

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mdp.core.entity.Result;
import com.mdp.core.query.QueryTools;
import static com.mdp.core.utils.BaseUtils.*;
import com.mdp.core.entity.Tips;
import com.mdp.core.entity.LangTips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.RequestUtils;
import com.mdp.core.utils.NumberUtil;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.mdp.swagger.ApiEntityParams;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

import com.xm.core.service.XmCollectLinkService;
import com.xm.core.entity.XmCollectLink;
/**
 * @author maimeng-mdp code-gen
 * @since 2023-10-3
 */
@RestController
@RequestMapping(value="/xm/core/xmCollectLink")
@Api(tags={"xm_collect_link-操作接口"})
public class XmCollectLinkController {
	
	static Logger logger =LoggerFactory.getLogger(XmCollectLinkController.class);
	
	@Autowired
	private XmCollectLinkService xmCollectLinkService;

	@ApiOperation( value = "xm_collect_link-查询列表",notes=" ")
	@ApiEntityParams(XmCollectLink.class)
	@ApiResponses({
		@ApiResponse(code = 200,response=XmCollectLink.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Result listXmCollectLink(@ApiIgnore @RequestParam Map<String,Object> params){
			User user=LoginUtils.getCurrentUserInfo();
			QueryWrapper<XmCollectLink> qw = QueryTools.initQueryWrapper(XmCollectLink.class , params);
			IPage page=QueryTools.initPage(params);
			List<Map<String,Object>> datas = xmCollectLinkService.selectListMapByWhere(page,qw,params);
			return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());
	}
	

	@ApiOperation( value = "xm_collect_link-新增",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmCollectLink.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result addXmCollectLink(@RequestBody XmCollectLink xmCollectLink) {
		 xmCollectLinkService.save(xmCollectLink);
         return Result.ok("add-ok","添加成功！");
	}

	@ApiOperation( value = "xm_collect_link-删除",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Result delXmCollectLink(@RequestBody XmCollectLink xmCollectLink){
		xmCollectLinkService.removeById(xmCollectLink);
        return Result.ok("del-ok","删除成功！");
	}

	@ApiOperation( value = "xm_collect_link-修改",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmCollectLink.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Result editXmCollectLink(@RequestBody XmCollectLink xmCollectLink) {
		xmCollectLinkService.updateById(xmCollectLink);
        return Result.ok("edit-ok","修改成功！");
	}

    @ApiOperation( value = "xm_collect_link-批量修改某些字段",notes="")
    @ApiEntityParams( value = XmCollectLink.class, props={ }, remark = "xm_collect_link", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmCollectLink.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Result editSomeFields( @ApiIgnore @RequestBody Map<String,Object> params) {
            User user= LoginUtils.getCurrentUserInfo();
            xmCollectLinkService.editSomeFields(params);
            return Result.ok("edit-ok","更新成功");
	}

	@ApiOperation( value = "xm_collect_link-批量删除",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Result batchDelXmCollectLink(@RequestBody List<XmCollectLink> xmCollectLinks) {
	    User user= LoginUtils.getCurrentUserInfo();
        if(xmCollectLinks.size()<=0){
            return Result.error("batchDel-data-err-0","请上送待删除数据列表");
        }
         List<XmCollectLink> datasDb=xmCollectLinkService.listByIds(xmCollectLinks.stream().map(i-> i.getCollectId() ).collect(Collectors.toList()));

        List<XmCollectLink> can=new ArrayList<>();
        List<XmCollectLink> no=new ArrayList<>();
        for (XmCollectLink data : datasDb) {
            if(true){
                can.add(data);
            }else{
                no.add(data);
            }
        }
        List<String> msgs=new ArrayList<>();
        if(can.size()>0){
            xmCollectLinkService.removeByIds(can);
            msgs.add(LangTips.transMsg("del-ok-num","成功删除%s条数据.",can.size()));
        }

        if(no.size()>0){
            msgs.add(LangTips.transMsg("not-allow-del-num","以下%s条数据不能删除:【%s】",no.size(),no.stream().map(i-> i.getCollectId() ).collect(Collectors.joining(","))));
        }
        if(can.size()>0){
             return Result.ok(msgs.stream().collect(Collectors.joining()));
        }else {
            return Result.error(msgs.stream().collect(Collectors.joining()));
        }
	} 

	@ApiOperation( value = "xm_collect_link-根据主键查询一条数据",notes=" ")
     @ApiResponses({
            @ApiResponse(code = 200,response=XmCollectLink.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
    })
    @RequestMapping(value="/queryById",method=RequestMethod.GET)
    public Result queryById(XmCollectLink xmCollectLink) {
        XmCollectLink data = (XmCollectLink) xmCollectLinkService.getById(xmCollectLink);
        return Result.ok().setData(data);
    }

}
