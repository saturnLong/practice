package com.ltx.rabbit;

import com.ltx.rabbit.producer.MessageProducer;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能概要：
 * 
 * @author linbingwen
 * @since  2016年1月15日 
 */
public class MessageTest {
	
	private Logger logger = LoggerFactory.getLogger(MessageTest.class);
	
	private ApplicationContext context = null;
	
	@Before
	public void setUp() throws Exception {
	    context = new ClassPathXmlApplicationContext("application.xml");
	}

	@Test
	public void shouldSendAAmqMessage() throws Exception {
       MessageProducer messageProducer = (MessageProducer) context.getBean("messageProducer");
       int a = 1;
       while (true) {
		   Map<String,String> q = new HashMap<String,String>();
		   q.put("key","key"+((a%2==0)?1:2));
		   q.put("msg",a+"");
    	   messageProducer.sendMessage(q);
		   a++;
    	   try {
    		   //暂停一下，好让消息消费者去取消息打印出来
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace(); 
           }
    
	   }
	}
}
