package com.xm.core.service;

import com.xm.core.entity.XmTaskWorkload;
import com.xm.core.vo.BatchJoinToSbillVo;
import com.xm.core.vo.UserTaskVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdp.core.service.BaseService;
import static com.mdp.core.utils.BaseUtils.*;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;

import com.xm.core.entity.XmTaskSbillDetail;
import org.springframework.transaction.annotation.Transactional;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTaskSbillDetail 表 xm_task_sbill_detail 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmTaskSbillDetailService")
public class XmTaskSbillDetailService extends BaseService {
	static Logger logger =LoggerFactory.getLogger(XmTaskSbillDetailService.class);

	@Autowired
	XmTaskWorkloadService xmTaskWorkloadService;

    @Autowired
    XmTaskSbillService  xmTaskSbillService;

    public List<XmTaskSbillDetail> selectListByUserTasks(BatchJoinToSbillVo batchJoinToSbillVo) {
        return super.selectList("selectListByUserTasks",batchJoinToSbillVo);
    }

    @Transactional
    public void batchDoDelete(List<XmTaskSbillDetail> xmTaskSbillDetails) {
        String sbillId=xmTaskSbillDetails.get(0).getSbillId();
        super.batchDelete(xmTaskSbillDetails);
        //更新工时表数据状态
        xmTaskWorkloadService.updateStatusAfterDetailDel(xmTaskSbillDetails.stream().map(i->i.getId()).collect(Collectors.toList()));

        //更新结算单数据
        xmTaskSbillService.updateByWorkloadList(Arrays.asList(sbillId));
    }
}

