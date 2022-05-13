package com.xm.core.listener;

import com.mdp.core.service.BaseService;
import com.mdp.mq.queue.MessageListener;
import com.xm.core.entity.XmTask;
import com.xm.core.queue.XmTaskSumParentsPushService;
import com.xm.core.service.XmTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Service
public class XmTaskSumParentsListener extends MessageListener<XmTask> {

        Map<String,Map<String,XmTask>> tasksAllMap=new HashMap<>();


    @Autowired
    XmTaskService xmTaskService;


    @Override
    public Object getQueueKey() {
        return XmTaskSumParentsPushService.queueName;
    }

    @Override
    public void handleMessage(XmTask message) {
         synchronized (tasksAllMap){
             Map<String,XmTask> my=tasksAllMap.get(message.getProjectId());
             if(my==null){
                 my=new HashMap<>();
                 tasksAllMap.put(message.getProjectId(),my);
             }
             my.put(message.getId(),message);
         }
    }

    /**
     * 每隔一段时间更新一次数据库
     */
    @Scheduled(cron = "* 0/30 * * * ?")
    public void autoUpdateToDb(){
       Map<String,Map<String,XmTask>> myTasksAllMap=new HashMap<>();
        synchronized (this.tasksAllMap){
            myTasksAllMap.putAll(this.tasksAllMap);
        }
        if(myTasksAllMap.size()>0){

            List<XmTask> tasks=new ArrayList<>();
            List<XmTask> errors=new ArrayList<>();
             myTasksAllMap.forEach((projectId,tasksMap)->{
                 tasks.addAll(tasksMap.values());
                 if(tasks.size()>100){
                     try {
                         xmTaskService.batchSumParents(tasks);
                         tasks.clear();
                     }catch (Exception e){
                         errors.addAll(tasks);
                         tasks.clear();
                     }
                 }
             });
             if(tasks.size()>0){
                 try {
                     xmTaskService.batchSumParents(tasks);
                     tasks.clear();
                 }catch (Exception e){

                 }
             }
            if(errors.size()>0){
                try {
                    xmTaskService.batchSumParents(errors);
                    errors.clear();
                }catch (Exception e){
                    errors.clear();
                }
            }
        }

    }

    @PostConstruct
    public void init(){
        super.popMessage();
    }
}
