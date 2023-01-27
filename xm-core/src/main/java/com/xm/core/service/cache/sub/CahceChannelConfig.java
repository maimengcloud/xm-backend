package com.xm.core.service.cache.sub;

import com.mdp.mq.sp.ChannelConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;

@Configuration 
public class CahceChannelConfig implements ChannelConfig {
	
	RedisMessageListenerContainer container;
	
	@Autowired
	CacheMessageListener messageListener;

	@Override
	public RedisMessageListenerContainer container(RedisMessageListenerContainer container) { 
		// TODO Auto-generated method stub
		this.container=container;

		container.addMessageListener(messageListener, topic("XM_PRODUCT_CACHE"));
		container.addMessageListener(messageListener, topic( "XM_PROJECT_CACHE"));
		container.addMessageListener(messageListener, topic( "XM_GROUP_CACHE"));
		return container;
	}

	public void setMessageListener(MessageListener messageListener,Topic topic){
		container.addMessageListener(messageListener, topic);
	}

	
	Topic topic(String channelName){
		ChannelTopic topic=new ChannelTopic(channelName);
		return topic;
		
	}

	@Override
	public void removeMessageListener(MessageListener messageListener, Topic topic) {
		container.removeMessageListener(messageListener,topic);
		
	}

	@Override
	public void removeMessageListener(MessageListener messageListener) {
		container.removeMessageListener(messageListener);
		
	}

	@Override
	public void removeMessageListener(String listenerName,Topic topic) {

		container.removeMessageListener(messageListener,topic);
	}

	@Override
	public void addMessageListener(String listenerName, Topic topic) {
		container.addMessageListener(messageListener,topic);
	}


}
