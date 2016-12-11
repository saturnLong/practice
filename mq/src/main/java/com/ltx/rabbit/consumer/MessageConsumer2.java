package com.ltx.rabbit.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * 功能概要：消费接收
 * 
 * @author linbingwen
 * @since  2016年1月15日 
 */
public class MessageConsumer2 implements MessageListener {
	
	private Logger logger = LoggerFactory.getLogger(MessageConsumer2.class);

	@Override
	public void onMessage(Message message) {
		logger.info("receive MessageConsumer2 message:{}",message);
	}

}
