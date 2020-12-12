package com.qqkj.xm.core.ctrl.push;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qqkj.mdp.core.context.ContextHolder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.qqkj.mdp.mybatis.PageUtils; 
import com.qqkj.mdp.core.utils.RequestUtils;
import com.qqkj.mdp.core.entity.Tips;
import com.qqkj.mdp.core.err.BizException;
import com.qqkj.mdp.core.service.SequenceService;
import com.qqkj.xm.core.service.XmBranchStateService;
import com.qqkj.xm.core.entity.XmBranchState;
import com.qqkj.xm.core.entity.XmBranchState;
/**
 * url编制采用rest风格,如对XM.xm_branch_state 机构内所有项目指标汇总的操作有增删改查,对应的url分别为:<br>
 *  新增: core/xmBranchState/add <br>
 *  查询: core/xmBranchState/list<br>
 *  模糊查询: core/xmBranchState/listKey<br>
 *  修改: core/xmBranchState/edit <br>
 *  删除: core/xmBranchState/del<br>
 *  批量删除: core/xmBranchState/batchDel<br>
 * 组织 com.qqkj  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmBranchState 表 XM.xm_branch_state 当前主键(包括多主键): id; 
 ***/
@RestController("xm.core.push.xmPushController")
@RequestMapping(value="/**/core/push")
@Api(tags={"消息推送接口"})
public class XmPushController {
	
	static Log logger=LogFactory.getLog(XmPushController.class); 
	 
	
		 
}
