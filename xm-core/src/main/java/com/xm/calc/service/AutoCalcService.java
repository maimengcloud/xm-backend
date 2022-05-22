package com.xm.calc.service;

import com.xm.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class AutoCalcService{

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    XmRecordService xmRecordService;

    @Autowired
    XmProjectStateService xmProjectStateService;


    @Autowired
    XmProductStateService xmProductStateService;

    @Autowired
    XmMenuStateService xmMenuStateService;

    @Autowired
    XmIterationStateService xmIterationStateService;

    @Autowired
    XmBranchStateService xmBranchStateService;

    @Autowired
    XmGroupStateService xmGroupStateService;

    @Scheduled(cron = "* * 0 * * ?")
    public void load_tasks_to_xm_project_state(){
        List<String> projectIds=xmRecordService.selectChangeProjectIds();
        if(projectIds!=null && projectIds.size()>0){
            for (String projectId : projectIds) {
                boolean notExists=redisTemplate.opsForValue().setIfAbsent("load_tasks_to_xm_project_state-"+projectId,"1",12L, TimeUnit.HOURS);
                if(notExists){
                    xmProjectStateService.loadTasksToXmProjectState(projectId);
                    xmGroupStateService.loadTasksToXmProjectGroupState(projectId);
                }

            }
        }

    }

    @Scheduled(cron = "* * 0 * * ?")
    public void load_tasks_to_xm_product_state(){
        List<String> productIds=xmRecordService.selectChangeProductIds();
        if(productIds!=null && productIds.size()>0){
            for (String productId : productIds) {
                boolean notExists=redisTemplate.opsForValue().setIfAbsent("load_tasks_to_xm_product_state-"+productId,"1",12L, TimeUnit.HOURS);
                if(notExists){
                    xmMenuStateService.loadTasksToXmMenuState(productId);
                    xmProductStateService.loadTasksToXmProductState(productId);
                }

            }
        }
    }

    @Scheduled(cron = "* * 3 * * ?")
    public void load_tasks_to_xm_iteration_state(){
        List<String> iterationIds=xmRecordService.selectChangeIterationIds();
        if(iterationIds!=null && iterationIds.size()>0){
            for (String iterationId : iterationIds) {
                boolean notExists=redisTemplate.opsForValue().setIfAbsent("load_tasks_to_xm_iteration_state-"+iterationId,"1",12L, TimeUnit.HOURS);
                if(notExists){
                    xmIterationStateService.loadTasksToXmIterationState(iterationId);
                }

            }
        }
    }

    @Scheduled(cron = "* * 4 * * ?")
    public void load_project_state_to_xm_branch_state(){
        List<String> branchIds=xmRecordService.selectChangeBranchIds();
        if(branchIds!=null && branchIds.size()>0){
            for (String branchId : branchIds) {
                boolean notExists=redisTemplate.opsForValue().setIfAbsent("load_project_state_to_xm_branch_state-"+branchId,"1",12L, TimeUnit.HOURS);
                if(notExists){
                    xmBranchStateService.loadProjectStateToXmBranchState(branchId);
                }
            }
        }
    }
}
