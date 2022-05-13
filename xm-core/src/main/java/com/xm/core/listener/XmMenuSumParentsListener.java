package com.xm.core.listener;

import com.mdp.mq.queue.MessageListener;
import com.xm.core.entity.XmMenu;
import com.xm.core.entity.XmMenu;
import com.xm.core.queue.XmMenuSumParentsPushService;
import com.xm.core.queue.XmMenuSumParentsPushService;
import com.xm.core.service.XmMenuStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class XmMenuSumParentsListener extends MessageListener<XmMenu> {

        Map<String,Map<String,XmMenu>> menusAllMap =new HashMap<>();


    @Autowired
    XmMenuStateService xmMenuStateService;


    @Override
    public Object getQueueKey() {
        return XmMenuSumParentsPushService.queueName;
    }

    @Override
    public void handleMessage(XmMenu message) {
        synchronized (menusAllMap){
            Map<String,XmMenu> my=menusAllMap.get(message.getProductId());
            if(my==null){
                my=new HashMap<>();
                menusAllMap.put(message.getProductId(),my);
            }
            my.put(message.getMenuId(),message);
        }
    }

    /**
     * 每隔一段时间更新一次数据库
     */
    @Scheduled(cron = "* 0/30 * * * ?")
    public void autoUpdateToDb(){
        Map<String,Map<String, XmMenu>> myMenusAllMap=new HashMap<>();
        synchronized (this.menusAllMap){
            myMenusAllMap.putAll(this.menusAllMap);
        }
        if(myMenusAllMap.size()>0){

            List<XmMenu> menus=new ArrayList<>();
            List<XmMenu> errors=new ArrayList<>();
            myMenusAllMap.forEach((projectId,menusMap)->{
                menus.addAll(menusMap.values());
                if(menus.size()>100){
                    try {
                        xmMenuStateService.batchSumParents(menus);
                        menus.clear();
                    }catch (Exception e){
                        errors.addAll(menus);
                        menus.clear();
                    }
                }
            });
            if(menus.size()>0){
                try {
                    xmMenuStateService.batchSumParents(menus);
                    menus.clear();
                }catch (Exception e){

                }
            }
            if(errors.size()>0){
                try {
                    xmMenuStateService.batchSumParents(errors);
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
