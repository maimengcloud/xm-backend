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

import com.xm.core.service.XmMyFootPrintService;
import com.xm.core.entity.XmMyFootPrint;
/**
 * @author maimeng-mdp code-gen
 * @since 2023-10-3
 */
@RestController
@RequestMapping(value="/xm/core/xmMyFootPrint")
@Api(tags={"我关注的项目或者任务-操作接口"})
public class XmMyFootPrintController {
	
	static Logger logger =LoggerFactory.getLogger(XmMyFootPrintController.class);
	
	@Autowired
	private XmMyFootPrintService xmMyFootPrintService;

	@ApiOperation( value = "我关注的项目或者任务-查询列表",notes=" ")
	@ApiEntityParams(XmMyFootPrint.class)
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMyFootPrint.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Result listXmMyFootPrint(@ApiIgnore @RequestParam Map<String,Object> params){
			User user=LoginUtils.getCurrentUserInfo();
			QueryWrapper<XmMyFootPrint> qw = QueryTools.initQueryWrapper(XmMyFootPrint.class , params);
			IPage page=QueryTools.initPage(params);
			List<Map<String,Object>> datas = xmMyFootPrintService.selectListMapByWhere(page,qw,params);
			return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());
	}
	

	@ApiOperation( value = "我关注的项目或者任务-新增",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMyFootPrint.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result addXmMyFootPrint(@RequestBody XmMyFootPrint xmMyFootPrint) {
		 xmMyFootPrintService.save(xmMyFootPrint);
         return Result.ok("add-ok","添加成功！");
	}

	@ApiOperation( value = "我关注的项目或者任务-删除",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Result delXmMyFootPrint(@RequestBody XmMyFootPrint xmMyFootPrint){
		xmMyFootPrintService.removeById(xmMyFootPrint);
        return Result.ok("del-ok","删除成功！");
	}

	@ApiOperation( value = "我关注的项目或者任务-修改",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmMyFootPrint.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Result editXmMyFootPrint(@RequestBody XmMyFootPrint xmMyFootPrint) {
		xmMyFootPrintService.updateById(xmMyFootPrint);
        return Result.ok("edit-ok","修改成功！");
	}

    @ApiOperation( value = "我关注的项目或者任务-批量修改某些字段",notes="")
    @ApiEntityParams( value = XmMyFootPrint.class, props={ }, remark = "我关注的项目或者任务", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmMyFootPrint.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Result editSomeFields( @ApiIgnore @RequestBody Map<String,Object> params) {
            User user= LoginUtils.getCurrentUserInfo();
            xmMyFootPrintService.editSomeFields(params);
            return Result.ok("edit-ok","更新成功");
	}

	@ApiOperation( value = "我关注的项目或者任务-批量删除",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Result batchDelXmMyFootPrint(@RequestBody List<XmMyFootPrint> xmMyFootPrints) {
	    User user= LoginUtils.getCurrentUserInfo();
        if(xmMyFootPrints.size()<=0){
            return Result.error("batchDel-data-err-0","请上送待删除数据列表");
        }
         List<XmMyFootPrint> datasDb=xmMyFootPrintService.listByIds(xmMyFootPrints.stream().map(i->map( "userid",i.getUserid() ,  "bizId",i.getBizId() ,  "pbizId",i.getPbizId() )).collect(Collectors.toList()));

        List<XmMyFootPrint> can=new ArrayList<>();
        List<XmMyFootPrint> no=new ArrayList<>();
        for (XmMyFootPrint data : datasDb) {
            if(true){
                can.add(data);
            }else{
                no.add(data);
            }
        }
        List<String> msgs=new ArrayList<>();
        if(can.size()>0){
            xmMyFootPrintService.removeByIds(can);
            msgs.add(LangTips.transMsg("del-ok-num","成功删除%s条数据.",can.size()));
        }

        if(no.size()>0){
            msgs.add(LangTips.transMsg("not-allow-del-num","以下%s条数据不能删除:【%s】",no.size(),no.stream().map(i-> i.getUserid() +" "+ i.getBizId() +" "+ i.getPbizId() ).collect(Collectors.joining(","))));
        }
        if(can.size()>0){
             return Result.ok(msgs.stream().collect(Collectors.joining()));
        }else {
            return Result.error(msgs.stream().collect(Collectors.joining()));
        }
	} 

	@ApiOperation( value = "我关注的项目或者任务-根据主键查询一条数据",notes=" ")
     @ApiResponses({
            @ApiResponse(code = 200,response=XmMyFootPrint.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
    })
    @RequestMapping(value="/queryById",method=RequestMethod.GET)
    public Result queryById(XmMyFootPrint xmMyFootPrint) {
        XmMyFootPrint data = (XmMyFootPrint) xmMyFootPrintService.getById(xmMyFootPrint);
        return Result.ok().setData(data);
    }

}
