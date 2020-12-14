package com.qqkj.xm.push.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.qqkj.mdp.core.entity.Tips;

@Service
public class PushMsgService {
	
	@Autowired
	CallBizService callBizServie;
	
	 private static ExecutorService pool;
	 
	 @PostConstruct
	public void initPool(){
		//maximumPoolSize设置为2 ，拒绝策略为AbortPolic策略，直接抛出异常
	        pool = new ThreadPoolExecutor(10, 20, 1000, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy() );
	        
	 }
	
	
	public void pushPrichatMsgToIm(String branchId,String sendUserid,String sendUsername,String toUserid,String toUsername,String msg) {
		Map<String,Object> map=new HashMap<>();
		map.put("toUserid", toUserid); 
		map.put("toUsername", toUsername); 
		map.put("sendUserid", sendUserid); 
		map.put("sendUsername", sendUsername); 
		
		map.put("sendContent", msg);
		map.put("store", "1");
		pool.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					Tips tips=callBizServie.callApi("/im/im/push/publishPrichatMessage", map);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}); 
		
	}
	
	public void pushMsgToIm(Map<String,Object> message) {
 		 
		message.put("store", "1");
		//Tips tips=callBizServie.callApi("/im/im/push/publishMessage", message);

		pool.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					Tips tips=callBizServie.callApi("/im/im/push/publishMessage", message);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}); 
		
	} 

	public void pushGroupMsg(String branchId,String groupId,String sendUserid,String sendUsername,String msg) {
		Map<String,Object> message=new HashMap<>();
 		message.put("groupId", groupId); 
		message.put("action", "newMessage"); 
		message.put("msgType", "group"); 
		message.put("branchId", branchId); 
		message.put("sendUserid", sendUserid);
 		message.put("sendUsername", sendUsername); 
 		message.put("sendContent", msg);  
 		message.put("store", "1"); 
 		this.pushMsgToIm(message);
	}
	public void pushLeaveChannelGroupMsg(String branchId,String groupId,List<Map<String,Object>> users) {
		Map<String,Object> map=new HashMap<>();
		map.put("groupId", groupId); 
		map.put("action", "leaveChannelGroup");   
		map.put("msgType", "group");  
		map.put("users",users); 
		map.put("branchId", branchId);  
		map.put("store", "1"); 
		this.pushMsgToIm(map);
	}
	public void pushJoinChannelGroupMsg(String branchId,String groupId,List<Map<String,Object>> users) {
		Map<String,Object> map=new HashMap<>();
		map.put("groupId", groupId); 
		map.put("action", "joinChannelGroup");   
		map.put("msgType", "group");  
		map.put("users",users);  
		map.put("store", "1"); 
		map.put("branchId", branchId); 
		this.pushMsgToIm(map);
	}
	public void pushChannelGroupRemoveMsg(String branchId,String groupId) {
		Map<String,Object> map=new HashMap<>();
		map.put("groupId", groupId); 
		map.put("action", "channelGroupRemove");  
		map.put("msgType", "group"); 
		map.put("branchId", branchId);  
		map.put("store", "1"); 
		this.pushMsgToIm(map);
	}
	public void pushChannelGroupCreateMsg(String branchId,String bizPid,String bizId,String groupId,String groupName,String cuserid,String cusername,List<Map<String,Object>> users,String msg) {
		Map<String,Object> map=new HashMap<>();
		map.put("groupId", groupId);
		map.put("groupName", groupName);  
		map.put("categoryId", "common"); 
		map.put("users", users); 
		map.put("cuserid", cuserid);
		map.put("cusername", cusername);  
		map.put("branchId", branchId); 
		map.put("bizPid", bizPid); 
		map.put("bizId", bizId); 
		map.put("action", "channelGroupCreate");  
		map.put("sendContent", msg); 
		map.put("msgType", "group");  
		map.put("store", "1"); 
		this.pushMsgToIm(map);
	}
	public void pushChannelGroupCreateMsg(String branchId,String categoryId,String bizPid,String bizId,String groupId,String groupName,String cuserid,String cusername,List<Map<String,Object>> users,String msg) {
		Map<String,Object> map=new HashMap<>();
		map.put("groupId", groupId);
		map.put("groupName", groupName); 
		map.put("categoryId", categoryId); 

		map.put("users", users); 
		map.put("cuserid", cuserid);
		map.put("cusername", cusername);  
		map.put("branchId", branchId); 
		map.put("bizPid", bizPid); 
		map.put("bizId", bizId); 

		map.put("sendContent", msg); 
		map.put("action", "channelGroupCreate");  
		map.put("msgType", "group");  
		map.put("store", "1"); 
		this.pushMsgToIm(map);
	}


}
