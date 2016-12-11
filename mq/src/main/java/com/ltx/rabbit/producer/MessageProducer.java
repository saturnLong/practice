package com.ltx.rabbit.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 功能概要：消息产生,提交到队列中去
 * 
 * @author linbingwen
 * @since  2016年1月15日 
 */
@Service
public class MessageProducer {
	
	private Logger logger = LoggerFactory.getLogger(MessageProducer.class);

	@Resource
	private AmqpTemplate amqpTemplate;

	public void sendMessage(Object message){
	  logger.info("to send message:{}",message);
		Map<String,String> m = (Map<String, String>) message;
	  amqpTemplate.convertAndSend(m.get("key"),m.get("msg"));
	}
}
