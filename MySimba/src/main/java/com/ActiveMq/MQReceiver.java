package com.ActiveMq;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class MQReceiver {
	@Resource(name="jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	public void receiver(String key){
		
		if(jmsTemplate==null){
			System.out.println("........................null");
			ClassPathXmlApplicationContext app= new ClassPathXmlApplicationContext("classpath:springMQ.xml");
			jmsTemplate = (JmsTemplate) app.getBean("jmsTemplate");
		}
		 Map<String, Object> map =  (Map<String, Object>)jmsTemplate.receiveAndConvert();
	
		 System.out.println(map.get(key));
	}
}
