package com.xm.core.queue;

import com.mdp.mq.queue.MessageListener;
import com.mdp.mq.queue.Push;
import com.xm.core.entity.XmTask;
import com.xm.core.service.XmTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class XmTaskSumParentsPushService {

    @Autowired
    Push push;

    public static String queueName="xm-task-sum-parents";

    public void pushXmTask(XmTask xmTask){
        if(xmTask==null || StringUtils.hasText(xmTask.getId())){
            return;
        }
        push.leftPush(queueName,xmTask);
    }

    public void pushXmTasks(List<XmTask> xmTasks){
        if(xmTasks==null ||xmTasks.size()==0){
            return;
        }
        for (XmTask xmTask : xmTasks) {
            push.leftPush(queueName,xmTask);
        }

    }
}
