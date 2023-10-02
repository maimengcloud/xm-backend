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

import com.xm.core.service.XmTaskWorkloadService;
import com.xm.core.entity.XmTaskWorkload;
/**
 * @author maimeng-mdp code-gen
 * @since 2023-10-3
 */
@RestController
@RequestMapping(value="/xm/core/xmTaskWorkload")
@Api(tags={"工时登记表-操作接口"})
public class XmTaskWorkloadController {
	
	static Logger logger =LoggerFactory.getLogger(XmTaskWorkloadController.class);
	
	@Autowired
	private XmTaskWorkloadService xmTaskWorkloadService;

	@ApiOperation( value = "工时登记表-查询列表",notes=" ")
	@ApiEntityParams(XmTaskWorkload.class)
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskWorkload.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'错误码'},total:总记录数,data:[数据对象1,数据对象2,...]}")
	})
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Result listXmTaskWorkload(@ApiIgnore @RequestParam Map<String,Object> params){
			User user=LoginUtils.getCurrentUserInfo();
			QueryWrapper<XmTaskWorkload> qw = QueryTools.initQueryWrapper(XmTaskWorkload.class , params);
			IPage page=QueryTools.initPage(params);
			List<Map<String,Object>> datas = xmTaskWorkloadService.selectListMapByWhere(page,qw,params);
			return Result.ok("query-ok","查询成功").setData(datas).setTotal(page.getTotal());
	}
	

	@ApiOperation( value = "工时登记表-新增",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskWorkload.class,message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result addXmTaskWorkload(@RequestBody XmTaskWorkload xmTaskWorkload) {
		 xmTaskWorkloadService.save(xmTaskWorkload);
         return Result.ok("add-ok","添加成功！");
	}

	@ApiOperation( value = "工时登记表-删除",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}}")
	}) 
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Result delXmTaskWorkload(@RequestBody XmTaskWorkload xmTaskWorkload){
		xmTaskWorkloadService.removeById(xmTaskWorkload);
        return Result.ok("del-ok","删除成功！");
	}

	@ApiOperation( value = "工时登记表-修改",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200,response=XmTaskWorkload.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	}) 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Result editXmTaskWorkload(@RequestBody XmTaskWorkload xmTaskWorkload) {
		xmTaskWorkloadService.updateById(xmTaskWorkload);
        return Result.ok("edit-ok","修改成功！");
	}

    @ApiOperation( value = "工时登记表-批量修改某些字段",notes="")
    @ApiEntityParams( value = XmTaskWorkload.class, props={ }, remark = "工时登记表", paramType = "body" )
	@ApiResponses({
			@ApiResponse(code = 200,response=XmTaskWorkload.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
	})
	@RequestMapping(value="/editSomeFields",method=RequestMethod.POST)
	public Result editSomeFields( @ApiIgnore @RequestBody Map<String,Object> params) {
            User user= LoginUtils.getCurrentUserInfo();
            xmTaskWorkloadService.editSomeFields(params);
            return Result.ok("edit-ok","更新成功");
	}

	@ApiOperation( value = "工时登记表-批量删除",notes=" ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'}")
	}) 
	@RequestMapping(value="/batchDel",method=RequestMethod.POST)
	public Result batchDelXmTaskWorkload(@RequestBody List<XmTaskWorkload> xmTaskWorkloads) {
	    User user= LoginUtils.getCurrentUserInfo();
        if(xmTaskWorkloads.size()<=0){
            return Result.error("batchDel-data-err-0","请上送待删除数据列表");
        }
         List<XmTaskWorkload> datasDb=xmTaskWorkloadService.listByIds(xmTaskWorkloads.stream().map(i-> i.getId() ).collect(Collectors.toList()));

        List<XmTaskWorkload> can=new ArrayList<>();
        List<XmTaskWorkload> no=new ArrayList<>();
        for (XmTaskWorkload data : datasDb) {
            if(true){
                can.add(data);
            }else{
                no.add(data);
            }
        }
        List<String> msgs=new ArrayList<>();
        if(can.size()>0){
            xmTaskWorkloadService.removeByIds(can);
            msgs.add(LangTips.transMsg("del-ok-num","成功删除%s条数据.",can.size()));
        }

        if(no.size()>0){
            msgs.add(LangTips.transMsg("not-allow-del-num","以下%s条数据不能删除:【%s】",no.size(),no.stream().map(i-> i.getId() ).collect(Collectors.joining(","))));
        }
        if(can.size()>0){
             return Result.ok(msgs.stream().collect(Collectors.joining()));
        }else {
            return Result.error(msgs.stream().collect(Collectors.joining()));
        }
	} 

	@ApiOperation( value = "工时登记表-根据主键查询一条数据",notes=" ")
     @ApiResponses({
            @ApiResponse(code = 200,response=XmTaskWorkload.class, message = "{tips:{isOk:true/false,msg:'成功/失败原因',tipscode:'失败时错误码'},data:数据对象}")
    })
    @RequestMapping(value="/queryById",method=RequestMethod.GET)
    public Result queryById(XmTaskWorkload xmTaskWorkload) {
        XmTaskWorkload data = (XmTaskWorkload) xmTaskWorkloadService.getById(xmTaskWorkload);
        return Result.ok().setData(data);
    }

}
